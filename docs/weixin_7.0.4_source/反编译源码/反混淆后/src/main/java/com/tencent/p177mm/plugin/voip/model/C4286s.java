package com.tencent.p177mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C14047k.C14046a;
import com.tencent.p177mm.plugin.voip.model.p746a.C14038d;
import com.tencent.p177mm.plugin.voip.model.p746a.C24844g;
import com.tencent.p177mm.plugin.voip.model.p746a.C24845l;
import com.tencent.p177mm.plugin.voip.model.p746a.C29491f;
import com.tencent.p177mm.plugin.voip.model.p746a.C35349a;
import com.tencent.p177mm.plugin.voip.model.p746a.C35352b;
import com.tencent.p177mm.plugin.voip.model.p746a.C35353c;
import com.tencent.p177mm.plugin.voip.model.p746a.C40028i;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip.video.C22470i;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.voip.model.s */
public final class C4286s implements C14046a {
    private static int hGc = -1;
    private static int sTl = -1;
    static int sTm = 20;
    WifiManager bJj;
    public C14047k sNl = C29500l.cIW();
    private Object sTi = new Object();
    C22470i sTj;
    private int sTk = 0;
    public String sTn;
    int sTo;
    Timer sTp = null;
    WifiInfo sTq;
    private C7564ap sTr = new C7564ap(Looper.getMainLooper(), new C42881(), false);
    private byte[] sTs = new byte[500];
    C7564ap sTt = new C7564ap(Looper.getMainLooper(), new C42902(), true);
    private C7564ap sTu = new C7564ap(Looper.getMainLooper(), new C42893(), true);
    private C7564ap sTv = new C7564ap(Looper.getMainLooper(), new C42914(), true);

    /* renamed from: com.tencent.mm.plugin.voip.model.s$6 */
    class C42856 extends TimerTask {
        C42856() {
        }

