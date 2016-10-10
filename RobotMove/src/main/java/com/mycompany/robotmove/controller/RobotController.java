/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.controller;

import static com.mycompany.robotmove.constants.RobotConstants.*;
import com.mycompany.robotmove.controller.command.Command;
import com.mycompany.robotmove.controller.command.RobotCommandFactory;
import com.mycompany.robotmove.view.RobotView;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * RobotController
 * @author Zakhar
 */
public class RobotController {
    private String inputedLine = null;
    private String inputedCommand = null;    
    private Pattern commandPattern = Pattern.compile(COMMAND_REG);
    private RobotCommandFactory commandFactory = new RobotCommandFactory();
    private Command command = null;
    private RobotView robotView = new RobotView();
    
    /**
     * starts controlling the robot from the console
     */
    public void startRobot(){
        do {
            Scanner scanIn = new Scanner(System.in);
            inputedLine = scanIn.nextLine();
            Matcher matchetCommand = commandPattern.matcher(inputedLine.trim());
            while (matchetCommand.find()) {
                inputedCommand = matchetCommand.group().toLowerCase();
            }
            command = commandFactory.getCommand(inputedCommand);
            if(command != null){
                robotView.printToConsole(command.execute(inputedLine));
            } else {
                robotView.printToConsole(NO_SUCH_COMMAND_MESSAGE);
            }
        } while(!END_COMMAND.equals(inputedCommand));
    }
}
