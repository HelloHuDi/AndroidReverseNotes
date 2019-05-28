package com.tencent.p177mm.loader.p864g;

import com.tencent.p177mm.loader.p864g.C18541i.C18542a;
import com.tencent.p177mm.loader.p864g.p1196a.C37883d;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collection;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 +*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0014\u0010(\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tJ\u0013\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u0014\u0010*\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "callInUI", "callPrepareInUI", "", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.g.d */
public final class C26366d<T extends C26365c> implements C9576b {
    public static final C26369a eQY = new C26369a();
    private C26364a eQT;
    private C26364a eQU;
    private final LinkedList<C37884g<C26365c, C42155f<T>>> eQV = new LinkedList();
    private final LinkedList<C37884g<C26365c, C42155f<T>>> eQW = new LinkedList();
    private final C37883d eQX;
    private final LinkedList<C42155f<T>> ezr = new LinkedList();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
    /* renamed from: com.tencent.mm.loader.g.d$c */
    static final class C18538c implements C18542a {
        final /* synthetic */ C26366d eRa;

        C18538c(C26366d c26366d) {
            this.eRa = c26366d;
        }

        /* renamed from: b */
        public final void mo33793b(final C26365c c26365c, final C45423h c45423h) {
            C8902b.m16042a(new C31214a<C37091y>(this) {
                final /* synthetic */ C18538c eRd;

                public final /* synthetic */ Object invoke() {
                    Object obj;
                    C26365c c26365c;
                    C45423h c45423h;
                    C4990ab.m7416i("MicroMsg.Loader.DefaultTaskLoader", this.eRd.eRa.m41947TO() + "workStatus change work " + c26365c + " getStatus: " + c45423h);
                    for (Object next : this.eRd.eRa.eQW) {
                        if (C25052j.m39373j(((C26365c) ((C37884g) next).first).mo9027Pc(), c26365c.mo9027Pc())) {
                            obj = next;
                            break;
                        }
                    }
                    obj = null;
                    C37884g c37884g = (C37884g) obj;
                    if (c37884g != null) {
                        this.eRd.eRa.eQW.remove(c37884g);
                        C42155f c42155f = (C42155f) c37884g.second;
                        if (c42155f != null) {
                            c26365c = c26365c;
                            if (c26365c == null) {
                                throw new C44941v("null cannot be cast to non-null type T");
                            }
                            c45423h = c45423h;
                            C25052j.m39375o(c45423h, "status");
                            c42155f.mo9004a(c26365c, c45423h);
                        }
                    }
                    C26366d c26366d = this.eRd.eRa;
                    c26365c = c26365c;
                    C25052j.m39375o(c26365c, "work");
                    c45423h = c45423h;
                    C25052j.m39375o(c45423h, "status");
                    C8902b.m16042a(new C18540e(c26366d, c26365c, c45423h));
                    C45423h c45423h2 = c45423h;
                    if (c45423h2 != null) {
                        switch (C42154e.eQZ[c45423h2.ordinal()]) {
                            case 1:
                                C4990ab.m7416i("MicroMsg.Loader.DefaultTaskLoader", this.eRd.eRa.m41947TO() + "workStat wait");
                                break;
                        }
                    }
                    this.eRd.eRa.m41949TQ();
                    return C37091y.AUy;
                }
            });
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$d */
    static final class C18539d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C26366d eRa;

        C18539d(C26366d c26366d) {
            this.eRa = c26366d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eRa.eQV.clear();
            this.eRa.eQW.clear();
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$e */
    static final class C18540e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C26366d eRa;
        final /* synthetic */ C45423h eRf;
        final /* synthetic */ C26365c eRg;

        C18540e(C26366d c26366d, C26365c c26365c, C45423h c45423h) {
            this.eRa = c26366d;
            this.eRg = c26365c;
            this.eRf = c45423h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            for (C42155f c42155f : this.eRa.ezr) {
                C26365c c26365c = this.eRg;
                if (c26365c == null) {
                    throw new C44941v("null cannot be cast to non-null type T");
                }
                c42155f.mo9004a(c26365c, this.eRf);
            }
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$f */
    static final class C26367f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C26366d eRa;
        final /* synthetic */ C42155f eRc;

        C26367f(C26366d c26366d, C42155f c42155f) {
            this.eRa = c26366d;
            this.eRc = c42155f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj;
            Iterable<C42155f> a = this.eRa.ezr;
            if (!((a instanceof Collection) && ((Collection) a).isEmpty())) {
                for (C42155f j : a) {
                    if (C25052j.m39373j(j, this.eRc)) {
                        obj = null;
                        break;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                this.eRa.ezr.add(this.eRc);
            }
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$g */
    static final class C26368g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C26366d eRa;
        final /* synthetic */ C42155f eRc;

        C26368g(C26366d c26366d, C42155f c42155f) {
            this.eRa = c26366d;
            this.eRc = c42155f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eRa.ezr.remove(this.eRc);
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/loader/LoaderCore$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.g.d$a */
    public static final class C26369a {
        private C26369a() {
        }

        public /* synthetic */ C26369a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$b */
    static final class C26370b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C26366d eRa;
        final /* synthetic */ C26365c eRb;
        final /* synthetic */ C42155f eRc;

        C26370b(C26366d c26366d, C26365c c26365c, C42155f c42155f) {
            this.eRa = c26366d;
            this.eRb = c26365c;
            this.eRc = c42155f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj;
            for (Object next : this.eRa.eQV) {
                if (C25052j.m39373j(((C26365c) ((C37884g) next).first).mo9027Pc(), this.eRb.mo9027Pc())) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            C37884g c37884g = (C37884g) obj;
            if (c37884g != null) {
                c37884g.second = this.eRc;
                C4990ab.m7417i("MicroMsg.Loader.DefaultTaskLoader", this.eRa.m41947TO() + "this task already in task in mPendingQueue %s", this.eRb);
                this.eRa.m41949TQ();
            } else {
                for (Object next2 : this.eRa.eQW) {
                    if (C25052j.m39373j(((C26365c) ((C37884g) next2).first).mo9027Pc(), this.eRb.mo9027Pc())) {
                        obj = next2;
                        break;
                    }
                }
                obj = null;
                c37884g = (C37884g) obj;
                if (c37884g != null) {
                    c37884g.second = this.eRc;
                    C4990ab.m7417i("MicroMsg.Loader.DefaultTaskLoader", this.eRa.m41947TO() + "this task already in task in mRunningQueue %s", this.eRb);
                    this.eRa.m41949TQ();
                } else {
                    this.eRa.eQV.add(new C37884g(this.eRb, this.eRc));
                    this.eRa.m41949TQ();
                }
            }
            return C37091y.AUy;
        }
    }

    public C26366d(C37883d c37883d) {
        C25052j.m39376p(c37883d, "configuration");
        this.eQX = c37883d;
    }

    /* renamed from: TO */
    private final String m41947TO() {
        return "name:" + this.eQX.name() + "_this:" + hashCode() + '_';
    }

    /* renamed from: a */
    public final void mo44160a(C42155f<T> c42155f) {
        C25052j.m39376p(c42155f, "callback");
        C8902b.m16042a(new C26367f(this, c42155f));
    }

    /* renamed from: b */
    public final void mo44161b(C42155f<T> c42155f) {
        C25052j.m39376p(c42155f, "callback");
        C8902b.m16042a(new C26368g(this, c42155f));
    }

    /* renamed from: TP */
    private final void m41948TP() {
        if (this.eQT == null) {
            this.eQT = this.eQX.mo33788TR();
        }
    }

    /* renamed from: a */
    public final void mo44158a(T t) {
        C25052j.m39376p(t, "t");
        mo44159a(t, null);
    }

    /* renamed from: a */
    public final void mo44159a(T t, C42155f<T> c42155f) {
        C25052j.m39376p(t, "t");
        C8902b.m16042a(new C26370b(this, t, c42155f));
    }

    /* renamed from: TQ */
    private final boolean m41949TQ() {
        if (this.eQV.size() <= 0) {
            C4990ab.m7416i("MicroMsg.Loader.DefaultTaskLoader", m41947TO() + "DefaultTaskLoader mPendingQueue is empty");
            return false;
        } else if (this.eQW.size() > this.eQX.mo33790TT()) {
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.Loader.DefaultTaskLoader", m41947TO() + "callPrepare RunningQueue %s max_run_task %s mPendingQueue %s", Integer.valueOf(this.eQW.size()), Integer.valueOf(this.eQX.mo33790TT()), Integer.valueOf(this.eQV.size()));
            Object remove = this.eQV.remove(0);
            C25052j.m39375o(remove, "mPendingQueue.removeAt(0)");
            C37884g c37884g = (C37884g) remove;
            this.eQW.add(c37884g);
            if (this.eQX.mo33791TU().mo73213b((C26365c) c37884g.first)) {
                execute(new C18541i((C26365c) c37884g.first, this, new C18538c(this)));
                return true;
            }
            C4990ab.m7420w("MicroMsg.Loader.DefaultTaskLoader", m41947TO() + " block retryStrategy " + c37884g + ".first");
            C42155f c42155f = (C42155f) c37884g.second;
            if (c42155f != null) {
                remove = c37884g.first;
                if (remove == null) {
                    throw new C44941v("null cannot be cast to non-null type T");
                }
                c42155f.mo9004a((C26365c) remove, C45423h.Block);
            }
            return true;
        }
    }

    public final void clean() {
        C8902b.m16042a(new C18539d(this));
    }

    public final void execute(Runnable runnable) {
        C25052j.m39376p(runnable, "runnable");
        m41948TP();
        C26364a c26364a = this.eQT;
        if (c26364a != null) {
            c26364a.execute(runnable);
        }
    }

    /* renamed from: u */
    public final void mo20894u(Runnable runnable) {
        C25052j.m39376p(runnable, "runnable");
        if (this.eQU == null) {
            this.eQU = this.eQX.mo33789TS();
        }
        C26364a c26364a = this.eQU;
        if (c26364a != null) {
            c26364a.execute(runnable);
        }
    }
}
