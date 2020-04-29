package com.example.vegetablepuzzle.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vegetablepuzzle.R;
import com.example.vegetablepuzzle.util.customizateuser.BacgroudsEnum;
import com.example.vegetablepuzzle.util.customizateuser.LinesEnum;
import com.example.vegetablepuzzle.util.customizateuser.User;
import com.example.vegetablepuzzle.util.customizateuser.UserSettings;

public class MainActivity extends AppCompatActivity {
    public static String LOGNAME = "GameLog";
    private Button start, shop, exit;
    private SharedPreferences myPreferences;
    private SharedPreferences.Editor myEditor;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InizializateComponents();

    }
    private void InizializateComponents()
    {

        //Log.d(MainActivity.LOGNAME,"" + userSettings.getBacgroundres() + "  " +  User.bacgroundname);
        getDatefromSharedPreferences();
        UserSettings userSettings = new UserSettings();
        constraintLayout = findViewById(R.id.main_activity_layout);
        if(userSettings.getBacgroundres() != 0)
        {
            Log.d(MainActivity.LOGNAME,"there");
            constraintLayout.setBackgroundResource(userSettings.getBacgroundres());
        }
        start = findViewById(R.id.start);
        shop = findViewById(R.id.shop);
        exit = findViewById(R.id.exit);
        start.setOnClickListener(CreatesetOnclickListener());
        shop.setOnClickListener(CreatesetOnclickListener());
        exit.setOnClickListener(CreatesetOnclickListener());
        Log.d(MainActivity.LOGNAME,"" + userSettings.getBacgroundres() + "  " +  User.bacgroundname);

    }

    private View.OnClickListener CreatesetOnclickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.start:
                        CreateStartIntent();
                        break;
                    case R.id.exit:
                        CreateExitIntent();
                        break;
                    case R.id.shop:
                        CreateShoptIntent();
                        break;
                }
            }
        };
        return onClickListener;
    }

    public void getDatefromSharedPreferences() {
        if (User.bacground == null || User.tips == null || User.coins == null || User.line == null) {
        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        myEditor = myPreferences.edit();

            User.currentlevel =  myPreferences.getInt("currentlevel", 1);

            User.coins = myPreferences.getInt("coins", 1000);
            //
            User.tips = myPreferences.getInt("tips", 0);
            //
            User.linename = myPreferences.getString("line", "line1");
            //
            User.bacgroundname = myPreferences.getString("bacground", "bacground1");
            //
            switch (User.bacgroundname) {
                case "bacground1":
                    User.bacground = BacgroudsEnum.BACKGROUND1;
                    break;
                case "bacground2":
                    User.bacground = BacgroudsEnum.BACKGROUND2;
                    break;
                case "bacground3":
                    User.bacground = BacgroudsEnum.BACKGROUND3;
                    break;
                case "bacground4":
                    User.bacground = BacgroudsEnum.BACKGROUND4;
                    break;
            }
//
            switch (User.linename) {
                case "line1":
                    User.line = LinesEnum.LINE1;
                    break;
                case "line2":
                    User.line = LinesEnum.LINE2;
                    break;
                case "line3":
                    User.line = LinesEnum.LINE3;
                    break;
                case "line4":
                    User.line = LinesEnum.LINE4;
                    break;
            }
        }
    }

    void CreateStartIntent() {
        Intent intent = new Intent(MainActivity.this, ChooseGame.class);
        startActivity(intent);
    }

    void CreateShoptIntent() {
        Intent intent = new Intent(MainActivity.this, Shop.class);
        startActivity(intent);
    }

    void CreateExitIntent() {
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       if( User.bacgroundname== null || User.linename==null || User.tips==null || User.coins==null || User.currentlevel==null)
        {
            myEditor.putString("bacground", User.bacgroundname.toString());
            myEditor.putString("line", User.linename.toString());
            myEditor.putInt("tips", User.tips);
            myEditor.putInt("coins", User.coins);
            myEditor.putInt("currentlevel", User.currentlevel);

            myEditor.apply();
        }
       this.finish();
    }
}
