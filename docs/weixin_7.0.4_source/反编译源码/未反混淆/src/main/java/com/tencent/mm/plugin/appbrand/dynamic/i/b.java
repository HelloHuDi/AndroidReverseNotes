package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import java.util.ArrayList;

public final class b {
    private static a hoL = new a();
    private static a hoM = new a();

    static class a {
        volatile int count;
        volatile long hoN;
        volatile long hoO;
        volatile long hoP;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.hoN = 0;
            this.hoO = 0;
            this.count = 0;
        }
    }

    static {
        AppMethodBeat.i(10976);
        AppMethodBeat.o(10976);
    }

    public static void f(long j, int i) {
        AppMethodBeat.i(10973);
        if (j <= 0 || i <= 0) {
            AppMethodBeat.o(10973);
            return;
        }
        switch (h.QE()) {
            case 1:
                a(hoM, j, i);
                AppMethodBeat.o(10973);
                return;
            default:
                a(hoL, j, i);
                AppMethodBeat.o(10973);
                return;
        }
    }

    public static void aAj() {
        AppMethodBeat.i(10974);
        a(5, 6, 7, 8, hoM);
        a(0, 1, 2, 3, hoL);
        hoM.reset();
        hoL.reset();
        AppMethodBeat.o(10974);
    }

    private static void a(a aVar, long j, int i) {
        synchronized (aVar) {
            aVar.hoN += j / 1000;
            aVar.hoO += (long) i;
            aVar.hoP += j / ((long) i);
            aVar.count++;
        }
    }

    private static void a(int i, int i2, int i3, int i4, a aVar) {
        AppMethodBeat.i(10975);
        int i5 = aVar.count;
        long j = aVar.hoN;
        long j2 = aVar.hoO;
        long j3 = aVar.hoP;
        if (j <= 0 || j2 <= 0 || i5 <= 0 || j3 <= 0) {
            AppMethodBeat.o(10975);
            return;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(690);
        iDKey.SetKey(i);
        iDKey.SetValue(j);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(690);
        iDKey2.SetKey(i2);
        iDKey2.SetValue(j2);
        arrayList.add(iDKey2);
        iDKey2 = new IDKey();
        iDKey2.SetID(690);
        iDKey2.SetKey(i3);
        iDKey2.SetValue((long) i5);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(690);
        iDKey3.SetKey(i4);
        iDKey3.SetValue(j3);
        arrayList.add(iDKey3);
        com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, false);
        AppMethodBeat.o(10975);
    }
}
