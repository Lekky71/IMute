package com.lekai.root.imute;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by root on 5/24/17.
 */

public class ChangeVolumeService extends IntentService{
    public ChangeVolumeService() {
        super("changeVolumeService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        VolumeTasks.executeTask(this,action);
    }
}
