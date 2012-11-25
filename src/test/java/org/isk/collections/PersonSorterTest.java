package org.isk.collections;

import junit.framework.Assert;
import org.isk.collections.sorting.Person;
import org.isk.collections.sorting.PersonSorter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yohan Beschi
 */
public class PersonSorterTest {
    private List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() {
        this.persons.add(new Person("Doug", "Lea"));
        this.persons.add(new Person("Joshua", "Bloch"));
        this.persons.add(new Person("Brian", "Goetz"));
        this.persons.add(new Person("Max", "Bloch"));
    }

    @After
    public void tearDown() {
        this.persons.clear();
    }

    @Test
    public void naturalSortUsingLambda() {
        PersonSorter.naturalSortUsingLambda(this.persons);

        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(0));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(1));
        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(2));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(3));
    }

    @Test
    public void naturalSortUsingStatic() {
        PersonSorter.naturalSortUsingStatic(this.persons);

        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(0));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(1));
        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(2));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(3));
    }

    @Test
    public void sortByLastNameUsingNoneStatic() {
        PersonSorter.sortByLastNameUsingNoneStatic(this.persons);

        Assert.assertEquals("Bloch", this.persons.get(0).getLastName());
        Assert.assertEquals("Bloch", this.persons.get(1).getLastName());
        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(2));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(3));
    }

    @Test
    public void sortByFirstNameUsingInstance() {
        PersonSorter.sortByFirstNameUsingInstance(this.persons);

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(0));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(1));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(2));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(3));
    }

    @Test
    public void sortByFirstNameUsingComparingAndLambda() {
        PersonSorter.sortByFirstNameUsingComparingAndLambda(this.persons);

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(0));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(1));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(2));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(3));
    }

    @Test
    public void sortByFirstNameUsingComparingAndReference() {
        PersonSorter.sortByFirstNameUsingComparingAndReference(this.persons);

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(0));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(1));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(2));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(3));
    }

    @Test
    public void sortByFirstNameUsingListSort() {
        PersonSorter.sortByFirstNameUsingListSort(this.persons);

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(0));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(1));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(2));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(3));
    }

    @Test
     public void sortByFirstNameUsingListSortWithConstant() {
        this.persons.sort(PersonSorter.comparing(PersonSorter.MAPPER_BY_FIRSTNAME));

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(0));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(1));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(2));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(3));
    }

    @Test
    public void sortByFirstNameUsingReverseSortWithConstant() {
        this.persons.sort(PersonSorter.comparing(PersonSorter.MAPPER_BY_FIRSTNAME).reverse());

        Assert.assertEquals(new Person("Brian", "Goetz"), this.persons.get(3));
        Assert.assertEquals(new Person("Doug", "Lea"), this.persons.get(2));
        Assert.assertEquals(new Person("Joshua", "Bloch"), this.persons.get(1));
        Assert.assertEquals(new Person("Max", "Bloch"), this.persons.get(0));
    }
}
