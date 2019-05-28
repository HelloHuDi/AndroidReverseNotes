package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class WebViewBagBgView extends View {
    int mDuration;
    private Paint mPaint = new Paint();
    long mStartTime;
    private RectF nI;
    int svV;
    private int uzg = -7829368;
    private int uzh = -65536;
    private float uzi = 0.0f;
    private float uzj;
    private float uzk;
    private int uzl;
    private int uzm;
    boolean uzn;

    public WebViewBagBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8198);
        this.mPaint.setAntiAlias(true);
        this.uzm = -1;
        AppMethodBeat.o(8198);
    }

    public void setStartColor(int i) {
        this.uzg = i;
    }

    public void setAngryColor(int i) {
        this.uzh = i;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(8199);
        super.onDraw(canvas);
        if (this.uzk == this.uzj) {
            this.uzj -= 0.001f;
        }
        this.mPaint.setShader(new LinearGradient(0.0f, this.uzj, 0.0f, this.uzk, new int[]{this.uzg, this.uzh}, null, TileMode.CLAMP));
        canvas.drawOval(this.nI, this.mPaint);
        if (this.uzn && this.uzk > 0.0f) {
            this.uzj -= this.uzi;
            this.uzj = this.uzj < ((float) (-this.uzl)) ? (float) (-this.uzl) : this.uzj;
            this.uzk = ((float) this.uzm) - this.uzj < ((float) this.uzl) ? (float) this.uzm : this.uzj + ((float) this.uzl);
            postInvalidateDelayed((long) this.svV);
        }
        AppMethodBeat.o(8199);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(8200);
        super.onMeasure(i, i2);
        this.uzm = MeasureSpec.getSize(i);
        this.nI = new RectF(0.0f, 0.0f, (float) this.uzm, (float) this.uzm);
        this.uzl = this.uzm / 2;
        lT(System.currentTimeMillis());
        AppMethodBeat.o(8200);
    }

    /* Access modifiers changed, original: final */
    public final void lT(long j) {
        AppMethodBeat.i(8201);
        if (this.uzm < 0) {
            ab.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", Integer.valueOf(this.uzm));
            AppMethodBeat.o(8201);
            return;
        }
        float f;
        WebViewBagBgView webViewBagBgView;
        this.uzi = ((float) (this.uzm * 2)) / (((float) this.mDuration) / ((float) this.svV));
        if (j - this.mStartTime <= 0) {
            f = (float) this.uzm;
            webViewBagBgView = this;
        } else {
            this.uzj = ((float) this.uzm) - (((float) (((int) (((float) (j - this.mStartTime)) / ((float) this.svV))) + 1)) * this.uzi);
            if (this.uzj < ((float) (-this.uzl))) {
                f = (float) (-this.uzl);
                webViewBagBgView = this;
            } else {
                f = this.uzj;
                webViewBagBgView = this;
            }
        }
        webViewBagBgView.uzj = f;
        this.uzk = ((float) this.uzm) - this.uzj < ((float) this.uzl) ? (float) this.uzm : this.uzj + ((float) this.uzl);
        AppMethodBeat.o(8201);
    }
}
