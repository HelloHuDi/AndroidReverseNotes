package com.bumptech.glide.p086c.p087a.p784a;

import android.net.Uri;
import android.support.p057v4.widget.C8415j;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.a.a.b */
public final class C41544b {
    /* renamed from: f */
    public static boolean m72731f(Uri uri) {
        AppMethodBeat.m2504i(91734);
        if (uri != null && C8741b.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            AppMethodBeat.m2505o(91734);
            return true;
        }
        AppMethodBeat.m2505o(91734);
        return false;
    }

    /* renamed from: g */
    public static boolean m72732g(Uri uri) {
        AppMethodBeat.m2504i(91735);
        boolean contains = uri.getPathSegments().contains("video");
        AppMethodBeat.m2505o(91735);
        return contains;
    }

    /* renamed from: aR */
    public static boolean m72730aR(int i, int i2) {
        return i != C8415j.INVALID_ID && i2 != C8415j.INVALID_ID && i <= 512 && i2 <= 384;
    }
}
