package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//import java.util.logging.LogManager;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        
        

        String resourceName = "student.csv";
        String configFile = "config.properties";

        try (
            InputStream configStream = App.class.getClassLoader().getResourceAsStream(configFile);
            BufferedReader cs = new BufferedReader(new InputStreamReader(configStream, StandardCharsets.UTF_8));
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resourceName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
        ) {
            if (inputStream == null) {
                logger.error("Resource '{}' not found in classpath. Ensure it's placed in 'src/main/resources'.", resourceName);
                return;
                
            }
            //System.out.println("DEBUG: Trying to load resource: " + resourceName);


            String line;
            boolean header = true;

            while ((line = cs.readLine()) != null) {
                logger.info("Search is based on this config -> {}", line);

                String[] studentProfile = line.split(",");
                int sage = Integer.parseInt(studentProfile[1]);
                int smarks = Integer.parseInt(studentProfile[2]);
                logger.info("Parsed config: sage={}, smarks={}", sage, smarks);


                while ((line = br.readLine()) != null) {
                    if (header) {
                        header = false;
                        continue;
                    }

                    String[] values = line.split(",");
                    int age = Integer.parseInt(values[2]);
                    int marks = Integer.parseInt(values[3]);

                    if (age >= sage && marks > smarks) {
                        logger.info("Matched Student: ID={}, Name={}, Age={}, Marks={}",
                                values[0], values[1], values[2], values[3]);
                    }
                }
            }

        } catch (IOException e) {
            logger.error("Error reading the file", e);
        }
    }
}
