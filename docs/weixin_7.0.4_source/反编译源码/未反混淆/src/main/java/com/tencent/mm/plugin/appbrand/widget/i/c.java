package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class c {
    public void a(String str, d dVar) {
        AppMethodBeat.i(87563);
        ab.d("IconLoadErrorHandler ", "setTabBarFail: ".concat(String.valueOf(str)));
        if (dVar.jpw != null) {
            dVar.jpw.destroy(dVar.index);
        }
        AppMethodBeat.o(87563);
    }
}
