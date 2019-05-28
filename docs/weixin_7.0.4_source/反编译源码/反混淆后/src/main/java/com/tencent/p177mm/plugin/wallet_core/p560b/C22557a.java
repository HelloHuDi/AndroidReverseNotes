package com.tencent.p177mm.plugin.wallet_core.p560b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardElementUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletConfirmCardIDUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wallet_core.b.a */
public abstract class C22557a extends C40931c {
    /* renamed from: a */
    public C40931c mo8123a(Activity activity, Bundle bundle) {
        mo64557F("start", activity, bundle);
        if (bundle != null) {
            bundle.putBoolean("key_is_bind_reg_process", true);
        }
        mo64571b(activity, WalletBankcardIdUI.class, bundle);
        return this;
    }

    /* renamed from: a */
    public void mo8124a(Activity activity, int i, Bundle bundle) {
        mo64557F("forward", activity, Integer.valueOf(i), bundle);
        if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            mo64571b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            mo64571b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletOrderInfoUI) {
            mo8125b(activity, bundle);
        }
    }

    /* renamed from: c */
    public void mo8127c(Activity activity, int i) {
        mo64557F("back", activity, Integer.valueOf(i));
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
        } else {
            mo55241F(activity);
        }
    }

    /* renamed from: c */
    public boolean mo8128c(Activity activity, Bundle bundle) {
        return activity instanceof WalletOrderInfoUI;
    }

    /* renamed from: a */
    public boolean mo26470a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                C4990ab.m7416i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
                C30379h.m48447a((Context) walletBaseUI, str, null, walletBaseUI.getString(C25738R.string.fa5), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46467);
                        C22557a.this.mo8125b(walletBaseUI, C22557a.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.m2505o(46467);
                    }
                });
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.fgl;
    }
}
