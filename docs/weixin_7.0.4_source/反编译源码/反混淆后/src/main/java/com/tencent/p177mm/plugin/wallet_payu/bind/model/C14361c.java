package com.tencent.p177mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.p177mm.plugin.wallet_payu.bind.p568ui.WalletPayUBankcardManageUI;
import com.tencent.p177mm.plugin.wallet_payu.bind.p568ui.WalletPayUCardElementUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C44780a;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUCheckPwdUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.model.c */
public class C14361c extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48341);
        C4990ab.m7410d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        mo64571b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(48341);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48342);
        if (activity instanceof WalletPayUCheckPwdUI) {
            mo64571b(activity, WalletPayUCardElementUI.class, bundle);
        }
        AppMethodBeat.m2505o(48342);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48343);
        mo55241F(activity);
        AppMethodBeat.m2505o(48343);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48344);
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            C23639t.makeText(activity, C25738R.string.fle, 0).show();
            mo64560a(activity, WalletPayUBankcardManageUI.class, -1, false);
            AppMethodBeat.m2505o(48344);
            return;
        }
        C23639t.makeText(activity, C25738R.string.fen, 0).show();
        mo64560a(activity, WalletPayUBankcardManageUI.class, 0, false);
        AppMethodBeat.m2505o(48344);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48345);
        C44432g c143602;
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            C143621 c143621 = new C44780a(mMActivity, c30868i, this.mqu) {
                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48338);
                    if (i == 0) {
                        String string = this.hwd.getString(C25738R.string.fd7);
                        AppMethodBeat.m2505o(48338);
                        return string;
                    }
                    CharSequence Au = super.mo9364Au(i);
                    AppMethodBeat.m2505o(48338);
                    return Au;
                }
            };
            AppMethodBeat.m2505o(48345);
            return c143621;
        } else if (mMActivity instanceof WalletPayUCardElementUI) {
            c143602 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48339);
                    if ((c1207m instanceof C14358a) && i == 0 && i2 == 0) {
                        C14361c.this.mqu.putInt("key_errcode_payu", 0);
                        C14361c.this.mo8125b(this.hwd, C14361c.this.mqu);
                    }
                    if (c1207m instanceof NetScenePayUElementQuery) {
                        PayUBankcardElement payUBankcardElement;
                        if (i == 0 && i2 == 0) {
                            payUBankcardElement = ((NetScenePayUElementQuery) c1207m).tSF;
                            if (C5046bo.isNullOrNil(payUBankcardElement.tSG)) {
                                payUBankcardElement.tSH = C4996ah.getContext().getString(C25738R.string.fp6);
                            }
                            C14361c.this.mqu.putParcelable("key_card_element", ((NetScenePayUElementQuery) c1207m).tSF);
                        } else {
                            payUBankcardElement = new PayUBankcardElement();
                            if (C5046bo.isNullOrNil(str)) {
                                str = "err card element";
                            }
                            payUBankcardElement.tSH = str;
                            C14361c.this.mqu.putParcelable("key_card_element", payUBankcardElement);
                        }
                    }
                    AppMethodBeat.m2505o(48339);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48340);
                    PayUBankcardElement payUBankcardElement = (PayUBankcardElement) C14361c.this.mqu.getParcelable("key_card_element");
                    this.Agm.mo36581a(new C14358a(payUBankcardElement.pcj, payUBankcardElement.tSH, C14361c.this.mqu.getString("key_bank_username"), C14361c.this.mqu.getString("key_card_id"), C14361c.this.mqu.getString("key_expire_data"), payUBankcardElement.cardType, C14361c.this.mqu.getString("key_cvv"), C14361c.this.mqu.getString("key_pwd1")), true);
                    AppMethodBeat.m2505o(48340);
                    return false;
                }
            };
            AppMethodBeat.m2505o(48345);
            return c143602;
        } else {
            c143602 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48345);
            return c143602;
        }
    }

    public final String bxP() {
        return "PayUBindProcess";
    }
}
