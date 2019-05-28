package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.websearch.api.C14423an;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSWebViewUI */
public class FTSWebViewUI extends FTSBaseWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getHint() {
        AppMethodBeat.m2504i(8539);
        String string = getString(C25738R.string.f9220te);
        AppMethodBeat.m2505o(8539);
        return string;
    }

    public final void aMh() {
        AppMethodBeat.m2504i(8540);
        super.aMh();
        C14423an.m22638Ij(this.scene);
        if (this.scene == 21) {
            C14423an.m22640Il(17);
        }
        AppMethodBeat.m2505o(8540);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8541);
        super.onResume();
        C14423an.cVv();
        AppMethodBeat.m2505o(8541);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8542);
        super.onPause();
        C14423an.cVw();
        AppMethodBeat.m2505o(8542);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8543);
        super.onDestroy();
        C14423an.cVx();
        C14423an.cVy();
        if (this.scene == 21) {
            C14423an.m22640Il(18);
        }
        AppMethodBeat.m2505o(8543);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(8544);
        super.onBackPressed();
        dbN();
        AppMethodBeat.m2505o(8544);
    }

    public void onClickCancelBtn(View view) {
        AppMethodBeat.m2504i(8545);
        super.onClickCancelBtn(view);
        finish();
        AppMethodBeat.m2505o(8545);
    }

    public final void daC() {
        AppMethodBeat.m2504i(8547);
        dbN();
        super.daC();
        AppMethodBeat.m2505o(8547);
    }

    private void dbN() {
        AppMethodBeat.m2504i(8546);
        if (this.scene == 21) {
            C14423an.m22640Il(19);
        }
        AppMethodBeat.m2505o(8546);
    }
}
