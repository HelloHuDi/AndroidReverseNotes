package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class MultiViewerItem {
    public Set<Integer> activeParts = new HashSet();
    public boolean needOriginFrame = true;
    public int renderId;
    public VideoMaterial videoMaterial;

    public MultiViewerItem() {
        AppMethodBeat.i(83509);
        AppMethodBeat.o(83509);
    }
}
