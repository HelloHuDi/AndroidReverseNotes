package com.tencent.p177mm.plugin.story.p531g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.f */
public final class C39877f {
    public static final C39877f sbT = new C39877f();

    static {
        AppMethodBeat.m2504i(109818);
        AppMethodBeat.m2505o(109818);
    }

    private C39877f() {
    }

    /* renamed from: lF */
    public static void m68290lF(boolean z) {
        AppMethodBeat.m2504i(109809);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(z)));
        C7060h.pYm.mo15419k(1005, 101, 1);
        if (z) {
            C7060h.pYm.mo15419k(1005, 102, 1);
            AppMethodBeat.m2505o(109809);
            return;
        }
        C7060h.pYm.mo15419k(1005, 103, 1);
        AppMethodBeat.m2505o(109809);
    }

    /* renamed from: lG */
    public static void m68291lG(boolean z) {
        AppMethodBeat.m2504i(109810);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(z)));
        C7060h.pYm.mo15419k(1005, 1, 1);
        if (z) {
            C7060h.pYm.mo15419k(1005, 2, 1);
            AppMethodBeat.m2505o(109810);
            return;
        }
        C7060h.pYm.mo15419k(1005, 3, 1);
        AppMethodBeat.m2505o(109810);
    }

    /* renamed from: lH */
    public static void m68292lH(boolean z) {
        AppMethodBeat.m2504i(109811);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
        C7060h.pYm.mo15419k(1005, 11, 1);
        if (z) {
            C7060h.pYm.mo15419k(1005, 12, 1);
            AppMethodBeat.m2505o(109811);
            return;
        }
        C7060h.pYm.mo15419k(1005, 13, 1);
        AppMethodBeat.m2505o(109811);
    }

    /* renamed from: lI */
    public static void m68293lI(boolean z) {
        AppMethodBeat.m2504i(109812);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
        C7060h.pYm.mo15419k(1005, 21, 1);
        if (z) {
            C7060h.pYm.mo15419k(1005, 22, 1);
            AppMethodBeat.m2505o(109812);
            return;
        }
        C7060h.pYm.mo15419k(1005, 23, 1);
        AppMethodBeat.m2505o(109812);
    }

    /* renamed from: f */
    public static void m68289f(boolean z, long j) {
        AppMethodBeat.m2504i(109813);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + z + ", time:" + j);
        C7060h.pYm.mo15419k(1005, 31, j);
        if (z) {
            C7060h.pYm.mo15419k(1005, 32, j);
            AppMethodBeat.m2505o(109813);
            return;
        }
        C7060h.pYm.mo15419k(1005, 33, j);
        AppMethodBeat.m2505o(109813);
    }

    /* renamed from: ai */
    public static void m68288ai(int i, boolean z) {
        AppMethodBeat.m2504i(109814);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + i + ", isCaptureVideo:" + z);
        C7060h.pYm.mo15419k(1005, 41, 1);
        if (i <= 1) {
            if (z) {
                C7060h.pYm.mo15419k(1005, 42, 1);
                AppMethodBeat.m2505o(109814);
                return;
            }
            C7060h.pYm.mo15419k(1005, 43, 1);
            AppMethodBeat.m2505o(109814);
        } else if (i != 2) {
            if (i == 3) {
                if (z) {
                    C7060h.pYm.mo15419k(1005, 48, 1);
                    AppMethodBeat.m2505o(109814);
                    return;
                }
                C7060h.pYm.mo15419k(1005, 49, 1);
            }
            AppMethodBeat.m2505o(109814);
        } else if (z) {
            C7060h.pYm.mo15419k(1005, 45, 1);
            AppMethodBeat.m2505o(109814);
        } else {
            C7060h.pYm.mo15419k(1005, 46, 1);
            AppMethodBeat.m2505o(109814);
        }
    }

    /* renamed from: lJ */
    public static void m68294lJ(boolean z) {
        AppMethodBeat.m2504i(109815);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
        if (z) {
            C7060h.pYm.mo15419k(1005, 5, 1);
            AppMethodBeat.m2505o(109815);
            return;
        }
        C7060h.pYm.mo15419k(1005, 6, 1);
        AppMethodBeat.m2505o(109815);
    }

    public static void cAh() {
        AppMethodBeat.m2504i(109816);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
        C7060h.pYm.mo15419k(1005, 8, 1);
        AppMethodBeat.m2505o(109816);
    }

    public static void cAi() {
        AppMethodBeat.m2504i(109817);
        C4990ab.m7416i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
        C7060h.pYm.mo15419k(1005, 107, 1);
        AppMethodBeat.m2505o(109817);
    }
}
