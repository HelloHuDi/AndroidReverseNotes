package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.c.a;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c extends a {
    public final void init() {
        AppMethodBeat.i(51550);
        ab.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
        g gVar = g.tWY;
        g.nx(true);
        g.tWY.HG(1);
        AppMethodBeat.o(51550);
    }

    public final void a(Activity activity, b bVar) {
        AppMethodBeat.i(51551);
        if (!com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51551);
        } else if (bVar == null || bVar.ae(activity)) {
            ur urVar = new ur();
            urVar.cRv.cRx = 0;
            urVar.cRv.activity = activity;
            com.tencent.mm.sdk.b.a.xxA.m(urVar);
            switch (((Integer) urVar.cRw.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.af(activity));
                    intent.setPackage(ah.getPackageName());
                    activity.startActivity(intent);
                    h.pYm.e(12097, Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    break;
            }
            AppMethodBeat.o(51551);
        } else {
            ab.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(51551);
        }
    }

    public final void a(Activity activity, b bVar, com.tencent.mm.plugin.walletlock.a.b.a aVar) {
        AppMethodBeat.i(51552);
        if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ur urVar = new ur();
            urVar.cRv.cRx = 1;
            urVar.cRv.activity = activity;
            com.tencent.mm.sdk.b.a.xxA.m(urVar);
            switch (((Integer) urVar.cRw.data).intValue()) {
                case 17:
                    if (bVar != null && !bVar.ae(activity)) {
                        ab.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                        break;
                    }
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.af(activity));
                    intent.setPackage(ah.getPackageName());
                    activity.startActivity(intent);
                    AppMethodBeat.o(51552);
                    return;
                    break;
            }
            AppMethodBeat.o(51552);
            return;
        }
        ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        AppMethodBeat.o(51552);
    }

    public final void h(Activity activity, int i) {
        AppMethodBeat.i(51553);
        if (i != 1) {
            AppMethodBeat.o(51553);
        } else if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 1);
            d.b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
            AppMethodBeat.o(51553);
        } else {
            ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51553);
        }
    }

    public final void b(Activity activity, int i, int i2) {
        AppMethodBeat.i(51554);
        if (i != 1) {
            AppMethodBeat.o(51554);
        } else if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 1);
            d.b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
            AppMethodBeat.o(51554);
        } else {
            ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51554);
        }
    }

    public final void ad(Activity activity) {
        AppMethodBeat.i(51555);
        if (!com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51555);
        } else if (b.cTz()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
            intent.putExtra("next_action", "next_action.modify_pattern");
            intent.setPackage(ah.getPackageName());
            activity.startActivity(intent);
            AppMethodBeat.o(51555);
        } else {
            ab.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
            AppMethodBeat.o(51555);
        }
    }

    public final void i(Activity activity, int i) {
        AppMethodBeat.i(51556);
        if (!com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51556);
        } else if (b.cTz()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
            intent.putExtra("next_action", "next_action.switch_off_pattern");
            intent.setPackage(ah.getPackageName());
            activity.startActivity(intent);
            AppMethodBeat.o(51556);
        } else {
            ab.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
            AppMethodBeat.o(51556);
        }
    }

    public final boolean cTj() {
        AppMethodBeat.i(139162);
        boolean cTz = b.cTz();
        AppMethodBeat.o(139162);
        return cTz;
    }

    public final boolean cTk() {
        AppMethodBeat.i(51558);
        boolean cTA = b.cTA();
        AppMethodBeat.o(51558);
        return cTA;
    }

    public final /* synthetic */ b cTi() {
        AppMethodBeat.i(51559);
        com.tencent.mm.plugin.walletlock.c.d cTU = com.tencent.mm.plugin.walletlock.c.d.cTU();
        AppMethodBeat.o(51559);
        return cTU;
    }
}
