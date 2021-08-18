package com.example.howtodoinjavatwo.springbootsoapservicews;

import com.alineservices.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.Assert;

@Component
public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setNome("Sajal");
        student.setIdade(5);
        student.setEndereco("Pune");
        students.put(student.getNome(), student);

        student = new Student();
        student.setNome("Kajal");
        student.setIdade(5);
        student.setEndereco("Chicago");
        students.put(student.getNome(), student);

    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }

    public Student deleteStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.remove(name);
    }

    public Student setStudent(Student name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.put(name.getNome(), name);
    }
}
