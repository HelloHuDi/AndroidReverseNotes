package com.tencent.p177mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.a */
public final class C22711a extends C44432g {
    private Bundle mqu;

    public C22711a(MMActivity mMActivity, C30868i c30868i, Bundle bundle) {
        super(mMActivity, c30868i);
        this.mqu = bundle;
    }

    /* renamed from: w */
    public final boolean mo9367w(Object... objArr) {
        AppMethodBeat.m2504i(48565);
        this.Agm.mo36581a(new C29705c(this.mqu.getString("payu_reference")), true);
        AppMethodBeat.m2505o(48565);
        return true;
    }

    /* renamed from: c */
    public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48566);
        if ((c1207m instanceof C29705c) && i == 0 && i2 == 0) {
            C29705c c29705c = (C29705c) c1207m;
            this.mqu.putParcelable("key_security_question", new PayUSecurityQuestion(c29705c.f13719id, c29705c.tUL));
            AppMethodBeat.m2505o(48566);
            return false;
        }
        if (c1207m instanceof C22712b) {
            C22712b c22712b = (C22712b) c1207m;
            if (i == 0 && i2 == 0) {
                if (c22712b.lSP) {
                    this.mqu.putString("payu_reference", c22712b.tUK);
                    C24143a.m37116j(this.hwd, this.mqu);
                    AppMethodBeat.m2505o(48566);
                    return true;
                }
                AppMethodBeat.m2505o(48566);
                return false;
            }
        }
        AppMethodBeat.m2505o(48566);
        return false;
    }

    /* renamed from: p */
    public final boolean mo9366p(Object... objArr) {
        AppMethodBeat.m2504i(48567);
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.mqu.getParcelable("key_security_question");
        String string = this.mqu.getString("key_question_answer");
        this.Agm.mo36581a(new C22712b(this.mqu.getString("payu_reference"), payUSecurityQuestion.f13718id, string), true);
        AppMethodBeat.m2505o(48567);
        return false;
    }
}
