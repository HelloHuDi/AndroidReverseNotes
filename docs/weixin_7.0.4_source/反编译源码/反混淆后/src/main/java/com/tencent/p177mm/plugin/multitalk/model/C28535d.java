package com.tencent.p177mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.loader.C26049d;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.voip.model.C29495b;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p659pb.talkroom.sdk.C24244c;
import com.tencent.p659pb.talkroom.sdk.C30918b;
import com.tencent.p659pb.talkroom.sdk.C44444d;
import com.tencent.p659pb.talkroom.sdk.C46731e;
import com.tencent.wecall.talkroom.model.C36576e;
import com.tencent.wxmm.v2helper;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.multitalk.model.d */
public final class C28535d implements C1202f {
    C1293a cqd = new C285362();
    C1292c kzb;
    public C44444d oFP;
    C24798c oFQ;
    C24244c oFR;
    C30918b oFS;
    C29495b oFT = new C285373();

    /* renamed from: com.tencent.mm.plugin.multitalk.model.d$2 */
    class C285362 implements C1293a {
        C285362() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(53905);
            if (i <= 0) {
                C4990ab.m7412e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
                AppMethodBeat.m2505o(53905);
                return;
            }
            if (C28535d.this.oFR != null) {
                C28535d.this.oFR.mo40016Y(bArr, i);
            }
            AppMethodBeat.m2505o(53905);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(53906);
            C4990ab.m7417i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(53906);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.d$3 */
    class C285373 implements C29495b {
        C285373() {
        }

        /* renamed from: N */
        public final int mo45518N(byte[] bArr, int i) {
            int X;
            AppMethodBeat.m2504i(53907);
            if (C28535d.this.oFS != null) {
                X = C28535d.this.oFS.mo41178X(bArr, i);
            } else {
                X = 0;
            }
            if (X < 0) {
                AppMethodBeat.m2505o(53907);
                return -1;
            }
            AppMethodBeat.m2505o(53907);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.d$1 */
    class C285381 implements C46731e {
        C285381() {
        }

        /* renamed from: d */
        public final boolean mo46545d(int i, int i2, byte[] bArr) {
            AppMethodBeat.m2504i(53892);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
            C1720g.m3540Rg().mo14541a(new C6984o(i, i2, bArr), 0);
            AppMethodBeat.m2505o(53892);
            return false;
        }

        public final boolean bRj() {
            AppMethodBeat.m2504i(53893);
            int Lw = C45290m.m83509Lw();
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(Lw)));
            if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                C26049d.m41592B(C4996ah.getContext(), "libvoipCodec_v7a.so");
            } else if ((Lw & 512) != 0) {
                C26049d.m41592B(C4996ah.getContext(), "libvoipCodec.so");
                Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
            } else {
                C26049d.m41592B(C4996ah.getContext(), "libvoipCodec_v5.so");
                Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
            }
            AppMethodBeat.m2505o(53893);
            return true;
        }

        /* renamed from: Lw */
        public final int mo46534Lw() {
            AppMethodBeat.m2504i(53894);
            int Lw = C45290m.m83509Lw();
            AppMethodBeat.m2505o(53894);
            return Lw;
        }

