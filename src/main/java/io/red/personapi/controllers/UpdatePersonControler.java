package io.red.personapi.controllers;

import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.services.UpdatePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
public class UpdatePersonControler {

    private final UpdatePersonService service;

    public UpdatePersonControler(UpdatePersonService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updatePerson(@RequestBody PersonRequest request,
                                               @PathVariable(name = "id") Long id){
        service.updatePerson(request, id);
        return ResponseEntity.ok("Person updated");
    }
}
