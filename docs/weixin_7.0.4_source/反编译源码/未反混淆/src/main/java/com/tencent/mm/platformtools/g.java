package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    public static String vo(String str) {
        AppMethodBeat.i(58717);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.o(58717);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char r : toCharArray) {
            String r2 = SpellMap.r(r);
            if (r2 != null) {
                stringBuffer.append(r2);
            }
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(58717);
        return str;
    }

    public static String vp(String str) {
        AppMethodBeat.i(58718);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.o(58718);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = toCharArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isSpace(toCharArray[i])) {
                String r = SpellMap.r(toCharArray[i]);
                if (r != null && r.length() > 0) {
                    stringBuffer.append(r.charAt(0));
                }
            }
        }
        str = stringBuffer.toString().toUpperCase();
        AppMethodBeat.o(58718);
        return str;
    }
}
