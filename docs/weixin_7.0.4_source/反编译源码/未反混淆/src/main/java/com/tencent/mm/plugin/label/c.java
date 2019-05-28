package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class c {
    public static String eR(String str, String str2) {
        AppMethodBeat.i(22506);
        ab.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", str, str2);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(22506);
            return str;
        } else if (bo.isNullOrNil(str)) {
            str = str2 + "\u0000";
            AppMethodBeat.o(22506);
            return str;
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            if (bo.P(str.split(",")).contains(str2)) {
                str = str + "\u0000";
                AppMethodBeat.o(22506);
                return str;
            }
            str = str + "," + str2 + "\u0000";
            AppMethodBeat.o(22506);
            return str;
        }
    }

    public static String eS(String str, String str2) {
        AppMethodBeat.i(22507);
        ab.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", str, str2);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(22507);
            return str;
        } else if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(22507);
            return str;
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            ArrayList P = bo.P(str.split(","));
            if (P.contains(str2)) {
                P.remove(str2);
                str = cf(P);
                AppMethodBeat.o(22507);
                return str;
            }
            AppMethodBeat.o(22507);
            return str;
        }
    }

    public static String cf(List<String> list) {
        AppMethodBeat.i(22508);
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i));
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\u0000");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(22508);
        return stringBuilder2;
    }
}
