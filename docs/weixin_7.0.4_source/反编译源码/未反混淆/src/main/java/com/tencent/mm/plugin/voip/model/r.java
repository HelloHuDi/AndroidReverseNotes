package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.bt.b;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass14;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class r {
    private static final f<Integer, com.tencent.mm.plugin.voip.model.o.a> emX = new c(5);
    public boolean con;
    public ap oGx;
    private n qbK;
    public String sRK;
    public s sSP;
    public VoipMgr sSQ;
    public boolean sSR;
    public boolean sSS;
    private long sST;
    public Map<Integer, Long> sSU;
    public int sSV;
    public long sSW;
    public long sSX;
    public Point sSY;
    public boolean sSZ;
    public boolean sTa;
    public boolean sTb;
    public cpm sTc;
    public long sTd;
    public boolean sTe;
    List<a> sTf;
    public String talker;

    public class a {
        boolean cancelled;
        cpm sTh;
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.r$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String val$tips;

        AnonymousClass4(String str) {
            this.val$tips = str;
        }

        public final void run() {
            AppMethodBeat.i(4604);
            if (r.this.sSQ != null) {
                VoipMgr voipMgr = r.this.sSQ;
                String str = this.val$tips;
                if (voipMgr.sRe != null) {
                    voipMgr.sRK = str;
                    voipMgr.sRe.abY(str);
                }
            }
            AppMethodBeat.o(4604);
        }
    }

    static /* synthetic */ boolean fc(Context context) {
        AppMethodBeat.i(4641);
        boolean eA = eA(context);
        AppMethodBeat.o(4641);
        return eA;
    }

    public r() {
        AppMethodBeat.i(4605);
        this.con = false;
        this.sSR = false;
        this.sSS = false;
        this.talker = null;
        this.sST = 0;
        this.sSU = new HashMap();
        this.sSV = -1;
        this.sSW = 0;
        this.sSX = 0;
        this.sSZ = false;
        this.sTa = false;
        this.sTb = false;
        this.sTc = null;
        this.sTd = 0;
        this.sRK = null;
        this.sTe = false;
        this.qbK = new com.tencent.mm.network.n.a() {
            public final void gl(int i) {
                AppMethodBeat.i(4601);
                ab.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(i)));
                if (r.this.con && i == 4) {
                    k kVar = r.this.sSP.sNl;
                    if (kVar.sPz == 0) {
                        kVar.sPz = kVar.sPp.sTX;
                    }
                    int netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
                    if (netType != kVar.sPz) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + kVar.sPz + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = kVar.sPp.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + kVar.sPp.nwC + ", roomkey=" + kVar.sPp.nwv + "]");
                            }
                            cmm cmm = new cmm();
                            cmm.xko = 3;
                            cmm.xkp = new b(bArr, 0, 1);
                            kVar.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        kVar.sPz = netType;
                    }
                    s sVar = r.this.sSP;
                    new h(sVar.sNl.sPp.nwu, sVar.sNl.sPp.nwv, sVar.sNl.sPp.nwC, 0, 0, null).cKw();
                }
                AppMethodBeat.o(4601);
            }
        };
        this.oGx = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(4603);
                ab.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
                if (r.this.sTc == null) {
                    r.this.sTd = 0;
                    r.this.oGx.stopTimer();
                    AppMethodBeat.o(4603);
                    return false;
                } else if (r.fc(ah.getContext())) {
                    r.this.ad(r.this.sTc.wem, r.this.sTc.wen);
                    r.this.b(r.this.sTc);
                    r.this.sTc = null;
                    r.this.sTd = 0;
                    r.this.oGx.stopTimer();
                    com.tencent.mm.plugin.report.service.h.pYm.a(500, 5, 1, false);
                    AppMethodBeat.o(4603);
                    return false;
                } else if (System.currentTimeMillis() - r.this.sTd < 60000) {
                    AppMethodBeat.o(4603);
                    return true;
                } else {
                    r.this.sTc = null;
                    r.this.sTd = 0;
                    r.this.oGx.stopTimer();
                    AppMethodBeat.o(4603);
                    return false;
                }
            }
        }, true);
        this.sTf = null;
        this.sSP = new s();
        this.con = false;
        this.sSR = false;
        this.sSS = false;
        this.talker = null;
        this.sRK = null;
        g.RO().a(this.qbK);
        AppMethodBeat.o(4605);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(4606);
        this.sSP.stop();
        this.sSP = null;
        g.RO().b(this.qbK);
        super.finalize();
        AppMethodBeat.o(4606);
    }

    public final void b(boolean z, boolean z2, String str) {
        AppMethodBeat.i(4607);
        ab.i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2 + "username " + str);
        this.con = z;
        if (z2) {
            this.sSR = z;
            this.sSP.sNl.sPp.sUl = 0;
        } else {
            this.sSP.sNl.sPp.sUl = 1;
            this.sSS = z;
        }
        this.talker = str;
        this.sSP.sNl.sPp.sVH.gfj = str;
        AppMethodBeat.o(4607);
    }

    public final void Q(boolean z, boolean z2) {
        AppMethodBeat.i(4608);
        this.sTa = z;
        this.sTb = z2;
        ab.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(4608);
    }

    public final void ba(Context context, String str) {
        AppMethodBeat.i(4609);
        ab.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str) || (System.currentTimeMillis() - this.sST < FaceGestureDetGLThread.BRIGHTNESS_DURATION && System.currentTimeMillis() - this.sST > 0)) {
            AppMethodBeat.o(4609);
        } else if (System.currentTimeMillis() - this.sSW >= this.sSX || System.currentTimeMillis() - this.sSW <= 0) {
            this.sST = System.currentTimeMillis();
            if (((j) g.K(j.class)).XM().aoO(str) == null) {
                AppMethodBeat.o(4609);
                return;
            }
            a(context, str, true, false, false);
            cJY();
            AppMethodBeat.o(4609);
        } else {
            ab.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f6x, (int) R.string.f7t, null);
            AppMethodBeat.o(4609);
        }
    }

    public final void bb(Context context, String str) {
        AppMethodBeat.i(4610);
        ab.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str) || (System.currentTimeMillis() - this.sST < FaceGestureDetGLThread.BRIGHTNESS_DURATION && System.currentTimeMillis() - this.sST > 0)) {
            AppMethodBeat.o(4610);
        } else if (System.currentTimeMillis() - this.sSW >= this.sSX || System.currentTimeMillis() - this.sSW <= 0) {
            this.sST = System.currentTimeMillis();
            if (((j) g.K(j.class)).XM().aoO(str) == null) {
                AppMethodBeat.o(4610);
                return;
            }
            a(context, str, true, true, false);
            cJY();
            AppMethodBeat.o(4610);
        } else {
            ab.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f6x, (int) R.string.f7t, null);
            AppMethodBeat.o(4610);
        }
    }

    private static void cJY() {
        AppMethodBeat.i(4611);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 7;
        com.tencent.mm.sdk.b.a.xxA.m(uiVar);
        AppMethodBeat.o(4611);
    }

    public final void ad(final int i, final long j) {
        AppMethodBeat.i(4612);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4602);
                ab.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", Integer.valueOf(i), Long.valueOf(j));
                if (!com.tencent.mm.m.a.ME() && !r.fc(ah.getContext())) {
                    ab.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                    AppMethodBeat.o(4602);
                } else if (r.this.sSP.cKg()) {
                    ab.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
                    if (!(r.this.sSP.sNl.sPp.nwu == i || r.this.sSP.sNl.sPp.nwv == j)) {
                        ab.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r.this.sSP.sNl.sPp.nwu), Long.valueOf(r.this.sSP.sNl.sPp.nwv));
                        s.a(i, j, 2, null, null, r.this.talker);
                    }
                    AppMethodBeat.o(4602);
                } else {
                    new e(i, j, "").cKw();
                    if (!r.this.sTe) {
                        com.tencent.mm.plugin.voip.a.a.c(i, j, 1, 2);
                        r.this.sTe = true;
                    }
                    AppMethodBeat.o(4602);
                }
            }
        });
        AppMethodBeat.o(4612);
    }

    public final void b(cpm cpm) {
        AppMethodBeat.i(4613);
        if (com.tencent.mm.m.a.ME() || eA(ah.getContext())) {
            String str = cpm.xmT;
            String Yz = com.tencent.mm.model.r.Yz();
            int i = cpm.xmL;
            ab.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", Yz, str, Integer.valueOf(i), Integer.valueOf(cpm.wem));
            if (this.sSP.cIJ()) {
                s.a(cpm.wem, cpm.wen, 2, null, null, str);
                ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + cpm.wem);
                com.tencent.mm.plugin.report.service.h.pYm.a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                com.tencent.mm.plugin.voip.a.a.GI(0);
                AppMethodBeat.o(4613);
                return;
            } else if (s.cKh()) {
                s.a(cpm.wem, cpm.wen, 3, null, null, str);
                ab.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + cpm.wem);
                com.tencent.mm.plugin.report.service.h.pYm.a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                com.tencent.mm.plugin.voip.a.a.GI(0);
                AppMethodBeat.o(4613);
                return;
            } else {
                this.sSP.cKi();
                if (this.sSP.a(cpm)) {
                    Context context = ah.getContext();
                    if (((j) g.K(j.class)).XM().aoO(str) == null) {
                        s.a(cpm.wem, cpm.wen, 4, null, null, str);
                        ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + cpm.wem);
                        com.tencent.mm.plugin.report.service.h.pYm.a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                        com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                        com.tencent.mm.plugin.voip.a.a.GI(0);
                        AppMethodBeat.o(4613);
                        return;
                    }
                    if (1 == i || i == 0) {
                        try {
                            a(context, str, false, i == 0, true);
                            if (this.sSP != null) {
                                this.sSP.Gy(cpm.wem);
                            }
                            ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.a.a.GI(2);
                        }
                    }
                    s.a(cpm.wem, cpm.wen, 1, this.sSP.sNl.sPp.field_peerId, this.sSP.sNl.sPp.field_capInfo, str);
                    com.tencent.mm.plugin.report.service.h.pYm.a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(4613);
                    return;
                }
                ab.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                com.tencent.mm.plugin.report.service.h.pYm.a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                com.tencent.mm.plugin.voip.a.a.GI(0);
                AppMethodBeat.o(4613);
                return;
            }
        }
        ab.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.sTc == null && this.oGx.doT()) {
            ab.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.sTc = cpm;
            this.oGx.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.sTd = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.pYm.a(500, 4, 1, false);
            com.tencent.mm.plugin.voip.a.a.GI(0);
        }
        AppMethodBeat.o(4613);
    }

    public final void Gv(int i) {
        AppMethodBeat.i(4614);
        if (this.sTf == null || this.sTf.isEmpty()) {
            AppMethodBeat.o(4614);
            return;
        }
        for (a aVar : this.sTf) {
            if (aVar != null && aVar.sTh != null && aVar.sTh.wem == i) {
                aVar.cancelled = true;
                AppMethodBeat.o(4614);
                return;
            }
        }
        AppMethodBeat.o(4614);
    }

    static {
        AppMethodBeat.i(4642);
        AppMethodBeat.o(4642);
    }

    public static com.tencent.mm.plugin.voip.model.o.a abW(String str) {
        AppMethodBeat.i(4615);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(4615);
            return null;
        }
        int hashCode = str.hashCode();
        com.tencent.mm.plugin.voip.model.o.a aVar = (com.tencent.mm.plugin.voip.model.o.a) emX.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            AppMethodBeat.o(4615);
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.voip.model.o.a();
        if (aVar.parse(str)) {
            emX.k(Integer.valueOf(hashCode), aVar);
            AppMethodBeat.o(4615);
            return aVar;
        }
        AppMethodBeat.o(4615);
        return null;
    }

    private static Map<Integer, Long> br(byte[] bArr) {
        AppMethodBeat.i(4616);
        if (bo.cb(bArr)) {
            AppMethodBeat.o(4616);
            return null;
        }
        try {
            cfz cfz = (cfz) new cfz().parseFrom(bArr);
            if (cfz == null) {
                AppMethodBeat.o(4616);
                return null;
            }
            ab.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + cfz.wYL);
            LinkedList linkedList = cfz.wYM;
            if (linkedList.size() != cfz.wYL) {
                AppMethodBeat.o(4616);
                return null;
            }
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cfz.wYL) {
                    break;
                }
                hashMap.put(Integer.valueOf(((axg) linkedList.get(i2)).pXC), Long.valueOf(4294967295L & ((long) ((axg) linkedList.get(i2)).wBo)));
                i = i2 + 1;
            }
            if (hashMap.size() != cfz.wYL) {
                AppMethodBeat.o(4616);
                return null;
            }
            AppMethodBeat.o(4616);
            return hashMap;
        } catch (Exception e) {
            AppMethodBeat.o(4616);
            return null;
        }
    }

    private static byte[] ai(Map<Integer, Long> map) {
        AppMethodBeat.i(4617);
        cfz cfz = new cfz();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            axg axg = new axg();
            axg.pXC = num.intValue();
            axg.wBo = ((Long) map.get(num)).intValue();
            linkedList.push(axg);
        }
        cfz.wYM = linkedList;
        cfz.wYL = linkedList.size();
        try {
            byte[] toByteArray = cfz.toByteArray();
            AppMethodBeat.o(4617);
            return toByteArray;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            AppMethodBeat.o(4617);
            return null;
        }
    }

    private static String bs(byte[] bArr) {
        AppMethodBeat.i(4618);
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
            }
            str = str + toHexString.toUpperCase();
        }
        AppMethodBeat.o(4618);
        return str;
    }

    public final int b(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        AppMethodBeat.i(4619);
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        ab.i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map br = br(this.sSP.sNl.sPt);
        if (br == null) {
            ab.i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
        } else {
            j3 = 0;
            for (Integer num : br.keySet()) {
                Long l = (Long) br.get(num);
                switch (num.intValue()) {
                    case 1:
                        j4 = l.longValue();
                        break;
                    case 2:
                        j5 = l.longValue();
                        break;
                    case 3:
                        j3 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        ab.i(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j2 = j3;
        }
        ab.i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j4 + " relayData key:" + j5 + " connectingStatusKey:" + j2);
        try {
            cpi cpi = (cpi) new cpi().parseFrom(bArr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < cpi.xmM.size()) {
                    cph cph = (cph) cpi.xmM.get(i3);
                    ab.i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + cph.wat);
                    StringBuilder stringBuilder;
                    if (cph.wat == 1) {
                        cqi cqi;
                        try {
                            cqi = (cqi) new cqi().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e) {
                            ab.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            cqi = null;
                        }
                        if (cqi != null) {
                            ab.i("MicroMsg.Voip.VoipService", "voip notify status:" + cqi.jBT);
                            if (j6 < ((long) cph.pXC)) {
                                j3 = (long) cph.pXC;
                            } else {
                                j3 = j6;
                            }
                            if (((long) cph.pXC) > j4) {
                                ab.i("MicroMsg.Voip.VoipService", "voiop notify status key[" + cph.pXC + "] > local status key[" + j4 + "] status[" + cqi.jBT + "]");
                                this.sSP.sNl.sPs.a(cqi, 1);
                                j6 = j3;
                            }
                        } else {
                            ab.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            j3 = j6;
                        }
                        j6 = j3;
                    } else if (cph.wat == 2) {
                        cpx cpx;
                        try {
                            cpx = (cpx) new cpx().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e2) {
                            ab.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                            ab.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                            cpx = null;
                        }
                        if (cpx != null) {
                            ab.i("MicroMsg.Voip.VoipService", "notify relay data type:" + cpx.jCt);
                            if (j7 < ((long) cph.pXC)) {
                                j3 = (long) cph.pXC;
                            } else {
                                j3 = j7;
                            }
                            if (((long) cph.pXC) > j5) {
                                stringBuilder = new StringBuilder("notify relaydata key:[");
                                ab.i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("] > local relaydata key[").append(j5).append("]").toString());
                                if (cpx.jCt == 5) {
                                    this.sSP.sNl.sPs.a(cpx);
                                    j7 = j3;
                                } else if (cpx.jCt == 1) {
                                    this.sSP.sNl.sPs.b(cpx);
                                    j7 = j3;
                                } else {
                                    ab.i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + cpx.jCt);
                                    j7 = j3;
                                }
                            } else {
                                stringBuilder = new StringBuilder("notify relaydata item key[");
                                ab.i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("] <=local relaydatakey[").append(j5).append("]").toString());
                                j7 = j3;
                            }
                        } else {
                            ab.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        }
                    } else if (cph.wat == 3) {
                        SKBuiltinBuffer_t parseFrom;
                        try {
                            parseFrom = new SKBuiltinBuffer_t().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                            parseFrom = null;
                        }
                        if (parseFrom != null) {
                            if (j8 < ((long) cph.pXC)) {
                                j3 = (long) cph.pXC;
                            } else {
                                j3 = j8;
                            }
                            if (((long) cph.pXC) > j2) {
                                stringBuilder = new StringBuilder("notify connectingStatkey[");
                                ab.i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("]> local connectingstatus key[").append(j2).append("]").toString());
                                this.sSP.sNl.sPs.c(parseFrom);
                                if (this.sTc != null && (com.tencent.mm.plugin.voip.a.a.bv(parseFrom.getBuffer().toByteArray()) & 255) == 1) {
                                    this.sTc.xmL = 1;
                                }
                            }
                            j8 = j3;
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    if (j6 <= j4) {
                        j6 = j4;
                    }
                    if (j7 <= j5) {
                        j7 = j5;
                    }
                    if (j8 <= j2) {
                        j8 = j2;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
                    hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
                    hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
                    byte[] ai = ai(hashMap);
                    if (i == this.sSP.sNl.sPp.nwu && j == this.sSP.sNl.sPp.nwv) {
                        this.sSP.sNl.sPt = ai;
                        ab.i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
                    }
                    ab.i("MicroMsg.Voip.VoipService", "__parse voip notify end");
                    AppMethodBeat.o(4619);
                    return 0;
                }
            }
        } catch (Exception e3) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            ab.i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + bs(bArr));
            AppMethodBeat.o(4619);
            return 0;
        }
    }

    public static byte[] U(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int R(boolean z, boolean z2) {
        AppMethodBeat.i(4620);
        int R = this.sSP.R(z, z2);
        AppMethodBeat.o(4620);
        return R;
    }

    public final void Gh(int i) {
        AppMethodBeat.i(4621);
        this.sSP.Gh(i);
        AppMethodBeat.o(4621);
    }

    public final int cJZ() {
        return this.sSP.sNl.sPp.nwu;
    }

    public final long cKa() {
        return this.sSP.sNl.sPp.nwv;
    }

    public final long cIK() {
        AppMethodBeat.i(139154);
        long cIK = this.sSP.sNl.cIK();
        AppMethodBeat.o(139154);
        return cIK;
    }

    public final int cIt() {
        AppMethodBeat.i(139155);
        int cIt = this.sSP.sNl.cIt();
        AppMethodBeat.o(139155);
        return cIt;
    }

    public final void Gw(int i) {
        AppMethodBeat.i(4624);
        ab.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", Integer.valueOf(i));
        this.sSP.Gw(i);
        AppMethodBeat.o(4624);
    }

    public final void cKb() {
        AppMethodBeat.i(4625);
        ab.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", Integer.valueOf(1));
        this.sSP.sNl.sPp.sVH.sQq = 1;
        AppMethodBeat.o(4625);
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        AppMethodBeat.i(4626);
        m mVar = this.sSP.sNl.sPr;
        if (((!z ? 1 : 0) & (mVar.kzf == m.kze ? 1 : 0)) != 0) {
            AppMethodBeat.o(4626);
            return -1;
        } else if (mVar.sNl.sPp.cKK()) {
            int videoEncodeToLocal = mVar.sNl.sPp.videoEncodeToLocal(bArr, i, i3, i4, i2, 0, 75, iArr);
            AppMethodBeat.o(4626);
            return videoEncodeToLocal;
        } else {
            AppMethodBeat.o(4626);
            return -1;
        }
    }

    public final boolean mj(boolean z) {
        AppMethodBeat.i(4627);
        boolean mj = this.sSP.mj(z);
        AppMethodBeat.o(4627);
        return mj;
    }

    public final int mo(boolean z) {
        AppMethodBeat.i(4628);
        int mo = this.sSP.mo(z);
        AppMethodBeat.o(4628);
        return mo;
    }

    public final int mp(boolean z) {
        AppMethodBeat.i(4629);
        int mp = this.sSP.mp(z);
        AppMethodBeat.o(4629);
        return mp;
    }

    public final void an(int i, boolean z) {
        AppMethodBeat.i(4630);
        s sVar = this.sSP;
        if (sVar.sTj != null) {
            sVar.sTj.ao(i, z);
        }
        AppMethodBeat.o(4630);
    }

    public final void Gx(int i) {
        AppMethodBeat.i(4631);
        this.sSP.Gx(i);
        AppMethodBeat.o(4631);
    }

    public final boolean cKc() {
        boolean z = false;
        AppMethodBeat.i(4632);
        try {
            if (!(this.sSP.sNl.sPp == null || (this.sSP.sNl.sPp.sUI & 8) == 0)) {
                z = true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + e.getMessage());
        }
        AppMethodBeat.o(4632);
        return z;
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(4633);
        if (context == null) {
            context = ah.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        iq iqVar = new iq();
        iqVar.cDO.cDR = false;
        iqVar.cDO.cDQ = currentTimeMillis;
        iqVar.cDO.cDP = context;
        com.tencent.mm.sdk.b.a.xxA.m(iqVar);
        ab.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.o(4633);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0344  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final VoipMgr a(Context context, PString pString, PBool pBool, PBool pBool2, PInt pInt) {
        AppMethodBeat.i(4634);
        VoipMgr voipMgr;
        if (this.sSQ != null) {
            ab.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = this.sSQ.edV;
            pBool.value = this.sSQ.sRm;
            pBool2.value = this.sSQ.sRn;
            pInt.value = this.sSQ.sRc.mState;
            voipMgr = this.sSQ;
            AppMethodBeat.o(4634);
            return voipMgr;
        } else if (pString.value == null) {
            ab.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
            AppMethodBeat.o(4634);
            return null;
        } else if (pBool.value || this.sSP.cIJ()) {
            String str;
            VoipMgr voipMgr2;
            List P;
            k kVar;
            IntentFilter intentFilter;
            this.sSQ = new VoipMgr();
            com.tencent.mm.compatible.b.g.a aVar = this.sSQ;
            String str2 = pString.value;
            boolean z = pBool.value;
            boolean z2 = pBool2.value;
            ab.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", str2, Boolean.valueOf(z), Boolean.valueOf(z2));
            aVar.sRG = true;
            aVar.edV = str2;
            aVar.sRm = z;
            aVar.sRn = z2;
            aVar.sRl = ((j) g.K(j.class)).XM().aoO(aVar.edV);
            aVar.iGP = new ak(Looper.getMainLooper());
            if (aVar.sRM == null) {
                aVar.sRM = new com.tencent.mm.plugin.voip.video.e();
            }
            aVar.sRN = 0;
            aVar.sRO = 0;
            aVar.sRo = bo.getInt(com.tencent.mm.m.g.Nu().getValue("VOIPCameraSwitch"), 1) == 0;
            if (!aVar.sRn) {
                aVar.sRo = false;
            }
            int T = com.tencent.mm.plugin.voip.a.b.T(z, z2);
            if (aVar.sRo) {
                if (T == 0) {
                    T = 1;
                } else if (256 == T) {
                    T = d.MIC_PTU_ZIPAI_TOKYO;
                }
            }
            if (z) {
                aVar.sRc = com.tencent.mm.plugin.voip.a.b.GM(T);
            } else {
                aVar.sRc = com.tencent.mm.plugin.voip.a.b.GL(T);
            }
            boolean Mi = com.tencent.mm.compatible.f.b.Mi();
            boolean Mj = com.tencent.mm.compatible.f.b.Mj();
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                com.tencent.mm.plugin.report.service.h hVar;
                Object[] objArr;
                if (!Mi) {
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aVar.sRn ? 0 : 1);
                    objArr[1] = Integer.valueOf(1);
                    hVar.e(11306, objArr);
                }
                if (!Mj) {
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aVar.sRn ? 0 : 1);
                    objArr[1] = Integer.valueOf(0);
                    hVar.e(11306, objArr);
                }
            }
            if (!(Mj && Mi)) {
                String str3 = null;
                str = null;
                if (!Mi && !Mj) {
                    str3 = context.getString(R.string.f71);
                    str = context.getString(R.string.f68);
                } else if (!Mi) {
                    str3 = context.getString(R.string.f73);
                    str = context.getString(R.string.f69);
                } else if (!Mj) {
                    str3 = context.getString(R.string.f72);
                    str = context.getString(R.string.f6_);
                }
                com.tencent.mm.ui.base.h.a(context, str3, str, context.getString(R.string.f6a), true, new AnonymousClass14(context));
            }
            ab.i("MicroMsg.Voip.VoipMgr", "initMgr");
            com.tencent.mm.booter.a.Ib().Id();
            com.tencent.mm.compatible.b.g.KK().b(aVar);
            com.tencent.mm.compatible.b.g.KK().a(aVar);
            com.tencent.mm.compatible.b.g.KK().KM();
            aVar.cqx = new com.tencent.mm.compatible.util.b(ah.getContext());
            aVar.cqx.requestFocus();
            if (aVar.sRn) {
                com.tencent.mm.plugin.voip.b.cIj().b(true, true, aVar.edV);
            } else {
                com.tencent.mm.plugin.voip.b.cIj().b(true, false, aVar.edV);
            }
            if (aVar.sRm) {
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKi();
                if (aVar.sRn) {
                    T = com.tencent.mm.plugin.voip.b.cIj().sSP.dp(aVar.sRl.field_username, 0);
                } else {
                    T = com.tencent.mm.plugin.voip.b.cIj().sSP.dp(aVar.sRl.field_username, 1);
                }
                if (T < 0) {
                    aVar.mu(false);
                    voipMgr = this.sSQ;
                    AppMethodBeat.o(4634);
                    return voipMgr;
                }
            }
            aVar.sRd = new HeadsetPlugReceiver();
            aVar.sRd.a(ah.getContext(), aVar.sSk);
            r cIj = com.tencent.mm.plugin.voip.b.cIj();
            Context context2 = ah.getContext();
            s sVar = cIj.sSP;
            sVar.sNl.jiq = context2;
            sVar.sNl.sPq = aVar;
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
            com.tencent.mm.plugin.voip.a.a.cLs();
            aVar.nva = (TelephonyManager) ah.getContext().getSystemService("phone");
            aVar.nva.listen(aVar.nvb, 32);
            com.tencent.mm.plugin.voip.b.cIj().an(aVar.sRn ? 0 : 1, aVar.sRm);
            com.tencent.mm.compatible.b.g.a voipMgr22;
            if (com.tencent.mm.compatible.b.g.KK().KV()) {
                T = 3;
                voipMgr22 = aVar;
            } else if (com.tencent.mm.compatible.b.g.KK().KP()) {
                T = 4;
                voipMgr22 = aVar;
            } else if (aVar.sRn) {
                T = 1;
                voipMgr22 = aVar;
            } else {
                T = 2;
                voipMgr22 = aVar;
            }
            voipMgr22.sRr = T;
            aVar.sRL = false;
            aVar.sRu = aVar.sRn;
            str2 = "voip_recent_contact" + com.tencent.mm.model.r.Yz();
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("voip_plugin_prefs", 0);
            str = sharedPreferences.getString(str2, null);
            if (str != null) {
                P = bo.P(str.split(";"));
                if (P != null) {
                    int size = P.size();
                    if (P.contains(aVar.edV)) {
                        if (size > 1) {
                            P.remove(aVar.edV);
                        }
                        sharedPreferences.edit().putString(str2, bo.c(P, ";")).commit();
                        com.tencent.mm.sdk.b.a.xxA.c(aVar.sSm);
                        com.tencent.mm.sdk.b.a.xxA.c(aVar.nvc);
                        kVar = aVar.sRz;
                        if (!kVar.jFO.contains(aVar)) {
                            kVar.jFO.add(aVar);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        ah.getContext().registerReceiver(aVar.sSj, intentFilter);
                        aVar.mfW = new SensorController(aVar.getContext());
                        ab.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                        aVar.mfW.a(aVar);
                        voipMgr = this.sSQ;
                        AppMethodBeat.o(4634);
                        return voipMgr;
                    } else if (4 == size) {
                        P.remove(size - 1);
                    }
                    P.add(0, aVar.edV);
                    sharedPreferences.edit().putString(str2, bo.c(P, ";")).commit();
                    com.tencent.mm.sdk.b.a.xxA.c(aVar.sSm);
                    com.tencent.mm.sdk.b.a.xxA.c(aVar.nvc);
                    kVar = aVar.sRz;
                    if (kVar.jFO.contains(aVar)) {
                    }
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    ah.getContext().registerReceiver(aVar.sSj, intentFilter);
                    aVar.mfW = new SensorController(aVar.getContext());
                    ab.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                    aVar.mfW.a(aVar);
                    voipMgr = this.sSQ;
                    AppMethodBeat.o(4634);
                    return voipMgr;
                }
            }
            P = new ArrayList();
            P.add(0, aVar.edV);
            sharedPreferences.edit().putString(str2, bo.c(P, ";")).commit();
            com.tencent.mm.sdk.b.a.xxA.c(aVar.sSm);
            com.tencent.mm.sdk.b.a.xxA.c(aVar.nvc);
            kVar = aVar.sRz;
            if (kVar.jFO.contains(aVar)) {
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            ah.getContext().registerReceiver(aVar.sSj, intentFilter);
            aVar.mfW = new SensorController(aVar.getContext());
            ab.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
            aVar.mfW.a(aVar);
            voipMgr = this.sSQ;
            AppMethodBeat.o(4634);
            return voipMgr;
        } else {
            ab.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            q.a(pString.value, pBool2.value ? bi.xZc : bi.xZb, pBool.value ? 1 : 0, 4, ah.getContext().getString(R.string.f41));
            AppMethodBeat.o(4634);
            return null;
        }
    }

    public static float mw(boolean z) {
        AppMethodBeat.i(4635);
        float f = 0.74766356f;
        try {
            byte[] bArr;
            r cIj = com.tencent.mm.plugin.voip.b.cIj();
            if (z) {
                bArr = cIj.sSP.sNl.sPp.field_capInfo;
            } else {
                bArr = cIj.sSP.sNl.sPp.sUb;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > CdnLogic.kBizGeneric) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                ab.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            ab.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        AppMethodBeat.o(4635);
        return f;
    }

    public final void cKd() {
        AppMethodBeat.i(4636);
        this.sSP.sTt.ae(1000, 1000);
        AppMethodBeat.o(4636);
    }

    private static boolean eA(Context context) {
        AppMethodBeat.i(4637);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            ab.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                ab.i("MicroMsg.Voip.VoipService", "is in backGround.");
                AppMethodBeat.o(4637);
                return false;
            }
        }
        if (((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.o(4637);
            return false;
        }
        ab.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        AppMethodBeat.o(4637);
        return true;
    }

    public final void Gj(int i) {
        AppMethodBeat.i(4638);
        this.sSP.sNl.Gj(i);
        AppMethodBeat.o(4638);
    }

    public final void cKe() {
        AppMethodBeat.i(4639);
        this.sSP.sNl.sPr.cIZ();
        AppMethodBeat.o(4639);
    }

    public final void jj(boolean z) {
        int i;
        AppMethodBeat.i(4640);
        ab.c("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", Boolean.valueOf(z));
        byte[] bArr = new byte[1];
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        bArr[0] = (byte) i;
        this.sSP.sNl.sPp.setAppCmd(425, bArr, 1);
        AppMethodBeat.o(4640);
    }
}
