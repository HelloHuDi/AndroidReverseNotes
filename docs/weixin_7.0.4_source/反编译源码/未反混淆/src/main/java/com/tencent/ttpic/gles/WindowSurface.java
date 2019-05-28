package com.tencent.ttpic.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WindowSurface extends EglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        AppMethodBeat.i(50053);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
        AppMethodBeat.o(50053);
    }

    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        AppMethodBeat.i(50054);
        createWindowSurface(surfaceTexture);
        AppMethodBeat.o(50054);
    }

    public void release() {
        AppMethodBeat.i(50055);
        releaseEglSurface();
        if (this.mSurface != null) {
            if (this.mReleaseSurface) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
        AppMethodBeat.o(50055);
    }

    public void recreate(EglCore eglCore) {
        AppMethodBeat.i(50056);
        if (this.mSurface == null) {
            RuntimeException runtimeException = new RuntimeException("not yet implemented for SurfaceTexture");
            AppMethodBeat.o(50056);
            throw runtimeException;
        }
        this.mEglCore = eglCore;
        createWindowSurface(this.mSurface);
        AppMethodBeat.o(50056);
    }
}
