package com.tencent.p177mm.plugin.voip.model;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C40031m.C314542;
import com.tencent.p177mm.plugin.voip.model.C40031m.C400303;
import com.tencent.p177mm.plugin.voip.model.C40031m.C40032b;
import com.tencent.p177mm.plugin.voip.model.p746a.C43729h;
import com.tencent.p177mm.plugin.voip.model.p746a.C43731k;
import com.tencent.p177mm.plugin.voip.model.p746a.C46320j;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ccx;
import com.tencent.p177mm.protocal.protobuf.cmm;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.protocal.protobuf.con;
import com.tencent.p177mm.protocal.protobuf.cpf;
import com.tencent.p177mm.protocal.protobuf.cpg;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.protocal.protobuf.cps;
import com.tencent.p177mm.protocal.protobuf.cpu;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.protocal.protobuf.cqi;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.voip.model.k */
public final class C14047k {
    public boolean cJn;
    public Context jiq;
    C7306ak mHandler;
    public int mStatus;
    public boolean sOL;
    public boolean sOM;
    public boolean sON;
    public boolean sOO;
    public boolean sOP;
    public boolean sOQ;
    public boolean sOR;
    public boolean sOS;
    public ccx sOT;
    public int sOU;
    public long sOV;
    public long sOW;
    public int sOX;
    public int sOY;
    public boolean sOZ;
    public boolean sPA;
    public VoipScoreState sPB;
    public int sPC;
    public C7564ap sPD;
    Timer sPE;
    int sPF;
    private C7564ap sPG;
    private C14046a sPH;
    public boolean sPa;
    public boolean sPb;
    public int sPc;
    private int sPd;
    private int sPe;
    private int sPf;
    private int sPg;
    private int sPh;
    public boolean sPi;
    private boolean sPj;
    private int sPk;
    private boolean sPl;
    private int sPm;
    private int sPn;
    private int sPo;
    public v2protocal sPp;
    public C35358u sPq;
    public C40031m sPr;
    public C4292t sPs;
    public byte[] sPt;
    public cpm sPu;
    public boolean sPv;
    public boolean sPw;
    public int sPx;
    public int sPy;
    public int sPz;

