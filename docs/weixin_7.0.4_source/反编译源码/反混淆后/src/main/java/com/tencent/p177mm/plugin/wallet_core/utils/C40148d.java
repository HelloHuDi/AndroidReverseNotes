package com.tencent.p177mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.d */
public final class C40148d {
    public static long tPh = 0;
    public static int tPi = 2;
    public static int tPj = 1;
    public static int tPk = 2;

    public static void cSP() {
        AppMethodBeat.m2504i(48010);
        tPh = System.currentTimeMillis();
        AppMethodBeat.m2505o(48010);
    }

    public static int cSQ() {
        AppMethodBeat.m2504i(48011);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - tPh) / 1000);
        AppMethodBeat.m2505o(48011);
        return currentTimeMillis;
    }

    /* renamed from: a */
    public static void m68847a(Activity activity, Bundle bundle, int i) {
        AppMethodBeat.m2504i(48012);
        C40931c aE = C24143a.m37112aE(activity);
        if (C14241r.cPI().cQg() || aE == null || !aE.dNG()) {
            if (!(C14241r.cPI().cQg() || bundle == null || !bundle.getBoolean("key_is_bind_reg_process", false))) {
                C7060h.pYm.mo8381e(10932, Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0)));
            }
            AppMethodBeat.m2505o(48012);
            return;
        }
        Orders orders = (Orders) bundle.getParcelable("key_orders");
        if (!(((PayInfo) bundle.getParcelable("key_pay_info")) == null || orders == null)) {
            C7060h.pYm.mo8381e(10725, Integer.valueOf(i), Integer.valueOf(r0.cIf), Integer.valueOf((int) (orders.pTN * 100.0d)), orders.pcl);
        }
        AppMethodBeat.m2505o(48012);
    }

    /* renamed from: gj */
    public static void m68849gj(int i, int i2) {
        AppMethodBeat.m2504i(48013);
        C7060h.pYm.mo8381e(10932, Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.m2505o(48013);
    }

    /* renamed from: a */
    public static void m68848a(PayInfo payInfo, Orders orders) {
        AppMethodBeat.m2504i(48014);
        if (!(C14241r.cPI().cQg() || payInfo == null || orders == null)) {
            C7060h.pYm.mo8381e(10725, Integer.valueOf(1), Integer.valueOf(payInfo.cIf), Integer.valueOf((int) (orders.pTN * 100.0d)), orders.pcl);
        }
        AppMethodBeat.m2505o(48014);
    }
}
