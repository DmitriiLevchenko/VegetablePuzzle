package com.example.vegetablepuzzle.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vegetablepuzzle.R;
import com.example.vegetablepuzzle.util.customizateuser.User;
import com.example.vegetablepuzzle.util.customizateuser.UserSettings;
import com.example.vegetablepuzzle.util.gameprocces.GameSettings;

public class ChooseGame extends AppCompatActivity {
    private Button level1,level2,level3,level4;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);
        InizializateComponents();
    }
    private  void InizializateComponents()
    {
        constraintLayout = findViewById(R.id.choosegame);
        UserSettings userSettings = new UserSettings();
        if(userSettings.getBacgroundres() != 0)
        {
            Log.d(MainActivity.LOGNAME,"there");
            constraintLayout.setBackgroundResource(userSettings.getBacgroundres());
        }
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        //
        level1.setOnClickListener(CreatesetOnclickListener());
        level2.setOnClickListener(CreatesetOnclickListener());
        level3.setOnClickListener(CreatesetOnclickListener());
        level4.setOnClickListener(CreatesetOnclickListener());
    }
    private View.OnClickListener CreatesetOnclickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.level1:
                        OpenLevel(1);
                        break;
                    case R.id.level2:
                        OpenLevel(2);
                        break;
                    case R.id.level3:
                        OpenLevel(3);
                        break;
                    case R.id.level4:
                        OpenLevel(4);
                        break;
                }
            }
        };
        return onClickListener;
    }
    private void OpenLevel(int level) {
        if(User.currentlevel >= level)
        {
            startActivity(new Intent(ChooseGame.this,GameStarter.class));
            //this.finish();
            GameSettings.level = level;
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please complete previous levels",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
}
