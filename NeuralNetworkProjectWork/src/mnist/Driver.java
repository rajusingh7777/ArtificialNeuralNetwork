package mnist;

import java.io.*;
import java.util.Arrays;

import NeuronTrainSet.TrainSet;
import NeuronsNetwork.Neurons;
import NeuronsNetwork.NetworkTools;

public class Driver {

	// Train set
	public static TrainSet createTrainSet() {
		TrainSet set = new TrainSet(28 * 28, 10);
		BufferedReader inLine = null;
		try {
			String path = new File("").getAbsolutePath();
			inLine = new BufferedReader(new FileReader(path + "/res/train.csv"));
			String inputLine = "";
			int countImagetrained=0;
			while ((inputLine = inLine.readLine()) != null) {
				countImagetrained++;
				
				if(countImagetrained % 100 ==  0){
                    System.out.println("Image trained till: " + countImagetrained);
                }
				int a = Integer.parseInt(inputLine.substring(0, 1));
				inputLine = inputLine.substring(2);

				int[] b = Arrays.stream(inputLine.split(",")).mapToInt(Integer::parseInt).toArray();

				double[] input = new double[28 * 28];
				double[] output = new double[10];

				output[a] = 1d;
				for (int j = 0; j < 28 * 28; j++) {
					input[j] = (double) b[j] / (double) 256;
				}

				set.addData(input, output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

	// Test set
	public static TrainSet createTestSet() {
		TrainSet set = new TrainSet(28 * 28, 10);
		BufferedReader inLine = null;
		try {
			String path = new File("").getAbsolutePath();
			inLine = new BufferedReader(new FileReader(path + "/res/test.csv"));
			String inputLine = "";
			while ((inputLine = inLine.readLine()) != null) {
				int a = Integer.parseInt(inputLine.substring(0, 1));
				inputLine = inputLine.substring(2);

				int[] b = Arrays.stream(inputLine.split(",")).mapToInt(Integer::parseInt).toArray();

				double[] input = new double[28 * 28];
				double[] output = new double[10];

				output[a] = 1d;
				for (int j = 0; j < 28 * 28; j++) {
					input[j] = (double) b[j] / (double) 256;
				}

				set.addData(input, output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

	// Export csv file method
	public static void csv(int e, int a) throws FileNotFoundException {
		try (FileWriter fw = new FileWriter("ExpectedVsActual.csv", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(e + "," + a);

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
		}
	}

	public static void trainData(Neurons net, TrainSet set, int epochs, int loops, int batch_size) {
		for (int e = 0; e < epochs; e++) {
			net.train(set, loops, batch_size);
			System.out.println("******************* " +"Epoch: "+ e + " ********************");
		}
	}
	
	
	// Accuracy 
	public static double testTrainSet(Neurons net, TrainSet set, int printSteps) {
		int correct = 0;
		double calculatedhighest=0.0;
		double highest=0.0;
		for (int i = 0; i < set.size(); i++) {

			 calculatedhighest = NetworkTools.indexOfHighestValue(net.calculate(set.getInput(i)));

			System.out.println("Actual " + calculatedhighest);

			 highest = NetworkTools.indexOfHighestValue(set.getOutput(i));
			System.out.println("Expected " + highest);

			try {
				Driver.csv((int) highest, (int) calculatedhighest);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			if (calculatedhighest == highest) {

				correct++;
			}
		}
		
		System.out.println("\n"+"Testing done and the result is: " + correct + " / " + set.size() + "  -> "
				+ (double) correct / (double) set.size() *100 + " % Accuracy");
		
		return calculatedhighest;
	}

	public static void colorPrint(double a, double b, int i){
		if(a==b){
			System.out.print((int) a+" ");
		}else
			System.err.print((int) a+" ");
		if(i%1000==0)
		System.out.println("\n");
	}
	
	public static void main(String[] args) {

		Neurons neurons = new Neurons(784, 70, 35, 10);

		TrainSet trainSet = createTrainSet();
		trainData(neurons, trainSet, 20, 50, 100);

		TrainSet testSet = createTestSet();
		testTrainSet(neurons, testSet, 10);
	}
	
}
