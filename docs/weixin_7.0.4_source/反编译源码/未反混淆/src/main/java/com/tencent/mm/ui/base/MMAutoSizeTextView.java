package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMAutoSizeTextView extends TextView {
    private float noa;
    private Paint vQ;
    private float ytH;
    private float ytI;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106484);
        init();
        AppMethodBeat.o(106484);
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106485);
        init();
        AppMethodBeat.o(106485);
    }

    private void init() {
        AppMethodBeat.i(106486);
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.ytH = (float) a.fromDPToPix(getContext(), 8);
        this.ytI = (float) a.fromDPToPix(getContext(), 22);
        this.vQ = new Paint();
        this.vQ.set(getPaint());
        dzD();
        AppMethodBeat.o(106486);
    }

    private void ex(String str, int i) {
        AppMethodBeat.i(106487);
        ab.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", str, Integer.valueOf(i));
        if (i <= 0) {
            AppMethodBeat.o(106487);
            return;
        }
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        dzD();
        float f = this.noa;
        this.vQ.setTextSize(f);
        while (f > this.ytH && this.vQ.measureText(str) > ((float) paddingLeft)) {
            f -= 1.0f;
            if (f <= this.ytH) {
                f = this.ytH;
                break;
            }
            this.vQ.setTextSize(f);
        }
        ab.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", Float.valueOf(f), Float.valueOf(this.noa), Float.valueOf(this.vQ.measureText(str)), Integer.valueOf(paddingLeft));
        setTextSize(0, f);
        AppMethodBeat.o(106487);
    }

    private void dzD() {
        AppMethodBeat.i(106488);
        this.noa = getTextSize();
        if (this.noa <= this.ytH) {
            this.noa = this.ytI;
        }
        AppMethodBeat.o(106488);
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AppMethodBeat.i(106489);
        ab.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        ex(charSequence.toString(), getWidth());
        AppMethodBeat.o(106489);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106490);
        ab.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            ex(getText().toString(), i);
        }
        AppMethodBeat.o(106490);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106491);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(106491);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(106491);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(106492);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(106492);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(106492);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(106493);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(106493);
            return baseline;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(106493);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(106494);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(106494);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(106494);
            return true;
        }
    }
}
