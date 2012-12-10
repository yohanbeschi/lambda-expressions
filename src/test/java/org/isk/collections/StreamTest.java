package org.isk.collections;

import junit.framework.Assert;
import org.isk.collections.stream.Shape;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicates;

/**
 * @author Yohan Beschi
 */
public class StreamTest {
    private List<Shape> shapes = new ArrayList<>();

    @Before
    public void setUp() {
        this.shapes.add(new Shape(Color.BLACK, Shape.ShapeNameEnum.CIRCLE, 1));
        this.shapes.add(new Shape(Color.RED, Shape.ShapeNameEnum.TRIANGLE, 2));
        this.shapes.add(new Shape(Color.BLUE, Shape.ShapeNameEnum.SQUARE, 3));
        this.shapes.add(new Shape(Color.YELLOW, Shape.ShapeNameEnum.TRIANGLE, 4));
    }

    @After
    public void tearDown() {
        this.shapes.clear();
    }

    /**
     * Each shape will become green using {@link java.util.Iterator#forEach(java.util.function.Block)}
     */
    @Test
    public void looping() {
        this.shapes.forEach(e -> e.setColor(Color.GREEN));

        this.shapes.forEach(e -> Assert.assertEquals(Color.GREEN, e.getColor()));
    }

    /**
     * Each blue shape will become green using {@link java.util.stream.Stream#filter(java.util.function.Predicate)} 
     * and {@link java.util.stream.Stream#forEach(java.util.function.Block)}
     */
    @Test
    public void filtering() {
        this.shapes.stream()
                .filter(e -> e.getColor() == Color.BLUE)
                .forEach(e -> e.setColor(Color.GREEN));

        Assert.assertEquals(Color.BLACK, this.shapes.get(0).getColor());
        Assert.assertEquals(Color.RED, this.shapes.get(1).getColor());
        Assert.assertEquals(Color.GREEN, this.shapes.get(2).getColor());
        Assert.assertEquals(Color.YELLOW, this.shapes.get(3).getColor());
    }

    /**
     * Each Red triangle will become green using {@link java.util.stream.Stream#filter(java.util.function.Predicate)} twice
     * and {@link java.util.stream.Stream#forEach(java.util.function.Block)}
     */
    @Test
    public void multiFiltering() {
        this.shapes.stream()
                .filter(e -> e.getShapeName() == Shape.ShapeNameEnum.TRIANGLE)
                .filter(e -> e.getColor() == Color.RED)
                .forEach(e -> e.setColor(Color.GREEN));

        Assert.assertEquals(Color.BLACK, this.shapes.get(0).getColor());
        Assert.assertEquals(Color.GREEN, this.shapes.get(1).getColor());
        Assert.assertEquals(Color.BLUE, this.shapes.get(2).getColor());
        Assert.assertEquals(Color.YELLOW, this.shapes.get(3).getColor());
    }

    /**
     * Create an {@link ArrayList} of triangles using {@link java.util.stream.Stream#filter(java.util.function.Predicate)}
     * and {@link java.util.stream.Stream#into(java.util.stream.Stream.Destination)}
     */
    @Test
     public void sublist() {
        final List<Shape> triangles = this.shapes.stream()
                .filter(e -> e.getShapeName() == Shape.ShapeNameEnum.TRIANGLE)
                .into(new ArrayList<Shape>());

        Assert.assertEquals(2, triangles.size());
        triangles.forEach(e -> Assert.assertEquals(Shape.ShapeNameEnum.TRIANGLE, e.getShapeName()));
    }

    /**
     * Create a {@link HashSet} of colors each shapes using {@link java.util.stream.Stream#map(java.util.function.Function)}
     * and {@link java.util.stream.Stream#into(java.util.stream.Stream.Destination)}
     */
    @Test
    public void mapping() {
        final Set<Shape.ShapeNameEnum> shapeNames = this.shapes.stream()
                .map(e -> e.getShapeName())
                .into(new HashSet<Shape.ShapeNameEnum>());

        Assert.assertEquals(3, shapeNames.size());
    }

    /**
     * Create a sorted {@link HashSet} of shape's name of each shape using {@link java.util.stream.Stream#map(java.util.function.Function)},
     * {@link java.util.stream.Stream#sorted(java.util.Comparator)} and {@link java.util.stream.Stream#into(java.util.stream.Stream.Destination)}.
     */
    @Test
     public void mappingSorted() {
        final Set<Shape.ShapeNameEnum> shapeNames = this.shapes.stream()
                .map(e -> e.getShapeName())
                .sorted(Shape.ShapeNameEnum::compareTo)
                .into(new TreeSet<Shape.ShapeNameEnum>());

        Assert.assertEquals(3, shapeNames.size());
        final Iterator<Shape.ShapeNameEnum> iterator = shapeNames.iterator();
        Assert.assertEquals(Shape.ShapeNameEnum.CIRCLE, iterator.next());
        Assert.assertEquals(Shape.ShapeNameEnum.SQUARE, iterator.next());
        Assert.assertEquals(Shape.ShapeNameEnum.TRIANGLE, iterator.next());
    }

    /**
     * Add the weigh of each shape using {@link java.util.stream.Stream#map(java.util.function.Function)},
     * and {@link java.util.stream.Stream#reduce(Object, java.util.function.BinaryOperator)}.
     */
    @Test
    public void accumulator() {
        final int sum = this.shapes.stream()
                                   .map(e -> e.getWeight())
                                   .reduce(0, (x, y) -> x + y);

        Assert.assertEquals(10, sum);
    }

    /**
     * Return a default value if the list is empty using {@link java.util.stream.Stream#reduce(Object, java.util.function.BinaryOperator)}
     */
    @Test
    public void emptyAccumulator() {
        final int sum = new ArrayList<Integer>().stream()
                .reduce(100, (x, y) -> x + y);

        Assert.assertEquals(100, sum);
    }

    /**
     * Create an {@link ArrayList} of shapes having a weight equals to 1 or 4.
     */
    @Test
    public void predicates() {
        final List<Shape> shapes = this.shapes.stream()
                .filter(Predicates.or((Shape e) -> e.getWeight() == 1, (Shape e) -> e.getWeight() == 4))
                .into(new ArrayList<Shape>());

        Assert.assertEquals(2, shapes.size());
    }
}
