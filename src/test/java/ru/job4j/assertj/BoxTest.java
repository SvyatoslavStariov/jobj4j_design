package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void testNumberOfVerticesEqualsMenusOne() {
        Box box = new Box(12, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isNotZero()
                .isOdd()
                .isInstanceOf(Integer.class)
                .isLessThan(0)
                .isGreaterThan(-2)
                .isEqualTo(-1);
    }

    @Test
    void testNumberOfVerticesNonEqualsMenusOne() {
        Box box = new Box(12, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isNotZero()
                .isOdd()
                .isInstanceOf(Integer.class)
                .isLessThan(0)
                .isGreaterThan(-2)
                .isNotEqualTo(12);
    }

    @Test
    void testExistIsFalse() {
        Box box = new Box(12, 10);
        boolean exist = box.isExist();
        assertThat(exist)
                .isFalse()
                .isInstanceOf(Boolean.class);
    }

    @Test
    void testExistIsTrue() {
        Box box = new Box(0, 10);
        boolean exist = box.isExist();
        assertThat(exist)
                .isTrue()
                .isInstanceOf(Boolean.class);
    }

    @Test
    void testAreaEqualsSixHundred() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area)
                .isInstanceOf(Double.class)
                .isEqualTo(600d, withPrecision(0.006d))
                .isCloseTo(600d, withPrecision(0.01d))
                .isCloseTo(600d, Percentage.withPercentage(1.0d))
                .isGreaterThan(599d)
                .isLessThan(601d);
    }

    @Test
    void testAreaEqualsOneHundredSeventyThree() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area)
                .isInstanceOf(Double.class)
                .isEqualTo(173.2d, withPrecision(0.6d))
                .isCloseTo(173.2d, withPrecision(0.01d))
                .isCloseTo(173.2d, Percentage.withPercentage(1.0d))
                .isGreaterThan(172d)
                .isLessThan(174d);
    }
}