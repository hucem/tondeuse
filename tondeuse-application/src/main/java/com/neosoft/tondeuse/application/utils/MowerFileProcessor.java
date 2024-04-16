package com.neosoft.tondeuse.application.utils;

import com.neosoft.tondeuse.domain.data.Mower;
import com.neosoft.tondeuse.domain.data.Position;
import com.neosoft.tondeuse.domain.service.MowerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MowerFileProcessor {

    private final MowerService mowerService;

    public MowerFileProcessor(MowerService mowerService) {
        this.mowerService = mowerService;
    }

    public List<Position> processMowerInstructions(MultipartFile file) throws IOException {
        List<Position> finalPositions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] positionParts = line.split("\\s+");
                if (positionParts.length < 3) continue;
                String instructions = reader.readLine();
                if (instructions == null) break;

                int x = Integer.parseInt(positionParts[0]);
                int y = Integer.parseInt(positionParts[1]);
                char orientation = positionParts[2].charAt(0);

                Position position = new Position(x, y, orientation);
                Mower mower = new Mower(position, instructions);
                Position finalPosition = mowerService.executeInstructions(mower);
                finalPositions.add(finalPosition);
            }
        }
        return finalPositions;
    }
}