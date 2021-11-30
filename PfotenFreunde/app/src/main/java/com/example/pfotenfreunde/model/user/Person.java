package com.example.pfotenfreunde.model.user;

public class Person extends User{

    private String surname;
    private int age;
    private Sex sex;

    public Person(String name, String phone, String email, Address address, String surname, int age, Sex sex) {
        super(name, phone, email, address);
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
