package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.wecall.talkroom.model.e;
import com.tencent.wxmm.v2helper;
import junit.framework.Assert;

public final class d implements f {
    a cqd = new a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(53905);
            if (i <= 0) {
                ab.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
                AppMethodBeat.o(53905);
                return;
            }
            if (d.this.oFR != null) {
                d.this.oFR.Y(bArr, i);
            }
            AppMethodBeat.o(53905);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(53906);
            ab.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(53906);
        }
    };
    c kzb;
    public com.tencent.pb.talkroom.sdk.d oFP;
    c oFQ;
    com.tencent.pb.talkroom.sdk.c oFR;
    b oFS;
    com.tencent.mm.plugin.voip.model.b oFT = new com.tencent.mm.plugin.voip.model.b() {
        public final int N(byte[] bArr, int i) {
            int X;
            AppMethodBeat.i(53907);
            if (d.this.oFS != null) {
                X = d.this.oFS.X(bArr, i);
            } else {
                X = 0;
            }
            if (X < 0) {
                AppMethodBeat.o(53907);
                return -1;
            }
            AppMethodBeat.o(53907);
            return 0;
        }
    };

    public d() {
        AppMethodBeat.i(53908);
        ab.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = ah.getContext();
        e dTl = e.dTl();
        e.jt(context);
        this.oFP = dTl;
        this.oFP.dPP();
        this.oFQ = new c();
        int h = bo.h((Integer) g.RP().eJH.get(1));
        this.oFP.a(p.bSf(), new com.tencent.pb.talkroom.sdk.e() {
            public final boolean d(int i, int i2, byte[] bArr) {
                AppMethodBeat.i(53892);
                ab.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
                g.Rg().a(new o(i, i2, bArr), 0);
                AppMethodBeat.o(53892);
                return false;
            }

            public final boolean bRj() {
                AppMethodBeat.i(53893);
                int Lw = m.Lw();
                ab.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(Lw)));
                if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec_v7a.so");
                } else if ((Lw & 512) != 0) {
                    com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec.so");
                    Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
                } else {
                    com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec_v5.so");
                    Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
                }
                AppMethodBeat.o(53893);
                return true;
            }

            public final int Lw() {
                AppMethodBeat.i(53894);
                int Lw = m.Lw();
                AppMethodBeat.o(53894);
                return Lw;
            }

            public final int bRk() {
                AppMethodBeat.i(53895);
                String dur = g.RP().Rz().dur();
                q.ku(dur);
                ab.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(dur)));
                d dVar = d.this;
                byte[] bArr = new byte[]{(byte) 0};
                byte[] bArr2 = new byte[2];
                if (q.etd.eqq >= 0) {
                    bArr2[0] = (byte) q.etd.eqq;
                    dVar.oFP.setAppCmd(406, bArr2, 1);
                } else if (q.etd.eqq == -2) {
                    dVar.oFP.setAppCmd(407, bArr, 1);
                }
                if (q.etd.eqt >= 0) {
                    byte[] bArr3 = new byte[5];
                    if (q.etd.equ >= 0 && q.etd.eqv >= 0) {
                        bArr3[0] = (byte) q.etd.equ;
                        bArr3[1] = (byte) q.etd.eqv;
                        if (q.etd.eqw >= 0) {
                            bArr3[2] = (byte) q.etd.eqw;
                            bArr3[3] = (byte) q.etd.eqt;
                            bArr3[4] = (byte) q.etd.eqx;
                            dVar.oFP.setAppCmd(404, bArr3, 5);
                        } else {
                            dVar.oFP.setAppCmd(404, bArr3, 2);
                        }
                    }
                } else if (q.etd.eqt == -2) {
                    dVar.oFP.setAppCmd(405, bArr, 1);
                }
                if (q.etd.eqr >= 0) {
                    bArr2[0] = (byte) q.etd.eqr;
                    dVar.oFP.setAppCmd(408, bArr2, 1);
                } else if (q.etd.eqr == -2) {
                    dVar.oFP.setAppCmd(409, bArr, 1);
                }
                if (q.etd.eqC[0] > (short) 0 || q.etd.eqC[1] > (short) 0) {
                    bArr2[0] = (byte) 0;
                    bArr2[1] = (byte) 0;
                    if (q.etd.eqC[0] > (short) 0 && q.etd.eqC[0] < (short) 10000) {
                        bArr2[0] = (byte) q.etd.eqC[0];
                    }
                    if (q.etd.eqC[1] > (short) 0 && q.etd.eqC[1] < (short) 10000) {
                        bArr2[1] = (byte) q.etd.eqC[1];
                    }
                    dVar.oFP.setAppCmd(v2helper.EMethodSetNgStrength, bArr2, 2);
                }
                if (q.etd.epT >= 0 || q.etd.epV >= 0) {
                    bArr2[0] = (byte) -1;
                    bArr2[1] = (byte) -1;
                    if (q.etd.epT >= 0) {
                        bArr2[0] = (byte) q.etd.epT;
                    }
                    if (q.etd.epV >= 0) {
                        bArr2[1] = (byte) q.etd.epV;
                    }
                    dVar.oFP.setAppCmd(414, bArr2, 2);
                }
                if (q.etd.epU >= 0 || q.etd.epW >= 0) {
                    bArr2[0] = (byte) -1;
                    bArr2[1] = (byte) -1;
                    if (q.etd.epU >= 0) {
                        bArr2[0] = (byte) q.etd.epU;
                    }
                    if (q.etd.epW >= 0) {
                        bArr2[1] = (byte) q.etd.epW;
                    }
                    dVar.oFP.setAppCmd(415, bArr2, 2);
                }
                if (q.etd.epX >= 0 || q.etd.epY >= 0) {
                    bArr2[0] = (byte) -1;
                    bArr2[1] = (byte) -1;
                    if (q.etd.epX >= 0) {
                        bArr2[0] = (byte) q.etd.epX;
                    }
                    if (q.etd.epY >= 0) {
                        bArr2[1] = (byte) q.etd.epY;
                    }
                    dVar.oFP.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr2, 2);
                }
                if (q.etd.epZ >= 0) {
                    bArr2[0] = (byte) q.etd.epZ;
                    dVar.oFP.setAppCmd(416, bArr2, 1);
                }
                if (q.etd.eqa >= 0 && q.etd.eqa != 5) {
                    bArr2[0] = (byte) q.etd.eqa;
                    dVar.oFP.setAppCmd(417, bArr2, 1);
                }
                if (q.etd.eqb >= 0 && q.etd.eqb != 5) {
                    bArr2[0] = (byte) q.etd.eqb;
                    dVar.oFP.setAppCmd(418, bArr2, 1);
                }
                if (q.etd.eqc >= 0) {
                    bArr2[0] = (byte) q.etd.eqc;
                    dVar.oFP.setAppCmd(419, bArr2, 1);
                }
                if (1 == q.etd.eqA) {
                    byte[] bArr4 = new byte[30];
                    for (int i = 0; i < 15; i++) {
                        bArr4[i * 2] = (byte) (q.etd.eqB[i] & 255);
                        bArr4[(i * 2) + 1] = (byte) ((q.etd.eqB[i] >> 8) & 255);
                    }
                    dVar.oFP.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr4, 30);
                }
                if (q.etd.eqA == 0) {
                    dVar.oFP.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff, bArr, 1);
                }
                if (q.etd.eqE > 0) {
                    bArr2[0] = (byte) q.etd.eqE;
                    dVar.oFP.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr2, 1);
                }
                if (q.etd.eqd > 0) {
                    bArr2[0] = (byte) q.etd.eqd;
                    dVar.oFP.setAppCmd(431, bArr2, 4);
                }
                if (q.etd.eqM >= 0) {
                    dVar.oFP.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) q.etd.eqM, (byte) q.etd.eqN, (byte) q.etd.eqO, (byte) q.etd.eqP}, 4);
                }
                AppMethodBeat.o(53895);
                return 0;
            }

            public final boolean jk(boolean z) {
                AppMethodBeat.i(53896);
                ab.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", Boolean.valueOf(z));
                d.this.oFQ.io(z);
                AppMethodBeat.o(53896);
                return true;
            }

            public final int a(int i, int i2, b bVar) {
                AppMethodBeat.i(53897);
                d.this.oFS = bVar;
                int a = d.this.oFQ.a(d.this.oFT, i, i2);
                ab.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KU()), Boolean.valueOf(p.bSf().oGb));
                if (com.tencent.mm.compatible.b.g.KK().KU() != p.bSf().oGb && p.bSf().nwe.DB()) {
                    d.this.oFQ.io(p.bSf().oGb);
                }
                AppMethodBeat.o(53897);
                return a;
            }

            public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
                AppMethodBeat.i(53898);
                d.this.oFR = cVar;
                d.this.kzb = new c(i, 1, 7);
                d.this.kzb.gG(i2);
                d.this.kzb.br(true);
                d.this.kzb.EJ();
                d.this.kzb.cpB = -19;
                d.this.kzb.v(1, false);
                d.this.kzb.bq(true);
                d.this.kzb.cpM = d.this.cqd;
                if (d.this.kzb.EL()) {
                    AppMethodBeat.o(53898);
                    return 1;
                }
                AppMethodBeat.o(53898);
                return -1;
            }

            public final boolean bRl() {
                AppMethodBeat.i(53899);
                ab.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
                com.tencent.mm.compatible.b.g.a aVar = d.this.oFQ;
                synchronized (aVar.kzr) {
                    try {
                        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(aVar.cFy), Integer.valueOf(aVar.hashCode()));
                        if (aVar.cFy) {
                            com.tencent.mm.plugin.voip.model.c cVar = aVar.kzq;
                            if (cVar != null) {
                                aVar.kzw.evE = SystemClock.elapsedRealtime();
                                cVar.cIr();
                                ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + aVar.kzw.Mr());
                                cVar.cIo();
                                aVar.cFy = false;
                                aVar.kzq = null;
                                com.tencent.mm.compatible.b.g.KK().La();
                                com.tencent.mm.compatible.b.g.KK().setMode(0);
                            }
                            aVar.kzs.fa(ah.getContext());
                            com.tencent.mm.compatible.b.g.KK().b(aVar);
                            aVar.gar.Mm();
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(53899);
                    }
                }
                return true;
            }

            public final boolean bRm() {
                AppMethodBeat.i(53900);
                ab.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
                try {
                    if (d.this.kzb != null) {
                        d.this.kzb.cpM = null;
                        d.this.kzb.EB();
                    }
                    d.this.kzb = null;
                    AppMethodBeat.o(53900);
                    return true;
                } catch (Exception e) {
                    ab.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(e)));
                    AppMethodBeat.o(53900);
                    return false;
                }
            }

            public final int bRn() {
                int i = 0;
                AppMethodBeat.i(53901);
                ab.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
                if (d.this.oFQ != null) {
                    c cVar = d.this.oFQ;
                    if (cVar.kzq != null) {
                        i = cVar.kzq.cIt();
                    }
                }
                i = (int) ((((float) com.tencent.mm.compatible.b.g.KK().getStreamVolume(i)) / ((float) com.tencent.mm.compatible.b.g.KK().getStreamMaxVolume(i))) * 100.0f);
                AppMethodBeat.o(53901);
                return i;
            }

            public final int bRo() {
                AppMethodBeat.i(53902);
                ab.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
                if (d.this.kzb != null) {
                    int EO = d.this.kzb.EO();
                    AppMethodBeat.o(53902);
                    return EO;
                }
                AppMethodBeat.o(53902);
                return -2;
            }

            public final int bRp() {
                AppMethodBeat.i(53903);
                ab.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
                if (d.this.kzb != null) {
                    int i = d.this.kzb.cpq;
                    AppMethodBeat.o(53903);
                    return i;
                }
                AppMethodBeat.o(53903);
                return 0;
            }

            public final int bRq() {
                AppMethodBeat.i(53904);
                ab.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
                if (d.this.oFQ != null) {
                    c cVar = d.this.oFQ;
                    if (cVar.kzq != null) {
                        int cIs = cVar.kzq.cIs();
                        AppMethodBeat.o(53904);
                        return cIs;
                    }
                    AppMethodBeat.o(53904);
                    return 0;
                }
                AppMethodBeat.o(53904);
                return 0;
            }

            public final boolean y(int i, String str, String str2) {
                AppMethodBeat.i(53891);
                switch (i) {
                    case 0:
                        ab.v(str, str2);
                        break;
                    case 1:
                        ab.d(str, str2);
                        break;
                    case 2:
                        ab.i(str, str2);
                        break;
                    case 3:
                        ab.w(str, str2);
                        break;
                    case 4:
                        ab.e(str, str2);
                        break;
                    case 5:
                        ab.f(str, str2);
                        break;
                    default:
                        ab.v(str, str2);
                        break;
                }
                AppMethodBeat.o(53891);
                return false;
            }
        });
        this.oFP.bR(h, r.Yz());
        g.Rg().a(1918, (f) this);
        g.Rg().a(1919, (f) this);
        g.Rg().a(1927, (f) this);
        g.Rg().a(1928, (f) this);
        g.Rg().a(1929, (f) this);
        g.Rg().a(1931, (f) this);
        g.Rg().a(1932, (f) this);
        g.Rg().a(1933, (f) this);
        g.Rg().a(1935, (f) this);
        g.Rg().a(1937, (f) this);
        g.Rg().a(1938, (f) this);
        g.Rg().a(1939, (f) this);
        AppMethodBeat.o(53908);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(53909);
        o oVar = (o) mVar;
        ab.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + oVar.lqy);
        this.oFP.e(i2, oVar.lqx, oVar.lqy, oVar.cQr);
        AppMethodBeat.o(53909);
    }

    public final void jj(boolean z) {
        int i;
        AppMethodBeat.i(53910);
        ab.c("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", Boolean.valueOf(z));
        byte[] bArr = new byte[1];
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        bArr[0] = (byte) i;
        this.oFP.setAppCmd(425, bArr, 1);
        AppMethodBeat.o(53910);
    }
}
