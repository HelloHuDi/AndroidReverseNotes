package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C40955e;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24191at;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24194aw;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.wecall.talkroom.model.c */
public final class C6001c {
    public static boolean AIW = false;
    private static final C40955e<C6001c> AIX = new C60021();
    private static boolean DEBUG = false;
    private Map<String, TalkRoom> AIY;
    private Map<String, String> AIZ;
    C6006g AJa;

    /* renamed from: com.tencent.wecall.talkroom.model.c$1 */
    static class C60021 extends C40955e<C6001c> {
        C60021() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo13134mG() {
            AppMethodBeat.m2504i(127794);
            C6001c c6001c = new C6001c();
            AppMethodBeat.m2505o(127794);
            return c6001c;
        }
    }

    /* synthetic */ C6001c(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(127810);
        AppMethodBeat.m2505o(127810);
    }

    public static C6001c dTg() {
        AppMethodBeat.m2504i(127795);
        C6001c c6001c = (C6001c) AIX.get();
        AppMethodBeat.m2505o(127795);
        return c6001c;
    }

    private C6001c() {
        AppMethodBeat.m2504i(127796);
        this.AIY = new HashMap();
        this.AIZ = new HashMap();
        C44443c.m80389d("TalkRoomManager", "asyncLoadCache");
        AppMethodBeat.m2505o(127796);
    }

