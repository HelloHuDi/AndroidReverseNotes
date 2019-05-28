package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import java.nio.FloatBuffer;

@Keep
public interface IMBFontHandler {
    boolean checkAndFlushClearSignal();

    int[] checkAndFlushDirtySignal();

    FloatBuffer drawText(String str);

    void enableStroke(boolean z);

    Bitmap getBitmapAtlas();

    float getTextLineHeight(String str);

    void init(int i, int i2);

    String loadFont(String str);

    float measureText(String str);

    void release();

    void setStrokeWidth(float f);

    void useFont(String str, float f, boolean z, boolean z2);
}
