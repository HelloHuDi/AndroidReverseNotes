package com.tencent.mm.sdk.g.c;

import android.os.HandlerThread;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.a;
import com.tencent.mm.sdk.platformtools.al;

public final class c {
    private static a xEH;
    public static final e xEI = new e() {
        public final HandlerThread anO(String str) {
            AppMethodBeat.i(52688);
            AnonymousClass1 anonymousClass1 = new HandlerThread("[GT]".concat(String.valueOf(str))) {
                final /* synthetic */ Runnable eGq = null;

                public final void run() {
                    AppMethodBeat.i(52683);
                    super.run();
                    if (this.eGq != null) {
                        this.eGq.run();
                    }
                    AppMethodBeat.o(52683);
                }

                public final String toString() {
                    AppMethodBeat.i(52684);
                    String format = String.format("[%s,%s,%s]", new Object[]{getName(), Long.valueOf(getId()), getState()});
                    AppMethodBeat.o(52684);
                    return format;
                }
            };
            if (c.xEH != null) {
                c.xEH;
            }
            AppMethodBeat.o(52688);
            return anonymousClass1;
        }

        public final HandlerThread a(final Runnable runnable, String str, final Printer printer) {
            AppMethodBeat.i(52689);
            AnonymousClass2 anonymousClass2 = new HandlerThread("[GT]".concat(String.valueOf(str))) {
                public final void run() {
                    AppMethodBeat.i(52685);
                    super.run();
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(52685);
                }

                /* Access modifiers changed, original: protected|final */
                public final void onLooperPrepared() {
                    AppMethodBeat.i(52686);
                    super.onLooperPrepared();
                    getLooper().setMessageLogging(printer);
                    AppMethodBeat.o(52686);
                }

                public final String toString() {
                    AppMethodBeat.i(52687);
                    String format = String.format("[%s,%s,%s]", new Object[]{getName(), Long.valueOf(getId()), getState()});
                    AppMethodBeat.o(52687);
                    return format;
                }
            };
            if (c.xEH != null) {
                c.xEH;
            }
            AppMethodBeat.o(52689);
            return anonymousClass2;
        }
    };

    static {
        AppMethodBeat.i(52692);
        AppMethodBeat.o(52692);
    }

    public static HandlerThread anN(String str) {
        AppMethodBeat.i(52690);
        HandlerThread anO = xEI.anO(str);
        AppMethodBeat.o(52690);
        return anO;
    }

    public static al dqp() {
        AppMethodBeat.i(52691);
        al alVar = new al("worker");
        AppMethodBeat.o(52691);
        return alVar;
    }
}
