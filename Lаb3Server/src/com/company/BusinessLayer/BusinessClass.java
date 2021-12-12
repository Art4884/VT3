package com.company.BusinessLayer;

import com.company.DAO.DAO;
import com.company.PresistenceLayer.Student;

import java.util.ArrayList;

public class BusinessClass {

    DAO dao = new DAO();

    public void addStudent(String studentInfo){
        String[] studentArray = studentInfo.split(" ");
        Student student = new Student(studentArray[0], studentArray[1], Integer.parseInt(studentArray[2]), Integer.parseInt(studentArray[3]));
        ArrayList<Student> students = dao.getArchiveOfStudents();
        students.add(student);
        dao.saveStudentsArchive(students);
    }

    public String studentProfile(int individualNumber){
        ArrayList<Student> students = dao.getArchiveOfStudents();
        for (Student student : students) {
            if (student.getIndividualNumber() == individualNumber) {
                return student.toString();
            }
        }
        return "There is no student with such number";
    }

    public void changeStudent(String studentInfo){
        String[] studentArray = studentInfo.split(" ");
        Student student = new Student(studentArray[0], studentArray[1], Integer.parseInt(studentArray[2]), Integer.parseInt(studentArray[3]));
        ArrayList<Student> students = dao.getArchiveOfStudents();
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getIndividualNumber() == student.getIndividualNumber()){
                students.set(i, student);
            }
        }
        dao.saveStudentsArchive(students);
    }

    public void deleteStudents(String studentInfo){
        String[] studentArray = studentInfo.split(" ");
        Student student = new Student(studentArray[0], studentArray[1], Integer.parseInt(studentArray[2]), Integer.parseInt(studentArray[3]));
        ArrayList<Student> students = dao.getArchiveOfStudents();
        students.remove(student);
        dao.saveStudentsArchive(students);
    }
}
