package com.lab9.Subject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.lab9.SiteController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class SubjectModelAssembler implements RepresentationModelAssembler<Subject, EntityModel<Subject>> {
    @Override
    public EntityModel<Subject> toModel(Subject subject) {
        return EntityModel.of(subject,
                WebMvcLinkBuilder.linkTo(methodOn(SiteController.class).getSubject(subject.getSubjectId())).withSelfRel(),
                linkTo(methodOn(SiteController.class).getAllSubjects()).withRel("subjects"));
    }
}
