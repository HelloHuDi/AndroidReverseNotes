package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qafpapi.QAFPNative;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.shake.d.a.a */
public final class C46198a implements C1202f {
    C1292c coZ;
    private C1293a cqd = new C132581();
    Object kbe = new Object();
    long qtA;
    int qtB;
    private boolean qtC = false;
    byte[] qtn = new byte[10240];
    int qto = 0;
    int qtp = 0;
    long qtq = 0;
    int qtr = 0;
    boolean qts = false;
    C13261e qtt = null;
    private C34896a qtu = null;
    boolean qtv = false;
    boolean qtw = false;
    int qtx = 0;
    int qty;
    private boolean qtz = false;

    /* renamed from: com.tencent.mm.plugin.shake.d.a.a$1 */
    class C132581 implements C1293a {
        C132581() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int QAFPProcessTV;
            AppMethodBeat.m2504i(24589);
            C1446a c1446a = new C1446a();
            synchronized (C46198a.this.kbe) {
                try {
                    if (C46198a.this.qtr == 408) {
                        C4990ab.m7418v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                        QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
                    } else {
                        QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(24589);
                }
            }
            long anU = C5046bo.anU() - C46198a.this.qtA;
            C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", Integer.valueOf(C46198a.this.qtx), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(anU), Long.valueOf(c1446a.mo4908Mr()));
            if (anU > ((long) ((C46198a.this.qtB * AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) + WearableStatusCodes.TARGET_NODE_NOT_CONNECTED))) {
                byte[] bArr2 = new byte[10240];
                C1446a c1446a2 = new C1446a();
                if (C46198a.this.qtr == 408) {
                    C4990ab.m7418v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(bArr2);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(bArr2);
                }
                C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", Integer.valueOf(C46198a.this.qtx), Integer.valueOf(QAFPProcessTV), Long.valueOf(c1446a2.mo4908Mr()));
                if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                    C4990ab.m7413e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", Integer.valueOf(C46198a.this.qtx), Integer.valueOf(QAFPProcessTV));
                    C46198a.this.reset();
                    AppMethodBeat.m2505o(24589);
                    return;
                }
                synchronized (C46198a.this.qtn) {
                    try {
                        boolean z;
                        System.arraycopy(bArr2, 0, C46198a.this.qtn, 0, QAFPProcessTV);
                        C46198a.this.qto = QAFPProcessTV;
                        C46198a c46198a = C46198a.this;
                        if (C46198a.this.qtB >= 3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c46198a.qtw = z;
                        C46198a.this.qtp = (int) (anU / 1000);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(24589);
                        }
                    }
                }
                C46198a.this.agK();
                C46198a c46198a2 = C46198a.this;
                c46198a2.qtB++;
            }
            if (C46198a.this.qtw) {
                C4990ab.m7421w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", Integer.valueOf(C46198a.this.qtx), Long.valueOf(anU));
                C46198a.this.reset();
            }
            AppMethodBeat.m2505o(24589);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.a$3 */
    class C218303 implements Runnable {
        C218303() {
        }

