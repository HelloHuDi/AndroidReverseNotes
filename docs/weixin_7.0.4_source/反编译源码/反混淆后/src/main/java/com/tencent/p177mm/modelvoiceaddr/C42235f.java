package com.tencent.p177mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C25835a;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.qqpinyin.voicerecoapi.C16135c;
import com.tencent.qqpinyin.voicerecoapi.C16135c.C16136a;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;

/* renamed from: com.tencent.mm.modelvoiceaddr.f */
public final class C42235f implements C1202f {
    public static int cri = 100;
    private static final String gaQ = (C5128ac.eSj + "tmp_voiceaddr.spx");
    private static final String gaR = (C5128ac.eSj + "tmp_voiceaddr.amr");
    C1292c coZ;
    private C1293a cpM = new C367031();
    public int gaL = 1;
    public int gaS = 0;
    int gaT = 0;
    boolean gaU = false;
    private int gaV = 500000;
    public boolean gaW = false;
    C42234b gaX = null;
    C25835a gaY;
    C16135c gaZ = null;
    private C18723a gba = null;
    C7306ak handler = new C379672();

    /* renamed from: com.tencent.mm.modelvoiceaddr.f$a */
    public class C9751a implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(116695);
            synchronized (C42235f.this) {
                C4990ab.m7416i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(C42235f.m74539d(C42235f.this)).delete();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SceneVoiceAddr", "delete file failed, " + C42235f.m74539d(C42235f.this), e);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(116695);
                }
                C42235f.this.coZ = new C1292c(C42235f.this.gaW ? TXRecordCommon.AUDIO_SAMPLERATE_8000 : TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                C42235f.this.coZ.cpB = -19;
                C42235f.this.coZ.mo4595bq(false);
                if (!C42235f.this.gaW) {
                    C42235f.this.gaY = new C41768d();
                    if (!C42235f.this.gaY.mo43824eo(C42235f.m74539d(C42235f.this))) {
                        C4990ab.m7412e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        C42235f.this.gaY.mo43820Fe();
                        C42235f.this.gaY = null;
                    }
                }
                if (C42235f.this.gaW || C1427q.etn.erW <= 0) {
                    C42235f.this.coZ.mo4599v(5, false);
                } else {
                    C42235f.this.coZ.mo4599v(C1427q.etn.erW, true);
                }
                C42235f.this.coZ.mo4596br(false);
                C42235f.this.gaZ = new C16135c(C42235f.this.gaV);
                int dPU = C42235f.this.gaZ.dPU();
                if (dPU != 0) {
                    C4990ab.m7412e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(dPU)));
                    C42235f.m74542g(C42235f.this);
                } else {
                    C42235f.this.coZ.cpM = C42235f.this.cpM;
                    if (!C42235f.this.coZ.mo4592EL()) {
                        C4990ab.m7412e("MicroMsg.SceneVoiceAddr", "start record failed");
                        C42235f.m74542g(C42235f.this);
                    }
                }
            }
            AppMethodBeat.m2505o(116695);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.f$1 */
    class C367031 implements C1293a {
        C367031() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int i2;
            AppMethodBeat.m2504i(116693);
            C4990ab.m7411d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            C16136a c16136a = new C16136a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (C42235f.this.gaZ != null) {
                C42235f.this.gaZ.mo28643a(sArr, i / 2, c16136a);
            }
            C42235f.m74536a(C42235f.this, sArr, i / 2);
            if (C42235f.this.gaY != null) {
                i2 = C42235f.this.gaY.mo43822a(new C32305a(bArr, i));
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                C42235f.m74535a(C42235f.this);
                C4990ab.m7412e("MicroMsg.SceneVoiceAddr", "write to file failed");
                AppMethodBeat.m2505o(116693);
                return;
            }
            C42235f c42235f = C42235f.this;
            c42235f.gaT = i2 + c42235f.gaT;
            if (C42235f.this.gaT > 3300 && !C42235f.this.gaU) {
                C4990ab.m7410d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                C42235f.this.handler.sendEmptyMessage(0);
                C42235f.this.gaU = true;
            }
            if (c16136a.AqE == 2 || c16136a.AqE == 3) {
                C4990ab.m7416i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + c16136a.AqE);
                C42235f.m74535a(C42235f.this);
            }
            AppMethodBeat.m2505o(116693);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.f$2 */
    class C379672 extends C7306ak {
        C379672() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(116694);
            if (message.what == 2) {
                if (C42235f.this.gaX != null) {
                    C42235f.this.gaX.ams();
                    AppMethodBeat.m2505o(116694);
                    return;
                }
            } else if (message.what == 0) {
                if (C42235f.this.gaL == 0) {
                    C4990ab.m7410d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    C1720g.m3540Rg().mo14539a(349, C42235f.this);
                } else {
                    C1720g.m3540Rg().mo14539a(206, C42235f.this);
                }
                if (C42235f.this.gaL != 0) {
                    C42235f.this.gba = new C24673d(C42235f.m74539d(C42235f.this), C42235f.this.gaL);
                } else if (C42235f.this.gaW) {
                    C42235f.this.gba = new C42233e(C42235f.m74539d(C42235f.this), 1);
                } else {
                    C42235f.this.gba = new C42233e(C42235f.m74539d(C42235f.this), 0);
                }
                C1720g.m3540Rg().mo14541a(C42235f.this.gba, 0);
                AppMethodBeat.m2505o(116694);
                return;
            } else if (message.what == 3 && C42235f.this.gaX != null) {
                C42235f.this.gaX.mo44291a(new String[0], -1);
            }
            AppMethodBeat.m2505o(116694);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.f$b */
    public interface C42234b {
        /* renamed from: a */
        void mo44291a(String[] strArr, long j);

        void amr();

        void ams();
    }

    /* renamed from: a */
    static /* synthetic */ void m74535a(C42235f c42235f) {
        AppMethodBeat.m2504i(116701);
        c42235f.finish();
        AppMethodBeat.m2505o(116701);
    }

    /* renamed from: g */
    static /* synthetic */ void m74542g(C42235f c42235f) {
        AppMethodBeat.m2504i(116702);
        c42235f.reset();
        AppMethodBeat.m2505o(116702);
    }

    static {
        AppMethodBeat.m2504i(116703);
        AppMethodBeat.m2505o(116703);
    }

    public C42235f(C42234b c42234b, int i) {
        int i2 = 500000;
        AppMethodBeat.m2504i(116696);
        this.gaX = c42234b;
        this.gaL = i;
        if (this.gaL != 1) {
            i2 = 1500000;
        }
        this.gaV = i2;
        AppMethodBeat.m2505o(116696);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(116697);
        if (this.gaL == 0) {
            C4990ab.m7410d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            C1720g.m3540Rg().mo14546b(349, (C1202f) this);
        } else {
            C1720g.m3540Rg().mo14546b(206, (C1202f) this);
        }
        String[] amk = ((C18723a) c1207m).amk();
        long aml = ((C18723a) c1207m).aml();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(amk == null ? -1 : amk.length);
        C4990ab.m7417i(str2, str3, objArr);
        if (this.gaX != null) {
            if (i2 == 0 && i == 0) {
                this.gaX.mo44291a(amk, aml);
            } else {
                this.gaX.amr();
                cancel();
                AppMethodBeat.m2505o(116697);
                return;
            }
        }
        AppMethodBeat.m2505o(116697);
    }

    private void finish() {
        AppMethodBeat.m2504i(116698);
        C4990ab.m7416i("MicroMsg.SceneVoiceAddr", "finish");
        C4990ab.m7409c("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.gba != null) {
            this.gba.amj();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.gaU) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
        AppMethodBeat.m2505o(116698);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(116699);
        this.gaX = null;
        finish();
        AppMethodBeat.m2505o(116699);
    }

    private void reset() {
        AppMethodBeat.m2504i(116700);
        C4990ab.m7416i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            try {
                if (this.coZ != null) {
                    this.coZ.mo4590EB();
                    this.coZ = null;
                }
                if (this.gaY != null) {
                    this.gaY.mo43820Fe();
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
                AppMethodBeat.m2505o(116700);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m74536a(C42235f c42235f, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > c42235f.gaS) {
                c42235f.gaS = s;
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ String m74539d(C42235f c42235f) {
        if (c42235f.gaW) {
            return gaR;
        }
        return gaQ;
    }
}
