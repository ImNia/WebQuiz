package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenerateAnswer {
    public static int COUNT_QUESTION = 0;

    @Autowired
    private QuestionStructRepository questionStructRepository;

    public QuestionStruct createQuestion(QuestionStruct question) {
        if (question == null) return null;
        System.out.println(questionStructRepository.getClass());
        questionStructRepository.save(question);

        COUNT_QUESTION++;
        return question;
    }

    public QuestionStruct getQuestion(int numberQuestion) {
        return questionStructRepository.findById(numberQuestion);
    }

    public ArrayList<QuestionStruct> getAllQuestion() {
        return questionStructRepository.findAll();
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

    public AnswerStruct checkAnswer(int id, AnswerUserStruct value) {
        List<Integer> userAnswer = value.getAnswer();
        List<Integer> masterAnswer = questionStructRepository.findById(id).getAnswer();
        Collections.sort(masterAnswer);
        Collections.sort(userAnswer);
        if (masterAnswer.containsAll(userAnswer) && userAnswer.containsAll(masterAnswer)) {
            return rightAnswer(true);
        }
        return rightAnswer(false);
    }

    public void deleteBase() {
        questionStructRepository.deleteAll();
    }
}
