package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class h {
    public static String cMm;
    public static int cSQ;
    public static String uEm;

    public h(Intent intent) {
        AppMethodBeat.i(8780);
        if (intent == null) {
            AppMethodBeat.o(8780);
            return;
        }
        cMm = bo.nullAsNil(intent.getStringExtra("KPublisherId"));
        uEm = bo.nullAsNil(intent.getStringExtra("geta8key_username"));
        cSQ = bo.h(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        AppMethodBeat.o(8780);
    }
}
