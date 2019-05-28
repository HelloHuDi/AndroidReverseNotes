package com.tencent.p177mm.plugin.appbrand.p332t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;

/* renamed from: com.tencent.mm.plugin.appbrand.t.a */
public interface C33526a {

    /* renamed from: com.tencent.mm.plugin.appbrand.t.a$b */
    public enum C19740b {
        CLIENT,
        SERVER;

        static {
            AppMethodBeat.m2505o(73206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.t.a$a */
    public enum C27300a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        static {
            AppMethodBeat.m2505o(73203);
        }
    }

    /* renamed from: b */
    void mo54002b(C33533d c33533d);
}
