package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16222fd.C5871a;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fa */
class C46783fa extends C16224fe {
    /* renamed from: g */
    private boolean f18129g = true;

    /* renamed from: b */
    public /* synthetic */ C16224fe mo29280b() {
        AppMethodBeat.m2504i(98859);
        C46783fa a = mo75368a();
        AppMethodBeat.m2505o(98859);
        return a;
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(98860);
        C46783fa a = mo75368a();
        AppMethodBeat.m2505o(98860);
        return a;
    }

    public C46783fa(C5871a... c5871aArr) {
        super(c5871aArr);
    }

    /* renamed from: a */
    public C46783fa mo75368a() {
        AppMethodBeat.m2504i(98858);
        ArrayList arrayList = this.f3215e;
        int size = this.f3215e.size();
        C5871a[] c5871aArr = new C5871a[size];
        for (int i = 0; i < size; i++) {
            c5871aArr[i] = (C5871a) ((C16222fd) arrayList.get(i)).clone();
        }
        C46783fa c46783fa = new C46783fa(c5871aArr);
        AppMethodBeat.m2505o(98858);
        return c46783fa;
    }
}
