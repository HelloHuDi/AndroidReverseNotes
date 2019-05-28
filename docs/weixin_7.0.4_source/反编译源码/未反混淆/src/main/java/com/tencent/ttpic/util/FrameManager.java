package com.tencent.ttpic.util;

import android.util.SparseArray;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FrameManager {
    private static FrameManager instance = new FrameManager();
    public SparseArray<h> frameSparseArray = new SparseArray();

    static {
        AppMethodBeat.i(83917);
        AppMethodBeat.o(83917);
    }

    public static FrameManager getInstance() {
        return instance;
    }

    private FrameManager() {
        AppMethodBeat.i(83915);
        AppMethodBeat.o(83915);
    }

    public h getFrameByTex(int i) {
        AppMethodBeat.i(83916);
        h hVar = (h) this.frameSparseArray.get(i);
        if (hVar == null) {
            hVar = new h();
            this.frameSparseArray.put(i, hVar);
        }
        AppMethodBeat.o(83916);
        return hVar;
    }
}
