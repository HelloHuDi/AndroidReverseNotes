package com.tencent.p177mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C39468g;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoUI;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.offline.j */
public class C34650j extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(43349);
        String str2 = "";
        if (bundle != null) {
            if (C5046bo.isNullOrNil(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.tAq == null || orders.tAq.size() <= 0)) {
                    str = ((Commodity) orders.tAq.get(0)).cAa;
                }
            } else {
                str = "key_trans_id";
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C39468g("offlineshowpage", "push", str), 0);
            mo64571b(activity, WalletOrderInfoUI.class, bundle);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            AppMethodBeat.m2505o(43349);
            return this;
        }
        str = str2;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C39468g("offlineshowpage", "push", str), 0);
        mo64571b(activity, WalletOrderInfoUI.class, bundle);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.m2505o(43349);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(43350);
        if (activity instanceof WalletOrderInfoUI) {
            mo55241F(activity);
            mo8125b(activity, null);
        }
        AppMethodBeat.m2505o(43350);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(43351);
        mo55241F(activity);
        AppMethodBeat.m2505o(43351);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43352);
        mo64570aG(activity);
        if (this.mqu.getInt("key_from_scene") == 8) {
            C28630a.m45508Up(this.mqu.getString("key_appid"));
        }
        AppMethodBeat.m2505o(43352);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "ShowOrderSuccessProcess";
    }
}
