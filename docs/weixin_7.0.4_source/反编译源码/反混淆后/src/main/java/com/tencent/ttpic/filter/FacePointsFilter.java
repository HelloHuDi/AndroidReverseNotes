package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25625a;
import com.tencent.filter.C25624m.C25629b;
import com.tencent.filter.C25624m.C25633e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");

    static {
        AppMethodBeat.m2504i(82442);
        AppMethodBeat.m2505o(82442);
    }

    public FacePointsFilter() {
        super(FRAGMENT_SHADER);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82435);
        addParam(new C25629b("canvasSize", (float) i, (float) i2));
        addParam(new C25629b("faceDetectImageSize", (float) (((double) i) * d), (float) (((double) i2) * d)));
        AppMethodBeat.m2505o(82435);
    }

    public void updatePoints(float[] fArr) {
        AppMethodBeat.m2504i(82436);
        if (fArr != null) {
            addParam(new C25625a("facePoints", fArr));
        }
        AppMethodBeat.m2505o(82436);
    }

    public void updatePointColor(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(82437);
        addParam(new C25633e("pointColor", f, f2, f3, f4));
        AppMethodBeat.m2505o(82437);
    }

    public void updatePointSize(float f) {
        AppMethodBeat.m2504i(82438);
        addParam(new C0933f("pointSize", f));
        AppMethodBeat.m2505o(82438);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82439);
        addParam(new C25629b("canvasSize", 0.0f, 0.0f));
        addParam(new C25629b("faceDetectImageSize", 0.0f, 0.0f));
        addParam(new C25625a("facePoints", new float[0]));
        addParam(new C25633e("pointColor", 1.0f, 0.0f, 0.0f, 1.0f));
        addParam(new C0933f("pointSize", 3.0f));
        super.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82439);
    }

    public void updatePoints(List<PointF> list) {
        AppMethodBeat.m2504i(82440);
        updatePoints(VideoMaterialUtil.toFlatArray((List) list));
        AppMethodBeat.m2505o(82440);
    }

    public void updateMultiPoints(List<List<PointF>> list) {
        AppMethodBeat.m2504i(82441);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.m2505o(82441);
            return;
        }
        updatePoints(VideoMaterialUtil.toFlatArray((List) list.get(0)));
        AppMethodBeat.m2505o(82441);
    }
}
