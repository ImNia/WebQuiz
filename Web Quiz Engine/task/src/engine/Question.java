package engine;

import org.springframework.web.bind.annotation.*;



@RestController
public class Question {
    private int answer;

    @RequestMapping(value = "/api/quiz", method = RequestMethod.GET)
    public QuestionStruct questionPage() {
        QuestionStruct tmp;
        tmp = GenerateAnswer.getQuestion();
        //System.out.println(tmp.text);
        return tmp;
    }

    //@PostMapping(path = "/app/quiz")
    //TODO регуляр
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
    }
}
