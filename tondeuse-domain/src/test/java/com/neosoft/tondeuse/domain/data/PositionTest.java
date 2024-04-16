package com.neosoft.tondeuse.domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testPositionProperties() {
        int x = 5;
        int y = 10;
        char orientation = 'N';
        Position position = new Position(x, y, orientation);
        assertEquals(x, position.x(), "X coordinate should match the constructor argument.");
        assertEquals(y, position.y(), "Y coordinate should match the constructor argument.");
        assertEquals(orientation, position.orientation(), "Orientation should match the constructor argument.");
    }

    @Test
    void testEqualsAndHashCode() {
        Position position1 = new Position(5, 10, 'N');
        Position position2 = new Position(5, 10, 'N');
        assertEquals(position1, position2, "Two positions with the same data should be considered equal.");
        assertEquals(position1.hashCode(), position2.hashCode(), "Hash codes should match for equal objects.");
    }

    @Test
    void testToString() {
        Position position = new Position(5, 10, 'N');
        String expectedToString = "Position[x=5, y=10, orientation=N]";
        assertEquals(expectedToString, position.toString(), "ToString should return a correctly formatted string.");
    }
}