package sample;


import sample.Exceptions.RandomException;
import sample.controllers.Random;
import sample.controllers.RandomStudentVsStudentController;

public class Main {


    public static void main(String[] args) {
//       RandomStudentVsStudentController randomStudentVsStudentController = new RandomStudentVsStudentController();
//
//        randomStudentVsStudentController.randomAll();
        Random random = new Random();
        random.run();


    }


}