    /* renamed from: cp */
    public final boolean mo13131cp(String str, boolean z) {
        AppMethodBeat.m2504i(127797);
        if (TextUtils.isEmpty(str)) {
            C44443c.m80392w("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            AppMethodBeat.m2505o(127797);
            return false;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            AppMethodBeat.m2505o(127797);
            return false;
        }
        List<C6003d> dSX = auE.dSX();
        if (dSX == null) {
            C44443c.m80392w("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            AppMethodBeat.m2505o(127797);
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (C6003d c6003d : dSX) {
            if (c6003d != null) {
                boolean z4;
                c6003d.dTi();
                TalkRoom.dST();
                if (c6003d.getState() != 10) {
                    z4 = z2;
                } else if (c6003d.dTk()) {
                    z4 = true;
                } else {
                    z4 = z2;
                    z3 = true;
                }
                if (z && z3) {
                    AppMethodBeat.m2505o(127797);
                    return true;
                } else if (z4 && z3) {
                    C44443c.m80392w("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    AppMethodBeat.m2505o(127797);
                    return true;
                } else {
                    z2 = z4;
                }
            }
        }
        AppMethodBeat.m2505o(127797);
        return false;
    }

    public final TalkRoom auE(String str) {
        AppMethodBeat.m2504i(127798);
        TalkRoom talkRoom = (TalkRoom) this.AIY.get(str);
        if (talkRoom == null && C46825j.auS(str)) {
            talkRoom = (TalkRoom) this.AIY.get((String) this.AIZ.get(str));
        }
        AppMethodBeat.m2505o(127798);
        return talkRoom;
    }

    public final void auF(String str) {
        AppMethodBeat.m2504i(127799);
        try {
            TalkRoom auE = auE(str);
            if (auE == null) {
                C44443c.m80392w("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
                AppMethodBeat.m2505o(127799);
                return;
            }
            String str2;
            C6003d auD = auE.auD(C36407a.dPM());
            if (auD != null) {
                auD.AJb.status = 20;
                auD.AJb.kyZ = -1;
            }
            String str3 = "tagorewang:TalkRoom";
            Object[] objArr = new Object[2];
            objArr[0] = "resetRoomTempInfo groupId: ";
            if (auE.Aqc == null) {
                str2 = "";
            } else {
                str2 = auE.Aqc;
            }
            objArr[1] = str2;
            C44443c.m80389d(str3, objArr);
            C6001c.dTh();
            AppMethodBeat.m2505o(127799);
        } catch (Throwable th) {
            C44443c.m80392w("TalkRoomManager", "handleRoomExit: ", th);
            AppMethodBeat.m2505o(127799);
        }
    }

    public final int auG(String str) {
        AppMethodBeat.m2504i(127800);
        if (TextUtils.isEmpty(str)) {
            C44443c.m80392w("TalkRoomManager", "getSelfMemberId invalid groupId");
            AppMethodBeat.m2505o(127800);
            return -1;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            AppMethodBeat.m2505o(127800);
            return -1;
        }
        C6003d auD = auE.auD(C36407a.dPM());
        if (auD != null) {
            C44443c.m80392w("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", C36407a.dPM(), " memberId: ", Integer.valueOf(auD.dTj()));
            int dTj = auD.dTj();
            AppMethodBeat.m2505o(127800);
            return dTj;
        }
        C44443c.m80392w("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        AppMethodBeat.m2505o(127800);
        return -1;
    }

    public final int auH(String str) {
        AppMethodBeat.m2504i(127801);
        if (TextUtils.isEmpty(str)) {
            C44443c.m80392w("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            AppMethodBeat.m2505o(127801);
            return 0;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
            AppMethodBeat.m2505o(127801);
            return 0;
        }
        int dSU = auE.dSU();
        AppMethodBeat.m2505o(127801);
        return dSU;
    }

    /* renamed from: d */
    public final boolean mo13132d(String str, String str2, String... strArr) {
        AppMethodBeat.m2504i(127802);
        C44443c.m80389d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!C46825j.auS(str)) {
            C44443c.m80392w("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            AppMethodBeat.m2505o(127802);
            return false;
        } else if (strArr == null || strArr.length == 0) {
            C44443c.m80392w("TalkRoomManager", "newTmpGroup empty uuid array");
            AppMethodBeat.m2505o(127802);
            return false;
        } else {
            try {
                C24191at c24191at = new C24191at();
                c24191at.cAO = 0;
                c24191at.AoT = str2;
                c24191at.AoS = C36407a.dPM();
                TalkRoom talkRoom = new TalkRoom(str, null, c24191at);
                int length = strArr.length;
                for (int i = 0; i != length; i++) {
                    String str3 = strArr[i];
                    C24193av c24193av = new C24193av();
                    c24193av.Aop = str3;
                    c24193av.Apu = C36407a.dPM();
                    c24193av.status = 20;
                    c24193av.kyZ = -1;
                    c24193av.Api = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.mo50886a(new C6003d(c24193av, new C24194aw()));
                }
                this.AIY.put(str, talkRoom);
                C6001c.dTh();
                AppMethodBeat.m2505o(127802);
                return true;
            } catch (Exception e) {
                C44443c.m80392w("TalkRoomManager", "newTmpGroup err: ", e);
                AppMethodBeat.m2505o(127802);
                return false;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo13124a(String str, String str2, Integer num, int i, long j, C24191at c24191at, C24193av[] c24193avArr, C24194aw[] c24194awArr, boolean z, boolean z2) {
        CharSequence charSequence;
        AppMethodBeat.m2504i(127803);
        C44443c.m80389d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z2));
        if (TextUtils.isEmpty(str)) {
            charSequence = str2;
        } else {
            Object charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            C44443c.m80392w("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            AppMethodBeat.m2505o(127803);
            return false;
        }
        if (C46825j.auS(str2)) {
            this.AIZ.put(str2, charSequence2);
        }
        TalkRoom talkRoom = (TalkRoom) this.AIY.get(charSequence2);
        if (TextUtils.isEmpty(str2) || talkRoom == null || c24191at == null || c24191at.cAO == 100) {
            if (talkRoom == null) {
                if (C46825j.auS(str2)) {
                    talkRoom = (TalkRoom) this.AIY.get(str2);
                }
                if (talkRoom != null) {
                    this.AIY.put(charSequence2, talkRoom);
                }
            }
            if (talkRoom != null && z2) {
                int dTH = C46825j.dTH();
                long dTI = C46825j.dTI();
                C44443c.m80389d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(dTH), " and roomKey: ", Long.valueOf(j));
                if (dTH != 0 && dTH != i) {
                    C44443c.m80392w("TalkRoomManager", "diff roomId: ", Integer.valueOf(dTH), " -> ", Integer.valueOf(i));
                    AppMethodBeat.m2505o(127803);
                    return false;
                } else if (!(0 == dTI || dTI == j)) {
                    C44443c.m80392w("TalkRoomManager", "diff roomKey: ", Long.valueOf(dTI), " -> ", Long.valueOf(j));
                    AppMethodBeat.m2505o(127803);
                    return false;
                }
            }
            if (talkRoom == null) {
                C44443c.m80389d("TalkRoomManager", "newOrUpdateGroup create groupId: ", charSequence2);
                this.AIY.put(charSequence2, TalkRoom.m50224a(charSequence2, str2, num, i, j, c24191at, c24193avArr, c24194awArr));
            } else {
                C44443c.m80389d("TalkRoomManager", "newOrUpdateGroup update groupId: ", charSequence2);
                TalkRoom.m50223a(talkRoom, charSequence2, str2, num, i, j, c24191at, c24193avArr, c24194awArr);
            }
            if (this.AJa != null && z) {
                this.AJa.mo13149g(auL(charSequence2));
            }
            C6001c.dTh();
            AppMethodBeat.m2505o(127803);
            return true;
        }
        C44443c.m80392w("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
        AppMethodBeat.m2505o(127803);
        return false;
    }

    private static void dTh() {
        AppMethodBeat.m2504i(127804);
        C44443c.m80389d("TalkRoomManager", "asyncWriteBackCache");
        AppMethodBeat.m2505o(127804);
    }

    public final int auI(String str) {
        AppMethodBeat.m2504i(127805);
        TalkRoom auE = auE(str);
        if (auE == null) {
            AppMethodBeat.m2505o(127805);
            return 0;
        }
        C44443c.m80389d("TalkRoomManager", "getGroupMemberSize groupid: ", str, " size: ", Integer.valueOf(auE.AIU.size()));
        AppMethodBeat.m2505o(127805);
        return auE.AIU.size();
    }

    /* renamed from: k */
    public final String mo13133k(String str, int i, long j) {
        AppMethodBeat.m2504i(127806);
        if (i == 0 && j == 0) {
            C44443c.m80392w("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            AppMethodBeat.m2505o(127806);
            return null;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
            AppMethodBeat.m2505o(127806);
            return null;
        }
        C6003d auD = auE.auD(C36407a.dPM());
        if (auD == null) {
            C44443c.m80392w("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
            AppMethodBeat.m2505o(127806);
            return null;
        }
        C24193av c24193av = auD.AJb;
        if (c24193av == null) {
            C44443c.m80392w("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
            AppMethodBeat.m2505o(127806);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",");
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(j);
        stringBuffer.append(",");
        stringBuffer.append(c24193av.Apk);
        C44443c.m80392w("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(127806);
        return stringBuffer2;
    }

    public static boolean auJ(String str) {
        AppMethodBeat.m2504i(127807);
        TalkRoom auE = C6001c.dTg().auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "isMySelfExit talkRoom is null");
            AppMethodBeat.m2505o(127807);
            return true;
        }
        C6003d dSZ = auE.dSZ();
        if (dSZ == null || 20 == dSZ.getState()) {
            AppMethodBeat.m2505o(127807);
            return true;
        }
        AppMethodBeat.m2505o(127807);
        return false;
    }

    public static int auK(String str) {
        AppMethodBeat.m2504i(127808);
        TalkRoom auE = C6001c.dTg().auE(str);
        if (auE == null) {
            C44443c.m80392w("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            AppMethodBeat.m2505o(127808);
            return 0;
        }
        int i;
        C6003d dSZ = auE.dSZ();
        if (dSZ == null || dSZ.AJb == null) {
            i = 0;
        } else {
            i = dSZ.AJb.boZ;
        }
        C44443c.m80392w("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i));
        AppMethodBeat.m2505o(127808);
        return i;
    }

    public final MultiTalkGroup auL(String str) {
        AppMethodBeat.m2504i(127809);
        TalkRoom auE = auE(str);
        if (auE == null) {
            AppMethodBeat.m2505o(127809);
            return null;
        }
        MultiTalkGroup dTc = auE.dTc();
        AppMethodBeat.m2505o(127809);
        return dTc;
    }
}
