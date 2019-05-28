package com.tencent.p177mm.plugin.webview.luggage.p1141a;

import android.os.Bundle;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.plugin.webview.luggage.C43887h;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.a.a */
public class C29775a implements C37866a<Bundle, Bundle> {
    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(6420);
        Bundle bundle = (Bundle) obj;
        if (bundle != null) {
            String string = bundle.getString("name");
            String string2 = bundle.getString("data");
            Set<C17821n> cXb = C43887h.cXb();
            if (cXb != null) {
                C43883c c43883c = new C43883c();
                c43883c.mName = string;
                try {
                    c43883c.bOf = new JSONObject(string2);
                    for (C17821n c17821n : cXb) {
                        c17821n.bPN.mo52826a(c43883c);
                    }
                    AppMethodBeat.m2505o(6420);
                    return;
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(6420);
    }
}
