package com.tencent.mm.plugin.sns.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c implements a {
    public final int cez() {
        return 12990;
    }

    public final void t(Object... objArr) {
        AppMethodBeat.i(35694);
        e(0, objArr);
        AppMethodBeat.o(35694);
    }

    public final void e(int i, Object... objArr) {
        AppMethodBeat.i(35695);
        switch (i) {
            case 2:
                AppMethodBeat.o(35695);
                return;
            default:
                h.pYm.e(12990, objArr);
                AppMethodBeat.o(35695);
                return;
        }
    }
}
