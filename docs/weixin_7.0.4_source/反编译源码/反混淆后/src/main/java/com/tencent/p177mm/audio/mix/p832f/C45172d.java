package com.tencent.p177mm.audio.mix.p832f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C41771a;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p196e.C17961c;
import com.tencent.p177mm.audio.mix.p196e.C45168d;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p831d.C25840m;
import com.tencent.p177mm.audio.mix.p831d.C37487a;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C41729d;
import com.tencent.p177mm.p230g.p231a.C18405u;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.audio.mix.f.d */
public final class C45172d {
    AudioTrack aQf;
    private int channels = 2;
    volatile HashMap<String, C17875b> clD = new HashMap();
    volatile HashMap<String, Boolean> cmD = new HashMap();
    private Thread cnA;
    public C17961c cnB = new C17961c(this);
    C32316b cnC;
    private C25840m cnD;
    public C9056g cnE;
    volatile HashMap<String, Boolean> cnF = new HashMap();
    volatile HashMap<String, Boolean> cnG = new HashMap();
    volatile HashMap<String, C37491e<Integer>> cnH = new HashMap();
    volatile HashMap<String, C41729d> cnI = new HashMap();
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
    private Runnable cnU = new C374901();
    ArrayList<String> cnV = new ArrayList();
    public C37487a cnp = this.cnp;
    private int cnt = 4;
    public AtomicBoolean cnu = new AtomicBoolean(false);
    AtomicBoolean cnv = new AtomicBoolean(false);
    public AtomicBoolean cnw = new AtomicBoolean(true);
    public Queue<C25836b> cnx = new ArrayDeque();
    public Object cny = new Object();
    Object cnz = new Object();
    Handler mHandler;
    private int sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;

