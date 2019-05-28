package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.tencent.neattextview.textview.layout.e */
public final class C5785e<E> {
    private final Class<? extends E> AkO;
    public int AkP = 0;
    public E[] AkQ;
    public int[] AkR;
    public int[] AkS;
    public int[] AkT;

    C5785e(Class<? extends E> cls) {
        this.AkO = cls;
    }

    /* renamed from: a */
    public final void mo11863a(Spanned spanned, int i) {
        AppMethodBeat.m2504i(3258);
        if (r3 > 0 && (this.AkQ == null || this.AkQ.length < r3)) {
            this.AkQ = (Object[]) Array.newInstance(this.AkO, r3);
            this.AkR = new int[r3];
            this.AkS = new int[r3];
            this.AkT = new int[r3];
        }
        this.AkP = 0;
        for (Object obj : spanned.getSpans(0, i, this.AkO)) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart != spanEnd) {
                int spanFlags = spanned.getSpanFlags(obj);
                this.AkQ[this.AkP] = obj;
                this.AkR[this.AkP] = spanStart;
                this.AkS[this.AkP] = spanEnd;
                this.AkT[this.AkP] = spanFlags;
                this.AkP++;
            }
        }
        AppMethodBeat.m2505o(3258);
    }

    /* renamed from: hS */
    public final E mo11864hS(int i, int i2) {
        int i3 = 0;
        while (i3 < this.AkP) {
            if (this.AkR[i3] < i2 && this.AkS[i3] > i) {
                return this.AkQ[i3];
            }
            i3++;
        }
        return null;
    }
}
