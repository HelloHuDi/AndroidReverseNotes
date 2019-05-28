package com.bumptech.glide.p086c.p090c.p091a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.p784a.C41544b;
import com.bumptech.glide.p086c.p087a.p784a.C8508c;
import com.bumptech.glide.p086c.p087a.p784a.C8508c.C8509b;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p090c.C8536r;
import com.bumptech.glide.p086c.p092d.p093a.C44997r;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.a.d */
public final class C31949d implements C37175n<Uri, InputStream> {
    private final Context context;

    /* renamed from: com.bumptech.glide.c.c.a.d$a */
    public static class C17529a implements C31953o<Uri, InputStream> {
        private final Context context;

        public C17529a(Context context) {
            this.context = context;
        }

        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92170);
            C31949d c31949d = new C31949d(this.context);
            AppMethodBeat.m2505o(92170);
            return c31949d;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92172);
        Uri uri = (Uri) obj;
        if (C41544b.m72731f(uri) && C41544b.m72732g(uri)) {
            AppMethodBeat.m2505o(92172);
            return true;
        }
        AppMethodBeat.m2505o(92172);
        return false;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92173);
        Uri uri = (Uri) obj;
        if (C41544b.m72730aR(i, i2)) {
            Object obj2;
            Long l = (Long) c31967j.mo52069a(C44997r.aFJ);
            if (l == null || l.longValue() != -1) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                C17555b c17555b = new C17555b(uri);
                Context context = this.context;
                C37176a c37176a = new C37176a(c17555b, C8508c.m15115a(context, uri, new C8509b(context.getContentResolver())));
                AppMethodBeat.m2505o(92173);
                return c37176a;
            }
        }
        AppMethodBeat.m2505o(92173);
        return null;
    }

    public C31949d(Context context) {
        AppMethodBeat.m2504i(92171);
        this.context = context.getApplicationContext();
        AppMethodBeat.m2505o(92171);
    }
}
