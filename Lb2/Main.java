package Lb2;

import Lb2.Models.Student;
import Lb2.Models.ReadDataHandler;
import Lb2.Models.Enums.*;


import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    private static ReadDataHandler _readDataHandler = new ReadDataHandler();
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Serheiev", "Valentyn", "Andrew", "2005-03-13",
                "Lisova street", "1234456", "Faculty 1", 2, "Group A"));
        students.add(new Student(1, "Tomas", "Shayba", "Andrew", "2006-03-13",
                "Lisova street", "1234534534", "Faculty 2", 2, "Group A"));
        students.add(new Student(1, "Roman", "Biliy", "Andrew", "2006-03-13",
                "Lisova street", "123678890", "Faculty 1", 2, "Group B"));
        boolean isEnd = false;

        while (!isEnd){
            System.out.println("----MENU----\n" +
                    "1 - Compare by group.\n" +
                    "2 - Compare by birth day.\n" +
                    "3 - Compare by faculty.\n" +
                    "4 - EXIT");

            MenuChoice menuChoice = _readDataHandler.GetMenuChoice();
            if(menuChoice != null){
                Predicate<Student> predicate = _readDataHandler.GetPredicate(menuChoice);

                if(predicate == null)
                    isEnd = true;
                else
                    students.stream().filter(predicate).forEach(System.out::println);
            }
        }
    }
}
