package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.storage.emotion.u */
public final class C15439u extends C7296k {
    public HashMap<String, C15438t> ybh;

    /* renamed from: com.tencent.mm.storage.emotion.u$1 */
    class C154401 implements Comparator<C15438t> {
        C154401() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((C15438t) obj2).eRt - ((C15438t) obj).eRt);
        }
    }

    public final void dvl() {
        AppMethodBeat.m2504i(62892);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_SMILEY_STRING, (Object) "");
        this.ybh = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                C15438t c15438t = new C15438t();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                c15438t.key = jSONObject.optString("key", "");
                c15438t.position = jSONObject.optInt("position", 0);
                c15438t.ybg = jSONObject.optInt("use_count", 0);
                c15438t.eRt = jSONObject.optLong("last_time", 0);
                this.ybh.put(c15438t.key, c15438t);
            }
            AppMethodBeat.m2505o(62892);
        } catch (JSONException e) {
            Log.m81051w("SmileyUsageInfoStorage", "data error clear all");
            axQ();
            AppMethodBeat.m2505o(62892);
        }
    }

    public final List<C15438t> bjY() {
        AppMethodBeat.m2504i(62893);
        if (this.ybh == null) {
            dvl();
        }
        ArrayList arrayList = new ArrayList();
        for (C15438t c15438t : this.ybh.values()) {
            if (c15438t.position >= 0 && c15438t.position < C26003e.dqK().aRt()) {
                arrayList.add(c15438t);
            }
        }
        Collections.sort(arrayList, new C154401());
        AppMethodBeat.m2505o(62893);
        return arrayList;
    }

    public final void axQ() {
        AppMethodBeat.m2504i(62894);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECENT_SMILEY_STRING, null);
        this.ybh = new HashMap();
        AppMethodBeat.m2505o(62894);
    }
}
