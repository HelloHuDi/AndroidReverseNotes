package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fav.a.i */
public final class C11853i {
    public static List<C11854a> mfh;
    private static String mfi = "";
    private static String mfj = "";
    private static long mfk = 0;

    /* renamed from: com.tencent.mm.plugin.fav.a.i$a */
    static class C11854a {
        /* renamed from: in */
        int f2907in;
        long mfl;
        String pageId;
        String sid;

        private C11854a() {
        }

        /* synthetic */ C11854a(byte b) {
            this();
        }
    }

    public static void start() {
        AppMethodBeat.m2504i(102658);
        mfh = new Vector();
        AppMethodBeat.m2505o(102658);
    }

    public static void end() {
        AppMethodBeat.m2504i(102659);
        if (mfh == null) {
            mfh = null;
            C11853i.buD();
            AppMethodBeat.m2505o(102659);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (C11854a c11854a : mfh) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", c11854a.pageId);
                jSONObject.put("tbe", c11854a.mfl);
                jSONObject.put("in", c11854a.f2907in);
                jSONObject.put("sid", c11854a.sid);
            } catch (JSONException e) {
                C4990ab.m7420w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
            }
            stringBuilder.append(jSONObject.toString()).append(";");
            if (stringBuilder.length() > 3072) {
                mfh = null;
                C11853i.buD();
                AppMethodBeat.m2505o(102659);
                return;
            }
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 3072) {
            mfh = null;
            C11853i.buD();
            AppMethodBeat.m2505o(102659);
            return;
        }
        String[] strArr = new String[3];
        int i = 0;
        while (i < 3) {
            try {
                strArr[i] = "";
                i++;
            } catch (Throwable th) {
                C4990ab.m7420w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + th.getMessage());
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
        C7060h.pYm.mo8381e(15508, strArr[0], strArr[1], strArr[2]);
        mfh = null;
        C11853i.buD();
        AppMethodBeat.m2505o(102659);
    }

    /* renamed from: a */
    private static void m19720a(String str, long j, int i, String str2) {
        AppMethodBeat.m2504i(102660);
        if (mfh == null) {
            AppMethodBeat.m2505o(102660);
            return;
        }
        C11854a c11854a = new C11854a();
        c11854a.pageId = str;
        c11854a.mfl = j;
        c11854a.f2907in = i;
        if (C5046bo.isNullOrNil(str2)) {
            c11854a.sid = "-1";
        } else {
            c11854a.sid = str2;
        }
        if (mfh != null) {
            mfh.add(c11854a);
        }
        AppMethodBeat.m2505o(102660);
    }

    private static void buD() {
        mfi = "";
        mfj = "";
        mfk = 0;
    }

    /* renamed from: el */
    public static void m19721el(String str, String str2) {
        AppMethodBeat.m2504i(102661);
        if (!C5046bo.isNullOrNil(mfi)) {
            C11853i.m19722em(mfi, mfj);
        }
        mfi = str;
        mfj = str2;
        mfk = System.currentTimeMillis();
        AppMethodBeat.m2505o(102661);
    }

    /* renamed from: LK */
    public static void m19718LK(String str) {
        AppMethodBeat.m2504i(102662);
        C11853i.m19721el(str, "");
        AppMethodBeat.m2505o(102662);
    }

    /* renamed from: em */
    private static void m19722em(String str, String str2) {
        AppMethodBeat.m2504i(102663);
        if (C5046bo.isNullOrNil(str) || !str.equals(mfi)) {
            AppMethodBeat.m2505o(102663);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - mfk);
        mfk /= 1000;
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "-1";
        }
        C11853i.m19720a(str, mfk, currentTimeMillis, str2);
        C11853i.buD();
        AppMethodBeat.m2505o(102663);
    }

    /* renamed from: LL */
    public static void m19719LL(String str) {
        AppMethodBeat.m2504i(102664);
        C11853i.m19722em(str, "");
        AppMethodBeat.m2505o(102664);
    }
}
