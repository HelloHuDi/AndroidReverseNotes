package com.bumptech.glide.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.c.a.a.b;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class c implements n<Uri, InputStream> {
    private final Context context;

    public static class a implements o<Uri, InputStream> {
        private final Context context;

        public a(Context context) {
            this.context = context;
        }

        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92166);
            c cVar = new c(this.context);
            AppMethodBeat.o(92166);
            return cVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92168);
        Uri uri = (Uri) obj;
        if (!b.f(uri) || b.g(uri)) {
            AppMethodBeat.o(92168);
            return false;
        }
        AppMethodBeat.o(92168);
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92169);
        Uri uri = (Uri) obj;
        if (b.aR(i, i2)) {
            com.bumptech.glide.g.b bVar = new com.bumptech.glide.g.b(uri);
            Context context = this.context;
            com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(bVar, com.bumptech.glide.c.a.a.c.a(context, uri, new com.bumptech.glide.c.a.a.c.a(context.getContentResolver())));
            AppMethodBeat.o(92169);
            return aVar;
        }
        AppMethodBeat.o(92169);
        return null;
    }

    public c(Context context) {
        AppMethodBeat.i(92167);
        this.context = context.getApplicationContext();
        AppMethodBeat.o(92167);
    }
}
