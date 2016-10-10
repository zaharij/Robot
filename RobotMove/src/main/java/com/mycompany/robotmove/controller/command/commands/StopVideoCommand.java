/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command.commands;

import static com.mycompany.robotmove.constants.RobotConstants.SEPARATOR;
import com.mycompany.robotmove.controller.command.Command;

/**
 *
 * @author Zakhar
 */
public class StopVideoCommand implements Command{

    @Override
    public String execute(String commandStr) {
        robot.stopVideo();
        return robot.getStartVideoDateTime().toString().concat(SEPARATOR).concat(robot
                .getStopVideoDateTime().toString()).concat(SEPARATOR).concat(robot.getVideoTimeInMinutes().toString());
    }
    
}
