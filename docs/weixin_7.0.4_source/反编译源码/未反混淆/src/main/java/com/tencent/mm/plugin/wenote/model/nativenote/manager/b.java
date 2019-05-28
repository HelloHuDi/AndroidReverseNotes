package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class b {
    private static float bUz = Float.MAX_VALUE;
    private static float uOW = Float.MAX_VALUE;
    private static int uOX = -1;
    public static float uOY = 48.0f;

    private static float dej() {
        float f;
        synchronized (b.class) {
            if (bUz == Float.MAX_VALUE) {
                bUz = getDisplayMetrics().density;
            }
            f = bUz;
        }
        return f;
    }

    public static float getTextSize() {
        return uOY;
    }

    public static void setTextSize(float f) {
        uOY = f;
    }

    public static int Kc(int i) {
        return Math.round(((float) i) * dek());
    }

    public static int Kd(int i) {
        return Math.round(((float) i) / dek());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float dek() {
        float f;
        synchronized (b.class) {
            if (uOW == Float.MAX_VALUE) {
                uOW = getDisplayMetrics().density * ah.getContext().getResources().getConfiguration().fontScale;
            }
            f = uOW;
        }
        return f;
    }

    public static int del() {
        if (uOX == -1) {
            uOX = Math.round(dej() * 30.0f);
        }
        return uOX;
    }
}
