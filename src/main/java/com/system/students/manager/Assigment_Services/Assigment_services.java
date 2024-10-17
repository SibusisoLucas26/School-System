package com.system.students.manager.Assigment_Services;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.students.manager.model.Assignment;
import com.system.students.manager.repository.Assignment_repo;

import jakarta.annotation.PostConstruct;

@Service
public class Assigment_services implements Inter_Assignments {

    @Autowired
    private Assignment_repo assigmeent_repo;

    @Override
    public void update(Assignment assignment) {
        Optional<Assignment> assigOptional = assigmeent_repo.findById(
                assignment.getId());
        if (assigOptional.isPresent()) {
            assignment.setTitle(assignment.getTitle());
            assignment.setDescription(assignment.getDescription());
            assignment.setDueDate(assignment.getDueDate());
            // Update other fields as necessary
            assigmeent_repo.save(assignment);
        }
    }

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assigmeent_repo.save(assignment);
    }

    @Override
    public Optional<Assignment> findById(Long id) {
        return assigmeent_repo.findById(id);
    }

    @Override
    public List<Assignment> getAllAssign() {
        return assigmeent_repo.findAll();
    }

    @Override
    public void deleteAssign(Long id) {
        assigmeent_repo.deleteById(id);
    }

    @PostConstruct
    public void loadAssignmentsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Assignment>> typeReference = new TypeReference<List<Assignment>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/assignments.json");

        try {
            List<Assignment> assignments = objectMapper.readValue(inputStream, typeReference);
            assigmeent_repo.saveAll(assignments); // Save to the database
            System.out.println("Assignments saved to the database.");
        } catch (Exception e) {
            System.out.println("Unable to save assignments: " + e.getMessage());
        }
    }
}
