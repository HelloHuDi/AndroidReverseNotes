package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    at AIT;
    Map<String, d> AIU = new ConcurrentHashMap();

    static class a implements Comparator<d> {
        a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    }

    public static TalkRoom a(String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        AppMethodBeat.i(127767);
        c.d("tagorewang:TalkRoom:create", "create groupId: ", str, " tmpId: ", str2);
        TalkRoom talkRoom = new TalkRoom(str, num, atVar);
        talkRoom.auC(str2);
        Sl(i);
        nG(j);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int length2 = awVarArr == null ? 0 : awVarArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            av avVar = avVarArr[i2];
            if (avVar == null) {
                c.w("tagorewang:TalkRoom:create", "null member info, index: ", Integer.valueOf(i2));
            } else {
                aw awVar = null;
                for (int i3 = 0; i3 != length2; i3++) {
                    awVar = awVarArr[i3];
                    if (awVar != null && awVar.vzt == avVar.vzt) {
                        c.d("tagorewang:TalkRoom:create", "member info: ", avVar, " profile: ", awVar);
                        break;
                    }
                    awVar = null;
                }
                talkRoom.a(new d(avVar, awVar));
            }
        }
        c.d("tagorewang:TalkRoom:create", "did create");
        AppMethodBeat.o(127767);
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        AppMethodBeat.i(127768);
        if (talkRoom == null) {
            c.w("tagorewang:TalkRoom:update", "updateAll null");
            AppMethodBeat.o(127768);
            return null;
        }
        c.d("tagorewang:TalkRoom:update", "updateAll groupId: ", str, " tmpId: ", str2);
        talkRoom.b(str, num);
        talkRoom.auC(str2);
        Sl(i);
        nG(j);
        talkRoom.b(atVar);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int i2;
        if (awVarArr == null) {
            i2 = 0;
        } else {
            i2 = awVarArr.length;
        }
        if (length == 0 && i2 == 0) {
            c.w("tagorewang:TalkRoom:update", "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array.");
            AppMethodBeat.o(127768);
            return talkRoom;
        }
        HashSet<String> hashSet = new HashSet(talkRoom.AIU.keySet());
        hashSet.remove(com.tencent.pb.a.a.a.dPM());
        for (int i3 = 0; i3 != length; i3++) {
            av avVar = avVarArr[i3];
            if (avVar == null) {
                c.w("tagorewang:TalkRoom:update", "null member info, index: ", Integer.valueOf(i3));
            } else {
                d auD = talkRoom.auD(avVar.Aop);
                if (auD == null) {
                    c.d("tagorewang:TalkRoom:update", "add new member");
                    auD = new d(avVar);
                    talkRoom.a(auD);
                } else {
                    auD.a(avVar);
                }
                hashSet.remove(auD.dTi());
            }
        }
        for (String str3 : hashSet) {
            c.d("tagorewang:TalkRoom:update", "keyset", str3);
            c.d("tagorewang:TalkRoom", "remove", talkRoom.AIU.remove(str3));
        }
        if (hashSet.size() > 0) {
            c.w("tagorewang:TalkRoom:update", "updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size()));
        }
        c.d("tagorewang:TalkRoom:update", "did updateAll");
        AppMethodBeat.o(127768);
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, at atVar) {
        AppMethodBeat.i(127769);
        b(str, num);
        b(atVar);
        AppMethodBeat.o(127769);
    }

    public static boolean dST() {
        return false;
    }

    private void auC(String str) {
        AppMethodBeat.i(127770);
        if (j.auS(str)) {
            this.Aqd = str;
        }
        AppMethodBeat.o(127770);
    }

    public final int dSU() {
        return this.AlR == 0 ? 0 : this.AlR;
    }

    private void b(String str, Integer num) {
        AppMethodBeat.i(127771);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(127771);
            return;
        }
        if (j.auS(str)) {
            this.Aqd = str;
        } else {
            this.Aqc = str;
        }
        if (num != null) {
            this.AlR = num.intValue();
        }
        AppMethodBeat.o(127771);
    }

    public static int dSV() {
        AppMethodBeat.i(127772);
        int dTH = j.dTH();
        AppMethodBeat.o(127772);
        return dTH;
    }

    private static void Sl(int i) {
        AppMethodBeat.i(127773);
        c.d("tagorewang:TalkRoom", "setRoomId: ", Integer.valueOf(i));
        AppMethodBeat.o(127773);
    }

    public static long cKa() {
        AppMethodBeat.i(127774);
        long dTI = j.dTI();
        AppMethodBeat.o(127774);
        return dTI;
    }

    private static void nG(long j) {
        AppMethodBeat.i(127775);
        c.d("tagorewang:TalkRoom", "setRoomKey: ", Long.valueOf(j));
        AppMethodBeat.o(127775);
    }

    private static t a(at atVar) {
        AppMethodBeat.i(127776);
        if (atVar != null) {
            try {
                if (atVar.AoM != null) {
                    byte[] bArr = atVar.AoM;
                    t tVar = (t) e.a(new t(), bArr, bArr.length);
                    AppMethodBeat.o(127776);
                    return tVar;
                }
            } catch (Exception e) {
                c.w("tagorewang:TalkRoom", "toPlayItemInfo err: ", e);
                AppMethodBeat.o(127776);
                return null;
            }
        }
        AppMethodBeat.o(127776);
        return null;
    }

    private String dSW() {
        String stringBuilder;
        AppMethodBeat.i(127777);
        if (this.AIT == null || TextUtils.isEmpty(this.AIT.name)) {
            ArrayList arrayList = new ArrayList(this.AIU.values());
            arrayList.remove(this.AIU.get(com.tencent.pb.a.a.a.dPM()));
            List fE = fE(arrayList);
            c.i("tagorewang:TalkRoom", "getOtherMembers size: ", Integer.valueOf(fE.size()), " all size: ", Integer.valueOf(this.AIU.size()));
            StringBuilder stringBuilder2 = new StringBuilder();
            if (fE != null) {
                int size = fE.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder2.append(((d) fE.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder2.append(12289);
                        }
                    } catch (Exception e) {
                        c.w("tagorewang:TalkRoom", "updateRoomNameIfEmpty err and continue: ", e);
                    }
                }
            }
            if (stringBuilder2.toString().length() > 0) {
                stringBuilder = stringBuilder2.toString();
                AppMethodBeat.o(127777);
                return stringBuilder;
            }
        }
        if (this.AIT == null || TextUtils.isEmpty(this.AIT.name)) {
            c.w("tagorewang:TalkRoom", "updateRoomNameIfEmpty still empty, groupId: ", this.Aqc, " tmpId: ", this.Aqd);
            AppMethodBeat.o(127777);
            return null;
        }
        stringBuilder = this.AIT.name;
        AppMethodBeat.o(127777);
        return stringBuilder;
    }

    private void b(at atVar) {
        AppMethodBeat.i(127778);
        if (atVar == null) {
            AppMethodBeat.o(127778);
            return;
        }
        try {
            this.Aqe = atVar.AoT;
            this.Aqf = atVar.AoS;
            if (!(this.AIT == null || atVar.cAO == 0)) {
                t a = a(atVar);
                t a2 = a(this.AIT);
                if (a == null) {
                    atVar.AoM = this.AIT.AoM;
                } else if (a.Anu == 0 || a.Anu != a2.Anu) {
                    c.w("tagorewang:TalkRoom", "setRoomInfo bad id: ", Integer.valueOf(a2.Anu), " -> ", Integer.valueOf(a.Anu));
                    atVar.AoM = this.AIT.AoM;
                }
            }
            this.AIT = atVar;
            AppMethodBeat.o(127778);
        } catch (Exception e) {
            c.w("tagorewang:TalkRoom", "setRoomInfo assert failed: ", e);
            this.AIT = atVar;
            AppMethodBeat.o(127778);
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(127779);
        this.AIU.put(dVar.dTi(), dVar);
        AppMethodBeat.o(127779);
    }

    public final List<d> dSY() {
        AppMethodBeat.i(127781);
        ArrayList arrayList = new ArrayList(this.AIU.values());
        AppMethodBeat.o(127781);
        return arrayList;
    }

    private static List<d> fE(List<d> list) {
        AppMethodBeat.i(127782);
        if (list.isEmpty()) {
            AppMethodBeat.o(127782);
        } else {
            Collections.sort(list, new a());
            AppMethodBeat.o(127782);
        }
        return list;
    }

    public final d auD(String str) {
        AppMethodBeat.i(127783);
        d dVar = (d) this.AIU.get(str);
        AppMethodBeat.o(127783);
        return dVar;
    }

    public final d dSZ() {
        AppMethodBeat.i(127784);
        d dVar = (d) this.AIU.get(com.tencent.pb.a.a.a.dPM());
        AppMethodBeat.o(127784);
        return dVar;
    }

    public final List<av> dTa() {
        AppMethodBeat.i(127785);
        List dTb = dTb();
        AppMethodBeat.o(127785);
        return dTb;
    }

    public final List<av> dTb() {
        AppMethodBeat.i(127786);
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.AIU.entrySet()) {
            arrayList.add(((d) value.getValue()).AJb);
        }
        AppMethodBeat.o(127786);
        return arrayList;
    }

    public String toString() {
        String dSW;
        AppMethodBeat.i(127787);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("groupId: ").append(this.Aqc);
            stringBuilder.append(" tmpId: ").append(this.Aqd);
            stringBuilder.append(" routeId: ").append(this.AlR);
            StringBuilder append = stringBuilder.append(" room name: ");
            if (this.AIT == null || TextUtils.isEmpty(this.AIT.name)) {
                dSW = dSW();
            } else {
                dSW = this.AIT.name;
            }
            append.append(dSW);
        } catch (Exception e) {
            stringBuilder.append(" broken by " + e.getMessage());
        }
        dSW = stringBuilder.toString();
        AppMethodBeat.o(127787);
        return dSW;
    }

    public final MultiTalkGroup dTc() {
        AppMethodBeat.i(127788);
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.Aqc = this.Aqc;
        multiTalkGroup.Aqd = this.Aqd;
        multiTalkGroup.AlR = this.AlR;
        multiTalkGroup.Aqe = this.Aqe;
        multiTalkGroup.Aqf = this.Aqf;
        ArrayList arrayList = new ArrayList();
        List<d> dSY = dSY();
        if (dSY.size() > 0) {
            for (d dVar : dSY) {
                if (dVar != null) {
                    String str;
                    int i;
                    int i2;
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.Aqh = dVar.dTi();
                    if (dVar.AJb != null) {
                        str = dVar.AJb.Apu;
                    } else {
                        str = "";
                    }
                    multiTalkGroupMember.Aqi = str;
                    if (dVar.AJb != null) {
                        i = dVar.AJb.boZ;
                    } else {
                        i = 0;
                    }
                    multiTalkGroupMember.boZ = i;
                    multiTalkGroupMember.status = dVar.getState();
                    if (dVar.AJb == null || dVar.AJb.Api == 0) {
                        i2 = 0;
                    } else {
                        i2 = dVar.AJb.Api;
                    }
                    multiTalkGroupMember.Api = i2;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.Aqg = arrayList;
        AppMethodBeat.o(127788);
        return multiTalkGroup;
    }

    public final List<d> dSX() {
        AppMethodBeat.i(127780);
        List fE = fE(new ArrayList(this.AIU.values()));
        d dSZ = dSZ();
        fE.remove(dSZ);
        fE.add(0, dSZ);
        dSZ = (d) this.AIU.get(Integer.valueOf(90100));
        if (dSZ != null) {
            fE.remove(dSZ);
            fE.add(dSZ);
        }
        AppMethodBeat.o(127780);
        return fE;
    }
}
