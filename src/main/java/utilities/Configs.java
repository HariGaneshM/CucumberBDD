package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {
	
	public static Properties props;
	
	public static void readConfigs() {
		
		props = new Properties();
		
        try (FileInputStream file = new FileInputStream("src/main/resources/configs.properties")) {
            props.load(file);
        } catch (IOException e) {
            if (e instanceof java.io.FileNotFoundException) {
                System.err.println("Config file not found");
            } else {
                e.printStackTrace();
            }
        }
	}
	
	public static String getProperty(String key) {
		
		if (props == null) {
			
			readConfigs();
		}
		String propValue = props.getProperty(key);
		
		if (propValue == null) {
			
			System.out.println(key + " property is missing in config file");
        }
		return propValue;
	}
}
