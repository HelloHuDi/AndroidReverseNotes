package com.bumptech.glide.p086c.p088b.p785b;

import com.bumptech.glide.p086c.p088b.p785b.C31932a.C31933a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.bumptech.glide.c.b.b.d */
public class C41190d implements C31933a {
    private final long aDc = 262144000;
    private final C17518a aDd;

    /* renamed from: com.bumptech.glide.c.b.b.d$a */
    public interface C17518a {
        /* renamed from: mW */
        File mo31949mW();
    }

    public C41190d(C17518a c17518a) {
        this.aDd = c17518a;
    }

    /* renamed from: mU */
    public final C31932a mo52048mU() {
        AppMethodBeat.m2504i(91980);
        File mW = this.aDd.mo31949mW();
        if (mW == null) {
            AppMethodBeat.m2505o(91980);
            return null;
        } else if (mW.mkdirs() || (mW.exists() && mW.isDirectory())) {
            C31932a c41545e = new C41545e(mW, this.aDc);
            AppMethodBeat.m2505o(91980);
            return c41545e;
        } else {
            AppMethodBeat.m2505o(91980);
            return null;
        }
    }
}
