package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ae */
public final class C5855ae extends C41029ak {
    /* renamed from: e */
    private static ArrayList<C5856af> f1520e;
    /* renamed from: f */
    private static Map<String, String> f1521f;
    /* renamed from: a */
    public ArrayList<C5856af> f1522a = null;
    /* renamed from: b */
    public int f1523b = 0;
    /* renamed from: c */
    public String f1524c = "";
    /* renamed from: d */
    public Map<String, String> f1525d = null;

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98412);
        c46767aj.mo75330a(this.f1522a, 0);
        c46767aj.mo75326a(this.f1523b, 1);
        c46767aj.mo75329a(this.f1524c, 2);
        if (this.f1525d != null) {
            c46767aj.mo75331a(this.f1525d, 3);
        }
        AppMethodBeat.m2505o(98412);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98413);
        if (f1520e == null) {
            f1520e = new ArrayList();
            f1520e.add(new C5856af());
        }
        this.f1522a = (ArrayList) c41028ai.mo65104a(f1520e, 0, true);
        this.f1523b = c41028ai.mo65101a(this.f1523b, 1, true);
        this.f1524c = c41028ai.mo65105a(2, true);
        if (f1521f == null) {
            f1521f = new HashMap();
            f1521f.put("", "");
        }
        this.f1525d = (Map) c41028ai.mo65104a(f1521f, 3, false);
        AppMethodBeat.m2505o(98413);
    }
}
