package com.bumptech.glide.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.c.a.a.b;
import com.bumptech.glide.c.a.a.c;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class d implements n<Uri, InputStream> {
    private final Context context;

    public static class a implements o<Uri, InputStream> {
        private final Context context;

        public a(Context context) {
            this.context = context;
        }

        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92170);
            d dVar = new d(this.context);
            AppMethodBeat.o(92170);
            return dVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92172);
        Uri uri = (Uri) obj;
        if (b.f(uri) && b.g(uri)) {
            AppMethodBeat.o(92172);
            return true;
        }
        AppMethodBeat.o(92172);
        return false;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92173);
        Uri uri = (Uri) obj;
        if (b.aR(i, i2)) {
            Object obj2;
            Long l = (Long) jVar.a(com.bumptech.glide.c.d.a.r.aFJ);
            if (l == null || l.longValue() != -1) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                com.bumptech.glide.g.b bVar = new com.bumptech.glide.g.b(uri);
                Context context = this.context;
                com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(bVar, c.a(context, uri, new c.b(context.getContentResolver())));
                AppMethodBeat.o(92173);
                return aVar;
            }
        }
        AppMethodBeat.o(92173);
        return null;
    }

    public d(Context context) {
        AppMethodBeat.i(92171);
        this.context = context.getApplicationContext();
        AppMethodBeat.o(92171);
    }
}
