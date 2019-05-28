package com.tencent.p177mm.kernel.p238a.p240b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.p238a.p239a.C1649a;
import com.tencent.p177mm.kernel.p238a.p239a.C1649a.C1648a;
import com.tencent.p177mm.p217ci.C1388b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.b.f */
public final class C6597f<T> extends C1649a<T> implements C1656c<T> {
    private C1656c<T> eLM;
    private C1657d<T> eLS;
    public Class eLT;
    private volatile boolean eLU = false;

    /* renamed from: com.tencent.mm.kernel.a.b.f$b */
    public static class C1663b {
        public C1388b eMd = new C1388b();

        public C1663b() {
            AppMethodBeat.m2504i(123335);
            AppMethodBeat.m2505o(123335);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.b.f$a */
    public static class C6596a<T> extends C1648a<T> {
        volatile int eLV;
        private boolean eLW;
        volatile boolean eLX;
        public volatile C6596a eLY;
        public volatile C6596a eLZ;
        public C1665h eMa;
        private C1656c eMb;
        public C1663b eMc;

        /* synthetic */ C6596a(Object obj, Class cls, C1656c c1656c, byte b) {
            this(obj, cls, c1656c);
        }

        private C6596a(T t, Class cls, C1656c c1656c) {
            super(t);
            AppMethodBeat.m2504i(123327);
            this.eLV = 0;
            this.eLW = false;
            this.eLX = false;
            this.eMa = new C1665h();
            this.eMc = new C1663b();
            this.eMa.eLE = cls;
            this.eMb = c1656c;
            AppMethodBeat.m2505o(123327);
        }

        /* renamed from: a */
        public final void mo5113a(C1648a c1648a) {
            AppMethodBeat.m2504i(123328);
            super.mo5113a(c1648a);
            synchronized (this) {
                try {
                    this.eLV++;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(123328);
                }
            }
        }

        /* renamed from: Sx */
        private boolean m10857Sx() {
            return this.eLV == 0 && (this.eLY == null || this.eLY.eLB);
        }

        /* renamed from: Sy */
        public final synchronized boolean mo14807Sy() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.m2504i(123330);
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolvedAndSwallowIt for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.eLA;
                objArr[1] = this.eMa.eLE;
                objArr[2] = Boolean.valueOf(this.eLX);
                objArr[3] = Integer.valueOf(this.eLV);
                objArr[4] = this.eLY;
                objArr[5] = this.eLY != null ? Boolean.valueOf(this.eLY.eLB) : "";
                objArr[6] = this.eMa.eMm;
                C4990ab.m7411d(str, str2, objArr);
                if (this.eLX) {
                    AppMethodBeat.m2505o(123330);
                } else if (m10857Sx()) {
                    C4990ab.m7417i("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    this.eLX = true;
                    notify();
                    AppMethodBeat.m2505o(123330);
                    z = true;
                } else {
                    AppMethodBeat.m2505o(123330);
                }
            }
            return z;
        }

        /* renamed from: Sz */
        private synchronized boolean m10858Sz() {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.m2504i(123331);
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolved for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.eLA;
                objArr[1] = this.eMa.eLE;
                objArr[2] = Boolean.valueOf(this.eLX);
                objArr[3] = Integer.valueOf(this.eLV);
                objArr[4] = this.eLY;
                objArr[5] = this.eLY != null ? Boolean.valueOf(this.eLY.eLB) : "";
                objArr[6] = this.eMa.eMm;
                C4990ab.m7417i(str, str2, objArr);
                if (this.eLX) {
                    AppMethodBeat.m2505o(123331);
                } else {
                    z = m10857Sx();
                    AppMethodBeat.m2505o(123331);
                }
            }
            return z;
        }

        /* renamed from: SA */
        private synchronized void m10856SA() {
            AppMethodBeat.m2504i(123332);
            try {
                if (this.eLX) {
                    C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    AppMethodBeat.m2505o(123332);
                } else {
                    C4990ab.m7416i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    wait();
                    C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    AppMethodBeat.m2505o(123332);
                }
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MMSkeleton.ParallelsDependencies", e, "", new Object[0]);
                AppMethodBeat.m2505o(123332);
            }
            return;
        }

        /* renamed from: SB */
        public final synchronized boolean mo14806SB() {
            boolean Sy;
            AppMethodBeat.m2504i(123333);
            this.eLV--;
            Sy = mo14807Sy();
            AppMethodBeat.m2505o(123333);
            return Sy;
        }

        public final String toString() {
            AppMethodBeat.m2504i(123334);
            String str = super.toString() + " - with type " + this.eMa.eLE;
            AppMethodBeat.m2505o(123334);
            return str;
        }

