package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateAnswer {
    public static int COUNT_QUESTION = 0;

    @Autowired
    private QuestionStructRepository questionStructRepository;

    public static Map<Integer, Integer> response = new HashMap<>();
    static ArrayList<QuestionStruct> questionAvailable = new ArrayList<>();


    public QuestionStruct createQuestion(QuestionStruct question) {
        if (question == null) return null;
        System.out.println(questionStructRepository.getClass());
        questionStructRepository.save(question);

        COUNT_QUESTION++;
        //question.setId(COUNT_QUESTION);
        questionAvailable.add(question);
        return question;
    }

    public static QuestionStruct getQuestion(int numberQuestion) {
        return questionAvailable.get(numberQuestion);
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
