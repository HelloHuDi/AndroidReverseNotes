package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public abstract class e extends c {
    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            t.makeText(activity, R.string.fle, 0).show();
        } else {
            t.makeText(activity, R.string.fen, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new g(mMActivity, iVar) {
            public final boolean c(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(48508);
                if (mVar instanceof d) {
                    ab.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                    if (i == 0 && i2 == 0) {
                        e.this.mqu.putInt("key_errcode_payu", 0);
                        a.b(this.hwd, e.this.mqu, 0);
                        AppMethodBeat.o(48508);
                        return true;
                    }
                }
                AppMethodBeat.o(48508);
                return false;
            }

            public final boolean p(Object... objArr) {
                AppMethodBeat.i(48509);
                s sVar = (s) objArr[0];
                this.Agm.a(new d(e.this.mqu.getString("payu_reference"), sVar.guu), true);
                AppMethodBeat.o(48509);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }
}
