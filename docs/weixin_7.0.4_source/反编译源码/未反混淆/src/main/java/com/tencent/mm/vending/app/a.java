package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.d;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.g.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements com.tencent.mm.vending.e.b {
    Map<Class, a> c = new ConcurrentHashMap();
    byte[] d = new byte[0];
    private AtomicBoolean f = new AtomicBoolean(false);
    volatile boolean g = false;
    Context j;
    private c zWX = new c();
    public c<Vending> zWY = new c();
    com.tencent.mm.vending.base.a<Object> zXc = new com.tencent.mm.vending.base.a<Object>() {
        public final /* synthetic */ Object resolveAsynchronous(Object obj) {
            AppMethodBeat.i(126095);
            Object aH = aH((Class) obj);
            AppMethodBeat.o(126095);
            return aH;
        }

        public final Object aH(Class<?> cls) {
            AppMethodBeat.i(126094);
            a aVar = (a) a.this.c.get(cls);
            if (aVar != null) {
                aVar.c = true;
                Object aoq = aVar.aoq();
                aVar.c = false;
                if (aVar.b) {
                    aVar.zXg = defer(cls);
                } else {
                    AppMethodBeat.o(126094);
                    return aoq;
                }
            }
            AppMethodBeat.o(126094);
            return null;
        }
    };
    Map<Class, com.tencent.mm.vending.b.c<b>> zXd = new HashMap();
    public com.tencent.mm.vending.d.a zXe;

    public abstract class a<_Struct> {
        boolean b = false;
        boolean c = false;
        d zXg;

        public abstract _Struct aoq();
    }

    public interface b<_Struct> {
        void bj(_Struct _struct);
    }

    public a() {
        this.zWY.keep(this.zXc);
        this.zXc.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {
            public final /* synthetic */ void cP(Object obj) {
                AppMethodBeat.i(126100);
                Class cls = (Class) obj;
                com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) a.this.zXd.get(cls);
                if (cVar != null) {
                    cVar.a(f.cV(a.this.zXc.get(cls)));
                }
                AppMethodBeat.o(126100);
            }
        });
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        this.zWX.keep(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.zXd.get(cls);
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.b.c<b>(com.tencent.mm.vending.h.d.zYp) {
                public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                    AppMethodBeat.i(126093);
                    ((b) obj).bj(aVar.get(0));
                    AppMethodBeat.o(126093);
                }
            };
            this.zXd.put(cls, cVar);
        }
        cVar.aD(bVar);
        Object peek = this.zXc.peek(cls);
        if (peek != null) {
            bVar.bj(peek);
        }
    }

    public final <_Struct> _Struct x(Class<_Struct> cls) {
        c();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.g) {
            synchronized (this.d) {
                if (!this.g) {
                    try {
                        this.d.wait();
                    } catch (InterruptedException e) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.zXc.get(cls);
    }

    public final void aG(Class<?> cls) {
        c();
        this.zXc.request(cls);
    }

    /* Access modifiers changed, original: protected|final */
    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        c();
        this.c.put(cls, aVar);
    }

    private void c() {
        if (Looper.myLooper() == this.zXc.getLooper() && !this.f.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
        this.f.set(true);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        this.zWX.dead();
        this.zWY.dead();
    }
}
