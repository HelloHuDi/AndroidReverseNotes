package com.tencent.p177mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.label.c */
public final class C21158c {
    /* renamed from: eR */
    public static String m32495eR(String str, String str2) {
        AppMethodBeat.m2504i(22506);
        C4990ab.m7411d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", str, str2);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(22506);
            return str;
        } else if (C5046bo.isNullOrNil(str)) {
            str = str2 + "\u0000";
            AppMethodBeat.m2505o(22506);
            return str;
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            if (C5046bo.m7508P(str.split(",")).contains(str2)) {
                str = str + "\u0000";
                AppMethodBeat.m2505o(22506);
                return str;
            }
            str = str + "," + str2 + "\u0000";
            AppMethodBeat.m2505o(22506);
            return str;
        }
    }

    /* renamed from: eS */
    public static String m32496eS(String str, String str2) {
        AppMethodBeat.m2504i(22507);
        C4990ab.m7411d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", str, str2);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(22507);
            return str;
        } else if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(22507);
            return str;
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            ArrayList P = C5046bo.m7508P(str.split(","));
            if (P.contains(str2)) {
                P.remove(str2);
                str = C21158c.m32494cf(P);
                AppMethodBeat.m2505o(22507);
                return str;
            }
            AppMethodBeat.m2505o(22507);
            return str;
        }
    }

    /* renamed from: cf */
    public static String m32494cf(List<String> list) {
        AppMethodBeat.m2504i(22508);
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
        AppMethodBeat.m2505o(22508);
        return stringBuilder2;
    }
}