        /* renamed from: a */
        public final void mo14808a(C5681a c5681a) {
            AppMethodBeat.m2504i(123329);
            if (!this.eLB) {
                if (!m10858Sz()) {
                    int i;
                    HashSet Sj = mo5108Sj();
                    Assert.assertNotNull(Sj);
                    Iterator it = Sj.iterator();
                    while (it.hasNext()) {
                        if (!((C6596a) ((C1648a) it.next())).eLB) {
                            C4990ab.m7417i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, (C1648a) it.next());
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i != 0) {
                        m10856SA();
                    }
                }
                this.eMc.eMd.dOV();
                if (!this.eLB) {
                    C1736j.m3587i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.eMa.eLE);
                    c5681a.call(this);
                    this.eLB = true;
                }
                this.eMc.eMd.done();
            }
            AppMethodBeat.m2505o(123329);
        }
    }

    public C6597f(Class cls, C1657d<T> c1657d, C1656c c1656c) {
        this.eLT = cls;
        this.eLS = c1657d;
        this.eLM = c1656c;
    }

    /* renamed from: aE */
    public final C1648a<T> mo5117aE(T t) {
        AppMethodBeat.m2504i(123336);
        if (!this.eLx.containsKey(t)) {
            this.eLx.putIfAbsent(t, new C6596a(t, this.eLT, this.eLM, (byte) 0));
        }
        C1648a c1648a = (C1648a) this.eLx.get(t);
        AppMethodBeat.m2505o(123336);
        return c1648a;
    }

    /* renamed from: aK */
    public final C6596a<T> mo14810aK(T t) {
        AppMethodBeat.m2504i(123337);
        C6596a c6596a = (C6596a) this.eLx.get(t);
        AppMethodBeat.m2505o(123337);
        return c6596a;
    }

    public final void reset(boolean z) {
        AppMethodBeat.m2504i(123338);
        for (C1648a c1648a : this.eLx.values()) {
            C6596a c6596a = (C6596a) c1648a;
            if (z) {
                c6596a.eLB = false;
            }
            synchronized (c6596a) {
                try {
                    c6596a.eLV = c6596a.mo5109Sk();
                    c6596a.eLX = false;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(123338);
                }
            }
        }
        AppMethodBeat.m2505o(123338);
    }

    public final void prepare() {
        AppMethodBeat.m2504i(123339);
        C4990ab.m7417i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.eLT);
        Assert.assertNotNull(this.eLS);
        this.eLU = true;
        for (C1648a c1648a : this.eLx.values()) {
            if (c1648a.mo5110Sl()) {
                C6596a c6596a = (C6596a) c1648a;
                C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", c6596a);
                if (c6596a.mo14807Sy()) {
                    this.eLS.mo5135b(c6596a);
                }
                C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", c6596a);
            }
        }
        C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.eLT);
        AppMethodBeat.m2505o(123339);
    }

    /* renamed from: Sp */
    public final C6596a<T> mo5131Sp() {
        AppMethodBeat.m2504i(123340);
        C6596a Sp = this.eLS.mo5134Sp();
        AppMethodBeat.m2505o(123340);
        return Sp;
    }

    /* renamed from: a */
    public final void mo5132a(C6596a<T> c6596a) {
        AppMethodBeat.m2504i(123341);
        HashSet Si = c6596a.mo5107Si();
        if (Si != null) {
            Iterator it = Si.iterator();
            while (it.hasNext()) {
                C6596a c6596a2 = (C6596a) ((C1648a) it.next());
                if (c6596a2.mo14806SB()) {
                    this.eLS.mo5135b(c6596a2);
                }
            }
        }
        AppMethodBeat.m2505o(123341);
    }

    /* renamed from: aL */
    public final void mo14811aL(Object obj) {
        AppMethodBeat.m2504i(123342);
        C6596a c6596a = (C6596a) this.eLx.get(obj);
        if (c6596a.eLA != ((C6596a) obj).eLA) {
            C4990ab.m7413e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", c6596a, c6596a.eLA, obj, this.eLx.get(obj));
        }
        if (this.eLU && c6596a.mo14807Sy()) {
            this.eLS.mo5135b(c6596a);
        }
        AppMethodBeat.m2505o(123342);
    }

    /* renamed from: Sw */
    public final List<C1648a> mo14809Sw() {
        AppMethodBeat.m2504i(123343);
        ArrayList arrayList = new ArrayList(1);
        for (C1648a c1648a : this.eLx.values()) {
            if (!((C6596a) c1648a).eLB) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s";
                Object[] objArr = new Object[4];
                objArr[0] = c1648a;
                objArr[1] = Integer.valueOf(((C6596a) c1648a).eLV);
                objArr[2] = ((C6596a) c1648a).eLY;
                objArr[3] = ((C6596a) c1648a).eLY != null ? Boolean.valueOf(((C6596a) c1648a).eLY.eLB) : "";
                C4990ab.m7413e(str, str2, objArr);
                arrayList.add(c1648a);
            }
        }
        AppMethodBeat.m2505o(123343);
        return arrayList;
    }
}
