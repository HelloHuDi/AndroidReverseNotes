package com.tencent.p177mm.plugin.appbrand.jsapi.version;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.a */
public enum C42591a {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String hYi;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.a$a */
    public static final class C41236a extends C38369p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onUpdateStatusChange";

        private C41236a() {
        }

        public /* synthetic */ C41236a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2505o(131500);
    }

    private C42591a(String str) {
        this.hYi = str;
    }

    /* renamed from: BN */
    public static C42591a m75401BN(String str) {
        AppMethodBeat.m2504i(131499);
        for (C42591a c42591a : C42591a.values()) {
            if (c42591a.hYi.equals(str)) {
                AppMethodBeat.m2505o(131499);
                return c42591a;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid name %s", new Object[]{str}));
        AppMethodBeat.m2505o(131499);
        throw illegalArgumentException;
    }

    public final String toString() {
        return this.hYi;
    }
}