    /* renamed from: com.tencent.mm.audio.mix.f.d$1 */
    class C374901 implements Runnable {
        C374901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137168);
            Process.setThreadPriority(-19);
            if (C45172d.this.cnw.get()) {
                C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
                AppMethodBeat.m2505o(137168);
                return;
            }
            if (C45172d.this.aQf == null) {
                C45172d.m83187a(C45172d.this);
            }
            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
            while (!C45172d.this.cnw.get()) {
                C45172d c45172d = C45172d.this;
                synchronized (c45172d.cny) {
                    while (c45172d.cnv.get() && !c45172d.cnw.get()) {
                        try {
                            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                            c45172d.cny.wait();
                        } catch (Exception e) {
                            C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "waitPlay", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(137168);
                        }
                    }
                }
                if (C45172d.this.cnw.get()) {
                    C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
                    break;
                }
                C25836b Eo = C45172d.this.mo73147Eo();
                if (Eo != null) {
                    byte[] bArr = Eo.ckv;
                    if (C45172d.this.aQf == null) {
                        C45172d.m83187a(C45172d.this);
                    }
                    if (bArr != null && bArr.length > 0) {
                        int i;
                        if (C45172d.this.aQf != null && (C45172d.this.aQf.getPlayState() == 1 || C45172d.this.aQf.getPlayState() == 2)) {
                            C45172d.this.aQf.play();
                        }
                        C45172d c45172d2 = C45172d.this;
                        c45172d2.cnT++;
                        C45172d c45172d3 = C45172d.this;
                        Iterator it = Eo.ckw.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            synchronized (c45172d3.cnz) {
                                try {
                                    if (TextUtils.isEmpty(str) || (c45172d3.cmD.containsKey(str) && ((Boolean) c45172d3.cmD.get(str)).booleanValue())) {
                                    } else {
                                        if (c45172d3.cmD.containsKey(str)) {
                                            c45172d3.cmD.put(str, Boolean.TRUE);
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        if (i != 0) {
                                            c45172d3.mHandler.post(new C451712(str));
                                        }
                                    }
                                } catch (Throwable th2) {
                                    AppMethodBeat.m2505o(137168);
                                }
                            }
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (C45172d.this.aQf != null) {
                            if (C45172d.this.cnB.mo33502DX()) {
                                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
                                C45172d.this.aQf.setStereoVolume(0.0f, 0.0f);
                            } else {
                                C45172d.this.aQf.setStereoVolume(1.0f, 1.0f);
                            }
                            i = C45172d.this.aQf.write(bArr, 0, bArr.length);
                        } else {
                            i = 0;
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 100) {
                            C45174b.m83208e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(C45172d.this.cnT));
                        }
                        if (i < 0) {
                            C45174b.m83208e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", Integer.valueOf(i));
                        }
                        if (C45172d.this.cnx.size() == 0) {
                            C45172d.this.cnR[0] = bArr[bArr.length - 2];
                            C45172d.this.cnR[1] = bArr[bArr.length - 1];
                        }
                    }
                    C41771a.m73730Dg().mo67525a(Eo);
                }
            }
            C45172d.this.mo73150Er();
            C45174b.m83210i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(137168);
        }
    }

    /* renamed from: com.tencent.mm.audio.mix.f.d$3 */
    class C417813 implements C25840m {
        C417813() {
        }

        /* renamed from: a */
        public final void mo43830a(C18405u c18405u) {
            int i;
            AppMethodBeat.m2504i(137170);
            int i2 = c18405u.csP.action;
            if (i2 == 12 || i2 == 11 || i2 == 10 || i2 == 6) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                if (C45172d.this.cnH.containsKey(c18405u.csP.ckD)) {
                    C37491e c37491e = (C37491e) C45172d.this.cnH.get(c18405u.csP.ckD);
                    if (c37491e != null) {
                        if (c37491e.mo60422g(Integer.valueOf(i2))) {
                            C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                            AppMethodBeat.m2505o(137170);
                            return;
                        }
                    }
                    c37491e.mo60421al(Integer.valueOf(i2));
                    C45172d.this.cnH.put(c18405u.csP.ckD, c37491e);
                } else {
                    synchronized (C45172d.this.cnz) {
                        try {
                            C45172d.this.cnH.put(c18405u.csP.ckD, new C37491e(Integer.valueOf(i2)));
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(137170);
                        }
                    }
                }
            }
            if (C45172d.this.cnC == null) {
                AppMethodBeat.m2505o(137170);
                return;
            }
            C45174b.m83210i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", c18405u.csP.ckD, c18405u.csP.state);
            if (i2 == 9) {
                C45172d.this.cnC.mo46596b(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 7) {
                C45172d.this.cnC.mo46597c(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 0) {
                C45172d.this.cnC.mo46598d(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 1) {
                C45172d.this.cnC.mo46598d(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 2) {
                C45172d.this.cnC.mo46599e(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 3) {
                C45172d.this.cnG.put(c18405u.csP.ckD, Boolean.FALSE);
                C45172d.this.cnC.mo46600f(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 5) {
                C45172d.this.cnG.put(c18405u.csP.ckD, Boolean.FALSE);
                C45172d.this.cnC.mo46601g(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 4) {
                C45172d.this.cnG.put(c18405u.csP.ckD, Boolean.FALSE);
                C45172d.this.cnC.mo46604j(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 10) {
                C45172d.this.cnC.mo46602h(c18405u);
                AppMethodBeat.m2505o(137170);
            } else if (i2 == 6) {
                C45172d.this.cnC.mo46603i(c18405u);
                AppMethodBeat.m2505o(137170);
            } else {
                if (i2 == 11) {
                    C45172d.this.cnC.mo46605k(c18405u);
                }
                AppMethodBeat.m2505o(137170);
            }
        }
    }

    /* renamed from: com.tencent.mm.audio.mix.f.d$2 */
    class C451712 implements Runnable {
        final /* synthetic */ String cnX;

        C451712(String str) {
            this.cnX = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(137169);
            C45172d.this.mo73162i(11, this.cnX);
            AppMethodBeat.m2505o(137169);
        }
    }

    public C45172d() {
        AppMethodBeat.m2504i(137171);
        C17961c c17961c = this.cnB;
        C45174b.m83209i("MicroMsg.Mix.AudioMixController", "onInit");
        c17961c.mo33504Ea();
        c17961c.cmx.clear();
        c17961c.cmq = new C45168d();
        c17961c.cmq.init();
        if (this.cnD == null) {
            this.cnD = new C417813();
        }
        this.mHandler = new Handler(Looper.myLooper());
        AppMethodBeat.m2505o(137171);
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(137172);
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
                AppMethodBeat.m2505o(137172);
            }
        }
        this.cnI.clear();
        this.cmD.clear();
    }

    /* renamed from: El */
    public final void mo73145El() {
        AppMethodBeat.m2504i(137173);
        this.cnu.set(false);
        this.cnw.set(true);
        this.cnv.set(false);
        mo73149Eq();
        m83186En();
        AppMethodBeat.m2505o(137173);
    }

    /* renamed from: dQ */
    public final C17875b mo73156dQ(String str) {
        AppMethodBeat.m2504i(137174);
        if (this.clD.containsKey(str)) {
            C17875b c17875b = (C17875b) this.clD.get(str);
            AppMethodBeat.m2505o(137174);
            return c17875b;
        }
        AppMethodBeat.m2505o(137174);
        return null;
    }

    /* renamed from: dV */
    public final void mo73157dV(String str) {
        AppMethodBeat.m2504i(137175);
        this.cnB.mo33510dI(str);
        synchronized (this.cnz) {
            try {
                this.cmD.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137175);
                }
            }
        }
        this.cnF.remove(str);
        this.cnG.put(str, Boolean.FALSE);
        if (this.cnp.mo60412dE(str)) {
            mo73162i(3, str);
        }
        AppMethodBeat.m2505o(137175);
    }

    /* renamed from: dF */
    public final boolean mo73155dF(String str) {
        AppMethodBeat.m2504i(137176);
        if (this.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) this.cnH.get(str);
            if (c37491e != null) {
                if (c37491e.mo60422g(Integer.valueOf(0))) {
                    AppMethodBeat.m2505o(137176);
                    return true;
                }
            }
            if (!this.cnB.mo33511dJ(str) && this.cnp.mo60413dF(str)) {
                AppMethodBeat.m2505o(137176);
                return true;
            }
        }
        AppMethodBeat.m2505o(137176);
        return false;
    }

    /* renamed from: ef */
    public final int mo73160ef(String str) {
        AppMethodBeat.m2504i(137177);
        int dL = (int) this.cnB.mo33513dL(str);
        AppMethodBeat.m2505o(137177);
        return dL;
    }

    /* renamed from: ea */
    public final int mo73159ea(String str) {
        AppMethodBeat.m2504i(137178);
        if (this.clD.containsKey(str)) {
            String str2 = ((C17875b) this.clD.get(str)).filePath;
            if (TextUtils.isEmpty(str2)) {
                AppMethodBeat.m2505o(137178);
                return 0;
            }
            C37484c dv = C45166d.m83168Dm().mo73133dv(str2);
            if (dv != null) {
                int i = (int) dv.duration;
                AppMethodBeat.m2505o(137178);
                return i;
            }
        }
        AppMethodBeat.m2505o(137178);
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Em */
    public final void mo73146Em() {
        AppMethodBeat.m2504i(137179);
        synchronized (this) {
            try {
                if (this.cnA == null) {
                    this.cnA = new Thread(this.cnU, "audio_mix_player");
                    this.cnA.start();
                    C45174b.m83210i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", Long.valueOf(this.cnA.getId()));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137179);
            }
        }
    }

    /* renamed from: En */
    private void m83186En() {
        AppMethodBeat.m2504i(137180);
        synchronized (this) {
            try {
                if (this.cnA != null) {
                    C45174b.m83210i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", Long.valueOf(this.cnA.getId()));
                    this.cnA = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137180);
            }
        }
    }

    /* renamed from: DL */
    public final void mo73144DL() {
        AppMethodBeat.m2504i(137181);
        try {
            if (this.aQf != null) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
            }
            AppMethodBeat.m2505o(137181);
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, C27067l.NAME, new Object[0]);
            AppMethodBeat.m2505o(137181);
        }
    }

    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r0 = (com.tencent.p177mm.audio.mix.p830a.C25836b) r6.cnx.poll();
            r6.cny.notifyAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Eo */
    public final C25836b mo73147Eo() {
        AppMethodBeat.m2504i(137182);
        synchronized (this.cny) {
            while (true) {
                try {
                    if ((this.cnx.size() != 0 && !this.cnv.get()) || this.cnw.get()) {
                        break;
                    }
                    C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
                    mo73144DL();
                    if (this.aQf != null && this.aQf.getPlayState() == 3) {
                        this.aQf.stop();
                    }
                    this.cny.wait();
                    this.cnT = 0;
                } catch (InterruptedException e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "waitPlay", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(137182);
                }
            }
        }
        AppMethodBeat.m2505o(137182);
        return r0;
    }

    /* renamed from: Ep */
    public final void mo73148Ep() {
        AppMethodBeat.m2504i(137183);
        this.cnx.clear();
        AppMethodBeat.m2505o(137183);
    }

    /* renamed from: Eq */
    public final void mo73149Eq() {
        AppMethodBeat.m2504i(137184);
        synchronized (this.cny) {
            try {
                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
                this.cny.notifyAll();
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "syncNotify", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(137184);
            }
        }
        AppMethodBeat.m2505o(137184);
    }

    private synchronized boolean createAudioTrack() {
        boolean z;
        AppMethodBeat.m2504i(137185);
        C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        this.cnt = minBufferSize / 3536;
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayerImpl", "miniBufferSize:%d, channels:%d, sampleRate:%d", Integer.valueOf(minBufferSize), Integer.valueOf(this.channels), Integer.valueOf(this.sampleRate));
        if (this.aQf == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "audioTrack is null, new AudioTrack");
            try {
                this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
            } catch (IllegalArgumentException e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "AudioTrack create", new Object[0]);
            }
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            C45174b.m83207e("MicroMsg.Mix.AudioMixPlayerImpl", "audio track not initialized");
            if (this.aQf != null) {
                C45174b.m83208e("MicroMsg.Mix.AudioMixPlayerImpl", "AudioTrack getState", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e2) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(137185);
            z = false;
        } else {
            AppMethodBeat.m2505o(137185);
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: Er */
    public final synchronized void mo73150Er() {
        AppMethodBeat.m2504i(137186);
        try {
            if (this.aQf != null) {
                this.aQf.flush();
                this.aQf.stop();
                this.aQf.release();
                this.aQf = null;
            }
            AppMethodBeat.m2505o(137186);
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.m2505o(137186);
        }
        return;
    }

    /* renamed from: eg */
    public final int mo73161eg(String str) {
        AppMethodBeat.m2504i(137187);
        if (this.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) this.cnH.get(str);
            if (c37491e != null) {
                int intValue = ((Integer) c37491e.get()).intValue();
                AppMethodBeat.m2505o(137187);
                return intValue;
            }
            AppMethodBeat.m2505o(137187);
            return -1;
        }
        AppMethodBeat.m2505o(137187);
        return -1;
    }

    /* renamed from: i */
    public final void mo73162i(int i, String str) {
        AppMethodBeat.m2504i(137188);
        mo73158e(i, str, this.cnB.mo33515dP(str));
        AppMethodBeat.m2505o(137188);
    }

    /* renamed from: e */
    public final void mo73158e(int i, String str, String str2) {
        AppMethodBeat.m2504i(137189);
        C17875b c17875b = (C17875b) this.clD.get(str);
        if (c17875b == null) {
            AppMethodBeat.m2505o(137189);
            return;
        }
        C18405u c18405u = new C18405u();
        c18405u.csP.ckD = str;
        c18405u.csP.action = i;
        c18405u.csP.appId = c17875b.appId;
        if (TextUtils.isEmpty(str2)) {
            str2 = c17875b.clP;
        }
        c18405u.csP.clP = str2;
        c18405u.csP.state = C18405u.m28656gI(i);
        if (this.cnD != null) {
            this.cnD.mo43830a(c18405u);
        }
        AppMethodBeat.m2505o(137189);
    }

    /* renamed from: a */
    public final void mo73153a(int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(137190);
        C17875b c17875b = (C17875b) this.clD.get(str);
        if (c17875b == null) {
            AppMethodBeat.m2505o(137190);
            return;
        }
        C18405u c18405u = new C18405u();
        c18405u.csP.ckD = str;
        c18405u.csP.action = i;
        c18405u.csP.appId = c17875b.appId;
        c18405u.csP.errCode = i2;
        c18405u.csP.aIm = str2;
        c18405u.csP.state = C18405u.m28656gI(i);
        if (this.cnD != null) {
            this.cnD.mo43830a(c18405u);
        }
        AppMethodBeat.m2505o(137190);
    }

    /* JADX WARNING: Missing block: B:13:0x0063, code skipped:
            if (r0.mo60422g(java.lang.Integer.valueOf(2)) != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Es */
    public final int mo73151Es() {
        int i = 0;
        AppMethodBeat.m2504i(137191);
        synchronized (this.cnz) {
            try {
                Set keySet = this.cnH.keySet();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(keySet);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int i2;
                    C37491e c37491e = (C37491e) this.cnH.get((String) it.next());
                    if (c37491e != null) {
                        if (!c37491e.mo60422g(Integer.valueOf(0))) {
                            if (!c37491e.mo60422g(Integer.valueOf(1))) {
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
                AppMethodBeat.m2505o(137191);
            }
        }
        return i;
    }

    /* renamed from: Et */
    public final ArrayList<String> mo73152Et() {
        AppMethodBeat.m2504i(137192);
        this.cnJ.clear();
        this.cnV.clear();
        synchronized (this.cnz) {
            try {
                this.cnV.addAll(this.cnH.keySet());
                Iterator it = this.cnV.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    C37491e c37491e = (C37491e) this.cnH.get(str);
                    if (c37491e != null) {
                        if (c37491e.mo60422g(Integer.valueOf(2))) {
                            this.cnJ.add(str);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137192);
            }
        }
        ArrayList<String> arrayList = this.cnJ;
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m83187a(C45172d c45172d) {
        AppMethodBeat.m2504i(137193);
        if (c45172d.createAudioTrack()) {
            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "create AudioTrack success");
            c45172d.aQf.play();
            AppMethodBeat.m2505o(137193);
            return;
        }
        C45174b.m83208e("MicroMsg.Mix.AudioMixPlayerImpl", "onError, errCode:%d", Integer.valueOf(710));
        AppMethodBeat.m2505o(137193);
    }
}
