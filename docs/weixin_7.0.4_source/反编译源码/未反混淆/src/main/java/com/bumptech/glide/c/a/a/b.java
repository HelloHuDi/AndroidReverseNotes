package com.bumptech.glide.c.a.a;

import android.net.Uri;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean f(Uri uri) {
        AppMethodBeat.i(91734);
        if (uri != null && com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            AppMethodBeat.o(91734);
            return true;
        }
        AppMethodBeat.o(91734);
        return false;
    }

    public static boolean g(Uri uri) {
        AppMethodBeat.i(91735);
        boolean contains = uri.getPathSegments().contains("video");
        AppMethodBeat.o(91735);
        return contains;
    }

    public static boolean aR(int i, int i2) {
        return i != j.INVALID_ID && i2 != j.INVALID_ID && i <= 512 && i2 <= 384;
    }
}
