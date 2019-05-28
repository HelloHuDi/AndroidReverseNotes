package com.tencent.p177mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C40408d;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C44026f;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditDetailUI;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditErrDetailUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wxcredit.d */
public class C23218d extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48620);
        C4990ab.m7410d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        mo64571b(activity, WalletWXCreditDetailUI.class, bundle);
        AppMethodBeat.m2505o(48620);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48621);
        if (i == 1) {
            mo64571b(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
            AppMethodBeat.m2505o(48621);
        } else if (activity instanceof WalletWXCreditDetailUI) {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.m2505o(48621);
        } else if (activity instanceof WalletCheckPwdUI) {
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(48621);
        } else {
            if (activity instanceof WalletWXCreditErrDetailUI) {
                mo64571b(activity, WalletCheckPwdUI.class, bundle);
            }
            AppMethodBeat.m2505o(48621);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48622);
        mo55241F(activity);
        AppMethodBeat.m2505o(48622);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48623);
        mo64575d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.m2505o(48623);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48624);
        C44432g c232192;
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            C232201 c232201 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }

                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(48616);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Agm.mo49367a(new C40408d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.m2505o(48616);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48624);
            return c232201;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            c232192 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48617);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C44026f) {
                            this.Agm.mo36581a(new C35475y(), true);
                        } else if (c1207m instanceof C35475y) {
                            C23218d.this.mo8125b(this.hwd, C23218d.this.mqu);
                        }
                        AppMethodBeat.m2505o(48617);
                        return true;
                    }
                    AppMethodBeat.m2505o(48617);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48618);
                    Bankcard bankcard = (Bankcard) C23218d.this.mqu.getParcelable("key_bankcard");
                    this.Agm.mo49367a(new C44026f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, 1);
                    AppMethodBeat.m2505o(48618);
                    return true;
                }

                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(48619);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Agm.mo49367a(new C40408d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.m2505o(48619);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48624);
            return c232192;
        } else {
            c232192 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48624);
            return c232192;
        }
    }

    public final String bxP() {
        return "WXCreditManagerProcess";
    }
}
