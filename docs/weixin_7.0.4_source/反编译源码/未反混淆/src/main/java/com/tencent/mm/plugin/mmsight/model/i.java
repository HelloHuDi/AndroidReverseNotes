package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class i {
    private static al ouv = new al("MMSightHandler");

    static {
        AppMethodBeat.i(76521);
        AppMethodBeat.o(76521);
    }

    public static void R(Runnable runnable) {
        AppMethodBeat.i(76519);
        ouv.aa(runnable);
        AppMethodBeat.o(76519);
    }

    public static void S(Runnable runnable) {
        AppMethodBeat.i(76520);
        ouv.m(runnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(76520);
    }
}
