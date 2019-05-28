package com.tencent.soter.p663a.p664g;

import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p1107c.C16167a;

/* renamed from: com.tencent.soter.a.g.c */
abstract class C24299c extends C44469d {
    C24299c() {
    }

    /* renamed from: eQ */
    protected static void m37469eQ(String str, int i) {
        C44476d.m80482d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", str, Integer.valueOf(i));
        synchronized (C16167a.class) {
            if (C16167a.dRe().dRh() != null) {
                C16167a.dRe().dRh().edit().putInt(str, i).apply();
            }
        }
    }
}
