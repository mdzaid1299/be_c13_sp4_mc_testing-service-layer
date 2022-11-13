package com.example.demoMc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Music already exists")
public class MusicAlreadyExistException extends Exception{

}
