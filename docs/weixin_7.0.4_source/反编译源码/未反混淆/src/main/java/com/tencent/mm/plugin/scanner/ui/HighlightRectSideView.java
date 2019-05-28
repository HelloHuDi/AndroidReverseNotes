package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public class HighlightRectSideView extends View {
    private ap gyS = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(81023);
            HighlightRectSideView.this.qcw = HighlightRectSideView.this.qcw + 1;
            HighlightRectSideView.this.invalidate();
            AppMethodBeat.o(81023);
            return true;
        }
    }, true);
    private boolean[] qcr;
    private Rect qcs;
    private int qct;
    private int qcu;
    private int qcv;
    private int qcw = 0;
    private Paint vw;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(81024);
        Bitmap decodeResource = com.tencent.mm.compatible.g.a.decodeResource(getResources(), R.drawable.ani);
        this.qct = decodeResource.getWidth();
        this.qcu = decodeResource.getHeight();
        if (this.qcu != this.qct) {
            ab.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.qcv = (this.qct * 6) / 24;
        this.qcr = new boolean[4];
        this.vw = new Paint();
        this.vw.setColor(6676738);
        this.vw.setAlpha(255);
        this.vw.setStrokeWidth((float) this.qcv);
        this.vw.setStyle(Style.STROKE);
        AppMethodBeat.o(81024);
    }

    public void setMaskRect(Rect rect) {
        AppMethodBeat.i(81025);
        this.qcs = rect;
        ab.d("MicroMsg.HighlightRectSideView", "rect:%s", rect);
        AppMethodBeat.o(81025);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(81026);
        super.onAttachedToWindow();
        this.gyS.ae(300, 300);
        AppMethodBeat.o(81026);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(81027);
        super.onDetachedFromWindow();
        if (this.gyS != null) {
            this.gyS.stopTimer();
            this.gyS = null;
        }
        AppMethodBeat.o(81027);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int i;
        AppMethodBeat.i(81028);
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.qcr[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.qcv / 2;
        if (this.qcr[0] && (1 == i || this.qcw % 2 == 0)) {
            canvas.drawLine((float) (this.qcs.left + i3), (float) (this.qcs.top + this.qcu), (float) (this.qcs.left + i3), (float) (this.qcs.bottom - this.qcu), this.vw);
        }
        if (this.qcr[1] && (1 == i || this.qcw % 2 == 0)) {
            canvas.drawLine((float) (this.qcs.right - i3), (float) (this.qcs.top + this.qcu), (float) (this.qcs.right - i3), (float) (this.qcs.bottom - this.qcu), this.vw);
        }
        if (this.qcr[2] && (1 == i || this.qcw % 3 == 0)) {
            canvas.drawLine((float) (this.qcs.left + this.qct), (float) (this.qcs.top + i3), (float) (this.qcs.right - this.qct), (float) (this.qcs.top + i3), this.vw);
        }
        if (this.qcr[3] && (1 == i || this.qcw % 3 == 0)) {
            canvas.drawLine((float) (this.qcs.left + this.qct), (float) (this.qcs.bottom - i3), (float) (this.qcs.right - this.qct), (float) (this.qcs.bottom - i3), this.vw);
        }
        AppMethodBeat.o(81028);
    }

    public void setShowRectEdges(boolean[] zArr) {
        int i = 0;
        AppMethodBeat.i(81029);
        if (zArr == null || 4 != zArr.length) {
            AppMethodBeat.o(81029);
            return;
        }
        ab.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3]));
        while (i < 4) {
            this.qcr[i] = zArr[i];
            i++;
        }
        invalidate();
        AppMethodBeat.o(81029);
    }
}
