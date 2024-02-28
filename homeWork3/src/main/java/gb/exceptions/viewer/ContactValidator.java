package gb.exceptions.viewer;

import gb.exceptions.exceptions.WrongSizeOfInputData;
import gb.exceptions.exceptions.WrongDataFormat;
import gb.exceptions.model.Contact;
import gb.exceptions.model.Human;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidator implements Validator{

    private void validateBirthDay(String bd){
        Pattern pattern = Pattern.compile("^(\\d{2}).(\\d{2}).(\\d{4})");
        Matcher matcher = pattern.matcher(bd);
        if (!matcher.find()){ throw new WrongDataFormat("Неправильный формат даты: "+bd);}
        int day = Integer.parseInt(matcher.group());
    }
    @Override
    public Human validate(String[] rawData) {
        Human contact = new Contact();
        if (rawData.length != contact.getDataDimension()){
            contact = null;
            String message = rawData + ":";
            message += (rawData.length < contact.getDataDimension())?"Не достаточно данных":"Слишком много данных";
            throw new WrongSizeOfInputData(message);
        }
        validateBirthDay(rawData[3]);
        return contact;

    }
}
