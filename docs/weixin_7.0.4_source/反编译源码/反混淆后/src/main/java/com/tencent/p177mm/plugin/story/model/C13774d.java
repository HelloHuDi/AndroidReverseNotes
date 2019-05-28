package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C43625e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d */
public final class C13774d {
    private static final String TAG = TAG;
    private static final int rSe = 86400000;
    private static long rSf;
    public static final C13774d rSg = new C13774d();

    static {
        AppMethodBeat.m2504i(109017);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, Long.valueOf(0));
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.m2505o(109017);
            throw c44941v;
        }
        rSf = ((Long) obj).longValue();
        AppMethodBeat.m2505o(109017);
    }

    private C13774d() {
    }

    public static boolean canPostStory() {
        C1706e RP;
        AppMethodBeat.m2504i(109013);
        C4990ab.m7410d(TAG, "lastTimestamp: " + rSf);
        long aaE = C1839cb.aaE();
        if (aaE - rSf > ((long) rSe)) {
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
            rSf = aaE;
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, Long.valueOf(rSf));
            C4990ab.m7410d(TAG, "count reset to 0, lastTimestamp update to now: " + rSf);
        }
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(109013);
            throw c44941v;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue < ((Number) C43625e.rRA.mo53288Uw()).intValue()) {
            C4990ab.m7410d(TAG, "pass, count=".concat(String.valueOf(intValue)));
            AppMethodBeat.m2505o(109013);
            return true;
        }
        C4990ab.m7410d(TAG, "goodbye, count=".concat(String.valueOf(intValue)));
        AppMethodBeat.m2505o(109013);
        return false;
    }

    public static void cxA() {
        AppMethodBeat.m2504i(109014);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(109014);
            throw c44941v;
        }
        int intValue = ((Integer) obj).intValue();
        C1706e RP2 = C1720g.m3536RP();
        C25052j.m39375o(RP2, "MMKernel.storage()");
        RP2.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
        AppMethodBeat.m2505o(109014);
    }

    public static void cxB() {
        AppMethodBeat.m2504i(109015);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(109015);
            throw c44941v;
        }
        int intValue = ((Integer) obj).intValue();
        C1706e RP2 = C1720g.m3536RP();
        C25052j.m39375o(RP2, "MMKernel.storage()");
        RP2.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.max(0, intValue - 1)));
        AppMethodBeat.m2505o(109015);
    }

    /* renamed from: EK */
    public static void m21935EK(int i) {
        AppMethodBeat.m2504i(109016);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.min(i, ((Number) C43625e.rRA.mo53288Uw()).intValue())));
        AppMethodBeat.m2505o(109016);
    }
}
