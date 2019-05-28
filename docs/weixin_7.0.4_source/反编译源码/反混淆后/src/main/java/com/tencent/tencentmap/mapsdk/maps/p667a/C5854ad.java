package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ad */
public final class C5854ad extends C41029ak implements Cloneable {
    /* renamed from: b */
    private static ArrayList<C5853ac> f1518b;
    /* renamed from: a */
    public ArrayList<C5853ac> f1519a = null;

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98410);
        c46767aj.mo75330a(this.f1519a, 0);
        AppMethodBeat.m2505o(98410);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98411);
        if (f1518b == null) {
            f1518b = new ArrayList();
            f1518b.add(new C5853ac());
        }
        this.f1519a = (ArrayList) c41028ai.mo65104a(f1518b, 0, true);
        AppMethodBeat.m2505o(98411);
    }
}
