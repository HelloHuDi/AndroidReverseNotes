package com.tencent.p177mm.sdk.p604g.p607c;

import android.os.HandlerThread;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4938a;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.sdk.g.c.c */
public final class C4960c {
    private static C4938a xEH;
    public static final C4962e xEI = new C49611();

    /* renamed from: com.tencent.mm.sdk.g.c.c$1 */
    static class C49611 implements C4962e {
        C49611() {
        }

        public final HandlerThread anO(String str) {
            AppMethodBeat.m2504i(52688);
            C49581 c49581 = new HandlerThread("[GT]".concat(String.valueOf(str))) {
                final /* synthetic */ Runnable eGq = null;

                public final void run() {
                    AppMethodBeat.m2504i(52683);
                    super.run();
                    if (this.eGq != null) {
                        this.eGq.run();
                    }
                    AppMethodBeat.m2505o(52683);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(52684);
                    String format = String.format("[%s,%s,%s]", new Object[]{getName(), Long.valueOf(getId()), getState()});
                    AppMethodBeat.m2505o(52684);
                    return format;
                }
            };
            if (C4960c.xEH != null) {
                C4960c.xEH;
            }
            AppMethodBeat.m2505o(52688);
            return c49581;
        }

        /* renamed from: a */
        public final HandlerThread mo10206a(final Runnable runnable, String str, final Printer printer) {
            AppMethodBeat.m2504i(52689);
            C49592 c49592 = new HandlerThread("[GT]".concat(String.valueOf(str))) {
                public final void run() {
                    AppMethodBeat.m2504i(52685);
                    super.run();
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.m2505o(52685);
                }

                /* Access modifiers changed, original: protected|final */
                public final void onLooperPrepared() {
                    AppMethodBeat.m2504i(52686);
                    super.onLooperPrepared();
                    getLooper().setMessageLogging(printer);
                    AppMethodBeat.m2505o(52686);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(52687);
                    String format = String.format("[%s,%s,%s]", new Object[]{getName(), Long.valueOf(getId()), getState()});
                    AppMethodBeat.m2505o(52687);
                    return format;
                }
            };
            if (C4960c.xEH != null) {
                C4960c.xEH;
            }
            AppMethodBeat.m2505o(52689);
            return c49592;
        }
    }

    static {
        AppMethodBeat.m2504i(52692);
        AppMethodBeat.m2505o(52692);
    }

    public static HandlerThread anN(String str) {
        AppMethodBeat.m2504i(52690);
        HandlerThread anO = xEI.anO(str);
        AppMethodBeat.m2505o(52690);
        return anO;
    }

    public static C5004al dqp() {
        AppMethodBeat.m2504i(52691);
        C5004al c5004al = new C5004al("worker");
        AppMethodBeat.m2505o(52691);
        return c5004al;
    }
}
