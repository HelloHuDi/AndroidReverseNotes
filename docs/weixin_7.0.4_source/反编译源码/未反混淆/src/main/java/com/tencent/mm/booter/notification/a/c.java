package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bo.a;
import com.tencent.mm.m.f;

public final class c {
    public int eem = -1;

    public final int B(String str, int i) {
        AppMethodBeat.i(16010);
        this.eem = a.bWV();
        if (f.ja(i)) {
            if (f.kD(str)) {
                try {
                    this.eem = R.drawable.arv;
                } catch (Exception e) {
                }
            } else if (f.kE(str)) {
                try {
                    this.eem = R.drawable.arv;
                } catch (Exception e2) {
                }
            }
        }
        if (this.eem < 0) {
            this.eem = a.bWV();
        }
        int i2 = this.eem;
        AppMethodBeat.o(16010);
        return i2;
    }
}
