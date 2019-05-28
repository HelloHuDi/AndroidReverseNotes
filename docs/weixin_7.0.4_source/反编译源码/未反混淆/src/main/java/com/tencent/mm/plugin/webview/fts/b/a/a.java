package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static final a ugy = new a();
    private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> ugx = new HashMap();

    public a() {
        AppMethodBeat.i(5773);
        AppMethodBeat.o(5773);
    }

    static {
        AppMethodBeat.i(5775);
        AppMethodBeat.o(5775);
    }

    public static a cWt() {
        return ugy;
    }

    public static com.tencent.mm.plugin.webview.fts.b.a.a.a aeb(String str) {
        AppMethodBeat.i(5774);
        if (TextUtils.isEmpty(str) || !str.startsWith("//test-widget-ui")) {
            ab.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
            AppMethodBeat.o(5774);
            return null;
        }
        String[] split = str.split("\\s+");
        if (split.length != 2) {
            ab.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
            AppMethodBeat.o(5774);
            return null;
        }
        com.tencent.mm.plugin.webview.fts.b.a.a.a aVar;
        try {
            aVar = new com.tencent.mm.plugin.webview.fts.b.a.a.a(split[1]);
        } catch (Exception e) {
            ab.printErrStackTrace("SearchWidgetTestUiMgr", e, "", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            AppMethodBeat.o(5774);
            return null;
        }
        ugy.ugx.put(aVar.csB, aVar);
        ab.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", aVar.ugB, aVar.csB, aVar.ugz, aVar.ugA);
        AppMethodBeat.o(5774);
        return aVar;
    }
}
