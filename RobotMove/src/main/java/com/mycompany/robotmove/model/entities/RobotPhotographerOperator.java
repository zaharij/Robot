/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.model.entities;

import static com.mycompany.robotmove.constants.RobotConstants.*;
import static com.mycompany.robotmove.model.entities.RobotOperator.getCurrentTime;
import com.mycompany.robotmove.model.entities.common.Operator;
import com.mycompany.robotmove.model.entities.common.Photographer;
import com.mycompany.robotmove.model.entities.common.Robot;
import java.sql.Timestamp;

/**
 *
 * @author Zakhar
 */
public class RobotPhotographerOperator extends Robot implements Photographer, Operator {
    private Timestamp startVideoDateTime;
    private Timestamp stopVideoDateTime;
    private Timestamp photoTime;
    private Long videoTimeInMinutes;

    @Override
    public void makePhoto() {
        this.photoTime = RobotOperator.getCurrentTime();
    }

    @Override
    public void startVideo() {
        startVideoDateTime = getCurrentTime();
    }

    @Override
    public void stopVideo() {
        stopVideoDateTime = getCurrentTime();
        calculateVideoTime();
    }
    
    /**
     * calculates the video time
     */
    private void calculateVideoTime() {
        long result = (getStopVideoDateTime().getTime() - getStartVideoDateTime().getTime())/MILLISEC_TO_SEC_NUMBER;
        this.videoTimeInMinutes = result%SECONDS_IN_MINUTE;
    }

    /**
     * @return the startVideoDateTime
     */
    public Timestamp getStartVideoDateTime() {
        return startVideoDateTime;
    }

    /**
     * @return the stopVideoDateTime
     */
    public Timestamp getStopVideoDateTime() {
        return stopVideoDateTime;
    }

    /**
     * @return the videoTimeInMinutes
     */
    public Long getVideoTimeInMinutes() {
        return videoTimeInMinutes;
    }

    /**
     * @return the photoTime
     */
    public Timestamp getPhotoTime() {
        return photoTime;
    }
}
