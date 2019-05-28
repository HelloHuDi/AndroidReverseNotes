package com.tencent.wecall.talkroom.model;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.p1368a.p1369a.C25509d;
import com.google.p1368a.p1369a.C25510e;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.C0938f;
import com.tencent.p139g.p809a.C25636d;
import com.tencent.p139g.p809a.C37343a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import com.tencent.p177mm.plugin.multi.talk;
import com.tencent.p177mm.plugin.multi.talk.C28534a;
import com.tencent.p659pb.common.p1102c.C16121b;
import com.tencent.p659pb.common.p1102c.C40956g;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p1102c.C46730f;
import com.tencent.p659pb.common.p1631a.C44437a;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.C30912b;
import com.tencent.p659pb.common.p660b.C44438e;
import com.tencent.p659pb.common.p660b.C44441h;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C16120o;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24189af;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24191at;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24192au;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24194aw;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24197p;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24198q;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24200x;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24209z;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24211ab;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24213ah;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24219aa;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24221ak;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24227as;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24228ay;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24232r;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24237aj;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C5792ac;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.p659pb.talkroom.sdk.C24244c;
import com.tencent.p659pb.talkroom.sdk.C30918b;
import com.tencent.p659pb.talkroom.sdk.C40957f;
import com.tencent.p659pb.talkroom.sdk.C46731e;
import com.tencent.p659pb.talkroom.sdk.C46732g;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wecall.talkroom.model.C6006g.C601017;
import com.tencent.wecall.talkroom.model.C6006g.C601118;
import com.tencent.wecall.talkroom.model.C6006g.C60131;
import com.tencent.wecall.talkroom.model.C6006g.C60147;
import com.tencent.wecall.talkroom.model.C6006g.C601611;
import com.tencent.wecall.talkroom.model.C6006g.C601720;
import com.tencent.wecall.talkroom.model.C6006g.C602015;
import com.tencent.wecall.talkroom.model.C6006g.C602116;
import com.tencent.wecall.talkroom.model.C6006g.C60222;
import com.tencent.wecall.talkroom.model.C6006g.C60256;
import com.tencent.wecall.talkroom.model.C6006g.C60273;
import com.tencent.wecall.talkroom.p1114a.C16377d;
import com.tencent.wecall.talkroom.p1114a.C16378e;
import com.tencent.wecall.talkroom.p1114a.C25015b;
import com.tencent.wecall.talkroom.p1114a.C25016k;
import com.tencent.wecall.talkroom.p1114a.C31130a;
import com.tencent.wecall.talkroom.p1114a.C31131c;
import com.tencent.wecall.talkroom.p1114a.C31132j;
import com.tencent.wecall.talkroom.p1114a.C31133l;
import com.tencent.wecall.talkroom.p1114a.C31134m;
import com.tencent.wecall.talkroom.p1114a.C41109f;
import com.tencent.wecall.talkroom.p1114a.C41110g;
import com.tencent.wecall.talkroom.p1114a.C41111i;
import com.tencent.wecall.talkroom.p1114a.C46824h;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.wecall.talkroom.model.f */
public final class C24507f implements Callback, C25636d, C30912b {
    public static String[] AJN = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    public static List<Integer> AJj = new ArrayList();
    private static int AJq = 30000;
    private static C46731e Amd = null;
    private C37343a AHP;
    private int AJA = 0;
    int AJB = -1;
    public C36578h AJC = C36578h.AKQ;
    C36575b AJD;
    private C28534a AJE;
    private TimerTask AJF;
    private TimerTask AJG;
    private Timer AJH = new Timer("TalkRoomService_HelloTimer");
    private TimerTask AJI;
    private Timer AJJ = new Timer("TalkRoomService_talkDurationTimer");
    C6006g AJK = new C6006g();
    private int AJL = 0;
    private boolean AJM = false;
    public String AJO = null;
    HashSet<Long> AJP = new HashSet();
    public boolean AJQ = false;
    public boolean AJR = true;
    public boolean AJS = true;
    private short[] AJT = null;
    private int[] AJU = null;
    private short[] AJV = null;
    private int[] AJW = null;
    private int AJX = 0;
    public boolean AJY = false;
    public boolean AJZ = true;
    C6005f AJi;
    private Map<String, C6004e> AJk = new HashMap();
    private final int AJl = 1;
    private final int AJm = 2;
    private final int AJn = 3;
    private final int AJo = 4;
    public final int AJp = 6;
    private boolean AJr = false;
    private boolean AJs = false;
    private String AJt;
    public String AJu;
    private int AJv = 0;
    private int AJw = 0;
    private int AJx = 0;
    private long AJy = 0;
    private boolean AJz = true;
    private Runnable AKa = new C245168();
    private C24239d AKb = null;
    private Runnable AKc = new C163799();
    int AlR;
    Handler mHandler;
    boolean mIsMute = false;
    public int nCF;
    boolean nME = false;
    public String neq;
    boolean sRm = false;
    public long sZg;
    int state = 0;

    /* renamed from: com.tencent.wecall.talkroom.model.f$e */
    class C6004e {
        String groupId;
        int nwu;
        long nwv;

