package com.typebdigital.hello_world_api.service;

import com.typebdigital.hello_world_api.model.ErrorResponse;
import com.typebdigital.hello_world_api.model.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class HelloWorldService {

    public ResponseEntity<?> process(String name) {

        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid Input"));
        }

        char first = Character.toLowerCase(name.trim().charAt(0));

        if (first >= 'a' && first <= 'm') {
            String formatted = name.substring(0,1).toUpperCase() + name.substring(1);

            return ResponseEntity.ok(
                    new SuccessResponse("Hello " + formatted)
            );
        }

        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Invalid Input"));
    }
}