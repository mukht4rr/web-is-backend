package com.web_is.Service;

import com.web_is.Model.Course;
import com.web_is.Respository.LecturerRepository;
import com.web_is.Model.Lecturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    public Lecturers findByEmail(String lecturerEmail) {
        return lecturerRepository.findByLecturerEmail(lecturerEmail);
    }

    public List<Lecturers> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public Optional<Lecturers> getLecturerById(int lecturerId) {
        return lecturerRepository.findById(lecturerId);
    }

    public Lecturers saveLecturer(Lecturers lecturers) {
        return lecturerRepository.save(lecturers);
    }

    public void deleteLecturer(int lecturerId) {
        lecturerRepository.deleteById(lecturerId);
    }

    public long countLecturers() {
        return lecturerRepository.count();
    }

    //update lecturer
    public Lecturers updateLecturer(Lecturers updateLecturer) {
        Optional<Lecturers> optionalLecturers = lecturerRepository.findById(updateLecturer.getLecturerId());
        if (optionalLecturers.isPresent()) {
            Lecturers existingLecturer = optionalLecturers.get();
            // Update only the fields that are not null in updatedCourse
            if (updateLecturer.getLecturerName() != null) {
                existingLecturer.setLecturerName(updateLecturer.getLecturerName());
            }
            if (updateLecturer.getLecturerEmail() != null) {
                existingLecturer.setLecturerEmail(updateLecturer.getLecturerEmail());
            }
            if (updateLecturer.getLecturerPhone() != null) {
                existingLecturer.setLecturerPhone(updateLecturer.getLecturerPhone());
            }
            return lecturerRepository.save(existingLecturer);
        } else {
            return null;
        }
    }

}
