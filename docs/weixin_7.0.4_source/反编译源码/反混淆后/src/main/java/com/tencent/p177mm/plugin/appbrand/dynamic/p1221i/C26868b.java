package com.tencent.p177mm.plugin.appbrand.dynamic.p1221i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.i.b */
public final class C26868b {
    private static C26869a hoL = new C26869a();
    private static C26869a hoM = new C26869a();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.i.b$a */
    static class C26869a {
        volatile int count;
        volatile long hoN;
        volatile long hoO;
        volatile long hoP;

        private C26869a() {
        }

        /* synthetic */ C26869a(byte b) {
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
        AppMethodBeat.m2504i(10976);
        AppMethodBeat.m2505o(10976);
    }

    /* renamed from: f */
    public static void m42802f(long j, int i) {
        AppMethodBeat.m2504i(10973);
        if (j <= 0 || i <= 0) {
            AppMethodBeat.m2505o(10973);
            return;
        }
        switch (C41725h.m73453QE()) {
            case 1:
                C26868b.m42801a(hoM, j, i);
                AppMethodBeat.m2505o(10973);
                return;
            default:
                C26868b.m42801a(hoL, j, i);
                AppMethodBeat.m2505o(10973);
                return;
        }
    }

    public static void aAj() {
        AppMethodBeat.m2504i(10974);
        C26868b.m42800a(5, 6, 7, 8, hoM);
        C26868b.m42800a(0, 1, 2, 3, hoL);
        hoM.reset();
        hoL.reset();
        AppMethodBeat.m2505o(10974);
    }

    /* renamed from: a */
    private static void m42801a(C26869a c26869a, long j, int i) {
        synchronized (c26869a) {
            c26869a.hoN += j / 1000;
            c26869a.hoO += (long) i;
            c26869a.hoP += j / ((long) i);
            c26869a.count++;
        }
    }

    /* renamed from: a */
    private static void m42800a(int i, int i2, int i3, int i4, C26869a c26869a) {
        AppMethodBeat.m2504i(10975);
        int i5 = c26869a.count;
        long j = c26869a.hoN;
        long j2 = c26869a.hoO;
        long j3 = c26869a.hoP;
        if (j <= 0 || j2 <= 0 || i5 <= 0 || j3 <= 0) {
            AppMethodBeat.m2505o(10975);
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
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(10975);
    }
}
