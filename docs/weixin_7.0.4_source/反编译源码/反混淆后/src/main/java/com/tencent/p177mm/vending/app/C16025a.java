package com.tencent.p177mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.base.C5679a;
import com.tencent.p177mm.vending.base.C5679a.C5680a;
import com.tencent.p177mm.vending.base.Vending;
import com.tencent.p177mm.vending.base.Vending.C24131d;
import com.tencent.p177mm.vending.p636b.C24124c;
import com.tencent.p177mm.vending.p638d.C30834a;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.p177mm.vending.p639e.C7359c;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.vending.app.a */
public abstract class C16025a implements C5685b {
    /* renamed from: c */
    Map<Class, C16026a> f3000c = new ConcurrentHashMap();
    /* renamed from: d */
    byte[] f3001d = new byte[0];
    /* renamed from: f */
    private AtomicBoolean f3002f = new AtomicBoolean(false);
    /* renamed from: g */
    volatile boolean f3003g = false;
    /* renamed from: j */
    Context f3004j;
    private C7359c zWX = new C7359c();
    public C7359c<Vending> zWY = new C7359c();
    C5679a<Object> zXc = new C160291();
    Map<Class, C24124c<C16028b>> zXd = new HashMap();
    public C30834a zXe;

    /* renamed from: com.tencent.mm.vending.app.a$a */
    public abstract class C16026a<_Struct> {
        /* renamed from: b */
        boolean f3005b = false;
        /* renamed from: c */
        boolean f3006c = false;
        C24131d zXg;

        public abstract _Struct aoq();
    }

    /* renamed from: com.tencent.mm.vending.app.a$b */
    public interface C16028b<_Struct> {
        /* renamed from: bj */
        void mo28394bj(_Struct _struct);
    }

    /* renamed from: com.tencent.mm.vending.app.a$1 */
    class C160291 extends C5679a<Object> {
        C160291() {
        }

        public final /* synthetic */ Object resolveAsynchronous(Object obj) {
            AppMethodBeat.m2504i(126095);
            Object aH = mo11564aH((Class) obj);
            AppMethodBeat.m2505o(126095);
            return aH;
        }

        /* renamed from: aH */
        public final Object mo11564aH(Class<?> cls) {
            AppMethodBeat.m2504i(126094);
            C16026a c16026a = (C16026a) C16025a.this.f3000c.get(cls);
            if (c16026a != null) {
                c16026a.f3006c = true;
                Object aoq = c16026a.aoq();
                c16026a.f3006c = false;
                if (c16026a.f3005b) {
                    c16026a.zXg = defer(cls);
                } else {
                    AppMethodBeat.m2505o(126094);
                    return aoq;
                }
            }
            AppMethodBeat.m2505o(126094);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.vending.app.a$2 */
    class C160302 implements C5680a {
        C160302() {
        }

        /* renamed from: cP */
        public final /* synthetic */ void mo28395cP(Object obj) {
            AppMethodBeat.m2504i(126100);
            Class cls = (Class) obj;
            C24124c c24124c = (C24124c) C16025a.this.zXd.get(cls);
            if (c24124c != null) {
                c24124c.mo39927a(C5698f.m8560cV(C16025a.this.zXc.get(cls)));
            }
            AppMethodBeat.m2505o(126100);
        }
    }

    public C16025a() {
        this.zWY.keep(this.zXc);
        this.zXc.addVendingDataResolvedCallback(new C160302());
    }

    public void keep(C5684a c5684a) {
        this.zWX.keep(c5684a);
    }

    /* renamed from: a */
    public final <_Struct> void mo28388a(Class<_Struct> cls, C16028b<_Struct> c16028b) {
        C24124c c24124c = (C24124c) this.zXd.get(cls);
        if (c24124c == null) {
            c24124c = new C24124c<C16028b>(C5703d.zYp) {
                /* renamed from: a */
                public final /* synthetic */ void mo28393a(Object obj, C5710a c5710a) {
                    AppMethodBeat.m2504i(126093);
                    ((C16028b) obj).mo28394bj(c5710a.get(0));
                    AppMethodBeat.m2505o(126093);
                }
            };
            this.zXd.put(cls, c24124c);
        }
        c24124c.mo39928aD(c16028b);
        Object peek = this.zXc.peek(cls);
        if (peek != null) {
            c16028b.mo28394bj(peek);
        }
    }

    /* renamed from: x */
    public final <_Struct> _Struct mo28391x(Class<_Struct> cls) {
        m24338c();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.f3003g) {
            synchronized (this.f3001d) {
                if (!this.f3003g) {
                    try {
                        this.f3001d.wait();
                    } catch (InterruptedException e) {
                        C5687a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.zXc.get(cls);
    }

    /* renamed from: aG */
    public final void mo28389aG(Class<?> cls) {
        m24338c();
        this.zXc.request(cls);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final <_Struct> void mo28387a(Class<_Struct> cls, C16026a<_Struct> c16026a) {
        m24338c();
        this.f3000c.put(cls, c16026a);
    }

    /* renamed from: c */
    private void m24338c() {
        if (Looper.myLooper() == this.zXc.getLooper() && !this.f3002f.get()) {
            C5687a.m8541e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
        this.f3002f.set(true);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        this.zWX.dead();
        this.zWY.dead();
    }
}
