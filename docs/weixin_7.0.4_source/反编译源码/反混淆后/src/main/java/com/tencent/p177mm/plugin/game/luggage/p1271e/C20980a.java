package com.tencent.p177mm.plugin.game.luggage.p1271e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.e.a */
public class C20980a implements C37866a<Bundle, Bundle> {
    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(136004);
        Bundle bundle = (Bundle) obj;
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    C9367gu c9367gu = new C9367gu();
                    c9367gu.cBw.f2862Cn = 4;
                    c9367gu.cBw.cBy = jSONObject.toString();
                    C4879a.xxA.mo10055m(c9367gu);
                } catch (JSONException e) {
                    AppMethodBeat.m2505o(136004);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(136004);
    }
}
