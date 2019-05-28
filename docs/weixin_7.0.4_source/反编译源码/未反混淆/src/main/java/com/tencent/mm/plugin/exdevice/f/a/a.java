package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a {
    public static ArrayList<d> a(String str, String str2, String str3, String str4, Map<String, String> map, List<c> list) {
        AppMethodBeat.i(19430);
        ab.d("MicroMsg.ExdeviceMsgXmlParser", str3);
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.o(19430);
            return null;
        }
        b X = b.X(str3, str4);
        if (X != null) {
            Map map2 = X.fgm;
            ArrayList<d> arrayList = new ArrayList();
            String str5 = "MicroMsg.ExdeviceMsgXmlParser";
            String str6 = "map is null :%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(map2 == null);
            ab.d(str5, str6, objArr);
            if (!(map2 == null || map2.isEmpty())) {
                int i;
                String str7;
                ab.d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", map2.toString());
                int i2 = 0;
                while (true) {
                    i = i2;
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    if (bo.isNullOrNil(str7)) {
                        break;
                    }
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    str6 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".step");
                    c cVar = new c();
                    cVar.field_appusername = str2;
                    cVar.field_username = str7;
                    cVar.field_rankID = str;
                    cVar.field_step = bo.getInt(str6, 0);
                    list.add(cVar);
                    map.put(str7, str5);
                    i2 = i + 1;
                }
                ab.i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", Integer.valueOf(i));
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".username");
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".nickname");
                    if (bo.isNullOrNil(str7)) {
                        ab.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i3));
                        AppMethodBeat.o(19430);
                        return arrayList;
                    }
                    str6 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".rank.rankdisplay");
                    i = bo.getInt((String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".score.scoredisplay"), 0);
                    d dVar = new d();
                    dVar.field_appusername = str2;
                    dVar.field_rankID = str;
                    dVar.field_username = str7;
                    dVar.field_ranknum = bo.getInt(str6, 0);
                    dVar.field_score = i;
                    dVar.field_selfLikeState = 2;
                    dVar.field_likecount = 0;
                    arrayList.add(dVar);
                    map.put(str7, str5);
                    i2 = i3 + 1;
                }
            }
        }
        AppMethodBeat.o(19430);
        return null;
    }

    public static void d(String str, String str2, Map<String, String> map) {
        int i = 0;
        AppMethodBeat.i(19431);
        ab.d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.o(19431);
            return;
        }
        b X = b.X(str, str2);
        if (X != null) {
            Map map2 = X.fgm;
            if (map2 != null && !map2.isEmpty()) {
                String str3;
                int i2 = 0;
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                    if (bo.isNullOrNil(str3)) {
                        break;
                    }
                    map.put(str3, (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname"));
                    i2++;
                }
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    String str4 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    if (bo.isNullOrNil(str3)) {
                        break;
                    }
                    map.put(str3, str4);
                    i++;
                }
            }
        }
        AppMethodBeat.o(19431);
    }
}
