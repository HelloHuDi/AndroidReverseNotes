package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.b.a.b;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d<DataType> implements b {
    private final com.bumptech.glide.c.d<DataType> aAc;
    private final j aAd;
    private final DataType data;

    d(com.bumptech.glide.c.d<DataType> dVar, DataType dataType, j jVar) {
        this.aAc = dVar;
        this.data = dataType;
        this.aAd = jVar;
    }

    public final boolean m(File file) {
        AppMethodBeat.i(91762);
        boolean a = this.aAc.a(this.data, file, this.aAd);
        AppMethodBeat.o(91762);
        return a;
    }
}
