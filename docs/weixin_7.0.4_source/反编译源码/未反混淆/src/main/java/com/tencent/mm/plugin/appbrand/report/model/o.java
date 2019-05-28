package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

public final class o {

    public enum a {
        GUIDE_EXPOSE(1),
        GUIDE_CLOSE(2),
        TO_APP_LAUNCHER(3),
        GUIDE_CLOSE_BY_BACK(4);
        
        final int value;

        static {
            AppMethodBeat.o(132662);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public static void a(a aVar, String str) {
        AppMethodBeat.i(132663);
        e.pXa.e(14750, Integer.valueOf(aVar.value), str);
        AppMethodBeat.o(132663);
    }
}
