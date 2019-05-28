package com.tencent.p177mm.plugin.webview.fts.p578b.p579a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.fts.p578b.p579a.p1329a.C22789a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.fts.b.a.a */
public final class C4539a {
    public static final C4539a ugy = new C4539a();
    private Map<String, C22789a> ugx = new HashMap();

    public C4539a() {
        AppMethodBeat.m2504i(5773);
        AppMethodBeat.m2505o(5773);
    }

    static {
        AppMethodBeat.m2504i(5775);
        AppMethodBeat.m2505o(5775);
    }

    public static C4539a cWt() {
        return ugy;
    }

    public static C22789a aeb(String str) {
        AppMethodBeat.m2504i(5774);
        if (TextUtils.isEmpty(str) || !str.startsWith("//test-widget-ui")) {
            C4990ab.m7420w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
            AppMethodBeat.m2505o(5774);
            return null;
        }
        String[] split = str.split("\\s+");
        if (split.length != 2) {
            C4990ab.m7420w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
            AppMethodBeat.m2505o(5774);
            return null;
        }
        C22789a c22789a;
        try {
            c22789a = new C22789a(split[1]);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("SearchWidgetTestUiMgr", e, "", new Object[0]);
            c22789a = null;
        }
        if (c22789a == null) {
            AppMethodBeat.m2505o(5774);
            return null;
        }
        ugy.ugx.put(c22789a.csB, c22789a);
        C4990ab.m7417i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", c22789a.ugB, c22789a.csB, c22789a.ugz, c22789a.ugA);
        AppMethodBeat.m2505o(5774);
        return c22789a;
    }
}
