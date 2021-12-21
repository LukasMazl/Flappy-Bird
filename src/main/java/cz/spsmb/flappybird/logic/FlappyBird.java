package cz.spsmb.flappybird.logic;

import cz.spsmb.flappybird.logic.handler.OnClickHandler;
import cz.spsmb.flappybird.logic.handler.OnGameOver;
import cz.spsmb.flappybird.model.GameState;
import cz.spsmb.flappybird.model.view.ViewHolder;
import cz.spsmb.flappybird.model.view.bird.Bird;
import cz.spsmb.flappybird.model.view.pipe.PipeWrapper;
import cz.spsmb.flappybird.ticker.OnTick;
import cz.spsmb.flappybird.ticker.Ticker;
import cz.spsmb.flappybird.view.SceneManager;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.LinkedList;
import java.util.List;

public class FlappyBird extends Scene {

    public static final double SCENE_WIDTH = 288;
    public static final double SCENE_HEIGHT = 512;
    public static final double PIPE_LINE_MOVEMENT = 10;

    private SceneManager sceneManager;
    private GameState gameState;
    private Ticker ticker;
    private Bird bird;
    private List<PipeWrapper> pipeWrapperList;

    private OnClickHandler onClickHandler;
    private OnGameOver onGameOver;

    public FlappyBird(SceneManager sceneManager) {
        super(sceneManager.getParentScene(), SCENE_WIDTH, SCENE_HEIGHT);
        this.sceneManager = sceneManager;
        this.gameState = GameState.READY;
        this.pipeWrapperList = new LinkedList<>();
        this.bird = new Bird(sceneManager);
    }

    public void start() {
        super.getWindow().setOnCloseRequest((e) -> {
                System.exit(1);
        });
        initHandlers();
        initScene();
        initTicker();
    }

    private double getRandom() {
        return  ((int) (Math.random() *
                    (SCENE_HEIGHT - ViewHolder.getInstance().getBaseGround().getHeight() * 2)
                        + ViewHolder.getInstance().getBaseGround().getHeight() / 2));

    }

    private void initPipe() {
        for (int i = 1; i < 4; i++) {
            PipeWrapper pipeWrapper = new PipeWrapper(sceneManager, SCENE_WIDTH * i, getRandom());
            this.pipeWrapperList.add(pipeWrapper);
        }
    }

    private void initTicker() {
        this.ticker.register(this::onTick);
        this.ticker.start();
    }

    public void addOnTickHandler(OnTick onTick) {
        this.ticker.register(onTick);
    }

    private void onTick() {
        switch (gameState) {
            case READY -> doReady();
            case PLAYING -> doPlaying();
            case GAME_OVER -> doNothing();
        }
    }

    private void doNothing() {

    }

    private void initScene() {
        Platform.runLater(() -> {
            sceneManager.showOnlySceneCollection(
                    ViewHolder.getInstance().getBackgroundDay(),
                    ViewHolder.getInstance().getBaseGround(),
                    ViewHolder.getInstance().getWelcomeMessage()
            );
        });
    }

    private void initHandlers() {
        this.onClickHandler.register(this::doOnClick);
    }

    private void doOnClick() {
        switch (gameState) {
            case READY -> startPlaying();
            case PLAYING -> makeMove();
            case GAME_OVER -> restartGame();
        }
    }

    private void restartGame() {
        gameState = GameState.READY;
        pipeWrapperList.clear();
        bird.restart();
        initScene();
    }

    private void makeMove() {
        bird.goUp();
    }

    private void startPlaying() {
        gameState = GameState.PLAYING;
        Platform.runLater(() -> {
                sceneManager.showOnlySceneCollection(
                        ViewHolder.getInstance().getBackgroundDay(),
                        ViewHolder.getInstance().getBaseGround()
                );
                initPipe();
                bird.draw();
            });
    }

    private void doGameOver() {
        if(onGameOver != null) {
            onGameOver.gameOver();
        }
        Platform.runLater(() -> {
                sceneManager.showOnlySceneCollection(
                        ViewHolder.getInstance().getBackgroundDay(),
                        ViewHolder.getInstance().getBaseGround(),
                        ViewHolder.getInstance().getGameOver());
            });
    }


    private void doPlaying() {
        boolean gameOver = checkGameOver();
        if(gameOver) {
            gameState = GameState.GAME_OVER;
            doGameOver();
        } else {
            Platform.runLater(() -> {
                    checkPipelines();
                    bird.makeMove();
                    for(PipeWrapper pipeWrapper : pipeWrapperList) {
                        pipeWrapper.move(PIPE_LINE_MOVEMENT);
                    }
                }
            );
        }
    }

    private void checkPipelines() {
        if(!pipeWrapperList.isEmpty()) {
            PipeWrapper first = pipeWrapperList.get(0);
            if (first.isOutOfScene()) {
                PipeWrapper pipeWrapper = new PipeWrapper(sceneManager, SCENE_WIDTH * pipeWrapperList.size(), getRandom());
                pipeWrapperList.remove(0);
                this.pipeWrapperList.add(pipeWrapper);
            }
        }
    }

    private boolean checkGameOver() {
        boolean groundIntersect =  bird.isIntersect(ViewHolder.getInstance().getBaseGround().getRectangle2D());
        if(groundIntersect) {
            return true;
        }

        boolean pipeIntersect = false;
        for(PipeWrapper pipeWrapper : pipeWrapperList) {
            pipeIntersect |= pipeWrapper.isIntersect(bird);
        }
        return pipeIntersect;
    }

    private void doReady() {

    }

    // GETTER and SETTER
    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public OnClickHandler getOnClickHandler() {
        return onClickHandler;
    }

    public void setOnClickHandler(OnClickHandler onClickHandler) {
        this.onClickHandler = onClickHandler;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public List<PipeWrapper> getPipeWrapperList() {
        return pipeWrapperList;
    }

    public void setPipeWrapperList(List<PipeWrapper> pipeWrapperList) {
        this.pipeWrapperList = pipeWrapperList;
    }

    public void setOnGameOver(OnGameOver onGameOver) {
        this.onGameOver = onGameOver;
    }
}