        /* JADX WARNING: Missing block: B:12:0x0053, code skipped:
            r11.qtD.qtv = true;
            r0 = r11.qtD.qtr;
            r3 = r11.qtD.qtp;
            r6 = r11.qtD.qtx;
            r7 = r11.qtD.qtw;
            r8 = r11.qtD.qty;
     */
        /* JADX WARNING: Missing block: B:13:0x006d, code skipped:
            if (r0 != 367) goto L_0x0085;
     */
        /* JADX WARNING: Missing block: B:14:0x006f, code skipped:
            r1 = new com.tencent.p177mm.plugin.shake.p509d.p510a.C34897f(r2, r3, r4, r6, r7, r8);
     */
        /* JADX WARNING: Missing block: B:15:0x0074, code skipped:
            com.tencent.p177mm.model.C9638aw.m17182Rg().mo14541a(r1, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(24591);
     */
        /* JADX WARNING: Missing block: B:21:0x0087, code skipped:
            if (r0 != 408) goto L_0x008f;
     */
        /* JADX WARNING: Missing block: B:22:0x0089, code skipped:
            r1 = new com.tencent.p177mm.plugin.shake.p509d.p510a.C34898g(r2, r3, r4, r6, r7, r8);
     */
        /* JADX WARNING: Missing block: B:23:0x008f, code skipped:
            r1 = null;
     */
        /* JADX WARNING: Missing block: B:29:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(24591);
            if (C46198a.this.qtv) {
                C4990ab.m7413e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", Integer.valueOf(C46198a.this.qtx));
                AppMethodBeat.m2505o(24591);
                return;
            }
            synchronized (C46198a.this.qtn) {
                try {
                    if (C46198a.this.qto <= 0) {
                    } else {
                        byte[] bArr = new byte[C46198a.this.qto];
                        System.arraycopy(C46198a.this.qtn, 0, bArr, 0, C46198a.this.qto);
                        C46198a.this.qto = 0;
                        long j = C46198a.this.qtq;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(24591);
                }
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(24592);
            String str = super.toString() + "|tryStartNetscene";
            AppMethodBeat.m2505o(24592);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.a$a */
    public interface C34896a {
        /* renamed from: b */
        void mo25333b(btd btd, long j, boolean z);
    }

    public C46198a() {
        AppMethodBeat.m2504i(24593);
        AppMethodBeat.m2505o(24593);
    }

    /* renamed from: a */
    static /* synthetic */ void m86383a(C46198a c46198a, btd btd, long j, boolean z) {
        AppMethodBeat.m2504i(24603);
        c46198a.m86384a(btd, j, z);
        AppMethodBeat.m2505o(24603);
    }

