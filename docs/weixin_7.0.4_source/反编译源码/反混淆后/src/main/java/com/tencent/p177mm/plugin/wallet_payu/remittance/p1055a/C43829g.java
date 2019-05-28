package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.remittance.p1017a.C13018a;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1056ui.PayURemittanceAdapterUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.g */
public class C43829g extends C13018a {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48537);
        C4990ab.m7410d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
        mo64571b(activity, PayURemittanceAdapterUI.class, bundle);
        AppMethodBeat.m2505o(48537);
        return this;
    }
}
