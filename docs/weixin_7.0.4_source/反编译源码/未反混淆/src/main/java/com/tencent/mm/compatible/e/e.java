package com.tencent.mm.compatible.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a;

final class e implements a {
    e() {
    }

    public static a.a b(Looper looper) {
        AppMethodBeat.i(92927);
        a.a aVar = new a.a();
        try {
            aVar.erH = u.c(looper);
            aVar.rotate = 0;
            if (aVar.erH == null) {
                AppMethodBeat.o(92927);
                return null;
            }
            AppMethodBeat.o(92927);
            return aVar;
        } catch (Exception e) {
            AppMethodBeat.o(92927);
            return null;
        }
    }
}
