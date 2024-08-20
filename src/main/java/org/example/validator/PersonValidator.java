package org.example.validator;

import org.example.exception.*;
import org.example.model.Person;
import org.example.utils.Assert;

import java.time.LocalDateTime;

public class PersonValidator {

    public void validate2(Person person) {
        if (person.getName() == null || person.getName().isEmpty())
            throw new InvalidNameException();

        if (person.getSurname() == null || person.getSurname().isEmpty())
            throw new InvalidSurnameException();

        if (person.getSurname().equals(person.getName()))
            throw new InvalidFullNameException();

        if (person.getAge() == null)
            throw new InvalidAgeException();

        if (person.getAge() < 0)
            throw new InvalidAgeException();

        if (person.getAge() > 100)
            throw new InvalidAgeException();

        if (!person.isAgreementAccepted())
            throw new AgreementIsNotAcceptedException();

        if (!person.getBirthdate().isBefore(LocalDateTime.now()))
            throw new InvalidBirthdateException();
    }

    public void validate(Person person) {
        Assert.notBlank(person.getName(), InvalidNameException::new);
        Assert.notBlank(person.getSurname(), InvalidSurnameException::new);
        Assert.notEquals(person.getName(), person.getSurname(), InvalidFullNameException::new);
        Assert.notNull(person.getAge(), InvalidAgeException::new);
        Assert.isGreater(person.getAge(), 0, InvalidAgeException::new);
        Assert.isLess(person.getAge(), 100, InvalidAgeException::new);
        Assert.isTrue(person.isAgreementAccepted(), AgreementIsNotAcceptedException::new);
        Assert.isBefore(person.getBirthdate(), LocalDateTime.now(), InvalidBirthdateException::new);
    }
}
