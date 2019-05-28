package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;

public final class v {
    private static v lwR = null;
    public al fPG = new al();
    final HashMap<Long, Integer> lwS = new HashMap();

    private v() {
        AppMethodBeat.i(19630);
        AppMethodBeat.o(19630);
    }

    public static v bpz() {
        AppMethodBeat.i(19631);
        if (lwR == null) {
            lwR = new v();
        }
        v vVar = lwR;
        AppMethodBeat.o(19631);
        return vVar;
    }
}
