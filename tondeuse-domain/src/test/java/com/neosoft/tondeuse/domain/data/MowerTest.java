package com.neosoft.tondeuse.domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void testMowerRecord() {
        Position position = new Position(5, 10, 'N');
        String instructions = "AADAADADDA";
        Mower mower = new Mower(position, instructions);
        assertEquals(position, mower.position(), "Position should match the constructor argument.");
        assertEquals(instructions, mower.instructions(), "Instructions should match the constructor argument.");

        testRecordEqualsAndHashCode();
        testRecordToString();
    }

    void testRecordEqualsAndHashCode() {
        Position position1 = new Position(5, 10, 'N');
        Position position2 = new Position(5, 10, 'N');
        Mower mower1 = new Mower(position1, "AADAADADDA");
        Mower mower2 = new Mower(position2, "AADAADADDA");
        assertEquals(mower1, mower2, "Mowers with same data should be equal.");
        assertEquals(mower1.hashCode(), mower2.hashCode(), "Hashcodes should match for equal mowers.");
    }

    void testRecordToString() {
        Position position = new Position(5, 10, 'N');
        Mower mower = new Mower(position, "AADAADADDA");
        String expectedToString = "Mower[position=Position[x=5, y=10, orientation=N], instructions=AADAADADDA]";
        assertEquals(expectedToString, mower.toString(), "ToString should return a correctly formatted string.");
    }
}
