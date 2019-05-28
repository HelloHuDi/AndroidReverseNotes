package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public final class e extends p {
    public static final int CTRL_INDEX = 520;
    public static final String NAME = "onVoIPChatInterrupted";

    class a {
        int errCode;
        String hTq;

        public a(String str, int i) {
            this.hTq = str;
            this.errCode = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] hTp = new int[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.values().length];

        static {
            AppMethodBeat.i(131400);
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBf.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBg.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBh.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBi.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBj.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                hTp[com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBk.ordinal()] = 7;
                AppMethodBeat.o(131400);
            } catch (NoSuchFieldError e7) {
                AppMethodBeat.o(131400);
            }
        }
    }
}
