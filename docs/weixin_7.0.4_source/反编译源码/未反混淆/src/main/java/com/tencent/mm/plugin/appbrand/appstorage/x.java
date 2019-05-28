package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.o;

public interface x {

    public enum a implements com.tencent.mm.plugin.appbrand.appstorage.a.a {
        ;

        private a(String str) {
        }

        static {
            AppMethodBeat.o(129526);
        }

        public final int ys(String str) {
            AppMethodBeat.i(129525);
            o wI = com.tencent.mm.plugin.appbrand.a.wI(str);
            if (wI == null || wI.atI() == null) {
                AppMethodBeat.o(129525);
                return 0;
            }
            int i = wI.atI().uin;
            AppMethodBeat.o(129525);
            return i;
        }
    }

    public enum b implements com.tencent.mm.plugin.appbrand.appstorage.a.a {
        ;

        private b(String str) {
        }

        static {
            AppMethodBeat.o(129530);
        }

        public final int ys(String str) {
            AppMethodBeat.i(129529);
            g.RN();
            int QF = com.tencent.mm.kernel.a.QF();
            AppMethodBeat.o(129529);
            return QF;
        }
    }
}
