package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar */
class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private C7306ak fbD;
    private int lAB;
    private int lAC;
    private Runnable lAD;
    private int left;
    private Context mContext;
    private Paint mPaint;
    private int njL;
    private int right;
    private int top;

    /* renamed from: com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar$1 */
    class C304391 implements Runnable {
        C304391() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30998);
            SendDataToDeviceProgressBar.this.invalidate();
            AppMethodBeat.m2505o(30998);
        }
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(30999);
        this.lAB = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lAC = -1;
        this.njL = 10;
        this.lAD = new C304391();
        setImageResource(C25738R.drawable.a8f);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a81);
        this.top = this.left;
        this.lAC = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a82);
        this.fbD = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(30999);
    }

    /* renamed from: Os */
    public final void mo70164Os(int i) {
        AppMethodBeat.m2504i(31000);
        if (i >= 100) {
            i = 100;
        }
        this.lAB = (int) ((((float) i) / 100.0f) * 360.0f);
        dCN();
        AppMethodBeat.m2505o(31000);
    }

    public final int getProgress() {
        return (int) ((((float) this.lAB) / 360.0f) * 100.0f);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(31001);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.mPaint.setColor(this.mContext.getResources().getColor(C25738R.color.f12240x6));
        this.mPaint.setStrokeWidth((float) this.lAC);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.lAB, false, this.mPaint);
        width = this.lAB + 270;
        if (width > v2helper.VOIP_ENC_HEIGHT_LV1) {
            width -= 360;
        }
        this.mPaint.setColor(this.mContext.getResources().getColor(C25738R.color.f12237x3));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.lAB), false, this.mPaint);
        AppMethodBeat.m2505o(31001);
    }

    private void dCN() {
        AppMethodBeat.m2504i(31002);
        this.fbD.removeCallbacks(this.lAD);
        this.fbD.postDelayed(this.lAD, 0);
        AppMethodBeat.m2505o(31002);
    }
}
