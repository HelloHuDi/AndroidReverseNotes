package com.tencent.p177mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.webview.a */
public final class C14445a {
    public static final Pattern uet = Pattern.compile("(http|https)://mp.weixin.qq.com.*");
    public static final String ueu = (C6457e.eSn + "vproxy");

    static {
        AppMethodBeat.m2504i(5610);
        AppMethodBeat.m2505o(5610);
    }
}
