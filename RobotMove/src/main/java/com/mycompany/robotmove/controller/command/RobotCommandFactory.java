/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command;

import static com.mycompany.robotmove.constants.RobotConstants.COMMAND_MAP;

/**
 * RobotCommandFactory
 * @author Zakhar
 */
public class RobotCommandFactory {
    
    /**
     * returns Command object, by given String
     * @param commandStr - user's input command
     * @return (Command)
     */
     public Command getCommand (String commandStr){
        if (COMMAND_MAP.containsKey(commandStr)){
            return COMMAND_MAP.get(commandStr);
        } else {
            return null;
        }               
    }
}