    public final boolean ckt() {
        boolean z = false;
        AppMethodBeat.m2504i(24594);
        synchronized (this.kbe) {
            try {
                if (this.qtz) {
                    C4990ab.m7410d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
                } else {
                    int QAFPInit = QAFPNative.QAFPInit();
                    C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", Integer.valueOf(QAFPInit));
                    if (QAFPInit >= 0) {
                        this.qtz = true;
                    }
                    if (QAFPInit >= 0) {
                        z = true;
                    }
                    AppMethodBeat.m2505o(24594);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(24594);
            }
        }
        return z;
    }

    public final boolean cku() {
        boolean z = false;
        AppMethodBeat.m2504i(24595);
        synchronized (this.kbe) {
            try {
                if (this.qtz) {
                    C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", Integer.valueOf(QAFPNative.QAFPRelease()));
                    if (QAFPNative.QAFPRelease() >= 0) {
                        z = true;
                    }
                    AppMethodBeat.m2505o(24595);
                } else {
                    C4990ab.m7410d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(24595);
            }
        }
        return z;
    }

    /* renamed from: EB */
    public final boolean mo74193EB() {
        AppMethodBeat.m2504i(24596);
        C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", Integer.valueOf(this.qtx));
        C9638aw.m17182Rg().mo14546b(367, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(408, (C1202f) this);
        synchronized (this.qtn) {
            try {
                this.qto = 0;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(24596);
                }
            }
        }
        if (this.coZ != null) {
            this.coZ.mo4590EB();
            this.coZ = null;
        }
        AppMethodBeat.m2505o(24596);
        return true;
    }

    /* renamed from: a */
    public final boolean mo74194a(int i, C34896a c34896a) {
        AppMethodBeat.m2504i(24597);
        mo74193EB();
        synchronized (this.kbe) {
            try {
                this.qty = QAFPNative.QAFPGetVersion();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(24597);
            }
        }
        ckt();
        this.qtr = i;
        this.qtu = c34896a;
        this.qtw = false;
        this.qtv = false;
        this.qts = false;
        this.qtC = false;
        C9638aw.m17182Rg().mo14539a(367, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(408, (C1202f) this);
        this.qtx = (int) C5046bo.anU();
        C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", Integer.valueOf(this.qtx));
        this.coZ = new C1292c(TXRecordCommon.AUDIO_SAMPLERATE_8000, 1, 4);
        this.coZ.cpB = -19;
        this.coZ.cpM = this.cqd;
        if (this.coZ.mo4592EL()) {
            synchronized (this.kbe) {
                try {
                    C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", Integer.valueOf(QAFPNative.QAFPReset()));
                    if (QAFPNative.QAFPReset() < 0) {
                        C4990ab.m7413e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", Integer.valueOf(r3), Integer.valueOf(this.qtx));
                        reset();
                    } else {
                        this.qtq = C5046bo.anU();
                        this.qtA = C5046bo.anU();
                        this.qtB = 0;
                        AppMethodBeat.m2505o(24597);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(24597);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
            reset();
            return false;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.m2504i(24598);
        C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", Integer.valueOf(this.qtx));
        if (this.coZ != null) {
            this.coZ.mo4590EB();
            this.coZ = null;
        }
        m86385ks(false);
        AppMethodBeat.m2505o(24598);
    }

    /* renamed from: ks */
    private void m86385ks(final boolean z) {
        AppMethodBeat.m2504i(24599);
        C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", Boolean.FALSE);
        C5004al.m7441d(new Runnable() {
            final /* synthetic */ boolean qtE = false;

            public final void run() {
                AppMethodBeat.m2504i(24590);
                if (this.qtE) {
                    C46198a.m86383a(C46198a.this, null, -1, z);
                    AppMethodBeat.m2505o(24590);
                } else if (!C46198a.this.qts) {
                    C4990ab.m7420w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
                    AppMethodBeat.m2505o(24590);
                } else if (C46198a.this.coZ != null) {
                    C4990ab.m7420w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
                    AppMethodBeat.m2505o(24590);
                } else if (C46198a.this.qtt != null) {
                    C46198a c46198a = C46198a.this;
                    btd ckw = C46198a.this.qtt.ckw();
                    C13261e c13261e = C46198a.this.qtt;
                    long anU = C5046bo.anU();
                    if (c13261e.qtJ > 0 && c13261e.qtJ < anU) {
                        anU = c13261e.qtJ;
                    }
                    C46198a.m86383a(c46198a, ckw, anU, z);
                    AppMethodBeat.m2505o(24590);
                } else {
                    C46198a.m86383a(C46198a.this, null, -1, z);
                    AppMethodBeat.m2505o(24590);
                }
            }
        });
        AppMethodBeat.m2505o(24599);
    }

    /* renamed from: a */
    private synchronized void m86384a(btd btd, long j, boolean z) {
        AppMethodBeat.m2504i(24600);
        if (this.qtC) {
            C4990ab.m7420w("MicroMsg.MusicFingerPrintRecorder", "hy: already call backed to UI");
            AppMethodBeat.m2505o(24600);
        } else {
            this.qtu.mo25333b(btd, j, z);
            this.qtC = true;
            AppMethodBeat.m2505o(24600);
        }
    }

    /* Access modifiers changed, original: final */
    public final void agK() {
        AppMethodBeat.m2504i(24601);
        C9638aw.m17180RS().mo10302aa(new C218303());
        AppMethodBeat.m2505o(24601);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24602);
        if (c1207m.getType() == 367 || c1207m.getType() == 408) {
            C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.qtv = false;
            if (((C13261e) c1207m).ckv()) {
                C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", Integer.valueOf(this.qtx));
                mo74193EB();
                this.qtt = (C13261e) c1207m;
                this.qts = true;
                m86385ks(false);
                AppMethodBeat.m2505o(24602);
                return;
            } else if (this.qto == 0 && this.qtw) {
                C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", Integer.valueOf(this.qtx));
                this.qtt = null;
                this.qts = true;
                if (i == 0 && i2 == 0) {
                    m86385ks(false);
                } else {
                    m86385ks(true);
                }
                C9638aw.m17182Rg().mo14546b(367, (C1202f) this);
                C9638aw.m17182Rg().mo14546b(408, (C1202f) this);
                AppMethodBeat.m2505o(24602);
                return;
            } else {
                C4990ab.m7411d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", Integer.valueOf(this.qtx));
                agK();
                AppMethodBeat.m2505o(24602);
                return;
            }
        }
        AppMethodBeat.m2505o(24602);
    }
}
