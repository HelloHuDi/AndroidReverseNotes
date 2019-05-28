package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.ui.widget.LineLinearLayout */
public class LineLinearLayout extends LinearLayout {
    private Paint mPaint;
    private Rect mRect;
    private int zMd;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107861);
        setWillNotDraw(false);
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setColor(-571543826);
        this.mPaint.setStrokeWidth((float) Math.round(C1338a.getDensity(getContext()) * 0.5f));
        this.zMd = C1338a.fromDPToPix(context, 44);
        AppMethodBeat.m2505o(107861);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107862);
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.mPaint;
        int i = 1;
        while (true) {
            int i2 = i;
            if (this.zMd * i2 < measuredHeight) {
                canvas.drawLine(0.0f, (float) (this.zMd * i2), (float) getMeasuredWidth(), (float) (this.zMd * i2), paint);
                i = i2 + 1;
            } else {
                super.onDraw(canvas);
                AppMethodBeat.m2505o(107862);
                return;
            }
        }
    }
}
