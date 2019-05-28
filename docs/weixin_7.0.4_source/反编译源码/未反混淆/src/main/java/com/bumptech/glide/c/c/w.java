package com.bumptech.glide.c.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c.a.i;
import com.bumptech.glide.c.a.n;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class w<Data> implements n<Uri, Data> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT})));
    private final c<Data> aEM;

    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver azy;

        public d(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        public final com.bumptech.glide.c.a.d<InputStream> l(Uri uri) {
            AppMethodBeat.i(92149);
            n nVar = new n(this.azy, uri);
            AppMethodBeat.o(92149);
            return nVar;
        }

        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92150);
            w wVar = new w(this);
            AppMethodBeat.o(92150);
            return wVar;
        }
    }

    public interface c<Data> {
        com.bumptech.glide.c.a.d<Data> l(Uri uri);
    }

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver azy;

        public a(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92145);
            w wVar = new w(this);
            AppMethodBeat.o(92145);
            return wVar;
        }

        public final com.bumptech.glide.c.a.d<AssetFileDescriptor> l(Uri uri) {
            AppMethodBeat.i(92146);
            com.bumptech.glide.c.a.a aVar = new com.bumptech.glide.c.a.a(this.azy, uri);
            AppMethodBeat.o(92146);
            return aVar;
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver azy;

        public b(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        public final com.bumptech.glide.c.a.d<ParcelFileDescriptor> l(Uri uri) {
            AppMethodBeat.i(92147);
            i iVar = new i(this.azy, uri);
            AppMethodBeat.o(92147);
            return iVar;
        }

        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92148);
            w wVar = new w(this);
            AppMethodBeat.o(92148);
            return wVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92151);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.o(92151);
        return contains;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92152);
        Uri uri = (Uri) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(uri), this.aEM.l(uri));
        AppMethodBeat.o(92152);
        return aVar;
    }

    static {
        AppMethodBeat.i(92153);
        AppMethodBeat.o(92153);
    }

    public w(c<Data> cVar) {
        this.aEM = cVar;
    }
}
