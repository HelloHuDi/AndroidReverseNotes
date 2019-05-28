package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OffsetGuideFilter extends BaseFilter {
    private float xOffset = 0.0f;

    public OffsetGuideFilter() {
        super(GLSLRender.bJB);
    }

    public void setxOffset(float f) {
        this.xOffset = f;
    }

    private void updatePosition() {
        AppMethodBeat.i(82685);
        float f = 0.0f - this.xOffset;
        float f2 = 0.5f - (this.xOffset / 2.0f);
        setPositions(new float[]{f, -1.0f, f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        setTexCords(new float[]{f2, 1.0f, f2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        AppMethodBeat.o(82685);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, h hVar) {
        AppMethodBeat.i(82686);
        updatePosition();
        super.RenderProcess(i, i2, i3, i4, d, hVar);
        AppMethodBeat.o(82686);
    }
}
