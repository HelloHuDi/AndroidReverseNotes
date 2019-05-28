package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUSetPasswordUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.e */
public abstract class C29698e extends C40931c {
    /* renamed from: a */
    public void mo8124a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            mo64571b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            mo64558a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            C23639t.makeText(activity, C25738R.string.fle, 0).show();
        } else {
            C23639t.makeText(activity, C25738R.string.fen, 0).show();
        }
        mo64575d(activity, "mall", ".ui.MallIndexUI");
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new C44432g(mMActivity, c30868i) {
            /* renamed from: c */
            public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(48508);
                if (c1207m instanceof C22707d) {
                    C4990ab.m7410d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                    if (i == 0 && i2 == 0) {
                        C29698e.this.mqu.putInt("key_errcode_payu", 0);
                        C24143a.m37113b(this.hwd, C29698e.this.mqu, 0);
                        AppMethodBeat.m2505o(48508);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(48508);
                return false;
            }

            /* renamed from: p */
            public final boolean mo9366p(Object... objArr) {
                AppMethodBeat.m2504i(48509);
                C14264s c14264s = (C14264s) objArr[0];
                this.Agm.mo36581a(new C22707d(C29698e.this.mqu.getString("payu_reference"), c14264s.guu), true);
                AppMethodBeat.m2505o(48509);
                return true;
            }
        } : super.mo24745a(mMActivity, c30868i);
    }
}
