package vdcomtest.foobar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFooBarBuilderTests {
    @Test
    public void builder1Test(){
        String[] expected = {"1", "2", "Foo", "4", "Bar", "Foo", "7", "8", "Foo", "Bar", "11", "Foo", "13", "14", "FooBar"};
        String[] actual = ArrayFooBarBuilder.build1(15);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void builder2Test(){
        String[] expected = {"1", "2", "Foo", "4", "Bar", "Foo", "7", "8", "Foo", "Bar", "11", "Foo", "13", "14", "FooBar"};
        String[] actual = ArrayFooBarBuilder.build2(15);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void builder3Test(){
        String[] expected = {"1", "2", "Foo", "4", "Bar", "Foo", "7", "8", "Foo", "Bar", "11", "Foo", "13", "14", "FooBar"};
        String[] actual = ArrayFooBarBuilder.build3(15);
        Assertions.assertArrayEquals(expected, actual);
    }

}
