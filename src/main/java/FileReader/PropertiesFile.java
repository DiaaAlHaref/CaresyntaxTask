package FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static String[] propertiesFileReader(String[] data){
        String[] dataFile= new String[data.length];         //Array of String declaration
        Properties property = new Properties();             //Properties file declaration

        try {
            InputStream input=new FileInputStream("src/test/resources/DataDriven/data.properties");
            //properties file path declaration
            property.load(input);  // load inputs in the file key , value
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0; i<data.length; i++){
            dataFile[i]= property.getProperty(data[i]);
            //loop on the values of the file , get the value in datafile[], get key from data[]
        }
        return dataFile;
    }
}
