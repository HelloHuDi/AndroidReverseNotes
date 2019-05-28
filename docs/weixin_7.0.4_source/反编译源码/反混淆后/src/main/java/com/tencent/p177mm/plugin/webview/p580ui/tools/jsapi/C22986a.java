package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.a */
public final class C22986a {
    public static final Set<String> uFa = new C229871();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.a$1 */
    static class C229871 extends HashSet<String> {
        C229871() {
            AppMethodBeat.m2504i(8850);
            add("application/msword");
            add("application/vnd.ms-powerpoint");
            add("application/vnd.ms-excel");
            add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
            add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            add("application/kswps");
            add("application/kset");
            add("application/ksdps");
            add("application/pdf");
            add("text/plain");
            AppMethodBeat.m2505o(8850);
        }
    }

    static {
        AppMethodBeat.m2504i(8851);
        AppMethodBeat.m2505o(8851);
    }
}
