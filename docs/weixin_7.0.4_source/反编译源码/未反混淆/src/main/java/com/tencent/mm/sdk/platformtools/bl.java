package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.d;

public final class bl {
    private final d xBP;
    private ae<String, String> xBQ = new ae(256);

    public bl(String str) {
        AppMethodBeat.i(52281);
        this.xBP = new d(str);
        AppMethodBeat.o(52281);
    }

    public final String decryptTag(String str) {
        Throwable e;
        AppMethodBeat.i(52282);
        try {
            if (str.startsWith("!")) {
                String str2;
                if (this.xBQ.aj(str)) {
                    str2 = (String) this.xBQ.get(str);
                    AppMethodBeat.o(52282);
                    return str2;
                }
                str2 = str.substring(1);
                try {
                    String[] split = str2.split("@");
                    if (split.length > 1) {
                        String str3 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring = str2.substring(str3.length() + 1, (str3.length() + 1) + intValue);
                        String str4 = this.xBP.cr(substring) + str2.substring(intValue + (str3.length() + 1));
                        this.xBQ.put(str, str4);
                        AppMethodBeat.o(52282);
                        return str4;
                    }
                    str = str2;
                } catch (Exception e2) {
                    e = e2;
                    str = str2;
                    ab.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
                    str = "[td]".concat(String.valueOf(r8));
                    AppMethodBeat.o(52282);
                    return str;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        AppMethodBeat.o(52282);
        return str;
    }
}
