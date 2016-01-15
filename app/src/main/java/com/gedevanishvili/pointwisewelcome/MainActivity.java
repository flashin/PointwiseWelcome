package com.gedevanishvili.pointwisewelcome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gedevanishvili.pointwisewelcome.services.ConsumerService;
import com.gedevanishvili.pointwisewelcome.services.ProducerService;

public class MainActivity extends AppCompatActivity {

    private TextView mStr = null;
    private TextView mWeight = null;

    /**
     * This broadcast receiver receives messages from consumer service and updates UI
     */
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String str = intent.getStringExtra("str");
            int weight = intent.getIntExtra("weight", 0);

            mStr.setText(str);
            mWeight.setText(String.valueOf(weight));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStr = (TextView) findViewById(R.id.value_str);
        mWeight = (TextView) findViewById(R.id.value_weight);

        // Start producer service
        Intent producerIntent = new Intent(this, ProducerService.class);
        startService(producerIntent);

        // Start consumer service
        Intent consumerIntent = new Intent(this, ConsumerService.class);
        startService(consumerIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(ConsumerService.Notification));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
