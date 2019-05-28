package com.tencent.p177mm.plugin.sns.p520ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.C3872i.C3873a;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar */
public class SnsTextProgressBar extends ProgressBar {
    /* renamed from: EV */
    private int f13710EV;
    private int iaQ;
    private Context mContext;
    private Paint mPaint;
    private String mText;
    private String rNl;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40525);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3873a.SnsTextProgressBar, 0, 0);
        try {
            setTextSize(obtainStyledAttributes.getInteger(0, 18));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(40525);
        }
    }

    public void setProgress(int i) {
        AppMethodBeat.m2504i(40526);
        setText(i);
        super.setProgress(i);
        AppMethodBeat.m2505o(40526);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    @SuppressLint({"DrawAllocation"})
    public synchronized void onDraw(Canvas canvas) {
        int color;
        AppMethodBeat.m2504i(40527);
        super.onDraw(canvas);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        if (this.rNl == null || this.rNl.length() <= 0) {
            color = this.mContext.getResources().getColor(C25738R.color.a6c);
        } else {
            color = Color.parseColor(this.rNl);
        }
        this.mPaint.setColor(color);
        this.mPaint.setTextSize((float) this.iaQ);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        canvas.drawText(this.mText, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.mPaint);
        AppMethodBeat.m2505o(40527);
    }

    public void setTextSize(int i) {
        AppMethodBeat.m2504i(40528);
        this.iaQ = C1338a.fromDPToPix(this.mContext, i);
        AppMethodBeat.m2505o(40528);
    }

    private void setText(int i) {
        AppMethodBeat.m2504i(40529);
        this.f13710EV = i;
        this.mText = String.valueOf(i) + "%";
        AppMethodBeat.m2505o(40529);
    }

    public void setPaintColor(String str) {
        this.rNl = str;
    }
}
