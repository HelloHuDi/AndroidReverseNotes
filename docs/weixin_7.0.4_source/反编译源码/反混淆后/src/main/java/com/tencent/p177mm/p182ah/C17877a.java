package com.tencent.p177mm.p182ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18129e.C18130a;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;

/* renamed from: com.tencent.mm.ah.a */
public final class C17877a {
    C1177f<String, Bitmap> fra;

    public C17877a(int i) {
        AppMethodBeat.m2504i(77829);
        this.fra = new C7598c(i);
        AppMethodBeat.m2505o(77829);
    }

    /* renamed from: d */
    public final void mo33378d(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(77830);
        if (this.fra != null) {
            this.fra.mo4412k(str, bitmap);
            AppMethodBeat.m2505o(77830);
            return;
        }
        C18130a.m28566a("avatar_cache", str, bitmap);
        AppMethodBeat.m2505o(77830);
    }
}
