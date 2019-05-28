package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class j extends RuntimeException {
    private final int column;
    private final int line;
    private final int offset;

    j(String str, int i, int i2, int i3) {
        super(str + " at " + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3);
        AppMethodBeat.i(70596);
        this.offset = i;
        this.line = i2;
        this.column = i3;
        AppMethodBeat.o(70596);
    }
}
