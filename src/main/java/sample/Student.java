package sample;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private String question;
    private String team;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!Objects.equals(name, student.name)) return false;
        if (!Objects.equals(lastname, student.lastname)) return false;
        if (!Objects.equals(question, student.question)) return false;


        return Objects.equals(team, student.team);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);

        return result;
    }

    public Student(int id, String name, String lastname, String team, String question) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.team = team;
        this.question = question;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {this.team = team;}

    public Student(int id,String name, String lastname, String team) {
        this.id =id;
        this.name = name;
        this.lastname = lastname;
        this.team = team;
    }
}
