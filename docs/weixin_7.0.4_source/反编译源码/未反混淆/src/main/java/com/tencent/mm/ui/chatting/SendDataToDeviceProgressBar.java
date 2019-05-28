package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.wxmm.v2helper;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private ak fbD;
    private int lAB;
    private int lAC;
    private Runnable lAD;
    private int left;
    private Context mContext;
    private Paint mPaint;
    private int njL;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(30999);
        this.lAB = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lAC = -1;
        this.njL = 10;
        this.lAD = new Runnable() {
            public final void run() {
                AppMethodBeat.i(30998);
                SendDataToDeviceProgressBar.this.invalidate();
                AppMethodBeat.o(30998);
            }
        };
        setImageResource(R.drawable.a8f);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.dimen.a81);
        this.top = this.left;
        this.lAC = this.mContext.getResources().getDimensionPixelSize(R.dimen.a82);
        this.fbD = new ak(Looper.getMainLooper());
        AppMethodBeat.o(30999);
    }

    public final void Os(int i) {
        AppMethodBeat.i(31000);
        if (i >= 100) {
            i = 100;
        }
        this.lAB = (int) ((((float) i) / 100.0f) * 360.0f);
        dCN();
        AppMethodBeat.o(31000);
    }

    public final int getProgress() {
        return (int) ((((float) this.lAB) / 360.0f) * 100.0f);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(31001);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.mPaint.setColor(this.mContext.getResources().getColor(R.color.x6));
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
        this.mPaint.setColor(this.mContext.getResources().getColor(R.color.x3));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.lAB), false, this.mPaint);
        AppMethodBeat.o(31001);
    }

    private void dCN() {
        AppMethodBeat.i(31002);
        this.fbD.removeCallbacks(this.lAD);
        this.fbD.postDelayed(this.lAD, 0);
        AppMethodBeat.o(31002);
    }
}
