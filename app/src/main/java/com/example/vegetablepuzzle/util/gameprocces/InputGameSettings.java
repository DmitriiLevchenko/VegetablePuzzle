package com.example.vegetablepuzzle.util.gameprocces;

import com.example.vegetablepuzzle.R;
import com.example.vegetablepuzzle.activitys.GameStarter;

import java.util.ArrayList;

public class InputGameSettings {
    private  ArrayList<Integer> imagechooseinput = new ArrayList<Integer>();
    private   ArrayList<Integer> puzzleimageinput = new ArrayList<Integer>();
    private  Integer backgroundImage;

    public ArrayList<Integer> getImagechooseinput() {
        switch (GameSettings.level)
        {
            case 1:
                imagechooseinput.add(R.drawable.puzzle_1_1_4);
                imagechooseinput.add(R.drawable.puzzle_1_1_1);
                imagechooseinput.add(R.drawable.puzzle_1_2_4);
                imagechooseinput.add(R.drawable.puzzle_1_2_1);
                imagechooseinput.add(R.drawable.puzzle_1_2_3);
                imagechooseinput.add(R.drawable.puzzle_1_2_2);
                imagechooseinput.add(R.drawable.puzzle_1_1_3);
                imagechooseinput.add(R.drawable.puzzle_1_1_2);
                break;
            case 2:
                imagechooseinput.add(R.drawable.puzzle_2_1_4);
                imagechooseinput.add(R.drawable.puzzle_2_1_1);
                imagechooseinput.add(R.drawable.puzzle_2_2_4);
                imagechooseinput.add(R.drawable.puzzle_2_2_1);
                imagechooseinput.add(R.drawable.puzzle_2_2_3);
                imagechooseinput.add(R.drawable.puzzle_2_2_2);
                imagechooseinput.add(R.drawable.puzzle_2_1_3);
                imagechooseinput.add(R.drawable.puzzle_2_1_2);
                break;
            case 3:
                imagechooseinput.add(R.drawable.puzzle_3_1_4);
                imagechooseinput.add(R.drawable.puzzle_3_1_1);
                imagechooseinput.add(R.drawable.puzzle_3_2_4);
                imagechooseinput.add(R.drawable.puzzle_3_2_1);
                imagechooseinput.add(R.drawable.puzzle_3_2_3);
                imagechooseinput.add(R.drawable.puzzle_3_2_2);
                imagechooseinput.add(R.drawable.puzzle_3_1_3);
                imagechooseinput.add(R.drawable.puzzle_3_1_2);
                break;
            case 4:
                imagechooseinput.add(R.drawable.puzzle_4_1_4);
                imagechooseinput.add(R.drawable.puzzle_4_1_1);
                imagechooseinput.add(R.drawable.puzzle_4_2_4);
                imagechooseinput.add(R.drawable.puzzle_4_2_1);
                imagechooseinput.add(R.drawable.puzzle_4_2_3);
                imagechooseinput.add(R.drawable.puzzle_4_2_2);
                imagechooseinput.add(R.drawable.puzzle_4_1_3);
                imagechooseinput.add(R.drawable.puzzle_4_1_2);
                break;
        }
        return imagechooseinput;
    }

    public Integer getBackgroundImage() {
        switch (GameSettings.level) {
            case 1:
                backgroundImage = R.drawable.puzzle_1;break;
            case 2:
                backgroundImage = R.drawable.puzzle_2;break;
            case 3:
                backgroundImage = R.drawable.puzzle_3;break;
            case 4:
                backgroundImage = R.drawable.puzzle_4;break;
        }

        return backgroundImage;
    }

    public ArrayList<Integer> getPuzzleimageinput() {
        switch (GameSettings.level) {
            case 1:
                puzzleimageinput.add(R.drawable.puzzle_1_1_1);
                puzzleimageinput.add(R.drawable.puzzle_1_1_2);
                puzzleimageinput.add(R.drawable.puzzle_1_1_3);
                puzzleimageinput.add(R.drawable.puzzle_1_1_4);
                puzzleimageinput.add(R.drawable.puzzle_1_2_1);
                puzzleimageinput.add(R.drawable.puzzle_1_2_2);
                puzzleimageinput.add(R.drawable.puzzle_1_2_3);
                puzzleimageinput.add(R.drawable.puzzle_1_2_4);
                break;
            case 2:
                puzzleimageinput.add(R.drawable.puzzle_2_1_1);
                puzzleimageinput.add(R.drawable.puzzle_2_1_2);
                puzzleimageinput.add(R.drawable.puzzle_2_1_3);
                puzzleimageinput.add(R.drawable.puzzle_2_1_4);
                puzzleimageinput.add(R.drawable.puzzle_2_2_1);
                puzzleimageinput.add(R.drawable.puzzle_2_2_2);
                puzzleimageinput.add(R.drawable.puzzle_2_2_3);
                puzzleimageinput.add(R.drawable.puzzle_2_2_4);
                break;
            case 3:
                puzzleimageinput.add(R.drawable.puzzle_3_1_1);
                puzzleimageinput.add(R.drawable.puzzle_3_1_2);
                puzzleimageinput.add(R.drawable.puzzle_3_1_3);
                puzzleimageinput.add(R.drawable.puzzle_3_1_4);
                puzzleimageinput.add(R.drawable.puzzle_3_2_1);
                puzzleimageinput.add(R.drawable.puzzle_3_2_2);
                puzzleimageinput.add(R.drawable.puzzle_3_2_3);
                puzzleimageinput.add(R.drawable.puzzle_3_2_4);
                break;
            case 4:
                puzzleimageinput.add(R.drawable.puzzle_4_1_1);
                puzzleimageinput.add(R.drawable.puzzle_4_1_2);
                puzzleimageinput.add(R.drawable.puzzle_4_1_3);
                puzzleimageinput.add(R.drawable.puzzle_4_1_4);
                puzzleimageinput.add(R.drawable.puzzle_4_2_1);
                puzzleimageinput.add(R.drawable.puzzle_4_2_2);
                puzzleimageinput.add(R.drawable.puzzle_4_2_3);
                puzzleimageinput.add(R.drawable.puzzle_4_2_4);
                break;
        }


        return puzzleimageinput;
    }
}
