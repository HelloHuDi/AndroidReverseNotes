package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements d<InputStream> {
    private final Uri azA;
    private final e azB;
    private InputStream azC;

    public static class b implements d {
        private static final String[] azD = new String[]{"_data"};
        private final ContentResolver azy;

        public b(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        public final Cursor h(Uri uri) {
            AppMethodBeat.i(91737);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.azy.query(Thumbnails.EXTERNAL_CONTENT_URI, azD, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.o(91737);
            return query;
        }
    }

    public static class a implements d {
        private static final String[] azD = new String[]{"_data"};
        private final ContentResolver azy;

        public a(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        public final Cursor h(Uri uri) {
            AppMethodBeat.i(91736);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.azy.query(Images.Thumbnails.EXTERNAL_CONTENT_URI, azD, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.o(91736);
            return query;
        }
    }

    public static c a(Context context, Uri uri, d dVar) {
        AppMethodBeat.i(91738);
        c cVar = new c(uri, new e(com.bumptech.glide.c.ae(context).awj.lF(), dVar, com.bumptech.glide.c.ae(context).awk, context.getContentResolver()));
        AppMethodBeat.o(91738);
        return cVar;
    }

    private c(Uri uri, e eVar) {
        this.azA = uri;
        this.azB = eVar;
    }

    public final void cleanup() {
        AppMethodBeat.i(91740);
        if (this.azC != null) {
            try {
                this.azC.close();
                AppMethodBeat.o(91740);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(91740);
    }

    public final void cancel() {
    }

    public final Class<InputStream> mg() {
        return InputStream.class;
    }

    public final com.bumptech.glide.c.a mh() {
        return com.bumptech.glide.c.a.LOCAL;
    }

    public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super InputStream> aVar) {
        AppMethodBeat.i(91739);
        try {
            int i;
            InputStream gVar2;
            InputStream j = this.azB.j(this.azA);
            if (j != null) {
                i = this.azB.i(this.azA);
            } else {
                i = -1;
            }
            if (i != -1) {
                gVar2 = new com.bumptech.glide.c.a.g(j, i);
            } else {
                gVar2 = j;
            }
            this.azC = gVar2;
            aVar.S(this.azC);
            AppMethodBeat.o(91739);
        } catch (FileNotFoundException e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.b(e);
            AppMethodBeat.o(91739);
        }
    }
}
