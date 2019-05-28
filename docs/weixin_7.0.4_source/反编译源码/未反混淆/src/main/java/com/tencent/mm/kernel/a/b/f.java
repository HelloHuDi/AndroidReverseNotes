package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class f<T> extends com.tencent.mm.kernel.a.a.a<T> implements c<T> {
    private c<T> eLM;
    private d<T> eLS;
    public Class eLT;
    private volatile boolean eLU = false;

    public static class b {
        public com.tencent.mm.ci.b eMd = new com.tencent.mm.ci.b();

        public b() {
            AppMethodBeat.i(123335);
            AppMethodBeat.o(123335);
        }
    }

    public static class a<T> extends com.tencent.mm.kernel.a.a.a.a<T> {
        volatile int eLV;
        private boolean eLW;
        volatile boolean eLX;
        public volatile a eLY;
        public volatile a eLZ;
        public h eMa;
        private c eMb;
        public b eMc;

        /* synthetic */ a(Object obj, Class cls, c cVar, byte b) {
            this(obj, cls, cVar);
        }

        private a(T t, Class cls, c cVar) {
            super(t);
            AppMethodBeat.i(123327);
            this.eLV = 0;
            this.eLW = false;
            this.eLX = false;
            this.eMa = new h();
            this.eMc = new b();
            this.eMa.eLE = cls;
            this.eMb = cVar;
            AppMethodBeat.o(123327);
        }

        public final void a(com.tencent.mm.kernel.a.a.a.a aVar) {
            AppMethodBeat.i(123328);
            super.a(aVar);
            synchronized (this) {
                try {
                    this.eLV++;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(123328);
                }
            }
        }

        private boolean Sx() {
            return this.eLV == 0 && (this.eLY == null || this.eLY.eLB);
        }

        public final synchronized boolean Sy() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.i(123330);
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
                ab.d(str, str2, objArr);
                if (this.eLX) {
                    AppMethodBeat.o(123330);
                } else if (Sx()) {
                    ab.i("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    this.eLX = true;
                    notify();
                    AppMethodBeat.o(123330);
                    z = true;
                } else {
                    AppMethodBeat.o(123330);
                }
            }
            return z;
        }

        private synchronized boolean Sz() {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(123331);
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
                ab.i(str, str2, objArr);
                if (this.eLX) {
                    AppMethodBeat.o(123331);
                } else {
                    z = Sx();
                    AppMethodBeat.o(123331);
                }
            }
            return z;
        }

        private synchronized void SA() {
            AppMethodBeat.i(123332);
            try {
                if (this.eLX) {
                    ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    AppMethodBeat.o(123332);
                } else {
                    ab.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    wait();
                    ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.eLB), this.eMa.eLE);
                    AppMethodBeat.o(123332);
                }
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MMSkeleton.ParallelsDependencies", e, "", new Object[0]);
                AppMethodBeat.o(123332);
            }
            return;
        }

        public final synchronized boolean SB() {
            boolean Sy;
            AppMethodBeat.i(123333);
            this.eLV--;
            Sy = Sy();
            AppMethodBeat.o(123333);
            return Sy;
        }

        public final String toString() {
            AppMethodBeat.i(123334);
            String str = super.toString() + " - with type " + this.eMa.eLE;
            AppMethodBeat.o(123334);
            return str;
        }

        public final void a(com.tencent.mm.vending.c.a aVar) {
            AppMethodBeat.i(123329);
            if (!this.eLB) {
                if (!Sz()) {
                    int i;
                    HashSet Sj = Sj();
                    Assert.assertNotNull(Sj);
                    Iterator it = Sj.iterator();
                    while (it.hasNext()) {
                        if (!((a) ((com.tencent.mm.kernel.a.a.a.a) it.next())).eLB) {
                            ab.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, (com.tencent.mm.kernel.a.a.a.a) it.next());
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i != 0) {
                        SA();
                    }
                }
                this.eMc.eMd.dOV();
                if (!this.eLB) {
                    j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.eMa.eLE);
                    aVar.call(this);
                    this.eLB = true;
                }
                this.eMc.eMd.done();
            }
            AppMethodBeat.o(123329);
        }
    }

    public f(Class cls, d<T> dVar, c cVar) {
        this.eLT = cls;
        this.eLS = dVar;
        this.eLM = cVar;
    }

    public final com.tencent.mm.kernel.a.a.a.a<T> aE(T t) {
        AppMethodBeat.i(123336);
        if (!this.eLx.containsKey(t)) {
            this.eLx.putIfAbsent(t, new a(t, this.eLT, this.eLM, (byte) 0));
        }
        com.tencent.mm.kernel.a.a.a.a aVar = (com.tencent.mm.kernel.a.a.a.a) this.eLx.get(t);
        AppMethodBeat.o(123336);
        return aVar;
    }

    public final a<T> aK(T t) {
        AppMethodBeat.i(123337);
        a aVar = (a) this.eLx.get(t);
        AppMethodBeat.o(123337);
        return aVar;
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(123338);
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.eLx.values()) {
            a aVar2 = (a) aVar;
            if (z) {
                aVar2.eLB = false;
            }
            synchronized (aVar2) {
                try {
                    aVar2.eLV = aVar2.Sk();
                    aVar2.eLX = false;
                } catch (Throwable th) {
                    AppMethodBeat.o(123338);
                }
            }
        }
        AppMethodBeat.o(123338);
    }

    public final void prepare() {
        AppMethodBeat.i(123339);
        ab.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.eLT);
        Assert.assertNotNull(this.eLS);
        this.eLU = true;
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.eLx.values()) {
            if (aVar.Sl()) {
                a aVar2 = (a) aVar;
                ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", aVar2);
                if (aVar2.Sy()) {
                    this.eLS.b(aVar2);
                }
                ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", aVar2);
            }
        }
        ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.eLT);
        AppMethodBeat.o(123339);
    }

    public final a<T> Sp() {
        AppMethodBeat.i(123340);
        a Sp = this.eLS.Sp();
        AppMethodBeat.o(123340);
        return Sp;
    }

    public final void a(a<T> aVar) {
        AppMethodBeat.i(123341);
        HashSet Si = aVar.Si();
        if (Si != null) {
            Iterator it = Si.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) ((com.tencent.mm.kernel.a.a.a.a) it.next());
                if (aVar2.SB()) {
                    this.eLS.b(aVar2);
                }
            }
        }
        AppMethodBeat.o(123341);
    }

    public final void aL(Object obj) {
        AppMethodBeat.i(123342);
        a aVar = (a) this.eLx.get(obj);
        if (aVar.eLA != ((a) obj).eLA) {
            ab.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", aVar, aVar.eLA, obj, this.eLx.get(obj));
        }
        if (this.eLU && aVar.Sy()) {
            this.eLS.b(aVar);
        }
        AppMethodBeat.o(123342);
    }

    public final List<com.tencent.mm.kernel.a.a.a.a> Sw() {
        AppMethodBeat.i(123343);
        ArrayList arrayList = new ArrayList(1);
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.eLx.values()) {
            if (!((a) aVar).eLB) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s";
                Object[] objArr = new Object[4];
                objArr[0] = aVar;
                objArr[1] = Integer.valueOf(((a) aVar).eLV);
                objArr[2] = ((a) aVar).eLY;
                objArr[3] = ((a) aVar).eLY != null ? Boolean.valueOf(((a) aVar).eLY.eLB) : "";
                ab.e(str, str2, objArr);
                arrayList.add(aVar);
            }
        }
        AppMethodBeat.o(123343);
        return arrayList;
    }
}
