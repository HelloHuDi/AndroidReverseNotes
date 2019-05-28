package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(41592);
        ab.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(41592);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(41593);
        if (activity instanceof WalletCheckPwdUI) {
            ab.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            if (this.mqu.getInt("key_open_biometric_type") == 1) {
                b(activity, FingerPrintAuthUI.class, bundle);
                AppMethodBeat.o(41593);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_scene", 0);
            a(activity, WalletFaceIdAuthUI.class, bundle, bundle2);
            AppMethodBeat.o(41593);
        } else if (activity instanceof FingerPrintAuthUI) {
            b(activity, bundle);
            AppMethodBeat.o(41593);
        } else {
            if (activity instanceof WalletFaceIdAuthUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(41593);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(41594);
        b(activity, new Bundle());
        AppMethodBeat.o(41594);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(41595);
        Intent intent = new Intent();
        ab.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        a(activity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, intent, true);
        AppMethodBeat.o(41595);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "FingerprintAuth";
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(41596);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(41591);
                    a.this.mqu.putString("pwd", (String) objArr[0]);
                    ab.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
                    AppMethodBeat.o(41591);
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }
            };
            AppMethodBeat.o(41596);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(41596);
        return a;
    }
}
