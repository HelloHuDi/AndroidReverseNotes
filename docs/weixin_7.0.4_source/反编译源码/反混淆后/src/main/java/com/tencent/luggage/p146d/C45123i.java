package com.tencent.luggage.p146d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.luggage.d.i */
public final class C45123i {
    public ConcurrentHashMap<C0987f, Boolean> bPw = new ConcurrentHashMap();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.luggage.d.i$f */
    public static abstract class C0987f {
        /* renamed from: xm */
        public abstract boolean mo3954xm();

        /* synthetic */ C0987f(byte b) {
            this();
        }

        private C0987f() {
        }
    }

    /* renamed from: com.tencent.luggage.d.i$e */
    public static abstract class C6274e extends C0987f {
        public abstract void onReady();

        public C6274e() {
            super();
        }

        /* renamed from: xm */
        public final boolean mo3954xm() {
            onReady();
            return false;
        }
    }

    /* renamed from: com.tencent.luggage.d.i$d */
    public static abstract class C8863d extends C0987f {
        public C8863d() {
            super();
        }
    }

    /* renamed from: com.tencent.luggage.d.i$b */
    public static abstract class C32184b extends C0987f {
        public C32184b() {
            super();
        }
    }

    /* renamed from: com.tencent.luggage.d.i$c */
    public static abstract class C32185c extends C0987f {
        public C32185c() {
            super();
        }
    }

    /* renamed from: com.tencent.luggage.d.i$a */
    public static abstract class C45122a extends C0987f {
        /* renamed from: wY */
        public abstract boolean mo38421wY();

        public C45122a() {
            super();
        }

        /* renamed from: xm */
        public final boolean mo3954xm() {
            return mo38421wY();
        }
    }

    public C45123i() {
        AppMethodBeat.m2504i(90809);
        AppMethodBeat.m2505o(90809);
    }

    /* renamed from: xl */
    private static boolean m82919xl() {
        AppMethodBeat.m2504i(90810);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.m2505o(90810);
            return true;
        }
        AppMethodBeat.m2505o(90810);
        return false;
    }

    /* renamed from: a */
    public final void mo72933a(C0987f c0987f) {
        AppMethodBeat.m2504i(90811);
        this.bPw.put(c0987f, Boolean.TRUE);
        AppMethodBeat.m2505o(90811);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: D */
    public final boolean mo72932D(Class<? extends C0987f> cls) {
        AppMethodBeat.m2504i(90812);
        if (C45123i.m82919xl()) {
            for (C0987f c0987f : this.bPw.keySet()) {
                if (cls.isInstance(c0987f)) {
                    boolean xm = c0987f.mo3954xm();
                    if (((Boolean) this.bPw.get(c0987f)).booleanValue()) {
                        this.bPw.remove(c0987f);
                    }
                    if (xm) {
                        AppMethodBeat.m2505o(90812);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(90812);
            return false;
        }
        C45124d.m82927e("LuggagePageEventBus", "notifyListener on non-UI thread");
        AppMethodBeat.m2505o(90812);
        return false;
    }
}
