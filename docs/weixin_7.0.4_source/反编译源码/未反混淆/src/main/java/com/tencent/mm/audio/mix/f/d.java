package com.tencent.mm.audio.mix.f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.audio.mix.b.a;
import com.tencent.mm.audio.mix.d.m;
import com.tencent.mm.audio.mix.e.c;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d {
    AudioTrack aQf;
    private int channels = 2;
    volatile HashMap<String, b> clD = new HashMap();
    volatile HashMap<String, Boolean> cmD = new HashMap();
    private Thread cnA;
    public c cnB = new c(this);
    b cnC;
    private m cnD;
    public g cnE;
    volatile HashMap<String, Boolean> cnF = new HashMap();
    volatile HashMap<String, Boolean> cnG = new HashMap();
    volatile HashMap<String, e<Integer>> cnH = new HashMap();
    volatile HashMap<String, com.tencent.mm.ag.d> cnI = new HashMap();
    private ArrayList<String> cnJ = new ArrayList();
    private volatile HashMap<String, Long> cnK = new HashMap();
    private volatile HashMap<String, Integer> cnL = new HashMap();
    private volatile HashMap<String, Integer> cnM = new HashMap();
    private volatile HashMap<String, Integer> cnN = new HashMap();
    private volatile HashMap<String, Integer> cnO = new HashMap();
    private volatile HashMap<String, Integer> cnP = new HashMap();
    private byte[] cnQ = new byte[3536];
    byte[] cnR = new byte[2];
    private short cnS = (short) 0;
    int cnT = 0;
    private Runnable cnU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137168);
            Process.setThreadPriority(-19);
            if (d.this.cnw.get()) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
                AppMethodBeat.o(137168);
                return;
            }
            if (d.this.aQf == null) {
                d.a(d.this);
            }
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
            while (!d.this.cnw.get()) {
                d dVar = d.this;
                synchronized (dVar.cny) {
                    while (dVar.cnv.get() && !dVar.cnw.get()) {
                        try {
                            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                            dVar.cny.wait();
                        } catch (Exception e) {
                            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "waitPlay", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.o(137168);
                        }
                    }
                }
                if (d.this.cnw.get()) {
                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
                    break;
                }
                com.tencent.mm.audio.mix.a.b Eo = d.this.Eo();
                if (Eo != null) {
                    byte[] bArr = Eo.ckv;
                    if (d.this.aQf == null) {
                        d.a(d.this);
                    }
                    if (bArr != null && bArr.length > 0) {
                        int i;
                        if (d.this.aQf != null && (d.this.aQf.getPlayState() == 1 || d.this.aQf.getPlayState() == 2)) {
                            d.this.aQf.play();
                        }
                        d dVar2 = d.this;
                        dVar2.cnT++;
                        d dVar3 = d.this;
                        Iterator it = Eo.ckw.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            synchronized (dVar3.cnz) {
                                try {
                                    if (TextUtils.isEmpty(str) || (dVar3.cmD.containsKey(str) && ((Boolean) dVar3.cmD.get(str)).booleanValue())) {
                                    } else {
                                        if (dVar3.cmD.containsKey(str)) {
                                            dVar3.cmD.put(str, Boolean.TRUE);
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        if (i != 0) {
                                            dVar3.mHandler.post(new AnonymousClass2(str));
                                        }
                                    }
                                } catch (Throwable th2) {
                                    AppMethodBeat.o(137168);
                                }
                            }
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (d.this.aQf != null) {
                            if (d.this.cnB.DX()) {
                                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
                                d.this.aQf.setStereoVolume(0.0f, 0.0f);
                            } else {
                                d.this.aQf.setStereoVolume(1.0f, 1.0f);
                            }
                            i = d.this.aQf.write(bArr, 0, bArr.length);
                        } else {
                            i = 0;
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 100) {
                            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(d.this.cnT));
                        }
                        if (i < 0) {
                            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", Integer.valueOf(i));
                        }
                        if (d.this.cnx.size() == 0) {
                            d.this.cnR[0] = bArr[bArr.length - 2];
                            d.this.cnR[1] = bArr[bArr.length - 1];
                        }
                    }
                    a.Dg().a(Eo);
                }
            }
            d.this.Er();
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(137168);
        }
    };
    ArrayList<String> cnV = new ArrayList();
    public com.tencent.mm.audio.mix.d.a cnp = this.cnp;
    private int cnt = 4;
    public AtomicBoolean cnu = new AtomicBoolean(false);
    AtomicBoolean cnv = new AtomicBoolean(false);
    public AtomicBoolean cnw = new AtomicBoolean(true);
    public Queue<com.tencent.mm.audio.mix.a.b> cnx = new ArrayDeque();
    public Object cny = new Object();
    Object cnz = new Object();
    Handler mHandler;
    private int sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;

    /* renamed from: com.tencent.mm.audio.mix.f.d$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String cnX;

        AnonymousClass2(String str) {
            this.cnX = str;
        }

        public final void run() {
            AppMethodBeat.i(137169);
            d.this.i(11, this.cnX);
            AppMethodBeat.o(137169);
        }
    }

    public d() {
        AppMethodBeat.i(137171);
        c cVar = this.cnB;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
        cVar.Ea();
        cVar.cmx.clear();
        cVar.cmq = new com.tencent.mm.audio.mix.e.d();
        cVar.cmq.init();
        if (this.cnD == null) {
            this.cnD = new m() {
                public final void a(u uVar) {
                    int i;
                    AppMethodBeat.i(137170);
                    int i2 = uVar.csP.action;
                    if (i2 == 12 || i2 == 11 || i2 == 10 || i2 == 6) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        if (d.this.cnH.containsKey(uVar.csP.ckD)) {
                            e eVar = (e) d.this.cnH.get(uVar.csP.ckD);
                            if (eVar != null) {
                                if (eVar.g(Integer.valueOf(i2))) {
                                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                                    AppMethodBeat.o(137170);
                                    return;
                                }
                            }
                            eVar.al(Integer.valueOf(i2));
                            d.this.cnH.put(uVar.csP.ckD, eVar);
                        } else {
                            synchronized (d.this.cnz) {
                                try {
                                    d.this.cnH.put(uVar.csP.ckD, new e(Integer.valueOf(i2)));
                                } catch (Throwable th) {
                                    AppMethodBeat.o(137170);
                                }
                            }
                        }
                    }
                    if (d.this.cnC == null) {
                        AppMethodBeat.o(137170);
                        return;
                    }
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", uVar.csP.ckD, uVar.csP.state);
                    if (i2 == 9) {
                        d.this.cnC.b(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 7) {
                        d.this.cnC.c(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 0) {
                        d.this.cnC.d(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 1) {
                        d.this.cnC.d(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 2) {
                        d.this.cnC.e(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 3) {
                        d.this.cnG.put(uVar.csP.ckD, Boolean.FALSE);
                        d.this.cnC.f(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 5) {
                        d.this.cnG.put(uVar.csP.ckD, Boolean.FALSE);
                        d.this.cnC.g(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 4) {
                        d.this.cnG.put(uVar.csP.ckD, Boolean.FALSE);
                        d.this.cnC.j(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 10) {
                        d.this.cnC.h(uVar);
                        AppMethodBeat.o(137170);
                    } else if (i2 == 6) {
                        d.this.cnC.i(uVar);
                        AppMethodBeat.o(137170);
                    } else {
                        if (i2 == 11) {
                            d.this.cnC.k(uVar);
                        }
                        AppMethodBeat.o(137170);
                    }
                }
            };
        }
        this.mHandler = new Handler(Looper.myLooper());
        AppMethodBeat.o(137171);
    }

    public final void clearCache() {
        AppMethodBeat.i(137172);
        this.cnB.clearCache();
        this.clD.clear();
        this.cnF.clear();
        this.cnG.clear();
        synchronized (this.cnz) {
            try {
                this.cnH.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137172);
            }
        }
        this.cnI.clear();
        this.cmD.clear();
    }

    public final void El() {
        AppMethodBeat.i(137173);
        this.cnu.set(false);
        this.cnw.set(true);
        this.cnv.set(false);
        Eq();
        En();
        AppMethodBeat.o(137173);
    }

    public final b dQ(String str) {
        AppMethodBeat.i(137174);
        if (this.clD.containsKey(str)) {
            b bVar = (b) this.clD.get(str);
            AppMethodBeat.o(137174);
            return bVar;
        }
        AppMethodBeat.o(137174);
        return null;
    }

    public final void dV(String str) {
        AppMethodBeat.i(137175);
        this.cnB.dI(str);
        synchronized (this.cnz) {
            try {
                this.cmD.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137175);
                }
            }
        }
        this.cnF.remove(str);
        this.cnG.put(str, Boolean.FALSE);
        if (this.cnp.dE(str)) {
            i(3, str);
        }
        AppMethodBeat.o(137175);
    }

    public final boolean dF(String str) {
        AppMethodBeat.i(137176);
        if (this.cnH.containsKey(str)) {
            e eVar = (e) this.cnH.get(str);
            if (eVar != null) {
                if (eVar.g(Integer.valueOf(0))) {
                    AppMethodBeat.o(137176);
                    return true;
                }
            }
            if (!this.cnB.dJ(str) && this.cnp.dF(str)) {
                AppMethodBeat.o(137176);
                return true;
            }
        }
        AppMethodBeat.o(137176);
        return false;
    }

    public final int ef(String str) {
        AppMethodBeat.i(137177);
        int dL = (int) this.cnB.dL(str);
        AppMethodBeat.o(137177);
        return dL;
    }

    public final int ea(String str) {
        AppMethodBeat.i(137178);
        if (this.clD.containsKey(str)) {
            String str2 = ((b) this.clD.get(str)).filePath;
            if (TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(137178);
                return 0;
            }
            com.tencent.mm.audio.mix.a.c dv = com.tencent.mm.audio.mix.b.d.Dm().dv(str2);
            if (dv != null) {
                int i = (int) dv.duration;
                AppMethodBeat.o(137178);
                return i;
            }
        }
        AppMethodBeat.o(137178);
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final void Em() {
        AppMethodBeat.i(137179);
        synchronized (this) {
            try {
                if (this.cnA == null) {
                    this.cnA = new Thread(this.cnU, "audio_mix_player");
                    this.cnA.start();
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", Long.valueOf(this.cnA.getId()));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137179);
            }
        }
    }

    private void En() {
        AppMethodBeat.i(137180);
        synchronized (this) {
            try {
                if (this.cnA != null) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", Long.valueOf(this.cnA.getId()));
                    this.cnA = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137180);
            }
        }
    }

    public final void DL() {
        AppMethodBeat.i(137181);
        try {
            if (this.aQf != null) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
            }
            AppMethodBeat.o(137181);
        } catch (Exception e) {
            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, l.NAME, new Object[0]);
            AppMethodBeat.o(137181);
        }
    }

    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r0 = (com.tencent.mm.audio.mix.a.b) r6.cnx.poll();
            r6.cny.notifyAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.audio.mix.a.b Eo() {
        AppMethodBeat.i(137182);
        synchronized (this.cny) {
            while (true) {
                try {
                    if ((this.cnx.size() != 0 && !this.cnv.get()) || this.cnw.get()) {
                        break;
                    }
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
                    DL();
                    if (this.aQf != null && this.aQf.getPlayState() == 3) {
                        this.aQf.stop();
                    }
                    this.cny.wait();
                    this.cnT = 0;
                } catch (InterruptedException e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "waitPlay", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(137182);
                }
            }
        }
        AppMethodBeat.o(137182);
        return r0;
    }

    public final void Ep() {
        AppMethodBeat.i(137183);
        this.cnx.clear();
        AppMethodBeat.o(137183);
    }

    public final void Eq() {
        AppMethodBeat.i(137184);
        synchronized (this.cny) {
            try {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
                this.cny.notifyAll();
            } catch (Exception e) {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "syncNotify", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(137184);
            }
        }
        AppMethodBeat.o(137184);
    }

    private synchronized boolean createAudioTrack() {
        boolean z;
        AppMethodBeat.i(137185);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        this.cnt = minBufferSize / 3536;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "miniBufferSize:%d, channels:%d, sampleRate:%d", Integer.valueOf(minBufferSize), Integer.valueOf(this.channels), Integer.valueOf(this.sampleRate));
        if (this.aQf == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "audioTrack is null, new AudioTrack");
            try {
                this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
            } catch (IllegalArgumentException e) {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "AudioTrack create", new Object[0]);
            }
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "audio track not initialized");
            if (this.aQf != null) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "AudioTrack getState", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(137185);
            z = false;
        } else {
            AppMethodBeat.o(137185);
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void Er() {
        AppMethodBeat.i(137186);
        try {
            if (this.aQf != null) {
                this.aQf.flush();
                this.aQf.stop();
                this.aQf.release();
                this.aQf = null;
            }
            AppMethodBeat.o(137186);
        } catch (Exception e) {
            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.o(137186);
        }
        return;
    }

    public final int eg(String str) {
        AppMethodBeat.i(137187);
        if (this.cnH.containsKey(str)) {
            e eVar = (e) this.cnH.get(str);
            if (eVar != null) {
                int intValue = ((Integer) eVar.get()).intValue();
                AppMethodBeat.o(137187);
                return intValue;
            }
            AppMethodBeat.o(137187);
            return -1;
        }
        AppMethodBeat.o(137187);
        return -1;
    }

    public final void i(int i, String str) {
        AppMethodBeat.i(137188);
        e(i, str, this.cnB.dP(str));
        AppMethodBeat.o(137188);
    }

    public final void e(int i, String str, String str2) {
        AppMethodBeat.i(137189);
        b bVar = (b) this.clD.get(str);
        if (bVar == null) {
            AppMethodBeat.o(137189);
            return;
        }
        u uVar = new u();
        uVar.csP.ckD = str;
        uVar.csP.action = i;
        uVar.csP.appId = bVar.appId;
        if (TextUtils.isEmpty(str2)) {
            str2 = bVar.clP;
        }
        uVar.csP.clP = str2;
        uVar.csP.state = u.gI(i);
        if (this.cnD != null) {
            this.cnD.a(uVar);
        }
        AppMethodBeat.o(137189);
    }

    public final void a(int i, String str, int i2, String str2) {
        AppMethodBeat.i(137190);
        b bVar = (b) this.clD.get(str);
        if (bVar == null) {
            AppMethodBeat.o(137190);
            return;
        }
        u uVar = new u();
        uVar.csP.ckD = str;
        uVar.csP.action = i;
        uVar.csP.appId = bVar.appId;
        uVar.csP.errCode = i2;
        uVar.csP.aIm = str2;
        uVar.csP.state = u.gI(i);
        if (this.cnD != null) {
            this.cnD.a(uVar);
        }
        AppMethodBeat.o(137190);
    }

    /* JADX WARNING: Missing block: B:13:0x0063, code skipped:
            if (r0.g(java.lang.Integer.valueOf(2)) != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int Es() {
        int i = 0;
        AppMethodBeat.i(137191);
        synchronized (this.cnz) {
            try {
                Set keySet = this.cnH.keySet();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(keySet);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int i2;
                    e eVar = (e) this.cnH.get((String) it.next());
                    if (eVar != null) {
                        if (!eVar.g(Integer.valueOf(0))) {
                            if (!eVar.g(Integer.valueOf(1))) {
                            }
                        }
                        i2 = i + 1;
                        i = i2;
                    }
                    i2 = i;
                    i = i2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137191);
            }
        }
        return i;
    }

    public final ArrayList<String> Et() {
        AppMethodBeat.i(137192);
        this.cnJ.clear();
        this.cnV.clear();
        synchronized (this.cnz) {
            try {
                this.cnV.addAll(this.cnH.keySet());
                Iterator it = this.cnV.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    e eVar = (e) this.cnH.get(str);
                    if (eVar != null) {
                        if (eVar.g(Integer.valueOf(2))) {
                            this.cnJ.add(str);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137192);
            }
        }
        ArrayList<String> arrayList = this.cnJ;
        return arrayList;
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(137193);
        if (dVar.createAudioTrack()) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "create AudioTrack success");
            dVar.aQf.play();
            AppMethodBeat.o(137193);
            return;
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "onError, errCode:%d", Integer.valueOf(710));
        AppMethodBeat.o(137193);
    }
}
