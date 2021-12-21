package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products") // TODO check needed?
public class Product {
    @Id
    Integer id;

    @NotNull // TODO redundant?
    @Length(min = 3, max = 50)
    String name;

    @NotNull // TODO redundant?
    @Min(0)
    double price;

    @ManyToOne
    ProductType productType;
}
