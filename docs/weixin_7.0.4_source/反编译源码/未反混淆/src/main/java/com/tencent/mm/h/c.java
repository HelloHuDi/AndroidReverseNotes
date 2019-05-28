package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public String Title;
    public int ctr;
    public int cts;
    public String desc;
    public String eff;
    public String efg;
    public int efh;
    public int showType;
    public String url;

    public static c ka(String str) {
        AppMethodBeat.i(123393);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(123393);
            return null;
        }
        c cVar = new c();
        Map z = br.z(str, "e");
        if (z == null) {
            ab.d("MicroMsg.BroadcastEntity", "this is not errmsg");
            AppMethodBeat.o(123393);
            return null;
        }
        cVar.desc = (String) z.get(".e.Content");
        cVar.url = (String) z.get(".e.Url");
        cVar.Title = (String) z.get(".e.Title");
        cVar.cts = bo.getInt((String) z.get(".e.Action"), 0);
        cVar.showType = bo.getInt((String) z.get(".e.ShowType"), 0);
        cVar.ctr = bo.getInt((String) z.get(".e.DispSec"), 30);
        cVar.eff = (String) z.get(".e.Ok");
        cVar.efg = (String) z.get(".e.Cancel");
        cVar.efh = bo.getInt((String) z.get("e.Countdown"), 0);
        if (ix(cVar.showType)) {
            AppMethodBeat.o(123393);
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) z.get(".e"));
            cVar.desc = jSONObject.getString("Content");
            cVar.url = jSONObject.getString("Url");
            cVar.Title = jSONObject.getString("Title");
            cVar.cts = bo.getInt(jSONObject.getString("Action"), 0);
            cVar.showType = bo.getInt(jSONObject.getString("ShowType"), 0);
            cVar.ctr = bo.getInt(jSONObject.getString("DispSec"), 30);
            cVar.eff = (String) z.get(".e.Ok");
            cVar.efg = (String) z.get(".e.Cancel");
            cVar.efh = bo.getInt((String) z.get("e.Countdown"), 0);
            if (ix(cVar.showType)) {
                AppMethodBeat.o(123393);
                return cVar;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BroadcastEntity", e, "", new Object[0]);
        }
        AppMethodBeat.o(123393);
        return null;
    }

    private static boolean ix(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3 || i == 8) {
            return true;
        }
        return false;
    }
}
