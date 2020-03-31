package a2.weka;

import java.util.Random;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.lazy.IBk;
import weka.classifiers.Evaluation;

public class NN {

	public static void main(String[] args) throws Exception {
	 	 
	    //load training dataset
	    DataSource source = new DataSource("../A2/imdb/TrainAS.arff");
	    Instances dataset = source.getDataSet();
	    
	    //set class index to the last attribute
	    dataset.setClassIndex(dataset.numAttributes()-1);
	  
	    //Build modle
	    IBk ibk = new IBk();	    
	    ibk.buildClassifier(dataset);
	    
	    //build a model to evaluate against using the training dataset
	    Evaluation eval = new Evaluation(dataset);
	    
	    //Load test Data
	    DataSource source2 =  new DataSource("../A2/imdb/TestAS.arff");
	    Instances testDataSet = source2.getDataSet();   
	    testDataSet.setClassIndex(testDataSet.numAttributes()-1);
	    
	    //Evaluate the model
	    //eval.evaluateModel(ibk, testDataSet);
	    
	    //Use Cross Validate instead to better refine results
	    eval.crossValidateModel(ibk, testDataSet, 10, new Random(1));
	    
	    System.out.println(eval.toSummaryString("Results: \n", false)); 
	}
}
