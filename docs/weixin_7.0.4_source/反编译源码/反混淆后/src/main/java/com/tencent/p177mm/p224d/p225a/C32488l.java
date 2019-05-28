package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Context;
import com.eclipsesource.p097v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.d.a.l */
public final class C32488l {
    public final C45301c chO;
    public final C1481e chP;
    public final LinkedList<C9265n> chQ = new LinkedList();
    private final FutureTask<V8Context> chR;
    public final C9256f chr;

    /* renamed from: com.tencent.mm.d.a.l$2 */
    public class C14842 implements Runnable {
        final /* synthetic */ C32488l chU;
        final /* synthetic */ String val$name;

        public C14842(String str, C32488l c32488l) {
            this.val$name = str;
            this.chU = c32488l;
        }

        public final void run() {
            AppMethodBeat.m2504i(113836);
            C32488l.this.mo53119CB().shareObject(this.val$name, this.chU.mo53119CB());
            AppMethodBeat.m2505o(113836);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$3 */
    public class C14853 implements Runnable {
        final /* synthetic */ String chV;

        public C14853(String str) {
            this.chV = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(113837);
            C32488l.this.chO.waitForDebugger(this.chV);
            AppMethodBeat.m2505o(113837);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$4 */
    public class C14864 implements Runnable {
        final /* synthetic */ String bOU;
        final /* synthetic */ String chW;

        public C14864(String str, String str2) {
            this.bOU = str;
            this.chW = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(113838);
            C32488l.this.mo53119CB().executeDebugScript(this.bOU, this.chW);
            AppMethodBeat.m2505o(113838);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$11 */
    class C925811 implements Runnable {
        C925811() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113845);
            C4990ab.m7416i("MicroMsg.J2V8.V8ContextEngine", "destroy");
            for (int i = 0; i < C32488l.this.chQ.size(); i++) {
                ((C9265n) C32488l.this.chQ.get(i)).cleanup();
            }
            V8Context CB = C32488l.this.mo53119CB();
            if (CB != null) {
                try {
                    CB.release();
                    AppMethodBeat.m2505o(113845);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", e);
                }
            }
            AppMethodBeat.m2505o(113845);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$5 */
    class C92595 implements Runnable {
        C92595() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113839);
            C32488l.this.chQ.add(new C18182p().mo20687a(C32488l.this));
            C32488l.this.chQ.add(new C37669r().mo20687a(C32488l.this));
            C32488l.this.chQ.add(new C1487o(C32488l.this.chr).mo20687a(C32488l.this));
            C32488l.this.chQ.add(new C45302q(C32488l.this.chP).mo20687a(C32488l.this));
            AppMethodBeat.m2505o(113839);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$10 */
    public class C2606310 implements Runnable {
        final /* synthetic */ Object bRN;
        final /* synthetic */ Class cic;
        final /* synthetic */ String val$name;

        public C2606310(Object obj, String str, Class cls) {
            this.bRN = obj;
            this.val$name = str;
            this.cic = cls;
        }

        public final void run() {
            AppMethodBeat.m2504i(113844);
            C32488l c32488l = C32488l.this;
            Object obj = this.bRN;
            String str = this.val$name;
            Class cls = this.cic;
            Class cls2 = obj.getClass();
            ArrayList<Method> arrayList = new ArrayList();
            while (true) {
                Class cls3 = cls2;
                if (cls3 == Object.class) {
                    break;
                }
                for (Method method : new ArrayList(Arrays.asList(cls3.getDeclaredMethods()))) {
                    if (cls == null || method.isAnnotationPresent(cls)) {
                        arrayList.add(method);
                    }
                }
                cls2 = cls3.getSuperclass();
            }
            V8Value newV8Object = c32488l.mo53119CB().newV8Object();
            for (Method method2 : arrayList) {
                newV8Object.registerJavaMethod(obj, method2.getName(), method2.getName(), method2.getParameterTypes());
            }
            c32488l.mo53119CB().add(str, newV8Object);
            newV8Object.release();
            AppMethodBeat.m2505o(113844);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$9 */
    class C324899 implements Runnable {
        final /* synthetic */ JavaVoidCallback cib;
        final /* synthetic */ String val$name;

        C324899(JavaVoidCallback javaVoidCallback, String str) {
            this.cib = javaVoidCallback;
            this.val$name = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(113843);
            C32488l.this.mo53119CB().registerJavaMethod(this.cib, this.val$name);
            AppMethodBeat.m2505o(113843);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$b */
    public interface C32490b {
        /* renamed from: ds */
        void mo21687ds(String str);
    }

    /* renamed from: com.tencent.mm.d.a.l$8 */
    public class C324928 implements Runnable {
        final /* synthetic */ String bOU;
        final /* synthetic */ C32490b chX;
        final /* synthetic */ String chY;
        final /* synthetic */ String chZ;
        final /* synthetic */ String cia;

        public C324928(String str, C32490b c32490b, String str2, String str3, String str4) {
            this.chY = str;
            this.chX = c32490b;
            this.bOU = str2;
            this.chZ = str3;
            this.cia = str4;
        }

        public final void run() {
            AppMethodBeat.m2504i(113842);
            C4990ab.m7411d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", this.chY);
            if (this.chX != null) {
                Object executeScript = C32488l.this.mo53119CB().executeScript(this.bOU, this.chY, 0, this.chZ, this.cia);
                this.chX.mo21687ds(executeScript == null ? null : executeScript.toString());
                AppMethodBeat.m2505o(113842);
                return;
            }
            C32488l.this.mo53119CB().executeVoidScript(this.bOU, this.chY, 0, this.chZ, this.cia);
            AppMethodBeat.m2505o(113842);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$a */
    public interface C32493a {
        /* renamed from: Cu */
        V8Context mo53127Cu();
    }

    public C32488l(C45301c c45301c, C9256f c9256f, final C32493a c32493a) {
        AppMethodBeat.m2504i(113846);
        this.chO = c45301c;
        this.chR = new FutureTask(new Callable<V8Context>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.m2504i(113835);
                V8Context Cu = c32493a.mo53127Cu();
                AppMethodBeat.m2505o(113835);
                return Cu;
            }
        });
        c45301c.mo73187k(this.chR);
        if (c9256f == null) {
            c9256f = new C45303s();
        }
        this.chr = c9256f;
        this.chP = new C32485k(this);
        this.chO.mo73187k(new C92595());
        AppMethodBeat.m2505o(113846);
    }

    /* renamed from: CB */
    public final V8Context mo53119CB() {
        V8Context v8Context;
        AppMethodBeat.m2504i(113847);
        try {
            v8Context = (V8Context) this.chR.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", e, "getV8Context failed", new Object[0]);
            v8Context = null;
        }
        AppMethodBeat.m2505o(113847);
        return v8Context;
    }

    /* renamed from: a */
    public final void mo53121a(final String str, final C32490b c32490b) {
        AppMethodBeat.m2504i(113848);
        this.chO.mo73187k(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(113840);
                if (c32490b != null) {
                    Object executeScript = C32488l.this.mo53119CB().executeScript(str);
                    c32490b.mo21687ds(executeScript == null ? null : executeScript.toString());
                    AppMethodBeat.m2505o(113840);
                    return;
                }
                C32488l.this.mo53119CB().executeVoidScript(str);
                AppMethodBeat.m2505o(113840);
            }
        });
        AppMethodBeat.m2505o(113848);
    }

    /* renamed from: a */
    public final void mo53122a(final String str, final String str2, final C32490b c32490b) {
        AppMethodBeat.m2504i(113849);
        this.chO.mo73187k(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(113841);
                C4990ab.m7411d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", str);
                if (c32490b != null) {
                    Object executeScript = C32488l.this.mo53119CB().executeScript(str2, str, 0);
                    c32490b.mo21687ds(executeScript == null ? null : executeScript.toString());
                    AppMethodBeat.m2505o(113841);
                    return;
                }
                C32488l.this.mo53119CB().executeVoidScript(str2, str, 0);
                AppMethodBeat.m2505o(113841);
            }
        });
        AppMethodBeat.m2505o(113849);
    }

    /* renamed from: a */
    public final void mo53120a(int i, C33211h c33211h) {
        AppMethodBeat.m2504i(113850);
        this.chO.mo73183a(i, c33211h);
        AppMethodBeat.m2505o(113850);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(113851);
        this.chO.mo73188l(new C925811());
        AppMethodBeat.m2505o(113851);
    }
}
