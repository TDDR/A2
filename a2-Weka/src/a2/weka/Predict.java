package a2.weka;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.lazy.IBk;

public class Predict {
	
		public static void main(String[] args) throws Exception {
		 	 
		    //Load training data
		    DataSource source = new DataSource("../A2/imdb/TrainAS.arff");
		    Instances trainingData = source.getDataSet();

		    //Set class index to the last attribute (pos, neg)
		    trainingData.setClassIndex(trainingData.numAttributes()-1);
		  
		    //Build model
		    IBk ibk = new IBk();	    
		    ibk.buildClassifier(trainingData);
		    
		    //Load data to make predictions on
		    DataSource source2 =  new DataSource("../A2/imdb/Test.arff");  
		    Instances testingData = source2.getDataSet();   
		    
		    //Set class index to the last attribute (pos, neg)
		    testingData.setClassIndex(testingData.numAttributes()-1);
		    
		    //Loop through data and make predictions
		    System.out.println("Actual, Predicted");
		    for(int i = 0; i < testingData.numInstances(); i++) {
		    	
		    	//Get double value that represents the class for the current instance
		    	double actualClass = testingData.instance(i).classValue();
		    	
		    	//Convert that double into a String
		    	String actual = testingData.classAttribute().value((int)actualClass);
		    	
		    	Instance currentInstance = testingData.instance(i);
		    	
		    	//Get double that represents the predicted value
		    	double predicted = ibk.classifyInstance(currentInstance);
		    	
		    	//Convert that double into a string
		    	String predictedString = testingData.classAttribute().value((int)predicted);
		    
		    	//Print results
		    	System.out.println(actual + ", " + predictedString);
		    }
		}
	}