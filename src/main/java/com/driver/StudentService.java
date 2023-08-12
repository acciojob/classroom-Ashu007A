package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, String> studentTeacherPairs = new HashMap<>();

    public String addStudent(Student student) {
        students.put(student.getName(), student);
        return "New student added successfully";
    }

    public String addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
        return "New teacher added successfully";
    }

    public String addStudentTeacherPair(String studentName, String teacherName) {
        studentTeacherPairs.put(studentName, teacherName);
        return "New student-teacher pair added successfully";
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        List<String> studentsByTeacher = new ArrayList<>();
        for (Map.Entry<String, String> entry : studentTeacherPairs.entrySet()) {
            if (entry.getValue().equals(teacherName)) {
                studentsByTeacher.add(entry.getKey());
            }
        }
        return studentsByTeacher;
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacherByName(String teacherName) {
        teachers.remove(teacherName);
        // Remove associated student-teacher pairs
        studentTeacherPairs.values().removeIf(value -> value.equals(teacherName));
    }

    public void deleteAllTeachers() {
        teachers.clear();
        studentTeacherPairs.clear();
    }
}