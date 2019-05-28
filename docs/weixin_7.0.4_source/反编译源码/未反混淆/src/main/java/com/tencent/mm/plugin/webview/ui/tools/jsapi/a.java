package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class a {
    public static final Set<String> uFa = new HashSet<String>() {
        {
            AppMethodBeat.i(8850);
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
            AppMethodBeat.o(8850);
        }
    };

    static {
        AppMethodBeat.i(8851);
        AppMethodBeat.o(8851);
    }
}
