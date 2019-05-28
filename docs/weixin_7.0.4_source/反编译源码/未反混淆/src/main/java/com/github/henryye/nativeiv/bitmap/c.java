package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    JPG,
    PNG,
    BMP,
    GIF,
    WEBP,
    UNKNOWN;

    static {
        AppMethodBeat.o(115760);
    }
}
