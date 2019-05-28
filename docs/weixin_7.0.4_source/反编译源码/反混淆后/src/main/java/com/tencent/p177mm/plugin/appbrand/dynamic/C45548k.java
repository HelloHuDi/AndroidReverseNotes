package com.tencent.p177mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.k */
public final class C45548k {
    private static final Map<String, WxaWidgetContext> hlK = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(10716);
        AppMethodBeat.m2505o(10716);
    }

    /* renamed from: a */
    public static boolean m84000a(String str, WxaWidgetContext wxaWidgetContext) {
        AppMethodBeat.m2504i(10713);
        if (C5046bo.isNullOrNil(str) || wxaWidgetContext == null) {
            AppMethodBeat.m2505o(10713);
            return false;
        }
        hlK.put(str, wxaWidgetContext);
        AppMethodBeat.m2505o(10713);
        return true;
    }

    /* renamed from: Aa */
    public static WxaWidgetContext m83998Aa(String str) {
        AppMethodBeat.m2504i(10714);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(10714);
            return null;
        }
        WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) hlK.get(str);
        AppMethodBeat.m2505o(10714);
        return wxaWidgetContext;
    }

    /* renamed from: Ab */
    public static WxaWidgetContext m83999Ab(String str) {
        AppMethodBeat.m2504i(10715);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(10715);
            return null;
        }
        WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) hlK.remove(str);
        AppMethodBeat.m2505o(10715);
        return wxaWidgetContext;
    }
}
