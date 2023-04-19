package org.example;

public class Person {
    protected final String name;
    protected final String lastname;
    protected int age;
    protected String address;

    private Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public PersonBuilder newChildBuilder(){
        PersonBuilder personBuilder = new PersonBuilder()
                .setLastname(this.lastname)
                .setAge(1)
                .setAddress(this.address);
        return personBuilder;
    }

    public boolean hasAge(){
        boolean isKnown = false;
        if (this.age != 0){
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
        age++;
        System.out.println("Happy Birthday! You are " + age + " now!");
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

    public static class PersonBuilder {
        protected String name;
        protected String lastname;
        protected int age;
        protected String address;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public PersonBuilder setAge(int age) throws IllegalArgumentException{
            if (age < 0){
                throw new IllegalArgumentException("Некорректно указан возраст!");
            }
            this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() throws IllegalStateException {
            if (this.name == null || this.lastname == null) {
                throw new IllegalStateException("В конструктор класса Person переданы не все обязательные параметры! " +
                        "('name' и lastname')");
            }
            Person person = new Person(this.name, this.lastname);
            person.age = this.age;
            person.address = this.address;

            return person;
        }
    }
}
