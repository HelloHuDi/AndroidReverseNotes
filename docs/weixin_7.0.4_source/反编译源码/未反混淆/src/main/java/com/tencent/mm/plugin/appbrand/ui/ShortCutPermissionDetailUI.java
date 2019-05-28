package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ab;

public class ShortCutPermissionDetailUI extends WebViewUI {
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onStart() {
        AppMethodBeat.i(17096);
        super.onStart();
        this.mStartTime = System.currentTimeMillis();
        AppMethodBeat.o(17096);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(17097);
        super.onNewIntent(intent);
        setIntent(intent);
        AppMethodBeat.o(17097);
    }

    public void onStop() {
        AppMethodBeat.i(17098);
        super.onStop();
        ab.i("MicroMsg.ShortCutPermissionDetailUI", "onStop");
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_app_id");
            int intExtra = intent.getIntExtra("extra_permission_and_jump_status", 0);
            h.pYm.e(15786, Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(intExtra), Integer.valueOf(0), stringExtra);
        }
        this.mStartTime = 0;
        AppMethodBeat.o(17098);
    }
}
