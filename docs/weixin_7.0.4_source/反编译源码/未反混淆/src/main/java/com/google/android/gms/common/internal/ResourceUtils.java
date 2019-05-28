package com.google.android.gms.common.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ResourceUtils {
    private static final Uri zzuw = new Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    @Deprecated
    public interface SignInResources {
        public static final String BUTTON_DARK_TEXT_DEFAULT = "common_google_signin_btn_text_dark_normal";
    }

    static {
        AppMethodBeat.i(89720);
        AppMethodBeat.o(89720);
    }

    private ResourceUtils() {
    }

    public static Uri getDrawableUri(String str) {
        AppMethodBeat.i(89719);
        Preconditions.checkNotNull(str, "Resource name must not be null.");
        Uri build = zzuw.buildUpon().appendPath(str).build();
        AppMethodBeat.o(89719);
        return build;
    }
}
