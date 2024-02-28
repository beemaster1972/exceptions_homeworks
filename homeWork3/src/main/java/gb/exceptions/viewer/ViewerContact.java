package gb.exceptions.viewer;


import java.util.Scanner;

public class ViewerContact implements Viewer {
    private static final String promptContact = "Введите данные контакта в формате <Фамилия> <Имя> <Отчество> <дата_рождения> <номер_телефона> <пол>%n" +
            "%nФорматы данных:%n" +
            "%n" +
            "фамилия, имя, отчество - строки%n" +
            "дата_рождения - строка формата dd.mm.yyyy%n" +
            "номер_телефона - +7XXXXXXXXXX (десять цифр после +7)%n" +
            "пол - символ латиницей f или m.%n"+
            "Для завершения просто нажмите Enter.%n"+
            "Ваш ввод: ";
    private static Scanner scanner = new Scanner(System.in);
    private String inputString(String prompt) {
        String result = "";
        System.out.printf(prompt);
        result = scanner.nextLine();
        return result;

    }

    public String getContact() {
        return inputString(promptContact);
    }

    public void close() {scanner.close();}
}
