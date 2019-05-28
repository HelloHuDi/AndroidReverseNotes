package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public b kDp;

    static class a {
        static d kDq = new d();

        static {
            AppMethodBeat.i(41031);
            AppMethodBeat.o(41031);
        }
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        AppMethodBeat.i(41032);
        this.kDp = new b();
        AppMethodBeat.o(41032);
    }

    public final int setVolume(float f) {
        this.kDp.mVolume = f;
        return 0;
    }

    public final int aA(float f) {
        this.kDp.JN = f;
        return 0;
    }

    public final int start(String str) {
        AppMethodBeat.i(41033);
        int start = this.kDp.start(str);
        AppMethodBeat.o(41033);
        return start;
    }
}
