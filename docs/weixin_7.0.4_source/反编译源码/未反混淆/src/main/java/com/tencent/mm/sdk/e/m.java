package com.tencent.mm.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public String ctq;
    public int hsh;
    public Object obj;
    public k xDr;

    public m() {
        this.ctq = null;
        this.xDr = null;
        this.hsh = -1;
        this.obj = null;
    }

    public m(String str) {
        this.ctq = str;
        this.xDr = null;
        this.hsh = -1;
        this.obj = null;
    }

    public final String toString() {
        AppMethodBeat.i(52518);
        String str = "MStorageEventData [event=" + this.ctq + ", eventId=" + this.hsh + ", stg=" + this.xDr + ", obj=" + this.obj + "]";
        AppMethodBeat.o(52518);
        return str;
    }
}
