package gb.exceptions.controller;

import gb.exceptions.model.Human;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {


    public void saveToFile(String fileName, Human data) {
        try (FileWriter file = new FileWriter(fileName, true)){
            file.write(data.toString()+System.lineSeparator());

        } catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
