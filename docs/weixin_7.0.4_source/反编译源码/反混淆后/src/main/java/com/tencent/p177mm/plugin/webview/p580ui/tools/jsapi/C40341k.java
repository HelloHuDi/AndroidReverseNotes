package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.k */
public final class C40341k {
    public static void agC(String str) {
        AppMethodBeat.m2504i(9839);
        if (!C5046bo.isNullOrNil(str) && str.startsWith("http")) {
            C32291o.ahk().mo33458a(str, null);
        }
        AppMethodBeat.m2505o(9839);
    }
}
