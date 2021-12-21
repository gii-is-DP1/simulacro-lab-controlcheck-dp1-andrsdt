package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_types") // TODO check needed?
public class ProductType {
    @Id // TODO check correct import
    Integer id;

    @NotNull // TODO check redundant
    @Length(min = 3, max = 50)

    @Column(unique = true)
    String name;
}
