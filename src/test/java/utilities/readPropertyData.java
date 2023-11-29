package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertyData {
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("D:\\TestAutomationLearningFramework\\TestAutomationLearning\\src\\test\\resources\\configFile\\config.properties");
		
		Properties p = new Properties();
	
		p.load(fr);
		
		
	}
}
