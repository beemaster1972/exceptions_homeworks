package gb.exceptions.viewer;

import gb.exceptions.exceptions.WrongDataFormat;
import gb.exceptions.exceptions.WrongSizeOfInputData;
import gb.exceptions.model.Contact;
import gb.exceptions.model.Human;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidator implements Validator {

    private void validateBirthDay(String bd) throws WrongDataFormat {
        Pattern pattern = Pattern.compile("^(\\d{2}).(\\d{2}).(\\d{4})");
        Matcher matcher = pattern.matcher(bd);
        if (!matcher.find()) {
            throw new WrongDataFormat("Неправильный формат даты: " + bd);
        }
        int day = Integer.parseInt(matcher.group(1));
        int month = Integer.parseInt(matcher.group(2));
        int year = Integer.parseInt(matcher.group(3));
        if (day <= 0 || day > 31) throw new WrongDataFormat("Неверный день: " + String.valueOf(day));
        if (month <= 0 || month > 12) throw new WrongDataFormat("Неверный месяц: " + String.valueOf(month));
        if (year <= 0 || year > LocalDate.now().getYear())
            throw new WrongDataFormat("Неправильный год: " + String.valueOf(year));
    }

    private void validatePhoneNumber(String phone) throws WrongDataFormat {
        Pattern pattern = Pattern.compile("^[+]?[7]?\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches())
            throw new WrongDataFormat("Неверный формат номера телефона. Должен быть +7XXXXXXXXXX. Введен: " + phone);
    }

    private void validateGender(String gender) throws WrongDataFormat {
        Pattern pattern = Pattern.compile("[fm]{1}");
        Matcher matcher = pattern.matcher(gender);
        if (!matcher.matches())
            throw new WrongDataFormat("Неверно указан пол. Должно быть либо m - мужской, либо f - женский. Введен: " + gender);
    }

    private void validateName(String name, String prefix) throws WrongDataFormat {
        Pattern pattern = Pattern.compile("^[A-ZА-Я]{1}[a-zа-я]+");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches())
            throw new WrongDataFormat(String.format("Неверно указан%s. Введено: %s. Должно быть с заглавной буквы и содержать только буквы латинского или кирилического алфавита", prefix, name));
    }

    @Override
    public Human validate(String[] rawData) throws WrongDataFormat {
        Human contact = new Contact();
        if (rawData.length != contact.getDataDimension()) {
            String message = Arrays.toString(rawData) + ":";
            message += (rawData.length < contact.getDataDimension()) ? "Не достаточно данных: " : "Слишком много данных.";
            message += switch (contact.getDataDimension() - rawData.length) {
                case 1 -> " не введен пол.";
                case 2 -> " не введен номер телефона и пол.";
                case 3 -> " нет даты рождения, номера телефона и пола.";
                case 4 -> " нет отчества, даты рождения, номера телефона и пола.";
                case 5 -> " нет имени, отчества,даты рождения, номера телефона и пола";
                case 6 -> " нет фамилии,имени, отчества,даты рождения, номера телефона и пола";
                default -> "";
            };
            throw new WrongSizeOfInputData(message);
        }
        validateName(rawData[0], "а фамилия");
        validateName(rawData[1], "о имя");
        validateName(rawData[2], "о отчество");
        validateBirthDay(rawData[3]);
        validatePhoneNumber(rawData[4]);
        validateGender(rawData[5]);
        contact = new Contact(rawData);
        return contact;

    }
}
