package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class GridSettingModel {
    public Rect canvasRect = new Rect();
    public List<GridModel> canvasRectList = new ArrayList();

    public GridSettingModel() {
        AppMethodBeat.i(83498);
        AppMethodBeat.o(83498);
    }
}
