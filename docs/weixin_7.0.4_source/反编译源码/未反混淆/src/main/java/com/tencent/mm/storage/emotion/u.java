package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class u extends k {
    public HashMap<String, t> ybh;

    public final void dvl() {
        AppMethodBeat.i(62892);
        String str = (String) g.RP().Ry().get(a.USERINFO_RECENT_SMILEY_STRING, (Object) "");
        this.ybh = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                t tVar = new t();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                tVar.key = jSONObject.optString("key", "");
                tVar.position = jSONObject.optInt("position", 0);
                tVar.ybg = jSONObject.optInt("use_count", 0);
                tVar.eRt = jSONObject.optLong("last_time", 0);
                this.ybh.put(tVar.key, tVar);
            }
            AppMethodBeat.o(62892);
        } catch (JSONException e) {
            Log.w("SmileyUsageInfoStorage", "data error clear all");
            axQ();
            AppMethodBeat.o(62892);
        }
    }

    public final List<t> bjY() {
        AppMethodBeat.i(62893);
        if (this.ybh == null) {
            dvl();
        }
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.ybh.values()) {
            if (tVar.position >= 0 && tVar.position < e.dqK().aRt()) {
                arrayList.add(tVar);
            }
        }
        Collections.sort(arrayList, new Comparator<t>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((t) obj2).eRt - ((t) obj).eRt);
            }
        });
        AppMethodBeat.o(62893);
        return arrayList;
    }

    public final void axQ() {
        AppMethodBeat.i(62894);
        g.RP().Ry().set(a.USERINFO_RECENT_SMILEY_STRING, null);
        this.ybh = new HashMap();
        AppMethodBeat.o(62894);
    }
}
