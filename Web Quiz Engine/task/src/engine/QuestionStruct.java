package engine;

public class QuestionStruct {
    private String title;
    private String text;
    private String[] options;

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
    public void setOptions(String[] options) {
        this.options = options.clone();
    }
    public String[] getOptions() {
        return this.options;
    }
}
