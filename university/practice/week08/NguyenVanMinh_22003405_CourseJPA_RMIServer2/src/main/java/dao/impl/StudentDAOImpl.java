package dao.impl;

import dao.StudentDAO;
import jakarta.persistence.EntityManager;
import model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDAOImpl extends GenericDAOImpl<Student, Integer> implements StudentDAO {

    public StudentDAOImpl(Class<Student> clazz) {
        super(clazz);
    }

    public StudentDAOImpl(EntityManager em, Class<Student> clazz) {
        super(em, clazz);
    }

    @Override
    public Map<Student, Double> getAverageScoreOfStudents() {
        String query = """
                SELECT sg.student, avg(sg.grade) as avgGrade
                FROM  StudentGrade sg
                WHERE sg.grade is not null
                GROUP BY sg.student
                """;
        return em.createQuery(query, Object[].class)
                .getResultList()
                .stream()
                .collect(Collectors.toMap(
                        result -> (Student) result[0],
                        result -> (Double) result[1]
                ));
    }

    @Override
    public List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) {
        return null;
    }
}
