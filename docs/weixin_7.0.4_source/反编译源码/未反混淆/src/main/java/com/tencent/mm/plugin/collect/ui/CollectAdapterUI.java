package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class CollectAdapterUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41167);
        super.onCreate(bundle);
        AM(8);
        g.RQ();
        ab.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue()));
        if (((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
            d.b((Context) this, "collect", ".ui.CollectHKMainUI", getIntent());
        } else {
            d.b((Context) this, "collect", ".ui.CollectMainUI", getIntent());
        }
        finish();
        AppMethodBeat.o(41167);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
