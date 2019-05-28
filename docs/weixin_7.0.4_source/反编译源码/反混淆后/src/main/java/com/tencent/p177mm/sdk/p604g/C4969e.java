package com.tencent.p177mm.sdk.p604g;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.g.e */
public final class C4969e {
    public long iBv;
    public String name;
    public long startTime;
    public C4968a xDX;
    public long xDY;

    /* renamed from: com.tencent.mm.sdk.g.e$a */
    public enum C4968a {
        WAITING,
        RUNNING,
        FINISH;

        static {
            AppMethodBeat.m2505o(52589);
        }
    }

    public C4969e(String str) {
        this.name = str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(52590);
        String str = this.name + " " + this.xDX + " " + this.xDY + " " + this.startTime + " " + this.iBv;
        AppMethodBeat.m2505o(52590);
        return str;
    }
}
