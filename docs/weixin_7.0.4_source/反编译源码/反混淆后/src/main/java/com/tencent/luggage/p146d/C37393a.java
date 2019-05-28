package com.tencent.luggage.p146d;

import com.tencent.luggage.bridge.C0986k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.d.a */
public abstract class C37393a<CONTEXT extends C25687b> {
    CONTEXT bOY;

    /* renamed from: com.tencent.luggage.d.a$a */
    public class C32183a {
        public CONTEXT bOZ;
        public C0986k bPa;

        /* renamed from: c */
        public final void mo52825c(String str, Map<String, Object> map) {
            AppMethodBeat.m2504i(90768);
            C0986k c0986k = this.bPa;
            if (str == null) {
                str = "";
            }
            c0986k.bOy = str;
            c0986k.bOz = map != null ? new JSONObject(map) : null;
            if (c0986k.bOs != 0) {
                c0986k.mo3952wM();
            }
            AppMethodBeat.m2505o(90768);
        }

        /* renamed from: a */
        public final void mo52824a(String str, JSONObject jSONObject) {
            AppMethodBeat.m2504i(90769);
            this.bPa.mo3951a(str, jSONObject);
            AppMethodBeat.m2505o(90769);
        }
    }

    /* renamed from: a */
    public abstract void mo38432a(C32183a c32183a);

    public abstract String name();
}
