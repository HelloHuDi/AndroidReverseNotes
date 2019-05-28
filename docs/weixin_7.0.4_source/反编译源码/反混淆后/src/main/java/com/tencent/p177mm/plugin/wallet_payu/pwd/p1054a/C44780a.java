package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.a */
public class C44780a extends C44432g {
    private Bundle mqu;

    public C44780a(MMActivity mMActivity, C30868i c30868i, Bundle bundle) {
        super(mMActivity, c30868i);
        this.mqu = bundle;
    }

    /* renamed from: c */
    public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48501);
        if (c1207m instanceof C29697c) {
            C29697c c29697c = (C29697c) c1207m;
            if (C5046bo.isNullOrNil(c29697c.token)) {
                C4990ab.m7420w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                C4990ab.m7410d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.mqu.putString("payu_reference", c29697c.token);
                C24143a.m37116j(this.hwd, this.mqu);
            }
        }
        AppMethodBeat.m2505o(48501);
        return false;
    }

    /* renamed from: p */
    public final boolean mo9366p(Object... objArr) {
        AppMethodBeat.m2504i(48502);
        this.mqu.putString("key_pwd1", (String) objArr[0]);
        this.Agm.mo36581a(new C29697c(this.mqu.getString("key_pwd1")), true);
        AppMethodBeat.m2505o(48502);
        return true;
    }
}
