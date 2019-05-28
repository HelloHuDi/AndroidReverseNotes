package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.ShortCutPermissionDetailUI */
public class ShortCutPermissionDetailUI extends WebViewUI {
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onStart() {
        AppMethodBeat.m2504i(17096);
        super.onStart();
        this.mStartTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(17096);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(17097);
        super.onNewIntent(intent);
        setIntent(intent);
        AppMethodBeat.m2505o(17097);
    }

    public void onStop() {
        AppMethodBeat.m2504i(17098);
        super.onStop();
        C4990ab.m7416i("MicroMsg.ShortCutPermissionDetailUI", "onStop");
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_app_id");
            int intExtra = intent.getIntExtra("extra_permission_and_jump_status", 0);
            C7060h.pYm.mo8381e(15786, Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(intExtra), Integer.valueOf(0), stringExtra);
        }
        this.mStartTime = 0;
        AppMethodBeat.m2505o(17098);
    }
}
