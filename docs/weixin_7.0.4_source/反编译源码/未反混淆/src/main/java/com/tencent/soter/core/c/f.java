package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f {
    public String aIm;
    public int errCode;

    public f(int i, String str) {
        this(i);
        AppMethodBeat.i(73033);
        if (!g.isNullOrNil(str)) {
            this.aIm = str;
        }
        AppMethodBeat.o(73033);
    }

    public f(int i) {
        AppMethodBeat.i(73034);
        this.errCode = i;
        switch (this.errCode) {
            case 0:
                this.aIm = "ok";
                AppMethodBeat.o(73034);
                return;
            case 2:
                this.aIm = "device not support soter";
                AppMethodBeat.o(73034);
                return;
            default:
                this.aIm = "errmsg not specified";
                AppMethodBeat.o(73034);
                return;
        }
    }

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).errCode == this.errCode;
    }

    public String toString() {
        AppMethodBeat.i(73035);
        String str = "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.o(73035);
        return str;
    }
}
