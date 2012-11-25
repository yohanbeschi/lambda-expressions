package org.isk.generics;

/**
 * @author Yohan Beschi
 */
public interface GenericsLambdaWithEllipse<T, R> {
    R doSomething(T ... t);
}
