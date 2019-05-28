package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class PLSysTextView extends SysTextView {
    public PLSysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLSysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(105700);
        if (bo.ac(charSequence)) {
            if (h.DEBUG) {
                ab.d("MicroMsg.PLSysTextView", "set null text");
            }
            AppMethodBeat.o(105700);
            return;
        }
        boolean z;
        long j = 0;
        if (h.DEBUG) {
            j = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().eNL) {
            c.eNj.a(getConfig(), getLayoutWrapper());
        }
        f a = c.eNj.a(getConfig(), charSequence);
        if (a != null) {
            setTextLayout(a);
            z = true;
        } else {
            super.setText$609c24db(charSequence);
            z = false;
        }
        if (h.DEBUG) {
            ab.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", Double.valueOf(((double) (System.currentTimeMillis() - j)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence);
        }
        AppMethodBeat.o(105700);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(105701);
        super.onMeasure(i, i2);
        AppMethodBeat.o(105701);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(105702);
        super.onDraw(canvas);
        AppMethodBeat.o(105702);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(105703);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().eNL = false;
        }
        AppMethodBeat.o(105703);
    }

    public boolean onPreDraw() {
        return true;
    }
}
