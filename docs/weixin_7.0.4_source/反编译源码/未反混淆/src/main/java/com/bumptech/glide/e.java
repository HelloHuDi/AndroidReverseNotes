package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.c.b.j;
import com.bumptech.glide.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e extends ContextWrapper {
    static final k<?, ?> awz = new b();
    private final Handler awA = new Handler(Looper.getMainLooper());
    private final b awB;
    final j awe;
    public final h awj;
    public final com.bumptech.glide.c.b.a.b awk;
    final Map<Class<?>, k<?, ?>> awp;
    public final int awu;
    final com.bumptech.glide.f.e awv;

    static {
        AppMethodBeat.i(91614);
        AppMethodBeat.o(91614);
    }

    public e(Context context, com.bumptech.glide.c.b.a.b bVar, h hVar, b bVar2, com.bumptech.glide.f.e eVar, Map<Class<?>, k<?, ?>> map, j jVar, int i) {
        super(context.getApplicationContext());
        AppMethodBeat.i(91613);
        this.awk = bVar;
        this.awj = hVar;
        this.awB = bVar2;
        this.awv = eVar;
        this.awp = map;
        this.awe = jVar;
        this.awu = i;
        AppMethodBeat.o(91613);
    }
}
