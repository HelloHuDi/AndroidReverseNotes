package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    private int code;

    static {
        AppMethodBeat.o(128050);
    }

    private g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        AppMethodBeat.i(128049);
        String str = "UUIDStatusCode:" + this.code;
        AppMethodBeat.o(128049);
        return str;
    }
}
