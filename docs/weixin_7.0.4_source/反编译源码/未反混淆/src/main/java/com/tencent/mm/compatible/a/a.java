package com.tencent.mm.compatible.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class a {

    public interface a {
        void run();
    }

    public static boolean a(int i, a aVar) {
        AppMethodBeat.i(51922);
        if (d.iW(i)) {
            aVar.run();
            AppMethodBeat.o(51922);
            return true;
        }
        AppMethodBeat.o(51922);
        return false;
    }
}
