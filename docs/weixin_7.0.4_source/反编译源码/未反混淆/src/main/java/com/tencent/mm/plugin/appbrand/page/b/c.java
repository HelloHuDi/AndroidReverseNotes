package com.tencent.mm.plugin.appbrand.page.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;

public interface c {

    public static class a {
        public static c r(u uVar) {
            AppMethodBeat.i(87373);
            if (VERSION.SDK_INT >= 21) {
                a aVar = new a(uVar);
                AppMethodBeat.o(87373);
                return aVar;
            }
            c bVar = new b(uVar);
            AppMethodBeat.o(87373);
            return bVar;
        }
    }

    public enum b {
        SHOWN,
        HIDDEN;

        static {
            AppMethodBeat.o(87376);
        }
    }

    void aAS();

    void aBr();

    void aBs();

    b aBt();

    void onOrientationChanged(int i);
}
