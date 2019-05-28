package com.tencent.mm.loader.g;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 +*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0014\u0010(\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tJ\u0013\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u0014\u0010*\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "callInUI", "callPrepareInUI", "", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c> implements b {
    public static final a eQY = new a();
    private a eQT;
    private a eQU;
    private final LinkedList<g<c, f<T>>> eQV = new LinkedList();
    private final LinkedList<g<c, f<T>>> eQW = new LinkedList();
    private final com.tencent.mm.loader.g.a.d eQX;
    private final LinkedList<f<T>> ezr = new LinkedList();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
    static final class c implements com.tencent.mm.loader.g.i.a {
        final /* synthetic */ d eRa;

        c(d dVar) {
            this.eRa = dVar;
        }

        public final void b(final c cVar, final h hVar) {
            com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                final /* synthetic */ c eRd;

                public final /* synthetic */ Object invoke() {
                    Object obj;
                    c cVar;
                    h hVar;
                    ab.i("MicroMsg.Loader.DefaultTaskLoader", this.eRd.eRa.TO() + "workStatus change work " + cVar + " getStatus: " + hVar);
                    for (Object next : this.eRd.eRa.eQW) {
                        if (j.j(((c) ((g) next).first).Pc(), cVar.Pc())) {
                            obj = next;
                            break;
                        }
                    }
                    obj = null;
                    g gVar = (g) obj;
                    if (gVar != null) {
                        this.eRd.eRa.eQW.remove(gVar);
                        f fVar = (f) gVar.second;
                        if (fVar != null) {
                            cVar = cVar;
                            if (cVar == null) {
                                throw new v("null cannot be cast to non-null type T");
                            }
                            hVar = hVar;
                            j.o(hVar, "status");
                            fVar.a(cVar, hVar);
                        }
                    }
                    d dVar = this.eRd.eRa;
                    cVar = cVar;
                    j.o(cVar, "work");
                    hVar = hVar;
                    j.o(hVar, "status");
                    com.tencent.mm.ab.b.a(new e(dVar, cVar, hVar));
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        switch (e.eQZ[hVar2.ordinal()]) {
                            case 1:
                                ab.i("MicroMsg.Loader.DefaultTaskLoader", this.eRd.eRa.TO() + "workStat wait");
                                break;
                        }
                    }
                    this.eRd.eRa.TQ();
                    return y.AUy;
                }
            });
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ d eRa;

        d(d dVar) {
            this.eRa = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eRa.eQV.clear();
            this.eRa.eQW.clear();
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ d eRa;
        final /* synthetic */ h eRf;
        final /* synthetic */ c eRg;

        e(d dVar, c cVar, h hVar) {
            this.eRa = dVar;
            this.eRg = cVar;
            this.eRf = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            for (f fVar : this.eRa.ezr) {
                c cVar = this.eRg;
                if (cVar == null) {
                    throw new v("null cannot be cast to non-null type T");
                }
                fVar.a(cVar, this.eRf);
            }
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ d eRa;
        final /* synthetic */ f eRc;

        f(d dVar, f fVar) {
            this.eRa = dVar;
            this.eRc = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj;
            Iterable<f> a = this.eRa.ezr;
            if (!((a instanceof Collection) && ((Collection) a).isEmpty())) {
                for (f j : a) {
                    if (j.j(j, this.eRc)) {
                        obj = null;
                        break;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                this.eRa.ezr.add(this.eRc);
            }
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ d eRa;
        final /* synthetic */ f eRc;

        g(d dVar, f fVar) {
            this.eRa = dVar;
            this.eRc = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eRa.ezr.remove(this.eRc);
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/loader/LoaderCore$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ d eRa;
        final /* synthetic */ c eRb;
        final /* synthetic */ f eRc;

        b(d dVar, c cVar, f fVar) {
            this.eRa = dVar;
            this.eRb = cVar;
            this.eRc = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj;
            for (Object next : this.eRa.eQV) {
                if (j.j(((c) ((g) next).first).Pc(), this.eRb.Pc())) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            g gVar = (g) obj;
            if (gVar != null) {
                gVar.second = this.eRc;
                ab.i("MicroMsg.Loader.DefaultTaskLoader", this.eRa.TO() + "this task already in task in mPendingQueue %s", this.eRb);
                this.eRa.TQ();
            } else {
                for (Object next2 : this.eRa.eQW) {
                    if (j.j(((c) ((g) next2).first).Pc(), this.eRb.Pc())) {
                        obj = next2;
                        break;
                    }
                }
                obj = null;
                gVar = (g) obj;
                if (gVar != null) {
                    gVar.second = this.eRc;
                    ab.i("MicroMsg.Loader.DefaultTaskLoader", this.eRa.TO() + "this task already in task in mRunningQueue %s", this.eRb);
                    this.eRa.TQ();
                } else {
                    this.eRa.eQV.add(new g(this.eRb, this.eRc));
                    this.eRa.TQ();
                }
            }
            return y.AUy;
        }
    }

    public d(com.tencent.mm.loader.g.a.d dVar) {
        j.p(dVar, "configuration");
        this.eQX = dVar;
    }

    private final String TO() {
        return "name:" + this.eQX.name() + "_this:" + hashCode() + '_';
    }

    public final void a(f<T> fVar) {
        j.p(fVar, "callback");
        com.tencent.mm.ab.b.a(new f(this, fVar));
    }

    public final void b(f<T> fVar) {
        j.p(fVar, "callback");
        com.tencent.mm.ab.b.a(new g(this, fVar));
    }

    private final void TP() {
        if (this.eQT == null) {
            this.eQT = this.eQX.TR();
        }
    }

    public final void a(T t) {
        j.p(t, "t");
        a(t, null);
    }

    public final void a(T t, f<T> fVar) {
        j.p(t, "t");
        com.tencent.mm.ab.b.a(new b(this, t, fVar));
    }

    private final boolean TQ() {
        if (this.eQV.size() <= 0) {
            ab.i("MicroMsg.Loader.DefaultTaskLoader", TO() + "DefaultTaskLoader mPendingQueue is empty");
            return false;
        } else if (this.eQW.size() > this.eQX.TT()) {
            return false;
        } else {
            ab.i("MicroMsg.Loader.DefaultTaskLoader", TO() + "callPrepare RunningQueue %s max_run_task %s mPendingQueue %s", Integer.valueOf(this.eQW.size()), Integer.valueOf(this.eQX.TT()), Integer.valueOf(this.eQV.size()));
            Object remove = this.eQV.remove(0);
            j.o(remove, "mPendingQueue.removeAt(0)");
            g gVar = (g) remove;
            this.eQW.add(gVar);
            if (this.eQX.TU().b((c) gVar.first)) {
                execute(new i((c) gVar.first, this, new c(this)));
                return true;
            }
            ab.w("MicroMsg.Loader.DefaultTaskLoader", TO() + " block retryStrategy " + gVar + ".first");
            f fVar = (f) gVar.second;
            if (fVar != null) {
                remove = gVar.first;
                if (remove == null) {
                    throw new v("null cannot be cast to non-null type T");
                }
                fVar.a((c) remove, h.Block);
            }
            return true;
        }
    }

    public final void clean() {
        com.tencent.mm.ab.b.a(new d(this));
    }

    public final void execute(Runnable runnable) {
        j.p(runnable, "runnable");
        TP();
        a aVar = this.eQT;
        if (aVar != null) {
            aVar.execute(runnable);
        }
    }

    public final void u(Runnable runnable) {
        j.p(runnable, "runnable");
        if (this.eQU == null) {
            this.eQU = this.eQX.TS();
        }
        a aVar = this.eQU;
        if (aVar != null) {
            aVar.execute(runnable);
        }
    }
}
