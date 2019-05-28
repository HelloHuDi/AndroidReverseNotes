package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.C0942i;
import com.tencent.p659pb.common.p1102c.C30916h;
import com.tencent.p659pb.common.p1102c.C40956g;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p1631a.C44437a;
import com.tencent.p659pb.common.p660b.C44438e;
import com.tencent.p659pb.common.p660b.C44439f;
import com.tencent.p659pb.common.p660b.C44439f.C36409a;
import com.tencent.p659pb.common.p660b.C44441h;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24190am;
import com.tencent.p659pb.common.system.ConnectReceiver;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.p659pb.talkroom.sdk.C24243a;
import com.tencent.p659pb.talkroom.sdk.C40957f;
import com.tencent.p659pb.talkroom.sdk.C44444d;
import com.tencent.p659pb.talkroom.sdk.C46731e;
import com.tencent.p659pb.talkroom.sdk.C46732g;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.model.C24507f.C24514b;
import com.tencent.wecall.talkroom.model.C24507f.C24517a;
import com.tencent.wecall.talkroom.model.C24507f.C6004e;
import com.tencent.wecall.talkroom.model.C6006g.C600710;
import com.tencent.wecall.talkroom.model.C6006g.C600812;
import com.tencent.wecall.talkroom.model.C6006g.C601914;
import com.tencent.wecall.talkroom.model.C6006g.C6028a;
import com.tencent.wecall.talkroom.p1114a.C25015b;
import com.tencent.wecall.talkroom.p1114a.C25016k;
import com.tencent.wecall.talkroom.p1114a.C31133l;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.wecall.talkroom.model.e */
public class C36576e implements C44444d {
    private static C36576e AJe = null;
    private C24243a AJd = null;
    private ConnectReceiver AJf = new ConnectReceiver();
    private C6028a AJg = new C365771();
    private final String TAG = "TalkRoomSdkApi";

    /* renamed from: com.tencent.wecall.talkroom.model.e$1 */
    class C365771 implements C6028a {
        C365771() {
        }

        /* renamed from: p */
        public final void mo13191p(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.m2504i(127819);
            C44443c.m80392w("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
            if (C44437a.Alq) {
                Toast.makeText(C46729d.sZj, "onCreateRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24583e(multiTalkGroup);
            }
            AppMethodBeat.m2505o(127819);
        }

        /* renamed from: Sm */
        public final void mo13174Sm(int i) {
            AppMethodBeat.m2504i(127820);
            C44443c.m80389d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i));
            AppMethodBeat.m2505o(127820);
        }

        public final void akC() {
            AppMethodBeat.m2504i(127821);
            C44443c.m80392w("TalkRoomSdkApi", "onInitSeccess");
            if (C44437a.Alq) {
                Toast.makeText(C46729d.sZj, "onInitSeccess ", 0).show();
            }
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.bRL();
            }
            AppMethodBeat.m2505o(127821);
        }

