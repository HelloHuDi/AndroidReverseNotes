package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c */
public final class C42484c {
    /* renamed from: kT */
    public static void m75254kT(int i) {
        AppMethodBeat.m2504i(94179);
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(762, (long) i, 1);
        AppMethodBeat.m2505o(94179);
    }

    /* renamed from: cZ */
    public static void m75253cZ(int i, int i2) {
        AppMethodBeat.m2504i(94180);
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
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6306b(arrayList, true);
        AppMethodBeat.m2505o(94180);
    }
}
