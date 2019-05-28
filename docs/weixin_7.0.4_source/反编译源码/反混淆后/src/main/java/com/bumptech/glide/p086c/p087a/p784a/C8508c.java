package com.bumptech.glide.p086c.p087a.p784a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p087a.C8513g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.a.a.c */
public final class C8508c implements C0742d<InputStream> {
    private final Uri azA;
    private final C17514e azB;
    private InputStream azC;

    /* renamed from: com.bumptech.glide.c.a.a.c$b */
    public static class C8509b implements C25402d {
        private static final String[] azD = new String[]{"_data"};
        private final ContentResolver azy;

        public C8509b(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        /* renamed from: h */
        public final Cursor mo18599h(Uri uri) {
            AppMethodBeat.m2504i(91737);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.azy.query(Thumbnails.EXTERNAL_CONTENT_URI, azD, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.m2505o(91737);
            return query;
        }
    }

    /* renamed from: com.bumptech.glide.c.a.a.c$a */
    public static class C8510a implements C25402d {
        private static final String[] azD = new String[]{"_data"};
        private final ContentResolver azy;

        public C8510a(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        /* renamed from: h */
        public final Cursor mo18599h(Uri uri) {
            AppMethodBeat.m2504i(91736);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.azy.query(Images.Thumbnails.EXTERNAL_CONTENT_URI, azD, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.m2505o(91736);
            return query;
        }
    }

    /* renamed from: a */
    public static C8508c m15115a(Context context, Uri uri, C25402d c25402d) {
        AppMethodBeat.m2504i(91738);
        C8508c c8508c = new C8508c(uri, new C17514e(C8555c.m15204ae(context).awj.mo52082lF(), c25402d, C8555c.m15204ae(context).awk, context.getContentResolver()));
        AppMethodBeat.m2505o(91738);
        return c8508c;
    }

    private C8508c(Uri uri, C17514e c17514e) {
        this.azA = uri;
        this.azB = c17514e;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(91740);
        if (this.azC != null) {
            try {
                this.azC.close();
                AppMethodBeat.m2505o(91740);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(91740);
    }

    public final void cancel() {
    }

    /* renamed from: mg */
    public final Class<InputStream> mo2187mg() {
        return InputStream.class;
    }

    /* renamed from: mh */
    public final C25405a mo2188mh() {
        return C25405a.LOCAL;
    }

    /* renamed from: a */
    public final void mo2184a(C37192g c37192g, C0743a<? super InputStream> c0743a) {
        AppMethodBeat.m2504i(91739);
        try {
            int i;
            InputStream c8513g;
            InputStream j = this.azB.mo31943j(this.azA);
            if (j != null) {
                i = this.azB.mo31942i(this.azA);
            } else {
                i = -1;
            }
            if (i != -1) {
                c8513g = new C8513g(j, i);
            } else {
                c8513g = j;
            }
            this.azC = c8513g;
            c0743a.mo2189S(this.azC);
            AppMethodBeat.m2505o(91739);
        } catch (FileNotFoundException e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            c0743a.mo2190b(e);
            AppMethodBeat.m2505o(91739);
        }
    }
}
