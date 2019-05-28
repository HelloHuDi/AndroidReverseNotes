package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.format.Formatter;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.model.ao;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal {
    public static final int VOICE_FRAME_BYTES;
    public static final int VOICE_SAMPLERATE;
    protected static int cpuFlag0;
    public static boolean sTV = false;
    public static d sVJ = null;
    public static Surface sVL = null;
    public static WeakReference<e> sVN = null;
    private static int sVn = 10;
    private static final String[] supportedH264HwCodecPrefixes = new String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.hisi"};
    int bitrate = 300;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public long fDH = 0;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineReportStatFromApp = null;
    public int field_HWEncH = 0;
    public int field_HWEncW = 0;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int[] field_jbmBitratRsSvrParamArray = null;
    public double[] field_jbmBitratRsSvrParamDoubleArray = null;
    public int field_jbmParamArraySize = 0;
    public int field_jbmParamDoubleArraySize = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    public int[] field_natSvrArray = null;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    private ak handler = null;
    public int height = 480;
    protected boolean isInited = false;
    public int kIm = 0;
    public String nMl = "";
    public int netType = 0;
    public int nwC = 0;
    public int nwu = 0;
    public long nwv = 0;
    public int nwx = 0;
    public int sTW = 0;
    public int sTX = 0;
    public int sTY = 0;
    public long sTZ = 0;
    public int sUA = 0;
    public int sUB = 0;
    public int sUC = 0;
    public int sUD = 0;
    public int sUE = 100;
    public int sUF = 300;
    public int sUG = 1;
    public int sUH = 1;
    public int sUI = 0;
    public int sUJ = 1;
    public int sUK = 0;
    public int sUL = 0;
    public int sUM = 0;
    public int sUN = 0;
    public int sUO = 0;
    public int sUP = 0;
    public int sUQ = 0;
    public int sUR = 0;
    public int sUS = 0;
    public int sUT = 0;
    public int[] sUU = null;
    public int sUV = 0;
    public int sUW = 0;
    public int sUX = 0;
    public int sUY = 0;
    public byte[] sUZ = null;
    public byte[] sUa = null;
    public byte[] sUb = null;
    public byte[] sUc = null;
    public int sUd = 0;
    public byte[] sUe = null;
    public int sUf = 500;
    public int sUg = 30;
    public int sUh = 999;
    public int sUi = 0;
    public byte[] sUj = null;
    public int sUk = 20;
    public int sUl = 0;
    public int sUm = 0;
    public int sUn = 0;
    public int sUo = 0;
    public int sUp = 0;
    public int sUq = 65536;
    public int sUr = 0;
    public int sUs = 0;
    public int sUt = 7;
    public int sUu = 3;
    public int sUv = 3;
    public int sUw = 0;
    public int sUx = 0;
    public int sUy = -1;
    public int sUz = -1;
    byte[] sVA = new byte[4096];
    byte[] sVB = new byte[2048];
    byte[] sVC = new byte[4096];
    public byte[] sVD = new byte[2048];
    public byte[] sVE = new byte[2048];
    public int[] sVF = new int[30];
    int sVG = 0;
    public n sVH = new n();
    public e sVI = null;
    int sVK = 8;
    public boolean sVM = false;
    public int sVa = 0;
    public int sVb = 0;
    public int sVc = 0;
    public int sVd = 0;
    public byte[] sVe = new byte[1500];
    public int sVf = 0;
    public byte[] sVg = null;
    public byte[] sVh = null;
    public int sVi = 0;
    public int sVj = 0;
    public int sVk = 0;
    public int sVl = 0;
    public int sVm = 0;
    public ArrayBlockingQueue<byte[]> sVo = new ArrayBlockingQueue(sVn);
    public long sVp = 0;
    public byte[] sVq = new byte[8];
    public int sVr = 0;
    public int sVs = 0;
    public int sVt = 0;
    public int sVu = 0;
    public int sVv = 0;
    byte[] sVw = new byte[4096];
    byte[] sVx = new byte[2048];
    byte[] sVy = new byte[2048];
    byte[] sVz = new byte[4096];
    public int width = 640;

    private native int forceredirect(int i, int i2);

    private native int setsvraddr(int i, int i2, int i3, String str, String str2, int i4);

    private native int uninit(int i, long j, int i2);

    public native int GetAudioFormat(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3);

    public native int GetNetBottleneckSide();

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int connectToPeer();

    public native int connectToPeerDirect();

    public native int connectToPeerRelay();

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getChannelReport(byte[] bArr, int i);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngine2ndInfoReport(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native String[] getNatReport();

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getNewEngineInfoReport(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVideoHWDecode(int[] iArr, byte[] bArr, int i);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigInfo(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3, int i12, int i13, int i14, byte[] bArr4, int i15);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setNetSignalValue(int i, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int setjbmbitraterssvrparam();

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoHWDecode(byte[] bArr);

    public native int videoHWProcess(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        AppMethodBeat.i(4769);
        k.a("voipMain", v2protocal.class.getClassLoader());
        int Lw = m.Lw();
        cpuFlag0 = Lw;
        Lw = (Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? TXRecordCommon.AUDIO_SAMPLERATE_16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
        VOICE_SAMPLERATE = Lw;
        VOICE_FRAME_BYTES = ((Lw / 1000) * 20) * 2;
        AppMethodBeat.o(4769);
    }

    public final int setAppCmd(int i) {
        AppMethodBeat.i(4739);
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.Logi("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        AppMethodBeat.o(4739);
        return appCmd;
    }

    private static String cKz() {
        AppMethodBeat.i(4740);
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        str = "," + str + "," + str2 + "," + str3 + "," + str4;
        AppMethodBeat.o(4740);
        return str;
    }

    public static long bt(byte[] bArr) {
        AppMethodBeat.i(4741);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        long j = wrap.getLong();
        AppMethodBeat.o(4741);
        return j;
    }

    private String cKA() {
        long j;
        long j2 = 0;
        AppMethodBeat.i(4742);
        if (this.sUm == 0 && this.sUn == 0) {
            this.sVH.sQv = 0;
        } else if (this.sUn != 0 && this.sUm != 0) {
            this.sVH.sQv = 3;
        } else if (this.sUn != 0) {
            this.sVH.sQv = 1;
        } else if (this.sUm != 0) {
            this.sVH.sQv = 2;
        }
        this.sVH.sQD = a.getNetType(ah.getContext());
        this.sVH.sQC = this.field_videoDuration;
        this.sVH.sQB = this.field_audioDuration;
        this.sUr = g.KK().Lb();
        if (this.sVH.sQL <= 0 || this.sVH.sQF <= this.sVH.sQL) {
            j = 0;
        } else {
            j = this.sVH.sQF - this.sVH.sQL;
        }
        a.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(j)));
        setJNIAppCmd(1, this.sVq, this.sVq.length);
        long bt = bt(this.sVq);
        n nVar = this.sVH;
        long j3 = (bt <= this.sVH.sQJ || this.sVH.sQJ <= 0) ? 0 : bt - this.sVH.sQJ;
        nVar.sQM = j3;
        n nVar2 = this.sVH;
        if (bt > this.sVH.sQL && this.sVH.sQL > 0) {
            j2 = bt - this.sVH.sQL;
        }
        nVar2.sQN = j2;
        a.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.sVH.sQM + " lCalledWaitTime:" + this.sVH.sQN);
        StringBuilder append = new StringBuilder().append(this.sUl).append(",").append(this.nwu).append(",").append(this.nwv).append(",").append(this.nwC).append(",").append(this.sVH.sQe).append(",").append(this.sVH.sQq).append(",").append(this.sVH.sQr).append(",").append(this.sVH.sQs).append(",").append(this.sVH.sQt).append(",").append(this.sVH.sQu).append(",").append(this.sVH.sQv).append(",").append(this.sVH.sQo).append(",").append(this.sVH.sQw).append(",").append(this.sVH.sQx).append(",").append(this.sVH.sQy).append(",").append(this.sVH.sQz).append(",").append(this.sVH.sQA).append(",").append(this.sVH.sQB).append(",").append(this.sVH.sQC).append(",").append(this.sVH.sQD).append(cKD()).append(cKE()).append(cKz()).append(",").append(this.sVH.sQE).append(",").append(this.sUq).append(",").append(this.sUr).append(",").append(j).append(",").append(this.sVH.sQM).append(",").append(this.sVH.sQN).append(",").append(this.sUs).append(",").append(this.sTX).append(cKB()).append(",").append(cpuFlag0 & 255).append(",").append(this.sUy).append(",").append(this.sUz);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.sVH.sQG).append(",").append(this.sVH.sQI).append(",").append(this.sVH.sQH).append(",0,").append(this.sVH.sQO).append(",").append(this.sVH.sQP).append(",").append(this.sVH.sQQ).append(",").append(this.sVH.sQR).toString();
        a.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.sTX);
        a.Logi("MicroMsg.Voip", "voipreport:NewDialStatString:".concat(String.valueOf(str)));
        a.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + cKB());
        a.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.sVH.sQP + "lInterruptEndTime:" + this.sVH.sQQ + "mIinterruptCnt:" + this.sVH.sQR);
        AppMethodBeat.o(4742);
        return str;
    }

    private String cKB() {
        AppMethodBeat.i(4743);
        String str = "," + this.channelStrategy;
        AppMethodBeat.o(4743);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final String cKC() {
        AppMethodBeat.i(4744);
        String str;
        if (this.field_videoDuration == 0) {
            a.Logd("MicroMsg.Voip", "captureFrames:" + this.sVr + ", videoduration: 0");
            str = ",0";
            AppMethodBeat.o(4744);
            return str;
        }
        a.Logd("MicroMsg.Voip", "capturefps:" + (this.sVr / this.field_videoDuration) + " framecount:" + this.sVr + " videoDuration:" + this.field_videoDuration);
        str = "," + (this.sVr / this.field_videoDuration);
        AppMethodBeat.o(4744);
        return str;
    }

    private String cKD() {
        AppMethodBeat.i(4745);
        a.Logd("MicroMsg.Voip", "usePreConnect:" + this.sUC);
        String str = "," + this.sUC;
        AppMethodBeat.o(4745);
        return str;
    }

    private String cKE() {
        AppMethodBeat.i(4746);
        a.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.sUD);
        String str = "," + this.sUD;
        AppMethodBeat.o(4746);
        return str;
    }

    private String cKF() {
        AppMethodBeat.i(4747);
        if (VERSION.SDK_INT < 11) {
            this.sUu = 0;
            this.sUv = 2;
        } else {
            this.sUu = 3;
            this.sUv = 3;
        }
        if (q.etd.eqg >= 0) {
            this.sUu = q.etd.eqg;
        }
        if (VERSION.SDK_INT >= 11 && l.IN() && 2 == q.etn.erV) {
            this.sUv = 2;
        }
        if (q.etd.eqh >= 0) {
            this.sUv = q.etd.eqh;
        }
        if (VERSION.SDK_INT < 11) {
            this.sUt = 1;
        } else {
            this.sUt = 7;
        }
        if (q.etd.epG) {
            this.sUt = 1;
        }
        if (q.etd.eqf >= 0) {
            this.sUt = q.etd.eqf;
        }
        if (q.etd.epH > 0) {
            this.sUw = 3;
            this.sUx = 0;
        } else if (q.etd.eqi >= 0) {
            this.sUw = q.etd.eqi;
            this.sUx = q.etd.eqi;
        }
        if (q.etd.eqj >= 0) {
            this.sUw = q.etd.eqj;
        }
        if (q.etd.eqk >= 0) {
            this.sUx = q.etd.eqk;
        }
        String str = "," + this.sUu + "," + this.sUv + "," + this.sUt + "," + this.sUw + "," + this.sUx;
        AppMethodBeat.o(4747);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final String cKG() {
        AppMethodBeat.i(4748);
        getChannelInfo(this.sVz, this.sVz.length, this.sUV, this.sUW, this.sUX, this.sUY);
        a.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(this.nwv + "," + this.nwu + "," + this.nwC + this.sVH.cJg() + ("," + this.sVH.sQu) + new String(this.sVz, 0, this.field_channelStatLength))));
        getChannelReport(this.sVz, this.sVz.length);
        String str = new String(this.sVz, 0, this.field_channelReportLength);
        a.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(str)));
        AppMethodBeat.o(4748);
        return str;
    }

    private String cKH() {
        AppMethodBeat.i(4749);
        getNewEngineInfo(this.sVA, this.sVA.length);
        getNewEngineExtInfo(this.sVB, this.sVB.length);
        a.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.nwC + "," + this.nwv + this.sVH.cJg() + "," + this.sUm + "," + this.sUn + cKC() + new String(this.sVA, 0, this.field_newEngineStatLength) + "," + this.sUo + "," + this.sUp + cKF() + new String(this.sVB, 0, this.field_newEngineExtStatLength))));
        getNewEngineInfoReport(this.sVA, this.sVA.length);
        String str = this.nwC + "," + this.nwv + this.sVH.cJg() + "," + this.sUm + "," + this.sUn + cKC() + new String(this.sVA, 0, this.field_newEngineReportLength);
        a.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
        AppMethodBeat.o(4749);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final String cKI() {
        AppMethodBeat.i(4750);
        getEngine2ndInfo(this.sVC, this.sVC.length);
        a.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.nwv + "," + this.nwu + "," + this.nwC + new String(this.sVC, 0, this.field_engine2ndStatLength))));
        getEngine2ndInfoReport(this.sVC, this.sVC.length);
        String str = this.nwv + "," + this.nwu + "," + this.nwC + new String(this.sVC, 0, this.field_engine2ndReportLength);
        a.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
        AppMethodBeat.o(4750);
        return str;
    }

    public final String cKJ() {
        AppMethodBeat.i(4751);
        String str = cKz() + "," + this.sUA + "," + (cpuFlag0 & 255) + cKF() + "," + this.sUz;
        AppMethodBeat.o(4751);
        return str;
    }

    public v2protocal(ak akVar) {
        AppMethodBeat.i(4752);
        this.handler = akVar;
        AppMethodBeat.o(4752);
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        AppMethodBeat.i(4753);
        if (i == 100) {
            a.outputJniLog(bArr, "MicroMsg.Voip", i2);
            AppMethodBeat.o(4753);
        } else if (i == 101) {
            a.outputJniLog(bArr, "MicroMsg.v2Core", i2);
            AppMethodBeat.o(4753);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
            AppMethodBeat.o(4753);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i, int i2, int[] iArr) {
        AppMethodBeat.i(4754);
        if (iArr != null) {
            a.Logd("MicroMsg.VoipService", "callByJni : arg1:" + i + " arg2:" + i2);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        AppMethodBeat.o(4754);
        return 0;
    }

    public final boolean cKK() {
        return this.isInited;
    }

    public final int a(cok cok, cok cok2, cok cok3, int i, int i2) {
        AppMethodBeat.i(4755);
        if (cok == null || cok.xlZ <= 0) {
            a.Logi("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.Logi("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(cok);
        }
        if (cok2 == null || cok2.xlZ <= 0) {
            a.Logi("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.Logi("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(cok2);
        }
        if (cok3 == null || cok3.xlZ <= 0) {
            a.Logi("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.Logi("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(cok3);
        }
        int forceredirect = forceredirect(i, i2);
        a.Logi("MicroMsg.Voip", "v2protocal forceRedirect ret :".concat(String.valueOf(forceredirect)));
        AppMethodBeat.o(4755);
        return forceredirect;
    }

    private static int cKL() {
        AppMethodBeat.i(4756);
        DhcpInfo dhcpInfo = ((WifiManager) ah.getContext().getSystemService("wifi")).getDhcpInfo();
        a.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(dhcpInfo.gateway))));
        int i = dhcpInfo.gateway;
        AppMethodBeat.o(4756);
        return i;
    }

    public final int a(cok cok, cok cok2, cok cok3, cpu cpu, LinkedList<cps> linkedList) {
        AppMethodBeat.i(4757);
        if (cok.xlZ > 0) {
            a.Logi("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(cok);
        } else {
            a.Logi("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (cok2.xlZ > 0) {
            a.Logi("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(cok2);
        } else {
            a.Logi("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (cok3.xlZ > 0) {
            a.Logi("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(cok3);
        } else {
            a.Logi("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        if (linkedList == null || linkedList.size() <= 0) {
            a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray no nat svr list");
        } else {
            a.Logi("MicroMsg.Voip", "v2protocal natSvr.size() :" + linkedList.size());
            this.field_natSvrArray = a.au(linkedList);
            a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray :" + this.field_natSvrArray.length);
        }
        int i = setsvraddr(cpu.xnK, cpu.xnL, cpu.xnM, cpu.userName, cpu.gDC, cKL());
        a.Logi("MicroMsg.Voip", "v2protocal setsvraddr ret :".concat(String.valueOf(i)));
        AppMethodBeat.o(4757);
        return i;
    }

    public final int cKM() {
        AppMethodBeat.i(4758);
        this.netType = a.getNetType(ah.getContext());
        if (this.netType == 5) {
            this.netType = 4;
        }
        this.sUU = new int[(this.defaultWidth * this.defaultHeight)];
        com.tencent.mm.kernel.g.RN();
        this.kIm = com.tencent.mm.kernel.a.QF();
        int Lw = m.Lw();
        int i = VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        height = init(this.netType, 65538, (this.defaultWidth << 16) | this.defaultHeight, (width << 16) | height, this.kIm, Lw | ((gLVersion << 24) | (i << 16)), com.tencent.mm.compatible.util.e.eSi + "lib/", 4);
        a.Logd("MicroMsg.Voip", "protocal init ret :" + height + ",uin= " + this.kIm);
        this.isInited = true;
        if (height < 0) {
            reset();
        }
        AppMethodBeat.o(4758);
        return height;
    }

    public static boolean cKN() {
        return ((cpuFlag0 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) && ((cpuFlag0 >> 12) & 15) >= 4 && (cpuFlag0 & 255) >= 30 && VERSION.SDK_INT >= 23;
    }

    public final int cEb() {
        int i;
        AppMethodBeat.i(4759);
        this.netType = a.getNetType(ah.getContext());
        this.sTX = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z = this.sTX >= 4 && (cpuFlag0 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (cpuFlag0 & 255) >= 26;
        boolean z2 = z && (cpuFlag0 & 255) >= 30;
        boolean z3 = q.etc.erv > 0 && q.etc.eqX.width >= 480 && q.etc.eqX.height >= v2helper.VOIP_ENC_HEIGHT_LV1 && q.etc.eqZ.width >= 480 && q.etc.eqZ.height >= v2helper.VOIP_ENC_HEIGHT_LV1;
        boolean z4 = q.etc.erv >= 2 && q.etc.eqX.width >= 640 && q.etc.eqX.height >= 480 && q.etc.eqZ.width >= 640 && q.etc.eqZ.height >= 480;
        boolean z5 = q.etc.erv == 0;
        Object obj = q.etc.erw == 0 ? 1 : null;
        Object obj2 = q.etc.erw > 0 ? 1 : null;
        this.sVM = false;
        if (obj == null) {
            boolean z6;
            boolean z7;
            int i2;
            boolean z8 = z2 && abX("video/avc");
            if (obj2 != null) {
                z6 = z2 && (q.etc.erw & 16) != 0;
                boolean z9 = z8 && (q.etc.erw & 15) != 0;
                z7 = z9;
            } else {
                z6 = z2;
                z7 = z8;
            }
            this.sVM = z7;
            a.Logi("MicroMsg.Voip", "hwH264Local:" + z8 + ",hwHEVCLocal:false, bSupportH264HW:" + z7 + ", bSupportHEVCHW:false, svrHWCfg:" + q.etc.erw);
            if (z7) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = z6 ? i2 | 2 : i2;
        } else {
            i = 0;
        }
        if ((z || z3) && !z5) {
            if (this.sVM || z4) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            sTV = true;
            a.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + VideoMaterialUtil.CRAZYFACE_X + this.defaultHeight);
        }
        a.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z3 + ", bDisable480FromSvr:" + z5 + ", bEnable640FromLocal:" + z2 + ", bEnable640FromSvr:" + z4);
        this.sUU = new int[(this.defaultWidth * this.defaultHeight)];
        com.tencent.mm.kernel.g.RN();
        this.kIm = com.tencent.mm.kernel.a.QF();
        int i3 = VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        int init = init(this.netType | (i << 8), 2, (this.defaultWidth << 16) | this.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), this.kIm, cpuFlag0 | ((gLVersion << 24) | (i3 << 16)), com.tencent.mm.compatible.util.e.eSi + "lib/", 0);
        a.Logi("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + this.kIm + ", gl_vs:" + gLVersion + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.isInited = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.o(4759);
        return init;
    }

    public final String mx(boolean z) {
        String stringBuilder;
        AppMethodBeat.i(4760);
        if (this.isInited) {
            a.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(z)));
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.sVH.sQo;
            this.field_ChannelReportDial[1] = this.sVH.sQu;
            this.field_ChannelReportDial[2] = this.sUV;
            this.field_ChannelReportDial[3] = this.sUW;
            this.field_ChannelReportDial[4] = this.sUX;
            this.field_ChannelReportDial[5] = this.sUY;
            this.field_EngineReportStatFromApp = new int[14];
            cKF();
            this.field_EngineReportStatFromApp[0] = this.sUo;
            this.field_EngineReportStatFromApp[1] = this.sUp;
            this.field_EngineReportStatFromApp[2] = this.sUu;
            this.field_EngineReportStatFromApp[3] = this.sUv;
            this.field_EngineReportStatFromApp[4] = this.sUt;
            this.field_EngineReportStatFromApp[5] = this.sUw;
            this.field_EngineReportStatFromApp[6] = this.sUx;
            this.field_EngineReportStatFromApp[7] = -1;
            if (this.sVI != null) {
                this.field_EngineReportStatFromApp[8] = this.sVI.sOv;
                this.field_EngineReportStatFromApp[9] = this.sVI.sOx;
                this.field_EngineReportStatFromApp[10] = this.sVI.sOo;
            } else {
                this.field_EngineReportStatFromApp[8] = 0;
                this.field_EngineReportStatFromApp[9] = 0;
                this.field_EngineReportStatFromApp[10] = 0;
            }
            if (sVJ != null) {
                this.field_EngineReportStatFromApp[11] = sVJ.sOk;
            } else {
                this.field_EngineReportStatFromApp[11] = 0;
            }
            this.field_EngineReportStatFromApp[12] = this.sVl;
            this.field_EngineReportStatFromApp[13] = this.sVm;
            this.isInited = false;
            uninit(this.nwu, this.nwv, this.nwC);
            sTV = false;
            if (this.sVI != null) {
                this.sVI.cIv();
                this.sVI = null;
            }
            if (sVJ != null) {
                sVJ.interrupt();
                sVJ.cIv();
                sVJ = null;
            }
            sVL = null;
            sVN = null;
            a.Logi("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.sVw, this.sVw.length, this.sVF, 30);
                getEngineVersionInfo(this.sVx, this.sVx.length);
                getEngineQosInfo(this.sVy, this.sVy.length);
                StringBuilder stringBuilder2 = new StringBuilder();
                long j = (long) this.kIm;
                if (this.kIm < 0) {
                    j = ((long) this.kIm) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.nwv).append(",").append(this.nwu).append(",").append(this.nwC).append(",");
                n nVar = this.sVH;
                stringBuilder = append.append(nVar.sQe + "," + nVar.sQf + "," + nVar.sQg + "," + nVar.sQh + "," + nVar.sQi + "," + nVar.sQj + "," + nVar.sQk + "," + nVar.sQl + "," + nVar.sQm + "," + nVar.sQn + "," + nVar.sQo).toString();
                a.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(stringBuilder)));
                append = stringBuilder2.append(stringBuilder).append(new String(this.sVw, 0, this.field_statInfoLength)).append(cKz()).append(cKB()).append("," + this.sVH.sQp).append(new String(this.sVx, 0, this.field_engineVersionStatLength)).append(cKC());
                a.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
                stringBuilder = append.append("," + cpuFlag0).append(cKD()).append(cKE()).append(new String(this.sVy, 0, this.field_engineQosStatLength)).toString();
                a.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.sVw, 0, this.field_statInfoLength));
                a.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.sVx, 0, this.field_engineVersionStatLength));
                a.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.sVy, 0, this.field_engineQosStatLength));
                a.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(stringBuilder)));
                ao.a.flv.cm(this.field_netFlowRecv, this.field_netFlowSent);
                a.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                AppMethodBeat.o(4760);
                return stringBuilder;
            }
        }
        stringBuilder = "";
        AppMethodBeat.o(4760);
        return stringBuilder;
    }

    public static String cKO() {
        return "\u0000";
    }

    public final String cKP() {
        AppMethodBeat.i(4761);
        String cKA = cKA();
        AppMethodBeat.o(4761);
        return cKA;
    }

    public final String[] cKQ() {
        AppMethodBeat.i(4762);
        String[] natReport = getNatReport();
        a.Loge("MicroMsg.Voip", "nat_report size:" + natReport.length);
        for (String str : natReport) {
            a.Loge("MicroMsg.Voip", "nat_report:" + str);
        }
        AppMethodBeat.o(4762);
        return natReport;
    }

    public final String cKR() {
        AppMethodBeat.i(4763);
        String cKH = cKH();
        AppMethodBeat.o(4763);
        return cKH;
    }

    public final void reset() {
        AppMethodBeat.i(4764);
        a.Logi("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_natSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.nwu = 0;
        this.sTZ = 0;
        this.sTY = 0;
        this.nwC = 0;
        this.nwv = 0;
        this.channelStrategy = 0;
        this.nwx = 0;
        this.fDH = 0;
        this.sUa = null;
        this.sUb = null;
        this.sUc = null;
        this.sUd = 0;
        this.sUe = null;
        this.sUY = 0;
        this.sUZ = null;
        this.sVa = 0;
        this.sVb = 0;
        this.sUj = null;
        this.sVg = null;
        this.sVh = null;
        this.sVr = 0;
        this.sVs = 0;
        this.sVt = 0;
        this.sVu = 0;
        this.sVv = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.sVG = 0;
        this.sUD = 0;
        this.sUC = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.sUo = 0;
        this.sUp = 0;
        this.sUq = 65536;
        this.sUr = 0;
        this.sUs = 0;
        this.sUz = -1;
        this.sUA = 0;
        this.sVk = 0;
        this.sTW = 0;
        this.nMl = "";
        this.sVi = 0;
        this.sVj = 0;
        this.sVH.reset();
        this.sVH.cJf();
        sTV = false;
        this.field_jbmBitratRsSvrParamArray = null;
        this.field_jbmParamArraySize = 0;
        this.field_jbmBitratRsSvrParamDoubleArray = null;
        this.field_jbmParamDoubleArraySize = 0;
        a.Logi("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
        AppMethodBeat.o(4764);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(4765);
        sVN = new WeakReference(eVar);
        AppMethodBeat.o(4765);
    }

    public static void fX(int i, int i2) {
        AppMethodBeat.i(4766);
        if (sVN != null) {
            e eVar = (e) sVN.get();
            if (eVar != null) {
                int width = eVar.mdt.getWidth();
                int height = eVar.mdt.getHeight();
                double d = ((double) i2) / ((double) i);
                if (!(width == 3 && height == 3)) {
                    int i3;
                    int i4;
                    if (height > ((int) (((double) width) * d))) {
                        i3 = (int) (((double) height) / d);
                        i4 = height;
                    } else {
                        i4 = (int) (d * ((double) width));
                        i3 = width;
                    }
                    int i5 = (width - i3) / 2;
                    int i6 = (height - i4) / 2;
                    ab.i("DecodeTextureView", "video=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + " view=" + width + VideoMaterialUtil.CRAZYFACE_X + height + " newView=" + i3 + VideoMaterialUtil.CRAZYFACE_X + i4 + " off=" + i5 + "," + i6);
                    Matrix matrix = new Matrix();
                    eVar.mdt.getTransform(matrix);
                    matrix.setScale(((float) i3) / ((float) width), ((float) i4) / ((float) height));
                    matrix.postTranslate((float) i5, (float) i6);
                    eVar.mdt.setTransform(matrix);
                }
            }
        }
        AppMethodBeat.o(4766);
    }

    @SuppressLint({"NewApi"})
    private static boolean abX(String str) {
        boolean z;
        Exception e;
        AppMethodBeat.i(4767);
        try {
            if (VERSION.SDK_INT >= 21) {
                int codecCount = MediaCodecList.getCodecCount() - 1;
                z = false;
                while (codecCount >= 0) {
                    try {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                        a.Logd("MicroMsg.Voip", "steve codecInfo : " + codecInfoAt.getName());
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        String name = codecInfoAt.getName();
                        for (String equalsIgnoreCase : supportedTypes) {
                            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                                try {
                                    a.Logd("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(name)));
                                    z = true;
                                } catch (Exception e2) {
                                    e = e2;
                                    z = true;
                                    ab.printErrStackTrace("MicroMsg.Voip", e, "SupportAvcCodec error: %s", e.getMessage());
                                    AppMethodBeat.o(4767);
                                    return z;
                                }
                            }
                        }
                        codecCount--;
                    } catch (Exception e3) {
                        e = e3;
                        ab.printErrStackTrace("MicroMsg.Voip", e, "SupportAvcCodec error: %s", e.getMessage());
                        AppMethodBeat.o(4767);
                        return z;
                    }
                }
            }
            z = false;
        } catch (Exception e4) {
            e = e4;
            z = false;
            ab.printErrStackTrace("MicroMsg.Voip", e, "SupportAvcCodec error: %s", e.getMessage());
            AppMethodBeat.o(4767);
            return z;
        }
        AppMethodBeat.o(4767);
        return z;
    }

    public final int a(a aVar) {
        AppMethodBeat.i(4768);
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger atomicInteger2 = new AtomicInteger();
        AtomicInteger atomicInteger3 = new AtomicInteger();
        int GetAudioFormat = GetAudioFormat(atomicInteger, atomicInteger2, atomicInteger3);
        if (GetAudioFormat == 0) {
            aVar.channels = atomicInteger3.get();
            aVar.sNh = atomicInteger2.get();
            aVar.pug = atomicInteger.get();
            aVar.sNg = 0;
        } else {
            aVar.pug = (m.Lw() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? TXRecordCommon.AUDIO_SAMPLERATE_16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
            aVar.channels = 1;
            aVar.sNh = 20;
            aVar.sNg = 0;
        }
        a.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + GetAudioFormat + ",samplerate = " + aVar.pug + ", framelenms =" + aVar.sNh + ", channels =" + aVar.channels);
        AppMethodBeat.o(4768);
        return GetAudioFormat;
    }
}
