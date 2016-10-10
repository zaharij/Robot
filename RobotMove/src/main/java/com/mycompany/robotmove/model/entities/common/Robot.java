/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.model.entities.common;

import static com.mycompany.robotmove.constants.RobotConstants.*;
import com.mycompany.robotmove.model.entities.enumeration.DirectionEnum;
import static com.mycompany.robotmove.model.entities.enumeration.DirectionEnum.NORTH;
import com.mycompany.robotmove.model.entities.enumeration.TurnEnum;

/**
 * superclass Robot
 * @author Zakhar
 */
public class Robot {        
    private Integer coordinateX;
    private Integer coordinateY;
    private DirectionEnum direction;
    
    public Robot (int coordinateX, int coordinateY, DirectionEnum direction){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.direction = direction;
    }
    
    public Robot (){
        if (this.coordinateX == null || this.coordinateY == null || this.direction == null){
            this.coordinateX = DEFAULT_CORDINATE_NUMBER;
            this.coordinateY = DEFAULT_CORDINATE_NUMBER;
            this.direction = NORTH;
        }
    }
    
    /**
     * moves towards using direction
     * @param centimeters - distance to move in centimeters
     * @param direction - side of the horizon
     */
    public void moveToward(int centimeters, DirectionEnum direction){
        this.direction = direction;
        moveToward(centimeters);
    }
    
    /**
     * moves forward
     * @param centimeters - distance to move in centimeters
     */
    public void moveToward(int centimeters){
        if (this.getDirection().equals(NORTH_ENUM)){
            this.coordinateY += centimeters;
        } else if (this.getDirection().equals(SOUTH_ENUM)){
            this.coordinateY -= centimeters;
        } else if (this.getDirection().equals(WEST_ENUM)){
            this.coordinateX -= centimeters;
        } else if (this.getDirection().equals(EAST_ENUM)){
            this.coordinateX += centimeters;
        }
    }
    
    /**
     * sets the direction
     * @param direction - side of the horizon
     */
    public void moveToward(DirectionEnum direction){
        this.direction = direction;
    }
    
    /**
     * turns the robot to the left or to the right
     * @param side (left or right)
     */
    public void turn(TurnEnum side){
        int currentDirIndex = DIRECTION_LIST.indexOf(getDirection());
        if (side.equals(LEFT_ENUM)){
            if (currentDirIndex == FIRST_ELEMENT){
                currentDirIndex = DIRECTION_LIST.size() - INDEX_CORRECTION_NUMBER;
            } else {
                currentDirIndex--;
            }
        } else if(side.equals(RIGHT_ENUM)){
            if (currentDirIndex == (DIRECTION_LIST.size() - INDEX_CORRECTION_NUMBER)){
                currentDirIndex = FIRST_ELEMENT;
            } else {
                currentDirIndex++;
            }
        } else {
            return;
        }
        this.direction = DIRECTION_LIST.get(currentDirIndex);
    }

    /**
     * @return the coordinateX
     */
    public Integer getCoordinateX() {
        return coordinateX;
    }

    /**
     * @return the coordinateY
     */
    public Integer getCoordinateY() {
        return coordinateY;
    }

    /**
     * @return the direction
     */
    public DirectionEnum getDirection() {
        return direction;
    }
}
