package engine;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class QuestionStruct {
    @Id
    private int id;
    private String title;
    private String text;
    private String[] options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
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

    public void setAnswer(int[] answer) {
        this.answer = answer.clone();
    }
    public int[] getAnswer() {
        return this.answer;
    }
}