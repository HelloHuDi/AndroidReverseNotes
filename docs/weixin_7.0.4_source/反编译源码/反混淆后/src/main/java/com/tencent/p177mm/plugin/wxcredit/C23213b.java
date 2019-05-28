package com.tencent.p177mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C44025e;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C46477c;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditChangeAmountUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wxcredit.b */
public class C23213b extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48604);
        C4990ab.m7410d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        mo64571b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(48604);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48605);
        if (activity instanceof WalletCheckPwdUI) {
            mo64571b(activity, WalletWXCreditChangeAmountUI.class, bundle);
            AppMethodBeat.m2505o(48605);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            mo64571b(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
            AppMethodBeat.m2505o(48605);
        } else {
            if (activity instanceof WalletWXCreditChangeAmountResultUI) {
                mo8125b(activity, bundle);
            }
            AppMethodBeat.m2505o(48605);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48606);
        mo55241F(activity);
        AppMethodBeat.m2505o(48606);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48607);
        mo64575d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.m2505o(48607);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48608);
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            C232141 c232141 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48600);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C44025e) {
                            C23213b.this.mqu.putString("kreq_token", ((C44025e) c1207m).token);
                            AppMethodBeat.m2505o(48600);
                            return false;
                        } else if (c1207m instanceof C46477c) {
                            C23213b.this.mqu.putDouble("key_credit_amount", ((C46477c) c1207m).uYv);
                            C23213b.this.mo8124a(this.hwd, 0, C23213b.this.mqu);
                            AppMethodBeat.m2505o(48600);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(48600);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48601);
                    this.Agm.mo49367a(new C44025e(((Bankcard) C23213b.this.mqu.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    AppMethodBeat.m2505o(48601);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48608);
            return c232141;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            C44432g c232152 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48602);
                    if (i == 0 && i2 == 0) {
                        C23213b.this.mo8124a(this.hwd, 0, C23213b.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.m2505o(48602);
                        return true;
                    }
                    AppMethodBeat.m2505o(48602);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48603);
                    C23213b.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.mo49367a(new C29619r((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.m2505o(48603);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48608);
            return c232152;
        } else {
            AppMethodBeat.m2505o(48608);
            return null;
        }
    }

    public final String bxP() {
        return "WXCreditChangeAmountProcess";
    }
}
