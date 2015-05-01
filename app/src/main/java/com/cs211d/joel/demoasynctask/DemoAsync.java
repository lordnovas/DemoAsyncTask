package com.cs211d.joel.demoasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DemoAsync extends ActionBarActivity
{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_async);
        tv = (TextView) findViewById(R.id.ticker);
        new PrintSequenceTask().execute(1);


    }



    public class PrintSequenceTask extends AsyncTask<Integer,Integer,Void>
    {

        @Override
        protected void onPreExecute()
        {
            tv.setText("Sequence of Numbers Begins!");

        }
        @Override
        protected Void doInBackground(Integer... args)
        {
            for(int i=args[0];i<=10;i++)
            {

                publishProgress(i);
                SystemClock.sleep(1000);
            }

            return null;
        }

        protected void onProgressUpdate(Integer... args)
        {
            tv.setText(args[0].toString()+"\n");
        }

    }






}
