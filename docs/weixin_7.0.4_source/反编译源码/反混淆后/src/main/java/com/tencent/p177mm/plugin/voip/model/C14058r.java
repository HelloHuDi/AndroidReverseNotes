package com.tencent.p177mm.plugin.voip.model;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C18299iq;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.p177mm.plugin.voip.model.C40033o.C22460a;
import com.tencent.p177mm.plugin.voip.model.VoipMgr.C427614;
import com.tencent.p177mm.plugin.voip.model.p746a.C14040e;
import com.tencent.p177mm.plugin.voip.model.p746a.C43729h;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip.p546ui.VideoActivity;
import com.tencent.p177mm.plugin.voip.video.C40042e;
import com.tencent.p177mm.plugin.voip.video.C43741k;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.axg;
import com.tencent.p177mm.protocal.protobuf.cfz;
import com.tencent.p177mm.protocal.protobuf.cmm;
import com.tencent.p177mm.protocal.protobuf.cph;
import com.tencent.p177mm.protocal.protobuf.cpi;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.protocal.protobuf.cqi;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.voip.model.r */
public final class C14058r {
    private static final C1177f<Integer, C22460a> emX = new C7598c(5);
    public boolean con;
    public C7564ap oGx;
    private C1923n qbK;
    public String sRK;
    public C4286s sSP;
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
    List<C14061a> sTf;
    public String talker;

