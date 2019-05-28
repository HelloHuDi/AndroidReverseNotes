package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CropFilter extends BaseFilter {
    private float bottom = 0.0f;
    private float left = 0.0f;

    public CropFilter() {
        super(GLSLRender.bJB);
    }

    public void updateCorpRect(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(82131);
        updateTexCords(i, i2, i3, i4);
        AppMethodBeat.m2505o(82131);
    }

    private void updatePosition(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(82132);
        float f = ((float) (i3 - i)) / ((float) i3);
        float f2 = ((float) (i4 - i2)) / ((float) i4);
        float f3 = -1.0f + f;
        f = 1.0f - f;
        float f4 = -1.0f + f2;
        f2 = 1.0f - f2;
        setPositions(new float[]{f3, f4, f3, f2, f, f2, f, f4});
        AppMethodBeat.m2505o(82132);
    }

    private void updateTexCords(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(82133);
        float f = (((float) (i3 - i)) / 2.0f) / ((float) i3);
        float f2 = 1.0f - f;
        float f3 = (((float) (i4 - i2)) / 2.0f) / ((float) i4);
        float f4 = 1.0f - f3;
        if (Float.compare(f, this.left) == 0 && Float.compare(f3, this.bottom) == 0) {
            AppMethodBeat.m2505o(82133);
            return;
        }
        this.left = f;
        this.bottom = f3;
        setTexCords(new float[]{f, f3, f, f4, f2, f4, f2, f3});
        AppMethodBeat.m2505o(82133);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(82134);
        this.left = 0.0f;
        this.bottom = 0.0f;
        super.clearGLSLSelf();
        AppMethodBeat.m2505o(82134);
    }
}
