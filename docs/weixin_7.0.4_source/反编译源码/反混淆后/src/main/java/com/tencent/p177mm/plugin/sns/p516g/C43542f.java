package com.tencent.p177mm.plugin.sns.p516g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p516g.C21890d.C21891a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.sns.g.f */
public final class C43542f {
    public static final Pattern qPU = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] qPV = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, C43541a> qPW = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.g.f$a */
    enum C43541a {
        OK,
        FAIL;

        static {
            AppMethodBeat.m2505o(36807);
        }
    }

    static {
        AppMethodBeat.m2504i(36809);
        AppMethodBeat.m2505o(36809);
    }

    /* renamed from: a */
    public static String m77825a(C21891a c21891a) {
        AppMethodBeat.m2504i(36808);
        String str;
        if (!qPW.containsKey(c21891a.qPR)) {
            CharSequence charSequence = c21891a.qPR;
            if (C5046bo.isNullOrNil(charSequence)) {
                str = c21891a.qPQ;
                AppMethodBeat.m2505o(36808);
                return str;
            }
            Object obj;
            do {
                Matcher matcher = qPU.matcher(charSequence);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    String group = matcher.group();
                    C4990ab.m7416i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
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
                    qPW.put(c21891a.qPR, C43541a.OK);
                    str = c21891a.qPR;
                    AppMethodBeat.m2505o(36808);
                    return str;
                }
            } while (obj != null);
            qPW.put(c21891a.qPR, C43541a.FAIL);
            str = c21891a.qPQ;
            AppMethodBeat.m2505o(36808);
            return str;
        } else if (((C43541a) qPW.get(c21891a.qPR)) == C43541a.OK) {
            str = c21891a.qPR;
            AppMethodBeat.m2505o(36808);
            return str;
        } else {
            str = c21891a.qPQ;
            AppMethodBeat.m2505o(36808);
            return str;
        }
    }
}
