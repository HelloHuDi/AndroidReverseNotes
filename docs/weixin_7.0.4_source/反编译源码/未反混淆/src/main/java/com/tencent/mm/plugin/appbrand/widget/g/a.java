package com.tencent.mm.plugin.appbrand.widget.g;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a {
    public static void c(int i, long j, long j2, int i2) {
        AppMethodBeat.i(67895);
        if (j <= 0 || j2 <= 0 || i2 <= 0) {
            AppMethodBeat.o(67895);
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
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(67895);
    }

    public static void A(int i, long j) {
        int i2;
        AppMethodBeat.i(67896);
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
        h.pYm.a((long) i, (long) i2, 1, false);
        AppMethodBeat.o(67896);
    }

    public static void B(int i, long j) {
        int i2;
        AppMethodBeat.i(67897);
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
        h.pYm.a((long) i, (long) i2, 1, false);
        AppMethodBeat.o(67897);
    }
}
