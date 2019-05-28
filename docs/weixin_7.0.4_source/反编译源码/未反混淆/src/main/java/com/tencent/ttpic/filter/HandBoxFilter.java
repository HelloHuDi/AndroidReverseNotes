package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import java.util.List;

public class HandBoxFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
    public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
    private boolean mNoPoints = true;
    float[] pointsVertex = new float[16];

    public HandBoxFilter() {
        super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
        AppMethodBeat.i(82589);
        AppMethodBeat.o(82589);
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.i(82590);
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.o(82590);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82591);
        super.ApplyGLSLFilter();
        AppMethodBeat.o(82591);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82592);
        super.clearGLSLSelf();
        AppMethodBeat.o(82592);
    }

    public void updatePoints(List<PointF> list, float f, int i, int i2) {
        AppMethodBeat.i(82593);
        if (list == null || list.size() != 9) {
            this.mNoPoints = true;
            AppMethodBeat.o(82593);
            return;
        }
        this.mNoPoints = false;
        normalizePoints(list, (int) (((float) i) * f), (int) (((float) i2) * f));
        setCoordNum(8);
        setPositions(this.pointsVertex);
        AppMethodBeat.o(82593);
    }

    public void render(int i, int i2, int i3) {
        AppMethodBeat.i(82594);
        if (!this.mNoPoints) {
            setDrawMode(DRAW_MODE.LINES);
            GLES20.glLineWidth(4.0f);
            GlUtil.setBlendMode(true);
            OnDrawFrameGLSL();
            renderTexture(i, i2, i3);
            GlUtil.setBlendMode(false);
        }
        AppMethodBeat.o(82594);
    }

    private void normalizePoints(List<PointF> list, int i, int i2) {
        AppMethodBeat.i(82595);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(82595);
            return;
        }
        this.pointsVertex[0] = ((((PointF) list.get(1)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[1] = ((((PointF) list.get(1)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[2] = ((((PointF) list.get(3)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[3] = ((((PointF) list.get(3)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[4] = ((((PointF) list.get(3)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[5] = ((((PointF) list.get(3)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[6] = ((((PointF) list.get(8)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[7] = ((((PointF) list.get(8)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[8] = ((((PointF) list.get(8)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[9] = ((((PointF) list.get(8)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[10] = ((((PointF) list.get(6)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[11] = ((((PointF) list.get(6)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[12] = ((((PointF) list.get(6)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[13] = ((((PointF) list.get(6)).y * 2.0f) / ((float) i2)) - 1.0f;
        this.pointsVertex[14] = ((((PointF) list.get(1)).x * 2.0f) / ((float) i)) - 1.0f;
        this.pointsVertex[15] = ((((PointF) list.get(1)).y * 2.0f) / ((float) i2)) - 1.0f;
        AppMethodBeat.o(82595);
    }
}
