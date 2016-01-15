package com.gedevanishvili.pointwisewelcome.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.gedevanishvili.pointwisewelcome.data.MyConfig;
import com.gedevanishvili.pointwisewelcome.data.Tuple;
import com.gedevanishvili.pointwisewelcome.modules.PQManager;
import com.gedevanishvili.pointwisewelcome.modules.RandomErrorGenerator;

import java.util.Timer;
import java.util.TimerTask;

public class ConsumerService extends Service {

    public static final String Notification = "com.gedevanishvili.pointwisewelcome.service.update";

    public ConsumerService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        TimerTask producerTask = new TimerTask() {
            @Override
            public void run() {

                Tuple Tuple = (Tuple) PQManager.getInstance().poll();
                if (Tuple != null) {
                    try {
                        RandomErrorGenerator.check();

                        // Broadcast a message to update UI
                        Intent intent = new Intent(Notification);
                        intent.putExtra("str", Tuple.getString());
                        intent.putExtra("weight", Tuple.getWeight());
                        sendBroadcast(intent);
                    } catch (RuntimeException e) {
                        // return the element to the queue if error occurs
                        PQManager.getInstance().add(Tuple);
                    }
                }
            }
        };

        Timer producerTimer = new Timer();
        // Schedule task every T2 milliseconds
        producerTimer.schedule(producerTask, 0, MyConfig.T2);

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
