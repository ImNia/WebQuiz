package engine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;


@RestController
public class Question {
    @RequestMapping(value = "/api/quizzes/{id}", method = RequestMethod.GET)
    public QuestionStruct questionPage(@PathVariable int id) {
        if (id <= 0 || id > GenerateAnswer.COUNT_QUESTION) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return GenerateAnswer.getQuestion(id - 1);
    }

    @PostMapping(value = "/api/quizzes", consumes = "application/json")
    public QuestionStruct receiveQuestion(@RequestBody QuestionStruct question) {
        if (question.getTitle() == null || question.getText() == null || question.getOptions() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return GenerateAnswer.createQuestion(question);
    }

    @RequestMapping(value = "/api/quizzes", method = RequestMethod.GET)
    public QuestionStruct[] existsQuestion() {
        QuestionStruct[] exist = new QuestionStruct[GenerateAnswer.COUNT_QUESTION];
        for (int i = 0; i < GenerateAnswer.COUNT_QUESTION; i++) {
            exist[i] = GenerateAnswer.getQuestion(i);
        }
        return exist;
    }

    //@RequestMapping(value = "/api/quizzes/{id}/solve", method = RequestMethod.POST)
    @PostMapping(value = "/api/quizzes/{id}/solve", consumes = "application/json")
    public AnswerStruct answerPage(@PathVariable int id, @RequestBody AnswerUserStruct value) {
        if (value.getAnswer() == null) {
            if (GenerateAnswer.questionAvailable.get(id).getAnswer() == null) {
                return GenerateAnswer.rightAnswer(true);
            } else {
                return GenerateAnswer.rightAnswer(false);
            }
        }
        ArrayList<Integer> answerUser = new ArrayList<>();
        for (int tmp: value.getAnswer()) {
            answerUser.add(tmp);
        }
        Collections.sort(answerUser);

        ArrayList<Integer> answerMaster = new ArrayList<>();
        if (GenerateAnswer.questionAvailable.get(id - 1).getAnswer() != null) {
            for (int t : GenerateAnswer.questionAvailable.get(id - 1).getAnswer()) {
                answerMaster.add(t);
            }
        }
        if (answerUser.size() != answerMaster.size())
            return GenerateAnswer.rightAnswer(false);

        for (int i = 0; i < answerUser.size(); i++) {
            if (answerUser.get(i) != answerMaster.get(i)) {
                return GenerateAnswer.rightAnswer(false);
            }
        }
        return GenerateAnswer.rightAnswer(true);
    }
}
