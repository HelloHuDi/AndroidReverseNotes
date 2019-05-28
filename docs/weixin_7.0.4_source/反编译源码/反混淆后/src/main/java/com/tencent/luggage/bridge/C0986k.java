package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.k */
public final class C0986k {
    public JSONObject bOf;
    String bOr;
    public int bOs;
    private boolean bOt;
    private C32178f bOw;
    boolean bOx;
    public String bOy;
    public JSONObject bOz;

    C0986k(C32178f c32178f, C37390m c37390m, boolean z) {
        AppMethodBeat.m2504i(90725);
        this.bOw = c32178f;
        JSONObject wK = c37390m.mo20029wK();
        this.bOr = wK.getString(C8741b.METHOD);
        this.bOf = wK.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject("{}");
        }
        this.bOx = z;
        this.bOs = wK.optInt("callbackId", 0);
        this.bOt = false;
        this.bOz = new JSONObject();
        AppMethodBeat.m2505o(90725);
    }

    /* renamed from: a */
    public final void mo3951a(String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(90726);
        if (str == null) {
            str = "";
        }
        this.bOy = str;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.bOz = jSONObject;
        if (this.bOs != 0) {
            mo3952wM();
        }
        AppMethodBeat.m2505o(90726);
    }

    /* renamed from: wM */
    public final void mo3952wM() {
        AppMethodBeat.m2504i(90727);
        this.bOw.mo52820a(mo3953wN());
        AppMethodBeat.m2505o(90727);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wN */
    public final C45118e mo3953wN() {
        AppMethodBeat.m2504i(90728);
        C25682c c25682c = new C25682c(this.bOs, this.bOy, this.bOz, this.bOt);
        AppMethodBeat.m2505o(90728);
        return c25682c;
    }
}
