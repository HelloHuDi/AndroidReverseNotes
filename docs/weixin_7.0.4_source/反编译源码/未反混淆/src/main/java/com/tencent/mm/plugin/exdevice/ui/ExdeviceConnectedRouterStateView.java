package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ak;

public class ExdeviceConnectedRouterStateView extends ImageView {
    private int bottom;
    private ak fbD;
    int lAB;
    private int lAC;
    private Runnable lAD;
    private int left;
    private Context mContext;
    private Paint mPaint;
    private int right;
    private int state;
    private int top;

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(19930);
        this.lAB = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lAC = -1;
        this.lAD = new Runnable() {
            public final void run() {
                AppMethodBeat.i(19929);
                ExdeviceConnectedRouterStateView.this.invalidate();
                AppMethodBeat.o(19929);
            }
        };
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.lAC = a.fromDPToPix(this.mContext, 3);
        this.fbD = new ak(Looper.getMainLooper());
        AppMethodBeat.o(19930);
    }

    public void setState(int i) {
        AppMethodBeat.i(19931);
        this.state = i;
        uR(10);
        AppMethodBeat.o(19931);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(19932);
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.mPaint.setARGB(255, 103, 209, 79);
            this.mPaint.setStrokeWidth((float) this.lAC);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.lAB, false, this.mPaint);
            this.lAB += 5;
            if (this.lAB > 365) {
                this.lAB = 0;
            }
            uR(100);
        }
        AppMethodBeat.o(19932);
    }

    private void uR(int i) {
        AppMethodBeat.i(19933);
        this.fbD.removeCallbacks(this.lAD);
        this.fbD.postDelayed(this.lAD, (long) i);
        AppMethodBeat.o(19933);
    }
}
