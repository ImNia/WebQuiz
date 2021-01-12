package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;


@RestController
public class Question {

    @Autowired
    public GenerateAnswer tmp;

    @RequestMapping(value = "/api/quizzes/{id}", method = RequestMethod.GET)
    public QuestionStruct questionPage(@PathVariable int id) {
        if (id <= 0 || tmp.getQuestion(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return tmp.getQuestion(id);
    }

    @PostMapping(value = "/api/quizzes", consumes = "application/json")
    public QuestionStruct receiveQuestion(@RequestBody QuestionStruct question) {
        if (question.getTitle() == null || question.getText() == null || question.getOptions() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return tmp.createQuestion(question);
    }

    @RequestMapping(value = "/api/quizzes", method = RequestMethod.GET)
    public ArrayList<QuestionStruct> existsQuestion() {
        return tmp.getAllQuestion();
    }

    @PostMapping(value = "/api/quizzes/{id}/solve", consumes = "application/json")
    public AnswerStruct answerPage(@PathVariable int id, @RequestBody AnswerUserStruct value) {
        return tmp.checkAnswer(id, value);
    }

    @RequestMapping(value = "/api/delete", method = RequestMethod.GET)
    public void deleteQuestion() {
        tmp.deleteBase();
    }
}
