package engine;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question")
public class QuestionStruct {
    @GeneratedValue
    @Column(name = "id")
    @Id
    private Integer id;
    private String title;
    private String text;
    @ElementCollection
    private List<String> options;
    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
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
    public void setOptions(List<String> options) {
        this.options = options;
    }
    public List<String> getOptions() {
        return this.options;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
    public List<Integer> getAnswer() {
        return this.answer;
    }
}