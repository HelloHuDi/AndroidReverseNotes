package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum b {
    ;

    public static String aQ(Map<String, List<String>> map) {
        AppMethodBeat.i(79649);
        String str;
        if (map == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(79649);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(bo.bc((String) entry.getKey(), BuildConfig.COMMAND));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String str2 : list) {
                    stringBuilder.append(bo.nullAsNil(str2)).append("|");
                }
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(79649);
        return str2;
    }
}
