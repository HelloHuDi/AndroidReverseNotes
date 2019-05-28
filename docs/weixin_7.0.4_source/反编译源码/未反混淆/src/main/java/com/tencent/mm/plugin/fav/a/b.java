package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b {
    private static HashMap<Long, ArrayList<String>> meC = new HashMap();
    private static long meD = 0;

    private static String ek(String str, String str2) {
        AppMethodBeat.i(102524);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102524);
            return str2;
        } else if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(102524);
            return str;
        } else {
            str2 = str + "​" + str2;
            AppMethodBeat.o(102524);
            return str2;
        }
    }

    public static String cf(String str, int i) {
        AppMethodBeat.i(102525);
        String x = g.x((str + i + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(102525);
        return x;
    }

    public static long a(g gVar) {
        long j = 0;
        AppMethodBeat.i(102526);
        for (int i : a.meA) {
            if (i == gVar.field_type) {
                long j2;
                if (gVar.field_favProto != null) {
                    Iterator it = gVar.field_favProto.wiv.iterator();
                    while (true) {
                        j2 = j;
                        if (!it.hasNext()) {
                            break;
                        }
                        j = ((aar) it.next()).wgu + j2;
                    }
                } else {
                    j2 = 0;
                }
                gVar.field_datatotalsize = j2;
                ab.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", Integer.valueOf(gVar.field_id), Long.valueOf(j2));
                AppMethodBeat.o(102526);
                return j2;
            }
        }
        AppMethodBeat.o(102526);
        return 0;
    }

    public static aaw a(int i, abf abf, abs abs) {
        AppMethodBeat.i(102527);
        if (abf == null) {
            ab.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
            AppMethodBeat.o(102527);
            return null;
        }
        aaw aaw = new aaw();
        abl abl = abf.wit;
        if (abl != null) {
            aaw.cEV = abl.cEV;
            aaw.wif = abl.whU;
            aaw.appId = abl.appId;
            aaw.csl = abl.csl;
        }
        if (abs != null) {
            if (abs.wiI != null) {
                aaw.wig.addAll(abs.wiI);
            }
            if (abs.wiJ != null) {
                aaw.wig.addAll(abs.wiJ);
            }
        }
        aaw.cKb = abf;
        aaw.type = i;
        switch (i) {
            case 1:
                aaw.title = "";
                aaw.desc = abf.desc;
                AppMethodBeat.o(102527);
                return aaw;
            case 2:
                if (abf.wiv != null && abf.wiv.size() > 0) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 4:
                if (!(abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 5:
                if (abf.whA != null) {
                    aaw.title = abf.whA.title;
                    aaw.desc = abf.whA.wiY;
                }
                if (!(!bo.isNullOrNil(aaw.title) || abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                if (bo.isNullOrNil(aaw.desc) && abl != null) {
                    aaw.desc = abl.link;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 6:
                aaw.title = abf.hHV;
                if (bo.isNullOrNil(aaw.title)) {
                    if (abf.why != null) {
                        aaw.title = abf.why.cIK;
                        aaw.desc = abf.why.label;
                    }
                } else if (abf.why != null) {
                    aaw.desc = abf.why.cIK;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 7:
                if (!(abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                    aaw.desc = ((aar) abf.wiv.get(0)).desc;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 8:
                aaw.title = abf.title;
                if (!(!bo.isNullOrNil(aaw.title) || abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 10:
            case 11:
                if (abf.whC != null) {
                    aaw.title = abf.whC.title;
                    aaw.desc = abf.whC.desc;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 12:
            case 15:
                if (abf.whE != null) {
                    aaw.title = abf.whE.title;
                    aaw.desc = abf.whE.desc;
                }
                AppMethodBeat.o(102527);
                return aaw;
            case 14:
            case 18:
                LinkedList<aar> linkedList = abf.wiv;
                if (linkedList == null) {
                    AppMethodBeat.o(102527);
                    return null;
                }
                for (aar aar : linkedList) {
                    if (1 == aar.dataType) {
                        aaw.title = aar.desc;
                        AppMethodBeat.o(102527);
                        return aaw;
                    }
                }
                AppMethodBeat.o(102527);
                return aaw;
            default:
                ab.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", Integer.valueOf(i));
                AppMethodBeat.o(102527);
                return aaw;
        }
    }

    public static long b(g gVar) {
        AppMethodBeat.i(102528);
        if (gVar == null) {
            AppMethodBeat.o(102528);
            return 0;
        }
        int i = 0;
        Iterator it = gVar.field_favProto.wiv.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = (int) (((aar) it.next()).wgu + ((long) i2));
            } else {
                long j = (long) i2;
                AppMethodBeat.o(102528);
                return j;
            }
        }
    }

    public static aar c(g gVar) {
        AppMethodBeat.i(102529);
        aar aar;
        if (gVar == null) {
            aar = new aar();
            AppMethodBeat.o(102529);
            return aar;
        } else if (gVar.field_favProto.wiv.size() == 0) {
            aar = new aar();
            AppMethodBeat.o(102529);
            return aar;
        } else {
            aar = (aar) gVar.field_favProto.wiv.get(0);
            AppMethodBeat.o(102529);
            return aar;
        }
    }

    public static void in(long j) {
        AppMethodBeat.i(102530);
        ab.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", Long.valueOf(j));
        com.tencent.mm.kernel.g.RP().Ry().set(a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(j));
        AppMethodBeat.o(102530);
    }

    public static void io(long j) {
        AppMethodBeat.i(102531);
        ab.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", Long.valueOf(j));
        com.tencent.mm.kernel.g.RP().Ry().set(a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(j));
        AppMethodBeat.o(102531);
    }

    private static String ip(long j) {
        AppMethodBeat.i(102532);
        StringBuilder stringBuilder = new StringBuilder();
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        String str;
        if (iE == null || iE.field_favProto == null || iE.field_favProto.wiv.size() <= 1) {
            str = "";
            AppMethodBeat.o(102532);
            return str;
        }
        aaz aaz = iE.field_favProto.vzK;
        String str2 = "";
        str = "";
        if (aaz != null) {
            str2 = aaz.win;
            str = aaz.wim;
        }
        stringBuilder.append("<noteinfo>");
        stringBuilder.append("<noteauthor>").append(str).append("</noteauthor>");
        stringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
        stringBuilder.append("<edittime>").append(iE.field_favProto.lgR).append("</edittime>");
        stringBuilder.append("<favlocalid>").append(iE.field_localId).append("</favlocalid>");
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bK(iE.field_favProto.wiv).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        stringBuilder.append("</noteinfo>");
        str = stringBuilder.toString();
        AppMethodBeat.o(102532);
        return str;
    }

    static {
        AppMethodBeat.i(102620);
        AppMethodBeat.o(102620);
    }

    private static void a(gh ghVar) {
        AppMethodBeat.i(102533);
        if (bo.isNullOrNil(ghVar.cAH.desc)) {
            ghVar.cAI.ret = -1;
            AppMethodBeat.o(102533);
            return;
        }
        g LG = LG(ghVar.cAH.desc);
        if (LG == null || LG.field_localId <= 0) {
            ghVar.cAI.ret = -1;
            AppMethodBeat.o(102533);
            return;
        }
        boolean e = e(LG);
        String str = ghVar.cAH.cAN;
        ArrayList arrayList;
        if (e) {
            ghVar.cAI.ret = 1;
            arrayList = (ArrayList) meC.get(Long.valueOf(LG.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    meC.remove(Long.valueOf(LG.field_localId));
                }
            }
            AppMethodBeat.o(102533);
        } else if (bo.isNullOrNil(str)) {
            ghVar.cAI.ret = -1;
            AppMethodBeat.o(102533);
        } else {
            long j = LG.field_localId;
            if (meC.get(Long.valueOf(j)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) meC.get(Long.valueOf(j));
            }
            arrayList.add(str);
            meC.put(Long.valueOf(j), arrayList);
            final g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
            if (iE == null || iE.field_localId <= 0) {
                ghVar.cAI.ret = -1;
                AppMethodBeat.o(102533);
            } else if (e(iE) || iE.field_itemStatus == 10) {
                ghVar.cAI.ret = -1;
                com.tencent.mm.kernel.g.RS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(102520);
                        b.d(iE);
                        AppMethodBeat.o(102520);
                    }
                }, 500);
                AppMethodBeat.o(102533);
            } else {
                ghVar.cAI.ret = -1;
                AppMethodBeat.o(102533);
            }
        }
    }

    public static synchronized void d(g gVar) {
        synchronized (b.class) {
            AppMethodBeat.i(102534);
            if (gVar == null || gVar.field_type != 18) {
                AppMethodBeat.o(102534);
            } else if (!meC.containsKey(Long.valueOf(gVar.field_localId))) {
                AppMethodBeat.o(102534);
            } else if (meC.get(Long.valueOf(gVar.field_localId)) == null || ((ArrayList) meC.get(Long.valueOf(gVar.field_localId))).size() == 0) {
                AppMethodBeat.o(102534);
            } else {
                ab.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", Long.valueOf(gVar.field_localId), ip(gVar.field_localId));
                ow owVar = new ow();
                owVar.cLi.cLj = (ArrayList) meC.get(Long.valueOf(gVar.field_localId));
                owVar.cLi.cLk = r2;
                com.tencent.mm.sdk.b.a.xxA.m(owVar);
                meC.remove(Long.valueOf(gVar.field_localId));
                AppMethodBeat.o(102534);
            }
        }
    }

    private static boolean e(g gVar) {
        AppMethodBeat.i(102535);
        if (gVar == null) {
            AppMethodBeat.o(102535);
            return false;
        }
        boolean z;
        Iterator it = gVar.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if ((aar.dataType == 8 || aar.dataType == 4 || aar.dataType == 2 || aar.dataType == 3) && (bo.isNullOrNil(aar.wfZ) || bo.isNullOrNil(aar.wgb))) {
                z = false;
                break;
            }
        }
        z = true;
        AppMethodBeat.o(102535);
        return z;
    }

    public static void bI(List<Integer> list) {
        AppMethodBeat.i(102536);
        if (list.size() == 0) {
            ab.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
            AppMethodBeat.o(102536);
            return;
        }
        Set bud = bud();
        ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", bud.toString());
        for (Integer num : list) {
            boolean remove = bud.remove(num.toString());
            ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", num, Boolean.valueOf(remove));
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", bud.toString());
        d(bud);
        AppMethodBeat.o(102536);
    }

    private static void d(Set<String> set) {
        AppMethodBeat.i(102537);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", obj);
        com.tencent.mm.kernel.g.RP().Ry().set(225282, obj);
        AppMethodBeat.o(102537);
    }

    private static Set<String> bud() {
        AppMethodBeat.i(102538);
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(225282, (Object) "");
        ab.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", str);
        HashSet hashSet = new HashSet();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102538);
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(102538);
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        AppMethodBeat.o(102538);
        return hashSet;
    }

    public static void iq(long j) {
        AppMethodBeat.i(102539);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
        AppMethodBeat.o(102539);
    }

    public static void ir(long j) {
        AppMethodBeat.i(102540);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
        AppMethodBeat.o(102540);
    }

    public static void is(long j) {
        AppMethodBeat.i(102541);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putLong("fav_mx_file_size", j).commit();
        AppMethodBeat.o(102541);
    }

    public static String bue() {
        AppMethodBeat.i(102542);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.RQ();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("favorite/web/").toString();
        AppMethodBeat.o(102542);
        return stringBuilder2;
    }

    public static String b(aar aar) {
        AppMethodBeat.i(102543);
        String str;
        if (aar == null) {
            str = "";
            AppMethodBeat.o(102543);
            return str;
        }
        String str2 = aar.mnd;
        if (bo.isNullOrNil(str2) || !com.tencent.mm.kernel.g.RK()) {
            str = "";
            AppMethodBeat.o(102543);
            return str;
        }
        com.tencent.mm.vfs.b Lz = Lz(str2);
        Object obj = null;
        if (aar.dataType == 8 && !bo.isNullOrNil(aar.title)) {
            str2 = aar.title;
            Lz = Lz(aar.mnd);
            obj = 1;
        }
        if (aar.wgo != null && aar.wgo.trim().length() > 0 && obj == null) {
            str2 = str2 + "." + aar.wgo;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(Lz, str2);
        if (bVar.exists() || bo.isNullOrNil(aar.wgq)) {
            str = j.w(bVar.dMD());
            AppMethodBeat.o(102543);
            return str;
        }
        str = g.x((aar.wgq + aar.mnd).getBytes());
        if (bo.isNullOrNil(str)) {
            str = j.w(bVar.dMD());
            AppMethodBeat.o(102543);
            return str;
        }
        if (aar.wgo != null && aar.wgo.trim().length() > 0) {
            str = str + "." + aar.wgo;
        }
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(Lz, str);
        if (bVar2.exists()) {
            str = j.w(bVar2.dMD());
            AppMethodBeat.o(102543);
            return str;
        }
        str = aar.mnd;
        if (aar.wgo != null && aar.wgo.trim().length() > 0) {
            str = str + "." + aar.wgo;
        }
        ab.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(str)));
        str = j.w(new com.tencent.mm.vfs.b(Lz, str).dMD());
        AppMethodBeat.o(102543);
        return str;
    }

    private static com.tencent.mm.vfs.b Lz(String str) {
        AppMethodBeat.i(102544);
        int hashCode = str.hashCode() & 255;
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(String.format("%s/%s/%d/", new Object[]{com.tencent.mm.kernel.g.RP().eJM, "favorite", Integer.valueOf(hashCode)}));
        if (!(bVar.exists() && bVar.isDirectory())) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(102544);
        return bVar;
    }

    public static boolean f(g gVar) {
        AppMethodBeat.i(102545);
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(102545);
            return false;
        }
        Iterator it = gVar.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.whh == 2) {
                AppMethodBeat.o(102545);
                return true;
            } else if (aar.whh == 1) {
                AppMethodBeat.o(102545);
                return true;
            }
        }
        AppMethodBeat.o(102545);
        return false;
    }

    public static boolean g(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10 || gVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static void buf() {
        AppMethodBeat.i(102546);
        Set<String> bud = bud();
        if (bud.size() == 0) {
            ab.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
            AppMethodBeat.o(102546);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", bud.toString());
        LinkedList linkedList = new LinkedList();
        for (String str : bud) {
            try {
                linkedList.add(Integer.valueOf(bo.getInt(str, 0)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
                ab.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", e.getMessage());
            }
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            com.tencent.mm.kernel.g.Rg().a(new ag(linkedList), 0);
        }
        AppMethodBeat.o(102546);
    }

    private static void h(g gVar) {
        AppMethodBeat.i(102547);
        Set set = an.mgy;
        LinkedList linkedList = gVar.field_favProto.wiv;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                String c = c((aar) linkedList.get(i2));
                if (set == null || !set.contains(c)) {
                    e.deleteFile(c);
                }
                c = b((aar) linkedList.get(i2));
                if (set == null || !set.contains(c)) {
                    e.deleteFile(c);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(102547);
                return;
            }
        }
    }

    public static String c(aar aar) {
        AppMethodBeat.i(102548);
        String str;
        if (aar == null || bo.isNullOrNil(aar.mnd)) {
            str = "";
            AppMethodBeat.o(102548);
            return str;
        }
        str = LA(aar.mnd);
        str = j.w(new com.tencent.mm.vfs.b(Lz(str), str).dMD());
        AppMethodBeat.o(102548);
        return str;
    }

    public static String LA(String str) {
        AppMethodBeat.i(102549);
        String str2 = str + "_t";
        AppMethodBeat.o(102549);
        return str2;
    }

    public static boolean bJ(List<g> list) {
        AppMethodBeat.i(102550);
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            AppMethodBeat.o(102550);
            return false;
        }
        Set bud = bud();
        for (g gVar : list) {
            h(gVar);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().iG(gVar.field_localId);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().z(gVar);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iC(gVar.field_localId);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().v(gVar);
            bud.add(gVar.field_id);
            ab.d("MicroMsg.Fav.FavApiLogic", "delete id %d", Integer.valueOf(gVar.field_id));
        }
        d(bud);
        buf();
        AppMethodBeat.o(102550);
        return true;
    }

    public static void a(g gVar, boolean z) {
        AppMethodBeat.i(102551);
        h(gVar);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().iG(gVar.field_localId);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().z(gVar);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iC(gVar.field_localId);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().v(gVar);
        if (z) {
            Set bud = bud();
            bud.add(gVar.field_id);
            d(bud);
            buf();
        }
        AppMethodBeat.o(102551);
    }

    public static boolean a(final g gVar, final boolean z, final Runnable runnable) {
        AppMethodBeat.i(102552);
        if (gVar == null) {
            ab.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            al.d(runnable);
            AppMethodBeat.o(102552);
            return false;
        }
        if (Looper.myLooper() == com.tencent.mm.kernel.g.RS().oAl.getLooper()) {
            ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
            a(gVar, z);
            al.d(runnable);
        } else {
            ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102521);
                    ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
                    b.a(gVar, z);
                    al.d(runnable);
                    AppMethodBeat.o(102521);
                }
            });
        }
        AppMethodBeat.o(102552);
        return true;
    }

    public static boolean i(g gVar) {
        AppMethodBeat.i(102553);
        boolean a = a(gVar, true, null);
        AppMethodBeat.o(102553);
        return a;
    }

    public static void j(g gVar) {
        int i;
        j jVar;
        AppMethodBeat.i(102554);
        j iH = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().iH(gVar.field_localId);
        if (iH == null) {
            iH = new j();
            iH.field_localId = gVar.field_localId;
            i = 1;
            jVar = iH;
        } else {
            i = 0;
            jVar = iH;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (gVar.field_favProto.title != null) {
            stringBuffer.append(gVar.field_favProto.title);
        }
        if (gVar.field_favProto.desc != null) {
            stringBuffer.append(gVar.field_favProto.desc);
        }
        if (gVar.field_favProto.wit != null) {
            abl abl = gVar.field_favProto.wit;
            if (!bo.isNullOrNil(abl.cEV)) {
                stringBuffer.append(abl.cEV);
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(abl.cEV);
                if (aoO != null) {
                    stringBuffer.append(aoO.field_nickname).append(aoO.field_conRemark);
                }
                aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(abl.toUser);
                if (aoO != null) {
                    stringBuffer.append(aoO.field_nickname).append(aoO.field_conRemark);
                }
                stringBuffer.append(abl.whU);
            }
        }
        LinkedList linkedList = gVar.field_favProto.wiv;
        jVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.desc != null) {
                stringBuffer.append(aar.desc);
            }
            if (aar.title != null) {
                stringBuffer.append(aar.title);
            }
            int i2 = aar.dataType;
            jVar.field_subtype = j.vx(i2) | jVar.field_subtype;
        }
        if (gVar.field_favProto.whA != null) {
            if (gVar.field_favProto.whA.desc != null) {
                stringBuffer.append(gVar.field_favProto.whA.desc);
            }
            if (gVar.field_favProto.whA.title != null) {
                stringBuffer.append(gVar.field_favProto.whA.title);
            }
        }
        if (gVar.field_favProto.whC != null) {
            if (gVar.field_favProto.whC.desc != null) {
                stringBuffer.append(gVar.field_favProto.whC.desc);
            }
            if (gVar.field_favProto.whC.title != null) {
                stringBuffer.append(gVar.field_favProto.whC.title);
            }
        }
        jVar.field_tagContent = "";
        for (String str : gVar.field_tagProto.wiI) {
            jVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : gVar.field_tagProto.wiJ) {
            jVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().LM(str2);
        }
        jVar.field_content = stringBuffer.toString();
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (i != 0) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().a(jVar);
            AppMethodBeat.o(102554);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().a(jVar, "localId");
        AppMethodBeat.o(102554);
    }

    public static boolean LB(String str) {
        AppMethodBeat.i(102555);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102555);
            return false;
        }
        boolean endsWith = str.endsWith("_t");
        AppMethodBeat.o(102555);
        return endsWith;
    }

    public static aar a(g gVar, String str) {
        AppMethodBeat.i(102556);
        if (bo.isNullOrNil(str) || gVar == null || gVar.field_favProto.wiv.size() == 0) {
            AppMethodBeat.o(102556);
            return null;
        }
        Iterator it = gVar.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(str)) {
                AppMethodBeat.o(102556);
                return aar;
            }
        }
        AppMethodBeat.o(102556);
        return null;
    }

    public static void a(c cVar) {
        AppMethodBeat.i(102557);
        int r = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().r(cVar.field_favLocalId, 0);
        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", Integer.valueOf(r), Long.valueOf(cVar.field_favLocalId));
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(cVar.field_favLocalId);
        if (iE == null) {
            ab.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.o(102557);
        } else if (iE.buA()) {
            ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
            AppMethodBeat.o(102557);
        } else if (cVar.field_status == 3 && r != cVar.field_status && iE.field_type == 18 && ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(cVar.field_dataId).field_status == 3) {
            a(cVar, iE);
            AppMethodBeat.o(102557);
        } else {
            switch (r) {
                case 0:
                    AppMethodBeat.o(102557);
                    return;
                case 1:
                    if (iE.buz()) {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(15, cVar.field_favLocalId);
                    } else {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(4, cVar.field_favLocalId);
                    }
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    AppMethodBeat.o(102557);
                    return;
                case 2:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(6, cVar.field_favLocalId);
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    break;
                case 3:
                    if (iE.field_type == 18) {
                        a(cVar, iE);
                        AppMethodBeat.o(102557);
                        return;
                    } else if (iE.buz()) {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(17, cVar.field_favLocalId);
                        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getModService().run();
                        AppMethodBeat.o(102557);
                        return;
                    } else {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(9, cVar.field_favLocalId);
                        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
                        AppMethodBeat.o(102557);
                        return;
                    }
                case 4:
                    if (iE.buz()) {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(16, cVar.field_favLocalId);
                    } else {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(6, cVar.field_favLocalId);
                    }
                    h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(iE.field_type), Integer.valueOf(-5), Long.valueOf(b(iE)), Long.valueOf(h.ix(iE.field_localId)));
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    AppMethodBeat.o(102557);
                    return;
            }
            AppMethodBeat.o(102557);
        }
    }

    public static void b(c cVar) {
        AppMethodBeat.i(102558);
        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", Integer.valueOf(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().r(cVar.field_favLocalId, 1)), Long.valueOf(cVar.field_favLocalId));
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(cVar.field_favLocalId);
        if (iE == null) {
            ab.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.o(102558);
        } else if (iE.buA() || iE.buw() || iE.bux()) {
            ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", Boolean.valueOf(iE.buA()), Boolean.valueOf(iE.buw()), Boolean.valueOf(iE.bux()));
            AppMethodBeat.o(102558);
        } else {
            switch (r1) {
                case 0:
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id));
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(10, cVar.field_favLocalId);
                    AppMethodBeat.o(102558);
                    return;
                case 1:
                    h.iy(iE.field_localId);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(7, cVar.field_favLocalId);
                    AppMethodBeat.o(102558);
                    return;
                case 2:
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id));
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(8, cVar.field_favLocalId);
                    break;
                case 3:
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id));
                    h.pYm.e(10659, Integer.valueOf(1), Integer.valueOf(iE.field_type), Integer.valueOf(0), Long.valueOf(b(iE)), Long.valueOf(h.ix(iE.field_localId)));
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(10, cVar.field_favLocalId);
                    AppMethodBeat.o(102558);
                    return;
                case 4:
                    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    h.pYm.e(10659, Integer.valueOf(1), Integer.valueOf(iE.field_type), Integer.valueOf(-5), Long.valueOf(b(iE)), Long.valueOf(h.ix(iE.field_localId)));
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(8, cVar.field_favLocalId);
                    AppMethodBeat.o(102558);
                    return;
            }
            AppMethodBeat.o(102558);
        }
    }

    private static void a(c cVar, g gVar) {
        AppMethodBeat.i(102559);
        Iterator it = gVar.field_favProto.wiv.iterator();
        int i = 0;
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (!(aar.dataType == 1 || aar.dataType == 6)) {
                int i2;
                if (bo.isNullOrNil(aar.wfZ)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i == 0) {
            if (gVar.field_id > 0) {
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(17, cVar.field_favLocalId);
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getModService().run();
                AppMethodBeat.o(102559);
                return;
            }
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(9, cVar.field_favLocalId);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
        }
        AppMethodBeat.o(102559);
    }

    public static void a(aar aar, g gVar, int i) {
        AppMethodBeat.i(102560);
        if (i == 1 && (aar.wgF <= 0 || bo.isNullOrNil(aar.wfV) || bo.isNullOrNil(aar.fgE))) {
            ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.o(102560);
        } else if (i == 0 && bo.isNullOrNil(c(aar))) {
            ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
            AppMethodBeat.o(102560);
        } else {
            String LA = LA(aar.mnd);
            if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(LA) != null) {
                ab.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", LA);
                AppMethodBeat.o(102560);
                return;
            }
            ab.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
            c cVar = new c();
            cVar.field_cdnKey = aar.wfV;
            cVar.field_cdnUrl = aar.fgE;
            cVar.field_dataId = LA;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_totalLen = (int) aar.wgF;
            cVar.field_type = i;
            cVar.field_status = 1;
            cVar.field_path = c(aar);
            cVar.field_modifyTime = bo.anU();
            cVar.field_attrFlag |= 1;
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().e(cVar);
            if (i == 1) {
                b(cVar);
                AppMethodBeat.o(102560);
                return;
            }
            a(cVar);
            AppMethodBeat.o(102560);
        }
    }

    public static void a(aar aar, g gVar, int i, boolean z) {
        AppMethodBeat.i(102561);
        if (i == 1 && (bo.isNullOrNil(aar.wgb) || bo.isNullOrNil(aar.wfZ))) {
            ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.o(102561);
        } else if (i == 0 && bo.isNullOrNil(b(aar))) {
            ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
            AppMethodBeat.o(102561);
        } else if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd) != null) {
            ab.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", aar.mnd);
            AppMethodBeat.o(102561);
        } else {
            int i2;
            ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
            c cVar = new c();
            cVar.field_dataId = aar.mnd;
            cVar.field_totalLen = (int) aar.wgu;
            cVar.field_type = i;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_cdnKey = aar.wgb;
            cVar.field_cdnUrl = aar.wfZ;
            cVar.field_path = b(aar);
            if (aar.dataType == 3) {
                String str = aar.wgo;
                if (!bo.isNullOrNil(str) && str.equals("speex")) {
                    i2 = -3;
                } else if (bo.isNullOrNil(str) || !str.equals("silk")) {
                    i2 = -2;
                } else {
                    i2 = -4;
                }
                cVar.field_dataType = i2;
            } else {
                cVar.field_dataType = aar.dataType;
            }
            cVar.field_modifyTime = bo.anU();
            boolean isWifi = at.isWifi(ah.getContext());
            if (i == 0) {
                ab.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j = ah.getContext().getSharedPreferences(ah.doA(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j == 0) {
                        j = 26214400;
                    }
                    if (((long) cVar.field_totalLen) <= j) {
                        ab.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", Long.valueOf(j));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
                } else {
                    cVar.field_status = 4;
                    ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                ab.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    if (((long) cVar.field_totalLen) <= ah.getContext().getSharedPreferences(ah.doA(), 0).getLong("fav_mx_auto_download_size", 26214400)) {
                        ab.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", Long.valueOf(ah.getContext().getSharedPreferences(ah.doA(), 0).getLong("fav_mx_auto_download_size", 26214400)));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
                } else {
                    cVar.field_status = 4;
                    ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
                }
            }
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().e(cVar);
            if (i == 1) {
                b(cVar);
                AppMethodBeat.o(102561);
                return;
            }
            a(cVar);
            AppMethodBeat.o(102561);
        }
    }

    public static boolean vu(int i) {
        for (int i2 : a.meA) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(g gVar) {
        AppMethodBeat.i(102562);
        if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId) != null) {
            AppMethodBeat.o(102562);
            return true;
        }
        AppMethodBeat.o(102562);
        return false;
    }

    public static void bug() {
        AppMethodBeat.i(102563);
        if (0 >= meD) {
            ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            AppMethodBeat.o(102563);
            return;
        }
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(meD);
        meD = 0;
        if (iE == null) {
            ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            AppMethodBeat.o(102563);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", iE.field_localId);
        a(ah.getContext(), ".ui.FavTagEditUI", intent, null);
        AppMethodBeat.o(102563);
    }

    public static void it(long j) {
        meD = j;
    }

    public static long buh() {
        AppMethodBeat.i(102564);
        long bui = bui() - buj();
        if (bui < 0) {
            bui = 1024;
        }
        AppMethodBeat.o(102564);
        return bui;
    }

    public static long bui() {
        AppMethodBeat.i(102565);
        long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.o(102565);
        return longValue;
    }

    public static long buj() {
        AppMethodBeat.i(102566);
        long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.o(102566);
        return longValue;
    }

    public static String LC(String str) {
        AppMethodBeat.i(102567);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(102567);
            return str;
        } else if (!bo.isNullOrNil(aoO.field_conRemark)) {
            str = aoO.field_conRemark;
            AppMethodBeat.o(102567);
            return str;
        } else if (bo.isNullOrNil(aoO.field_nickname)) {
            str = aoO.field_username;
            AppMethodBeat.o(102567);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.o(102567);
            return str;
        }
    }

    public static String mK(String str) {
        AppMethodBeat.i(102568);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        String str2;
        if (aoO == null) {
            ab.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", str);
            str2 = "";
            AppMethodBeat.o(102568);
            return str2;
        }
        str2 = aoO.Oj();
        if (t.kH(str2)) {
            List my = n.my(str);
            String Yz = r.Yz();
            if (my == null || my.isEmpty()) {
                ab.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
            } else {
                my.remove(Yz);
                my.add(0, Yz);
                str2 = n.f(my, 3);
            }
        }
        AppMethodBeat.o(102568);
        return str2;
    }

    public static void l(g gVar) {
        AppMethodBeat.i(102569);
        if (gVar.bux()) {
            switch (gVar.field_itemStatus) {
                case 3:
                    gVar.field_itemStatus = 1;
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getCheckCdnService().run();
                    AppMethodBeat.o(102569);
                    return;
                case 6:
                    if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iz(gVar.field_localId).size() == 0) {
                        gVar.field_itemStatus = 9;
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                        com.tencent.mm.kernel.g.Rg().a(new af(gVar), 0);
                        AppMethodBeat.o(102569);
                        return;
                    }
                    gVar.field_itemStatus = 4;
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().x(gVar);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                    for (c cVar : ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iz(gVar.field_localId)) {
                        ab.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar.field_dataId, Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(cVar.field_dataId);
                    }
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                    AppMethodBeat.o(102569);
                    return;
                case 11:
                    gVar.field_itemStatus = 9;
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
                    break;
                case 14:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(12, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
                    AppMethodBeat.o(102569);
                    return;
                case 16:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(15, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().x(gVar);
                    for (c cVar2 : ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iz(gVar.field_localId)) {
                        ab.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar2.field_dataId, Integer.valueOf(cVar2.field_dataType), Integer.valueOf(cVar2.field_totalLen));
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(cVar2.field_dataId);
                    }
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                    AppMethodBeat.o(102569);
                    return;
                case 18:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(17, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getModService().run();
                    AppMethodBeat.o(102569);
                    return;
            }
            AppMethodBeat.o(102569);
            return;
        }
        ab.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
        AppMethodBeat.o(102569);
    }

    public static void m(g gVar) {
        AppMethodBeat.i(102570);
        if (gVar == null) {
            AppMethodBeat.o(102570);
        } else if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10) {
            gVar.field_itemStatus = 7;
            LinkedList<aar> linkedList = gVar.field_favProto.wiv;
            if (linkedList.size() == 0) {
                AppMethodBeat.o(102570);
                return;
            }
            for (aar aar : linkedList) {
                a(gVar, aar, true);
                a(gVar, aar);
            }
            AppMethodBeat.o(102570);
        } else {
            ab.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
            AppMethodBeat.o(102570);
        }
    }

    public static void a(g gVar, aar aar, boolean z) {
        AppMethodBeat.i(102571);
        if (gVar == null || bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.o(102571);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), aar.mnd);
        c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd);
        if (LR != null && LR.field_status == 3) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
            LR = null;
        }
        if (LR != null && (bo.isNullOrNil(LR.field_cdnUrl) || bo.isNullOrNil(LR.field_cdnKey) || bo.isNullOrNil(LR.field_dataId) || !LR.field_cdnUrl.equals(aar.wfZ) || !LR.field_cdnKey.equals(aar.wgb) || !LR.field_dataId.equals(aar.mnd))) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b(aar));
            if (!(bo.isNullOrNil(aar.wgb) || bo.isNullOrNil(aar.wfZ) || bVar.exists())) {
                ab.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                a(aar, gVar, 1, true);
                if (z) {
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(aar.mnd);
                    if (!bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().c(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd));
                    }
                }
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(102571);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        LR.field_status = 1;
        LR.field_path = b(aar);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
        if (z) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(aar.mnd);
            if (!bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().c(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd));
            }
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
        AppMethodBeat.o(102571);
    }

    public static void d(aar aar) {
        AppMethodBeat.i(102573);
        c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd);
        if (!(LR == null || LR.field_status == 3)) {
            LR.field_status = 2;
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().pauseDownload(aar.mnd);
        }
        LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(LA(aar.mnd));
        if (!(LR == null || LR.field_status == 3)) {
            LR.field_status = 2;
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().pauseDownload(LA(aar.mnd));
        }
        AppMethodBeat.o(102573);
    }

    public static void n(g gVar) {
        AppMethodBeat.i(102574);
        if (gVar.buw()) {
            ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", Integer.valueOf(gVar.field_itemStatus));
            Iterator it = gVar.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd);
                if (!(LR == null || LR.field_status == 3)) {
                    LR.field_status = 2;
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LQ(aar.mnd);
                }
                LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(LA(aar.mnd));
                if (!(LR == null || LR.field_status == 3)) {
                    LR.field_status = 2;
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LQ(LA(aar.mnd));
                }
            }
            g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId);
            ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", Integer.valueOf(iE.field_itemStatus));
            switch (iE.field_itemStatus) {
                case 1:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(3, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(3));
                    AppMethodBeat.o(102574);
                    return;
                case 4:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(6, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(6));
                    AppMethodBeat.o(102574);
                    return;
                case 9:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(11, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(11));
                    AppMethodBeat.o(102574);
                    return;
                case 12:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(14, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(14));
                    AppMethodBeat.o(102574);
                    return;
                case 15:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(16, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(16));
                    AppMethodBeat.o(102574);
                    return;
                case 17:
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(18, iE.field_localId);
                    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(18));
                    break;
            }
            AppMethodBeat.o(102574);
            return;
        }
        ab.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
        AppMethodBeat.o(102574);
    }

    public static boolean buk() {
        AppMethodBeat.i(102575);
        if (bui() == 0) {
            AppMethodBeat.o(102575);
            return false;
        } else if (buh() < 52428800) {
            AppMethodBeat.o(102575);
            return true;
        } else {
            AppMethodBeat.o(102575);
            return false;
        }
    }

    public static float fY(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        AppMethodBeat.i(102576);
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.o(102576);
        return f;
    }

    public static float iu(long j) {
        float f = 1.0f;
        AppMethodBeat.i(102577);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.o(102577);
        return f;
    }

    public static String iv(long j) {
        AppMethodBeat.i(102578);
        String str;
        if (j == 0) {
            str = "0KB";
            AppMethodBeat.o(102578);
            return str;
        } else if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            str = String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
            AppMethodBeat.o(102578);
            return str;
        } else if ((((double) j) * 1.0d) / 1024.0d >= 1.0d) {
            str = String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
            AppMethodBeat.o(102578);
            return str;
        } else {
            str = "1KB";
            AppMethodBeat.o(102578);
            return str;
        }
    }

    public static String aC(float f) {
        AppMethodBeat.i(102579);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.o(102579);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.o(102579);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(102579);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(102579);
            return format;
        }
    }

    public static boolean e(aar aar) {
        AppMethodBeat.i(102580);
        com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
        if (aih != null && aih.fJS == 6 && bo.bc(aar.mnd, "").equals(aih.fJU) && com.tencent.mm.aw.a.aie()) {
            AppMethodBeat.o(102580);
            return true;
        }
        AppMethodBeat.o(102580);
        return false;
    }

    public static String bul() {
        AppMethodBeat.i(102581);
        String str = com.tencent.mm.kernel.g.RP().eJM + "favorite/music/";
        AppMethodBeat.o(102581);
        return str;
    }

    public static boolean o(g gVar) {
        AppMethodBeat.i(102583);
        if (gVar == null) {
            AppMethodBeat.o(102583);
            return false;
        }
        aar c = c(gVar);
        if (c == null) {
            AppMethodBeat.o(102583);
            return false;
        }
        int ckU;
        int i;
        boolean a;
        long yz = bo.yz();
        com.tencent.mm.plugin.sight.base.a WR = d.WR(b(c));
        if (WR != null) {
            ckU = WR.ckU();
            i = c.duration;
            if (i <= 0 || Math.abs(i - ckU) >= 2) {
                c.LD(ckU);
                a = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            ckU = 0;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", Integer.valueOf(i), Integer.valueOf(ckU), Boolean.valueOf(a), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(102583);
        return a;
    }

    public static String bum() {
        AppMethodBeat.i(102584);
        String str = com.tencent.mm.kernel.g.RP().eJM + "favorite/";
        AppMethodBeat.o(102584);
        return str;
    }

    public static String bun() {
        AppMethodBeat.i(102585);
        String str = com.tencent.mm.kernel.g.RP().eJM + "favorite/voice/";
        AppMethodBeat.o(102585);
        return str;
    }

    public static List<g> a(long j, int i, Set<Integer> set, w wVar) {
        AppMethodBeat.i(102586);
        if (j == 0) {
            List a = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(i, set, wVar);
            AppMethodBeat.o(102586);
            return a;
        }
        List<g> b = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().b(j, i, set, wVar);
        AppMethodBeat.o(102586);
        return b;
    }

    public static long q(long j, int i) {
        AppMethodBeat.i(102587);
        ab.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
        long w = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().w(j, i);
        long u = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().u(j, i);
        ab.v("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(w), Long.valueOf(u), Long.valueOf(j));
        if (w == 0) {
            AppMethodBeat.o(102587);
            return u;
        }
        LinkedList v = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().v(w, i);
        if (v.size() > 0) {
            ab.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(w), Long.valueOf(u), Long.valueOf(j));
            ab.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", Integer.valueOf(v.size()));
            if (!com.tencent.mm.kernel.g.Rg().a(new ah(v), 0)) {
                ab.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
                ah.bve();
            }
        }
        if (u == 0) {
            AppMethodBeat.o(102587);
            return w;
        } else if (w < u) {
            AppMethodBeat.o(102587);
            return w;
        } else {
            AppMethodBeat.o(102587);
            return u;
        }
    }

    public static void startSync() {
        AppMethodBeat.i(102588);
        com.tencent.mm.kernel.g.Rg().a(new aj(), 0);
        AppMethodBeat.o(102588);
    }

    public static String LD(String str) {
        AppMethodBeat.i(102589);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102589);
            return null;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bue() + g.x(str.getBytes()));
        if (bVar.exists()) {
            String w = j.w(bVar.dMD());
            AppMethodBeat.o(102589);
            return w;
        }
        AppMethodBeat.o(102589);
        return null;
    }

    public static boolean f(aar aar) {
        AppMethodBeat.i(102590);
        boolean exists = new com.tencent.mm.vfs.b(b(aar)).exists();
        AppMethodBeat.o(102590);
        return exists;
    }

    public static boolean g(aar aar) {
        AppMethodBeat.i(102591);
        boolean amo = com.tencent.mm.sdk.platformtools.r.amo(b(aar));
        AppMethodBeat.o(102591);
        return amo;
    }

    public static boolean buo() {
        AppMethodBeat.i(102592);
        if (ah.bvf() > 0) {
            AppMethodBeat.o(102592);
            return true;
        }
        AppMethodBeat.o(102592);
        return false;
    }

    public static boolean a(long j, Runnable runnable) {
        AppMethodBeat.i(102595);
        boolean a = a(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j), true, runnable);
        AppMethodBeat.o(102595);
        return a;
    }

    public static void p(g gVar) {
        int i;
        j jVar;
        AppMethodBeat.i(102596);
        j iH = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().iH(gVar.field_localId);
        if (iH == null) {
            iH = new j();
            iH.field_localId = gVar.field_localId;
            i = 1;
            jVar = iH;
        } else {
            i = 0;
            jVar = iH;
        }
        jVar.field_tagContent = "";
        for (String str : gVar.field_tagProto.wiI) {
            jVar.field_tagContent += " " + str;
        }
        for (String str2 : gVar.field_tagProto.wiJ) {
            jVar.field_tagContent += " " + str2;
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().LM(str2);
        }
        jVar.field_content = "";
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (i != 0) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().a(jVar);
            AppMethodBeat.o(102596);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().a(jVar, "localId");
        AppMethodBeat.o(102596);
    }

    public static ArrayList<g> a(List<String> list, List<String> list2, List<Integer> list3, List<g> list4, Set<Integer> set, w wVar) {
        AppMethodBeat.i(102597);
        ArrayList b = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavSearchStorage().b(list, list2, list3);
        ArrayList<g> arrayList = new ArrayList();
        if (b.size() == 0) {
            AppMethodBeat.o(102597);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < b.size() ? i + 20 : b.size();
            ab.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(b.size()));
            ArrayList a = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(b.subList(i, size), list4, set, wVar);
            if (a != null && a.size() > 0) {
                if (list3.contains(Integer.valueOf(8))) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        g gVar = (g) it.next();
                        if (gVar.field_type == 18) {
                            Object obj;
                            try {
                                LinkedList linkedList = gVar.field_favProto.wiv;
                                i = 1;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= linkedList.size()) {
                                        obj = null;
                                        break;
                                    } else if (((aar) linkedList.get(i2)).dataType == 8) {
                                        obj = 1;
                                        break;
                                    } else {
                                        i = i2 + 1;
                                    }
                                }
                            } catch (Exception e) {
                                obj = null;
                            }
                            if (obj != null) {
                                arrayList.add(gVar);
                            }
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                } else {
                    arrayList.addAll(a);
                }
            }
            if (size >= b.size()) {
                AppMethodBeat.o(102597);
                return arrayList;
            }
            i = size;
        }
    }

    public static int LE(String str) {
        AppMethodBeat.i(102598);
        if (!bo.isNullOrNil(str) && str.equals("speex")) {
            AppMethodBeat.o(102598);
            return 1;
        } else if (bo.isNullOrNil(str) || !str.equals("silk")) {
            AppMethodBeat.o(102598);
            return 0;
        } else {
            AppMethodBeat.o(102598);
            return 2;
        }
    }

    public static boolean bup() {
        AppMethodBeat.i(102599);
        if (bui() == 0) {
            AppMethodBeat.o(102599);
            return false;
        } else if (buh() < 10485760) {
            AppMethodBeat.o(102599);
            return true;
        } else {
            AppMethodBeat.o(102599);
            return false;
        }
    }

    public static g LF(String str) {
        AppMethodBeat.i(102600);
        g gVar = new g();
        gVar.field_localId = -1;
        gVar.field_id = -1;
        gVar.field_xml = str;
        gVar.field_type = 18;
        gVar.LH(str);
        AppMethodBeat.o(102600);
        return gVar;
    }

    private static g LG(String str) {
        AppMethodBeat.i(102601);
        if (str == null || str.equals("")) {
            ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
            AppMethodBeat.o(102601);
            return null;
        }
        String str2;
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (replace.startsWith("<noteinfo>")) {
            str2 = replace;
        } else {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        }
        Map z = br.z(str2, "noteinfo");
        if (z == null) {
            ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            AppMethodBeat.o(102601);
            return null;
        }
        g gVar = new g();
        try {
            gVar.field_favProto = new abf();
            gVar.field_type = 18;
            gVar.field_favProto.mk(bo.getLong((String) z.get(".noteinfo.edittime"), 0));
            aaz aaz = new aaz();
            aaz.win = (String) z.get(".noteinfo.noteeditor");
            aaz.wim = (String) z.get(".noteinfo.noteauthor");
            gVar.field_favProto.a(aaz);
            gVar.field_localId = bo.getLong((String) z.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            com.tencent.mm.plugin.fav.a.a.b.a(str2, gVar.field_favProto);
            AppMethodBeat.o(102601);
            return gVar;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
            ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", e.toString());
            AppMethodBeat.o(102601);
            return null;
        }
    }

    public static void e(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(102602);
        g LG = LG(str);
        if (LG == null) {
            AppMethodBeat.o(102602);
            return;
        }
        ld ldVar = new ld();
        ldVar.cGU.type = 2;
        ldVar.cGU.field_localId = -1;
        ldVar.cGU.context = context;
        ldVar.cGU.cHa = 4;
        ldVar.cGU.cHc = true;
        Bundle bundle = new Bundle();
        bundle.putString("noteauthor", LG.field_favProto.vzK.wim);
        bundle.putString("noteeditor", LG.field_favProto.vzK.win);
        bundle.putLong("edittime", LG.field_favProto.lgR);
        bundle.putString("notexml", g.s(LG));
        bundle.putString("snslocalid", str2);
        bundle.putString("snsthumbpath", str3);
        bundle.putString("snsnotelinkxml", str);
        ldVar.cGU.cGZ = bundle;
        ldVar.cGU.field_favProto = LG.field_favProto;
        com.tencent.mm.sdk.b.a.xxA.m(ldVar);
        AppMethodBeat.o(102602);
    }

    private static void b(gh ghVar) {
        AppMethodBeat.i(102603);
        g LG = LG(ghVar.cAH.desc);
        if (LG == null) {
            AppMethodBeat.o(102603);
            return;
        }
        if (!(LG.field_favProto == null || LG.field_favProto.wiv == null)) {
            Iterator it = LG.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (aar.dataType == 20) {
                    aar.oY(true);
                    aar.oX(true);
                    aar.akV("");
                    aar.akL("");
                    aar.akM("");
                    aar.akJ("");
                    aar.akK("");
                }
            }
        }
        ghVar.cAH.cvC = LG.field_favProto;
        AppMethodBeat.o(102603);
    }

    public static g a(abf abf) {
        AppMethodBeat.i(102604);
        g gVar = new g();
        gVar.field_favProto = new abf();
        gVar.field_type = 18;
        gVar.field_favProto = abf;
        AppMethodBeat.o(102604);
        return gVar;
    }

    private static void b(g gVar, boolean z) {
        AppMethodBeat.i(102605);
        aaz aaz = new aaz();
        if (!z) {
            aaz.wim = r.Yz();
        }
        aaz.win = r.Yz();
        gVar.field_favProto.mk(bo.anT());
        gVar.field_favProto.a(aaz);
        AppMethodBeat.o(102605);
    }

    public static void q(g gVar) {
        AppMethodBeat.i(102606);
        if (gVar == null) {
            AppMethodBeat.o(102606);
            return;
        }
        aaz aaz = gVar.field_favProto.vzK;
        if (aaz == null || bo.isNullOrNil(aaz.win)) {
            if (gVar.field_type == 18) {
                if (gVar.field_favProto.wit.cvp == 6) {
                    b(gVar, false);
                } else {
                    b(gVar, true);
                }
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
            }
            AppMethodBeat.o(102606);
            return;
        }
        AppMethodBeat.o(102606);
    }

    public static void c(gh ghVar) {
        AppMethodBeat.i(102607);
        g gVar;
        if (ghVar.cAH.cAO == 1) {
            String str;
            ghVar.cAI.path = ip(ghVar.cAH.cvv);
            com.tencent.mm.g.a.gh.b bVar = ghVar.cAI;
            g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
            if (iE == null || iE.field_favProto == null) {
                str = "";
            } else {
                if (iE.field_type != 18 || iE.field_favProto.wiv.size() > 1) {
                    Iterator it = iE.field_favProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        switch (aar.dataType) {
                            case 2:
                                str = c(aar);
                                if (!e.ct(str)) {
                                    String b = b(aar);
                                    if (!e.ct(b)) {
                                        if (!aar.wfU) {
                                            if (!aar.wga) {
                                                str = "";
                                                break;
                                            }
                                            a(iE, aar, true);
                                            str = b;
                                            break;
                                        }
                                        a(iE, aar);
                                        break;
                                    }
                                    com.tencent.mm.sdk.platformtools.d.c(b, 150, 150, CompressFormat.JPEG, 90, str);
                                    str = c(aar);
                                    break;
                                }
                                break;
                            default:
                        }
                    }
                }
                str = "";
            }
            bVar.thumbPath = str;
            AppMethodBeat.o(102607);
        } else if (ghVar.cAH.cAO == 2) {
            gVar = new g();
            gVar.field_type = 2;
            aar aar2 = new aar();
            aar2.akU(cf(aar2.toString(), 2));
            String b2 = b(aar2);
            aar2.akV(b2);
            aar2.LE(2);
            gVar.field_favProto.wiv.add(aar2);
            ghVar.cAI.path = g.s(gVar);
            ghVar.cAI.thumbPath = b2;
            AppMethodBeat.o(102607);
        } else if (ghVar.cAH.cAO == 3) {
            gVar = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
            if (gVar != null) {
                ghVar.cAI.path = r.Yz() + ";" + gVar.field_fromUser + ";" + gVar.field_updateTime;
            }
            AppMethodBeat.o(102607);
        } else if (ghVar.cAH.cAO == 4) {
            b(ghVar);
            AppMethodBeat.o(102607);
        } else if (ghVar.cAH.cAO == 5) {
            a(ghVar);
            AppMethodBeat.o(102607);
        } else if (ghVar.cAH.cAO == 6) {
            gVar = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
            if (gVar == null) {
                ghVar.cAI.ret = 0;
                AppMethodBeat.o(102607);
                return;
            }
            int i;
            com.tencent.mm.g.a.gh.b bVar2 = ghVar.cAI;
            if (gVar.field_id > 0) {
                i = 1;
            } else {
                i = 0;
            }
            bVar2.ret = i;
            AppMethodBeat.o(102607);
        } else {
            gVar = new g();
            gVar.field_type = 18;
            gVar.field_favProto = ghVar.cAH.cvC;
            ghVar.cAI.path = g.s(gVar);
            AppMethodBeat.o(102607);
        }
    }

    public static void a(g gVar, int i) {
        AppMethodBeat.i(102608);
        if (gVar == null) {
            ab.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
            AppMethodBeat.o(102608);
            return;
        }
        LinkedList linkedList = new LinkedList();
        bca bca = new bca();
        bca.wGC = 4;
        bca.wGD = 0;
        linkedList.add(bca);
        LinkedList linkedList2 = new LinkedList();
        bcd bcd = new bcd();
        bcd.ncF = "favitem.taglist";
        bcd.jCt = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = gVar.field_tagProto.wiJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bo.ani((String) gVar.field_tagProto.wiJ.get(i2))).append("</tag>");
        }
        bcd.pXM = stringBuffer.toString();
        ab.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", Integer.valueOf(gVar.field_id), bcd.pXM);
        linkedList2.add(bcd);
        if (gVar.field_id > 0) {
            com.tencent.mm.kernel.g.Rg().a(new al(gVar.field_id, linkedList, linkedList2), 0);
            h.k((long) gVar.field_id, size, i);
            AppMethodBeat.o(102608);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getEditService().a(gVar.field_localId, linkedList, linkedList2, i);
        AppMethodBeat.o(102608);
    }

    public static void b(Context context, String str, Intent intent) {
        AppMethodBeat.i(139140);
        a(context, str, intent, null);
        AppMethodBeat.o(139140);
    }

    public static void a(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(102610);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                ab.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.o(102610);
                return;
            }
        }
        String str2 = ah.doz() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.o(102610);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.o(102610);
    }

    public static void a(Context context, String str, Intent intent, int i) {
        AppMethodBeat.i(102611);
        a(context, str, intent, i, null);
        AppMethodBeat.o(102611);
    }

    public static void a(Context context, String str, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.i(102612);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                ab.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.o(102612);
                return;
            }
        }
        String str2 = ah.doz() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i, bundle);
        }
        AppMethodBeat.o(102612);
    }

    public static void c(String str, Context context) {
        AppMethodBeat.i(102613);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
            AppMethodBeat.o(102613);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.bp.d.f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(102613);
    }

    public static void v(Intent intent, Context context) {
        AppMethodBeat.i(102615);
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 1);
            com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
        AppMethodBeat.o(102615);
    }

    public static void e(String str, Context context) {
        AppMethodBeat.i(102616);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
            AppMethodBeat.o(102616);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", str);
        intent.putExtra("Retr_Msg_Type", 4);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.bp.d.f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(102616);
    }

    public static void a(long j, aay aay, String str, String str2, ArrayList<String> arrayList, Context context) {
        AppMethodBeat.i(102617);
        if (aay == null || context == null) {
            AppMethodBeat.o(102617);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", j);
        intent.putExtra("kwebmap_slat", aay.lat);
        intent.putExtra("kwebmap_lng", aay.lng);
        intent.putExtra("kPoiName", aay.cIK);
        intent.putExtra("Kwebmap_locaion", aay.label);
        if (aay.cED >= 0) {
            intent.putExtra("kwebmap_scale", aay.cED);
        }
        intent.putExtra("kisUsername", str);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("kRemark", str2);
        intent.putExtra("kTags", arrayList);
        intent.putExtra("kFavCanDel", true);
        intent.putExtra("kFavCanRemark", true);
        com.tencent.mm.bp.d.b(context, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(102617);
    }

    public static String[] a(final g gVar, ak akVar) {
        String str = null;
        AppMethodBeat.i(102618);
        if (gVar == null) {
            ab.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            AppMethodBeat.o(102618);
            return null;
        }
        final aar c = c(gVar);
        String[] strArr = new String[2];
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(102522);
                b.a(gVar, c);
                AppMethodBeat.o(102522);
            }
        };
        abe abe;
        switch (gVar.field_type) {
            case 5:
                abu abu = gVar.field_favProto.whA;
                if (c == null) {
                    if (abu != null) {
                        strArr[1] = abu.thumbUrl;
                        break;
                    }
                }
                String str2;
                if (abu == null) {
                    str2 = null;
                } else {
                    str2 = abu.thumbUrl;
                }
                if (bo.isNullOrNil(str2)) {
                    str2 = c.cvq;
                }
                strArr[0] = c(c);
                strArr[1] = str2;
                akVar.post(anonymousClass3);
                break;
                break;
            case 10:
                abe = gVar.field_favProto.whC;
                if (abe != null) {
                    strArr[1] = abe.thumbUrl;
                    break;
                }
                break;
            case 11:
                abe = gVar.field_favProto.whC;
                if (abe != null) {
                    strArr[1] = abe.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (gVar.field_favProto.wiv != null) {
                    Iterator it = gVar.field_favProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        if (aar.dataType == 2) {
                            str = b(aar);
                            akVar.post(anonymousClass3);
                        } else if (aar.dataType == 15) {
                            str = c(aar);
                            akVar.post(anonymousClass3);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = c.cvq;
                break;
            case 15:
                abo abo = gVar.field_favProto.whE;
                if (abo != null) {
                    strArr[1] = abo.thumbUrl;
                    break;
                }
                break;
            default:
                if (c != null) {
                    strArr[0] = c(c);
                    strArr[1] = c.cvq;
                    akVar.post(anonymousClass3);
                    break;
                }
                break;
        }
        ab.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", strArr[0], strArr[1], Integer.valueOf(gVar.field_type));
        AppMethodBeat.o(102618);
        return strArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String r(g gVar) {
        String str;
        AppMethodBeat.i(102619);
        StringBuffer stringBuffer = new StringBuffer();
        aar aar;
        switch (gVar.field_type) {
            case 1:
                if (!bo.isNullOrNil(gVar.field_favProto.desc)) {
                    stringBuffer.append(gVar.field_favProto.desc.getBytes().length);
                    break;
                }
                break;
            case 2:
            case 8:
                long j = 0;
                Iterator it = gVar.field_favProto.wiv.iterator();
                while (true) {
                    long j2 = j;
                    if (!it.hasNext()) {
                        stringBuffer.append(j2);
                        break;
                    }
                    aar = (aar) it.next();
                    if (aar != null) {
                        j = aar.wgu + j2;
                    } else {
                        j = j2;
                    }
                }
            case 3:
            case 4:
            case 16:
                stringBuffer.append(c(gVar).duration);
                break;
            case 5:
                str = "";
                try {
                    str = gVar.field_favProto.whA.wiY;
                } catch (Exception e) {
                }
                stringBuffer.append(str);
                break;
            case 14:
            case 18:
                if (gVar != null) {
                    Iterator it2 = gVar.field_favProto.wiv.iterator();
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (it2.hasNext()) {
                        int i5;
                        aar = (aar) it2.next();
                        switch (aar.dataType) {
                            case 1:
                                if (bo.isNullOrNil(aar.desc)) {
                                    i5 = i;
                                } else {
                                    i3 = aar.desc.getBytes().length + i3;
                                    continue;
                                }
                            case 2:
                                i2++;
                                continue;
                            case 4:
                                i4++;
                                continue;
                            default:
                                i5 = i + 1;
                        }
                        i = i5;
                    }
                    str = String.format("%d:%d:%d:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i)});
                    AppMethodBeat.o(102619);
                    return str;
                }
                break;
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(102619);
        return str;
    }

    public static String a(aar aar) {
        AppMethodBeat.i(102523);
        aas aas = aar.wgT;
        String str = "";
        switch (aar.dataType) {
            case 1:
                str = ek(str, aar.desc);
                break;
            case 4:
                if (aas.whE != null) {
                    str = ek(str, aas.whE.title);
                    break;
                }
                break;
            case 5:
                if (aas.whA != null) {
                    str = ek(str, aas.whA.title);
                    break;
                }
                break;
            case 6:
                str = ek(str, aas.hHV);
                if (aas.why != null) {
                    str = ek(ek(str, aas.why.cIK), aas.why.label);
                    break;
                }
                break;
            case 8:
                str = ek(str, aas.title);
                break;
            case 10:
            case 11:
                if (aas.whC != null) {
                    str = ek(ek(str, aas.whC.title), aas.whC.desc);
                    break;
                }
                break;
            default:
                str = ek(ek(str, aas.title), aas.desc);
                break;
        }
        AppMethodBeat.o(102523);
        return str;
    }

    public static void a(g gVar, aar aar) {
        AppMethodBeat.i(102572);
        if (bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.o(102572);
            return;
        }
        String LA = LA(aar.mnd);
        c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(LA);
        if (LR != null && LR.field_status == 3) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(c(aar));
            if (!(bo.isNullOrNil(aar.wfV) || bo.isNullOrNil(aar.fgE) || bVar.exists())) {
                a(aar, gVar, 1);
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(LA);
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
            }
            AppMethodBeat.o(102572);
            return;
        }
        LR.field_status = 1;
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(LA);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
        AppMethodBeat.o(102572);
    }

    public static String getAppName(Context context, String str) {
        AppMethodBeat.i(102582);
        com.tencent.mm.model.ad.b bVar = com.tencent.mm.model.ad.a.fls;
        String t;
        if (bVar != null) {
            t = bVar.t(context, str);
            AppMethodBeat.o(102582);
            return t;
        }
        t = "";
        AppMethodBeat.o(102582);
        return t;
    }

    public static void a(aar aar, int i, long j) {
        AppMethodBeat.i(102593);
        if (bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.o(102593);
        } else if (bo.isNullOrNil(aar.wfV) || bo.isNullOrNil(aar.fgE)) {
            AppMethodBeat.o(102593);
        } else {
            String LA = LA(aar.mnd);
            c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(LA);
            if (LR != null && (LR.field_status == 3 || LR.field_status == 4)) {
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
                LR = null;
            }
            if (LR == null || LR.field_type != 1) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(c(aar));
                if (!(bo.isNullOrNil(aar.wfV) || bo.isNullOrNil(aar.fgE) || bVar.exists())) {
                    g gVar = new g();
                    gVar.field_localId = j;
                    gVar.field_id = -1;
                    gVar.field_type = i;
                    a(aar, gVar, 1);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(LA);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                }
                AppMethodBeat.o(102593);
                return;
            }
            LR.field_status = 1;
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(LA);
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
            AppMethodBeat.o(102593);
        }
    }

    public static void b(aar aar, int i, long j) {
        AppMethodBeat.i(102594);
        if (bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.o(102594);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", aar.mnd);
        c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(aar.mnd);
        if (LR != null && (LR.field_status == 3 || LR.field_status == 4)) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b(aar));
            if (!(bo.isNullOrNil(aar.wgb) || bo.isNullOrNil(aar.wfZ) || bVar.exists())) {
                ab.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                g gVar = new g();
                gVar.field_localId = j;
                gVar.field_id = -1;
                gVar.field_type = i;
                a(aar, gVar, 1, true);
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(aar.mnd);
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(102594);
            return;
        }
        ab.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        LR.field_status = 1;
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(LR, "dataId");
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().LP(aar.mnd);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
        AppMethodBeat.o(102594);
    }

    public static void d(String str, Context context) {
        AppMethodBeat.i(102614);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
            AppMethodBeat.o(102614);
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + r.Yz() + "_0";
        String nW = v.nW(str2);
        v.Zp().y(nW, true).j("prePublishId", str2);
        intent.putExtra("reportSessionId", nW);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(102614);
    }
}