        public final void run() {
            int i = 10;
            AppMethodBeat.m2504i(4648);
            if (C4286s.this.bJj != null) {
                C4286s.this.sTq = C4286s.this.bJj.getConnectionInfo();
            }
            if (C4286s.this.sTq == null || C4286s.this.sTq.getBSSID() == null || C4286s.this.bJj == null) {
                C4286s.hGc = -1;
            } else {
                C4286s.this.bJj;
                C4286s.hGc = WifiManager.calculateSignalLevel(C4286s.this.sTq.getRssi(), 10);
                if (C4286s.hGc <= 10) {
                    i = C4286s.hGc;
                }
                C4286s.hGc = i;
                C4286s.hGc = C4286s.hGc < 0 ? 0 : C4286s.hGc;
                C4286s.hGc = C4286s.hGc * 10;
            }
            if (C4286s.hGc == -1) {
                if (C4286s.this.sTo <= 1) {
                    C4286s.sTl = -1;
                }
                C4286s.this.setNetSignalValue(1, C4286s.sTl);
                AppMethodBeat.m2505o(4648);
                return;
            }
            C4286s.this.setNetSignalValue(2, C4286s.hGc);
            AppMethodBeat.m2505o(4648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.s$5 */
    class C42875 extends PhoneStateListener {
        final /* synthetic */ TelephonyManager sTx;

        C42875(TelephonyManager telephonyManager) {
            this.sTx = telephonyManager;
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int i = 100;
            AppMethodBeat.m2504i(4647);
            super.onSignalStrengthsChanged(signalStrength);
            String[] split = signalStrength.toString().split(" ");
            if (this.sTx.getNetworkType() == 13) {
                if (split != null && split.length >= 10) {
                    C4286s.sTl = C5046bo.getInt(split[9], -141) + 140;
                }
                C4286s.this.sTn = "LTE";
            } else {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if (signalStrength.isGsm() && gsmSignalStrength == 99) {
                    C4286s.sTl = -1;
                } else {
                    C4286s.sTl = (int) (((float) gsmSignalStrength) * 3.2258065f);
                }
            }
            if (C4286s.sTl <= 100) {
                i = C4286s.sTl;
            }
            C4286s.sTl = i;
            C4286s.sTl = C4286s.sTl < 0 ? 0 : C4286s.sTl;
            C4286s.this.sTo = C4286s.this.sTo + 1;
            AppMethodBeat.m2505o(4647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.s$1 */
    class C42881 implements C5015a {
        C42881() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4643);
            if (C4286s.this.sNl.sPp.sTY == 1) {
                int i;
                C14047k c14047k = C4286s.this.sNl;
                if (c14047k.mStatus == 2 || c14047k.mStatus == 4) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                    C4286s.this.sNl.sPp.sVH.sQe = 101;
                    C7060h.pYm.mo8381e(11521, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                    C4286s.this.cKk();
                    C4286s.this.sNl.sPq.cJA();
                }
            }
            AppMethodBeat.m2505o(4643);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.s$3 */
    class C42893 implements C5015a {
        C42893() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4645);
            if (C4286s.this.sNl.sPp.nwu == 0) {
                C46317a.Loge("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + " roomId == 0 ");
                C4286s.this.sTu.stopTimer();
            } else {
                boolean z;
                if (C4286s.this.sNl.mStatus >= 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    new C29491f(C4286s.this.sNl.sPp.nwu, C4286s.this.sNl.sPp.nwv, C4286s.this.sNl.sPC).cKw();
                }
            }
            AppMethodBeat.m2505o(4645);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.s$2 */
    class C42902 implements C5015a {
        C42902() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4644);
            C14047k c14047k = C4286s.this.sNl;
            c14047k.sPx++;
            if (C4286s.this.sNl.sPp.nwu == 0) {
                C46317a.Loge("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + "double link switch roomId == 0 ");
                C4286s.this.sTt.stopTimer();
            } else {
                C4286s.this.sNl.sPp.app2EngineDataEx(C4286s.this.sNl.sPp.sVc, C4286s.this.sNl.sPp.sVd, C4286s.this.sNl.sPp.sVe, 0, 0);
                if (!C4286s.this.sNl.sPw && 1 == C4286s.this.sNl.sPp.field_mGetValidSample) {
                    C4286s.this.sNl.sPw = true;
                    C4286s.this.sNl.sPy = C4286s.this.sNl.sPx;
                }
                if (1 == C4286s.this.sNl.sPc) {
                    C4286s.this.sNl.sPc = 15;
                }
                if (true == C4286s.this.sNl.sPw && C4286s.this.sNl.sPx - C4286s.this.sNl.sPy == C4286s.this.sNl.sPc && (C4286s.this.sNl.sPp.sUT & 1) == 0) {
                    C4286s.this.sNl.sPy = C4286s.this.sNl.sPx;
                    int isDCSameLan = C4286s.this.sNl.sPp.isDCSameLan();
                    int currentConnType = C4286s.this.sNl.sPp.getCurrentConnType();
                    if (1 == isDCSameLan && 1 == currentConnType) {
                        C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(isDCSameLan)));
                        c14047k = C4286s.this.sNl;
                        c14047k.sPx++;
                        AppMethodBeat.m2505o(4644);
                        return true;
                    }
                    int i = C4286s.this.sNl.sPp.getcurstrategy();
                    int isRelayConnReady = C4286s.this.sNl.sPp.isRelayConnReady();
                    int isDCReady = C4286s.this.sNl.sPp.isDCReady();
                    isDCSameLan = C4286s.this.sNl.sPc - 3;
                    if (isDCSameLan > 15) {
                        isDCSameLan = 15;
                    }
                    C4286s.this.sNl.sPp.app2EngineLinkQualityEx(isDCSameLan, C4286s.this.sTs);
                    new C14038d(C4286s.this.sNl.sPp.nwu, C4286s.this.sNl.sPp.nwv, C4286s.this.sNl.sPp.nwC, currentConnType, isRelayConnReady, isDCReady, i, C4286s.this.sTs, C4286s.this.sNl.sPp.field_realLinkQualityInfoBuffLen).cKw();
                    v2protocal v2protocal = C4286s.this.sNl.sPp;
                    v2protocal.sUV++;
                    C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + C4286s.this.sNl.sPc + " isFirstValidSampleSet " + C4286s.this.sNl.sPw + " mGetValidSample " + C4286s.this.sNl.sPp.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + C4286s.this.sNl.sPp.sUV + "mTimerCounter " + C4286s.this.sNl.sPx + "mLastSwitchTimer " + C4286s.this.sNl.sPy);
                }
            }
            AppMethodBeat.m2505o(4644);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.s$4 */
    class C42914 implements C5015a {
        C42914() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4646);
            C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
            if (3 == C4286s.this.sNl.mStatus && C4286s.this.sTk != 0 && C4286s.this.sTk == C4286s.this.sNl.sPp.nwu) {
                C4286s.this.sTk = 0;
                C4286s.this.sNl.mo26330v(5, -9000, "");
            }
            AppMethodBeat.m2505o(4646);
            return false;
        }
    }

    public C4286s() {
        AppMethodBeat.m2504i(4649);
        this.sNl.mo26297a((C14046a) this);
        this.sTj = new C22470i(C4996ah.getContext());
        AppMethodBeat.m2505o(4649);
    }

    public final void stop() {
        AppMethodBeat.m2504i(4650);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.sNl.mo26297a(null);
        AppMethodBeat.m2505o(4650);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(4651);
        stop();
        super.finalize();
        AppMethodBeat.m2505o(4651);
    }

    public final void reset() {
        AppMethodBeat.m2504i(4652);
        C4990ab.m7410d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.sNl.reset();
        this.sTu.stopTimer();
        this.sTr.stopTimer();
        this.sTt.stopTimer();
        this.sTv.stopTimer();
        if (this.sTp != null) {
            this.sTp.cancel();
            this.sTp = null;
        }
        this.sTk = 0;
        C43727b.cIj().sRK = null;
        AppMethodBeat.m2505o(4652);
    }

    private void cKf() {
        AppMethodBeat.m2504i(4653);
        C4990ab.m7410d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.sTu.stopTimer();
        this.sTr.stopTimer();
        this.sTt.stopTimer();
        this.sTv.stopTimer();
        this.sTk = 0;
        AppMethodBeat.m2505o(4653);
    }

    /* renamed from: Gw */
    public final void mo9272Gw(int i) {
        AppMethodBeat.m2504i(4654);
        this.sNl.mo26286Gd(i);
        AppMethodBeat.m2505o(4654);
    }

    public final boolean cKg() {
        return this.sNl.sPp.nwu != 0;
    }

    public final boolean cIJ() {
        AppMethodBeat.m2504i(4655);
        if (this.sNl.cIJ()) {
            AppMethodBeat.m2505o(4655);
            return true;
        }
        AppMethodBeat.m2505o(4655);
        return false;
    }

    public static boolean cKh() {
        AppMethodBeat.m2504i(4656);
        if (((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getCallState() != 0) {
            AppMethodBeat.m2505o(4656);
            return true;
        }
        AppMethodBeat.m2505o(4656);
        return false;
    }

    public final void cKi() {
        AppMethodBeat.m2504i(4657);
        if (this.sNl.cIJ()) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.sNl.mStatus);
        }
        C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + C7574bs.dut());
        this.sNl.cIF();
        cKf();
        C1427q.m3050ku(C1720g.m3536RP().mo5240Rz().dur());
        AppMethodBeat.m2505o(4657);
    }

    /* renamed from: v */
    public final void mo9299v(int i, int i2, String str) {
        AppMethodBeat.m2504i(4658);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(i)));
        switch (i) {
            case 1:
                cKn();
                this.sNl.sPq.onError(i2, str);
                break;
            case 4:
                cKn();
                this.sNl.sPq.onReject();
                AppMethodBeat.m2505o(4658);
                return;
            case 5:
                cKn();
                this.sNl.sPq.cJA();
                AppMethodBeat.m2505o(4658);
                return;
            case 6:
                cKn();
                this.sNl.sPq.cJC();
                AppMethodBeat.m2505o(4658);
                return;
        }
        AppMethodBeat.m2505o(4658);
    }

