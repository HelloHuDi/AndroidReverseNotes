package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends g {
    private Bundle mqu;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.mqu = bundle;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48501);
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            if (bo.isNullOrNil(cVar.token)) {
                ab.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                ab.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.mqu.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.j(this.hwd, this.mqu);
            }
        }
        AppMethodBeat.o(48501);
        return false;
    }

    public final boolean p(Object... objArr) {
        AppMethodBeat.i(48502);
        this.mqu.putString("key_pwd1", (String) objArr[0]);
        this.Agm.a(new c(this.mqu.getString("key_pwd1")), true);
        AppMethodBeat.o(48502);
        return true;
    }
}
