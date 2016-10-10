/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command.commands;

import static com.mycompany.robotmove.constants.RobotConstants.*;
import com.mycompany.robotmove.controller.command.Command;
import com.mycompany.robotmove.model.entities.enumeration.DirectionEnum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MoveCommand
 * @author Zakhar
 */
public class MoveCommand implements Command{
    private Pattern moveNumberPattern = Pattern.compile(MOVE_NUMBER_REG);
    private Pattern dirPattern = Pattern.compile(DIR_COMMAND_REG);
    private DirectionEnum dirEnum;
    private Integer distance;
    private String outputStr;

    @Override
    public String execute(String commandStr) {
        initDirDistance(commandStr);
        if (dirEnum == null){
            robot.moveToward(distance);
        } else if (distance == null){
            robot.moveToward(dirEnum);
        } else {
            robot.moveToward(distance, dirEnum);
        }
        outputStr = robot.getCoordinateX().toString().concat(SEPARATOR).concat(robot.getCoordinateY()
                .toString()).concat(SEPARATOR).concat(robot.getDirection().toString());
        distance = null;
        dirEnum = null;
        return outputStr;
    }

    /**
     * parses inputed command line and sets values (dir and distance) 
     * @param commandStr - inputed string
     * @throws NumberFormatException 
     */
    private void initDirDistance(String commandStr) throws NumberFormatException {
        Matcher matcherMoveNumber = moveNumberPattern.matcher(commandStr.trim());
        while (matcherMoveNumber.find()) {
            distance = Integer.parseInt(matcherMoveNumber.group());
        }
        Matcher matcherDir = dirPattern.matcher(commandStr.trim());
        while (matcherDir.find()) {
            dirEnum = DirectionEnum.valueOf(matcherDir.group().toUpperCase());
        }
    }
    
}
