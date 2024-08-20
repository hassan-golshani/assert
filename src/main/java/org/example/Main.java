package org.example;

import org.example.model.Person;
import org.example.validator.PersonValidator;

public class Main {

    private static final PersonValidator PERSON_VALIDATOR = new PersonValidator();

    public static void main(String[] args) {
        Person person = new Person();
        //set your data
        PERSON_VALIDATOR.validate2(person);
        PERSON_VALIDATOR.validate(person);
    }
}