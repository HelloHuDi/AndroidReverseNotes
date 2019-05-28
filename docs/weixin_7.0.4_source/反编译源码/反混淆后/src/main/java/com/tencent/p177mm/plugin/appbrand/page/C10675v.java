package com.tencent.p177mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.page.v */
public final class C10675v {
    /* renamed from: Di */
    public static String m18368Di(String str) {
        AppMethodBeat.m2504i(87276);
        String str2 = "";
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("<script>", i);
            int indexOf2 = str.indexOf("</script>", i);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                AppMethodBeat.m2505o(87276);
            } else {
                str2 = str2 + (i > 0 ? ";" : "") + str.substring(indexOf + 8, indexOf2);
                i = indexOf2 + 9;
            }
        }
        AppMethodBeat.m2505o(87276);
        return str2;
    }
}
