package com.tencent.mm.plugin.sns.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements a {
    public final int cez() {
        return 11855;
    }

    public final void t(Object... objArr) {
        AppMethodBeat.i(35692);
        e(0, objArr);
        AppMethodBeat.o(35692);
    }

    public final void e(int i, Object... objArr) {
        AppMethodBeat.i(35693);
        switch (i) {
            case 0:
            case 1:
                h.pYm.e(11855, objArr);
                AppMethodBeat.o(35693);
                return;
            case 2:
                h.pYm.e(14646, objArr);
                AppMethodBeat.o(35693);
                return;
            default:
                ab.e("Kv_11855", "unknown type %d", Integer.valueOf(i));
                AppMethodBeat.o(35693);
                return;
        }
    }
}
