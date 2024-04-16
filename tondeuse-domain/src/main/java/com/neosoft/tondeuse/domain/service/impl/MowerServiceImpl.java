package com.neosoft.tondeuse.domain.service.impl;

import com.neosoft.tondeuse.domain.data.Mower;
import com.neosoft.tondeuse.domain.data.Position;
import com.neosoft.tondeuse.domain.service.MowerService;

public class MowerServiceImpl implements MowerService {

    @Override
    public Position executeInstructions(Mower mower) {
        Position position = mower.position();
        var commands = mower.instructions();

        for (var command : commands.toCharArray()) {
            position = switch (command) {
                case 'A' -> moveForward(position);
                case 'D' -> turnRight(position);
                case 'G' -> turnLeft(position);
                default -> position; // Keeps the position unchanged if the command is unrecognized
            };
        }
        return position;
    }

    @Override
    public Position moveForward(Position position) {
        return switch (position.orientation()) {
            case 'N' -> new Position(position.x(), position.y() + 1, position.orientation());
            case 'E' -> new Position(position.x() + 1, position.y(), position.orientation());
            case 'S' -> new Position(position.x(), position.y() - 1, position.orientation());
            case 'W' -> new Position(position.x() - 1, position.y(), position.orientation());
            default -> position;
        };
    }

    @Override
    public Position turnRight(Position position) {
        return switch (position.orientation()) {
            case 'N' -> new Position(position.x(), position.y(), 'E');
            case 'E' -> new Position(position.x(), position.y(), 'S');
            case 'S' -> new Position(position.x(), position.y(), 'W');
            case 'W' -> new Position(position.x(), position.y(), 'N');
            default -> position;
        };
    }

    @Override
    public Position turnLeft(Position position) {
        return switch (position.orientation()) {
            case 'N' -> new Position(position.x(), position.y(), 'W');
            case 'W' -> new Position(position.x(), position.y(), 'S');
            case 'S' -> new Position(position.x(), position.y(), 'E');
            case 'E' -> new Position(position.x(), position.y(), 'N');
            default -> position;
        };
    }
}