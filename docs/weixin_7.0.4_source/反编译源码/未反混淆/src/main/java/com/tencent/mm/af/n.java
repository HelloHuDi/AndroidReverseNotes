package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class n {
    public int fjt;
    public int fju;

    public static final n mj(String str) {
        AppMethodBeat.i(16198);
        n nVar = new n();
        b X = b.X(str, null);
        if (X != null) {
            Map map = X.fjf;
            if (map != null) {
                nVar.fjt = bo.getInt((String) map.get(".msg.appmsg.xmlfulllen"), 0);
                nVar.fju = bo.getInt((String) map.get(".msg.appmsg.realinnertype"), 0);
            }
        }
        AppMethodBeat.o(16198);
        return nVar;
    }
}
