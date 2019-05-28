package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a;
import java.util.ArrayList;

public final class c {
    public static void kT(int i) {
        AppMethodBeat.i(94179);
        ((a) e.C(a.class)).f(762, (long) i, 1);
        AppMethodBeat.o(94179);
    }

    public static void cZ(int i, int i2) {
        AppMethodBeat.i(94180);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        ((a) e.C(a.class)).b(arrayList, true);
        AppMethodBeat.o(94180);
    }
}
