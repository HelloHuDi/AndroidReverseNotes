package com.tencent.mm.plugin.webview.luggage.a;

import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.webview.luggage.h;
import java.util.Set;
import org.json.JSONObject;

public class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(6420);
        Bundle bundle = (Bundle) obj;
        if (bundle != null) {
            String string = bundle.getString("name");
            String string2 = bundle.getString("data");
            Set<n> cXb = h.cXb();
            if (cXb != null) {
                c cVar2 = new c();
                cVar2.mName = string;
                try {
                    cVar2.bOf = new JSONObject(string2);
                    for (n nVar : cXb) {
                        nVar.bPN.a(cVar2);
                    }
                    AppMethodBeat.o(6420);
                    return;
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(6420);
    }
}
