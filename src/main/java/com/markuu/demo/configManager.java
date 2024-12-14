package com.markuu.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configManager {
    private static final String CONFIG_FILE = "src/main/java/com/markuu/demo/config.properties";
    private static Properties properties;

    public configManager() {
        properties = new Properties();
        loadConfig();
    }

    private void loadConfig() {
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Long getHospId() {
        return Long.parseLong(properties.getProperty("hospId"));
    }

    public void setHospId(Long hospId) {
        properties.setProperty("hospId", hospId.toString());
    }

    public static Long getPatientId() {
        return Long.parseLong(properties.getProperty("patientId"));
    }

    public void setPatientId(Long patientId) {
        properties.setProperty("patientId", patientId.toString());
    }

    public static Long getWardId() {
        return Long.parseLong(properties.getProperty("wardId"));
    }

    public void setWardId(Long wardId) {
        properties.setProperty("wardId", wardId.toString());
    }

    public static Long getChildbId() {
        return Long.parseLong(properties.getProperty("childbId"));
    }

    public void setChildbId(Long childbId) {
        properties.setProperty("childbId", childbId.toString());
    }

    public static Long getChildId() {
        return Long.parseLong(properties.getProperty("childId"));
    }

    public void setChildId(Long childId) {
        properties.setProperty("childId", childId.toString());
    }

    public static Long getEmployeeId() {
        return Long.parseLong(properties.getProperty("employeeId"));
    }

    public void setEmployeeId(Long employeeId) {
        properties.setProperty("employeeId", employeeId.toString());
    }
}