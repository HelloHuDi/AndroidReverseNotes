package com.bumptech.glide.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class i {
    public static void b(boolean z, String str) {
        AppMethodBeat.i(92597);
        if (z) {
            AppMethodBeat.o(92597);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        AppMethodBeat.o(92597);
        throw illegalArgumentException;
    }

    public static <T> T d(T t, String str) {
        AppMethodBeat.i(92598);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(92598);
            throw nullPointerException;
        }
        AppMethodBeat.o(92598);
        return t;
    }

    public static String checkNotEmpty(String str) {
        AppMethodBeat.i(92599);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be null or empty");
            AppMethodBeat.o(92599);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(92599);
        return str;
    }

    public static <T extends Collection<Y>, Y> T c(T t) {
        AppMethodBeat.i(92600);
        if (t.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be empty.");
            AppMethodBeat.o(92600);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(92600);
        return t;
    }
}
