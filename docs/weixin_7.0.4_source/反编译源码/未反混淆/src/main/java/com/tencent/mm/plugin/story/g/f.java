package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
public final class f {
    public static final f sbT = new f();

    static {
        AppMethodBeat.i(109818);
        AppMethodBeat.o(109818);
    }

    private f() {
    }

    public static void lF(boolean z) {
        AppMethodBeat.i(109809);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(z)));
        h.pYm.k(1005, 101, 1);
        if (z) {
            h.pYm.k(1005, 102, 1);
            AppMethodBeat.o(109809);
            return;
        }
        h.pYm.k(1005, 103, 1);
        AppMethodBeat.o(109809);
    }

    public static void lG(boolean z) {
        AppMethodBeat.i(109810);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(z)));
        h.pYm.k(1005, 1, 1);
        if (z) {
            h.pYm.k(1005, 2, 1);
            AppMethodBeat.o(109810);
            return;
        }
        h.pYm.k(1005, 3, 1);
        AppMethodBeat.o(109810);
    }

    public static void lH(boolean z) {
        AppMethodBeat.i(109811);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
        h.pYm.k(1005, 11, 1);
        if (z) {
            h.pYm.k(1005, 12, 1);
            AppMethodBeat.o(109811);
            return;
        }
        h.pYm.k(1005, 13, 1);
        AppMethodBeat.o(109811);
    }

    public static void lI(boolean z) {
        AppMethodBeat.i(109812);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
        h.pYm.k(1005, 21, 1);
        if (z) {
            h.pYm.k(1005, 22, 1);
            AppMethodBeat.o(109812);
            return;
        }
        h.pYm.k(1005, 23, 1);
        AppMethodBeat.o(109812);
    }

    public static void f(boolean z, long j) {
        AppMethodBeat.i(109813);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + z + ", time:" + j);
        h.pYm.k(1005, 31, j);
        if (z) {
            h.pYm.k(1005, 32, j);
            AppMethodBeat.o(109813);
            return;
        }
        h.pYm.k(1005, 33, j);
        AppMethodBeat.o(109813);
    }

    public static void ai(int i, boolean z) {
        AppMethodBeat.i(109814);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + i + ", isCaptureVideo:" + z);
        h.pYm.k(1005, 41, 1);
        if (i <= 1) {
            if (z) {
                h.pYm.k(1005, 42, 1);
                AppMethodBeat.o(109814);
                return;
            }
            h.pYm.k(1005, 43, 1);
            AppMethodBeat.o(109814);
        } else if (i != 2) {
            if (i == 3) {
                if (z) {
                    h.pYm.k(1005, 48, 1);
                    AppMethodBeat.o(109814);
                    return;
                }
                h.pYm.k(1005, 49, 1);
            }
            AppMethodBeat.o(109814);
        } else if (z) {
            h.pYm.k(1005, 45, 1);
            AppMethodBeat.o(109814);
        } else {
            h.pYm.k(1005, 46, 1);
            AppMethodBeat.o(109814);
        }
    }

    public static void lJ(boolean z) {
        AppMethodBeat.i(109815);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
        if (z) {
            h.pYm.k(1005, 5, 1);
            AppMethodBeat.o(109815);
            return;
        }
        h.pYm.k(1005, 6, 1);
        AppMethodBeat.o(109815);
    }

    public static void cAh() {
        AppMethodBeat.i(109816);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
        h.pYm.k(1005, 8, 1);
        AppMethodBeat.o(109816);
    }

    public static void cAi() {
        AppMethodBeat.i(109817);
        ab.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
        h.pYm.k(1005, 107, 1);
        AppMethodBeat.o(109817);
    }
}
