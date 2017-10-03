package com.github.ihandy.jobschedulerdemo;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.FileWriter;
import java.io.IOException;

public class ExerciseIntentService extends IntentService {

    private static final String ACTION_WRITE_EXERCISE = "com.github.ihandy.jobschedulerdemo.action.ACTION_WRITE_EXERCISE";

    public ExerciseIntentService() {
        super("ExerciseIntentService");
    }

    public static void startActionWriteExercise(Context context) {
        Intent intent = new Intent(context, ExerciseIntentService.class);
        intent.setAction(ACTION_WRITE_EXERCISE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_WRITE_EXERCISE.equals(action)) {
                handleActionWriteExercise();
            }
        }
    }

    private void handleActionWriteExercise() {
        try {
            FileWriter fileWriter = new FileWriter(getFilesDir().getPath() + "exercise.txt");
            fileWriter.write("Exercise");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
