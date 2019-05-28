package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c;

public class j extends c {
    public final c a(Activity activity, Bundle bundle) {
        String str;
        AppMethodBeat.i(43349);
        String str2 = "";
        if (bundle != null) {
            if (bo.isNullOrNil(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.tAq == null || orders.tAq.size() <= 0)) {
                    str = ((Commodity) orders.tAq.get(0)).cAa;
                }
            } else {
                str = "key_trans_id";
            }
            g.RQ();
            g.RO().eJo.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
            b(activity, WalletOrderInfoUI.class, bundle);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            AppMethodBeat.o(43349);
            return this;
        }
        str = str2;
        g.RQ();
        g.RO().eJo.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
        b(activity, WalletOrderInfoUI.class, bundle);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(43349);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(43350);
        if (activity instanceof WalletOrderInfoUI) {
            F(activity);
            b(activity, null);
        }
        AppMethodBeat.o(43350);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(43351);
        F(activity);
        AppMethodBeat.o(43351);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43352);
        aG(activity);
        if (this.mqu.getInt("key_from_scene") == 8) {
            com.tencent.mm.plugin.offline.c.a.Up(this.mqu.getString("key_appid"));
        }
        AppMethodBeat.o(43352);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "ShowOrderSuccessProcess";
    }
}
