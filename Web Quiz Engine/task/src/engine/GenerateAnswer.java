package engine;

public class GenerateAnswer {
    public static QuestionStruct getQuestion() {
        QuestionStruct answer = new QuestionStruct();
        answer.setTitle("The Java Logo");
        answer.setText("What is depicted on the Java logo?");
        answer.setOptions(new String[] {"Robot","Tea leaf","Cup of coffee","Bug"});
        return answer;
    }

    public static AnswerStruct rightAnswer(boolean correct) {
        AnswerStruct answer = new AnswerStruct();
        answer.setSuccess(correct);
        if (correct) {
            answer.setFeedback("Congratulations, you're right!");
        } else {
            answer.setFeedback("Wrong answer! Please, try again.");
        }
        return answer;
    }
}
