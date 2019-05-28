package com.tencent.p177mm.sdk.p603e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.e.m */
public final class C4935m {
    public String ctq;
    public int hsh;
    public Object obj;
    public C7296k xDr;

    public C4935m() {
        this.ctq = null;
        this.xDr = null;
        this.hsh = -1;
        this.obj = null;
    }

    public C4935m(String str) {
        this.ctq = str;
        this.xDr = null;
        this.hsh = -1;
        this.obj = null;
    }

    public final String toString() {
        AppMethodBeat.m2504i(52518);
        String str = "MStorageEventData [event=" + this.ctq + ", eventId=" + this.hsh + ", stg=" + this.xDr + ", obj=" + this.obj + "]";
        AppMethodBeat.m2505o(52518);
        return str;
    }
}
