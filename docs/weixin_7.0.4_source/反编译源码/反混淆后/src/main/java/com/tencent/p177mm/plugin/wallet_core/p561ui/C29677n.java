package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14222ac;
import com.tencent.p177mm.plugin.wallet_core.p749c.C7184s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.n */
public class C29677n extends C40931c {
    private String gEk;
    private int scene;
    private String token;
    private String tul;

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(47406);
        C4990ab.m7416i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.tul = bundle.getString("key_relation_key");
        this.gEk = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        mo64571b(activity, WalletVerifyCodeUI.class, bundle);
        AppMethodBeat.m2505o(47406);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(47407);
        C4990ab.m7416i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            mo64564a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            AppMethodBeat.m2505o(47407);
            return;
        }
        mo64559a(activity, WalletCheckPwdUI.class, -1, null, false);
        AppMethodBeat.m2505o(47407);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return null;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(47408);
        final C30868i c30868i2 = c30868i;
        final MMActivity mMActivity2 = mMActivity;
        C296781 c296781 = new C44432g(mMActivity, c30868i) {
            /* renamed from: p */
            public final boolean mo9366p(Object... objArr) {
                AppMethodBeat.m2504i(47403);
                if (objArr.length == 2) {
                    C14264s c14264s = (C14264s) objArr[1];
                    c14264s.token = C29677n.this.token;
                    C4990ab.m7416i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    c30868i2.mo49367a(new C14222ac(c14264s, C29677n.this.tul), true, 1);
                    AppMethodBeat.m2505o(47403);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                AppMethodBeat.m2505o(47403);
                return false;
            }

            /* renamed from: x */
            public final boolean mo38265x(Object... objArr) {
                AppMethodBeat.m2504i(47404);
                C4990ab.m7416i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                c30868i2.mo49367a(new C7184s(C29677n.this.gEk, C29677n.this.token, 0), true, 1);
                AppMethodBeat.m2505o(47404);
                return true;
            }

            /* renamed from: c */
            public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(47405);
                if (i != 0 || i2 != 0) {
                    if (c1207m instanceof C14222ac) {
                        C4990ab.m7412e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
                    }
                    AppMethodBeat.m2505o(47405);
                    return false;
                } else if (c1207m instanceof C14222ac) {
                    C4990ab.m7416i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    C14222ac c14222ac = (C14222ac) c1207m;
                    Bundle bundle = C29677n.this.mqu;
                    bundle.putString("key_jsapi_token", c14222ac.tuu);
                    C29677n.this.mo8125b(mMActivity2, bundle);
                    AppMethodBeat.m2505o(47405);
                    return true;
                } else if (c1207m instanceof C7184s) {
                    AppMethodBeat.m2505o(47405);
                    return true;
                } else {
                    AppMethodBeat.m2505o(47405);
                    return false;
                }
            }
        };
        AppMethodBeat.m2505o(47408);
        return c296781;
    }
}
