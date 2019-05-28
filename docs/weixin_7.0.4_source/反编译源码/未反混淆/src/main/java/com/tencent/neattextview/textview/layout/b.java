package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public interface b extends Serializable {
    int QU(int i);

    void a(Canvas canvas, TextPaint textPaint, float f);

    float[] dPg();

    RectF dPh();

    RectF dPi();

    float dPj();

    boolean dPk();

    float dPl();

    float dPm();

    int getEnd();

    float getHeight();

    float getPrimaryHorizontal(int i);

    int getStart();

    float getWidth();
}
