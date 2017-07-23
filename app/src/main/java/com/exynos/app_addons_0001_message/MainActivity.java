package com.exynos.app_addons_0001_message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private final String TAG="MessageTest";
    private int ButtonCount = 0;
    private Thread myThread;
    private MyThread myThread2;
    class MyRunnable implements Runnable {
        public void run(){
            int count = 0;
            for(;;){
                Log.d(TAG, "myThread"+count);
                count++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Thread getMyThread() {
        return myThread;
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            int count = 0;
            super.run();
            for(;;){
                Log.d(TAG, "myThread2"+count);
                count++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Log.d(TAG,"send message"+ButtonCount);
                ButtonCount++;
            }
        });

        myThread = new Thread(new MyRunnable(), "MessageTestThread");
        myThread.start();
        myThread2 = new MyThread();
        myThread2.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
