package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.i.a;

public class SnsTextProgressBar extends ProgressBar {
    private int EV;
    private int iaQ;
    private Context mContext;
    private Paint mPaint;
    private String mText;
    private String rNl;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40525);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.SnsTextProgressBar, 0, 0);
        try {
            setTextSize(obtainStyledAttributes.getInteger(0, 18));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(40525);
        }
    }

    public void setProgress(int i) {
        AppMethodBeat.i(40526);
        setText(i);
        super.setProgress(i);
        AppMethodBeat.o(40526);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    @SuppressLint({"DrawAllocation"})
    public synchronized void onDraw(Canvas canvas) {
        int color;
        AppMethodBeat.i(40527);
        super.onDraw(canvas);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        if (this.rNl == null || this.rNl.length() <= 0) {
            color = this.mContext.getResources().getColor(R.color.a6c);
        } else {
            color = Color.parseColor(this.rNl);
        }
        this.mPaint.setColor(color);
        this.mPaint.setTextSize((float) this.iaQ);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        canvas.drawText(this.mText, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.mPaint);
        AppMethodBeat.o(40527);
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(40528);
        this.iaQ = com.tencent.mm.bz.a.fromDPToPix(this.mContext, i);
        AppMethodBeat.o(40528);
    }

    private void setText(int i) {
        AppMethodBeat.i(40529);
        this.EV = i;
        this.mText = String.valueOf(i) + "%";
        AppMethodBeat.o(40529);
    }

    public void setPaintColor(String str) {
        this.rNl = str;
    }
}
