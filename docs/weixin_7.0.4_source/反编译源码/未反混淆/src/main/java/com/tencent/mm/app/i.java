package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class i implements com.tencent.e.a.b.a {

    static final class a {
        static final i cer = new i();

        static {
            AppMethodBeat.i(3230);
            AppMethodBeat.o(3230);
        }
    }

    /* synthetic */ i(byte b) {
        this();
    }

    public final void println(int i, String str, String str2) {
        AppMethodBeat.i(3231);
        switch (i) {
            case 2:
                ab.v(str, str2);
                AppMethodBeat.o(3231);
                return;
            case 3:
                ab.d(str, str2);
                AppMethodBeat.o(3231);
                return;
            case 4:
                ab.i(str, str2);
                AppMethodBeat.o(3231);
                return;
            case 5:
                ab.w(str, str2);
                AppMethodBeat.o(3231);
                return;
            case 6:
                ab.e(str, str2);
                break;
        }
        AppMethodBeat.o(3231);
    }

    public final boolean isLoggable(String str, int i) {
        return true;
    }

    private i() {
    }
}
