package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v {
    public static String Di(String str) {
        AppMethodBeat.i(87276);
        String str2 = "";
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("<script>", i);
            int indexOf2 = str.indexOf("</script>", i);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                AppMethodBeat.o(87276);
            } else {
                str2 = str2 + (i > 0 ? ";" : "") + str.substring(indexOf + 8, indexOf2);
                i = indexOf2 + 9;
            }
        }
        AppMethodBeat.o(87276);
        return str2;
    }
}
