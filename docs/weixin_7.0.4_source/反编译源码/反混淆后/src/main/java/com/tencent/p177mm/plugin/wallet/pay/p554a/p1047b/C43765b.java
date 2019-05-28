package com.tencent.p177mm.plugin.wallet.pay.p554a.p1047b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.b.b */
public final class C43765b {
    private static long tor = 0;

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ak */
    public static void m78447ak(String str, int i, int i2) {
        AppMethodBeat.m2504i(45937);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - tor > 1000) {
            C1207m c46348e;
            tor = currentTimeMillis;
            if (!C5046bo.isNullOrNil(str)) {
                if (str.startsWith("sns_aa_")) {
                    c46348e = new C46348e(str, i, i2);
                } else if (str.startsWith("sns_tf_")) {
                    c46348e = new C14158h(str, i, i2);
                } else if (str.startsWith("sns_ff_")) {
                    c46348e = new C31455g(str, i, i2);
                } else if (str.startsWith("sns_")) {
                    c46348e = new C22529f(str, i, i2);
                } else if (str.startsWith("ts_")) {
                    c46348e = new C40073j(str, i, i2);
                } else if (str.startsWith("up_")) {
                    c46348e = new C40074k(str, i, i2);
                } else if (str.startsWith("seb_ff_")) {
                    c46348e = new C40072d(str, i, i2);
                } else if (str.startsWith("tax_")) {
                    c46348e = new C31456i(str, i, i2);
                } else if (str.startsWith("dc_")) {
                    c46348e = new C43766c(str, i, i2);
                }
                if (c46348e != null) {
                    C4990ab.m7418v("NetSceneCancelPayHelper", "start cancelPay request");
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46348e, 0);
                }
            }
            c46348e = null;
            if (c46348e != null) {
            }
        }
        AppMethodBeat.m2505o(45937);
    }
}
