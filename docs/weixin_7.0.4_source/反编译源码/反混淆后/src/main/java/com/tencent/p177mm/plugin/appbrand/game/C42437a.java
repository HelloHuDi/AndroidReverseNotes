package com.tencent.p177mm.plugin.appbrand.game;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.C25712a;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.handler.C17841a;
import com.tencent.magicbrush.p821d.C25714b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19346bo;
import com.tencent.p177mm.plugin.appbrand.p297h.C10257s;
import com.tencent.p177mm.plugin.appbrand.p297h.C33212n;
import com.tencent.p177mm.plugin.appbrand.p297h.C38235g;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p297h.C6748m.C6749a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.p177mm.plugin.appbrand.p329s.C45686m;
import com.tencent.p177mm.sdk.platformtools.C5058f;

/* renamed from: com.tencent.mm.plugin.appbrand.game.a */
public final class C42437a {
    public volatile MBRuntime hqb;
    public boolean hqc = false;
    public boolean hqd = false;
    public boolean hqe = true;
    public C6747i hqf;
    public C26880c hqg;
    public IMBEventListener hqh;
    public MBParams hqi = new MBParams();
    public final C19215a hqj = new C19215a(new C424362());

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$a */
    class C19215a extends C25714b implements C6749a {
        C19215a(Runnable runnable) {
            super(runnable);
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(129994);
            run();
            AppMethodBeat.m2505o(129994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$b */
    public class C19216b extends C25712a {
        public final void onJsExceptionOccurred(String str, String str2, int i) {
            AppMethodBeat.m2504i(129995);
            C45124d.m82928e("MicroMsg.MBRuntimeSimple", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", str, str2);
            if (C42437a.this.hqf == null) {
                AppMethodBeat.m2505o(129995);
                return;
            }
            C38237q c38237q = (C38237q) C42437a.this.hqf.mo14970af(C38237q.class);
            if (i == c38237q.aGU().aGT()) {
                C19346bo.m30025a(C42437a.this.hqf, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)}), 0);
                AppMethodBeat.m2505o(129995);
                return;
            }
            C38235g oO = c38237q.mo30582oO(i);
            if (oO != null) {
                C45686m.m84388a(oO, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)}));
                AppMethodBeat.m2505o(129995);
            } else if (C5058f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("[DebugOnly] j2v8 not follow the pattern");
                AppMethodBeat.m2505o(129995);
                throw illegalStateException;
            } else {
                AppMethodBeat.m2505o(129995);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$c */
    public static class C26880c implements C17841a {
        private C33212n hql;

        public /* synthetic */ C26880c(C6747i c6747i, byte b) {
            this(c6747i);
        }

        private C26880c(C6747i c6747i) {
            AppMethodBeat.m2504i(129996);
            this.hql = (C33212n) c6747i.mo14970af(C33212n.class);
            AppMethodBeat.m2505o(129996);
        }

        /* renamed from: f */
        public final void mo33017f(Runnable runnable) {
            AppMethodBeat.m2504i(129997);
            this.hql.mo30581f(runnable);
            AppMethodBeat.m2505o(129997);
        }

        /* renamed from: yE */
        public final boolean mo33018yE() {
            AppMethodBeat.m2504i(129998);
            boolean yE = this.hql.mo30589yE();
            AppMethodBeat.m2505o(129998);
            return yE;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$1 */
    public class C424351 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(129992);
            if (C42437a.this.hqb == null) {
                AppMethodBeat.m2505o(129992);
                return;
            }
            synchronized (C42437a.this) {
                try {
                    if (C42437a.this.hqb == null) {
                    } else if (C42437a.this.hqf == null) {
                        AppMethodBeat.m2505o(129992);
                    } else {
                        C10257s c10257s = (C10257s) C42437a.this.hqf.mo14970af(C10257s.class);
                        C42437a.this.hqb.bindTo(c10257s.getIsolatePtr(), c10257s.aGW());
                        AppMethodBeat.m2505o(129992);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(129992);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$2 */
    class C424362 implements Runnable {
        C424362() {
        }

        public final void run() {
            AppMethodBeat.m2504i(129993);
            if (C42437a.this.hqb != null) {
                synchronized (C42437a.this) {
                    try {
                        if (C42437a.this.hqb != null) {
                            C42437a.this.hqb.destroy();
                            C42437a.this.hqb = null;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(129993);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(129993);
        }
    }

    public C42437a() {
        AppMethodBeat.m2504i(129999);
        AppMethodBeat.m2505o(129999);
    }
}
