package com.tencent.p177mm.p190at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18129e;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;

/* renamed from: com.tencent.mm.at.j */
final class C9019j implements C18129e {
    private C1177f<String, Bitmap> fEV = new C26399b(5, getClass());

    C9019j() {
        AppMethodBeat.m2504i(78306);
        AppMethodBeat.m2505o(78306);
    }

    /* renamed from: f */
    public final void mo20452f(Object obj, Object obj2) {
        AppMethodBeat.m2504i(78307);
        this.fEV.mo4412k((String) obj, (Bitmap) obj2);
        AppMethodBeat.m2505o(78307);
    }

    public final Object get(Object obj) {
        AppMethodBeat.m2504i(78308);
        Object obj2 = this.fEV.get((String) obj);
        AppMethodBeat.m2505o(78308);
        return obj2;
    }

    public final Object remove(Object obj) {
        AppMethodBeat.m2504i(78309);
        this.fEV.remove((String) obj);
        AppMethodBeat.m2505o(78309);
        return null;
    }
}
