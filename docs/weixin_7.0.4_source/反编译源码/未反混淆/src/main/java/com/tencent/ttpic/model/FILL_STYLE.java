package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FILL_STYLE {
    CUT(0),
    STRETCH(1),
    SPACE(2),
    FRAME_STYLE_CUT(3);
    
    public final int value;

    static {
        AppMethodBeat.o(50232);
    }

    private FILL_STYLE(int i) {
        this.value = i;
    }
}
