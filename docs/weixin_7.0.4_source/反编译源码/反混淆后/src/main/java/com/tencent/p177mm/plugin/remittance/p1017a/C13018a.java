package com.tencent.p177mm.plugin.remittance.p1017a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.remittance.p497ui.RemittanceAdapterUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.remittance.a.a */
public class C13018a extends C40931c {
    /* renamed from: a */
    public C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(44422);
        C4990ab.m7410d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        mo64571b(activity, RemittanceAdapterUI.class, bundle);
        AppMethodBeat.m2505o(44422);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(44423);
        super.mo64570aG(activity);
        AppMethodBeat.m2505o(44423);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(44424);
        mo55241F(activity);
        AppMethodBeat.m2505o(44424);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "RemittanceProcess";
    }
}
