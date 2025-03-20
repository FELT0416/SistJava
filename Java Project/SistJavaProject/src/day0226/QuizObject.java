package day0226;


public class QuizObject {
    static String processName;
    String stuName;
    int age;
    private String city;
    private String hobby;

    public QuizObject() {
    }

    public void setName(String name){
        this.stuName = name;
    }
    public String getName(){
        return this.stuName;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setHobby(String hobby){
        this.hobby = hobby;
    }
    public String getHobby(){
        return this.hobby;
    }


}
