package com.github.ihandy.jobschedulerdemo;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = ExampleInstrumentedTest.class.getSimpleName();

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.github.ihandy.jobschedulerdemo", appContext.getPackageName());
    }

    @Test
    public void sendDemoBroadcast() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //Init intent with receiver class
        Intent demoIntentForBroadcast = new Intent(appContext, ExerciseRequestsReceiver.class);

        //Add action to proper handle this request by receiver
        demoIntentForBroadcast.setAction(ExerciseRequestsReceiver.ACTION_PERFORM_EXERCISE);

        Log.d(TAG, "sendDemoBroadcast: action: " + ExerciseRequestsReceiver.ACTION_PERFORM_EXERCISE);

        //Sending broadcast with intent
        appContext.sendBroadcast(demoIntentForBroadcast);
    }
}
