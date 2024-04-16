package com.neosoft.tondeuse.application.controller;

import com.neosoft.tondeuse.application.utils.MowerFileProcessor;
import com.neosoft.tondeuse.domain.data.Position;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith(MockitoExtension.class)
public class MowerControllerTest {

    @Mock
    private MowerFileProcessor fileProcessor;

    @InjectMocks
    private MowerController controller;

    private MockMvc mockMvc;

    @Test
    void executeMower_ShouldReturnPositions_WhenValidFile() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", "1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA".getBytes());
        when(fileProcessor.processMowerInstructions(any()))
                .thenReturn(List.of(new Position(1, 3, 'N'), new Position(5, 1, 'E')));

        mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(multipart("/mowers/execute").file(file).contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"x\":1,\"y\":3,\"orientation\":\"N\"},{\"x\":5,\"y\":1,\"orientation\":\"E\"}]"));
    }

    @Test
    void executeMower_ShouldReturnBadRequest_WhenEmptyFile() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", new byte[0]);
        mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(multipart("/mowers/execute").file(file).contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("File is empty"));
    }
}