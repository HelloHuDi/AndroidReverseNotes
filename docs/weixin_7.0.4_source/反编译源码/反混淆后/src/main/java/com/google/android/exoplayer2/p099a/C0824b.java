package com.google.android.exoplayer2.p099a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

/* renamed from: com.google.android.exoplayer2.a.b */
public final class C0824b {
    public static final C0824b aPz;
    public final int aPA;
    public final int aPB;
    AudioAttributes aPC;
    public final int flags;

    /* renamed from: com.google.android.exoplayer2.a.b$a */
    public static final class C0825a {
        int aPA = 0;
        int aPB = 1;
        int flags = 0;
    }

    private /* synthetic */ C0824b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    static {
        AppMethodBeat.m2504i(94644);
        C0825a c0825a = new C0825a();
        aPz = new C0824b(c0825a.aPA, c0825a.flags, c0825a.aPB, (byte) 0);
        AppMethodBeat.m2505o(94644);
    }

    private C0824b(int i, int i2, int i3) {
        this.aPA = i;
        this.flags = i2;
        this.aPB = i3;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(94643);
        if (this == obj) {
            AppMethodBeat.m2505o(94643);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(94643);
            return false;
        } else {
            C0824b c0824b = (C0824b) obj;
            if (this.aPA == c0824b.aPA && this.flags == c0824b.flags && this.aPB == c0824b.aPB) {
                AppMethodBeat.m2505o(94643);
                return true;
            }
            AppMethodBeat.m2505o(94643);
            return false;
        }
    }

    public final int hashCode() {
        return ((((this.aPA + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.flags) * 31) + this.aPB;
    }
}
