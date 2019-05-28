package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cb */
public final class C24359cb {
    /* renamed from: a */
    private String f4651a;
    /* renamed from: b */
    private Map<String, C24360cc> f4652b = new HashMap();

    public C24359cb(String str) {
        AppMethodBeat.m2504i(98614);
        this.f4651a = str;
        AppMethodBeat.m2505o(98614);
    }

    /* renamed from: a */
    public final String mo40545a() {
        return this.f4651a;
    }

    /* renamed from: a */
    public final void mo40546a(C24360cc c24360cc) {
        AppMethodBeat.m2504i(98615);
        this.f4652b.put(c24360cc.f4653a, c24360cc);
        AppMethodBeat.m2505o(98615);
    }

    /* renamed from: b */
    public final Map<String, C24360cc> mo40547b() {
        return this.f4652b;
    }
}
