package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25629b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;

public class RotateScaleFilter extends VideoFilterBase {
    public RotateScaleFilter() {
        super(PROGRAM_TYPE.ROTATE_SCALE);
        AppMethodBeat.m2504i(82827);
        initParams();
        AppMethodBeat.m2505o(82827);
    }

    public void updateParams(float f, float f2, float f3, PointF pointF, PointF pointF2, PointF pointF3) {
        AppMethodBeat.m2504i(82828);
        addParam(new C0933f("texScale", f));
        addParam(new C0933f("texRotate", f2));
        addParam(new C25629b("translate", pointF2.x, pointF2.y));
        addParam(new C25629b("anchor", pointF.x, pointF.y));
        addParam(new C0933f("alpha", f3));
        addParam(new C25629b("canvasSize", pointF3.x, pointF3.y));
        AppMethodBeat.m2505o(82828);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82829);
        updateParams(1.0f, 0.0f, 1.0f, new PointF(), new PointF(), new PointF(1.0f, 1.0f));
        AppMethodBeat.m2505o(82829);
    }
}
