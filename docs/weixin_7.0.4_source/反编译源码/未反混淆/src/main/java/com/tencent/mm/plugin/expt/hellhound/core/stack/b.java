package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] lMu = new int[a.values().length];

        static {
            AppMethodBeat.i(73358);
            try {
                lMu[a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lMu[a.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lMu[a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lMu[a.STOP.ordinal()] = 4;
                AppMethodBeat.o(73358);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(73358);
            }
        }
    }
}
