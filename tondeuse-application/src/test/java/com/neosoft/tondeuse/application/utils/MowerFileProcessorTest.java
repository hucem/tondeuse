package com.neosoft.tondeuse.application.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.neosoft.tondeuse.domain.data.Mower;
import com.neosoft.tondeuse.domain.data.Position;
import com.neosoft.tondeuse.domain.service.MowerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MowerFileProcessorTest {

    @Mock
    private MowerService mowerService;

    @InjectMocks
    private MowerFileProcessor fileProcessor;

    @Test
    void processMowerInstructions_ShouldReturnPositions_WhenValidInput() throws Exception {
        // Arrange
        String content = "1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", content.getBytes());
        when(mowerService.executeInstructions(new Mower(new Position(1, 2, 'N'), "GAGAGAGAA")))
                .thenReturn(new Position(1, 3, 'N')); // Supposed final position after instructions
        when(mowerService.executeInstructions(new Mower(new Position(3, 3, 'E'), "AADAADADDA")))
                .thenReturn(new Position(5, 1, 'E')); // Supposed final position after instructions

        // Act
        List<Position> positions = fileProcessor.processMowerInstructions(file);

        // Assert
        assertEquals(2, positions.size());
        assertEquals(new Position(1, 3, 'N'), positions.get(0));
        assertEquals(new Position(5, 1, 'E'), positions.get(1));
    }
}
