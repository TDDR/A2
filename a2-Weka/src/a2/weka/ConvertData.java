package a2.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class ConvertData {

	public static void main(String[] args) throws Exception {
		
		
		//Load CSV
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:/Users/TIM/Documents/BSD_winter 2020/BTP 400 Software 2 - Java/A2/imdb/Test.csv"));
		
		Instances data = loader.getDataSet(); //get instances object
		
		//Save as ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data); //set the data to convert
		
		saver.setFile(new File("C:/Users/TIM/Documents/BSD_winter 2020/BTP 400 Software 2 - Java/A2/imdb/Test.arff"));
		saver.writeBatch();
	}
}
