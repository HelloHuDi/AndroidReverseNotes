package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpaceFilter extends BaseFilter {
    private float mRatio = 0.0f;

    public SpaceFilter() {
        super(GLSLRender.bJB);
    }

    public void setSpaceRatio(float f) {
        AppMethodBeat.m2504i(82950);
        if (Float.compare(this.mRatio, f) == 0) {
            AppMethodBeat.m2505o(82950);
            return;
        }
        this.mRatio = f;
        float f2 = 1.0f - this.mRatio;
        setPositions(new float[]{-f2, -f2, -f2, f2, f2, f2, f2, -f2});
        AppMethodBeat.m2505o(82950);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82951);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glFinish();
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(82951);
        return renderTexture;
    }
}
