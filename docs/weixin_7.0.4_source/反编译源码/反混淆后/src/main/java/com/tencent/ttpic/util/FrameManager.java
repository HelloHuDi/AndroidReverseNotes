package com.tencent.ttpic.util;

import android.util.SparseArray;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FrameManager {
    private static FrameManager instance = new FrameManager();
    public SparseArray<C41672h> frameSparseArray = new SparseArray();

    static {
        AppMethodBeat.m2504i(83917);
        AppMethodBeat.m2505o(83917);
    }

    public static FrameManager getInstance() {
        return instance;
    }

    private FrameManager() {
        AppMethodBeat.m2504i(83915);
        AppMethodBeat.m2505o(83915);
    }

    public C41672h getFrameByTex(int i) {
        AppMethodBeat.m2504i(83916);
        C41672h c41672h = (C41672h) this.frameSparseArray.get(i);
        if (c41672h == null) {
            c41672h = new C41672h();
            this.frameSparseArray.put(i, c41672h);
        }
        AppMethodBeat.m2505o(83916);
        return c41672h;
    }
}
