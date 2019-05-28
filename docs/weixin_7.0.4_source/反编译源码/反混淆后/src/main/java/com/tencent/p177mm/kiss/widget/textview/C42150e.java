package com.tencent.p177mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.kiss.widget.textview.e */
public final class C42150e {
    private final C45416d[] eNK = new C45416d[3];
    /* renamed from: gI */
    private int f17166gI;
    private final Object mLock = new Object();

    public C42150e() {
        AppMethodBeat.m2504i(105714);
        AppMethodBeat.m2505o(105714);
    }

    /* renamed from: SP */
    public final C45416d mo67689SP() {
        C45416d c45416d = null;
        synchronized (this.mLock) {
            if (this.f17166gI > 0) {
                int i = this.f17166gI - 1;
                c45416d = this.eNK[i];
                this.eNK[i] = null;
                this.f17166gI--;
            }
        }
        return c45416d;
    }

    /* renamed from: a */
    public final boolean mo67690a(C45416d c45416d) {
        AppMethodBeat.m2504i(105715);
        synchronized (this.mLock) {
            boolean z;
            int i = 0;
            while (i < this.f17166gI) {
                try {
                    if (this.eNK[i] == c45416d) {
                        z = true;
                        break;
                    }
                    i++;
                } finally {
                    AppMethodBeat.m2505o(105715);
                }
            }
            z = false;
            if (z) {
                Object illegalStateException = new IllegalStateException("Already in the pool!");
                throw illegalStateException;
            }
            c45416d.eNx = null;
            c45416d.eNy = null;
            c45416d.eNz = 0;
            c45416d.eNA = 0;
            c45416d.eNB = new TextPaint();
            c45416d.width = 0;
            c45416d.eNC = Alignment.ALIGN_NORMAL;
            c45416d.gravity = 51;
            c45416d.eND = null;
            c45416d.eNE = 0;
            c45416d.maxLines = BaseClientBuilder.API_PRIORITY_OTHER;
            c45416d.eNF = null;
            c45416d.eNG = 0.0f;
            c45416d.eNH = 1.0f;
            c45416d.eNI = false;
            c45416d.maxLength = 0;
            c45416d.eNJ = null;
            if (this.f17166gI < this.eNK.length) {
                this.eNK[this.f17166gI] = c45416d;
                this.f17166gI++;
                AppMethodBeat.m2505o(105715);
                return true;
            }
            AppMethodBeat.m2505o(105715);
            return false;
        }
    }
}
