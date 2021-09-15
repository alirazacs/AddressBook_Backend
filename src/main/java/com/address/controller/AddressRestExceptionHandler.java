package com.address.controller;


import com.address.exception.AddressNotFoundException;
import com.address.model.AddressErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*this class purpose is to handle all exceptions globally no need to handle exception seperately for each REST service
just make use of @ControllerAdvice annotation */
@ControllerAdvice
public class AddressRestExceptionHandler {

    //    add an exception handler that will basically return our error response in json format
//    using @ExceptionHandler
//    this annoation gets called automatically by spring when exception occurs

//    for specific exception of type AddressNotFoundException
//    @ExceptionHandler
////    placing Exception instead of AddressNotFoundException in parameter
//    public ResponseEntity<AddressErrorResponse> handleException(AddressNotFoundException exception) {
//
////        create addressErrorResponse object
//        AddressErrorResponse error = new AddressErrorResponse();
////        writing HttpStatus.NOT_FOUND.value() handle only one type of exception either int or string...
//
////        error.setStatus(HttpStatus.NOT_FOUND.value());
//
////      lets catch all exceptions> just a little modification using BAD_REQUEST after HttpStatus
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exception.getMessage());
//        error.setTime(System.currentTimeMillis());
////error is the body in ResponseEntity object, and 2nd argu is status
////        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
////        modification done here...
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//
//    }
//for catching all types of exceptions
    @ExceptionHandler
//    placing Exception instead of AddressNotFoundException in parameter
    public ResponseEntity<AddressErrorResponse> handleException(Exception exception) {

//        create addressErrorResponse object
        AddressErrorResponse error = new AddressErrorResponse();
//        writing HttpStatus.NOT_FOUND.value() handle only one type of exception either int or string...

//        error.setStatus(HttpStatus.NOT_FOUND.value());

//      lets catch all exceptions> just a little modification using BAD_REQUEST after HttpStatus
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTime(System.currentTimeMillis());
//error is the body in ResponseEntity object, and 2nd argu is status
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

//        modification done here...

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }
}
