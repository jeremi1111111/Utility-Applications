package com.lab9.Student;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.lab9.SiteController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentModelAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {
    @Override
    public EntityModel<Student> toModel(Student student) {
        return EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(methodOn(SiteController.class).getStudent(student.getStudentId())).withSelfRel(),
                linkTo(methodOn(SiteController.class).getAllStudents()).withRel("students"));
    }
}
