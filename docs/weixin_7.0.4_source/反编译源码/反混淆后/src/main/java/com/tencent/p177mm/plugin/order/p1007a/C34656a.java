package com.tencent.p177mm.plugin.order.p1007a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.order.p480ui.MallOrderDetailInfoUI;
import com.tencent.p177mm.plugin.order.p480ui.MallOrderProductListUI;
import com.tencent.p177mm.plugin.order.p480ui.MallOrderRecordListUI;
import com.tencent.p177mm.plugin.order.p480ui.MallOrderTransactionInfoUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.order.a.a */
public class C34656a extends C40931c {
    /* renamed from: a */
    public C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43723);
        C4990ab.m7410d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        mo64571b(activity, MallOrderRecordListUI.class, bundle);
        AppMethodBeat.m2505o(43723);
        return this;
    }

    /* renamed from: a */
    public void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(43724);
        if (activity instanceof MallOrderRecordListUI) {
            mo64571b(activity, MallOrderTransactionInfoUI.class, bundle);
            AppMethodBeat.m2505o(43724);
        } else if (activity instanceof MallOrderDetailInfoUI) {
            int i2 = bundle.getInt("key_enter_id");
            if (i2 == 0) {
                mo64571b(activity, MallOrderProductListUI.class, bundle);
                AppMethodBeat.m2505o(43724);
                return;
            }
            if (i2 == 1) {
                mo64571b(activity, MallOrderTransactionInfoUI.class, bundle);
            }
            AppMethodBeat.m2505o(43724);
        } else {
            if ((activity instanceof MallOrderProductListUI) || (activity instanceof MallOrderTransactionInfoUI)) {
                mo55241F(activity);
            }
            AppMethodBeat.m2505o(43724);
        }
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43725);
        super.mo64570aG(activity);
        AppMethodBeat.m2505o(43725);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(43726);
        mo55241F(activity);
        AppMethodBeat.m2505o(43726);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "ShowOrdersInfoProcess";
    }
}
