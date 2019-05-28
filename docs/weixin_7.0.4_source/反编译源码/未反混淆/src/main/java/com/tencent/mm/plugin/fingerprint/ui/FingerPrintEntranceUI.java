package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(41659);
        super.onCreate(bundle);
        ab.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (e.bxJ()) {
            ab.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            ab.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            h.a((Context) this, getResources().getString(R.string.etm), "", getResources().getString(((l) g.K(l.class)).bxr() ? R.string.abk : R.string.s6), getString(R.string.or), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41655);
                    ab.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
                    FingerPrintEntranceUI.a(FingerPrintEntranceUI.this);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(41655);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41656);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(41656);
                }
            });
            e.bxF();
        } else if (e.bxE()) {
            z = false;
        } else {
            ab.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            h.a((Context) this, getResources().getString(R.string.etl), "", getResources().getString(R.string.abi), getString(R.string.or), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41657);
                    ab.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
                    d.H(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(41657);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41658);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(41658);
                }
            });
            e.bxD();
        }
        if (!z) {
            ab.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
        AppMethodBeat.o(41659);
    }

    public void onResume() {
        AppMethodBeat.i(41660);
        super.onResume();
        AppMethodBeat.o(41660);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void a(FingerPrintEntranceUI fingerPrintEntranceUI) {
        AppMethodBeat.i(41661);
        ((l) g.K(l.class)).dO(fingerPrintEntranceUI);
        AppMethodBeat.o(41661);
    }
}
