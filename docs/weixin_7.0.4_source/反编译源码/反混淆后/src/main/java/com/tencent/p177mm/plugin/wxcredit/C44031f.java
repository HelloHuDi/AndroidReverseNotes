package com.tencent.p177mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C44026f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wxcredit.f */
public class C44031f extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48647);
        C4990ab.m7410d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            mo64566a(activity, "wallet", ".bind.ui.WalletBankcardDetailUI", bundle);
        } else {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.m2505o(48647);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48648);
        if (activity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.m2505o(48648);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            mo8125b(activity, bundle);
        }
        AppMethodBeat.m2505o(48648);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48649);
        mo55241F(activity);
        AppMethodBeat.m2505o(48649);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48650);
        mo64575d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.m2505o(48650);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48651);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C148181 c148181 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48645);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C44026f)) {
                        C44031f.this.mo8124a(this.hwd, 0, C44031f.this.mqu);
                        AppMethodBeat.m2505o(48645);
                        return true;
                    }
                    AppMethodBeat.m2505o(48645);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48646);
                    if (C44031f.this.mqu.getBoolean("key_is_show_detail", true)) {
                        AppMethodBeat.m2505o(48646);
                        return false;
                    }
                    Bankcard bankcard = (Bankcard) C44031f.this.mqu.getParcelable("key_bankcard");
                    this.Agm.mo49367a(new C44026f(bankcard.field_bankcardType, bankcard.field_bindSerial, C44031f.this.mqu.getString("key_pwd1")), true, 1);
                    AppMethodBeat.m2505o(48646);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48651);
            return c148181;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(48651);
        return a;
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "WXCreditUnbindProcess";
    }
}
