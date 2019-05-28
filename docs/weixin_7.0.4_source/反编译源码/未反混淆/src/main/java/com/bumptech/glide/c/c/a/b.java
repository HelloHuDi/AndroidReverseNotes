package com.bumptech.glide.c.c.a;

import android.net.Uri;
import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b implements n<Uri, InputStream> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final n<g, InputStream> aEN;

    public static class a implements o<Uri, InputStream> {
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92162);
            b bVar = new b(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(92162);
            return bVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92163);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.o(92163);
        return contains;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92164);
        com.bumptech.glide.c.c.n.a b = this.aEN.b(new g(((Uri) obj).toString()), i, i2, jVar);
        AppMethodBeat.o(92164);
        return b;
    }

    static {
        AppMethodBeat.i(92165);
        AppMethodBeat.o(92165);
    }

    public b(n<g, InputStream> nVar) {
        this.aEN = nVar;
    }
}
