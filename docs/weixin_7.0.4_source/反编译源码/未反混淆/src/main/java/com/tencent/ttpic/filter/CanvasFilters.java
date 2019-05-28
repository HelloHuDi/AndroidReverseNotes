package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ttpic.fabby.FabbyUtil.TRANSFORM_TYPE;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.util.AlgoUtils;

public class CanvasFilters {
    private BaseFilter mDrawFilter = new BaseFilter(GLSLRender.bJB);

    public CanvasFilters() {
        AppMethodBeat.i(82068);
        AppMethodBeat.o(82068);
    }

    public RenderParam drawOnFrame(GridModel gridModel, h hVar, int i, int i2) {
        AppMethodBeat.i(82069);
        if (gridModel == null || gridModel.canvasRect == null) {
            AppMethodBeat.o(82069);
            return null;
        }
        RenderParam renderParam = new RenderParam();
        renderParam.texture = hVar.texture[0];
        renderParam.texCords = calculateTexPosTriangles(gridModel, i, i2, gridModel.canvasRect.width, gridModel.canvasRect.height, hVar.width, hVar.height);
        renderParam.position = calculateVerPosTriangles(gridModel, i, i2, ((float) hVar.width) / ((float) hVar.height));
        renderParam.texScale = 1.0f;
        AppMethodBeat.o(82069);
        return renderParam;
    }

    private float[] calculateVerPosTriangles(GridModel gridModel, int i, int i2, float f) {
        float[] calPositionsTriangles;
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(82070);
        float f6 = ((float) i) / ((float) i2);
        if (((double) Math.abs(f6 - f)) < 1.0E-4d || gridModel.positionMode == 0) {
            calPositionsTriangles = AlgoUtils.calPositionsTriangles((float) gridModel.canvasRect.x, (float) gridModel.canvasRect.y, (float) (gridModel.canvasRect.x + gridModel.canvasRect.width), (float) (gridModel.canvasRect.y + gridModel.canvasRect.height), i, i2);
        } else if (f6 > f) {
            f2 = ((float) i2) * f;
            f6 = ((float) gridModel.canvasRect.x) - ((((float) i) - f2) / 2.0f);
            f3 = (float) gridModel.canvasRect.y;
            calPositionsTriangles = AlgoUtils.calPositionsTriangles(f6, f3, ((float) gridModel.canvasRect.width) + f6, ((float) gridModel.canvasRect.height) + f3, (int) f2, i2);
        } else {
            f2 = ((float) i) / f;
            f6 = (float) gridModel.canvasRect.x;
            f3 = ((float) gridModel.canvasRect.y) - ((((float) i2) - f2) / 2.0f);
            calPositionsTriangles = AlgoUtils.calPositionsTriangles(f6, f3, ((float) gridModel.canvasRect.width) + f6, ((float) gridModel.canvasRect.height) + f3, i, (int) f2);
        }
        if (BitUtils.checkBit(gridModel.transformType, TRANSFORM_TYPE.MIRROR_TOP_BOTTOM.value)) {
            f3 = calPositionsTriangles[0];
            f4 = calPositionsTriangles[1];
            f5 = calPositionsTriangles[3];
            f2 = calPositionsTriangles[4];
            calPositionsTriangles = new float[]{f3, f5, f3, f4, f2, f4, f3, f5, f2, f4, f2, f5};
        }
        if (BitUtils.checkBit(gridModel.transformType, TRANSFORM_TYPE.MIRROR_LEFT_RIGHT.value)) {
            f3 = calPositionsTriangles[0];
            f4 = calPositionsTriangles[1];
            f5 = calPositionsTriangles[3];
            f2 = calPositionsTriangles[4];
            calPositionsTriangles = new float[]{f2, f4, f2, f5, f3, f5, f2, f4, f3, f5, f3, f4};
        }
        AppMethodBeat.o(82070);
        return calPositionsTriangles;
    }

    private float[] calculateTexPosTriangles(GridModel gridModel, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(82071);
        if (gridModel.positionMode == 0) {
            i3 = (i3 * i5) / i;
            i4 = (i4 * i6) / i2;
        }
        float[] fArr;
        if (gridModel.aspectMode == 1) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
            AppMethodBeat.o(82071);
            return fArr;
        }
        float f = ((float) i5) / ((float) i6);
        float f2;
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        if (((float) i3) / ((float) i4) > f) {
            f2 = ((float) i3) / f;
            pointF = new PointF(0.0f, 0.5f + ((0.5f * ((float) i4)) / f2));
            pointF2 = new PointF(0.0f, 0.5f - ((0.5f * ((float) i4)) / f2));
            pointF3 = new PointF(1.0f, 0.5f - ((0.5f * ((float) i4)) / f2));
            pointF4 = new PointF(1.0f, ((0.5f * ((float) i4)) / f2) + 0.5f);
            fArr = new float[]{pointF2.x, pointF2.y, pointF.x, pointF.y, pointF4.x, pointF4.y, pointF2.x, pointF2.y, pointF4.x, pointF4.y, pointF3.x, pointF3.y};
            AppMethodBeat.o(82071);
            return fArr;
        }
        f2 = ((float) i4) * f;
        pointF = new PointF(0.5f - ((0.5f * ((float) i3)) / f2), 1.0f);
        pointF2 = new PointF(0.5f - ((0.5f * ((float) i3)) / f2), 0.0f);
        pointF3 = new PointF(0.5f + ((0.5f * ((float) i3)) / f2), 0.0f);
        pointF4 = new PointF(((0.5f * ((float) i3)) / f2) + 0.5f, 1.0f);
        fArr = new float[]{pointF2.x, pointF2.y, pointF.x, pointF.y, pointF4.x, pointF4.y, pointF2.x, pointF2.y, pointF4.x, pointF4.y, pointF3.x, pointF3.y};
        AppMethodBeat.o(82071);
        return fArr;
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82072);
        this.mDrawFilter.clearGLSLSelf();
        AppMethodBeat.o(82072);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82073);
        this.mDrawFilter.setRenderMode(i);
        AppMethodBeat.o(82073);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82074);
        this.mDrawFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82074);
    }
}
