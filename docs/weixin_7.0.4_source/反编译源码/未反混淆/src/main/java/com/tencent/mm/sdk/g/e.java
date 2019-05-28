package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public long iBv;
    public String name;
    public long startTime;
    public a xDX;
    public long xDY;

    public enum a {
        WAITING,
        RUNNING,
        FINISH;

        static {
            AppMethodBeat.o(52589);
        }
    }

    public e(String str) {
        this.name = str;
    }

    public final String toString() {
        AppMethodBeat.i(52590);
        String str = this.name + " " + this.xDX + " " + this.xDY + " " + this.startTime + " " + this.iBv;
        AppMethodBeat.o(52590);
        return str;
    }
}
