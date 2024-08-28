package functional.programming.beans;

import functional.programming.types.Gender;

public class Person {
    String name;
    Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public boolean isFemale() {
        return Gender.FEMALE.equals(this.gender);
    }

    public boolean isMale() {
        return Gender.MALE.equals(this.gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
