package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.g.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.common.c.h;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.model.f.b;
import com.tencent.wecall.talkroom.model.g.AnonymousClass14;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class e implements d {
    private static e AJe = null;
    private a AJd = null;
    private ConnectReceiver AJf = new ConnectReceiver();
    private g.a AJg = new g.a() {
        public final void p(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(127819);
            c.w("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
            if (com.tencent.pb.common.a.a.Alq) {
                Toast.makeText(com.tencent.pb.common.c.d.sZj, "onCreateRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (e.this.AJd != null) {
                e.this.AJd.e(multiTalkGroup);
            }
            AppMethodBeat.o(127819);
        }

        public final void Sm(int i) {
            AppMethodBeat.i(127820);
            c.d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i));
            AppMethodBeat.o(127820);
        }

        public final void akC() {
            AppMethodBeat.i(127821);
            c.w("TalkRoomSdkApi", "onInitSeccess");
            if (com.tencent.pb.common.a.a.Alq) {
                Toast.makeText(com.tencent.pb.common.c.d.sZj, "onInitSeccess ", 0).show();
            }
            if (e.this.AJd != null) {
                e.this.AJd.bRL();
            }
            AppMethodBeat.o(127821);
        }

        public final void g(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(127822);
            String str = a.dSR().neq;
            String str2 = null;
            if (multiTalkGroup != null) {
                str2 = multiTalkGroup.Aqc;
            }
            c.i("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
            if (com.tencent.pb.common.a.a.Alq) {
                Toast.makeText(com.tencent.pb.common.c.d.sZj, "onMemberChange ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (g.iA(str2, str)) {
                c.dTg();
                if (c.auJ(str) && a.dSR().state != 3) {
                    int i;
                    int i2;
                    c.dTg();
                    int auK = c.auK(str);
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
                    c.w("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(auK));
                    h.Sq(i);
                    a.dSR().AJC.Su(i2);
                    f dSR = a.dSR();
                    auK = a.dSR().nCF;
                    long j = a.dSR().sZg;
                    a.dSR();
                    dSR.a(str2, auK, j, false, false, false);
                }
            }
            if (e.this.AJd != null) {
                e.this.AJd.g(multiTalkGroup);
            }
            AppMethodBeat.o(127822);
        }

        public final void k(int i, Object obj) {
            AppMethodBeat.i(127823);
            c.w("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i), " data: ", obj);
            if (e.this.AJd != null) {
                e.this.AJd.k(i, obj);
            }
            AppMethodBeat.o(127823);
        }

        public final void q(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(127824);
            c.w("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
            if (e.this.AJd != null) {
                e.this.AJd.f(multiTalkGroup);
                if (com.tencent.pb.common.a.a.Alq) {
                    Toast.makeText(com.tencent.pb.common.c.d.sZj, "onEnterRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(127824);
        }

        public final void cq(String str, boolean z) {
            AppMethodBeat.i(127825);
            c.d("TalkRoomSdkApi", "onExitRoom", str, a.dSR().neq, Boolean.valueOf(z));
            AppMethodBeat.o(127825);
        }

        public final void onStateChanged(int i) {
            AppMethodBeat.i(127826);
            c.d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i));
            AppMethodBeat.o(127826);
        }

        public final void dTm() {
            AppMethodBeat.i(127827);
            c.d("TalkRoomSdkApi", "onSelfHoldOnBegin");
            AppMethodBeat.o(127827);
        }

        public final void dTn() {
            AppMethodBeat.i(127828);
            c.d("TalkRoomSdkApi", "onSelfHoldOnEnd");
            AppMethodBeat.o(127828);
        }

        public final void eS(String str, int i) {
            AppMethodBeat.i(127829);
            c.d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i));
            AppMethodBeat.o(127829);
        }

        public final void jg(boolean z) {
            AppMethodBeat.i(127830);
            c.i("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
            if (e.this.AJd != null) {
                e.this.AJd.jg(z);
            }
            AppMethodBeat.o(127830);
        }

        public final void b(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(127831);
            c.w("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
            if (e.this.AJd != null) {
                e.this.AJd.b(multiTalkGroup);
                if (com.tencent.pb.common.a.a.Alq) {
                    Toast.makeText(com.tencent.pb.common.c.d.sZj, "onInviteMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(127831);
        }

        public final void a(int i, MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(127832);
            c.w("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i));
            if (e.this.AJd != null) {
                e.this.AJd.d(multiTalkGroup);
                if (com.tencent.pb.common.a.a.Alq) {
                    Toast.makeText(com.tencent.pb.common.c.d.sZj, "onMisscMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(127832);
        }

        public final void fF(List<MultiTalkGroup> list) {
            AppMethodBeat.i(127833);
            c.i("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
            if (e.this.AJd != null) {
                e.this.AJd;
            }
            AppMethodBeat.o(127833);
        }

        public final void dTo() {
            AppMethodBeat.i(127834);
            c.w("TalkRoomSdkApi", "onSendMsgSucc");
            if (e.this.AJd != null) {
                e.this.AJd;
            }
            AppMethodBeat.o(127834);
        }

        public final void H(String str, byte[] bArr) {
            int i = 0;
            AppMethodBeat.i(127835);
            String str2 = "TalkRoomSdkApi";
            Object[] objArr = new Object[4];
            objArr[0] = "onRcvMultiTalkMsg groupId: ";
            objArr[1] = str;
            objArr[2] = " datas size: ";
            if (bArr != null) {
                i = bArr.length;
            }
            objArr[3] = Integer.valueOf(i);
            c.w(str2, objArr);
            if (e.this.AJd != null) {
                e.this.AJd;
            }
            AppMethodBeat.o(127835);
        }

        public final void Sn(int i) {
            AppMethodBeat.i(127836);
            c.d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i));
            if (e.this.AJd != null) {
                e.this.AJd.bRM();
            }
            AppMethodBeat.o(127836);
        }

        public final void bRN() {
            AppMethodBeat.i(127837);
            c.d("TalkRoomSdkApi", "onSubscribeLargeVideoSuss");
            if (e.this.AJd != null) {
                e.this.AJd.bRN();
            }
            AppMethodBeat.o(127837);
        }

        public final void cr(List<am> list) {
            AppMethodBeat.i(127838);
            c.d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
            if (e.this.AJd != null) {
                e.this.AJd.cr(list);
            }
            AppMethodBeat.o(127838);
        }

        public final void ze(int i) {
            AppMethodBeat.i(127839);
            c.d("TalkRoomSdkApi", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(i));
            if (e.this.AJd != null) {
                e.this.AJd.ze(i);
            }
            AppMethodBeat.o(127839);
        }
    };
    private final String TAG = "TalkRoomSdkApi";

    public static e dTl() {
        AppMethodBeat.i(127840);
        if (AJe == null) {
            synchronized (e.class) {
                try {
                    if (AJe == null) {
                        AJe = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(127840);
                    }
                }
            }
        }
        e eVar = AJe;
        AppMethodBeat.o(127840);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(127841);
        AppMethodBeat.o(127841);
    }

    public static void jt(Context context) {
        AppMethodBeat.i(127842);
        com.tencent.pb.common.c.d.sZj = context;
        i.dM(context);
        AppMethodBeat.o(127842);
    }

    public final boolean a(a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        AppMethodBeat.i(127843);
        if (com.tencent.pb.common.c.d.sZj == null) {
            c.w("TalkRoomSdkApi", "init fail context: ", com.tencent.pb.common.c.d.sZj);
            AppMethodBeat.o(127843);
            return false;
        }
        try {
            this.AJd = aVar;
            f.a(eVar);
            f dSR = a.dSR();
            dSR.AJK.a(this.AJg);
            f.dPx().Amd = eVar;
            a.dSQ();
            a.dSS();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.tencent.pb.common.c.d.sZj.registerReceiver(this.AJf, intentFilter);
            c.d("TalkRoomSdkApi", "init");
            AppMethodBeat.o(127843);
            return true;
        } catch (Exception e) {
            c.w("TalkRoomSdkApi", "init ", e);
            AppMethodBeat.o(127843);
            return false;
        }
    }

    public final void rm(boolean z) {
        AppMethodBeat.i(127844);
        f dSR = a.dSR();
        c.w("TalkRoomService", "setMute isMute: ", Boolean.valueOf(z));
        dSR.mIsMute = z;
        h.aB(new AnonymousClass14(z));
        AppMethodBeat.o(127844);
    }

    public final void jo(boolean z) {
        boolean jk;
        AppMethodBeat.i(127845);
        a.dSR();
        com.tencent.pb.talkroom.sdk.e dTA = f.dTA();
        if (dTA != null) {
            jk = dTA.jk(z);
        } else {
            jk = false;
        }
        c.d("TalkRoomService", "switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(jk), " realret: ", Boolean.valueOf(f.KU()), " wxCallBack: ", dTA);
        AppMethodBeat.o(127845);
    }

    public final boolean dPP() {
        AppMethodBeat.i(127846);
        try {
            c.dPK();
            c.w("TalkRoomSdkApi", "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", Integer.valueOf(0));
            AppMethodBeat.o(127846);
            return true;
        } catch (Throwable th) {
            c.w("TalkRoomSdkApi", "setOpenLog: ", th);
            AppMethodBeat.o(127846);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(String str, String str2, List<String> list) {
        AppMethodBeat.i(127847);
        f dSR = a.dSR();
        String[] fG = f.fG(list);
        if (fG.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (com.tencent.pb.a.a.a.dPM().hashCode() & CdnLogic.kBizGeneric);
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
            c.w("TalkRoomService", "createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(fG.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null);
            if (!com.tencent.pb.a.a.a.dPN()) {
                c.w("TalkRoomService", "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.dPN()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.dPO()));
                h.a("", str, 0, 0, "create", "req", "false", "noAuth");
            } else if (!com.tencent.pb.common.b.h.isNetworkConnected()) {
                c.w("TalkRoomService", "createTalkRoom isNetworkConnected is false");
                h.Ss(-4003);
                h.a("", str, 0, 0, "create", "req", "false", "noNetwork");
            } else if (dSR.cIJ()) {
                if (dSR.cIJ()) {
                    h.Ss(-4002);
                }
                h.a("", str, 0, 0, "create", "req", "false", "isBusy");
            } else if (TextUtils.isEmpty(str)) {
                c.w("TalkRoomService", "createTalkRoom cliendId is null");
                h.a("", str, 0, 0, "create", "req", "false", "cliendIdnull");
            } else if (j.auS(str)) {
                if (c.dTg().auE(str) == null) {
                    c.dTg().d(str, str2, fG);
                }
                dSR.AJC.reset();
                dSR.ru(false);
                dSR.dTp();
                if (dSR.cEA()) {
                    dSR.AJC.dTC();
                    dSR.neq = str;
                    dSR.AJO = str;
                    dSR.AlR = nextInt;
                    dSR.AJu = str;
                    dSR.setState(1);
                    dSR.sRm = true;
                    a aVar = new a();
                    aVar.groupId = dSR.neq;
                    aVar.AKr = fG;
                    aVar.AKs = null;
                    aVar.AmC = nextInt;
                    aVar.type = 0;
                    aVar.AKt = 0;
                    aVar.AKu = null;
                    aVar.AKv = false;
                    aVar.AKw = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = aVar;
                    dSR.mHandler.removeMessages(2);
                    TalkRoom auE = c.dTg().auE(dSR.neq);
                    if (auE == null) {
                        c.w("TalkRoomManager", "isOnlyMySelfInGroup talkroom is null");
                    } else {
                        List dSX = auE.dSX();
                        if (dSX == null || dSX.size() != 1) {
                            c.w("TalkRoomManager", "isOnlyMySelfInGroup TalkRoomMember list is not match");
                        } else {
                            d dVar = (d) dSX.get(0);
                            if (dVar == null) {
                                c.w("TalkRoomManager", "isOnlyMySelfInGroup talkRoomMember is null");
                            } else {
                                boolean dTk = dVar.dTk();
                                c.w("TalkRoomManager", "isOnlyMySelfInGroup ret: ", Boolean.valueOf(dTk));
                            }
                        }
                    }
                    dSR.mHandler.sendMessage(obtain);
                    dSR.AJQ = true;
                    c.w("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.dPM(), " usrnameList: ", list);
                    if (str == null) {
                        AppMethodBeat.o(127847);
                        return true;
                    }
                    AppMethodBeat.o(127847);
                    return false;
                }
                c.w("TalkRoomService", "createTalkRoom initEngine fail");
                h.a("", str, 0, 0, "create", "req", "false", "initEnginefail");
                dSR.ru(false);
            } else {
                c.w("TalkRoomService", "createTalkRoom groupId is not cliend id: ", str);
                h.a("", str, 0, 0, "create", "req", "false", "isnotcliendId");
            }
        }
        str = null;
        c.w("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.dPM(), " usrnameList: ", list);
        if (str == null) {
        }
    }

    public final boolean A(String str, int i, String str2) {
        AppMethodBeat.i(127848);
        f dSR = a.dSR();
        c.w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(i), " ret: ", dSR.a(str, dSR.nCF, dSR.sZg, i, 1, str2));
        if (dSR.a(str, dSR.nCF, dSR.sZg, i, 1, str2) == b.OK) {
            AppMethodBeat.o(127848);
            return true;
        }
        AppMethodBeat.o(127848);
        return false;
    }

    public final boolean a(String str, int i, long j, int i2, String str2) {
        AppMethodBeat.i(127849);
        c.w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " wxGroupId: ", str2, " ret: ", a.dSR().a(str, i, j, i2, 100, str2));
        if (a.dSR().a(str, i, j, i2, 100, str2) == b.OK) {
            AppMethodBeat.o(127849);
            return true;
        }
        AppMethodBeat.o(127849);
        return false;
    }

    public final boolean B(String str, List<String> list) {
        AppMethodBeat.i(127850);
        if (g.iA(str, a.dSR().neq)) {
            boolean z;
            f dSR = a.dSR();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(dSR.nCF);
            objArr[3] = Long.valueOf(dSR.sZg);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            c.w(str2, objArr);
            dSR.AJQ = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (com.tencent.pb.common.b.h.isNetworkConnected()) {
                String[] fG = f.fG(list);
                if (fG.length <= 0) {
                    c.w("TalkRoomService", "addTalkRoomMember users is null");
                    z = false;
                } else {
                    z = com.tencent.pb.common.b.e.dPu().a(new com.tencent.wecall.talkroom.a.b(str, dSR.nCF, dSR.sZg, fG));
                    dSR.AJC.aa("add", "req", String.valueOf(z), String.valueOf(dSR.state));
                }
            } else {
                c.w("TalkRoomService", "addTalkRoomMember isNetworkConnected is false");
                z = false;
            }
            c.w("TalkRoomSdkApi", "addMultiTalkMember ret: ", Boolean.valueOf(z));
            AppMethodBeat.o(127850);
            return z;
        }
        c.w("TalkRoomSdkApi", "addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.dSR().neq);
        AppMethodBeat.o(127850);
        return false;
    }

    public final boolean Sa(String str) {
        AppMethodBeat.i(127851);
        if (g.iA(str, a.dSR().neq)) {
            int i = a.dSR().nCF;
            long j = a.dSR().sZg;
            boolean az = a.dSR().az(str, 1, 100);
            c.w("TalkRoomSdkApi", "exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            AppMethodBeat.o(127851);
            return az;
        }
        c.w("TalkRoomSdkApi", "exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.dSR().neq);
        if (a.dSR().auN(str)) {
            e auM = a.dSR().auM(str);
            a.dSR().a(str, auM == null ? 0 : auM.nwu, auM == null ? 0 : auM.nwv, 1);
        }
        AppMethodBeat.o(127851);
        return false;
    }

    public final List<String> atK(String str) {
        AppMethodBeat.i(127852);
        if (g.iA(str, a.dSR().neq)) {
            TalkRoom auE = c.dTg().auE(str);
            if (auE == null) {
                c.w("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
                AppMethodBeat.o(127852);
                return null;
            }
            List<d> dSY = auE.dSY();
            ArrayList arrayList = new ArrayList();
            for (d dVar : dSY) {
                if (dVar != null) {
                    int i;
                    f dSR = a.dSR();
                    int dTj = dVar.dTj();
                    if (dSR.AJD != null) {
                        b bVar = dSR.AJD;
                        i = (!com.tencent.pb.common.a.a.Alr || bVar.AIV == null) ? 0 : bVar.AIV.GetVoiceActivity(dTj) == 1 ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(dVar.dTi());
                    }
                }
            }
            AppMethodBeat.o(127852);
            return arrayList;
        }
        c.w("TalkRoomSdkApi", "getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.dSR().neq);
        AppMethodBeat.o(127852);
        return null;
    }

    public final boolean e(int i, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(127853);
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
        c.w(str, objArr);
        if (i == 0) {
            f.dPx().s(i2, bArr);
        } else {
            f dPx = f.dPx();
            f.a QW = dPx.QW(i2);
            if (QW != null) {
                c.w("NETCMD", "CLTRCV FAIL", Integer.valueOf(i2), QW.Amg, Integer.valueOf(1), Integer.valueOf(i));
                dPx.a(QW, -1, null);
            }
        }
        AppMethodBeat.o(127853);
        return true;
    }

    public final boolean ck(byte[] bArr) {
        AppMethodBeat.i(127854);
        f.dPx();
        c.w("TalkRoomSdkApi", "handleMultiTalkNotify ret: ", Integer.valueOf(f.cj(bArr)));
        if (f.cj(bArr) == 0) {
            AppMethodBeat.o(127854);
            return true;
        }
        AppMethodBeat.o(127854);
        return false;
    }

    public final boolean rn(boolean z) {
        AppMethodBeat.i(127855);
        c.w("TalkRoomSdkApi", "holadMultiTalk isHold", Boolean.valueOf(z));
        f dSR;
        if (z) {
            dSR = a.dSR();
            c.d("TalkRoomService", "syscall", "startHoldOn");
            dSR.AJY = true;
            dSR.rv(false);
            h.aB(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(127957);
                    synchronized (g.this.callbacks) {
                        try {
                            for (a dTm : g.this.callbacks) {
                                dTm.dTm();
                            }
                        } finally {
                            AppMethodBeat.o(127957);
                        }
                    }
                }
            });
        } else {
            dSR = a.dSR();
            c.d("TalkRoomService", "syscall", "endHoldOn");
            dSR.AJY = false;
            dSR.dTq();
            if (dSR.cIJ() && dSR.nME) {
                dSR.rv(true);
                h.aB(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127959);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a dTn : g.this.callbacks) {
                                    dTn.dTn();
                                }
                            } finally {
                                AppMethodBeat.o(127959);
                            }
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(127855);
        return true;
    }

    public final void bR(int i, String str) {
        AppMethodBeat.i(127857);
        com.tencent.pb.a.a.a.QX(i);
        com.tencent.pb.a.a.a.atJ(str);
        c.w("TalkRoomSdkApi", "setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str);
        AppMethodBeat.o(127857);
    }

    public final boolean zf(int i) {
        AppMethodBeat.i(127858);
        if (a.dSR().cIJ()) {
            c.d("TalkRoomSdkApi", "switchMultiTalkVideo action: ", Integer.valueOf(i));
            f dSR = a.dSR();
            if (TextUtils.isEmpty(dSR.neq)) {
                c.w("TalkRoomService", "switchMultiTalkVideo mGroupId is null");
                AppMethodBeat.o(127858);
                return false;
            }
            dSR.AJB = i;
            c.d("TalkRoomService", "switchMultiTalkVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.dPu().a(new l(dSR.neq, dSR.nCF, dSR.sZg, i))));
            AppMethodBeat.o(127858);
            return com.tencent.pb.common.b.e.dPu().a(new l(dSR.neq, dSR.nCF, dSR.sZg, i));
        }
        c.w("TalkRoomSdkApi", "switchMultiTalkVideo isWorking is false");
        AppMethodBeat.o(127858);
        return false;
    }

    public final boolean Sj(String str) {
        AppMethodBeat.i(127859);
        if (a.dSR().cIJ()) {
            c.d("TalkRoomSdkApi", "subscribeLargeVideo ownerUserName: ", str);
            f dSR = a.dSR();
            if (TextUtils.isEmpty(dSR.neq)) {
                c.w("TalkRoomService", "subscribeLargeVideo mGroupId null ");
                AppMethodBeat.o(127859);
                return false;
            }
            c.d("TalkRoomService", "subscribeLargeVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.dPu().a(new k(dSR.neq, dSR.nCF, dSR.sZg, str))));
            AppMethodBeat.o(127859);
            return com.tencent.pb.common.b.e.dPu().a(new k(dSR.neq, dSR.nCF, dSR.sZg, str));
        }
        c.w("TalkRoomSdkApi", "subscribeLargeVideo isWorking is false");
        AppMethodBeat.o(127859);
        return false;
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(127860);
        int a = a.dSR().a(bArr, s, i, i2, i3, i4);
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
        c.d(str, objArr);
        AppMethodBeat.o(127860);
        return a;
    }

    public final com.tencent.pb.talkroom.sdk.f D(int[] iArr) {
        int i = 0;
        AppMethodBeat.i(127861);
        com.tencent.pb.talkroom.sdk.f D = a.dSR().D(iArr);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[4];
        objArr[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " MultiTalkVideoDecodeInfo: ";
        objArr[3] = D;
        c.d(str, objArr);
        AppMethodBeat.o(127861);
        return D;
    }

    public final com.tencent.pb.talkroom.sdk.g a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        AppMethodBeat.i(127862);
        com.tencent.pb.talkroom.sdk.g a = a.dSR().a(bArr, i, i2, i3, i4, iArr);
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
        c.d(str, objArr);
        AppMethodBeat.o(127862);
        return a;
    }

    public final int setAppCmd(int i, byte[] bArr, int i2) {
        int i3 = -1;
        AppMethodBeat.i(127863);
        f dSR = a.dSR();
        if (dSR.AJD == null) {
            c.w("TalkRoomService", "setAppCmd type: ", Integer.valueOf(i), " engine is null");
        } else {
            b bVar = dSR.AJD;
            if (bArr == null || bVar.AIV == null) {
                c.w("simon:TalkRoomContext", "steve:setAppCmd null, params:", bArr, ", engine:", bVar.AIV);
            } else {
                i3 = bVar.AIV.setAppCmd(i, bArr, i2);
            }
        }
        c.d("TalkRoomSdkApi", "setAppCmd type: ", Integer.valueOf(i), " paramLen: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        AppMethodBeat.o(127863);
        return i3;
    }

    public final String dPQ() {
        AppMethodBeat.i(127856);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(com.tencent.pb.a.a.a.dPM());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        c.w("TalkRoomSdkApi", "genMultiTalkClientId clientId: ", stringBuilder.toString());
        AppMethodBeat.o(127856);
        return stringBuilder.toString();
    }
}
