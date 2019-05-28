package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.b */
public abstract class C35746b {
    private static float bUz = Float.MAX_VALUE;
    private static float uOW = Float.MAX_VALUE;
    private static int uOX = -1;
    public static float uOY = 48.0f;

    private static float dej() {
        float f;
        synchronized (C35746b.class) {
            if (bUz == Float.MAX_VALUE) {
                bUz = C35746b.getDisplayMetrics().density;
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

    /* renamed from: Kc */
    public static int m58600Kc(int i) {
        return Math.round(((float) i) * C35746b.dek());
    }

    /* renamed from: Kd */
    public static int m58601Kd(int i) {
        return Math.round(((float) i) / C35746b.dek());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float dek() {
        float f;
        synchronized (C35746b.class) {
            if (uOW == Float.MAX_VALUE) {
                uOW = C35746b.getDisplayMetrics().density * C4996ah.getContext().getResources().getConfiguration().fontScale;
            }
            f = uOW;
        }
        return f;
    }

    public static int del() {
        if (uOX == -1) {
            uOX = Math.round(C35746b.dej() * 30.0f);
        }
        return uOX;
    }
}
