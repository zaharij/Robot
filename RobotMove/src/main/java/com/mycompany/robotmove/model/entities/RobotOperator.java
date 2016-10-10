/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.model.entities;

import com.mycompany.robotmove.model.entities.common.Operator;
import com.mycompany.robotmove.model.entities.common.Robot;
import static com.mycompany.robotmove.constants.RobotConstants.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Zakhar
 */
public class RobotOperator extends Robot implements Operator {
    private Timestamp startVideoDateTime;
    private Timestamp stopVideoDateTime;
    private long videoTimeInMinutes;    

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
     * returns current date&time
     * @return Timestamp
     */
    public static Timestamp getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Timestamp currentTimestamp = new Timestamp(now.getTime());
        return currentTimestamp;
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
    public long getVideoTimeInMinutes() {
        return videoTimeInMinutes;
    }
    
    
}
