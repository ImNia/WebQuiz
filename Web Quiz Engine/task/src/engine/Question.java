package engine;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import static engine.parser.getQuestion;
import static engine.parser.rightAnswer;


@RestController
public class Question {
    private int answer;

    //@PostMapping(path = "/app/quiz")
    //TODO регуляр
    @RequestMapping(value = "/api/quiz", method = RequestMethod.GET)
    public QuestionStruct questionPage() {
        QuestionStruct tmp = new QuestionStruct();
        tmp = getQuestion("src/engine/Date.json");
        System.out.println(tmp.text);
        return tmp;
    }

    @RequestMapping(value = "/api/quiz", method = RequestMethod.POST)
    public AnswerStruct answerPage(@RequestParam(name="answer") String value) {
        AnswerStruct tmp = new AnswerStruct();
        System.out.println(value);
        int znak = Integer.parseInt(value);
        if(znak == 2) {
            tmp = rightAnswer("src/engine/RightAnswer.json");
        } else {
            tmp = rightAnswer("src/engine/FalseAnswer.json");
        }
        return tmp;
    }
}
