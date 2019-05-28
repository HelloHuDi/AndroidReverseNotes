package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.b */
final class C38988b {

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.b$1 */
    static /* synthetic */ class C340761 {
        static final /* synthetic */ int[] lMu = new int[C45901a.values().length];

        static {
            AppMethodBeat.m2504i(73358);
            try {
                lMu[C45901a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lMu[C45901a.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lMu[C45901a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lMu[C45901a.STOP.ordinal()] = 4;
                AppMethodBeat.m2505o(73358);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(73358);
            }
        }
    }
}
