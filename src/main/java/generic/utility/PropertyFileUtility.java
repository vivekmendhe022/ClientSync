package generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PROPERTYFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}
	
	
}
