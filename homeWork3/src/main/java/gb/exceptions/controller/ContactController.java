package gb.exceptions.controller;

import gb.exceptions.exceptions.MyExceptions;
import gb.exceptions.exceptions.WrongDataFormat;
import gb.exceptions.exceptions.WrongSizeOfInputData;
import gb.exceptions.model.Contact;
import gb.exceptions.model.Human;
import gb.exceptions.viewer.ContactValidator;
import gb.exceptions.viewer.StringParser;
import gb.exceptions.viewer.Viewer;
import gb.exceptions.viewer.ViewerContact;

public class ContactController {
    public void run(){
        Human contact = new Contact();
        ViewerContact viewerContact = new ViewerContact();
        boolean exit = false;
        while (!exit){
            try {
                contact = new ContactValidator().validate(new StringParser().getDataFromString(viewerContact.getContact()));
            } catch (WrongSizeOfInputData | WrongDataFormat e) {
                System.err.println(e.getMessage());
                System.out.println("Попробуйте позже еще раз...");
                exit = true;
            }
            if (!exit) {
                System.out.println(contact);
                System.out.printf("Записываю данные в файл %s.csv%n", contact.getLastname());
                new SaveToFile().saveToFile(contact.getLastname() + ".csv", contact);
            }
        }
        viewerContact.close();
    }
}
