package com.tencent.p177mm.p1186bq;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.bq.a */
public final class C18114a {
    private static final Map<Integer, Integer> vwL = new HashMap();

    static {
        AppMethodBeat.m2504i(28267);
        AppMethodBeat.m2505o(28267);
    }

    /* renamed from: Lu */
    public static void m28535Lu(int i) {
        AppMethodBeat.m2504i(28264);
        vwL.put(Integer.valueOf(i), Integer.valueOf(C5046bo.m7567h((Integer) vwL.get(Integer.valueOf(i))) + 1));
        AppMethodBeat.m2505o(28264);
    }

    public static String dlM() {
        AppMethodBeat.m2504i(28265);
        String str = "[a=" + (C9638aw.m17190ZK() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1") + " ";
        if (C9638aw.m17190ZK() == null) {
            AppMethodBeat.m2505o(28265);
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        C9638aw.m17190ZK();
        str = append.append(C18628c.m29072Ry() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").append(" ").toString() + "u=" + (C9638aw.m17179RK() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO) + "]";
        AppMethodBeat.m2505o(28265);
        return str;
    }

    public static void akz(String str) {
        AppMethodBeat.m2504i(28266);
        String str2 = str + C18114a.dlM();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : vwL.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        vwL.clear();
        if (stringBuilder.length() > 0) {
            C4990ab.m7410d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            C37907bv.m64020s(10, stringBuilder.toString());
        }
        C4990ab.m7410d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(str2 + C18114a.dlM())));
        try {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(66819, Long.valueOf(C5046bo.anT()));
            AppMethodBeat.m2505o(28266);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
            AppMethodBeat.m2505o(28266);
        }
    }

    public static void run() {
        Object obj;
        AppMethodBeat.m2504i(28263);
        C9638aw.m17190ZK();
        if (C5046bo.m7549fp(C5046bo.m7514a((Long) C18628c.m29072Ry().get(66819, null), 0)) * 1000 > 1800000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C18114a.akz("");
        }
        AppMethodBeat.m2505o(28263);
    }
}
