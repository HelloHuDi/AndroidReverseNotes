package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.a;
import com.tencent.filter.m.b;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");

    static {
        AppMethodBeat.i(82442);
        AppMethodBeat.o(82442);
    }

    public FacePointsFilter() {
        super(FRAGMENT_SHADER);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82435);
        addParam(new b("canvasSize", (float) i, (float) i2));
        addParam(new b("faceDetectImageSize", (float) (((double) i) * d), (float) (((double) i2) * d)));
        AppMethodBeat.o(82435);
    }

    public void updatePoints(float[] fArr) {
        AppMethodBeat.i(82436);
        if (fArr != null) {
            addParam(new a("facePoints", fArr));
        }
        AppMethodBeat.o(82436);
    }

    public void updatePointColor(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(82437);
        addParam(new e("pointColor", f, f2, f3, f4));
        AppMethodBeat.o(82437);
    }

    public void updatePointSize(float f) {
        AppMethodBeat.i(82438);
        addParam(new f("pointSize", f));
        AppMethodBeat.o(82438);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82439);
        addParam(new b("canvasSize", 0.0f, 0.0f));
        addParam(new b("faceDetectImageSize", 0.0f, 0.0f));
        addParam(new a("facePoints", new float[0]));
        addParam(new e("pointColor", 1.0f, 0.0f, 0.0f, 1.0f));
        addParam(new f("pointSize", 3.0f));
        super.ApplyGLSLFilter();
        AppMethodBeat.o(82439);
    }

    public void updatePoints(List<PointF> list) {
        AppMethodBeat.i(82440);
        updatePoints(VideoMaterialUtil.toFlatArray((List) list));
        AppMethodBeat.o(82440);
    }

    public void updateMultiPoints(List<List<PointF>> list) {
        AppMethodBeat.i(82441);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(82441);
            return;
        }
        updatePoints(VideoMaterialUtil.toFlatArray((List) list.get(0)));
        AppMethodBeat.o(82441);
    }
}
