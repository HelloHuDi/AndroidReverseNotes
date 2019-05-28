package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;

public class DislocationFilter extends BaseFilter {
    private List<Pair<RectF, PointF>> mDislocationRects = new ArrayList();

    public DislocationFilter() {
        super(GLSLRender.bJB);
        AppMethodBeat.m2504i(82151);
        AppMethodBeat.m2505o(82151);
    }

    public void addLocation(float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.m2504i(82152);
        this.mDislocationRects.add(new Pair(new RectF(f, f2, f3, f4), new PointF(f5, f6)));
        AppMethodBeat.m2505o(82152);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82153);
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        setTexCords(GlUtil.ORIGIN_TEX_COORDS);
        boolean renderTexture = super.renderTexture(i, i2, i3);
        for (Pair pair : this.mDislocationRects) {
            float[] calPositions = AlgoUtils.calPositions(Math.min(Math.max(((PointF) pair.second).x + ((RectF) pair.first).left, 0.0f), 1.0f), Math.min(Math.max(((PointF) pair.second).y + ((RectF) pair.first).top, 0.0f), 1.0f), Math.min(Math.max(((PointF) pair.second).x + ((RectF) pair.first).right, 0.0f), 1.0f), Math.min(Math.max(((PointF) pair.second).y + ((RectF) pair.first).bottom, 0.0f), 1.0f), 1, 1);
            float[] fArr = new float[calPositions.length];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= calPositions.length / 2) {
                    break;
                }
                fArr[i5 * 2] = ((calPositions[i5 * 2] + 1.0f) / 2.0f) - ((PointF) pair.second).x;
                fArr[(i5 * 2) + 1] = ((calPositions[(i5 * 2) + 1] + 1.0f) / 2.0f) - ((PointF) pair.second).y;
                i4 = i5 + 1;
            }
            setPositions(calPositions);
            setTexCords(fArr);
            super.renderTexture(i, i2, i3);
        }
        AppMethodBeat.m2505o(82153);
        return renderTexture;
    }
}
