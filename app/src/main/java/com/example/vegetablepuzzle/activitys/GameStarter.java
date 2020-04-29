package com.example.vegetablepuzzle.activitys;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vegetablepuzzle.R;
import com.example.vegetablepuzzle.util.customizateuser.User;
import com.example.vegetablepuzzle.util.customizateuser.UserSettings;
import com.example.vegetablepuzzle.util.gameprocces.GameSettings;
import com.example.vegetablepuzzle.util.gameprocces.InputGameSettings;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class GameStarter extends AppCompatActivity {
    private ImageView puzzle11, puzzle12, puzzle13, puzzle14, puzzle21, puzzle22, puzzle23, puzzle24;
    private ArrayList<ImageView> puzzlesfield = new ArrayList<>(10);
    private ArrayList<ImageView> choosepuzzle = new ArrayList<>();
    private ImageView choose1, choose2, choose3, choose4, choose5, choose6, choose7, choose8;
    private Boolean ischoosepuzzles = false;
    private Integer ActiveImage = null, indexactive = null;
    private ArrayList<Integer> arrayListpuzzle;
    private ArrayList<Integer> arrayListchoose;
    private Integer quantatyrightpuzzlechooses = 0;
    private TextView CoinsCount, tips;
    private Button buttonnextlevel;
    private ConstraintLayout constraintLayout;
    private ImageView backgroundpuzzle;
    private Integer lineresbackground = R.drawable.circling_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_starter);

        InizializateComponents();
    }

    private void InizializateComponents() {
        constraintLayout = findViewById(R.id.gamelayout);
        UserSettings userSettings = new UserSettings();
        if (userSettings.getBacgroundres() != 0) {
            Log.d(MainActivity.LOGNAME, "there");
            constraintLayout.setBackgroundResource(userSettings.getBacgroundres());
        }
        if(userSettings.getLineres() != 0)
        {
            lineresbackground = userSettings.getLineres();

        }
        buttonnextlevel = findViewById(R.id.nextlevel);
        buttonnextlevel.setOnClickListener(CreatesetOnclickListener());
        CoinsCount = findViewById(R.id.coinscount2);
        CoinsCount.setText(User.coins.toString());
        tips = findViewById(R.id.tips);
        tips.setText(User.tips.toString());


        tips.setOnClickListener(CreatesetOnclickListener());
        puzzle11 = findViewById(R.id.puzzle11);
        puzzle12 = findViewById(R.id.puzzle12);
        puzzle13 = findViewById(R.id.puzzle13);
        puzzle14 = findViewById(R.id.puzzle14);
        puzzle21 = findViewById(R.id.puzzle21);
        puzzle22 = findViewById(R.id.puzzle22);
        puzzle23 = findViewById(R.id.puzzle23);
        puzzle24 = findViewById(R.id.puzzle24);
        puzzlesfield.add(puzzle11);
        puzzlesfield.add(puzzle12);
        puzzlesfield.add(puzzle13);
        puzzlesfield.add(puzzle14);
        puzzlesfield.add(puzzle21);
        puzzlesfield.add(puzzle22);
        puzzlesfield.add(puzzle23);
        puzzlesfield.add(puzzle24);
        choose1 = findViewById(R.id.choosepuzzle1);
        choose2 = findViewById(R.id.choosepuzzle2);
        choose3 = findViewById(R.id.choosepuzzle3);
        choose4 = findViewById(R.id.choosepuzzle4);
        choose5 = findViewById(R.id.choosepuzzle5);
        choose6 = findViewById(R.id.choosepuzzle6);
        choose7 = findViewById(R.id.choosepuzzle7);
        choose8 = findViewById(R.id.choosepuzzle8);
        choosepuzzle.add(choose1);
        choosepuzzle.add(choose2);
        choosepuzzle.add(choose3);
        choosepuzzle.add(choose4);
        choosepuzzle.add(choose5);
        choosepuzzle.add(choose6);
        choosepuzzle.add(choose7);
        choosepuzzle.add(choose8);
        InputGameSettings inputGameSettings = new InputGameSettings();
        backgroundpuzzle = findViewById(R.id.puzzlebackground);
        backgroundpuzzle.setBackgroundResource(inputGameSettings.getBackgroundImage());
        arrayListpuzzle = inputGameSettings.getPuzzleimageinput();
        arrayListchoose = inputGameSettings.getImagechooseinput();
        //Log.d(MainActivity.LOGNAME,"puzzlesfield.size():: " + puzzlesfield.size()) ;
        for (int i = 0; i < puzzlesfield.size(); i++) {
            choosepuzzle.get(i).setImageResource(arrayListchoose.get(i));
            final int finalI = i;
            //Log.d(MainActivity.LOGNAME,"finalI:: " + finalI) ;
            choosepuzzle.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choosepuzzleOnclickListener(arrayListchoose.get(finalI).intValue(), finalI);
                }
            });
            //Log.d(MainActivity.LOGNAME,"finalI:: " + finalI) ;
            puzzlesfield.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    puzzlesfieldOnclickListener(finalI);
                }
            });
            Log.d(MainActivity.LOGNAME, arrayListchoose.get(i) + "  " + arrayListpuzzle.get(i));
        }
        puzzle24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puzzlesfieldOnclickListener(7);
            }
        });
    }

    private View.OnClickListener CreatesetOnclickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.nextlevel:
                        CreatenewLevelIntent();
                        break;
                    case R.id.tips:
                        Usetip();
                        break;
                }
            }
        };
        return onClickListener;
    }

    private void choosepuzzleOnclickListener(int image, int index) {

        ischoosepuzzles = true;
        if (indexactive != null) {
            choosepuzzle.get(indexactive).setBackgroundResource(R.drawable.imageborder);
        }
        ActiveImage = image;
        indexactive = index;
        choosepuzzle.get(index).setBackgroundResource(lineresbackground);
        Log.d(MainActivity.LOGNAME, "puzzlesfieldOnclickListener:: " + image + "image");
    }

    private void puzzlesfieldOnclickListener(int index) {
        //Log.d(MainActivity.LOGNAME,"puzzlesfieldOnclickListener::"  +  arrayListchoose.get(indexactive) +   "==" + arrayListpuzzle.get(index)) ;
        if (ischoosepuzzles) {
            if (arrayListchoose.get(indexactive).equals(arrayListpuzzle.get(index))) {
                quantatyrightpuzzlechooses++;
                choosepuzzle.get(indexactive).setVisibility(View.GONE);
                puzzlesfield.get(index).setBackgroundResource(ActiveImage);
                puzzlesfield.get(index).setVisibility(View.VISIBLE);
                puzzlesfield.get(index).setAlpha(1.f);
                puzzlesfield.get(index).setImageAlpha(1);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Wrong puzzle,try again",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
            if (quantatyrightpuzzlechooses == 8) {
                Win();
            }
            ischoosepuzzles = false;
//            ActiveImage = null;
//            indexactive = null;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Choose puzzle and try again",
                    Toast.LENGTH_SHORT);
            if (indexactive != null) {
                choosepuzzle.get(indexactive).setBackgroundResource(R.drawable.imageborder);
            }
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    private void Win() {
        switch (GameSettings.level) {
            case 1:
                User.coins += 100;
                break;
            case 2:
                User.coins += 200;
                break;
            case 3:
                User.coins += 300;
                break;
            case 4:
                User.coins += 400;
                break;

        }
        CoinsCount.setText(User.coins.toString());
        buttonnextlevel.setVisibility(View.VISIBLE);
    }

    private void CreatenewLevelIntent() {
        if (GameSettings.level < 4) {
            GameSettings.level++;
            User.currentlevel++;
        }
        this.recreate();
    }

    private void Usetip() {
        if (User.tips > 0) {
            User.tips--;
            tips.setText(User.tips.toString());
            //
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < puzzlesfield.size(); i++) {
                                puzzlesfield.get(i).setVisibility(View.GONE);
                            }
                        }
                    });
                    cancel();
                }
            }, 100, 1000);
            Timer timer2 = new Timer();

            timer2.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < puzzlesfield.size(); i++) {
                                puzzlesfield.get(i).setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    cancel();
                }
            }, 2000, 1000);

        }

    }


}

