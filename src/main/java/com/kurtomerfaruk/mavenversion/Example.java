package com.kurtomerfaruk.mavenversion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Omer Faruk Kurt
 * @Created on date 29/09/2018 12:12:52
 */
@ManagedBean
@ApplicationScoped
public class Example {

    private String version;
    private String buildDate;

    public Example() {
        Properties prop = loadManifestFile();
        if (prop != null) {
            version = prop.getProperty("version");
            buildDate = prop.getProperty("build.date");
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    private Properties loadManifestFile() {

        Properties prop = new Properties();
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("version.properties");
            if (resourceAsStream != null) {
                prop.load(resourceAsStream);
            }
        } catch (IOException e) {
        }
        return prop;
    }

}
