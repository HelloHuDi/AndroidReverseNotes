package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.collect.ui.CollectAdapterUI */
public class CollectAdapterUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41167);
        super.onCreate(bundle);
        mo9439AM(8);
        C1720g.m3537RQ();
        C4990ab.m7417i("MicroMsg.CollectAdapterUI", "walletRegion: %s", Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue()));
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
            C25985d.m41467b((Context) this, "collect", ".ui.CollectHKMainUI", getIntent());
        } else {
            C25985d.m41467b((Context) this, "collect", ".ui.CollectMainUI", getIntent());
        }
        finish();
        AppMethodBeat.m2505o(41167);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
