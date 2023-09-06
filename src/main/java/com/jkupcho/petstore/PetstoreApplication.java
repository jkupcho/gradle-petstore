package com.jkupcho.petstore;

import com.jkupcho.petstore.domain.CreatePetDto;
import com.jkupcho.petstore.domain.Pet;
import com.jkupcho.petstore.domain.PetRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class PetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstoreApplication.class, args);
    }

    @RestController
    @RequestMapping("/api/pets")
    static class PetController {

        private final PetRepository repository;

        @Autowired
        public PetController(PetRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public Page<Pet> getAll(PageCriteria page) {
            return this.repository.findAll(page.toPageable());
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void create(@RequestBody CreatePetDto pet) {
            this.repository.save(pet.toPet());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Pet> get(@PathVariable("id") Long id) {
            var petOpt = this.repository.findById(id);
            return petOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable("id") Long id) {
            this.repository.deleteById(id);
        }

    }

    record PageCriteria(Integer limit, Integer page) {

        Pageable toPageable() {
            return PageRequest.of(page == null ? 0 : page , limit == null ? 25 : limit);
        }
    }
}