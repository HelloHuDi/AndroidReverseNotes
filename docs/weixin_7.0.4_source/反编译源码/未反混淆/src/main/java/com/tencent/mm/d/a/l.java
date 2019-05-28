package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class l {
    public final c chO;
    public final e chP;
    public final LinkedList<n> chQ = new LinkedList();
    private final FutureTask<V8Context> chR;
    public final f chr;

    /* renamed from: com.tencent.mm.d.a.l$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ l chU;
        final /* synthetic */ String val$name;

        public AnonymousClass2(String str, l lVar) {
            this.val$name = str;
            this.chU = lVar;
        }

        public final void run() {
            AppMethodBeat.i(113836);
            l.this.CB().shareObject(this.val$name, this.chU.CB());
            AppMethodBeat.o(113836);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String chV;

        public AnonymousClass3(String str) {
            this.chV = str;
        }

        public final void run() {
            AppMethodBeat.i(113837);
            l.this.chO.waitForDebugger(this.chV);
            AppMethodBeat.o(113837);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String bOU;
        final /* synthetic */ String chW;

        public AnonymousClass4(String str, String str2) {
            this.bOU = str;
            this.chW = str2;
        }

        public final void run() {
            AppMethodBeat.i(113838);
            l.this.CB().executeDebugScript(this.bOU, this.chW);
            AppMethodBeat.o(113838);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$10 */
    public class AnonymousClass10 implements Runnable {
        final /* synthetic */ Object bRN;
        final /* synthetic */ Class cic;
        final /* synthetic */ String val$name;

        public AnonymousClass10(Object obj, String str, Class cls) {
            this.bRN = obj;
            this.val$name = str;
            this.cic = cls;
        }

        public final void run() {
            AppMethodBeat.i(113844);
            l lVar = l.this;
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
            V8Value newV8Object = lVar.CB().newV8Object();
            for (Method method2 : arrayList) {
                newV8Object.registerJavaMethod(obj, method2.getName(), method2.getName(), method2.getParameterTypes());
            }
            lVar.CB().add(str, newV8Object);
            newV8Object.release();
            AppMethodBeat.o(113844);
        }
    }

    /* renamed from: com.tencent.mm.d.a.l$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ JavaVoidCallback cib;
        final /* synthetic */ String val$name;

        AnonymousClass9(JavaVoidCallback javaVoidCallback, String str) {
            this.cib = javaVoidCallback;
            this.val$name = str;
        }

        public final void run() {
            AppMethodBeat.i(113843);
            l.this.CB().registerJavaMethod(this.cib, this.val$name);
            AppMethodBeat.o(113843);
        }
    }

    public interface b {
        void ds(String str);
    }

    /* renamed from: com.tencent.mm.d.a.l$8 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ String bOU;
        final /* synthetic */ b chX;
        final /* synthetic */ String chY;
        final /* synthetic */ String chZ;
        final /* synthetic */ String cia;

        public AnonymousClass8(String str, b bVar, String str2, String str3, String str4) {
            this.chY = str;
            this.chX = bVar;
            this.bOU = str2;
            this.chZ = str3;
            this.cia = str4;
        }

        public final void run() {
            AppMethodBeat.i(113842);
            ab.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", this.chY);
            if (this.chX != null) {
                Object executeScript = l.this.CB().executeScript(this.bOU, this.chY, 0, this.chZ, this.cia);
                this.chX.ds(executeScript == null ? null : executeScript.toString());
                AppMethodBeat.o(113842);
                return;
            }
            l.this.CB().executeVoidScript(this.bOU, this.chY, 0, this.chZ, this.cia);
            AppMethodBeat.o(113842);
        }
    }

    public interface a {
        V8Context Cu();
    }

    public l(c cVar, f fVar, final a aVar) {
        AppMethodBeat.i(113846);
        this.chO = cVar;
        this.chR = new FutureTask(new Callable<V8Context>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.i(113835);
                V8Context Cu = aVar.Cu();
                AppMethodBeat.o(113835);
                return Cu;
            }
        });
        cVar.k(this.chR);
        if (fVar == null) {
            fVar = new s();
        }
        this.chr = fVar;
        this.chP = new k(this);
        this.chO.k(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113839);
                l.this.chQ.add(new p().a(l.this));
                l.this.chQ.add(new r().a(l.this));
                l.this.chQ.add(new o(l.this.chr).a(l.this));
                l.this.chQ.add(new q(l.this.chP).a(l.this));
                AppMethodBeat.o(113839);
            }
        });
        AppMethodBeat.o(113846);
    }

    public final V8Context CB() {
        V8Context v8Context;
        AppMethodBeat.i(113847);
        try {
            v8Context = (V8Context) this.chR.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", e, "getV8Context failed", new Object[0]);
            v8Context = null;
        }
        AppMethodBeat.o(113847);
        return v8Context;
    }

    public final void a(final String str, final b bVar) {
        AppMethodBeat.i(113848);
        this.chO.k(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113840);
                if (bVar != null) {
                    Object executeScript = l.this.CB().executeScript(str);
                    bVar.ds(executeScript == null ? null : executeScript.toString());
                    AppMethodBeat.o(113840);
                    return;
                }
                l.this.CB().executeVoidScript(str);
                AppMethodBeat.o(113840);
            }
        });
        AppMethodBeat.o(113848);
    }

    public final void a(final String str, final String str2, final b bVar) {
        AppMethodBeat.i(113849);
        this.chO.k(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113841);
                ab.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", str);
                if (bVar != null) {
                    Object executeScript = l.this.CB().executeScript(str2, str, 0);
                    bVar.ds(executeScript == null ? null : executeScript.toString());
                    AppMethodBeat.o(113841);
                    return;
                }
                l.this.CB().executeVoidScript(str2, str, 0);
                AppMethodBeat.o(113841);
            }
        });
        AppMethodBeat.o(113849);
    }

    public final void a(int i, h hVar) {
        AppMethodBeat.i(113850);
        this.chO.a(i, hVar);
        AppMethodBeat.o(113850);
    }

    public final void destroy() {
        AppMethodBeat.i(113851);
        this.chO.l(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113845);
                ab.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
                for (int i = 0; i < l.this.chQ.size(); i++) {
                    ((n) l.this.chQ.get(i)).cleanup();
                }
                V8Context CB = l.this.CB();
                if (CB != null) {
                    try {
                        CB.release();
                        AppMethodBeat.o(113845);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", e);
                    }
                }
                AppMethodBeat.o(113845);
            }
        });
        AppMethodBeat.o(113851);
    }
}
