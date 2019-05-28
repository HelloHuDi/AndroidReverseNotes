package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class ar {
    private static Map<String, String> unw = new HashMap();

    static {
        AppMethodBeat.i(6799);
        AppMethodBeat.o(6799);
    }

    public static void hb(String str, String str2) {
        AppMethodBeat.i(6796);
        ab.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
            AppMethodBeat.o(6796);
        } else if (unw.containsKey(str)) {
            ab.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
            AppMethodBeat.o(6796);
        } else {
            unw.put(str, str2);
            AppMethodBeat.o(6796);
        }
    }

    public static String aek(String str) {
        AppMethodBeat.i(6797);
        ab.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            AppMethodBeat.o(6797);
            return null;
        }
        String str2 = (String) unw.get(str);
        if (bo.isNullOrNil(str2)) {
            Object obj;
            int indexOf = str.indexOf("#");
            if (indexOf < 0) {
                obj = str;
            } else {
                obj = str.substring(0, indexOf);
            }
            str2 = (String) unw.get(obj);
        }
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(6797);
            return str;
        }
        AppMethodBeat.o(6797);
        return str2;
    }

    public static void clear() {
        AppMethodBeat.i(6798);
        unw.clear();
        AppMethodBeat.o(6798);
    }
}
