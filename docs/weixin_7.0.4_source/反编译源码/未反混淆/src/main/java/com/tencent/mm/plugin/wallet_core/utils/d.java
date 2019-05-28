package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

public final class d {
    public static long tPh = 0;
    public static int tPi = 2;
    public static int tPj = 1;
    public static int tPk = 2;

    public static void cSP() {
        AppMethodBeat.i(48010);
        tPh = System.currentTimeMillis();
        AppMethodBeat.o(48010);
    }

    public static int cSQ() {
        AppMethodBeat.i(48011);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - tPh) / 1000);
        AppMethodBeat.o(48011);
        return currentTimeMillis;
    }

    public static void a(Activity activity, Bundle bundle, int i) {
        AppMethodBeat.i(48012);
        c aE = a.aE(activity);
        if (r.cPI().cQg() || aE == null || !aE.dNG()) {
            if (!(r.cPI().cQg() || bundle == null || !bundle.getBoolean("key_is_bind_reg_process", false))) {
                h.pYm.e(10932, Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0)));
            }
            AppMethodBeat.o(48012);
            return;
        }
        Orders orders = (Orders) bundle.getParcelable("key_orders");
        if (!(((PayInfo) bundle.getParcelable("key_pay_info")) == null || orders == null)) {
            h.pYm.e(10725, Integer.valueOf(i), Integer.valueOf(r0.cIf), Integer.valueOf((int) (orders.pTN * 100.0d)), orders.pcl);
        }
        AppMethodBeat.o(48012);
    }

    public static void gj(int i, int i2) {
        AppMethodBeat.i(48013);
        h.pYm.e(10932, Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.o(48013);
    }

    public static void a(PayInfo payInfo, Orders orders) {
        AppMethodBeat.i(48014);
        if (!(r.cPI().cQg() || payInfo == null || orders == null)) {
            h.pYm.e(10725, Integer.valueOf(1), Integer.valueOf(payInfo.cIf), Integer.valueOf((int) (orders.pTN * 100.0d)), orders.pcl);
        }
        AppMethodBeat.o(48014);
    }
}
