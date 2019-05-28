package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern qPU = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] qPV = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> qPW = new HashMap();

    enum a {
        OK,
        FAIL;

        static {
            AppMethodBeat.o(36807);
        }
    }

    static {
        AppMethodBeat.i(36809);
        AppMethodBeat.o(36809);
    }

    public static String a(a aVar) {
        AppMethodBeat.i(36808);
        String str;
        if (!qPW.containsKey(aVar.qPR)) {
            CharSequence charSequence = aVar.qPR;
            if (bo.isNullOrNil(charSequence)) {
                str = aVar.qPQ;
                AppMethodBeat.o(36808);
                return str;
            }
            Object obj;
            do {
                Matcher matcher = qPU.matcher(charSequence);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    String group = matcher.group();
                    ab.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    charSequence = charSequence.replace(group, "");
                    for (String indexOf : qPV) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj = 1;
                            continue;
                            break;
                        }
                    }
                    obj = null;
                    continue;
                } else {
                    qPW.put(aVar.qPR, a.OK);
                    str = aVar.qPR;
                    AppMethodBeat.o(36808);
                    return str;
                }
            } while (obj != null);
            qPW.put(aVar.qPR, a.FAIL);
            str = aVar.qPQ;
            AppMethodBeat.o(36808);
            return str;
        } else if (((a) qPW.get(aVar.qPR)) == a.OK) {
            str = aVar.qPR;
            AppMethodBeat.o(36808);
            return str;
        } else {
            str = aVar.qPQ;
            AppMethodBeat.o(36808);
            return str;
        }
    }
}
