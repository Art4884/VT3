package com.company.DAO;

import com.company.PresistenceLayer.Account;
import com.company.PresistenceLayer.Student;

import java.util.ArrayList;

public class DAO {

    private ArrayList<Student> archiveOfStudents = new XMLSerialization<Student>().deserializeForStudents();
    //private ArrayList<Account> archiveOfAccounts= new XMLSerialization<Account>().deserializeForAccounts();

    public void saveStudentsArchive(ArrayList<Student> archive){
        XMLSerialization<Student> serialization = new XMLSerialization<>();
        serialization.serializeForStudents(archive);
        archiveOfStudents = archive;
    }

//    public void saveAccountsArchive(ArrayList<Account> archive){
//        XMLSerialization<Account> serialization = new XMLSerialization<>();
//        serialization.serializeForAccounts(archive);
//        archiveOfAccounts = archive;
//    }

    public ArrayList<Student> getArchiveOfStudents() {
        return archiveOfStudents;
    }

//    public ArrayList<Account> getArchiveOfAccounts() {
//        return archiveOfAccounts;
//    }
}
