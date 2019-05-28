package com.tencent.mm.plugin.voip.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class m {
    public static int kze = 3;
    public static int sPY = 0;
    public static int sPZ = 0;
    volatile c kzb = null;
    public int kzf = 1;
    int kzg = 92;
    private int kzh = 1;
    private final Object kzi = new Object();
    public int kzj = 0;
    private int kzk = 1;
    private long kzl = 0;
    private com.tencent.mm.audio.b.c.a kzo = new com.tencent.mm.audio.b.c.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(4436);
            synchronized (m.this.kzi) {
                try {
                    if (m.this.kzf == 2 && m.this.sPL != null) {
                        long currentTimeMillis;
                        if (m.this.sPO == 1) {
                            m.this.sPM = System.currentTimeMillis();
                            m.this.sPN = m.this.sPM;
                            m.this.sPO = 0;
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                            m.this.sPP = (int) ((currentTimeMillis - m.this.sPN) - ((long) (m.sPZ * 20)));
                            m.this.sPM = currentTimeMillis;
                        }
                        if (m.this.kzg <= 10) {
                            m.this.kzg = 92;
                        }
                        m.this.kzg = ((m.this.sPL.cIq() + 24) + (m.this.kzg * 3)) / 4;
                        if (m.this.kzh == 1) {
                            m.this.sPR = m.this.sPL.cIn();
                            if (m.this.sPR >= m.this.kzg) {
                                m.this.sPR = m.this.sPR - m.this.kzg;
                            }
                            m.this.kzg = m.this.sPR;
                            m.this.kzh = 0;
                        } else {
                            m.this.kzg = 0;
                        }
                        if (1 == m.this.kzk) {
                            m.this.kzk = 0;
                            m.this.kzl = System.currentTimeMillis();
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                            long l = currentTimeMillis - m.this.kzl;
                            if (l > 1000) {
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(l)));
                            }
                            m.this.kzl = currentTimeMillis;
                        }
                        m.this.sNl.sPp.recordCallback(bArr, i, m.this.kzg);
                        m.sPZ++;
                    }
                } finally {
                    AppMethodBeat.o(4436);
                }
            }
        }

        public final void bN(int i, int i2) {
        }
    };
    public k sNl = null;
    c sPL = null;
    private long sPM = 0;
    private long sPN = 0;
    private int sPO = 1;
    private int sPP = 0;
    private long sPQ = 0;
    private int sPR = 0;
    private int sPS = 0;
    public boolean sPT = false;
    public boolean sPU = false;
    public int sPV = 0;
    private int sPW = 1;
    private long sPX = 0;
    b sQa;

    class a implements Runnable {
        private c nxe = null;
        private c nxt = null;

        public a(c cVar, c cVar2) {
            this.nxe = cVar;
            this.nxt = cVar2;
        }

        public final void run() {
            AppMethodBeat.i(4439);
            if (this.nxe != null) {
                this.nxe.cIr();
                this.nxe.cIo();
                this.nxe = null;
            }
            ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
            if (this.nxt != null) {
                this.nxt.EB();
                this.nxt = null;
                ab.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord");
            }
            AppMethodBeat.o(4439);
        }
    }

    class b implements Runnable {
        boolean sQc = false;
        boolean sQd = false;

        b() {
        }

        public final void run() {
            AppMethodBeat.i(4440);
            while (m.this.kzf == 2 && !this.sQd) {
                long currentTimeMillis = System.currentTimeMillis();
                if (m.this.sNl.cIQ() && m.this.sNl.sPp.videoDecode(m.this.sNl.sPp.sUU) == 1) {
                    int i = m.this.sNl.sPp.field_remoteImgWidth;
                    int i2 = m.this.sNl.sPp.field_remoteImgHeight;
                    boolean z = i == 0 && i2 < 3;
                    if (z) {
                        if (!this.sQc) {
                            m mVar = m.this;
                            mVar.sPV |= 1;
                            m.this.sNl.sPq.setHWDecMode(m.this.sPV);
                            ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec");
                        }
                        if (v2protocal.sVJ != null) {
                            try {
                                i = m.this.sNl.sPp.field_remoteImgLength;
                                ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
                                i2 = m.this.sNl.sPp.field_remoteImgHeight;
                                byte[] bArr = new byte[i];
                                m.this.sNl.sPp.getVideoHWDecode(m.this.sNl.sPp.sUU, bArr, i);
                                v2protocal.sVJ.T(bArr, i2);
                                ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (System.currentTimeMillis() - currentTimeMillis) + ", startTime = " + currentTimeMillis);
                            } catch (Exception e) {
                                ab.e("EncodeDecode", "interrupted while waiting");
                                ab.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + e.toString());
                            }
                        }
                    } else {
                        if (this.sQc) {
                            m mVar2 = m.this;
                            mVar2.sPV &= -2;
                            if (v2protocal.sVJ != null) {
                                v2protocal.sVJ.sOe = false;
                            }
                            m.this.sNl.sPq.setHWDecMode(m.this.sPV);
                            ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
                        }
                        if (m.this.sNl.sPp.field_remoteImgLength > 0 && m.this.sNl.sPq != null) {
                            v2protocal v2protocal = m.this.sNl.sPp;
                            v2protocal.sVv++;
                            m.this.sNl.sPq.b(i, i2, m.this.sNl.sPp.sUU);
                        }
                    }
                    this.sQc = z;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    ab.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(4440);
        }
    }

    public m(k kVar) {
        AppMethodBeat.i(4441);
        this.sNl = kVar;
        AppMethodBeat.o(4441);
    }

    public final int cIX() {
        if (this.kzb == null || this.sNl.sPp.sVH.sQo != (byte) 1) {
            return 0;
        }
        return this.kzb.cpq;
    }

    public final int cIs() {
        AppMethodBeat.i(4442);
        if (this.sPL == null || this.sNl.sPp.sVH.sQo != (byte) 1) {
            AppMethodBeat.o(4442);
            return 0;
        }
        int cIs = this.sPL.cIs();
        AppMethodBeat.o(4442);
        return cIs;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x002b, B:43:0x0107] */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1);
     */
    /* JADX WARNING: Missing block: B:57:0x0139, code skipped:
            r1 = 4443;
     */
    /* JADX WARNING: Missing block: B:59:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(4443);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void cIY() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(4443);
            ab.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", this.kzb);
            int i2;
            if (this.kzf == kze) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
                i2 = this.kzi;
                synchronized (i2) {
                    if (this.kzb != null) {
                        ab.e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
                        this.kzb.EB();
                    }
                }
            } else {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
                this.kzf = kze;
                if (this.sQa != null) {
                    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    this.sQa.sQd = true;
                    d.xDG.remove(this.sQa);
                    this.sQa = null;
                }
                this.kzh = 1;
                this.sPR = 0;
                this.kzk = 1;
                this.sPW = 1;
                this.kzl = 0;
                this.sPX = 0;
                this.kzg = 92;
                this.sPM = 0;
                this.sPN = 0;
                this.sPO = 1;
                this.sPP = 0;
                this.kzj = 0;
                this.sNl.sPp.sUo = cIX();
                this.sNl.sPp.sUp = cIs();
                v2protocal v2protocal = this.sNl.sPp;
                if (this.kzb == null || this.sNl.sPp.sVH.sQo != (byte) 1) {
                    i2 = -2;
                } else {
                    i2 = this.kzb.EO();
                }
                v2protocal.sUs = i2;
                v2protocal v2protocal2 = this.sNl.sPp;
                if (this.sPL != null && this.sNl.sPp.sVH.sQo == (byte) 1) {
                    i = this.sPL.cIt();
                }
                v2protocal2.sUz = (int) ((((float) g.KK().getStreamVolume(i)) / ((float) g.KK().getStreamMaxVolume(i))) * 100.0f);
                Object obj = this.kzi;
                synchronized (obj) {
                    if (!(this.sPL == null || this.kzb == null)) {
                        d.f(new a(this.sPL, this.kzb), "VoipDeviceHandler_stopDev");
                        ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                    }
                    AppMethodBeat.o(4443);
                }
            }
            AppMethodBeat.o(4443);
        }
    }

    public final void cIZ() {
        AppMethodBeat.i(4444);
        ab.c("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", this.kzb);
        synchronized (this.kzi) {
            try {
                if (this.kzb != null) {
                    ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                    this.kzb.EB();
                    this.kzb = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(4444);
            }
        }
    }

    public final boolean mj(boolean z) {
        AppMethodBeat.i(4445);
        if (this.sPL != null) {
            boolean mj = this.sPL.mj(z);
            AppMethodBeat.o(4445);
            return mj;
        }
        AppMethodBeat.o(4445);
        return false;
    }

    public final int b(byte[] bArr, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(4446);
        if (this.kzf != 2) {
            AppMethodBeat.o(4446);
            return 0;
        } else if (this.sNl.cIP()) {
            int i5;
            v2protocal v2protocal = this.sNl.sPp;
            v2protocal.sVr++;
            if (this.sPU) {
                ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
                this.sNl.sPp.sVM = false;
                this.sPT = false;
                this.sPU = false;
                this.sNl.Gi(1);
            }
            if (!this.sNl.sPp.sVM || this.sNl.sPp.sVI == null) {
                this.sPT = false;
            } else {
                e eVar = this.sNl.sPp.sVI;
                if (!(eVar.sNl == null || eVar.sNl.sPp == null)) {
                    if (eVar.sNl.sPp.setAppCmd(e.EMethodGetQosPara, eVar.sOz.s2p, eVar.sOz.s2p.length) >= 0) {
                        a aVar = eVar.sOz;
                        ByteBuffer wrap = ByteBuffer.wrap(aVar.s2p);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        aVar.iKbps = wrap.getShort();
                        aVar.cFps = wrap.get();
                        aVar.cIPeriod = wrap.get();
                        aVar.cRSLevel = wrap.get();
                        aVar.cQPmin = wrap.get();
                        aVar.cQPmax = wrap.get();
                        aVar.cHPPMaxLyr = wrap.get();
                        aVar.cSwitch = wrap.get();
                        aVar.cResolution = wrap.get();
                        aVar.cRsvd1 = wrap.get();
                        aVar.cRsvd2 = wrap.get();
                        aVar.cSkipFlag = wrap.get();
                        aVar.cIReqFlag = wrap.get();
                        aVar = eVar.sOz;
                        ab.d("MeidaCodec[HWEnc]", "raw S2P:" + aVar.s2p);
                        ab.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + aVar.iKbps + ", fps:" + aVar.cFps + ", IP:" + aVar.cIPeriod + ", RS:" + aVar.cRSLevel + ", QPMin:" + aVar.cQPmin + ", QPMax:" + aVar.cQPmax + ", HPP:" + aVar.cHPPMaxLyr + ", SWitch:" + aVar.cSwitch + ", Reso:" + aVar.cResolution + ", Rsvd1:" + aVar.cRsvd1 + ", Rsvd2:" + aVar.cRsvd2 + ", Skip:" + aVar.cSkipFlag + ", IReq:" + aVar.cIReqFlag);
                    }
                    i5 = eVar.sOz.iKbps;
                    if ((eVar.sOv == 8 ? 1 : null) == null) {
                        i5 = (int) (((double) i5) * (1.0d + ((1.0d * ((double) Math.max(Math.min(eVar.sNl.sPp.sUK, 30), 0))) / 100.0d)));
                    }
                    if (eVar.m_br_kbps != i5) {
                        eVar.SetBitRate(i5);
                        ab.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + e.frameID + ", new_br: " + eVar.m_br_kbps + ", tuneBR:" + i5 + ", tuneRatio:" + eVar.sNl.sPp.sUK);
                        eVar.m_br_kbps = i5;
                    }
                    if ((byte) 1 == eVar.sOz.cIReqFlag && e.frameID > 0) {
                        if (eVar.mediaCodec != null) {
                            ab.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
                            Bundle bundle = new Bundle();
                            bundle.putInt("request-sync", 0);
                            eVar.mediaCodec.setParameters(bundle);
                        }
                        ab.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + e.frameID);
                    }
                    if (eVar.sOz.cFps != eVar.m_framerate) {
                        eVar.m_framerate = eVar.sOz.cFps;
                    }
                }
                boolean equalsIgnoreCase = this.sNl.sPp.sVI.ENCODING.equalsIgnoreCase("video/avc");
                if (this.sNl.sPp.sVI.ENCODING.equalsIgnoreCase("video/hevc") || (equalsIgnoreCase && 1 == (this.sNl.sPp.sVI.sOz.cRsvd1 & 1) && this.sNl.sPp.sVI.sOz.cResolution >= (byte) 6)) {
                    this.sPT = true;
                } else {
                    this.sPT = false;
                }
            }
            ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + System.currentTimeMillis() + ", len:" + i + ", cnt:" + this.sNl.sPp.sVr + ", mIsHWEncEnable:" + this.sNl.sPp.sVM + ", mIsHWEncUsing:" + this.sPT);
            i5 = 0;
            if (!this.sPT || this.sNl.sPp.sVI == null) {
                if ((this.sPV >> 8) != 0) {
                    this.sPV &= -257;
                    this.sNl.sPq.setHWDecMode(this.sPV);
                }
                i5 = this.sNl.sPp.videoEncodeToSend(bArr, i, i3, i4, i2);
            } else {
                if (1 != (this.sPV >> 8)) {
                    this.sPV |= 256;
                    this.sNl.sPq.setHWDecMode(this.sPV);
                }
                int e = this.sNl.sPp.sVI.e(bArr, i3, i4, i2);
                if (e >= 0) {
                    i5 = 1;
                } else {
                    ab.d("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(e)));
                    this.sPU = true;
                }
            }
            AppMethodBeat.o(4446);
            return i5;
        } else {
            AppMethodBeat.o(4446);
            return 0;
        }
    }

    static /* synthetic */ void q(m mVar) {
        AppMethodBeat.i(4447);
        synchronized (mVar.kzi) {
            try {
                a aVar = new a();
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, record samplerate:" + aVar.pug + ", framelen: " + aVar.sNh + ", ret:" + mVar.sNl.sPp.a(aVar));
                mVar.kzb = new c(aVar.pug, aVar.channels, 1);
                mVar.kzb.gG(aVar.sNh);
                mVar.kzb.br(true);
                mVar.kzb.EJ();
                mVar.kzb.cpB = -19;
                mVar.kzb.v(1, false);
                mVar.kzb.bq(true);
                mVar.kzb.cpM = mVar.kzo;
                if (!(mVar.kzb.EL() || mVar.kzb.cpq == 13)) {
                    mVar.kzj = 1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(4447);
            }
        }
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + mVar.kzj);
        mVar.sNl.Ge(mVar.kzj);
        mVar.sNl.sPp.sVH.sQo = (byte) 1;
    }
}
