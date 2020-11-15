package com.example.writenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    static boolean isPlay = true;
    MediaPlayer mediaPlayer;
    Button music_brn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music_brn = (Button)findViewById(R.id.btn_music);
        PlayMusic();




    }
    public void OnPlay(View v){

        startActivity(new Intent(MainActivity.this,SelectActivity.class));


    }
    public void OnAbout(View v){

        startActivity(new Intent(MainActivity.this,AboutActivity.class));


    }


    private void PlayMusic(){
        mediaPlayer = MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }


    public void OnMusic(View v){
        if (isPlay == true){
            if (mediaPlayer !=null){
                mediaPlayer.stop();
                music_brn.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;

            }


        }else {
            PlayMusic();
            music_brn.setBackgroundResource(R.drawable.btn_music1);
            isPlay = true;
        }



    }

    public void OnStop(View v){
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }



    }

    public void OnDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
    }

    public void OnRestart(View v){
        super.onRestart();
        if (isPlay == true){
            PlayMusic();


        }


    }



}
