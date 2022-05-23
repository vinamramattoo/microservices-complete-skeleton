package com.vinamra.microservices.complete.skeleton.exception;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {

    private List<Error> errors = new ArrayList<>();
}
