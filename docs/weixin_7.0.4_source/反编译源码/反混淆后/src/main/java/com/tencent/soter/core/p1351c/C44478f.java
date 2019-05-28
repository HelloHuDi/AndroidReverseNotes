package com.tencent.soter.core.p1351c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.soter.core.c.f */
public class C44478f {
    public String aIm;
    public int errCode;

    public C44478f(int i, String str) {
        this(i);
        AppMethodBeat.m2504i(73033);
        if (!C24321g.isNullOrNil(str)) {
            this.aIm = str;
        }
        AppMethodBeat.m2505o(73033);
    }

    public C44478f(int i) {
        AppMethodBeat.m2504i(73034);
        this.errCode = i;
        switch (this.errCode) {
            case 0:
                this.aIm = "ok";
                AppMethodBeat.m2505o(73034);
                return;
            case 2:
                this.aIm = "device not support soter";
                AppMethodBeat.m2505o(73034);
                return;
            default:
                this.aIm = "errmsg not specified";
                AppMethodBeat.m2505o(73034);
                return;
        }
    }

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C44478f) && ((C44478f) obj).errCode == this.errCode;
    }

    public String toString() {
        AppMethodBeat.m2504i(73035);
        String str = "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.m2505o(73035);
        return str;
    }
}
