package sample.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.DataBase.DataBaseHandler;

import sample.Exceptions.RandomException;
import sample.Student;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class RandomStudentVsStudentController {


    List<Student> listStudent = new ArrayList<>();
    List<Student> listStudentQuestion = new ArrayList<>();
    List<Student> listStudentOut = new ArrayList<>();
    Gson gson = new Gson();
    String json = "";

    Student studentQuestion;
    Student studentAnswer;

    public  static int id=0;



//    void initialize() {
//        listStudent.addAll(DataBaseHandler.getAllStudentsFromDB());
//        updateLists();
//        backButton.setOnAction(event -> {
//            for (Student student :
//                    listStudent) {
//                DataBaseHandler.setQuestionAndAnswerAndBalls(student);
//            }
//
//
//        });
//
//        startRandom.setOnAction(event -> {
//            updateLists();
//            randomize();
//
//
//        });

//
//    }

    private void updateLists() {
        listStudentQuestion = listStudent.stream().filter(a -> a.getQuestion().equals("x")).collect(Collectors.toList());

    }


    private void randomize() {
        updateLists();



        if ((listStudentQuestion.size() < 2)) {

            System.out.println("No more student pairs left" + listStudentQuestion.get(0).getName() + " " + listStudentQuestion.get(0).getLastname());

        } else {
            studentQuestion = listStudentQuestion.get((int) (Math.random() * listStudentQuestion.size()));
            studentQuestion.setQuestion("done");
            listStudentOut.add(new Student(id,studentQuestion.getLastname(),studentQuestion.getName(),studentQuestion.getTeam()));
            System.out.println(studentQuestion.getLastname() + " " + studentQuestion.getName() + " " + studentQuestion.getTeam());
            id++;
            updateLists();

            randomSecond();
        }
    }

    private void randomSecond() {

        studentAnswer = listStudentQuestion.get((int) (Math.random() * listStudentQuestion.size()));

        if ((!studentAnswer.getTeam().equals(studentQuestion.getTeam()))) {
            studentAnswer.setQuestion("done");
            listStudentOut.add(new Student(id,studentAnswer.getLastname(),studentAnswer.getName(),studentAnswer.getTeam()));
            System.out.println(studentAnswer.getLastname() + " " + studentAnswer.getName() + " " + studentAnswer.getTeam());
            id++;
            System.out.println("=============================================================");
            updateLists();

        } else randomSecond();
    }

    public String randomAll() {
//        listStudent.addAll(DataBaseHandler.getAllStudentsFromDB());
        listStudent.add(0, new Student(1, "Akulov", "Oleg", "yellow", "x"));
        listStudent.add(1, new Student(2, "Ananev", "Maxim", "yellow", "x"));
        listStudent.add(2, new Student(3, "Bakulin", "Alexey", "yellow", "x"));
        listStudent.add(3, new Student(4, "Barisheva", "Evgeniya", "blue", "x"));
        listStudent.add(4, new Student(5, "Gricenko", "Nikolay", "blue", "x"));
        listStudent.add(5, new Student(6, "Detsky", "Yaroslav", "yellow", "x"));
        listStudent.add(6, new Student(7, "Dumava", "Oleg", "blue", "x"));
        listStudent.add(7, new Student(8, "Zanko", "Anna", "red", "x"));
        listStudent.add(8, new Student(9, "Korotkov", "Alexander", "blue", "x"));
        listStudent.add(9, new Student(10, "Kochubei", "Pavel", "blue", "x"));
        listStudent.add(10, new Student(11, "Maxut", "Rauan", "red", "x"));
        listStudent.add(11, new Student(12, "Moroz", "Alexander", "red", "x"));
        listStudent.add(12, new Student(13, "Peretyagin", "Sergei", "red", "x"));
        listStudent.add(13, new Student(14, "Ponomaryov", "Sergei", "blue", "x"));
        listStudent.add(14, new Student(15, "Sazhin", "Victor", "red", "x"));
        listStudent.add(15, new Student(16, "Fedorenko", "Stanislav", "yellow", "x"));
        listStudent.add(16, new Student(17, "Shokel", "Nadejda", "yellow", "x"));
        listStudent.add(17, new Student(18, "Sholkov", "Vasiliy", "red", "x"));
        listStudent.add(18, new Student(19, "Yaminov", "Damir", "blue", "x"));


        int i = listStudent.size() / 2;
        while (i != 0) {
            randomize();
            i--;
        }
      if (listStudentQuestion.size() > 2) {
          json="";
          id=0;
        randomAll();
            }
        for (int j = 0; j <listStudentQuestion.size(); j++) {
            listStudentOut.add(new Student(id,listStudentQuestion.get(j).getLastname(),listStudentQuestion.get(j).getName(),listStudentQuestion.get(j).getTeam()));
       id++;
        }
   json=gson.toJson(listStudentOut);

        System.out.println(json);

        id=0;
        //        DataBaseHandler.clearMarks();
        return json;
    }


}
