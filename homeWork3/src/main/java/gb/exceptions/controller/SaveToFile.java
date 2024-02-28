package gb.exceptions.controller;

import gb.exceptions.model.Human;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {


    public void saveToFile(String fileName, Human data) {
        try (FileWriter file = new FileWriter(fileName)){
            file.write(data.toString());

        } catch (IOException e){
            System.out.println(e);
        }

    }
}
