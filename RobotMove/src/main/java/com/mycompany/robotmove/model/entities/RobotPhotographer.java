/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotmove.model.entities;

import com.mycompany.robotmove.model.entities.common.Photographer;
import com.mycompany.robotmove.model.entities.common.Robot;
import java.sql.Timestamp;

/**
 *
 * @author Zakhar
 */
public class RobotPhotographer extends Robot implements Photographer {
    private Timestamp photoTime;

    @Override
    public void makePhoto() {
        this.photoTime = RobotOperator.getCurrentTime();
    }

    /**
     * @return the photoTime
     */
    public Timestamp getPhotoTime() {
        return photoTime;
    }
    
}
