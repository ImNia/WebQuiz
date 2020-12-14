package engine;

public class AnswerUserStruct {
    private int[] answer;

    public void setAnswer(int[] answer) {
        this.answer = answer.clone();
    }
    public int[] getAnswer() {
        return this.answer;
    }
}
