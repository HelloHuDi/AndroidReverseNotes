package com.tencent.p177mm.plugin.appbrand.jsapi.p309j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j.C33839a;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.e */
public final class C41234e extends C38369p {
    public static final int CTRL_INDEX = 520;
    public static final String NAME = "onVoIPChatInterrupted";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.e$a */
    class C2297a {
        int errCode;
        String hTq;

        public C2297a(String str, int i) {
            this.hTq = str;
            this.errCode = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.e$1 */
    static /* synthetic */ class C333311 {
        static final /* synthetic */ int[] hTp = new int[C33839a.values().length];

        static {
            AppMethodBeat.m2504i(131400);
            try {
                hTp[C33839a.kBe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hTp[C33839a.kBf.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hTp[C33839a.kBg.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hTp[C33839a.kBh.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                hTp[C33839a.kBi.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                hTp[C33839a.kBj.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                hTp[C33839a.kBk.ordinal()] = 7;
                AppMethodBeat.m2505o(131400);
            } catch (NoSuchFieldError e7) {
                AppMethodBeat.m2505o(131400);
            }
        }
    }
}
