package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public a eNR;

    public static b ST() {
        AppMethodBeat.i(105816);
        b bVar = new b();
        bVar.eNR = new a();
        AppMethodBeat.o(105816);
        return bVar;
    }

    public final b SU() {
        this.eNR.maxLines = 6;
        return this;
    }

    public final b a(TruncateAt truncateAt) {
        this.eNR.eND = truncateAt;
        return this;
    }

    public final b jU(int i) {
        this.eNR.gravity = i;
        return this;
    }

    public final b ad(float f) {
        this.eNR.eOg = f;
        return this;
    }

    public final b jV(int i) {
        this.eNR.textColor = i;
        return this;
    }
}
