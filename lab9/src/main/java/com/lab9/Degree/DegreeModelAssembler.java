package com.lab9.Degree;

import com.lab9.SiteController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DegreeModelAssembler implements RepresentationModelAssembler<Degree, EntityModel<Degree>> {
    @Override
    public EntityModel<Degree> toModel(Degree degree) {
        return EntityModel.of(degree,
                WebMvcLinkBuilder.linkTo(methodOn(SiteController.class).getStudent(degree.getDegreeId())).withSelfRel());
    }
}
