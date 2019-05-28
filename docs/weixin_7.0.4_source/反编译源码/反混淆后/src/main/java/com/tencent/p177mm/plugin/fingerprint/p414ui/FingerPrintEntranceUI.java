package com.tencent.p177mm.plugin.fingerprint.p414ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39088e;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI */
public class FingerPrintEntranceUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI$3 */
    class C31343 implements OnClickListener {
        C31343() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41657);
            C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
            C25985d.m41448H(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.m2505o(41657);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI$4 */
    class C207704 implements OnClickListener {
        C207704() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41658);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.m2505o(41658);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI$2 */
    class C247582 implements OnClickListener {
        C247582() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41656);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.m2505o(41656);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI$1 */
    class C247591 implements OnClickListener {
        C247591() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41655);
            C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
            FingerPrintEntranceUI.m38646a(FingerPrintEntranceUI.this);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.m2505o(41655);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(41659);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (C39088e.bxJ()) {
            C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            C30379h.m48445a((Context) this, getResources().getString(C25738R.string.etm), "", getResources().getString(((C30052l) C1720g.m3528K(C30052l.class)).bxr() ? C25738R.string.abk : C25738R.string.f9187s6), getString(C25738R.string.f9076or), true, new C247591(), new C247582());
            C39088e.bxF();
        } else if (C39088e.bxE()) {
            z = false;
        } else {
            C4990ab.m7416i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            C30379h.m48445a((Context) this, getResources().getString(C25738R.string.etl), "", getResources().getString(C25738R.string.abi), getString(C25738R.string.f9076or), true, new C31343(), new C207704());
            C39088e.bxD();
        }
        if (!z) {
            C4990ab.m7412e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
        AppMethodBeat.m2505o(41659);
    }

    public void onResume() {
        AppMethodBeat.m2504i(41660);
        super.onResume();
        AppMethodBeat.m2505o(41660);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: a */
    static /* synthetic */ void m38646a(FingerPrintEntranceUI fingerPrintEntranceUI) {
        AppMethodBeat.m2504i(41661);
        ((C30052l) C1720g.m3528K(C30052l.class)).mo48310dO(fingerPrintEntranceUI);
        AppMethodBeat.m2505o(41661);
    }
}
