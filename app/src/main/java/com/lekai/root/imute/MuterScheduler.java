package com.lekai.root.imute;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by root on 5/24/17.
 */

public class MuterScheduler extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
