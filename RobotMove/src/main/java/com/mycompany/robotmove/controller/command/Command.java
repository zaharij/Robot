/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller.command;

import com.mycompany.robotmove.model.entities.RobotPhotographerOperator;

/**
 * interface Command implements pattern command
 * @author Zakhar
 */
public interface Command {
    public static RobotPhotographerOperator robot = new RobotPhotographerOperator();
    
    public String execute(String commandStr);
}
