package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.p1658b.C46333a;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;

/* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI */
public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements C1202f {
    /* renamed from: VO */
    private boolean f16193VO = false;
    private Dialog gII = null;

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI$1 */
    class C143561 implements OnCancelListener {
        C143561() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(48290);
            WalletOpenFingerprintPayRedirectUI.this.f16193VO = true;
            WalletOpenFingerprintPayRedirectUI.m68855a(WalletOpenFingerprintPayRedirectUI.this, "");
            AppMethodBeat.m2505o(48290);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI$2 */
    class C401552 implements OnClickListener {
        C401552() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48291);
            WalletOpenFingerprintPayRedirectUI.this.finish();
            AppMethodBeat.m2505o(48291);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48293);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        AppMethodBeat.m2505o(48293);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48294);
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(48294);
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(48295);
        C4990ab.m7416i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(c4737a)));
        switch (c4737a) {
            case LOGIN_OK:
                C4990ab.m7416i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C35475y(null, 19), 0);
                if (this.gII != null) {
                    this.gII.dismiss();
                    this.gII = null;
                }
                this.gII = C30901g.m49320g(this, new C143561());
                AppMethodBeat.m2505o(48295);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                C4990ab.m7412e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                m68854a(1, false, "");
                break;
            default:
                C4990ab.m7412e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(c4737a)));
                break;
        }
        m68854a(2, true, getString(C25738R.string.f8a));
        AppMethodBeat.m2505o(48295);
    }

    /* renamed from: a */
    private void m68854a(int i, boolean z, String str) {
        AppMethodBeat.m2504i(48296);
        C4990ab.m7413e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", Integer.valueOf(i));
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (z) {
            C30379h.m48448a((Context) this, str, "", false, new C401552());
            AppMethodBeat.m2505o(48296);
            return;
        }
        finish();
        AppMethodBeat.m2505o(48296);
    }

    public void onStop() {
        AppMethodBeat.m2504i(48297);
        super.onStop();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(48297);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48298);
        if (c1207m instanceof C35475y) {
            if (this.f16193VO) {
                C4990ab.m7420w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            } else {
                this.f16193VO = true;
                if (i == 0 && i2 == 0) {
                    C4990ab.m7416i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
                    C46332s.cNC();
                    C22587ak cND = C46332s.cND();
                    if (cND == null || !cND.cQg()) {
                        C4990ab.m7416i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                        m68854a(5, true, getString(C25738R.string.ff4));
                        AppMethodBeat.m2505o(48298);
                        return;
                    } else if (C46333a.cOQ() && C1427q.etg.ets == 1) {
                        Intent intent = new Intent();
                        intent.putExtra("key_is_from_system", true);
                        C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                        finish();
                        AppMethodBeat.m2505o(48298);
                        return;
                    } else {
                        C4990ab.m7412e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                        m68854a(6, true, getString(C25738R.string.ff6));
                        AppMethodBeat.m2505o(48298);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
                m68854a(3, true, getString(C25738R.string.f8a));
                AppMethodBeat.m2505o(48298);
                return;
            }
        }
        AppMethodBeat.m2505o(48298);
    }
}
