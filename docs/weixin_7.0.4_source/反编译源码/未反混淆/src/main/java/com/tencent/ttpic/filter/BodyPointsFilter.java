package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import java.util.List;

public class BodyPointsFilter extends VideoFilterBase {
    private static final int BODY_POINTS_COUNT = 59;
    public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
    public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
    float[] lineVertex = new float[236];
    private boolean mNoPoints = true;
    float[] pointsVertex = new float[118];

    public BodyPointsFilter() {
        super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
        AppMethodBeat.i(82051);
        AppMethodBeat.o(82051);
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.i(82052);
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.o(82052);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82053);
        super.ApplyGLSLFilter();
        AppMethodBeat.o(82053);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82054);
        super.clearGLSLSelf();
        AppMethodBeat.o(82054);
    }

    public void updatePoints(List<PointF> list, int i, int i2) {
        AppMethodBeat.i(82055);
        if (list == null || list.size() != 59) {
            this.mNoPoints = true;
            AppMethodBeat.o(82055);
            return;
        }
        this.mNoPoints = false;
        normalizePoints(list, i, i2);
        AppMethodBeat.o(82055);
    }

    public void render(int i, int i2, int i3) {
        AppMethodBeat.i(82056);
        if (!this.mNoPoints) {
            GLES20.glLineWidth(4.0f);
            setDrawMode(DRAW_MODE.LINES);
            setCoordNum(118);
            setPositions(this.lineVertex);
            GlUtil.setBlendMode(true);
            OnDrawFrameGLSL();
            renderTexture(i, i2, i3);
            GlUtil.setBlendMode(false);
            GLES20.glLineWidth(8.0f);
            setDrawMode(DRAW_MODE.POINTS);
            setCoordNum(59);
            setPositions(this.pointsVertex);
            GlUtil.setBlendMode(true);
            OnDrawFrameGLSL();
            renderTexture(i, i2, i3);
            GlUtil.setBlendMode(false);
        }
        AppMethodBeat.o(82056);
    }

    private void normalizePoints(List<PointF> list, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(82057);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(82057);
            return;
        }
        int i4;
        for (i4 = 0; i4 < list.size() - 1; i4++) {
            this.lineVertex[(i4 * 4) + 0] = ((((PointF) list.get(i4)).x * 2.0f) / ((float) i)) - 1.0f;
            this.lineVertex[(i4 * 4) + 1] = ((((PointF) list.get(i4)).y * 2.0f) / ((float) i2)) - 1.0f;
            this.lineVertex[(i4 * 4) + 2] = ((((PointF) list.get(i4 + 1)).x * 2.0f) / ((float) i)) - 1.0f;
            this.lineVertex[(i4 * 4) + 3] = ((((PointF) list.get(i4 + 1)).y * 2.0f) / ((float) i2)) - 1.0f;
        }
        i4 = list.size() - 1;
        this.lineVertex[(i4 * 4) + 0] = ((((PointF) list.get(i4)).x * 2.0f) / ((float) i)) - 1.0f;
        this.lineVertex[(i4 * 4) + 1] = ((((PointF) list.get(i4)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.lineVertex[(i4 * 4) + 2] = ((((PointF) list.get(0)).x * 2.0f) / ((float) i)) - 1.0f;
        this.lineVertex[(i4 * 4) + 3] = ((((PointF) list.get(0)).y * 2.0f) / ((float) i2)) - 1.0f;
        while (i3 < list.size()) {
            this.pointsVertex[i3 * 2] = ((((PointF) list.get(i3)).x * 2.0f) / ((float) i)) - 1.0f;
            this.pointsVertex[(i3 * 2) + 1] = ((((PointF) list.get(i3)).y * 2.0f) / ((float) i2)) - 1.0f;
            i3++;
        }
        AppMethodBeat.o(82057);
    }
}
