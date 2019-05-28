package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import java.util.regex.Pattern;

public final class a {
    public static final Pattern uet = Pattern.compile("(http|https)://mp.weixin.qq.com.*");
    public static final String ueu = (e.eSn + "vproxy");

    static {
        AppMethodBeat.i(5610);
        AppMethodBeat.o(5610);
    }
}
