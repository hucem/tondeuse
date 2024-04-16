package com.neosoft.tondeuse.application.controller;

import com.neosoft.tondeuse.application.utils.MowerFileProcessor;
import com.neosoft.tondeuse.domain.data.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/mowers")
public class MowerController {

    @Autowired
    private MowerFileProcessor fileProcessor;

    @PostMapping("/execute")
    public ResponseEntity<?> executeMower(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        try {
            List<Position> finalPositions = fileProcessor.processMowerInstructions(file);
            return ResponseEntity.ok(finalPositions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to process file: " + e.getMessage());
        }
    }

}