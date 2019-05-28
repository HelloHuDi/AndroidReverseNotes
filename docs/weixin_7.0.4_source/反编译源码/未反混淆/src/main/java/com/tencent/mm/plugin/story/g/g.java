package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-story_release"})
public final class g {
    public static final g sbU = new g();

    static {
        AppMethodBeat.i(109823);
        AppMethodBeat.o(109823);
    }

    private g() {
    }

    public static void lK(boolean z) {
        AppMethodBeat.i(109819);
        ab.i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(z)));
        if (z) {
            h.pYm.k(986, 5, 1);
            AppMethodBeat.o(109819);
            return;
        }
        h.pYm.k(986, 6, 1);
        AppMethodBeat.o(109819);
    }

    public static void cAj() {
        AppMethodBeat.i(109820);
        ab.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
        h.pYm.k(986, 9, 1);
        AppMethodBeat.o(109820);
    }

    public static void h(boolean z, int i, int i2) {
        AppMethodBeat.i(109821);
        ab.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + z + ", bitrate:" + i + ", fps:" + i2);
        if (z) {
            h.pYm.k(986, 56, 1);
            h.pYm.k(986, 60, (long) i);
            h.pYm.k(986, 63, (long) i2);
            AppMethodBeat.o(109821);
            return;
        }
        h.pYm.k(986, 57, 1);
        h.pYm.k(986, 66, (long) i);
        h.pYm.k(986, 69, (long) i2);
        AppMethodBeat.o(109821);
    }

    public static void cAk() {
        AppMethodBeat.i(109822);
        ab.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxHitBitrateExceed");
        h.pYm.k(986, 73, 1);
        AppMethodBeat.o(109822);
    }
}
