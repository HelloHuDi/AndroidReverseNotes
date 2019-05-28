package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.u */
public final class C18405u extends C4883b {
    public C18406a csP;

    /* renamed from: com.tencent.mm.g.a.u$a */
    public static final class C18406a {
        public String aIm;
        public int action;
        public String appId;
        public String ckD;
        public String clP;
        public long duration;
        public int errCode;
        public String state;
    }

    public C18405u() {
        this((byte) 0);
    }

    private C18405u(byte b) {
        AppMethodBeat.m2504i(137224);
        this.csP = new C18406a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(137224);
    }

    /* renamed from: gI */
    public static String m28656gI(int i) {
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