        public final int bRk() {
            AppMethodBeat.m2504i(53895);
            String dur = C1720g.m3536RP().mo5240Rz().dur();
            C1427q.m3050ku(dur);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(dur)));
            C28535d c28535d = C28535d.this;
            byte[] bArr = new byte[]{(byte) 0};
            byte[] bArr2 = new byte[2];
            if (C1427q.etd.eqq >= 0) {
                bArr2[0] = (byte) C1427q.etd.eqq;
                c28535d.oFP.setAppCmd(406, bArr2, 1);
            } else if (C1427q.etd.eqq == -2) {
                c28535d.oFP.setAppCmd(407, bArr, 1);
            }
            if (C1427q.etd.eqt >= 0) {
                byte[] bArr3 = new byte[5];
                if (C1427q.etd.equ >= 0 && C1427q.etd.eqv >= 0) {
                    bArr3[0] = (byte) C1427q.etd.equ;
                    bArr3[1] = (byte) C1427q.etd.eqv;
                    if (C1427q.etd.eqw >= 0) {
                        bArr3[2] = (byte) C1427q.etd.eqw;
                        bArr3[3] = (byte) C1427q.etd.eqt;
                        bArr3[4] = (byte) C1427q.etd.eqx;
                        c28535d.oFP.setAppCmd(404, bArr3, 5);
                    } else {
                        c28535d.oFP.setAppCmd(404, bArr3, 2);
                    }
                }
            } else if (C1427q.etd.eqt == -2) {
                c28535d.oFP.setAppCmd(405, bArr, 1);
            }
            if (C1427q.etd.eqr >= 0) {
                bArr2[0] = (byte) C1427q.etd.eqr;
                c28535d.oFP.setAppCmd(408, bArr2, 1);
            } else if (C1427q.etd.eqr == -2) {
                c28535d.oFP.setAppCmd(409, bArr, 1);
            }
            if (C1427q.etd.eqC[0] > (short) 0 || C1427q.etd.eqC[1] > (short) 0) {
                bArr2[0] = (byte) 0;
                bArr2[1] = (byte) 0;
                if (C1427q.etd.eqC[0] > (short) 0 && C1427q.etd.eqC[0] < (short) 10000) {
                    bArr2[0] = (byte) C1427q.etd.eqC[0];
                }
                if (C1427q.etd.eqC[1] > (short) 0 && C1427q.etd.eqC[1] < (short) 10000) {
                    bArr2[1] = (byte) C1427q.etd.eqC[1];
                }
                c28535d.oFP.setAppCmd(v2helper.EMethodSetNgStrength, bArr2, 2);
            }
            if (C1427q.etd.epT >= 0 || C1427q.etd.epV >= 0) {
                bArr2[0] = (byte) -1;
                bArr2[1] = (byte) -1;
                if (C1427q.etd.epT >= 0) {
                    bArr2[0] = (byte) C1427q.etd.epT;
                }
                if (C1427q.etd.epV >= 0) {
                    bArr2[1] = (byte) C1427q.etd.epV;
                }
                c28535d.oFP.setAppCmd(414, bArr2, 2);
            }
            if (C1427q.etd.epU >= 0 || C1427q.etd.epW >= 0) {
                bArr2[0] = (byte) -1;
                bArr2[1] = (byte) -1;
                if (C1427q.etd.epU >= 0) {
                    bArr2[0] = (byte) C1427q.etd.epU;
                }
                if (C1427q.etd.epW >= 0) {
                    bArr2[1] = (byte) C1427q.etd.epW;
                }
                c28535d.oFP.setAppCmd(415, bArr2, 2);
            }
            if (C1427q.etd.epX >= 0 || C1427q.etd.epY >= 0) {
                bArr2[0] = (byte) -1;
                bArr2[1] = (byte) -1;
                if (C1427q.etd.epX >= 0) {
                    bArr2[0] = (byte) C1427q.etd.epX;
                }
                if (C1427q.etd.epY >= 0) {
                    bArr2[1] = (byte) C1427q.etd.epY;
                }
                c28535d.oFP.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr2, 2);
            }
            if (C1427q.etd.epZ >= 0) {
                bArr2[0] = (byte) C1427q.etd.epZ;
                c28535d.oFP.setAppCmd(416, bArr2, 1);
            }
            if (C1427q.etd.eqa >= 0 && C1427q.etd.eqa != 5) {
                bArr2[0] = (byte) C1427q.etd.eqa;
                c28535d.oFP.setAppCmd(417, bArr2, 1);
            }
            if (C1427q.etd.eqb >= 0 && C1427q.etd.eqb != 5) {
                bArr2[0] = (byte) C1427q.etd.eqb;
                c28535d.oFP.setAppCmd(418, bArr2, 1);
            }
            if (C1427q.etd.eqc >= 0) {
                bArr2[0] = (byte) C1427q.etd.eqc;
                c28535d.oFP.setAppCmd(419, bArr2, 1);
            }
            if (1 == C1427q.etd.eqA) {
                byte[] bArr4 = new byte[30];
                for (int i = 0; i < 15; i++) {
                    bArr4[i * 2] = (byte) (C1427q.etd.eqB[i] & 255);
                    bArr4[(i * 2) + 1] = (byte) ((C1427q.etd.eqB[i] >> 8) & 255);
                }
                c28535d.oFP.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr4, 30);
            }
            if (C1427q.etd.eqA == 0) {
                c28535d.oFP.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff, bArr, 1);
            }
            if (C1427q.etd.eqE > 0) {
                bArr2[0] = (byte) C1427q.etd.eqE;
                c28535d.oFP.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr2, 1);
            }
            if (C1427q.etd.eqd > 0) {
                bArr2[0] = (byte) C1427q.etd.eqd;
                c28535d.oFP.setAppCmd(431, bArr2, 4);
            }
            if (C1427q.etd.eqM >= 0) {
                c28535d.oFP.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) C1427q.etd.eqM, (byte) C1427q.etd.eqN, (byte) C1427q.etd.eqO, (byte) C1427q.etd.eqP}, 4);
            }
            AppMethodBeat.m2505o(53895);
            return 0;
        }

        /* renamed from: jk */
        public final boolean mo46546jk(boolean z) {
            AppMethodBeat.m2504i(53896);
            C4990ab.m7417i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", Boolean.valueOf(z));
            C28535d.this.oFQ.mo41657io(z);
            AppMethodBeat.m2505o(53896);
            return true;
        }

        /* renamed from: a */
        public final int mo46535a(int i, int i2, C30918b c30918b) {
            AppMethodBeat.m2504i(53897);
            C28535d.this.oFS = c30918b;
            int a = C28535d.this.oFQ.mo41656a(C28535d.this.oFT, i, i2);
            C4990ab.m7417i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", Boolean.valueOf(C1407g.m2946KK().mo4821KU()), Boolean.valueOf(C34572p.bSf().oGb));
            if (C1407g.m2946KK().mo4821KU() != C34572p.bSf().oGb && C34572p.bSf().nwe.mo38019DB()) {
                C28535d.this.oFQ.mo41657io(C34572p.bSf().oGb);
            }
            AppMethodBeat.m2505o(53897);
            return a;
        }

        /* renamed from: a */
        public final int mo46536a(int i, int i2, C24244c c24244c) {
            AppMethodBeat.m2504i(53898);
            C28535d.this.oFR = c24244c;
            C28535d.this.kzb = new C1292c(i, 1, 7);
            C28535d.this.kzb.mo4598gG(i2);
            C28535d.this.kzb.mo4596br(true);
            C28535d.this.kzb.mo4591EJ();
            C28535d.this.kzb.cpB = -19;
            C28535d.this.kzb.mo4599v(1, false);
            C28535d.this.kzb.mo4595bq(true);
            C28535d.this.kzb.cpM = C28535d.this.cqd;
            if (C28535d.this.kzb.mo4592EL()) {
                AppMethodBeat.m2505o(53898);
                return 1;
            }
            AppMethodBeat.m2505o(53898);
            return -1;
        }

        public final boolean bRl() {
            AppMethodBeat.m2504i(53899);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
            C1406a c1406a = C28535d.this.oFQ;
            synchronized (c1406a.kzr) {
                try {
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(c1406a.cFy), Integer.valueOf(c1406a.hashCode()));
                    if (c1406a.cFy) {
                        C29496c c29496c = c1406a.kzq;
                        if (c29496c != null) {
                            c1406a.kzw.evE = SystemClock.elapsedRealtime();
                            c29496c.cIr();
                            C4990ab.m7416i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + c1406a.kzw.mo4908Mr());
                            c29496c.cIo();
                            c1406a.cFy = false;
                            c1406a.kzq = null;
                            C1407g.m2946KK().mo4825La();
                            C1407g.m2946KK().setMode(0);
                        }
                        c1406a.kzs.mo26277fa(C4996ah.getContext());
                        C1407g.m2946KK().mo4829b(c1406a);
                        c1406a.gar.mo73178Mm();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(53899);
                }
            }
            return true;
        }

        public final boolean bRm() {
            AppMethodBeat.m2504i(53900);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
            try {
                if (C28535d.this.kzb != null) {
                    C28535d.this.kzb.cpM = null;
                    C28535d.this.kzb.mo4590EB();
                }
                C28535d.this.kzb = null;
                AppMethodBeat.m2505o(53900);
                return true;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(e)));
                AppMethodBeat.m2505o(53900);
                return false;
            }
        }

        public final int bRn() {
            int i = 0;
            AppMethodBeat.m2504i(53901);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
            if (C28535d.this.oFQ != null) {
                C24798c c24798c = C28535d.this.oFQ;
                if (c24798c.kzq != null) {
                    i = c24798c.kzq.cIt();
                }
            }
            i = (int) ((((float) C1407g.m2946KK().getStreamVolume(i)) / ((float) C1407g.m2946KK().getStreamMaxVolume(i))) * 100.0f);
            AppMethodBeat.m2505o(53901);
            return i;
        }

        public final int bRo() {
            AppMethodBeat.m2504i(53902);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
            if (C28535d.this.kzb != null) {
                int EO = C28535d.this.kzb.mo4594EO();
                AppMethodBeat.m2505o(53902);
                return EO;
            }
            AppMethodBeat.m2505o(53902);
            return -2;
        }

        public final int bRp() {
            AppMethodBeat.m2504i(53903);
            C4990ab.m7410d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
            if (C28535d.this.kzb != null) {
                int i = C28535d.this.kzb.cpq;
                AppMethodBeat.m2505o(53903);
                return i;
            }
            AppMethodBeat.m2505o(53903);
            return 0;
        }

        public final int bRq() {
            AppMethodBeat.m2504i(53904);
            C4990ab.m7410d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
            if (C28535d.this.oFQ != null) {
                C24798c c24798c = C28535d.this.oFQ;
                if (c24798c.kzq != null) {
                    int cIs = c24798c.kzq.cIs();
                    AppMethodBeat.m2505o(53904);
                    return cIs;
                }
                AppMethodBeat.m2505o(53904);
                return 0;
            }
            AppMethodBeat.m2505o(53904);
            return 0;
        }

        /* renamed from: y */
        public final boolean mo46547y(int i, String str, String str2) {
            AppMethodBeat.m2504i(53891);
            switch (i) {
                case 0:
                    C4990ab.m7418v(str, str2);
                    break;
                case 1:
                    C4990ab.m7410d(str, str2);
                    break;
                case 2:
                    C4990ab.m7416i(str, str2);
                    break;
                case 3:
                    C4990ab.m7420w(str, str2);
                    break;
                case 4:
                    C4990ab.m7412e(str, str2);
                    break;
                case 5:
                    C4990ab.m7414f(str, str2);
                    break;
                default:
                    C4990ab.m7418v(str, str2);
                    break;
            }
            AppMethodBeat.m2505o(53891);
            return false;
        }
    }

    public C28535d() {
        AppMethodBeat.m2504i(53908);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = C4996ah.getContext();
        C36576e dTl = C36576e.dTl();
        C36576e.m60614jt(context);
        this.oFP = dTl;
        this.oFP.dPP();
        this.oFQ = new C24798c();
        int h = C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(1));
        this.oFP.mo58361a(C34572p.bSf(), new C285381());
        this.oFP.mo58364bR(h, C1853r.m3846Yz());
        C1720g.m3540Rg().mo14539a(1918, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1919, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1927, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1928, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1929, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1931, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1932, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1933, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1935, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1937, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1938, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1939, (C1202f) this);
        AppMethodBeat.m2505o(53908);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53909);
        C6984o c6984o = (C6984o) c1207m;
        C4990ab.m7416i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + c6984o.lqy);
        this.oFP.mo58368e(i2, c6984o.lqx, c6984o.lqy, c6984o.cQr);
        AppMethodBeat.m2505o(53909);
    }

    /* renamed from: jj */
    public final void mo46533jj(boolean z) {
        int i;
        AppMethodBeat.m2504i(53910);
        C4990ab.m7409c("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", Boolean.valueOf(z));
        byte[] bArr = new byte[1];
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        bArr[0] = (byte) i;
        this.oFP.setAppCmd(425, bArr, 1);
        AppMethodBeat.m2505o(53910);
    }
}
