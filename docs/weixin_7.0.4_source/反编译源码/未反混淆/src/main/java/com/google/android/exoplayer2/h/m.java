package com.google.android.exoplayer2.h;

import android.content.Context;
import com.google.android.exoplayer2.h.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m implements a {
    private final u<? super f> bpJ;
    private final a bqq;
    private final Context context;

    public m(Context context, u<? super f> uVar, a aVar) {
        AppMethodBeat.i(95823);
        this.context = context.getApplicationContext();
        this.bpJ = uVar;
        this.bqq = aVar;
        AppMethodBeat.o(95823);
    }

    public final /* synthetic */ f tm() {
        AppMethodBeat.i(95824);
        l lVar = new l(this.context, this.bpJ, this.bqq.tm());
        AppMethodBeat.o(95824);
        return lVar;
    }
}
