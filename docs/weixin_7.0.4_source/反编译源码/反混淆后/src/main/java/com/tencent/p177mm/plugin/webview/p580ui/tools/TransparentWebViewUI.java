package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.TransparentWebViewUI */
public class TransparentWebViewUI extends GameWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7585);
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.uvh != null) {
                this.uvh.enable();
                AppMethodBeat.m2505o(7585);
                return;
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.uvh != null) {
                this.uvh.enable();
            }
        }
        AppMethodBeat.m2505o(7585);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(7586);
        super.initView();
        dao().uuh = true;
        dao().hfA = false;
        dao().mo69669nM(true);
        dao().mo69666Jp(0);
        if (!(getIntent() != null && getIntent().hasExtra("show_full_screen") && getIntent().getBooleanExtra("show_full_screen", false))) {
            z = false;
        }
        if (z && this.uve != null) {
            this.uve.setCanMove(false);
        }
        AppMethodBeat.m2505o(7586);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZH() {
        AppMethodBeat.m2504i(7587);
        setBackGroundColorResource(0);
        this.mController.contentView.setBackgroundResource(0);
        this.pzf.setBackgroundResource(17170445);
        this.pzf.setBackgroundColor(0);
        findViewById(2131823600).setBackgroundResource(17170445);
        findViewById(2131823601).setBackgroundResource(17170445);
        AppMethodBeat.m2505o(7587);
    }

    public final boolean aYc() {
        return false;
    }
}
