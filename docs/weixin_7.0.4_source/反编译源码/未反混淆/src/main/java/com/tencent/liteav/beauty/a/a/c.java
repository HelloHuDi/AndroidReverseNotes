package com.tencent.liteav.beauty.a.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends b {
    private Surface b;
    private boolean c;

    public c(a aVar, int i, int i2, boolean z) {
        super(aVar);
        AppMethodBeat.i(66844);
        a(i, i2);
        this.c = z;
        AppMethodBeat.o(66844);
    }

    public void c() {
        AppMethodBeat.i(66845);
        a();
        if (this.b != null) {
            if (this.c) {
                this.b.release();
            }
            this.b = null;
        }
        AppMethodBeat.o(66845);
    }
}