    /* renamed from: com.tencent.mm.plugin.voip.model.k$2 */
    class C42822 implements Runnable {
        C42822() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4392);
            if (C14047k.this.sPq != null) {
                C14047k.this.sPq.cJC();
            }
            AppMethodBeat.m2505o(4392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$4 */
    class C42834 implements Runnable {
        C42834() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4394);
            C14047k.this.sPq.cJB();
            AppMethodBeat.m2505o(4394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$5 */
    class C42845 extends TimerTask {
        C42845() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4395);
            C14047k c14047k = C14047k.this;
            c14047k.sPF++;
            if (C14047k.this.sPp.sVv != 0 || C14047k.this.sPF > 10) {
                C14047k.this.cIR();
                C14047k.this.sPE.cancel();
                C14047k.this.sPE = null;
                AppMethodBeat.m2505o(4395);
                return;
            }
            AppMethodBeat.m2505o(4395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$6 */
    class C140456 implements Runnable {
        C140456() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4396);
            if (C14047k.this.mStatus != 2 && C14047k.this.mStatus != 3 && C14047k.this.mStatus != 4) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + C14047k.this.mStatus);
                AppMethodBeat.m2505o(4396);
            } else if (C14047k.this.sOL) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
                AppMethodBeat.m2505o(4396);
            } else {
                int i;
                int i2;
                C46317a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
                int i3 = ((((C14047k.this.sPp.sUO >> 2) & 3) >> 1) & 1) & (((C14047k.this.sPp.sUO & 3) >> 1) & 1);
                v2protocal v2protocal = C14047k.this.sPp;
                int i4 = C14047k.this.sPp.sTY;
                long j = (long) C14047k.this.sPp.nwu;
                int i5 = C14047k.this.sPp.nwC;
                long j2 = C14047k.this.sPp.nwv;
                byte[] bArr = C14047k.this.sPp.sUa;
                int i6 = C14047k.this.sPp.channelStrategy;
                int i7 = C14047k.this.sPp.sUf;
                int i8 = C14047k.this.sPp.sUg;
                int i9 = C14047k.this.sPp.sUd;
                if (C14047k.this.sPp.sUe == null) {
                    i = 0;
                } else {
                    i = C14047k.this.sPp.sUe.length;
                }
                byte[] bArr2 = C14047k.this.sPp.sUe;
                int i10 = C14047k.this.sPp.sUh;
                int i11 = C14047k.this.sPp.sTX;
                int i12 = C14047k.this.sPp.sUY;
                byte[] bArr3 = C14047k.this.sPp.sUZ;
                int i13 = C14047k.this.sPp.sVa;
                int i14 = C14047k.this.sPp.sUi;
                if (C14047k.this.sPp.sUj == null) {
                    i2 = 0;
                } else {
                    i2 = C14047k.this.sPp.sUj.length;
                }
                int configInfo = v2protocal.setConfigInfo(i4, j, i5, j2, bArr, i6, i7, i8, i9, i, bArr2, i10, i3, i11, i12, bArr3, i13, i14, i2, C14047k.this.sPp.sUj, C14047k.this.sPp.sVb);
                if (configInfo == 0) {
                    configInfo = C14047k.this.sPp.connectToPeerRelay();
                }
                C46317a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i3 + ",  NetType: " + C14047k.this.sPp.sTX + ", EncryptStrategy: " + C14047k.this.sPp.sUY);
                if (configInfo < 0) {
                    C46317a.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(configInfo)));
                    C14047k.this.sPp.sVH.sQe = 14;
                    C14047k.this.mo26330v(1, -9002, "");
                    AppMethodBeat.m2505o(4396);
                    return;
                }
                C14047k.this.sOL = true;
                C14047k.this.sPp.sVH.sQl = (byte) 1;
                C14047k.this.sPp.sVH.sQt = 1;
                AppMethodBeat.m2505o(4396);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$a */
    public interface C14046a {
        /* renamed from: v */
        void mo9299v(int i, int i2, String str);
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$1 */
    class C140481 implements C5015a {
        C140481() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4391);
            C4990ab.m7418v("MicroMsg.Voip.VoipContext", "voip repeat sync");
            C14047k.this.sPs.mo9302a(null, false, 7);
            AppMethodBeat.m2505o(4391);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$7 */
    class C140497 implements Runnable {
        C140497() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4397);
            if (C14047k.this.mStatus != 4 && C14047k.this.mStatus != 5 && C14047k.this.mStatus != 6) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + C14047k.this.mStatus);
                AppMethodBeat.m2505o(4397);
            } else if (C14047k.this.sOM) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
                AppMethodBeat.m2505o(4397);
            } else {
                C14047k.this.sOM = true;
                C46317a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
                int connectToPeerDirect = C14047k.this.sPp.connectToPeerDirect();
                if (connectToPeerDirect < 0) {
                    C46317a.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(connectToPeerDirect)));
                    C14047k.this.sPp.sVH.sQe = 14;
                    C14047k.this.mo26330v(1, -9002, "");
                    AppMethodBeat.m2505o(4397);
                    return;
                }
                C14047k.this.cIU();
                AppMethodBeat.m2505o(4397);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$8 */
    class C140508 implements C5015a {
        C140508() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4398);
            if (C14047k.this.mStatus == 4) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
                C14047k.this.sPp.sVH.sQe = 105;
                C14047k.this.mo26330v(1, -9000, "");
            }
            AppMethodBeat.m2505o(4398);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$9 */
    class C140519 implements Runnable {
        final /* synthetic */ int val$height;
        final /* synthetic */ int val$width;

        C140519(int i, int i2) {
            this.val$width = i;
            this.val$height = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(4399);
            if (C14047k.this.sPp != null) {
                v2protocal.m68583fX(this.val$width, this.val$height);
            }
            AppMethodBeat.m2505o(4399);
        }
    }

    protected C14047k() {
        AppMethodBeat.m2504i(4400);
        this.mStatus = 1;
        this.sOL = false;
        this.sOM = false;
        this.sON = false;
        this.sOO = false;
        this.cJn = false;
        this.sOP = false;
        this.sOQ = false;
        this.sOR = false;
        this.sOS = false;
        this.sOT = new ccx();
        this.sOU = 0;
        this.sOV = 0;
        this.sOW = 0;
        this.sOX = 0;
        this.sOY = 0;
        this.sOZ = false;
        this.sPa = false;
        this.sPb = false;
        this.sPc = 10;
        this.sPd = -1;
        this.sPe = -1;
        this.sPf = -1;
        this.sPg = -1;
        this.sPh = -1;
        this.sPi = false;
        this.sPj = false;
        this.sPk = 1;
        this.sPl = false;
        this.sPm = 1;
        this.sPn = -1;
        this.sPo = -1;
        this.jiq = null;
        this.sPq = C35358u.sTD;
        this.sPt = null;
        this.sPu = null;
        this.sPv = false;
        this.sPw = false;
        this.sPx = 0;
        this.sPy = 0;
        this.sPz = 0;
        this.sPA = false;
        this.sPC = 0;
        this.sPD = new C7564ap(Looper.getMainLooper(), new C140481(), true);
        this.mHandler = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(4393);
                byte[] bArr;
                int i;
                if (message == null || message.what != 59998) {
                    super.handleMessage(message);
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 1) {
                    if (C14047k.this.sPp.nwu == 0) {
                        C46317a.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                        AppMethodBeat.m2505o(4393);
                        return;
                    }
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
                    bArr = (byte[]) message.obj;
                    C4292t c4292t = C14047k.this.sPs;
                    i = message.arg2;
                    cpx cpx = new cpx();
                    cpx.jCt = 1;
                    SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                    sKBuiltinBuffer_t.setBuffer(bArr);
                    cpx.vJd = sKBuiltinBuffer_t;
                    SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                    try {
                        sKBuiltinBuffer_t2.setBuffer(cpx.toByteArray());
                        cpf cpf = new cpf();
                        cpf.wat = i;
                        cpf.wau = sKBuiltinBuffer_t2;
                        cpf.ndG = C1853r.m3846Yz();
                        cpg cpg = new cpg();
                        cpg.jBv = 1;
                        cpg.jBw.add(cpf);
                        c4292t.mo9302a(cpg, true, 2);
                        AppMethodBeat.m2505o(4393);
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                        AppMethodBeat.m2505o(4393);
                    }
                } else if (message.arg1 == 4) {
                    if (C14047k.this.sPp.nwu == 0) {
                        C46317a.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                        AppMethodBeat.m2505o(4393);
                        return;
                    }
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
                    C14047k.this.sPp.sVH.sQe = 107;
                    C14047k.this.mo26330v(1, -9004, "");
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 6) {
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
                    if (C14047k.this.sPp.nwu == 0) {
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                        AppMethodBeat.m2505o(4393);
                        return;
                    }
                    C14047k.this.sON = true;
                    C14047k.this.sPp.sVH.sQu = 1;
                    if (C14047k.this.cJn || C14047k.this.sOO) {
                        C14047k.this.sPp.sUD = 0;
                    } else {
                        C14047k.this.sPp.sUD = 1;
                    }
                    C14047k.this.sPp.setInactive();
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
                    C14047k.this.cIO();
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 3) {
                    C14047k.this.mStatus = 5;
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 5) {
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
                    if (C14047k.this.mStatus >= 5) {
                        C14047k.this.sPp.sVH.sQe = 108;
                    } else {
                        C14047k.this.sPp.sVH.sQe = 106;
                    }
                    if (message.arg2 == 4) {
                        C14047k.this.sPp.sVH.sQw = 1;
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
                    } else if (message.arg2 == 1) {
                        if (C14047k.this.sOR) {
                            C46317a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                            C14047k.this.sOQ = true;
                            AppMethodBeat.m2505o(4393);
                            return;
                        }
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
                        C14047k.this.sON = false;
                        C14047k.this.sPp.sVH.sQw = 5;
                    } else if (message.arg2 == 5) {
                        if (C14047k.this.sOQ) {
                            C14047k.this.sPp.sVH.sQw = 6;
                            C46317a.Logi("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                            C14047k.this.sOQ = true;
                            AppMethodBeat.m2505o(4393);
                            return;
                        }
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "channel network fail");
                        C14047k.this.sPp.sVH.sQw = 6;
                    }
                    C14047k.this.mo26330v(1, -9000, "");
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 100) {
                    C46317a.outputJniLog((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 101) {
                    C46317a.outputJniLog((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 7) {
                    int[] iArr = (int[]) message.obj;
                    int i2 = message.arg2;
                    String str = null;
                    try {
                        str = C5023at.m7474gE(C4996ah.getContext());
                    } catch (Exception e2) {
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
                    }
                    String str2 = null;
                    try {
                        str2 = ((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getSimOperatorName();
                    } catch (Exception e3) {
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
                    }
                    new C46320j(C14047k.this.sOW, C14047k.this.sOV, C14047k.this.sOX, str2, str, C14047k.this.sOY, i2, iArr).cKw();
                    AppMethodBeat.m2505o(4393);
                } else if (message.arg1 == 8) {
                    bArr = (byte[]) message.obj;
                    C14047k c14047k = C14047k.this;
                    try {
                        cmm cmm = (cmm) new cmm().parseFrom(bArr);
                        if (!(c14047k.sPA && cmm.xko == 1)) {
                            C46317a.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + cmm.xko);
                        }
                        switch (cmm.xko) {
                            case 1:
                                if (!c14047k.sPA) {
                                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
                                    c14047k.mo26301am(8, false);
                                    if (cmm.xkp != null) {
                                        ByteBuffer wrap = ByteBuffer.wrap(cmm.xkp.f1226wR, 0, 4);
                                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                                        int min = Math.min(wrap.getInt(), 6);
                                        ByteBuffer allocate = ByteBuffer.allocate(4);
                                        allocate.order(ByteOrder.LITTLE_ENDIAN);
                                        allocate.putInt(min);
                                        C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(min)));
                                        c14047k.sPp.setAppCmd(30, allocate.array(), 4);
                                    } else {
                                        C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
                                    }
                                }
                                c14047k.sPA = true;
                                AppMethodBeat.m2505o(4393);
                                return;
                            case 2:
                                C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
                                c14047k.sPr.sPU = true;
                                AppMethodBeat.m2505o(4393);
                                return;
                            case 3:
                                if (cmm.xkp != null) {
                                    bArr = cmm.xkp.f1226wR;
                                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(bArr)));
                                    i = c14047k.sPp.setAppCmd(302, bArr, 4);
                                    if (i < 0) {
                                        C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr + "fail:" + i + ", [roomid=" + c14047k.sPp.nwC + ", roomkey=" + c14047k.sPp.nwv + "]");
                                    }
                                    AppMethodBeat.m2505o(4393);
                                    return;
                                }
                                C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                AppMethodBeat.m2505o(4393);
                                return;
                            case 4:
                                if (cmm.xkp != null) {
                                    con con = (con) new con().parseFrom(cmm.xkp.f1226wR);
                                    C46317a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + con.xmt);
                                    byte[] bArr2 = new byte[4];
                                    bArr2[0] = (byte) con.xmt;
                                    c14047k.sPp.setJNIAppCmd(2, bArr2, 4);
                                    AppMethodBeat.m2505o(4393);
                                    return;
                                }
                                C46317a.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                                AppMethodBeat.m2505o(4393);
                                return;
                            case 5:
                                if (cmm.xkp == null) {
                                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodDisableCodec] empty buffer");
                                    break;
                                }
                                bArr = cmm.xkp.f1226wR;
                                if (c14047k.sPp != null) {
                                    c14047k.sPp.setAppCmd(35, bArr, 4);
                                }
                                AppMethodBeat.m2505o(4393);
                                return;
                        }
                        AppMethodBeat.m2505o(4393);
                    } catch (Exception e4) {
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
                        AppMethodBeat.m2505o(4393);
                    }
                } else {
                    int[] iArr2;
                    if (message.arg1 == 9) {
                        C46323n c46323n = C14047k.this.sPp.sVH;
                        if (0 == c46323n.sQI) {
                            c46323n.sQI = System.currentTimeMillis();
                            C46317a.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + c46323n.sQI);
                        }
                        C46317a.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
                        if (1 == C14047k.this.sPp.sVk) {
                            cqi cqi = new cqi();
                            cqi.jBT = 1;
                            C14047k.this.sPs.mo9304a(cqi, 2);
                            AppMethodBeat.m2505o(4393);
                            return;
                        }
                    } else if (message.arg1 == 11) {
                        C14047k.this.sPC = 2;
                        AppMethodBeat.m2505o(4393);
                        return;
                    } else if (message.arg1 == 12) {
                        C14047k.this.sPC = 1;
                        AppMethodBeat.m2505o(4393);
                        return;
                    } else if (message.arg1 == 13) {
                        iArr2 = (int[]) message.obj;
                        new C43729h(C14047k.this.sPp.nwu, C14047k.this.sPp.nwv, C14047k.this.sPp.nwC, 1, message.arg2, iArr2).cKw();
                        AppMethodBeat.m2505o(4393);
                        return;
                    } else if (message.arg1 == 14) {
                        iArr2 = (int[]) message.obj;
                        new C43729h(C14047k.this.sPp.nwu, C14047k.this.sPp.nwv, C14047k.this.sPp.nwC, 2, message.arg2, iArr2).cKw();
                    }
                    AppMethodBeat.m2505o(4393);
                }
            }
        };
        this.sPE = null;
        this.sPF = 0;
        this.sPG = new C7564ap(Looper.getMainLooper(), new C140508(), false);
        this.sPH = null;
        this.sPp = new v2protocal(this.mHandler);
        this.sPr = new C40031m(this);
        this.sPs = new C4292t(this);
        this.sPz = 0;
        this.sPB = new VoipScoreState();
        AppMethodBeat.m2505o(4400);
    }

    public final void reset() {
        AppMethodBeat.m2504i(4401);
        C4990ab.m7416i("MicroMsg.Voip.VoipContext", "reset");
        this.sPq.cJD();
        if (this.sPp.cKK()) {
            this.sPp.mo63320mx(false);
        }
        this.sPp.reset();
        this.sPd = -1;
        this.sPe = -1;
        this.sPf = -1;
        this.sPg = -1;
        this.sPh = -1;
        this.sPr.cIY();
        this.sPp.sUs = 0;
        this.sPG.stopTimer();
        this.sPs.cKs();
        this.sPD.stopTimer();
        this.sOL = false;
        this.sON = false;
        this.sOM = false;
        this.sOO = false;
        this.cJn = false;
        this.sOP = false;
        this.sPt = null;
        this.sPu = null;
        this.sOZ = false;
        this.sPa = false;
        this.sPb = false;
        this.sPi = false;
        this.sPj = false;
        this.sPl = false;
        this.sPk = 1;
        this.sPm = 1;
        this.sPv = false;
        this.sPn = -1;
        this.sPo = -1;
        this.sOQ = false;
        this.sOR = false;
        this.sOP = false;
        this.sOL = false;
        this.sOS = false;
        this.sPc = 10;
        this.mStatus = 1;
        this.sPz = 0;
        this.sPC = 0;
        this.sPA = false;
        AppMethodBeat.m2505o(4401);
    }

    public final void cIE() {
        int i = 0;
        AppMethodBeat.m2504i(4402);
        if (this.sOL && this.sOU == 0) {
            this.sOU = 1;
            if (this.sPp.field_speedTestInfoLength < 8) {
                C46317a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.m2505o(4402);
                return;
            }
            int i2 = this.sPp.sVF[1];
            if (i2 + 2 > this.sPp.field_speedTestInfoLength) {
                C46317a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.m2505o(4402);
                return;
            }
            int i3 = this.sPp.sVF[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.sPp.field_speedTestInfoLength) {
                C46317a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.m2505o(4402);
                return;
            }
            int i4;
            this.sOV = this.sPp.nwv;
            this.sOX = this.sPp.netType;
            this.sOY = this.sPp.nwu;
            this.sOT.wem = this.sPp.nwu;
            this.sOT.xcr = this.sPp.sUl;
            this.sOT.vZF = this.sPp.netType;
            this.sOT.xcs = this.sOL ? 1 : 0;
            ccx ccx = this.sOT;
            if (this.sON) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ccx.xct = i2;
            this.sOT.xcu = this.sPp.sVF[0];
            i3 = 2;
            this.sOT.xcv = this.sPp.sVF[1];
            i2 = 0;
            while (true) {
                i4 = i3;
                if (i2 >= this.sOT.xcv) {
                    break;
                }
                i3 = i4 + 1;
                this.sOT.xcw.add(Integer.valueOf(this.sPp.sVF[i4]));
                i2++;
            }
            int i5 = i4 + 1;
            this.sOT.xcx = this.sPp.sVF[i4];
            i2 = i5 + 1;
            this.sOT.xcy = this.sPp.sVF[i5];
            while (i < this.sOT.xcy) {
                i4 = i2 + 1;
                this.sOT.xcz.add(Integer.valueOf(this.sPp.sVF[i2]));
                i++;
                i2 = i4;
            }
            i3 = i2 + 1;
            this.sOT.xcA = this.sPp.sVF[i2];
            this.sOT.xcB = this.sPp.sVF[i3];
            new C43731k(this.sOT).cKw();
            AppMethodBeat.m2505o(4402);
            return;
        }
        C46317a.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.sOL + " ,mSpeedTestStatus=" + this.sOU);
        AppMethodBeat.m2505o(4402);
    }

    public final void cIF() {
        AppMethodBeat.m2504i(4403);
        if (this.sOU == 0) {
            AppMethodBeat.m2505o(4403);
        } else if (this.sOU == 1) {
            this.sOU = 0;
            this.sPp.sVp = 0;
            AppMethodBeat.m2505o(4403);
        } else {
            this.sOU = 0;
            v2protocal v2protocal = this.sPp;
            C46317a.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            v2protocal.StopSpeedTest();
            v2protocal.sVp = 0;
            AppMethodBeat.m2505o(4403);
        }
    }

    /* renamed from: Gd */
    public final void mo26286Gd(int i) {
        AppMethodBeat.m2504i(4404);
        this.sPp.sUm = Math.abs(i);
        AppMethodBeat.m2505o(4404);
    }

    /* renamed from: Ge */
    public final void mo26287Ge(int i) {
        AppMethodBeat.m2504i(4405);
        this.sPp.sUn = Math.abs(i);
        AppMethodBeat.m2505o(4405);
    }

    public final void cIG() {
        AppMethodBeat.m2504i(4406);
        this.sPp.sUo = this.sPr.cIX();
        this.sPp.sUp = this.sPr.cIs();
        AppMethodBeat.m2505o(4406);
    }

    /* renamed from: Gf */
    public final void mo26288Gf(int i) {
        this.sPp.sUq = i;
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(4407);
        cIV();
        this.mHandler.post(new C42822());
        AppMethodBeat.m2505o(4407);
    }

    /* renamed from: a */
    public final boolean mo26300a(cpm cpm) {
        this.sPu = cpm;
        this.sPp.nMl = this.sPu.xmT;
        this.sPp.nwu = this.sPu.wem;
        this.sPp.nwv = this.sPu.wen;
        this.sPp.nwC = 1;
        this.sPp.sTY = 0;
        this.mStatus = 3;
        return true;
    }

    public final void setStatus(int i) {
        AppMethodBeat.m2504i(4408);
        if (i == this.mStatus) {
            AppMethodBeat.m2505o(4408);
            return;
        }
        if (i == 4) {
            this.sPG.mo16770ae(60000, 60000);
        }
        this.mStatus = i;
        AppMethodBeat.m2505o(4408);
    }

    public final int cIH() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        if (this.mStatus != 4) {
            return 3;
        }
        return 2;
    }

    public final boolean cII() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean cIJ() {
        AppMethodBeat.m2504i(4409);
        C4990ab.m7411d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", Integer.valueOf(this.mStatus));
        if (this.mStatus == 1) {
            AppMethodBeat.m2505o(4409);
            return false;
        }
        AppMethodBeat.m2505o(4409);
        return true;
    }

    public final int cIt() {
        AppMethodBeat.m2504i(4410);
        C40031m c40031m = this.sPr;
        if (c40031m.sPL != null) {
            int cIt = c40031m.sPL.cIt();
            AppMethodBeat.m2505o(4410);
            return cIt;
        }
        AppMethodBeat.m2505o(4410);
        return 0;
    }

    /* renamed from: Gg */
    public final void mo26289Gg(int i) {
        AppMethodBeat.m2504i(4411);
        if (8 == i || 9 == i) {
            this.sPh = i;
        } else {
            this.sPf = i;
            this.sPd = i;
        }
        if (1 == i || 3 == i) {
            mo26290Gh(2);
        }
        this.sPq.mo30876Gt(i);
        AppMethodBeat.m2505o(4411);
    }

    /* renamed from: Gh */
    public final void mo26290Gh(int i) {
        AppMethodBeat.m2504i(4412);
        if (8 == i || 9 == i) {
            this.sPg = i;
        } else {
            this.sPd = i;
            this.sPe = i;
        }
        this.sPs.mo9301GB(i);
        AppMethodBeat.m2505o(4412);
    }

    public final long cIK() {
        return (long) this.sPp.sUl;
    }

    public final boolean cIL() {
        if (this.sPb) {
            return false;
        }
        switch (this.sPd) {
            case -1:
                return true;
            case 0:
                if (4 != this.sPe) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.sPe || -1 == this.sPe)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.sPe || 6 == this.sPe || 7 == this.sPe) {
                    return false;
                }
        }
        return true;
    }

    public final boolean cIM() {
        if (this.sPb) {
            return false;
        }
        switch (this.sPd) {
            case -1:
                return true;
            case 0:
                if (4 != this.sPe) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.sPf || this.sPf == 0 || -1 == this.sPf)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.sPf || 6 == this.sPf || 7 == this.sPf) {
                    return false;
                }
        }
        return true;
    }

    /* renamed from: mo */
    public final int mo26324mo(boolean z) {
        int appCmd;
        AppMethodBeat.m2504i(4413);
        if (z) {
            appCmd = this.sPp.setAppCmd(412);
        } else {
            appCmd = this.sPp.setAppCmd(413);
        }
        if (appCmd < 0) {
            C46317a.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.m2505o(4413);
        return appCmd;
    }

    /* renamed from: mp */
    public final int mo26325mp(boolean z) {
        int appCmd;
        AppMethodBeat.m2504i(4414);
        if (z) {
            appCmd = this.sPp.setAppCmd(401);
        } else {
            appCmd = this.sPp.setAppCmd(402);
        }
        if (appCmd < 0) {
            C46317a.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.m2505o(4414);
        return appCmd;
    }

    private void cIN() {
        AppMethodBeat.m2504i(4415);
        C46317a.Logd("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + C1427q.etd.eqq);
        if (C1427q.etd.epS == 1) {
            this.sPp.setAppCmd(410);
        }
        byte[] bArr = new byte[2];
        if (C1427q.etd.eqq >= 0) {
            bArr[0] = (byte) C1427q.etd.eqq;
            this.sPp.setAppCmd(406, bArr, 1);
        } else if (C1427q.etd.eqq == -2) {
            this.sPp.setAppCmd(407);
        }
        if (C1427q.etd.eqr >= 0) {
            bArr[0] = (byte) C1427q.etd.eqr;
            this.sPp.setAppCmd(408, bArr, 1);
        } else if (C1427q.etd.eqr == -2) {
            this.sPp.setAppCmd(409);
        }
        C5141c ll = C18624c.abi().mo17131ll("100447");
        if (ll.isValid() && 1 == C5046bo.getInt((String) ll.dru().get("SetVoipRnnNsOn"), 0)) {
            this.sPp.setAppCmd(v2helper.EMethodSetSendToNetworkOn, new byte[]{(byte) C5046bo.getInt((String) ll.dru().get("SetVoipRnnNsOn"), 0)}, 1);
        }
        if (C1427q.etd.eqt >= 0) {
            byte[] bArr2 = new byte[5];
            if (C1427q.etd.equ >= 0 && C1427q.etd.eqv >= 0) {
                bArr2[0] = (byte) C1427q.etd.equ;
                bArr2[1] = (byte) C1427q.etd.eqv;
                if (C1427q.etd.eqw >= 0) {
                    bArr2[2] = (byte) C1427q.etd.eqw;
                    bArr2[3] = (byte) C1427q.etd.eqt;
                    bArr2[4] = (byte) C1427q.etd.eqx;
                    this.sPp.setAppCmd(404, bArr2, 5);
                } else {
                    this.sPp.setAppCmd(404, bArr2, 2);
                }
            }
        } else if (C1427q.etd.eqt == -2) {
            this.sPp.setAppCmd(405);
        }
        if (C1427q.etd.epT >= 0 || C1427q.etd.epV >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (C1427q.etd.epT >= 0) {
                bArr[0] = (byte) C1427q.etd.epT;
            }
            if (C1427q.etd.epV >= 0) {
                bArr[1] = (byte) C1427q.etd.epV;
            }
            this.sPp.setAppCmd(414, bArr, 2);
        }
        if (C1427q.etd.epU >= 0 || C1427q.etd.epW >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (C1427q.etd.epU >= 0) {
                bArr[0] = (byte) C1427q.etd.epU;
            }
            if (C1427q.etd.epW >= 0) {
                bArr[1] = (byte) C1427q.etd.epW;
            }
            this.sPp.setAppCmd(415, bArr, 2);
        }
        if (C1427q.etd.epX >= 0 || C1427q.etd.epY >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (C1427q.etd.epX >= 0) {
                bArr[0] = (byte) C1427q.etd.epX;
            }
            if (C1427q.etd.epY >= 0) {
                bArr[1] = (byte) C1427q.etd.epY;
            }
            this.sPp.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr, 2);
        }
        if (C1427q.etd.epZ >= 0) {
            bArr[0] = (byte) C1427q.etd.epZ;
            this.sPp.setAppCmd(416, bArr, 1);
        }
        if (C1427q.etd.eqd >= 0) {
            bArr[0] = (byte) C1427q.etd.eqd;
            this.sPp.setAppCmd(431, bArr, 4);
        }
        if (C1427q.etd.eqa >= 0 && !(this.sPp.sUM == 0 && C1427q.etd.eqa == 5)) {
            bArr[0] = (byte) C1427q.etd.eqa;
            this.sPp.setAppCmd(417, bArr, 1);
        }
        if (C1427q.etd.eqb >= 0 && !(this.sPp.sUM == 0 && C1427q.etd.eqb == 5)) {
            bArr[0] = (byte) C1427q.etd.eqb;
            this.sPp.setAppCmd(418, bArr, 1);
        }
        if (C1427q.etd.eqc >= 0) {
            bArr[0] = (byte) C1427q.etd.eqc;
            this.sPp.setAppCmd(419, bArr, 1);
        }
        if (this.sPp.sUM == 1 && (C1427q.etd.eqa == 5 || C1427q.etd.eqb == 5)) {
            this.sPp.sUy = 5;
        }
        if (1 == C1427q.etd.eqA) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (C1427q.etd.eqB[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((C1427q.etd.eqB[i] >> 8) & 255);
            }
            this.sPp.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr3, 30);
        }
        if (C1427q.etd.eqA == 0) {
            this.sPp.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff);
        }
        if (C1427q.etd.eqC[0] > (short) 0 || C1427q.etd.eqC[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (C1427q.etd.eqC[0] > (short) 0 && C1427q.etd.eqC[0] < (short) 10000) {
                bArr[0] = (byte) C1427q.etd.eqC[0];
            }
            if (C1427q.etd.eqC[1] > (short) 0 && C1427q.etd.eqC[1] < (short) 10000) {
                bArr[1] = (byte) C1427q.etd.eqC[1];
            }
            this.sPp.setAppCmd(v2helper.EMethodSetNgStrength, bArr, 2);
        }
        if (C1427q.etd.eqE > 0) {
            bArr[0] = (byte) C1427q.etd.eqE;
            this.sPp.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr, 1);
        }
        if (C1427q.etd.eqM >= 0) {
            this.sPp.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) C1427q.etd.eqM, (byte) C1427q.etd.eqN, (byte) C1427q.etd.eqO, (byte) C1427q.etd.eqP}, 4);
        }
        AppMethodBeat.m2505o(4415);
    }

    public final void cIO() {
        AppMethodBeat.m2504i(4416);
        C46317a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.sOP && this.sON) {
            C46317a.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.sPp.setActive();
            if (this.sOS) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.sOS);
                AppMethodBeat.m2505o(4416);
                return;
            }
            int i;
            Object obj;
            this.sPp.setSvrConfig(205, 0, 0, this.sPp.sVb, 0, 0, 0);
            C46317a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.sPp.sVb + " SwitchFlag = " + this.sPp.sUi);
            if (this.sPp.startEngine() == 0) {
                this.sPp.sVH.sQE = 0;
            } else {
                this.sOS = false;
                this.sPp.sVH.sQE = 1;
            }
            cIN();
            if (!cIL() && !cIM()) {
                cIR();
            } else if (this.sPE != null) {
                cIR();
            } else {
                this.sPE = new Timer();
                this.sPF = 0;
                this.sPE.schedule(new C42845(), 200, 200);
            }
            this.sPq.cJE();
            C40031m c40031m = this.sPr;
            if (c40031m.kzf == 2) {
                C46317a.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                c40031m.kzf = 2;
                c40031m.sPU = false;
                c40031m.sPV = 0;
                if (c40031m.sQa != null) {
                    C46317a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    c40031m.sQa.sQd = true;
                    C7305d.xDG.remove(c40031m.sQa);
                    c40031m.sQa = null;
                }
                c40031m.sQa = new C40032b();
                C7305d.post(c40031m.sQa, "VoipDeviceHandler_decode");
                C46317a.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                C1427q.etd.dump();
                c40031m.sPL = new C29496c();
                C22458a c22458a = new C22458a();
                C46317a.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + c22458a.pug + ", framelen: " + c22458a.sNh + ", ret:" + c40031m.sNl.sPp.mo63273a(c22458a));
                c40031m.sPL.mo47750G(c22458a.pug, c22458a.channels, c22458a.sNh, 0);
                c40031m.kzg = c40031m.sPL.mo47759x(c40031m.sNl.jiq, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (c40031m.sPL.sNk ? 1 : 0);
                c40031m.sNl.sPp.setAppCmd(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE, bArr, 1);
                if (c40031m.kzg <= 10) {
                    if (c40031m.kzg <= 0) {
                        c40031m.kzj = 1;
                    }
                    c40031m.kzg = 92;
                }
                if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                    C43727b.cIj().mo26362jj(true);
                } else {
                    C43727b.cIj().mo26362jj(false);
                }
                c40031m.sPL.sNt = new C314542();
                if (c40031m.sPL.cIp() <= 0) {
                    c40031m.kzj = 1;
                }
                C7305d.m12298f(new C400303(), "voip_start_record");
            }
            C46323n c46323n = this.sPp.sVH;
            if (c46323n.beginTime == 0) {
                c46323n.sQx = 0;
            } else {
                c46323n.sQx = (int) (System.currentTimeMillis() - c46323n.beginTime);
            }
            C46317a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + c46323n.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            C46317a.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + c46323n.sQx);
            this.sPq.onConnected();
            this.mStatus = 5;
            c46323n = this.sPp.sVH;
            c46323n.sQF = System.currentTimeMillis();
            C46317a.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + c46323n.sQF);
            this.sPp.setSvrConfig(202, this.sPp.sUE, this.sPp.sUF, 0, 0, 0, 0);
            this.sPp.setSvrConfig(203, 0, 0, this.sPp.sUJ, 0, 0, 0);
            this.sPp.setSvrConfig(206, 0, 0, this.sPp.sUN, 0, 0, 0);
            this.sPp.setSvrConfig(103, this.sPp.sUG, this.sPp.sUH, this.sPp.sUI, this.sPp.sUL, 0, 0);
            this.sPp.setSvrConfig(205, 0, 0, this.sPp.sVb, 0, 0, 0);
            this.sPp.setSvrConfig(207, 0, 0, this.sPp.sUi, 0, 0, 0);
            C46317a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.sPp.sVb + " SwitchFlag = " + this.sPp.sUi);
            int i2 = (this.sPp.sUO >> 2) & 3;
            int i3 = this.sPp.sUO & 3;
            if (this.sPp.nwC == 0) {
                i = (i2 << 2) + i3;
            } else {
                i = (i3 << 2) + i2;
            }
            this.sPp.setSvrConfig(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE, 0, 0, i, 0, 0, 0);
            this.sPp.setSvrConfig(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS, 0, 0, this.sPp.sUP, this.sPp.sUQ, this.sPp.sUR, this.sPp.sUS);
            if (!(this.sPp.sVg == null || this.sPp.sVh == null)) {
                this.sPp.setSvrConfig(504, 0, 0, this.sPp.sVf, 0, 0, 0);
                this.sPp.setSvrConfig(505, 0, 0, this.sPp.sVg[0], this.sPp.sVg[1], this.sPp.sVg[2], this.sPp.sVg[3]);
                this.sPp.setSvrConfig(506, 0, 0, this.sPp.sVh[0], this.sPp.sVh[1], 0, 0);
                C46317a.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.sPp.sVf + ",FECKeyPara1 = " + this.sPp.sVg[0] + "," + this.sPp.sVg[1] + "," + this.sPp.sVg[2] + "," + this.sPp.sVg[3] + ",FECKeyPara2 = " + this.sPp.sVh[0] + "," + this.sPp.sVh[1]);
            }
            this.sPp.setSvrConfig(507, 0, 0, (this.sPp.sUT & 4) >> 2, (this.sPp.sUT & 2) >> 1, this.sPp.sUT & 1, 0);
            this.sPp.setjbmbitraterssvrparam();
            C46317a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.sPp.sUE + ",audioTsdEdge = " + this.sPp.sUF + ",passthroughQosAlgorithm = " + this.sPp.sUG + ",fastPlayRepair = " + this.sPp.sUH + ", audioDTX = " + this.sPp.sUJ + ", mARQFlag = " + i + ", mQosStrategy = " + this.sPp.sUT + ", mSvrCfgListV = " + this.sPp.sUI + ", maxBRForRelay = " + this.sPp.sUL);
            byte[] bArr2 = new byte[]{(byte) C1427q.etc.eru, (byte) -1};
            C46317a.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            C46317a.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.sPp.setAppCmd(15, bArr2, 1);
            C46317a.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + C7243d.vxo);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(C7243d.vxo);
            this.sPp.setAppCmd(505, allocate.array(), 4);
            if ((this.sPp.sUi & 2) == 0) {
                mo26301am(16, true);
            }
            bArr2 = new byte[4];
            this.sPp.setAppCmd(26, bArr2, 4);
            allocate = ByteBuffer.wrap(bArr2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int i4 = allocate.getInt();
            C46317a.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(i4)));
            Object obj2 = ((this.sPp.sUI & 4) != 0 || C1427q.etc.erw > 0) ? 1 : null;
            if (obj2 == null && this.sPp.sVM) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
                obj = (i4 & 4) != 0 ? 1 : null;
                obj2 = (i4 & 8) != 0 ? 1 : null;
                if (!(obj == null && obj2 == null)) {
                    this.sPr.sPU = true;
                    mo26326mq(false);
                }
                this.sPp.sVM = false;
            }
            if (this.sPp.sVM) {
                v2protocal v2protocal = this.sPp;
                int i5 = C1427q.etc.erw;
                boolean z = false;
                Object obj3 = (i4 & 4) != 0 ? 1 : null;
                obj = (i4 & 8) != 0 ? 1 : null;
                if (!(obj3 == null && obj == null)) {
                    String str = obj3 != null ? "video/hevc" : "video/avc";
                    v2protocal.sVI = new C46321e(v2protocal.width, v2protocal.height, v2protocal.sVK, v2protocal.bitrate, i5, str);
                    C46317a.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(str)));
                    if (v2protocal.sVL != null) {
                        v2protocal.sVJ = new C43732d(v2protocal.sVL);
                        C46317a.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                    }
                    z = true;
                    if (v2protocal.sVI == null || v2protocal.sVJ == null) {
                        v2protocal.sVM = false;
                        z = false;
                    }
                }
                C46317a.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + z + ", iHW:" + i4);
                if (!this.sPp.sVM) {
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                    this.sPr.sPU = true;
                    mo26326mq(false);
                }
            }
            if (this.sPp.sVI != null) {
                this.sPp.sVI.sNl = this;
            }
            if (v2protocal.sVJ != null) {
                v2protocal.sVJ.mo69420a(this);
            }
            this.sOS = true;
            this.sPA = false;
            this.sPB.nxT = C1829bf.aaa();
            C4990ab.m7417i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", Long.valueOf(r0.nxT));
            AppMethodBeat.m2505o(4416);
            return;
        }
        C46317a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.sOP + ", isChannelConnectedSuccess " + this.sON);
        AppMethodBeat.m2505o(4416);
    }

    /* renamed from: mq */
    public final void mo26326mq(boolean z) {
        AppMethodBeat.m2504i(4417);
        if (z) {
            mo26291Gi(2);
        }
        if (this.sPp != null) {
            C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
            mo26301am(8, false);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(6);
            C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
            this.sPp.setAppCmd(30, allocate.array(), 4);
        }
        AppMethodBeat.m2505o(4417);
    }

    /* renamed from: am */
    public final int mo26301am(int i, boolean z) {
        AppMethodBeat.m2504i(4418);
        if (i < 0) {
            AppMethodBeat.m2505o(4418);
            return -1;
        }
        C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + i + ", local=" + z + ", remote =true");
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        if (z) {
            try {
                if (this.sPp != null) {
                    cmm cmm = new cmm();
                    cmm.xko = 5;
                    cmm.xkp = new C1332b(allocate.array());
                    C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(i)));
                    this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                }
            } catch (Exception e) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
            }
        }
        C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(i)));
        this.sPp.setAppCmd(35, allocate.array(), 4);
        AppMethodBeat.m2505o(4418);
        return 1;
    }

    public final boolean cIP() {
        AppMethodBeat.m2504i(4419);
        boolean cIL = cIL();
        int i = 0;
        if (cIL) {
            i = 1;
        }
        if (this.sPn == -1 || this.sPn != i) {
            this.sPn = i;
            if (cIL) {
                C46317a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.sPp.setAppCmd(203);
            } else {
                C46317a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.sPp.setAppCmd(202);
            }
        }
        AppMethodBeat.m2505o(4419);
        return cIL;
    }

    public final boolean cIQ() {
        AppMethodBeat.m2504i(4420);
        boolean cIM = cIM();
        int i = 0;
        if (cIM) {
            i = 1;
        }
        if (this.sPo == -1 || this.sPo != i) {
            this.sPo = i;
            if (cIM) {
                C46317a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.sPp.setAppCmd(201);
            } else {
                C46317a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.sPp.setAppCmd(200);
            }
        }
        AppMethodBeat.m2505o(4420);
        return cIM;
    }

    /* renamed from: Gi */
    public final void mo26291Gi(int i) {
        AppMethodBeat.m2504i(4422);
        try {
            cmm cmm = new cmm();
            cmm.xko = i;
            if (1 == i) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(6);
                cmm.xkp = new C1332b(allocate.array());
                this.sPp.setAppCmd(32, allocate.array(), 4);
            } else {
                cmm.xkp = null;
            }
            this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
            C46317a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(4422);
        } catch (Exception e) {
            C46317a.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
            AppMethodBeat.m2505o(4422);
        }
    }

    /* renamed from: Gj */
    public final void mo26292Gj(int i) {
        AppMethodBeat.m2504i(4423);
        C46317a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            this.sPp.setJNIAppCmd(2, bArr, 4);
            con con = new con();
            con.xmt = i;
            con.xmu = 1;
            cmm cmm = new cmm();
            cmm.xko = 4;
            cmm.xkp = new C1332b(con.toByteArray(), 0, 1);
            this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
            AppMethodBeat.m2505o(4423);
        } catch (Exception e) {
            C46317a.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
            AppMethodBeat.m2505o(4423);
        }
    }

    private void cIS() {
        AppMethodBeat.m2504i(4424);
        C5004al.m7441d(new C140456());
        AppMethodBeat.m2505o(4424);
    }

    public final void cIT() {
        AppMethodBeat.m2504i(4425);
        boolean z = !C5046bo.m7540cb(this.sPp.sUa);
        C46317a.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + z + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.sOR + ",isRemoteAccepted:" + this.sOO + ",isLocalAccept:" + this.cJn);
        this.sPp.sVH.sQq = 7;
        if (z && (this.mStatus == 4 || this.mStatus == 5 || this.mStatus == 6 || ((this.mStatus == 2 && this.sOR) || (this.mStatus == 3 && this.sOR)))) {
            if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
                C46317a.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
                AppMethodBeat.m2505o(4425);
                return;
            } else if (this.sOO || this.cJn) {
                if (!this.sOL) {
                    cIS();
                }
                C5004al.m7441d(new C140497());
            } else if (this.sOR && !this.sOL) {
                cIS();
                AppMethodBeat.m2505o(4425);
                return;
            }
        }
        AppMethodBeat.m2505o(4425);
    }

    public final void cIU() {
        AppMethodBeat.m2504i(4426);
        if (this.sOM && !C5046bo.m7540cb(this.sPp.sUc)) {
            int handleCommand = this.sPp.handleCommand(this.sPp.sUc, this.sPp.sUc.length);
            if (handleCommand < 0) {
                C46317a.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(handleCommand)));
            }
            this.sPp.sUc = null;
        }
        AppMethodBeat.m2505o(4426);
    }

    /* renamed from: bo */
    public final void mo26303bo(byte[] bArr) {
        AppMethodBeat.m2504i(4427);
        C4990ab.m7416i("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.sPp.sVH.sQj = (byte) 1;
        this.sPp.sVH.sQi = (byte) 1;
        this.sPp.sUa = bArr;
        AppMethodBeat.m2505o(4427);
    }

    /* renamed from: b */
    public final void mo26302b(int i, byte[] bArr, byte[] bArr2) {
        this.sPp.sVf = i;
        this.sPp.sVg = bArr;
        this.sPp.sVh = bArr2;
    }

    /* renamed from: a */
    public final void mo26299a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.sPp.sUd = i;
        this.sPp.sUe = bArr;
        this.sPp.sUY = i2;
        this.sPp.sUZ = bArr2;
    }

    /* renamed from: Gk */
    public final void mo26293Gk(int i) {
        this.sPp.sVa = i;
    }

    /* renamed from: a */
    public final void mo26298a(cok cok, cok cok2, cok cok3, LinkedList<cps> linkedList) {
        AppMethodBeat.m2504i(4428);
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        cpu cpu;
        if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
            cpu = new cpu();
            cpu.xnK = 0;
            cpu.xnL = 0;
            cpu.xnM = 0;
            cpu.userName = "";
            cpu.gDC = "";
            if (this.sPp.mo63275a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                C4990ab.m7416i("MicroMsg.Voip.VoipContext", "setIp fail!");
            }
            AppMethodBeat.m2505o(4428);
            return;
        }
        cpu = new cpu();
        try {
            cpu.xnK = 1;
            cpu.xnL = defaultPort;
            cpu.xnM = 0;
            cpu.userName = "";
            cpu.gDC = "";
            cpu.xnL = C46317a.m86985Pz(InetAddress.getByName(defaultHost).getHostAddress());
            if (this.sPp.mo63275a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                C4990ab.m7416i("MicroMsg.Voip.VoipContext", "setIp fail!");
                AppMethodBeat.m2505o(4428);
                return;
            }
        } catch (UnknownHostException e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipContext", e, "", new Object[0]);
            if (this.sPp.mo63275a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                C4990ab.m7416i("MicroMsg.Voip.VoipContext", "setIp fail!");
                AppMethodBeat.m2505o(4428);
                return;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.sPp.mo63275a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                C4990ab.m7416i("MicroMsg.Voip.VoipContext", "setIp fail!");
            }
            AppMethodBeat.m2505o(4428);
        }
        AppMethodBeat.m2505o(4428);
    }

    /* renamed from: i */
    public final void mo26323i(int i, int i2, int i3, int i4, int i5) {
        this.sPp.sUO = i;
        this.sPp.sUP = i2;
        this.sPp.sUQ = i3;
        this.sPp.sUR = i4;
        this.sPp.sUS = i5;
    }

    /* renamed from: Gl */
    public final void mo26294Gl(int i) {
        this.sPp.sUT = i;
    }

    /* renamed from: bp */
    public final void mo26304bp(byte[] bArr) {
        AppMethodBeat.m2504i(4429);
        C4990ab.m7417i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", Byte.valueOf(this.sPp.sVH.sQn));
        if (this.sPp.sVH.sQn == (byte) 1 || bArr == null) {
            AppMethodBeat.m2505o(4429);
            return;
        }
        this.sPp.sVH.sQn = (byte) 1;
        this.sPp.sUb = bArr;
        int exchangeCabInfo = this.sPp.exchangeCabInfo(this.sPp.sUb, this.sPp.sUb.length);
        if (exchangeCabInfo < 0) {
            C46317a.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(exchangeCabInfo)));
            this.sPp.sVH.sQe = 15;
            mo26330v(1, -9003, "");
        }
        AppMethodBeat.m2505o(4429);
    }

    /* renamed from: Gm */
    public final void mo26295Gm(int i) {
        this.sPp.sVH.sQk = (byte) 1;
        this.sPp.channelStrategy = i;
    }

    /* renamed from: Gn */
    public final void mo26296Gn(int i) {
        this.sPp.sUh = i;
    }

    /* renamed from: bq */
    public final void mo26305bq(byte[] bArr) {
        AppMethodBeat.m2504i(4430);
        this.sPp.sUc = bArr;
        cIU();
        AppMethodBeat.m2505o(4430);
    }

    public final void cIV() {
        AppMethodBeat.m2504i(4431);
        C4990ab.m7416i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.sPD.stopTimer();
        AppMethodBeat.m2505o(4431);
    }

    /* renamed from: a */
    public final void mo26297a(C14046a c14046a) {
        if (c14046a != null) {
            this.sPH = c14046a;
        }
    }

    /* renamed from: v */
    public final void mo26330v(int i, int i2, String str) {
        AppMethodBeat.m2504i(4432);
        cIV();
        if (this.sPH != null) {
            this.sPH.mo9299v(i, i2, str);
        }
        AppMethodBeat.m2505o(4432);
    }

    /* Access modifiers changed, original: final */
    public final void cIR() {
        AppMethodBeat.m2504i(4421);
        if (this.mStatus == 5) {
            setStatus(6);
            this.sPp.sVH.cJa();
            C46317a.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new C42834());
        }
        AppMethodBeat.m2505o(4421);
    }
}
