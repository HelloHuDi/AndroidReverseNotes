package com.tencent.soter.a.g;

import com.tencent.soter.a.c.a;
import com.tencent.soter.core.c.d;

abstract class c extends d {
    c() {
    }

    protected static void eQ(String str, int i) {
        d.d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", str, Integer.valueOf(i));
        synchronized (a.class) {
            if (a.dRe().dRh() != null) {
                a.dRe().dRh().edit().putInt(str, i).apply();
            }
        }
    }
}
