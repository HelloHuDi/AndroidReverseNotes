package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hr */
public final class C41062hr extends C46803m {
    /* renamed from: c */
    static ArrayList<C46941hq> f16507c = new ArrayList();
    /* renamed from: a */
    public int f16508a = 0;
    /* renamed from: b */
    public ArrayList<C46941hq> f16509b = null;

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(99569);
        c24398l.mo40668a(this.f16508a, 0);
        if (this.f16509b != null) {
            c24398l.mo40673a(this.f16509b, 1);
        }
        AppMethodBeat.m2505o(99569);
    }

    static {
        AppMethodBeat.m2504i(99571);
        f16507c.add(new C46941hq());
        AppMethodBeat.m2505o(99571);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(99570);
        this.f16508a = c31070k.mo50503a(this.f16508a, 0, true);
        this.f16509b = (ArrayList) c31070k.mo50507a(f16507c, 1, false);
        AppMethodBeat.m2505o(99570);
    }
}
