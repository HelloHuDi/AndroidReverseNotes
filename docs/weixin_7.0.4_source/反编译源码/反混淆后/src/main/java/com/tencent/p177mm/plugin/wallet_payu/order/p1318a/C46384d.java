package com.tencent.p177mm.plugin.wallet_payu.order.p1318a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.order.p1007a.C34656a;
import com.tencent.p177mm.plugin.wallet_payu.order.p570ui.PayUMallOrderDetailUI;
import com.tencent.p177mm.plugin.wallet_payu.order.p570ui.PayUMallOrderRecordListUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.a.d */
public class C46384d extends C34656a {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48424);
        C4990ab.m7410d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        mo64571b(activity, PayUMallOrderRecordListUI.class, bundle);
        AppMethodBeat.m2505o(48424);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48425);
        if (activity instanceof PayUMallOrderRecordListUI) {
            mo64571b(activity, PayUMallOrderDetailUI.class, bundle);
        }
        AppMethodBeat.m2505o(48425);
    }
}
