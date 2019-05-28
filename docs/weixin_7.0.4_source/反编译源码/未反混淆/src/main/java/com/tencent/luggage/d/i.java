package com.tencent.luggage.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class i {
    public ConcurrentHashMap<f, Boolean> bPw = new ConcurrentHashMap();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public static abstract class f {
        public abstract boolean xm();

        /* synthetic */ f(byte b) {
            this();
        }

        private f() {
        }
    }

    public static abstract class e extends f {
        public abstract void onReady();

        public e() {
            super();
        }

        public final boolean xm() {
            onReady();
            return false;
        }
    }

    public static abstract class d extends f {
        public d() {
            super();
        }
    }

    public static abstract class b extends f {
        public b() {
            super();
        }
    }

    public static abstract class c extends f {
        public c() {
            super();
        }
    }

    public static abstract class a extends f {
        public abstract boolean wY();

        public a() {
            super();
        }

        public final boolean xm() {
            return wY();
        }
    }

    public i() {
        AppMethodBeat.i(90809);
        AppMethodBeat.o(90809);
    }

    private static boolean xl() {
        AppMethodBeat.i(90810);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.o(90810);
            return true;
        }
        AppMethodBeat.o(90810);
        return false;
    }

    public final void a(f fVar) {
        AppMethodBeat.i(90811);
        this.bPw.put(fVar, Boolean.TRUE);
        AppMethodBeat.o(90811);
    }

    /* Access modifiers changed, original: final */
    public final boolean D(Class<? extends f> cls) {
        AppMethodBeat.i(90812);
        if (xl()) {
            for (f fVar : this.bPw.keySet()) {
                if (cls.isInstance(fVar)) {
                    boolean xm = fVar.xm();
                    if (((Boolean) this.bPw.get(fVar)).booleanValue()) {
                        this.bPw.remove(fVar);
                    }
                    if (xm) {
                        AppMethodBeat.o(90812);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(90812);
            return false;
        }
        com.tencent.luggage.g.d.e("LuggagePageEventBus", "notifyListener on non-UI thread");
        AppMethodBeat.o(90812);
        return false;
    }
}
