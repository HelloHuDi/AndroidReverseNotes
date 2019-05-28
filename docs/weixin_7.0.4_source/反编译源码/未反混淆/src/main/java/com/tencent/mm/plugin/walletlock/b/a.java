package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a extends com.tencent.mm.plugin.walletlock.c.a {
    public final void init() {
        AppMethodBeat.i(51445);
        g gVar = g.tWY;
        g.cTX();
        g.tWY.HG(3);
        AppMethodBeat.o(51445);
    }

    public final void a(Activity activity, b bVar) {
        AppMethodBeat.i(51446);
        if (!com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ab.d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(51446);
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
                    intent.putExtra("scene", com.tencent.mm.plugin.walletlock.c.a.af(activity));
                    intent.setPackage(ah.getPackageName());
                    activity.startActivity(intent);
                    break;
            }
            AppMethodBeat.o(51446);
        } else {
            ab.d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(51446);
        }
    }

    public final void a(Activity activity, b bVar, com.tencent.mm.plugin.walletlock.a.b.a aVar) {
        AppMethodBeat.i(51447);
        super.a(activity, bVar, aVar);
        AppMethodBeat.o(51447);
    }

    public final void b(Activity activity, int i, int i2) {
        AppMethodBeat.i(51448);
        super.b(activity, i, i2);
        AppMethodBeat.o(51448);
    }

    public final b cTi() {
        AppMethodBeat.i(51449);
        d cTU = d.cTU();
        AppMethodBeat.o(51449);
        return cTU;
    }

    public final boolean cTj() {
        AppMethodBeat.i(51450);
        g gVar = g.tWY;
        boolean cTo = g.cTo();
        AppMethodBeat.o(51450);
        return cTo;
    }
}
