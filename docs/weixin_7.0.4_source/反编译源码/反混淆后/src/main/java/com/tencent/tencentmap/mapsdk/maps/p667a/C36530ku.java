package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ku */
public class C36530ku<T extends C31074kv> implements C31074kv {
    /* renamed from: a */
    private final List<T> f15437a;
    /* renamed from: b */
    private final C16304ky f15438b;

    public C36530ku(List<T> list) {
        AppMethodBeat.m2504i(100269);
        this.f15437a = list;
        this.f15438b = C36528ks.m60515a(list);
        AppMethodBeat.m2505o(100269);
    }

    /* renamed from: a */
    public List<T> mo57770a() {
        return this.f15437a;
    }

    /* renamed from: b */
    public C36529kt mo29553b() {
        return this.f15438b;
    }
}
