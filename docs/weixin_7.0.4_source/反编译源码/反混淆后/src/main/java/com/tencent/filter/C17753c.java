package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;

/* renamed from: com.tencent.filter.c */
public class C17753c extends BaseFilter {
    public C17753c() {
        super(GLSLRender.bJB);
        this.mIsGPU = false;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86351);
        this.mIsPreviewFilter = z;
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
        }
        AppMethodBeat.m2505o(86351);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, int i5, int i6, double d, C41672h c41672h) {
        AppMethodBeat.m2504i(86352);
        if (this.mIsPreviewFilter) {
            super.RenderProcess(i, i2, i3, i4, i5, i6, d, c41672h);
            AppMethodBeat.m2505o(86352);
            return;
        }
        QImage aL = C41106g.m71542aL(i, i2, i3);
        QImage ApplyFilter = ApplyFilter(aL);
        GLSLRender.nativeTextImage(ApplyFilter, i6);
        aL.Dispose();
        if (aL != ApplyFilter) {
            ApplyFilter.Dispose();
        }
        AppMethodBeat.m2505o(86352);
    }
}
