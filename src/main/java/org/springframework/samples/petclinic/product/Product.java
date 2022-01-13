package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Length(min = 3, max = 50)
    String name;

    @PositiveOrZero
    Double price;

    @ManyToOne
    ProductType productType;
}
