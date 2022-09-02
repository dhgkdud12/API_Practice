package com.example.api;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class controller2 {

    Set<Student> students = new HashSet<>();

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
    public Set<Student> selectAll() {
        return students;
    }

    // ID 조회
    @GetMapping("/select")
    public Student selectStudent(@RequestParam int id) {
        ArrayList<Student> arrayList = new ArrayList<>(students);
        Student student = new Student();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                student.setId(id);
                student.setName(arrayList.get(i).getName());
            }
        }
        return student;
    }

    // 이름 수정 xx
//    @PutMapping("/")
//    public Student put(@RequestParam int id, @RequestParam String name) {
//        ArrayList<Student> arrayList = new ArrayList<>(students);
//        Student student = new Student();
//        student.setId(id);
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i).getId() == id) {
//                arrayList.remove(i);
//                arrayList.get(i).setName(name);
//                student = arrayList.get(i);
//            }
//        }
//        return student;
//    }

    // 아이디 삭제 - xx
//    @DeleteMapping("/")
//    public String delete(@RequestParam int id) {
//        ArrayList<Student> arrayList = new ArrayList<>(students);
//        for (int i = 0; i < students.size(); i++) {
//            if (arrayList.get(i).getId() == id) {
//                students.remove(i);
//            }
//        }
//        String msg = id + " 삭제";
//        return msg;
//    }

    // 모두 삭제
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        students.clear();
        String msg = "모두삭제";
        return msg;
    }



}
