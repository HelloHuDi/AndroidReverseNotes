package com.tencent.p177mm.plugin.appbrand.widget.p1540g;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.g.a */
public final class C38593a {
    /* renamed from: c */
    public static void m65400c(int i, long j, long j2, int i2) {
        AppMethodBeat.m2504i(67895);
        if (j <= 0 || j2 <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(67895);
            return;
        }
        int i3;
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(703);
        iDKey.SetKey(i == 1 ? 3 : 0);
        iDKey.SetValue(j);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(703);
        if (i == 1) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        iDKey.SetKey(i3);
        iDKey.SetValue(j2);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(703);
        iDKey.SetKey(i == 1 ? 5 : 2);
        iDKey.SetValue((long) i2);
        arrayList.add(iDKey);
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(67895);
    }

    /* renamed from: A */
    public static void m65398A(int i, long j) {
        int i2;
        AppMethodBeat.m2504i(67896);
        if (j <= 500000) {
            i2 = 0;
        } else if (j <= 1000000) {
            i2 = 1;
        } else if (j <= 2000000) {
            i2 = 2;
        } else if (j <= 3000000) {
            i2 = 3;
        } else if (j <= 4000000) {
            i2 = 4;
        } else if (j <= 5000000) {
            i2 = 5;
        } else {
            i2 = 6;
        }
        C7060h.pYm.mo8378a((long) i, (long) i2, 1, false);
        AppMethodBeat.m2505o(67896);
    }

    /* renamed from: B */
    public static void m65399B(int i, long j) {
        int i2;
        AppMethodBeat.m2504i(67897);
        if (j <= 20000000) {
            i2 = 0;
        } else if (j <= 25000000) {
            i2 = 1;
        } else if (j <= 30000000) {
            i2 = 2;
        } else if (j <= 35000000) {
            i2 = 3;
        } else if (j <= 40000000) {
            i2 = 4;
        } else if (j <= 50000000) {
            i2 = 5;
        } else if (j <= 60000000) {
            i2 = 6;
        } else if (j <= 70000000) {
            i2 = 7;
        } else if (j <= 80000000) {
            i2 = 8;
        } else {
            i2 = 9;
        }
        C7060h.pYm.mo8378a((long) i, (long) i2, 1, false);
        AppMethodBeat.m2505o(67897);
    }
}
