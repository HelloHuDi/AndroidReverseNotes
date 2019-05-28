package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public enum a {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String hYi;

    public static final class a extends p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onUpdateStatusChange";

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.o(131500);
    }

    private a(String str) {
        this.hYi = str;
    }

    public static a BN(String str) {
        AppMethodBeat.i(131499);
        for (a aVar : values()) {
            if (aVar.hYi.equals(str)) {
                AppMethodBeat.o(131499);
                return aVar;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid name %s", new Object[]{str}));
        AppMethodBeat.o(131499);
        throw illegalArgumentException;
    }

    public final String toString() {
        return this.hYi;
    }
}
