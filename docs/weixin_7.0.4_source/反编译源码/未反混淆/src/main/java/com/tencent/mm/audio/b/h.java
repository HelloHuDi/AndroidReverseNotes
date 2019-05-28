package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class h implements j, com.tencent.mm.compatible.b.g.a {
    private static boolean cph = false;
    private boolean cqA = false;
    private boolean cqB = false;
    private long cqC;
    public int cqD = 0;
    private boolean cqE = false;
    private boolean cqF = false;
    private int cqG = 0;
    private com.tencent.mm.compatible.b.c.a cqH = com.tencent.mm.compatible.b.c.a.UNKNOWN;
    protected b cqI;
    protected com.tencent.mm.ai.j.a cqJ = null;
    private boolean cqK = false;
    private ap cqL = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(116495);
            q.a(h.this.mFileName, h.this);
            m.amc().run();
            ab.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.this.mFileName);
            AppMethodBeat.o(116495);
            return false;
        }
    }, true);
    private Runnable cqM;
    private a cqw = null;
    private com.tencent.mm.compatible.util.b cqx;
    private a cqy = null;
    private String cqz;
    private String mFileName = "";
    private long mRecordStartTime = 0;

    final class a implements Runnable {
        ak handler;

        public a() {
            AppMethodBeat.i(116500);
            this.handler = new ak(h.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(116499);
                    if (h.this.cqG <= 0) {
                        AppMethodBeat.o(116499);
                        return;
                    }
                    ab.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (h.this.cqI == null));
                    h.this.cqG = 2;
                    if (h.this.cqI != null) {
                        h.this.cqI.acE();
                    }
                    AppMethodBeat.o(116499);
                }
            };
            AppMethodBeat.o(116500);
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(116501);
            al.af(h.this.cqM);
            ab.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", Long.valueOf(Thread.currentThread().getId()));
            synchronized (h.this) {
                try {
                    ab.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", Long.valueOf(Thread.currentThread().getId()), h.this);
                    if (h.this.cqw == null) {
                        ab.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                    } else {
                        String a = h.this.mFileName;
                        if (h.this.cqF) {
                            z = false;
                        }
                        ab.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", q.U(a, z), Boolean.valueOf(h.this.cqF));
                        if (h.this.cqw.el(q.U(a, z))) {
                            h.this.cqx.requestFocus();
                        } else {
                            q.uS(h.this.mFileName);
                            h.this.mFileName = null;
                            h.this.cqw = null;
                            ab.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.this.mFileName + "]");
                        }
                        h.this.mRecordStartTime = bo.yz();
                        ab.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.this.mFileName + "] time:" + bo.az(h.this.cqC));
                        this.handler.sendEmptyMessageDelayed(0, 1);
                        AppMethodBeat.o(116501);
                    }
                } finally {
                    AppMethodBeat.o(116501);
                }
            }
        }
    }

    static /* synthetic */ void l(h hVar) {
        AppMethodBeat.i(116515);
        hVar.EW();
        AppMethodBeat.o(116515);
    }

    public h(Context context, boolean z) {
        AppMethodBeat.i(116502);
        this.cqx = new com.tencent.mm.compatible.util.b(context);
        this.cqF = z;
        ab.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
        AppMethodBeat.o(116502);
    }

    public final void reset() {
        AppMethodBeat.i(116503);
        if (this.cqw != null) {
            this.cqw.EB();
            this.cqx.Mm();
            ab.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.cqC = 0;
        this.cqy = null;
        this.cqH = com.tencent.mm.compatible.b.c.a.UNKNOWN;
        this.cqG = 0;
        this.mRecordStartTime = 0;
        AppMethodBeat.o(116503);
    }

    public final int ET() {
        return this.cqD;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean isRecording() {
        AppMethodBeat.i(116504);
        if (this.cqw == null) {
            AppMethodBeat.o(116504);
            return false;
        } else if (this.cqw.getStatus() == 1) {
            AppMethodBeat.o(116504);
            return true;
        } else {
            AppMethodBeat.o(116504);
            return false;
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.i(116505);
        if (this.cqw == null) {
            AppMethodBeat.o(116505);
            return 0;
        }
        int maxAmplitude = this.cqw.getMaxAmplitude();
        AppMethodBeat.o(116505);
        return maxAmplitude;
    }

    public final boolean em(String str) {
        AppMethodBeat.i(116506);
        ab.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(str)));
        reset();
        this.cqz = str;
        this.cqC = bo.yz();
        if (str == null) {
            ab.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            AppMethodBeat.o(116506);
            return false;
        }
        this.cqA = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((r.YD() & 16384) == 0) {
                this.cqB = true;
            } else {
                this.cqB = false;
            }
        }
        if (!this.cqF) {
            if (this.cqA) {
                this.mFileName = u.uY(r.Yz());
            } else if (this.cqB) {
                this.mFileName = u.uY("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                ab.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                AppMethodBeat.o(116506);
                return false;
            }
            g.KK().a((com.tencent.mm.compatible.b.g.a) this);
            this.cqE = false;
            this.cqK = false;
            if (!g.KS() || g.KK().eoY.isBluetoothScoOn()) {
                EW();
            } else {
                this.cqK = true;
                g.KK().KM();
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(116496);
                        if (h.this.cqE) {
                            ab.e("MicroMsg.SceneVoice.Recorder", "mHasBeginRec is true");
                            AppMethodBeat.o(116496);
                            return;
                        }
                        ab.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
                        h.l(h.this);
                        AppMethodBeat.o(116496);
                    }
                }, 1000);
            }
            AppMethodBeat.o(116506);
            return true;
        }
        this.mFileName = q.uP(str);
        if (this.mFileName != null) {
        }
        ab.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        AppMethodBeat.o(116506);
        return false;
    }

    public final boolean cancel() {
        AppMethodBeat.i(116507);
        ab.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            try {
                ab.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.cqw != null) {
                    this.cqw.EB();
                    this.cqx.Mm();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(116507);
                }
            }
        }
        g.KK().b((com.tencent.mm.compatible.b.g.a) this);
        if (this.cqK) {
            g.KK().KN();
            this.cqK = false;
        }
        q.uQ(this.mFileName);
        m.amc().run();
        if (!(this.cqw == null || bo.isNullOrNil(this.mFileName) || this.cqF)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.euD = this.mFileName;
            aVar.euE = EV();
            aVar.euF = 1;
            aVar.cvG = this.cqw.EC();
            com.tencent.mm.plugin.report.service.h.pYm.X(10513, aVar.Mk());
        }
        this.mFileName = "";
        AppMethodBeat.o(116507);
        return true;
    }

    public boolean EH() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(116508);
        if (this.cqL != null) {
            this.cqL.stopTimer();
            this.cqL.removeCallbacksAndMessages(null);
        }
        g.KK().b((com.tencent.mm.compatible.b.g.a) this);
        if (this.cqK) {
            g.KK().KN();
            this.cqK = false;
        }
        this.cqD = (int) EV();
        ab.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.cqD));
        if (!(this.cqw == null || bo.isNullOrNil(this.mFileName) || this.cqF)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.euD = this.mFileName;
            aVar.euE = (long) this.cqD;
            aVar.euF = 2;
            aVar.cvG = this.cqw.EC();
            com.tencent.mm.plugin.report.service.h.pYm.X(10513, aVar.Mk());
        }
        synchronized (this) {
            try {
                ab.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", this.mFileName, this.cqw, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.cqw != null) {
                    this.cqw.EB();
                    this.cqx.Mm();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(116508);
                }
            }
        }
        if (this.cqG != 2) {
            q.uS(this.mFileName);
            this.mFileName = null;
            ab.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bo.az(this.cqC));
        } else {
            if (((long) this.cqD) < 800 || (this.cqA && ((long) this.cqD) < 1000)) {
                ab.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.cqD);
                q.uS(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                q.ah(this.mFileName, this.cqD);
                m.amc().run();
                ab.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.cqG = -1;
        AppMethodBeat.o(116508);
        return z2;
    }

    private void EU() {
        AppMethodBeat.i(116509);
        AnonymousClass3 anonymousClass3 = new com.tencent.mm.ai.j.a() {
            public final void onError() {
                AppMethodBeat.i(116497);
                h.this.cqx.Mm();
                ab.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.this.mFileName);
                q.uS(h.this.mFileName);
                if (h.this.cqJ != null) {
                    h.this.cqJ.onError();
                }
                AppMethodBeat.o(116497);
            }
        };
        if (this.cqw != null) {
            this.cqw.a(anonymousClass3);
        }
        AppMethodBeat.o(116509);
    }

    public final long EV() {
        AppMethodBeat.i(116510);
        if (this.mRecordStartTime == 0) {
            AppMethodBeat.o(116510);
            return 0;
        }
        long az = bo.az(this.mRecordStartTime);
        AppMethodBeat.o(116510);
        return az;
    }

    public final void gE(int i) {
        AppMethodBeat.i(116511);
        ab.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (i == 1) {
            EW();
        }
        AppMethodBeat.o(116511);
    }

    private void EW() {
        AppMethodBeat.i(116512);
        if (this.cqE) {
            ab.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] return mHasBeginRec is true!");
            AppMethodBeat.o(116512);
            return;
        }
        this.cqE = true;
        if (this.cqF) {
            this.cqH = com.tencent.mm.compatible.b.c.a.SPEEX;
            this.cqw = new k();
        } else {
            EZ();
            this.cqw = new t(this.cqH);
        }
        EU();
        EX();
        this.cqy = new a();
        ab.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] mRecordStartRunnable has post! threadPool:%s", d.xDG.dqb());
        d.post(this.cqy, "SceneVoiceRecorder_record");
        this.cqG = 1;
        this.cqL.ae(3000, 3000);
        ab.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bo.az(this.cqC));
        AppMethodBeat.o(116512);
    }

    private void EX() {
        AppMethodBeat.i(116513);
        AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(116498);
                ab.e("MicroMsg.SceneVoice.Recorder", "start record timeout");
                com.tencent.mm.plugin.report.service.h.pYm.a(357, 51, 1, true);
                if (!h.cph) {
                    if (com.tencent.mm.protocal.d.vxr) {
                        com.tencent.mm.plugin.report.service.h.pYm.g("Record", "start record timeout", null);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(357, 52, 1, true);
                }
                h.cph = true;
                AppMethodBeat.o(116498);
            }
        };
        this.cqM = anonymousClass4;
        al.n(anonymousClass4, 600);
        AppMethodBeat.o(116513);
    }

    public final void a(com.tencent.mm.ai.j.a aVar) {
        this.cqJ = aVar;
    }

    public final void a(b bVar) {
        this.cqI = bVar;
    }

    public final int EY() {
        if (this.cqF) {
            return 1;
        }
        if (this.cqH == com.tencent.mm.compatible.b.c.a.PCM || this.cqH == com.tencent.mm.compatible.b.c.a.AMR) {
            return 0;
        }
        if (this.cqH == com.tencent.mm.compatible.b.c.a.SILK) {
            return 2;
        }
        return -1;
    }

    private void EZ() {
        AppMethodBeat.i(116514);
        this.cqH = c.KI();
        String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("VoiceFormat");
        String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("VoiceFormatToQQ");
        if (this.cqH == com.tencent.mm.compatible.b.c.a.PCM) {
            if (4 == bo.getInt(value, 4) && g.b.ES()) {
                this.cqH = com.tencent.mm.compatible.b.c.a.SILK;
            }
            if (this.cqz != null && this.cqz.endsWith("@qqim")) {
                this.cqH = com.tencent.mm.compatible.b.c.a.AMR;
            }
        }
        if (this.cqH == com.tencent.mm.compatible.b.c.a.PCM) {
            ab.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
            this.cqH = com.tencent.mm.compatible.b.c.a.AMR;
        }
        ab.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.cqH, Boolean.valueOf(g.b.ES()));
        AppMethodBeat.o(116514);
    }
}
