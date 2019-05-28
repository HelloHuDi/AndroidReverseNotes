package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.IOException;

public final class a {
    public static final h aLi = new c(BuildConfig.COMMAND);
    public static final h aLj = new c("true");
    public static final h aLk = new c("false");

    static {
        AppMethodBeat.i(70496);
        AppMethodBeat.o(70496);
    }

    public static h dr(int i) {
        AppMethodBeat.i(70489);
        d dVar = new d(Integer.toString(i, 10));
        AppMethodBeat.o(70489);
        return dVar;
    }

    public static h t(long j) {
        AppMethodBeat.i(70490);
        d dVar = new d(Long.toString(j, 10));
        AppMethodBeat.o(70490);
        return dVar;
    }

    public static h T(float f) {
        AppMethodBeat.i(70491);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.o(70491);
            throw illegalArgumentException;
        }
        d dVar = new d(ai(Float.toString(f)));
        AppMethodBeat.o(70491);
        return dVar;
    }

    public static h m(double d) {
        AppMethodBeat.i(70492);
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.o(70492);
            throw illegalArgumentException;
        }
        d dVar = new d(ai(Double.toString(d)));
        AppMethodBeat.o(70492);
        return dVar;
    }

    public static h ag(String str) {
        AppMethodBeat.i(70493);
        h hVar;
        if (str == null) {
            hVar = aLi;
            AppMethodBeat.o(70493);
            return hVar;
        }
        hVar = new g(str);
        AppMethodBeat.o(70493);
        return hVar;
    }

    public static h aB(boolean z) {
        return z ? aLj : aLk;
    }

    public static h ah(String str) {
        AppMethodBeat.i(70494);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(70494);
            throw nullPointerException;
        }
        try {
            f fVar = new f(str);
            fVar.pi();
            fVar.ph();
            h oT = fVar.oT();
            fVar.ph();
            if (fVar.pp()) {
                AppMethodBeat.o(70494);
                return oT;
            }
            j am = fVar.am("Unexpected character");
            AppMethodBeat.o(70494);
            throw am;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(70494);
            throw runtimeException;
        }
    }

    private static String ai(String str) {
        AppMethodBeat.i(70495);
        if (str.endsWith(".0")) {
            str = str.substring(0, str.length() - 2);
            AppMethodBeat.o(70495);
            return str;
        }
        AppMethodBeat.o(70495);
        return str;
    }
}
