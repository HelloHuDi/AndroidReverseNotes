package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32632si;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1058ui.FingerprintWalletLockUI;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.GestureGuardLogicUI;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.walletlock.c.c */
public final class C29710c extends C4884c<C32632si> {
    public C29710c() {
        AppMethodBeat.m2504i(51688);
        this.xxI = C32632si.class.getName().hashCode();
        AppMethodBeat.m2505o(51688);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(51689);
        C32632si c32632si = (C32632si) c4883b;
        if (c32632si != null) {
            Intent intent = c32632si.cOC.cOE;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (c32632si.cOC.czX != null) {
                C4990ab.m7417i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", Integer.valueOf(intExtra));
                if (intExtra == 2) {
                    intent.setClass(c32632si.cOC.czX, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(c32632si.cOC.czX, GestureGuardLogicUI.class);
                }
                c32632si.cOC.czX.startActivityForResult(intent, c32632si.cOC.requestCode);
                c32632si.cOD.cxT = true;
            } else {
                c32632si.cOD.cxT = false;
            }
            C4990ab.m7417i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", Boolean.valueOf(c32632si.cOD.cxT));
        }
        AppMethodBeat.m2505o(51689);
        return false;
    }
}
