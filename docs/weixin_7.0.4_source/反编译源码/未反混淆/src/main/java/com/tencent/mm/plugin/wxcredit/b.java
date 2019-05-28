package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48604);
        ab.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(48604);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48605);
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletWXCreditChangeAmountUI.class, bundle);
            AppMethodBeat.o(48605);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            b(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
            AppMethodBeat.o(48605);
        } else {
            if (activity instanceof WalletWXCreditChangeAmountResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(48605);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48606);
        F(activity);
        AppMethodBeat.o(48606);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48607);
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.o(48607);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48608);
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48600);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof e) {
                            b.this.mqu.putString("kreq_token", ((e) mVar).token);
                            AppMethodBeat.o(48600);
                            return false;
                        } else if (mVar instanceof com.tencent.mm.plugin.wxcredit.a.c) {
                            b.this.mqu.putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c) mVar).uYv);
                            b.this.a(this.hwd, 0, b.this.mqu);
                            AppMethodBeat.o(48600);
                            return true;
                        }
                    }
                    AppMethodBeat.o(48600);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48601);
                    this.Agm.a(new e(((Bankcard) b.this.mqu.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    AppMethodBeat.o(48601);
                    return true;
                }
            };
            AppMethodBeat.o(48608);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            g anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48602);
                    if (i == 0 && i2 == 0) {
                        b.this.a(this.hwd, 0, b.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.o(48602);
                        return true;
                    }
                    AppMethodBeat.o(48602);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48603);
                    b.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.a(new r((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.o(48603);
                    return true;
                }
            };
            AppMethodBeat.o(48608);
            return anonymousClass2;
        } else {
            AppMethodBeat.o(48608);
            return null;
        }
    }

    public final String bxP() {
        return "WXCreditChangeAmountProcess";
    }
}
