package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.ab;

public class a implements b {
    protected static int af(Activity activity) {
        AppMethodBeat.i(51682);
        ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", activity.getClass().getSimpleName());
        if (activity.getClass().getSimpleName().equals("MallIndexUI")) {
            AppMethodBeat.o(51682);
            return 1;
        } else if (activity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
            AppMethodBeat.o(51682);
            return 2;
        } else {
            AppMethodBeat.o(51682);
            return -1;
        }
    }

    public void init() {
        AppMethodBeat.i(51683);
        g.tWY.HG(0);
        AppMethodBeat.o(51683);
    }

    public void a(Activity activity, b.b bVar) {
    }

    public void a(Activity activity, b.b bVar, com.tencent.mm.plugin.walletlock.a.b.a aVar) {
    }

    public void h(Activity activity, int i) {
        AppMethodBeat.i(51684);
        ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", Integer.valueOf(i));
        if (i == 1) {
            new c().h(activity, i);
            AppMethodBeat.o(51684);
            return;
        }
        if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().h(activity, i);
        }
        AppMethodBeat.o(51684);
    }

    public void b(Activity activity, int i, int i2) {
        AppMethodBeat.i(51685);
        ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            new c().b(activity, i, i2);
            AppMethodBeat.o(51685);
            return;
        }
        if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(activity, i, i2);
        }
        AppMethodBeat.o(51685);
    }

    public void ad(Activity activity) {
    }

    public void i(Activity activity, int i) {
    }

    public b.b cTi() {
        return null;
    }

    public boolean cTj() {
        return false;
    }

    public boolean cTk() {
        return false;
    }

    public void b(Activity activity, Intent intent) {
        AppMethodBeat.i(51686);
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivity(intent);
        AppMethodBeat.o(51686);
    }

    public void b(Activity activity, Intent intent, int i) {
        AppMethodBeat.i(51687);
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivityForResult(intent, i);
        AppMethodBeat.o(51687);
    }

    public void HB(int i) {
    }
}
