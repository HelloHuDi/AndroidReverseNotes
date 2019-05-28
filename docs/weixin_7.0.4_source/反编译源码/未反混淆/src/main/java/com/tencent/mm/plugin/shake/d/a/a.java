package com.tencent.mm.plugin.shake.d.a;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qafpapi.QAFPNative;
import com.tencent.ugc.TXRecordCommon;

public final class a implements f {
    c coZ;
    private com.tencent.mm.audio.b.c.a cqd = new com.tencent.mm.audio.b.c.a() {
        public final void u(byte[] bArr, int i) {
            int QAFPProcessTV;
            AppMethodBeat.i(24589);
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            synchronized (a.this.kbe) {
                try {
                    if (a.this.qtr == 408) {
                        ab.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                        QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
                    } else {
                        QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(24589);
                }
            }
            long anU = bo.anU() - a.this.qtA;
            ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", Integer.valueOf(a.this.qtx), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(anU), Long.valueOf(aVar.Mr()));
            if (anU > ((long) ((a.this.qtB * AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) + WearableStatusCodes.TARGET_NODE_NOT_CONNECTED))) {
                byte[] bArr2 = new byte[10240];
                com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
                if (a.this.qtr == 408) {
                    ab.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(bArr2);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(bArr2);
                }
                ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", Integer.valueOf(a.this.qtx), Integer.valueOf(QAFPProcessTV), Long.valueOf(aVar2.Mr()));
                if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                    ab.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", Integer.valueOf(a.this.qtx), Integer.valueOf(QAFPProcessTV));
                    a.this.reset();
                    AppMethodBeat.o(24589);
                    return;
                }
                synchronized (a.this.qtn) {
                    try {
                        boolean z;
                        System.arraycopy(bArr2, 0, a.this.qtn, 0, QAFPProcessTV);
                        a.this.qto = QAFPProcessTV;
                        a aVar3 = a.this;
                        if (a.this.qtB >= 3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar3.qtw = z;
                        a.this.qtp = (int) (anU / 1000);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(24589);
                        }
                    }
                }
                a.this.agK();
                a aVar4 = a.this;
                aVar4.qtB++;
            }
            if (a.this.qtw) {
                ab.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", Integer.valueOf(a.this.qtx), Long.valueOf(anU));
                a.this.reset();
            }
            AppMethodBeat.o(24589);
        }

        public final void bN(int i, int i2) {
        }
    };
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
    e qtt = null;
    private a qtu = null;
    boolean qtv = false;
    boolean qtw = false;
    int qtx = 0;
    int qty;
    private boolean qtz = false;

    public interface a {
        void b(btd btd, long j, boolean z);
    }

    public a() {
        AppMethodBeat.i(24593);
        AppMethodBeat.o(24593);
    }

    static /* synthetic */ void a(a aVar, btd btd, long j, boolean z) {
        AppMethodBeat.i(24603);
        aVar.a(btd, j, z);
        AppMethodBeat.o(24603);
    }

