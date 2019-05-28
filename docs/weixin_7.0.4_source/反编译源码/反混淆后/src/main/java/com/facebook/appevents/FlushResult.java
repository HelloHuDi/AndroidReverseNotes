package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FlushResult {
    SUCCESS,
    SERVER_ERROR,
    NO_CONNECTIVITY,
    UNKNOWN_ERROR;

    static {
        AppMethodBeat.m2505o(72009);
    }
}
