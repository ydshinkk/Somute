package com.mobile.somute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MoodTracker extends AppCompatActivity {

    int cYear, cMonth, cDayOfMonth, cSoundNum;
    CalendarView calView;
    EditText et_date, et_soundNum;
    Button btn_saveDB;
    DBHelper dbHelper;
    ImageButton iBtn_mood1, iBtn_mood2, iBtn_mood3, iBtn_mood4, iBtn_mood5, iBtn_mood6, iBtn_mood7, iBtn_mood8;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5, mediaPlayer6, mediaPlayer7, mediaPlayer8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);

        calView = (CalendarView) findViewById(R.id.calView);
        et_date = (EditText) findViewById(R.id.et_date);
        btn_saveDB = (Button) findViewById(R.id.btn_saveDB);
        dbHelper =new DBHelper(MoodTracker.this, 1);

        iBtn_mood1 = (ImageButton) findViewById(R.id.iBtn_mood1);
        iBtn_mood2 = (ImageButton) findViewById(R.id.iBtn_mood2);
        iBtn_mood3 = (ImageButton) findViewById(R.id.iBtn_mood3);
        iBtn_mood4 = (ImageButton) findViewById(R.id.iBtn_mood4);
        iBtn_mood5 = (ImageButton) findViewById(R.id.iBtn_mood5);
        iBtn_mood6 = (ImageButton) findViewById(R.id.iBtn_mood6);
        iBtn_mood7 = (ImageButton) findViewById(R.id.iBtn_mood7);
        iBtn_mood8 = (ImageButton) findViewById(R.id.iBtn_mood8);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.sound1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.sound3);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.sound4);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.sound5);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.sound6);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.sound7);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.sound8);

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                cYear = year;
                cMonth = month+1;
                cDayOfMonth = dayOfMonth;
                et_date.setText(year + "년 " + cMonth + "월 " + dayOfMonth + "일");
            }
        });

        iBtn_mood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });
        iBtn_mood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });
        iBtn_mood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer3.start();
            }
        });
        iBtn_mood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer4.start();
            }
        });
        iBtn_mood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer5.start();
            }
        });
        iBtn_mood6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer6.start();
            }
        });
        iBtn_mood7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer7.start();
            }
        });
        iBtn_mood8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer8.start();
            }
        });

        btn_saveDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_soundNum.getText().equals("1")){
                    cSoundNum = 1;
                }
                else if(et_soundNum.getText().equals("2")){
                    cSoundNum = 2;
                }
                else if(et_soundNum.getText().equals("3")){
                    cSoundNum = 3;
                }
                else if(et_soundNum.getText().equals("4")){
                    cSoundNum = 4;
                }
                else if(et_soundNum.getText().equals("5")){
                    cSoundNum = 5;
                }
                else if(et_soundNum.getText().equals("6")){
                    cSoundNum = 6;
                }
                else if(et_soundNum.getText().equals("7")){
                    cSoundNum = 7;
                }
                else { cSoundNum = 8; }

                dbHelper.insert(cYear, cMonth, cDayOfMonth, cSoundNum);
                Toast.makeText(MoodTracker.this, "저장이 완료되었습니다!", Toast.LENGTH_LONG).show();
            }
        });

    }

}