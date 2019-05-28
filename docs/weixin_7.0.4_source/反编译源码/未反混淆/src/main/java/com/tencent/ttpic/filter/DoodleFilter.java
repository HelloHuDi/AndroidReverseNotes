package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class DoodleFilter extends VideoFilterBase {
    private List<List<PointF>> list = new ArrayList();

    public DoodleFilter() {
        super(PROGRAM_TYPE.DOODLE);
        AppMethodBeat.i(82154);
        AppMethodBeat.o(82154);
    }

    public void setTouchPoints(List<List<PointF>> list, List<List<PointF>> list2, int i, int i2, float f) {
        AppMethodBeat.i(82155);
        if (list == null || list.size() == 0) {
            this.list.clear();
            AppMethodBeat.o(82155);
            return;
        }
        this.list = new ArrayList(list2.size());
        PointF pointF = (PointF) ((List) list.get(0)).get(86);
        for (List<PointF> list3 : list2) {
            ArrayList arrayList = new ArrayList();
            for (PointF pointF2 : list3) {
                arrayList.add(new PointF((((pointF2.x + (pointF.x / f)) / ((float) i)) * 2.0f) - 1.0f, -((((pointF2.y + (pointF.y / f)) / ((float) i2)) * 2.0f) - 1.0f)));
            }
            this.list.add(arrayList);
        }
        AppMethodBeat.o(82155);
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.i(82156);
        setPositions(null);
        AppMethodBeat.o(82156);
    }

    public void renderProcess() {
        AppMethodBeat.i(82157);
        for (List list : this.list) {
            setPositions(VideoMaterialUtil.toFlatArray(list));
            OnDrawFrameGLSL();
            GLES20.glLineWidth(10.0f);
            GLES20.glDrawArrays(3, 0, list.size());
        }
        GLES20.glFlush();
        AppMethodBeat.o(82157);
    }
}
