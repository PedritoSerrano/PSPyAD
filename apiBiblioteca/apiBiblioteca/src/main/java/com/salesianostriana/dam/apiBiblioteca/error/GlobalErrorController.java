package com.salesianostriana.dam.apiBiblioteca.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LibraryNotFoundException.class)

}
