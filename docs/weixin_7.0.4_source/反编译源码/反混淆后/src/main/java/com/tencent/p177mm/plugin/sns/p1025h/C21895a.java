package com.tencent.p177mm.plugin.sns.p1025h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C35917fq;
import com.tencent.p177mm.protocal.protobuf.C40509db;
import com.tencent.p177mm.protocal.protobuf.C40521fr;
import com.tencent.p177mm.protocal.protobuf.ary;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.h.a */
public final class C21895a {
    /* renamed from: YC */
    private static int m33455YC(String str) {
        int i = 0;
        AppMethodBeat.m2504i(36815);
        try {
            i = C5046bo.getInt(str, 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(36815);
        return i;
    }

    /* renamed from: tA */
    private static float m33462tA(String str) {
        float f = 0.0f;
        AppMethodBeat.m2504i(36816);
        if (str == null) {
            AppMethodBeat.m2505o(36816);
        } else {
            try {
                f = C5046bo.getFloat(str, 0.0f);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(36816);
        }
        return f;
    }

    /* renamed from: tB */
    private static String m33463tB(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: YD */
    public static C40509db m33456YD(String str) {
        C40509db b;
        AppMethodBeat.m2504i(36817);
        Map z = C5049br.m7595z(str, "albumList");
        C40509db c40509db = new C40509db();
        if (z != null) {
            c40509db.nbs = C21895a.m33463tB((String) z.get(".albumList.$lang"));
            b = C21895a.m33459b(z, C21895a.m33457a(z, c40509db));
        } else {
            b = c40509db;
        }
        AppMethodBeat.m2505o(36817);
        return b;
    }

    /* renamed from: a */
    private static C40509db m33457a(Map<String, String> map, C40509db c40509db) {
        AppMethodBeat.m2504i(36818);
        C35917fq c35917fq = new C35917fq();
        c35917fq.Name = C21895a.m33463tB((String) map.get(".albumList.album.author.name"));
        c35917fq.Title = C21895a.m33463tB((String) map.get(".albumList.album.author.title"));
        c35917fq.vEA = C21895a.m33463tB((String) map.get(".albumList.album.author.description"));
        c35917fq.vHz = C21895a.m33463tB((String) map.get(".albumList.album.author.quote"));
        c35917fq.vHA = C21895a.m33458ad(map);
        c40509db.vFj = c35917fq;
        AppMethodBeat.m2505o(36818);
        return c40509db;
    }

    /* renamed from: ad */
    private static C40521fr m33458ad(Map<String, String> map) {
        AppMethodBeat.m2504i(36819);
        C40521fr c40521fr = new C40521fr();
        baw o = C21895a.m33460o(map, ".albumList.album.author.icon.media");
        String str = (String) map.get(".albumList.album.author.icon.media.id");
        String str2 = (String) map.get(".albumList.album.author.icon.media.type");
        String str3 = (String) map.get(".albumList.album.author.icon.media.title");
        String str4 = (String) map.get(".albumList.album.author.icon.media.desc");
        String str5 = (String) map.get(".albumList.album.author.icon.media.url");
        String str6 = (String) map.get(".albumList.album.author.icon.media.private");
        String str7 = (String) map.get(".albumList.album.author.icon.media.thumb");
        String str8 = (String) map.get(".albumList.album.author.icon.media.url.$type");
        String str9 = (String) map.get(".albumList.album.author.icon.media.thumb.$type");
        bau bau = new bau();
        bau.f17915Id = C21895a.m33463tB(str);
        bau.jCt = C21895a.m33455YC(str2);
        bau.Title = C21895a.m33463tB(str3);
        bau.Desc = C21895a.m33463tB(str4);
        bau.Url = C21895a.m33463tB(str5);
        bau.wEG = C21895a.m33455YC(str8);
        bau.wEH = C21895a.m33463tB(str7);
        bau.wEI = C21895a.m33455YC(str9);
        bau.wEJ = C21895a.m33455YC(str6);
        bau.wEK = o;
        c40521fr.vHB = bau;
        AppMethodBeat.m2505o(36819);
        return c40521fr;
    }

    /* renamed from: o */
    private static baw m33460o(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(36820);
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        baw baw = new baw();
        baw.wFy = 0.0f;
        baw.wFx = 0.0f;
        baw.wFz = 0.0f;
        if (str2 != null) {
            baw.wFx = C21895a.m33462tA(str2);
        }
        if (str3 != null) {
            baw.wFy = C21895a.m33462tA(str3);
        }
        if (str4 != null) {
            baw.wFz = C21895a.m33462tA(str4);
        }
        AppMethodBeat.m2505o(36820);
        return baw;
    }

    /* renamed from: b */
    private static C40509db m33459b(Map<String, String> map, C40509db c40509db) {
        AppMethodBeat.m2504i(36821);
        int i = 0;
        while (true) {
            Object obj;
            String str;
            int i2 = i;
            ary ary = new ary();
            if (i2 == 0) {
                obj = ".albumList.album.groupList.group.name";
                str = ".albumList.album.groupList.group.mediaList";
            } else {
                obj = ".albumList.album.groupList.group" + i2 + ".name";
                str = ".albumList.album.groupList.group" + i2 + ".mediaList";
            }
            String str2 = (String) map.get(obj);
            if (str2 != null) {
                ary.Name = C21895a.m33463tB(str2);
                ary.wbK = C21895a.m33461p(map, str);
                c40509db.vFk.add(ary);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(36821);
                return c40509db;
            }
        }
    }

    /* renamed from: p */
    private static LinkedList<bau> m33461p(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(36822);
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            String obj62;
            String obj72;
            String obj82;
            String obj92;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                obj2 = str + ".media" + i + ".type";
                obj3 = str + ".media" + i + ".title";
                obj4 = str + ".media" + i + ".desc";
                obj5 = str + ".media" + i + ".url";
                str2 = str + ".media" + i + ".thumb";
                str3 = str + ".media" + i + ".url.$type";
                str4 = str + ".media" + i + ".thumb.$type";
                str5 = str + ".media" + i + ".private";
                str6 = str + ".media" + i;
                obj62 = str5;
                obj72 = str4;
                obj82 = str3;
                obj92 = str2;
            } else {
                obj = str + ".media.id";
                obj2 = str + ".media.type";
                obj3 = str + ".media.title";
                obj4 = str + ".media.desc";
                obj5 = str + ".media.url";
                str2 = str + ".media.thumb";
                str3 = str + ".media.url.$type";
                str4 = str + ".media.thumb.$type";
                str5 = str + ".media.private";
                str6 = str + ".media";
                obj62 = str5;
                obj72 = str4;
                obj82 = str3;
                obj92 = str2;
            }
            if (obj != null && obj2 != null) {
                baw o = C21895a.m33460o(map, str6);
                str6 = (String) map.get(obj);
                str5 = (String) map.get(obj2);
                str4 = (String) map.get(obj3);
                str3 = (String) map.get(obj4);
                str2 = (String) map.get(obj5);
                obj62 = (String) map.get(obj62);
                obj92 = (String) map.get(obj92);
                obj82 = (String) map.get(obj82);
                obj72 = (String) map.get(obj72);
                if (str6 == null || str5 == null) {
                    break;
                }
                bau bau = new bau();
                bau.f17915Id = C21895a.m33463tB(str6);
                bau.jCt = C21895a.m33455YC(str5);
                bau.Title = C21895a.m33463tB(str4);
                bau.Desc = C21895a.m33463tB(str3);
                bau.Url = C21895a.m33463tB(str2);
                bau.wEG = C21895a.m33455YC(obj82);
                bau.wEH = C21895a.m33463tB(obj92);
                bau.wEI = C21895a.m33455YC(obj72);
                bau.wEJ = C21895a.m33455YC(obj62);
                bau.wEK = o;
                linkedList.add(bau);
                i++;
            } else {
                break;
            }
        }
        AppMethodBeat.m2505o(36822);
        return linkedList;
    }
}
