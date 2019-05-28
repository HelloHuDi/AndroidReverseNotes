package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.af */
public final class C5856af extends C41029ak {
    /* renamed from: g */
    private static Map<String, String> f1526g;
    /* renamed from: h */
    private static ArrayList<String> f1527h;
    /* renamed from: i */
    private static ArrayList<String> f1528i;
    /* renamed from: a */
    public byte f1529a = (byte) 0;
    /* renamed from: b */
    public byte f1530b = (byte) 0;
    /* renamed from: c */
    public String f1531c = "";
    /* renamed from: d */
    public Map<String, String> f1532d = null;
    /* renamed from: e */
    public ArrayList<String> f1533e = null;
    /* renamed from: f */
    public ArrayList<String> f1534f = null;

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98414);
        c46767aj.mo75325a(this.f1529a, 0);
        c46767aj.mo75325a(this.f1530b, 1);
        c46767aj.mo75329a(this.f1531c, 2);
        c46767aj.mo75331a(this.f1532d, 3);
        if (this.f1533e != null) {
            c46767aj.mo75330a(this.f1533e, 4);
        }
        if (this.f1534f != null) {
            c46767aj.mo75330a(this.f1534f, 6);
        }
        AppMethodBeat.m2505o(98414);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98415);
        this.f1529a = c41028ai.mo65100a(this.f1529a, 0, true);
        this.f1530b = c41028ai.mo65100a(this.f1530b, 1, true);
        this.f1531c = c41028ai.mo65105a(2, true);
        if (f1526g == null) {
            f1526g = new HashMap();
            f1526g.put("", "");
        }
        this.f1532d = (Map) c41028ai.mo65104a(f1526g, 3, true);
        if (f1527h == null) {
            f1527h = new ArrayList();
            f1527h.add("");
        }
        this.f1533e = (ArrayList) c41028ai.mo65104a(f1527h, 4, false);
        if (f1528i == null) {
            f1528i = new ArrayList();
            f1528i.add("");
        }
        this.f1534f = (ArrayList) c41028ai.mo65104a(f1528i, 6, false);
        AppMethodBeat.m2505o(98415);
    }
}
