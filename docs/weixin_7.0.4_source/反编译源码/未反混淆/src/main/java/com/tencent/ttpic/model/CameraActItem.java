package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class CameraActItem extends FrameSourceItem {
    private h cameraFrame;

    public CameraActItem(BaseFilter baseFilter) {
        super(baseFilter);
    }

    public void init() {
    }

    public void update(h hVar, long j, List<List<PointF>> list, List<float[]> list2, int i) {
        AppMethodBeat.i(83453);
        super.update(hVar, j, list, list2, i);
        this.cameraFrame = hVar;
        AppMethodBeat.o(83453);
    }

    public void clear() {
    }

    public void reset() {
    }

    public int getOrigWidth(int i) {
        return this.cameraFrame.width;
    }

    public int getOrigHeight(int i) {
        return this.cameraFrame.height;
    }

    public int getTexture(CanvasItem canvasItem, long j) {
        return this.cameraFrame.texture[0];
    }
}
