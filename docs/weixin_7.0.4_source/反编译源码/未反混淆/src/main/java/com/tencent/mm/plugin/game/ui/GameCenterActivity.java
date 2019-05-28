package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class GameCenterActivity extends GameBaseActivity {
    protected int nfs = 0;
    protected String nft = null;
    private dd nfu;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        this.nfu = a.bDg();
        if (this.nfu != null) {
            this.nfs = c.parseColor(this.nfu.color);
            this.nft = this.nfu.mYo;
        }
        ab.i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
        if (d.iW(21) && this.nfs != 0) {
            xE(this.nfs);
        }
    }
}
