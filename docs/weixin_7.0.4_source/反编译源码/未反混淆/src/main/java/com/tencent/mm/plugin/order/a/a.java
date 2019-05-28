package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class a extends c {
    public c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43723);
        ab.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, MallOrderRecordListUI.class, bundle);
        AppMethodBeat.o(43723);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(43724);
        if (activity instanceof MallOrderRecordListUI) {
            b(activity, MallOrderTransactionInfoUI.class, bundle);
            AppMethodBeat.o(43724);
        } else if (activity instanceof MallOrderDetailInfoUI) {
            int i2 = bundle.getInt("key_enter_id");
            if (i2 == 0) {
                b(activity, MallOrderProductListUI.class, bundle);
                AppMethodBeat.o(43724);
                return;
            }
            if (i2 == 1) {
                b(activity, MallOrderTransactionInfoUI.class, bundle);
            }
            AppMethodBeat.o(43724);
        } else {
            if ((activity instanceof MallOrderProductListUI) || (activity instanceof MallOrderTransactionInfoUI)) {
                F(activity);
            }
            AppMethodBeat.o(43724);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43725);
        super.aG(activity);
        AppMethodBeat.o(43725);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(43726);
        F(activity);
        AppMethodBeat.o(43726);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "ShowOrdersInfoProcess";
    }
}
