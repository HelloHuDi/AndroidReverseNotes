package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    LEFT,
    RIGHT,
    CENTER;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.g$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] jjT = null;

        static {
            AppMethodBeat.i(123953);
            jjT = new int[g.values().length];
            try {
                jjT[g.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jjT[g.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jjT[g.CENTER.ordinal()] = 3;
                AppMethodBeat.o(123953);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(123953);
            }
        }
    }

    static {
        AppMethodBeat.o(123957);
    }

    public static g EK(String str) {
        AppMethodBeat.i(123956);
        Enum f = d.f(str, g.class);
        g gVar = LEFT;
        if (f != null) {
            Enum gVar2 = f;
        }
        gVar2 = gVar2;
        AppMethodBeat.o(123956);
        return gVar2;
    }
}
