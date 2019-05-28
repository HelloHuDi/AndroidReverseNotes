package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i, int i2) {
        super(eglCore);
        AppMethodBeat.i(50019);
        createOffscreenSurface(i, i2);
        AppMethodBeat.o(50019);
    }

    public void release() {
        AppMethodBeat.i(50020);
        releaseEglSurface();
        AppMethodBeat.o(50020);
    }
}
