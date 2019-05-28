package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class u extends b {
    public a csP;

    public static final class a {
        public String aIm;
        public int action;
        public String appId;
        public String ckD;
        public String clP;
        public long duration;
        public int errCode;
        public String state;
    }

    public u() {
        this((byte) 0);
    }

    private u(byte b) {
        AppMethodBeat.i(137224);
        this.csP = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(137224);
    }

    public static String gI(int i) {
        if (i == 0) {
            return "play";
        }
        if (i == 1) {
            return "play";
        }
        if (i == 2) {
            return "pause";
        }
        if (i == 3) {
            return "stop";
        }
        if (i == 4) {
            return "error";
        }
        if (i == 5) {
            return "ended";
        }
        if (i == 6) {
            return "seeked";
        }
        if (i == 7) {
            return "canplay";
        }
        if (i == 9) {
            return "waiting";
        }
        if (i == 10) {
            return "seeking";
        }
        if (i == 11) {
            return "real_play";
        }
        if (i == 12) {
            return "mix_play_ready";
        }
        return "";
    }
}
