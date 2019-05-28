package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    OPTIONS,
    TRACE,
    PATCH;

    static {
        AppMethodBeat.o(77245);
    }
}
