package com.bumptech.glide.p086c.p090c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p087a.p784a.C41544b;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.c.c.k */
public final class C0764k implements C37175n<Uri, File> {
    private final Context context;

    /* renamed from: com.bumptech.glide.c.c.k$b */
    static class C0765b implements C0742d<File> {
        private static final String[] aEl = new String[]{"_data"};
        private final Context context;
        private final Uri uri;

        C0765b(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super File> c0743a) {
            CharSequence charSequence = null;
            AppMethodBeat.m2504i(92087);
            Cursor query = this.context.getContentResolver().query(this.uri, aEl, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        charSequence = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    AppMethodBeat.m2505o(92087);
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                c0743a.mo2190b(new FileNotFoundException("Failed to find file path for: " + this.uri));
                AppMethodBeat.m2505o(92087);
                return;
            }
            c0743a.mo2189S(new File(charSequence));
            AppMethodBeat.m2505o(92087);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<File> mo2187mg() {
            return File.class;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            return C25405a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.k$a */
    public static final class C0766a implements C31953o<Uri, File> {
        private final Context context;

        public C0766a(Context context) {
            this.context = context;
        }

        /* renamed from: a */
        public final C37175n<Uri, File> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92086);
            C0764k c0764k = new C0764k(this.context);
            AppMethodBeat.m2505o(92086);
            return c0764k;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92088);
        boolean f = C41544b.m72731f((Uri) obj);
        AppMethodBeat.m2505o(92088);
        return f;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92089);
        Uri uri = (Uri) obj;
        C37176a c37176a = new C37176a(new C17555b(uri), new C0765b(this.context, uri));
        AppMethodBeat.m2505o(92089);
        return c37176a;
    }

    public C0764k(Context context) {
        this.context = context;
    }
}
