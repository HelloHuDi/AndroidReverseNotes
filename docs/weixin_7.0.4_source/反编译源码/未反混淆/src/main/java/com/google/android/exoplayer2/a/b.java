package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class b {
    public static final b aPz;
    public final int aPA;
    public final int aPB;
    AudioAttributes aPC;
    public final int flags;

    public static final class a {
        int aPA = 0;
        int aPB = 1;
        int flags = 0;
    }

    private /* synthetic */ b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    static {
        AppMethodBeat.i(94644);
        a aVar = new a();
        aPz = new b(aVar.aPA, aVar.flags, aVar.aPB, (byte) 0);
        AppMethodBeat.o(94644);
    }

    private b(int i, int i2, int i3) {
        this.aPA = i;
        this.flags = i2;
        this.aPB = i3;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(94643);
        if (this == obj) {
            AppMethodBeat.o(94643);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(94643);
            return false;
        } else {
            b bVar = (b) obj;
            if (this.aPA == bVar.aPA && this.flags == bVar.flags && this.aPB == bVar.aPB) {
                AppMethodBeat.o(94643);
                return true;
            }
            AppMethodBeat.o(94643);
            return false;
        }
    }

    public final int hashCode() {
        return ((((this.aPA + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.flags) * 31) + this.aPB;
    }
}
