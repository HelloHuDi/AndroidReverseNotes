package com.tencent.ttpic.constant;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CATEGORY_TYPE {
    NORMAL(0),
    EMOJI(1);
    
    public final int value;

    static {
        AppMethodBeat.o(81861);
    }

    private CATEGORY_TYPE(int i) {
        this.value = i;
    }
}
