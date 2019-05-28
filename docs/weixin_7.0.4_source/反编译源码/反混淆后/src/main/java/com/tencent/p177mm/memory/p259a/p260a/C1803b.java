package com.tencent.p177mm.memory.p259a.p260a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1792a;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1799d;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C6661f;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C7482g;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.memory.a.a.b */
public class C1803b {
    private static volatile C1803b feh;
    public static final C1792a fei;
    private final String TAG = "MicroMsg.CacheInvoke";
    public ConcurrentHashMap<String, C1802b> fdN = new ConcurrentHashMap();
    private C1802b fej = null;

    /* renamed from: com.tencent.mm.memory.a.a.b$b */
    public interface C1802b<T> {
        /* renamed from: Xs */
        void mo5368Xs();

        /* renamed from: Xt */
        C1792a mo5369Xt();

        /* renamed from: Xu */
        C1799d<String, T> mo5370Xu();

        /* renamed from: Xv */
        C1177f<String, T> mo5371Xv();
    }

    /* renamed from: com.tencent.mm.memory.a.a.b$a */
    static class C1804a implements C1802b {
        private static String fen = "//data[%d,%d]::%s::%s";
        private C1799d<String, C6662a> fek = null;
        private C7482g<String, Object> fel = null;
        private C1792a fem;

        /* renamed from: com.tencent.mm.memory.a.a.b$a$1 */
        class C18051 implements C1175b<String, C6662a> {
            C18051() {
            }

            /* renamed from: c */
            public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.m2504i(115448);
                String str = (String) obj;
                C6662a c6662a = (C6662a) obj2;
                C6662a c6662a2 = (C6662a) obj3;
                if (!(c6662a == null || c6662a.fec == null || c6662a.fec.get() == null)) {
                    C1175b c1175b = (C1175b) c6662a.fec.get();
                    if (c1175b != null) {
                        c1175b.mo4401c(str, c6662a, c6662a2);
                    }
                }
                AppMethodBeat.m2505o(115448);
            }
        }

        /* renamed from: com.tencent.mm.memory.a.a.b$a$2 */
        class C18062 implements C1176c<String, C6662a> {
            C18062() {
            }

            /* renamed from: l */
            public final /* bridge */ /* synthetic */ int mo4402l(Object obj, Object obj2) {
                C6662a c6662a = (C6662a) obj2;
                if (c6662a != null) {
                    return c6662a.fee;
                }
                return 0;
            }
        }

        C1804a(C1792a c1792a) {
            AppMethodBeat.m2504i(115450);
            this.fem = c1792a;
            this.fek = new C6661f<String, C6662a>(c1792a, new C18051(), new C18062()) {
                /* renamed from: p */
                public final /* synthetic */ Object mo5372p(Object obj, Object obj2) {
                    AppMethodBeat.m2504i(115449);
                    String str = (String) obj2;
                    String str2 = ((String) obj) + "@" + str;
                    AppMethodBeat.m2505o(115449);
                    return str2;
                }
            };
            this.fel = new C7482g();
            AppMethodBeat.m2505o(115450);
        }

        /* renamed from: Xs */
        public final void mo5368Xs() {
            AppMethodBeat.m2504i(115451);
            this.fek.trimToSize(this.fem.fer / 2);
            AppMethodBeat.m2505o(115451);
        }

        /* renamed from: Xt */
        public final C1792a mo5369Xt() {
            return this.fem;
        }

        /* renamed from: Xu */
        public final C1799d mo5370Xu() {
            return this.fek;
        }

        /* renamed from: Xv */
        public final C1177f mo5371Xv() {
            return this.fel;
        }
    }

    static {
        AppMethodBeat.m2504i(115458);
        C1792a Xw = C1792a.m3685Xw();
        fei = Xw;
        C1803b Xr = C1803b.m3705Xr();
        C1804a c1804a = new C1804a(Xw);
        Xr.fdN.put(Xw.few, c1804a);
        if (Xw.equals(fei)) {
            Xr.fej = c1804a;
        }
        AppMethodBeat.m2505o(115458);
    }

    C1803b() {
        AppMethodBeat.m2504i(115452);
        AppMethodBeat.m2505o(115452);
    }

    /* renamed from: Xr */
    public static C1803b m3705Xr() {
        AppMethodBeat.m2504i(115453);
        if (feh == null) {
            synchronized (C1803b.class) {
                try {
                    if (feh == null) {
                        feh = new C1803b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(115453);
                    }
                }
            }
        }
        C1803b c1803b = feh;
        AppMethodBeat.m2505o(115453);
        return c1803b;
    }

    /* renamed from: b */
    private static C1802b m3706b(C1792a c1792a) {
        AppMethodBeat.m2504i(115454);
        C1802b c1802b = (C1802b) C1803b.m3705Xr().fdN.get(c1792a.few);
        AppMethodBeat.m2505o(115454);
        return c1802b;
    }

    /* renamed from: c */
    public static C1799d<String, C6662a> m3707c(C1792a c1792a) {
        AppMethodBeat.m2504i(115455);
        C1799d<String, C6662a> Xu;
        if (c1792a == null || c1792a.equals("")) {
            AppMethodBeat.m2505o(115455);
            return null;
        } else if (fei.equals(c1792a)) {
            Xu = C1803b.m3705Xr().fej.mo5370Xu();
            AppMethodBeat.m2505o(115455);
            return Xu;
        } else {
            C1803b.m3705Xr();
            Xu = C1803b.m3706b(c1792a).mo5370Xu();
            AppMethodBeat.m2505o(115455);
            return Xu;
        }
    }

    /* renamed from: d */
    public static C1177f<String, Object> m3708d(C1792a c1792a) {
        AppMethodBeat.m2504i(115456);
        C1177f<String, Object> Xv;
        if (c1792a == null || c1792a.equals("")) {
            AppMethodBeat.m2505o(115456);
            return null;
        } else if (fei.equals(c1792a)) {
            Xv = C1803b.m3705Xr().fej.mo5371Xv();
            AppMethodBeat.m2505o(115456);
            return Xv;
        } else {
            C1803b.m3705Xr();
            Xv = C1803b.m3706b(c1792a).mo5371Xv();
            AppMethodBeat.m2505o(115456);
            return Xv;
        }
    }

    /* renamed from: e */
    public static int m3709e(C1792a c1792a) {
        AppMethodBeat.m2504i(115457);
        int i;
        if (c1792a == null || c1792a.equals("")) {
            AppMethodBeat.m2505o(115457);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (fei.equals(c1792a)) {
            i = C1803b.m3705Xr().fej.mo5369Xt().fer;
            AppMethodBeat.m2505o(115457);
            return i;
        } else {
            C1803b.m3705Xr();
            i = C1803b.m3706b(c1792a).mo5369Xt().fer;
            AppMethodBeat.m2505o(115457);
            return i;
        }
    }
}
