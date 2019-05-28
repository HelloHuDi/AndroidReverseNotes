package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24191at;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24194aw;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24234t;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    C24191at AIT;
    Map<String, C6003d> AIU = new ConcurrentHashMap();

    /* renamed from: com.tencent.wecall.talkroom.model.TalkRoom$a */
    static class C31135a implements Comparator<C6003d> {
        C31135a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static TalkRoom m50224a(String str, String str2, Integer num, int i, long j, C24191at c24191at, C24193av[] c24193avArr, C24194aw[] c24194awArr) {
        AppMethodBeat.m2504i(127767);
        C44443c.m80389d("tagorewang:TalkRoom:create", "create groupId: ", str, " tmpId: ", str2);
        TalkRoom talkRoom = new TalkRoom(str, num, c24191at);
        talkRoom.auC(str2);
        m50221Sl(i);
        m50228nG(j);
        int length = c24193avArr == null ? 0 : c24193avArr.length;
        int length2 = c24194awArr == null ? 0 : c24194awArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            C24193av c24193av = c24193avArr[i2];
            if (c24193av == null) {
                C44443c.m80392w("tagorewang:TalkRoom:create", "null member info, index: ", Integer.valueOf(i2));
            } else {
                C24194aw c24194aw = null;
                for (int i3 = 0; i3 != length2; i3++) {
                    c24194aw = c24194awArr[i3];
                    if (c24194aw != null && c24194aw.vzt == c24193av.vzt) {
                        C44443c.m80389d("tagorewang:TalkRoom:create", "member info: ", c24193av, " profile: ", c24194aw);
                        break;
                    }
                    c24194aw = null;
                }
                talkRoom.mo50886a(new C6003d(c24193av, c24194aw));
            }
        }
        C44443c.m80389d("tagorewang:TalkRoom:create", "did create");
        AppMethodBeat.m2505o(127767);
        return talkRoom;
    }

    /* renamed from: a */
    public static TalkRoom m50223a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, C24191at c24191at, C24193av[] c24193avArr, C24194aw[] c24194awArr) {
        AppMethodBeat.m2504i(127768);
        if (talkRoom == null) {
            C44443c.m80392w("tagorewang:TalkRoom:update", "updateAll null");
            AppMethodBeat.m2505o(127768);
            return null;
        }
        C44443c.m80389d("tagorewang:TalkRoom:update", "updateAll groupId: ", str, " tmpId: ", str2);
        talkRoom.m50226b(str, num);
        talkRoom.auC(str2);
        m50221Sl(i);
        m50228nG(j);
        talkRoom.m50225b(c24191at);
        int length = c24193avArr == null ? 0 : c24193avArr.length;
        int i2;
        if (c24194awArr == null) {
            i2 = 0;
        } else {
            i2 = c24194awArr.length;
        }
        if (length == 0 && i2 == 0) {
            C44443c.m80392w("tagorewang:TalkRoom:update", "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array.");
            AppMethodBeat.m2505o(127768);
            return talkRoom;
        }
        HashSet<String> hashSet = new HashSet(talkRoom.AIU.keySet());
        hashSet.remove(C36407a.dPM());
        for (int i3 = 0; i3 != length; i3++) {
            C24193av c24193av = c24193avArr[i3];
            if (c24193av == null) {
                C44443c.m80392w("tagorewang:TalkRoom:update", "null member info, index: ", Integer.valueOf(i3));
            } else {
                C6003d auD = talkRoom.auD(c24193av.Aop);
                if (auD == null) {
                    C44443c.m80389d("tagorewang:TalkRoom:update", "add new member");
                    auD = new C6003d(c24193av);
                    talkRoom.mo50886a(auD);
                } else {
                    auD.mo13135a(c24193av);
                }
                hashSet.remove(auD.dTi());
            }
        }
        for (String str3 : hashSet) {
            C44443c.m80389d("tagorewang:TalkRoom:update", "keyset", str3);
            C44443c.m80389d("tagorewang:TalkRoom", "remove", talkRoom.AIU.remove(str3));
        }
        if (hashSet.size() > 0) {
            C44443c.m80392w("tagorewang:TalkRoom:update", "updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size()));
        }
        C44443c.m80389d("tagorewang:TalkRoom:update", "did updateAll");
        AppMethodBeat.m2505o(127768);
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, C24191at c24191at) {
        AppMethodBeat.m2504i(127769);
        m50226b(str, num);
        m50225b(c24191at);
        AppMethodBeat.m2505o(127769);
    }

    public static boolean dST() {
        return false;
    }

    private void auC(String str) {
        AppMethodBeat.m2504i(127770);
        if (C46825j.auS(str)) {
            this.Aqd = str;
        }
        AppMethodBeat.m2505o(127770);
    }

    public final int dSU() {
        return this.AlR == 0 ? 0 : this.AlR;
    }

    /* renamed from: b */
    private void m50226b(String str, Integer num) {
        AppMethodBeat.m2504i(127771);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(127771);
            return;
        }
        if (C46825j.auS(str)) {
            this.Aqd = str;
        } else {
            this.Aqc = str;
        }
        if (num != null) {
            this.AlR = num.intValue();
        }
        AppMethodBeat.m2505o(127771);
    }

    public static int dSV() {
        AppMethodBeat.m2504i(127772);
        int dTH = C46825j.dTH();
        AppMethodBeat.m2505o(127772);
        return dTH;
    }

    /* renamed from: Sl */
    private static void m50221Sl(int i) {
        AppMethodBeat.m2504i(127773);
        C44443c.m80389d("tagorewang:TalkRoom", "setRoomId: ", Integer.valueOf(i));
        AppMethodBeat.m2505o(127773);
    }

    public static long cKa() {
        AppMethodBeat.m2504i(127774);
        long dTI = C46825j.dTI();
        AppMethodBeat.m2505o(127774);
        return dTI;
    }

    /* renamed from: nG */
    private static void m50228nG(long j) {
        AppMethodBeat.m2504i(127775);
        C44443c.m80389d("tagorewang:TalkRoom", "setRoomKey: ", Long.valueOf(j));
        AppMethodBeat.m2505o(127775);
    }

    /* renamed from: a */
    private static C24234t m50222a(C24191at c24191at) {
        AppMethodBeat.m2504i(127776);
        if (c24191at != null) {
            try {
                if (c24191at.AoM != null) {
                    byte[] bArr = c24191at.AoM;
                    C24234t c24234t = (C24234t) C25510e.m40292a(new C24234t(), bArr, bArr.length);
                    AppMethodBeat.m2505o(127776);
                    return c24234t;
                }
            } catch (Exception e) {
                C44443c.m80392w("tagorewang:TalkRoom", "toPlayItemInfo err: ", e);
                AppMethodBeat.m2505o(127776);
                return null;
            }
        }
        AppMethodBeat.m2505o(127776);
        return null;
    }

    private String dSW() {
        String stringBuilder;
        AppMethodBeat.m2504i(127777);
        if (this.AIT == null || TextUtils.isEmpty(this.AIT.name)) {
            ArrayList arrayList = new ArrayList(this.AIU.values());
            arrayList.remove(this.AIU.get(C36407a.dPM()));
            List fE = m50227fE(arrayList);
            C44443c.m80391i("tagorewang:TalkRoom", "getOtherMembers size: ", Integer.valueOf(fE.size()), " all size: ", Integer.valueOf(this.AIU.size()));
            StringBuilder stringBuilder2 = new StringBuilder();
            if (fE != null) {
                int size = fE.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder2.append(((C6003d) fE.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder2.append(12289);
                        }
                    } catch (Exception e) {
                        C44443c.m80392w("tagorewang:TalkRoom", "updateRoomNameIfEmpty err and continue: ", e);
                    }
                }
            }
            if (stringBuilder2.toString().length() > 0) {
                stringBuilder = stringBuilder2.toString();
                AppMethodBeat.m2505o(127777);
                return stringBuilder;
            }
        }
        if (this.AIT == null || TextUtils.isEmpty(this.AIT.name)) {
            C44443c.m80392w("tagorewang:TalkRoom", "updateRoomNameIfEmpty still empty, groupId: ", this.Aqc, " tmpId: ", this.Aqd);
            AppMethodBeat.m2505o(127777);
            return null;
        }
        stringBuilder = this.AIT.name;
        AppMethodBeat.m2505o(127777);
        return stringBuilder;
    }

    /* renamed from: b */
    private void m50225b(C24191at c24191at) {
        AppMethodBeat.m2504i(127778);
        if (c24191at == null) {
            AppMethodBeat.m2505o(127778);
            return;
        }
        try {
            this.Aqe = c24191at.AoT;
            this.Aqf = c24191at.AoS;
            if (!(this.AIT == null || c24191at.cAO == 0)) {
                C24234t a = m50222a(c24191at);
                C24234t a2 = m50222a(this.AIT);
                if (a == null) {
                    c24191at.AoM = this.AIT.AoM;
                } else if (a.Anu == 0 || a.Anu != a2.Anu) {
                    C44443c.m80392w("tagorewang:TalkRoom", "setRoomInfo bad id: ", Integer.valueOf(a2.Anu), " -> ", Integer.valueOf(a.Anu));
                    c24191at.AoM = this.AIT.AoM;
                }
            }
            this.AIT = c24191at;
            AppMethodBeat.m2505o(127778);
        } catch (Exception e) {
            C44443c.m80392w("tagorewang:TalkRoom", "setRoomInfo assert failed: ", e);
            this.AIT = c24191at;
            AppMethodBeat.m2505o(127778);
        }
    }

    /* renamed from: a */
    public final void mo50886a(C6003d c6003d) {
        AppMethodBeat.m2504i(127779);
        this.AIU.put(c6003d.dTi(), c6003d);
        AppMethodBeat.m2505o(127779);
    }

    public final List<C6003d> dSY() {
        AppMethodBeat.m2504i(127781);
        ArrayList arrayList = new ArrayList(this.AIU.values());
        AppMethodBeat.m2505o(127781);
        return arrayList;
    }

    /* renamed from: fE */
    private static List<C6003d> m50227fE(List<C6003d> list) {
        AppMethodBeat.m2504i(127782);
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(127782);
        } else {
            Collections.sort(list, new C31135a());
            AppMethodBeat.m2505o(127782);
        }
        return list;
    }

    public final C6003d auD(String str) {
        AppMethodBeat.m2504i(127783);
        C6003d c6003d = (C6003d) this.AIU.get(str);
        AppMethodBeat.m2505o(127783);
        return c6003d;
    }

    public final C6003d dSZ() {
        AppMethodBeat.m2504i(127784);
        C6003d c6003d = (C6003d) this.AIU.get(C36407a.dPM());
        AppMethodBeat.m2505o(127784);
        return c6003d;
    }

    public final List<C24193av> dTa() {
        AppMethodBeat.m2504i(127785);
        List dTb = dTb();
        AppMethodBeat.m2505o(127785);
        return dTb;
    }

    public final List<C24193av> dTb() {
        AppMethodBeat.m2504i(127786);
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.AIU.entrySet()) {
            arrayList.add(((C6003d) value.getValue()).AJb);
        }
        AppMethodBeat.m2505o(127786);
        return arrayList;
    }

    public String toString() {
        String dSW;
        AppMethodBeat.m2504i(127787);
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
        AppMethodBeat.m2505o(127787);
        return dSW;
    }

    public final MultiTalkGroup dTc() {
        AppMethodBeat.m2504i(127788);
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.Aqc = this.Aqc;
        multiTalkGroup.Aqd = this.Aqd;
        multiTalkGroup.AlR = this.AlR;
        multiTalkGroup.Aqe = this.Aqe;
        multiTalkGroup.Aqf = this.Aqf;
        ArrayList arrayList = new ArrayList();
        List<C6003d> dSY = dSY();
        if (dSY.size() > 0) {
            for (C6003d c6003d : dSY) {
                if (c6003d != null) {
                    String str;
                    int i;
                    int i2;
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.Aqh = c6003d.dTi();
                    if (c6003d.AJb != null) {
                        str = c6003d.AJb.Apu;
                    } else {
                        str = "";
                    }
                    multiTalkGroupMember.Aqi = str;
                    if (c6003d.AJb != null) {
                        i = c6003d.AJb.boZ;
                    } else {
                        i = 0;
                    }
                    multiTalkGroupMember.boZ = i;
                    multiTalkGroupMember.status = c6003d.getState();
                    if (c6003d.AJb == null || c6003d.AJb.Api == 0) {
                        i2 = 0;
                    } else {
                        i2 = c6003d.AJb.Api;
                    }
                    multiTalkGroupMember.Api = i2;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.Aqg = arrayList;
        AppMethodBeat.m2505o(127788);
        return multiTalkGroup;
    }

    public final List<C6003d> dSX() {
        AppMethodBeat.m2504i(127780);
        List fE = m50227fE(new ArrayList(this.AIU.values()));
        C6003d dSZ = dSZ();
        fE.remove(dSZ);
        fE.add(0, dSZ);
        dSZ = (C6003d) this.AIU.get(Integer.valueOf(90100));
        if (dSZ != null) {
            fE.remove(dSZ);
            fE.add(dSZ);
        }
        AppMethodBeat.m2505o(127780);
        return fE;
    }
}
