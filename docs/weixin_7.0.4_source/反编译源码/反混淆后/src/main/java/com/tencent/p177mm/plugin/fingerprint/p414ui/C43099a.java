package com.tencent.p177mm.plugin.fingerprint.p414ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.fingerprint.ui.a */
public class C43099a extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(41592);
        C4990ab.m7416i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        mo64571b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(41592);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(41593);
        if (activity instanceof WalletCheckPwdUI) {
            C4990ab.m7416i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            if (this.mqu.getInt("key_open_biometric_type") == 1) {
                mo64571b(activity, FingerPrintAuthUI.class, bundle);
                AppMethodBeat.m2505o(41593);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_scene", 0);
            mo64563a(activity, WalletFaceIdAuthUI.class, bundle, bundle2);
            AppMethodBeat.m2505o(41593);
        } else if (activity instanceof FingerPrintAuthUI) {
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(41593);
        } else {
            if (activity instanceof WalletFaceIdAuthUI) {
                mo8125b(activity, bundle);
            }
            AppMethodBeat.m2505o(41593);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(41594);
        mo8125b(activity, new Bundle());
        AppMethodBeat.m2505o(41594);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(41595);
        Intent intent = new Intent();
        C4990ab.m7416i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        mo64564a(activity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, intent, true);
        AppMethodBeat.m2505o(41595);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "FingerprintAuth";
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(41596);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C119441 c119441 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(41591);
                    C43099a.this.mqu.putString("pwd", (String) objArr[0]);
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
                    AppMethodBeat.m2505o(41591);
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(41596);
            return c119441;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(41596);
        return a;
    }
}
