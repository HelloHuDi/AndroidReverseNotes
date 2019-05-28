package com.tencent.p177mm.opensdk.diffdev.p1214a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.g */
public enum C18748g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    private int code;

    static {
        AppMethodBeat.m2505o(128050);
    }

    private C18748g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        AppMethodBeat.m2504i(128049);
        String str = "UUIDStatusCode:" + this.code;
        AppMethodBeat.m2505o(128049);
        return str;
    }
}
