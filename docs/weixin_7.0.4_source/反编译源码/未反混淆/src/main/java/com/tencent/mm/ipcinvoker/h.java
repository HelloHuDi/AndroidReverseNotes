package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class h {
    private static volatile h eGe;
    Map<String, BaseIPCService> eGf = new HashMap();

    private h() {
        AppMethodBeat.i(114042);
        AppMethodBeat.o(114042);
    }

    public static h PO() {
        AppMethodBeat.i(114043);
        if (eGe == null) {
            synchronized (h.class) {
                try {
                    if (eGe == null) {
                        eGe = new h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114043);
                    }
                }
            }
        }
        h hVar = eGe;
        AppMethodBeat.o(114043);
        return hVar;
    }

    public final BaseIPCService lj(String str) {
        AppMethodBeat.i(114044);
        BaseIPCService baseIPCService = (BaseIPCService) this.eGf.get(str);
        AppMethodBeat.o(114044);
        return baseIPCService;
    }
}
