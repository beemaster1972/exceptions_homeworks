package gb.exceptions.model;

public class Contact implements Human{
    private final int DATA_DIMENSION = 6;
    protected String name;
    protected String surename;
    protected String lastname;
    protected String birthday;
    protected String gender;
    protected String phoneNumber;

    public Contact(String name, String surename, String lastname, String birthday, String gender, String phoneNumber) {
        this.name = name;
        this.surename = surename;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String[] rawData){

        this.name = rawData[1];
        this.surename = rawData[2];
        this.lastname = rawData[0];
        this.birthday = rawData[3];
        this.gender = rawData[5];
        this.phoneNumber = rawData[4];
    }

    public Contact() {
        name = "Ivan";
        surename = "Ivanovich";
        lastname = "Kuznetsoff";
        birthday = "01.01.1970";
        gender = "m";
        phoneNumber = "124567890";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurename() {
        return surename;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public int getDataDimension(){ return DATA_DIMENSION;}

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                name,
                surename,
                lastname,
                birthday,
                phoneNumber,
                gender);
    }
}
