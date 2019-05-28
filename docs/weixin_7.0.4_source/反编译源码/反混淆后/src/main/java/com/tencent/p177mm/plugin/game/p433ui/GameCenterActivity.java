package com.tencent.p177mm.plugin.game.p433ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameCenterActivity */
public abstract class GameCenterActivity extends GameBaseActivity {
    protected int nfs = 0;
    protected String nft = null;
    private C39197dd nfu;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        this.nfu = C45985a.bDg();
        if (this.nfu != null) {
            this.nfs = C46001c.parseColor(this.nfu.color);
            this.nft = this.nfu.mYo;
        }
        C4990ab.m7416i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
        if (C1443d.m3068iW(21) && this.nfs != 0) {
            mo17446xE(this.nfs);
        }
    }
}
