package a2.weka;

//import required classes
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.stemmers.LovinsStemmer;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class SentimentAnalysis{

  public static void main(String args[]) throws Exception{

  //***Put StWv here***
  
  //the base classifier
  J48 tree = new J48();


  //Create the FilteredClassifier object
  FilteredClassifier fc = new FilteredClassifier();
  //specify filter
  fc.setFilter(filter);
  //specify base classifier
  fc.setClassifier(tree);
  //Build the meta-classifier
  fc.buildClassifier(dataset);

  System.out.println(tree.graph());
  System.out.println(tree);
 }
}