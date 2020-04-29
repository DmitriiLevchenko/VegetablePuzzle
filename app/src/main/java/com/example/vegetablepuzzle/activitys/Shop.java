package com.example.vegetablepuzzle.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vegetablepuzzle.R;
import com.example.vegetablepuzzle.util.customizateuser.BacgroudsEnum;
import com.example.vegetablepuzzle.util.customizateuser.LinesEnum;
import com.example.vegetablepuzzle.util.customizateuser.User;
import com.example.vegetablepuzzle.util.customizateuser.UserSettings;

public class Shop extends AppCompatActivity {
    private TextView bacground1price, bacground2price, bacground3price, bacground4price, line1price, line2price, line3price, line4price,coinscount;
    private final Integer BACKGROUNDCOST = 100, LINECOST = 50, TIPCOST = 50;
    private Button buytip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        InizializateComponents();
    }

    private void InizializateComponents() {
        UserSettings userSettings = new UserSettings();
        Log.d(MainActivity.LOGNAME,"" + userSettings.getBacgroundres() + "  " +  User.bacgroundname);
        coinscount = findViewById(R.id.coinscount);
        coinscount.setText(User.coins.toString());
        //
        bacground1price = findViewById(R.id.moneytextBox4);
        bacground2price = findViewById(R.id.moneytextBox6);
        bacground3price = findViewById(R.id.moneytextBox2);
        bacground4price = findViewById(R.id.moneytextBox7);
        //
        line1price = findViewById(R.id.moneytextlineBox4);
        line2price = findViewById(R.id.moneytextlineBox6);
        line3price = findViewById(R.id.moneytextlineBox1);
        line4price = findViewById(R.id.moneytextlineBox3);
        //
        buytip = findViewById(R.id.buytip);

        bacground1price.setOnClickListener(CreatesetOnclickListener());
        bacground2price.setOnClickListener(CreatesetOnclickListener());
        bacground3price.setOnClickListener(CreatesetOnclickListener());
        bacground4price.setOnClickListener(CreatesetOnclickListener());

        line1price.setOnClickListener(CreatesetOnclickListener());
        line2price.setOnClickListener(CreatesetOnclickListener());
        line3price.setOnClickListener(CreatesetOnclickListener());
        line4price.setOnClickListener(CreatesetOnclickListener());

        buytip.setOnClickListener(CreatesetOnclickListener());
    }

    public View.OnClickListener CreatesetOnclickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.moneytextBox4:
                        if (User.coins - BACKGROUNDCOST >= 0)
                            setUserSettingsBacground(BACKGROUNDCOST, BacgroudsEnum.BACKGROUND1,"bacground1");
                        break;
                    case R.id.moneytextBox6:
                        if (User.coins - BACKGROUNDCOST >= 0)
                            setUserSettingsBacground(BACKGROUNDCOST, BacgroudsEnum.BACKGROUND2,"bacground2");
                        break;
                    case R.id.moneytextBox2:
                        if (User.coins - BACKGROUNDCOST >= 0)
                            setUserSettingsBacground(BACKGROUNDCOST, BacgroudsEnum.BACKGROUND3,"bacground3");
                        break;
                    case R.id.moneytextBox7:
                        if (User.coins - BACKGROUNDCOST >= 0)
                            setUserSettingsBacground(BACKGROUNDCOST, BacgroudsEnum.BACKGROUND4,"bacground4");
                        break;

                    case R.id.moneytextlineBox4:
                        if (User.coins - LINECOST >= 0)
                            setUserSettingsLine(LINECOST, LinesEnum.LINE1,"line1");
                        break;
                    case R.id.moneytextlineBox6:
                        if (User.coins - LINECOST >= 0)
                            setUserSettingsLine(LINECOST, LinesEnum.LINE1,"line2");
                        break;
                    case R.id.moneytextlineBox1:
                        if (User.coins - LINECOST >= 0)
                            setUserSettingsLine(LINECOST, LinesEnum.LINE1,"line3");
                        break;
                    case R.id.moneytextlineBox3:
                        if (User.coins - LINECOST >= 0)
                            setUserSettingsLine(LINECOST, LinesEnum.LINE1,"line4");
                        break;

                    case R.id.buytip:
                        if (User.coins - TIPCOST >= 0) setUserSettingsTip(TIPCOST);
                        break;
                }
            }
        };
        return onClickListener;
    }
    private boolean setUserSettingsBacground(int cost, BacgroudsEnum bacgroudsEnum,String backgroundname) {
        User.coins -= cost;
        User.bacground = bacgroudsEnum;
        User.bacgroundname = backgroundname;
        coinscount.setText(User.coins.toString());
        return true;
    }

    private boolean setUserSettingsLine(int cost, LinesEnum linesEnum,String linename) {
        User.coins -= cost;
        User.line = linesEnum;
        User.linename = linename;
        coinscount.setText(User.coins.toString());
        return true;
    }

    private boolean setUserSettingsTip(int cost) {
        User.coins -= cost;
        User.tips++;
        coinscount.setText(User.coins.toString());
        return true;
    }
}
