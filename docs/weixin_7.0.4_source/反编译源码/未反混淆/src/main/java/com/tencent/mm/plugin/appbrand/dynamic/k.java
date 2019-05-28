package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k {
    private static final Map<String, WxaWidgetContext> hlK = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(10716);
        AppMethodBeat.o(10716);
    }

    public static boolean a(String str, WxaWidgetContext wxaWidgetContext) {
        AppMethodBeat.i(10713);
        if (bo.isNullOrNil(str) || wxaWidgetContext == null) {
            AppMethodBeat.o(10713);
            return false;
        }
        hlK.put(str, wxaWidgetContext);
        AppMethodBeat.o(10713);
        return true;
    }

    public static WxaWidgetContext Aa(String str) {
        AppMethodBeat.i(10714);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(10714);
            return null;
        }
        WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) hlK.get(str);
        AppMethodBeat.o(10714);
        return wxaWidgetContext;
    }

    public static WxaWidgetContext Ab(String str) {
        AppMethodBeat.i(10715);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(10715);
            return null;
        }
        WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) hlK.remove(str);
        AppMethodBeat.o(10715);
        return wxaWidgetContext;
    }
}
