package engine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionStructRepository extends CrudRepository<QuestionStruct, Integer> {
    @Override
    ArrayList<QuestionStruct> findAll();

    QuestionStruct findById(int numberQuestion);
}
