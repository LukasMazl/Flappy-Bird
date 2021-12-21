package cz.spsmb.flappybird.logic.handler;

import cz.spsmb.flappybird.logic.FlappyBird;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class NeuroneNetworkAi extends AbstractAiHandler {

    private static final int CLASSES_COUNT = 2;
    private static final int FEATURES_COUNT = 10;
    

    private boolean last;
    private int count = 0;

    public NeuroneNetworkAi(FlappyBird flappyBird) {
        super(flappyBird);
    }

    private void initNetwork() {
        MultiLayerConfiguration configuration = new NeuralNetConfiguration.Builder()
                .activation(Activation.TANH)
                .weightInit(WeightInit.XAVIER)
                .updater(new Nesterovs(0.1, 0.9))
                .l2(0.0001)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(FEATURES_COUNT).nOut(3).build())
                .layer(1, new DenseLayer.Builder().nIn(3).nOut(3).build())
                .layer(2, new OutputLayer.Builder(
                        LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD).activation(Activation.SOFTMAX)
                        .nIn(3).nOut(CLASSES_COUNT).build())
                .backprop(true).pretrain(false)
                .build();
    }

    @Override
    protected boolean shouldGoUP() {
        count++;
        if (count % 40 == 0) {
            last = true;
            return true;
        }
        last = false;
        return false;
    }

    @Override
    public void gameOver() {
        System.out.println(last);
    }
}
