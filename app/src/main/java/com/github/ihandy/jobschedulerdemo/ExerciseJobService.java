package com.github.ihandy.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class ExerciseJobService extends JobService {

    private static final String TAG = ExerciseJobService.class.getSimpleName();

    public ExerciseJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "onStartJob: starting job with id: " + params.getJobId());

        ExerciseIntentService.startActionWriteExercise(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob: stopping job with id: " + params.getJobId());
        return true;
    }

}
