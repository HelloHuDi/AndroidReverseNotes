package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.a */
public final class C38934a {
    /* renamed from: a */
    public static ArrayList<C34029d> m66099a(String str, String str2, String str3, String str4, Map<String, String> map, List<C34028c> list) {
        AppMethodBeat.m2504i(19430);
        C4990ab.m7410d("MicroMsg.ExdeviceMsgXmlParser", str3);
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.m2505o(19430);
            return null;
        }
        C8910b X = C8910b.m16058X(str3, str4);
        if (X != null) {
            Map map2 = X.fgm;
            ArrayList<C34029d> arrayList = new ArrayList();
            String str5 = "MicroMsg.ExdeviceMsgXmlParser";
            String str6 = "map is null :%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(map2 == null);
            C4990ab.m7411d(str5, str6, objArr);
            if (!(map2 == null || map2.isEmpty())) {
                int i;
                String str7;
                C4990ab.m7411d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", map2.toString());
                int i2 = 0;
                while (true) {
                    i = i2;
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    if (C5046bo.isNullOrNil(str7)) {
                        break;
                    }
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    str6 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".step");
                    C34028c c34028c = new C34028c();
                    c34028c.field_appusername = str2;
                    c34028c.field_username = str7;
                    c34028c.field_rankID = str;
                    c34028c.field_step = C5046bo.getInt(str6, 0);
                    list.add(c34028c);
                    map.put(str7, str5);
                    i2 = i + 1;
                }
                C4990ab.m7417i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", Integer.valueOf(i));
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".username");
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".nickname");
                    if (C5046bo.isNullOrNil(str7)) {
                        C4990ab.m7417i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i3));
                        AppMethodBeat.m2505o(19430);
                        return arrayList;
                    }
                    str6 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".rank.rankdisplay");
                    i = C5046bo.getInt((String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".score.scoredisplay"), 0);
                    C34029d c34029d = new C34029d();
                    c34029d.field_appusername = str2;
                    c34029d.field_rankID = str;
                    c34029d.field_username = str7;
                    c34029d.field_ranknum = C5046bo.getInt(str6, 0);
                    c34029d.field_score = i;
                    c34029d.field_selfLikeState = 2;
                    c34029d.field_likecount = 0;
                    arrayList.add(c34029d);
                    map.put(str7, str5);
                    i2 = i3 + 1;
                }
            }
        }
        AppMethodBeat.m2505o(19430);
        return null;
    }

    /* renamed from: d */
    public static void m66100d(String str, String str2, Map<String, String> map) {
        int i = 0;
        AppMethodBeat.m2504i(19431);
        C4990ab.m7411d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.m2505o(19431);
            return;
        }
        C8910b X = C8910b.m16058X(str, str2);
        if (X != null) {
            Map map2 = X.fgm;
            if (map2 != null && !map2.isEmpty()) {
                String str3;
                int i2 = 0;
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                    if (C5046bo.isNullOrNil(str3)) {
                        break;
                    }
                    map.put(str3, (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname"));
                    i2++;
                }
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    String str4 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    if (C5046bo.isNullOrNil(str3)) {
                        break;
                    }
                    map.put(str3, str4);
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(19431);
    }
}
