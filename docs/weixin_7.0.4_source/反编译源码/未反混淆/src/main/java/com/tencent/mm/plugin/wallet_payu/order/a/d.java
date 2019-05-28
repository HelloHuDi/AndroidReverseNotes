package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class d extends a {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48424);
        ab.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, PayUMallOrderRecordListUI.class, bundle);
        AppMethodBeat.o(48424);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48425);
        if (activity instanceof PayUMallOrderRecordListUI) {
            b(activity, PayUMallOrderDetailUI.class, bundle);
        }
        AppMethodBeat.o(48425);
    }
}
