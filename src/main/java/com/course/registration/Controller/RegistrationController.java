package com.course.registration.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.registration.DTO.RegistrationDTO;
import com.course.registration.Repository.RegistrationRepository;
import com.course.registration.Service.EmailService;
import com.course.registration.entity.Registration;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private EmailService emailService;
    

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationDTO dto) {
        Optional<Registration> existing = repo.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already registered");
        }

        Registration r = new Registration();
        r.setName(dto.getName());
        r.setCollege(dto.getCollege());
        r.setContact(dto.getContact());
        r.setEmail(dto.getEmail());            // set email
        r.setCourses(String.join(",", dto.getCourses()));
        r.setTiming(dto.getTiming());

        repo.save(r);

        emailService.sendMail(dto.getEmail(), dto.getName(), dto.getCollege(), dto.getContact(), dto.getCourses(), dto.getTiming());

        return ResponseEntity.ok("Registered successfully");
    }
    
    @GetMapping("/registrations")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> list = repo.findAll();
        return ResponseEntity.ok(list);
    }
}