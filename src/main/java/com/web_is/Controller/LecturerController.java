package com.web_is.Controller;

import com.web_is.Service.LecturerService;
import com.web_is.User.Lecturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @PostMapping("/add")
    public ResponseEntity<Lecturers> addLecturer(@RequestBody Lecturers lecturers) {
        try {
            Lecturers savedLecturer = lecturerService.saveLecturer(lecturers);
            return ResponseEntity.ok(savedLecturer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/get") // Change "/add" to something like "/get"
    public List<Lecturers> getCourse() {
        try {
            return lecturerService.getAllLecturers();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return (List<Lecturers>) ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTotalLecturers() {
        try {
            long totalLecturers = lecturerService.countLecturers();
            return ResponseEntity.ok(totalLecturers);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).body(null);
        }
    }

}