    /* renamed from: com.tencent.mm.plugin.voip.model.r$1 */
    class C75271 extends C1924a {
        C75271() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(4601);
            C4990ab.m7410d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(i)));
            if (C14058r.this.con && i == 4) {
                C14047k c14047k = C14058r.this.sSP.sNl;
                if (c14047k.sPz == 0) {
                    c14047k.sPz = c14047k.sPp.sTX;
                }
                int netType = C46317a.getNetType(C4996ah.getContext());
                if (netType != c14047k.sPz) {
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + c14047k.sPz + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = c14047k.sPp.setAppCmd(301, bArr, 4);
                        if (appCmd < 0) {
                            C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + c14047k.sPp.nwC + ", roomkey=" + c14047k.sPp.nwv + "]");
                        }
                        cmm cmm = new cmm();
                        cmm.xko = 3;
                        cmm.xkp = new C1332b(bArr, 0, 1);
                        c14047k.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                    } catch (Exception e) {
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                    }
                    c14047k.sPz = netType;
                }
                C4286s c4286s = C14058r.this.sSP;
                new C43729h(c4286s.sNl.sPp.nwu, c4286s.sNl.sPp.nwv, c4286s.sNl.sPp.nwC, 0, 0, null).cKw();
            }
            AppMethodBeat.m2505o(4601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.r$3 */
    class C140603 implements C5015a {
        C140603() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4603);
            C4990ab.m7418v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
            if (C14058r.this.sTc == null) {
                C14058r.this.sTd = 0;
                C14058r.this.oGx.stopTimer();
                AppMethodBeat.m2505o(4603);
                return false;
            } else if (C14058r.m22227fc(C4996ah.getContext())) {
                C14058r.this.mo26346ad(C14058r.this.sTc.wem, C14058r.this.sTc.wen);
                C14058r.this.mo26349b(C14058r.this.sTc);
                C14058r.this.sTc = null;
                C14058r.this.sTd = 0;
                C14058r.this.oGx.stopTimer();
                C7060h.pYm.mo8378a(500, 5, 1, false);
                AppMethodBeat.m2505o(4603);
                return false;
            } else if (System.currentTimeMillis() - C14058r.this.sTd < 60000) {
                AppMethodBeat.m2505o(4603);
                return true;
            } else {
                C14058r.this.sTc = null;
                C14058r.this.sTd = 0;
                C14058r.this.oGx.stopTimer();
                AppMethodBeat.m2505o(4603);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.r$a */
    public class C14061a {
        boolean cancelled;
        cpm sTh;
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.r$4 */
    class C140624 implements Runnable {
        final /* synthetic */ String val$tips;

        C140624(String str) {
            this.val$tips = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(4604);
            if (C14058r.this.sSQ != null) {
                VoipMgr voipMgr = C14058r.this.sSQ;
                String str = this.val$tips;
                if (voipMgr.sRe != null) {
                    voipMgr.sRK = str;
                    voipMgr.sRe.abY(str);
                }
            }
            AppMethodBeat.m2505o(4604);
        }
    }

    /* renamed from: fc */
    static /* synthetic */ boolean m22227fc(Context context) {
        AppMethodBeat.m2504i(4641);
        boolean eA = C14058r.m22225eA(context);
        AppMethodBeat.m2505o(4641);
        return eA;
    }

    public C14058r() {
        AppMethodBeat.m2504i(4605);
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
        this.qbK = new C75271();
        this.oGx = new C7564ap(Looper.getMainLooper(), new C140603(), true);
        this.sTf = null;
        this.sSP = new C4286s();
        this.con = false;
        this.sSR = false;
        this.sSS = false;
        this.talker = null;
        this.sRK = null;
        C1720g.m3535RO().mo5187a(this.qbK);
        AppMethodBeat.m2505o(4605);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(4606);
        this.sSP.stop();
        this.sSP = null;
        C1720g.m3535RO().mo5188b(this.qbK);
        super.finalize();
        AppMethodBeat.m2505o(4606);
    }

    /* renamed from: b */
    public final void mo26350b(boolean z, boolean z2, String str) {
        AppMethodBeat.m2504i(4607);
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2 + "username " + str);
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
        AppMethodBeat.m2505o(4607);
    }

    /* renamed from: Q */
    public final void mo26342Q(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4608);
        this.sTa = z;
        this.sTb = z2;
        C4990ab.m7411d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.m2505o(4608);
    }

    /* renamed from: ba */
    public final void mo26351ba(Context context, String str) {
        AppMethodBeat.m2504i(4609);
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str) || (System.currentTimeMillis() - this.sST < FaceGestureDetGLThread.BRIGHTNESS_DURATION && System.currentTimeMillis() - this.sST > 0)) {
            AppMethodBeat.m2505o(4609);
        } else if (System.currentTimeMillis() - this.sSW >= this.sSX || System.currentTimeMillis() - this.sSW <= 0) {
            this.sST = System.currentTimeMillis();
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str) == null) {
                AppMethodBeat.m2505o(4609);
                return;
            }
            C14058r.m22216a(context, str, true, false, false);
            C14058r.cJY();
            AppMethodBeat.m2505o(4609);
        } else {
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            C30379h.m48431a(context, (int) C25738R.string.f6x, (int) C25738R.string.f7t, null);
            AppMethodBeat.m2505o(4609);
        }
    }

    /* renamed from: bb */
    public final void mo26352bb(Context context, String str) {
        AppMethodBeat.m2504i(4610);
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str) || (System.currentTimeMillis() - this.sST < FaceGestureDetGLThread.BRIGHTNESS_DURATION && System.currentTimeMillis() - this.sST > 0)) {
            AppMethodBeat.m2505o(4610);
        } else if (System.currentTimeMillis() - this.sSW >= this.sSX || System.currentTimeMillis() - this.sSW <= 0) {
            this.sST = System.currentTimeMillis();
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str) == null) {
                AppMethodBeat.m2505o(4610);
                return;
            }
            C14058r.m22216a(context, str, true, true, false);
            C14058r.cJY();
            AppMethodBeat.m2505o(4610);
        } else {
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            C30379h.m48431a(context, (int) C25738R.string.f6x, (int) C25738R.string.f7t, null);
            AppMethodBeat.m2505o(4610);
        }
    }

    private static void cJY() {
        AppMethodBeat.m2504i(4611);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 7;
        C4879a.xxA.mo10055m(c26250ui);
        AppMethodBeat.m2505o(4611);
    }

    /* renamed from: ad */
    public final void mo26346ad(final int i, final long j) {
        AppMethodBeat.m2504i(4612);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(4602);
                C4990ab.m7417i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", Integer.valueOf(i), Long.valueOf(j));
                if (!C37885a.m63952ME() && !C14058r.m22227fc(C4996ah.getContext())) {
                    C4990ab.m7416i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                    AppMethodBeat.m2505o(4602);
                } else if (C14058r.this.sSP.cKg()) {
                    C4990ab.m7416i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
                    if (!(C14058r.this.sSP.sNl.sPp.nwu == i || C14058r.this.sSP.sNl.sPp.nwv == j)) {
                        C4990ab.m7417i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(C14058r.this.sSP.sNl.sPp.nwu), Long.valueOf(C14058r.this.sSP.sNl.sPp.nwv));
                        C4286s.m6629a(i, j, 2, null, null, C14058r.this.talker);
                    }
                    AppMethodBeat.m2505o(4602);
                } else {
                    new C14040e(i, j, "").cKw();
                    if (!C14058r.this.sTe) {
                        C46317a.m86991c(i, j, 1, 2);
                        C14058r.this.sTe = true;
                    }
                    AppMethodBeat.m2505o(4602);
                }
            }
        });
        AppMethodBeat.m2505o(4612);
    }

    /* renamed from: b */
    public final void mo26349b(cpm cpm) {
        AppMethodBeat.m2504i(4613);
        if (C37885a.m63952ME() || C14058r.m22225eA(C4996ah.getContext())) {
            String str = cpm.xmT;
            String Yz = C1853r.m3846Yz();
            int i = cpm.xmL;
            C4990ab.m7417i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", Yz, str, Integer.valueOf(i), Integer.valueOf(cpm.wem));
            if (this.sSP.cIJ()) {
                C4286s.m6629a(cpm.wem, cpm.wen, 2, null, null, str);
                C4990ab.m7410d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + cpm.wem);
                C7060h.pYm.mo8377a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(2), Integer.valueOf(C46317a.getNetType(C4996ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                C46317a.m86983GI(0);
                AppMethodBeat.m2505o(4613);
                return;
            } else if (C4286s.cKh()) {
                C4286s.m6629a(cpm.wem, cpm.wen, 3, null, null, str);
                C4990ab.m7412e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + cpm.wem);
                C7060h.pYm.mo8377a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(3), Integer.valueOf(C46317a.getNetType(C4996ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                C46317a.m86983GI(0);
                AppMethodBeat.m2505o(4613);
                return;
            } else {
                this.sSP.cKi();
                if (this.sSP.mo9276a(cpm)) {
                    Context context = C4996ah.getContext();
                    if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str) == null) {
                        C4286s.m6629a(cpm.wem, cpm.wen, 4, null, null, str);
                        C4990ab.m7410d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + cpm.wem);
                        C7060h.pYm.mo8377a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(4), Integer.valueOf(C46317a.getNetType(C4996ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                        C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                        C46317a.m86983GI(0);
                        AppMethodBeat.m2505o(4613);
                        return;
                    }
                    if (1 == i || i == 0) {
                        try {
                            C14058r.m22216a(context, str, false, i == 0, true);
                            if (this.sSP != null) {
                                this.sSP.mo9274Gy(cpm.wem);
                            }
                            C4990ab.m7410d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                        } catch (Exception e) {
                            C46317a.m86983GI(2);
                        }
                    }
                    C4286s.m6629a(cpm.wem, cpm.wen, 1, this.sSP.sNl.sPp.field_peerId, this.sSP.sNl.sPp.field_capInfo, str);
                    C7060h.pYm.mo8377a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(1), Integer.valueOf(C46317a.getNetType(C4996ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.m2505o(4613);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                C7060h.pYm.mo8377a(11525, true, true, Integer.valueOf(cpm.wem), Long.valueOf(cpm.wen), Integer.valueOf(cpm.xmL), Integer.valueOf(5), Integer.valueOf(C46317a.getNetType(C4996ah.getContext())), Long.valueOf(System.currentTimeMillis()));
                C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(7));
                C46317a.m86983GI(0);
                AppMethodBeat.m2505o(4613);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.sTc == null && this.oGx.doT()) {
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.sTc = cpm;
            this.oGx.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.sTd = System.currentTimeMillis();
            C7060h.pYm.mo8378a(500, 4, 1, false);
            C46317a.m86983GI(0);
        }
        AppMethodBeat.m2505o(4613);
    }

    /* renamed from: Gv */
    public final void mo26339Gv(int i) {
        AppMethodBeat.m2504i(4614);
        if (this.sTf == null || this.sTf.isEmpty()) {
            AppMethodBeat.m2505o(4614);
            return;
        }
        for (C14061a c14061a : this.sTf) {
            if (c14061a != null && c14061a.sTh != null && c14061a.sTh.wem == i) {
                c14061a.cancelled = true;
                AppMethodBeat.m2505o(4614);
                return;
            }
        }
        AppMethodBeat.m2505o(4614);
    }

    static {
        AppMethodBeat.m2504i(4642);
        AppMethodBeat.m2505o(4642);
    }

    public static C22460a abW(String str) {
        AppMethodBeat.m2504i(4615);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(4615);
            return null;
        }
        int hashCode = str.hashCode();
        C22460a c22460a = (C22460a) emX.get(Integer.valueOf(hashCode));
        if (c22460a != null) {
            AppMethodBeat.m2505o(4615);
            return c22460a;
        }
        c22460a = new C22460a();
        if (c22460a.parse(str)) {
            emX.mo4412k(Integer.valueOf(hashCode), c22460a);
            AppMethodBeat.m2505o(4615);
            return c22460a;
        }
        AppMethodBeat.m2505o(4615);
        return null;
    }

    /* renamed from: br */
    private static Map<Integer, Long> m22220br(byte[] bArr) {
        AppMethodBeat.m2504i(4616);
        if (C5046bo.m7540cb(bArr)) {
            AppMethodBeat.m2505o(4616);
            return null;
        }
        try {
            cfz cfz = (cfz) new cfz().parseFrom(bArr);
            if (cfz == null) {
                AppMethodBeat.m2505o(4616);
                return null;
            }
            C4990ab.m7410d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + cfz.wYL);
            LinkedList linkedList = cfz.wYM;
            if (linkedList.size() != cfz.wYL) {
                AppMethodBeat.m2505o(4616);
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
                AppMethodBeat.m2505o(4616);
                return null;
            }
            AppMethodBeat.m2505o(4616);
            return hashMap;
        } catch (Exception e) {
            AppMethodBeat.m2505o(4616);
            return null;
        }
    }

    /* renamed from: ai */
    private static byte[] m22218ai(Map<Integer, Long> map) {
        AppMethodBeat.m2504i(4617);
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
            AppMethodBeat.m2505o(4617);
            return toByteArray;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            AppMethodBeat.m2505o(4617);
            return null;
        }
    }

    /* renamed from: bs */
    private static String m22221bs(byte[] bArr) {
        AppMethodBeat.m2504i(4618);
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
            }
            str = str + toHexString.toUpperCase();
        }
        AppMethodBeat.m2505o(4618);
        return str;
    }

    /* renamed from: b */
    public final int mo26348b(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        AppMethodBeat.m2504i(4619);
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map br = C14058r.m22220br(this.sSP.sNl.sPt);
        if (br == null) {
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
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
                        C4990ab.m7416i(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j2 = j3;
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j4 + " relayData key:" + j5 + " connectingStatusKey:" + j2);
        try {
            cpi cpi = (cpi) new cpi().parseFrom(bArr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < cpi.xmM.size()) {
                    cph cph = (cph) cpi.xmM.get(i3);
                    C4990ab.m7416i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + cph.wat);
                    StringBuilder stringBuilder;
                    if (cph.wat == 1) {
                        cqi cqi;
                        try {
                            cqi = (cqi) new cqi().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            cqi = null;
                        }
                        if (cqi != null) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "voip notify status:" + cqi.jBT);
                            if (j6 < ((long) cph.pXC)) {
                                j3 = (long) cph.pXC;
                            } else {
                                j3 = j6;
                            }
                            if (((long) cph.pXC) > j4) {
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", "voiop notify status key[" + cph.pXC + "] > local status key[" + j4 + "] status[" + cqi.jBT + "]");
                                this.sSP.sNl.sPs.mo9304a(cqi, 1);
                                j6 = j3;
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            j3 = j6;
                        }
                        j6 = j3;
                    } else if (cph.wat == 2) {
                        cpx cpx;
                        try {
                            cpx = (cpx) new cpx().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e2) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                            cpx = null;
                        }
                        if (cpx != null) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "notify relay data type:" + cpx.jCt);
                            if (j7 < ((long) cph.pXC)) {
                                j3 = (long) cph.pXC;
                            } else {
                                j3 = j7;
                            }
                            if (((long) cph.pXC) > j5) {
                                stringBuilder = new StringBuilder("notify relaydata key:[");
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("] > local relaydata key[").append(j5).append("]").toString());
                                if (cpx.jCt == 5) {
                                    this.sSP.sNl.sPs.mo9303a(cpx);
                                    j7 = j3;
                                } else if (cpx.jCt == 1) {
                                    this.sSP.sNl.sPs.mo9305b(cpx);
                                    j7 = j3;
                                } else {
                                    C4990ab.m7416i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + cpx.jCt);
                                    j7 = j3;
                                }
                            } else {
                                stringBuilder = new StringBuilder("notify relaydata item key[");
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("] <=local relaydatakey[").append(j5).append("]").toString());
                                j7 = j3;
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        }
                    } else if (cph.wat == 3) {
                        SKBuiltinBuffer_t parseFrom;
                        try {
                            parseFrom = new SKBuiltinBuffer_t().parseFrom(cph.vJd.getBufferToBytes());
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
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
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", stringBuilder.append(cph.pXC).append("]> local connectingstatus key[").append(j2).append("]").toString());
                                this.sSP.sNl.sPs.mo9306c(parseFrom);
                                if (this.sTc != null && (C46317a.m86990bv(parseFrom.getBuffer().toByteArray()) & 255) == 1) {
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
                    byte[] ai = C14058r.m22218ai(hashMap);
                    if (i == this.sSP.sNl.sPp.nwu && j == this.sSP.sNl.sPp.nwv) {
                        this.sSP.sNl.sPt = ai;
                        C4990ab.m7416i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
                    }
                    C4990ab.m7416i("MicroMsg.Voip.VoipService", "__parse voip notify end");
                    AppMethodBeat.m2505o(4619);
                    return 0;
                }
            }
        } catch (Exception e3) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + C14058r.m22221bs(bArr));
            AppMethodBeat.m2505o(4619);
            return 0;
        }
    }

    /* renamed from: U */
    public static byte[] m22215U(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    /* renamed from: R */
    public final int mo26343R(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4620);
        int R = this.sSP.mo9275R(z, z2);
        AppMethodBeat.m2505o(4620);
        return R;
    }

    /* renamed from: Gh */
    public final void mo26337Gh(int i) {
        AppMethodBeat.m2504i(4621);
        this.sSP.mo9271Gh(i);
        AppMethodBeat.m2505o(4621);
    }

    public final int cJZ() {
        return this.sSP.sNl.sPp.nwu;
    }

    public final long cKa() {
        return this.sSP.sNl.sPp.nwv;
    }

    public final long cIK() {
        AppMethodBeat.m2504i(139154);
        long cIK = this.sSP.sNl.cIK();
        AppMethodBeat.m2505o(139154);
        return cIK;
    }

    public final int cIt() {
        AppMethodBeat.m2504i(139155);
        int cIt = this.sSP.sNl.cIt();
        AppMethodBeat.m2505o(139155);
        return cIt;
    }

    /* renamed from: Gw */
    public final void mo26340Gw(int i) {
        AppMethodBeat.m2504i(4624);
        C4990ab.m7411d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", Integer.valueOf(i));
        this.sSP.mo9272Gw(i);
        AppMethodBeat.m2505o(4624);
    }

    public final void cKb() {
        AppMethodBeat.m2504i(4625);
        C4990ab.m7411d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", Integer.valueOf(1));
        this.sSP.sNl.sPp.sVH.sQq = 1;
        AppMethodBeat.m2505o(4625);
    }

    /* renamed from: a */
    public final int mo26344a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(4626);
        C40031m c40031m = this.sSP.sNl.sPr;
        if (((!z ? 1 : 0) & (c40031m.kzf == C40031m.kze ? 1 : 0)) != 0) {
            AppMethodBeat.m2505o(4626);
            return -1;
        } else if (c40031m.sNl.sPp.cKK()) {
            int videoEncodeToLocal = c40031m.sNl.sPp.videoEncodeToLocal(bArr, i, i3, i4, i2, 0, 75, iArr);
            AppMethodBeat.m2505o(4626);
            return videoEncodeToLocal;
        } else {
            AppMethodBeat.m2505o(4626);
            return -1;
        }
    }

    /* renamed from: mj */
    public final boolean mo26363mj(boolean z) {
        AppMethodBeat.m2504i(4627);
        boolean mj = this.sSP.mo9292mj(z);
        AppMethodBeat.m2505o(4627);
        return mj;
    }

    /* renamed from: mo */
    public final int mo26364mo(boolean z) {
        AppMethodBeat.m2504i(4628);
        int mo = this.sSP.mo9293mo(z);
        AppMethodBeat.m2505o(4628);
        return mo;
    }

    /* renamed from: mp */
    public final int mo26365mp(boolean z) {
        AppMethodBeat.m2504i(4629);
        int mp = this.sSP.mo9294mp(z);
        AppMethodBeat.m2505o(4629);
        return mp;
    }

    /* renamed from: an */
    public final void mo26347an(int i, boolean z) {
        AppMethodBeat.m2504i(4630);
        C4286s c4286s = this.sSP;
        if (c4286s.sTj != null) {
            c4286s.sTj.mo38022ao(i, z);
        }
        AppMethodBeat.m2505o(4630);
    }

    /* renamed from: Gx */
    public final void mo26341Gx(int i) {
        AppMethodBeat.m2504i(4631);
        this.sSP.mo9273Gx(i);
        AppMethodBeat.m2505o(4631);
    }

    public final boolean cKc() {
        boolean z = false;
        AppMethodBeat.m2504i(4632);
        try {
            if (!(this.sSP.sNl.sPp == null || (this.sSP.sNl.sPp.sUI & 8) == 0)) {
                z = true;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + e.getMessage());
        }
        AppMethodBeat.m2505o(4632);
        return z;
    }

    /* renamed from: a */
    public static void m22216a(Context context, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(4633);
        if (context == null) {
            context = C4996ah.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        C18299iq c18299iq = new C18299iq();
        c18299iq.cDO.cDR = false;
        c18299iq.cDO.cDQ = currentTimeMillis;
        c18299iq.cDO.cDP = context;
        C4879a.xxA.mo10055m(c18299iq);
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "start VideoActivity");
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
        AppMethodBeat.m2505o(4633);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0344  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final VoipMgr mo26345a(Context context, PString pString, PBool pBool, PBool pBool2, PInt pInt) {
        AppMethodBeat.m2504i(4634);
        VoipMgr voipMgr;
        if (this.sSQ != null) {
            C4990ab.m7416i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = this.sSQ.edV;
            pBool.value = this.sSQ.sRm;
            pBool2.value = this.sSQ.sRn;
            pInt.value = this.sSQ.sRc.mState;
            voipMgr = this.sSQ;
            AppMethodBeat.m2505o(4634);
            return voipMgr;
        } else if (pString.value == null) {
            C4990ab.m7412e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
            AppMethodBeat.m2505o(4634);
            return null;
        } else if (pBool.value || this.sSP.cIJ()) {
            String str;
            VoipMgr voipMgr2;
            List P;
            C43741k c43741k;
            IntentFilter intentFilter;
            this.sSQ = new VoipMgr();
            C1406a c1406a = this.sSQ;
            String str2 = pString.value;
            boolean z = pBool.value;
            boolean z2 = pBool2.value;
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", str2, Boolean.valueOf(z), Boolean.valueOf(z2));
            c1406a.sRG = true;
            c1406a.edV = str2;
            c1406a.sRm = z;
            c1406a.sRn = z2;
            c1406a.sRl = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c1406a.edV);
            c1406a.iGP = new C7306ak(Looper.getMainLooper());
            if (c1406a.sRM == null) {
                c1406a.sRM = new C40042e();
            }
            c1406a.sRN = 0;
            c1406a.sRO = 0;
            c1406a.sRo = C5046bo.getInt(C26373g.m41964Nu().getValue("VOIPCameraSwitch"), 1) == 0;
            if (!c1406a.sRn) {
                c1406a.sRo = false;
            }
            int T = C40025b.m68551T(z, z2);
            if (c1406a.sRo) {
                if (T == 0) {
                    T = 1;
                } else if (256 == T) {
                    T = C31128d.MIC_PTU_ZIPAI_TOKYO;
                }
            }
            if (z) {
                c1406a.sRc = C40025b.m68547GM(T);
            } else {
                c1406a.sRc = C40025b.m68546GL(T);
            }
            boolean Mi = C37657b.m63680Mi();
            boolean Mj = C37657b.m63681Mj();
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                C7060h c7060h;
                Object[] objArr;
                if (!Mi) {
                    c7060h = C7060h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(c1406a.sRn ? 0 : 1);
                    objArr[1] = Integer.valueOf(1);
                    c7060h.mo8381e(11306, objArr);
                }
                if (!Mj) {
                    c7060h = C7060h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(c1406a.sRn ? 0 : 1);
                    objArr[1] = Integer.valueOf(0);
                    c7060h.mo8381e(11306, objArr);
                }
            }
            if (!(Mj && Mi)) {
                String str3 = null;
                str = null;
                if (!Mi && !Mj) {
                    str3 = context.getString(C25738R.string.f71);
                    str = context.getString(C25738R.string.f68);
                } else if (!Mi) {
                    str3 = context.getString(C25738R.string.f73);
                    str = context.getString(C25738R.string.f69);
                } else if (!Mj) {
                    str3 = context.getString(C25738R.string.f72);
                    str = context.getString(C25738R.string.f6_);
                }
                C30379h.m48447a(context, str3, str, context.getString(C25738R.string.f6a), true, new C427614(context));
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "initMgr");
            C1321a.m2829Ib().mo4649Id();
            C1407g.m2946KK().mo4829b(c1406a);
            C1407g.m2946KK().mo4828a(c1406a);
            C1407g.m2946KK().mo4817KM();
            c1406a.cqx = new C45293b(C4996ah.getContext());
            c1406a.cqx.requestFocus();
            if (c1406a.sRn) {
                C43727b.cIj().mo26350b(true, true, c1406a.edV);
            } else {
                C43727b.cIj().mo26350b(true, false, c1406a.edV);
            }
            if (c1406a.sRm) {
                C43727b.cIj().sSP.cKi();
                if (c1406a.sRn) {
                    T = C43727b.cIj().sSP.mo9290dp(c1406a.sRl.field_username, 0);
                } else {
                    T = C43727b.cIj().sSP.mo9290dp(c1406a.sRl.field_username, 1);
                }
                if (T < 0) {
                    c1406a.mo30912mu(false);
                    voipMgr = this.sSQ;
                    AppMethodBeat.m2505o(4634);
                    return voipMgr;
                }
            }
            c1406a.sRd = new HeadsetPlugReceiver();
            c1406a.sRd.mo26276a(C4996ah.getContext(), c1406a.sSk);
            C14058r cIj = C43727b.cIj();
            Context context2 = C4996ah.getContext();
            C4286s c4286s = cIj.sSP;
            c4286s.sNl.jiq = context2;
            c4286s.sNl.sPq = c1406a;
            C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
            C46317a.cLs();
            c1406a.nva = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
            c1406a.nva.listen(c1406a.nvb, 32);
            C43727b.cIj().mo26347an(c1406a.sRn ? 0 : 1, c1406a.sRm);
            C1406a voipMgr22;
            if (C1407g.m2946KK().mo4822KV()) {
                T = 3;
                voipMgr22 = c1406a;
            } else if (C1407g.m2946KK().mo4819KP()) {
                T = 4;
                voipMgr22 = c1406a;
            } else if (c1406a.sRn) {
                T = 1;
                voipMgr22 = c1406a;
            } else {
                T = 2;
                voipMgr22 = c1406a;
            }
            voipMgr22.sRr = T;
            c1406a.sRL = false;
            c1406a.sRu = c1406a.sRn;
            str2 = "voip_recent_contact" + C1853r.m3846Yz();
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("voip_plugin_prefs", 0);
            str = sharedPreferences.getString(str2, null);
            if (str != null) {
                P = C5046bo.m7508P(str.split(";"));
                if (P != null) {
                    int size = P.size();
                    if (P.contains(c1406a.edV)) {
                        if (size > 1) {
                            P.remove(c1406a.edV);
                        }
                        sharedPreferences.edit().putString(str2, C5046bo.m7536c(P, ";")).commit();
                        C4879a.xxA.mo10052c(c1406a.sSm);
                        C4879a.xxA.mo10052c(c1406a.nvc);
                        c43741k = c1406a.sRz;
                        if (!c43741k.jFO.contains(c1406a)) {
                            c43741k.jFO.add(c1406a);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        C4996ah.getContext().registerReceiver(c1406a.sSj, intentFilter);
                        c1406a.mfW = new SensorController(c1406a.getContext());
                        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                        c1406a.mfW.mo10258a(c1406a);
                        voipMgr = this.sSQ;
                        AppMethodBeat.m2505o(4634);
                        return voipMgr;
                    } else if (4 == size) {
                        P.remove(size - 1);
                    }
                    P.add(0, c1406a.edV);
                    sharedPreferences.edit().putString(str2, C5046bo.m7536c(P, ";")).commit();
                    C4879a.xxA.mo10052c(c1406a.sSm);
                    C4879a.xxA.mo10052c(c1406a.nvc);
                    c43741k = c1406a.sRz;
                    if (c43741k.jFO.contains(c1406a)) {
                    }
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    C4996ah.getContext().registerReceiver(c1406a.sSj, intentFilter);
                    c1406a.mfW = new SensorController(c1406a.getContext());
                    C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                    c1406a.mfW.mo10258a(c1406a);
                    voipMgr = this.sSQ;
                    AppMethodBeat.m2505o(4634);
                    return voipMgr;
                }
            }
            P = new ArrayList();
            P.add(0, c1406a.edV);
            sharedPreferences.edit().putString(str2, C5046bo.m7536c(P, ";")).commit();
            C4879a.xxA.mo10052c(c1406a.sSm);
            C4879a.xxA.mo10052c(c1406a.nvc);
            c43741k = c1406a.sRz;
            if (c43741k.jFO.contains(c1406a)) {
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            C4996ah.getContext().registerReceiver(c1406a.sSj, intentFilter);
            c1406a.mfW = new SensorController(c1406a.getContext());
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
            c1406a.mfW.mo10258a(c1406a);
            voipMgr = this.sSQ;
            AppMethodBeat.m2505o(4634);
            return voipMgr;
        } else {
            C4990ab.m7412e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            C14055q.m22208a(pString.value, pBool2.value ? C7620bi.xZc : C7620bi.xZb, pBool.value ? 1 : 0, 4, C4996ah.getContext().getString(C25738R.string.f41));
            AppMethodBeat.m2505o(4634);
            return null;
        }
    }

    /* renamed from: mw */
    public static float m22231mw(boolean z) {
        AppMethodBeat.m2504i(4635);
        float f = 0.74766356f;
        try {
            byte[] bArr;
            C14058r cIj = C43727b.cIj();
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
                C4990ab.m7411d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        AppMethodBeat.m2505o(4635);
        return f;
    }

    public final void cKd() {
        AppMethodBeat.m2504i(4636);
        this.sSP.sTt.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(4636);
    }

    /* renamed from: eA */
    private static boolean m22225eA(Context context) {
        AppMethodBeat.m2504i(4637);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C4990ab.m7410d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                C4990ab.m7416i("MicroMsg.Voip.VoipService", "is in backGround.");
                AppMethodBeat.m2505o(4637);
                return false;
            }
        }
        if (((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.m2505o(4637);
            return false;
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipService", "is in foreGround.");
        AppMethodBeat.m2505o(4637);
        return true;
    }

    /* renamed from: Gj */
    public final void mo26338Gj(int i) {
        AppMethodBeat.m2504i(4638);
        this.sSP.sNl.mo26292Gj(i);
        AppMethodBeat.m2505o(4638);
    }

    public final void cKe() {
        AppMethodBeat.m2504i(4639);
        this.sSP.sNl.sPr.cIZ();
        AppMethodBeat.m2505o(4639);
    }

    /* renamed from: jj */
    public final void mo26362jj(boolean z) {
        int i;
        AppMethodBeat.m2504i(4640);
        C4990ab.m7409c("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", Boolean.valueOf(z));
        byte[] bArr = new byte[1];
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        bArr[0] = (byte) i;
        this.sSP.sNl.sPp.setAppCmd(425, bArr, 1);
        AppMethodBeat.m2505o(4640);
    }
}
