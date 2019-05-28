package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FilterWraper extends BaseFilter {
    protected long bCj = 0;
    private boolean bCk = false;
    protected String bJx = "";

    private static native void nativeDispose(long j);

    private static native int nativeGetOutputText(long j);

    private static native long nativeInitialWithString(String str);

    private static native void nativeRenderContext(long j, int i, int i2, int i3);

    public FilterWraper(String str) {
        super(GLSLRender.bJB);
        this.bJx = str;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86358);
        if (this.bCk) {
            nativeDispose(this.bCj);
        }
        this.bCj = nativeInitialWithString(this.bJx);
        this.bCk = true;
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86358);
    }

    public void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86359);
        if (this.bCk) {
            nativeRenderContext(this.bCj, i, i2, i3);
        }
        super.beforeRender(i, i2, i3);
        AppMethodBeat.m2505o(86359);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86360);
        boolean renderTexture;
        if (this.bCk) {
            renderTexture = super.renderTexture(nativeGetOutputText(this.bCj), i2, i3);
            AppMethodBeat.m2505o(86360);
            return renderTexture;
        }
        renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(86360);
        return renderTexture;
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(86361);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.bCk = false;
        }
        super.ClearGLSL();
        AppMethodBeat.m2505o(86361);
    }
}
