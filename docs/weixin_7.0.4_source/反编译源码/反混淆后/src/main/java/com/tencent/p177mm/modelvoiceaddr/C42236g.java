package com.tencent.p177mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C25835a;
import com.tencent.p177mm.audio.p1180d.C45163c;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvoiceaddr.C42237h.C32853a;
import com.tencent.p177mm.modelvoiceaddr.p1208a.C18721c;
import com.tencent.p177mm.modelvoiceaddr.p1208a.C18721c.C18722a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import java.io.File;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.g */
public final class C42236g implements C1202f, C18725b {
    private static int cri = 5000;
    private static final String gaQ = (C5128ac.eSj + "voice_temp.silk");
    public static int gbc = 1;
    public static int gbd = 2;
    public static int gbe = 4;
    private C1292c coZ;
    private C1293a cpM = new C18871();
    private int gaD = gbc;
    private int gaS = 0;
    private int gaT = 0;
    private boolean gaU = false;
    private C25835a gaY;
    private C18723a gba = null;
    private boolean gbf = false;
    private C32852b gbg = null;
    private C18721c gbh;
    private C18722a gbi = new C97522();
    private int scene = 0;

    /* renamed from: com.tencent.mm.modelvoiceaddr.g$1 */
    class C18871 implements C1293a {
        short[] gbj;

        C18871() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(116704);
            C4990ab.m7411d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            if (this.gbj == null || this.gbj.length < i / 2) {
                this.gbj = new short[(i / 2)];
            }
            while (i2 < i / 2) {
                this.gbj[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                i2++;
            }
            C42236g.m74550a(C42236g.this, this.gbj, i / 2);
            if (C42236g.this.gbh != null) {
                C42236g.this.gbh.mo33988f(this.gbj, i / 2);
                AppMethodBeat.m2505o(116704);
                return;
            }
            C42236g.this.mo67760cG(9, -1);
            C4990ab.m7412e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.m2505o(116704);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(116705);
            C4990ab.m7413e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i), Integer.valueOf(i2));
            C42236g.this.mo67760cG(10, -1);
            AppMethodBeat.m2505o(116705);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.g$2 */
    class C97522 implements C18722a {
        byte[] gbl;

