package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.webview.model.am */
public final class C29818am extends C7563j<C22882al> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C22882al.ccO, "WebviewLocalData")};

    static {
        AppMethodBeat.m2504i(6738);
        AppMethodBeat.m2505o(6738);
    }

    public C29818am(C4927e c4927e) {
        super(c4927e, C22882al.ccO, "WebviewLocalData", null);
    }

    /* renamed from: au */
    public static int m47273au(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6737);
        int hashCode = (str + str2 + str3).hashCode();
        AppMethodBeat.m2505o(6737);
        return hashCode;
    }
}
