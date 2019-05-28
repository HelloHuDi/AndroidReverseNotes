package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.a.c;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.plugin.voip.model.a.l;
import com.tencent.mm.plugin.voip.model.k.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bs;
import java.util.ArrayList;
import java.util.Timer;

public final class s implements a {
    private static int hGc = -1;
    private static int sTl = -1;
    static int sTm = 20;
    WifiManager bJj;
    public k sNl = l.cIW();
    private Object sTi = new Object();
    i sTj;
    private int sTk = 0;
    public String sTn;
    int sTo;
    Timer sTp = null;
    WifiInfo sTq;
    private ap sTr = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(4643);
            if (s.this.sNl.sPp.sTY == 1) {
                int i;
                k kVar = s.this.sNl;
                if (kVar.mStatus == 2 || kVar.mStatus == 4) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                    s.this.sNl.sPp.sVH.sQe = 101;
                    h.pYm.e(11521, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                    s.this.cKk();
                    s.this.sNl.sPq.cJA();
                }
            }
            AppMethodBeat.o(4643);
            return false;
        }
    }, false);
    private byte[] sTs = new byte[500];
    ap sTt = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(4644);
            k kVar = s.this.sNl;
            kVar.sPx++;
            if (s.this.sNl.sPp.nwu == 0) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", g.Mq() + "double link switch roomId == 0 ");
                s.this.sTt.stopTimer();
            } else {
                s.this.sNl.sPp.app2EngineDataEx(s.this.sNl.sPp.sVc, s.this.sNl.sPp.sVd, s.this.sNl.sPp.sVe, 0, 0);
                if (!s.this.sNl.sPw && 1 == s.this.sNl.sPp.field_mGetValidSample) {
                    s.this.sNl.sPw = true;
                    s.this.sNl.sPy = s.this.sNl.sPx;
                }
                if (1 == s.this.sNl.sPc) {
                    s.this.sNl.sPc = 15;
                }
                if (true == s.this.sNl.sPw && s.this.sNl.sPx - s.this.sNl.sPy == s.this.sNl.sPc && (s.this.sNl.sPp.sUT & 1) == 0) {
                    s.this.sNl.sPy = s.this.sNl.sPx;
                    int isDCSameLan = s.this.sNl.sPp.isDCSameLan();
                    int currentConnType = s.this.sNl.sPp.getCurrentConnType();
                    if (1 == isDCSameLan && 1 == currentConnType) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(isDCSameLan)));
                        kVar = s.this.sNl;
                        kVar.sPx++;
                        AppMethodBeat.o(4644);
                        return true;
                    }
                    int i = s.this.sNl.sPp.getcurstrategy();
                    int isRelayConnReady = s.this.sNl.sPp.isRelayConnReady();
                    int isDCReady = s.this.sNl.sPp.isDCReady();
                    isDCSameLan = s.this.sNl.sPc - 3;
                    if (isDCSameLan > 15) {
                        isDCSameLan = 15;
                    }
                    s.this.sNl.sPp.app2EngineLinkQualityEx(isDCSameLan, s.this.sTs);
                    new d(s.this.sNl.sPp.nwu, s.this.sNl.sPp.nwv, s.this.sNl.sPp.nwC, currentConnType, isRelayConnReady, isDCReady, i, s.this.sTs, s.this.sNl.sPp.field_realLinkQualityInfoBuffLen).cKw();
                    v2protocal v2protocal = s.this.sNl.sPp;
                    v2protocal.sUV++;
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + s.this.sNl.sPc + " isFirstValidSampleSet " + s.this.sNl.sPw + " mGetValidSample " + s.this.sNl.sPp.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + s.this.sNl.sPp.sUV + "mTimerCounter " + s.this.sNl.sPx + "mLastSwitchTimer " + s.this.sNl.sPy);
                }
            }
            AppMethodBeat.o(4644);
            return true;
        }
    }, true);
    private ap sTu = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(4645);
            if (s.this.sNl.sPp.nwu == 0) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", g.Mq() + " roomId == 0 ");
                s.this.sTu.stopTimer();
            } else {
                boolean z;
                if (s.this.sNl.mStatus >= 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    new f(s.this.sNl.sPp.nwu, s.this.sNl.sPp.nwv, s.this.sNl.sPC).cKw();
                }
            }
            AppMethodBeat.o(4645);
            return true;
        }
    }, true);
    private ap sTv = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(4646);
            ab.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
            if (3 == s.this.sNl.mStatus && s.this.sTk != 0 && s.this.sTk == s.this.sNl.sPp.nwu) {
                s.this.sTk = 0;
                s.this.sNl.v(5, -9000, "");
            }
            AppMethodBeat.o(4646);
            return false;
        }
    }, true);

    /* renamed from: com.tencent.mm.plugin.voip.model.s$5 */
    class AnonymousClass5 extends PhoneStateListener {
        final /* synthetic */ TelephonyManager sTx;

        AnonymousClass5(TelephonyManager telephonyManager) {
            this.sTx = telephonyManager;
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int i = 100;
            AppMethodBeat.i(4647);
            super.onSignalStrengthsChanged(signalStrength);
            String[] split = signalStrength.toString().split(" ");
            if (this.sTx.getNetworkType() == 13) {
                if (split != null && split.length >= 10) {
                    s.sTl = bo.getInt(split[9], -141) + 140;
                }
                s.this.sTn = "LTE";
            } else {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if (signalStrength.isGsm() && gsmSignalStrength == 99) {
                    s.sTl = -1;
                } else {
                    s.sTl = (int) (((float) gsmSignalStrength) * 3.2258065f);
                }
            }
            if (s.sTl <= 100) {
                i = s.sTl;
            }
            s.sTl = i;
            s.sTl = s.sTl < 0 ? 0 : s.sTl;
            s.this.sTo = s.this.sTo + 1;
            AppMethodBeat.o(4647);
        }
    }

    public s() {
        AppMethodBeat.i(4649);
        this.sNl.a((a) this);
        this.sTj = new i(ah.getContext());
        AppMethodBeat.o(4649);
    }

    public final void stop() {
        AppMethodBeat.i(4650);
        ab.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.sNl.a(null);
        AppMethodBeat.o(4650);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(4651);
        stop();
        super.finalize();
        AppMethodBeat.o(4651);
    }

    public final void reset() {
        AppMethodBeat.i(4652);
        ab.d("MicroMsg.Voip.VoipServiceEx", "reset");
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
        b.cIj().sRK = null;
        AppMethodBeat.o(4652);
    }

    private void cKf() {
        AppMethodBeat.i(4653);
        ab.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.sTu.stopTimer();
        this.sTr.stopTimer();
        this.sTt.stopTimer();
        this.sTv.stopTimer();
        this.sTk = 0;
        AppMethodBeat.o(4653);
    }

    public final void Gw(int i) {
        AppMethodBeat.i(4654);
        this.sNl.Gd(i);
        AppMethodBeat.o(4654);
    }

    public final boolean cKg() {
        return this.sNl.sPp.nwu != 0;
    }

    public final boolean cIJ() {
        AppMethodBeat.i(4655);
        if (this.sNl.cIJ()) {
            AppMethodBeat.o(4655);
            return true;
        }
        AppMethodBeat.o(4655);
        return false;
    }

    public static boolean cKh() {
        AppMethodBeat.i(4656);
        if (((TelephonyManager) ah.getContext().getSystemService("phone")).getCallState() != 0) {
            AppMethodBeat.o(4656);
            return true;
        }
        AppMethodBeat.o(4656);
        return false;
    }

    public final void cKi() {
        AppMethodBeat.i(4657);
        if (this.sNl.cIJ()) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.sNl.mStatus);
        }
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + bs.dut());
        this.sNl.cIF();
        cKf();
        q.ku(com.tencent.mm.kernel.g.RP().Rz().dur());
        AppMethodBeat.o(4657);
    }

    public final void v(int i, int i2, String str) {
        AppMethodBeat.i(4658);
        ab.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(i)));
        switch (i) {
            case 1:
                cKn();
                this.sNl.sPq.onError(i2, str);
                break;
            case 4:
                cKn();
                this.sNl.sPq.onReject();
                AppMethodBeat.o(4658);
                return;
            case 5:
                cKn();
                this.sNl.sPq.cJA();
                AppMethodBeat.o(4658);
                return;
            case 6:
                cKn();
                this.sNl.sPq.cJC();
                AppMethodBeat.o(4658);
                return;
        }
        AppMethodBeat.o(4658);
    }

    public final int dp(String str, int i) {
        AppMethodBeat.i(4659);
        ab.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", str, Integer.valueOf(0), Integer.valueOf(i));
        if (bo.isNullOrNil(str)) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            AppMethodBeat.o(4659);
            return -1;
        } else if (this.sNl.cIJ()) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            AppMethodBeat.o(4659);
            return -1;
        } else {
            this.sNl.sPp.sTY = 1;
            this.sNl.sPp.nMl = str;
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", g.Mq() + "call username:" + str);
            if (this.sNl.sPp.cKK()) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", g.Mq() + "v2protocal already init.");
                this.sNl.sPp.mx(false);
                this.sNl.sPp.reset();
            }
            if (this.sNl.sPp.cEb() < 0) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.o(4659);
                return -1;
            }
            if (this.sNl.sPp.sVI != null) {
                this.sNl.sPp.sVI.sNl = this.sNl;
            }
            if (v2protocal.sVJ != null) {
                v2protocal.sVJ.a(this.sNl);
            }
            this.sTu.ae(50000, 50000);
            this.sNl.sPp.nwx = (int) System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.sNl.sPp.field_peerId, this.sNl.sPp.field_capInfo, this.sNl.sPp.netType, i, this.sNl.sPp.nwx).cKw();
            this.sNl.setStatus(2);
            this.sNl.sPr.kzf = 1;
            this.sTr.ae(60000, 60000);
            this.sNl.sPp.sVH.sQJ = System.currentTimeMillis();
            this.sNl.sPp.sVH.beginTime = System.currentTimeMillis();
            this.sNl.sPp.sVH.sQp = i;
            ab.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.sNl.sPp.sVH.sQp);
            AppMethodBeat.o(4659);
            return 0;
        }
    }

    public final int cKj() {
        int i = 2;
        AppMethodBeat.i(4660);
        ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.sNl.sPp.nwu);
        if (this.sNl.sPp.nwu == 0 && this.sNl.sPp.nwx == 0) {
            reset();
            AppMethodBeat.o(4660);
            return -1;
        }
        this.sNl.sPp.sVH.sQe = this.sNl.cIH();
        this.sNl.sPp.sVH.sQq = 3;
        if (this.sNl.mStatus < 6) {
            this.sNl.sPp.sVH.sQs = 1;
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(b.cIj().cJZ());
        objArr[1] = Long.valueOf(b.cIj().cKa());
        objArr[2] = Long.valueOf(b.cIj().cIK());
        if (this.sNl.mStatus != 5) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Long.valueOf(System.currentTimeMillis());
        objArr[5] = Long.valueOf(System.currentTimeMillis());
        hVar.a(11521, true, true, objArr);
        i = cKk();
        AppMethodBeat.o(4660);
        return i;
    }

    public final int cKk() {
        AppMethodBeat.i(4661);
        if (this.sNl.cIJ()) {
            ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", Integer.valueOf(this.sNl.sPp.nwu), Integer.valueOf(this.sNl.sPp.sTW), Integer.valueOf(this.sNl.sPp.nwx));
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0 && this.sNl.sPp.nwx == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    } else {
                        String mx;
                        if (this.sNl.sPp.cKK()) {
                            mx = this.sNl.sPp.mx(true);
                            if (mx.length() > 0) {
                                new c(this.sNl.sPp.nwu, this.sNl.sPp.nwv, this.sNl.sPp.nMl, mx, this.sNl.sPp.nwx).cKw();
                            }
                        }
                        n nVar = this.sNl.sPp.sVH;
                        nVar.sQz = (int) (System.currentTimeMillis() - nVar.sQJ);
                        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + nVar.sQz);
                        if (this.sNl.sPp.sUo == 0 && this.sNl.sPp.sUp == 0) {
                            this.sNl.cIG();
                        }
                        this.sNl.Gf(this.sTj.cLN());
                        this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                        if (b.cIj().sSQ != null) {
                            this.sNl.sPp.sVH.sQR = b.cIj().sSQ.sRT;
                            this.sNl.sPp.sVH.sQP = b.cIj().sSQ.sQP / 1000;
                            this.sNl.sPp.sVH.sQQ = b.cIj().sSQ.sQQ / 1000;
                        }
                        String cKO = v2protocal.cKO();
                        String cKP = this.sNl.sPp.cKP();
                        String cKR = this.sNl.sPp.cKR();
                        String cKG = this.sNl.sPp.cKG();
                        mx = this.sNl.sPp.cKI();
                        String[] cKQ = this.sNl.sPp.cKQ();
                        if (cKP.length() > 0) {
                            new l(cKO, cKP, cKG, cKR, mx, cKQ).cKw();
                        }
                        this.sNl.cIE();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        this.sNl.sPp.nwx = 0;
                        AppMethodBeat.o(4661);
                        return 0;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(4661);
                }
            }
        } else {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
            AppMethodBeat.o(4661);
            return -1;
        }
        return -1;
    }

    public final boolean a(cpm cpm) {
        int i = true;
        AppMethodBeat.i(4662);
        if (this.sNl.cIJ()) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.sNl.mStatus);
            AppMethodBeat.o(4662);
            return false;
        } else if (cpm == null) {
            AppMethodBeat.o(4662);
            return false;
        } else {
            this.sNl.sPp.sVH.sQp = cpm.xmL;
            ab.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.sNl.sPp.sVH.sQp);
            if (this.sNl.sPp.cKK()) {
                com.tencent.mm.plugin.voip.a.a.Logw("MicroMsg.Voip.VoipServiceEx", g.Mq() + "v2protocal already init.");
                this.sNl.sPp.mx(false);
                this.sNl.sPp.reset();
            }
            this.sNl.a(cpm);
            if (com.tencent.mm.plugin.voip.a.d.cLw() || com.tencent.mm.r.a.Oo() || com.tencent.mm.plugin.voip.a.d.cLz()) {
                ab.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                if (com.tencent.mm.plugin.voip.a.d.cLw()) {
                    a(cpm.wem, cpm.wen, 2, null, null, cpm.xmT);
                } else {
                    cKl();
                    if (cpm.xmL != 0) {
                        i = 0;
                    }
                    q.a(cpm.xmT, i != 0 ? bi.xZc : bi.xZb, 0, 6, ah.getContext().getString(R.string.f4_));
                }
                AppMethodBeat.o(4662);
                return false;
            } else if (this.sNl.sPp.cEb() < 0) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.o(4662);
                return false;
            } else {
                if (v2protocal.sVJ != null) {
                    v2protocal.sVJ.a(this.sNl);
                }
                h.pYm.a(11524, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                this.sNl.sPq.cJy();
                AppMethodBeat.o(4662);
                return true;
            }
        }
    }

    public final int R(boolean z, boolean z2) {
        AppMethodBeat.i(4663);
        cKr();
        if (!this.sTv.doT()) {
            this.sTv.stopTimer();
        }
        this.sNl.sPp.sVH.cJd();
        ab.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(z)));
        if (!this.sNl.cII()) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.o(4663);
            return -1;
        } else if (this.sNl.sPp.nwu == 0) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            AppMethodBeat.o(4663);
            return -1;
        } else {
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", g.Mq() + "accept invite, roomid:" + this.sNl.sPp.nwu);
            this.sTu.ae(50000, 50000);
            this.sNl.sPp.sVH.cJe();
            new com.tencent.mm.plugin.voip.model.a.b(1, this.sNl.sPp.netType, this.sNl.sPp.nwu, this.sNl.sPp.field_peerId, this.sNl.sPp.field_capInfo, this.sNl.sPp.nwv, z, z2).cKw();
            this.sNl.setStatus(4);
            this.sNl.sPr.kzf = 1;
            this.sNl.cJn = true;
            AppMethodBeat.o(4663);
            return 0;
        }
    }

    public final int cKl() {
        AppMethodBeat.i(4664);
        ab.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.sNl.cII()) {
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    } else {
                        this.sNl.sPp.sVH.cJe();
                        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.sNl.mStatus + " roomid:" + this.sNl.sPp.nwu);
                        new com.tencent.mm.plugin.voip.model.a.b(2, this.sNl.sPp.netType, this.sNl.sPp.nwu, new byte[0], new byte[0], this.sNl.sPp.nwv, false, false).cKw();
                        if (this.sNl.sPp.sUo == 0 && this.sNl.sPp.sUp == 0) {
                            this.sNl.cIG();
                        }
                        this.sNl.Gf(this.sTj.cLN());
                        this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                        if (b.cIj().sSQ != null) {
                            this.sNl.sPp.sVH.sQR = b.cIj().sSQ.sRT;
                            this.sNl.sPp.sVH.sQP = b.cIj().sSQ.sQP / 1000;
                            this.sNl.sPp.sVH.sQQ = b.cIj().sSQ.sQQ / 1000;
                        }
                        if (this.sNl.sPp.cKK()) {
                            this.sNl.sPp.mx(true);
                        }
                        String cKO = v2protocal.cKO();
                        String cKP = this.sNl.sPp.cKP();
                        String cKR = this.sNl.sPp.cKR();
                        String cKG = this.sNl.sPp.cKG();
                        String cKI = this.sNl.sPp.cKI();
                        String[] cKQ = this.sNl.sPp.cKQ();
                        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                        if (cKP.length() > 0) {
                            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                            new l(cKO, cKP, cKG, cKR, cKI, cKQ).cKw();
                        } else {
                            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                        }
                        this.sNl.cIE();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        AppMethodBeat.o(4664);
                        return 0;
                    }
                } finally {
                    AppMethodBeat.o(4664);
                }
            }
        } else {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.o(4664);
            return -1;
        }
        return -1;
    }

    public final int cKm() {
        AppMethodBeat.i(4665);
        ab.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (this.sNl.sPp.nwu == 0) {
            this.sNl.sPr.cIY();
            reset();
            AppMethodBeat.o(4665);
            return 0;
        }
        this.sNl.sPp.sVH.sQe = this.sNl.cIH();
        int cKn = cKn();
        AppMethodBeat.o(4665);
        return cKn;
    }

    public final int cKn() {
        AppMethodBeat.i(4666);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.sNl.mStatus + " roomid:" + this.sNl.sPp.nwu + ",threadid = " + Thread.currentThread().getId());
        this.sNl.sPr.cIY();
        if (this.sNl.sPp.sVH.sQo == (byte) 1) {
            n nVar = this.sNl.sPp.sVH;
            if (nVar.sQF == 0) {
                nVar.sQy = 0;
            } else {
                nVar.sQy = (int) ((System.currentTimeMillis() - nVar.sQF) / 1000);
            }
            if (nVar.sQy < 0) {
                nVar.sQy = 0;
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + nVar.sQy);
        }
        synchronized (this.sTi) {
            try {
                int i = this.sNl.sPp.sVH.sQq;
                if (this.sNl.sPp.nwu != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                    this.sNl.sPq.cJD();
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                    if (this.sNl.sPp.cKK()) {
                        String mx = this.sNl.sPp.mx(true);
                        if (mx.length() > 0) {
                            new com.tencent.mm.plugin.voip.model.a.i(this.sNl.sPp.nwu, this.sNl.sPp.nwv, mx).cKw();
                            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                        }
                    }
                    this.sNl.sPp.sVH.sQO = this.sNl.sPq.cJG();
                    if (b.cIj().sSQ != null) {
                        this.sNl.sPp.sVH.sQR = b.cIj().sSQ.sRT;
                        this.sNl.sPp.sVH.sQP = b.cIj().sSQ.sQP / 1000;
                        this.sNl.sPp.sVH.sQQ = b.cIj().sSQ.sQQ / 1000;
                    }
                    this.sNl.Gf(this.sTj.cLN());
                    String cKO = v2protocal.cKO();
                    String cKP = this.sNl.sPp.cKP();
                    String cKR = this.sNl.sPp.cKR();
                    String cKG = this.sNl.sPp.cKG();
                    String cKI = this.sNl.sPp.cKI();
                    String[] cKQ = this.sNl.sPp.cKQ();
                    if (cKP.length() > 0) {
                        new l(cKO, cKP, cKG, cKR, cKI, cKQ).cKw();
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                    }
                } else {
                    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
                }
                this.sNl.cIE();
                reset();
                this.sNl.sPp.nwu = 0;
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
            } finally {
                AppMethodBeat.o(4666);
            }
        }
        return 0;
    }

    public final int cKo() {
        AppMethodBeat.i(4667);
        ab.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.sNl.cII()) {
            synchronized (this.sTi) {
                try {
                    if (this.sNl.sPp.nwu == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    } else {
                        new com.tencent.mm.plugin.voip.model.a.b(3, this.sNl.sPp.netType, this.sNl.sPp.nwu, new byte[0], new byte[0], this.sNl.sPp.nwv, false, false).cKw();
                        reset();
                        this.sNl.sPp.nwu = 0;
                        AppMethodBeat.o(4667);
                        return 0;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(4667);
                }
            }
        } else {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.sNl.mStatus);
            AppMethodBeat.o(4667);
            return -1;
        }
        return -1;
    }

    public static void a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        AppMethodBeat.i(4668);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (!(i == 0 || j == 0)) {
            new com.tencent.mm.plugin.voip.model.a.a(i, j, i2, bArr, bArr2, str).cKw();
        }
        AppMethodBeat.o(4668);
    }

    public final int setNetSignalValue(int i, int i2) {
        AppMethodBeat.i(4669);
        int netSignalValue = this.sNl.sPp.setNetSignalValue(i, i2);
        AppMethodBeat.o(4669);
        return netSignalValue;
    }

    public final void Gh(int i) {
        AppMethodBeat.i(4670);
        this.sNl.Gh(i);
        AppMethodBeat.o(4670);
    }

    public final int cIt() {
        AppMethodBeat.i(139156);
        int cIt = this.sNl.cIt();
        AppMethodBeat.o(139156);
        return cIt;
    }

    public final boolean mj(boolean z) {
        AppMethodBeat.i(4672);
        boolean mj = this.sNl.sPr.mj(z);
        AppMethodBeat.o(4672);
        return mj;
    }

    public final int mo(boolean z) {
        AppMethodBeat.i(4673);
        int mo = this.sNl.mo(z);
        AppMethodBeat.o(4673);
        return mo;
    }

    public final int mp(boolean z) {
        AppMethodBeat.i(4674);
        int mp = this.sNl.mp(z);
        AppMethodBeat.o(4674);
        return mp;
    }

    public final void Gx(int i) {
        AppMethodBeat.i(4675);
        if (this.sTj != null) {
            this.sTj.Gx(i);
        }
        AppMethodBeat.o(4675);
    }

    public final void cKp() {
        AppMethodBeat.i(4676);
        if (this.sTj != null) {
            this.sTj.r(R.raw.voip_bad_netstatus_hint, 0, false);
        }
        AppMethodBeat.o(4676);
    }

    public final void stopRing() {
        AppMethodBeat.i(4677);
        if (this.sTj != null) {
            this.sTj.stop();
        }
        AppMethodBeat.o(4677);
    }

    public final boolean cKq() {
        AppMethodBeat.i(4678);
        if (this.sTj != null) {
            boolean DB = this.sTj.DB();
            AppMethodBeat.o(4678);
            return DB;
        }
        AppMethodBeat.o(4678);
        return true;
    }

    public final void Gy(int i) {
        AppMethodBeat.i(4679);
        this.sTk = i;
        if (!this.sTv.doT()) {
            this.sTv.stopTimer();
        }
        this.sTv.ae(70000, 70000);
        AppMethodBeat.o(4679);
    }

    public final void cKr() {
        AppMethodBeat.i(4680);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.sTr.stopTimer();
        this.sTr.ae(60000, 60000);
        AppMethodBeat.o(4680);
    }
}
