/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command.commands;

import static com.mycompany.robotmove.constants.RobotConstants.DIR_COMMAND_REG;
import static com.mycompany.robotmove.constants.RobotConstants.SEPARATOR;
import com.mycompany.robotmove.controller.command.Command;
import com.mycompany.robotmove.model.entities.enumeration.TurnEnum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Zakhar
 */
public class TurnCommand implements Command{
    private Pattern dirPattern = Pattern.compile(DIR_COMMAND_REG);
    private TurnEnum turnEnum;
    private String outputStr;

    @Override
    public String execute(String commandStr) {
       initDir(commandStr);
       robot.turn(turnEnum);
       outputStr = robot.getCoordinateX().toString().concat(SEPARATOR).concat(robot.getCoordinateY()
                .toString()).concat(SEPARATOR).concat(robot.getDirection().toString());
       return outputStr;
    }

    /**
     * parses inputed string and sets direction (left or right)
     * @param commandStr 
     */
    private void initDir(String commandStr) {
        Matcher matcherDir = dirPattern.matcher(commandStr.trim());
        while (matcherDir.find()) {
            turnEnum = TurnEnum.valueOf(matcherDir.group().toUpperCase());
        }
    }
    
}
