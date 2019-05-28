package com.tencent.p177mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.header.GyroView */
public class GyroView extends View {
    private float aqf;
    private float jcU = 0.0f;
    private float jcV = 0.0f;
    private float jcW;
    private float jcX;
    private float jcY;
    private float jcZ;
    private boolean jda = false;
    private Paint mPaint;

    public GyroView(Context context) {
        super(context);
        AppMethodBeat.m2504i(114922);
        init();
        AppMethodBeat.m2505o(114922);
    }

    public GyroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(114923);
        init();
        AppMethodBeat.m2505o(114923);
    }

    private void init() {
        AppMethodBeat.m2504i(114924);
        this.jcX = 40.0f * getResources().getDisplayMetrics().density;
        this.jcW = 100.0f * getResources().getDisplayMetrics().density;
        this.aqf = 20.0f * getResources().getDisplayMetrics().density;
        this.jcY = 10.0f * getResources().getDisplayMetrics().density;
        this.jcZ = 6.0f * getResources().getDisplayMetrics().density;
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(-9934744);
        AppMethodBeat.m2505o(114924);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(114925);
        super.onDraw(canvas);
        float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.jcV > 0.0f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (this.jcY / 2.0f) - ((this.jcV * (this.jcY - this.jcZ)) / 2.0f), this.mPaint);
            canvas.drawCircle(measuredWidth - (this.jcV * this.aqf), measuredHeight, this.jcZ / 2.0f, this.mPaint);
            canvas.drawCircle(measuredWidth + (this.jcV * this.aqf), measuredHeight, this.jcZ / 2.0f, this.mPaint);
            AppMethodBeat.m2505o(114925);
            return;
        }
        canvas.drawCircle(measuredWidth, measuredHeight, (this.jcU * this.jcY) / 2.0f, this.mPaint);
        AppMethodBeat.m2505o(114925);
    }

    public void setVerticalScroll(float f) {
        AppMethodBeat.m2504i(114926);
        float f2 = (f - this.jcX) / (this.jcW - this.jcX);
        if (this.jda) {
            f2 = 1.0f - f2;
        }
        this.jcV = Math.max(0.0f, Math.min(f2, 1.0f));
        f2 = f / this.jcX;
        if (this.jda) {
            f2 = 1.0f - f2;
        }
        this.jcU = Math.max(0.0f, Math.min(f2, 1.0f));
        postInvalidate();
        AppMethodBeat.m2505o(114926);
    }

    /* renamed from: b */
    public final void mo22610b(float f, int i) {
        AppMethodBeat.m2504i(114927);
        float f2 = (f - this.jcX) / (((float) i) - this.jcX);
        if (this.jda) {
            f2 = 1.0f - f2;
        }
        this.jcV = Math.max(0.0f, Math.min(f2, 1.0f));
        f2 = f / this.jcX;
        if (this.jda) {
            f2 = 1.0f - f2;
        }
        this.jcU = Math.max(0.0f, Math.min(f2, 1.0f));
        C4990ab.m7411d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", Float.valueOf(f), Integer.valueOf(i), Float.valueOf(this.jcU), Float.valueOf(this.jcV));
        postInvalidate();
        AppMethodBeat.m2505o(114927);
    }
}
