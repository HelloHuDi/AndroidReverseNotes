package com.tencent.mm.plugin.game.luggage.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.ipcinvoker.c;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(136004);
        Bundle bundle = (Bundle) obj;
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    gu guVar = new gu();
                    guVar.cBw.Cn = 4;
                    guVar.cBw.cBy = jSONObject.toString();
                    com.tencent.mm.sdk.b.a.xxA.m(guVar);
                } catch (JSONException e) {
                    AppMethodBeat.o(136004);
                    return;
                }
            }
        }
        AppMethodBeat.o(136004);
    }
}
