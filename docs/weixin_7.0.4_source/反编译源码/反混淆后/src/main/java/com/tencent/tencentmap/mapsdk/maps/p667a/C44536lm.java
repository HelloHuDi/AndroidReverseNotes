package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.basemap.data.C45133b;
import com.tencent.map.lib.basemap.data.C8885a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lm */
public class C44536lm {
    /* renamed from: a */
    private int f17484a = 0;
    /* renamed from: b */
    private int f17485b = 0;
    /* renamed from: c */
    private String f17486c = "default";
    /* renamed from: d */
    private String f17487d = "";
    /* renamed from: e */
    private String f17488e = "";
    /* renamed from: f */
    private String f17489f;

    public C44536lm(int i, int i2, String str, String str2, String str3, String str4) {
        this.f17484a = i;
        this.f17485b = i2;
        this.f17487d = str;
        this.f17488e = str2;
        this.f17489f = str3;
        this.f17486c = str4;
    }

    /* renamed from: a */
    public int mo70926a() {
        return (this.f17484a * 10) + this.f17485b;
    }

    /* renamed from: a */
    public boolean mo70927a(C8885a c8885a) {
        AppMethodBeat.m2504i(100439);
        boolean b;
        switch (this.f17484a) {
            case 0:
                b = m80834b(c8885a);
                AppMethodBeat.m2505o(100439);
                return b;
            case 1:
                b = m80835c(c8885a);
                AppMethodBeat.m2505o(100439);
                return b;
            default:
                AppMethodBeat.m2505o(100439);
                return false;
        }
    }

    /* renamed from: b */
    public String mo70928b() {
        return this.f17487d;
    }

    /* renamed from: c */
    public String mo70929c() {
        return this.f17488e;
    }

    /* renamed from: d */
    public String mo70930d() {
        return this.f17489f;
    }

    /* renamed from: b */
    private boolean m80834b(C8885a c8885a) {
        AppMethodBeat.m2504i(100440);
        if ("default".equals(this.f17486c)) {
            AppMethodBeat.m2505o(100440);
            return true;
        } else if (c8885a == null) {
            AppMethodBeat.m2505o(100440);
            return false;
        } else {
            boolean a = C46801ln.m88999a(c8885a.mo20120a(), C46801ln.m88998a().mo75520c(this.f17486c));
            AppMethodBeat.m2505o(100440);
            return a;
        }
    }

    /* renamed from: c */
    private boolean m80835c(C8885a c8885a) {
        AppMethodBeat.m2504i(100441);
        if ("default".equals(this.f17486c)) {
            AppMethodBeat.m2505o(100441);
            return true;
        } else if (c8885a == null) {
            AppMethodBeat.m2505o(100441);
            return false;
        } else {
            C45133b[] c = C46801ln.m88998a().mo75520c(this.f17486c);
            C45133b[] b = c8885a.mo20122b();
            if (b == null || c == null) {
                AppMethodBeat.m2505o(100441);
                return true;
            }
            boolean a = C46801ln.m89000a(b, c);
            AppMethodBeat.m2505o(100441);
            return a;
        }
    }
}
