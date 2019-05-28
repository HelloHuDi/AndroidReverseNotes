package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i, int i2) {
        super(eglCore);
        AppMethodBeat.m2504i(50019);
        createOffscreenSurface(i, i2);
        AppMethodBeat.m2505o(50019);
    }

    public void release() {
        AppMethodBeat.m2504i(50020);
        releaseEglSurface();
        AppMethodBeat.m2505o(50020);
    }
}
