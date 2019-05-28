package com.tencent.p177mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.mmsight.model.i */
public final class C46078i {
    private static C5004al ouv = new C5004al("MMSightHandler");

    static {
        AppMethodBeat.m2504i(76521);
        AppMethodBeat.m2505o(76521);
    }

    /* renamed from: R */
    public static void m85848R(Runnable runnable) {
        AppMethodBeat.m2504i(76519);
        ouv.mo10302aa(runnable);
        AppMethodBeat.m2505o(76519);
    }

    /* renamed from: S */
    public static void m85849S(Runnable runnable) {
        AppMethodBeat.m2504i(76520);
        ouv.mo10310m(runnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(76520);
    }
}
