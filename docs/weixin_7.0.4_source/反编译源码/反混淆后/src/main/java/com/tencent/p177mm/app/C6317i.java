package com.tencent.p177mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b.C0925a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.app.i */
public final class C6317i implements C0925a {

    /* renamed from: com.tencent.mm.app.i$a */
    static final class C1259a {
        static final C6317i cer = new C6317i();

        static {
            AppMethodBeat.m2504i(3230);
            AppMethodBeat.m2505o(3230);
        }
    }

    /* synthetic */ C6317i(byte b) {
        this();
    }

    public final void println(int i, String str, String str2) {
        AppMethodBeat.m2504i(3231);
        switch (i) {
            case 2:
                C4990ab.m7418v(str, str2);
                AppMethodBeat.m2505o(3231);
                return;
            case 3:
                C4990ab.m7410d(str, str2);
                AppMethodBeat.m2505o(3231);
                return;
            case 4:
                C4990ab.m7416i(str, str2);
                AppMethodBeat.m2505o(3231);
                return;
            case 5:
                C4990ab.m7420w(str, str2);
                AppMethodBeat.m2505o(3231);
                return;
            case 6:
                C4990ab.m7412e(str, str2);
                break;
        }
        AppMethodBeat.m2505o(3231);
    }

    public final boolean isLoggable(String str, int i) {
        return true;
    }

    private C6317i() {
    }
}
