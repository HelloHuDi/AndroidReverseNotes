package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum HttpMethod {
    GET,
    POST,
    DELETE;

    static {
        AppMethodBeat.o(71773);
    }
}
