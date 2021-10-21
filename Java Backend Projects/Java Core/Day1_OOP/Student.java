package variables.Day1_OOP;

/*
Author: Jumanazar Saidov
Problem no: 5-topshiriq
Definition:
Quyidagi atributlari bor bo’lgan Student nomli klass yarating:
familiya,  ismi,  guruh nomeri, o’qiydigan fanlari (5 ta fandan iborat massiv).
O’qidigan fanlari ro’yxatini ekranga chiqazuvchi printSubjects nomli method yarating
 */

import java.util.Arrays;

public class Student {
    private String lastName;
    private String firstName;
    private int groupID;
    private String[] subjects = new String[5];

    public Student(String lastName, String firstName, int groupID, String[] subjects){
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupID = groupID;
        this.subjects = subjects;
    }

    public void printSubjects(){
        System.out.println(Arrays.toString(subjects));
    }

    public static void main(String[] args) {
        Student a = new Student("Kodirov", "Alisher", 502, new String[]{"Math", "Chemistry", "Physics", "PT", "Literature"});
        a.printSubjects();
    }
}
