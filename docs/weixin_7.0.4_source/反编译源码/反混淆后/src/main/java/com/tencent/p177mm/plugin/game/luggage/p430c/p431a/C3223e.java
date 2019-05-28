package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.content.Context;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.protocal.protobuf.bbb;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.e */
public final class C3223e extends C34289a {
    public C3223e() {
        super(10);
    }

    /* renamed from: a */
    public final void mo7540a(Context context, C24905d c24905d, final bbb bbb) {
        AppMethodBeat.m2504i(135903);
        c24905d.bPN.mo52826a(new C17817c() {
            public final String name() {
                return "onCustomGameMenuClicked";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(135902);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", bbb.wFQ);
                    AppMethodBeat.m2505o(135902);
                    return jSONObject;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(135902);
                    return null;
                }
            }
        });
        AppMethodBeat.m2505o(135903);
    }
}
