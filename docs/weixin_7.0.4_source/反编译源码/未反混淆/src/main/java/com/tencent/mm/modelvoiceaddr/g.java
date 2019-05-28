package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.d;
import java.io.File;
import java.util.List;

public final class g implements f, b {
    private static int cri = 5000;
    private static final String gaQ = (ac.eSj + "voice_temp.silk");
    public static int gbc = 1;
    public static int gbd = 2;
    public static int gbe = 4;
    private c coZ;
    private com.tencent.mm.audio.b.c.a cpM = new com.tencent.mm.audio.b.c.a() {
        short[] gbj;

        public final void u(byte[] bArr, int i) {
            int i2 = 0;
            AppMethodBeat.i(116704);
            ab.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            if (this.gbj == null || this.gbj.length < i / 2) {
                this.gbj = new short[(i / 2)];
            }
            while (i2 < i / 2) {
                this.gbj[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                i2++;
            }
            g.a(g.this, this.gbj, i / 2);
            if (g.this.gbh != null) {
                g.this.gbh.f(this.gbj, i / 2);
                AppMethodBeat.o(116704);
                return;
            }
            g.this.cG(9, -1);
            ab.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.o(116704);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(116705);
            ab.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i), Integer.valueOf(i2));
            g.this.cG(10, -1);
            AppMethodBeat.o(116705);
        }
    };
    private int gaD = gbc;
    private int gaS = 0;
    private int gaT = 0;
    private boolean gaU = false;
    private com.tencent.mm.audio.d.a gaY;
    private a gba = null;
    private boolean gbf = false;
    private b gbg = null;
    private com.tencent.mm.modelvoiceaddr.a.c gbh;
    private com.tencent.mm.modelvoiceaddr.a.c.a gbi = new com.tencent.mm.modelvoiceaddr.a.c.a() {
        byte[] gbl;

        public final void c(short[] sArr, int i) {
            AppMethodBeat.i(116707);
            if (sArr == null) {
                AppMethodBeat.o(116707);
                return;
            }
            int i2;
            if (this.gbl == null || this.gbl.length < i * 2) {
                this.gbl = new byte[(i * 2)];
            }
            for (i2 = 0; i2 < i; i2++) {
                this.gbl[i2 * 2] = (byte) (sArr[i2] & 255);
                this.gbl[(i2 * 2) + 1] = (byte) ((sArr[i2] & 65280) >> 8);
            }
            if (g.this.gaY != null) {
                i2 = g.this.gaY.a(new com.tencent.mm.audio.b.g.a(this.gbl, i * 2), 0, true);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                g.this.cG(4, -1);
                ab.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                AppMethodBeat.o(116707);
                return;
            }
            g.this.gaT = i2 + g.this.gaT;
            if (!(g.this.gbf || g.this.gaT <= 200 || g.this.gaU)) {
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(116706);
                        ab.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", Integer.valueOf(g.this.gaT), Long.valueOf(System.currentTimeMillis()));
                        if (g.this.gbf || g.this.gba == null || g.this.gaT == 0) {
                            ab.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                            AppMethodBeat.o(116706);
                            return;
                        }
                        com.tencent.mm.kernel.g.Rg().a((int) d.MIC_PTU_AUTOLEVEL, g.this);
                        if (!(((c) g.this.gba).amo() && com.tencent.mm.kernel.g.Rg().a(g.this.gba, 0))) {
                            g.this.cG(13, 131);
                        }
                        AppMethodBeat.o(116706);
                    }
                });
                g.this.gaU = true;
            }
            AppMethodBeat.o(116707);
        }

        public final void amu() {
            AppMethodBeat.i(116708);
            ab.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (g.this.gba instanceof c) {
                try {
                    ((c) g.this.gba).mw(e.cs(g.gaQ));
                    AppMethodBeat.o(116708);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                    g.this.cG(6, -1);
                }
            }
            AppMethodBeat.o(116708);
        }

        public final void amv() {
            AppMethodBeat.i(116709);
            ab.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (g.this.gba instanceof c) {
                try {
                    h hVar = ((c) g.this.gba).gay;
                    ab.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                    hVar.gbt.writeLock().lock();
                    com.tencent.mm.modelvoiceaddr.h.a aVar = new com.tencent.mm.modelvoiceaddr.h.a();
                    hVar.gbs.put(aVar.gbv, aVar);
                    hVar.gbt.writeLock().unlock();
                    if (g.this.gaY.Ff()) {
                        AppMethodBeat.o(116709);
                        return;
                    }
                    g.this.cG(5, -1);
                    AppMethodBeat.o(116709);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                    g.this.cG(6, -1);
                }
            }
            AppMethodBeat.o(116709);
        }

        public final void CV() {
            AppMethodBeat.i(116710);
            ab.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            g.this.stop(false);
            AppMethodBeat.o(116710);
        }
    };
    private int scene = 0;

    public interface b {
        void ams();

        void amw();

        void b(String[] strArr, List<String> list);

        void c(int i, int i2, int i3, long j);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(116711);
            synchronized (g.this) {
                String valueOf;
                try {
                    ab.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", Long.valueOf(System.currentTimeMillis()));
                    long nanoTime = System.nanoTime() & 4294967295L;
                    if (nanoTime < 0) {
                        nanoTime = Math.abs(nanoTime);
                    }
                    valueOf = String.valueOf(nanoTime);
                    File file = new File(g.gaQ);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    file = new File(g.gaQ);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    file.delete();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(116711);
                }
                g.this.coZ = new c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                g.this.coZ.cpB = -19;
                g.this.coZ.bq(false);
                g.this.gaY = new com.tencent.mm.audio.d.c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 23900);
                if (g.this.gaY.eo(g.gaQ)) {
                    if (q.etn.erW > 0) {
                        g.this.coZ.v(q.etn.erW, true);
                    } else {
                        g.this.coZ.v(5, false);
                    }
                    g.this.coZ.gG(50);
                    g.this.coZ.br(false);
                    try {
                        int i;
                        g.this.gbh = new com.tencent.mm.modelvoiceaddr.a.c();
                        g.this.gbh.gbP = g.this.gbi;
                        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100235");
                        if (ll.isValid()) {
                            i = bo.getInt((String) ll.dru().get("MMVoipVadOn"), 0);
                        } else {
                            i = 0;
                        }
                        g.this.gba = new c(g.gaQ, valueOf, String.valueOf(i), g.this.gaD, g.this.scene);
                        g.this.coZ.cpM = g.this.cpM;
                        if (!g.this.coZ.EL()) {
                            ab.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                            g.this.cG(8, -1);
                        }
                    } catch (Throwable th2) {
                        ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", th2, "init VoiceDetectAPI failed", new Object[0]);
                        g.this.cG(7, -1);
                    }
                } else {
                    ab.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                    g.this.gaY.Fe();
                    g.this.gaY = null;
                    g.this.cG(5, -1);
                }
            }
            AppMethodBeat.o(116711);
        }
    }

    static {
        AppMethodBeat.i(116721);
        AppMethodBeat.o(116721);
    }

    public g() {
        AppMethodBeat.i(116712);
        AppMethodBeat.o(116712);
    }

    public final void init(int i, int i2, b bVar) {
        this.gaD = i;
        this.gbg = bVar;
        this.scene = i2;
    }

    public g(int i, int i2, b bVar) {
        AppMethodBeat.i(116713);
        this.gaD = i;
        this.gbg = bVar;
        this.scene = i2;
        AppMethodBeat.o(116713);
    }

    public final void start() {
        AppMethodBeat.i(116714);
        ab.i("MicroMsg.SceneVoiceInputAddr", "start record");
        com.tencent.mm.sdk.g.d.f(new a(this, (byte) 0), "SceneVoiceInputAddr_record");
        AppMethodBeat.o(116714);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(116715);
        String[] amk = ((a) mVar).amk();
        List amn = ((a) mVar).amn();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(amk == null ? -1 : amk.length);
        objArr[4] = Integer.valueOf(mVar.hashCode());
        objArr[5] = Integer.valueOf(this.gba == null ? -1 : this.gba.hashCode());
        ab.d(str2, str3, objArr);
        if (this.gba == null || mVar.hashCode() != this.gba.hashCode()) {
            ab.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
            AppMethodBeat.o(116715);
            return;
        }
        if (this.gbg != null) {
            if (i2 == 0 && i == 0) {
                this.gbg.b(amk, amn);
                if ((mVar instanceof c) && this.gaT == 0 && ((c) mVar).gay.amy()) {
                    this.gbg.amw();
                    cancel(false);
                }
            } else {
                if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                    this.gbg.c(13, 132, -1, -1);
                } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                    this.gbg.c(11, i, i2, (long) ((a) mVar).amm());
                } else {
                    this.gbg.c(13, com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX, -1, -1);
                }
                cancel(false);
                AppMethodBeat.o(116715);
                return;
            }
        }
        AppMethodBeat.o(116715);
    }

    public final void cG(int i, int i2) {
        AppMethodBeat.i(116716);
        ab.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1));
        if (this.gbg != null) {
            this.gbg.c(i, i2, -1, -1);
        }
        l(false, true);
        AppMethodBeat.o(116716);
    }

    public final void stop(boolean z) {
        AppMethodBeat.i(116717);
        ab.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!(z || this.gbg == null)) {
            this.gbg.ams();
        }
        l(true, true);
        AppMethodBeat.o(116717);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(116718);
        ab.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.gbg = null;
        l(false, z);
        AppMethodBeat.o(116718);
    }

    /* JADX WARNING: Missing block: B:28:0x006e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(116719);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(boolean z, boolean z2) {
        AppMethodBeat.i(116719);
        ab.i("MicroMsg.SceneVoiceInputAddr", "reset keepNetScene = %s,sendLastScene = %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        synchronized (this) {
            try {
                this.gbf = true;
                if (this.coZ != null) {
                    this.coZ.EB();
                    this.coZ = null;
                }
                if (this.gaY != null) {
                    this.gaY.Fe();
                    this.gaY = null;
                }
                if (this.gbh != null) {
                    this.gbh.release();
                    this.gbh = null;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(116719);
            }
            this.gaT = 0;
            if (this.gba != null && (this.gba instanceof c)) {
                this.gba.amj();
                try {
                    ((c) this.gba).mw(e.cs(gaQ));
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "reset cutShortSentence error", new Object[0]);
                    cG(6, -1);
                }
            }
            if (!z) {
                if (this.gaU) {
                    if (this.gba != null && (this.gba instanceof c)) {
                        ab.i("MicroMsg.SceneVoiceInputAddr", "reset call stop() sendLastScene:%s", Boolean.valueOf(z2));
                        if (z2) {
                            ((c) this.gba).amp();
                        }
                        com.tencent.mm.kernel.g.Rg().b((int) d.MIC_PTU_AUTOLEVEL, (f) this);
                    }
                    this.gba = null;
                    this.gaU = false;
                    AppMethodBeat.o(116719);
                }
            }
        }
    }

    public final int getMaxAmplitudeRate() {
        int i = this.gaS;
        this.gaS = 0;
        if (i > cri) {
            cri = i;
        }
        return (i * 100) / cri;
    }

    static /* synthetic */ void a(g gVar, short[] sArr, int i) {
        AppMethodBeat.i(116720);
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > gVar.gaS) {
                gVar.gaS = s;
            }
        }
        ab.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(gVar.gaS));
        AppMethodBeat.o(116720);
    }
}
