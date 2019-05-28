package com.bumptech.glide.p086c.p090c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C44979h;
import com.bumptech.glide.p086c.p087a.C8514m;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.a */
public final class C25427a<Data> implements C37175n<Uri, Data> {
    private static final int aDM = 22;
    private final C25425a<Data> aDN;
    private final AssetManager azj;

    /* renamed from: com.bumptech.glide.c.c.a$b */
    public static class C17528b implements C25425a<ParcelFileDescriptor>, C31953o<Uri, ParcelFileDescriptor> {
        private final AssetManager azj;

        public C17528b(AssetManager assetManager) {
            this.azj = assetManager;
        }

        /* renamed from: a */
        public final C37175n<Uri, ParcelFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92030);
            C25427a c25427a = new C25427a(this.azj, this);
            AppMethodBeat.m2505o(92030);
            return c25427a;
        }

        /* renamed from: b */
        public final C0742d<ParcelFileDescriptor> mo31961b(AssetManager assetManager, String str) {
            AppMethodBeat.m2504i(92031);
            C44979h c44979h = new C44979h(assetManager, str);
            AppMethodBeat.m2505o(92031);
            return c44979h;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.a$a */
    public interface C25425a<Data> {
        /* renamed from: b */
        C0742d<Data> mo31961b(AssetManager assetManager, String str);
    }

    /* renamed from: com.bumptech.glide.c.c.a$c */
    public static class C25428c implements C25425a<InputStream>, C31953o<Uri, InputStream> {
        private final AssetManager azj;

        public C25428c(AssetManager assetManager) {
            this.azj = assetManager;
        }

        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92032);
            C25427a c25427a = new C25427a(this.azj, this);
            AppMethodBeat.m2505o(92032);
            return c25427a;
        }

        /* renamed from: b */
        public final C0742d<InputStream> mo31961b(AssetManager assetManager, String str) {
            AppMethodBeat.m2504i(92033);
            C8514m c8514m = new C8514m(assetManager, str);
            AppMethodBeat.m2505o(92033);
            return c8514m;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92034);
        Uri uri = (Uri) obj;
        if ("file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            AppMethodBeat.m2505o(92034);
            return true;
        }
        AppMethodBeat.m2505o(92034);
        return false;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92035);
        Uri uri = (Uri) obj;
        C37176a c37176a = new C37176a(new C17555b(uri), this.aDN.mo31961b(this.azj, uri.toString().substring(aDM)));
        AppMethodBeat.m2505o(92035);
        return c37176a;
    }

    public C25427a(AssetManager assetManager, C25425a<Data> c25425a) {
        this.azj = assetManager;
        this.aDN = c25425a;
    }
}
