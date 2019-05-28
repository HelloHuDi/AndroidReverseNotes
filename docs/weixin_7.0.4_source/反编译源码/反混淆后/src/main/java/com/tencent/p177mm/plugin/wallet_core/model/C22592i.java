package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C30859c;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.i */
public final class C22592i {
    public int tyd = 0;
    public String tye = "";
    public int tyf = 0;
    public String tyg = "";
    public int tyh = 0;
    public C30859c tyi = new C30859c();

    public C22592i() {
        AppMethodBeat.m2504i(46739);
        AppMethodBeat.m2505o(46739);
    }

    public C22592i(Bundle bundle) {
        AppMethodBeat.m2504i(46740);
        this.tyd = bundle.getInt("key_is_gen_cert", 0);
        this.tyf = bundle.getInt("key_is_hint_crt", 0);
        this.tyh = bundle.getInt("key_is_ignore_cert", 0);
        this.tye = bundle.getString("key_crt_token", "");
        this.tyg = bundle.getString("key_crt_wording", "");
        this.tyi = new C30859c(this.tyg);
        AppMethodBeat.m2505o(46740);
    }

    public final boolean cPm() {
        AppMethodBeat.m2504i(46741);
        if (this.tyf == 0 || C5046bo.isNullOrNil(this.tyg)) {
            AppMethodBeat.m2505o(46741);
            return false;
        }
        AppMethodBeat.m2505o(46741);
        return true;
    }

    public final boolean cPn() {
        if (this.tyd == 1) {
            return true;
        }
        return false;
    }

    public final boolean cPo() {
        AppMethodBeat.m2504i(46742);
        if (cPn() && this.tyh == 0) {
            AppMethodBeat.m2505o(46742);
            return true;
        }
        AppMethodBeat.m2505o(46742);
        return false;
    }
}
