package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a extends c {
    public c a(Activity activity, Bundle bundle) {
        F("start", activity, bundle);
        if (bundle != null) {
            bundle.putBoolean("key_is_bind_reg_process", true);
        }
        b(activity, WalletBankcardIdUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        F("forward", activity, Integer.valueOf(i), bundle);
        if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletOrderInfoUI) {
            b(activity, bundle);
        }
    }

    public void c(Activity activity, int i) {
        F("back", activity, Integer.valueOf(i));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            F(activity);
        }
    }

    public boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletOrderInfoUI;
    }

    public boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                ab.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
                h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(R.string.fa5), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46467);
                        a.this.b(walletBaseUI, a.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.o(46467);
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public int a(MMActivity mMActivity, int i) {
        return R.string.fgl;
    }
}
