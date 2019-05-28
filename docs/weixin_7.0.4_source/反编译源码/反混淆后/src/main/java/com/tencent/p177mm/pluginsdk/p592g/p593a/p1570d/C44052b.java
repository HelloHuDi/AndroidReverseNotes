package com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.pluginsdk.g.a.d.b */
public enum C44052b {
    ;

    /* renamed from: aQ */
    public static String m79181aQ(Map<String, List<String>> map) {
        AppMethodBeat.m2504i(79649);
        String str;
        if (map == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(79649);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(C5046bo.m7532bc((String) entry.getKey(), BuildConfig.COMMAND));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String str2 : list) {
                    stringBuilder.append(C5046bo.nullAsNil(str2)).append("|");
                }
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(79649);
        return str2;
    }
}
