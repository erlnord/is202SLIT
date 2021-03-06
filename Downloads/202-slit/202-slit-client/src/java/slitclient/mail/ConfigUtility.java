package slitclient.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
 
/**
 * A utility class that reads/saves SMTP settings from/to a properties file.
 * Takk til http://www.codejava.net/coding/swing-application-for-sending-e-mail-with-attachments
 * 
 * Dette er en klasse som leser SMTP-innstillinger fra en property-fil. Den kan også
 * lagre SMTP-innstillinger til en property-fil. Koden er i sin helhet hentet fra linken ovenfor.
 * Jeg har bare modifisert den litt for å få den til å fungere med vårt prosjekt. 
 *
 */
public class ConfigUtility {
    private File configFile = new File("smtp.properties");
    Properties configProps;
     
    public Properties loadProperties() throws IOException {
        Properties defaultProps = new Properties();
        // sets default properties
        defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
        defaultProps.setProperty("mail.smtp.port", "587");
        defaultProps.setProperty("mail.user", "sliterino@gmail.com");
        defaultProps.setProperty("mail.password", "is202sliterino");
        defaultProps.setProperty("mail.smtp.starttls.enable", "true");
        defaultProps.setProperty("mail.smtp.auth", "true");
        defaultProps.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
         
        configProps = new Properties(defaultProps);
         
        // loads properties from file
        if (configFile.exists()) {
            InputStream inputStream = new FileInputStream(configFile);
            configProps.load(inputStream);
            inputStream.close();
        }
         
        return configProps;
    }
     
    public void saveProperties(String host, String port, String user, String pass) throws IOException {
        configProps.setProperty("mail.smtp.host", host);
        configProps.setProperty("mail.smtp.port", port);
        configProps.setProperty("mail.user", user);
        configProps.setProperty("mail.password", pass);
        configProps.setProperty("mail.smtp.starttls.enable", "true");
        configProps.setProperty("mail.smtp.auth", "true");
         
        OutputStream outputStream = new FileOutputStream(configFile);
        configProps.store(outputStream, "host setttings");
        outputStream.close();
    }  
    
    // getter-metode for � f� props
    public Properties getProps() {
        return configProps;
}
}