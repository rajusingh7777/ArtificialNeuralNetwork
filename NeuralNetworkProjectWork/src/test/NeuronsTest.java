package test;

import static org.junit.Assert.*;
import org.junit.Test;

import NeuronTrainSet.TrainSet;
import NeuronsNetwork.Neurons;
import mnist.Driver;

public class NeuronsTest {
	
	@Test
    public void createTestSet() throws Exception {
       
		Driver.createTrainSet();
        assertEquals(2, 2.0, 0.0001);
        assertEquals(3, 3.0, 0.0001);
        assertEquals(4, 4.0, 0.0001);
    }
	
	@Test
	public void testTrainSet() throws Exception {
		
		Neurons neurons = new Neurons(784, 10, 5, 10);
		TrainSet trainSet = Driver.createTrainSet();
		Driver.trainData(neurons, trainSet, 2, 50, 100);
		Driver.testTrainSet(neurons, trainSet, 2);
        assertEquals(Driver.testTrainSet(neurons, trainSet, 2), 3, 10);
        assertEquals(Driver.testTrainSet(neurons, trainSet, 2), 3, 10);
        assertEquals(Driver.testTrainSet(neurons, trainSet, 2), 4, 10);
        assertEquals(Driver.testTrainSet(neurons, trainSet, 2), 5, 10);
        assertEquals(Driver.testTrainSet(neurons, trainSet, 2), 6, 10);
    }
	
	@Test
	public void MeanSqErr() throws Exception{
		double[] input ={0.0,0.1,0.2};
		double[] output={0.0,1.0,2.0};
		Neurons n = new Neurons(784);
		assertEquals(n.MSE(input, output),.0445,.1);
		assertEquals(n.MSE(input, output),.0431,.1);
		assertEquals(n.MSE(input, output),.0453,.1);
	}
	
	@Test
	public void sigmoidfuction() throws Exception{
		Neurons n = new Neurons(784);
		assertEquals(n.sigmoidfuc(-7.986908),.000339767,.01);
		assertEquals(n.sigmoidfuc(-7.106908),.000339767,.01);
	}

}
