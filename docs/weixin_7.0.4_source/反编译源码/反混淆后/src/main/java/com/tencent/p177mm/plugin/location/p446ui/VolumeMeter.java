package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.location.ui.VolumeMeter */
public class VolumeMeter extends ImageView implements Runnable {
    private Paint aFY;
    public boolean fAA = false;
    private Context mContext;
    private float maxRadius;
    public boolean nOg = false;
    private View nOh;
    private int nOi = -1;
    private int nOj = -1;
    public C7306ak nOk = null;
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

    /* renamed from: com.tencent.mm.plugin.location.ui.VolumeMeter$1 */
    class C211771 implements Runnable {
        C211771() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113577);
            Looper.prepare();
            VolumeMeter.this.nOk = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(113577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.VolumeMeter$2 */
    class C283722 implements Runnable {
        C283722() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113578);
            VolumeMeter.this.nOk = new C7306ak();
            VolumeMeter.this.bKh();
            AppMethodBeat.m2505o(113578);
        }
    }

    public final void bKh() {
        AppMethodBeat.m2504i(113579);
        if (this.nOk == null) {
            new C7306ak().postDelayed(new C283722(), 100);
            AppMethodBeat.m2505o(113579);
            return;
        }
        this.nOk.post(this);
        AppMethodBeat.m2505o(113579);
    }

    public void run() {
        AppMethodBeat.m2504i(113580);
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
        AppMethodBeat.m2505o(113580);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113581);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113581);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113582);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113582);
    }

    private void init() {
        AppMethodBeat.m2504i(113583);
        this.aFY = new Paint();
        AppMethodBeat.m2505o(113583);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(113584);
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
                    int b = C4977b.m7371b(this.mContext, 50.0f);
                    this.nOi = iArr[0] + (width / 2);
                    this.nOj = (iArr[1] + (height / 2)) - (b / 2);
                    this.nOu = (float) (width / 2);
                    this.maxRadius = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.nOi < 0 || this.nOj < 0) {
            AppMethodBeat.m2505o(113584);
            return;
        }
        this.aFY.setColor(this.nOp);
        this.aFY.setAlpha(this.nOq);
        float b2 = (float) C4977b.m7371b(this.mContext, this.radius);
        if (b2 > this.maxRadius) {
            b2 = this.maxRadius;
        }
        if (b2 < this.nOu) {
            b2 = this.nOu;
        }
        canvas.drawCircle((float) this.nOi, (float) this.nOj, b2, this.aFY);
        AppMethodBeat.m2505o(113584);
    }

    public final void reset() {
        AppMethodBeat.m2504i(113585);
        this.radius = 0.0f;
        this.nOl = 0.0f;
        this.nOm = 0.0f;
        this.nOn = 0.0f;
        this.nOo = 0.0f;
        postInvalidate();
        AppMethodBeat.m2505o(113585);
    }

    public void setVolume(float f) {
        this.nOl = this.nOm;
        this.nOm = f;
    }

    public void setArchView(View view) {
        this.nOh = view;
    }
}
