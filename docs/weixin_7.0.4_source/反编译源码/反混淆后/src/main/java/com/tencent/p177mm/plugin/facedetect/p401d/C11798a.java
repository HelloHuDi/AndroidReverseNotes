package com.tencent.p177mm.plugin.facedetect.p401d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C25835a;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.modelvoiceaddr.p1208a.C18721c;
import com.tencent.p177mm.modelvoiceaddr.p1208a.C18721c.C18722a;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.facedetect.d.a */
public final class C11798a {
    private static final String lUR = (C43036p.bsO() + "/fdv_v_");
    public static final String lUW = (C1448h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    C1292c coZ;
    private C1293a cpM = new C118012();
    private int gaS = 0;
    int gaT = 0;
    C25835a gaY;
    boolean gbH = true;
    C18721c gbh;
    private C18722a gbi = new C117963();
    C11799b lUS = null;
    boolean lUT = false;
    String lUU = "";
    ArrayList<C1293a> lUV = new ArrayList(5);
    public C1293a lUX = new C118001();

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$3 */
    class C117963 implements C18722a {
        C117963() {
        }

        /* renamed from: c */
        public final void mo21122c(short[] sArr, int i) {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_SHUILIAN);
            C4990ab.m7411d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", sArr, Integer.valueOf(i));
            AppMethodBeat.m2505o(C31128d.MIC_PTU_SHUILIAN);
        }

        public final void amu() {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_YOUJIALI);
            C4990ab.m7410d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_YOUJIALI);
        }

        public final void amv() {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIRAN);
            C4990ab.m7410d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (C11798a.this.lUS != null) {
                C11798a.this.lUS.bsU();
            }
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIRAN);
        }

        /* renamed from: CV */
        public final void mo21119CV() {
            AppMethodBeat.m2504i(290);
            C4990ab.m7410d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (C11798a.this.lUS != null) {
                C11798a.this.lUS.onError(11);
            }
            AppMethodBeat.m2505o(290);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$a */
    class C11797a implements Runnable {
        private Runnable lUZ;

        /* synthetic */ C11797a(C11798a c11798a, Runnable runnable, byte b) {
            this(runnable);
        }

        private C11797a(Runnable runnable) {
            this.lUZ = null;
            this.lUZ = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(291);
            synchronized (C11798a.this) {
                if (C11798a.this.lUT) {
                    C4990ab.m7420w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                } else {
                    C4990ab.m7416i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                    C11798a.this.lUU = C11798a.lUR + C5046bo.m7588yz() + ".spx";
                    try {
                        C5730e.deleteFile(C11798a.this.lUU);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(291);
                    }
                    C11798a.this.coZ = new C1292c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                    C11798a.this.coZ.cpB = -19;
                    C11798a.this.coZ.mo4595bq(false);
                    C11798a.this.gaY = new C41768d();
                    if (C11798a.this.gaY.mo43824eo(C11798a.this.lUU)) {
                        if (C1427q.etn.erW > 0) {
                            C11798a.this.coZ.mo4599v(C1427q.etn.erW, true);
                        } else {
                            C11798a.this.coZ.mo4599v(5, false);
                        }
                        C11798a.this.coZ.mo4598gG(50);
                        C11798a.this.coZ.mo4596br(false);
                        try {
                            C11798a.this.gbh = new C18721c(5000, C18721c.ehZ.getInt("sil_time", 200), C18721c.ehZ.getFloat("s_n_ration", 2.5f), C18721c.ehZ.getInt("s_window", 50), C18721c.ehZ.getInt("s_length", 35), C18721c.ehZ.getInt("s_delay_time", 20), false, false);
                            C11798a.this.gbh.gbP = C11798a.this.gbi;
                        } catch (Throwable th2) {
                            C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + th2.getMessage());
                            if (C11798a.this.lUS != null) {
                                C11798a.this.lUS.onError(6);
                            }
                        }
                        C11798a.this.coZ.cpM = C11798a.this.lUX;
                        C11798a.this.mo23596a(C11798a.this.cpM);
                        if (!C11798a.this.coZ.mo4592EL()) {
                            C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                            if (C11798a.this.lUS != null) {
                                C11798a.this.lUS.onError(7);
                            }
                        } else if (this.lUZ != null) {
                            this.lUZ.run();
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                        C11798a.this.gaY.mo43820Fe();
                        C11798a.this.gaY = null;
                        if (C11798a.this.lUS != null) {
                            C11798a.this.lUS.onError(5);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(291);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$b */
    public interface C11799b {
        void bsU();

        void onError(int i);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$1 */
    class C118001 implements C1293a {
        C118001() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(283);
            if (C11798a.this.lUV != null) {
                Iterator it = C11798a.this.lUV.iterator();
                while (it.hasNext()) {
                    C1293a c1293a = (C1293a) it.next();
                    if (c1293a != null) {
                        c1293a.mo4601u(bArr, i);
                    }
                }
            }
            AppMethodBeat.m2505o(283);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(284);
            if (C11798a.this.lUV != null) {
                Iterator it = C11798a.this.lUV.iterator();
                while (it.hasNext()) {
                    C1293a c1293a = (C1293a) it.next();
                    if (c1293a != null) {
                        c1293a.mo4600bN(i, i2);
                    }
                }
            }
            AppMethodBeat.m2505o(284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$2 */
    class C118012 implements C1293a {
        short[] gbj;

        C118012() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(285);
            C4990ab.m7411d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            if (this.gbj == null || this.gbj.length < i / 2) {
                this.gbj = new short[(i / 2)];
            }
            while (i2 < i / 2) {
                this.gbj[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                i2++;
            }
            C11798a.m19635a(C11798a.this, this.gbj, i / 2);
            if (C11798a.this.gbh != null) {
                C11798a.this.gbh.mo33988f(this.gbj, i / 2);
                if (C11798a.this.gaY != null) {
                    i2 = C11798a.this.gaY.mo43822a(new C32305a(bArr, i));
                } else {
                    i2 = -1;
                }
                if (-1 != i2 || C11798a.this.lUS == null) {
                    AppMethodBeat.m2505o(285);
                    return;
                }
                C11798a.this.lUS.onError(3);
                C11798a.this.bsT();
                C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                AppMethodBeat.m2505o(285);
                return;
            }
            if (C11798a.this.lUS != null) {
                C11798a.this.lUS.onError(1);
                C11798a.this.bsT();
            }
            C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.m2505o(285);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(286);
            C4990ab.m7412e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
            C11798a.this.bsT();
            if (C11798a.this.lUS != null) {
                C11798a.this.lUS.onError(2);
            }
            AppMethodBeat.m2505o(286);
        }
    }

    public C11798a() {
        AppMethodBeat.m2504i(292);
        AppMethodBeat.m2505o(292);
    }

    static {
        AppMethodBeat.m2504i(295);
        AppMethodBeat.m2505o(295);
    }

    public final void bsT() {
        AppMethodBeat.m2504i(293);
        C5730e.deleteFile(this.lUU);
        AppMethodBeat.m2505o(293);
    }

    /* renamed from: a */
    public final void mo23596a(C1293a c1293a) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_WU);
        this.lUV.add(c1293a);
        AppMethodBeat.m2505o(C31128d.MIC_PTU_WU);
    }

    /* renamed from: a */
    static /* synthetic */ void m19635a(C11798a c11798a, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > c11798a.gaS) {
                c11798a.gaS = s;
            }
        }
    }
}
