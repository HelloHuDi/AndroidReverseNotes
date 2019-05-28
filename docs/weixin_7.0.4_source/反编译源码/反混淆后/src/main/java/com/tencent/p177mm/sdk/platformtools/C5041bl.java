package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1172d;

/* renamed from: com.tencent.mm.sdk.platformtools.bl */
public final class C5041bl {
    private final C1172d xBP;
    private C4993ae<String, String> xBQ = new C4993ae(256);

    public C5041bl(String str) {
        AppMethodBeat.m2504i(52281);
        this.xBP = new C1172d(str);
        AppMethodBeat.m2505o(52281);
    }

    public final String decryptTag(String str) {
        Throwable e;
        AppMethodBeat.m2504i(52282);
        try {
            if (str.startsWith("!")) {
                String str2;
                if (this.xBQ.mo10274aj(str)) {
                    str2 = (String) this.xBQ.get(str);
                    AppMethodBeat.m2505o(52282);
                    return str2;
                }
                str2 = str.substring(1);
                try {
                    String[] split = str2.split("@");
                    if (split.length > 1) {
                        String str3 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring = str2.substring(str3.length() + 1, (str3.length() + 1) + intValue);
                        String str4 = this.xBP.mo4400cr(substring) + str2.substring(intValue + (str3.length() + 1));
                        this.xBQ.put(str, str4);
                        AppMethodBeat.m2505o(52282);
                        return str4;
                    }
                    str = str2;
                } catch (Exception e2) {
                    e = e2;
                    str = str2;
                    C4990ab.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
                    str = "[td]".concat(String.valueOf(r8));
                    AppMethodBeat.m2505o(52282);
                    return str;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        AppMethodBeat.m2505o(52282);
        return str;
    }
}
