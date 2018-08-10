Abstract:
In this project we present an Artificial Neural Network(ANN) to recognize human handwritten digits. For the computer an image is just a collection of pixels with different colours. Whatever is actually in the picture is very hard for a computer to identify. Yet, state-of-the-art neural networks are already been able to automatically identify faces or describe the actual content of a photo. The ANN proposed here is experimented on the well-known MNIST data set to identify hand-written digits. 
	
Dataset:
The MNIST problem is a dataset developed for evaluating machine learning models on the handwritten digit classification problem. The dataset was constructed from a number of scanned document dataset available from the National Institute of Standards and Technology (NIST). This is where the name for the dataset comes from, as the Modified NIST or MNIST dataset.
Each image is a 28 x 28 pixel square (784 pixels total). A standard split of the dataset is used to evaluate and compare models, where 60,000 images are used to train a model and a separate set of 10,000 images are used to test it. It is a digit recognition task. As such there are 10 digits (0 to 9) or 10 classes to predict. Results are reported using prediction error, which is nothing more than the inverted classification accuracy. 

Methods:
• Backpropagation

This class implements a backpropagation training algorithm for feed forward neural networks. It works by analysing the error of the output of the neural network.  In our program, we calculate the error in the output nodes by calculating the difference between the expected value and the actual value during the model training. For layers other than the input layers, the weight is adjusted by calculating the sum of the product of error and the weight of the node. This process continues working its way backwards through the layers of the neural network.  The learning rate specifies the degree to which the weight matrixes will be modified through each iteration. 

• Sigmoid Function
We used Sigmoid function as an activation function where the “z” value is a sum of the weights and the bias of each node. Its output is always bound between 0 and 1.

• Neural Structure:
 A multilayer perceptron algorithm consists of several layers of nodes, interconnected through weighted acyclic arcs from each preceding layer to the following, without lateral or feedback connections. Each node calculates a transformed weighted linear combination of its inputs (output activations from the preceding layer), with one of the weights acting as a trainable bias connected to a constant input. 
	In our program, we have a total of 4 layers:
1) Input Layer: The input layer is a 2-D Array and it consists of 28 x 28 nodes. Each node has a set of input weights, which is obtained from the pixel values through the csv file. The error values are not calculated for the input layer since all the rows are linked to a label in the label file.
2) Two Hidden Layers: We have 2 hidden layers in between the input and output layers. First layer has 70 nodes and the second has 35 nodes. 
3) Output Layer: The output layer consists of 10 nodes, one each for the digits from 0-9. Based on the weights from previous nodes, weight of each node is calculated. The index value of the node, which has the highest weight, is the output of the image.

• Neurons:
This class consists of the neurons or nodes in each layer. Initially each neuron consists of a random weight and
a random bias, between -0.5 and 0.7. This class implemented the backpropagation method, MeanSquareError
method and method to calculate the index of out the output of the highest value. 

• Training and test Methods
For training the model we read the data from the CSV files, containing 5000 records using BufferReader to read each record. The first column is parse as label and the rest of the columns is the pixel intensity. We feed a part of the training dataset to train our model. The training occurs using the backpropagation and activation functions. 
	To test the trained model, we utilize the unused 5000 records from the dataset and test the accuracy of the model. The accuracy is calculated by checking the ratio of the actual output by expected output.

