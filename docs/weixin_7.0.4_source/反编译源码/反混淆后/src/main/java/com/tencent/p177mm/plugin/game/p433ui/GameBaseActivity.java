package com.tencent.p177mm.plugin.game.p433ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBaseActivity */
public abstract class GameBaseActivity extends MMActivity {
    private long mStartTime = 0;
    private int neK = 1;
    private long neL = 0;
    private long neM = 0;

    public abstract int bFf();

    public abstract int bFg();

    public abstract int bFh();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
        }
        this.neM = System.currentTimeMillis();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.neL += System.currentTimeMillis() - this.neM;
    }

    public void onDestroy() {
        if (this.mStartTime != 0) {
            C4990ab.m7417i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", getClass().getSimpleName(), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Long.valueOf(this.neL));
            if (bFe()) {
                C34276a.m56204a(this.neK, bFf(), bFg(), (long) bFh(), "", "", r8 / 1000, this.neL / 1000);
            }
        }
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public boolean bFe() {
        return true;
    }
}
