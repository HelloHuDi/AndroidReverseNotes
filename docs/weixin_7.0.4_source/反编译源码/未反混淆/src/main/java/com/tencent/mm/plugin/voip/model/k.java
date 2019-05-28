package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
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

public final class k {
    public boolean cJn;
    public Context jiq;
    ak mHandler;
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
    public ap sPD;
    Timer sPE;
    int sPF;
    private ap sPG;
    private a sPH;
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
    public u sPq;
    public m sPr;
    public t sPs;
    public byte[] sPt;
    public cpm sPu;
    public boolean sPv;
    public boolean sPw;
    public int sPx;
    public int sPy;
    public int sPz;

    public interface a {
        void v(int i, int i2, String str);
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.k$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ int val$height;
        final /* synthetic */ int val$width;

        AnonymousClass9(int i, int i2) {
            this.val$width = i;
            this.val$height = i2;
        }

        public final void run() {
            AppMethodBeat.i(4399);
            if (k.this.sPp != null) {
                v2protocal.fX(this.val$width, this.val$height);
            }
            AppMethodBeat.o(4399);
        }
    }

    protected k() {
        AppMethodBeat.i(4400);
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
        this.sPq = u.sTD;
        this.sPt = null;
        this.sPu = null;
        this.sPv = false;
        this.sPw = false;
        this.sPx = 0;
        this.sPy = 0;
        this.sPz = 0;
        this.sPA = false;
        this.sPC = 0;
        this.sPD = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(4391);
                ab.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
                k.this.sPs.a(null, false, 7);
                AppMethodBeat.o(4391);
                return true;
            }
        }, true);
        this.mHandler = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(4393);
                byte[] bArr;
                int i;
                if (message == null || message.what != 59998) {
                    super.handleMessage(message);
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 1) {
                    if (k.this.sPp.nwu == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                        AppMethodBeat.o(4393);
                        return;
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
                    bArr = (byte[]) message.obj;
                    t tVar = k.this.sPs;
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
                        cpf.ndG = r.Yz();
                        cpg cpg = new cpg();
                        cpg.jBv = 1;
                        cpg.jBw.add(cpf);
                        tVar.a(cpg, true, 2);
                        AppMethodBeat.o(4393);
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                        AppMethodBeat.o(4393);
                    }
                } else if (message.arg1 == 4) {
                    if (k.this.sPp.nwu == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                        AppMethodBeat.o(4393);
                        return;
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
                    k.this.sPp.sVH.sQe = 107;
                    k.this.v(1, -9004, "");
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 6) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
                    if (k.this.sPp.nwu == 0) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                        AppMethodBeat.o(4393);
                        return;
                    }
                    k.this.sON = true;
                    k.this.sPp.sVH.sQu = 1;
                    if (k.this.cJn || k.this.sOO) {
                        k.this.sPp.sUD = 0;
                    } else {
                        k.this.sPp.sUD = 1;
                    }
                    k.this.sPp.setInactive();
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
                    k.this.cIO();
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 3) {
                    k.this.mStatus = 5;
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 5) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
                    if (k.this.mStatus >= 5) {
                        k.this.sPp.sVH.sQe = 108;
                    } else {
                        k.this.sPp.sVH.sQe = 106;
                    }
                    if (message.arg2 == 4) {
                        k.this.sPp.sVH.sQw = 1;
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
                    } else if (message.arg2 == 1) {
                        if (k.this.sOR) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                            k.this.sOQ = true;
                            AppMethodBeat.o(4393);
                            return;
                        }
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
                        k.this.sON = false;
                        k.this.sPp.sVH.sQw = 5;
                    } else if (message.arg2 == 5) {
                        if (k.this.sOQ) {
                            k.this.sPp.sVH.sQw = 6;
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                            k.this.sOQ = true;
                            AppMethodBeat.o(4393);
                            return;
                        }
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel network fail");
                        k.this.sPp.sVH.sQw = 6;
                    }
                    k.this.v(1, -9000, "");
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 100) {
                    com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 101) {
                    com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 7) {
                    int[] iArr = (int[]) message.obj;
                    int i2 = message.arg2;
                    String str = null;
                    try {
                        str = at.gE(ah.getContext());
                    } catch (Exception e2) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
                    }
                    String str2 = null;
                    try {
                        str2 = ((TelephonyManager) ah.getContext().getSystemService("phone")).getSimOperatorName();
                    } catch (Exception e3) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
                    }
                    new j(k.this.sOW, k.this.sOV, k.this.sOX, str2, str, k.this.sOY, i2, iArr).cKw();
                    AppMethodBeat.o(4393);
                } else if (message.arg1 == 8) {
                    bArr = (byte[]) message.obj;
                    k kVar = k.this;
                    try {
                        cmm cmm = (cmm) new cmm().parseFrom(bArr);
                        if (!(kVar.sPA && cmm.xko == 1)) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + cmm.xko);
                        }
                        switch (cmm.xko) {
                            case 1:
                                if (!kVar.sPA) {
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
                                    kVar.am(8, false);
                                    if (cmm.xkp != null) {
                                        ByteBuffer wrap = ByteBuffer.wrap(cmm.xkp.wR, 0, 4);
                                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                                        int min = Math.min(wrap.getInt(), 6);
                                        ByteBuffer allocate = ByteBuffer.allocate(4);
                                        allocate.order(ByteOrder.LITTLE_ENDIAN);
                                        allocate.putInt(min);
                                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(min)));
                                        kVar.sPp.setAppCmd(30, allocate.array(), 4);
                                    } else {
                                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
                                    }
                                }
                                kVar.sPA = true;
                                AppMethodBeat.o(4393);
                                return;
                            case 2:
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
                                kVar.sPr.sPU = true;
                                AppMethodBeat.o(4393);
                                return;
                            case 3:
                                if (cmm.xkp != null) {
                                    bArr = cmm.xkp.wR;
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(bArr)));
                                    i = kVar.sPp.setAppCmd(302, bArr, 4);
                                    if (i < 0) {
                                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr + "fail:" + i + ", [roomid=" + kVar.sPp.nwC + ", roomkey=" + kVar.sPp.nwv + "]");
                                    }
                                    AppMethodBeat.o(4393);
                                    return;
                                }
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                AppMethodBeat.o(4393);
                                return;
                            case 4:
                                if (cmm.xkp != null) {
                                    con con = (con) new con().parseFrom(cmm.xkp.wR);
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + con.xmt);
                                    byte[] bArr2 = new byte[4];
                                    bArr2[0] = (byte) con.xmt;
                                    kVar.sPp.setJNIAppCmd(2, bArr2, 4);
                                    AppMethodBeat.o(4393);
                                    return;
                                }
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                                AppMethodBeat.o(4393);
                                return;
                            case 5:
                                if (cmm.xkp == null) {
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodDisableCodec] empty buffer");
                                    break;
                                }
                                bArr = cmm.xkp.wR;
                                if (kVar.sPp != null) {
                                    kVar.sPp.setAppCmd(35, bArr, 4);
                                }
                                AppMethodBeat.o(4393);
                                return;
                        }
                        AppMethodBeat.o(4393);
                    } catch (Exception e4) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
                        AppMethodBeat.o(4393);
                    }
                } else {
                    int[] iArr2;
                    if (message.arg1 == 9) {
                        n nVar = k.this.sPp.sVH;
                        if (0 == nVar.sQI) {
                            nVar.sQI = System.currentTimeMillis();
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + nVar.sQI);
                        }
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
                        if (1 == k.this.sPp.sVk) {
                            cqi cqi = new cqi();
                            cqi.jBT = 1;
                            k.this.sPs.a(cqi, 2);
                            AppMethodBeat.o(4393);
                            return;
                        }
                    } else if (message.arg1 == 11) {
                        k.this.sPC = 2;
                        AppMethodBeat.o(4393);
                        return;
                    } else if (message.arg1 == 12) {
                        k.this.sPC = 1;
                        AppMethodBeat.o(4393);
                        return;
                    } else if (message.arg1 == 13) {
                        iArr2 = (int[]) message.obj;
                        new h(k.this.sPp.nwu, k.this.sPp.nwv, k.this.sPp.nwC, 1, message.arg2, iArr2).cKw();
                        AppMethodBeat.o(4393);
                        return;
                    } else if (message.arg1 == 14) {
                        iArr2 = (int[]) message.obj;
                        new h(k.this.sPp.nwu, k.this.sPp.nwv, k.this.sPp.nwC, 2, message.arg2, iArr2).cKw();
                    }
                    AppMethodBeat.o(4393);
                }
            }
        };
        this.sPE = null;
        this.sPF = 0;
        this.sPG = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(4398);
                if (k.this.mStatus == 4) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
                    k.this.sPp.sVH.sQe = 105;
                    k.this.v(1, -9000, "");
                }
                AppMethodBeat.o(4398);
                return false;
            }
        }, false);
        this.sPH = null;
        this.sPp = new v2protocal(this.mHandler);
        this.sPr = new m(this);
        this.sPs = new t(this);
        this.sPz = 0;
        this.sPB = new VoipScoreState();
        AppMethodBeat.o(4400);
    }

    public final void reset() {
        AppMethodBeat.i(4401);
        ab.i("MicroMsg.Voip.VoipContext", "reset");
        this.sPq.cJD();
        if (this.sPp.cKK()) {
            this.sPp.mx(false);
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
        AppMethodBeat.o(4401);
    }

    public final void cIE() {
        int i = 0;
        AppMethodBeat.i(4402);
        if (this.sOL && this.sOU == 0) {
            this.sOU = 1;
            if (this.sPp.field_speedTestInfoLength < 8) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.o(4402);
                return;
            }
            int i2 = this.sPp.sVF[1];
            if (i2 + 2 > this.sPp.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.o(4402);
                return;
            }
            int i3 = this.sPp.sVF[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.sPp.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.sPp.field_speedTestInfoLength);
                AppMethodBeat.o(4402);
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
            new com.tencent.mm.plugin.voip.model.a.k(this.sOT).cKw();
            AppMethodBeat.o(4402);
            return;
        }
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.sOL + " ,mSpeedTestStatus=" + this.sOU);
        AppMethodBeat.o(4402);
    }

    public final void cIF() {
        AppMethodBeat.i(4403);
        if (this.sOU == 0) {
            AppMethodBeat.o(4403);
        } else if (this.sOU == 1) {
            this.sOU = 0;
            this.sPp.sVp = 0;
            AppMethodBeat.o(4403);
        } else {
            this.sOU = 0;
            v2protocal v2protocal = this.sPp;
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            v2protocal.StopSpeedTest();
            v2protocal.sVp = 0;
            AppMethodBeat.o(4403);
        }
    }

    public final void Gd(int i) {
        AppMethodBeat.i(4404);
        this.sPp.sUm = Math.abs(i);
        AppMethodBeat.o(4404);
    }

    public final void Ge(int i) {
        AppMethodBeat.i(4405);
        this.sPp.sUn = Math.abs(i);
        AppMethodBeat.o(4405);
    }

    public final void cIG() {
        AppMethodBeat.i(4406);
        this.sPp.sUo = this.sPr.cIX();
        this.sPp.sUp = this.sPr.cIs();
        AppMethodBeat.o(4406);
    }

    public final void Gf(int i) {
        this.sPp.sUq = i;
    }

    public final void shutdown() {
        AppMethodBeat.i(4407);
        cIV();
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4392);
                if (k.this.sPq != null) {
                    k.this.sPq.cJC();
                }
                AppMethodBeat.o(4392);
            }
        });
        AppMethodBeat.o(4407);
    }

    public final boolean a(cpm cpm) {
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
        AppMethodBeat.i(4408);
        if (i == this.mStatus) {
            AppMethodBeat.o(4408);
            return;
        }
        if (i == 4) {
            this.sPG.ae(60000, 60000);
        }
        this.mStatus = i;
        AppMethodBeat.o(4408);
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
        AppMethodBeat.i(4409);
        ab.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", Integer.valueOf(this.mStatus));
        if (this.mStatus == 1) {
            AppMethodBeat.o(4409);
            return false;
        }
        AppMethodBeat.o(4409);
        return true;
    }

    public final int cIt() {
        AppMethodBeat.i(4410);
        m mVar = this.sPr;
        if (mVar.sPL != null) {
            int cIt = mVar.sPL.cIt();
            AppMethodBeat.o(4410);
            return cIt;
        }
        AppMethodBeat.o(4410);
        return 0;
    }

    public final void Gg(int i) {
        AppMethodBeat.i(4411);
        if (8 == i || 9 == i) {
            this.sPh = i;
        } else {
            this.sPf = i;
            this.sPd = i;
        }
        if (1 == i || 3 == i) {
            Gh(2);
        }
        this.sPq.Gt(i);
        AppMethodBeat.o(4411);
    }

    public final void Gh(int i) {
        AppMethodBeat.i(4412);
        if (8 == i || 9 == i) {
            this.sPg = i;
        } else {
            this.sPd = i;
            this.sPe = i;
        }
        this.sPs.GB(i);
        AppMethodBeat.o(4412);
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

    public final int mo(boolean z) {
        int appCmd;
        AppMethodBeat.i(4413);
        if (z) {
            appCmd = this.sPp.setAppCmd(412);
        } else {
            appCmd = this.sPp.setAppCmd(413);
        }
        if (appCmd < 0) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.o(4413);
        return appCmd;
    }

    public final int mp(boolean z) {
        int appCmd;
        AppMethodBeat.i(4414);
        if (z) {
            appCmd = this.sPp.setAppCmd(401);
        } else {
            appCmd = this.sPp.setAppCmd(402);
        }
        if (appCmd < 0) {
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.o(4414);
        return appCmd;
    }

    private void cIN() {
        AppMethodBeat.i(4415);
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + q.etd.eqq);
        if (q.etd.epS == 1) {
            this.sPp.setAppCmd(410);
        }
        byte[] bArr = new byte[2];
        if (q.etd.eqq >= 0) {
            bArr[0] = (byte) q.etd.eqq;
            this.sPp.setAppCmd(406, bArr, 1);
        } else if (q.etd.eqq == -2) {
            this.sPp.setAppCmd(407);
        }
        if (q.etd.eqr >= 0) {
            bArr[0] = (byte) q.etd.eqr;
            this.sPp.setAppCmd(408, bArr, 1);
        } else if (q.etd.eqr == -2) {
            this.sPp.setAppCmd(409);
        }
        c ll = com.tencent.mm.model.c.c.abi().ll("100447");
        if (ll.isValid() && 1 == bo.getInt((String) ll.dru().get("SetVoipRnnNsOn"), 0)) {
            this.sPp.setAppCmd(v2helper.EMethodSetSendToNetworkOn, new byte[]{(byte) bo.getInt((String) ll.dru().get("SetVoipRnnNsOn"), 0)}, 1);
        }
        if (q.etd.eqt >= 0) {
            byte[] bArr2 = new byte[5];
            if (q.etd.equ >= 0 && q.etd.eqv >= 0) {
                bArr2[0] = (byte) q.etd.equ;
                bArr2[1] = (byte) q.etd.eqv;
                if (q.etd.eqw >= 0) {
                    bArr2[2] = (byte) q.etd.eqw;
                    bArr2[3] = (byte) q.etd.eqt;
                    bArr2[4] = (byte) q.etd.eqx;
                    this.sPp.setAppCmd(404, bArr2, 5);
                } else {
                    this.sPp.setAppCmd(404, bArr2, 2);
                }
            }
        } else if (q.etd.eqt == -2) {
            this.sPp.setAppCmd(405);
        }
        if (q.etd.epT >= 0 || q.etd.epV >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (q.etd.epT >= 0) {
                bArr[0] = (byte) q.etd.epT;
            }
            if (q.etd.epV >= 0) {
                bArr[1] = (byte) q.etd.epV;
            }
            this.sPp.setAppCmd(414, bArr, 2);
        }
        if (q.etd.epU >= 0 || q.etd.epW >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (q.etd.epU >= 0) {
                bArr[0] = (byte) q.etd.epU;
            }
            if (q.etd.epW >= 0) {
                bArr[1] = (byte) q.etd.epW;
            }
            this.sPp.setAppCmd(415, bArr, 2);
        }
        if (q.etd.epX >= 0 || q.etd.epY >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (q.etd.epX >= 0) {
                bArr[0] = (byte) q.etd.epX;
            }
            if (q.etd.epY >= 0) {
                bArr[1] = (byte) q.etd.epY;
            }
            this.sPp.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr, 2);
        }
        if (q.etd.epZ >= 0) {
            bArr[0] = (byte) q.etd.epZ;
            this.sPp.setAppCmd(416, bArr, 1);
        }
        if (q.etd.eqd >= 0) {
            bArr[0] = (byte) q.etd.eqd;
            this.sPp.setAppCmd(431, bArr, 4);
        }
        if (q.etd.eqa >= 0 && !(this.sPp.sUM == 0 && q.etd.eqa == 5)) {
            bArr[0] = (byte) q.etd.eqa;
            this.sPp.setAppCmd(417, bArr, 1);
        }
        if (q.etd.eqb >= 0 && !(this.sPp.sUM == 0 && q.etd.eqb == 5)) {
            bArr[0] = (byte) q.etd.eqb;
            this.sPp.setAppCmd(418, bArr, 1);
        }
        if (q.etd.eqc >= 0) {
            bArr[0] = (byte) q.etd.eqc;
            this.sPp.setAppCmd(419, bArr, 1);
        }
        if (this.sPp.sUM == 1 && (q.etd.eqa == 5 || q.etd.eqb == 5)) {
            this.sPp.sUy = 5;
        }
        if (1 == q.etd.eqA) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (q.etd.eqB[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((q.etd.eqB[i] >> 8) & 255);
            }
            this.sPp.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr3, 30);
        }
        if (q.etd.eqA == 0) {
            this.sPp.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff);
        }
        if (q.etd.eqC[0] > (short) 0 || q.etd.eqC[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (q.etd.eqC[0] > (short) 0 && q.etd.eqC[0] < (short) 10000) {
                bArr[0] = (byte) q.etd.eqC[0];
            }
            if (q.etd.eqC[1] > (short) 0 && q.etd.eqC[1] < (short) 10000) {
                bArr[1] = (byte) q.etd.eqC[1];
            }
            this.sPp.setAppCmd(v2helper.EMethodSetNgStrength, bArr, 2);
        }
        if (q.etd.eqE > 0) {
            bArr[0] = (byte) q.etd.eqE;
            this.sPp.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr, 1);
        }
        if (q.etd.eqM >= 0) {
            this.sPp.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) q.etd.eqM, (byte) q.etd.eqN, (byte) q.etd.eqO, (byte) q.etd.eqP}, 4);
        }
        AppMethodBeat.o(4415);
    }

    public final void cIO() {
        AppMethodBeat.i(4416);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.sOP && this.sON) {
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.sPp.setActive();
            if (this.sOS) {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.sOS);
                AppMethodBeat.o(4416);
                return;
            }
            int i;
            Object obj;
            this.sPp.setSvrConfig(205, 0, 0, this.sPp.sVb, 0, 0, 0);
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.sPp.sVb + " SwitchFlag = " + this.sPp.sUi);
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
                this.sPE.schedule(new TimerTask() {
                    public final void run() {
                        AppMethodBeat.i(4395);
                        k kVar = k.this;
                        kVar.sPF++;
                        if (k.this.sPp.sVv != 0 || k.this.sPF > 10) {
                            k.this.cIR();
                            k.this.sPE.cancel();
                            k.this.sPE = null;
                            AppMethodBeat.o(4395);
                            return;
                        }
                        AppMethodBeat.o(4395);
                    }
                }, 200, 200);
            }
            this.sPq.cJE();
            m mVar = this.sPr;
            if (mVar.kzf == 2) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                mVar.kzf = 2;
                mVar.sPU = false;
                mVar.sPV = 0;
                if (mVar.sQa != null) {
                    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    mVar.sQa.sQd = true;
                    d.xDG.remove(mVar.sQa);
                    mVar.sQa = null;
                }
                mVar.sQa = new b();
                d.post(mVar.sQa, "VoipDeviceHandler_decode");
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                q.etd.dump();
                mVar.sPL = new c();
                a aVar = new a();
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + aVar.pug + ", framelen: " + aVar.sNh + ", ret:" + mVar.sNl.sPp.a(aVar));
                mVar.sPL.G(aVar.pug, aVar.channels, aVar.sNh, 0);
                mVar.kzg = mVar.sPL.x(mVar.sNl.jiq, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (mVar.sPL.sNk ? 1 : 0);
                mVar.sNl.sPp.setAppCmd(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE, bArr, 1);
                if (mVar.kzg <= 10) {
                    if (mVar.kzg <= 0) {
                        mVar.kzj = 1;
                    }
                    mVar.kzg = 92;
                }
                if (g.KK().KV() || g.KK().KP()) {
                    b.cIj().jj(true);
                } else {
                    b.cIj().jj(false);
                }
                mVar.sPL.sNt = new b() {
                    public final int N(byte[] bArr, int i) {
                        AppMethodBeat.i(4437);
                        if (m.this.kzf != 2) {
                            AppMethodBeat.o(4437);
                            return -1;
                        }
                        if (1 == m.this.sPW) {
                            m.this.sPW = 0;
                            m.this.sPX = System.currentTimeMillis();
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first play");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long p = currentTimeMillis - m.this.sPX;
                            if (p > 1000) {
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(p)));
                            }
                            m.this.sPX = currentTimeMillis;
                        }
                        int playCallback = m.this.sNl.sPp.playCallback(bArr, i);
                        if (playCallback < 0) {
                            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipDeviceHandler", com.tencent.mm.compatible.util.g.Mq() + "protocal.playcallback ret:" + playCallback);
                            AppMethodBeat.o(4437);
                            return -1;
                        }
                        m.sPY++;
                        AppMethodBeat.o(4437);
                        return 0;
                    }
                };
                if (mVar.sPL.cIp() <= 0) {
                    mVar.kzj = 1;
                }
                d.f(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4438);
                        try {
                            m.q(m.this);
                            AppMethodBeat.o(4438);
                        } catch (Exception e) {
                            ab.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", e.getMessage());
                            m.this.kzj = 1;
                            m.this.sNl.Ge(m.this.kzj);
                            AppMethodBeat.o(4438);
                        }
                    }
                }, "voip_start_record");
            }
            n nVar = this.sPp.sVH;
            if (nVar.beginTime == 0) {
                nVar.sQx = 0;
            } else {
                nVar.sQx = (int) (System.currentTimeMillis() - nVar.beginTime);
            }
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + nVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + nVar.sQx);
            this.sPq.onConnected();
            this.mStatus = 5;
            nVar = this.sPp.sVH;
            nVar.sQF = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + nVar.sQF);
            this.sPp.setSvrConfig(202, this.sPp.sUE, this.sPp.sUF, 0, 0, 0, 0);
            this.sPp.setSvrConfig(203, 0, 0, this.sPp.sUJ, 0, 0, 0);
            this.sPp.setSvrConfig(206, 0, 0, this.sPp.sUN, 0, 0, 0);
            this.sPp.setSvrConfig(103, this.sPp.sUG, this.sPp.sUH, this.sPp.sUI, this.sPp.sUL, 0, 0);
            this.sPp.setSvrConfig(205, 0, 0, this.sPp.sVb, 0, 0, 0);
            this.sPp.setSvrConfig(207, 0, 0, this.sPp.sUi, 0, 0, 0);
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.sPp.sVb + " SwitchFlag = " + this.sPp.sUi);
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
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.sPp.sVf + ",FECKeyPara1 = " + this.sPp.sVg[0] + "," + this.sPp.sVg[1] + "," + this.sPp.sVg[2] + "," + this.sPp.sVg[3] + ",FECKeyPara2 = " + this.sPp.sVh[0] + "," + this.sPp.sVh[1]);
            }
            this.sPp.setSvrConfig(507, 0, 0, (this.sPp.sUT & 4) >> 2, (this.sPp.sUT & 2) >> 1, this.sPp.sUT & 1, 0);
            this.sPp.setjbmbitraterssvrparam();
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.sPp.sUE + ",audioTsdEdge = " + this.sPp.sUF + ",passthroughQosAlgorithm = " + this.sPp.sUG + ",fastPlayRepair = " + this.sPp.sUH + ", audioDTX = " + this.sPp.sUJ + ", mARQFlag = " + i + ", mQosStrategy = " + this.sPp.sUT + ", mSvrCfgListV = " + this.sPp.sUI + ", maxBRForRelay = " + this.sPp.sUL);
            byte[] bArr2 = new byte[]{(byte) q.etc.eru, (byte) -1};
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.sPp.setAppCmd(15, bArr2, 1);
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.vxo);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.vxo);
            this.sPp.setAppCmd(505, allocate.array(), 4);
            if ((this.sPp.sUi & 2) == 0) {
                am(16, true);
            }
            bArr2 = new byte[4];
            this.sPp.setAppCmd(26, bArr2, 4);
            allocate = ByteBuffer.wrap(bArr2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int i4 = allocate.getInt();
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(i4)));
            Object obj2 = ((this.sPp.sUI & 4) != 0 || q.etc.erw > 0) ? 1 : null;
            if (obj2 == null && this.sPp.sVM) {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
                obj = (i4 & 4) != 0 ? 1 : null;
                obj2 = (i4 & 8) != 0 ? 1 : null;
                if (!(obj == null && obj2 == null)) {
                    this.sPr.sPU = true;
                    mq(false);
                }
                this.sPp.sVM = false;
            }
            if (this.sPp.sVM) {
                v2protocal v2protocal = this.sPp;
                int i5 = q.etc.erw;
                boolean z = false;
                Object obj3 = (i4 & 4) != 0 ? 1 : null;
                obj = (i4 & 8) != 0 ? 1 : null;
                if (!(obj3 == null && obj == null)) {
                    String str = obj3 != null ? "video/hevc" : "video/avc";
                    v2protocal.sVI = new e(v2protocal.width, v2protocal.height, v2protocal.sVK, v2protocal.bitrate, i5, str);
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(str)));
                    if (v2protocal.sVL != null) {
                        v2protocal.sVJ = new d(v2protocal.sVL);
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                    }
                    z = true;
                    if (v2protocal.sVI == null || v2protocal.sVJ == null) {
                        v2protocal.sVM = false;
                        z = false;
                    }
                }
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + z + ", iHW:" + i4);
                if (!this.sPp.sVM) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                    this.sPr.sPU = true;
                    mq(false);
                }
            }
            if (this.sPp.sVI != null) {
                this.sPp.sVI.sNl = this;
            }
            if (v2protocal.sVJ != null) {
                v2protocal.sVJ.a(this);
            }
            this.sOS = true;
            this.sPA = false;
            this.sPB.nxT = bf.aaa();
            ab.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", Long.valueOf(r0.nxT));
            AppMethodBeat.o(4416);
            return;
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.sOP + ", isChannelConnectedSuccess " + this.sON);
        AppMethodBeat.o(4416);
    }

    public final void mq(boolean z) {
        AppMethodBeat.i(4417);
        if (z) {
            Gi(2);
        }
        if (this.sPp != null) {
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
            am(8, false);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(6);
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
            this.sPp.setAppCmd(30, allocate.array(), 4);
        }
        AppMethodBeat.o(4417);
    }

    public final int am(int i, boolean z) {
        AppMethodBeat.i(4418);
        if (i < 0) {
            AppMethodBeat.o(4418);
            return -1;
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + i + ", local=" + z + ", remote =true");
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        if (z) {
            try {
                if (this.sPp != null) {
                    cmm cmm = new cmm();
                    cmm.xko = 5;
                    cmm.xkp = new com.tencent.mm.bt.b(allocate.array());
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(i)));
                    this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                }
            } catch (Exception e) {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
            }
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(i)));
        this.sPp.setAppCmd(35, allocate.array(), 4);
        AppMethodBeat.o(4418);
        return 1;
    }

    public final boolean cIP() {
        AppMethodBeat.i(4419);
        boolean cIL = cIL();
        int i = 0;
        if (cIL) {
            i = 1;
        }
        if (this.sPn == -1 || this.sPn != i) {
            this.sPn = i;
            if (cIL) {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.sPp.setAppCmd(203);
            } else {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.sPp.setAppCmd(202);
            }
        }
        AppMethodBeat.o(4419);
        return cIL;
    }

    public final boolean cIQ() {
        AppMethodBeat.i(4420);
        boolean cIM = cIM();
        int i = 0;
        if (cIM) {
            i = 1;
        }
        if (this.sPo == -1 || this.sPo != i) {
            this.sPo = i;
            if (cIM) {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.sPp.setAppCmd(201);
            } else {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.sPp.setAppCmd(200);
            }
        }
        AppMethodBeat.o(4420);
        return cIM;
    }

    public final void Gi(int i) {
        AppMethodBeat.i(4422);
        try {
            cmm cmm = new cmm();
            cmm.xko = i;
            if (1 == i) {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(6);
                cmm.xkp = new com.tencent.mm.bt.b(allocate.array());
                this.sPp.setAppCmd(32, allocate.array(), 4);
            } else {
                cmm.xkp = null;
            }
            this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(i)));
            AppMethodBeat.o(4422);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
            AppMethodBeat.o(4422);
        }
    }

    public final void Gj(int i) {
        AppMethodBeat.i(4423);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            this.sPp.setJNIAppCmd(2, bArr, 4);
            con con = new con();
            con.xmt = i;
            con.xmu = 1;
            cmm cmm = new cmm();
            cmm.xko = 4;
            cmm.xkp = new com.tencent.mm.bt.b(con.toByteArray(), 0, 1);
            this.sPp.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
            AppMethodBeat.o(4423);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
            AppMethodBeat.o(4423);
        }
    }

    private void cIS() {
        AppMethodBeat.i(4424);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4396);
                if (k.this.mStatus != 2 && k.this.mStatus != 3 && k.this.mStatus != 4) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + k.this.mStatus);
                    AppMethodBeat.o(4396);
                } else if (k.this.sOL) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
                    AppMethodBeat.o(4396);
                } else {
                    int i;
                    int i2;
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
                    int i3 = ((((k.this.sPp.sUO >> 2) & 3) >> 1) & 1) & (((k.this.sPp.sUO & 3) >> 1) & 1);
                    v2protocal v2protocal = k.this.sPp;
                    int i4 = k.this.sPp.sTY;
                    long j = (long) k.this.sPp.nwu;
                    int i5 = k.this.sPp.nwC;
                    long j2 = k.this.sPp.nwv;
                    byte[] bArr = k.this.sPp.sUa;
                    int i6 = k.this.sPp.channelStrategy;
                    int i7 = k.this.sPp.sUf;
                    int i8 = k.this.sPp.sUg;
                    int i9 = k.this.sPp.sUd;
                    if (k.this.sPp.sUe == null) {
                        i = 0;
                    } else {
                        i = k.this.sPp.sUe.length;
                    }
                    byte[] bArr2 = k.this.sPp.sUe;
                    int i10 = k.this.sPp.sUh;
                    int i11 = k.this.sPp.sTX;
                    int i12 = k.this.sPp.sUY;
                    byte[] bArr3 = k.this.sPp.sUZ;
                    int i13 = k.this.sPp.sVa;
                    int i14 = k.this.sPp.sUi;
                    if (k.this.sPp.sUj == null) {
                        i2 = 0;
                    } else {
                        i2 = k.this.sPp.sUj.length;
                    }
                    int configInfo = v2protocal.setConfigInfo(i4, j, i5, j2, bArr, i6, i7, i8, i9, i, bArr2, i10, i3, i11, i12, bArr3, i13, i14, i2, k.this.sPp.sUj, k.this.sPp.sVb);
                    if (configInfo == 0) {
                        configInfo = k.this.sPp.connectToPeerRelay();
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i3 + ",  NetType: " + k.this.sPp.sTX + ", EncryptStrategy: " + k.this.sPp.sUY);
                    if (configInfo < 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(configInfo)));
                        k.this.sPp.sVH.sQe = 14;
                        k.this.v(1, -9002, "");
                        AppMethodBeat.o(4396);
                        return;
                    }
                    k.this.sOL = true;
                    k.this.sPp.sVH.sQl = (byte) 1;
                    k.this.sPp.sVH.sQt = 1;
                    AppMethodBeat.o(4396);
                }
            }
        });
        AppMethodBeat.o(4424);
    }

    public final void cIT() {
        AppMethodBeat.i(4425);
        boolean z = !bo.cb(this.sPp.sUa);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + z + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.sOR + ",isRemoteAccepted:" + this.sOO + ",isLocalAccept:" + this.cJn);
        this.sPp.sVH.sQq = 7;
        if (z && (this.mStatus == 4 || this.mStatus == 5 || this.mStatus == 6 || ((this.mStatus == 2 && this.sOR) || (this.mStatus == 3 && this.sOR)))) {
            if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
                AppMethodBeat.o(4425);
                return;
            } else if (this.sOO || this.cJn) {
                if (!this.sOL) {
                    cIS();
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4397);
                        if (k.this.mStatus != 4 && k.this.mStatus != 5 && k.this.mStatus != 6) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + k.this.mStatus);
                            AppMethodBeat.o(4397);
                        } else if (k.this.sOM) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
                            AppMethodBeat.o(4397);
                        } else {
                            k.this.sOM = true;
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
                            int connectToPeerDirect = k.this.sPp.connectToPeerDirect();
                            if (connectToPeerDirect < 0) {
                                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(connectToPeerDirect)));
                                k.this.sPp.sVH.sQe = 14;
                                k.this.v(1, -9002, "");
                                AppMethodBeat.o(4397);
                                return;
                            }
                            k.this.cIU();
                            AppMethodBeat.o(4397);
                        }
                    }
                });
            } else if (this.sOR && !this.sOL) {
                cIS();
                AppMethodBeat.o(4425);
                return;
            }
        }
        AppMethodBeat.o(4425);
    }

    public final void cIU() {
        AppMethodBeat.i(4426);
        if (this.sOM && !bo.cb(this.sPp.sUc)) {
            int handleCommand = this.sPp.handleCommand(this.sPp.sUc, this.sPp.sUc.length);
            if (handleCommand < 0) {
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(handleCommand)));
            }
            this.sPp.sUc = null;
        }
        AppMethodBeat.o(4426);
    }

    public final void bo(byte[] bArr) {
        AppMethodBeat.i(4427);
        ab.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.sPp.sVH.sQj = (byte) 1;
        this.sPp.sVH.sQi = (byte) 1;
        this.sPp.sUa = bArr;
        AppMethodBeat.o(4427);
    }

    public final void b(int i, byte[] bArr, byte[] bArr2) {
        this.sPp.sVf = i;
        this.sPp.sVg = bArr;
        this.sPp.sVh = bArr2;
    }

    public final void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.sPp.sUd = i;
        this.sPp.sUe = bArr;
        this.sPp.sUY = i2;
        this.sPp.sUZ = bArr2;
    }

    public final void Gk(int i) {
        this.sPp.sVa = i;
    }

    public final void a(cok cok, cok cok2, cok cok3, LinkedList<cps> linkedList) {
        AppMethodBeat.i(4428);
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
            if (this.sPp.a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
            }
            AppMethodBeat.o(4428);
            return;
        }
        cpu = new cpu();
        try {
            cpu.xnK = 1;
            cpu.xnL = defaultPort;
            cpu.xnM = 0;
            cpu.userName = "";
            cpu.gDC = "";
            cpu.xnL = com.tencent.mm.plugin.voip.a.a.Pz(InetAddress.getByName(defaultHost).getHostAddress());
            if (this.sPp.a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
                AppMethodBeat.o(4428);
                return;
            }
        } catch (UnknownHostException e) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipContext", e, "", new Object[0]);
            if (this.sPp.a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
                AppMethodBeat.o(4428);
                return;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.sPp.a(cok, cok2, cok3, cpu, (LinkedList) linkedList) != 0) {
                ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
            }
            AppMethodBeat.o(4428);
        }
        AppMethodBeat.o(4428);
    }

    public final void i(int i, int i2, int i3, int i4, int i5) {
        this.sPp.sUO = i;
        this.sPp.sUP = i2;
        this.sPp.sUQ = i3;
        this.sPp.sUR = i4;
        this.sPp.sUS = i5;
    }

    public final void Gl(int i) {
        this.sPp.sUT = i;
    }

    public final void bp(byte[] bArr) {
        AppMethodBeat.i(4429);
        ab.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", Byte.valueOf(this.sPp.sVH.sQn));
        if (this.sPp.sVH.sQn == (byte) 1 || bArr == null) {
            AppMethodBeat.o(4429);
            return;
        }
        this.sPp.sVH.sQn = (byte) 1;
        this.sPp.sUb = bArr;
        int exchangeCabInfo = this.sPp.exchangeCabInfo(this.sPp.sUb, this.sPp.sUb.length);
        if (exchangeCabInfo < 0) {
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(exchangeCabInfo)));
            this.sPp.sVH.sQe = 15;
            v(1, -9003, "");
        }
        AppMethodBeat.o(4429);
    }

    public final void Gm(int i) {
        this.sPp.sVH.sQk = (byte) 1;
        this.sPp.channelStrategy = i;
    }

    public final void Gn(int i) {
        this.sPp.sUh = i;
    }

    public final void bq(byte[] bArr) {
        AppMethodBeat.i(4430);
        this.sPp.sUc = bArr;
        cIU();
        AppMethodBeat.o(4430);
    }

    public final void cIV() {
        AppMethodBeat.i(4431);
        ab.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.sPD.stopTimer();
        AppMethodBeat.o(4431);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.sPH = aVar;
        }
    }

    public final void v(int i, int i2, String str) {
        AppMethodBeat.i(4432);
        cIV();
        if (this.sPH != null) {
            this.sPH.v(i, i2, str);
        }
        AppMethodBeat.o(4432);
    }

    /* Access modifiers changed, original: final */
    public final void cIR() {
        AppMethodBeat.i(4421);
        if (this.mStatus == 5) {
            setStatus(6);
            this.sPp.sVH.cJa();
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4394);
                    k.this.sPq.cJB();
                    AppMethodBeat.o(4394);
                }
            });
        }
        AppMethodBeat.o(4421);
    }
}
