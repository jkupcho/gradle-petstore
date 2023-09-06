package com.jkupcho.petstore.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PetTests {

    @Autowired PetRepository repository;

    @Test
    void shouldSave() {
        var pet = new Pet();
        pet.setAge(10);
        pet.setName("charcoal");

        var savedPet = this.repository.save(pet);

        assertEquals(1, savedPet.getId());
    }
}
