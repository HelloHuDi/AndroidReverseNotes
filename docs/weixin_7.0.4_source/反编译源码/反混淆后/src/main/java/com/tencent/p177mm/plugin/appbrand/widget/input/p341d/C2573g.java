package com.tencent.p177mm.plugin.appbrand.widget.input.p341d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.g */
public enum C2573g {
    LEFT,
    RIGHT,
    CENTER;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.g$1 */
    public static /* synthetic */ class C25741 {
        public static final /* synthetic */ int[] jjT = null;

        static {
            AppMethodBeat.m2504i(123953);
            jjT = new int[C2573g.values().length];
            try {
                jjT[C2573g.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jjT[C2573g.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jjT[C2573g.CENTER.ordinal()] = 3;
                AppMethodBeat.m2505o(123953);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(123953);
            }
        }
    }

    static {
        AppMethodBeat.m2505o(123957);
    }

    /* renamed from: EK */
    public static C2573g m4818EK(String str) {
        AppMethodBeat.m2504i(123956);
        Enum f = C33626d.m54899f(str, C2573g.class);
        C2573g c2573g = LEFT;
        if (f != null) {
            Enum c2573g2 = f;
        }
        c2573g2 = c2573g2;
        AppMethodBeat.m2505o(123956);
        return c2573g2;
    }
}
