package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48620);
        ab.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        b(activity, WalletWXCreditDetailUI.class, bundle);
        AppMethodBeat.o(48620);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48621);
        if (i == 1) {
            b(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
            AppMethodBeat.o(48621);
        } else if (activity instanceof WalletWXCreditDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(48621);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
            AppMethodBeat.o(48621);
        } else {
            if (activity instanceof WalletWXCreditErrDetailUI) {
                b(activity, WalletCheckPwdUI.class, bundle);
            }
            AppMethodBeat.o(48621);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48622);
        F(activity);
        AppMethodBeat.o(48622);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48623);
        d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(48623);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48624);
        g anonymousClass2;
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(48616);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.o(48616);
                    return true;
                }
            };
            AppMethodBeat.o(48624);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48617);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof f) {
                            this.Agm.a(new y(), true);
                        } else if (mVar instanceof y) {
                            d.this.b(this.hwd, d.this.mqu);
                        }
                        AppMethodBeat.o(48617);
                        return true;
                    }
                    AppMethodBeat.o(48617);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48618);
                    Bankcard bankcard = (Bankcard) d.this.mqu.getParcelable("key_bankcard");
                    this.Agm.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, 1);
                    AppMethodBeat.o(48618);
                    return true;
                }

                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(48619);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.o(48619);
                    return true;
                }
            };
            AppMethodBeat.o(48624);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(48624);
            return anonymousClass2;
        }
    }

    public final String bxP() {
        return "WXCreditManagerProcess";
    }
}
