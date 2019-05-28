package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d {
    private static final String TAG = TAG;
    private static final int rSe = 86400000;
    private static long rSf;
    public static final d rSg = new d();

    static {
        AppMethodBeat.i(109017);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, Long.valueOf(0));
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(109017);
            throw vVar;
        }
        rSf = ((Long) obj).longValue();
        AppMethodBeat.o(109017);
    }

    private d() {
    }

    public static boolean canPostStory() {
        e RP;
        AppMethodBeat.i(109013);
        ab.d(TAG, "lastTimestamp: " + rSf);
        long aaE = cb.aaE();
        if (aaE - rSf > ((long) rSe)) {
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
            rSf = aaE;
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, Long.valueOf(rSf));
            ab.d(TAG, "count reset to 0, lastTimestamp update to now: " + rSf);
        }
        RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(109013);
            throw vVar;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue < ((Number) com.tencent.mm.plugin.story.c.a.e.rRA.Uw()).intValue()) {
            ab.d(TAG, "pass, count=".concat(String.valueOf(intValue)));
            AppMethodBeat.o(109013);
            return true;
        }
        ab.d(TAG, "goodbye, count=".concat(String.valueOf(intValue)));
        AppMethodBeat.o(109013);
        return false;
    }

    public static void cxA() {
        AppMethodBeat.i(109014);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(109014);
            throw vVar;
        }
        int intValue = ((Integer) obj).intValue();
        e RP2 = g.RP();
        j.o(RP2, "MMKernel.storage()");
        RP2.Ry().set(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
        AppMethodBeat.o(109014);
    }

    public static void cxB() {
        AppMethodBeat.i(109015);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(109015);
            throw vVar;
        }
        int intValue = ((Integer) obj).intValue();
        e RP2 = g.RP();
        j.o(RP2, "MMKernel.storage()");
        RP2.Ry().set(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.max(0, intValue - 1)));
        AppMethodBeat.o(109015);
    }

    public static void EK(int i) {
        AppMethodBeat.i(109016);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.min(i, ((Number) com.tencent.mm.plugin.story.c.a.e.rRA.Uw()).intValue())));
        AppMethodBeat.o(109016);
    }
}
