package com.tencent.p177mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.wallet.bind.C41325a;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.WalletBankcardDetailUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_payu.bind.p568ui.WalletPayUBankcardDetailUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C29697c;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUCheckPwdUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.model.d */
public class C46382d extends C41325a {
    /* renamed from: d */
    public final void mo65990d(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48349);
        mo64571b(activity, WalletPayUBankcardDetailUI.class, bundle);
        AppMethodBeat.m2505o(48349);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48350);
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            C23639t.makeText(activity, C25738R.string.fle, 0).show();
        } else {
            C23639t.makeText(activity, C25738R.string.fen, 0).show();
        }
        mo64575d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.m2505o(48350);
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48351);
        if (activity instanceof WalletBankcardDetailUI) {
            mo64571b(activity, WalletPayUCheckPwdUI.class, bundle);
            AppMethodBeat.m2505o(48351);
            return;
        }
        if (activity instanceof WalletPayUCheckPwdUI) {
            mo8125b(activity, bundle);
        }
        AppMethodBeat.m2505o(48351);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48352);
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            C296961 c296961 = new C44432g(mMActivity, c30868i) {
                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48346);
                    if (i == 0) {
                        String string = this.hwd.getString(C25738R.string.fdi);
                        AppMethodBeat.m2505o(48346);
                        return string;
                    }
                    CharSequence Au = super.mo9364Au(i);
                    AppMethodBeat.m2505o(48346);
                    return Au;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48347);
                    if (c1207m instanceof C29697c) {
                        if (i2 == 0 && i == 0) {
                            C29697c c29697c = (C29697c) c1207m;
                            C46382d.this.mqu.putString("payu_reference", c29697c.token);
                            if (C5046bo.isNullOrNil(c29697c.token)) {
                                C4990ab.m7420w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                            } else {
                                C4990ab.m7410d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                                Bankcard bankcard = (Bankcard) C46382d.this.mqu.getParcelable("key_bankcard");
                                if (bankcard != null) {
                                    this.Agm.mo36581a(new C14359b(bankcard.field_bindSerial, C46382d.this.mqu.getString("payu_reference")), true);
                                }
                            }
                        }
                    } else if (c1207m instanceof C14359b) {
                        if (i == 0 && i2 == 0) {
                            C46382d.this.mqu.putInt("key_errcode_payu", 0);
                            C46382d.this.mo8125b(this.hwd, C46382d.this.mqu);
                        }
                        AppMethodBeat.m2505o(48347);
                        return false;
                    }
                    AppMethodBeat.m2505o(48347);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48348);
                    C46382d.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.mo36581a(new C29697c(C46382d.this.mqu.getString("key_pwd1")), true);
                    AppMethodBeat.m2505o(48348);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48352);
            return c296961;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(48352);
        return a;
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }
}