    public final boolean ckt() {
        boolean z = false;
        AppMethodBeat.i(24594);
        synchronized (this.kbe) {
            try {
                if (this.qtz) {
                    ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
                } else {
                    int QAFPInit = QAFPNative.QAFPInit();
                    ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", Integer.valueOf(QAFPInit));
                    if (QAFPInit >= 0) {
                        this.qtz = true;
                    }
                    if (QAFPInit >= 0) {
                        z = true;
                    }
                    AppMethodBeat.o(24594);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(24594);
            }
        }
        return z;
    }

    public final boolean cku() {
        boolean z = false;
        AppMethodBeat.i(24595);
        synchronized (this.kbe) {
            try {
                if (this.qtz) {
                    ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", Integer.valueOf(QAFPNative.QAFPRelease()));
                    if (QAFPNative.QAFPRelease() >= 0) {
                        z = true;
                    }
                    AppMethodBeat.o(24595);
                } else {
                    ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(24595);
            }
        }
        return z;
    }

    public final boolean EB() {
        AppMethodBeat.i(24596);
        ab.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", Integer.valueOf(this.qtx));
        aw.Rg().b(367, (f) this);
        aw.Rg().b(408, (f) this);
        synchronized (this.qtn) {
            try {
                this.qto = 0;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(24596);
                }
            }
        }
        if (this.coZ != null) {
            this.coZ.EB();
            this.coZ = null;
        }
        AppMethodBeat.o(24596);
        return true;
    }

    public final boolean a(int i, a aVar) {
        AppMethodBeat.i(24597);
        EB();
        synchronized (this.kbe) {
            try {
                this.qty = QAFPNative.QAFPGetVersion();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(24597);
            }
        }
        ckt();
        this.qtr = i;
        this.qtu = aVar;
        this.qtw = false;
        this.qtv = false;
        this.qts = false;
        this.qtC = false;
        aw.Rg().a(367, (f) this);
        aw.Rg().a(408, (f) this);
        this.qtx = (int) bo.anU();
        ab.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", Integer.valueOf(this.qtx));
        this.coZ = new c(TXRecordCommon.AUDIO_SAMPLERATE_8000, 1, 4);
        this.coZ.cpB = -19;
        this.coZ.cpM = this.cqd;
        if (this.coZ.EL()) {
            synchronized (this.kbe) {
                try {
                    ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", Integer.valueOf(QAFPNative.QAFPReset()));
                    if (QAFPNative.QAFPReset() < 0) {
                        ab.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", Integer.valueOf(r3), Integer.valueOf(this.qtx));
                        reset();
                    } else {
                        this.qtq = bo.anU();
                        this.qtA = bo.anU();
                        this.qtB = 0;
                        AppMethodBeat.o(24597);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(24597);
                }
            }
        } else {
            ab.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
            reset();
            return false;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.i(24598);
        ab.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", Integer.valueOf(this.qtx));
        if (this.coZ != null) {
            this.coZ.EB();
            this.coZ = null;
        }
        ks(false);
        AppMethodBeat.o(24598);
    }

    private void ks(final boolean z) {
        AppMethodBeat.i(24599);
        ab.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", Boolean.FALSE);
        al.d(new Runnable() {
            final /* synthetic */ boolean qtE = false;

            public final void run() {
                AppMethodBeat.i(24590);
                if (this.qtE) {
                    a.a(a.this, null, -1, z);
                    AppMethodBeat.o(24590);
                } else if (!a.this.qts) {
                    ab.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
                    AppMethodBeat.o(24590);
                } else if (a.this.coZ != null) {
                    ab.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
                    AppMethodBeat.o(24590);
                } else if (a.this.qtt != null) {
                    a aVar = a.this;
                    btd ckw = a.this.qtt.ckw();
                    e eVar = a.this.qtt;
                    long anU = bo.anU();
                    if (eVar.qtJ > 0 && eVar.qtJ < anU) {
                        anU = eVar.qtJ;
                    }
                    a.a(aVar, ckw, anU, z);
                    AppMethodBeat.o(24590);
                } else {
                    a.a(a.this, null, -1, z);
                    AppMethodBeat.o(24590);
                }
            }
        });
        AppMethodBeat.o(24599);
    }

    private synchronized void a(btd btd, long j, boolean z) {
        AppMethodBeat.i(24600);
        if (this.qtC) {
            ab.w("MicroMsg.MusicFingerPrintRecorder", "hy: already call backed to UI");
            AppMethodBeat.o(24600);
        } else {
            this.qtu.b(btd, j, z);
            this.qtC = true;
            AppMethodBeat.o(24600);
        }
    }

    /* Access modifiers changed, original: final */
    public final void agK() {
        AppMethodBeat.i(24601);
        aw.RS().aa(new Runnable() {
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
            r1 = new com.tencent.mm.plugin.shake.d.a.f(r2, r3, r4, r6, r7, r8);
     */
            /* JADX WARNING: Missing block: B:15:0x0074, code skipped:
            com.tencent.mm.model.aw.Rg().a(r1, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(24591);
     */
            /* JADX WARNING: Missing block: B:21:0x0087, code skipped:
            if (r0 != 408) goto L_0x008f;
     */
            /* JADX WARNING: Missing block: B:22:0x0089, code skipped:
            r1 = new com.tencent.mm.plugin.shake.d.a.g(r2, r3, r4, r6, r7, r8);
     */
            /* JADX WARNING: Missing block: B:23:0x008f, code skipped:
            r1 = null;
     */
            /* JADX WARNING: Missing block: B:29:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(24591);
                if (a.this.qtv) {
                    ab.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", Integer.valueOf(a.this.qtx));
                    AppMethodBeat.o(24591);
                    return;
                }
                synchronized (a.this.qtn) {
                    try {
                        if (a.this.qto <= 0) {
                        } else {
                            byte[] bArr = new byte[a.this.qto];
                            System.arraycopy(a.this.qtn, 0, bArr, 0, a.this.qto);
                            a.this.qto = 0;
                            long j = a.this.qtq;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(24591);
                    }
                }
            }

            public final String toString() {
                AppMethodBeat.i(24592);
                String str = super.toString() + "|tryStartNetscene";
                AppMethodBeat.o(24592);
                return str;
            }
        });
        AppMethodBeat.o(24601);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(24602);
        if (mVar.getType() == 367 || mVar.getType() == 408) {
            ab.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.qtv = false;
            if (((e) mVar).ckv()) {
                ab.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", Integer.valueOf(this.qtx));
                EB();
                this.qtt = (e) mVar;
                this.qts = true;
                ks(false);
                AppMethodBeat.o(24602);
                return;
            } else if (this.qto == 0 && this.qtw) {
                ab.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", Integer.valueOf(this.qtx));
                this.qtt = null;
                this.qts = true;
                if (i == 0 && i2 == 0) {
                    ks(false);
                } else {
                    ks(true);
                }
                aw.Rg().b(367, (f) this);
                aw.Rg().b(408, (f) this);
                AppMethodBeat.o(24602);
                return;
            } else {
                ab.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", Integer.valueOf(this.qtx));
                agK();
                AppMethodBeat.o(24602);
                return;
            }
        }
        AppMethodBeat.o(24602);
    }
}
