package org.isk.collections.sorting;

/**
 * @author Yohan Beschi
 */
public class Person {

    private final String firstName;
    private final String lastName;

    public Person() {
        this.firstName = "";
        this.lastName = "";
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static int staticNaturalSort(final Person p1, final Person p2) {
        final String lastName1 = p1.getLastName();
        final String lastName2 = p2.getLastName();

        if (lastName1.equals(lastName2)) {
            return p1.getFirstName().compareTo(p2.getFirstName());
        } else {
            return lastName1.compareTo(lastName2);
        }
    }
    
    public int sortByLastName(final Person p2) {
        return this.getLastName().compareTo(p2.getLastName());
    }

    public int sortByFirstName(final Person p1, final Person p2) {
        return p1.getFirstName().compareTo(p2.getFirstName());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;

        return true;
    }
}
