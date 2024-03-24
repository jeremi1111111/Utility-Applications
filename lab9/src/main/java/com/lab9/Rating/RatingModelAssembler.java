package com.lab9.Rating;

import com.lab9.SiteController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RatingModelAssembler implements RepresentationModelAssembler<Rating, EntityModel<Rating>> {
    @Override
    public EntityModel<Rating> toModel(Rating rating) {
        return EntityModel.of(rating,
                WebMvcLinkBuilder.linkTo(methodOn(SiteController.class).getStudent(rating.getRatingId())).withSelfRel());
    }
}