        /* renamed from: g */
        public final void mo13187g(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.m2504i(127822);
            String str = C41112a.dSR().neq;
            String str2 = null;
            if (multiTalkGroup != null) {
                str2 = multiTalkGroup.Aqc;
            }
            C44443c.m80391i("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
            if (C44437a.Alq) {
                Toast.makeText(C46729d.sZj, "onMemberChange ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (C40956g.m71019iA(str2, str)) {
                C6001c.dTg();
                if (C6001c.auJ(str) && C41112a.dSR().state != 3) {
                    int i;
                    int i2;
                    C6001c.dTg();
                    int auK = C6001c.auK(str);
                    if (auK == 104) {
                        i = -1602;
                        i2 = ErrorCode.THROWABLE_INITX5CORE;
                    } else if (auK == 2) {
                        i = -1603;
                        i2 = ErrorCode.TEST_THROWABLE_IS_NULL;
                    } else {
                        i = -1604;
                        i2 = ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT;
                    }
                    C44443c.m80392w("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(auK));
                    C36578h.m60647Sq(i);
                    C41112a.dSR().AJC.mo58375Su(i2);
                    C24507f dSR = C41112a.dSR();
                    auK = C41112a.dSR().nCF;
                    long j = C41112a.dSR().sZg;
                    C41112a.dSR();
                    dSR.mo41153a(str2, auK, j, false, false, false);
                }
            }
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24585g(multiTalkGroup);
            }
            AppMethodBeat.m2505o(127822);
        }

        /* renamed from: k */
        public final void mo13189k(int i, Object obj) {
            AppMethodBeat.m2504i(127823);
            C44443c.m80392w("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i), " data: ", obj);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24594k(i, obj);
            }
            AppMethodBeat.m2505o(127823);
        }

        /* renamed from: q */
        public final void mo13192q(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.m2504i(127824);
            C44443c.m80392w("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24584f(multiTalkGroup);
                if (C44437a.Alq) {
                    Toast.makeText(C46729d.sZj, "onEnterRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.m2505o(127824);
        }

        /* renamed from: cq */
        public final void mo13180cq(String str, boolean z) {
            AppMethodBeat.m2504i(127825);
            C44443c.m80389d("TalkRoomSdkApi", "onExitRoom", str, C41112a.dSR().neq, Boolean.valueOf(z));
            AppMethodBeat.m2505o(127825);
        }

        public final void onStateChanged(int i) {
            AppMethodBeat.m2504i(127826);
            C44443c.m80389d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i));
            AppMethodBeat.m2505o(127826);
        }

        public final void dTm() {
            AppMethodBeat.m2504i(127827);
            C44443c.m80389d("TalkRoomSdkApi", "onSelfHoldOnBegin");
            AppMethodBeat.m2505o(127827);
        }

        public final void dTn() {
            AppMethodBeat.m2504i(127828);
            C44443c.m80389d("TalkRoomSdkApi", "onSelfHoldOnEnd");
            AppMethodBeat.m2505o(127828);
        }

        /* renamed from: eS */
        public final void mo13185eS(String str, int i) {
            AppMethodBeat.m2504i(127829);
            C44443c.m80389d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(127829);
        }

        /* renamed from: jg */
        public final void mo13188jg(boolean z) {
            AppMethodBeat.m2504i(127830);
            C44443c.m80391i("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24588jg(z);
            }
            AppMethodBeat.m2505o(127830);
        }

        /* renamed from: b */
        public final void mo13178b(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.m2504i(127831);
            C44443c.m80392w("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24568b(multiTalkGroup);
                if (C44437a.Alq) {
                    Toast.makeText(C46729d.sZj, "onInviteMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.m2505o(127831);
        }

        /* renamed from: a */
        public final void mo13176a(int i, MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.m2504i(127832);
            C44443c.m80392w("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i));
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24582d(multiTalkGroup);
                if (C44437a.Alq) {
                    Toast.makeText(C46729d.sZj, "onMisscMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.m2505o(127832);
        }

        /* renamed from: fF */
        public final void mo13186fF(List<MultiTalkGroup> list) {
            AppMethodBeat.m2504i(127833);
            C44443c.m80391i("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd;
            }
            AppMethodBeat.m2505o(127833);
        }

        public final void dTo() {
            AppMethodBeat.m2504i(127834);
            C44443c.m80392w("TalkRoomSdkApi", "onSendMsgSucc");
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd;
            }
            AppMethodBeat.m2505o(127834);
        }

        /* renamed from: H */
        public final void mo13173H(String str, byte[] bArr) {
            int i = 0;
            AppMethodBeat.m2504i(127835);
            String str2 = "TalkRoomSdkApi";
            Object[] objArr = new Object[4];
            objArr[0] = "onRcvMultiTalkMsg groupId: ";
            objArr[1] = str;
            objArr[2] = " datas size: ";
            if (bArr != null) {
                i = bArr.length;
            }
            objArr[3] = Integer.valueOf(i);
            C44443c.m80392w(str2, objArr);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd;
            }
            AppMethodBeat.m2505o(127835);
        }

        /* renamed from: Sn */
        public final void mo13175Sn(int i) {
            AppMethodBeat.m2504i(127836);
            C44443c.m80389d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i));
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.bRM();
            }
            AppMethodBeat.m2505o(127836);
        }

        public final void bRN() {
            AppMethodBeat.m2504i(127837);
            C44443c.m80389d("TalkRoomSdkApi", "onSubscribeLargeVideoSuss");
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.bRN();
            }
            AppMethodBeat.m2505o(127837);
        }

        /* renamed from: cr */
        public final void mo13181cr(List<C24190am> list) {
            AppMethodBeat.m2504i(127838);
            C44443c.m80389d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24581cr(list);
            }
            AppMethodBeat.m2505o(127838);
        }

        /* renamed from: ze */
        public final void mo13193ze(int i) {
            AppMethodBeat.m2504i(127839);
            C44443c.m80389d("TalkRoomSdkApi", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(i));
            if (C36576e.this.AJd != null) {
                C36576e.this.AJd.mo24598ze(i);
            }
            AppMethodBeat.m2505o(127839);
        }
    }

    public static C36576e dTl() {
        AppMethodBeat.m2504i(127840);
        if (AJe == null) {
            synchronized (C36576e.class) {
                try {
                    if (AJe == null) {
                        AJe = new C36576e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(127840);
                    }
                }
            }
        }
        C36576e c36576e = AJe;
        AppMethodBeat.m2505o(127840);
        return c36576e;
    }

    private C36576e() {
        AppMethodBeat.m2504i(127841);
        AppMethodBeat.m2505o(127841);
    }

    /* renamed from: jt */
    public static void m60614jt(Context context) {
        AppMethodBeat.m2504i(127842);
        C46729d.sZj = context;
        C0942i.m2117dM(context);
        AppMethodBeat.m2505o(127842);
    }

    /* renamed from: a */
    public final boolean mo58361a(C24243a c24243a, C46731e c46731e) {
        AppMethodBeat.m2504i(127843);
        if (C46729d.sZj == null) {
            C44443c.m80392w("TalkRoomSdkApi", "init fail context: ", C46729d.sZj);
            AppMethodBeat.m2505o(127843);
            return false;
        }
        try {
            this.AJd = c24243a;
            C24507f.m38086a(c46731e);
            C24507f dSR = C41112a.dSR();
            dSR.AJK.mo13145a(this.AJg);
            C44439f.dPx().Amd = c46731e;
            C41112a.dSQ();
            C41112a.dSS();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            C46729d.sZj.registerReceiver(this.AJf, intentFilter);
            C44443c.m80389d("TalkRoomSdkApi", "init");
            AppMethodBeat.m2505o(127843);
            return true;
        } catch (Exception e) {
            C44443c.m80392w("TalkRoomSdkApi", "init ", e);
            AppMethodBeat.m2505o(127843);
            return false;
        }
    }

    /* renamed from: rm */
    public final void mo58371rm(boolean z) {
        AppMethodBeat.m2504i(127844);
        C24507f dSR = C41112a.dSR();
        C44443c.m80392w("TalkRoomService", "setMute isMute: ", Boolean.valueOf(z));
        dSR.mIsMute = z;
        C30916h.m49359aB(new C601914(z));
        AppMethodBeat.m2505o(127844);
    }

    /* renamed from: jo */
    public final void mo58370jo(boolean z) {
        boolean jk;
        AppMethodBeat.m2504i(127845);
        C41112a.dSR();
        C46731e dTA = C24507f.dTA();
        if (dTA != null) {
            jk = dTA.mo46546jk(z);
        } else {
            jk = false;
        }
        C44443c.m80389d("TalkRoomService", "switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(jk), " realret: ", Boolean.valueOf(C24507f.m38075KU()), " wxCallBack: ", dTA);
        AppMethodBeat.m2505o(127845);
    }

    public final boolean dPP() {
        AppMethodBeat.m2504i(127846);
        try {
            C44443c.dPK();
            C44443c.m80392w("TalkRoomSdkApi", "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", Integer.valueOf(0));
            AppMethodBeat.m2505o(127846);
            return true;
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomSdkApi", "setOpenLog: ", th);
            AppMethodBeat.m2505o(127846);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final boolean mo58369f(String str, String str2, List<String> list) {
        AppMethodBeat.m2504i(127847);
        C24507f dSR = C41112a.dSR();
        String[] fG = C24507f.m38113fG(list);
        if (fG.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (C36407a.dPM().hashCode() & CdnLogic.kBizGeneric);
            } else {
                String str3 = null;
                String str4 = null;
                int charAt = str3.charAt(str4.length() - 1) * 256;
                nextInt = 0;
                String str5 = null;
                if (str5.length() > 1) {
                    str3 = null;
                    str5 = null;
                    nextInt = str3.charAt(str5.length() - 2);
                }
                nextInt += charAt;
            }
            C44443c.m80392w("TalkRoomService", "createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(fG.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null);
            if (!C36407a.dPN()) {
                C44443c.m80392w("TalkRoomService", "createTalkRoom isAuthed: ", Boolean.valueOf(C36407a.dPN()), " isBindMobile: ", Boolean.valueOf(C36407a.dPO()));
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "noAuth");
            } else if (!C44441h.isNetworkConnected()) {
                C44443c.m80392w("TalkRoomService", "createTalkRoom isNetworkConnected is false");
                C36578h.m60649Ss(-4003);
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "noNetwork");
            } else if (dSR.cIJ()) {
                if (dSR.cIJ()) {
                    C36578h.m60649Ss(-4002);
                }
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "isBusy");
            } else if (TextUtils.isEmpty(str)) {
                C44443c.m80392w("TalkRoomService", "createTalkRoom cliendId is null");
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "cliendIdnull");
            } else if (C46825j.auS(str)) {
                if (C6001c.dTg().auE(str) == null) {
                    C6001c.dTg().mo13132d(str, str2, fG);
                }
                dSR.AJC.reset();
                dSR.mo41166ru(false);
                dSR.dTp();
                if (dSR.cEA()) {
                    dSR.AJC.dTC();
                    dSR.neq = str;
                    dSR.AJO = str;
                    dSR.AlR = nextInt;
                    dSR.AJu = str;
                    dSR.setState(1);
                    dSR.sRm = true;
                    C24517a c24517a = new C24517a();
                    c24517a.groupId = dSR.neq;
                    c24517a.AKr = fG;
                    c24517a.AKs = null;
                    c24517a.AmC = nextInt;
                    c24517a.type = 0;
                    c24517a.AKt = 0;
                    c24517a.AKu = null;
                    c24517a.AKv = false;
                    c24517a.AKw = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = c24517a;
                    dSR.mHandler.removeMessages(2);
                    TalkRoom auE = C6001c.dTg().auE(dSR.neq);
                    if (auE == null) {
                        C44443c.m80392w("TalkRoomManager", "isOnlyMySelfInGroup talkroom is null");
                    } else {
                        List dSX = auE.dSX();
                        if (dSX == null || dSX.size() != 1) {
                            C44443c.m80392w("TalkRoomManager", "isOnlyMySelfInGroup TalkRoomMember list is not match");
                        } else {
                            C6003d c6003d = (C6003d) dSX.get(0);
                            if (c6003d == null) {
                                C44443c.m80392w("TalkRoomManager", "isOnlyMySelfInGroup talkRoomMember is null");
                            } else {
                                boolean dTk = c6003d.dTk();
                                C44443c.m80392w("TalkRoomManager", "isOnlyMySelfInGroup ret: ", Boolean.valueOf(dTk));
                            }
                        }
                    }
                    dSR.mHandler.sendMessage(obtain);
                    dSR.AJQ = true;
                    C44443c.m80392w("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", C36407a.dPM(), " usrnameList: ", list);
                    if (str == null) {
                        AppMethodBeat.m2505o(127847);
                        return true;
                    }
                    AppMethodBeat.m2505o(127847);
                    return false;
                }
                C44443c.m80392w("TalkRoomService", "createTalkRoom initEngine fail");
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "initEnginefail");
                dSR.mo41166ru(false);
            } else {
                C44443c.m80392w("TalkRoomService", "createTalkRoom groupId is not cliend id: ", str);
                C36578h.m60653a("", str, 0, 0, "create", "req", "false", "isnotcliendId");
            }
        }
        str = null;
        C44443c.m80392w("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", C36407a.dPM(), " usrnameList: ", list);
        if (str == null) {
        }
    }

    /* renamed from: A */
    public final boolean mo58354A(String str, int i, String str2) {
        AppMethodBeat.m2504i(127848);
        C24507f dSR = C41112a.dSR();
        C44443c.m80392w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(i), " ret: ", dSR.mo41151a(str, dSR.nCF, dSR.sZg, i, 1, str2));
        if (dSR.mo41151a(str, dSR.nCF, dSR.sZg, i, 1, str2) == C24514b.OK) {
            AppMethodBeat.m2505o(127848);
            return true;
        }
        AppMethodBeat.m2505o(127848);
        return false;
    }

    /* renamed from: a */
    public final boolean mo58362a(String str, int i, long j, int i2, String str2) {
        AppMethodBeat.m2504i(127849);
        C44443c.m80392w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " wxGroupId: ", str2, " ret: ", C41112a.dSR().mo41151a(str, i, j, i2, 100, str2));
        if (C41112a.dSR().mo41151a(str, i, j, i2, 100, str2) == C24514b.OK) {
            AppMethodBeat.m2505o(127849);
            return true;
        }
        AppMethodBeat.m2505o(127849);
        return false;
    }

    /* renamed from: B */
    public final boolean mo58355B(String str, List<String> list) {
        AppMethodBeat.m2504i(127850);
        if (C40956g.m71019iA(str, C41112a.dSR().neq)) {
            boolean z;
            C24507f dSR = C41112a.dSR();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(dSR.nCF);
            objArr[3] = Long.valueOf(dSR.sZg);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            C44443c.m80392w(str2, objArr);
            dSR.AJQ = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (C44441h.isNetworkConnected()) {
                String[] fG = C24507f.m38113fG(list);
                if (fG.length <= 0) {
                    C44443c.m80392w("TalkRoomService", "addTalkRoomMember users is null");
                    z = false;
                } else {
                    z = C44438e.dPu().mo70368a(new C25015b(str, dSR.nCF, dSR.sZg, fG));
                    dSR.AJC.mo58376aa("add", "req", String.valueOf(z), String.valueOf(dSR.state));
                }
            } else {
                C44443c.m80392w("TalkRoomService", "addTalkRoomMember isNetworkConnected is false");
                z = false;
            }
            C44443c.m80392w("TalkRoomSdkApi", "addMultiTalkMember ret: ", Boolean.valueOf(z));
            AppMethodBeat.m2505o(127850);
            return z;
        }
        C44443c.m80392w("TalkRoomSdkApi", "addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, C41112a.dSR().neq);
        AppMethodBeat.m2505o(127850);
        return false;
    }

    /* renamed from: Sa */
    public final boolean mo58357Sa(String str) {
        AppMethodBeat.m2504i(127851);
        if (C40956g.m71019iA(str, C41112a.dSR().neq)) {
            int i = C41112a.dSR().nCF;
            long j = C41112a.dSR().sZg;
            boolean az = C41112a.dSR().mo41158az(str, 1, 100);
            C44443c.m80392w("TalkRoomSdkApi", "exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            AppMethodBeat.m2505o(127851);
            return az;
        }
        C44443c.m80392w("TalkRoomSdkApi", "exitMultiTalk groupid is not same; multiTalkGroupid: ", str, C41112a.dSR().neq);
        if (C41112a.dSR().auN(str)) {
            C6004e auM = C41112a.dSR().auM(str);
            C41112a.dSR().mo41154a(str, auM == null ? 0 : auM.nwu, auM == null ? 0 : auM.nwv, 1);
        }
        AppMethodBeat.m2505o(127851);
        return false;
    }

    public final List<String> atK(String str) {
        AppMethodBeat.m2504i(127852);
        if (C40956g.m71019iA(str, C41112a.dSR().neq)) {
            TalkRoom auE = C6001c.dTg().auE(str);
            if (auE == null) {
                C44443c.m80392w("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
                AppMethodBeat.m2505o(127852);
                return null;
            }
            List<C6003d> dSY = auE.dSY();
            ArrayList arrayList = new ArrayList();
            for (C6003d c6003d : dSY) {
                if (c6003d != null) {
                    int i;
                    C24507f dSR = C41112a.dSR();
                    int dTj = c6003d.dTj();
                    if (dSR.AJD != null) {
                        C36575b c36575b = dSR.AJD;
                        i = (!C44437a.Alr || c36575b.AIV == null) ? 0 : c36575b.AIV.GetVoiceActivity(dTj) == 1 ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(c6003d.dTi());
                    }
                }
            }
            AppMethodBeat.m2505o(127852);
            return arrayList;
        }
        C44443c.m80392w("TalkRoomSdkApi", "getTalkingMember groupid is not same; multiTalkGroupid: ", str, C41112a.dSR().neq);
        AppMethodBeat.m2505o(127852);
        return null;
    }

    /* renamed from: e */
    public final boolean mo58368e(int i, int i2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(127853);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C44443c.m80392w(str, objArr);
        if (i == 0) {
            C44439f.dPx().mo70373s(i2, bArr);
        } else {
            C44439f dPx = C44439f.dPx();
            C36409a QW = dPx.mo70369QW(i2);
            if (QW != null) {
                C44443c.m80392w("NETCMD", "CLTRCV FAIL", Integer.valueOf(i2), QW.Amg, Integer.valueOf(1), Integer.valueOf(i));
                dPx.mo70372a(QW, -1, null);
            }
        }
        AppMethodBeat.m2505o(127853);
        return true;
    }

    /* renamed from: ck */
    public final boolean mo58365ck(byte[] bArr) {
        AppMethodBeat.m2504i(127854);
        C44439f.dPx();
        C44443c.m80392w("TalkRoomSdkApi", "handleMultiTalkNotify ret: ", Integer.valueOf(C44439f.m80379cj(bArr)));
        if (C44439f.m80379cj(bArr) == 0) {
            AppMethodBeat.m2505o(127854);
            return true;
        }
        AppMethodBeat.m2505o(127854);
        return false;
    }

    /* renamed from: rn */
    public final boolean mo58372rn(boolean z) {
        AppMethodBeat.m2504i(127855);
        C44443c.m80392w("TalkRoomSdkApi", "holadMultiTalk isHold", Boolean.valueOf(z));
        C24507f dSR;
        if (z) {
            dSR = C41112a.dSR();
            C44443c.m80389d("TalkRoomService", "syscall", "startHoldOn");
            dSR.AJY = true;
            dSR.mo41167rv(false);
            C30916h.m49359aB(new C600710());
        } else {
            dSR = C41112a.dSR();
            C44443c.m80389d("TalkRoomService", "syscall", "endHoldOn");
            dSR.AJY = false;
            dSR.dTq();
            if (dSR.cIJ() && dSR.nME) {
                dSR.mo41167rv(true);
                C30916h.m49359aB(new C600812());
            }
        }
        AppMethodBeat.m2505o(127855);
        return true;
    }

    /* renamed from: bR */
    public final void mo58364bR(int i, String str) {
        AppMethodBeat.m2504i(127857);
        C36407a.m60044QX(i);
        C36407a.atJ(str);
        C44443c.m80392w("TalkRoomSdkApi", "setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str);
        AppMethodBeat.m2505o(127857);
    }

    /* renamed from: zf */
    public final boolean mo58374zf(int i) {
        AppMethodBeat.m2504i(127858);
        if (C41112a.dSR().cIJ()) {
            C44443c.m80389d("TalkRoomSdkApi", "switchMultiTalkVideo action: ", Integer.valueOf(i));
            C24507f dSR = C41112a.dSR();
            if (TextUtils.isEmpty(dSR.neq)) {
                C44443c.m80392w("TalkRoomService", "switchMultiTalkVideo mGroupId is null");
                AppMethodBeat.m2505o(127858);
                return false;
            }
            dSR.AJB = i;
            C44443c.m80389d("TalkRoomService", "switchMultiTalkVideo ret: ", Boolean.valueOf(C44438e.dPu().mo70368a(new C31133l(dSR.neq, dSR.nCF, dSR.sZg, i))));
            AppMethodBeat.m2505o(127858);
            return C44438e.dPu().mo70368a(new C31133l(dSR.neq, dSR.nCF, dSR.sZg, i));
        }
        C44443c.m80392w("TalkRoomSdkApi", "switchMultiTalkVideo isWorking is false");
        AppMethodBeat.m2505o(127858);
        return false;
    }

    /* renamed from: Sj */
    public final boolean mo58358Sj(String str) {
        AppMethodBeat.m2504i(127859);
        if (C41112a.dSR().cIJ()) {
            C44443c.m80389d("TalkRoomSdkApi", "subscribeLargeVideo ownerUserName: ", str);
            C24507f dSR = C41112a.dSR();
            if (TextUtils.isEmpty(dSR.neq)) {
                C44443c.m80392w("TalkRoomService", "subscribeLargeVideo mGroupId null ");
                AppMethodBeat.m2505o(127859);
                return false;
            }
            C44443c.m80389d("TalkRoomService", "subscribeLargeVideo ret: ", Boolean.valueOf(C44438e.dPu().mo70368a(new C25016k(dSR.neq, dSR.nCF, dSR.sZg, str))));
            AppMethodBeat.m2505o(127859);
            return C44438e.dPu().mo70368a(new C25016k(dSR.neq, dSR.nCF, dSR.sZg, str));
        }
        C44443c.m80392w("TalkRoomSdkApi", "subscribeLargeVideo isWorking is false");
        AppMethodBeat.m2505o(127859);
        return false;
    }

    /* renamed from: a */
    public final int mo58359a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(127860);
        int a = C41112a.dSR().mo41149a(bArr, s, i, i2, i3, i4);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Short.valueOf(s);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i4);
        C44443c.m80389d(str, objArr);
        AppMethodBeat.m2505o(127860);
        return a;
    }

    /* renamed from: D */
    public final C40957f mo58356D(int[] iArr) {
        int i = 0;
        AppMethodBeat.m2504i(127861);
        C40957f D = C41112a.dSR().mo41148D(iArr);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[4];
        objArr[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " MultiTalkVideoDecodeInfo: ";
        objArr[3] = D;
        C44443c.m80389d(str, objArr);
        AppMethodBeat.m2505o(127861);
        return D;
    }

    /* renamed from: a */
    public final C46732g mo58360a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        AppMethodBeat.m2504i(127862);
        C46732g a = C41112a.dSR().mo41150a(bArr, i, i2, i3, i4, iArr);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " localImg size: ";
        if (iArr != null) {
            i5 = iArr.length;
        }
        objArr[5] = Integer.valueOf(i5);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = a;
        C44443c.m80389d(str, objArr);
        AppMethodBeat.m2505o(127862);
        return a;
    }

    public final int setAppCmd(int i, byte[] bArr, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(127863);
        C24507f dSR = C41112a.dSR();
        if (dSR.AJD == null) {
            C44443c.m80392w("TalkRoomService", "setAppCmd type: ", Integer.valueOf(i), " engine is null");
        } else {
            C36575b c36575b = dSR.AJD;
            if (bArr == null || c36575b.AIV == null) {
                C44443c.m80392w("simon:TalkRoomContext", "steve:setAppCmd null, params:", bArr, ", engine:", c36575b.AIV);
            } else {
                i3 = c36575b.AIV.setAppCmd(i, bArr, i2);
            }
        }
        C44443c.m80389d("TalkRoomSdkApi", "setAppCmd type: ", Integer.valueOf(i), " paramLen: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.m2505o(127863);
        return i3;
    }

    public final String dPQ() {
        AppMethodBeat.m2504i(127856);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(C36407a.dPM());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        C44443c.m80392w("TalkRoomSdkApi", "genMultiTalkClientId clientId: ", stringBuilder.toString());
        AppMethodBeat.m2505o(127856);
        return stringBuilder.toString();
    }
}
