package com.tencent.ttpic;

import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.thread.SegmentGLThread;

public enum PTModule {
    INSTANCE;
    
    private SegmentGLThread mSegGLThread;

    static {
        AppMethodBeat.m2505o(81592);
    }

    public static PTModule getInstance() {
        return INSTANCE;
    }

    public final void init(EGLContext eGLContext) {
        AppMethodBeat.m2504i(81590);
        if (ApiHelper.hasJellyBeanMR1() && this.mSegGLThread == null) {
            this.mSegGLThread = new SegmentGLThread(eGLContext);
        }
        AppMethodBeat.m2505o(81590);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(81591);
        if (this.mSegGLThread != null) {
            this.mSegGLThread.destroy();
            this.mSegGLThread = null;
        }
        AppMethodBeat.m2505o(81591);
    }
}
