package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenerateAnswer {
    public static int COUNT_QUESTION = 0;
    public static Map<Integer, Integer> response = new HashMap<>();
    static ArrayList<QuestionStruct> questionAvailable = new ArrayList<>();

    public static QuestionStruct createQuestion(ReceiveQuestion question) {
        if (question == null) return null;

        QuestionStruct resultQuestion = new QuestionStruct();
        COUNT_QUESTION++;
        resultQuestion.setId(COUNT_QUESTION);
        resultQuestion.setTitle(question.title);
        resultQuestion.setText(question.text);
        resultQuestion.setOptions(question.options);
        ResponseContainer(COUNT_QUESTION, question.answer);

        questionAvailable.add(resultQuestion);
        return resultQuestion;
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
