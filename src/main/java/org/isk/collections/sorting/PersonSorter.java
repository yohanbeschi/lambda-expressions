package org.isk.collections.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.functions.Mapper;

/**
 * This class contains different ways of sorting collections.
 * @author Yohan Beschi
 */
public class PersonSorter {

	/**
	 * Comparator defined as an anonymous class.
	 */
    public final static Comparator<Person> NATURAL_SORT = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            final String lastName1 = p1.getLastName();
            final String lastName2 = p2.getLastName();

            if (lastName1.equals(lastName2)) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            } else {
                return lastName1.compareTo(lastName2);
            }
        }
    };

    /**
     * {@link Mapper} defined by a method reference {@link Person#getFirstName()}.
     */
    public final static Mapper<String, Person> MAPPER_BY_FIRSTNAME;

    static {
        MAPPER_BY_FIRSTNAME = Person::getFirstName;
    }

    /**
     * Natural sorting using a lambda expression instead of a {@link Comparator}.
     * @param list the list to sort.
     */
    public static void naturalSortUsingLambda(final List<Person> list) {
        Collections.sort(list, (p1, p2) -> {
            final String lastName1 = p1.getLastName();
            final String lastName2 = p2.getLastName();

            if (lastName1.equals(lastName2)) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            } else {
                return lastName1.compareTo(lastName2);
            }
        });
    }
    
    /**
     * Natural sorting using a method reference of a static method.
     * @param list the list to sort.
     */
    public static void naturalSortUsingStatic(final List<Person> list) {
        Collections.sort(list, Person::staticNaturalSort);
    }

    /**
     * Sorting by last names, using a method reference of an instance method 
     * of an arbitrary object of a particular type ({@link Person} is this case).
     * @param list
     */
    public static void sortByLastNameUsingNoneStatic(final List<Person> list) {
        Collections.sort(list, Person::sortByLastName);
    }

    /**
     * Sorting by first names, using a method reference an instance method 
     * of a particular object ({@link Person} is this case).
     * @param list the list to sort.
     */
    public static void sortByFirstNameUsingInstance(final List<Person> list) {
        Collections.sort(list, new Person()::sortByFirstName);
    }

    /**
     * Sorting by first names, using the method {@link PersonSorter#comparing(java.util.functions.Mapper)} with a lambda expression.
     * @param list the list to sort.
     */
    public static void sortByFirstNameUsingComparingAndLambda(final List<Person> list) {
        Collections.sort(list, PersonSorter.comparing((Person p) -> p.getFirstName()));
    }

    /**
     * Sorting by first names, using the method {@link PersonSorter#comparing(java.util.functions.Mapper)} with a method reference 
     * of an instance method of an arbitrary object of a particular type ({@link Person} is this case).
     * @param list the list to sort.
     */
    public static void sortByFirstNameUsingComparingAndReference(final List<Person> list) {
        Collections.sort(list, PersonSorter.comparing((Mapper<String, Person>)Person::getFirstName));
    }

    /**
     * Sorting by first names, using the {@link List#sort(java.util.Comparator)} method 
     * and the method {@link PersonSorter#comparing(java.util.functions.Mapper)} with a method reference 
     * of an instance method of an arbitrary object of a particular type ({@link Person} is this case).
     * @param list the list to sort.
     */
    public static void sortByFirstNameUsingListSort(final List<Person> list) {
        list.sort(PersonSorter.comparing((Mapper<String, Person>)Person::getFirstName));
    }

    /**
     * Compare two fields of two objects.
     * @param mapper the mapping between the input object and the field to be compared.
     * @param <T> the Input type.
     * @param <R> the Return type.
     * @return the result of the comparison.
     */
    public static <T, R extends Comparable<? super R>> Comparator<T> comparing(Mapper<R, T> mapper) {
        return (x, y) -> mapper.map(x).compareTo(mapper.map(y));
    }
}
