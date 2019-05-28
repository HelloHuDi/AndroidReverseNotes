package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean AIW = false;
    private static final e<c> AIX = new e<c>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(127794);
            c cVar = new c();
            AppMethodBeat.o(127794);
            return cVar;
        }
    };
    private static boolean DEBUG = false;
    private Map<String, TalkRoom> AIY;
    private Map<String, String> AIZ;
    g AJa;

    /* synthetic */ c(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(127810);
        AppMethodBeat.o(127810);
    }

    public static c dTg() {
        AppMethodBeat.i(127795);
        c cVar = (c) AIX.get();
        AppMethodBeat.o(127795);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(127796);
        this.AIY = new HashMap();
        this.AIZ = new HashMap();
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncLoadCache");
        AppMethodBeat.o(127796);
    }

    public final boolean cp(String str, boolean z) {
        AppMethodBeat.i(127797);
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            AppMethodBeat.o(127797);
            return false;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            AppMethodBeat.o(127797);
            return false;
        }
        List<d> dSX = auE.dSX();
        if (dSX == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            AppMethodBeat.o(127797);
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : dSX) {
            if (dVar != null) {
                boolean z4;
                dVar.dTi();
                TalkRoom.dST();
                if (dVar.getState() != 10) {
                    z4 = z2;
                } else if (dVar.dTk()) {
                    z4 = true;
                } else {
                    z4 = z2;
                    z3 = true;
                }
                if (z && z3) {
                    AppMethodBeat.o(127797);
                    return true;
                } else if (z4 && z3) {
                    com.tencent.pb.common.c.c.w("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    AppMethodBeat.o(127797);
                    return true;
                } else {
                    z2 = z4;
                }
            }
        }
        AppMethodBeat.o(127797);
        return false;
    }

    public final TalkRoom auE(String str) {
        AppMethodBeat.i(127798);
        TalkRoom talkRoom = (TalkRoom) this.AIY.get(str);
        if (talkRoom == null && j.auS(str)) {
            talkRoom = (TalkRoom) this.AIY.get((String) this.AIZ.get(str));
        }
        AppMethodBeat.o(127798);
        return talkRoom;
    }

    public final void auF(String str) {
        AppMethodBeat.i(127799);
        try {
            TalkRoom auE = auE(str);
            if (auE == null) {
                com.tencent.pb.common.c.c.w("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
                AppMethodBeat.o(127799);
                return;
            }
            String str2;
            d auD = auE.auD(a.dPM());
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
            com.tencent.pb.common.c.c.d(str3, objArr);
            dTh();
            AppMethodBeat.o(127799);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "handleRoomExit: ", th);
            AppMethodBeat.o(127799);
        }
    }

    public final int auG(String str) {
        AppMethodBeat.i(127800);
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getSelfMemberId invalid groupId");
            AppMethodBeat.o(127800);
            return -1;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            AppMethodBeat.o(127800);
            return -1;
        }
        d auD = auE.auD(a.dPM());
        if (auD != null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.dPM(), " memberId: ", Integer.valueOf(auD.dTj()));
            int dTj = auD.dTj();
            AppMethodBeat.o(127800);
            return dTj;
        }
        com.tencent.pb.common.c.c.w("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        AppMethodBeat.o(127800);
        return -1;
    }

    public final int auH(String str) {
        AppMethodBeat.i(127801);
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            AppMethodBeat.o(127801);
            return 0;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
            AppMethodBeat.o(127801);
            return 0;
        }
        int dSU = auE.dSU();
        AppMethodBeat.o(127801);
        return dSU;
    }

    public final boolean d(String str, String str2, String... strArr) {
        AppMethodBeat.i(127802);
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!j.auS(str)) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            AppMethodBeat.o(127802);
            return false;
        } else if (strArr == null || strArr.length == 0) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "newTmpGroup empty uuid array");
            AppMethodBeat.o(127802);
            return false;
        } else {
            try {
                at atVar = new at();
                atVar.cAO = 0;
                atVar.AoT = str2;
                atVar.AoS = a.dPM();
                TalkRoom talkRoom = new TalkRoom(str, null, atVar);
                int length = strArr.length;
                for (int i = 0; i != length; i++) {
                    String str3 = strArr[i];
                    av avVar = new av();
                    avVar.Aop = str3;
                    avVar.Apu = a.dPM();
                    avVar.status = 20;
                    avVar.kyZ = -1;
                    avVar.Api = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(avVar, new aw()));
                }
                this.AIY.put(str, talkRoom);
                dTh();
                AppMethodBeat.o(127802);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("TalkRoomManager", "newTmpGroup err: ", e);
                AppMethodBeat.o(127802);
                return false;
            }
        }
    }

    public final boolean a(String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr, boolean z, boolean z2) {
        CharSequence charSequence;
        AppMethodBeat.i(127803);
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z2));
        if (TextUtils.isEmpty(str)) {
            charSequence = str2;
        } else {
            Object charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            AppMethodBeat.o(127803);
            return false;
        }
        if (j.auS(str2)) {
            this.AIZ.put(str2, charSequence2);
        }
        TalkRoom talkRoom = (TalkRoom) this.AIY.get(charSequence2);
        if (TextUtils.isEmpty(str2) || talkRoom == null || atVar == null || atVar.cAO == 100) {
            if (talkRoom == null) {
                if (j.auS(str2)) {
                    talkRoom = (TalkRoom) this.AIY.get(str2);
                }
                if (talkRoom != null) {
                    this.AIY.put(charSequence2, talkRoom);
                }
            }
            if (talkRoom != null && z2) {
                int dTH = j.dTH();
                long dTI = j.dTI();
                com.tencent.pb.common.c.c.d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(dTH), " and roomKey: ", Long.valueOf(j));
                if (dTH != 0 && dTH != i) {
                    com.tencent.pb.common.c.c.w("TalkRoomManager", "diff roomId: ", Integer.valueOf(dTH), " -> ", Integer.valueOf(i));
                    AppMethodBeat.o(127803);
                    return false;
                } else if (!(0 == dTI || dTI == j)) {
                    com.tencent.pb.common.c.c.w("TalkRoomManager", "diff roomKey: ", Long.valueOf(dTI), " -> ", Long.valueOf(j));
                    AppMethodBeat.o(127803);
                    return false;
                }
            }
            if (talkRoom == null) {
                com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup create groupId: ", charSequence2);
                this.AIY.put(charSequence2, TalkRoom.a(charSequence2, str2, num, i, j, atVar, avVarArr, awVarArr));
            } else {
                com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup update groupId: ", charSequence2);
                TalkRoom.a(talkRoom, charSequence2, str2, num, i, j, atVar, avVarArr, awVarArr);
            }
            if (this.AJa != null && z) {
                this.AJa.g(auL(charSequence2));
            }
            dTh();
            AppMethodBeat.o(127803);
            return true;
        }
        com.tencent.pb.common.c.c.w("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
        AppMethodBeat.o(127803);
        return false;
    }

    private static void dTh() {
        AppMethodBeat.i(127804);
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncWriteBackCache");
        AppMethodBeat.o(127804);
    }

    public final int auI(String str) {
        AppMethodBeat.i(127805);
        TalkRoom auE = auE(str);
        if (auE == null) {
            AppMethodBeat.o(127805);
            return 0;
        }
        com.tencent.pb.common.c.c.d("TalkRoomManager", "getGroupMemberSize groupid: ", str, " size: ", Integer.valueOf(auE.AIU.size()));
        AppMethodBeat.o(127805);
        return auE.AIU.size();
    }

    public final String k(String str, int i, long j) {
        AppMethodBeat.i(127806);
        if (i == 0 && j == 0) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            AppMethodBeat.o(127806);
            return null;
        }
        TalkRoom auE = auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
            AppMethodBeat.o(127806);
            return null;
        }
        d auD = auE.auD(a.dPM());
        if (auD == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
            AppMethodBeat.o(127806);
            return null;
        }
        av avVar = auD.AJb;
        if (avVar == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
            AppMethodBeat.o(127806);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",");
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(j);
        stringBuffer.append(",");
        stringBuffer.append(avVar.Apk);
        com.tencent.pb.common.c.c.w("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(127806);
        return stringBuffer2;
    }

    public static boolean auJ(String str) {
        AppMethodBeat.i(127807);
        TalkRoom auE = dTg().auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "isMySelfExit talkRoom is null");
            AppMethodBeat.o(127807);
            return true;
        }
        d dSZ = auE.dSZ();
        if (dSZ == null || 20 == dSZ.getState()) {
            AppMethodBeat.o(127807);
            return true;
        }
        AppMethodBeat.o(127807);
        return false;
    }

    public static int auK(String str) {
        AppMethodBeat.i(127808);
        TalkRoom auE = dTg().auE(str);
        if (auE == null) {
            com.tencent.pb.common.c.c.w("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            AppMethodBeat.o(127808);
            return 0;
        }
        int i;
        d dSZ = auE.dSZ();
        if (dSZ == null || dSZ.AJb == null) {
            i = 0;
        } else {
            i = dSZ.AJb.boZ;
        }
        com.tencent.pb.common.c.c.w("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i));
        AppMethodBeat.o(127808);
        return i;
    }

    public final MultiTalkGroup auL(String str) {
        AppMethodBeat.i(127809);
        TalkRoom auE = auE(str);
        if (auE == null) {
            AppMethodBeat.o(127809);
            return null;
        }
        MultiTalkGroup dTc = auE.dTc();
        AppMethodBeat.o(127809);
        return dTc;
    }
}
