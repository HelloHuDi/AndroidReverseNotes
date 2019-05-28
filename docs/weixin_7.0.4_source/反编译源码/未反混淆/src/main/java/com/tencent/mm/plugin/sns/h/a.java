package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int YC(String str) {
        int i = 0;
        AppMethodBeat.i(36815);
        try {
            i = bo.getInt(str, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(36815);
        return i;
    }

    private static float tA(String str) {
        float f = 0.0f;
        AppMethodBeat.i(36816);
        if (str == null) {
            AppMethodBeat.o(36816);
        } else {
            try {
                f = bo.getFloat(str, 0.0f);
            } catch (Exception e) {
                ab.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(36816);
        }
        return f;
    }

    private static String tB(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static db YD(String str) {
        db b;
        AppMethodBeat.i(36817);
        Map z = br.z(str, "albumList");
        db dbVar = new db();
        if (z != null) {
            dbVar.nbs = tB((String) z.get(".albumList.$lang"));
            b = b(z, a(z, dbVar));
        } else {
            b = dbVar;
        }
        AppMethodBeat.o(36817);
        return b;
    }

    private static db a(Map<String, String> map, db dbVar) {
        AppMethodBeat.i(36818);
        fq fqVar = new fq();
        fqVar.Name = tB((String) map.get(".albumList.album.author.name"));
        fqVar.Title = tB((String) map.get(".albumList.album.author.title"));
        fqVar.vEA = tB((String) map.get(".albumList.album.author.description"));
        fqVar.vHz = tB((String) map.get(".albumList.album.author.quote"));
        fqVar.vHA = ad(map);
        dbVar.vFj = fqVar;
        AppMethodBeat.o(36818);
        return dbVar;
    }

    private static fr ad(Map<String, String> map) {
        AppMethodBeat.i(36819);
        fr frVar = new fr();
        baw o = o(map, ".albumList.album.author.icon.media");
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
        bau.Id = tB(str);
        bau.jCt = YC(str2);
        bau.Title = tB(str3);
        bau.Desc = tB(str4);
        bau.Url = tB(str5);
        bau.wEG = YC(str8);
        bau.wEH = tB(str7);
        bau.wEI = YC(str9);
        bau.wEJ = YC(str6);
        bau.wEK = o;
        frVar.vHB = bau;
        AppMethodBeat.o(36819);
        return frVar;
    }

    private static baw o(Map<String, String> map, String str) {
        AppMethodBeat.i(36820);
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
            baw.wFx = tA(str2);
        }
        if (str3 != null) {
            baw.wFy = tA(str3);
        }
        if (str4 != null) {
            baw.wFz = tA(str4);
        }
        AppMethodBeat.o(36820);
        return baw;
    }

    private static db b(Map<String, String> map, db dbVar) {
        AppMethodBeat.i(36821);
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
                ary.Name = tB(str2);
                ary.wbK = p(map, str);
                dbVar.vFk.add(ary);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(36821);
                return dbVar;
            }
        }
    }

    private static LinkedList<bau> p(Map<String, String> map, String str) {
        AppMethodBeat.i(36822);
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
                baw o = o(map, str6);
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
                bau.Id = tB(str6);
                bau.jCt = YC(str5);
                bau.Title = tB(str4);
                bau.Desc = tB(str3);
                bau.Url = tB(str2);
                bau.wEG = YC(obj82);
                bau.wEH = tB(obj92);
                bau.wEI = YC(obj72);
                bau.wEJ = YC(obj62);
                bau.wEK = o;
                linkedList.add(bau);
                i++;
            } else {
                break;
            }
        }
        AppMethodBeat.o(36822);
        return linkedList;
    }
}
