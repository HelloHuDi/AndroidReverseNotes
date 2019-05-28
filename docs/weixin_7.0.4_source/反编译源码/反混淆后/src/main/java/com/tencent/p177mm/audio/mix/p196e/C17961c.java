package com.tencent.p177mm.audio.mix.p196e;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C41772b;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.p177mm.audio.mix.p831d.C9050c;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.p1176ag.C17875b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.audio.mix.e.c */
public final class C17961c {
    protected Object ckQ = new Object();
    volatile LinkedList<String> ckw = new LinkedList();
    protected AtomicBoolean clS = new AtomicBoolean(false);
    protected AtomicBoolean clT = new AtomicBoolean(false);
    private Object cmA = new Object();
    private List<C45164d> cmB = new ArrayList();
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
    private Runnable cmM = new C90521();
    public C25842i cmq;
    C45172d cmr;
    protected AtomicBoolean cms = new AtomicBoolean(false);
    protected volatile HashMap<String, Boolean> cmt = new HashMap();
    private Thread cmu;
    private volatile LinkedList<String> cmv = new LinkedList();
    private volatile HashMap<String, Object> cmw = new HashMap();
    public volatile HashMap<String, List<C45164d>> cmx = new HashMap();
    private volatile HashMap<String, Boolean> cmy = new HashMap();
    public volatile HashMap<String, WeakReference<C9050c>> cmz = new HashMap();

