package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.a.h;
import com.tencent.mm.memory.a.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteGlobal;

public abstract class f<T, V extends c<T>> implements d<T, V> {
    h<T, V> feI;
    b<T, V> feJ = null;
    b<T, V> feK;
    c<T, V> feL;
    a fem = null;

    public abstract T p(T t, T t2);

    public final /* synthetic */ void e(Object obj, Object obj2, Object obj3) {
        c cVar = (c) obj3;
        if (a.feq) {
            ab.i("MicroMsg.UsageLruMap", "update businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, bo.ga((long) this.feI.size()), bo.ga((long) this.feI.maxSize()));
        }
        this.feI.k(p(obj, obj2), cVar);
        this.feJ.aY(obj).k(obj2, cVar);
    }

    public final /* synthetic */ Object f(Object obj, Object obj2, Object obj3) {
        c cVar = (c) obj3;
        if (a.feq) {
            ab.i("MicroMsg.UsageLruMap", "put businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, bo.ga((long) this.feI.size()), bo.ga((long) this.feI.maxSize()));
        }
        c cVar2 = (c) this.feI.put(p(obj, obj2), cVar);
        c cVar3 = (c) this.feJ.aY(obj).put(obj2, cVar);
        if (cVar2 == null) {
            return cVar3;
        }
        return cVar2;
    }

    public f(a aVar, b<T, V> bVar, c<T, V> cVar) {
        this.fem = aVar;
        this.feK = bVar;
        this.feL = cVar;
        this.feI = new h(this.fem.fer, new b<T, V>() {
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(115468);
                c cVar = (c) obj2;
                c cVar2 = (c) obj3;
                if (cVar != null) {
                    if (f.this.feJ.q(cVar.Xp(), cVar.Xq())) {
                        if (a.feq) {
                            ab.i("MicroMsg.UsageLruMap", "implMap RemoveCallback in extraLruMap businessKey:%s key:%s size:%s", r0, r1, bo.ga((long) f.this.feI.size()));
                        }
                        AppMethodBeat.o(115468);
                        return;
                    }
                }
                if (f.this.feK != null) {
                    ab.i("MicroMsg.UsageLruMap", "implMap RemoveCallback not in extraLruMap key:%s size:%s", obj, bo.ga((long) f.this.feI.size()));
                    f.this.feK.c(obj, cVar, cVar2);
                }
                AppMethodBeat.o(115468);
            }
        }, new c<T, V>() {
            public final /* bridge */ /* synthetic */ int l(Object obj, Object obj2) {
                AppMethodBeat.i(115469);
                c cVar = (c) obj2;
                if (f.this.feL != null) {
                    int l = f.this.feL.l(obj, cVar);
                    AppMethodBeat.o(115469);
                    return l;
                }
                AppMethodBeat.o(115469);
                return SQLiteGlobal.journalSizeLimit;
            }
        });
        this.feJ = new b(this.fem, new a<T, V>() {
            public final /* synthetic */ void r(Object obj, Object obj2) {
                AppMethodBeat.i(115470);
                Object p = f.this.p(obj, obj2);
                if (!f.this.feI.aj(p)) {
                    f.this.feI.remove(p);
                }
                AppMethodBeat.o(115470);
            }
        }, new b.b<T, V>() {
            public final /* synthetic */ int d(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(115471);
                c cVar = (c) obj3;
                if (f.this.feL != null) {
                    int l = f.this.feL.l(f.this.p(obj, obj2), cVar);
                    AppMethodBeat.o(115471);
                    return l;
                }
                AppMethodBeat.o(115471);
                return SQLiteGlobal.journalSizeLimit;
            }
        });
    }

    public final boolean q(T t, T t2) {
        return this.feI.aj(p(t, t2)) || this.feJ.q(t, t2);
    }

    public final boolean v(T t, T t2) {
        return this.feI.ak(p(t, t2)) || this.feJ.aY(t).ak(t2);
    }

    public final void trimToSize(int i) {
        this.feI.trimToSize(i);
    }

    public final int size() {
        return this.feI.size();
    }

    public final /* synthetic */ Object u(Object obj, Object obj2) {
        c cVar = (c) this.feI.ai(p(obj, obj2));
        c cVar2 = (c) this.feJ.aY(obj).ai(obj2);
        if (cVar == null) {
            return cVar2;
        }
        return cVar;
    }

    public final /* synthetic */ Object t(Object obj, Object obj2) {
        c cVar = (c) this.feI.get(p(obj, obj2));
        c cVar2 = (c) this.feJ.aY(obj).get(obj2);
        if (cVar == null) {
            return cVar2;
        }
        return cVar;
    }

    public final /* synthetic */ Object s(Object obj, Object obj2) {
        c cVar = (c) this.feI.remove(p(obj, obj2));
        c cVar2 = (c) this.feJ.aY(obj).remove(obj2);
        if (cVar == null) {
            return cVar2;
        }
        return cVar;
    }
}
