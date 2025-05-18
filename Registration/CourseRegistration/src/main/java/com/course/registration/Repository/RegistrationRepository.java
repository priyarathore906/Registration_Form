package com.course.registration.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.course.registration.entity.Registration;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	 Optional<Registration> findByEmail(String email);
}