package day0226;

public class QuizObjectTest {
    public static void main(String[] args) {

        QuizObject son = new QuizObject();
        son.setName("손흥민");
        son.setAge(29);
        son.setCity("부산");
        son.setHobby("헬스");

        QuizObject kim = new QuizObject();
        kim.setName("김연아");
        kim.setAge(26);
        kim.setCity("서울");
        kim.setHobby("여행");


        System.out.println("과정명: 쌍용 교육센터 자바교육 4강의장");
        System.out.println("==============================");
        System.out.println("학생 1 정보");
        System.out.println("이름: "+son.getName());
        System.out.println("나이: "+son.getAge()+"세");
        System.out.println("지역: "+son.getCity());
        System.out.println("취미: "+son.getHobby());
        System.out.println();
        System.out.println("학생 2 정보");
        System.out.println("이름: "+kim.getName());
        System.out.println("나이: "+kim.getAge()+"세");
        System.out.println("지역: "+kim.getCity());
        System.out.println("취미: "+kim.getHobby());


    }
}