        /* renamed from: com.tencent.mm.modelvoiceaddr.g$2$1 */
        class C97531 implements Runnable {
            C97531() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116706);
                C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", Integer.valueOf(C42236g.this.gaT), Long.valueOf(System.currentTimeMillis()));
                if (C42236g.this.gbf || C42236g.this.gba == null || C42236g.this.gaT == 0) {
                    C4990ab.m7420w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                    AppMethodBeat.m2505o(116706);
                    return;
                }
                C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_AUTOLEVEL, C42236g.this);
                if (!(((C32851c) C42236g.this.gba).amo() && C1720g.m3540Rg().mo14541a(C42236g.this.gba, 0))) {
                    C42236g.this.mo67760cG(13, 131);
                }
                AppMethodBeat.m2505o(116706);
            }
        }

        C97522() {
        }

        /* renamed from: c */
        public final void mo21122c(short[] sArr, int i) {
            AppMethodBeat.m2504i(116707);
            if (sArr == null) {
                AppMethodBeat.m2505o(116707);
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
            if (C42236g.this.gaY != null) {
                i2 = C42236g.this.gaY.mo43823a(new C32305a(this.gbl, i * 2), 0, true);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                C42236g.this.mo67760cG(4, -1);
                C4990ab.m7412e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                AppMethodBeat.m2505o(116707);
                return;
            }
            C42236g.this.gaT = i2 + C42236g.this.gaT;
            if (!(C42236g.this.gbf || C42236g.this.gaT <= 200 || C42236g.this.gaU)) {
                C1720g.m3539RS().mo10302aa(new C97531());
                C42236g.this.gaU = true;
            }
            AppMethodBeat.m2505o(116707);
        }

        public final void amu() {
            AppMethodBeat.m2504i(116708);
            C4990ab.m7416i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (C42236g.this.gba instanceof C32851c) {
                try {
                    ((C32851c) C42236g.this.gba).mo53423mw(C1173e.m2560cs(C42236g.gaQ));
                    AppMethodBeat.m2505o(116708);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                    C42236g.this.mo67760cG(6, -1);
                }
            }
            AppMethodBeat.m2505o(116708);
        }

        public final void amv() {
            AppMethodBeat.m2504i(116709);
            C4990ab.m7416i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (C42236g.this.gba instanceof C32851c) {
                try {
                    C42237h c42237h = ((C32851c) C42236g.this.gba).gay;
                    C4990ab.m7416i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                    c42237h.gbt.writeLock().lock();
                    C32853a c32853a = new C32853a();
                    c42237h.gbs.put(c32853a.gbv, c32853a);
                    c42237h.gbt.writeLock().unlock();
                    if (C42236g.this.gaY.mo43821Ff()) {
                        AppMethodBeat.m2505o(116709);
                        return;
                    }
                    C42236g.this.mo67760cG(5, -1);
                    AppMethodBeat.m2505o(116709);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                    C42236g.this.mo67760cG(6, -1);
                }
            }
            AppMethodBeat.m2505o(116709);
        }

        /* renamed from: CV */
        public final void mo21119CV() {
            AppMethodBeat.m2504i(116710);
            C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            C42236g.this.stop(false);
            AppMethodBeat.m2505o(116710);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.g$b */
    public interface C32852b {
        void ams();

        void amw();

        /* renamed from: b */
        void mo21116b(String[] strArr, List<String> list);

        /* renamed from: c */
        void mo21117c(int i, int i2, int i3, long j);
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.g$a */
    class C37968a implements Runnable {
        private C37968a() {
        }

        /* synthetic */ C37968a(C42236g c42236g, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(116711);
            synchronized (C42236g.this) {
                String valueOf;
                try {
                    C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", Long.valueOf(System.currentTimeMillis()));
                    long nanoTime = System.nanoTime() & 4294967295L;
                    if (nanoTime < 0) {
                        nanoTime = Math.abs(nanoTime);
                    }
                    valueOf = String.valueOf(nanoTime);
                    File file = new File(C42236g.gaQ);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    file = new File(C42236g.gaQ);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    file.delete();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(116711);
                }
                C42236g.this.coZ = new C1292c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                C42236g.this.coZ.cpB = -19;
                C42236g.this.coZ.mo4595bq(false);
                C42236g.this.gaY = new C45163c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 23900);
                if (C42236g.this.gaY.mo43824eo(C42236g.gaQ)) {
                    if (C1427q.etn.erW > 0) {
                        C42236g.this.coZ.mo4599v(C1427q.etn.erW, true);
                    } else {
                        C42236g.this.coZ.mo4599v(5, false);
                    }
                    C42236g.this.coZ.mo4598gG(50);
                    C42236g.this.coZ.mo4596br(false);
                    try {
                        int i;
                        C42236g.this.gbh = new C18721c();
                        C42236g.this.gbh.gbP = C42236g.this.gbi;
                        C5141c ll = C18624c.abi().mo17131ll("100235");
                        if (ll.isValid()) {
                            i = C5046bo.getInt((String) ll.dru().get("MMVoipVadOn"), 0);
                        } else {
                            i = 0;
                        }
                        C42236g.this.gba = new C32851c(C42236g.gaQ, valueOf, String.valueOf(i), C42236g.this.gaD, C42236g.this.scene);
                        C42236g.this.coZ.cpM = C42236g.this.cpM;
                        if (!C42236g.this.coZ.mo4592EL()) {
                            C4990ab.m7412e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                            C42236g.this.mo67760cG(8, -1);
                        }
                    } catch (Throwable th2) {
                        C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", th2, "init VoiceDetectAPI failed", new Object[0]);
                        C42236g.this.mo67760cG(7, -1);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                    C42236g.this.gaY.mo43820Fe();
                    C42236g.this.gaY = null;
                    C42236g.this.mo67760cG(5, -1);
                }
            }
            AppMethodBeat.m2505o(116711);
        }
    }

    static {
        AppMethodBeat.m2504i(116721);
        AppMethodBeat.m2505o(116721);
    }

    public C42236g() {
        AppMethodBeat.m2504i(116712);
        AppMethodBeat.m2505o(116712);
    }

    public final void init(int i, int i2, C32852b c32852b) {
        this.gaD = i;
        this.gbg = c32852b;
        this.scene = i2;
    }

    public C42236g(int i, int i2, C32852b c32852b) {
        AppMethodBeat.m2504i(116713);
        this.gaD = i;
        this.gbg = c32852b;
        this.scene = i2;
        AppMethodBeat.m2505o(116713);
    }

    public final void start() {
        AppMethodBeat.m2504i(116714);
        C4990ab.m7416i("MicroMsg.SceneVoiceInputAddr", "start record");
        C7305d.m12298f(new C37968a(this, (byte) 0), "SceneVoiceInputAddr_record");
        AppMethodBeat.m2505o(116714);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(116715);
        String[] amk = ((C18723a) c1207m).amk();
        List amn = ((C18723a) c1207m).amn();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(amk == null ? -1 : amk.length);
        objArr[4] = Integer.valueOf(c1207m.hashCode());
        objArr[5] = Integer.valueOf(this.gba == null ? -1 : this.gba.hashCode());
        C4990ab.m7411d(str2, str3, objArr);
        if (this.gba == null || c1207m.hashCode() != this.gba.hashCode()) {
            C4990ab.m7410d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
            AppMethodBeat.m2505o(116715);
            return;
        }
        if (this.gbg != null) {
            if (i2 == 0 && i == 0) {
                this.gbg.mo21116b(amk, amn);
                if ((c1207m instanceof C32851c) && this.gaT == 0 && ((C32851c) c1207m).gay.amy()) {
                    this.gbg.amw();
                    cancel(false);
                }
            } else {
                if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                    this.gbg.mo21117c(13, 132, -1, -1);
                } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                    this.gbg.mo21117c(11, i, i2, (long) ((C18723a) c1207m).amm());
                } else {
                    this.gbg.mo21117c(13, C19394e.CTRL_INDEX, -1, -1);
                }
                cancel(false);
                AppMethodBeat.m2505o(116715);
                return;
            }
        }
        AppMethodBeat.m2505o(116715);
    }

    /* renamed from: cG */
    public final void mo67760cG(int i, int i2) {
        AppMethodBeat.m2504i(116716);
        C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1));
        if (this.gbg != null) {
            this.gbg.mo21117c(i, i2, -1, -1);
        }
        m74561l(false, true);
        AppMethodBeat.m2505o(116716);
    }

    public final void stop(boolean z) {
        AppMethodBeat.m2504i(116717);
        C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!(z || this.gbg == null)) {
            this.gbg.ams();
        }
        m74561l(true, true);
        AppMethodBeat.m2505o(116717);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.m2504i(116718);
        C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.gbg = null;
        m74561l(false, z);
        AppMethodBeat.m2505o(116718);
    }

    /* JADX WARNING: Missing block: B:28:0x006e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(116719);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private void m74561l(boolean z, boolean z2) {
        AppMethodBeat.m2504i(116719);
        C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "reset keepNetScene = %s,sendLastScene = %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        synchronized (this) {
            try {
                this.gbf = true;
                if (this.coZ != null) {
                    this.coZ.mo4590EB();
                    this.coZ = null;
                }
                if (this.gaY != null) {
                    this.gaY.mo43820Fe();
                    this.gaY = null;
                }
                if (this.gbh != null) {
                    this.gbh.release();
                    this.gbh = null;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(116719);
            }
            this.gaT = 0;
            if (this.gba != null && (this.gba instanceof C32851c)) {
                this.gba.amj();
                try {
                    ((C32851c) this.gba).mo53423mw(C1173e.m2560cs(gaQ));
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "reset cutShortSentence error", new Object[0]);
                    mo67760cG(6, -1);
                }
            }
            if (!z) {
                if (this.gaU) {
                    if (this.gba != null && (this.gba instanceof C32851c)) {
                        C4990ab.m7417i("MicroMsg.SceneVoiceInputAddr", "reset call stop() sendLastScene:%s", Boolean.valueOf(z2));
                        if (z2) {
                            ((C32851c) this.gba).amp();
                        }
                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_AUTOLEVEL, (C1202f) this);
                    }
                    this.gba = null;
                    this.gaU = false;
                    AppMethodBeat.m2505o(116719);
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

    /* renamed from: a */
    static /* synthetic */ void m74550a(C42236g c42236g, short[] sArr, int i) {
        AppMethodBeat.m2504i(116720);
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > c42236g.gaS) {
                c42236g.gaS = s;
            }
        }
        C4990ab.m7411d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(c42236g.gaS));
        AppMethodBeat.m2505o(116720);
    }
}
