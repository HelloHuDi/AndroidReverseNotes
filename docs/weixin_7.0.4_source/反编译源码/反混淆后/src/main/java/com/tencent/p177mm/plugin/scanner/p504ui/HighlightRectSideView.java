package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.scanner.ui.HighlightRectSideView */
public class HighlightRectSideView extends View {
    private C7564ap gyS = new C7564ap(new C348361(), true);
    private boolean[] qcr;
    private Rect qcs;
    private int qct;
    private int qcu;
    private int qcv;
    private int qcw = 0;
    /* renamed from: vw */
    private Paint f16180vw;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.HighlightRectSideView$1 */
    class C348361 implements C5015a {
        C348361() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(81023);
            HighlightRectSideView.this.qcw = HighlightRectSideView.this.qcw + 1;
            HighlightRectSideView.this.invalidate();
            AppMethodBeat.m2505o(81023);
            return true;
        }
    }

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(81024);
        Bitmap decodeResource = C1434a.decodeResource(getResources(), C25738R.drawable.ani);
        this.qct = decodeResource.getWidth();
        this.qcu = decodeResource.getHeight();
        if (this.qcu != this.qct) {
            C4990ab.m7412e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.qcv = (this.qct * 6) / 24;
        this.qcr = new boolean[4];
        this.f16180vw = new Paint();
        this.f16180vw.setColor(6676738);
        this.f16180vw.setAlpha(255);
        this.f16180vw.setStrokeWidth((float) this.qcv);
        this.f16180vw.setStyle(Style.STROKE);
        AppMethodBeat.m2505o(81024);
    }

    public void setMaskRect(Rect rect) {
        AppMethodBeat.m2504i(81025);
        this.qcs = rect;
        C4990ab.m7411d("MicroMsg.HighlightRectSideView", "rect:%s", rect);
        AppMethodBeat.m2505o(81025);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(81026);
        super.onAttachedToWindow();
        this.gyS.mo16770ae(300, 300);
        AppMethodBeat.m2505o(81026);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(81027);
        super.onDetachedFromWindow();
        if (this.gyS != null) {
            this.gyS.stopTimer();
            this.gyS = null;
        }
        AppMethodBeat.m2505o(81027);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int i;
        AppMethodBeat.m2504i(81028);
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
            canvas.drawLine((float) (this.qcs.left + i3), (float) (this.qcs.top + this.qcu), (float) (this.qcs.left + i3), (float) (this.qcs.bottom - this.qcu), this.f16180vw);
        }
        if (this.qcr[1] && (1 == i || this.qcw % 2 == 0)) {
            canvas.drawLine((float) (this.qcs.right - i3), (float) (this.qcs.top + this.qcu), (float) (this.qcs.right - i3), (float) (this.qcs.bottom - this.qcu), this.f16180vw);
        }
        if (this.qcr[2] && (1 == i || this.qcw % 3 == 0)) {
            canvas.drawLine((float) (this.qcs.left + this.qct), (float) (this.qcs.top + i3), (float) (this.qcs.right - this.qct), (float) (this.qcs.top + i3), this.f16180vw);
        }
        if (this.qcr[3] && (1 == i || this.qcw % 3 == 0)) {
            canvas.drawLine((float) (this.qcs.left + this.qct), (float) (this.qcs.bottom - i3), (float) (this.qcs.right - this.qct), (float) (this.qcs.bottom - i3), this.f16180vw);
        }
        AppMethodBeat.m2505o(81028);
    }

    public void setShowRectEdges(boolean[] zArr) {
        int i = 0;
        AppMethodBeat.m2504i(81029);
        if (zArr == null || 4 != zArr.length) {
            AppMethodBeat.m2505o(81029);
            return;
        }
        C4990ab.m7411d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3]));
        while (i < 4) {
            this.qcr[i] = zArr[i];
            i++;
        }
        invalidate();
        AppMethodBeat.m2505o(81029);
    }
}
