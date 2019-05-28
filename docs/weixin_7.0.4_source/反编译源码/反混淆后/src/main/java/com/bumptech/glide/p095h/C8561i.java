package com.bumptech.glide.p095h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

/* renamed from: com.bumptech.glide.h.i */
public final class C8561i {
    /* renamed from: b */
    public static void m15215b(boolean z, String str) {
        AppMethodBeat.m2504i(92597);
        if (z) {
            AppMethodBeat.m2505o(92597);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        AppMethodBeat.m2505o(92597);
        throw illegalArgumentException;
    }

    /* renamed from: d */
    public static <T> T m15217d(T t, String str) {
        AppMethodBeat.m2504i(92598);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.m2505o(92598);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(92598);
        return t;
    }

    public static String checkNotEmpty(String str) {
        AppMethodBeat.m2504i(92599);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be null or empty");
            AppMethodBeat.m2505o(92599);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(92599);
        return str;
    }

    /* renamed from: c */
    public static <T extends Collection<Y>, Y> T m15216c(T t) {
        AppMethodBeat.m2504i(92600);
        if (t.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be empty.");
            AppMethodBeat.m2505o(92600);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(92600);
        return t;
    }
}
