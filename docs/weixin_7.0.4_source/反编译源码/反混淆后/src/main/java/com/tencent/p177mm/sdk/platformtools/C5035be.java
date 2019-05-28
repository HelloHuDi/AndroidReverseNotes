package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.sdk.platformtools.be */
public final class C5035be {
    /* renamed from: aS */
    public static String m7492aS(Map<String, String> map) {
        AppMethodBeat.m2504i(52263);
        if (map == null) {
            AppMethodBeat.m2505o(52263);
            return null;
        }
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~SEMI_XML~");
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            str = (String) entry.getValue();
            if (str != null) {
                int length = str2.length();
                int length2 = str.length();
                stringBuilder.append((char) (length >> 16)).append((char) length).append(str2);
                stringBuilder.append((char) (length2 >> 16)).append((char) length2).append(str);
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(52263);
        return str;
    }

    public static Map<String, String> amR(String str) {
        AppMethodBeat.m2504i(52264);
        if (str == null || !str.startsWith("~SEMI_XML~")) {
            AppMethodBeat.m2505o(52264);
            return null;
        }
        String substring = str.substring(10);
        Map<String, String> hashMap = new HashMap();
        int length = substring.length() - 4;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            try {
                int i3 = i2 + 1;
                i = ((substring.charAt(i) << 16) + substring.charAt(i2)) + i3;
                String substring2 = substring.substring(i3, i);
                i3 = i + 1;
                int i4 = i3 + 1;
                i = ((substring.charAt(i) << 16) + substring.charAt(i3)) + i4;
                hashMap.put(substring2, substring.substring(i4, i));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SemiXml", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(52264);
        return hashMap;
    }
}
