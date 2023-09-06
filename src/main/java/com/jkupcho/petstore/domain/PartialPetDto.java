package com.jkupcho.petstore.domain;

import java.io.Serializable;

/**
 * DTO for {@link Pet}
 */
public record PartialPetDto(String name, Integer age) implements Serializable {

    public Pet toPet() {
        var pet = new Pet();
        pet.setName(this.name);
        pet.setAge(this.age);
        return pet;
    }

}