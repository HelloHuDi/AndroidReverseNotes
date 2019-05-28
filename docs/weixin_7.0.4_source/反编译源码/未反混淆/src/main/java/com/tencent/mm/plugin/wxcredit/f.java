package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48647);
        ab.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            a(activity, "wallet", ".bind.ui.WalletBankcardDetailUI", bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(48647);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48648);
        if (activity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(48648);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(48648);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48649);
        F(activity);
        AppMethodBeat.o(48649);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48650);
        d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(48650);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48651);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48645);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wxcredit.a.f)) {
                        f.this.a(this.hwd, 0, f.this.mqu);
                        AppMethodBeat.o(48645);
                        return true;
                    }
                    AppMethodBeat.o(48645);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48646);
                    if (f.this.mqu.getBoolean("key_is_show_detail", true)) {
                        AppMethodBeat.o(48646);
                        return false;
                    }
                    Bankcard bankcard = (Bankcard) f.this.mqu.getParcelable("key_bankcard");
                    this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.f(bankcard.field_bankcardType, bankcard.field_bindSerial, f.this.mqu.getString("key_pwd1")), true, 1);
                    AppMethodBeat.o(48646);
                    return true;
                }
            };
            AppMethodBeat.o(48651);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(48651);
        return a;
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "WXCreditUnbindProcess";
    }
}
