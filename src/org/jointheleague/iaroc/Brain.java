package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    int x = 100;
    int y = 100;
    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }



    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?


    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {



        readSensors(0);
        driveDirect(x, y);

        if(isBumpRight() == true && isBumpLeft() == true){

            driveDirect(-100, -100);

            SystemClock.sleep(400);

            x = 100;
            y = 25;

            SystemClock.sleep(400);

            x = 25;
            y = 100;


        }else if(isBumpRight() == true){

            driveDirect(-100, -100);

            SystemClock.sleep(400);

            x = 100;
            y = 25;

            SystemClock.sleep(400);

            x = 25;
            y = 100;



        }else if(isBumpLeft() == true) {

            driveDirect(-100, -100);

            SystemClock.sleep(400);

            x = 25;
            y = 100;


        }



    }
}