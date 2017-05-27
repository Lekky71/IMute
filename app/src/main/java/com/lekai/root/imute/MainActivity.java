package com.lekai.root.imute;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    final int MUTE_FLAG = 99;
    final int UNMUTE_FLAG = 23;
    TableAdapter mTableAdapter;
    GridView tableView ;
    Context context;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    muteSound();
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    unmuteSound();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        context = getBaseContext();
        mTableAdapter = new TableAdapter(context);
        tableView = (GridView) findViewById(R.id.table_grdidview);
        tableView.setAdapter(mTableAdapter);
        tableView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int blue_color = getResources().getColor(R.color.table_color);
                int default_color = getResources().getColor(R.color.default_table_color);
                if(v.getBackground()==null){
                    v.setBackground(getDrawable(R.drawable.blue_back));
                }else if(v.getBackground()!=null){
                    v.setBackground(null);
                }
            }
        });


    }
    private void muteSound(){
        AudioManager soundManager = (AudioManager) context.getSystemService (context.AUDIO_SERVICE) ;
        soundManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
    private void unmuteSound(){
        AudioManager soundManager = (AudioManager) context.getSystemService (context.AUDIO_SERVICE) ;
        soundManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

}
