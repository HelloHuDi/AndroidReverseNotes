package com.bumptech.glide.c.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {
    private final Context context;

    static class b implements d<File> {
        private static final String[] aEl = new String[]{"_data"};
        private final Context context;
        private final Uri uri;

        b(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super File> aVar) {
            CharSequence charSequence = null;
            AppMethodBeat.i(92087);
            Cursor query = this.context.getContentResolver().query(this.uri, aEl, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        charSequence = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    AppMethodBeat.o(92087);
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                aVar.b(new FileNotFoundException("Failed to find file path for: " + this.uri));
                AppMethodBeat.o(92087);
                return;
            }
            aVar.S(new File(charSequence));
            AppMethodBeat.o(92087);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        public final Class<File> mg() {
            return File.class;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public static final class a implements o<Uri, File> {
        private final Context context;

        public a(Context context) {
            this.context = context;
        }

        public final n<Uri, File> a(r rVar) {
            AppMethodBeat.i(92086);
            k kVar = new k(this.context);
            AppMethodBeat.o(92086);
            return kVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92088);
        boolean f = com.bumptech.glide.c.a.a.b.f((Uri) obj);
        AppMethodBeat.o(92088);
        return f;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92089);
        Uri uri = (Uri) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(uri), new b(this.context, uri));
        AppMethodBeat.o(92089);
        return aVar;
    }

    public k(Context context) {
        this.context = context;
    }
}
