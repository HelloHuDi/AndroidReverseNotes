package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;

public class RotateScaleFilter extends VideoFilterBase {
    public RotateScaleFilter() {
        super(PROGRAM_TYPE.ROTATE_SCALE);
        AppMethodBeat.i(82827);
        initParams();
        AppMethodBeat.o(82827);
    }

    public void updateParams(float f, float f2, float f3, PointF pointF, PointF pointF2, PointF pointF3) {
        AppMethodBeat.i(82828);
        addParam(new f("texScale", f));
        addParam(new f("texRotate", f2));
        addParam(new b("translate", pointF2.x, pointF2.y));
        addParam(new b("anchor", pointF.x, pointF.y));
        addParam(new f("alpha", f3));
        addParam(new b("canvasSize", pointF3.x, pointF3.y));
        AppMethodBeat.o(82828);
    }

    public void initParams() {
        AppMethodBeat.i(82829);
        updateParams(1.0f, 0.0f, 1.0f, new PointF(), new PointF(), new PointF(1.0f, 1.0f));
        AppMethodBeat.o(82829);
    }
}
