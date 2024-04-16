package com.neosoft.tondeuse.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.neosoft.tondeuse.domain.data.Mower;
import com.neosoft.tondeuse.domain.data.Position;
import com.neosoft.tondeuse.domain.service.impl.MowerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MowerServiceTest {

    private MowerService mowerService;

    @Mock
    private Mower mower;

    @BeforeEach
    void setUp() {
        mowerService = new MowerServiceImpl();
    }

    @Test
    void testExecuteInstructions() {
        Position startPosition = new Position(0, 1, 'N');
        Position expectedPosition = new Position(0, 2, 'N');
        when(mower.position()).thenReturn(startPosition);
        when(mower.instructions()).thenReturn("A");
        Position result = mowerService.executeInstructions(mower);

        assertEquals(expectedPosition, result);
        verify(mower).position();
        verify(mower).instructions();
    }

    @Test
    void testMoveForward() {
        Position initial = new Position(0, 0, 'N');
        Position expected = new Position(0, 1, 'N');
        assertEquals(expected, mowerService.moveForward(initial));
    }

    @Test
    void testTurnRight() {
        Position initial = new Position(0, 0, 'N');
        Position expected = new Position(0, 0, 'E');
        assertEquals(expected.orientation(), mowerService.turnRight(initial).orientation());
    }

    @Test
    void testTurnLeft() {
        Position initial = new Position(0, 0, 'N');
        Position expected = new Position(0, 0, 'W');
        assertEquals(expected.orientation(), mowerService.turnLeft(initial).orientation());
    }
}
