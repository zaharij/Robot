/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.constants;

import com.mycompany.robotmove.controller.command.Command;
import com.mycompany.robotmove.controller.command.commands.*;
import static com.mycompany.robotmove.model.entities.enumeration.DirectionEnum.*;
import com.mycompany.robotmove.model.entities.enumeration.*;
import static com.mycompany.robotmove.model.entities.enumeration.TurnEnum.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zakhar
 */
public class RobotConstants {
    public final static String COMMAND_REG = "^[a-zA-Z\\s.]+[^:]";
    public final static String MOVE_NUMBER_REG = "\\d+";
    public final static String DIR_COMMAND_REG = "(?<=\\s)[a-zA-Z]+";
    
    public final static String NO_SUCH_COMMAND_MESSAGE = "No such command!";
    public final static String SEPARATOR = " | ";
    
    public final static ArrayList<DirectionEnum> DIRECTION_LIST = new ArrayList<DirectionEnum>()
    {{
        add(NORTH);
        add(EAST);
        add(SOUTH);
        add(WEST);
    }};
    
    public final static String END_COMMAND = "end";
    public final static String MOVE_COMMAND = "move";
    public final static String TURN_COMMAND = "turn";
    public final static String MAKE_PHOTO_COMMAND = "photo";
    public final static String START_VIDEO_COMMAND = "startvideo";
    public final static String STOP_VIDEO_COMMAND = "stopvideo";
    
    
    public final static Map<String, Command> COMMAND_MAP = new HashMap<String, Command>()//existing commands
    {{
        put(MOVE_COMMAND, new MoveCommand());
        put(TURN_COMMAND, new TurnCommand());
        put(MAKE_PHOTO_COMMAND, new MakePhotoCommand());
        put(START_VIDEO_COMMAND, new StartVideoCommand());
        put(STOP_VIDEO_COMMAND, new StopVideoCommand());
    }};
    
    public final static int INDEX_CORRECTION_NUMBER = 1;
    public final static int FIRST_ELEMENT = 0;
    public final static int DEFAULT_CORDINATE_NUMBER = 0;
    
    public final static DirectionEnum NORTH_ENUM = NORTH;
    public final static DirectionEnum SOUTH_ENUM = SOUTH;
    public final static DirectionEnum WEST_ENUM = WEST;
    public final static DirectionEnum EAST_ENUM = EAST;
    
    public final static TurnEnum LEFT_ENUM = LEFT;
    public final static TurnEnum RIGHT_ENUM = RIGHT;
    
    public final static long MILLISEC_TO_SEC_NUMBER = 60000;
    public final static long SECONDS_IN_MINUTE = 60;
}
