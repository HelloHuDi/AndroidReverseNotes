package com.tencent.p177mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.kiss.widget.textview.PLTextView */
public class PLTextView extends StaticTextView {
    private static long eNl = 0;
    private static int eNm = 0;
    private static long eNn = -2147483648L;
    private static long eNo = 0;
    private static int eNp = 0;
    private static long eNq = -2147483648L;
    private static long eNr = 0;
    private static int eNs = 0;
    private static long eNt = -2147483648L;
    private static boolean eNu = false;

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(105704);
        if (C5046bo.m7519ac(charSequence)) {
            if (C18527h.DEBUG) {
                C4990ab.m7410d("MicroMsg.PLTextView", "set null text");
            }
            AppMethodBeat.m2505o(105704);
            return;
        }
        boolean z;
        long j = 0;
        long j2 = 0;
        if (C18527h.DEBUG) {
            j = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().eNL) {
            C37873c.eNj.mo60604a(getConfig(), getLayoutWrapper());
        }
        C37874f a = C37873c.eNj.mo60603a(getConfig(), charSequence);
        if (a != null) {
            z = true;
            mo33774w(charSequence);
            setTextLayout(a);
        } else {
            z = false;
            mo33773v(charSequence);
        }
        if (C18527h.DEBUG) {
            j2 = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", Double.valueOf(((double) (j2 - j)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z));
        }
        long j3 = j2;
        if (eNu) {
            j = j3 - j;
            eNl += j;
            eNm++;
            if (j > eNn) {
                eNn = j;
            }
        }
        AppMethodBeat.m2505o(105704);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(105705);
        long j = 0;
        if (eNu) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (eNu) {
            j = System.currentTimeMillis() - j;
            eNo += j;
            eNp++;
            if (j > eNq) {
                eNq = j;
            }
        }
        AppMethodBeat.m2505o(105705);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(105706);
        long j = 0;
        if (eNu) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (eNu) {
            j = System.currentTimeMillis() - j;
            eNr += j;
            eNs++;
            if (j > eNt) {
                eNt = j;
            }
        }
        AppMethodBeat.m2505o(105706);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: v */
    public void mo33773v(CharSequence charSequence) {
        AppMethodBeat.m2504i(105707);
        super.setText(charSequence, false);
        AppMethodBeat.m2505o(105707);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: w */
    public void mo33774w(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(105708);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().eNL = false;
        }
        AppMethodBeat.m2505o(105708);
    }
}
