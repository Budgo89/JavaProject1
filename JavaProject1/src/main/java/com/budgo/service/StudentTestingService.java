package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;
import com.budgo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class StudentTestingService {

    private final Missions missions;
    private final Student student;
    private final AnswerCheckingService answerCheckingService;

    private Scanner scanner = new Scanner(System.in);

    public StudentTestingService(Missions missions, Student student,
                                 AnswerCheckingService answerCheckingService) {

        this.missions = missions;
        this.student = student;
        this.answerCheckingService = answerCheckingService;

        studentDataRequest();
        greetings();
        testing();
        testResult();
    }

    private void testResult() {
        System.out.println(student.getSurname() + " " + student.getName() + ", вы ответили правильно на :"
                + student.getCorrectAnswer() + " вопросов.");
    }

    private void testing() {
        for (Mission mission : missions.missionList) {
            System.out.println("+++++");
            System.out.println("Вопрос № " + mission.getId());
            System.out.println(mission.getQuestion());
            System.out.println("----");
            System.out.println("Варианты ответа:");
            for (int key : mission.getAnswers().keySet()) {
                System.out.println(key + " " + mission.getAnswers().get(key));
            }

            String answer = scanner.nextLine();
            if (answerCheckingService.isAnswer(mission.getId(), answer)) {
                student.setCorrectAnswer();
            }
        }
    }

    private void greetings() {
        System.out.println("Добрый день, " + student.getSurname() + " " + student.getName());
        System.out.println("Пройдите тестирование, введя номер ответа!");
    }

    private void studentDataRequest() {
        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();
        student.setName(name);

        System.out.println("Введите ваше фамилию: ");
        String surname = scanner.nextLine();
        student.setSurname(surname);
    }
}
