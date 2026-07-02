package com.typebdigital.hello_world_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

@Service
public class HelloWorldService {
    public Object processName(String name){
        if (name == null || name.trim().isEmpty()){
            return error();
        }

        char first = Character.toLowerCase(name.trim().charAt(0));

        if (first >= 'a' && first <= 'm'){
            String formatted = name.substring(0,1).toUpperCase() + name.substring(1);
            return new SuccessResponse("Hello" + formatted);
        }

        return error();
    }

    private ErrorResponse error(){
        return new ErrorResponse("Invalid Input");

    }

    //Response class
    public record SuccessResponse(String message){}
    public record ErrorResponse(String error){}
}
