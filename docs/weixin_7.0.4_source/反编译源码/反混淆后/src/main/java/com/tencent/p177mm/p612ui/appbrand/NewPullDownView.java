package com.tencent.p177mm.p612ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.appbrand.NewPullDownView */
public class NewPullDownView extends View {
    private float jcU = 0.0f;
    private boolean jda = false;
    private float yrw = (20.0f * getResources().getDisplayMetrics().density);
    private float yrx = ((14.0f * getResources().getDisplayMetrics().density) - (getResources().getDisplayMetrics().density * 4.0f));
    private Paint yry = new Paint(1);
    private Paint yrz;

    public NewPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29969);
        this.yry.setStyle(Style.FILL);
        this.yry.setColor(-4408132);
        this.yrz = new Paint(1);
        this.yrz.setStyle(Style.STROKE);
        this.yrz.setColor(0);
        this.yrz.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.yrz.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        AppMethodBeat.m2505o(29969);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(29970);
        super.onDraw(canvas);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) (getMeasuredHeight() / 2);
        canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        canvas.drawCircle(measuredWidth, measuredHeight, (this.jcU * this.yrw) / 2.0f, this.yry);
        if (this.jcU >= 0.4f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (((this.jcU - 0.4f) / 0.6f) * this.yrx) / 2.0f, this.yrz);
        }
        canvas.restore();
        AppMethodBeat.m2505o(29970);
    }

    public void setVerticalScrollPercent(float f) {
        AppMethodBeat.m2504i(29971);
        C4990ab.m7417i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", Float.valueOf(f));
        if (this.jda) {
            f = 1.0f - f;
        }
        this.jcU = Math.max(0.0f, Math.min(f, 1.0f));
        postInvalidate();
        AppMethodBeat.m2505o(29971);
    }
}
