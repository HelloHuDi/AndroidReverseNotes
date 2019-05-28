package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private final d[] eNK = new d[3];
    private int gI;
    private final Object mLock = new Object();

    public e() {
        AppMethodBeat.i(105714);
        AppMethodBeat.o(105714);
    }

    public final d SP() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.gI > 0) {
                int i = this.gI - 1;
                dVar = this.eNK[i];
                this.eNK[i] = null;
                this.gI--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(105715);
        synchronized (this.mLock) {
            boolean z;
            int i = 0;
            while (i < this.gI) {
                try {
                    if (this.eNK[i] == dVar) {
                        z = true;
                        break;
                    }
                    i++;
                } finally {
                    AppMethodBeat.o(105715);
                }
            }
            z = false;
            if (z) {
                Object illegalStateException = new IllegalStateException("Already in the pool!");
                throw illegalStateException;
            }
            dVar.eNx = null;
            dVar.eNy = null;
            dVar.eNz = 0;
            dVar.eNA = 0;
            dVar.eNB = new TextPaint();
            dVar.width = 0;
            dVar.eNC = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.eND = null;
            dVar.eNE = 0;
            dVar.maxLines = BaseClientBuilder.API_PRIORITY_OTHER;
            dVar.eNF = null;
            dVar.eNG = 0.0f;
            dVar.eNH = 1.0f;
            dVar.eNI = false;
            dVar.maxLength = 0;
            dVar.eNJ = null;
            if (this.gI < this.eNK.length) {
                this.eNK[this.gI] = dVar;
                this.gI++;
                AppMethodBeat.o(105715);
                return true;
            }
            AppMethodBeat.o(105715);
            return false;
        }
    }
}
