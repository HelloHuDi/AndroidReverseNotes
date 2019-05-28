package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI */
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48160);
        super.onCreate(bundle);
        mo9439AM(4);
        C40931c dOD = dOD();
        if (dOD != null) {
            int i = this.mBundle.getInt(C43818a.tPH, 0);
            String string = this.mBundle.getString(C43818a.tPN);
            C4990ab.m7417i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", Integer.valueOf(i), string);
            if (i == 3) {
                dOE().mo9366p(Integer.valueOf(i), string);
                AppMethodBeat.m2505o(48160);
                return;
            }
            dOD.mo8125b(this, this.mBundle);
            finish();
        }
        AppMethodBeat.m2505o(48160);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
