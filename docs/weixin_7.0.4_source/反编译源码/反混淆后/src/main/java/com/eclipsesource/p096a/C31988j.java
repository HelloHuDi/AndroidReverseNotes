package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.eclipsesource.a.j */
public final class C31988j extends RuntimeException {
    private final int column;
    private final int line;
    private final int offset;

    C31988j(String str, int i, int i2, int i3) {
        super(str + " at " + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3);
        AppMethodBeat.m2504i(70596);
        this.offset = i;
        this.line = i2;
        this.column = i3;
        AppMethodBeat.m2505o(70596);
    }
}
