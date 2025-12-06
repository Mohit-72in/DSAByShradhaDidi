package MyDSA.QuizApplication;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String[] selection = new String[5];

    QuestionService(){
        questions[0] = new Question(1,"Size Of Int","4 byte","8 byte","16 byte","2 Byte","4 byte");
        questions[1] = new Question(2,"Size Of double","4 byte","8 byte","16 byte","2 Byte","8 byte");
        questions[2] = new Question(3,"Size Of Char","4 byte","8 byte","16 byte","2 Byte","2 byte");
        questions[3] = new Question(4,"Size Of float","4 byte","8 byte","16 byte","2 Byte","4 byte");
        questions[4] = new Question(5,"Size Of long","4 byte","8 byte","16 byte","2 Byte","8 byte");


    }
    public void playQuiz(){
        int i = 0;
        for(Question q : questions){
            System.out.println(q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOptn1());
            System.out.println(q.getOptn2());
            System.out.println(q.getOptn3());
            System.out.println(q.getOptn4());
            Scanner sc = new Scanner(System.in);
            selection[i++] = sc.nextLine();
        }
        System.out.println(Arrays.toString(selection));

    }
    public void printScore(){
        int score = 0;
        for(int i = 0;i<questions.length;i++){
            String yrAns = selection[i];
            Question q = questions[i];
            String correctAns = q.getAnswer();
            if(correctAns.equals(yrAns)) score++;
        }
        System.out.println("Your Score is: "+score);
    }

}
