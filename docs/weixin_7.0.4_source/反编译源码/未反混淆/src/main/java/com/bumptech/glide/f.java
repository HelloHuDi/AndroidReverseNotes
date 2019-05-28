package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float awF;

    static {
        AppMethodBeat.o(91617);
    }

    private f(float f) {
        this.awF = f;
    }
}
