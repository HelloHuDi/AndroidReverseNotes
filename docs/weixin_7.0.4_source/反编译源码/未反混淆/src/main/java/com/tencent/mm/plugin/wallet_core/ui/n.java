package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class n extends c {
    private String gEk;
    private int scene;
    private String token;
    private String tul;

    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(47406);
        ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.tul = bundle.getString("key_relation_key");
        this.gEk = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        b(activity, WalletVerifyCodeUI.class, bundle);
        AppMethodBeat.o(47406);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void c(Activity activity, int i) {
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(47407);
        ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            AppMethodBeat.o(47407);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, null, false);
        AppMethodBeat.o(47407);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return null;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(47408);
        final i iVar2 = iVar;
        final MMActivity mMActivity2 = mMActivity;
        AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
            public final boolean p(Object... objArr) {
                AppMethodBeat.i(47403);
                if (objArr.length == 2) {
                    s sVar = (s) objArr[1];
                    sVar.token = n.this.token;
                    ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    iVar2.a(new ac(sVar, n.this.tul), true, 1);
                    AppMethodBeat.o(47403);
                    return true;
                }
                ab.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                AppMethodBeat.o(47403);
                return false;
            }

            public final boolean x(Object... objArr) {
                AppMethodBeat.i(47404);
                ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                iVar2.a(new com.tencent.mm.plugin.wallet_core.c.s(n.this.gEk, n.this.token, 0), true, 1);
                AppMethodBeat.o(47404);
                return true;
            }

            public final boolean c(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(47405);
                if (i != 0 || i2 != 0) {
                    if (mVar instanceof ac) {
                        ab.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
                    }
                    AppMethodBeat.o(47405);
                    return false;
                } else if (mVar instanceof ac) {
                    ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    ac acVar = (ac) mVar;
                    Bundle bundle = n.this.mqu;
                    bundle.putString("key_jsapi_token", acVar.tuu);
                    n.this.b(mMActivity2, bundle);
                    AppMethodBeat.o(47405);
                    return true;
                } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.s) {
                    AppMethodBeat.o(47405);
                    return true;
                } else {
                    AppMethodBeat.o(47405);
                    return false;
                }
            }
        };
        AppMethodBeat.o(47408);
        return anonymousClass1;
    }
}
