package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.model.ar */
public final class C46423ar {
    private static Map<String, String> unw = new HashMap();

    static {
        AppMethodBeat.m2504i(6799);
        AppMethodBeat.m2505o(6799);
    }

    /* renamed from: hb */
    public static void m87442hb(String str, String str2) {
        AppMethodBeat.m2504i(6796);
        C4990ab.m7417i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", str, str2);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
            AppMethodBeat.m2505o(6796);
        } else if (unw.containsKey(str)) {
            C4990ab.m7416i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
            AppMethodBeat.m2505o(6796);
        } else {
            unw.put(str, str2);
            AppMethodBeat.m2505o(6796);
        }
    }

    public static String aek(String str) {
        AppMethodBeat.m2504i(6797);
        C4990ab.m7417i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            AppMethodBeat.m2505o(6797);
            return null;
        }
        String str2 = (String) unw.get(str);
        if (C5046bo.isNullOrNil(str2)) {
            Object obj;
            int indexOf = str.indexOf("#");
            if (indexOf < 0) {
                obj = str;
            } else {
                obj = str.substring(0, indexOf);
            }
            str2 = (String) unw.get(obj);
        }
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(6797);
            return str;
        }
        AppMethodBeat.m2505o(6797);
        return str2;
    }

    public static void clear() {
        AppMethodBeat.m2504i(6798);
        unw.clear();
        AppMethodBeat.m2505o(6798);
    }
}
