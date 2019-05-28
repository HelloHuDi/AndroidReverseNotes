package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMAutoSizeTextView */
public class MMAutoSizeTextView extends TextView {
    private float noa;
    /* renamed from: vQ */
    private Paint f16208vQ;
    private float ytH;
    private float ytI;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106484);
        init();
        AppMethodBeat.m2505o(106484);
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106485);
        init();
        AppMethodBeat.m2505o(106485);
    }

    private void init() {
        AppMethodBeat.m2504i(106486);
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.ytH = (float) C1338a.fromDPToPix(getContext(), 8);
        this.ytI = (float) C1338a.fromDPToPix(getContext(), 22);
        this.f16208vQ = new Paint();
        this.f16208vQ.set(getPaint());
        dzD();
        AppMethodBeat.m2505o(106486);
    }

    /* renamed from: ex */
    private void m70237ex(String str, int i) {
        AppMethodBeat.m2504i(106487);
        C4990ab.m7417i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", str, Integer.valueOf(i));
        if (i <= 0) {
            AppMethodBeat.m2505o(106487);
            return;
        }
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        dzD();
        float f = this.noa;
        this.f16208vQ.setTextSize(f);
        while (f > this.ytH && this.f16208vQ.measureText(str) > ((float) paddingLeft)) {
            f -= 1.0f;
            if (f <= this.ytH) {
                f = this.ytH;
                break;
            }
            this.f16208vQ.setTextSize(f);
        }
        C4990ab.m7417i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", Float.valueOf(f), Float.valueOf(this.noa), Float.valueOf(this.f16208vQ.measureText(str)), Integer.valueOf(paddingLeft));
        setTextSize(0, f);
        AppMethodBeat.m2505o(106487);
    }

    private void dzD() {
        AppMethodBeat.m2504i(106488);
        this.noa = getTextSize();
        if (this.noa <= this.ytH) {
            this.noa = this.ytI;
        }
        AppMethodBeat.m2505o(106488);
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AppMethodBeat.m2504i(106489);
        C4990ab.m7420w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        m70237ex(charSequence.toString(), getWidth());
        AppMethodBeat.m2505o(106489);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106490);
        C4990ab.m7420w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            m70237ex(getText().toString(), i);
        }
        AppMethodBeat.m2505o(106490);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106491);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(106491);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(106491);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(106492);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(106492);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(106492);
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(106493);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(106493);
            return baseline;
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(106493);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(106494);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(106494);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(106494);
            return true;
        }
    }
}