    /* renamed from: dp */
    public final int mo9290dp(String str, int i) {
        AppMethodBeat.m2504i(4659);
        C4990ab.m7417i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", str, Integer.valueOf(0), Integer.valueOf(i));
        if (C5046bo.isNullOrNil(str)) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            AppMethodBeat.m2505o(4659);
            return -1;
        } else if (this.sNl.cIJ()) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            AppMethodBeat.m2505o(4659);
            return -1;
        } else {
            this.sNl.sPp.sTY = 1;
            this.sNl.sPp.nMl = str;
            C46317a.Logd("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + "call username:" + str);
            if (this.sNl.sPp.cKK()) {
                C46317a.Loge("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + "v2protocal already init.");
                this.sNl.sPp.mo63320mx(false);
                this.sNl.sPp.reset();
            }
            if (this.sNl.sPp.cEb() < 0) {
                C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.m2505o(4659);
                return -1;
            }
            if (this.sNl.sPp.sVI != null) {
                this.sNl.sPp.sVI.sNl = this.sNl;
            }
            if (v2protocal.sVJ != null) {
                v2protocal.sVJ.mo69420a(this.sNl);
            }
            this.sTu.mo16770ae(50000, 50000);
            this.sNl.sPp.nwx = (int) System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            new C24844g(arrayList, this.sNl.sPp.field_peerId, this.sNl.sPp.field_capInfo, this.sNl.sPp.netType, i, this.sNl.sPp.nwx).cKw();
            this.sNl.setStatus(2);
            this.sNl.sPr.kzf = 1;
            this.sTr.mo16770ae(60000, 60000);
            this.sNl.sPp.sVH.sQJ = System.currentTimeMillis();
            this.sNl.sPp.sVH.beginTime = System.currentTimeMillis();
            this.sNl.sPp.sVH.sQp = i;
            C4990ab.m7410d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.sNl.sPp.sVH.sQp);
            AppMethodBeat.m2505o(4659);
            return 0;
        }
    }

    public final int cKj() {
        int i = 2;
        AppMethodBeat.m2504i(4660);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.sNl.sPp.nwu);
        if (this.sNl.sPp.nwu == 0 && this.sNl.sPp.nwx == 0) {
            reset();
            AppMethodBeat.m2505o(4660);
            return -1;
        }
        this.sNl.sPp.sVH.sQe = this.sNl.cIH();
        this.sNl.sPp.sVH.sQq = 3;
        if (this.sNl.mStatus < 6) {
            this.sNl.sPp.sVH.sQs = 1;
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(C43727b.cIj().cJZ());
        objArr[1] = Long.valueOf(C43727b.cIj().cKa());
        objArr[2] = Long.valueOf(C43727b.cIj().cIK());
        if (this.sNl.mStatus != 5) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Long.valueOf(System.currentTimeMillis());
        objArr[5] = Long.valueOf(System.currentTimeMillis());
        c7060h.mo8377a(11521, true, true, objArr);
        i = cKk();
        AppMethodBeat.m2505o(4660);
        return i;
    }

    public final int cKk() {
        AppMethodBeat.m2504i(4661);
        if (this.sNl.cIJ()) {
            C4990ab.m7417i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", Integer.valueOf(this.sNl.sPp.nwu), Integer.valueOf(this.sNl.sPp.sTW), Integer.valueOf(this.sNl.sPp.nwx));
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0 && this.sNl.sPp.nwx == 0) {
                        C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    } else {
                        String mx;
                        if (this.sNl.sPp.cKK()) {
                            mx = this.sNl.sPp.mo63320mx(true);
                            if (mx.length() > 0) {
                                new C35353c(this.sNl.sPp.nwu, this.sNl.sPp.nwv, this.sNl.sPp.nMl, mx, this.sNl.sPp.nwx).cKw();
                            }
                        }
                        C46323n c46323n = this.sNl.sPp.sVH;
                        c46323n.sQz = (int) (System.currentTimeMillis() - c46323n.sQJ);
                        C46317a.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + c46323n.sQz);
                        if (this.sNl.sPp.sUo == 0 && this.sNl.sPp.sUp == 0) {
                            this.sNl.cIG();
                        }
                        this.sNl.mo26288Gf(this.sTj.cLN());
                        this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                        if (C43727b.cIj().sSQ != null) {
                            this.sNl.sPp.sVH.sQR = C43727b.cIj().sSQ.sRT;
                            this.sNl.sPp.sVH.sQP = C43727b.cIj().sSQ.sQP / 1000;
                            this.sNl.sPp.sVH.sQQ = C43727b.cIj().sSQ.sQQ / 1000;
                        }
                        String cKO = v2protocal.cKO();
                        String cKP = this.sNl.sPp.cKP();
                        String cKR = this.sNl.sPp.cKR();
                        String cKG = this.sNl.sPp.cKG();
                        mx = this.sNl.sPp.cKI();
                        String[] cKQ = this.sNl.sPp.cKQ();
                        if (cKP.length() > 0) {
                            new C24845l(cKO, cKP, cKG, cKR, mx, cKQ).cKw();
                        }
                        this.sNl.cIE();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        this.sNl.sPp.nwx = 0;
                        AppMethodBeat.m2505o(4661);
                        return 0;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(4661);
                }
            }
        } else {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
            AppMethodBeat.m2505o(4661);
            return -1;
        }
        return -1;
    }

    /* renamed from: a */
    public final boolean mo9276a(cpm cpm) {
        int i = true;
        AppMethodBeat.m2504i(4662);
        if (this.sNl.cIJ()) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.sNl.mStatus);
            AppMethodBeat.m2505o(4662);
            return false;
        } else if (cpm == null) {
            AppMethodBeat.m2505o(4662);
            return false;
        } else {
            this.sNl.sPp.sVH.sQp = cpm.xmL;
            C4990ab.m7410d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.sNl.sPp.sVH.sQp);
            if (this.sNl.sPp.cKK()) {
                C46317a.Logw("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + "v2protocal already init.");
                this.sNl.sPp.mo63320mx(false);
                this.sNl.sPp.reset();
            }
            this.sNl.mo26300a(cpm);
            if (C29488d.cLw() || C35973a.m59176Oo() || C29488d.cLz()) {
                C4990ab.m7412e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                if (C29488d.cLw()) {
                    C4286s.m6629a(cpm.wem, cpm.wen, 2, null, null, cpm.xmT);
                } else {
                    cKl();
                    if (cpm.xmL != 0) {
                        i = 0;
                    }
                    C14055q.m22208a(cpm.xmT, i != 0 ? C7620bi.xZc : C7620bi.xZb, 0, 6, C4996ah.getContext().getString(C25738R.string.f4_));
                }
                AppMethodBeat.m2505o(4662);
                return false;
            } else if (this.sNl.sPp.cEb() < 0) {
                C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.m2505o(4662);
                return false;
            } else {
                if (v2protocal.sVJ != null) {
                    v2protocal.sVJ.mo69420a(this.sNl);
                }
                C7060h.pYm.mo8377a(11524, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                this.sNl.sPq.cJy();
                AppMethodBeat.m2505o(4662);
                return true;
            }
        }
    }

    /* renamed from: R */
    public final int mo9275R(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4663);
        cKr();
        if (!this.sTv.doT()) {
            this.sTv.stopTimer();
        }
        this.sNl.sPp.sVH.cJd();
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(z)));
        if (!this.sNl.cII()) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.m2505o(4663);
            return -1;
        } else if (this.sNl.sPp.nwu == 0) {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            AppMethodBeat.m2505o(4663);
            return -1;
        } else {
            C46317a.Logd("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + "accept invite, roomid:" + this.sNl.sPp.nwu);
            this.sTu.mo16770ae(50000, 50000);
            this.sNl.sPp.sVH.cJe();
            new C35352b(1, this.sNl.sPp.netType, this.sNl.sPp.nwu, this.sNl.sPp.field_peerId, this.sNl.sPp.field_capInfo, this.sNl.sPp.nwv, z, z2).cKw();
            this.sNl.setStatus(4);
            this.sNl.sPr.kzf = 1;
            this.sNl.cJn = true;
            AppMethodBeat.m2505o(4663);
            return 0;
        }
    }

    public final int cKl() {
        AppMethodBeat.m2504i(4664);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.sNl.cII()) {
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0) {
                        C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    } else {
                        this.sNl.sPp.sVH.cJe();
                        C46317a.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.sNl.mStatus + " roomid:" + this.sNl.sPp.nwu);
                        new C35352b(2, this.sNl.sPp.netType, this.sNl.sPp.nwu, new byte[0], new byte[0], this.sNl.sPp.nwv, false, false).cKw();
                        if (this.sNl.sPp.sUo == 0 && this.sNl.sPp.sUp == 0) {
                            this.sNl.cIG();
                        }
                        this.sNl.mo26288Gf(this.sTj.cLN());
                        this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                        if (C43727b.cIj().sSQ != null) {
                            this.sNl.sPp.sVH.sQR = C43727b.cIj().sSQ.sRT;
                            this.sNl.sPp.sVH.sQP = C43727b.cIj().sSQ.sQP / 1000;
                            this.sNl.sPp.sVH.sQQ = C43727b.cIj().sSQ.sQQ / 1000;
                        }
                        if (this.sNl.sPp.cKK()) {
                            this.sNl.sPp.mo63320mx(true);
                        }
                        String cKO = v2protocal.cKO();
                        String cKP = this.sNl.sPp.cKP();
                        String cKR = this.sNl.sPp.cKR();
                        String cKG = this.sNl.sPp.cKG();
                        String cKI = this.sNl.sPp.cKI();
                        String[] cKQ = this.sNl.sPp.cKQ();
                        C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                        if (cKP.length() > 0) {
                            C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                            new C24845l(cKO, cKP, cKG, cKR, cKI, cKQ).cKw();
                        } else {
                            C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                        }
                        this.sNl.cIE();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        AppMethodBeat.m2505o(4664);
                        return 0;
                    }
                } finally {
                    AppMethodBeat.m2505o(4664);
                }
            }
        } else {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.m2505o(4664);
            return -1;
        }
        return -1;
    }

    public final int cKm() {
        AppMethodBeat.m2504i(4665);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (this.sNl.sPp.nwu == 0) {
            this.sNl.sPr.cIY();
            reset();
            AppMethodBeat.m2505o(4665);
            return 0;
        }
        this.sNl.sPp.sVH.sQe = this.sNl.cIH();
        int cKn = cKn();
        AppMethodBeat.m2505o(4665);
        return cKn;
    }

    public final int cKn() {
        AppMethodBeat.m2504i(4666);
        C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.sNl.mStatus + " roomid:" + this.sNl.sPp.nwu + ",threadid = " + Thread.currentThread().getId());
        this.sNl.sPr.cIY();
        if (this.sNl.sPp.sVH.sQo == (byte) 1) {
            C46323n c46323n = this.sNl.sPp.sVH;
            if (c46323n.sQF == 0) {
                c46323n.sQy = 0;
            } else {
                c46323n.sQy = (int) ((System.currentTimeMillis() - c46323n.sQF) / 1000);
            }
            if (c46323n.sQy < 0) {
                c46323n.sQy = 0;
                C46317a.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            C46317a.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + c46323n.sQy);
        }
        synchronized (this.sTi) {
            try {
                int i = this.sNl.sPp.sVH.sQq;
                if (this.sNl.sPp.nwu != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                    this.sNl.sPq.cJD();
                    C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                    if (this.sNl.sPp.cKK()) {
                        String mx = this.sNl.sPp.mo63320mx(true);
                        if (mx.length() > 0) {
                            new C40028i(this.sNl.sPp.nwu, this.sNl.sPp.nwv, mx).cKw();
                            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                        }
                    }
                    this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                    if (C43727b.cIj().sSQ != null) {
                        this.sNl.sPp.sVH.sQR = C43727b.cIj().sSQ.sRT;
                        this.sNl.sPp.sVH.sQP = C43727b.cIj().sSQ.sQP / 1000;
                        this.sNl.sPp.sVH.sQQ = C43727b.cIj().sSQ.sQQ / 1000;
                    }
                    this.sNl.mo26288Gf(this.sTj.cLN());
                    String cKO = v2protocal.cKO();
                    String cKP = this.sNl.sPp.cKP();
                    String cKR = this.sNl.sPp.cKR();
                    String cKG = this.sNl.sPp.cKG();
                    String cKI = this.sNl.sPp.cKI();
                    String[] cKQ = this.sNl.sPp.cKQ();
                    if (cKP.length() > 0) {
                        new C24845l(cKO, cKP, cKG, cKR, cKI, cKQ).cKw();
                        C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                    }
                } else {
                    C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
                }
                this.sNl.cIE();
                reset();
                this.sNl.sPp.nwu = 0;
                C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
            } finally {
                AppMethodBeat.m2505o(4666);
            }
        }
        return 0;
    }

    public final int cKo() {
        AppMethodBeat.m2504i(4667);
        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.sNl.cII()) {
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0) {
                        C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    } else {
                        new C35352b(3, this.sNl.sPp.netType, this.sNl.sPp.nwu, new byte[0], new byte[0], this.sNl.sPp.nwv, false, false).cKw();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        AppMethodBeat.m2505o(4667);
                        return 0;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(4667);
                }
            }
        } else {
            C46317a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.m2505o(4667);
            return -1;
        }
        return -1;
    }

    /* renamed from: a */
    public static void m6629a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        AppMethodBeat.m2504i(4668);
        C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (!(i == 0 || j == 0)) {
            new C35349a(i, j, i2, bArr, bArr2, str).cKw();
        }
        AppMethodBeat.m2505o(4668);
    }

    public final int setNetSignalValue(int i, int i2) {
        AppMethodBeat.m2504i(4669);
        int netSignalValue = this.sNl.sPp.setNetSignalValue(i, i2);
        AppMethodBeat.m2505o(4669);
        return netSignalValue;
    }

    /* renamed from: Gh */
    public final void mo9271Gh(int i) {
        AppMethodBeat.m2504i(4670);
        this.sNl.mo26290Gh(i);
        AppMethodBeat.m2505o(4670);
    }

    public final int cIt() {
        AppMethodBeat.m2504i(139156);
        int cIt = this.sNl.cIt();
        AppMethodBeat.m2505o(139156);
        return cIt;
    }

    /* renamed from: mj */
    public final boolean mo9292mj(boolean z) {
        AppMethodBeat.m2504i(4672);
        boolean mj = this.sNl.sPr.mo63264mj(z);
        AppMethodBeat.m2505o(4672);
        return mj;
    }

    /* renamed from: mo */
    public final int mo9293mo(boolean z) {
        AppMethodBeat.m2504i(4673);
        int mo = this.sNl.mo26324mo(z);
        AppMethodBeat.m2505o(4673);
        return mo;
    }

    /* renamed from: mp */
    public final int mo9294mp(boolean z) {
        AppMethodBeat.m2504i(4674);
        int mp = this.sNl.mo26325mp(z);
        AppMethodBeat.m2505o(4674);
        return mp;
    }

    /* renamed from: Gx */
    public final void mo9273Gx(int i) {
        AppMethodBeat.m2504i(4675);
        if (this.sTj != null) {
            this.sTj.mo38020Gx(i);
        }
        AppMethodBeat.m2505o(4675);
    }

    public final void cKp() {
        AppMethodBeat.m2504i(4676);
        if (this.sTj != null) {
            this.sTj.mo38026r(C1318a.voip_bad_netstatus_hint, 0, false);
        }
        AppMethodBeat.m2505o(4676);
    }

    public final void stopRing() {
        AppMethodBeat.m2504i(4677);
        if (this.sTj != null) {
            this.sTj.stop();
        }
        AppMethodBeat.m2505o(4677);
    }

    public final boolean cKq() {
        AppMethodBeat.m2504i(4678);
        if (this.sTj != null) {
            boolean DB = this.sTj.mo38019DB();
            AppMethodBeat.m2505o(4678);
            return DB;
        }
        AppMethodBeat.m2505o(4678);
        return true;
    }

    /* renamed from: Gy */
    public final void mo9274Gy(int i) {
        AppMethodBeat.m2504i(4679);
        this.sTk = i;
        if (!this.sTv.doT()) {
            this.sTv.stopTimer();
        }
        this.sTv.mo16770ae(70000, 70000);
        AppMethodBeat.m2505o(4679);
    }

    public final void cKr() {
        AppMethodBeat.m2504i(4680);
        C46317a.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.sTr.stopTimer();
        this.sTr.mo16770ae(60000, 60000);
        AppMethodBeat.m2505o(4680);
    }
}
