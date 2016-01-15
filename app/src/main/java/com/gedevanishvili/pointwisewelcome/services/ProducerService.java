package com.gedevanishvili.pointwisewelcome.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.gedevanishvili.pointwisewelcome.data.MyConfig;
import com.gedevanishvili.pointwisewelcome.modules.PQManager;

import java.util.Timer;
import java.util.TimerTask;

public class ProducerService extends Service {
    public ProducerService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        TimerTask producerTask = new TimerTask() {
            @Override
            public void run() {

                PQManager.getInstance().add();
            }
        };

        Timer producerTimer = new Timer();
        // Schedule task every T1 milliseconds
        producerTimer.schedule(producerTask, 0, MyConfig.T1);

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
