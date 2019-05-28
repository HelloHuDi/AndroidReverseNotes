package com.tencent.mars.smc;

import com.tencent.mm.plugin.report.e;
import java.util.ArrayList;

public class IPCSmcLogic {
    private static void reportKV(long j, String str, boolean z, boolean z2) {
        e.pXa.a((int) j, str, z2, z);
    }

    private static void reportIDKey(long j, long j2, long j3, boolean z) {
        e.pXa.a(j, j2, j3, z);
    }

    private static void reportGroupIDKey(int[] iArr, int[] iArr2, int[] iArr3, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new IDKey(iArr[i2], iArr2[i2], iArr3[i2]));
        }
        e.pXa.b(arrayList, z);
    }
}
