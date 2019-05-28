package com.tencent.p177mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.platformtools.g */
public final class C9790g {
    /* renamed from: vo */
    public static String m17432vo(String str) {
        AppMethodBeat.m2504i(58717);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.m2505o(58717);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char r : toCharArray) {
            String r2 = SpellMap.m42342r(r);
            if (r2 != null) {
                stringBuffer.append(r2);
            }
        }
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(58717);
        return str;
    }

    /* renamed from: vp */
    public static String m17433vp(String str) {
        AppMethodBeat.m2504i(58718);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.m2505o(58718);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = toCharArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isSpace(toCharArray[i])) {
                String r = SpellMap.m42342r(toCharArray[i]);
                if (r != null && r.length() > 0) {
                    stringBuffer.append(r.charAt(0));
                }
            }
        }
        str = stringBuffer.toString().toUpperCase();
        AppMethodBeat.m2505o(58718);
        return str;
    }
}
