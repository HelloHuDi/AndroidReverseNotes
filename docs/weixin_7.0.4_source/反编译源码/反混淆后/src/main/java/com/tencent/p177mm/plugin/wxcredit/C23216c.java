package com.tencent.p177mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wxcredit.c */
public class C23216c extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48611);
        C4990ab.m7410d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
        mo64571b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(48611);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48612);
        if (activity instanceof WalletCheckPwdUI) {
            C36391e.m60016n(activity, bundle.getString("key_url"), false);
            AppMethodBeat.m2505o(48612);
            return;
        }
        mo8125b(activity, bundle);
        AppMethodBeat.m2505o(48612);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48613);
        mo55241F(activity);
        AppMethodBeat.m2505o(48613);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48614);
        mo64575d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.m2505o(48614);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48615);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C232171 c232171 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48609);
                    if (i == 0 && i2 == 0) {
                        C23216c.this.mo8124a(this.hwd, 0, C23216c.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.m2505o(48609);
                        return true;
                    }
                    AppMethodBeat.m2505o(48609);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48610);
                    C23216c.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.mo49367a(new C29619r((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.m2505o(48610);
                    return true;
                }

                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(48615);
            return c232171;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(48615);
        return a;
    }

    public final String bxP() {
        return "WXCreditCheckPwdProcess";
    }
}
