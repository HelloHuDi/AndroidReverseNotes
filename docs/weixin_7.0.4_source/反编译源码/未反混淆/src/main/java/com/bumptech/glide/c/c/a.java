package com.bumptech.glide.c.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.h;
import com.bumptech.glide.c.a.m;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a<Data> implements n<Uri, Data> {
    private static final int aDM = 22;
    private final a<Data> aDN;
    private final AssetManager azj;

    public static class b implements a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {
        private final AssetManager azj;

        public b(AssetManager assetManager) {
            this.azj = assetManager;
        }

        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92030);
            a aVar = new a(this.azj, this);
            AppMethodBeat.o(92030);
            return aVar;
        }

        public final d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            AppMethodBeat.i(92031);
            h hVar = new h(assetManager, str);
            AppMethodBeat.o(92031);
            return hVar;
        }
    }

    public interface a<Data> {
        d<Data> b(AssetManager assetManager, String str);
    }

    public static class c implements a<InputStream>, o<Uri, InputStream> {
        private final AssetManager azj;

        public c(AssetManager assetManager) {
            this.azj = assetManager;
        }

        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(92032);
            a aVar = new a(this.azj, this);
            AppMethodBeat.o(92032);
            return aVar;
        }

        public final d<InputStream> b(AssetManager assetManager, String str) {
            AppMethodBeat.i(92033);
            m mVar = new m(assetManager, str);
            AppMethodBeat.o(92033);
            return mVar;
        }
    }

    public final /* synthetic */ boolean X(Object obj) {
        AppMethodBeat.i(92034);
        Uri uri = (Uri) obj;
        if ("file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            AppMethodBeat.o(92034);
            return true;
        }
        AppMethodBeat.o(92034);
        return false;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92035);
        Uri uri = (Uri) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(uri), this.aDN.b(this.azj, uri.toString().substring(aDM)));
        AppMethodBeat.o(92035);
        return aVar;
    }

    public a(AssetManager assetManager, a<Data> aVar) {
        this.azj = assetManager;
        this.aDN = aVar;
    }
}
