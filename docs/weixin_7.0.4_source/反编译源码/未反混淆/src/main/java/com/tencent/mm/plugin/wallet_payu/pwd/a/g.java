package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class g extends e {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48516);
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.o(48516);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48517);
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.o(48517);
            return;
        }
        super.a(activity, i, bundle);
        AppMethodBeat.o(48517);
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48518);
        com.tencent.mm.wallet_core.d.g anonymousClass2;
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new a(mMActivity, iVar, this.mqu) {
                public final CharSequence Au(int i) {
                    AppMethodBeat.i(48513);
                    if (i == 0) {
                        String string = this.hwd.getString(R.string.fdb);
                        AppMethodBeat.o(48513);
                        return string;
                    }
                    CharSequence Au = super.Au(i);
                    AppMethodBeat.o(48513);
                    return Au;
                }
            };
            AppMethodBeat.o(48518);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            anonymousClass2 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48514);
                    if (mVar instanceof b) {
                        ab.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                        if (i == 0 && i2 == 0) {
                            g.this.mqu.putInt("key_errcode_payu", 0);
                            a.b(this.hwd, g.this.mqu, 0);
                            AppMethodBeat.o(48514);
                            return true;
                        }
                    }
                    AppMethodBeat.o(48514);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48515);
                    s sVar = (s) objArr[0];
                    this.Agm.a(new b(g.this.mqu.getString("key_pwd1"), sVar.guu), true);
                    AppMethodBeat.o(48515);
                    return true;
                }
            };
            AppMethodBeat.o(48518);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(48518);
            return anonymousClass2;
        }
    }

    public final String bxP() {
        return "PayUModifyPasswordProcess";
    }
}
