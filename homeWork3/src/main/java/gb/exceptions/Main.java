package gb.exceptions;

import gb.exceptions.model.Contact;
import gb.exceptions.model.Human;
import gb.exceptions.viewer.ContactValidator;
import gb.exceptions.viewer.StringParser;
import gb.exceptions.viewer.Validator;

public class Main {
    public static void main(String[] args) {

        Human dima = new Contact();
        String[] data = new StringParser().getDataFromString("Ivan Ivanovich Kuznetsoff 01.01.1970 124567890 m");
        for (String el: data) {
            System.out.println(el);
        }
        Validator valid = new ContactValidator();
        System.out.println(valid.validate(data));
    }
}