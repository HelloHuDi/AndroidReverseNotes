package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.widget.j;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.smtt.sdk.WebView;

public class MMVerticalTextView extends View {
    private int direction;
    private String mText;
    private TextPaint oz = new TextPaint();
    Rect yyd = new Rect();

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106889);
        this.oz.setAntiAlias(true);
        this.oz.setTextSize(15.0f);
        this.oz.setColor(WebView.NIGHT_MODE_COLOR);
        this.oz.setTextAlign(Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.verticaltextview);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.mText = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelOffset(2, 15);
        if (resourceId > 0) {
            this.oz.setTextSize((float) resourceId);
        }
        this.oz.setColor(obtainStyledAttributes.getColor(1, WebView.NIGHT_MODE_COLOR));
        this.direction = obtainStyledAttributes.getInt(3, 0);
        this.oz.setFakeBoldText(obtainStyledAttributes.getBoolean(4, false));
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
        AppMethodBeat.o(106889);
    }

    public void setText(String str) {
        AppMethodBeat.i(106890);
        this.mText = str;
        requestLayout();
        invalidate();
        AppMethodBeat.o(106890);
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(106891);
        this.oz.setTextSize((float) i);
        requestLayout();
        invalidate();
        AppMethodBeat.o(106891);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(106892);
        this.oz.setColor(i);
        invalidate();
        AppMethodBeat.o(106892);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int height;
        AppMethodBeat.i(106893);
        this.oz.getTextBounds(this.mText, 0, this.mText.length(), this.yyd);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != ErrorDialogData.SUPPRESSED) {
            height = this.yyd.height();
            if (mode == j.INVALID_ID) {
                size = Math.min(height, size);
            } else {
                size = height;
            }
        }
        int mode2 = MeasureSpec.getMode(i2);
        height = MeasureSpec.getSize(i2);
        if (mode2 != ErrorDialogData.SUPPRESSED) {
            mode = this.yyd.width();
            height = mode2 == j.INVALID_ID ? Math.min(mode, height) : mode;
        }
        setMeasuredDimension(size, height);
        AppMethodBeat.o(106893);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(106894);
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int width;
        if (this.direction == 0) {
            width = (getWidth() >> 1) - (this.yyd.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            width = (getWidth() >> 1) + (this.yyd.height() >> 1);
            path.moveTo((float) width, (float) height);
            path.lineTo((float) width, 0.0f);
        }
        canvas.drawTextOnPath(this.mText, path, 0.0f, 0.0f, this.oz);
        AppMethodBeat.o(106894);
    }
}
