package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7585);
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.uvh != null) {
                this.uvh.enable();
                AppMethodBeat.o(7585);
                return;
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.uvh != null) {
                this.uvh.enable();
            }
        }
        AppMethodBeat.o(7585);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(7586);
        super.initView();
        dao().uuh = true;
        dao().hfA = false;
        dao().nM(true);
        dao().Jp(0);
        if (!(getIntent() != null && getIntent().hasExtra("show_full_screen") && getIntent().getBooleanExtra("show_full_screen", false))) {
            z = false;
        }
        if (z && this.uve != null) {
            this.uve.setCanMove(false);
        }
        AppMethodBeat.o(7586);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZH() {
        AppMethodBeat.i(7587);
        setBackGroundColorResource(0);
        this.mController.contentView.setBackgroundResource(0);
        this.pzf.setBackgroundResource(17170445);
        this.pzf.setBackgroundColor(0);
        findViewById(R.id.bhl).setBackgroundResource(17170445);
        findViewById(R.id.bhm).setBackgroundResource(17170445);
        AppMethodBeat.o(7587);
    }

    public final boolean aYc() {
        return false;
    }
}
