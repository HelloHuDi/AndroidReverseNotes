package com.bumptech.glide.p086c.p090c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C31243n;
import com.bumptech.glide.p086c.p087a.C31923a;
import com.bumptech.glide.p086c.p087a.C37160i;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.c.w */
public final class C41197w<Data> implements C37175n<Uri, Data> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", C8741b.CONTENT})));
    private final C25440c<Data> aEM;

    /* renamed from: com.bumptech.glide.c.c.w$d */
    public static class C8542d implements C31953o<Uri, InputStream>, C25440c<InputStream> {
        private final ContentResolver azy;

        public C8542d(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        /* renamed from: l */
        public final C0742d<InputStream> mo18643l(Uri uri) {
            AppMethodBeat.m2504i(92149);
            C31243n c31243n = new C31243n(this.azy, uri);
            AppMethodBeat.m2505o(92149);
            return c31243n;
        }

        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92150);
            C41197w c41197w = new C41197w(this);
            AppMethodBeat.m2505o(92150);
            return c41197w;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.w$c */
    public interface C25440c<Data> {
        /* renamed from: l */
        C0742d<Data> mo18643l(Uri uri);
    }

    /* renamed from: com.bumptech.glide.c.c.w$a */
    public static final class C36676a implements C31953o<Uri, AssetFileDescriptor>, C25440c<AssetFileDescriptor> {
        private final ContentResolver azy;

        public C36676a(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        /* renamed from: a */
        public final C37175n<Uri, AssetFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92145);
            C41197w c41197w = new C41197w(this);
            AppMethodBeat.m2505o(92145);
            return c41197w;
        }

        /* renamed from: l */
        public final C0742d<AssetFileDescriptor> mo18643l(Uri uri) {
            AppMethodBeat.m2504i(92146);
            C31923a c31923a = new C31923a(this.azy, uri);
            AppMethodBeat.m2505o(92146);
            return c31923a;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.w$b */
    public static class C37178b implements C31953o<Uri, ParcelFileDescriptor>, C25440c<ParcelFileDescriptor> {
        private final ContentResolver azy;

        public C37178b(ContentResolver contentResolver) {
            this.azy = contentResolver;
        }

        /* renamed from: l */
        public final C0742d<ParcelFileDescriptor> mo18643l(Uri uri) {
            AppMethodBeat.m2504i(92147);
            C37160i c37160i = new C37160i(this.azy, uri);
            AppMethodBeat.m2505o(92147);
            return c37160i;
        }

        /* renamed from: a */
        public final C37175n<Uri, ParcelFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92148);
            C41197w c41197w = new C41197w(this);
            AppMethodBeat.m2505o(92148);
            return c41197w;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92151);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.m2505o(92151);
        return contains;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92152);
        Uri uri = (Uri) obj;
        C37176a c37176a = new C37176a(new C17555b(uri), this.aEM.mo18643l(uri));
        AppMethodBeat.m2505o(92152);
        return c37176a;
    }

    static {
        AppMethodBeat.m2504i(92153);
        AppMethodBeat.m2505o(92153);
    }

    public C41197w(C25440c<Data> c25440c) {
        this.aEM = c25440c;
    }
}
