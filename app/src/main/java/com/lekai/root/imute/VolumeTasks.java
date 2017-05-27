package com.lekai.root.imute;

import android.content.Context;
import android.media.AudioManager;
public class VolumeTasks {
    public static final String MUTE_VOLUME = "mute-volume";
    public static final String UNMUTE_VOLUME = "unmute-volume";

    public static void executeTask(Context context, String action){
        if(MUTE_VOLUME.equals(action)){
            muteSound(context);
        }else if(UNMUTE_VOLUME.equals(action)){
            unmuteSound(context);
        }
    }

    private static void muteSound(Context context){
        AudioManager soundManager = (AudioManager) context.getSystemService (context.AUDIO_SERVICE) ;
        soundManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
    private static void unmuteSound(Context context){
        AudioManager soundManager = (AudioManager) context.getSystemService (context.AUDIO_SERVICE) ;
        soundManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
}
