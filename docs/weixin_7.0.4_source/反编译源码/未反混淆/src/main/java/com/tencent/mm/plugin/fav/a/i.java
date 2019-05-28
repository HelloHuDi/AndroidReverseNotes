package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static List<a> mfh;
    private static String mfi = "";
    private static String mfj = "";
    private static long mfk = 0;

    static class a {
        int in;
        long mfl;
        String pageId;
        String sid;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void start() {
        AppMethodBeat.i(102658);
        mfh = new Vector();
        AppMethodBeat.o(102658);
    }

    public static void end() {
        AppMethodBeat.i(102659);
        if (mfh == null) {
            mfh = null;
            buD();
            AppMethodBeat.o(102659);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (a aVar : mfh) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", aVar.pageId);
                jSONObject.put("tbe", aVar.mfl);
                jSONObject.put("in", aVar.in);
                jSONObject.put("sid", aVar.sid);
            } catch (JSONException e) {
                ab.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
            }
            stringBuilder.append(jSONObject.toString()).append(";");
            if (stringBuilder.length() > 3072) {
                mfh = null;
                buD();
                AppMethodBeat.o(102659);
                return;
            }
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 3072) {
            mfh = null;
            buD();
            AppMethodBeat.o(102659);
            return;
        }
        String[] strArr = new String[3];
        int i = 0;
        while (i < 3) {
            try {
                strArr[i] = "";
                i++;
            } catch (Throwable th) {
                ab.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + th.getMessage());
            }
        }
        for (i = 0; i < 3; i++) {
            if (stringBuilder2.length() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                strArr[i] = stringBuilder2;
                break;
            }
            strArr[i] = stringBuilder2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder2 = stringBuilder2.substring(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        h.pYm.e(15508, strArr[0], strArr[1], strArr[2]);
        mfh = null;
        buD();
        AppMethodBeat.o(102659);
    }

    private static void a(String str, long j, int i, String str2) {
        AppMethodBeat.i(102660);
        if (mfh == null) {
            AppMethodBeat.o(102660);
            return;
        }
        a aVar = new a();
        aVar.pageId = str;
        aVar.mfl = j;
        aVar.in = i;
        if (bo.isNullOrNil(str2)) {
            aVar.sid = "-1";
        } else {
            aVar.sid = str2;
        }
        if (mfh != null) {
            mfh.add(aVar);
        }
        AppMethodBeat.o(102660);
    }

    private static void buD() {
        mfi = "";
        mfj = "";
        mfk = 0;
    }

    public static void el(String str, String str2) {
        AppMethodBeat.i(102661);
        if (!bo.isNullOrNil(mfi)) {
            em(mfi, mfj);
        }
        mfi = str;
        mfj = str2;
        mfk = System.currentTimeMillis();
        AppMethodBeat.o(102661);
    }

    public static void LK(String str) {
        AppMethodBeat.i(102662);
        el(str, "");
        AppMethodBeat.o(102662);
    }

    private static void em(String str, String str2) {
        AppMethodBeat.i(102663);
        if (bo.isNullOrNil(str) || !str.equals(mfi)) {
            AppMethodBeat.o(102663);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - mfk);
        mfk /= 1000;
        if (bo.isNullOrNil(str2)) {
            str2 = "-1";
        }
        a(str, mfk, currentTimeMillis, str2);
        buD();
        AppMethodBeat.o(102663);
    }

    public static void LL(String str) {
        AppMethodBeat.i(102664);
        em(str, "");
        AppMethodBeat.o(102664);
    }
}
