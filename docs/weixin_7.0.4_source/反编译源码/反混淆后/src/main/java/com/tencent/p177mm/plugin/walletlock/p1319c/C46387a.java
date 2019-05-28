package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C29712b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C43835c;
import com.tencent.p177mm.plugin.walletlock.p1060ui.WalletLockSettingUI;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40168a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40169b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.walletlock.c.a */
public class C46387a implements C40167b {
    /* renamed from: af */
    protected static int m87240af(Activity activity) {
        AppMethodBeat.m2504i(51682);
        C4990ab.m7417i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", activity.getClass().getSimpleName());
        if (activity.getClass().getSimpleName().equals("MallIndexUI")) {
            AppMethodBeat.m2505o(51682);
            return 1;
        } else if (activity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
            AppMethodBeat.m2505o(51682);
            return 2;
        } else {
            AppMethodBeat.m2505o(51682);
            return -1;
        }
    }

    public void init() {
        AppMethodBeat.m2504i(51683);
        C40171g.tWY.mo63507HG(0);
        AppMethodBeat.m2505o(51683);
    }

    /* renamed from: a */
    public void mo38286a(Activity activity, C40169b c40169b) {
    }

    /* renamed from: a */
    public void mo38287a(Activity activity, C40169b c40169b, C40168a c40168a) {
    }

    /* renamed from: h */
    public void mo38295h(Activity activity, int i) {
        AppMethodBeat.m2504i(51684);
        C4990ab.m7417i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", Integer.valueOf(i));
        if (i == 1) {
            new C43835c().mo38295h(activity, i);
            AppMethodBeat.m2505o(51684);
            return;
        }
        if (i == 2) {
            new C29712b().mo38295h(activity, i);
        }
        AppMethodBeat.m2505o(51684);
    }

    /* renamed from: b */
    public void mo38289b(Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(51685);
        C4990ab.m7417i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            new C43835c().mo38289b(activity, i, i2);
            AppMethodBeat.m2505o(51685);
            return;
        }
        if (i == 2) {
            new C29712b().mo38289b(activity, i, i2);
        }
        AppMethodBeat.m2505o(51685);
    }

    /* renamed from: ad */
    public void mo38288ad(Activity activity) {
    }

    /* renamed from: i */
    public void mo38296i(Activity activity, int i) {
    }

    public C40169b cTi() {
        return null;
    }

    public boolean cTj() {
        return false;
    }

    public boolean cTk() {
        return false;
    }

    /* renamed from: b */
    public void mo38290b(Activity activity, Intent intent) {
        AppMethodBeat.m2504i(51686);
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(51686);
    }

    /* renamed from: b */
    public void mo38291b(Activity activity, Intent intent, int i) {
        AppMethodBeat.m2504i(51687);
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(51687);
    }

    /* renamed from: HB */
    public void mo38285HB(int i) {
    }
}
