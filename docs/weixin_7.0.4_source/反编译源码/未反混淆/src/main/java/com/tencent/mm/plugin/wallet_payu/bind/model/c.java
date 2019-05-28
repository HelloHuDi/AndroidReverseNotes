package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48341);
        ab.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.o(48341);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48342);
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUCardElementUI.class, bundle);
        }
        AppMethodBeat.o(48342);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48343);
        F(activity);
        AppMethodBeat.o(48343);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48344);
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            t.makeText(activity, R.string.fle, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            AppMethodBeat.o(48344);
            return;
        }
        t.makeText(activity, R.string.fen, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
        AppMethodBeat.o(48344);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48345);
        g anonymousClass2;
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new a(mMActivity, iVar, this.mqu) {
                public final CharSequence Au(int i) {
                    AppMethodBeat.i(48338);
                    if (i == 0) {
                        String string = this.hwd.getString(R.string.fd7);
                        AppMethodBeat.o(48338);
                        return string;
                    }
                    CharSequence Au = super.Au(i);
                    AppMethodBeat.o(48338);
                    return Au;
                }
            };
            AppMethodBeat.o(48345);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPayUCardElementUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48339);
                    if ((mVar instanceof a) && i == 0 && i2 == 0) {
                        c.this.mqu.putInt("key_errcode_payu", 0);
                        c.this.b(this.hwd, c.this.mqu);
                    }
                    if (mVar instanceof NetScenePayUElementQuery) {
                        PayUBankcardElement payUBankcardElement;
                        if (i == 0 && i2 == 0) {
                            payUBankcardElement = ((NetScenePayUElementQuery) mVar).tSF;
                            if (bo.isNullOrNil(payUBankcardElement.tSG)) {
                                payUBankcardElement.tSH = ah.getContext().getString(R.string.fp6);
                            }
                            c.this.mqu.putParcelable("key_card_element", ((NetScenePayUElementQuery) mVar).tSF);
                        } else {
                            payUBankcardElement = new PayUBankcardElement();
                            if (bo.isNullOrNil(str)) {
                                str = "err card element";
                            }
                            payUBankcardElement.tSH = str;
                            c.this.mqu.putParcelable("key_card_element", payUBankcardElement);
                        }
                    }
                    AppMethodBeat.o(48339);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48340);
                    PayUBankcardElement payUBankcardElement = (PayUBankcardElement) c.this.mqu.getParcelable("key_card_element");
                    this.Agm.a(new a(payUBankcardElement.pcj, payUBankcardElement.tSH, c.this.mqu.getString("key_bank_username"), c.this.mqu.getString("key_card_id"), c.this.mqu.getString("key_expire_data"), payUBankcardElement.cardType, c.this.mqu.getString("key_cvv"), c.this.mqu.getString("key_pwd1")), true);
                    AppMethodBeat.o(48340);
                    return false;
                }
            };
            AppMethodBeat.o(48345);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(48345);
            return anonymousClass2;
        }
    }

    public final String bxP() {
        return "PayUBindProcess";
    }
}
