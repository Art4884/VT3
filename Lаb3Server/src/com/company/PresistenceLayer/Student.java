package com.company.PresistenceLayer;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String surname;
    private int individualNumber;
    private int groupNumber;

    public Student(String name, String surname, int individualNumber, int groupNumber) {
        this.name = name;
        this.surname = surname;
        this.individualNumber = individualNumber;
        this.groupNumber = groupNumber;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(int individualNumber) {
        this.individualNumber = individualNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "IndividualNumber: " + individualNumber + "\n" +
                "Group: " + groupNumber;
    }
}