        C6004e() {
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$f */
    public interface C6005f {
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$9 */
    class C163799 implements Runnable {
        C163799() {
        }

        public final void run() {
            C24239d c24239d = null;
            AppMethodBeat.m2504i(127878);
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(C24507f.this.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = C24507f.this.AKb == null ? null : Integer.valueOf(C24507f.this.AKb.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(C24507f.this.AJr);
            C44443c.m80389d(str, objArr);
            if (C24507f.this.AKb == null) {
                C24507f.this.mHandler.removeCallbacks(C24507f.this.AKc);
                C44443c.m80392w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.m2505o(127878);
            } else if (C24507f.this.cIJ()) {
                if (C24507f.this.AKb != null && C24507f.this.AKb.getType() == 202 && C24507f.this.state == 3) {
                    C16378e c16378e = (C16378e) C24507f.this.AKb;
                    if (C24507f.m38096a(C24507f.this, c16378e.neq, c16378e.nCF, c16378e.sZg, C24507f.m38079Sp(c16378e.ALs))) {
                        c24239d = new C16378e(c16378e);
                        C44443c.m80392w("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (c24239d != null) {
                    C44438e.dPu().mo70368a(c24239d);
                    AppMethodBeat.m2505o(127878);
                    return;
                }
                C24507f.this.mHandler.removeCallbacks(C24507f.this.AKc);
                C44443c.m80392w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.m2505o(127878);
            } else {
                C24507f.this.mHandler.removeCallbacks(C24507f.this.AKc);
                C44443c.m80392w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.m2505o(127878);
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$d */
    class C16380d {
        int nCF;
        String neq;
        long sZg;
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$2 */
    class C245062 extends TimerTask {
        C245062() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127871);
            if (C24507f.this.nCF == 0 || C24507f.this.neq == null) {
                C44443c.m80392w("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(C24507f.this.nCF), C24507f.this.neq);
                C24507f.m38118k(C24507f.this);
                AppMethodBeat.m2505o(127871);
                return;
            }
            C24507f.m38088a(C24507f.this, C24507f.m38117j(C24507f.this));
            AppMethodBeat.m2505o(127871);
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$1 */
    class C245081 implements C28534a {

        /* renamed from: com.tencent.wecall.talkroom.model.f$1$1 */
        class C245091 implements Runnable {
            C245091() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127864);
                try {
                    C44443c.m80391i("TalkRoomService", "initMediaComponent");
                    C24507f.m38110e(C24507f.this);
                    AppMethodBeat.m2505o(127864);
                } catch (Throwable th) {
                    C44443c.m80392w("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th);
                    AppMethodBeat.m2505o(127864);
                }
            }
        }

        C245081() {
        }

        public final void keep_OnOpenSuccess() {
            int[] iArr = null;
            AppMethodBeat.m2504i(127865);
            C24507f.this.AJC.nxL = 1;
            C44443c.m80389d("TalkRoomService", "engine OnOpenSuccess");
            if (C24507f.this.state != 4) {
                C44443c.m80392w("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(C24507f.this.state));
                AppMethodBeat.m2505o(127865);
                return;
            }
            try {
                C24507f c24507f = C24507f.this;
                C6001c dTg = C6001c.dTg();
                String b = C24507f.this.neq;
                if (!TextUtils.isEmpty(b)) {
                    TalkRoom auE = dTg.auE(b);
                    if (auE != null) {
                        List dSX = auE.dSX();
                        if (dSX != null) {
                            int[] iArr2 = new int[dSX.size()];
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i = 0; i < dSX.size(); i++) {
                                C6003d c6003d = (C6003d) dSX.get(i);
                                if (c6003d != null) {
                                    iArr2[i] = c6003d.dTj();
                                    stringBuffer.append(iArr2[i]);
                                    stringBuffer.append(",");
                                }
                            }
                            C44443c.m80392w("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                            iArr = iArr2;
                        }
                    }
                }
                C24507f.m38089a(c24507f, iArr);
                if (C24507f.this.AJD != null) {
                    C36575b c = C24507f.this.AJD;
                    boolean KU = C24507f.m38075KU();
                    if (C44437a.Alr && c.AIV != null) {
                        if (KU) {
                            c.AIV.setAppCmd(401);
                        } else {
                            c.AIV.setAppCmd(402);
                        }
                    }
                }
                C24507f.this.AJs = true;
                C24507f.this.AJD;
                C46731e dTA = C24507f.dTA();
                if (dTA != null) {
                    dTA.bRk();
                }
                talk talk = C24507f.this.AJD.AIV;
                if (C44437a.Alr) {
                    AtomicInteger atomicInteger = new AtomicInteger();
                    AtomicInteger atomicInteger2 = new AtomicInteger();
                    talk.getSampleRate(atomicInteger, atomicInteger2);
                    int i2 = atomicInteger.get();
                    int i3 = atomicInteger2.get();
                    talk.VOICE_SAMPLERATE = i2;
                    talk.VOICE_FRAME_DURATION = i3;
                    C44443c.m80392w("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.VOICE_SAMPLERATE), Integer.valueOf(talk.VOICE_FRAME_DURATION));
                }
            } catch (Throwable th) {
                C44443c.m80392w("TalkRoomService", "keep_OnOpenSuccess:  ", th);
                AppMethodBeat.m2505o(127865);
                return;
            }
            new Handler(Looper.getMainLooper()).post(new C245091());
            C36578h c36578h = C24507f.this.AJC;
            if (c36578h.ALf == 0) {
                c36578h.AKU = 0;
            } else {
                c36578h.AKU = System.currentTimeMillis() - c36578h.ALf;
            }
            C44443c.m80389d(C36578h.TAG, "endFirstSendPcm", Long.valueOf(c36578h.AKU), Long.valueOf(c36578h.ALf));
            C6006g f = C24507f.this.AJK;
            C60273 c60273 = new C60273();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c60273.run();
                AppMethodBeat.m2505o(127865);
                return;
            }
            f.handler.post(c60273);
            AppMethodBeat.m2505o(127865);
        }

        public final void keep_OnError(int i) {
            int i2 = -401;
            AppMethodBeat.m2504i(127866);
            int i3 = 207;
            int i4 = -3007;
            int i5 = 103;
            switch (i) {
                case -4:
                    i3 = 206;
                    i4 = -3006;
                    i5 = 115;
                    i2 = -400;
                    break;
                case -3:
                    i3 = 205;
                    i5 = 114;
                    i4 = -3005;
                    break;
                case -2:
                    i3 = 204;
                    i5 = 113;
                    i4 = -3004;
                    break;
                case -1:
                    i3 = 203;
                    i5 = 112;
                    i4 = -3003;
                    break;
                default:
                    i2 = -400;
                    break;
            }
            C36578h.m60650St(i4);
            C24507f.this.AJC.mo58375Su(i3);
            C44443c.m80389d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i));
            C24507f.this.mo41155a(C24507f.this.neq, C24507f.this.nCF, C24507f.this.sZg, i5, true);
            C24507f.this.AJK.mo13150k(i2, null);
            AppMethodBeat.m2505o(127866);
        }

        public final void keep_OnNotify(int i) {
            AppMethodBeat.m2504i(127867);
            C44443c.m80392w("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i));
            if (i == 5) {
                C24507f.this.AJC.AKS = 1;
                C36578h c36578h = C24507f.this.AJC;
                if (c36578h.ALf == 0) {
                    c36578h.AKT = 0;
                } else {
                    c36578h.AKT = System.currentTimeMillis() - c36578h.ALf;
                }
                C44443c.m80389d(C36578h.TAG, "endRecvFirstPcm", Long.valueOf(c36578h.ALf), Long.valueOf(c36578h.AKT));
                C24507f.this.AJA = 1;
                C24507f.m38117j(C24507f.this);
            }
            AppMethodBeat.m2505o(127867);
        }

        public final void keep_OnReportEngineRecv(String str, int i) {
            AppMethodBeat.m2504i(127868);
            C44443c.m80389d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i), str);
            StringBuilder stringBuilder = new StringBuilder(C40956g.atI(C24507f.this.AJO));
            stringBuilder.append(",");
            stringBuilder.append(str);
            C36578h.auP(stringBuilder.toString());
            AppMethodBeat.m2505o(127868);
        }

        public final void keep_OnReportEngineSend(String str) {
            AppMethodBeat.m2504i(127869);
            C44443c.m80389d("TalkRoomService", "keep_OnReportEngineSend:", str);
            StringBuilder stringBuilder = new StringBuilder(C40956g.atI(C24507f.this.AJO));
            stringBuilder.append(",");
            stringBuilder.append(str);
            C36578h.auQ(stringBuilder.toString());
            AppMethodBeat.m2505o(127869);
        }

        public final void keep_OnReportChannel(String str) {
            AppMethodBeat.m2504i(127870);
            C44443c.m80389d("TalkRoomService", "keep_OnReportChannel:", str);
            StringBuilder stringBuilder = new StringBuilder(C40956g.atI(C24507f.this.AJO));
            stringBuilder.append(",");
            stringBuilder.append(str);
            C36578h.auR(stringBuilder.toString());
            AppMethodBeat.m2505o(127870);
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$7 */
    class C245137 extends TimerTask {
        C245137() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127876);
            if (!C24507f.this.AJY) {
                C24507f.this.AJv = C24507f.this.AJv + 1;
                if (C24507f.this.AJM) {
                    C24507f.this.AJx = C24507f.this.AJx + 1;
                }
                if (C24507f.this.AJB == 3 || C24507f.this.AJB == 2) {
                    C24507f.this.AJw = C24507f.this.AJw + 1;
                    C24507f.this.AJC.tdt = C24507f.this.AJw;
                }
                C24507f.this.AJC.AKV = C24507f.this.AJv * 1000;
                C24507f.this.AJC.tds = C24507f.this.AJv;
            }
            if (C24507f.this.AJi != null) {
                C24507f.this.AJv;
            }
            AppMethodBeat.m2505o(127876);
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$b */
    public enum C24514b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED;

        static {
            AppMethodBeat.m2505o(127881);
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$5 */
    class C245155 implements C24244c {
        C245155() {
        }

        /* renamed from: Y */
        public final void mo40016Y(byte[] bArr, int i) {
            AppMethodBeat.m2504i(127874);
            try {
                if (C24507f.this.AJs) {
                    if (C24507f.this.mIsMute) {
                        for (int i2 = 0; i2 < bArr.length; i2++) {
                            bArr[i2] = (byte) 0;
                        }
                    }
                    if (C24507f.this.AJs) {
                        C36575b c = C24507f.this.AJD;
                        short s = (short) i;
                        if (C44437a.Alr && c.AIV != null) {
                            c.AIV.SendAudio(bArr, s, 0);
                        }
                        if (C24507f.this.AJR) {
                            C24507f.this.AJR = false;
                            C44443c.m80392w("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i));
                        }
                    }
                    AppMethodBeat.m2505o(127874);
                    return;
                }
                AppMethodBeat.m2505o(127874);
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "initMediaComponent record", e);
                AppMethodBeat.m2505o(127874);
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$8 */
    class C245168 implements Runnable {
        C245168() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127877);
            if (C24507f.this.cIJ() && C24507f.this.nME) {
                C44443c.m80389d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                C36578h.m60648Sr(-2003);
                C24507f.this.AJC.mo58375Su(401);
                C24507f.this.mo41158az(C24507f.this.neq, 3, 108);
            }
            AppMethodBeat.m2505o(127877);
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$a */
    class C24517a {
        String[] AKr;
        C24228ay AKs;
        long AKt;
        String AKu;
        boolean AKv;
        String AKw;
        int AmC;
        String groupId;
        int type;

        C24517a() {
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$c */
    class C24518c {
        String AKI;
        int AmC;
        int AmJ;
        String groupId;
        int nwu;
        long nwv;

        C24518c() {
        }
    }

    /* renamed from: Sp */
    static /* synthetic */ boolean m38079Sp(int i) {
        AppMethodBeat.m2504i(127946);
        boolean So = C24507f.m38078So(i);
        AppMethodBeat.m2505o(127946);
        return So;
    }

    /* renamed from: a */
    static /* synthetic */ void m38087a(C24507f c24507f, int i, C24193av[] c24193avArr, C24227as c24227as, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2, int[] iArr, int i5) {
        AppMethodBeat.m2504i(127945);
        c24507f.m38085a(i, c24193avArr, c24227as, bArr, z, str, i2, j, i3, i4, bArr2, iArr, i5);
        AppMethodBeat.m2505o(127945);
    }

    /* renamed from: k */
    static /* synthetic */ void m38118k(C24507f c24507f) {
        AppMethodBeat.m2504i(127942);
        c24507f.dTv();
        AppMethodBeat.m2505o(127942);
    }

    static {
        AppMethodBeat.m2504i(127947);
        AppMethodBeat.m2505o(127947);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(127882);
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof C16380d)) {
                        C44443c.m80392w("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                    C16380d c16380d = (C16380d) obj;
                    if (c16380d.neq != null) {
                        C44443c.m80389d("TalkRoomService", "handlerInviteTimeOut");
                        if (c16380d.neq.equals(this.neq) && c16380d.nCF == this.nCF && c16380d.sZg == this.sZg) {
                            C36578h.dTG();
                            this.AJC.mo58375Su(501);
                            mo41154a(c16380d.neq, c16380d.nCF, c16380d.sZg, 7);
                            C44443c.m80392w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", c16380d.neq);
                            break;
                        }
                    }
                    C44443c.m80392w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                    break;
                }
                C44443c.m80392w("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof C24517a)) {
                        C44443c.m80392w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    C24517a c24517a = (C24517a) obj;
                    if (C40956g.m71019iA(c24517a.groupId, this.neq)) {
                        String str = c24517a.groupId;
                        String[] strArr = c24517a.AKr;
                        C24228ay c24228ay = c24517a.AKs;
                        int i = c24517a.AmC;
                        int i2 = c24517a.type;
                        long j = c24517a.AKt;
                        String str2 = c24517a.AKu;
                        boolean z = c24517a.AKv;
                        String str3 = c24517a.AKw;
                        this.AJC.dTE();
                        String str4 = "";
                        TalkRoom auE = C6001c.dTg().auE(str);
                        if (auE != null) {
                            String str5;
                            if (auE.AIT == null) {
                                str5 = "";
                            } else {
                                str5 = auE.AIT.name;
                            }
                            str4 = str5;
                        }
                        boolean a = C44438e.dPu().mo70368a(new C16377d(str, strArr, this.AJD.dTd(), str4, c24228ay, i, i2, j, str2, z, str3));
                        this.AJC.mo58376aa("create", "req", String.valueOf(a), String.valueOf(this.state));
                        C44443c.m80392w("TalkRoomService", "sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a));
                        break;
                    }
                }
                C44443c.m80392w("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof C24518c)) {
                        C44443c.m80392w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    C24518c c24518c = (C24518c) obj;
                    if (m38103b(c24518c.groupId, c24518c.nwu, c24518c.nwv, false)) {
                        m38102b(c24518c.groupId, c24518c.nwu, c24518c.nwv, c24518c.AmC, c24518c.AmJ, c24518c.AKI);
                        break;
                    }
                }
                C44443c.m80392w("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 4:
                C46730f.dPL();
                break;
        }
        AppMethodBeat.m2505o(127882);
        return true;
    }

    public C24507f() {
        AppMethodBeat.m2504i(127883);
        C44438e.dPu().mo70367a(201, this);
        C44438e.dPu().mo70367a(202, this);
        C44438e.dPu().mo70367a(203, this);
        C44438e.dPu().mo70367a(204, this);
        C44438e.dPu().mo70367a(205, this);
        C44438e.dPu().mo70367a(206, this);
        C44438e.dPu().mo70367a(207, this);
        C44438e.dPu().mo70367a(208, this);
        C44438e.dPu().mo70367a(210, this);
        C44438e.dPu().mo70367a(209, this);
        C44438e.dPu().mo70367a(211, this);
        C44438e.dPu().mo70367a(212, this);
        C44438e.dPu().mo70367a(213, this);
        C44438e.dPu().mo70367a(214, this);
        C44438e.dPu().mo70367a(800, this);
        C6001c dTg = C6001c.dTg();
        C6006g c6006g = this.AJK;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            C44443c.m80389d("TalkRoomManager", "setTalkServerCallback caller stack: ", r2);
        }
        dTg.AJa = c6006g;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.AHP == null) {
            this.AHP = (C37343a) C0938f.aux("EventCenter");
        }
        C44443c.m80389d("TalkRoomService", "syscall", "register", Boolean.TRUE);
        this.AHP.mo60055a(this, AJN);
        AppMethodBeat.m2505o(127883);
    }

    /* Access modifiers changed, original: final */
    public final boolean dTp() {
        AppMethodBeat.m2504i(127884);
        C44443c.m80389d("TalkRoomService", "initService");
        C46731e c46731e = Amd;
        if (c46731e != null) {
            c46731e.bRj();
        }
        this.AJD = new C36575b();
        this.AJO = this.neq;
        this.AJE = new C245081();
        AppMethodBeat.m2505o(127884);
        return true;
    }

    /* renamed from: ru */
    public final void mo41166ru(boolean z) {
        AppMethodBeat.m2504i(127885);
        this.AJC.groupId = this.neq;
        this.AJC.Amx = this.AJu;
        if (C40956g.isEmpty(this.AJC.groupId)) {
            this.AJC.groupId = "";
        }
        if (C40956g.isEmpty(this.AJC.Amx)) {
            this.AJC.Amx = "";
        }
        this.AJC.sUl = 1;
        this.AJC.nwu = this.nCF;
        this.AJC.nwv = this.sZg;
        C44443c.m80389d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        cEx();
        m38076Km();
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.AJD != null) {
            try {
                this.AJL = this.AJD.dTf();
                i = this.AJD.Close();
            } catch (Throwable th) {
                C44443c.m80392w("TalkRoomService", "uninitService", th);
            }
            C44443c.m80392w("TalkRoomService", "uninitService mid", Integer.valueOf(i));
        }
        if (this.AJD != null) {
            try {
                i = this.AJD.uninitLive();
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "uninitService 2", e);
            }
        }
        this.AJD = null;
        C44443c.m80392w("TalkRoomService", "steve:uninitService set engine null!");
        if (z) {
            String dTB = this.AJC.dTB();
            if (!(TextUtils.isEmpty(this.AJC.groupId) && TextUtils.isEmpty(this.AJC.Amx))) {
                C36578h.auO(dTB);
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessageDelayed(4, 0);
            }
            this.AJC.reset();
            C24507f.m38077La();
        }
        C44443c.m80389d("TalkRoomService", "uninitService end error", Integer.valueOf(i));
        AppMethodBeat.m2505o(127885);
    }

    public final void dTq() {
        AppMethodBeat.m2504i(127886);
        try {
            C44443c.m80392w("TalkRoomService", "stopHoldeOnPusher ");
            if (this.AKa != null) {
                this.mHandler.removeCallbacks(this.AKa);
            }
            AppMethodBeat.m2505o(127886);
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", " stopTimer: ", th);
            AppMethodBeat.m2505o(127886);
        }
    }

    /* renamed from: Km */
    private void m38076Km() {
        AppMethodBeat.m2504i(127887);
        this.AJk.remove(this.neq);
        this.AJL = 0;
        this.mIsMute = false;
        setState(0);
        this.AJs = false;
        m38090a(this.AJu, 0, 0, null, null);
        this.AJu = null;
        this.AlR = 0;
        this.AJv = 0;
        this.AJw = 0;
        this.AJx = 0;
        this.AJz = true;
        this.AJR = true;
        this.AJy = 0;
        this.AJA = 0;
        this.AJr = false;
        this.AJY = false;
        this.AJZ = true;
        dTq();
        this.mHandler.removeMessages(1);
        if (this.AJD != null) {
            this.AJD.dTe();
        }
        dTv();
        dTu();
        dTw();
        dTz();
        this.nME = false;
        this.AJQ = false;
        AppMethodBeat.m2505o(127887);
    }

    /* Access modifiers changed, original: final */
    public final void setState(int i) {
        AppMethodBeat.m2504i(127888);
        C44443c.m80392w("TalkRoomService", "setState newState: ", Integer.valueOf(i));
        if (this.state == i) {
            AppMethodBeat.m2505o(127888);
            return;
        }
        this.state = i;
        this.AJK.onStateChanged(i);
        AppMethodBeat.m2505o(127888);
    }

    /* renamed from: fG */
    static String[] m38113fG(List<String> list) {
        AppMethodBeat.m2504i(127889);
        if (list == null || list.size() <= 0) {
            String[] strArr = new String[0];
            AppMethodBeat.m2505o(127889);
            return strArr;
        }
        String[] strArr2 = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr2[i] = str;
            i = i2;
        }
        AppMethodBeat.m2505o(127889);
        return strArr2;
    }

    /* renamed from: a */
    public final C24514b mo41151a(String str, int i, long j, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(127890);
        C44443c.m80392w("TalkRoomService", "enterTalkRoom", str, str2, Integer.valueOf(this.nCF), Integer.valueOf(i), Long.valueOf(this.sZg), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.FALSE);
        C24514b c24514b;
        if (C36407a.dPN()) {
            C44441h.isNetworkConnected();
            if (C24507f.m38078So(i3) && i3 != 100 && cIJ()) {
                C36578h.m60653a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "isBusy");
                C44443c.m80392w("TalkRoomService", "enterTalkRoom isBusy");
                c24514b = C24514b.BUSY;
                AppMethodBeat.m2505o(127890);
                return c24514b;
            } else if (!m38105bW(i3, str)) {
                C44443c.m80392w("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state));
                C36578h.m60653a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "isNotValidEnterState");
                c24514b = C24514b.NOT_VALID_STATE;
                AppMethodBeat.m2505o(127890);
                return c24514b;
            } else if (TextUtils.isEmpty(str)) {
                C44443c.m80392w("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
                C36578h.m60653a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "groupIdnull");
                c24514b = C24514b.GROUP_NOT_VALID;
                AppMethodBeat.m2505o(127890);
                return c24514b;
            } else {
                if (C24507f.m38078So(i3)) {
                    this.AJC.reset();
                    mo41166ru(false);
                }
                dTp();
                if (cEA()) {
                    this.neq = str;
                    if (C24507f.m38078So(i3)) {
                        this.nCF = i;
                        this.sZg = j;
                    } else {
                        C6004e auM = auM(str);
                        this.nCF = auM == null ? 0 : auM.nwu;
                        this.sZg = auM == null ? 0 : auM.nwv;
                    }
                    this.AJO = str;
                    this.AlR = i2;
                    setState(3);
                    this.sRm = C24507f.m38078So(i3);
                    if (this.sRm) {
                        this.AJC.dTC();
                    }
                    if (!this.sRm || C6001c.dTg().mo13131cp(this.neq, true)) {
                        m38102b(str, this.nCF, this.sZg, i2, i3, str2);
                    } else {
                        C24518c c24518c = new C24518c();
                        c24518c.groupId = str;
                        c24518c.nwu = i;
                        c24518c.nwv = j;
                        c24518c.AmJ = i3;
                        c24518c.AmC = i2;
                        c24518c.AKI = str2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = c24518c;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    c24514b = C24514b.OK;
                    AppMethodBeat.m2505o(127890);
                    return c24514b;
                }
                C44443c.m80392w("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (C24507f.m38078So(i3)) {
                    C36578h.m60653a(str, "", this.nCF, this.sZg, "enter", "req", "false", "initEnginefail");
                    mo41166ru(false);
                } else {
                    this.AJC.mo58376aa("enter", "req", "false", "initEnginefail");
                }
                c24514b = C24514b.INIT_ENGINE_FAILED;
                AppMethodBeat.m2505o(127890);
                return c24514b;
            }
        }
        C44443c.m80392w("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(C36407a.dPN()), " isBindMobile: ", Boolean.valueOf(C36407a.dPO()));
        C36578h.m60653a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "noAuth");
        c24514b = C24514b.NOT_AUTH;
        AppMethodBeat.m2505o(127890);
        return c24514b;
    }

    /* renamed from: b */
    private void m38102b(String str, int i, long j, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(127891);
        C44443c.m80392w("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.TRUE, " wXgroupId: ", str2);
        if (i == 0 || j == 0) {
            C44443c.m80390e("TalkRoomService", "roomId or roomkey is 0..return.");
            AppMethodBeat.m2505o(127891);
            return;
        }
        if (!C24507f.m38078So(i3)) {
            this.AJC.dTF();
        }
        this.AJC.dTE();
        C24239d c16378e = new C16378e(str, i, j, this.AJD.dTd(), i2, i3, str2);
        C44438e.dPu().mo70368a(c16378e);
        m38108c(c16378e);
        AppMethodBeat.m2505o(127891);
    }

    /* renamed from: bW */
    private boolean m38105bW(int i, String str) {
        AppMethodBeat.m2504i(127892);
        if (i == 100) {
            AppMethodBeat.m2505o(127892);
            return true;
        } else if (C24507f.m38078So(i)) {
            if (this.state == 0) {
                AppMethodBeat.m2505o(127892);
                return true;
            }
            AppMethodBeat.m2505o(127892);
            return false;
        } else if (i == 1) {
            boolean auN = auN(str);
            AppMethodBeat.m2505o(127892);
            return auN;
        } else {
            AppMethodBeat.m2505o(127892);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo41154a(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(127893);
        C44443c.m80392w("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(127893);
            return false;
        }
        if (3 == (1 == i2 ? 1 : 3) && i2 != 7) {
            dTr();
        }
        boolean a = C44438e.dPu().mo70368a(new C41111i(str, i, j, i2));
        if (m38103b(str, i, j, false)) {
            this.AJC.mo58376aa("reject", "req", String.valueOf(a), String.valueOf(this.state));
        } else {
            C36578h.m60652a(str, i, j, "reject", "req", String.valueOf(a), String.valueOf(this.state));
        }
        m38091a(str, i, j, false);
        C44443c.m80392w("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.m2505o(127893);
        return a;
    }

    private int dTr() {
        AppMethodBeat.m2504i(127894);
        if (this.AJy == 0) {
            AppMethodBeat.m2505o(127894);
            return 0;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.AJy) / 1000);
        AppMethodBeat.m2505o(127894);
        return currentTimeMillis;
    }

    /* renamed from: eT */
    private boolean m38111eT(String str, int i) {
        AppMethodBeat.m2504i(127895);
        C44443c.m80392w("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(127895);
            return false;
        }
        boolean a = C44438e.dPu().mo70368a(new C31131c(str, i, this.AlR));
        this.AJC.mo58376aa("cancel", "req", String.valueOf(a), String.valueOf(this.state));
        m38091a(str, this.nCF, this.sZg, true);
        C44443c.m80392w("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.m2505o(127895);
        return a;
    }

    /* renamed from: a */
    public final boolean mo41155a(String str, int i, long j, int i2, boolean z) {
        AppMethodBeat.m2504i(127896);
        C44443c.m80392w("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            C44443c.m80389d("TalkRoomService", "exitTalkRoom: has exited");
            AppMethodBeat.m2505o(127896);
            return false;
        }
        boolean a = C44438e.dPu().mo70368a(new C41109f(str, i, j, i2));
        this.AJC.mo58376aa("exit", "req", String.valueOf(a), String.valueOf(this.state));
        m38091a(str, i, j, z);
        C44443c.m80392w("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.m2505o(127896);
        return a;
    }

    /* renamed from: b */
    private static int m38098b(int i, int i2, C30918b c30918b) {
        AppMethodBeat.m2504i(127898);
        int i3 = -100;
        try {
            C46731e c46731e = Amd;
            if (c46731e != null) {
                i3 = c46731e.mo46535a(i, i2, c30918b);
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e);
        }
        C44443c.m80389d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.m2505o(127898);
        return i3;
    }

    /* renamed from: b */
    private static int m38099b(int i, int i2, C24244c c24244c) {
        AppMethodBeat.m2504i(127900);
        int i3 = -100;
        try {
            C46731e c46731e = Amd;
            if (c46731e != null) {
                i3 = c46731e.mo46536a(i, i2, c24244c);
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "startRecord: ", e);
        }
        C44443c.m80389d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.m2505o(127900);
        return i3;
    }

    private void cEx() {
        AppMethodBeat.m2504i(127901);
        C44443c.m80389d("TalkRoomService", "releaseConpent");
        try {
            m38074EB();
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", "releaseConpent ", th);
        }
        try {
            dTs();
            AppMethodBeat.m2505o(127901);
        } catch (Throwable th2) {
            C44443c.m80392w("TalkRoomService", "releaseConpent ", th2);
            AppMethodBeat.m2505o(127901);
        }
    }

    /* renamed from: a */
    public final void mo41152a(int i, int i2, String str, C24239d c24239d) {
        Map I;
        AppMethodBeat.m2504i(127902);
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = c24239d != null ? Integer.valueOf(c24239d.getType()) : "";
        C44443c.m80389d(str2, objArr);
        if (i == 1 || i == 2) {
            I = C16121b.m24452I(Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(VError.ERROR_STICKER_OUTPUT_TEXTURE_ERROR), Integer.valueOf(204), Integer.valueOf(TXLiveConstants.PUSH_ERR_AUDIO_ENCODE_FAIL), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542));
            int type = c24239d.getType();
            if (I.containsKey(Integer.valueOf(type))) {
                C36578h.m60647Sq(((Integer) I.get(Integer.valueOf(type))).intValue());
            }
        }
        C25016k c25016k;
        if (i2 == -1) {
            try {
                if (c24239d.getType() == 201) {
                    C16377d c16377d = (C16377d) c24239d;
                    if (C40956g.m71019iA(this.AJu, c16377d.AJu)) {
                        this.AJC.mo58375Su(301);
                        this.AJC.mo58376aa("create", "resp", "-1", String.valueOf(this.state));
                        m38111eT(c16377d.AJu, 1001);
                        if (!c16377d.ALr) {
                            this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.AJK.mo13150k(-100, null);
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 209) {
                    this.AJK.mo13147eS(((C41110g) c24239d).neq, i2);
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 206) {
                    C31130a c31130a = (C31130a) c24239d;
                    if (!m38103b(c31130a.neq, c31130a.nCF, c31130a.sZg, false)) {
                        C36578h.m60652a(c31130a.neq, c31130a.nCF, c31130a.sZg, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.AJK.mo13144a(c31130a.ALq, C6001c.dTg().auL(c31130a.neq));
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 204) {
                    C25015b c25015b = (C25015b) c24239d;
                    if (m38103b(c25015b.neq, c25015b.nCF, c25015b.sZg, false)) {
                        this.AJC.mo58376aa("add", "resp", "-1", String.valueOf(this.state));
                        this.AJK.mo13150k(-300, null);
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 202) {
                    C16378e c16378e = (C16378e) c24239d;
                    if (m38103b(c16378e.neq, c16378e.nCF, c16378e.sZg, C24507f.m38078So(c16378e.ALs)) && this.state == 3) {
                        this.AJC.mo58375Su(302);
                        this.AJK.mo13150k(-200, null);
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 212) {
                    this.AJK.mo13148fF(null);
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 213) {
                    if (C40956g.equals(((C31132j) c24239d).neq, this.neq)) {
                        this.AJC.mo58376aa("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.AJK.mo13150k(-700, null);
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 211) {
                    C46824h c46824h = (C46824h) c24239d;
                    if (m38103b(c46824h.groupId, c46824h.nwu, c46824h.nwv, false)) {
                        this.AJC.mo58376aa("redirect", "resp", "-1", String.valueOf(this.state));
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else if (c24239d.getType() == 214) {
                    C31133l c31133l = (C31133l) c24239d;
                    if (m38103b(c31133l.neq, c31133l.nCF, c31133l.sZg, false)) {
                        this.AJK.mo13150k(-800, null);
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                } else {
                    if (c24239d.getType() == 800) {
                        c25016k = (C25016k) c24239d;
                        if (m38103b(c25016k.neq, c25016k.nCF, c25016k.sZg, false)) {
                            this.AJK.mo13150k(-1600, null);
                        }
                    }
                    AppMethodBeat.m2505o(127902);
                    return;
                }
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "cancelCreateTalkRoom: ", e);
                AppMethodBeat.m2505o(127902);
                return;
            }
        }
        Map I2;
        C6006g c6006g;
        int i3;
        if (c24239d.getType() == 201) {
            C16377d c16377d2 = (C16377d) c24239d;
            if (!(c16377d2 == null || c16377d2.AlO == null)) {
                Object obj;
                C24209z c24209z = (C24209z) c16377d2.AlO;
                C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(c16377d2.mType), c16377d2.AJu);
                if (c16377d2.ALr) {
                    obj = null;
                } else {
                    obj = 1;
                }
                I2 = C16121b.m24452I(Integer.valueOf(14000), Integer.valueOf(VError.ERROR_FACE_TXT_INIT), Integer.valueOf(14001), Integer.valueOf(VError.ERROR_FACE_MODEL_INIT), Integer.valueOf(14002), Integer.valueOf(-1009));
                if (I2.containsKey(Integer.valueOf(i2))) {
                    C36578h.m60647Sq(((Integer) I2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    AJj = null;
                    if (i2 != 0) {
                        if (C40956g.m71019iA(this.AJu, c16377d2.AJu)) {
                            if (i2 != -1) {
                                this.AJC.mo58375Su(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
                                this.AJC.mo58376aa("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                            }
                            if (this.state != 1) {
                                C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), c16377d2.AJu);
                                if (obj != null) {
                                    this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                m38091a(this.neq, this.nCF, this.sZg, true);
                                if (i2 == 14051) {
                                    this.AJK.mo13150k(-900, null);
                                } else if (i2 == 14052) {
                                    this.AJK.mo13150k(VError.ERROR_FILTER_CREATE_FAIL, null);
                                } else if (i2 == 14053) {
                                    this.AJK.mo13150k(VError.ERROR_BEAUTY_FACE_ATTR_NULL, c24209z);
                                } else if (i2 == 14504) {
                                    this.AJK.mo13150k(-1400, null);
                                } else {
                                    this.AJK.mo13150k(-100, null);
                                }
                                if (obj != null) {
                                    this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AJu, " createScene.mClientGroupId: ", c16377d2.AJu, " errCode: ", Integer.valueOf(i2));
                            if (obj != null) {
                                this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (C40956g.m71019iA(this.AJu, c24209z.Amx)) {
                        this.AJC.mo58376aa("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                        if (this.state != 1) {
                            C36578h.m60647Sq(VError.ERROR_DETECTOR_INSTANCE_INIT);
                            C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), c24209z.Amx, Integer.valueOf(c24209z.sQS), Long.valueOf(c24209z.sQT));
                            if (obj != null) {
                                this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (c24209z.AnR == null || c24209z.AnR.length == 0) {
                            C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), c24209z.Amx, Integer.valueOf(c24209z.sQS), Long.valueOf(c24209z.sQT));
                            C36578h.m60647Sq(-1605);
                            this.AJC.tdf = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                            mo41155a(c24209z.groupId, c24209z.sQS, c24209z.sQT, 116, true);
                            if (obj != null) {
                                this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.AJK.mo13150k(-100, null);
                        } else {
                            m38090a(c24209z.Amx, c24209z.sQS, c24209z.sQT, c24209z.groupId, c24209z.Amz.AoT);
                            this.AJO = c24209z.groupId;
                            this.AlR = c24209z.AmC;
                            setState(4);
                            m38095a(c24209z.AnR, c24209z.AnY, c24209z.AnZ);
                            m38093a(c24209z.groupId, c24209z.Amx, c24209z.AmC, c24209z.sQS, c24209z.sQT, c24209z.And, c24209z.AnS, c24209z.Amz, false, true);
                            if (this.AJK != null) {
                                c6006g = this.AJK;
                                C60256 c60256 = new C60256(C6001c.dTg().auL(c24209z.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    c60256.run();
                                } else {
                                    c6006g.handler.post(c60256);
                                }
                            }
                            byte[] bArr = new byte[c24209z.AnU.length];
                            for (i3 = 0; i3 < c24209z.AnU.length; i3++) {
                                bArr[i3] = (byte) c24209z.AnU[i3];
                            }
                            int[] iArr = new int[c24209z.Aod.length];
                            for (i3 = 0; i3 < c24209z.Aod.length; i3++) {
                                iArr[i3] = c24209z.Aod[i3];
                            }
                            m38085a(0, c24209z.And, c24209z.Ane, bArr, (c24209z.AnT & 2) != 0, c24209z.groupId, c24209z.sQS, c24209z.sQT, c24209z.Aoa, c24209z.Aob, c24209z.Aoc, iArr, c24209z.Ang);
                            if (c24209z.AnX != 0) {
                                C44443c.m80391i("TalkRoomService", "get helloFreqSeconds:" + c24209z.AnX);
                                AJq = c24209z.AnX * 1000;
                            }
                            dTt();
                            m38119l(c24209z.groupId, c24209z.sQS, c24209z.sQT);
                            if (obj != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("result", Boolean.TRUE);
                                hashMap.put("shareUrl", new String(c24209z.Amz.AoN, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("smsShortUrl", new String(c24209z.Amz.AoO, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("groupId", c24209z.groupId);
                                this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, hashMap);
                            }
                            C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg));
                        }
                    } else {
                        C44443c.m80392w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AJu, " resp.clientGroupId: ", c24209z.Amx, Integer.valueOf(c24209z.sQS), Long.valueOf(c24209z.sQT));
                        mo41155a(c24209z.groupId, c24209z.sQS, c24209z.sQT, 110, false);
                        if (obj != null) {
                            this.AHP.mo60056c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (c24239d.getType() == 202) {
            C16378e c16378e2 = (C16378e) c24239d;
            if (!(c16378e2 == null || c16378e2.AlO == null)) {
                m38083a(i2, (C24219aa) c16378e2.AlO, c16378e2);
            }
        }
        if (c24239d.getType() == 204) {
            C25015b c25015b2 = (C25015b) c24239d;
            if (!(c25015b2 == null || c25015b2.AlO == null)) {
                C24200x c24200x = (C24200x) c25015b2.AlO;
                C44443c.m80392w("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), " errCode: ", Integer.valueOf(i2));
                I2 = C16121b.m24452I(Integer.valueOf(14600), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL), Integer.valueOf(14601), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL), Integer.valueOf(14602), Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL));
                if (I2.containsKey(Integer.valueOf(i2))) {
                    C36578h.m60647Sq(((Integer) I2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    if (m38103b(c25015b2.neq, c25015b2.nCF, c25015b2.sZg, false)) {
                        this.AJC.mo58376aa("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.AJK.mo13150k(-300, null);
                    }
                } else {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(c24200x.AnQ == null ? 0 : c24200x.AnQ.length);
                    C44443c.m80392w(str2, objArr);
                    if (m38103b(c24200x.groupId, c24200x.sQS, c24200x.sQT, false)) {
                        this.AJC.mo58376aa("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    } else {
                        C44443c.m80392w("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", c24200x.groupId, this.neq, " resp.roomid: ", Integer.valueOf(c24200x.sQS), Integer.valueOf(this.nCF));
                        C36578h.m60647Sq(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED);
                    }
                    m38093a(c24200x.groupId, null, this.AlR, c24200x.sQS, c24200x.sQT, c24200x.AnQ, null, c24200x.Amz, true, true);
                }
            }
        }
        if (c24239d.getType() == 203) {
            C41109f c41109f = (C41109f) c24239d;
            if (!(c41109f == null || c41109f.AlO == null)) {
                C24211ab c24211ab = (C24211ab) c41109f.AlO;
                C44443c.m80389d("TalkRoomService", "handleExitVoiceRoomEnd", c24211ab.groupId, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), " errCode: ", Integer.valueOf(i2));
                I = C16121b.m24452I(Integer.valueOf(14400), Integer.valueOf(VError.ERROR_STICKER_INPUT_BUFFER_ERROR), Integer.valueOf(14401), Integer.valueOf(VError.ERROR_STICKER_OUTPUT_BUFFER_ERROR), Integer.valueOf(14402), Integer.valueOf(VError.ERROR_STICKER_FACE_ATTR_ERROR), Integer.valueOf(14403), Integer.valueOf(VError.ERROR_STICKER_INPUT_TEXTURE_ERROR));
                if (I.containsKey(Integer.valueOf(i2))) {
                    C36578h.m60647Sq(((Integer) I.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    C44443c.m80392w("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2));
                }
            }
        }
        if (c24239d.getType() == 205) {
            C31134m c31134m = (C31134m) c24239d;
            if (!(c31134m == null || c31134m.AlO == null)) {
                C24221ak c24221ak = (C24221ak) c31134m.AlO;
                C44443c.m80389d("TalkRoomService", "handleHelloEnd", c24221ak.groupId, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Integer.valueOf(i2), Integer.valueOf(i));
                dTu();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.AJC.mo58375Su(C19281ab.CTRL_INDEX);
                    C36578h.m60647Sq(i3);
                }
            }
        }
        if (c24239d.getType() == 206) {
            C31130a c31130a2 = (C31130a) c24239d;
            if (!(c31130a2 == null || c31130a2.AlO == null)) {
                C44443c.m80392w("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", c31130a2.neq, " roomid: ", Integer.valueOf(c31130a2.nCF), " roomKey: ", Long.valueOf(c31130a2.sZg));
                MultiTalkGroup auL;
                if (i2 == 18950) {
                    if (!m38103b(c31130a2.neq, c31130a2.nCF, c31130a2.sZg, false)) {
                        C36578h.m60652a(c31130a2.neq, c31130a2.nCF, c31130a2.sZg, "ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                    }
                    auL = C6001c.dTg().auL(c31130a2.neq);
                    C44443c.m80392w("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", c31130a2.neq, " multiTalkGroup: ", auL);
                    if (auL != null) {
                        this.AJK.mo13144a(c31130a2.ALq, auL);
                    }
                } else {
                    if (i2 == 0) {
                        this.AJr = true;
                    }
                    if (!cIJ()) {
                        C44443c.m80392w("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", c31130a2.neq);
                        this.AJC.reset();
                        mo41166ru(false);
                        this.AJC.mo58376aa("ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.sRm = false;
                        this.neq = c31130a2.neq;
                        this.AJO = this.neq;
                        this.nCF = c31130a2.nCF;
                        this.sZg = c31130a2.sZg;
                        this.AlR = c31130a2.AlR;
                        setState(2);
                        this.AJy = System.currentTimeMillis();
                        C36578h c36578h = this.AJC;
                        C44443c.m80389d(C36578h.TAG, "beginNotifyTime");
                        c36578h.ALg = System.currentTimeMillis();
                        if (i2 == 18900) {
                            C36578h.m60647Sq(-1521);
                        }
                    } else if (C40956g.equals(c31130a2.neq, this.neq)) {
                        C44443c.m80392w("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.neq);
                    }
                    C6004e c6004e = new C6004e();
                    c6004e.groupId = c31130a2.neq;
                    c6004e.nwu = c31130a2.nCF;
                    c6004e.nwv = c31130a2.sZg;
                    this.AJk.put(c31130a2.neq, c6004e);
                    auL = C6001c.dTg().auL(c31130a2.neq);
                    C44443c.m80392w("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", c31130a2.neq, " multiTalkGroup: ", auL);
                    if (auL != null) {
                        c6006g = this.AJK;
                        C601720 c601720 = new C601720(auL);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            c601720.run();
                        } else {
                            c6006g.handler.post(c601720);
                        }
                    } else {
                        mo41153a(c31130a2.neq, c31130a2.nCF, c31130a2.sZg, false, false, false);
                    }
                }
            }
        }
        if (c24239d.getType() == 207) {
            C41111i c41111i = (C41111i) c24239d;
            if (!(c41111i == null || c41111i.AlO == null)) {
                if (i2 == 18100) {
                    C36578h.m60647Sq(-1501);
                }
                C44443c.m80392w("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i2));
            }
        }
        if (c24239d.getType() == 208) {
            C31131c c31131c = (C31131c) c24239d;
            if (!(c31131c == null || c31131c.AlO == null)) {
                if (i2 == 18300) {
                    C36578h.m60647Sq(-1531);
                }
                C44443c.m80392w("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i2));
            }
        }
        if (c24239d.getType() == 209) {
            C41110g c41110g = (C41110g) c24239d;
            if (!(c41110g == null || c41110g.AlO == null)) {
                C5792ac c5792ac = (C5792ac) c41110g.AlO;
                if (i2 == 17900) {
                    C36578h.m60647Sq(-1511);
                }
                if (i2 != 0) {
                    this.AJK.mo13147eS(c41110g.neq, i2);
                    C44443c.m80392w("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2));
                } else {
                    TalkRoom auE = C6001c.dTg().auE(c5792ac.groupId);
                    if (auE != null) {
                        C44443c.m80392w("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                        m38093a(c5792ac.groupId, null, auE.dSU(), TalkRoom.dSV(), TalkRoom.cKa(), null, null, c5792ac.Amz, true, false);
                    } else {
                        m38093a(c5792ac.groupId, null, 0, 0, 0, null, null, c5792ac.Amz, true, false);
                    }
                    this.AJK.mo13147eS(c5792ac.groupId, 0);
                }
            }
        }
        if (c24239d.getType() == 210) {
            C44443c.m80389d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 19100) {
                C36578h.m60647Sq(-1541);
            }
        }
        if (c24239d.getType() == 211) {
            C46824h c46824h2 = (C46824h) c24239d;
            if (c46824h2 != null) {
                m38082a(i, i2, c24239d.AlO, c46824h2);
            }
        }
        if (c24239d.getType() == 212) {
            m38084a(i2, (C24213ah) c24239d.AlO);
        }
        if (c24239d.getType() == 213) {
            C31132j c31132j = (C31132j) c24239d;
            C44443c.m80392w("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i2));
            if (i2 != 0) {
                if (C40956g.equals(c31132j.neq, this.neq)) {
                    this.AJC.mo58376aa("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.AJK.mo13150k(-700, null);
                }
            } else if (C40956g.equals(c31132j.neq, this.neq)) {
                this.AJC.mo58376aa("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                c6006g = this.AJK;
                C601118 c601118 = new C601118();
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    c601118.run();
                } else {
                    c6006g.handler.post(c601118);
                }
            }
        }
        if (c24239d.getType() == 214) {
            C24189af c24189af = (C24189af) c24239d.AlO;
            C31133l c31133l2 = (C31133l) c24239d;
            C44443c.m80392w("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i2));
            if (m38103b(c31133l2.neq, c31133l2.nCF, c31133l2.sZg, false)) {
                if (this.AJD != null) {
                    C44443c.m80389d("TalkRoomService", "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[0]), Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[1]), Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[2]), Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[3]), Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[4]), Integer.valueOf(new int[]{c24189af.Aof, c24189af.Aog, c24189af.Aoh, c24189af.Aoi, c24189af.Aoj, c24189af.Aok}[5]));
                    C36575b c36575b = this.AJD;
                    if (c36575b.AIV == null) {
                        C44443c.m80392w("simon:TalkRoomContext", "steve:setMVSvrCfg null, pMVSvrCfg:", r5, ", engine:", c36575b.AIV);
                    } else {
                        c36575b.AIV.setMVSvrCfg(r5, 6);
                    }
                }
                if (i2 == 0) {
                    C6006g c6006g2 = this.AJK;
                    C602015 c602015 = new C602015(c24189af.Aof);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        c602015.run();
                    } else {
                        c6006g2.handler.post(c602015);
                    }
                } else if (i2 == 24301) {
                    this.AJK.mo13150k(-1700, Integer.valueOf(c24189af.Aom));
                } else {
                    this.AJK.mo13150k(-800, null);
                }
            } else {
                C44443c.m80392w("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", c31133l2.neq, Integer.valueOf(c31133l2.nCF));
            }
        }
        if (c24239d.getType() == 800) {
            c25016k = (C25016k) c24239d;
            C44443c.m80392w("TalkRoomService", "handleSubscribeLargeVideo errCode: ", Integer.valueOf(i2));
            if (!m38103b(c25016k.neq, c25016k.nCF, c25016k.sZg, false)) {
                C44443c.m80392w("TalkRoomService", "handleSubscribeLargeVideo isCurrentRoom is not same", c25016k.neq, Integer.valueOf(c25016k.nCF));
                AppMethodBeat.m2505o(127902);
                return;
            } else if (i2 == 0) {
                c6006g = this.AJK;
                C602116 c602116 = new C602116();
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    c602116.run();
                    AppMethodBeat.m2505o(127902);
                    return;
                }
                c6006g.handler.post(c602116);
                AppMethodBeat.m2505o(127902);
                return;
            } else {
                this.AJK.mo13150k(-1600, null);
            }
        }
        AppMethodBeat.m2505o(127902);
    }

    /* renamed from: a */
    public final int mo41149a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(127903);
        int i5 = -1;
        if (this.nME && this.AJD != null) {
            int i6;
            try {
                C44443c.m80389d("TalkRoomService", "sendVideo ", Integer.valueOf(i), Integer.valueOf(i2));
                C36575b c36575b = this.AJD;
                if (bArr == null || c36575b.AIV == null) {
                    C44443c.m80392w("simon:TalkRoomContext", "steve:sendVideo null, buffer:", bArr, ", engine:", c36575b.AIV);
                    i6 = -1;
                    C44443c.m80389d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.nME), " ret: ", Integer.valueOf(i6), " engine: ", this.AJD);
                    i5 = i6;
                } else {
                    i6 = c36575b.AIV.SendVideo(bArr, s, i, i2, i3, i4);
                    C44443c.m80389d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.nME), " ret: ", Integer.valueOf(i6), " engine: ", this.AJD);
                    i5 = i6;
                }
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "sendVideo error: ", e);
                i6 = -1;
            }
        }
        AppMethodBeat.m2505o(127903);
        return i5;
    }

    /* renamed from: a */
    public final C46732g mo41150a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        C46732g c46732g;
        AppMethodBeat.m2504i(127904);
        C46732g c46732g2 = new C46732g();
        if (this.nME && this.AJD != null) {
            try {
                C44443c.m80389d("TalkRoomService", "videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3));
                C36575b c36575b = this.AJD;
                if (bArr == null || c36575b.AIV == null) {
                    C44443c.m80392w("simon:TalkRoomContext", "steve:videoTrans null, recordData:", bArr, ", engine:", c36575b.AIV);
                    c46732g = null;
                    C44443c.m80389d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", c46732g, " engine: ", this.AJD);
                    AppMethodBeat.m2505o(127904);
                    return c46732g;
                }
                int videoTrans = c36575b.AIV.videoTrans(bArr, i, i2, i3, i4, iArr);
                c46732g = new C46732g();
                c46732g.Aqo = iArr;
                c46732g.Aqp = c36575b.AIV.field_localImgWidth;
                c46732g.Aqq = c36575b.AIV.field_localImgHeight;
                c46732g.ret = videoTrans;
                C44443c.m80389d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", c46732g, " engine: ", this.AJD);
                AppMethodBeat.m2505o(127904);
                return c46732g;
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "videoTrans error: ", e);
            }
        }
        c46732g = c46732g2;
        C44443c.m80389d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", c46732g, " engine: ", this.AJD);
        AppMethodBeat.m2505o(127904);
        return c46732g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x017c A:{Catch:{ Exception -> 0x011d }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1 A:{Catch:{ Exception -> 0x011d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: D */
    public final C40957f mo41148D(int[] iArr) {
        AppMethodBeat.m2504i(127905);
        C40957f c40957f = new C40957f();
        if (this.nME && this.AJD != null) {
            C40957f c40957f2;
            try {
                C44443c.m80389d("TalkRoomService", "receiveVideo");
                C36575b c36575b = this.AJD;
                C40957f c40957f3 = new C40957f();
                if (iArr == null || c36575b.AIV == null) {
                    C44443c.m80392w("simon:TalkRoomContext", "steve:receiveVideo null, imgBuffer:", iArr, ", engine:", c36575b.AIV);
                    c40957f2 = c40957f3;
                    C44443c.m80389d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", c40957f2, " engine: ", this.AJD);
                    c40957f = c40957f2;
                } else {
                    String str;
                    Object[] objArr;
                    c40957f3.ret = c36575b.AIV.videoDecode(iArr);
                    c40957f3.Aqj = iArr;
                    c40957f3.Aqk = c36575b.AIV.field_remoteImgLength;
                    c40957f3.Aql = c36575b.AIV.field_remoteImgWidth;
                    c40957f3.Aqm = c36575b.AIV.field_remoteImgHeight;
                    c40957f3.Aqn = c36575b.AIV.field_remoteImgChannel & 16383;
                    C6001c dTg = C6001c.dTg();
                    String str2 = C41112a.dSR().neq;
                    int i = c40957f3.Aqn;
                    if (TextUtils.isEmpty(str2)) {
                        C44443c.m80392w("TalkRoomManager", "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i));
                    } else {
                        TalkRoom auE = dTg.auE(str2);
                        if (auE == null) {
                            C44443c.m80392w("TalkRoomManager", "getUsrNameByMemberId talkRoom is null groupId: ", str2, " memberId: ", Integer.valueOf(i));
                        } else {
                            for (C24193av c24193av : auE.dTb()) {
                                if (c24193av != null && c24193av.kyZ == i) {
                                    C44443c.m80389d("TalkRoomManager", "getUsrNameByMemberId wxUserName:", c24193av.Aop, " groupId: ", str2, " memberId: ", Integer.valueOf(i));
                                    if (c24193av.Aop != null) {
                                        str = c24193av.Aop;
                                        c40957f3.Aqh = str;
                                        str2 = "simon:TalkRoomContext";
                                        objArr = new Object[4];
                                        objArr[0] = "steve:receiveVideo imgBuffer size:";
                                        objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                        objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                        objArr[3] = c40957f3;
                                        C44443c.m80389d(str2, objArr);
                                        c40957f2 = c40957f3;
                                        C44443c.m80389d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", c40957f2, " engine: ", this.AJD);
                                        c40957f = c40957f2;
                                    }
                                }
                            }
                        }
                    }
                    str = "";
                    c40957f3.Aqh = str;
                    str2 = "simon:TalkRoomContext";
                    objArr = new Object[4];
                    objArr[0] = "steve:receiveVideo imgBuffer size:";
                    if (iArr != null) {
                    }
                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                    objArr[3] = c40957f3;
                    C44443c.m80389d(str2, objArr);
                    c40957f2 = c40957f3;
                    C44443c.m80389d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", c40957f2, " engine: ", this.AJD);
                    c40957f = c40957f2;
                }
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomService", "receiveVideo error: ", e);
                c40957f2 = c40957f;
            }
        }
        AppMethodBeat.m2505o(127905);
        return c40957f;
    }

    /* renamed from: a */
    private void m38084a(int i, C24213ah c24213ah) {
        AppMethodBeat.m2504i(127906);
        C44443c.m80392w("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i));
        if (i != 0) {
            this.AJK.mo13148fF(null);
            AppMethodBeat.m2505o(127906);
            return;
        }
        C24192au[] c24192auArr = c24213ah.Aon;
        if (c24192auArr == null || c24192auArr.length == 0) {
            C44443c.m80392w("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            AppMethodBeat.m2505o(127906);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C24192au c24192au : c24192auArr) {
            if (c24192au != null) {
                m38093a(c24192au.groupId, null, 0, c24192au.sQS, c24192au.sQT, c24192au.AnQ, null, null, false, false);
                arrayList.add(C6001c.dTg().auL(c24192au.groupId));
            }
        }
        C44443c.m80392w("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.AJK.mo13148fF(arrayList);
        AppMethodBeat.m2505o(127906);
    }

    /* renamed from: a */
    private void m38082a(int i, int i2, Object obj, C46824h c46824h) {
        AppMethodBeat.m2504i(127907);
        C44443c.m80389d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0 || obj == null) {
            C44443c.m80390e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2));
            if (m38103b(c46824h.groupId, c46824h.nwu, c46824h.nwv, false)) {
                this.AJC.mo58376aa("redirect", "resp", "-1", String.valueOf(this.state));
            }
            AppMethodBeat.m2505o(127907);
            return;
        }
        C24237aj c24237aj = (C24237aj) obj;
        if (m38103b(c24237aj.groupId, c24237aj.sQS, c24237aj.sQT, false)) {
            int i3;
            this.AJC.mo58376aa("redirect", "resp", String.valueOf(i2), String.valueOf(this.state));
            m38093a(c24237aj.groupId, null, this.AlR, c24237aj.sQS, c24237aj.sQT, c24237aj.AnQ, c24237aj.AnS, c24237aj.Amz, false, false);
            byte[] bArr = new byte[c24237aj.AnU.length];
            for (i3 = 0; i3 < c24237aj.AnU.length; i3++) {
                bArr[i3] = (byte) c24237aj.AnU[i3];
            }
            int[] iArr = new int[c24237aj.Aod.length];
            for (i3 = 0; i3 < c24237aj.Aod.length; i3++) {
                iArr[i3] = c24237aj.Aod[i3];
            }
            m38095a(c24237aj.AnR, c24237aj.AnY, c24237aj.AnZ);
            this.AJD.Close();
            m38085a(0, c24237aj.AnQ, c24237aj.Ane, bArr, (c24237aj.AnT & 2) != 0, c24237aj.groupId, c24237aj.sQS, c24237aj.sQT, c24237aj.Aoa, c24237aj.Aob, c24237aj.Aoc, iArr, c24237aj.Ang);
            AppMethodBeat.m2505o(127907);
            return;
        }
        C44443c.m80390e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(c24237aj.sQS), Integer.valueOf(this.nCF));
        AppMethodBeat.m2505o(127907);
    }

    /* renamed from: a */
    private void m38083a(int i, C24219aa c24219aa, C16378e c16378e) {
        AppMethodBeat.m2504i(127908);
        C44443c.m80389d("TalkRoomService", "handleEnterTalkRoomEnd", c16378e.neq, Integer.valueOf(c16378e.nCF), Long.valueOf(c16378e.sZg), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state));
        Map I = C16121b.m24452I(Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111));
        if (I.containsKey(Integer.valueOf(i))) {
            C36578h.m60647Sq(((Integer) I.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            C44443c.m80390e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), c24219aa.groupId, Integer.valueOf(c24219aa.sQS), Long.valueOf(c24219aa.sQT));
            this.AJK.mo13150k(-14255, c24219aa);
            AppMethodBeat.m2505o(127908);
        } else if (i == 14256) {
            C44443c.m80390e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), c24219aa.groupId, Integer.valueOf(c24219aa.sQS), Long.valueOf(c24219aa.sQT));
            this.AJK.mo13150k(-14256, c24219aa);
            AppMethodBeat.m2505o(127908);
        } else if (i != 0 && i != 14204) {
            if (!m38103b(c16378e.neq, c16378e.nCF, c16378e.sZg, C24507f.m38078So(c16378e.ALs))) {
                C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", c16378e.neq, " mGroupId: ", this.neq, Integer.valueOf(c16378e.nCF), Integer.valueOf(this.nCF), Long.valueOf(c16378e.sZg), Long.valueOf(this.sZg));
                AppMethodBeat.m2505o(127908);
            } else if (3 != this.state) {
                C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), c16378e.neq, Integer.valueOf(c16378e.nCF), Long.valueOf(c16378e.sZg));
                AppMethodBeat.m2505o(127908);
            } else {
                this.AJC.mo58376aa("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                this.AJC.mo58375Su(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
                C44443c.m80392w("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), c16378e.neq, Integer.valueOf(c16378e.nCF), Long.valueOf(c16378e.sZg));
                m38091a(c16378e.neq, c16378e.nCF, c16378e.sZg, true);
                if (i == 14251) {
                    this.AJK.mo13150k(-1000, null);
                    AppMethodBeat.m2505o(127908);
                } else if (i == 14252) {
                    this.AJK.mo13150k(VError.ERROR_STICKER_CREATE_FAIL, null);
                    AppMethodBeat.m2505o(127908);
                } else if (i == 14253) {
                    Object valueOf = Integer.valueOf(60);
                    if (c24219aa != null) {
                        valueOf = Integer.valueOf(c24219aa.AnW);
                    }
                    this.AJK.mo13150k(-1500, valueOf);
                    AppMethodBeat.m2505o(127908);
                } else {
                    this.AJK.mo13150k(-200, null);
                    AppMethodBeat.m2505o(127908);
                }
            }
        } else if (i == 14204 && this.state == 4) {
            C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", c24219aa.groupId, Integer.valueOf(c24219aa.sQS), Long.valueOf(c24219aa.sQT));
            AppMethodBeat.m2505o(127908);
        } else {
            if (!m38103b(c24219aa.groupId, c24219aa.sQS, c24219aa.sQT, C24507f.m38078So(c24219aa.AmJ))) {
                C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", c24219aa.groupId, " mGroupId: ", this.neq, Integer.valueOf(c24219aa.sQS), Integer.valueOf(this.nCF), Long.valueOf(c24219aa.sQT), Long.valueOf(this.sZg));
                mo41155a(c24219aa.groupId, c24219aa.sQS, c24219aa.sQT, 111, false);
                C36578h.m60647Sq(-1110);
                AppMethodBeat.m2505o(127908);
            } else if (this.state != 3) {
                C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), c24219aa.groupId, Integer.valueOf(c24219aa.sQS), Long.valueOf(c24219aa.sQT));
                AppMethodBeat.m2505o(127908);
            } else {
                this.AJC.mo58376aa("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                if (c24219aa.AnR == null || c24219aa.AnR.length == 0) {
                    C44443c.m80392w("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), c24219aa.groupId, Integer.valueOf(c24219aa.sQS), Long.valueOf(c24219aa.sQT));
                    C36578h.m60647Sq(-1605);
                    this.AJC.tdf = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                    mo41155a(c24219aa.groupId, c24219aa.sQS, c24219aa.sQT, 116, true);
                    this.AJK.mo13150k(-200, null);
                    AppMethodBeat.m2505o(127908);
                    return;
                }
                int i2;
                this.neq = c24219aa.groupId;
                this.AJO = c24219aa.groupId;
                this.nCF = c24219aa.sQS;
                this.sZg = c24219aa.sQT;
                setState(4);
                m38095a(c24219aa.AnR, c24219aa.AnY, c24219aa.AnZ);
                m38093a(c24219aa.groupId, null, this.AlR, c24219aa.sQS, c24219aa.sQT, c24219aa.AnQ, c24219aa.AnS, c24219aa.Amz, false, true);
                C6006g c6006g = this.AJK;
                C60147 c60147 = new C60147(C6001c.dTg().auL(c24219aa.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    c60147.run();
                } else {
                    c6006g.handler.post(c60147);
                }
                byte[] bArr = new byte[c24219aa.AnU.length];
                for (i2 = 0; i2 < c24219aa.AnU.length; i2++) {
                    bArr[i2] = (byte) c24219aa.AnU[i2];
                }
                int[] iArr = new int[c24219aa.Aod.length];
                for (i2 = 0; i2 < c24219aa.Aod.length; i2++) {
                    iArr[i2] = c24219aa.Aod[i2];
                }
                m38085a(0, c24219aa.AnQ, c24219aa.Ane, bArr, (c24219aa.AnT & 2) != 0, c24219aa.groupId, c24219aa.sQS, c24219aa.sQT, c24219aa.Aoa, c24219aa.Aob, c24219aa.Aoc, iArr, c24219aa.Ang);
                if (c24219aa.AnX != 0) {
                    C44443c.m80391i("TalkRoomService", "get helloFreqSeconds:" + c24219aa.AnX);
                    AJq = c24219aa.AnX * 1000;
                }
                dTt();
                C44443c.m80392w("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg));
                AppMethodBeat.m2505o(127908);
            }
        }
    }

    /* renamed from: a */
    private void m38093a(String str, String str2, int i, int i2, long j, C24193av[] c24193avArr, C24194aw[] c24194awArr, C24191at c24191at, boolean z, boolean z2) {
        Integer num;
        AppMethodBeat.m2504i(127909);
        C24507f.m38092a(str, i2, j, c24193avArr);
        C6001c dTg = C6001c.dTg();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z3 = this.neq != null && this.neq.equals(str);
        boolean a = dTg.mo13124a(str, str2, num, i2, j, c24191at, c24193avArr, c24194awArr, z, z3);
        String str3 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.neq;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.nCF);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.sZg);
        objArr[7] = Boolean.valueOf(a);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(m38103b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(c24193avArr != null ? c24193avArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.AJz);
        C44443c.m80389d(str3, objArr);
        if (C6001c.dTg().mo13131cp(this.neq, false)) {
            C44443c.m80392w("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.AJz), " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i2));
            if (this.AJz) {
                this.AJz = false;
                this.nME = true;
                this.AJM = C41114k.dTJ();
                this.AJx = this.AJv;
                dTy();
            }
        }
        if (c24193avArr == null) {
            AppMethodBeat.m2505o(127909);
            return;
        }
        if (z2 && m38103b(str, i2, j, false) && c24193avArr.length > 0 && this.AJD != null) {
            m38094a(c24193avArr);
        }
        AppMethodBeat.m2505o(127909);
    }

    /* renamed from: a */
    private void m38094a(C24193av[] c24193avArr) {
        AppMethodBeat.m2504i(127910);
        if (c24193avArr == null) {
            C44443c.m80392w("TalkRoomService", "onMebersChangedToEngine members is null");
            AppMethodBeat.m2505o(127910);
            return;
        }
        int[] iArr = new int[c24193avArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < c24193avArr.length; i++) {
            iArr[i] = c24193avArr[i].kyZ;
            stringBuffer.append(c24193avArr[i].kyZ);
            stringBuffer.append(",");
        }
        C44443c.m80392w("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.AJD == null) {
            C44443c.m80392w("TalkRoomService", "onMebersChangedToEngine engine is null");
            AppMethodBeat.m2505o(127910);
            return;
        }
        this.AJD.OnMembersChanged(iArr);
        AppMethodBeat.m2505o(127910);
    }

    /* renamed from: a */
    private static void m38092a(String str, int i, long j, C24193av[] c24193avArr) {
        AppMethodBeat.m2504i(127911);
        if (c24193avArr == null) {
            C44443c.m80392w("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i), "  roomKey", Long.valueOf(j));
            AppMethodBeat.m2505o(127911);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (C24193av c24193av : c24193avArr) {
            if (c24193av != null) {
                stringBuffer.append(" memberId:" + c24193av.kyZ + " uuid: " + c24193av.Aop + " status: " + c24193av.status + "   mem.inviteTime:" + c24193av.Api + "  mem.reason: " + c24193av.boZ + "  mem.inviteuuid: " + c24193av.Apu + IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        C44443c.m80392w("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(c24193avArr.length), "  ", stringBuffer.toString());
        AppMethodBeat.m2505o(127911);
    }

    /* renamed from: a */
    private void m38095a(C16120o[] c16120oArr, C16120o[] c16120oArr2, int i) {
        AppMethodBeat.m2504i(127912);
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(c16120oArr == null ? 0 : c16120oArr.length);
        C44443c.m80389d(str, objArr);
        if (c16120oArr == null || c16120oArr.length <= 0) {
            AppMethodBeat.m2505o(127912);
            return;
        }
        this.AJU = new int[c16120oArr.length];
        this.AJT = new short[c16120oArr.length];
        this.AJW = new int[c16120oArr2.length];
        this.AJV = new short[c16120oArr2.length];
        this.AJX = i;
        C44443c.m80392w("TalkRoomService", "handleRelayData tcpStartTime: ", Integer.valueOf(this.AJX));
        int i2 = 0;
        for (C16120o c16120o : c16120oArr) {
            this.AJU[i2] = c16120o.Ana;
            this.AJT[i2] = (short) c16120o.port;
            C44443c.m80392w("TalkRoomService", "handleRelayData ip: ", Integer.valueOf(c16120o.Ana), " addr.port: ", Integer.valueOf(c16120o.port));
            i2++;
        }
        i2 = 0;
        for (C16120o c16120o2 : c16120oArr2) {
            this.AJW[i2] = c16120o2.Ana;
            this.AJV[i2] = (short) c16120o2.port;
            C44443c.m80392w("TalkRoomService", "handleRelayData tcpIp: ", Integer.valueOf(c16120o2.Ana), " tcpAddr.port: ", Integer.valueOf(c16120o2.port));
            i2++;
        }
        C44443c.m80389d("TalkRoomService", "handleRelayData", Arrays.toString(this.AJU), Arrays.toString(this.AJT), this.neq, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Arrays.toString(this.AJW), Arrays.toString(this.AJV), Integer.valueOf(this.AJX));
        AppMethodBeat.m2505o(127912);
    }

    /* renamed from: ct */
    public final int mo41161ct(byte[] bArr) {
        C24197p c24197p;
        AppMethodBeat.m2504i(127913);
        try {
            c24197p = (C24197p) C25510e.m40292a(new C24197p(), bArr, bArr.length);
        } catch (Exception e) {
            C36578h.m60647Sq(-1601);
            c24197p = null;
        }
        if (c24197p == null) {
            if (TextUtils.isEmpty(this.neq) && TextUtils.isEmpty(this.AJu)) {
                C36578h.m60651a(this.nCF, this.sZg, "notify", "pasrefail");
            } else {
                this.AJC.mo58376aa("notify", "pasrefail");
            }
            C44443c.m80392w("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            AppMethodBeat.m2505o(127913);
            return -2;
        }
        Object obj;
        C44443c.m80392w("TalkRoomService", "CLTNOT onVoiceGroupChange", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Long.valueOf(c24197p.cvx), Integer.valueOf(c24197p.Anb));
        long j = c24197p.cvx;
        if (this.AJP.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.AJP.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            C44443c.m80389d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error");
            if (m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
                this.AJC.mo58376aa("notify", "repeat", String.valueOf(c24197p.Anb));
            } else {
                C36578h.m60652a(c24197p.groupId, c24197p.sQS, c24197p.sQT, "notify", "repeat", String.valueOf(c24197p.Anb));
            }
            AppMethodBeat.m2505o(127913);
            return -3;
        }
        if (m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
            this.AJC.mo58376aa("notify", "succ", String.valueOf(c24197p.Anb));
        }
        int i;
        int i2;
        C6006g c6006g;
        byte[] bArr2;
        if (c24197p.Anb == 2) {
            m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, true, true);
        } else if (c24197p.Anb == 4) {
            m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, true, true);
            if (!(c24197p.Anf == 0 && c24197p.Ang == 0)) {
                C36575b c36575b = this.AJD;
                int i3 = c24197p.Anf;
                int i4 = c24197p.Ang;
                if (C44437a.Alr && c36575b.AIV != null) {
                    c36575b.AIV.SetAVEncryptType(i3, i4);
                }
            }
        } else if (c24197p.Anb == 16) {
            m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, true, false);
        } else if (c24197p.Anb == 1) {
            C44443c.m80392w("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", c24197p.groupId, " roomId: ", Integer.valueOf(c24197p.sQS), " roomkey: ", Long.valueOf(c24197p.sQT));
            if (C36407a.dPN()) {
                C36407a.dPO();
                if (cIJ() && C40956g.equals(c24197p.groupId, this.neq)) {
                    C44443c.m80392w("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.neq);
                } else {
                    m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, false, true);
                    String str = c24197p.groupId;
                    i = c24197p.sQS;
                    long j2 = c24197p.sQT;
                    int i5 = c24197p.AmC;
                    int i6 = c24197p.Anh;
                    if (TextUtils.isEmpty(str)) {
                        C44443c.m80392w("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                    } else {
                        boolean a = C44438e.dPu().mo70368a(new C31130a(str, i, j2, i5, i6));
                        C44443c.m80389d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", str, Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i6), Boolean.valueOf(a));
                    }
                    C44443c.m80392w("TalkRoomService", "handlerCreateGroupChange start ui");
                }
            } else {
                C44443c.m80392w("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
            }
        } else if (c24197p.Anb == 8) {
            C44443c.m80392w("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", c24197p.groupId, " mGroupId: ", this.neq);
            if (m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
                m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, true, false);
                mo41153a(c24197p.groupId, c24197p.sQS, c24197p.sQT, false, false, true);
            } else {
                m38093a(c24197p.groupId, null, c24197p.AmC, c24197p.sQS, c24197p.sQT, c24197p.And, c24197p.Anc, c24197p.Amz, true, false);
            }
        } else if (c24197p.Anb == 128) {
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = c24197p.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.neq;
            objArr[4] = " groupChg.whisperBuf size: ";
            if (c24197p.Ani == null) {
                i2 = 0;
            } else {
                i2 = c24197p.Ani.length;
            }
            objArr[5] = Integer.valueOf(i2);
            C44443c.m80389d(str2, objArr);
            c6006g = this.AJK;
            C601017 c601017 = new C601017(c24197p.groupId, c24197p.Ani);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c601017.run();
            } else {
                c6006g.handler.post(c601017);
            }
        } else if (c24197p.Anb == 256) {
            if (!m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
                C44443c.m80392w("TalkRoomService", "handleVideoMember is not same room ", c24197p.groupId, Integer.valueOf(c24197p.sQS));
            } else if (c24197p.Ani == null) {
                C44443c.m80392w("TalkRoomService", "handleVideoMember whisperBuf is null", c24197p.groupId, Integer.valueOf(c24197p.sQS));
            } else {
                C24232r c24232r;
                try {
                    bArr2 = c24197p.Ani;
                    c24232r = (C24232r) C25510e.m40292a(new C24232r(), bArr2, bArr2.length);
                } catch (C25509d e2) {
                    C44443c.m80392w("TalkRoomService", "handleVideoMember ", e2);
                    c24232r = null;
                }
                if (c24232r == null || c24232r.Anm == null) {
                    C44443c.m80392w("TalkRoomService", "handleVideoMember notify is null", c24197p.groupId, Integer.valueOf(c24197p.sQS));
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : c24232r.Anm) {
                        if (obj2 != null) {
                            arrayList.add(obj2);
                        }
                    }
                    C44443c.m80389d("TalkRoomService", "handleVideoMember groupid: ", this.neq, " roomId: ", Integer.valueOf(this.nCF), " videoUserNames: ", arrayList);
                    c6006g = this.AJK;
                    C601611 c601611 = new C601611(arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        c601611.run();
                    } else {
                        c6006g.handler.post(c601611);
                    }
                }
            }
        } else if (c24197p.Anb == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (!m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
                C44443c.m80392w("TalkRoomService", "handleOtherDevice is not same room ", c24197p.groupId, Integer.valueOf(c24197p.sQS));
            } else if (!(this.state == 3 || this.state == 4)) {
                mo41154a(c24197p.groupId, c24197p.sQS, c24197p.sQT, 1);
                this.AJK.mo13150k(-1400, null);
            }
        } else if (c24197p.Anb == 512) {
            if (!m38103b(c24197p.groupId, c24197p.sQS, c24197p.sQT, false)) {
                C44443c.m80392w("TalkRoomService", "handleVideoSubscribes is not same room ", c24197p.groupId, Integer.valueOf(c24197p.sQS));
            } else if (c24197p.Ani == null) {
                C44443c.m80392w("TalkRoomService", "handleVideoSubscribes whisperBuf is null", c24197p.groupId, Integer.valueOf(c24197p.sQS));
            } else {
                C24198q c24198q;
                try {
                    bArr2 = c24197p.Ani;
                    c24198q = (C24198q) C25510e.m40292a(new C24198q(), bArr2, bArr2.length);
                } catch (C25509d e22) {
                    C44443c.m80392w("TalkRoomService", "handleVideoSubscribes ", e22);
                    c24198q = null;
                }
                if (c24198q == null) {
                    C44443c.m80392w("TalkRoomService", "handleVideoMember notify is null", c24197p.groupId, Integer.valueOf(c24197p.sQS));
                } else {
                    C6006g c6006g2 = this.AJK;
                    C60131 c60131 = new C60131(c24198q.Anl);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        c60131.run();
                    } else {
                        c6006g2.handler.post(c60131);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(127913);
        return 0;
    }

    /* renamed from: a */
    private void m38091a(String str, int i, long j, boolean z) {
        AppMethodBeat.m2504i(127914);
        mo41153a(str, i, j, z, true, true);
        AppMethodBeat.m2505o(127914);
    }

    /* renamed from: a */
    public final void mo41153a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(127915);
        C44443c.m80392w("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nCF), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.sZg));
        C6001c.dTg().auF(str);
        if (z) {
            m38119l(str, i, j);
        }
        this.AJk.remove(str);
        if (m38103b(str, i, j, false)) {
            C44443c.m80389d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            mo41166ru(true);
            this.AJK.mo13146cq(str, z2);
        }
        if (z3) {
            MultiTalkGroup auL = C6001c.dTg().auL(str);
            if (auL != null) {
                this.AJK.mo13149g(auL);
            }
        }
        AppMethodBeat.m2505o(127915);
    }

    public final boolean cIJ() {
        AppMethodBeat.m2504i(127916);
        C44443c.m80392w("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            AppMethodBeat.m2505o(127916);
            return true;
        }
        AppMethodBeat.m2505o(127916);
        return false;
    }

    public final C6004e auM(String str) {
        AppMethodBeat.m2504i(127917);
        C6004e c6004e = (C6004e) this.AJk.get(str);
        AppMethodBeat.m2505o(127917);
        return c6004e;
    }

    public final boolean auN(String str) {
        AppMethodBeat.m2504i(127918);
        if (((C6004e) this.AJk.get(str)) != null) {
            AppMethodBeat.m2505o(127918);
            return true;
        }
        AppMethodBeat.m2505o(127918);
        return false;
    }

    private void dTt() {
        AppMethodBeat.m2504i(127919);
        C44443c.m80392w("TalkRoomService", "hello timer start~~");
        if (this.AJF != null) {
            C44443c.m80392w("TalkRoomService", "dealWithInit enter talkroom not first time");
            AppMethodBeat.m2505o(127919);
            return;
        }
        try {
            this.AJF = new C245062();
            this.AJH.schedule(this.AJF, 0, (long) AJq);
            AppMethodBeat.m2505o(127919);
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "startNooper: ", e);
            AppMethodBeat.m2505o(127919);
        }
    }

    private void dTu() {
        AppMethodBeat.m2504i(127920);
        try {
            C44443c.m80392w("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.AJG != null) {
                this.AJG.cancel();
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "cancelHelloTimeOutTask: ", e);
        }
        this.AJG = null;
        AppMethodBeat.m2505o(127920);
    }

    private void dTv() {
        AppMethodBeat.m2504i(127921);
        try {
            C44443c.m80392w("TalkRoomService", "cancelHelloTimerTask");
            if (this.AJF != null) {
                this.AJF.cancel();
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "cancelHelloTimerTask: ", e);
        }
        this.AJF = null;
        AppMethodBeat.m2505o(127921);
    }

    private void dTw() {
        AppMethodBeat.m2504i(127922);
        try {
            C44443c.m80392w("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.AJI != null) {
                this.AJI.cancel();
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "cancelTalkDurationTimerTask: ", e);
        }
        this.AJI = null;
        AppMethodBeat.m2505o(127922);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m38085a(int i, C24193av[] c24193avArr, C24227as c24227as, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2, int[] iArr, int i5) {
        Exception e;
        AppMethodBeat.m2504i(127923);
        C44443c.m80389d("TalkRoomService", "dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state));
        if (this.AJD != null) {
            boolean a;
            try {
                a = m38097a(c24193avArr, c24227as, bArr, z, i2, j, i3, i4, bArr2, iArr, i5);
                try {
                    C44443c.m80392w("TalkRoomService", "dealWithInit ret: ", Boolean.valueOf(a));
                } catch (Exception e2) {
                    e = e2;
                    C44443c.m80392w("TalkRoomService", "dealWithInit ", e);
                    if (a) {
                    }
                    if (i > 0) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = false;
            }
            if (a) {
                AppMethodBeat.m2505o(127923);
                return;
            }
        }
        if (i > 0) {
            this.AJC.mo58375Su(202);
            C44443c.m80392w("TalkRoomService", "exitTalkRoom dealWithInit fail");
            mo41155a(str, i2, j, 102, true);
            this.AJK.mo13150k(-400, null);
            AppMethodBeat.m2505o(127923);
            return;
        }
        final int i6 = i;
        final C24193av[] c24193avArr2 = c24193avArr;
        final C24227as c24227as2 = c24227as;
        final byte[] bArr3 = bArr;
        final boolean z2 = z;
        final String str2 = str;
        final int i7 = i2;
        final long j2 = j;
        final int i8 = i3;
        final int i9 = i4;
        final byte[] bArr4 = bArr2;
        final int[] iArr2 = iArr;
        final int i10 = i5;
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127873);
                C24507f.m38087a(C24507f.this, i6 - 1, c24193avArr2, c24227as2, bArr3, z2, str2, i7, j2, i8, i9, bArr4, iArr2, i10);
                AppMethodBeat.m2505o(127873);
            }
        }, 50);
        AppMethodBeat.m2505o(127923);
    }

    /* renamed from: a */
    private boolean m38097a(C24193av[] c24193avArr, C24227as c24227as, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2, int[] iArr, int i4) {
        AppMethodBeat.m2504i(127924);
        if (this.state != 4) {
            C44443c.m80392w("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
            AppMethodBeat.m2505o(127924);
            return false;
        }
        boolean b = m38104b(c24193avArr, c24227as, bArr, z, i, j, i2, i3, bArr2, iArr, i4);
        AppMethodBeat.m2505o(127924);
        return b;
    }

    /* Access modifiers changed, original: final */
    public final boolean cEA() {
        int Lw;
        AppMethodBeat.m2504i(127925);
        C44443c.m80389d("TalkRoomService", "initEngine", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Integer.valueOf(this.state));
        try {
            C36575b c36575b = this.AJD;
            if (C44437a.Alr) {
                String absolutePath = C46729d.sZj.getDir("lib", 0).getAbsolutePath();
                C46731e c46731e = Amd;
                if (c46731e != null) {
                    Lw = c46731e.mo46534Lw();
                } else {
                    Lw = 0;
                }
                C44443c.m80391i("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(C41114k.m71547ju(C46729d.sZj)), " cpuFlag:", Integer.valueOf(Lw), "libPath:", absolutePath);
                if (c36575b.AIV == null) {
                    Lw = -1;
                } else {
                    int i;
                    Lw = c36575b.AIV.init(r6, Lw, absolutePath + "/");
                    absolutePath = "simon:TalkRoomContext";
                    Object[] objArr = new Object[4];
                    objArr[0] = "protocalInit";
                    objArr[1] = Integer.valueOf(Lw);
                    objArr[2] = "field_capInfo length: ";
                    if (c36575b.AIV.field_capInfo == null) {
                        i = 0;
                    } else {
                        i = c36575b.AIV.field_capInfo.length;
                    }
                    objArr[3] = Integer.valueOf(i);
                    C44443c.m80391i(absolutePath, objArr);
                }
            } else {
                Lw = 0;
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "initEngine", e);
            Lw = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (Lw < 0) {
            C36578h.m60650St(-3001);
            this.AJC.mo58375Su(201);
            this.AJD = null;
            C44443c.m80392w("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(Lw));
            AppMethodBeat.m2505o(127925);
            return false;
        }
        AppMethodBeat.m2505o(127925);
        return true;
    }

    /* renamed from: rv */
    public final void mo41167rv(boolean z) {
        AppMethodBeat.m2504i(127926);
        try {
            m38074EB();
            dTs();
            if (z) {
                dTx();
                aDm();
            }
            C44443c.m80392w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
            AppMethodBeat.m2505o(127926);
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
            AppMethodBeat.m2505o(127926);
        }
    }

    private void aDm() {
        AppMethodBeat.m2504i(127927);
        m38074EB();
        int b = C24507f.m38099b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new C245155());
        if (b <= 0) {
            this.AJC.mo58375Su(101);
            C36578h.m60648Sr(-2001);
            this.AJK.mo13150k(-500, null);
        }
        C36578h c36578h;
        if (b > 0) {
            c36578h = this.AJC;
            c36578h.AKR &= -2;
        } else {
            c36578h = this.AJC;
            c36578h.AKR |= 1;
        }
        C44443c.m80392w("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b));
        AppMethodBeat.m2505o(127927);
    }

    private void dTx() {
        AppMethodBeat.m2504i(127928);
        dTs();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        if (C24507f.m38098b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new C30918b() {
            /* renamed from: X */
            public final int mo41178X(byte[] bArr, int i) {
                AppMethodBeat.m2504i(127875);
                if (C24507f.this.AJs) {
                    try {
                        int i2;
                        C36575b c = C24507f.this.AJD;
                        short s = (short) i;
                        AtomicInteger atomicInteger = atomicInteger;
                        AtomicInteger atomicInteger2 = atomicInteger2;
                        if (!C44437a.Alr || c.AIV == null) {
                            i2 = 1;
                        } else {
                            i2 = c.AIV.GetAudioData(bArr, s, atomicInteger, atomicInteger2);
                        }
                        if (C24507f.this.AJS && i2 >= 0) {
                            C24507f.this.AJS = false;
                            C44443c.m80392w("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(i2));
                        }
                        AppMethodBeat.m2505o(127875);
                        return i2;
                    } catch (Exception e) {
                        C44443c.m80392w("TalkRoomService", "initMediaComponent play", e);
                        AppMethodBeat.m2505o(127875);
                        return -1;
                    }
                }
                AppMethodBeat.m2505o(127875);
                return 0;
            }
        }) <= 0) {
            this.AJC.mo58375Su(101);
            C36578h.m60648Sr(-2001);
            C36578h c36578h = this.AJC;
            c36578h.AKR |= 1;
            this.AJK.mo13150k(-500, null);
        }
        C44443c.m80392w("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(r0));
        AppMethodBeat.m2505o(127928);
    }

    private void dTy() {
        AppMethodBeat.m2504i(127929);
        if (this.AJI != null) {
            C44443c.m80392w("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
            AppMethodBeat.m2505o(127929);
            return;
        }
        C44443c.m80392w("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.AJi, " mIsHoldOn: ", Boolean.valueOf(this.AJY));
        this.AJI = new C245137();
        this.AJJ.scheduleAtFixedRate(this.AJI, 1000, 1000);
        AppMethodBeat.m2505o(127929);
    }

    /* renamed from: b */
    private boolean m38104b(C24193av[] c24193avArr, C24227as c24227as, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2, int[] iArr, int i4) {
        int[] iArr2;
        int i5;
        int i6;
        AppMethodBeat.m2504i(127930);
        C44443c.m80389d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.neq, " ip: ", Arrays.toString(this.AJU), " ports: ", Arrays.toString(this.AJT), " tcpIp: ", Arrays.toString(this.AJW), " tcpPorts: ", Arrays.toString(this.AJV), " tcpStartTime: ", Integer.valueOf(this.AJX), " audio_encrypt_type: ", Integer.valueOf(i2), " video_encrypt_type: ", Integer.valueOf(i4));
        String dPM = C36407a.dPM();
        int i7 = -1;
        if (c24193avArr == null || c24193avArr.length <= 0) {
            iArr2 = null;
            i5 = -1;
        } else {
            int[] iArr3 = new int[c24193avArr.length];
            for (i6 = 0; i6 < c24193avArr.length; i6++) {
                iArr3[i6] = c24193avArr[i6].kyZ;
                if (C40956g.equals(c24193avArr[i6].Aop, dPM)) {
                    i7 = c24193avArr[i6].kyZ;
                }
            }
            iArr2 = iArr3;
            i5 = i7;
        }
        int auG = C6001c.dTg().auG(this.neq);
        this.AJC.kyZ = i5;
        try {
            int i8;
            C36575b c36575b = this.AJD;
            C28534a c28534a = this.AJE;
            TalkRoom auE = C6001c.dTg().auE(this.neq);
            if (auE == null) {
                C44443c.m80392w("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", r3);
                i8 = 0;
            } else {
                C6003d auD = auE.auD(C36407a.dPM());
                if (auD == null) {
                    C44443c.m80392w("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", r3);
                    i8 = 0;
                } else {
                    C24193av c24193av = auD.AJb;
                    if (c24193av == null) {
                        C44443c.m80392w("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", r3);
                        i8 = 0;
                    } else {
                        C44443c.m80389d("TalkRoomManager", "getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(c24193av.vzt));
                        i8 = c24193av.vzt;
                    }
                }
            }
            int[] iArr4 = this.AJU;
            short[] sArr = this.AJT;
            int[] iArr5 = this.AJW;
            short[] sArr2 = this.AJV;
            int i9 = this.AJX;
            C44443c.m80391i("simon:TalkRoomContext", "Open");
            C41113i c41113i = null;
            if (c24227as != null) {
                c41113i = new C41113i(c24227as.AoA, c24227as.fAa, c24227as.fAb, c24227as.AoB, c24227as.AoC, c24227as.AoD, c24227as.AoE, c24227as.AoF, c24227as.AoG, c24227as.AoH, c24227as.AoI, c24227as.AoJ);
            } else {
                C44443c.m80392w("simon:TalkRoomContext", "voiceConf is null");
            }
            int ju = C41114k.m71547ju(C46729d.sZj);
            if (c36575b.AIV == null) {
                i6 = -1;
            } else {
                i6 = c36575b.AIV.Open(c28534a, c41113i, i8, i5, i, j, iArr4, sArr, 0, iArr2, bArr, z, ju, iArr5, sArr2, i9, i2, i3, bArr2, iArr, i4);
            }
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", "connectToCompenent", th);
            i6 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        C6006g c6006g = this.AJK;
        C60222 c60222 = new C60222(i6);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c60222.run();
        } else {
            c6006g.handler.post(c60222);
        }
        C44443c.m80389d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(auG));
        if (i6 < 0) {
            C36578h.m60650St(-3002);
        }
        if (i6 == 0) {
            this.AJC.tdi = 1;
        }
        if (i6 == 0) {
            AppMethodBeat.m2505o(127930);
            return true;
        }
        AppMethodBeat.m2505o(127930);
        return false;
    }

    /* renamed from: b */
    private boolean m38103b(String str, int i, long j, boolean z) {
        AppMethodBeat.m2504i(127931);
        if (z) {
            boolean iA = C40956g.m71019iA(str, this.neq);
            AppMethodBeat.m2505o(127931);
            return iA;
        }
        C44443c.m80392w("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.neq, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nCF), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.sZg));
        if (C40956g.m71019iA(str, this.neq) && i == this.nCF && j == this.sZg) {
            AppMethodBeat.m2505o(127931);
            return true;
        }
        AppMethodBeat.m2505o(127931);
        return false;
    }

    /* renamed from: l */
    private void m38119l(String str, int i, long j) {
        AppMethodBeat.m2504i(127932);
        try {
            String k = C6001c.dTg().mo13133k(str, i, j);
            C44443c.m80392w("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.sRm), " mTalkDuration: ", Integer.valueOf(this.AJv), " msgKey: ", k);
            AppMethodBeat.m2505o(127932);
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", "handleRoomExit: ", th);
            AppMethodBeat.m2505o(127932);
        }
    }

    /* renamed from: az */
    public final boolean mo41158az(String str, int i, int i2) {
        AppMethodBeat.m2504i(127933);
        C44443c.m80392w("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(127933);
            return false;
        }
        if (i == 1 || i2 == 100) {
            this.AJC.dTD();
        }
        int i3 = this.nCF;
        long j = this.sZg;
        int i4 = C41112a.dSR().state;
        boolean eT;
        if (C46825j.auS(str)) {
            this.AJC.mo58375Su(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            eT = C41112a.dSR().m38111eT(str, 1000);
            AppMethodBeat.m2505o(127933);
            return eT;
        } else if (i4 == 2) {
            eT = C41112a.dSR().mo41154a(str, i3, j, i);
            AppMethodBeat.m2505o(127933);
            return eT;
        } else {
            C16121b.m24451H(Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108)).contains(Integer.valueOf(i2));
            eT = C41112a.dSR().mo41155a(str, i3, j, i2, true);
            AppMethodBeat.m2505o(127933);
            return eT;
        }
    }

    private void dTz() {
        AppMethodBeat.m2504i(127934);
        this.mHandler.removeCallbacks(this.AKc);
        this.AKb = null;
        AppMethodBeat.m2505o(127934);
    }

    /* renamed from: c */
    private void m38108c(C24239d c24239d) {
        AppMethodBeat.m2504i(127935);
        this.mHandler.removeCallbacks(this.AKc);
        this.AKb = c24239d;
        this.mHandler.postDelayed(this.AKc, 3000);
        AppMethodBeat.m2505o(127935);
    }

    /* renamed from: eR */
    public final void mo41164eR(String str, int i) {
        AppMethodBeat.m2504i(127936);
        if (C40956g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) && cIJ() && (this.nME || this.AJs)) {
            switch (i) {
                case 21:
                    switch (C41114k.m71547ju(C46729d.sZj)) {
                        case 4:
                            this.AJM = true;
                            break;
                        default:
                            this.AJM = false;
                            break;
                    }
                    if (this.nCF == 0 || this.sZg == 0) {
                        C44443c.m80392w("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        AppMethodBeat.m2505o(127936);
                        return;
                    }
                    C44443c.m80392w("TalkRoomService", "sendRedirect", this.neq, Integer.valueOf(this.nCF));
                    this.AJC.dTE();
                    boolean a = C44438e.dPu().mo70368a(new C46824h(this.neq, this.nCF, this.sZg, C6001c.dTg().auG(this.neq)));
                    this.AJC.mo58376aa("redirect", "req", String.valueOf(a), String.valueOf(this.state));
                    C44443c.m80392w("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a));
                    AppMethodBeat.m2505o(127936);
                    return;
                case 33:
                    C36575b c36575b = this.AJD;
                    int ju = C41114k.m71547ju(C46729d.sZj);
                    if (C44437a.Alr && c36575b.AIV != null) {
                        c36575b.AIV.onNetworkChange(ju);
                        break;
                    } else {
                        AppMethodBeat.m2505o(127936);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(127936);
    }

    /* renamed from: So */
    private static boolean m38078So(int i) {
        return i != 1;
    }

    /* renamed from: a */
    private void m38090a(String str, int i, long j, String str2, String str3) {
        this.nCF = i;
        this.sZg = j;
        this.neq = str2;
        this.AJu = str;
        this.AJt = str3;
    }

    /* renamed from: La */
    private static void m38077La() {
        AppMethodBeat.m2504i(127937);
        try {
            ((AudioManager) C46729d.sZj.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
            C44443c.m80392w("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
            AppMethodBeat.m2505o(127937);
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomService", "resumeAudioConfig ", th);
            AppMethodBeat.m2505o(127937);
        }
    }

    /* renamed from: KU */
    public static boolean m38075KU() {
        boolean isSpeakerphoneOn;
        AppMethodBeat.m2504i(127938);
        try {
            isSpeakerphoneOn = ((AudioManager) C46729d.sZj.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "isSpeakerOn ", e);
            isSpeakerphoneOn = false;
        }
        C44443c.m80389d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn));
        AppMethodBeat.m2505o(127938);
        return isSpeakerphoneOn;
    }

    /* renamed from: a */
    public static void m38086a(C46731e c46731e) {
        Amd = c46731e;
    }

    public static C46731e dTA() {
        return Amd;
    }

    private boolean dTs() {
        boolean bRl;
        AppMethodBeat.m2504i(127897);
        try {
            C46731e c46731e = Amd;
            if (c46731e != null) {
                this.AJC.sUz = c46731e.bRn();
                this.AJC.sUp = c46731e.bRq();
                bRl = c46731e.bRl();
                C44443c.m80389d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bRl));
                AppMethodBeat.m2505o(127897);
                return bRl;
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "stopPlayer: ", e);
        }
        bRl = false;
        C44443c.m80389d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bRl));
        AppMethodBeat.m2505o(127897);
        return bRl;
    }

    /* renamed from: EB */
    private boolean m38074EB() {
        boolean bRm;
        AppMethodBeat.m2504i(127899);
        try {
            C46731e c46731e = Amd;
            if (c46731e != null) {
                this.AJC.sUs = c46731e.bRo();
                this.AJC.sUo = c46731e.bRp();
                bRm = c46731e.bRm();
                C44443c.m80389d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bRm));
                AppMethodBeat.m2505o(127899);
                return bRm;
            }
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomService", "stopRecord: ", e);
        }
        bRm = false;
        C44443c.m80389d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bRm));
        AppMethodBeat.m2505o(127899);
        return bRm;
    }

    /* renamed from: e */
    static /* synthetic */ void m38110e(C24507f c24507f) {
        AppMethodBeat.m2504i(127940);
        if (c24507f.AJD == null) {
            C44443c.m80390e("TalkRoomService", "the engine should not be null.");
            AppMethodBeat.m2505o(127940);
            return;
        }
        C44443c.m80389d("TalkRoomService", "initMediaComponent");
        C46730f.m88557C(411, 1, "1");
        c24507f.dTx();
        c24507f.aDm();
        AppMethodBeat.m2505o(127940);
    }

    /* renamed from: j */
    static /* synthetic */ C31134m m38117j(C24507f c24507f) {
        AppMethodBeat.m2504i(127941);
        if (TextUtils.isEmpty(c24507f.neq)) {
            C44443c.m80392w("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            AppMethodBeat.m2505o(127941);
            return null;
        }
        C44443c.m80392w("TalkRoomService", "doHelloVoiceRoom mGroupId: ", c24507f.neq, " mRoomId: ", Integer.valueOf(c24507f.nCF), " mRoomKey: ", Long.valueOf(c24507f.sZg), " selfMemberId: ", Integer.valueOf(C6001c.dTg().auG(c24507f.neq)), " mCallData: ", Integer.valueOf(c24507f.AJA));
        C24239d c31134m = new C31134m(c24507f.neq, c24507f.nCF, c24507f.sZg, r6, c24507f.AJA);
        C44438e.dPu().mo70368a(c31134m);
        AppMethodBeat.m2505o(127941);
        return c31134m;
    }
}
