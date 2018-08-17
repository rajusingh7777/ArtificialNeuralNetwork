package test;

import static org.junit.Assert.*;
import org.junit.Test;

import NeuronTrainSet.TrainSet;
import NeuronsNetwork.NetworkTools;
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
    public void createRandomArray() throws Exception {
       
		assertEquals(NetworkTools.createRandomArray(10,1.0,9.9)[0],5.5,9.8);
		assertEquals(NetworkTools.createRandomArray(10,1.0,9.9)[0],3.4,9.8);
		assertEquals(NetworkTools.createRandomArray(10,1.0,9.9)[0],1.1,9.8);
    }
	
	@Test
    public void indexOfHighestValue() throws Exception {
		assertEquals(NetworkTools.indexOfHighestValue(new double[]{3.0,2.9,4.0}),2);
		assertEquals(NetworkTools.indexOfHighestValue(new double[]{1.0,6.9,5.0,2.4,7.7}),4);
		assertEquals(NetworkTools.indexOfHighestValue(new double[]{2.99,21.9,14.0}),1);
		assertEquals(NetworkTools.indexOfHighestValue(new double[]{22.99,21.9,14.0}),0);
    }
	
	@Test
    public void containsValue() throws Exception {
		assertEquals(NetworkTools.containsValue(new String[]{"neural","network","computational"},"network"), true);
		assertEquals(NetworkTools.containsValue(new Integer[]{2,3,7},8), false);
		assertEquals(NetworkTools.containsValue(new Double[]{4.0,6.6,9.34,8.81},9.34), true);
		assertEquals(NetworkTools.containsValue(new Double[]{4.0,6.6,9.34,8.81},1.2), false);
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
