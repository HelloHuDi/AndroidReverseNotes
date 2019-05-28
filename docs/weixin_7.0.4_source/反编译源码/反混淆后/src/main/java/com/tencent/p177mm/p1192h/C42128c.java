package com.tencent.p177mm.p1192h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.h.c */
public final class C42128c {
    public String Title;
    public int ctr;
    public int cts;
    public String desc;
    public String eff;
    public String efg;
    public int efh;
    public int showType;
    public String url;

    /* renamed from: ka */
    public static C42128c m74275ka(String str) {
        AppMethodBeat.m2504i(123393);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(123393);
            return null;
        }
        C42128c c42128c = new C42128c();
        Map z = C5049br.m7595z(str, "e");
        if (z == null) {
            C4990ab.m7410d("MicroMsg.BroadcastEntity", "this is not errmsg");
            AppMethodBeat.m2505o(123393);
            return null;
        }
        c42128c.desc = (String) z.get(".e.Content");
        c42128c.url = (String) z.get(".e.Url");
        c42128c.Title = (String) z.get(".e.Title");
        c42128c.cts = C5046bo.getInt((String) z.get(".e.Action"), 0);
        c42128c.showType = C5046bo.getInt((String) z.get(".e.ShowType"), 0);
        c42128c.ctr = C5046bo.getInt((String) z.get(".e.DispSec"), 30);
        c42128c.eff = (String) z.get(".e.Ok");
        c42128c.efg = (String) z.get(".e.Cancel");
        c42128c.efh = C5046bo.getInt((String) z.get("e.Countdown"), 0);
        if (C42128c.m74274ix(c42128c.showType)) {
            AppMethodBeat.m2505o(123393);
            return c42128c;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) z.get(".e"));
            c42128c.desc = jSONObject.getString("Content");
            c42128c.url = jSONObject.getString("Url");
            c42128c.Title = jSONObject.getString("Title");
            c42128c.cts = C5046bo.getInt(jSONObject.getString("Action"), 0);
            c42128c.showType = C5046bo.getInt(jSONObject.getString("ShowType"), 0);
            c42128c.ctr = C5046bo.getInt(jSONObject.getString("DispSec"), 30);
            c42128c.eff = (String) z.get(".e.Ok");
            c42128c.efg = (String) z.get(".e.Cancel");
            c42128c.efh = C5046bo.getInt((String) z.get("e.Countdown"), 0);
            if (C42128c.m74274ix(c42128c.showType)) {
                AppMethodBeat.m2505o(123393);
                return c42128c;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BroadcastEntity", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(123393);
        return null;
    }

    /* renamed from: ix */
    private static boolean m74274ix(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3 || i == 8) {
            return true;
        }
        return false;
    }
}
