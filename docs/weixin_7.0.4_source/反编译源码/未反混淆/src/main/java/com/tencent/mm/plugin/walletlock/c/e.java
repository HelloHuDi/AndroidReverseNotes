package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class e extends a {
    private static b tWS;

    public final void init() {
        AppMethodBeat.i(51692);
        ab.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", bo.l(new Throwable()));
        ab.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", Integer.valueOf(r0), Integer.valueOf(bo.g(g.RP().Ry().get(40, null), 0) & 8388608));
        g gVar;
        c cVar;
        if ((bo.g(g.RP().Ry().get(40, null), 0) & 8388608) != 0) {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            tWS = bVar;
            bVar.init();
            gVar = g.tWY;
            ab.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", Boolean.valueOf(m.cvU()), Boolean.valueOf(g.cTY()));
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.cTz() && !r0) {
                ab.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", Boolean.valueOf(g.RP().Ry().getBoolean(a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)));
                if (g.RP().Ry().getBoolean(a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)) {
                    cVar = new c();
                    tWS = cVar;
                    cVar.init();
                    aDp();
                    AppMethodBeat.o(51692);
                    return;
                }
            }
        } else if (com.tencent.mm.plugin.walletlock.gesture.a.b.cTz()) {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
            cVar = new c();
            tWS = cVar;
            cVar.init();
            gVar = g.tWY;
            g.nz(false);
        } else {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
            tWS = new a();
            gVar = g.tWY;
            g.ny(false);
            tWS.init();
        }
        aDp();
        AppMethodBeat.o(51692);
    }

    private static void aDp() {
        AppMethodBeat.i(51693);
        ab.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", Integer.valueOf(g.tWY.cTV()));
        AppMethodBeat.o(51693);
    }

    public final void a(Activity activity, b.b bVar) {
        AppMethodBeat.i(51694);
        if (tWS != null) {
            tWS.a(activity, bVar);
        }
        AppMethodBeat.o(51694);
    }

    public final void a(Activity activity, b.b bVar, b.a aVar) {
        AppMethodBeat.i(51695);
        if (tWS != null) {
            tWS.a(activity, bVar, aVar);
        }
        AppMethodBeat.o(51695);
    }

    public final void h(Activity activity, int i) {
        AppMethodBeat.i(51696);
        super.h(activity, i);
        AppMethodBeat.o(51696);
    }

    public final void b(Activity activity, int i, int i2) {
        AppMethodBeat.i(51697);
        super.b(activity, i, i2);
        AppMethodBeat.o(51697);
    }

    public final void ad(Activity activity) {
        AppMethodBeat.i(51698);
        if (tWS != null) {
            tWS.ad(activity);
        }
        AppMethodBeat.o(51698);
    }

    public final void i(Activity activity, int i) {
        AppMethodBeat.i(51699);
        Intent intent = new Intent();
        intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.close_wallet_lock");
        d.b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
        AppMethodBeat.o(51699);
    }

    public final b.b cTi() {
        AppMethodBeat.i(51700);
        if (tWS != null) {
            b.b cTi = tWS.cTi();
            AppMethodBeat.o(51700);
            return cTi;
        }
        AppMethodBeat.o(51700);
        return null;
    }

    public final boolean cTj() {
        AppMethodBeat.i(51701);
        g gVar = g.tWY;
        if (!g.cTz()) {
            gVar = g.tWY;
            if (!g.cTn()) {
                AppMethodBeat.o(51701);
                return false;
            }
        }
        AppMethodBeat.o(51701);
        return true;
    }

    public final boolean cTk() {
        AppMethodBeat.i(51702);
        if (tWS != null) {
            boolean cTk = tWS.cTk();
            AppMethodBeat.o(51702);
            return cTk;
        }
        AppMethodBeat.o(51702);
        return false;
    }

    public final void b(Activity activity, Intent intent) {
        AppMethodBeat.i(51703);
        if (tWS != null) {
            tWS.b(activity, intent);
            AppMethodBeat.o(51703);
            return;
        }
        super.b(activity, intent);
        AppMethodBeat.o(51703);
    }

    public final void b(Activity activity, Intent intent, int i) {
        AppMethodBeat.i(51704);
        if (tWS != null) {
            tWS.b(activity, intent, i);
            AppMethodBeat.o(51704);
            return;
        }
        super.b(activity, intent, i);
        AppMethodBeat.o(51704);
    }

    public final void HB(int i) {
        AppMethodBeat.i(51705);
        g gVar;
        if (i == 1) {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
            c cVar = new c();
            tWS = cVar;
            cVar.init();
            gVar = g.tWY;
            g.nz(true);
            AppMethodBeat.o(51705);
        } else if (i == 2) {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            tWS = bVar;
            bVar.init();
            gVar = g.tWY;
            g.nx(false);
            AppMethodBeat.o(51705);
        } else if (i == 3) {
            ab.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
            com.tencent.mm.plugin.walletlock.b.a aVar = new com.tencent.mm.plugin.walletlock.b.a();
            tWS = aVar;
            aVar.init();
            AppMethodBeat.o(51705);
        } else if (i == 0) {
            ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
            a aVar2 = new a();
            tWS = aVar2;
            aVar2.init();
            gVar = g.tWY;
            g.ny(true);
            AppMethodBeat.o(51705);
        } else {
            ab.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
            AppMethodBeat.o(51705);
        }
    }
}
