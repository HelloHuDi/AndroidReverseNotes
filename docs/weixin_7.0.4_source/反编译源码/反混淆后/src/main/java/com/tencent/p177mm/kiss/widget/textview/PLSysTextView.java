package com.tencent.p177mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.kiss.widget.textview.PLSysTextView */
public class PLSysTextView extends SysTextView {
    public PLSysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLSysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(105700);
        if (C5046bo.m7519ac(charSequence)) {
            if (C18527h.DEBUG) {
                C4990ab.m7410d("MicroMsg.PLSysTextView", "set null text");
            }
            AppMethodBeat.m2505o(105700);
            return;
        }
        boolean z;
        long j = 0;
        if (C18527h.DEBUG) {
            j = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().eNL) {
            C37873c.eNj.mo60604a(getConfig(), getLayoutWrapper());
        }
        C37874f a = C37873c.eNj.mo60603a(getConfig(), charSequence);
        if (a != null) {
            setTextLayout(a);
            z = true;
        } else {
            super.setText$609c24db(charSequence);
            z = false;
        }
        if (C18527h.DEBUG) {
            C4990ab.m7411d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", Double.valueOf(((double) (System.currentTimeMillis() - j)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence);
        }
        AppMethodBeat.m2505o(105700);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(105701);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(105701);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(105702);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(105702);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(105703);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().eNL = false;
        }
        AppMethodBeat.m2505o(105703);
    }

    public boolean onPreDraw() {
        return true;
    }
}
