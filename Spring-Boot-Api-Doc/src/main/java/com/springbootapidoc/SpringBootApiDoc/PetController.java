package com.springbootapidoc.SpringBootApiDoc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("pets")
@Api(value = "PetController")
public class PetController {
    private List<Pet> pets = new ArrayList<>();

    @PostConstruct
    public void init(){
        pets.add(new Pet(1, "Dog", new Date()));
        pets.add(new Pet(2, "Cat", new Date()));
        pets.add(new Pet(3, "Bird", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Add pet", notes = "Add pet to the list")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "hayvan") Pet pet) {
        pets.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Get all pets", notes = "Get all pets from the list")
    public ResponseEntity<List<Pet>> getList() {
        return ResponseEntity.ok(pets);
    }
}
