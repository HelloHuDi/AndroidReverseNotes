package com.tencent.mm.plugin.walletlock.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.si;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends com.tencent.mm.sdk.b.c<si> {
    public c() {
        AppMethodBeat.i(51688);
        this.xxI = si.class.getName().hashCode();
        AppMethodBeat.o(51688);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(51689);
        si siVar = (si) bVar;
        if (siVar != null) {
            Intent intent = siVar.cOC.cOE;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (siVar.cOC.czX != null) {
                ab.i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", Integer.valueOf(intExtra));
                if (intExtra == 2) {
                    intent.setClass(siVar.cOC.czX, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(siVar.cOC.czX, GestureGuardLogicUI.class);
                }
                siVar.cOC.czX.startActivityForResult(intent, siVar.cOC.requestCode);
                siVar.cOD.cxT = true;
            } else {
                siVar.cOD.cxT = false;
            }
            ab.i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", Boolean.valueOf(siVar.cOD.cxT));
        }
        AppMethodBeat.o(51689);
        return false;
    }
}
