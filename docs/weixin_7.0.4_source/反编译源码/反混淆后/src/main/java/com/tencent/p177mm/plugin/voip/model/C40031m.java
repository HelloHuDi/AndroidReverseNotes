package com.tencent.p177mm.plugin.voip.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.plugin.voip.model.C46321e.C4281a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.voip.model.m */
public final class C40031m {
    public static int kze = 3;
    public static int sPY = 0;
    public static int sPZ = 0;
    volatile C1292c kzb = null;
    public int kzf = 1;
    int kzg = 92;
    private int kzh = 1;
    private final Object kzi = new Object();
    public int kzj = 0;
    private int kzk = 1;
    private long kzl = 0;
    private C1293a kzo = new C140521();
    public C14047k sNl = null;
    C29496c sPL = null;
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
    C40032b sQa;

    /* renamed from: com.tencent.mm.plugin.voip.model.m$1 */
    class C140521 implements C1293a {
        C140521() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(4436);
            synchronized (C40031m.this.kzi) {
                try {
                    if (C40031m.this.kzf == 2 && C40031m.this.sPL != null) {
                        long currentTimeMillis;
                        if (C40031m.this.sPO == 1) {
                            C40031m.this.sPM = System.currentTimeMillis();
                            C40031m.this.sPN = C40031m.this.sPM;
                            C40031m.this.sPO = 0;
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                            C40031m.this.sPP = (int) ((currentTimeMillis - C40031m.this.sPN) - ((long) (C40031m.sPZ * 20)));
                            C40031m.this.sPM = currentTimeMillis;
                        }
                        if (C40031m.this.kzg <= 10) {
                            C40031m.this.kzg = 92;
                        }
                        C40031m.this.kzg = ((C40031m.this.sPL.cIq() + 24) + (C40031m.this.kzg * 3)) / 4;
                        if (C40031m.this.kzh == 1) {
                            C40031m.this.sPR = C40031m.this.sPL.cIn();
                            if (C40031m.this.sPR >= C40031m.this.kzg) {
                                C40031m.this.sPR = C40031m.this.sPR - C40031m.this.kzg;
                            }
                            C40031m.this.kzg = C40031m.this.sPR;
                            C40031m.this.kzh = 0;
                        } else {
                            C40031m.this.kzg = 0;
                        }
                        if (1 == C40031m.this.kzk) {
                            C40031m.this.kzk = 0;
                            C40031m.this.kzl = System.currentTimeMillis();
                            C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                            long l = currentTimeMillis - C40031m.this.kzl;
                            if (l > 1000) {
                                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(l)));
                            }
                            C40031m.this.kzl = currentTimeMillis;
                        }
                        C40031m.this.sNl.sPp.recordCallback(bArr, i, C40031m.this.kzg);
                        C40031m.sPZ++;
                    }
                } finally {
                    AppMethodBeat.m2505o(4436);
                }
            }
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.m$2 */
    class C314542 implements C29495b {
        C314542() {
        }

        /* renamed from: N */
        public final int mo45518N(byte[] bArr, int i) {
            AppMethodBeat.m2504i(4437);
            if (C40031m.this.kzf != 2) {
                AppMethodBeat.m2505o(4437);
                return -1;
            }
            if (1 == C40031m.this.sPW) {
                C40031m.this.sPW = 0;
                C40031m.this.sPX = System.currentTimeMillis();
                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first play");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long p = currentTimeMillis - C40031m.this.sPX;
                if (p > 1000) {
                    C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(p)));
                }
                C40031m.this.sPX = currentTimeMillis;
            }
            int playCallback = C40031m.this.sNl.sPp.playCallback(bArr, i);
            if (playCallback < 0) {
                C46317a.Loge("MicroMsg.Voip.VoipDeviceHandler", C1447g.m3075Mq() + "protocal.playcallback ret:" + playCallback);
                AppMethodBeat.m2505o(4437);
                return -1;
            }
            C40031m.sPY++;
            AppMethodBeat.m2505o(4437);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.m$a */
    class C35354a implements Runnable {
        private C29496c nxe = null;
        private C1292c nxt = null;

        public C35354a(C29496c c29496c, C1292c c1292c) {
            this.nxe = c29496c;
            this.nxt = c1292c;
        }

        public final void run() {
            AppMethodBeat.m2504i(4439);
            if (this.nxe != null) {
                this.nxe.cIr();
                this.nxe.cIo();
                this.nxe = null;
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
            if (this.nxt != null) {
                this.nxt.mo4590EB();
                this.nxt = null;
                C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord");
            }
            AppMethodBeat.m2505o(4439);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.m$3 */
    class C400303 implements Runnable {
        C400303() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4438);
            try {
                C40031m.m68576q(C40031m.this);
                AppMethodBeat.m2505o(4438);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", e.getMessage());
                C40031m.this.kzj = 1;
                C40031m.this.sNl.mo26287Ge(C40031m.this.kzj);
                AppMethodBeat.m2505o(4438);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.m$b */
    class C40032b implements Runnable {
        boolean sQc = false;
        boolean sQd = false;

        C40032b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4440);
            while (C40031m.this.kzf == 2 && !this.sQd) {
                long currentTimeMillis = System.currentTimeMillis();
                if (C40031m.this.sNl.cIQ() && C40031m.this.sNl.sPp.videoDecode(C40031m.this.sNl.sPp.sUU) == 1) {
                    int i = C40031m.this.sNl.sPp.field_remoteImgWidth;
                    int i2 = C40031m.this.sNl.sPp.field_remoteImgHeight;
                    boolean z = i == 0 && i2 < 3;
                    if (z) {
                        if (!this.sQc) {
                            C40031m c40031m = C40031m.this;
                            c40031m.sPV |= 1;
                            C40031m.this.sNl.sPq.setHWDecMode(C40031m.this.sPV);
                            C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec");
                        }
                        if (v2protocal.sVJ != null) {
                            try {
                                i = C40031m.this.sNl.sPp.field_remoteImgLength;
                                C4990ab.m7410d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
                                i2 = C40031m.this.sNl.sPp.field_remoteImgHeight;
                                byte[] bArr = new byte[i];
                                C40031m.this.sNl.sPp.getVideoHWDecode(C40031m.this.sNl.sPp.sUU, bArr, i);
                                v2protocal.sVJ.mo69419T(bArr, i2);
                                C4990ab.m7410d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (System.currentTimeMillis() - currentTimeMillis) + ", startTime = " + currentTimeMillis);
                            } catch (Exception e) {
                                C4990ab.m7412e("EncodeDecode", "interrupted while waiting");
                                C4990ab.m7412e("MicroMsg.Voip.VoipDeviceHandler", " error:" + e.toString());
                            }
                        }
                    } else {
                        if (this.sQc) {
                            C40031m c40031m2 = C40031m.this;
                            c40031m2.sPV &= -2;
                            if (v2protocal.sVJ != null) {
                                v2protocal.sVJ.sOe = false;
                            }
                            C40031m.this.sNl.sPq.setHWDecMode(C40031m.this.sPV);
                            C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
                        }
                        if (C40031m.this.sNl.sPp.field_remoteImgLength > 0 && C40031m.this.sNl.sPq != null) {
                            v2protocal v2protocal = C40031m.this.sNl.sPp;
                            v2protocal.sVv++;
                            C40031m.this.sNl.sPq.mo30881b(i, i2, C40031m.this.sNl.sPp.sUU);
                        }
                    }
                    this.sQc = z;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(4440);
        }
    }

    public C40031m(C14047k c14047k) {
        AppMethodBeat.m2504i(4441);
        this.sNl = c14047k;
        AppMethodBeat.m2505o(4441);
    }

    public final int cIX() {
        if (this.kzb == null || this.sNl.sPp.sVH.sQo != (byte) 1) {
            return 0;
        }
        return this.kzb.cpq;
    }

    public final int cIs() {
        AppMethodBeat.m2504i(4442);
        if (this.sPL == null || this.sNl.sPp.sVH.sQo != (byte) 1) {
            AppMethodBeat.m2505o(4442);
            return 0;
        }
        int cIs = this.sPL.cIs();
        AppMethodBeat.m2505o(4442);
        return cIs;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x002b, B:43:0x0107] */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r1);
     */
    /* JADX WARNING: Missing block: B:57:0x0139, code skipped:
            r1 = 4443;
     */
    /* JADX WARNING: Missing block: B:59:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(4443);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void cIY() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(4443);
            C4990ab.m7417i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", this.kzb);
            int i2;
            if (this.kzf == kze) {
                C46317a.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
                i2 = this.kzi;
                synchronized (i2) {
                    if (this.kzb != null) {
                        C4990ab.m7412e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
                        this.kzb.mo4590EB();
                    }
                }
            } else {
                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
                this.kzf = kze;
                if (this.sQa != null) {
                    C46317a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    this.sQa.sQd = true;
                    C7305d.xDG.remove(this.sQa);
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
                    i2 = this.kzb.mo4594EO();
                }
                v2protocal.sUs = i2;
                v2protocal v2protocal2 = this.sNl.sPp;
                if (this.sPL != null && this.sNl.sPp.sVH.sQo == (byte) 1) {
                    i = this.sPL.cIt();
                }
                v2protocal2.sUz = (int) ((((float) C1407g.m2946KK().getStreamVolume(i)) / ((float) C1407g.m2946KK().getStreamMaxVolume(i))) * 100.0f);
                Object obj = this.kzi;
                synchronized (obj) {
                    if (!(this.sPL == null || this.kzb == null)) {
                        C7305d.m12298f(new C35354a(this.sPL, this.kzb), "VoipDeviceHandler_stopDev");
                        C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                    }
                    AppMethodBeat.m2505o(4443);
                }
            }
            AppMethodBeat.m2505o(4443);
        }
    }

    public final void cIZ() {
        AppMethodBeat.m2504i(4444);
        C4990ab.m7409c("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", this.kzb);
        synchronized (this.kzi) {
            try {
                if (this.kzb != null) {
                    C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                    this.kzb.mo4590EB();
                    this.kzb = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(4444);
            }
        }
    }

    /* renamed from: mj */
    public final boolean mo63264mj(boolean z) {
        AppMethodBeat.m2504i(4445);
        if (this.sPL != null) {
            boolean mj = this.sPL.mo47758mj(z);
            AppMethodBeat.m2505o(4445);
            return mj;
        }
        AppMethodBeat.m2505o(4445);
        return false;
    }

    /* renamed from: b */
    public final int mo63259b(byte[] bArr, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(4446);
        if (this.kzf != 2) {
            AppMethodBeat.m2505o(4446);
            return 0;
        } else if (this.sNl.cIP()) {
            int i5;
            v2protocal v2protocal = this.sNl.sPp;
            v2protocal.sVr++;
            if (this.sPU) {
                C4990ab.m7416i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
                this.sNl.sPp.sVM = false;
                this.sPT = false;
                this.sPU = false;
                this.sNl.mo26291Gi(1);
            }
            if (!this.sNl.sPp.sVM || this.sNl.sPp.sVI == null) {
                this.sPT = false;
            } else {
                C46321e c46321e = this.sNl.sPp.sVI;
                if (!(c46321e.sNl == null || c46321e.sNl.sPp == null)) {
                    if (c46321e.sNl.sPp.setAppCmd(C46321e.EMethodGetQosPara, c46321e.sOz.s2p, c46321e.sOz.s2p.length) >= 0) {
                        C4281a c4281a = c46321e.sOz;
                        ByteBuffer wrap = ByteBuffer.wrap(c4281a.s2p);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        c4281a.iKbps = wrap.getShort();
                        c4281a.cFps = wrap.get();
                        c4281a.cIPeriod = wrap.get();
                        c4281a.cRSLevel = wrap.get();
                        c4281a.cQPmin = wrap.get();
                        c4281a.cQPmax = wrap.get();
                        c4281a.cHPPMaxLyr = wrap.get();
                        c4281a.cSwitch = wrap.get();
                        c4281a.cResolution = wrap.get();
                        c4281a.cRsvd1 = wrap.get();
                        c4281a.cRsvd2 = wrap.get();
                        c4281a.cSkipFlag = wrap.get();
                        c4281a.cIReqFlag = wrap.get();
                        c4281a = c46321e.sOz;
                        C4990ab.m7410d("MeidaCodec[HWEnc]", "raw S2P:" + c4281a.s2p);
                        C4990ab.m7410d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + c4281a.iKbps + ", fps:" + c4281a.cFps + ", IP:" + c4281a.cIPeriod + ", RS:" + c4281a.cRSLevel + ", QPMin:" + c4281a.cQPmin + ", QPMax:" + c4281a.cQPmax + ", HPP:" + c4281a.cHPPMaxLyr + ", SWitch:" + c4281a.cSwitch + ", Reso:" + c4281a.cResolution + ", Rsvd1:" + c4281a.cRsvd1 + ", Rsvd2:" + c4281a.cRsvd2 + ", Skip:" + c4281a.cSkipFlag + ", IReq:" + c4281a.cIReqFlag);
                    }
                    i5 = c46321e.sOz.iKbps;
                    if ((c46321e.sOv == 8 ? 1 : null) == null) {
                        i5 = (int) (((double) i5) * (1.0d + ((1.0d * ((double) Math.max(Math.min(c46321e.sNl.sPp.sUK, 30), 0))) / 100.0d)));
                    }
                    if (c46321e.m_br_kbps != i5) {
                        c46321e.SetBitRate(i5);
                        C4990ab.m7416i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + C46321e.frameID + ", new_br: " + c46321e.m_br_kbps + ", tuneBR:" + i5 + ", tuneRatio:" + c46321e.sNl.sPp.sUK);
                        c46321e.m_br_kbps = i5;
                    }
                    if ((byte) 1 == c46321e.sOz.cIReqFlag && C46321e.frameID > 0) {
                        if (c46321e.mediaCodec != null) {
                            C4990ab.m7418v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
                            Bundle bundle = new Bundle();
                            bundle.putInt("request-sync", 0);
                            c46321e.mediaCodec.setParameters(bundle);
                        }
                        C4990ab.m7416i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + C46321e.frameID);
                    }
                    if (c46321e.sOz.cFps != c46321e.m_framerate) {
                        c46321e.m_framerate = c46321e.sOz.cFps;
                    }
                }
                boolean equalsIgnoreCase = this.sNl.sPp.sVI.ENCODING.equalsIgnoreCase("video/avc");
                if (this.sNl.sPp.sVI.ENCODING.equalsIgnoreCase("video/hevc") || (equalsIgnoreCase && 1 == (this.sNl.sPp.sVI.sOz.cRsvd1 & 1) && this.sNl.sPp.sVI.sOz.cResolution >= (byte) 6)) {
                    this.sPT = true;
                } else {
                    this.sPT = false;
                }
            }
            C4990ab.m7410d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + System.currentTimeMillis() + ", len:" + i + ", cnt:" + this.sNl.sPp.sVr + ", mIsHWEncEnable:" + this.sNl.sPp.sVM + ", mIsHWEncUsing:" + this.sPT);
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
                int e = this.sNl.sPp.sVI.mo74511e(bArr, i3, i4, i2);
                if (e >= 0) {
                    i5 = 1;
                } else {
                    C4990ab.m7410d("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(e)));
                    this.sPU = true;
                }
            }
            AppMethodBeat.m2505o(4446);
            return i5;
        } else {
            AppMethodBeat.m2505o(4446);
            return 0;
        }
    }

    /* renamed from: q */
    static /* synthetic */ void m68576q(C40031m c40031m) {
        AppMethodBeat.m2504i(4447);
        synchronized (c40031m.kzi) {
            try {
                C22458a c22458a = new C22458a();
                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, record samplerate:" + c22458a.pug + ", framelen: " + c22458a.sNh + ", ret:" + c40031m.sNl.sPp.mo63273a(c22458a));
                c40031m.kzb = new C1292c(c22458a.pug, c22458a.channels, 1);
                c40031m.kzb.mo4598gG(c22458a.sNh);
                c40031m.kzb.mo4596br(true);
                c40031m.kzb.mo4591EJ();
                c40031m.kzb.cpB = -19;
                c40031m.kzb.mo4599v(1, false);
                c40031m.kzb.mo4595bq(true);
                c40031m.kzb.cpM = c40031m.kzo;
                if (!(c40031m.kzb.mo4592EL() || c40031m.kzb.cpq == 13)) {
                    c40031m.kzj = 1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(4447);
            }
        }
        C46317a.Logd("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + c40031m.kzj);
        c40031m.sNl.mo26287Ge(c40031m.kzj);
        c40031m.sNl.sPp.sVH.sQo = (byte) 1;
    }
}
