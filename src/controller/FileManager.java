package controller;

import java.io.*;
import java.util.NoSuchElementException;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public abstract class FileManager {
    /**
     * Save an object in a pathFile, if the pathFile doesn't exist, it will be created.
     * @param pathFile The pathFile where save the object.
     * @param object The object to save.
     *
     * @see ObjectOutputStream
     * @see FileOutputStream
     *
     */
    static public void writeToFile(String pathFile, Object object) {
        ObjectOutputStream outStream = null;
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(pathFile);
            outStream = new ObjectOutputStream(fileOutputStream);
            outStream.writeObject(object);
        } catch (IOException ioException) {

        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input.");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing pathFile.");
            }
        }
    }

    /**
     * Load a company from a file.
     * @param filename The pathname where load our company.
     * @return The company which was saved in the file.
     *
     * @see ObjectInputStream
     * @see FileInputStream
     */
    static public Object readFromFile(String filename) {
        Object objectRead = null;
        ObjectInputStream inputStream = null;
        try {
            FileInputStream fileInputStream=new FileInputStream(filename);
            inputStream = new ObjectInputStream(fileInputStream);
            objectRead = inputStream.readObject();
        } catch (EOFException ignored) {

        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Object creation failed.");
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return objectRead;
    }
}
