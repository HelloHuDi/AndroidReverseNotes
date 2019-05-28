package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

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
        AppMethodBeat.i(105704);
        if (bo.ac(charSequence)) {
            if (h.DEBUG) {
                ab.d("MicroMsg.PLTextView", "set null text");
            }
            AppMethodBeat.o(105704);
            return;
        }
        boolean z;
        long j = 0;
        long j2 = 0;
        if (h.DEBUG) {
            j = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().eNL) {
            c.eNj.a(getConfig(), getLayoutWrapper());
        }
        f a = c.eNj.a(getConfig(), charSequence);
        if (a != null) {
            z = true;
            w(charSequence);
            setTextLayout(a);
        } else {
            z = false;
            v(charSequence);
        }
        if (h.DEBUG) {
            j2 = System.currentTimeMillis();
            ab.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", Double.valueOf(((double) (j2 - j)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z));
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
        AppMethodBeat.o(105704);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(105705);
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
        AppMethodBeat.o(105705);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(105706);
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
        AppMethodBeat.o(105706);
    }

    /* Access modifiers changed, original: protected */
    public void v(CharSequence charSequence) {
        AppMethodBeat.i(105707);
        super.setText(charSequence, false);
        AppMethodBeat.o(105707);
    }

    /* Access modifiers changed, original: protected */
    public void w(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(105708);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().eNL = false;
        }
        AppMethodBeat.o(105708);
    }
}
