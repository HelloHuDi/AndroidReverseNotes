package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48611);
        ab.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(48611);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48612);
        if (activity instanceof WalletCheckPwdUI) {
            e.n(activity, bundle.getString("key_url"), false);
            AppMethodBeat.o(48612);
            return;
        }
        b(activity, bundle);
        AppMethodBeat.o(48612);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48613);
        F(activity);
        AppMethodBeat.o(48613);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48614);
        d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(48614);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48615);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48609);
                    if (i == 0 && i2 == 0) {
                        c.this.a(this.hwd, 0, c.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.o(48609);
                        return true;
                    }
                    AppMethodBeat.o(48609);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48610);
                    c.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.a(new r((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.o(48610);
                    return true;
                }

                public final boolean w(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(48615);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(48615);
        return a;
    }

    public final String bxP() {
        return "WXCreditCheckPwdProcess";
    }
}
