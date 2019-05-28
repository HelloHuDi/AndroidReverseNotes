package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.Map;

public final class u {
    public static Map<String, String> amt(String str) {
        AppMethodBeat.i(52007);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(52007);
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split(IOUtils.LINE_SEPARATOR_UNIX)) {
            if (str2 != null && str2.length() > 0) {
                String[] split = str2.trim().split("=", 2);
                if (split != null && split.length >= 2) {
                    String str3 = split[0];
                    Object obj = split[1];
                    if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_.]*")) {
                        hashMap.put(str3, obj);
                    }
                }
            }
        }
        AppMethodBeat.o(52007);
        return hashMap;
    }
}
