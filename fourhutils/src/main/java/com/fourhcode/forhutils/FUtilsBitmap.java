package com.fourhcode.forhutils;


import android.graphics.Bitmap;

public class FUtilsBitmap {

    public static Bitmap resizeImage(Bitmap origranlImage, float maxImageSize,
                                     boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / origranlImage.getWidth(),
                (float) maxImageSize / origranlImage.getHeight());
        int width = Math.round((float) ratio * origranlImage.getWidth());
        int height = Math.round((float) ratio * origranlImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(origranlImage, width,
                height, filter);
        return newBitmap;
    }





}
