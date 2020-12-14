package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenerateAnswer {
    public static int COUNT_QUESTION = 0;
    public static Map<Integer, Integer> response = new HashMap<>();
    static ArrayList<QuestionStruct> questionAvailable = new ArrayList<>();

    public static QuestionStruct createQuestion(QuestionStruct question) {
        if (question == null) return null;

        COUNT_QUESTION++;
        question.setId(COUNT_QUESTION);
        /*if (question.getAnswer().length == 0) {
            int[] tmp = new int[question.getOptions().length];
            for (int i = 0; i < question.getOptions().length; i++) {
                tmp[i] = i;
            }
            question.setAnswer(tmp);
        }*/
        questionAvailable.add(question);
        return question;
    }

    public static QuestionStruct getQuestion(int numberQuestion) {
        return questionAvailable.get(numberQuestion);
    }

    public static QuestionStruct generateQuestion(int numberQuestion) {
        QuestionStruct answer = new QuestionStruct();
        answer.setId(numberQuestion);
        switch (numberQuestion) {
            case 1:
                answer.setTitle("The Java Logo");
                answer.setText("What is depicted on the Java logo?");
                answer.setOptions(new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"});
                ResponseContainer(numberQuestion, 2);
                break;
            case 2:
                answer.setTitle("The Ultimate Question");
                answer.setText("What is the answer to the Ultimate Question of Life, the Universe and Everything?");
                answer.setOptions(new String[]{"Everything goes right","42","2+2=4","11011100"});
                ResponseContainer(numberQuestion, 1);
                break;
            default:
                break;
        }
        return answer;
    }

    public static void ResponseContainer(int id, int answer) {
        response.put(id, answer);
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
