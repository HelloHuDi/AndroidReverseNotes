package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

/* renamed from: com.tencent.neattextview.textview.layout.b */
public interface C5783b extends Serializable {
    /* renamed from: QU */
    int mo11848QU(int i);

    /* renamed from: a */
    void mo11849a(Canvas canvas, TextPaint textPaint, float f);

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
