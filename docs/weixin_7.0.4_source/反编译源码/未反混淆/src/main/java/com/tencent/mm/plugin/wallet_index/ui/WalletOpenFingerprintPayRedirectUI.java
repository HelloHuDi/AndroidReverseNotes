package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements f {
    private boolean VO = false;
    private Dialog gII = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48293);
        super.onCreate(bundle);
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        AppMethodBeat.o(48293);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean O(Intent intent) {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(48294);
        super.onDestroy();
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(48294);
    }

    public final void a(a aVar, Intent intent) {
        AppMethodBeat.i(48295);
        ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(aVar)));
        switch (aVar) {
            case LOGIN_OK:
                ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                g.RQ();
                g.RO().eJo.a(new y(null, 19), 0);
                if (this.gII != null) {
                    this.gII.dismiss();
                    this.gII = null;
                }
                this.gII = com.tencent.mm.wallet_core.ui.g.g(this, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(48290);
                        WalletOpenFingerprintPayRedirectUI.this.VO = true;
                        WalletOpenFingerprintPayRedirectUI.a(WalletOpenFingerprintPayRedirectUI.this, "");
                        AppMethodBeat.o(48290);
                    }
                });
                AppMethodBeat.o(48295);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                a(1, false, "");
                break;
            default:
                ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        a(2, true, getString(R.string.f8a));
        AppMethodBeat.o(48295);
    }

    private void a(int i, boolean z, String str) {
        AppMethodBeat.i(48296);
        ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", Integer.valueOf(i));
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (z) {
            h.a((Context) this, str, "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48291);
                    WalletOpenFingerprintPayRedirectUI.this.finish();
                    AppMethodBeat.o(48291);
                }
            });
            AppMethodBeat.o(48296);
            return;
        }
        finish();
        AppMethodBeat.o(48296);
    }

    public void onStop() {
        AppMethodBeat.i(48297);
        super.onStop();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(48297);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48298);
        if (mVar instanceof y) {
            if (this.VO) {
                ab.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            } else {
                this.VO = true;
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
                    s.cNC();
                    ak cND = s.cND();
                    if (cND == null || !cND.cQg()) {
                        ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                        a(5, true, getString(R.string.ff4));
                        AppMethodBeat.o(48298);
                        return;
                    } else if (com.tencent.mm.plugin.wallet.b.a.cOQ() && q.etg.ets == 1) {
                        Intent intent = new Intent();
                        intent.putExtra("key_is_from_system", true);
                        d.b((Context) this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                        finish();
                        AppMethodBeat.o(48298);
                        return;
                    } else {
                        ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                        a(6, true, getString(R.string.ff6));
                        AppMethodBeat.o(48298);
                        return;
                    }
                }
                ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
                a(3, true, getString(R.string.f8a));
                AppMethodBeat.o(48298);
                return;
            }
        }
        AppMethodBeat.o(48298);
    }
}
