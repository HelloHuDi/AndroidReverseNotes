package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.h */
public final class C40315h {
    public static String cMm;
    public static int cSQ;
    public static String uEm;

    public C40315h(Intent intent) {
        AppMethodBeat.m2504i(8780);
        if (intent == null) {
            AppMethodBeat.m2505o(8780);
            return;
        }
        cMm = C5046bo.nullAsNil(intent.getStringExtra("KPublisherId"));
        uEm = C5046bo.nullAsNil(intent.getStringExtra("geta8key_username"));
        cSQ = C5046bo.m7567h(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        AppMethodBeat.m2505o(8780);
    }
}
