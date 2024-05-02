package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class CustomListener implements IAlterSuiteListener {

    @SuppressWarnings("unused")
	
    
  //  public void alter(List<XmlSuite> suites) {
    	
    	
//    	// Get existing included groups
//    
//      //  String includetagname = System.getProperty("includetag");
//    	String includetagname = "signup";
//        System.out.println("Including the tag name: " + includetagname);
//        if (includetagname != null) {
//            String splitvalue[] = includetagname.split(",", 0);
//            for (String myStr : splitvalue) {
//                System.out.println("Adding included group: " + myStr);
//                for (XmlSuite suite : suites) {
//                //	suite.addIncludedGroup("BeforeClass");
//               //     suite.addIncludedGroup(myStr);
//                	
//                    List<String> existingIncludes = suite.getIncludedGroups();        
//                    // Add your new group(s) to existing includes
//                     System.out.println(existingIncludes);       
//                    existingIncludes.add(includetagname);        
//                    // Set included groups with existing and new ones
//                    suite.setIncludedGroups(existingIncludes);
//                }
//            }
//        } else {
//            System.out.println("System property includetag not set.");
//        }
//			}
    	
//    	 @Override
//    	    public void alter(List<XmlSuite> suites) {
//    	        String includetagname = "signup"; // Default value for testing
//    	        
//    	        
//    	        
//    	        System.out.println("Including the tag name: " + includetagname);
//    	        if (includetagname != null) {
//    	            for (XmlSuite suite : suites) {
//    	            	
//    	            	List<XmlClass> classes = suite.getXmlClasses();            
//    	            	classes.add(newXmlClass("com.example.MyTestClass1"));                        
//    	            	suite.setXmlClasses(classes);
//    	            	
//    	                List<String> existingIncludes = suite.getIncludedGroups();
//    	                if (existingIncludes == null) {
//    	                    existingIncludes = new ArrayList<>();
//    	                }
//    	                existingIncludes.add(includetagname);
//    	                suite.setIncludedGroups(existingIncludes);
//    	                System.out.println(existingIncludes);
//    	            }
//    	        } else {
//    	            System.out.println("System property includetag not set.");
//    	        }
//    	    }
    


        @Override
        public void alter(List<XmlSuite> suites) {
            //String includetagname = "signup"; // Default value for testing
            String includetagname = System.getProperty("includetag");
            System.out.println("Including the tag name: " + includetagname);
            if (includetagname != null) {
                for (XmlSuite suite : suites) {
//                    List<XmlTest> tests = suite.getTests();
//                    for (XmlTest test : tests) {
//                        List<XmlClass> classes = test.getClasses();
//                        classes.add(new XmlClass("utils.BasePage")); // Replace with your class name
//                        test.setXmlClasses(classes);
//                       // tests.add(test);
//                   
//                    }
                    //suite.setTests(tests);
                	
                	
                    List<String> existingIncludes = suite.getIncludedGroups();
                    if (existingIncludes == null) {
                        existingIncludes = new ArrayList<>();
                    }
                    existingIncludes.add(includetagname);
                    suite.setIncludedGroups(existingIncludes);
                  
                    System.out.println(existingIncludes);
                    
                    XmlTest myTest = null;
                	for (XmlTest test : suite.getTests()) {
                	    test.getXmlClasses().add(new XmlClass("utils.BasePage"));
                	}
                }
            } else {
                System.out.println("System property includetag not set.");
            }
        }
    }


 
