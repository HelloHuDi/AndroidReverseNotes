package com.tencent.mm.bq;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> vwL = new HashMap();

    static {
        AppMethodBeat.i(28267);
        AppMethodBeat.o(28267);
    }

    public static void Lu(int i) {
        AppMethodBeat.i(28264);
        vwL.put(Integer.valueOf(i), Integer.valueOf(bo.h((Integer) vwL.get(Integer.valueOf(i))) + 1));
        AppMethodBeat.o(28264);
    }

    public static String dlM() {
        AppMethodBeat.i(28265);
        String str = "[a=" + (aw.ZK() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1") + " ";
        if (aw.ZK() == null) {
            AppMethodBeat.o(28265);
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        aw.ZK();
        str = append.append(c.Ry() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").append(" ").toString() + "u=" + (aw.RK() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO) + "]";
        AppMethodBeat.o(28265);
        return str;
    }

    public static void akz(String str) {
        AppMethodBeat.i(28266);
        String str2 = str + dlM();
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
            ab.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            bv.s(10, stringBuilder.toString());
        }
        ab.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(str2 + dlM())));
        try {
            aw.ZK();
            c.Ry().set(66819, Long.valueOf(bo.anT()));
            AppMethodBeat.o(28266);
        } catch (Exception e) {
            ab.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
            AppMethodBeat.o(28266);
        }
    }

    public static void run() {
        Object obj;
        AppMethodBeat.i(28263);
        aw.ZK();
        if (bo.fp(bo.a((Long) c.Ry().get(66819, null), 0)) * 1000 > 1800000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            akz("");
        }
        AppMethodBeat.o(28263);
    }
}
