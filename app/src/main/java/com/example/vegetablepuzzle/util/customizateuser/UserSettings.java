package com.example.vegetablepuzzle.util.customizateuser;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.vegetablepuzzle.R;

public class UserSettings {
   private int bacgroundres = 0;
   private int lineres = 0;
   private Integer tips = User.tips;
   private Integer coins = User.coins;

   public int getBacgroundres() {
      switch (User.bacground)
      {
         case BACKGROUND1:
            bacgroundres = R.drawable.background_1;break;
         case BACKGROUND2:
            bacgroundres = R.drawable.background_2;break;
         case BACKGROUND3:
            bacgroundres = R.drawable.background_3;break;
         case BACKGROUND4:
            bacgroundres = R.drawable.background_4;break;
      }
      return bacgroundres;
   }

   public int getLineres() {
      switch (User.line)
      {
         case LINE1:
            lineres = R.drawable.circling_1;break;
         case LINE2:
            lineres = R.drawable.circling_2;break;
         case LINE3:
            lineres = R.drawable.circling_3;break;
         case LINE4:
            lineres = R.drawable.circling_4;break;
      }
      return lineres;
   }

   public Integer getTips() {
      return tips;
   }

   public Integer getCoins() {
      return coins;
   }
}
