package engine;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class Question {

    /*@RequestMapping(value = "/api/quiz", method = RequestMethod.GET)
    public QuestionStruct questionPage() {
        QuestionStruct tmp;
        tmp = GenerateAnswer.getQuestion((int) ( 1 + Math.random() * GenerateAnswer.COUNT_QUESTION));
        //System.out.println(tmp.text);
        return tmp;
    }
    //@PostMapping(path = "/app/quiz")
    @RequestMapping(value = "/api/quiz", method = RequestMethod.POST)
    public AnswerStruct answerPage(@RequestParam(name="answer") String value) {
        AnswerStruct tmp;
        System.out.println(value);
        int answer = Integer.parseInt(value);
        if(answer == 2) {
            tmp = GenerateAnswer.rightAnswer(true);
        } else {
            tmp = GenerateAnswer.rightAnswer(false);
        }
        return tmp;
    }*/

    @RequestMapping(value = "/api/quizzes/{id}", method = RequestMethod.GET)
    public QuestionStruct questionPage(@PathVariable int id) {
        if (id < 0 || id > GenerateAnswer.COUNT_QUESTION) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return GenerateAnswer.getQuestion(id - 1);
    }

    /* Создаем новый вопрос по запросу
    * */
    @PostMapping(value = "/api/quizzes", consumes = "application/json")
    public QuestionStruct allQuestion(@RequestBody ReceiveQuestion question) {
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

    @RequestMapping(value = "/api/quizzes/{id}/solve", method = RequestMethod.POST)
    public AnswerStruct answerPage(@PathVariable int id, @RequestParam(name="answer") String value) {
        AnswerStruct answer;
        if(Integer.parseInt(value) == GenerateAnswer.response.get(id)) {
            answer = GenerateAnswer.rightAnswer(true);
        } else {
            answer = GenerateAnswer.rightAnswer(false);
        }
        return answer;
    }
}
