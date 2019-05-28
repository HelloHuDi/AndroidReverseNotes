package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ah */
public class C42467ah extends C10332b {
    private C2241c hcM;
    private String hwL;
    private Map<String, Object> hwM;
    int hwN;

    /* renamed from: j */
    public C42467ah mo61032j(C2241c c2241c) {
        if (c2241c != null) {
            this.hcM = c2241c;
            this.hwN = 0;
        }
        return this;
    }

    /* renamed from: b */
    public C42467ah mo61030b(C2241c c2241c, int i) {
        AppMethodBeat.m2504i(91036);
        mo61032j(c2241c);
        this.hwN = i;
        AppMethodBeat.m2505o(91036);
        return this;
    }

    /* renamed from: n */
    public final C42467ah mo67975n(String str, Object obj) {
        AppMethodBeat.m2504i(91037);
        if (this.hwM == null) {
            this.hwM = new HashMap();
        }
        this.hwM.put(str, obj);
        AppMethodBeat.m2505o(91037);
        return this;
    }

    /* renamed from: AM */
    public C42467ah mo61028AM(String str) {
        this.hwL = str;
        return this;
    }

    /* renamed from: t */
    public C42467ah mo34958t(Map<String, Object> map) {
        AppMethodBeat.m2504i(91038);
        if (map == null) {
            AppMethodBeat.m2505o(91038);
        } else {
            C32192i.m52509d(map);
            this.hwM = map;
            AppMethodBeat.m2505o(91038);
        }
        return this;
    }

    public final String getData() {
        AppMethodBeat.m2504i(91039);
        String str;
        if (this.hwL != null) {
            str = this.hwL;
            AppMethodBeat.m2505o(91039);
            return str;
        } else if (this.hwM != null) {
            C32192i.m52509d(this.hwM);
            str = new JSONObject(this.hwM).toString();
            AppMethodBeat.m2505o(91039);
            return str;
        } else {
            AppMethodBeat.m2505o(91039);
            return null;
        }
    }

    public final void aCj() {
        AppMethodBeat.m2504i(91040);
        if (this.hcM == null) {
            AppMethodBeat.m2505o(91040);
            return;
        }
        this.hcM.mo6108a(this);
        AppMethodBeat.m2505o(91040);
    }
}
