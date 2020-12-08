package engine;

public class AnswerStruct {
    private boolean success;
    private String feedback;

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean isSuccess() {
        return this.success;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public String getFeedback() {
        return this.feedback;
    }
}
