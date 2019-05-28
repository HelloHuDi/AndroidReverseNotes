package com.tencent.wecall.talkroom.model;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.au;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.p;
import com.tencent.pb.common.b.a.a.q;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wecall.talkroom.a.i;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.model.g.AnonymousClass11;
import com.tencent.wecall.talkroom.model.g.AnonymousClass15;
import com.tencent.wecall.talkroom.model.g.AnonymousClass16;
import com.tencent.wecall.talkroom.model.g.AnonymousClass17;
import com.tencent.wecall.talkroom.model.g.AnonymousClass18;
import com.tencent.wecall.talkroom.model.g.AnonymousClass20;
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

public final class f implements Callback, com.tencent.g.a.d, com.tencent.pb.common.b.b {
    public static String[] AJN = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    public static List<Integer> AJj = new ArrayList();
    private static int AJq = 30000;
    private static com.tencent.pb.talkroom.sdk.e Amd = null;
    private com.tencent.g.a.a AHP;
    private int AJA = 0;
    int AJB = -1;
    public h AJC = h.AKQ;
    b AJD;
    private com.tencent.mm.plugin.multi.talk.a AJE;
    private TimerTask AJF;
    private TimerTask AJG;
    private Timer AJH = new Timer("TalkRoomService_HelloTimer");
    private TimerTask AJI;
    private Timer AJJ = new Timer("TalkRoomService_talkDurationTimer");
    g AJK = new g();
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
    f AJi;
    private Map<String, e> AJk = new HashMap();
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
    private Runnable AKa = new Runnable() {
        public final void run() {
            AppMethodBeat.i(127877);
            if (f.this.cIJ() && f.this.nME) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                h.Sr(-2003);
                f.this.AJC.Su(401);
                f.this.az(f.this.neq, 3, 108);
            }
            AppMethodBeat.o(127877);
        }
    };
    private com.tencent.pb.common.b.d AKb = null;
    private Runnable AKc = new Runnable() {
        public final void run() {
            com.tencent.pb.common.b.d dVar = null;
            AppMethodBeat.i(127878);
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(f.this.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = f.this.AKb == null ? null : Integer.valueOf(f.this.AKb.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(f.this.AJr);
            com.tencent.pb.common.c.c.d(str, objArr);
            if (f.this.AKb == null) {
                f.this.mHandler.removeCallbacks(f.this.AKc);
                com.tencent.pb.common.c.c.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(127878);
            } else if (f.this.cIJ()) {
                if (f.this.AKb != null && f.this.AKb.getType() == 202 && f.this.state == 3) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) f.this.AKb;
                    if (f.a(f.this, eVar.neq, eVar.nCF, eVar.sZg, f.Sp(eVar.ALs))) {
                        dVar = new com.tencent.wecall.talkroom.a.e(eVar);
                        com.tencent.pb.common.c.c.w("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (dVar != null) {
                    com.tencent.pb.common.b.e.dPu().a(dVar);
                    AppMethodBeat.o(127878);
                    return;
                }
                f.this.mHandler.removeCallbacks(f.this.AKc);
                com.tencent.pb.common.c.c.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(127878);
            } else {
                f.this.mHandler.removeCallbacks(f.this.AKc);
                com.tencent.pb.common.c.c.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(127878);
            }
        }
    };
    int AlR;
    Handler mHandler;
    boolean mIsMute = false;
    public int nCF;
    boolean nME = false;
    public String neq;
    boolean sRm = false;
    public long sZg;
    int state = 0;

    class e {
        String groupId;
        int nwu;
        long nwv;

        e() {
        }
    }

    public interface f {
    }

    class d {
        int nCF;
        String neq;
        long sZg;
    }

    public enum b {
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
            AppMethodBeat.o(127881);
        }
    }

    class a {
        String[] AKr;
        ay AKs;
        long AKt;
        String AKu;
        boolean AKv;
        String AKw;
        int AmC;
        String groupId;
        int type;

        a() {
        }
    }

    class c {
        String AKI;
        int AmC;
        int AmJ;
        String groupId;
        int nwu;
        long nwv;

        c() {
        }
    }

    static /* synthetic */ boolean Sp(int i) {
        AppMethodBeat.i(127946);
        boolean So = So(i);
        AppMethodBeat.o(127946);
        return So;
    }

    static /* synthetic */ void a(f fVar, int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2, int[] iArr, int i5) {
        AppMethodBeat.i(127945);
        fVar.a(i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2, iArr, i5);
        AppMethodBeat.o(127945);
    }

    static /* synthetic */ void k(f fVar) {
        AppMethodBeat.i(127942);
        fVar.dTv();
        AppMethodBeat.o(127942);
    }

    static {
        AppMethodBeat.i(127947);
        AppMethodBeat.o(127947);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(127882);
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.neq != null) {
                        com.tencent.pb.common.c.c.d("TalkRoomService", "handlerInviteTimeOut");
                        if (dVar.neq.equals(this.neq) && dVar.nCF == this.nCF && dVar.sZg == this.sZg) {
                            h.dTG();
                            this.AJC.Su(501);
                            a(dVar.neq, dVar.nCF, dVar.sZg, 7);
                            com.tencent.pb.common.c.c.w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.neq);
                            break;
                        }
                    }
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                    break;
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    a aVar = (a) obj;
                    if (g.iA(aVar.groupId, this.neq)) {
                        String str = aVar.groupId;
                        String[] strArr = aVar.AKr;
                        ay ayVar = aVar.AKs;
                        int i = aVar.AmC;
                        int i2 = aVar.type;
                        long j = aVar.AKt;
                        String str2 = aVar.AKu;
                        boolean z = aVar.AKv;
                        String str3 = aVar.AKw;
                        this.AJC.dTE();
                        String str4 = "";
                        TalkRoom auE = c.dTg().auE(str);
                        if (auE != null) {
                            String str5;
                            if (auE.AIT == null) {
                                str5 = "";
                            } else {
                                str5 = auE.AIT.name;
                            }
                            str4 = str5;
                        }
                        boolean a = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.AJD.dTd(), str4, ayVar, i, i2, j, str2, z, str3));
                        this.AJC.aa("create", "req", String.valueOf(a), String.valueOf(this.state));
                        com.tencent.pb.common.c.c.w("TalkRoomService", "sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a));
                        break;
                    }
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.groupId, cVar.nwu, cVar.nwv, false)) {
                        b(cVar.groupId, cVar.nwu, cVar.nwv, cVar.AmC, cVar.AmJ, cVar.AKI);
                        break;
                    }
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 4:
                com.tencent.pb.common.c.f.dPL();
                break;
        }
        AppMethodBeat.o(127882);
        return true;
    }

    public f() {
        AppMethodBeat.i(127883);
        com.tencent.pb.common.b.e.dPu().a(201, this);
        com.tencent.pb.common.b.e.dPu().a(202, this);
        com.tencent.pb.common.b.e.dPu().a(203, this);
        com.tencent.pb.common.b.e.dPu().a(204, this);
        com.tencent.pb.common.b.e.dPu().a(205, this);
        com.tencent.pb.common.b.e.dPu().a(206, this);
        com.tencent.pb.common.b.e.dPu().a(207, this);
        com.tencent.pb.common.b.e.dPu().a(208, this);
        com.tencent.pb.common.b.e.dPu().a(210, this);
        com.tencent.pb.common.b.e.dPu().a(209, this);
        com.tencent.pb.common.b.e.dPu().a(211, this);
        com.tencent.pb.common.b.e.dPu().a(212, this);
        com.tencent.pb.common.b.e.dPu().a(213, this);
        com.tencent.pb.common.b.e.dPu().a(214, this);
        com.tencent.pb.common.b.e.dPu().a(800, this);
        c dTg = c.dTg();
        g gVar = this.AJK;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.d("TalkRoomManager", "setTalkServerCallback caller stack: ", r2);
        }
        dTg.AJa = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.AHP == null) {
            this.AHP = (com.tencent.g.a.a) com.tencent.g.f.aux("EventCenter");
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "register", Boolean.TRUE);
        this.AHP.a(this, AJN);
        AppMethodBeat.o(127883);
    }

    /* Access modifiers changed, original: final */
    public final boolean dTp() {
        AppMethodBeat.i(127884);
        com.tencent.pb.common.c.c.d("TalkRoomService", "initService");
        com.tencent.pb.talkroom.sdk.e eVar = Amd;
        if (eVar != null) {
            eVar.bRj();
        }
        this.AJD = new b();
        this.AJO = this.neq;
        this.AJE = new com.tencent.mm.plugin.multi.talk.a() {
            public final void keep_OnOpenSuccess() {
                int[] iArr = null;
                AppMethodBeat.i(127865);
                f.this.AJC.nxL = 1;
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine OnOpenSuccess");
                if (f.this.state != 4) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(f.this.state));
                    AppMethodBeat.o(127865);
                    return;
                }
                try {
                    f fVar = f.this;
                    c dTg = c.dTg();
                    String b = f.this.neq;
                    if (!TextUtils.isEmpty(b)) {
                        TalkRoom auE = dTg.auE(b);
                        if (auE != null) {
                            List dSX = auE.dSX();
                            if (dSX != null) {
                                int[] iArr2 = new int[dSX.size()];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i = 0; i < dSX.size(); i++) {
                                    d dVar = (d) dSX.get(i);
                                    if (dVar != null) {
                                        iArr2[i] = dVar.dTj();
                                        stringBuffer.append(iArr2[i]);
                                        stringBuffer.append(",");
                                    }
                                }
                                com.tencent.pb.common.c.c.w("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                                iArr = iArr2;
                            }
                        }
                    }
                    f.a(fVar, iArr);
                    if (f.this.AJD != null) {
                        b c = f.this.AJD;
                        boolean KU = f.KU();
                        if (com.tencent.pb.common.a.a.Alr && c.AIV != null) {
                            if (KU) {
                                c.AIV.setAppCmd(401);
                            } else {
                                c.AIV.setAppCmd(402);
                            }
                        }
                    }
                    f.this.AJs = true;
                    f.this.AJD;
                    com.tencent.pb.talkroom.sdk.e dTA = f.dTA();
                    if (dTA != null) {
                        dTA.bRk();
                    }
                    talk talk = f.this.AJD.AIV;
                    if (com.tencent.pb.common.a.a.Alr) {
                        AtomicInteger atomicInteger = new AtomicInteger();
                        AtomicInteger atomicInteger2 = new AtomicInteger();
                        talk.getSampleRate(atomicInteger, atomicInteger2);
                        int i2 = atomicInteger.get();
                        int i3 = atomicInteger2.get();
                        talk.VOICE_SAMPLERATE = i2;
                        talk.VOICE_FRAME_DURATION = i3;
                        com.tencent.pb.common.c.c.w("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.VOICE_SAMPLERATE), Integer.valueOf(talk.VOICE_FRAME_DURATION));
                    }
                } catch (Throwable th) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "keep_OnOpenSuccess:  ", th);
                    AppMethodBeat.o(127865);
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127864);
                        try {
                            com.tencent.pb.common.c.c.i("TalkRoomService", "initMediaComponent");
                            f.e(f.this);
                            AppMethodBeat.o(127864);
                        } catch (Throwable th) {
                            com.tencent.pb.common.c.c.w("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th);
                            AppMethodBeat.o(127864);
                        }
                    }
                });
                h hVar = f.this.AJC;
                if (hVar.ALf == 0) {
                    hVar.AKU = 0;
                } else {
                    hVar.AKU = System.currentTimeMillis() - hVar.ALf;
                }
                com.tencent.pb.common.c.c.d(h.TAG, "endFirstSendPcm", Long.valueOf(hVar.AKU), Long.valueOf(hVar.ALf));
                g f = f.this.AJK;
                com.tencent.wecall.talkroom.model.g.AnonymousClass3 anonymousClass3 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127950);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a akC : g.this.callbacks) {
                                    akC.akC();
                                }
                            } finally {
                                AppMethodBeat.o(127950);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass3.run();
                    AppMethodBeat.o(127865);
                    return;
                }
                f.handler.post(anonymousClass3);
                AppMethodBeat.o(127865);
            }

            public final void keep_OnError(int i) {
                int i2 = -401;
                AppMethodBeat.i(127866);
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
                h.St(i4);
                f.this.AJC.Su(i3);
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i));
                f.this.a(f.this.neq, f.this.nCF, f.this.sZg, i5, true);
                f.this.AJK.k(i2, null);
                AppMethodBeat.o(127866);
            }

            public final void keep_OnNotify(int i) {
                AppMethodBeat.i(127867);
                com.tencent.pb.common.c.c.w("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i));
                if (i == 5) {
                    f.this.AJC.AKS = 1;
                    h hVar = f.this.AJC;
                    if (hVar.ALf == 0) {
                        hVar.AKT = 0;
                    } else {
                        hVar.AKT = System.currentTimeMillis() - hVar.ALf;
                    }
                    com.tencent.pb.common.c.c.d(h.TAG, "endRecvFirstPcm", Long.valueOf(hVar.ALf), Long.valueOf(hVar.AKT));
                    f.this.AJA = 1;
                    f.j(f.this);
                }
                AppMethodBeat.o(127867);
            }

            public final void keep_OnReportEngineRecv(String str, int i) {
                AppMethodBeat.i(127868);
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i), str);
                StringBuilder stringBuilder = new StringBuilder(g.atI(f.this.AJO));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.auP(stringBuilder.toString());
                AppMethodBeat.o(127868);
            }

            public final void keep_OnReportEngineSend(String str) {
                AppMethodBeat.i(127869);
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineSend:", str);
                StringBuilder stringBuilder = new StringBuilder(g.atI(f.this.AJO));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.auQ(stringBuilder.toString());
                AppMethodBeat.o(127869);
            }

            public final void keep_OnReportChannel(String str) {
                AppMethodBeat.i(127870);
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportChannel:", str);
                StringBuilder stringBuilder = new StringBuilder(g.atI(f.this.AJO));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.auR(stringBuilder.toString());
                AppMethodBeat.o(127870);
            }
        };
        AppMethodBeat.o(127884);
        return true;
    }

    public final void ru(boolean z) {
        AppMethodBeat.i(127885);
        this.AJC.groupId = this.neq;
        this.AJC.Amx = this.AJu;
        if (g.isEmpty(this.AJC.groupId)) {
            this.AJC.groupId = "";
        }
        if (g.isEmpty(this.AJC.Amx)) {
            this.AJC.Amx = "";
        }
        this.AJC.sUl = 1;
        this.AJC.nwu = this.nCF;
        this.AJC.nwv = this.sZg;
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        cEx();
        Km();
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.AJD != null) {
            try {
                this.AJL = this.AJD.dTf();
                i = this.AJD.Close();
            } catch (Throwable th) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "uninitService", th);
            }
            com.tencent.pb.common.c.c.w("TalkRoomService", "uninitService mid", Integer.valueOf(i));
        }
        if (this.AJD != null) {
            try {
                i = this.AJD.uninitLive();
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "uninitService 2", e);
            }
        }
        this.AJD = null;
        com.tencent.pb.common.c.c.w("TalkRoomService", "steve:uninitService set engine null!");
        if (z) {
            String dTB = this.AJC.dTB();
            if (!(TextUtils.isEmpty(this.AJC.groupId) && TextUtils.isEmpty(this.AJC.Amx))) {
                h.auO(dTB);
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessageDelayed(4, 0);
            }
            this.AJC.reset();
            La();
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService end error", Integer.valueOf(i));
        AppMethodBeat.o(127885);
    }

    public final void dTq() {
        AppMethodBeat.i(127886);
        try {
            com.tencent.pb.common.c.c.w("TalkRoomService", "stopHoldeOnPusher ");
            if (this.AKa != null) {
                this.mHandler.removeCallbacks(this.AKa);
            }
            AppMethodBeat.o(127886);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", " stopTimer: ", th);
            AppMethodBeat.o(127886);
        }
    }

    private void Km() {
        AppMethodBeat.i(127887);
        this.AJk.remove(this.neq);
        this.AJL = 0;
        this.mIsMute = false;
        setState(0);
        this.AJs = false;
        a(this.AJu, 0, 0, null, null);
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
        AppMethodBeat.o(127887);
    }

    /* Access modifiers changed, original: final */
    public final void setState(int i) {
        AppMethodBeat.i(127888);
        com.tencent.pb.common.c.c.w("TalkRoomService", "setState newState: ", Integer.valueOf(i));
        if (this.state == i) {
            AppMethodBeat.o(127888);
            return;
        }
        this.state = i;
        this.AJK.onStateChanged(i);
        AppMethodBeat.o(127888);
    }

    static String[] fG(List<String> list) {
        AppMethodBeat.i(127889);
        if (list == null || list.size() <= 0) {
            String[] strArr = new String[0];
            AppMethodBeat.o(127889);
            return strArr;
        }
        String[] strArr2 = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr2[i] = str;
            i = i2;
        }
        AppMethodBeat.o(127889);
        return strArr2;
    }

    public final b a(String str, int i, long j, int i2, int i3, String str2) {
        AppMethodBeat.i(127890);
        com.tencent.pb.common.c.c.w("TalkRoomService", "enterTalkRoom", str, str2, Integer.valueOf(this.nCF), Integer.valueOf(i), Long.valueOf(this.sZg), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.FALSE);
        b bVar;
        if (com.tencent.pb.a.a.a.dPN()) {
            h.isNetworkConnected();
            if (So(i3) && i3 != 100 && cIJ()) {
                h.a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "isBusy");
                com.tencent.pb.common.c.c.w("TalkRoomService", "enterTalkRoom isBusy");
                bVar = b.BUSY;
                AppMethodBeat.o(127890);
                return bVar;
            } else if (!bW(i3, str)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state));
                h.a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "isNotValidEnterState");
                bVar = b.NOT_VALID_STATE;
                AppMethodBeat.o(127890);
                return bVar;
            } else if (TextUtils.isEmpty(str)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
                h.a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "groupIdnull");
                bVar = b.GROUP_NOT_VALID;
                AppMethodBeat.o(127890);
                return bVar;
            } else {
                if (So(i3)) {
                    this.AJC.reset();
                    ru(false);
                }
                dTp();
                if (cEA()) {
                    this.neq = str;
                    if (So(i3)) {
                        this.nCF = i;
                        this.sZg = j;
                    } else {
                        e auM = auM(str);
                        this.nCF = auM == null ? 0 : auM.nwu;
                        this.sZg = auM == null ? 0 : auM.nwv;
                    }
                    this.AJO = str;
                    this.AlR = i2;
                    setState(3);
                    this.sRm = So(i3);
                    if (this.sRm) {
                        this.AJC.dTC();
                    }
                    if (!this.sRm || c.dTg().cp(this.neq, true)) {
                        b(str, this.nCF, this.sZg, i2, i3, str2);
                    } else {
                        c cVar = new c();
                        cVar.groupId = str;
                        cVar.nwu = i;
                        cVar.nwv = j;
                        cVar.AmJ = i3;
                        cVar.AmC = i2;
                        cVar.AKI = str2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    bVar = b.OK;
                    AppMethodBeat.o(127890);
                    return bVar;
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (So(i3)) {
                    h.a(str, "", this.nCF, this.sZg, "enter", "req", "false", "initEnginefail");
                    ru(false);
                } else {
                    this.AJC.aa("enter", "req", "false", "initEnginefail");
                }
                bVar = b.INIT_ENGINE_FAILED;
                AppMethodBeat.o(127890);
                return bVar;
            }
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.dPN()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.dPO()));
        h.a(str, "", this.nCF, this.sZg, "enter", "req", "false", String.valueOf(i3), "noAuth");
        bVar = b.NOT_AUTH;
        AppMethodBeat.o(127890);
        return bVar;
    }

    private void b(String str, int i, long j, int i2, int i3, String str2) {
        AppMethodBeat.i(127891);
        com.tencent.pb.common.c.c.w("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.TRUE, " wXgroupId: ", str2);
        if (i == 0 || j == 0) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "roomId or roomkey is 0..return.");
            AppMethodBeat.o(127891);
            return;
        }
        if (!So(i3)) {
            this.AJC.dTF();
        }
        this.AJC.dTE();
        com.tencent.pb.common.b.d eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.AJD.dTd(), i2, i3, str2);
        com.tencent.pb.common.b.e.dPu().a(eVar);
        c(eVar);
        AppMethodBeat.o(127891);
    }

    private boolean bW(int i, String str) {
        AppMethodBeat.i(127892);
        if (i == 100) {
            AppMethodBeat.o(127892);
            return true;
        } else if (So(i)) {
            if (this.state == 0) {
                AppMethodBeat.o(127892);
                return true;
            }
            AppMethodBeat.o(127892);
            return false;
        } else if (i == 1) {
            boolean auN = auN(str);
            AppMethodBeat.o(127892);
            return auN;
        } else {
            AppMethodBeat.o(127892);
            return false;
        }
    }

    public final boolean a(String str, int i, long j, int i2) {
        AppMethodBeat.i(127893);
        com.tencent.pb.common.c.c.w("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(127893);
            return false;
        }
        if (3 == (1 == i2 ? 1 : 3) && i2 != 7) {
            dTr();
        }
        boolean a = com.tencent.pb.common.b.e.dPu().a(new i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.AJC.aa("reject", "req", String.valueOf(a), String.valueOf(this.state));
        } else {
            h.a(str, i, j, "reject", "req", String.valueOf(a), String.valueOf(this.state));
        }
        a(str, i, j, false);
        com.tencent.pb.common.c.c.w("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.o(127893);
        return a;
    }

    private int dTr() {
        AppMethodBeat.i(127894);
        if (this.AJy == 0) {
            AppMethodBeat.o(127894);
            return 0;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.AJy) / 1000);
        AppMethodBeat.o(127894);
        return currentTimeMillis;
    }

    private boolean eT(String str, int i) {
        AppMethodBeat.i(127895);
        com.tencent.pb.common.c.c.w("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(127895);
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.c(str, i, this.AlR));
        this.AJC.aa("cancel", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, this.nCF, this.sZg, true);
        com.tencent.pb.common.c.c.w("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.o(127895);
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        AppMethodBeat.i(127896);
        com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "exitTalkRoom: has exited");
            AppMethodBeat.o(127896);
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.AJC.aa("exit", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, i, j, z);
        com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a));
        AppMethodBeat.o(127896);
        return a;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        AppMethodBeat.i(127898);
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = Amd;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.o(127898);
        return i3;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        AppMethodBeat.i(127900);
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = Amd;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "startRecord: ", e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.o(127900);
        return i3;
    }

    private void cEx() {
        AppMethodBeat.i(127901);
        com.tencent.pb.common.c.c.d("TalkRoomService", "releaseConpent");
        try {
            EB();
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "releaseConpent ", th);
        }
        try {
            dTs();
            AppMethodBeat.o(127901);
        } catch (Throwable th2) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "releaseConpent ", th2);
            AppMethodBeat.o(127901);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map I;
        AppMethodBeat.i(127902);
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        com.tencent.pb.common.c.c.d(str2, objArr);
        if (i == 1 || i == 2) {
            I = com.tencent.pb.common.c.b.I(Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(VError.ERROR_STICKER_OUTPUT_TEXTURE_ERROR), Integer.valueOf(204), Integer.valueOf(TXLiveConstants.PUSH_ERR_AUDIO_ENCODE_FAIL), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542));
            int type = dVar.getType();
            if (I.containsKey(Integer.valueOf(type))) {
                h.Sq(((Integer) I.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == 201) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (g.iA(this.AJu, dVar2.AJu)) {
                        this.AJC.Su(301);
                        this.AJC.aa("create", "resp", "-1", String.valueOf(this.state));
                        eT(dVar2.AJu, 1001);
                        if (!dVar2.ALr) {
                            this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.AJK.k(-100, null);
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 209) {
                    this.AJK.eS(((com.tencent.wecall.talkroom.a.g) dVar).neq, i2);
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 206) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.neq, aVar.nCF, aVar.sZg, false)) {
                        h.a(aVar.neq, aVar.nCF, aVar.sZg, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.AJK.a(aVar.ALq, c.dTg().auL(aVar.neq));
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 204) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.neq, bVar.nCF, bVar.sZg, false)) {
                        this.AJC.aa("add", "resp", "-1", String.valueOf(this.state));
                        this.AJK.k(-300, null);
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 202) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.neq, eVar.nCF, eVar.sZg, So(eVar.ALs)) && this.state == 3) {
                        this.AJC.Su(302);
                        this.AJK.k(-200, null);
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 212) {
                    this.AJK.fF(null);
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 213) {
                    if (g.equals(((j) dVar).neq, this.neq)) {
                        this.AJC.aa("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.AJK.k(-700, null);
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 211) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.groupId, hVar.nwu, hVar.nwv, false)) {
                        this.AJC.aa("redirect", "resp", "-1", String.valueOf(this.state));
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else if (dVar.getType() == 214) {
                    l lVar = (l) dVar;
                    if (b(lVar.neq, lVar.nCF, lVar.sZg, false)) {
                        this.AJK.k(-800, null);
                    }
                    AppMethodBeat.o(127902);
                    return;
                } else {
                    if (dVar.getType() == 800) {
                        kVar = (k) dVar;
                        if (b(kVar.neq, kVar.nCF, kVar.sZg, false)) {
                            this.AJK.k(-1600, null);
                        }
                    }
                    AppMethodBeat.o(127902);
                    return;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "cancelCreateTalkRoom: ", e);
                AppMethodBeat.o(127902);
                return;
            }
        }
        Map I2;
        g gVar;
        int i3;
        if (dVar.getType() == 201) {
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            if (!(dVar3 == null || dVar3.AlO == null)) {
                Object obj;
                z zVar = (z) dVar3.AlO;
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.AJu);
                if (dVar3.ALr) {
                    obj = null;
                } else {
                    obj = 1;
                }
                I2 = com.tencent.pb.common.c.b.I(Integer.valueOf(14000), Integer.valueOf(VError.ERROR_FACE_TXT_INIT), Integer.valueOf(14001), Integer.valueOf(VError.ERROR_FACE_MODEL_INIT), Integer.valueOf(14002), Integer.valueOf(-1009));
                if (I2.containsKey(Integer.valueOf(i2))) {
                    h.Sq(((Integer) I2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    AJj = null;
                    if (i2 != 0) {
                        if (g.iA(this.AJu, dVar3.AJu)) {
                            if (i2 != -1) {
                                this.AJC.Su(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
                                this.AJC.aa("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                            }
                            if (this.state != 1) {
                                com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.AJu);
                                if (obj != null) {
                                    this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.neq, this.nCF, this.sZg, true);
                                if (i2 == 14051) {
                                    this.AJK.k(-900, null);
                                } else if (i2 == 14052) {
                                    this.AJK.k(VError.ERROR_FILTER_CREATE_FAIL, null);
                                } else if (i2 == 14053) {
                                    this.AJK.k(VError.ERROR_BEAUTY_FACE_ATTR_NULL, zVar);
                                } else if (i2 == 14504) {
                                    this.AJK.k(-1400, null);
                                } else {
                                    this.AJK.k(-100, null);
                                }
                                if (obj != null) {
                                    this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AJu, " createScene.mClientGroupId: ", dVar3.AJu, " errCode: ", Integer.valueOf(i2));
                            if (obj != null) {
                                this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (g.iA(this.AJu, zVar.Amx)) {
                        this.AJC.aa("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                        if (this.state != 1) {
                            h.Sq(VError.ERROR_DETECTOR_INSTANCE_INIT);
                            com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), zVar.Amx, Integer.valueOf(zVar.sQS), Long.valueOf(zVar.sQT));
                            if (obj != null) {
                                this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (zVar.AnR == null || zVar.AnR.length == 0) {
                            com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), zVar.Amx, Integer.valueOf(zVar.sQS), Long.valueOf(zVar.sQT));
                            h.Sq(-1605);
                            this.AJC.tdf = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                            a(zVar.groupId, zVar.sQS, zVar.sQT, 116, true);
                            if (obj != null) {
                                this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.AJK.k(-100, null);
                        } else {
                            a(zVar.Amx, zVar.sQS, zVar.sQT, zVar.groupId, zVar.Amz.AoT);
                            this.AJO = zVar.groupId;
                            this.AlR = zVar.AmC;
                            setState(4);
                            a(zVar.AnR, zVar.AnY, zVar.AnZ);
                            a(zVar.groupId, zVar.Amx, zVar.AmC, zVar.sQS, zVar.sQT, zVar.And, zVar.AnS, zVar.Amz, false, true);
                            if (this.AJK != null) {
                                gVar = this.AJK;
                                com.tencent.wecall.talkroom.model.g.AnonymousClass6 anonymousClass6 = new com.tencent.wecall.talkroom.model.g.AnonymousClass6(c.dTg().auL(zVar.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    anonymousClass6.run();
                                } else {
                                    gVar.handler.post(anonymousClass6);
                                }
                            }
                            byte[] bArr = new byte[zVar.AnU.length];
                            for (i3 = 0; i3 < zVar.AnU.length; i3++) {
                                bArr[i3] = (byte) zVar.AnU[i3];
                            }
                            int[] iArr = new int[zVar.Aod.length];
                            for (i3 = 0; i3 < zVar.Aod.length; i3++) {
                                iArr[i3] = zVar.Aod[i3];
                            }
                            a(0, zVar.And, zVar.Ane, bArr, (zVar.AnT & 2) != 0, zVar.groupId, zVar.sQS, zVar.sQT, zVar.Aoa, zVar.Aob, zVar.Aoc, iArr, zVar.Ang);
                            if (zVar.AnX != 0) {
                                com.tencent.pb.common.c.c.i("TalkRoomService", "get helloFreqSeconds:" + zVar.AnX);
                                AJq = zVar.AnX * 1000;
                            }
                            dTt();
                            l(zVar.groupId, zVar.sQS, zVar.sQT);
                            if (obj != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("result", Boolean.TRUE);
                                hashMap.put("shareUrl", new String(zVar.Amz.AoN, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("smsShortUrl", new String(zVar.Amz.AoO, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("groupId", zVar.groupId);
                                this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, hashMap);
                            }
                            com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg));
                        }
                    } else {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AJu, " resp.clientGroupId: ", zVar.Amx, Integer.valueOf(zVar.sQS), Long.valueOf(zVar.sQT));
                        a(zVar.groupId, zVar.sQS, zVar.sQT, 110, false);
                        if (obj != null) {
                            this.AHP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (dVar.getType() == 202) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            if (!(eVar2 == null || eVar2.AlO == null)) {
                a(i2, (aa) eVar2.AlO, eVar2);
            }
        }
        if (dVar.getType() == 204) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            if (!(bVar2 == null || bVar2.AlO == null)) {
                x xVar = (x) bVar2.AlO;
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), " errCode: ", Integer.valueOf(i2));
                I2 = com.tencent.pb.common.c.b.I(Integer.valueOf(14600), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL), Integer.valueOf(14601), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL), Integer.valueOf(14602), Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL));
                if (I2.containsKey(Integer.valueOf(i2))) {
                    h.Sq(((Integer) I2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    if (b(bVar2.neq, bVar2.nCF, bVar2.sZg, false)) {
                        this.AJC.aa("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.AJK.k(-300, null);
                    }
                } else {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(xVar.AnQ == null ? 0 : xVar.AnQ.length);
                    com.tencent.pb.common.c.c.w(str2, objArr);
                    if (b(xVar.groupId, xVar.sQS, xVar.sQT, false)) {
                        this.AJC.aa("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    } else {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", xVar.groupId, this.neq, " resp.roomid: ", Integer.valueOf(xVar.sQS), Integer.valueOf(this.nCF));
                        h.Sq(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED);
                    }
                    a(xVar.groupId, null, this.AlR, xVar.sQS, xVar.sQT, xVar.AnQ, null, xVar.Amz, true, true);
                }
            }
        }
        if (dVar.getType() == 203) {
            com.tencent.wecall.talkroom.a.f fVar = (com.tencent.wecall.talkroom.a.f) dVar;
            if (!(fVar == null || fVar.AlO == null)) {
                ab abVar = (ab) fVar.AlO;
                com.tencent.pb.common.c.c.d("TalkRoomService", "handleExitVoiceRoomEnd", abVar.groupId, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), " errCode: ", Integer.valueOf(i2));
                I = com.tencent.pb.common.c.b.I(Integer.valueOf(14400), Integer.valueOf(VError.ERROR_STICKER_INPUT_BUFFER_ERROR), Integer.valueOf(14401), Integer.valueOf(VError.ERROR_STICKER_OUTPUT_BUFFER_ERROR), Integer.valueOf(14402), Integer.valueOf(VError.ERROR_STICKER_FACE_ATTR_ERROR), Integer.valueOf(14403), Integer.valueOf(VError.ERROR_STICKER_INPUT_TEXTURE_ERROR));
                if (I.containsKey(Integer.valueOf(i2))) {
                    h.Sq(((Integer) I.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2));
                }
            }
        }
        if (dVar.getType() == 205) {
            m mVar = (m) dVar;
            if (!(mVar == null || mVar.AlO == null)) {
                ak akVar = (ak) mVar.AlO;
                com.tencent.pb.common.c.c.d("TalkRoomService", "handleHelloEnd", akVar.groupId, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Integer.valueOf(i2), Integer.valueOf(i));
                dTu();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.AJC.Su(com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX);
                    h.Sq(i3);
                }
            }
        }
        if (dVar.getType() == 206) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            if (!(aVar2 == null || aVar2.AlO == null)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.neq, " roomid: ", Integer.valueOf(aVar2.nCF), " roomKey: ", Long.valueOf(aVar2.sZg));
                MultiTalkGroup auL;
                if (i2 == 18950) {
                    if (!b(aVar2.neq, aVar2.nCF, aVar2.sZg, false)) {
                        h.a(aVar2.neq, aVar2.nCF, aVar2.sZg, "ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                    }
                    auL = c.dTg().auL(aVar2.neq);
                    com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.neq, " multiTalkGroup: ", auL);
                    if (auL != null) {
                        this.AJK.a(aVar2.ALq, auL);
                    }
                } else {
                    if (i2 == 0) {
                        this.AJr = true;
                    }
                    if (!cIJ()) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", aVar2.neq);
                        this.AJC.reset();
                        ru(false);
                        this.AJC.aa("ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.sRm = false;
                        this.neq = aVar2.neq;
                        this.AJO = this.neq;
                        this.nCF = aVar2.nCF;
                        this.sZg = aVar2.sZg;
                        this.AlR = aVar2.AlR;
                        setState(2);
                        this.AJy = System.currentTimeMillis();
                        h hVar2 = this.AJC;
                        com.tencent.pb.common.c.c.d(h.TAG, "beginNotifyTime");
                        hVar2.ALg = System.currentTimeMillis();
                        if (i2 == 18900) {
                            h.Sq(-1521);
                        }
                    } else if (g.equals(aVar2.neq, this.neq)) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.neq);
                    }
                    e eVar3 = new e();
                    eVar3.groupId = aVar2.neq;
                    eVar3.nwu = aVar2.nCF;
                    eVar3.nwv = aVar2.sZg;
                    this.AJk.put(aVar2.neq, eVar3);
                    auL = c.dTg().auL(aVar2.neq);
                    com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.neq, " multiTalkGroup: ", auL);
                    if (auL != null) {
                        gVar = this.AJK;
                        AnonymousClass20 anonymousClass20 = new AnonymousClass20(auL);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            anonymousClass20.run();
                        } else {
                            gVar.handler.post(anonymousClass20);
                        }
                    } else {
                        a(aVar2.neq, aVar2.nCF, aVar2.sZg, false, false, false);
                    }
                }
            }
        }
        if (dVar.getType() == 207) {
            i iVar = (i) dVar;
            if (!(iVar == null || iVar.AlO == null)) {
                if (i2 == 18100) {
                    h.Sq(-1501);
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == 208) {
            com.tencent.wecall.talkroom.a.c cVar = (com.tencent.wecall.talkroom.a.c) dVar;
            if (!(cVar == null || cVar.AlO == null)) {
                if (i2 == 18300) {
                    h.Sq(-1531);
                }
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == 209) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            if (!(gVar2 == null || gVar2.AlO == null)) {
                ac acVar = (ac) gVar2.AlO;
                if (i2 == 17900) {
                    h.Sq(-1511);
                }
                if (i2 != 0) {
                    this.AJK.eS(gVar2.neq, i2);
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2));
                } else {
                    TalkRoom auE = c.dTg().auE(acVar.groupId);
                    if (auE != null) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                        a(acVar.groupId, null, auE.dSU(), TalkRoom.dSV(), TalkRoom.cKa(), null, null, acVar.Amz, true, false);
                    } else {
                        a(acVar.groupId, null, 0, 0, 0, null, null, acVar.Amz, true, false);
                    }
                    this.AJK.eS(acVar.groupId, 0);
                }
            }
        }
        if (dVar.getType() == 210) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 19100) {
                h.Sq(-1541);
            }
        }
        if (dVar.getType() == 211) {
            com.tencent.wecall.talkroom.a.h hVar3 = (com.tencent.wecall.talkroom.a.h) dVar;
            if (hVar3 != null) {
                a(i, i2, dVar.AlO, hVar3);
            }
        }
        if (dVar.getType() == 212) {
            a(i2, (ah) dVar.AlO);
        }
        if (dVar.getType() == 213) {
            j jVar = (j) dVar;
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i2));
            if (i2 != 0) {
                if (g.equals(jVar.neq, this.neq)) {
                    this.AJC.aa("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.AJK.k(-700, null);
                }
            } else if (g.equals(jVar.neq, this.neq)) {
                this.AJC.aa("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                gVar = this.AJK;
                AnonymousClass18 anonymousClass18 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127965);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a dTo : g.this.callbacks) {
                                    dTo.dTo();
                                }
                            } finally {
                                AppMethodBeat.o(127965);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass18.run();
                } else {
                    gVar.handler.post(anonymousClass18);
                }
            }
        }
        if (dVar.getType() == 214) {
            af afVar = (af) dVar.AlO;
            l lVar2 = (l) dVar;
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i2));
            if (b(lVar2.neq, lVar2.nCF, lVar2.sZg, false)) {
                if (this.AJD != null) {
                    com.tencent.pb.common.c.c.d("TalkRoomService", "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[0]), Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[1]), Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[2]), Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[3]), Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[4]), Integer.valueOf(new int[]{afVar.Aof, afVar.Aog, afVar.Aoh, afVar.Aoi, afVar.Aoj, afVar.Aok}[5]));
                    b bVar3 = this.AJD;
                    if (bVar3.AIV == null) {
                        com.tencent.pb.common.c.c.w("simon:TalkRoomContext", "steve:setMVSvrCfg null, pMVSvrCfg:", r5, ", engine:", bVar3.AIV);
                    } else {
                        bVar3.AIV.setMVSvrCfg(r5, 6);
                    }
                }
                if (i2 == 0) {
                    g gVar3 = this.AJK;
                    AnonymousClass15 anonymousClass15 = new AnonymousClass15(afVar.Aof);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass15.run();
                    } else {
                        gVar3.handler.post(anonymousClass15);
                    }
                } else if (i2 == 24301) {
                    this.AJK.k(-1700, Integer.valueOf(afVar.Aom));
                } else {
                    this.AJK.k(-800, null);
                }
            } else {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", lVar2.neq, Integer.valueOf(lVar2.nCF));
            }
        }
        if (dVar.getType() == 800) {
            kVar = (k) dVar;
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleSubscribeLargeVideo errCode: ", Integer.valueOf(i2));
            if (!b(kVar.neq, kVar.nCF, kVar.sZg, false)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleSubscribeLargeVideo isCurrentRoom is not same", kVar.neq, Integer.valueOf(kVar.nCF));
                AppMethodBeat.o(127902);
                return;
            } else if (i2 == 0) {
                gVar = this.AJK;
                AnonymousClass16 anonymousClass16 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127963);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a bRN : g.this.callbacks) {
                                    bRN.bRN();
                                }
                            } finally {
                                AppMethodBeat.o(127963);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass16.run();
                    AppMethodBeat.o(127902);
                    return;
                }
                gVar.handler.post(anonymousClass16);
                AppMethodBeat.o(127902);
                return;
            } else {
                this.AJK.k(-1600, null);
            }
        }
        AppMethodBeat.o(127902);
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(127903);
        int i5 = -1;
        if (this.nME && this.AJD != null) {
            int i6;
            try {
                com.tencent.pb.common.c.c.d("TalkRoomService", "sendVideo ", Integer.valueOf(i), Integer.valueOf(i2));
                b bVar = this.AJD;
                if (bArr == null || bVar.AIV == null) {
                    com.tencent.pb.common.c.c.w("simon:TalkRoomContext", "steve:sendVideo null, buffer:", bArr, ", engine:", bVar.AIV);
                    i6 = -1;
                    com.tencent.pb.common.c.c.d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.nME), " ret: ", Integer.valueOf(i6), " engine: ", this.AJD);
                    i5 = i6;
                } else {
                    i6 = bVar.AIV.SendVideo(bArr, s, i, i2, i3, i4);
                    com.tencent.pb.common.c.c.d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.nME), " ret: ", Integer.valueOf(i6), " engine: ", this.AJD);
                    i5 = i6;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "sendVideo error: ", e);
                i6 = -1;
            }
        }
        AppMethodBeat.o(127903);
        return i5;
    }

    public final com.tencent.pb.talkroom.sdk.g a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        com.tencent.pb.talkroom.sdk.g gVar;
        AppMethodBeat.i(127904);
        com.tencent.pb.talkroom.sdk.g gVar2 = new com.tencent.pb.talkroom.sdk.g();
        if (this.nME && this.AJD != null) {
            try {
                com.tencent.pb.common.c.c.d("TalkRoomService", "videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3));
                b bVar = this.AJD;
                if (bArr == null || bVar.AIV == null) {
                    com.tencent.pb.common.c.c.w("simon:TalkRoomContext", "steve:videoTrans null, recordData:", bArr, ", engine:", bVar.AIV);
                    gVar = null;
                    com.tencent.pb.common.c.c.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.AJD);
                    AppMethodBeat.o(127904);
                    return gVar;
                }
                int videoTrans = bVar.AIV.videoTrans(bArr, i, i2, i3, i4, iArr);
                gVar = new com.tencent.pb.talkroom.sdk.g();
                gVar.Aqo = iArr;
                gVar.Aqp = bVar.AIV.field_localImgWidth;
                gVar.Aqq = bVar.AIV.field_localImgHeight;
                gVar.ret = videoTrans;
                com.tencent.pb.common.c.c.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.AJD);
                AppMethodBeat.o(127904);
                return gVar;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "videoTrans error: ", e);
            }
        }
        gVar = gVar2;
        com.tencent.pb.common.c.c.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nME), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.AJD);
        AppMethodBeat.o(127904);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x017c A:{Catch:{ Exception -> 0x011d }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1 A:{Catch:{ Exception -> 0x011d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.pb.talkroom.sdk.f D(int[] iArr) {
        AppMethodBeat.i(127905);
        com.tencent.pb.talkroom.sdk.f fVar = new com.tencent.pb.talkroom.sdk.f();
        if (this.nME && this.AJD != null) {
            com.tencent.pb.talkroom.sdk.f fVar2;
            try {
                com.tencent.pb.common.c.c.d("TalkRoomService", "receiveVideo");
                b bVar = this.AJD;
                com.tencent.pb.talkroom.sdk.f fVar3 = new com.tencent.pb.talkroom.sdk.f();
                if (iArr == null || bVar.AIV == null) {
                    com.tencent.pb.common.c.c.w("simon:TalkRoomContext", "steve:receiveVideo null, imgBuffer:", iArr, ", engine:", bVar.AIV);
                    fVar2 = fVar3;
                    com.tencent.pb.common.c.c.d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", fVar2, " engine: ", this.AJD);
                    fVar = fVar2;
                } else {
                    String str;
                    Object[] objArr;
                    fVar3.ret = bVar.AIV.videoDecode(iArr);
                    fVar3.Aqj = iArr;
                    fVar3.Aqk = bVar.AIV.field_remoteImgLength;
                    fVar3.Aql = bVar.AIV.field_remoteImgWidth;
                    fVar3.Aqm = bVar.AIV.field_remoteImgHeight;
                    fVar3.Aqn = bVar.AIV.field_remoteImgChannel & 16383;
                    c dTg = c.dTg();
                    String str2 = a.dSR().neq;
                    int i = fVar3.Aqn;
                    if (TextUtils.isEmpty(str2)) {
                        com.tencent.pb.common.c.c.w("TalkRoomManager", "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i));
                    } else {
                        TalkRoom auE = dTg.auE(str2);
                        if (auE == null) {
                            com.tencent.pb.common.c.c.w("TalkRoomManager", "getUsrNameByMemberId talkRoom is null groupId: ", str2, " memberId: ", Integer.valueOf(i));
                        } else {
                            for (av avVar : auE.dTb()) {
                                if (avVar != null && avVar.kyZ == i) {
                                    com.tencent.pb.common.c.c.d("TalkRoomManager", "getUsrNameByMemberId wxUserName:", avVar.Aop, " groupId: ", str2, " memberId: ", Integer.valueOf(i));
                                    if (avVar.Aop != null) {
                                        str = avVar.Aop;
                                        fVar3.Aqh = str;
                                        str2 = "simon:TalkRoomContext";
                                        objArr = new Object[4];
                                        objArr[0] = "steve:receiveVideo imgBuffer size:";
                                        objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                        objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                        objArr[3] = fVar3;
                                        com.tencent.pb.common.c.c.d(str2, objArr);
                                        fVar2 = fVar3;
                                        com.tencent.pb.common.c.c.d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", fVar2, " engine: ", this.AJD);
                                        fVar = fVar2;
                                    }
                                }
                            }
                        }
                    }
                    str = "";
                    fVar3.Aqh = str;
                    str2 = "simon:TalkRoomContext";
                    objArr = new Object[4];
                    objArr[0] = "steve:receiveVideo imgBuffer size:";
                    if (iArr != null) {
                    }
                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                    objArr[3] = fVar3;
                    com.tencent.pb.common.c.c.d(str2, objArr);
                    fVar2 = fVar3;
                    com.tencent.pb.common.c.c.d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.nME), " decInfo: ", fVar2, " engine: ", this.AJD);
                    fVar = fVar2;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "receiveVideo error: ", e);
                fVar2 = fVar;
            }
        }
        AppMethodBeat.o(127905);
        return fVar;
    }

    private void a(int i, ah ahVar) {
        AppMethodBeat.i(127906);
        com.tencent.pb.common.c.c.w("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i));
        if (i != 0) {
            this.AJK.fF(null);
            AppMethodBeat.o(127906);
            return;
        }
        au[] auVarArr = ahVar.Aon;
        if (auVarArr == null || auVarArr.length == 0) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            AppMethodBeat.o(127906);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (au auVar : auVarArr) {
            if (auVar != null) {
                a(auVar.groupId, null, 0, auVar.sQS, auVar.sQT, auVar.AnQ, null, null, false, false);
                arrayList.add(c.dTg().auL(auVar.groupId));
            }
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.AJK.fF(arrayList);
        AppMethodBeat.o(127906);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        AppMethodBeat.i(127907);
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0 || obj == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2));
            if (b(hVar.groupId, hVar.nwu, hVar.nwv, false)) {
                this.AJC.aa("redirect", "resp", "-1", String.valueOf(this.state));
            }
            AppMethodBeat.o(127907);
            return;
        }
        aj ajVar = (aj) obj;
        if (b(ajVar.groupId, ajVar.sQS, ajVar.sQT, false)) {
            int i3;
            this.AJC.aa("redirect", "resp", String.valueOf(i2), String.valueOf(this.state));
            a(ajVar.groupId, null, this.AlR, ajVar.sQS, ajVar.sQT, ajVar.AnQ, ajVar.AnS, ajVar.Amz, false, false);
            byte[] bArr = new byte[ajVar.AnU.length];
            for (i3 = 0; i3 < ajVar.AnU.length; i3++) {
                bArr[i3] = (byte) ajVar.AnU[i3];
            }
            int[] iArr = new int[ajVar.Aod.length];
            for (i3 = 0; i3 < ajVar.Aod.length; i3++) {
                iArr[i3] = ajVar.Aod[i3];
            }
            a(ajVar.AnR, ajVar.AnY, ajVar.AnZ);
            this.AJD.Close();
            a(0, ajVar.AnQ, ajVar.Ane, bArr, (ajVar.AnT & 2) != 0, ajVar.groupId, ajVar.sQS, ajVar.sQT, ajVar.Aoa, ajVar.Aob, ajVar.Aoc, iArr, ajVar.Ang);
            AppMethodBeat.o(127907);
            return;
        }
        com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(ajVar.sQS), Integer.valueOf(this.nCF));
        AppMethodBeat.o(127907);
    }

    private void a(int i, aa aaVar, com.tencent.wecall.talkroom.a.e eVar) {
        AppMethodBeat.i(127908);
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleEnterTalkRoomEnd", eVar.neq, Integer.valueOf(eVar.nCF), Long.valueOf(eVar.sZg), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state));
        Map I = com.tencent.pb.common.c.b.I(Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111));
        if (I.containsKey(Integer.valueOf(i))) {
            h.Sq(((Integer) I.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), aaVar.groupId, Integer.valueOf(aaVar.sQS), Long.valueOf(aaVar.sQT));
            this.AJK.k(-14255, aaVar);
            AppMethodBeat.o(127908);
        } else if (i == 14256) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), aaVar.groupId, Integer.valueOf(aaVar.sQS), Long.valueOf(aaVar.sQT));
            this.AJK.k(-14256, aaVar);
            AppMethodBeat.o(127908);
        } else if (i != 0 && i != 14204) {
            if (!b(eVar.neq, eVar.nCF, eVar.sZg, So(eVar.ALs))) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.neq, " mGroupId: ", this.neq, Integer.valueOf(eVar.nCF), Integer.valueOf(this.nCF), Long.valueOf(eVar.sZg), Long.valueOf(this.sZg));
                AppMethodBeat.o(127908);
            } else if (3 != this.state) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.neq, Integer.valueOf(eVar.nCF), Long.valueOf(eVar.sZg));
                AppMethodBeat.o(127908);
            } else {
                this.AJC.aa("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                this.AJC.Su(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
                com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.neq, Integer.valueOf(eVar.nCF), Long.valueOf(eVar.sZg));
                a(eVar.neq, eVar.nCF, eVar.sZg, true);
                if (i == 14251) {
                    this.AJK.k(-1000, null);
                    AppMethodBeat.o(127908);
                } else if (i == 14252) {
                    this.AJK.k(VError.ERROR_STICKER_CREATE_FAIL, null);
                    AppMethodBeat.o(127908);
                } else if (i == 14253) {
                    Object valueOf = Integer.valueOf(60);
                    if (aaVar != null) {
                        valueOf = Integer.valueOf(aaVar.AnW);
                    }
                    this.AJK.k(-1500, valueOf);
                    AppMethodBeat.o(127908);
                } else {
                    this.AJK.k(-200, null);
                    AppMethodBeat.o(127908);
                }
            }
        } else if (i == 14204 && this.state == 4) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", aaVar.groupId, Integer.valueOf(aaVar.sQS), Long.valueOf(aaVar.sQT));
            AppMethodBeat.o(127908);
        } else {
            if (!b(aaVar.groupId, aaVar.sQS, aaVar.sQT, So(aaVar.AmJ))) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", aaVar.groupId, " mGroupId: ", this.neq, Integer.valueOf(aaVar.sQS), Integer.valueOf(this.nCF), Long.valueOf(aaVar.sQT), Long.valueOf(this.sZg));
                a(aaVar.groupId, aaVar.sQS, aaVar.sQT, 111, false);
                h.Sq(-1110);
                AppMethodBeat.o(127908);
            } else if (this.state != 3) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), aaVar.groupId, Integer.valueOf(aaVar.sQS), Long.valueOf(aaVar.sQT));
                AppMethodBeat.o(127908);
            } else {
                this.AJC.aa("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                if (aaVar.AnR == null || aaVar.AnR.length == 0) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), aaVar.groupId, Integer.valueOf(aaVar.sQS), Long.valueOf(aaVar.sQT));
                    h.Sq(-1605);
                    this.AJC.tdf = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                    a(aaVar.groupId, aaVar.sQS, aaVar.sQT, 116, true);
                    this.AJK.k(-200, null);
                    AppMethodBeat.o(127908);
                    return;
                }
                int i2;
                this.neq = aaVar.groupId;
                this.AJO = aaVar.groupId;
                this.nCF = aaVar.sQS;
                this.sZg = aaVar.sQT;
                setState(4);
                a(aaVar.AnR, aaVar.AnY, aaVar.AnZ);
                a(aaVar.groupId, null, this.AlR, aaVar.sQS, aaVar.sQT, aaVar.AnQ, aaVar.AnS, aaVar.Amz, false, true);
                g gVar = this.AJK;
                com.tencent.wecall.talkroom.model.g.AnonymousClass7 anonymousClass7 = new com.tencent.wecall.talkroom.model.g.AnonymousClass7(c.dTg().auL(aaVar.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass7.run();
                } else {
                    gVar.handler.post(anonymousClass7);
                }
                byte[] bArr = new byte[aaVar.AnU.length];
                for (i2 = 0; i2 < aaVar.AnU.length; i2++) {
                    bArr[i2] = (byte) aaVar.AnU[i2];
                }
                int[] iArr = new int[aaVar.Aod.length];
                for (i2 = 0; i2 < aaVar.Aod.length; i2++) {
                    iArr[i2] = aaVar.Aod[i2];
                }
                a(0, aaVar.AnQ, aaVar.Ane, bArr, (aaVar.AnT & 2) != 0, aaVar.groupId, aaVar.sQS, aaVar.sQT, aaVar.Aoa, aaVar.Aob, aaVar.Aoc, iArr, aaVar.Ang);
                if (aaVar.AnX != 0) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "get helloFreqSeconds:" + aaVar.AnX);
                    AJq = aaVar.AnX * 1000;
                }
                dTt();
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg));
                AppMethodBeat.o(127908);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, av[] avVarArr, aw[] awVarArr, at atVar, boolean z, boolean z2) {
        Integer num;
        AppMethodBeat.i(127909);
        a(str, i2, j, avVarArr);
        c dTg = c.dTg();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z3 = this.neq != null && this.neq.equals(str);
        boolean a = dTg.a(str, str2, num, i2, j, atVar, avVarArr, awVarArr, z, z3);
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
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(avVarArr != null ? avVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.AJz);
        com.tencent.pb.common.c.c.d(str3, objArr);
        if (c.dTg().cp(this.neq, false)) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.AJz), " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i2));
            if (this.AJz) {
                this.AJz = false;
                this.nME = true;
                this.AJM = k.dTJ();
                this.AJx = this.AJv;
                dTy();
            }
        }
        if (avVarArr == null) {
            AppMethodBeat.o(127909);
            return;
        }
        if (z2 && b(str, i2, j, false) && avVarArr.length > 0 && this.AJD != null) {
            a(avVarArr);
        }
        AppMethodBeat.o(127909);
    }

    private void a(av[] avVarArr) {
        AppMethodBeat.i(127910);
        if (avVarArr == null) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "onMebersChangedToEngine members is null");
            AppMethodBeat.o(127910);
            return;
        }
        int[] iArr = new int[avVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < avVarArr.length; i++) {
            iArr[i] = avVarArr[i].kyZ;
            stringBuffer.append(avVarArr[i].kyZ);
            stringBuffer.append(",");
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.AJD == null) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "onMebersChangedToEngine engine is null");
            AppMethodBeat.o(127910);
            return;
        }
        this.AJD.OnMembersChanged(iArr);
        AppMethodBeat.o(127910);
    }

    private static void a(String str, int i, long j, av[] avVarArr) {
        AppMethodBeat.i(127911);
        if (avVarArr == null) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i), "  roomKey", Long.valueOf(j));
            AppMethodBeat.o(127911);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (av avVar : avVarArr) {
            if (avVar != null) {
                stringBuffer.append(" memberId:" + avVar.kyZ + " uuid: " + avVar.Aop + " status: " + avVar.status + "   mem.inviteTime:" + avVar.Api + "  mem.reason: " + avVar.boZ + "  mem.inviteuuid: " + avVar.Apu + IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(avVarArr.length), "  ", stringBuffer.toString());
        AppMethodBeat.o(127911);
    }

    private void a(o[] oVarArr, o[] oVarArr2, int i) {
        AppMethodBeat.i(127912);
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(oVarArr == null ? 0 : oVarArr.length);
        com.tencent.pb.common.c.c.d(str, objArr);
        if (oVarArr == null || oVarArr.length <= 0) {
            AppMethodBeat.o(127912);
            return;
        }
        this.AJU = new int[oVarArr.length];
        this.AJT = new short[oVarArr.length];
        this.AJW = new int[oVarArr2.length];
        this.AJV = new short[oVarArr2.length];
        this.AJX = i;
        com.tencent.pb.common.c.c.w("TalkRoomService", "handleRelayData tcpStartTime: ", Integer.valueOf(this.AJX));
        int i2 = 0;
        for (o oVar : oVarArr) {
            this.AJU[i2] = oVar.Ana;
            this.AJT[i2] = (short) oVar.port;
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleRelayData ip: ", Integer.valueOf(oVar.Ana), " addr.port: ", Integer.valueOf(oVar.port));
            i2++;
        }
        i2 = 0;
        for (o oVar2 : oVarArr2) {
            this.AJW[i2] = oVar2.Ana;
            this.AJV[i2] = (short) oVar2.port;
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleRelayData tcpIp: ", Integer.valueOf(oVar2.Ana), " tcpAddr.port: ", Integer.valueOf(oVar2.port));
            i2++;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleRelayData", Arrays.toString(this.AJU), Arrays.toString(this.AJT), this.neq, this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Arrays.toString(this.AJW), Arrays.toString(this.AJV), Integer.valueOf(this.AJX));
        AppMethodBeat.o(127912);
    }

    public final int ct(byte[] bArr) {
        p pVar;
        AppMethodBeat.i(127913);
        try {
            pVar = (p) com.google.a.a.e.a(new p(), bArr, bArr.length);
        } catch (Exception e) {
            h.Sq(-1601);
            pVar = null;
        }
        if (pVar == null) {
            if (TextUtils.isEmpty(this.neq) && TextUtils.isEmpty(this.AJu)) {
                h.a(this.nCF, this.sZg, "notify", "pasrefail");
            } else {
                this.AJC.aa("notify", "pasrefail");
            }
            com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            AppMethodBeat.o(127913);
            return -2;
        }
        Object obj;
        com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT onVoiceGroupChange", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Long.valueOf(pVar.cvx), Integer.valueOf(pVar.Anb));
        long j = pVar.cvx;
        if (this.AJP.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.AJP.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error");
            if (b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
                this.AJC.aa("notify", "repeat", String.valueOf(pVar.Anb));
            } else {
                h.a(pVar.groupId, pVar.sQS, pVar.sQT, "notify", "repeat", String.valueOf(pVar.Anb));
            }
            AppMethodBeat.o(127913);
            return -3;
        }
        if (b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
            this.AJC.aa("notify", "succ", String.valueOf(pVar.Anb));
        }
        int i;
        int i2;
        g gVar;
        byte[] bArr2;
        if (pVar.Anb == 2) {
            a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, true, true);
        } else if (pVar.Anb == 4) {
            a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, true, true);
            if (!(pVar.Anf == 0 && pVar.Ang == 0)) {
                b bVar = this.AJD;
                int i3 = pVar.Anf;
                int i4 = pVar.Ang;
                if (com.tencent.pb.common.a.a.Alr && bVar.AIV != null) {
                    bVar.AIV.SetAVEncryptType(i3, i4);
                }
            }
        } else if (pVar.Anb == 16) {
            a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, true, false);
        } else if (pVar.Anb == 1) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", pVar.groupId, " roomId: ", Integer.valueOf(pVar.sQS), " roomkey: ", Long.valueOf(pVar.sQT));
            if (com.tencent.pb.a.a.a.dPN()) {
                com.tencent.pb.a.a.a.dPO();
                if (cIJ() && g.equals(pVar.groupId, this.neq)) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.neq);
                } else {
                    a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, false, true);
                    String str = pVar.groupId;
                    i = pVar.sQS;
                    long j2 = pVar.sQT;
                    int i5 = pVar.AmC;
                    int i6 = pVar.Anh;
                    if (TextUtils.isEmpty(str)) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                    } else {
                        boolean a = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.a(str, i, j2, i5, i6));
                        com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", str, Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i6), Boolean.valueOf(a));
                    }
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handlerCreateGroupChange start ui");
                }
            } else {
                com.tencent.pb.common.c.c.w("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
            }
        } else if (pVar.Anb == 8) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", pVar.groupId, " mGroupId: ", this.neq);
            if (b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
                a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, true, false);
                a(pVar.groupId, pVar.sQS, pVar.sQT, false, false, true);
            } else {
                a(pVar.groupId, null, pVar.AmC, pVar.sQS, pVar.sQT, pVar.And, pVar.Anc, pVar.Amz, true, false);
            }
        } else if (pVar.Anb == 128) {
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = pVar.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.neq;
            objArr[4] = " groupChg.whisperBuf size: ";
            if (pVar.Ani == null) {
                i2 = 0;
            } else {
                i2 = pVar.Ani.length;
            }
            objArr[5] = Integer.valueOf(i2);
            com.tencent.pb.common.c.c.d(str2, objArr);
            gVar = this.AJK;
            AnonymousClass17 anonymousClass17 = new AnonymousClass17(pVar.groupId, pVar.Ani);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass17.run();
            } else {
                gVar.handler.post(anonymousClass17);
            }
        } else if (pVar.Anb == 256) {
            if (!b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoMember is not same room ", pVar.groupId, Integer.valueOf(pVar.sQS));
            } else if (pVar.Ani == null) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoMember whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.sQS));
            } else {
                r rVar;
                try {
                    bArr2 = pVar.Ani;
                    rVar = (r) com.google.a.a.e.a(new r(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e2) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoMember ", e2);
                    rVar = null;
                }
                if (rVar == null || rVar.Anm == null) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.sQS));
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : rVar.Anm) {
                        if (obj2 != null) {
                            arrayList.add(obj2);
                        }
                    }
                    com.tencent.pb.common.c.c.d("TalkRoomService", "handleVideoMember groupid: ", this.neq, " roomId: ", Integer.valueOf(this.nCF), " videoUserNames: ", arrayList);
                    gVar = this.AJK;
                    AnonymousClass11 anonymousClass11 = new AnonymousClass11(arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass11.run();
                    } else {
                        gVar.handler.post(anonymousClass11);
                    }
                }
            }
        } else if (pVar.Anb == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (!b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleOtherDevice is not same room ", pVar.groupId, Integer.valueOf(pVar.sQS));
            } else if (!(this.state == 3 || this.state == 4)) {
                a(pVar.groupId, pVar.sQS, pVar.sQT, 1);
                this.AJK.k(-1400, null);
            }
        } else if (pVar.Anb == 512) {
            if (!b(pVar.groupId, pVar.sQS, pVar.sQT, false)) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoSubscribes is not same room ", pVar.groupId, Integer.valueOf(pVar.sQS));
            } else if (pVar.Ani == null) {
                com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoSubscribes whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.sQS));
            } else {
                q qVar;
                try {
                    bArr2 = pVar.Ani;
                    qVar = (q) com.google.a.a.e.a(new q(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e22) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoSubscribes ", e22);
                    qVar = null;
                }
                if (qVar == null) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.sQS));
                } else {
                    g gVar2 = this.AJK;
                    com.tencent.wecall.talkroom.model.g.AnonymousClass1 anonymousClass1 = new com.tencent.wecall.talkroom.model.g.AnonymousClass1(qVar.Anl);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass1.run();
                    } else {
                        gVar2.handler.post(anonymousClass1);
                    }
                }
            }
        }
        AppMethodBeat.o(127913);
        return 0;
    }

    private void a(String str, int i, long j, boolean z) {
        AppMethodBeat.i(127914);
        a(str, i, j, z, true, true);
        AppMethodBeat.o(127914);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(127915);
        com.tencent.pb.common.c.c.w("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.neq, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nCF), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.sZg));
        c.dTg().auF(str);
        if (z) {
            l(str, i, j);
        }
        this.AJk.remove(str);
        if (b(str, i, j, false)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            ru(true);
            this.AJK.cq(str, z2);
        }
        if (z3) {
            MultiTalkGroup auL = c.dTg().auL(str);
            if (auL != null) {
                this.AJK.g(auL);
            }
        }
        AppMethodBeat.o(127915);
    }

    public final boolean cIJ() {
        AppMethodBeat.i(127916);
        com.tencent.pb.common.c.c.w("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            AppMethodBeat.o(127916);
            return true;
        }
        AppMethodBeat.o(127916);
        return false;
    }

    public final e auM(String str) {
        AppMethodBeat.i(127917);
        e eVar = (e) this.AJk.get(str);
        AppMethodBeat.o(127917);
        return eVar;
    }

    public final boolean auN(String str) {
        AppMethodBeat.i(127918);
        if (((e) this.AJk.get(str)) != null) {
            AppMethodBeat.o(127918);
            return true;
        }
        AppMethodBeat.o(127918);
        return false;
    }

    private void dTt() {
        AppMethodBeat.i(127919);
        com.tencent.pb.common.c.c.w("TalkRoomService", "hello timer start~~");
        if (this.AJF != null) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "dealWithInit enter talkroom not first time");
            AppMethodBeat.o(127919);
            return;
        }
        try {
            this.AJF = new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(127871);
                    if (f.this.nCF == 0 || f.this.neq == null) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.this.nCF), f.this.neq);
                        f.k(f.this);
                        AppMethodBeat.o(127871);
                        return;
                    }
                    f.a(f.this, f.j(f.this));
                    AppMethodBeat.o(127871);
                }
            };
            this.AJH.schedule(this.AJF, 0, (long) AJq);
            AppMethodBeat.o(127919);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "startNooper: ", e);
            AppMethodBeat.o(127919);
        }
    }

    private void dTu() {
        AppMethodBeat.i(127920);
        try {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.AJG != null) {
                this.AJG.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelHelloTimeOutTask: ", e);
        }
        this.AJG = null;
        AppMethodBeat.o(127920);
    }

    private void dTv() {
        AppMethodBeat.i(127921);
        try {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelHelloTimerTask");
            if (this.AJF != null) {
                this.AJF.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelHelloTimerTask: ", e);
        }
        this.AJF = null;
        AppMethodBeat.o(127921);
    }

    private void dTw() {
        AppMethodBeat.i(127922);
        try {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.AJI != null) {
                this.AJI.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "cancelTalkDurationTimerTask: ", e);
        }
        this.AJI = null;
        AppMethodBeat.o(127922);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2, int[] iArr, int i5) {
        Exception e;
        AppMethodBeat.i(127923);
        com.tencent.pb.common.c.c.d("TalkRoomService", "dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state));
        if (this.AJD != null) {
            boolean a;
            try {
                a = a(avVarArr, asVar, bArr, z, i2, j, i3, i4, bArr2, iArr, i5);
                try {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "dealWithInit ret: ", Boolean.valueOf(a));
                } catch (Exception e2) {
                    e = e2;
                    com.tencent.pb.common.c.c.w("TalkRoomService", "dealWithInit ", e);
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
                AppMethodBeat.o(127923);
                return;
            }
        }
        if (i > 0) {
            this.AJC.Su(202);
            com.tencent.pb.common.c.c.w("TalkRoomService", "exitTalkRoom dealWithInit fail");
            a(str, i2, j, 102, true);
            this.AJK.k(-400, null);
            AppMethodBeat.o(127923);
            return;
        }
        final int i6 = i;
        final av[] avVarArr2 = avVarArr;
        final as asVar2 = asVar;
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
                AppMethodBeat.i(127873);
                f.a(f.this, i6 - 1, avVarArr2, asVar2, bArr3, z2, str2, i7, j2, i8, i9, bArr4, iArr2, i10);
                AppMethodBeat.o(127873);
            }
        }, 50);
        AppMethodBeat.o(127923);
    }

    private boolean a(av[] avVarArr, as asVar, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2, int[] iArr, int i4) {
        AppMethodBeat.i(127924);
        if (this.state != 4) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
            AppMethodBeat.o(127924);
            return false;
        }
        boolean b = b(avVarArr, asVar, bArr, z, i, j, i2, i3, bArr2, iArr, i4);
        AppMethodBeat.o(127924);
        return b;
    }

    /* Access modifiers changed, original: final */
    public final boolean cEA() {
        int Lw;
        AppMethodBeat.i(127925);
        com.tencent.pb.common.c.c.d("TalkRoomService", "initEngine", this.neq, Integer.valueOf(this.nCF), Long.valueOf(this.sZg), Integer.valueOf(this.state));
        try {
            b bVar = this.AJD;
            if (com.tencent.pb.common.a.a.Alr) {
                String absolutePath = com.tencent.pb.common.c.d.sZj.getDir("lib", 0).getAbsolutePath();
                com.tencent.pb.talkroom.sdk.e eVar = Amd;
                if (eVar != null) {
                    Lw = eVar.Lw();
                } else {
                    Lw = 0;
                }
                com.tencent.pb.common.c.c.i("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(k.ju(com.tencent.pb.common.c.d.sZj)), " cpuFlag:", Integer.valueOf(Lw), "libPath:", absolutePath);
                if (bVar.AIV == null) {
                    Lw = -1;
                } else {
                    int i;
                    Lw = bVar.AIV.init(r6, Lw, absolutePath + "/");
                    absolutePath = "simon:TalkRoomContext";
                    Object[] objArr = new Object[4];
                    objArr[0] = "protocalInit";
                    objArr[1] = Integer.valueOf(Lw);
                    objArr[2] = "field_capInfo length: ";
                    if (bVar.AIV.field_capInfo == null) {
                        i = 0;
                    } else {
                        i = bVar.AIV.field_capInfo.length;
                    }
                    objArr[3] = Integer.valueOf(i);
                    com.tencent.pb.common.c.c.i(absolutePath, objArr);
                }
            } else {
                Lw = 0;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "initEngine", e);
            Lw = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (Lw < 0) {
            h.St(-3001);
            this.AJC.Su(201);
            this.AJD = null;
            com.tencent.pb.common.c.c.w("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(Lw));
            AppMethodBeat.o(127925);
            return false;
        }
        AppMethodBeat.o(127925);
        return true;
    }

    public final void rv(boolean z) {
        AppMethodBeat.i(127926);
        try {
            EB();
            dTs();
            if (z) {
                dTx();
                aDm();
            }
            com.tencent.pb.common.c.c.w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
            AppMethodBeat.o(127926);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
            AppMethodBeat.o(127926);
        }
    }

    private void aDm() {
        AppMethodBeat.i(127927);
        EB();
        int b = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c() {
            public final void Y(byte[] bArr, int i) {
                AppMethodBeat.i(127874);
                try {
                    if (f.this.AJs) {
                        if (f.this.mIsMute) {
                            for (int i2 = 0; i2 < bArr.length; i2++) {
                                bArr[i2] = (byte) 0;
                            }
                        }
                        if (f.this.AJs) {
                            b c = f.this.AJD;
                            short s = (short) i;
                            if (com.tencent.pb.common.a.a.Alr && c.AIV != null) {
                                c.AIV.SendAudio(bArr, s, 0);
                            }
                            if (f.this.AJR) {
                                f.this.AJR = false;
                                com.tencent.pb.common.c.c.w("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i));
                            }
                        }
                        AppMethodBeat.o(127874);
                        return;
                    }
                    AppMethodBeat.o(127874);
                } catch (Exception e) {
                    com.tencent.pb.common.c.c.w("TalkRoomService", "initMediaComponent record", e);
                    AppMethodBeat.o(127874);
                }
            }
        });
        if (b <= 0) {
            this.AJC.Su(101);
            h.Sr(-2001);
            this.AJK.k(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.AJC;
            hVar.AKR &= -2;
        } else {
            hVar = this.AJC;
            hVar.AKR |= 1;
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b));
        AppMethodBeat.o(127927);
    }

    private void dTx() {
        AppMethodBeat.i(127928);
        dTs();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        if (b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b() {
            public final int X(byte[] bArr, int i) {
                AppMethodBeat.i(127875);
                if (f.this.AJs) {
                    try {
                        int i2;
                        b c = f.this.AJD;
                        short s = (short) i;
                        AtomicInteger atomicInteger = atomicInteger;
                        AtomicInteger atomicInteger2 = atomicInteger2;
                        if (!com.tencent.pb.common.a.a.Alr || c.AIV == null) {
                            i2 = 1;
                        } else {
                            i2 = c.AIV.GetAudioData(bArr, s, atomicInteger, atomicInteger2);
                        }
                        if (f.this.AJS && i2 >= 0) {
                            f.this.AJS = false;
                            com.tencent.pb.common.c.c.w("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(i2));
                        }
                        AppMethodBeat.o(127875);
                        return i2;
                    } catch (Exception e) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "initMediaComponent play", e);
                        AppMethodBeat.o(127875);
                        return -1;
                    }
                }
                AppMethodBeat.o(127875);
                return 0;
            }
        }) <= 0) {
            this.AJC.Su(101);
            h.Sr(-2001);
            h hVar = this.AJC;
            hVar.AKR |= 1;
            this.AJK.k(-500, null);
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(r0));
        AppMethodBeat.o(127928);
    }

    private void dTy() {
        AppMethodBeat.i(127929);
        if (this.AJI != null) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
            AppMethodBeat.o(127929);
            return;
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.AJi, " mIsHoldOn: ", Boolean.valueOf(this.AJY));
        this.AJI = new TimerTask() {
            public final void run() {
                AppMethodBeat.i(127876);
                if (!f.this.AJY) {
                    f.this.AJv = f.this.AJv + 1;
                    if (f.this.AJM) {
                        f.this.AJx = f.this.AJx + 1;
                    }
                    if (f.this.AJB == 3 || f.this.AJB == 2) {
                        f.this.AJw = f.this.AJw + 1;
                        f.this.AJC.tdt = f.this.AJw;
                    }
                    f.this.AJC.AKV = f.this.AJv * 1000;
                    f.this.AJC.tds = f.this.AJv;
                }
                if (f.this.AJi != null) {
                    f.this.AJv;
                }
                AppMethodBeat.o(127876);
            }
        };
        this.AJJ.scheduleAtFixedRate(this.AJI, 1000, 1000);
        AppMethodBeat.o(127929);
    }

    private boolean b(av[] avVarArr, as asVar, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2, int[] iArr, int i4) {
        int[] iArr2;
        int i5;
        int i6;
        AppMethodBeat.i(127930);
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.neq, " ip: ", Arrays.toString(this.AJU), " ports: ", Arrays.toString(this.AJT), " tcpIp: ", Arrays.toString(this.AJW), " tcpPorts: ", Arrays.toString(this.AJV), " tcpStartTime: ", Integer.valueOf(this.AJX), " audio_encrypt_type: ", Integer.valueOf(i2), " video_encrypt_type: ", Integer.valueOf(i4));
        String dPM = com.tencent.pb.a.a.a.dPM();
        int i7 = -1;
        if (avVarArr == null || avVarArr.length <= 0) {
            iArr2 = null;
            i5 = -1;
        } else {
            int[] iArr3 = new int[avVarArr.length];
            for (i6 = 0; i6 < avVarArr.length; i6++) {
                iArr3[i6] = avVarArr[i6].kyZ;
                if (g.equals(avVarArr[i6].Aop, dPM)) {
                    i7 = avVarArr[i6].kyZ;
                }
            }
            iArr2 = iArr3;
            i5 = i7;
        }
        int auG = c.dTg().auG(this.neq);
        this.AJC.kyZ = i5;
        try {
            int i8;
            b bVar = this.AJD;
            com.tencent.mm.plugin.multi.talk.a aVar = this.AJE;
            TalkRoom auE = c.dTg().auE(this.neq);
            if (auE == null) {
                com.tencent.pb.common.c.c.w("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", r3);
                i8 = 0;
            } else {
                d auD = auE.auD(com.tencent.pb.a.a.a.dPM());
                if (auD == null) {
                    com.tencent.pb.common.c.c.w("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", r3);
                    i8 = 0;
                } else {
                    av avVar = auD.AJb;
                    if (avVar == null) {
                        com.tencent.pb.common.c.c.w("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", r3);
                        i8 = 0;
                    } else {
                        com.tencent.pb.common.c.c.d("TalkRoomManager", "getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(avVar.vzt));
                        i8 = avVar.vzt;
                    }
                }
            }
            int[] iArr4 = this.AJU;
            short[] sArr = this.AJT;
            int[] iArr5 = this.AJW;
            short[] sArr2 = this.AJV;
            int i9 = this.AJX;
            com.tencent.pb.common.c.c.i("simon:TalkRoomContext", "Open");
            i iVar = null;
            if (asVar != null) {
                iVar = new i(asVar.AoA, asVar.fAa, asVar.fAb, asVar.AoB, asVar.AoC, asVar.AoD, asVar.AoE, asVar.AoF, asVar.AoG, asVar.AoH, asVar.AoI, asVar.AoJ);
            } else {
                com.tencent.pb.common.c.c.w("simon:TalkRoomContext", "voiceConf is null");
            }
            int ju = k.ju(com.tencent.pb.common.c.d.sZj);
            if (bVar.AIV == null) {
                i6 = -1;
            } else {
                i6 = bVar.AIV.Open(aVar, iVar, i8, i5, i, j, iArr4, sArr, 0, iArr2, bArr, z, ju, iArr5, sArr2, i9, i2, i3, bArr2, iArr, i4);
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "connectToCompenent", th);
            i6 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        g gVar = this.AJK;
        com.tencent.wecall.talkroom.model.g.AnonymousClass2 anonymousClass2 = new com.tencent.wecall.talkroom.model.g.AnonymousClass2(i6);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            gVar.handler.post(anonymousClass2);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(auG));
        if (i6 < 0) {
            h.St(-3002);
        }
        if (i6 == 0) {
            this.AJC.tdi = 1;
        }
        if (i6 == 0) {
            AppMethodBeat.o(127930);
            return true;
        }
        AppMethodBeat.o(127930);
        return false;
    }

    private boolean b(String str, int i, long j, boolean z) {
        AppMethodBeat.i(127931);
        if (z) {
            boolean iA = g.iA(str, this.neq);
            AppMethodBeat.o(127931);
            return iA;
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.neq, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nCF), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.sZg));
        if (g.iA(str, this.neq) && i == this.nCF && j == this.sZg) {
            AppMethodBeat.o(127931);
            return true;
        }
        AppMethodBeat.o(127931);
        return false;
    }

    private void l(String str, int i, long j) {
        AppMethodBeat.i(127932);
        try {
            String k = c.dTg().k(str, i, j);
            com.tencent.pb.common.c.c.w("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.sRm), " mTalkDuration: ", Integer.valueOf(this.AJv), " msgKey: ", k);
            AppMethodBeat.o(127932);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "handleRoomExit: ", th);
            AppMethodBeat.o(127932);
        }
    }

    public final boolean az(String str, int i, int i2) {
        AppMethodBeat.i(127933);
        com.tencent.pb.common.c.c.w("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(127933);
            return false;
        }
        if (i == 1 || i2 == 100) {
            this.AJC.dTD();
        }
        int i3 = this.nCF;
        long j = this.sZg;
        int i4 = a.dSR().state;
        boolean eT;
        if (j.auS(str)) {
            this.AJC.Su(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            eT = a.dSR().eT(str, 1000);
            AppMethodBeat.o(127933);
            return eT;
        } else if (i4 == 2) {
            eT = a.dSR().a(str, i3, j, i);
            AppMethodBeat.o(127933);
            return eT;
        } else {
            com.tencent.pb.common.c.b.H(Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108)).contains(Integer.valueOf(i2));
            eT = a.dSR().a(str, i3, j, i2, true);
            AppMethodBeat.o(127933);
            return eT;
        }
    }

    private void dTz() {
        AppMethodBeat.i(127934);
        this.mHandler.removeCallbacks(this.AKc);
        this.AKb = null;
        AppMethodBeat.o(127934);
    }

    private void c(com.tencent.pb.common.b.d dVar) {
        AppMethodBeat.i(127935);
        this.mHandler.removeCallbacks(this.AKc);
        this.AKb = dVar;
        this.mHandler.postDelayed(this.AKc, 3000);
        AppMethodBeat.o(127935);
    }

    public final void eR(String str, int i) {
        AppMethodBeat.i(127936);
        if (g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) && cIJ() && (this.nME || this.AJs)) {
            switch (i) {
                case 21:
                    switch (k.ju(com.tencent.pb.common.c.d.sZj)) {
                        case 4:
                            this.AJM = true;
                            break;
                        default:
                            this.AJM = false;
                            break;
                    }
                    if (this.nCF == 0 || this.sZg == 0) {
                        com.tencent.pb.common.c.c.w("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        AppMethodBeat.o(127936);
                        return;
                    }
                    com.tencent.pb.common.c.c.w("TalkRoomService", "sendRedirect", this.neq, Integer.valueOf(this.nCF));
                    this.AJC.dTE();
                    boolean a = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.h(this.neq, this.nCF, this.sZg, c.dTg().auG(this.neq)));
                    this.AJC.aa("redirect", "req", String.valueOf(a), String.valueOf(this.state));
                    com.tencent.pb.common.c.c.w("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a));
                    AppMethodBeat.o(127936);
                    return;
                case 33:
                    b bVar = this.AJD;
                    int ju = k.ju(com.tencent.pb.common.c.d.sZj);
                    if (com.tencent.pb.common.a.a.Alr && bVar.AIV != null) {
                        bVar.AIV.onNetworkChange(ju);
                        break;
                    } else {
                        AppMethodBeat.o(127936);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(127936);
    }

    private static boolean So(int i) {
        return i != 1;
    }

    private void a(String str, int i, long j, String str2, String str3) {
        this.nCF = i;
        this.sZg = j;
        this.neq = str2;
        this.AJu = str;
        this.AJt = str3;
    }

    private static void La() {
        AppMethodBeat.i(127937);
        try {
            ((AudioManager) com.tencent.pb.common.c.d.sZj.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
            com.tencent.pb.common.c.c.w("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
            AppMethodBeat.o(127937);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "resumeAudioConfig ", th);
            AppMethodBeat.o(127937);
        }
    }

    public static boolean KU() {
        boolean isSpeakerphoneOn;
        AppMethodBeat.i(127938);
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.d.sZj.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "isSpeakerOn ", e);
            isSpeakerphoneOn = false;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn));
        AppMethodBeat.o(127938);
        return isSpeakerphoneOn;
    }

    public static void a(com.tencent.pb.talkroom.sdk.e eVar) {
        Amd = eVar;
    }

    public static com.tencent.pb.talkroom.sdk.e dTA() {
        return Amd;
    }

    private boolean dTs() {
        boolean bRl;
        AppMethodBeat.i(127897);
        try {
            com.tencent.pb.talkroom.sdk.e eVar = Amd;
            if (eVar != null) {
                this.AJC.sUz = eVar.bRn();
                this.AJC.sUp = eVar.bRq();
                bRl = eVar.bRl();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bRl));
                AppMethodBeat.o(127897);
                return bRl;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "stopPlayer: ", e);
        }
        bRl = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bRl));
        AppMethodBeat.o(127897);
        return bRl;
    }

    private boolean EB() {
        boolean bRm;
        AppMethodBeat.i(127899);
        try {
            com.tencent.pb.talkroom.sdk.e eVar = Amd;
            if (eVar != null) {
                this.AJC.sUs = eVar.bRo();
                this.AJC.sUo = eVar.bRp();
                bRm = eVar.bRm();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bRm));
                AppMethodBeat.o(127899);
                return bRm;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "stopRecord: ", e);
        }
        bRm = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bRm));
        AppMethodBeat.o(127899);
        return bRm;
    }

    static /* synthetic */ void e(f fVar) {
        AppMethodBeat.i(127940);
        if (fVar.AJD == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "the engine should not be null.");
            AppMethodBeat.o(127940);
            return;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "initMediaComponent");
        com.tencent.pb.common.c.f.C(411, 1, "1");
        fVar.dTx();
        fVar.aDm();
        AppMethodBeat.o(127940);
    }

    static /* synthetic */ m j(f fVar) {
        AppMethodBeat.i(127941);
        if (TextUtils.isEmpty(fVar.neq)) {
            com.tencent.pb.common.c.c.w("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            AppMethodBeat.o(127941);
            return null;
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", "doHelloVoiceRoom mGroupId: ", fVar.neq, " mRoomId: ", Integer.valueOf(fVar.nCF), " mRoomKey: ", Long.valueOf(fVar.sZg), " selfMemberId: ", Integer.valueOf(c.dTg().auG(fVar.neq)), " mCallData: ", Integer.valueOf(fVar.AJA));
        com.tencent.pb.common.b.d mVar = new m(fVar.neq, fVar.nCF, fVar.sZg, r6, fVar.AJA);
        com.tencent.pb.common.b.e.dPu().a(mVar);
        AppMethodBeat.o(127941);
        return mVar;
    }
}
