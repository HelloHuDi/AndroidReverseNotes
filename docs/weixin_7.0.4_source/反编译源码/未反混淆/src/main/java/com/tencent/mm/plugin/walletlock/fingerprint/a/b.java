package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.c.a;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends a {
    public final void init() {
        AppMethodBeat.i(51463);
        g gVar = g.tWY;
        g.cTW();
        g.tWY.HG(2);
        AppMethodBeat.o(51463);
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar) {
        AppMethodBeat.i(51464);
        if (!com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51464);
        } else if (bVar == null || bVar.ae(activity)) {
            ur urVar = new ur();
            urVar.cRv.cRx = 0;
            urVar.cRv.activity = activity;
            com.tencent.mm.sdk.b.a.xxA.m(urVar);
            switch (((Integer) urVar.cRw.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.af(activity));
                    intent.setPackage(ah.getPackageName());
                    activity.startActivity(intent);
                    break;
            }
            AppMethodBeat.o(51464);
        } else {
            ab.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(51464);
        }
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar, com.tencent.mm.plugin.walletlock.a.b.a aVar) {
        AppMethodBeat.i(51465);
        if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ur urVar = new ur();
            urVar.cRv.cRx = 1;
            urVar.cRv.activity = activity;
            com.tencent.mm.sdk.b.a.xxA.m(urVar);
            switch (((Integer) urVar.cRw.data).intValue()) {
                case 17:
                    if (bVar != null && !bVar.ae(activity)) {
                        ab.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                        break;
                    }
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.af(activity));
                    intent.setPackage(ah.getPackageName());
                    activity.startActivity(intent);
                    AppMethodBeat.o(51465);
                    return;
                    break;
            }
            AppMethodBeat.o(51465);
            return;
        }
        ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        AppMethodBeat.o(51465);
    }

    public final void h(Activity activity, int i) {
        AppMethodBeat.i(51466);
        if (i != 2) {
            AppMethodBeat.o(51466);
        } else if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            d.b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
            AppMethodBeat.o(51466);
        } else {
            ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51466);
        }
    }

    public final void b(Activity activity, int i, int i2) {
        AppMethodBeat.i(51467);
        if (i != 2) {
            AppMethodBeat.o(51467);
        } else if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            ab.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", Integer.valueOf(i));
            d.b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
            AppMethodBeat.o(51467);
        } else {
            ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51467);
        }
    }

    public final void ad(Activity activity) {
    }

    public final void i(Activity activity, int i) {
    }

    public final com.tencent.mm.plugin.walletlock.a.b.b cTi() {
        AppMethodBeat.i(51468);
        com.tencent.mm.plugin.walletlock.c.d cTU = com.tencent.mm.plugin.walletlock.c.d.cTU();
        AppMethodBeat.o(51468);
        return cTU;
    }

    public final boolean cTj() {
        AppMethodBeat.i(51469);
        g gVar = g.tWY;
        boolean cTn = g.cTn();
        AppMethodBeat.o(51469);
        return cTn;
    }

    public final boolean cTk() {
        return false;
    }
}