    /* renamed from: com.tencent.mm.audio.mix.e.c$1 */
    class C90521 implements Runnable {
        C90521() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137087);
            Process.setThreadPriority(-19);
            if (C17961c.this.mo33497DB()) {
                C45174b.m83207e("MicroMsg.Mix.AudioMixController", "stop and exit");
                AppMethodBeat.m2505o(137087);
                return;
            }
            while (!C17961c.this.mo33497DB()) {
                C17961c.this.mo33501DV();
                if (C17961c.this.mo33497DB()) {
                    AppMethodBeat.m2505o(137087);
                    return;
                }
                System.nanoTime();
                List DY = C17961c.this.mo33503DY();
                if (DY.size() > 0) {
                    long nanoTime = System.nanoTime();
                    C25836b I = C17961c.this.cmq.mo43832I(DY);
                    long nanoTime2 = System.nanoTime();
                    C17961c c17961c = C17961c.this;
                    c17961c.cmI++;
                    C17961c.this.cmJ = (nanoTime2 - nanoTime) + C17961c.this.cmJ;
                    if (I != null) {
                        c17961c = C17961c.this;
                        I.ckw.addAll(c17961c.ckw);
                        c17961c.ckw.clear();
                        C45172d c45172d = c17961c.cmr;
                        if (c45172d.cnw.get()) {
                            C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
                        } else {
                            synchronized (c45172d.cny) {
                                while (c45172d.cnx.size() >= 2 && !c45172d.cnw.get()) {
                                    try {
                                        c45172d.cny.wait();
                                    } catch (InterruptedException e) {
                                        C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "enqueueMixBuffer", new Object[0]);
                                    } catch (Throwable th) {
                                        AppMethodBeat.m2505o(137087);
                                    }
                                }
                                c45172d.cnx.add(I);
                                c45172d.cny.notifyAll();
                            }
                        }
                    }
                    C17961c.m28245H(DY);
                    DY.clear();
                }
            }
            C45174b.m83209i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
            AppMethodBeat.m2505o(137087);
        }
    }

    public C17961c(C45172d c45172d) {
        AppMethodBeat.m2504i(137088);
        this.cmr = c45172d;
        AppMethodBeat.m2505o(137088);
    }

    /* renamed from: DR */
    public final void mo33498DR() {
        AppMethodBeat.m2504i(137089);
        C45174b.m83209i("MicroMsg.Mix.AudioMixController", "prepareMix");
        this.clT.set(false);
        this.clS.set(false);
        mo33504Ea();
        m28242DU();
        AppMethodBeat.m2505o(137089);
    }

    /* renamed from: DS */
    public final void mo33499DS() {
        AppMethodBeat.m2504i(137090);
        C45174b.m83209i("MicroMsg.Mix.AudioMixController", "pauseMix");
        this.clS.set(true);
        if (this.cmI > 0) {
            this.cmG = this.cmJ / ((long) this.cmI);
            C45174b.m83210i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", Long.valueOf(this.cmG));
        }
        this.cmK = 0;
        this.cmI = 0;
        this.cmJ = 0;
        this.cmL = 0;
        AppMethodBeat.m2505o(137090);
    }

    /* renamed from: DT */
    public final void mo33500DT() {
        AppMethodBeat.m2504i(137091);
        C45174b.m83209i("MicroMsg.Mix.AudioMixController", "stopMix");
        this.clT.set(true);
        this.clS.set(false);
        m28242DU();
        synchronized (this.cmA) {
            try {
                m28243DW();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137091);
            }
        }
        m28244DZ();
        mo33505Eb();
    }

    /* renamed from: DU */
    private void m28242DU() {
        AppMethodBeat.m2504i(137092);
        synchronized (this.ckQ) {
            try {
                this.ckQ.notify();
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "notifyMix", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(137092);
            }
        }
        AppMethodBeat.m2505o(137092);
    }

    /* renamed from: DV */
    public final void mo33501DV() {
        AppMethodBeat.m2504i(137093);
        synchronized (this.ckQ) {
            while (!this.clT.get() && this.clS.get()) {
                try {
                    C45174b.m83209i("MicroMsg.Mix.AudioMixController", "waitMix");
                    this.ckQ.wait();
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "waitMix", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(137093);
                }
            }
        }
        AppMethodBeat.m2505o(137093);
    }

    /* renamed from: DW */
    private void m28243DW() {
        AppMethodBeat.m2504i(137094);
        try {
            this.cmA.notifyAll();
            AppMethodBeat.m2505o(137094);
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "notifySyncPcmData", new Object[0]);
            AppMethodBeat.m2505o(137094);
        }
    }

    /* renamed from: dI */
    public final void mo33510dI(String str) {
        AppMethodBeat.m2504i(137097);
        this.cmt.put(str, Boolean.TRUE);
        mo33512dK(str);
        if (this.cmv.isEmpty()) {
            C45174b.m83209i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
            this.cms.set(true);
            this.cmr.mo73144DL();
            AppMethodBeat.m2505o(137097);
            return;
        }
        this.cms.set(false);
        AppMethodBeat.m2505o(137097);
    }

    /* renamed from: DX */
    public final boolean mo33502DX() {
        AppMethodBeat.m2504i(137098);
        boolean z = this.cms.get();
        AppMethodBeat.m2505o(137098);
        return z;
    }

    /* renamed from: dJ */
    public final boolean mo33511dJ(String str) {
        boolean booleanValue;
        AppMethodBeat.m2504i(137099);
        synchronized (this.cmA) {
            try {
                if (this.cmy.containsKey(str)) {
                    booleanValue = ((Boolean) this.cmy.get(str)).booleanValue();
                } else {
                    booleanValue = false;
                    AppMethodBeat.m2505o(137099);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137099);
            }
        }
        return booleanValue;
    }

    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dK */
    public final void mo33512dK(String str) {
        int i = 137100;
        AppMethodBeat.m2504i(137100);
        synchronized (this.cmA) {
            int i2;
            try {
                if (this.cmv.contains(str)) {
                    this.cmv.remove(str);
                    i2 = this.cmw.get(str);
                    List list = (List) this.cmx.remove(str);
                    if (i2 != 0) {
                        synchronized (i2) {
                            C17961c.m28245H(list);
                            list.clear();
                        }
                    } else {
                        C17961c.m28245H(list);
                        list.clear();
                    }
                    this.cmw.remove(str);
                    this.cmy.remove(str);
                    this.cmC.remove(str);
                    this.cmD.remove(str);
                    if (this.clS.get()) {
                        m28243DW();
                    }
                    this.cmE.remove(str);
                    this.cmF.remove(str);
                } else {
                    i2 = "The audio of the id is remove";
                    C45174b.m83207e("MicroMsg.Mix.AudioMixController", i2);
                }
            } catch (Throwable th) {
                while (true) {
                }
                i2 = 137100;
            } finally {
                AppMethodBeat.m2505o(
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

    /* renamed from: w */
    public final boolean mo33517w(String str, int i) {
        AppMethodBeat.m2504i(137101);
        if (!this.cmv.contains(str)) {
            AppMethodBeat.m2505o(137101);
            return false;
        } else if (i < 0) {
            this.cmE.remove(str);
            AppMethodBeat.m2505o(137101);
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
                AppMethodBeat.m2505o(137101);
                return false;
            }
            C17875b dQ = this.cmr.mo73156dQ(str);
            if (dQ == null) {
                this.cmE.remove(str);
                AppMethodBeat.m2505o(137101);
                return false;
            }
            C45174b.m83209i("MicroMsg.Mix.AudioMixController", "seekTo begin");
            boolean dJ = mo33511dJ(str);
            if (!dJ) {
                mo33509dH(str);
            }
            int size = list.size();
            C37484c dv = C45166d.m83168Dm().mo73133dv(dQ.filePath);
            int size2 = dv.size();
            int i2 = i / 20;
            int dL = (int) (mo33513dL(str) / 20);
            Object obj = this.cmw.get(str);
            if (obj == null) {
                this.cmE.remove(str);
                AppMethodBeat.m2505o(137101);
                return false;
            }
            if (i2 > dL && i2 <= size2) {
                C45174b.m83207e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos > currentPos");
                int i3 = i2 - dL;
                synchronized (obj) {
                    dL = 0;
                    while (dL < i3 && i3 <= size) {
                        try {
                            list.remove(list.size() - 1);
                            dL++;
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(137101);
                            }
                        }
                    }
                }
            } else if (i2 < dL && dL <= size2) {
                C45174b.m83207e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos");
                synchronized (obj) {
                    while (dL > i2) {
                        try {
                            C45164d gv = dv.mo60399gv(dL);
                            if (gv != null) {
                                list.add(list.size(), gv);
                            }
                            dL--;
                        } catch (Throwable th2) {
                            AppMethodBeat.m2505o(137101);
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
                            C45174b.m83207e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                        }
                    } catch (Throwable th3) {
                        AppMethodBeat.m2505o(137101);
                    }
                }
                synchronized (this.cmA) {
                    try {
                        m28243DW();
                    } catch (Throwable th4) {
                        while (true) {
                            AppMethodBeat.m2505o(137101);
                        }
                    }
                }
            }
            C45174b.m83210i("MicroMsg.Mix.AudioMixController", "seekTo end, time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(137101);
            return true;
        }
    }

    /* renamed from: dL */
    public final long mo33513dL(String str) {
        long longValue;
        AppMethodBeat.m2504i(137102);
        synchronized (this.cmA) {
            try {
                if (this.cmF.containsKey(str)) {
                    longValue = ((Long) this.cmF.get(str)).longValue();
                } else {
                    AppMethodBeat.m2505o(137102);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137102);
            }
        }
        return longValue;
    }

    /* renamed from: dM */
    public final boolean mo33514dM(String str) {
        AppMethodBeat.m2504i(137103);
        if (this.cmv.contains(str)) {
            List list = (List) this.cmx.get(str);
            if (list == null || list.size() == 0) {
                C45174b.m83209i("MicroMsg.Mix.AudioMixController", "queue size is 0");
                AppMethodBeat.m2505o(137103);
                return true;
            }
            AppMethodBeat.m2505o(137103);
            return false;
        }
        AppMethodBeat.m2505o(137103);
        return true;
    }

    /* renamed from: l */
    public final void mo33516l(String str, boolean z) {
        AppMethodBeat.m2504i(137104);
        synchronized (this.cmA) {
            try {
                this.cmC.put(str, Boolean.valueOf(z));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137104);
            }
        }
    }

    /* renamed from: dN */
    private boolean m28246dN(String str) {
        AppMethodBeat.m2504i(137105);
        synchronized (this.cmA) {
            try {
                if (!this.cmC.containsKey(str) || !((Boolean) this.cmC.get(str)).booleanValue()) {
                    AppMethodBeat.m2505o(137105);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137105);
            }
        }
        return true;
    }

    /* renamed from: dO */
    private void m28247dO(String str) {
        AppMethodBeat.m2504i(137106);
        this.cmr.mo73162i(5, str);
        mo33512dK(str);
        AppMethodBeat.m2505o(137106);
    }

    /* renamed from: DB */
    public final boolean mo33497DB() {
        AppMethodBeat.m2504i(139130);
        boolean z = this.clT.get();
        AppMethodBeat.m2505o(139130);
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
            com.tencent.p177mm.audio.mix.p197h.C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixController", r1, "writePcmDataTrack", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:67:0x00f8, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137108);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo33506a(String str, C45164d c45164d, C9050c c9050c) {
        List list;
        int i = 0;
        AppMethodBeat.m2504i(137108);
        if (c45164d == null || TextUtils.isEmpty(str) || c45164d.ckv == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioMixController", "track is invalid");
            AppMethodBeat.m2505o(137108);
            return 0;
        }
        Object obj = null;
        if (!this.cmx.containsKey(str)) {
            C45174b.m83208e("MicroMsg.Mix.AudioMixController", "queue not exist for audioId:%s", str);
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
                        AppMethodBeat.m2505o(137108);
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
                        AppMethodBeat.m2505o(137108);
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
            this.cmz.put(str, new WeakReference(c9050c));
        }
        list = (List) this.cmx.get(str);
        synchronized (obj2) {
            if (list == null) {
                try {
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137108);
                }
            } else {
                i = 0;
                list.add(0, c45164d);
            }
            return i;
        }
        int size = list.size();
        AppMethodBeat.m2505o(137108);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DY */
    public final List<C45164d> mo33503DY() {
        AppMethodBeat.m2504i(137109);
        ArrayList arrayList = new ArrayList();
        synchronized (this.cmA) {
            try {
                arrayList.addAll(this.cmv);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137109);
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
                                    C9050c c9050c = (C9050c) weakReference.get();
                                    if (c9050c != null) {
                                        c9050c.mo20521gx(list.size());
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
                                            C45164d c45164d = (C45164d) list.remove(size - 1);
                                            if (!this.cmE.containsKey(str) || ((long) ((Integer) this.cmE.get(str)).intValue()) <= c45164d.ckG) {
                                                this.cmF.put(str, Long.valueOf(c45164d.ckG));
                                                this.cmB.add(c45164d);
                                                this.ckw.add(str);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.m2505o(137109);
                                    }
                                }
                            }
                        } else if (m28246dN(str)) {
                            mo33516l(str, false);
                            m28247dO(str);
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(137109);
                    }
                }
            }
        }
        synchronized (this.cmA) {
            try {
                if (this.cmB.size() == 0 && !this.clT.get()) {
                    C45174b.m83209i("MicroMsg.Mix.AudioMixController", "wait read data");
                    this.cmA.wait();
                }
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e, "readMixDataFromPcmTrack", new Object[0]);
            } catch (Throwable th3) {
                AppMethodBeat.m2505o(137109);
            }
        }
        List<C45164d> list2 = this.cmB;
        return list2;
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(137110);
        C45174b.m83209i("MicroMsg.Mix.AudioMixController", "clearCache");
        synchronized (this.cmA) {
            try {
                m28244DZ();
                this.cmw.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137110);
            }
        }
    }

    /* renamed from: DZ */
    private void m28244DZ() {
        AppMethodBeat.m2504i(137111);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cmv.size()) {
                ((List) this.cmx.get(this.cmv.get(i2))).clear();
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(137111);
                return;
            }
        }
    }

    /* renamed from: Ea */
    public final void mo33504Ea() {
        AppMethodBeat.m2504i(137112);
        if (this.cmu == null) {
            this.cmu = new Thread(this.cmM, "audio_mix_controller");
            this.cmu.start();
        }
        AppMethodBeat.m2505o(137112);
    }

    /* renamed from: Eb */
    public final void mo33505Eb() {
        if (this.cmu != null) {
            this.cmu = null;
        }
    }

    /* renamed from: dP */
    public final String mo33515dP(String str) {
        String str2;
        AppMethodBeat.m2504i(137113);
        WeakReference weakReference = (WeakReference) this.cmz.get(str);
        if (!(weakReference == null || weakReference.get() == null)) {
            C9050c c9050c = (C9050c) weakReference.get();
            if (c9050c != null) {
                str2 = c9050c.clP;
                AppMethodBeat.m2505o(137113);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(137113);
        return str2;
    }

    /* renamed from: H */
    static void m28245H(List<C45164d> list) {
        AppMethodBeat.m2504i(137114);
        for (C45164d c45164d : list) {
            if (c45164d != null && c45164d.ckH) {
                C41772b.m73733Di().mo67527b(c45164d);
            }
        }
        AppMethodBeat.m2505o(137114);
    }

    /* renamed from: dG */
    public final void mo33508dG(String str) {
        AppMethodBeat.m2504i(137095);
        if (this.cmG > 0) {
            this.cmG = 0;
        }
        synchronized (this.cmA) {
            try {
                this.cms.set(false);
                this.cmt.put(str, Boolean.FALSE);
                if (this.cmv.contains(str)) {
                    C45174b.m83207e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
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
                m28242DU();
                m28243DW();
            } finally {
                AppMethodBeat.m2505o(137095);
            }
        }
    }

    /* renamed from: dH */
    public final void mo33509dH(String str) {
        AppMethodBeat.m2504i(137096);
        synchronized (this.cmA) {
            try {
                if (this.cmy.containsKey(str)) {
                    this.cmy.put(str, Boolean.TRUE);
                } else {
                    C45174b.m83207e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                }
            } finally {
                AppMethodBeat.m2505o(137096);
            }
        }
    }
}
