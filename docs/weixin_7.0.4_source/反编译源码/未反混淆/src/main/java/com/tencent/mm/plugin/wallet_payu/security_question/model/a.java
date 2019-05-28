package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a extends g {
    private Bundle mqu;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.mqu = bundle;
    }

    public final boolean w(Object... objArr) {
        AppMethodBeat.i(48565);
        this.Agm.a(new c(this.mqu.getString("payu_reference")), true);
        AppMethodBeat.o(48565);
        return true;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48566);
        if ((mVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) mVar;
            this.mqu.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.tUL));
            AppMethodBeat.o(48566);
            return false;
        }
        if (mVar instanceof b) {
            b bVar = (b) mVar;
            if (i == 0 && i2 == 0) {
                if (bVar.lSP) {
                    this.mqu.putString("payu_reference", bVar.tUK);
                    com.tencent.mm.wallet_core.a.j(this.hwd, this.mqu);
                    AppMethodBeat.o(48566);
                    return true;
                }
                AppMethodBeat.o(48566);
                return false;
            }
        }
        AppMethodBeat.o(48566);
        return false;
    }

    public final boolean p(Object... objArr) {
        AppMethodBeat.i(48567);
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.mqu.getParcelable("key_security_question");
        String string = this.mqu.getString("key_question_answer");
        this.Agm.a(new b(this.mqu.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        AppMethodBeat.o(48567);
        return false;
    }
}
