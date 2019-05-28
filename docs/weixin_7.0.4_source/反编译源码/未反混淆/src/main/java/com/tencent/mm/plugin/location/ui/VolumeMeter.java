package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;

public class VolumeMeter extends ImageView implements Runnable {
    private Paint aFY;
    public boolean fAA = false;
    private Context mContext;
    private float maxRadius;
    public boolean nOg = false;
    private View nOh;
    private int nOi = -1;
    private int nOj = -1;
    public ak nOk = null;
    private float nOl;
    private float nOm;
    private float nOn;
    private float nOo;
    private int nOp = -6751336;
    private int nOq = 70;
    private float nOr = 0.5f;
    private float nOs = 0.001f;
    private int nOt = 20;
    private float nOu;
    private float nOv = 40.0f;
    private float nOw = 30.0f;
    private float radius = 0.0f;

    public final void bKh() {
        AppMethodBeat.i(113579);
        if (this.nOk == null) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113578);
                    VolumeMeter.this.nOk = new ak();
                    VolumeMeter.this.bKh();
                    AppMethodBeat.o(113578);
                }
            }, 100);
            AppMethodBeat.o(113579);
            return;
        }
        this.nOk.post(this);
        AppMethodBeat.o(113579);
    }

    public void run() {
        AppMethodBeat.i(113580);
        if (this.fAA) {
            float f;
            float f2 = this.nOn;
            if (this.nOm > this.nOl) {
                f = (this.nOm - this.nOl) / this.nOw;
                if (f > this.nOr) {
                    f = this.nOr;
                } else if (f < this.nOs) {
                    f = this.nOs;
                }
                f += f2;
            } else if (this.nOm <= this.nOl) {
                f = (this.nOl - this.nOm) / this.nOv;
                if (f > this.nOr) {
                    f = this.nOr;
                } else if (f < this.nOs) {
                    f = this.nOs;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.nOn = f;
            this.nOo = this.nOn;
            this.radius = ((float) ((260.0d * Math.sqrt((double) this.nOn)) - ((double) (130.0f * this.nOn)))) / 1.5f;
            postInvalidate();
            this.nOk.postDelayed(this, (long) this.nOt);
        }
        AppMethodBeat.o(113580);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113581);
        this.mContext = context;
        init();
        AppMethodBeat.o(113581);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113582);
        this.mContext = context;
        init();
        AppMethodBeat.o(113582);
    }

    private void init() {
        AppMethodBeat.i(113583);
        this.aFY = new Paint();
        AppMethodBeat.o(113583);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(113584);
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (this.nOh != null) {
            int[] iArr = new int[2];
            this.nOh.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.nOh.getWidth();
                int height = this.nOh.getHeight();
                if (!(width == 0 || height == 0)) {
                    int b = b.b(this.mContext, 50.0f);
                    this.nOi = iArr[0] + (width / 2);
                    this.nOj = (iArr[1] + (height / 2)) - (b / 2);
                    this.nOu = (float) (width / 2);
                    this.maxRadius = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.nOi < 0 || this.nOj < 0) {
            AppMethodBeat.o(113584);
            return;
        }
        this.aFY.setColor(this.nOp);
        this.aFY.setAlpha(this.nOq);
        float b2 = (float) b.b(this.mContext, this.radius);
        if (b2 > this.maxRadius) {
            b2 = this.maxRadius;
        }
        if (b2 < this.nOu) {
            b2 = this.nOu;
        }
        canvas.drawCircle((float) this.nOi, (float) this.nOj, b2, this.aFY);
        AppMethodBeat.o(113584);
    }

    public final void reset() {
        AppMethodBeat.i(113585);
        this.radius = 0.0f;
        this.nOl = 0.0f;
        this.nOm = 0.0f;
        this.nOn = 0.0f;
        this.nOo = 0.0f;
        postInvalidate();
        AppMethodBeat.o(113585);
    }

    public void setVolume(float f) {
        this.nOl = this.nOm;
        this.nOm = f;
    }

    public void setArchView(View view) {
        this.nOh = view;
    }
}
