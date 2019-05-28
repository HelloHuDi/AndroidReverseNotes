package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static final String lUR = (p.bsO() + "/fdv_v_");
    public static final String lUW = (h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    c coZ;
    private com.tencent.mm.audio.b.c.a cpM = new com.tencent.mm.audio.b.c.a() {
        short[] gbj;

        public final void u(byte[] bArr, int i) {
            int i2 = 0;
            AppMethodBeat.i(285);
            ab.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            if (this.gbj == null || this.gbj.length < i / 2) {
                this.gbj = new short[(i / 2)];
            }
            while (i2 < i / 2) {
                this.gbj[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                i2++;
            }
            a.a(a.this, this.gbj, i / 2);
            if (a.this.gbh != null) {
                a.this.gbh.f(this.gbj, i / 2);
                if (a.this.gaY != null) {
                    i2 = a.this.gaY.a(new com.tencent.mm.audio.b.g.a(bArr, i));
                } else {
                    i2 = -1;
                }
                if (-1 != i2 || a.this.lUS == null) {
                    AppMethodBeat.o(285);
                    return;
                }
                a.this.lUS.onError(3);
                a.this.bsT();
                ab.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                AppMethodBeat.o(285);
                return;
            }
            if (a.this.lUS != null) {
                a.this.lUS.onError(1);
                a.this.bsT();
            }
            ab.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.o(285);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(286);
            ab.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
            a.this.bsT();
            if (a.this.lUS != null) {
                a.this.lUS.onError(2);
            }
            AppMethodBeat.o(286);
        }
    };
    private int gaS = 0;
    int gaT = 0;
    com.tencent.mm.audio.d.a gaY;
    boolean gbH = true;
    com.tencent.mm.modelvoiceaddr.a.c gbh;
    private com.tencent.mm.modelvoiceaddr.a.c.a gbi = new com.tencent.mm.modelvoiceaddr.a.c.a() {
        public final void c(short[] sArr, int i) {
            AppMethodBeat.i(d.MIC_PTU_SHUILIAN);
            ab.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", sArr, Integer.valueOf(i));
            AppMethodBeat.o(d.MIC_PTU_SHUILIAN);
        }

        public final void amu() {
            AppMethodBeat.i(d.MIC_PTU_YOUJIALI);
            ab.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
            AppMethodBeat.o(d.MIC_PTU_YOUJIALI);
        }

        public final void amv() {
            AppMethodBeat.i(d.MIC_PTU_ZIRAN);
            ab.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (a.this.lUS != null) {
                a.this.lUS.bsU();
            }
            AppMethodBeat.o(d.MIC_PTU_ZIRAN);
        }

        public final void CV() {
            AppMethodBeat.i(290);
            ab.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (a.this.lUS != null) {
                a.this.lUS.onError(11);
            }
            AppMethodBeat.o(290);
        }
    };
    b lUS = null;
    boolean lUT = false;
    String lUU = "";
    ArrayList<com.tencent.mm.audio.b.c.a> lUV = new ArrayList(5);
    public com.tencent.mm.audio.b.c.a lUX = new com.tencent.mm.audio.b.c.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(283);
            if (a.this.lUV != null) {
                Iterator it = a.this.lUV.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.audio.b.c.a aVar = (com.tencent.mm.audio.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.u(bArr, i);
                    }
                }
            }
            AppMethodBeat.o(283);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(284);
            if (a.this.lUV != null) {
                Iterator it = a.this.lUV.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.audio.b.c.a aVar = (com.tencent.mm.audio.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.bN(i, i2);
                    }
                }
            }
            AppMethodBeat.o(284);
        }
    };

    class a implements Runnable {
        private Runnable lUZ;

        /* synthetic */ a(a aVar, Runnable runnable, byte b) {
            this(runnable);
        }

        private a(Runnable runnable) {
            this.lUZ = null;
            this.lUZ = runnable;
        }

        public final void run() {
            AppMethodBeat.i(291);
            synchronized (a.this) {
                if (a.this.lUT) {
                    ab.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                } else {
                    ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                    a.this.lUU = a.lUR + bo.yz() + ".spx";
                    try {
                        e.deleteFile(a.this.lUU);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.o(291);
                    }
                    a.this.coZ = new c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 3);
                    a.this.coZ.cpB = -19;
                    a.this.coZ.bq(false);
                    a.this.gaY = new com.tencent.mm.audio.d.d();
                    if (a.this.gaY.eo(a.this.lUU)) {
                        if (q.etn.erW > 0) {
                            a.this.coZ.v(q.etn.erW, true);
                        } else {
                            a.this.coZ.v(5, false);
                        }
                        a.this.coZ.gG(50);
                        a.this.coZ.br(false);
                        try {
                            a.this.gbh = new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.ehZ.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.ehZ.getFloat("s_n_ration", 2.5f), com.tencent.mm.modelvoiceaddr.a.c.ehZ.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.ehZ.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.ehZ.getInt("s_delay_time", 20), false, false);
                            a.this.gbh.gbP = a.this.gbi;
                        } catch (Throwable th2) {
                            ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + th2.getMessage());
                            if (a.this.lUS != null) {
                                a.this.lUS.onError(6);
                            }
                        }
                        a.this.coZ.cpM = a.this.lUX;
                        a.this.a(a.this.cpM);
                        if (!a.this.coZ.EL()) {
                            ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                            if (a.this.lUS != null) {
                                a.this.lUS.onError(7);
                            }
                        } else if (this.lUZ != null) {
                            this.lUZ.run();
                        }
                    } else {
                        ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                        a.this.gaY.Fe();
                        a.this.gaY = null;
                        if (a.this.lUS != null) {
                            a.this.lUS.onError(5);
                        }
                    }
                }
            }
            AppMethodBeat.o(291);
        }
    }

    public interface b {
        void bsU();

        void onError(int i);
    }

    public a() {
        AppMethodBeat.i(292);
        AppMethodBeat.o(292);
    }

    static {
        AppMethodBeat.i(295);
        AppMethodBeat.o(295);
    }

    public final void bsT() {
        AppMethodBeat.i(293);
        e.deleteFile(this.lUU);
        AppMethodBeat.o(293);
    }

    public final void a(com.tencent.mm.audio.b.c.a aVar) {
        AppMethodBeat.i(d.MIC_PTU_WU);
        this.lUV.add(aVar);
        AppMethodBeat.o(d.MIC_PTU_WU);
    }

    static /* synthetic */ void a(a aVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > aVar.gaS) {
                aVar.gaS = s;
            }
        }
    }
}
