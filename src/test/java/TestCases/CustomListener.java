package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class CustomListener implements IAlterSuiteListener {

    @Override
    
    public void alter(List<XmlSuite> suites) {
    	try {
            Model model = readPom();
            if (model != null) {
                String myProperty = model.getProperties().getProperty("my.property");
                System.out.println("My Property Value: " + myProperty);
            } else {
                System.out.println("Failed to read POM file.");
            }
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        
        String includetagname = System.getProperty("includetag");
        System.out.println("Including the tag name: " + includetagname);
        if (includetagname != null) {
            String splitvalue[] = includetagname.split(",", 0);
            for (String myStr : splitvalue) {
                System.out.println("Adding included group: " + myStr);
                for (XmlSuite suite : suites) {
                    suite.addIncludedGroup(myStr);
                }
            }
        } else {
            System.out.println("System property includetag not set.");
        }
			}
 
		
 
	
    
    public Model readPom() throws IOException, XmlPullParserException {
    	MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        File pomFile = new File("pom.xml"); 
        FileInputStream fis = new FileInputStream(pomFile);
        model = reader.read(fis);
        fis.close();
        return model;
    }
    
//    public void onStart(ITestContext context) {
//        // Grouping test methods dynamically based on their priorities
//        context.getSuite().getXmlSuite().addIncludedGroup("signup");
//        context.getSuite().getXmlSuite().addIncludedGroup("login");
//        context.getSuite().getXmlSuite().addIncludedGroup("logout");
//    }

	
  
}
