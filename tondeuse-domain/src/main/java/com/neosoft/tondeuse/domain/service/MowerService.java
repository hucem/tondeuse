package com.neosoft.tondeuse.domain.service;

import com.neosoft.tondeuse.domain.data.Mower;
import com.neosoft.tondeuse.domain.data.Position;

public interface MowerService {


    Position executeInstructions(Mower mower);

    Position moveForward(Position position);

    Position turnRight(Position position);

    Position turnLeft(Position position);
}
