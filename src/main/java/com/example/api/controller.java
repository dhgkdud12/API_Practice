package com.example.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {

    List<Student> students = new ArrayList<>();

    // POST 입력
    @PostMapping("/")
    public Student post(@RequestBody Student student) {
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setName(student.getName());
        students.add(student1);
        return student1;
    }

    // GET 입력
    @GetMapping("/")
    public Student get(@RequestParam int id, @RequestParam String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        students.add(student);
        return student;
    }

    // 모두 조회
    @GetMapping("/selectAll")
    public List<Student> selectAll() {
        return students;
    }

    // ID 조회
    @GetMapping("/select")
    public Student selectStudent(@RequestParam int id) {
        Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student.setId(id);
                student.setName(students.get(i).getName());
            }
        }
        return student;
    }

    // 이름 수정
    @PutMapping("/")
    public Student put(@RequestParam int id, @RequestParam String name) {
        Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.get(i).setName(name);
                student = students.get(i);
            }
        }
        return student;
    }

    // 아이디 삭제
    @DeleteMapping("/")
    public String delete(@RequestParam int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
            }
        }
        String msg = id + " 삭제";
        return msg;
    }

    // 모두 삭제
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        students.removeAll(students);
        String msg = "모두삭제";
        return msg;
    }



}
