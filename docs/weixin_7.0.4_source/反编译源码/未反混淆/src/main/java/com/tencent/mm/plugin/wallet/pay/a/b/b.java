package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    private static long tor = 0;

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void ak(String str, int i, int i2) {
        AppMethodBeat.i(45937);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - tor > 1000) {
            m eVar;
            tor = currentTimeMillis;
            if (!bo.isNullOrNil(str)) {
                if (str.startsWith("sns_aa_")) {
                    eVar = new e(str, i, i2);
                } else if (str.startsWith("sns_tf_")) {
                    eVar = new h(str, i, i2);
                } else if (str.startsWith("sns_ff_")) {
                    eVar = new g(str, i, i2);
                } else if (str.startsWith("sns_")) {
                    eVar = new f(str, i, i2);
                } else if (str.startsWith("ts_")) {
                    eVar = new j(str, i, i2);
                } else if (str.startsWith("up_")) {
                    eVar = new k(str, i, i2);
                } else if (str.startsWith("seb_ff_")) {
                    eVar = new d(str, i, i2);
                } else if (str.startsWith("tax_")) {
                    eVar = new i(str, i, i2);
                } else if (str.startsWith("dc_")) {
                    eVar = new c(str, i, i2);
                }
                if (eVar != null) {
                    ab.v("NetSceneCancelPayHelper", "start cancelPay request");
                    g.RQ();
                    g.RO().eJo.a(eVar, 0);
                }
            }
            eVar = null;
            if (eVar != null) {
            }
        }
        AppMethodBeat.o(45937);
    }
}
