package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C29712b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40175b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C43835c;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40168a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40169b;
import com.tencent.p177mm.plugin.walletlock.p1623b.C43832a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.walletlock.c.e */
public final class C22716e extends C46387a {
    private static C40167b tWS;

    public final void init() {
        AppMethodBeat.m2504i(51692);
        C4990ab.m7417i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", C5046bo.m7574l(new Throwable()));
        C4990ab.m7417i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", Integer.valueOf(r0), Integer.valueOf(C5046bo.m7550g(C1720g.m3536RP().mo5239Ry().get(40, null), 0) & 8388608));
        C40171g c40171g;
        C43835c c43835c;
        if ((C5046bo.m7550g(C1720g.m3536RP().mo5239Ry().get(40, null), 0) & 8388608) != 0) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
            C29712b c29712b = new C29712b();
            tWS = c29712b;
            c29712b.init();
            c40171g = C40171g.tWY;
            C4990ab.m7417i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", Boolean.valueOf(C4104m.cvU()), Boolean.valueOf(C40171g.cTY()));
            if (C40175b.cTz() && !r0) {
                C4990ab.m7417i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", Boolean.valueOf(C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)));
                if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)) {
                    c43835c = new C43835c();
                    tWS = c43835c;
                    c43835c.init();
                    C22716e.aDp();
                    AppMethodBeat.m2505o(51692);
                    return;
                }
            }
        } else if (C40175b.cTz()) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
            c43835c = new C43835c();
            tWS = c43835c;
            c43835c.init();
            c40171g = C40171g.tWY;
            C40171g.m68902nz(false);
        } else {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
            tWS = new C46387a();
            c40171g = C40171g.tWY;
            C40171g.m68901ny(false);
            tWS.init();
        }
        C22716e.aDp();
        AppMethodBeat.m2505o(51692);
    }

    private static void aDp() {
        AppMethodBeat.m2504i(51693);
        C4990ab.m7417i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", Integer.valueOf(C40171g.tWY.cTV()));
        AppMethodBeat.m2505o(51693);
    }

    /* renamed from: a */
    public final void mo38286a(Activity activity, C40169b c40169b) {
        AppMethodBeat.m2504i(51694);
        if (tWS != null) {
            tWS.mo38286a(activity, c40169b);
        }
        AppMethodBeat.m2505o(51694);
    }

    /* renamed from: a */
    public final void mo38287a(Activity activity, C40169b c40169b, C40168a c40168a) {
        AppMethodBeat.m2504i(51695);
        if (tWS != null) {
            tWS.mo38287a(activity, c40169b, c40168a);
        }
        AppMethodBeat.m2505o(51695);
    }

    /* renamed from: h */
    public final void mo38295h(Activity activity, int i) {
        AppMethodBeat.m2504i(51696);
        super.mo38295h(activity, i);
        AppMethodBeat.m2505o(51696);
    }

    /* renamed from: b */
    public final void mo38289b(Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(51697);
        super.mo38289b(activity, i, i2);
        AppMethodBeat.m2505o(51697);
    }

    /* renamed from: ad */
    public final void mo38288ad(Activity activity) {
        AppMethodBeat.m2504i(51698);
        if (tWS != null) {
            tWS.mo38288ad(activity);
        }
        AppMethodBeat.m2505o(51698);
    }

    /* renamed from: i */
    public final void mo38296i(Activity activity, int i) {
        AppMethodBeat.m2504i(51699);
        Intent intent = new Intent();
        intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.close_wallet_lock");
        C25985d.m41468b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
        AppMethodBeat.m2505o(51699);
    }

    public final C40169b cTi() {
        AppMethodBeat.m2504i(51700);
        if (tWS != null) {
            C40169b cTi = tWS.cTi();
            AppMethodBeat.m2505o(51700);
            return cTi;
        }
        AppMethodBeat.m2505o(51700);
        return null;
    }

    public final boolean cTj() {
        AppMethodBeat.m2504i(51701);
        C40171g c40171g = C40171g.tWY;
        if (!C40171g.cTz()) {
            c40171g = C40171g.tWY;
            if (!C40171g.cTn()) {
                AppMethodBeat.m2505o(51701);
                return false;
            }
        }
        AppMethodBeat.m2505o(51701);
        return true;
    }

    public final boolean cTk() {
        AppMethodBeat.m2504i(51702);
        if (tWS != null) {
            boolean cTk = tWS.cTk();
            AppMethodBeat.m2505o(51702);
            return cTk;
        }
        AppMethodBeat.m2505o(51702);
        return false;
    }

    /* renamed from: b */
    public final void mo38290b(Activity activity, Intent intent) {
        AppMethodBeat.m2504i(51703);
        if (tWS != null) {
            tWS.mo38290b(activity, intent);
            AppMethodBeat.m2505o(51703);
            return;
        }
        super.mo38290b(activity, intent);
        AppMethodBeat.m2505o(51703);
    }

    /* renamed from: b */
    public final void mo38291b(Activity activity, Intent intent, int i) {
        AppMethodBeat.m2504i(51704);
        if (tWS != null) {
            tWS.mo38291b(activity, intent, i);
            AppMethodBeat.m2505o(51704);
            return;
        }
        super.mo38291b(activity, intent, i);
        AppMethodBeat.m2505o(51704);
    }

    /* renamed from: HB */
    public final void mo38285HB(int i) {
        AppMethodBeat.m2504i(51705);
        C40171g c40171g;
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
            C43835c c43835c = new C43835c();
            tWS = c43835c;
            c43835c.init();
            c40171g = C40171g.tWY;
            C40171g.m68902nz(true);
            AppMethodBeat.m2505o(51705);
        } else if (i == 2) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
            C29712b c29712b = new C29712b();
            tWS = c29712b;
            c29712b.init();
            c40171g = C40171g.tWY;
            C40171g.m68900nx(false);
            AppMethodBeat.m2505o(51705);
        } else if (i == 3) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
            C43832a c43832a = new C43832a();
            tWS = c43832a;
            c43832a.init();
            AppMethodBeat.m2505o(51705);
        } else if (i == 0) {
            C4990ab.m7416i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
            C46387a c46387a = new C46387a();
            tWS = c46387a;
            c46387a.init();
            c40171g = C40171g.tWY;
            C40171g.m68901ny(true);
            AppMethodBeat.m2505o(51705);
        } else {
            C4990ab.m7412e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
            AppMethodBeat.m2505o(51705);
        }
    }
}
