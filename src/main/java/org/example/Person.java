package org.example;

public class Person {
    protected final String name;
    protected final String lastname;
    protected int age = -1;
    protected String address;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public boolean hasAge(){
        boolean isKnown = false;
        if (this.age != -1){
            isKnown = true;
        }
        return isKnown;
    }

    public boolean hasAddress(){
        boolean isKnown = false;
        if (this.address != null){
            isKnown = true;
        }
        return isKnown;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday(){

    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

//    public PersonBuilder newChildBuilder(){
//
//    }
}
