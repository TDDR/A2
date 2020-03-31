package a2.weka;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class StWV {

	public static void main(String[] args) throws Exception {
		 
	    //load dataset
	    DataSource source = new DataSource("..A2/imdb/Train.arff");
	    Instances dataset = source.getDataSet();
	    
	    //set class index to the last attribute
	    dataset.setClassIndex(dataset.numAttributes()-1);
	  
	    NGramTokenizer gram = new NGramTokenizer(); //(min = 1 token, max = 3 tokens)
	  
	    String options[] = new String[2];
	  
	    //Set Normalized Doc Length
	    options[0] = "-N";
	    options[1] = "2";
		  
	    //Setting up the Filter
	    StringToWordVector filter = new StringToWordVector();
		  
	    filter.setOptions(options);
	    filter.setTokenizer(gram);
	    filter.setInputFormat(dataset);
	    filter.setIDFTransform(true);
		filter.setTFTransform(true);
		filter.setLowerCaseTokens(true);
		filter.setOutputWordCounts(true);
		 
	    //Apply the filter to our data
	    Instances newData = Filter.useFilter(dataset, filter);
	  
		//Save as ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData); //set the data to convert
		
		saver.setFile(new File("../A2/imdb/TrainStWV.arff"));
		saver.writeBatch();
	}
}