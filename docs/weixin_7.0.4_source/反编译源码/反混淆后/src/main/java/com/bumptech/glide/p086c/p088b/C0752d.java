package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C37189d;
import com.bumptech.glide.p086c.p088b.p785b.C31932a.C31931b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.bumptech.glide.c.b.d */
final class C0752d<DataType> implements C31931b {
    private final C37189d<DataType> aAc;
    private final C31967j aAd;
    private final DataType data;

    C0752d(C37189d<DataType> c37189d, DataType dataType, C31967j c31967j) {
        this.aAc = c37189d;
        this.data = dataType;
        this.aAd = c31967j;
    }

    /* renamed from: m */
    public final boolean mo2209m(File file) {
        AppMethodBeat.m2504i(91762);
        boolean a = this.aAc.mo2227a(this.data, file, this.aAd);
        AppMethodBeat.m2505o(91762);
        return a;
    }
}
