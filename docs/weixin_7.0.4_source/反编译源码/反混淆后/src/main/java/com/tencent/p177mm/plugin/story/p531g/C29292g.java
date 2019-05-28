package com.tencent.p177mm.plugin.story.p531g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.g */
public final class C29292g {
    public static final C29292g sbU = new C29292g();

    static {
        AppMethodBeat.m2504i(109823);
        AppMethodBeat.m2505o(109823);
    }

    private C29292g() {
    }

    /* renamed from: lK */
    public static void m46510lK(boolean z) {
        AppMethodBeat.m2504i(109819);
        C4990ab.m7416i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(z)));
        if (z) {
            C7060h.pYm.mo15419k(986, 5, 1);
            AppMethodBeat.m2505o(109819);
            return;
        }
        C7060h.pYm.mo15419k(986, 6, 1);
        AppMethodBeat.m2505o(109819);
    }

    public static void cAj() {
        AppMethodBeat.m2504i(109820);
        C4990ab.m7416i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
        C7060h.pYm.mo15419k(986, 9, 1);
        AppMethodBeat.m2505o(109820);
    }

    /* renamed from: h */
    public static void m46509h(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(109821);
        C4990ab.m7416i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + z + ", bitrate:" + i + ", fps:" + i2);
        if (z) {
            C7060h.pYm.mo15419k(986, 56, 1);
            C7060h.pYm.mo15419k(986, 60, (long) i);
            C7060h.pYm.mo15419k(986, 63, (long) i2);
            AppMethodBeat.m2505o(109821);
            return;
        }
        C7060h.pYm.mo15419k(986, 57, 1);
        C7060h.pYm.mo15419k(986, 66, (long) i);
        C7060h.pYm.mo15419k(986, 69, (long) i2);
        AppMethodBeat.m2505o(109821);
    }

    public static void cAk() {
        AppMethodBeat.m2504i(109822);
        C4990ab.m7416i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxHitBitrateExceed");
        C7060h.pYm.mo15419k(986, 73, 1);
        AppMethodBeat.m2505o(109822);
    }
}
