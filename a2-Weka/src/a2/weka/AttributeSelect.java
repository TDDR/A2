package a2.weka;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.BestFirst;

public class AttributeSelect {

	public static void main(String[] args) throws Exception {
		 
	    //load dataset
	    DataSource source = 
		 new DataSource("C:/Users/TIM/Documents/BSD_winter 2020/BTP 400 Software 2 - Java/A2/imdb/TestFiltered.arff");
	  
	    Instances dataset = source.getDataSet();
	    //set class index to the last attribute
	    dataset.setClassIndex(0);
	  
	    String options[] = new String[2];
	    
	    options[0] = "-N"; options[1] = "0";
	       
	    AttributeSelection filter = new AttributeSelection();
	     
	    CfsSubsetEval eval = new CfsSubsetEval();
	    BestFirst search = new BestFirst();
	    
	    //search.setOptions(options);
	    
	    filter.setEvaluator(eval);
	    filter.setSearch(search);	    
	    filter.setInputFormat(dataset);

	    //Apply the filter to our data
	    Instances newData = Filter.useFilter(dataset, filter);
	  
		//Save as ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData); //set the data to convert
		
		saver.setFile(new File("C:/Users/TIM/Documents/BSD_winter 2020/BTP 400 Software 2 - Java/A2/imdb/TestAttribute.arff"));
		saver.writeBatch();
  
	}
}

