package com.tencent.mm.audio.mix.e;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c {
    protected Object ckQ = new Object();
    volatile LinkedList<String> ckw = new LinkedList();
    protected AtomicBoolean clS = new AtomicBoolean(false);
    protected AtomicBoolean clT = new AtomicBoolean(false);
    private Object cmA = new Object();
    private List<d> cmB = new ArrayList();
    private volatile HashMap<String, Boolean> cmC = new HashMap();
    private volatile HashMap<String, Boolean> cmD = new HashMap();
    private volatile HashMap<String, Integer> cmE = new HashMap();
    private volatile HashMap<String, Long> cmF = new HashMap();
    public long cmG = 0;
    private boolean cmH = false;
    int cmI = 0;
    long cmJ = 0;
    private long cmK = 0;
    private long cmL = 0;
    private Runnable cmM = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137087);
            Process.setThreadPriority(-19);
            if (c.this.DB()) {
                b.e("MicroMsg.Mix.AudioMixController", "stop and exit");
                AppMethodBeat.o(137087);
                return;
            }
            while (!c.this.DB()) {
                c.this.DV();
                if (c.this.DB()) {
                    AppMethodBeat.o(137087);
                    return;
                }
                System.nanoTime();
                List DY = c.this.DY();
                if (DY.size() > 0) {
                    long nanoTime = System.nanoTime();
                    com.tencent.mm.audio.mix.a.b I = c.this.cmq.I(DY);
                    long nanoTime2 = System.nanoTime();
                    c cVar = c.this;
                    cVar.cmI++;
                    c.this.cmJ = (nanoTime2 - nanoTime) + c.this.cmJ;
                    if (I != null) {
                        cVar = c.this;
                        I.ckw.addAll(cVar.ckw);
                        cVar.ckw.clear();
                        com.tencent.mm.audio.mix.f.d dVar = cVar.cmr;
                        if (dVar.cnw.get()) {
                            b.e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
                        } else {
                            synchronized (dVar.cny) {
                                while (dVar.cnx.size() >= 2 && !dVar.cnw.get()) {
                                    try {
                                        dVar.cny.wait();
                                    } catch (InterruptedException e) {
                                        b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "enqueueMixBuffer", new Object[0]);
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(137087);
                                    }
                                }
                                dVar.cnx.add(I);
                                dVar.cny.notifyAll();
                            }
                        }
                    }
                    c.H(DY);
                    DY.clear();
                }
            }
            b.i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
            AppMethodBeat.o(137087);
        }
    };
    public i cmq;
    com.tencent.mm.audio.mix.f.d cmr;
    protected AtomicBoolean cms = new AtomicBoolean(false);
    protected volatile HashMap<String, Boolean> cmt = new HashMap();
    private Thread cmu;
    private volatile LinkedList<String> cmv = new LinkedList();
    private volatile HashMap<String, Object> cmw = new HashMap();
    public volatile HashMap<String, List<d>> cmx = new HashMap();
    private volatile HashMap<String, Boolean> cmy = new HashMap();
    public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.d.c>> cmz = new HashMap();

    public c(com.tencent.mm.audio.mix.f.d dVar) {
        AppMethodBeat.i(137088);
        this.cmr = dVar;
        AppMethodBeat.o(137088);
    }

    public final void DR() {
        AppMethodBeat.i(137089);
        b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
        this.clT.set(false);
        this.clS.set(false);
        Ea();
        DU();
        AppMethodBeat.o(137089);
    }

    public final void DS() {
        AppMethodBeat.i(137090);
        b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
        this.clS.set(true);
        if (this.cmI > 0) {
            this.cmG = this.cmJ / ((long) this.cmI);
            b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", Long.valueOf(this.cmG));
        }
        this.cmK = 0;
        this.cmI = 0;
        this.cmJ = 0;
        this.cmL = 0;
        AppMethodBeat.o(137090);
    }

    public final void DT() {
        AppMethodBeat.i(137091);
        b.i("MicroMsg.Mix.AudioMixController", "stopMix");
        this.clT.set(true);
        this.clS.set(false);
        DU();
        synchronized (this.cmA) {
            try {
                DW();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137091);
            }
        }
        DZ();
        Eb();
    }

    private void DU() {
        AppMethodBeat.i(137092);
        synchronized (this.ckQ) {
            try {
                this.ckQ.notify();
            } catch (Exception e) {
                b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "notifyMix", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(137092);
            }
        }
        AppMethodBeat.o(137092);
    }

    public final void DV() {
        AppMethodBeat.i(137093);
        synchronized (this.ckQ) {
            while (!this.clT.get() && this.clS.get()) {
                try {
                    b.i("MicroMsg.Mix.AudioMixController", "waitMix");
                    this.ckQ.wait();
                } catch (Exception e) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "waitMix", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(137093);
                }
            }
        }
        AppMethodBeat.o(137093);
    }

    private void DW() {
        AppMethodBeat.i(137094);
        try {
            this.cmA.notifyAll();
            AppMethodBeat.o(137094);
        } catch (Exception e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "notifySyncPcmData", new Object[0]);
            AppMethodBeat.o(137094);
        }
    }

    public final void dI(String str) {
        AppMethodBeat.i(137097);
        this.cmt.put(str, Boolean.TRUE);
        dK(str);
        if (this.cmv.isEmpty()) {
            b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
            this.cms.set(true);
            this.cmr.DL();
            AppMethodBeat.o(137097);
            return;
        }
        this.cms.set(false);
        AppMethodBeat.o(137097);
    }

    public final boolean DX() {
        AppMethodBeat.i(137098);
        boolean z = this.cms.get();
        AppMethodBeat.o(137098);
        return z;
    }

    public final boolean dJ(String str) {
        boolean booleanValue;
        AppMethodBeat.i(137099);
        synchronized (this.cmA) {
            try {
                if (this.cmy.containsKey(str)) {
                    booleanValue = ((Boolean) this.cmy.get(str)).booleanValue();
                } else {
                    booleanValue = false;
                    AppMethodBeat.o(137099);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137099);
            }
        }
        return booleanValue;
    }

    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dK(String str) {
        int i = 137100;
        AppMethodBeat.i(137100);
        synchronized (this.cmA) {
            int i2;
            try {
                if (this.cmv.contains(str)) {
                    this.cmv.remove(str);
                    i2 = this.cmw.get(str);
                    List list = (List) this.cmx.remove(str);
                    if (i2 != 0) {
                        synchronized (i2) {
                            H(list);
                            list.clear();
                        }
                    } else {
                        H(list);
                        list.clear();
                    }
                    this.cmw.remove(str);
                    this.cmy.remove(str);
                    this.cmC.remove(str);
                    this.cmD.remove(str);
                    if (this.clS.get()) {
                        DW();
                    }
                    this.cmE.remove(str);
                    this.cmF.remove(str);
                } else {
                    i2 = "The audio of the id is remove";
                    b.e("MicroMsg.Mix.AudioMixController", i2);
                }
            } catch (Throwable th) {
                while (true) {
                }
                i2 = 137100;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.tencent.mm.audio.mix.e.c.dK(java.lang.String):void, dex: classes3.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: INVOKE  (wrap: int
  ?: MERGE  (r3_1 int) = (r3_0 'i' int), (r2_5 'i2' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.audio.mix.e.c.dK(java.lang.String):void, dex: classes3.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_1 int) = (r3_0 'i' int), (r2_5 'i2' int) in method: com.tencent.mm.audio.mix.e.c.dK(java.lang.String):void, dex: classes3.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    public final boolean w(String str, int i) {
        AppMethodBeat.i(137101);
        if (!this.cmv.contains(str)) {
            AppMethodBeat.o(137101);
            return false;
        } else if (i < 0) {
            this.cmE.remove(str);
            AppMethodBeat.o(137101);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 0) {
                this.cmE.remove(str);
            } else {
                this.cmE.put(str, Integer.valueOf(i));
            }
            List list = (List) this.cmx.get(str);
            if (list == null || list.size() == 0) {
                this.cmE.remove(str);
                AppMethodBeat.o(137101);
                return false;
            }
            com.tencent.mm.ag.b dQ = this.cmr.dQ(str);
            if (dQ == null) {
                this.cmE.remove(str);
                AppMethodBeat.o(137101);
                return false;
            }
            b.i("MicroMsg.Mix.AudioMixController", "seekTo begin");
            boolean dJ = dJ(str);
            if (!dJ) {
                dH(str);
            }
            int size = list.size();
            com.tencent.mm.audio.mix.a.c dv = com.tencent.mm.audio.mix.b.d.Dm().dv(dQ.filePath);
            int size2 = dv.size();
            int i2 = i / 20;
            int dL = (int) (dL(str) / 20);
            Object obj = this.cmw.get(str);
            if (obj == null) {
                this.cmE.remove(str);
                AppMethodBeat.o(137101);
                return false;
            }
            if (i2 > dL && i2 <= size2) {
                b.e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos > currentPos");
                int i3 = i2 - dL;
                synchronized (obj) {
                    dL = 0;
                    while (dL < i3 && i3 <= size) {
                        try {
                            list.remove(list.size() - 1);
                            dL++;
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(137101);
                            }
                        }
                    }
                }
            } else if (i2 < dL && dL <= size2) {
                b.e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos");
                synchronized (obj) {
                    while (dL > i2) {
                        try {
                            d gv = dv.gv(dL);
                            if (gv != null) {
                                list.add(list.size(), gv);
                            }
                            dL--;
                        } catch (Throwable th2) {
                            AppMethodBeat.o(137101);
                        }
                    }
                }
            }
            if (!dJ) {
                synchronized (this.cmA) {
                    try {
                        if (this.cmy.containsKey(str)) {
                            this.cmy.put(str, Boolean.FALSE);
                        } else {
                            b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                        }
                    } catch (Throwable th3) {
                        AppMethodBeat.o(137101);
                    }
                }
                synchronized (this.cmA) {
                    try {
                        DW();
                    } catch (Throwable th4) {
                        while (true) {
                            AppMethodBeat.o(137101);
                        }
                    }
                }
            }
            b.i("MicroMsg.Mix.AudioMixController", "seekTo end, time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(137101);
            return true;
        }
    }

    public final long dL(String str) {
        long longValue;
        AppMethodBeat.i(137102);
        synchronized (this.cmA) {
            try {
                if (this.cmF.containsKey(str)) {
                    longValue = ((Long) this.cmF.get(str)).longValue();
                } else {
                    AppMethodBeat.o(137102);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137102);
            }
        }
        return longValue;
    }

    public final boolean dM(String str) {
        AppMethodBeat.i(137103);
        if (this.cmv.contains(str)) {
            List list = (List) this.cmx.get(str);
            if (list == null || list.size() == 0) {
                b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
                AppMethodBeat.o(137103);
                return true;
            }
            AppMethodBeat.o(137103);
            return false;
        }
        AppMethodBeat.o(137103);
        return true;
    }

    public final void l(String str, boolean z) {
        AppMethodBeat.i(137104);
        synchronized (this.cmA) {
            try {
                this.cmC.put(str, Boolean.valueOf(z));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137104);
            }
        }
    }

    private boolean dN(String str) {
        AppMethodBeat.i(137105);
        synchronized (this.cmA) {
            try {
                if (!this.cmC.containsKey(str) || !((Boolean) this.cmC.get(str)).booleanValue()) {
                    AppMethodBeat.o(137105);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137105);
            }
        }
        return true;
    }

    private void dO(String str) {
        AppMethodBeat.i(137106);
        this.cmr.i(5, str);
        dK(str);
        AppMethodBeat.o(137106);
    }

    public final boolean DB() {
        AppMethodBeat.i(139130);
        boolean z = this.clT.get();
        AppMethodBeat.o(139130);
        return z;
    }

    /* JADX WARNING: Missing block: B:52:0x00d0, code skipped:
            r2 = r7.cmA;
     */
    /* JADX WARNING: Missing block: B:53:0x00d2, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            r7.cmA.notifyAll();
     */
    /* JADX WARNING: Missing block: B:63:0x00e8, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:65:?, code skipped:
            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", r1, "writePcmDataTrack", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:67:0x00f8, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(137108);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(String str, d dVar, com.tencent.mm.audio.mix.d.c cVar) {
        List list;
        int i = 0;
        AppMethodBeat.i(137108);
        if (dVar == null || TextUtils.isEmpty(str) || dVar.ckv == null) {
            b.e("MicroMsg.Mix.AudioMixController", "track is invalid");
            AppMethodBeat.o(137108);
            return 0;
        }
        Object obj = null;
        if (!this.cmx.containsKey(str)) {
            b.e("MicroMsg.Mix.AudioMixController", "queue not exist for audioId:%s", str);
            synchronized (this.cmA) {
                try {
                    this.cmx.put(str, new ArrayList());
                    if (!this.cmv.contains(str)) {
                        this.cmv.add(str);
                    }
                    if (!this.cmw.containsKey(str)) {
                        obj = new Object();
                        this.cmw.put(str, obj);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(137108);
                    }
                }
            }
        }
        if (obj == null) {
            if (this.cmw.containsKey(str)) {
                obj = this.cmw.get(str);
            } else {
                synchronized (this.cmA) {
                    try {
                        if (this.cmw.containsKey(str)) {
                            obj = this.cmw.get(str);
                        } else {
                            obj = new Object();
                            this.cmw.put(str, obj);
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.o(137108);
                    }
                }
            }
        }
        Object obj2;
        if (obj == null) {
            obj2 = new Object();
        } else {
            obj2 = obj;
        }
        if (!this.cmz.containsKey(str)) {
            this.cmz.put(str, new WeakReference(cVar));
        }
        list = (List) this.cmx.get(str);
        synchronized (obj2) {
            if (list == null) {
                try {
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(137108);
                }
            } else {
                i = 0;
                list.add(0, dVar);
            }
            return i;
        }
        int size = list.size();
        AppMethodBeat.o(137108);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<d> DY() {
        AppMethodBeat.i(137109);
        ArrayList arrayList = new ArrayList();
        synchronized (this.cmA) {
            try {
                arrayList.addAll(this.cmv);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137109);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            synchronized (this.cmA) {
                try {
                    if (this.cmy.containsKey(str) && ((Boolean) this.cmy.get(str)).booleanValue()) {
                    } else {
                        List list = (List) this.cmx.get(str);
                        if (list != null && list.size() != 0) {
                            if (this.cmz.containsKey(str)) {
                                WeakReference weakReference = (WeakReference) this.cmz.get(str);
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    com.tencent.mm.audio.mix.d.c cVar = (com.tencent.mm.audio.mix.d.c) weakReference.get();
                                    if (cVar != null) {
                                        cVar.gx(list.size());
                                    }
                                }
                            }
                            Object obj = this.cmw.get(str);
                            if (obj != null) {
                                synchronized (obj) {
                                    try {
                                        int size = list.size();
                                        if (size <= 0) {
                                        } else {
                                            d dVar = (d) list.remove(size - 1);
                                            if (!this.cmE.containsKey(str) || ((long) ((Integer) this.cmE.get(str)).intValue()) <= dVar.ckG) {
                                                this.cmF.put(str, Long.valueOf(dVar.ckG));
                                                this.cmB.add(dVar);
                                                this.ckw.add(str);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(137109);
                                    }
                                }
                            }
                        } else if (dN(str)) {
                            l(str, false);
                            dO(str);
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(137109);
                    }
                }
            }
        }
        synchronized (this.cmA) {
            try {
                if (this.cmB.size() == 0 && !this.clT.get()) {
                    b.i("MicroMsg.Mix.AudioMixController", "wait read data");
                    this.cmA.wait();
                }
            } catch (Exception e) {
                b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "readMixDataFromPcmTrack", new Object[0]);
            } catch (Throwable th3) {
                AppMethodBeat.o(137109);
            }
        }
        List<d> list2 = this.cmB;
        return list2;
    }

    public final void clearCache() {
        AppMethodBeat.i(137110);
        b.i("MicroMsg.Mix.AudioMixController", "clearCache");
        synchronized (this.cmA) {
            try {
                DZ();
                this.cmw.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137110);
            }
        }
    }

    private void DZ() {
        AppMethodBeat.i(137111);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cmv.size()) {
                ((List) this.cmx.get(this.cmv.get(i2))).clear();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(137111);
                return;
            }
        }
    }

    public final void Ea() {
        AppMethodBeat.i(137112);
        if (this.cmu == null) {
            this.cmu = new Thread(this.cmM, "audio_mix_controller");
            this.cmu.start();
        }
        AppMethodBeat.o(137112);
    }

    public final void Eb() {
        if (this.cmu != null) {
            this.cmu = null;
        }
    }

    public final String dP(String str) {
        String str2;
        AppMethodBeat.i(137113);
        WeakReference weakReference = (WeakReference) this.cmz.get(str);
        if (!(weakReference == null || weakReference.get() == null)) {
            com.tencent.mm.audio.mix.d.c cVar = (com.tencent.mm.audio.mix.d.c) weakReference.get();
            if (cVar != null) {
                str2 = cVar.clP;
                AppMethodBeat.o(137113);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(137113);
        return str2;
    }

    static void H(List<d> list) {
        AppMethodBeat.i(137114);
        for (d dVar : list) {
            if (dVar != null && dVar.ckH) {
                com.tencent.mm.audio.mix.b.b.Di().b(dVar);
            }
        }
        AppMethodBeat.o(137114);
    }

    public final void dG(String str) {
        AppMethodBeat.i(137095);
        if (this.cmG > 0) {
            this.cmG = 0;
        }
        synchronized (this.cmA) {
            try {
                this.cms.set(false);
                this.cmt.put(str, Boolean.FALSE);
                if (this.cmv.contains(str)) {
                    b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
                } else {
                    this.cmv.add(str);
                    this.cmx.put(str, new ArrayList());
                    this.cmw.put(str, new Object());
                    this.cmC.put(str, Boolean.FALSE);
                }
                this.cmy.put(str, Boolean.FALSE);
                this.cmD.put(str, Boolean.FALSE);
                if (this.clS.get()) {
                    this.clS.set(false);
                } else {
                    this.cmB.size();
                }
                DU();
                DW();
            } finally {
                AppMethodBeat.o(137095);
            }
        }
    }

    public final void dH(String str) {
        AppMethodBeat.i(137096);
        synchronized (this.cmA) {
            try {
                if (this.cmy.containsKey(str)) {
                    this.cmy.put(str, Boolean.TRUE);
                } else {
                    b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                }
            } finally {
                AppMethodBeat.o(137096);
            }
        }
    }
}
