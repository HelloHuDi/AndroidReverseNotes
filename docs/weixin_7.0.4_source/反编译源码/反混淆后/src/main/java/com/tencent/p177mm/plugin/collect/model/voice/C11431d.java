package com.tencent.p177mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.collect.model.voice.d */
public final class C11431d {
    public C38809b kDp;

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.d$a */
    static class C11432a {
        static C11431d kDq = new C11431d();

        static {
            AppMethodBeat.m2504i(41031);
            AppMethodBeat.m2505o(41031);
        }
    }

    /* synthetic */ C11431d(byte b) {
        this();
    }

    private C11431d() {
        AppMethodBeat.m2504i(41032);
        this.kDp = new C38809b();
        AppMethodBeat.m2505o(41032);
    }

    public final int setVolume(float f) {
        this.kDp.mVolume = f;
        return 0;
    }

    /* renamed from: aA */
    public final int mo23172aA(float f) {
        this.kDp.f16164JN = f;
        return 0;
    }

    public final int start(String str) {
        AppMethodBeat.m2504i(41033);
        int start = this.kDp.start(str);
        AppMethodBeat.m2505o(41033);
        return start;
    }
}
