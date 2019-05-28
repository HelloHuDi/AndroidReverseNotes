package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.d.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;

public final class f implements com.tencent.mm.ai.f {
    public static int cri = 100;
    private static final String gaQ = (ac.eSj + "tmp_voiceaddr.spx");
    private static final String gaR = (ac.eSj + "tmp_voiceaddr.amr");
    c coZ;
    private com.tencent.mm.audio.b.c.a cpM = new com.tencent.mm.audio.b.c.a() {
        public final void u(byte[] bArr, int i) {
            int i2;
            AppMethodBeat.i(116693);
            ab.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (f.this.gaZ != null) {
                f.this.gaZ.a(sArr, i / 2, aVar);
            }
            f.a(f.this, sArr, i / 2);
            if (f.this.gaY != null) {
                i2 = f.this.gaY.a(new com.tencent.mm.audio.b.g.a(bArr, i));
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                f.a(f.this);
                ab.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                AppMethodBeat.o(116693);
                return;
            }
            f fVar = f.this;
            fVar.gaT = i2 + fVar.gaT;
            if (f.this.gaT > 3300 && !f.this.gaU) {
                ab.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                f.this.handler.sendEmptyMessage(0);
                f.this.gaU = true;
            }
            if (aVar.AqE == 2 || aVar.AqE == 3) {
                ab.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.AqE);
                f.a(f.this);
            }
            AppMethodBeat.o(116693);
        }

        public final void bN(int i, int i2) {
        }
    };
    public int gaL = 1;
    public int gaS = 0;
    int gaT = 0;
    boolean gaU = false;
    private int gaV = 500000;
    public boolean gaW = false;
    b gaX = null;
    com.tencent.mm.audio.d.a gaY;
    com.tencent.qqpinyin.voicerecoapi.c gaZ = null;
    private a gba = null;
    ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(116694);
            if (message.what == 2) {
                if (f.this.gaX != null) {
                    f.this.gaX.ams();
                    AppMethodBeat.o(116694);
                    return;
                }
            } else if (message.what == 0) {
                if (f.this.gaL == 0) {
                    ab.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    g.Rg().a(349, f.this);
                } else {
                    g.Rg().a(206, f.this);
                }
                if (f.this.gaL != 0) {
                    f.this.gba = new d(f.d(f.this), f.this.gaL);
                } else if (f.this.gaW) {
                    f.this.gba = new e(f.d(f.this), 1);
                } else {
                    f.this.gba = new e(f.d(f.this), 0);
                }
                g.Rg().a(f.this.gba, 0);
                AppMethodBeat.o(116694);
                return;
            } else if (message.what == 3 && f.this.gaX != null) {
                f.this.gaX.a(new String[0], -1);
            }
            AppMethodBeat.o(116694);
        }
    };

    public class a implements Runnable {
        public final void run() {
            AppMethodBeat.i(116695);
            synchronized (f.this) {
                ab.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(f.d(f.this)).delete();
                } catch (Exception e) {
                    ab.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), e);
                } catch (Throwable th) {
                    AppMethodBeat.o(116695);
                }
                f.this.coZ = new c(f.this.gaW ? TXRecordCommon.AUDIO_SAMPLERATE_8000 : TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                f.this.coZ.cpB = -19;
                f.this.coZ.bq(false);
                if (!f.this.gaW) {
                    f.this.gaY = new d();
                    if (!f.this.gaY.eo(f.d(f.this))) {
                        ab.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        f.this.gaY.Fe();
                        f.this.gaY = null;
                    }
                }
                if (f.this.gaW || q.etn.erW <= 0) {
                    f.this.coZ.v(5, false);
                } else {
                    f.this.coZ.v(q.etn.erW, true);
                }
                f.this.coZ.br(false);
                f.this.gaZ = new com.tencent.qqpinyin.voicerecoapi.c(f.this.gaV);
                int dPU = f.this.gaZ.dPU();
                if (dPU != 0) {
                    ab.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(dPU)));
                    f.g(f.this);
                } else {
                    f.this.coZ.cpM = f.this.cpM;
                    if (!f.this.coZ.EL()) {
                        ab.e("MicroMsg.SceneVoiceAddr", "start record failed");
                        f.g(f.this);
                    }
                }
            }
            AppMethodBeat.o(116695);
        }
    }

    public interface b {
        void a(String[] strArr, long j);

        void amr();

        void ams();
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(116701);
        fVar.finish();
        AppMethodBeat.o(116701);
    }

    static /* synthetic */ void g(f fVar) {
        AppMethodBeat.i(116702);
        fVar.reset();
        AppMethodBeat.o(116702);
    }

    static {
        AppMethodBeat.i(116703);
        AppMethodBeat.o(116703);
    }

    public f(b bVar, int i) {
        int i2 = 500000;
        AppMethodBeat.i(116696);
        this.gaX = bVar;
        this.gaL = i;
        if (this.gaL != 1) {
            i2 = 1500000;
        }
        this.gaV = i2;
        AppMethodBeat.o(116696);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(116697);
        if (this.gaL == 0) {
            ab.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            g.Rg().b(349, (com.tencent.mm.ai.f) this);
        } else {
            g.Rg().b(206, (com.tencent.mm.ai.f) this);
        }
        String[] amk = ((a) mVar).amk();
        long aml = ((a) mVar).aml();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(amk == null ? -1 : amk.length);
        ab.i(str2, str3, objArr);
        if (this.gaX != null) {
            if (i2 == 0 && i == 0) {
                this.gaX.a(amk, aml);
            } else {
                this.gaX.amr();
                cancel();
                AppMethodBeat.o(116697);
                return;
            }
        }
        AppMethodBeat.o(116697);
    }

    private void finish() {
        AppMethodBeat.i(116698);
        ab.i("MicroMsg.SceneVoiceAddr", "finish");
        ab.c("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.gba != null) {
            this.gba.amj();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.gaU) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
        AppMethodBeat.o(116698);
    }

    public final void cancel() {
        AppMethodBeat.i(116699);
        this.gaX = null;
        finish();
        AppMethodBeat.o(116699);
    }

    private void reset() {
        AppMethodBeat.i(116700);
        ab.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            try {
                if (this.coZ != null) {
                    this.coZ.EB();
                    this.coZ = null;
                }
                if (this.gaY != null) {
                    this.gaY.Fe();
                    this.gaY = null;
                }
                if (this.gaZ != null) {
                    this.gaZ.stop();
                }
                this.gaZ = null;
                if (this.gba != null) {
                    this.gba.amj();
                    this.gba = null;
                }
                this.gaT = 0;
                this.gaU = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(116700);
            }
        }
    }

    static /* synthetic */ void a(f fVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > fVar.gaS) {
                fVar.gaS = s;
            }
        }
    }

    static /* synthetic */ String d(f fVar) {
        if (fVar.gaW) {
            return gaR;
        }
        return gaQ;
    }
}
