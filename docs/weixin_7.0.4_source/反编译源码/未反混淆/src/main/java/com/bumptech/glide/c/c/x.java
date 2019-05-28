package com.bumptech.glide.c.c;

import android.net.Uri;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class x<Data> implements n<Uri, Data> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final n<g, Data> aEN;

    public static class a implements o<Uri, InputStream> {
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92154);
            x xVar = new x(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(92154);
            return xVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92155);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.o(92155);
        return contains;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92156);
        com.bumptech.glide.c.c.n.a b = this.aEN.b(new g(((Uri) obj).toString()), i, i2, jVar);
        AppMethodBeat.o(92156);
        return b;
    }

    static {
        AppMethodBeat.i(92157);
        AppMethodBeat.o(92157);
    }

    public x(n<g, Data> nVar) {
        this.aEN = nVar;
    }
}
