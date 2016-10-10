/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command.commands;

import com.mycompany.robotmove.controller.command.Command;

/**
 *
 * @author Zakhar
 */
public class StartVideoCommand implements Command{

    @Override
    public String execute(String commandStr) {
        robot.startVideo();
        return robot.getStartVideoDateTime().toString();
    }
    
}
