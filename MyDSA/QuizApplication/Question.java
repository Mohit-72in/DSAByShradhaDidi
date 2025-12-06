package MyDSA.QuizApplication;

public class Question {
    private int id;
    private String question;
    private String optn1;
    private  String optn2;
    private String optn3;
    private  String optn4;
    private String answer;

    public Question(int id, String question, String optn1, String optn2,
                    String optn3, String optn4, String answer) {
        this.id = id;
        this.question = question;
        this.optn1 = optn1;
        this.optn2 = optn2;
        this.optn3 = optn3;
        this.optn4 = optn4;
        this.answer = answer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("id=").append(id);
        sb.append(", question='").append(question).append('\'');
        sb.append(", optn1='").append(optn1).append('\'');
        sb.append(", optn2='").append(optn2).append('\'');
        sb.append(", optn3='").append(optn3).append('\'');
        sb.append(", optn4='").append(optn4).append('\'');
        sb.append(", answer='").append(answer).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptn1() {
        return optn1;
    }

    public void setOptn1(String optn1) {
        this.optn1 = optn1;
    }

    public String getOptn2() {
        return optn2;
    }

    public void setOptn2(String optn2) {
        this.optn2 = optn2;
    }

    public String getOptn3() {
        return optn3;
    }

    public void setOptn3(String optn3) {
        this.optn3 = optn3;
    }

    public String getOptn4() {
        return optn4;
    }

    public void setOptn4(String optn4) {
        this.optn4 = optn4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
