package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e {
    DEFAULT,
    DOODLE,
    TEXT,
    EMOJI,
    MOSAIC,
    CROP_PHOTO,
    CROP_VIDEO;

    static {
        AppMethodBeat.o(73801);
    }
}
