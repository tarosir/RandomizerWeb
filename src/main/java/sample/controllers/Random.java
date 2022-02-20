package sample.controllers;

import com.google.gson.Gson;
import sample.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {
    Gson gson = new Gson();
    String json;
    List<Student> listFirstCommand = new ArrayList<>();
    List<Student> listSecondCommand = new ArrayList<>();
    List<Student> listThirdCommand = new ArrayList<>();

    List<Student> listStudentOut = new ArrayList<>();

    public String run() {

        listFirstCommand.add(new Student(8, "Zanko", "Anna", "red"));
        listFirstCommand.add(new Student(11, "Maxut", "Rauan", "red"));
        listFirstCommand.add(new Student(12, "Moroz", "Alexander", "red"));
        listFirstCommand.add(new Student(13, "Peretyagin", "Sergei", "red"));
        listFirstCommand.add(new Student(15, "Sazhin", "Victor", "red"));
        listFirstCommand.add(new Student(18, "Sholkov", "Vasiliy", "red"));

        listSecondCommand.add(new Student(4, "Barisheva", "Evgeniya", "blue"));
        listSecondCommand.add(new Student(5, "Gricenko", "Nikolay", "blue"));
        listSecondCommand.add(new Student(7, "Dumava", "Oleg", "blue"));
        listSecondCommand.add(new Student(9, "Korotkov", "Alexander", "blue"));
        listSecondCommand.add(new Student(10, "Kochubei", "Pavel", "blue"));
        listSecondCommand.add(new Student(14, "Ponomaryov", "Sergei", "blue"));
        listSecondCommand.add(new Student(19, "Yaminov", "Damir", "blue"));

        listThirdCommand.add(new Student(1, "Akulov", "Oleg", "yellow"));
        listThirdCommand.add(new Student(2, "Ananev", "Maxim", "yellow"));
        listThirdCommand.add(new Student(3, "Bakulin", "Alexey", "yellow"));
        listThirdCommand.add(new Student(6, "Detsky", "Yaroslav", "yellow"));
        listThirdCommand.add(new Student(16, "Fedorenko", "Stanislav", "yellow"));
        listThirdCommand.add(new Student(17, "Shokel", "Nadejda", "yellow"));

        Collections.shuffle(listFirstCommand);
        Collections.shuffle(listSecondCommand);
        Collections.shuffle(listThirdCommand);

        List<Student> listFirstCommandCheck = new ArrayList<>(listFirstCommand);
        List<Student> listSecondCommandCheck = new ArrayList<>(listSecondCommand);
        List<Student> listThirdCommandCheck = new ArrayList<>(listThirdCommand);
        int maxSizeCommand;
        int minSizeCommand;
        if(listFirstCommand.size()>=listSecondCommand.size()&&listFirstCommand.size()>=listThirdCommand.size()){
            maxSizeCommand = listFirstCommand.size();
            minSizeCommand = Math.min(listSecondCommand.size(), listThirdCommand.size());
        }else{
            maxSizeCommand = Math.max(listSecondCommand.size(), listThirdCommand.size());
            if(listFirstCommand.size()<listSecondCommand.size()){
                minSizeCommand =  Math.min(listFirstCommand.size(), listThirdCommand.size());
            }else
                minSizeCommand = listSecondCommand.size();
        }

        int countLoopMax = (int) Math.ceil((double) maxSizeCommand/2);
        int countLoopMin = (int) Math.ceil((double) minSizeCommand/2);

        for (int i = 0; i < countLoopMax; i++) {
            if(i < countLoopMin){
                listStudentOut.add(listFirstCommand.get(i*2));
                listFirstCommandCheck.remove(listFirstCommand.get(i*2));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());

                listStudentOut.add(listSecondCommand.get(i*2));
                listSecondCommandCheck.remove(listSecondCommand.get(i*2));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                System.out.println("++++++++++++++++++++++++++++");

                listStudentOut.add(listThirdCommand.get(i*2));
                listThirdCommandCheck.remove(listThirdCommand.get(i*2));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());

                listStudentOut.add(listSecondCommand.get(i*2+1));
                listSecondCommandCheck.remove(listSecondCommand.get(i*2+1));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                System.out.println("++++++++++++++++++++++++++++");

                listStudentOut.add(listFirstCommand.get(i*2+1));
                listFirstCommandCheck.remove(listFirstCommand.get(i*2+1));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());

                listStudentOut.add(listThirdCommand.get(i*2+1));
                listThirdCommandCheck.remove(listThirdCommand.get(i*2+1));
                System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                System.out.println("++++++++++++++++++++++++++++");
            }else{
                int left = listFirstCommandCheck.size()+
                        listSecondCommandCheck.size()+
                        listThirdCommandCheck.size();
                if(left<2){
                    if(!listFirstCommandCheck.isEmpty()){
                        listStudentOut.add(listFirstCommandCheck.get(listFirstCommandCheck.size()-1));
                        listFirstCommandCheck.remove(listFirstCommandCheck.size()-1);
                        System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                    }
                    if(!listSecondCommandCheck.isEmpty()){
                        listStudentOut.add(listSecondCommandCheck.get(listSecondCommandCheck.size()-1));
                        listSecondCommandCheck.remove(listSecondCommandCheck.size()-1);
                        System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                    }
                    if(!listThirdCommandCheck.isEmpty()){
                        listStudentOut.add(listThirdCommandCheck.get(listThirdCommandCheck.size()-1));
                        listThirdCommandCheck.remove(listThirdCommandCheck.size()-1);
                        System.out.println(listStudentOut.get(listStudentOut.size()-1).toString());
                    }
                }
            }
        }
        for (int i = 0; i < listStudentOut.size(); i++) {
            listStudentOut.get(i).setId(i);
        }

        json=gson.toJson(listStudentOut);

        return json;
    }


}
