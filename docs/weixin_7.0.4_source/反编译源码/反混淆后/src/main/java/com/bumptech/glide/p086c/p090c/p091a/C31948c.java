package com.bumptech.glide.p086c.p090c.p091a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.p784a.C41544b;
import com.bumptech.glide.p086c.p087a.p784a.C8508c;
import com.bumptech.glide.p086c.p087a.p784a.C8508c.C8510a;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p090c.C8536r;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.a.c */
public final class C31948c implements C37175n<Uri, InputStream> {
    private final Context context;

    /* renamed from: com.bumptech.glide.c.c.a.c$a */
    public static class C25426a implements C31953o<Uri, InputStream> {
        private final Context context;

        public C25426a(Context context) {
            this.context = context;
        }

        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92166);
            C31948c c31948c = new C31948c(this.context);
            AppMethodBeat.m2505o(92166);
            return c31948c;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92168);
        Uri uri = (Uri) obj;
        if (!C41544b.m72731f(uri) || C41544b.m72732g(uri)) {
            AppMethodBeat.m2505o(92168);
            return false;
        }
        AppMethodBeat.m2505o(92168);
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92169);
        Uri uri = (Uri) obj;
        if (C41544b.m72730aR(i, i2)) {
            C17555b c17555b = new C17555b(uri);
            Context context = this.context;
            C37176a c37176a = new C37176a(c17555b, C8508c.m15115a(context, uri, new C8510a(context.getContentResolver())));
            AppMethodBeat.m2505o(92169);
            return c37176a;
        }
        AppMethodBeat.m2505o(92169);
        return null;
    }

    public C31948c(Context context) {
        AppMethodBeat.m2504i(92167);
        this.context = context.getApplicationContext();
        AppMethodBeat.m2505o(92167);
    }
}
