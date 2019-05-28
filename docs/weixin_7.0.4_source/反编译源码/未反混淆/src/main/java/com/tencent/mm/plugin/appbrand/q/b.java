package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b {

    public static class a {
        public static String n(String[] strArr) {
            AppMethodBeat.i(57065);
            String str = "";
            String str2 = " PRIMARY KEY ( ";
            for (String str3 : strArr) {
                str2 = str2 + ", " + str3;
            }
            String str4 = str + "," + (str2.replaceFirst(",", "") + " )");
            AppMethodBeat.o(57065);
            return str4;
        }
    }

    String[] getKeys();
}
