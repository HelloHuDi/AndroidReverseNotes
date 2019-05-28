package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    LOCAL,
    REMOTE,
    DATA_DISK_CACHE,
    RESOURCE_DISK_CACHE,
    MEMORY_CACHE;

    static {
        AppMethodBeat.o(91666);
    }
}
