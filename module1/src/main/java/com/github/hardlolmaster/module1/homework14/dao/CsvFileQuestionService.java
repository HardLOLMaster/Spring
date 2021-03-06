package com.github.hardlolmaster.module1.homework14.dao;

import com.github.hardlolmaster.module1.homework14.Properties;
import com.github.hardlolmaster.module1.homework14.domain.Question;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvFileQuestionService implements IQuestionService {

    private String filePath;

    public CsvFileQuestionService(Properties properties) {
        this.filePath = properties.getCsv().getPath();
    }

    @Override
    public List<Question> getQuestions() {
        File file = new File(filePath);

        List<Question> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] strArr = line.split(",");
                Question question = new Question();
                question.setNumber(Integer.parseInt(strArr[0]));
                question.setQuestion(strArr[1]);
                for (int i = 1; i < strArr.length - 2; ) {
                    question.addAnswer(strArr[++i]);
                }
                question.setRightAnswer(Integer.parseInt(strArr[strArr.length - 1]));
                result.add(question);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
