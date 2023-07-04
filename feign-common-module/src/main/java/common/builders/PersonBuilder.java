package common.builders;

import common.model.Person;

public final class PersonBuilder {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public static Person createPerson() {
        return new PersonBuilder().build();
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public Person build() {
        return new Person(firstName, middleName, lastName, age);
    }
}
