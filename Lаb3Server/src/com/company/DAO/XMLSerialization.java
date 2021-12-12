package com.company.DAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class XMLSerialization<T> {

    private final String ARCHIVE_OF_STUDENTS = "archive\\archive_of_students.xml";
    private final String ARCHIVE_OF_LOGINS = "archive\\archive_of_logins.xml";

    public void serializeForStudents(ArrayList<T> object){
        XMLEncoder encoder;
        try{
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ARCHIVE_OF_STUDENTS)));
            encoder.writeObject(object);
            encoder.close();
        }catch (FileNotFoundException e){
            System.out.println("ERROR: While creating or opening the file " + ARCHIVE_OF_STUDENTS);
        }
    }

    public ArrayList<T> deserializeForStudents(){
        return getTs(ARCHIVE_OF_STUDENTS);
    }

    public void serializeForAccounts(ArrayList<T> object){
        XMLEncoder encoder;
        try{
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ARCHIVE_OF_LOGINS)));
            encoder.writeObject(object);
            encoder.close();
        }catch (FileNotFoundException e){
            System.out.println("ERROR: While creating or opening the file " + ARCHIVE_OF_LOGINS);
        }
    }

    public ArrayList<T> deserializeForAccounts(){
        return getTs(ARCHIVE_OF_LOGINS);
    }

    private ArrayList<T> getTs(String archive_of_logins) {
        ArrayList<T> list = new ArrayList<>();
        XMLDecoder decoder;
        try{
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(archive_of_logins)));
            list = (ArrayList<T>) decoder.readObject();
            decoder.close();
        }catch (FileNotFoundException e){
            System.out.println("ERROR: File " + archive_of_logins + " not found!");
        }
        return list;
    }

}
