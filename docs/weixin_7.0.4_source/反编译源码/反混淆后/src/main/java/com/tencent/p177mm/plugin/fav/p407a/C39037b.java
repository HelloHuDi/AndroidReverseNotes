package com.tencent.p177mm.plugin.fav.p407a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26408ad.C26409b;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p230g.p231a.C18356ow;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C37721gh.C9356b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.p1400a.C27960b;
import com.tencent.p177mm.plugin.fav.p407a.p1400a.C43051a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aaw;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abs;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.a.b */
public final class C39037b {
    private static HashMap<Long, ArrayList<String>> meC = new HashMap();
    private static long meD = 0;

    /* renamed from: ek */
    private static String m66391ek(String str, String str2) {
        AppMethodBeat.m2504i(102524);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102524);
            return str2;
        } else if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(102524);
            return str;
        } else {
            str2 = str + "​" + str2;
            AppMethodBeat.m2505o(102524);
            return str2;
        }
    }

    /* renamed from: cf */
    public static String m66382cf(String str, int i) {
        AppMethodBeat.m2504i(102525);
        String x = C1178g.m2591x((str + i + System.currentTimeMillis()).getBytes());
        AppMethodBeat.m2505o(102525);
        return x;
    }

    /* renamed from: a */
    public static long m66344a(C27966g c27966g) {
        long j = 0;
        AppMethodBeat.m2504i(102526);
        for (int i : C20671a.meA) {
            if (i == c27966g.field_type) {
                long j2;
                if (c27966g.field_favProto != null) {
                    Iterator it = c27966g.field_favProto.wiv.iterator();
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
                c27966g.field_datatotalsize = j2;
                C4990ab.m7411d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", Integer.valueOf(c27966g.field_id), Long.valueOf(j2));
                AppMethodBeat.m2505o(102526);
                return j2;
            }
        }
        AppMethodBeat.m2505o(102526);
        return 0;
    }

    /* renamed from: a */
    public static aaw m66347a(int i, abf abf, abs abs) {
        AppMethodBeat.m2504i(102527);
        if (abf == null) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "proto item is null");
            AppMethodBeat.m2505o(102527);
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
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 2:
                if (abf.wiv != null && abf.wiv.size() > 0) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 4:
                if (!(abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 5:
                if (abf.whA != null) {
                    aaw.title = abf.whA.title;
                    aaw.desc = abf.whA.wiY;
                }
                if (!(!C5046bo.isNullOrNil(aaw.title) || abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                if (C5046bo.isNullOrNil(aaw.desc) && abl != null) {
                    aaw.desc = abl.link;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 6:
                aaw.title = abf.hHV;
                if (C5046bo.isNullOrNil(aaw.title)) {
                    if (abf.why != null) {
                        aaw.title = abf.why.cIK;
                        aaw.desc = abf.why.label;
                    }
                } else if (abf.why != null) {
                    aaw.desc = abf.why.cIK;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 7:
                if (!(abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                    aaw.desc = ((aar) abf.wiv.get(0)).desc;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 8:
                aaw.title = abf.title;
                if (!(!C5046bo.isNullOrNil(aaw.title) || abf.wiv == null || abf.wiv.isEmpty())) {
                    aaw.title = ((aar) abf.wiv.get(0)).title;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 10:
            case 11:
                if (abf.whC != null) {
                    aaw.title = abf.whC.title;
                    aaw.desc = abf.whC.desc;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 12:
            case 15:
                if (abf.whE != null) {
                    aaw.title = abf.whE.title;
                    aaw.desc = abf.whE.desc;
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            case 14:
            case 18:
                LinkedList<aar> linkedList = abf.wiv;
                if (linkedList == null) {
                    AppMethodBeat.m2505o(102527);
                    return null;
                }
                for (aar aar : linkedList) {
                    if (1 == aar.dataType) {
                        aaw.title = aar.desc;
                        AppMethodBeat.m2505o(102527);
                        return aaw;
                    }
                }
                AppMethodBeat.m2505o(102527);
                return aaw;
            default:
                C4990ab.m7421w("MicroMsg.Fav.FavApiLogic", "unknown type %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(102527);
                return aaw;
        }
    }

    /* renamed from: b */
    public static long m66369b(C27966g c27966g) {
        AppMethodBeat.m2504i(102528);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102528);
            return 0;
        }
        int i = 0;
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = (int) (((aar) it.next()).wgu + ((long) i2));
            } else {
                long j = (long) i2;
                AppMethodBeat.m2505o(102528);
                return j;
            }
        }
    }

    /* renamed from: c */
    public static aar m66378c(C27966g c27966g) {
        AppMethodBeat.m2504i(102529);
        aar aar;
        if (c27966g == null) {
            aar = new aar();
            AppMethodBeat.m2505o(102529);
            return aar;
        } else if (c27966g.field_favProto.wiv.size() == 0) {
            aar = new aar();
            AppMethodBeat.m2505o(102529);
            return aar;
        } else {
            aar = (aar) c27966g.field_favProto.wiv.get(0);
            AppMethodBeat.m2505o(102529);
            return aar;
        }
    }

    /* renamed from: in */
    public static void m66399in(long j) {
        AppMethodBeat.m2504i(102530);
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", Long.valueOf(j));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(j));
        AppMethodBeat.m2505o(102530);
    }

    /* renamed from: io */
    public static void m66400io(long j) {
        AppMethodBeat.m2504i(102531);
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", Long.valueOf(j));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(j));
        AppMethodBeat.m2505o(102531);
    }

    /* renamed from: ip */
    private static String m66401ip(long j) {
        AppMethodBeat.m2504i(102532);
        StringBuilder stringBuilder = new StringBuilder();
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        String str;
        if (iE == null || iE.field_favProto == null || iE.field_favProto.wiv.size() <= 1) {
            str = "";
            AppMethodBeat.m2505o(102532);
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
        stringBuilder.append(C43051a.m76486bK(iE.field_favProto.wiv).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        stringBuilder.append("</noteinfo>");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(102532);
        return str;
    }

    static {
        AppMethodBeat.m2504i(102620);
        AppMethodBeat.m2505o(102620);
    }

    /* renamed from: a */
    private static void m66355a(C37721gh c37721gh) {
        AppMethodBeat.m2504i(102533);
        if (C5046bo.isNullOrNil(c37721gh.cAH.desc)) {
            c37721gh.cAI.ret = -1;
            AppMethodBeat.m2505o(102533);
            return;
        }
        C27966g LG = C39037b.m66342LG(c37721gh.cAH.desc);
        if (LG == null || LG.field_localId <= 0) {
            c37721gh.cAI.ret = -1;
            AppMethodBeat.m2505o(102533);
            return;
        }
        boolean e = C39037b.m66389e(LG);
        String str = c37721gh.cAH.cAN;
        ArrayList arrayList;
        if (e) {
            c37721gh.cAI.ret = 1;
            arrayList = (ArrayList) meC.get(Long.valueOf(LG.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    meC.remove(Long.valueOf(LG.field_localId));
                }
            }
            AppMethodBeat.m2505o(102533);
        } else if (C5046bo.isNullOrNil(str)) {
            c37721gh.cAI.ret = -1;
            AppMethodBeat.m2505o(102533);
        } else {
            long j = LG.field_localId;
            if (meC.get(Long.valueOf(j)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) meC.get(Long.valueOf(j));
            }
            arrayList.add(str);
            meC.put(Long.valueOf(j), arrayList);
            final C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
            if (iE == null || iE.field_localId <= 0) {
                c37721gh.cAI.ret = -1;
                AppMethodBeat.m2505o(102533);
            } else if (C39037b.m66389e(iE) || iE.field_itemStatus == 10) {
                c37721gh.cAI.ret = -1;
                C1720g.m3539RS().mo10310m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(102520);
                        C39037b.m66383d(iE);
                        AppMethodBeat.m2505o(102520);
                    }
                }, 500);
                AppMethodBeat.m2505o(102533);
            } else {
                c37721gh.cAI.ret = -1;
                AppMethodBeat.m2505o(102533);
            }
        }
    }

    /* renamed from: d */
    public static synchronized void m66383d(C27966g c27966g) {
        synchronized (C39037b.class) {
            AppMethodBeat.m2504i(102534);
            if (c27966g == null || c27966g.field_type != 18) {
                AppMethodBeat.m2505o(102534);
            } else if (!meC.containsKey(Long.valueOf(c27966g.field_localId))) {
                AppMethodBeat.m2505o(102534);
            } else if (meC.get(Long.valueOf(c27966g.field_localId)) == null || ((ArrayList) meC.get(Long.valueOf(c27966g.field_localId))).size() == 0) {
                AppMethodBeat.m2505o(102534);
            } else {
                C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", Long.valueOf(c27966g.field_localId), C39037b.m66401ip(c27966g.field_localId));
                C18356ow c18356ow = new C18356ow();
                c18356ow.cLi.cLj = (ArrayList) meC.get(Long.valueOf(c27966g.field_localId));
                c18356ow.cLi.cLk = r2;
                C4879a.xxA.mo10055m(c18356ow);
                meC.remove(Long.valueOf(c27966g.field_localId));
                AppMethodBeat.m2505o(102534);
            }
        }
    }

    /* renamed from: e */
    private static boolean m66389e(C27966g c27966g) {
        AppMethodBeat.m2504i(102535);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102535);
            return false;
        }
        boolean z;
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if ((aar.dataType == 8 || aar.dataType == 4 || aar.dataType == 2 || aar.dataType == 3) && (C5046bo.isNullOrNil(aar.wfZ) || C5046bo.isNullOrNil(aar.wgb))) {
                z = false;
                break;
            }
        }
        z = true;
        AppMethodBeat.m2505o(102535);
        return z;
    }

    /* renamed from: bI */
    public static void m66376bI(List<Integer> list) {
        AppMethodBeat.m2504i(102536);
        if (list.size() == 0) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
            AppMethodBeat.m2505o(102536);
            return;
        }
        Set bud = C39037b.bud();
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", bud.toString());
        for (Integer num : list) {
            boolean remove = bud.remove(num.toString());
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", num, Boolean.valueOf(remove));
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", bud.toString());
        C39037b.m66386d(bud);
        AppMethodBeat.m2505o(102536);
    }

    /* renamed from: d */
    private static void m66386d(Set<String> set) {
        AppMethodBeat.m2504i(102537);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", obj);
        C1720g.m3536RP().mo5239Ry().set(225282, obj);
        AppMethodBeat.m2505o(102537);
    }

    private static Set<String> bud() {
        AppMethodBeat.m2504i(102538);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(225282, (Object) "");
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", str);
        HashSet hashSet = new HashSet();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102538);
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.m2505o(102538);
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        AppMethodBeat.m2505o(102538);
        return hashSet;
    }

    /* renamed from: iq */
    public static void m66402iq(long j) {
        AppMethodBeat.m2504i(102539);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
        AppMethodBeat.m2505o(102539);
    }

    /* renamed from: ir */
    public static void m66403ir(long j) {
        AppMethodBeat.m2504i(102540);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
        AppMethodBeat.m2505o(102540);
    }

    /* renamed from: is */
    public static void m66404is(long j) {
        AppMethodBeat.m2504i(102541);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putLong("fav_mx_file_size", j).commit();
        AppMethodBeat.m2505o(102541);
    }

    public static String bue() {
        AppMethodBeat.m2504i(102542);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("favorite/web/").toString();
        AppMethodBeat.m2505o(102542);
        return stringBuilder2;
    }

    /* renamed from: b */
    public static String m66370b(aar aar) {
        AppMethodBeat.m2504i(102543);
        String str;
        if (aar == null) {
            str = "";
            AppMethodBeat.m2505o(102543);
            return str;
        }
        String str2 = aar.mnd;
        if (C5046bo.isNullOrNil(str2) || !C1720g.m3531RK()) {
            str = "";
            AppMethodBeat.m2505o(102543);
            return str;
        }
        C5728b Lz = C39037b.m66343Lz(str2);
        Object obj = null;
        if (aar.dataType == 8 && !C5046bo.isNullOrNil(aar.title)) {
            str2 = aar.title;
            Lz = C39037b.m66343Lz(aar.mnd);
            obj = 1;
        }
        if (aar.wgo != null && aar.wgo.trim().length() > 0 && obj == null) {
            str2 = str2 + "." + aar.wgo;
        }
        C5728b c5728b = new C5728b(Lz, str2);
        if (c5728b.exists() || C5046bo.isNullOrNil(aar.wgq)) {
            str = C5736j.m8649w(c5728b.dMD());
            AppMethodBeat.m2505o(102543);
            return str;
        }
        str = C1178g.m2591x((aar.wgq + aar.mnd).getBytes());
        if (C5046bo.isNullOrNil(str)) {
            str = C5736j.m8649w(c5728b.dMD());
            AppMethodBeat.m2505o(102543);
            return str;
        }
        if (aar.wgo != null && aar.wgo.trim().length() > 0) {
            str = str + "." + aar.wgo;
        }
        C5728b c5728b2 = new C5728b(Lz, str);
        if (c5728b2.exists()) {
            str = C5736j.m8649w(c5728b2.dMD());
            AppMethodBeat.m2505o(102543);
            return str;
        }
        str = aar.mnd;
        if (aar.wgo != null && aar.wgo.trim().length() > 0) {
            str = str + "." + aar.wgo;
        }
        C4990ab.m7410d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(str)));
        str = C5736j.m8649w(new C5728b(Lz, str).dMD());
        AppMethodBeat.m2505o(102543);
        return str;
    }

    /* renamed from: Lz */
    private static C5728b m66343Lz(String str) {
        AppMethodBeat.m2504i(102544);
        int hashCode = str.hashCode() & 255;
        C5728b c5728b = new C5728b(String.format("%s/%s/%d/", new Object[]{C1720g.m3536RP().eJM, "favorite", Integer.valueOf(hashCode)}));
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(102544);
        return c5728b;
    }

    /* renamed from: f */
    public static boolean m66392f(C27966g c27966g) {
        AppMethodBeat.m2504i(102545);
        if (c27966g.field_favProto == null) {
            AppMethodBeat.m2505o(102545);
            return false;
        }
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.whh == 2) {
                AppMethodBeat.m2505o(102545);
                return true;
            } else if (aar.whh == 1) {
                AppMethodBeat.m2505o(102545);
                return true;
            }
        }
        AppMethodBeat.m2505o(102545);
        return false;
    }

    /* renamed from: g */
    public static boolean m66395g(C27966g c27966g) {
        if (c27966g == null) {
            return false;
        }
        if (c27966g.field_itemStatus == 8 || c27966g.field_itemStatus == 10 || c27966g.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static void buf() {
        AppMethodBeat.m2504i(102546);
        Set<String> bud = C39037b.bud();
        if (bud.size() == 0) {
            C4990ab.m7418v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
            AppMethodBeat.m2505o(102546);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", bud.toString());
        LinkedList linkedList = new LinkedList();
        for (String str : bud) {
            try {
                linkedList.add(Integer.valueOf(C5046bo.getInt(str, 0)));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", e.getMessage());
            }
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            C1720g.m3540Rg().mo14541a(new C34124ag(linkedList), 0);
        }
        AppMethodBeat.m2505o(102546);
    }

    /* renamed from: h */
    private static void m66397h(C27966g c27966g) {
        AppMethodBeat.m2504i(102547);
        Set set = C11851an.mgy;
        LinkedList linkedList = c27966g.field_favProto.wiv;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                String c = C39037b.m66379c((aar) linkedList.get(i2));
                if (set == null || !set.contains(c)) {
                    C5730e.deleteFile(c);
                }
                c = C39037b.m66370b((aar) linkedList.get(i2));
                if (set == null || !set.contains(c)) {
                    C5730e.deleteFile(c);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(102547);
                return;
            }
        }
    }

    /* renamed from: c */
    public static String m66379c(aar aar) {
        AppMethodBeat.m2504i(102548);
        String str;
        if (aar == null || C5046bo.isNullOrNil(aar.mnd)) {
            str = "";
            AppMethodBeat.m2505o(102548);
            return str;
        }
        str = C39037b.m66336LA(aar.mnd);
        str = C5736j.m8649w(new C5728b(C39037b.m66343Lz(str), str).dMD());
        AppMethodBeat.m2505o(102548);
        return str;
    }

    /* renamed from: LA */
    public static String m66336LA(String str) {
        AppMethodBeat.m2504i(102549);
        String str2 = str + "_t";
        AppMethodBeat.m2505o(102549);
        return str2;
    }

    /* renamed from: bJ */
    public static boolean m66377bJ(List<C27966g> list) {
        AppMethodBeat.m2504i(102550);
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            AppMethodBeat.m2505o(102550);
            return false;
        }
        Set bud = C39037b.bud();
        for (C27966g c27966g : list) {
            C39037b.m66397h(c27966g);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54690iG(c27966g.field_localId);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23701z(c27966g);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15168iC(c27966g.field_localId);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73775v(c27966g);
            bud.add(c27966g.field_id);
            C4990ab.m7411d("MicroMsg.Fav.FavApiLogic", "delete id %d", Integer.valueOf(c27966g.field_id));
        }
        C39037b.m66386d(bud);
        C39037b.buf();
        AppMethodBeat.m2505o(102550);
        return true;
    }

    /* renamed from: a */
    public static void m66361a(C27966g c27966g, boolean z) {
        AppMethodBeat.m2504i(102551);
        C39037b.m66397h(c27966g);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54690iG(c27966g.field_localId);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23701z(c27966g);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15168iC(c27966g.field_localId);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73775v(c27966g);
        if (z) {
            Set bud = C39037b.bud();
            bud.add(c27966g.field_id);
            C39037b.m66386d(bud);
            C39037b.buf();
        }
        AppMethodBeat.m2505o(102551);
    }

    /* renamed from: a */
    public static boolean m66366a(final C27966g c27966g, final boolean z, final Runnable runnable) {
        AppMethodBeat.m2504i(102552);
        if (c27966g == null) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(102552);
            return false;
        }
        if (Looper.myLooper() == C1720g.m3539RS().oAl.getLooper()) {
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Boolean.valueOf(z));
            C39037b.m66361a(c27966g, z);
            C5004al.m7441d(runnable);
        } else {
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Boolean.valueOf(z));
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102521);
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Boolean.valueOf(z));
                    C39037b.m66361a(c27966g, z);
                    C5004al.m7441d(runnable);
                    AppMethodBeat.m2505o(102521);
                }
            });
        }
        AppMethodBeat.m2505o(102552);
        return true;
    }

    /* renamed from: i */
    public static boolean m66398i(C27966g c27966g) {
        AppMethodBeat.m2504i(102553);
        boolean a = C39037b.m66366a(c27966g, true, null);
        AppMethodBeat.m2505o(102553);
        return a;
    }

    /* renamed from: j */
    public static void m66408j(C27966g c27966g) {
        int i;
        C31355j c31355j;
        AppMethodBeat.m2504i(102554);
        C31355j iH = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54691iH(c27966g.field_localId);
        if (iH == null) {
            iH = new C31355j();
            iH.field_localId = c27966g.field_localId;
            i = 1;
            c31355j = iH;
        } else {
            i = 0;
            c31355j = iH;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (c27966g.field_favProto.title != null) {
            stringBuffer.append(c27966g.field_favProto.title);
        }
        if (c27966g.field_favProto.desc != null) {
            stringBuffer.append(c27966g.field_favProto.desc);
        }
        if (c27966g.field_favProto.wit != null) {
            abl abl = c27966g.field_favProto.wit;
            if (!C5046bo.isNullOrNil(abl.cEV)) {
                stringBuffer.append(abl.cEV);
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(abl.cEV);
                if (aoO != null) {
                    stringBuffer.append(aoO.field_nickname).append(aoO.field_conRemark);
                }
                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(abl.toUser);
                if (aoO != null) {
                    stringBuffer.append(aoO.field_nickname).append(aoO.field_conRemark);
                }
                stringBuffer.append(abl.whU);
            }
        }
        LinkedList linkedList = c27966g.field_favProto.wiv;
        c31355j.field_subtype = 0;
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
            c31355j.field_subtype = C31355j.m50656vx(i2) | c31355j.field_subtype;
        }
        if (c27966g.field_favProto.whA != null) {
            if (c27966g.field_favProto.whA.desc != null) {
                stringBuffer.append(c27966g.field_favProto.whA.desc);
            }
            if (c27966g.field_favProto.whA.title != null) {
                stringBuffer.append(c27966g.field_favProto.whA.title);
            }
        }
        if (c27966g.field_favProto.whC != null) {
            if (c27966g.field_favProto.whC.desc != null) {
                stringBuffer.append(c27966g.field_favProto.whC.desc);
            }
            if (c27966g.field_favProto.whC.title != null) {
                stringBuffer.append(c27966g.field_favProto.whC.title);
            }
        }
        c31355j.field_tagContent = "";
        for (String str : c27966g.field_tagProto.wiI) {
            c31355j.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : c27966g.field_tagProto.wiJ) {
            c31355j.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73769LM(str2);
        }
        c31355j.field_content = stringBuffer.toString();
        c31355j.field_time = c27966g.field_updateTime;
        c31355j.field_type = c27966g.field_type;
        if (i != 0) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54687a(c31355j);
            AppMethodBeat.m2505o(102554);
            return;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54688a(c31355j, "localId");
        AppMethodBeat.m2505o(102554);
    }

    /* renamed from: LB */
    public static boolean m66337LB(String str) {
        AppMethodBeat.m2504i(102555);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102555);
            return false;
        }
        boolean endsWith = str.endsWith("_t");
        AppMethodBeat.m2505o(102555);
        return endsWith;
    }

    /* renamed from: a */
    public static aar m66346a(C27966g c27966g, String str) {
        AppMethodBeat.m2504i(102556);
        if (C5046bo.isNullOrNil(str) || c27966g == null || c27966g.field_favProto.wiv.size() == 0) {
            AppMethodBeat.m2505o(102556);
            return null;
        }
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(str)) {
                AppMethodBeat.m2505o(102556);
                return aar;
            }
        }
        AppMethodBeat.m2505o(102556);
        return null;
    }

    /* renamed from: a */
    public static void m66356a(C45925c c45925c) {
        AppMethodBeat.m2504i(102557);
        int r = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15170r(c45925c.field_favLocalId, 0);
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", Integer.valueOf(r), Long.valueOf(c45925c.field_favLocalId));
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c45925c.field_favLocalId);
        if (iE == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.m2505o(102557);
        } else if (iE.buA()) {
            C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
            AppMethodBeat.m2505o(102557);
        } else if (c45925c.field_status == 3 && r != c45925c.field_status && iE.field_type == 18 && ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(c45925c.field_dataId).field_status == 3) {
            C39037b.m66357a(c45925c, iE);
            AppMethodBeat.m2505o(102557);
        } else {
            switch (r) {
                case 0:
                    AppMethodBeat.m2505o(102557);
                    return;
                case 1:
                    if (iE.buz()) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(15, c45925c.field_favLocalId);
                    } else {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(4, c45925c.field_favLocalId);
                    }
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    AppMethodBeat.m2505o(102557);
                    return;
                case 2:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(6, c45925c.field_favLocalId);
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    break;
                case 3:
                    if (iE.field_type == 18) {
                        C39037b.m66357a(c45925c, iE);
                        AppMethodBeat.m2505o(102557);
                        return;
                    } else if (iE.buz()) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(17, c45925c.field_favLocalId);
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getModService().run();
                        AppMethodBeat.m2505o(102557);
                        return;
                    } else {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(9, c45925c.field_favLocalId);
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
                        AppMethodBeat.m2505o(102557);
                        return;
                    }
                case 4:
                    if (iE.buz()) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(16, c45925c.field_favLocalId);
                    } else {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(6, c45925c.field_favLocalId);
                    }
                    C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(iE.field_type), Integer.valueOf(-5), Long.valueOf(C39037b.m66369b(iE)), Long.valueOf(C27968h.m44529ix(iE.field_localId)));
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    AppMethodBeat.m2505o(102557);
                    return;
            }
            AppMethodBeat.m2505o(102557);
        }
    }

    /* renamed from: b */
    public static void m66373b(C45925c c45925c) {
        AppMethodBeat.m2504i(102558);
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", Integer.valueOf(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15170r(c45925c.field_favLocalId, 1)), Long.valueOf(c45925c.field_favLocalId));
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c45925c.field_favLocalId);
        if (iE == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.m2505o(102558);
        } else if (iE.buA() || iE.buw() || iE.bux()) {
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", Boolean.valueOf(iE.buA()), Boolean.valueOf(iE.buw()), Boolean.valueOf(iE.bux()));
            AppMethodBeat.m2505o(102558);
        } else {
            switch (r1) {
                case 0:
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id));
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(10, c45925c.field_favLocalId);
                    AppMethodBeat.m2505o(102558);
                    return;
                case 1:
                    C27968h.m44530iy(iE.field_localId);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(7, c45925c.field_favLocalId);
                    AppMethodBeat.m2505o(102558);
                    return;
                case 2:
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id));
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(8, c45925c.field_favLocalId);
                    break;
                case 3:
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id));
                    C7060h.pYm.mo8381e(10659, Integer.valueOf(1), Integer.valueOf(iE.field_type), Integer.valueOf(0), Long.valueOf(C39037b.m66369b(iE)), Long.valueOf(C27968h.m44529ix(iE.field_localId)));
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(10, c45925c.field_favLocalId);
                    AppMethodBeat.m2505o(102558);
                    return;
                case 4:
                    C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(c45925c.field_favLocalId), Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_itemStatus));
                    C7060h.pYm.mo8381e(10659, Integer.valueOf(1), Integer.valueOf(iE.field_type), Integer.valueOf(-5), Long.valueOf(C39037b.m66369b(iE)), Long.valueOf(C27968h.m44529ix(iE.field_localId)));
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(8, c45925c.field_favLocalId);
                    AppMethodBeat.m2505o(102558);
                    return;
            }
            AppMethodBeat.m2505o(102558);
        }
    }

    /* renamed from: a */
    private static void m66357a(C45925c c45925c, C27966g c27966g) {
        AppMethodBeat.m2504i(102559);
        Iterator it = c27966g.field_favProto.wiv.iterator();
        int i = 0;
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (!(aar.dataType == 1 || aar.dataType == 6)) {
                int i2;
                if (C5046bo.isNullOrNil(aar.wfZ)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i == 0) {
            if (c27966g.field_id > 0) {
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(17, c45925c.field_favLocalId);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getModService().run();
                AppMethodBeat.m2505o(102559);
                return;
            }
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(9, c45925c.field_favLocalId);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
        }
        AppMethodBeat.m2505o(102559);
    }

    /* renamed from: a */
    public static void m66363a(aar aar, C27966g c27966g, int i) {
        AppMethodBeat.m2504i(102560);
        if (i == 1 && (aar.wgF <= 0 || C5046bo.isNullOrNil(aar.wfV) || C5046bo.isNullOrNil(aar.fgE))) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.m2505o(102560);
        } else if (i == 0 && C5046bo.isNullOrNil(C39037b.m66379c(aar))) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
            AppMethodBeat.m2505o(102560);
        } else {
            String LA = C39037b.m66336LA(aar.mnd);
            if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(LA) != null) {
                C4990ab.m7421w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", LA);
                AppMethodBeat.m2505o(102560);
                return;
            }
            C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
            C45925c c45925c = new C45925c();
            c45925c.field_cdnKey = aar.wfV;
            c45925c.field_cdnUrl = aar.fgE;
            c45925c.field_dataId = LA;
            c45925c.field_favLocalId = c27966g.field_localId;
            c45925c.field_totalLen = (int) aar.wgF;
            c45925c.field_type = i;
            c45925c.field_status = 1;
            c45925c.field_path = C39037b.m66379c(aar);
            c45925c.field_modifyTime = C5046bo.anU();
            c45925c.field_attrFlag |= 1;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15165e(c45925c);
            if (i == 1) {
                C39037b.m66373b(c45925c);
                AppMethodBeat.m2505o(102560);
                return;
            }
            C39037b.m66356a(c45925c);
            AppMethodBeat.m2505o(102560);
        }
    }

    /* renamed from: a */
    public static void m66364a(aar aar, C27966g c27966g, int i, boolean z) {
        AppMethodBeat.m2504i(102561);
        if (i == 1 && (C5046bo.isNullOrNil(aar.wgb) || C5046bo.isNullOrNil(aar.wfZ))) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.m2505o(102561);
        } else if (i == 0 && C5046bo.isNullOrNil(C39037b.m66370b(aar))) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
            AppMethodBeat.m2505o(102561);
        } else if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd) != null) {
            C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", aar.mnd);
            AppMethodBeat.m2505o(102561);
        } else {
            int i2;
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
            C45925c c45925c = new C45925c();
            c45925c.field_dataId = aar.mnd;
            c45925c.field_totalLen = (int) aar.wgu;
            c45925c.field_type = i;
            c45925c.field_favLocalId = c27966g.field_localId;
            c45925c.field_cdnKey = aar.wgb;
            c45925c.field_cdnUrl = aar.wfZ;
            c45925c.field_path = C39037b.m66370b(aar);
            if (aar.dataType == 3) {
                String str = aar.wgo;
                if (!C5046bo.isNullOrNil(str) && str.equals("speex")) {
                    i2 = -3;
                } else if (C5046bo.isNullOrNil(str) || !str.equals("silk")) {
                    i2 = -2;
                } else {
                    i2 = -4;
                }
                c45925c.field_dataType = i2;
            } else {
                c45925c.field_dataType = aar.dataType;
            }
            c45925c.field_modifyTime = C5046bo.anU();
            boolean isWifi = C5023at.isWifi(C4996ah.getContext());
            if (i == 0) {
                C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(c45925c.field_dataType), Integer.valueOf(c45925c.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (c45925c.field_dataType == 8 || c45925c.field_dataType == 4 || c45925c.field_dataType == 15) {
                    long j = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j == 0) {
                        j = 26214400;
                    }
                    if (((long) c45925c.field_totalLen) <= j) {
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", Long.valueOf(j));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    c45925c.field_status = 1;
                    C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
                } else {
                    c45925c.field_status = 4;
                    C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(c45925c.field_dataType), Integer.valueOf(c45925c.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (c45925c.field_dataType == 8 || c45925c.field_dataType == 4 || c45925c.field_dataType == 15) {
                    if (((long) c45925c.field_totalLen) <= C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getLong("fav_mx_auto_download_size", 26214400)) {
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", Long.valueOf(C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getLong("fav_mx_auto_download_size", 26214400)));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    c45925c.field_status = 1;
                    C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
                } else {
                    c45925c.field_status = 4;
                    C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
                }
            }
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15165e(c45925c);
            if (i == 1) {
                C39037b.m66373b(c45925c);
                AppMethodBeat.m2505o(102561);
                return;
            }
            C39037b.m66356a(c45925c);
            AppMethodBeat.m2505o(102561);
        }
    }

    /* renamed from: vu */
    public static boolean m66420vu(int i) {
        for (int i2 : C20671a.meA) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public static boolean m66409k(C27966g c27966g) {
        AppMethodBeat.m2504i(102562);
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId) != null) {
            AppMethodBeat.m2505o(102562);
            return true;
        }
        AppMethodBeat.m2505o(102562);
        return false;
    }

    public static void bug() {
        AppMethodBeat.m2504i(102563);
        if (0 >= meD) {
            C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            AppMethodBeat.m2505o(102563);
            return;
        }
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(meD);
        meD = 0;
        if (iE == null) {
            C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            AppMethodBeat.m2505o(102563);
            return;
        }
        C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", iE.field_localId);
        C39037b.m66354a(C4996ah.getContext(), ".ui.FavTagEditUI", intent, null);
        AppMethodBeat.m2505o(102563);
    }

    /* renamed from: it */
    public static void m66405it(long j) {
        meD = j;
    }

    public static long buh() {
        AppMethodBeat.m2504i(102564);
        long bui = C39037b.bui() - C39037b.buj();
        if (bui < 0) {
            bui = 1024;
        }
        AppMethodBeat.m2505o(102564);
        return bui;
    }

    public static long bui() {
        AppMethodBeat.m2504i(102565);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.m2505o(102565);
        return longValue;
    }

    public static long buj() {
        AppMethodBeat.m2504i(102566);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.m2505o(102566);
        return longValue;
    }

    /* renamed from: LC */
    public static String m66338LC(String str) {
        AppMethodBeat.m2504i(102567);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(102567);
            return str;
        } else if (!C5046bo.isNullOrNil(aoO.field_conRemark)) {
            str = aoO.field_conRemark;
            AppMethodBeat.m2505o(102567);
            return str;
        } else if (C5046bo.isNullOrNil(aoO.field_nickname)) {
            str = aoO.field_username;
            AppMethodBeat.m2505o(102567);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.m2505o(102567);
            return str;
        }
    }

    /* renamed from: mK */
    public static String m66412mK(String str) {
        AppMethodBeat.m2504i(102568);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        String str2;
        if (aoO == null) {
            C4990ab.m7421w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", str);
            str2 = "";
            AppMethodBeat.m2505o(102568);
            return str2;
        }
        str2 = aoO.mo16707Oj();
        if (C1855t.m3896kH(str2)) {
            List my = C37921n.m64074my(str);
            String Yz = C1853r.m3846Yz();
            if (my == null || my.isEmpty()) {
                C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
            } else {
                my.remove(Yz);
                my.add(0, Yz);
                str2 = C37921n.m64058f(my, 3);
            }
        }
        AppMethodBeat.m2505o(102568);
        return str2;
    }

    /* renamed from: l */
    public static void m66410l(C27966g c27966g) {
        AppMethodBeat.m2504i(102569);
        if (c27966g.bux()) {
            switch (c27966g.field_itemStatus) {
                case 3:
                    c27966g.field_itemStatus = 1;
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getCheckCdnService().run();
                    AppMethodBeat.m2505o(102569);
                    return;
                case 6:
                    if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15169iz(c27966g.field_localId).size() == 0) {
                        c27966g.field_itemStatus = 9;
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                        C1720g.m3540Rg().mo14541a(new C11849af(c27966g), 0);
                        AppMethodBeat.m2505o(102569);
                        return;
                    }
                    c27966g.field_itemStatus = 4;
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15171x(c27966g);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                    for (C45925c c45925c : ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15169iz(c27966g.field_localId)) {
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), c45925c.field_dataId, Integer.valueOf(c45925c.field_dataType), Integer.valueOf(c45925c.field_totalLen));
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(c45925c.field_dataId);
                    }
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                    AppMethodBeat.m2505o(102569);
                    return;
                case 11:
                    c27966g.field_itemStatus = 9;
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
                    break;
                case 14:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(12, c27966g.field_localId);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
                    AppMethodBeat.m2505o(102569);
                    return;
                case 16:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(15, c27966g.field_localId);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15171x(c27966g);
                    for (C45925c c45925c2 : ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15169iz(c27966g.field_localId)) {
                        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_dataType), Integer.valueOf(c45925c2.field_totalLen));
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(c45925c2.field_dataId);
                    }
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                    AppMethodBeat.m2505o(102569);
                    return;
                case 18:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(17, c27966g.field_localId);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getModService().run();
                    AppMethodBeat.m2505o(102569);
                    return;
            }
            AppMethodBeat.m2505o(102569);
            return;
        }
        C4990ab.m7414f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
        AppMethodBeat.m2505o(102569);
    }

    /* renamed from: m */
    public static void m66411m(C27966g c27966g) {
        AppMethodBeat.m2504i(102570);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102570);
        } else if (c27966g.field_itemStatus == 8 || c27966g.field_itemStatus == 10) {
            c27966g.field_itemStatus = 7;
            LinkedList<aar> linkedList = c27966g.field_favProto.wiv;
            if (linkedList.size() == 0) {
                AppMethodBeat.m2505o(102570);
                return;
            }
            for (aar aar : linkedList) {
                C39037b.m66360a(c27966g, aar, true);
                C39037b.m66359a(c27966g, aar);
            }
            AppMethodBeat.m2505o(102570);
        } else {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
            AppMethodBeat.m2505o(102570);
        }
    }

    /* renamed from: a */
    public static void m66360a(C27966g c27966g, aar aar, boolean z) {
        AppMethodBeat.m2504i(102571);
        if (c27966g == null || C5046bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.m2505o(102571);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), aar.mnd);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd);
        if (LR != null && LR.field_status == 3) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
            LR = null;
        }
        if (LR != null && (C5046bo.isNullOrNil(LR.field_cdnUrl) || C5046bo.isNullOrNil(LR.field_cdnKey) || C5046bo.isNullOrNil(LR.field_dataId) || !LR.field_cdnUrl.equals(aar.wfZ) || !LR.field_cdnKey.equals(aar.wgb) || !LR.field_dataId.equals(aar.mnd))) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            C5728b c5728b = new C5728b(C39037b.m66370b(aar));
            if (!(C5046bo.isNullOrNil(aar.wgb) || C5046bo.isNullOrNil(aar.wfZ) || c5728b.exists())) {
                C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                C39037b.m66364a(aar, c27966g, 1, true);
                if (z) {
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(aar.mnd);
                    if (!C5046bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7317c(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd));
                    }
                }
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.m2505o(102571);
            return;
        }
        C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        LR.field_status = 1;
        LR.field_path = C39037b.m66370b(aar);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
        if (z) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(aar.mnd);
            if (!C5046bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7317c(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd));
            }
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
        AppMethodBeat.m2505o(102571);
    }

    /* renamed from: d */
    public static void m66384d(aar aar) {
        AppMethodBeat.m2504i(102573);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd);
        if (!(LR == null || LR.field_status == 3)) {
            LR.field_status = 2;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().pauseDownload(aar.mnd);
        }
        LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(C39037b.m66336LA(aar.mnd));
        if (!(LR == null || LR.field_status == 3)) {
            LR.field_status = 2;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().pauseDownload(C39037b.m66336LA(aar.mnd));
        }
        AppMethodBeat.m2505o(102573);
    }

    /* renamed from: n */
    public static void m66413n(C27966g c27966g) {
        AppMethodBeat.m2504i(102574);
        if (c27966g.buw()) {
            C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", Integer.valueOf(c27966g.field_itemStatus));
            Iterator it = c27966g.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd);
                if (!(LR == null || LR.field_status == 3)) {
                    LR.field_status = 2;
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7316LQ(aar.mnd);
                }
                LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(C39037b.m66336LA(aar.mnd));
                if (!(LR == null || LR.field_status == 3)) {
                    LR.field_status = 2;
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7316LQ(C39037b.m66336LA(aar.mnd));
                }
            }
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId);
            C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", Integer.valueOf(iE.field_itemStatus));
            switch (iE.field_itemStatus) {
                case 1:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(3, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(3));
                    AppMethodBeat.m2505o(102574);
                    return;
                case 4:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(6, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(6));
                    AppMethodBeat.m2505o(102574);
                    return;
                case 9:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(11, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(11));
                    AppMethodBeat.m2505o(102574);
                    return;
                case 12:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(14, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(14));
                    AppMethodBeat.m2505o(102574);
                    return;
                case 15:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(16, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(16));
                    AppMethodBeat.m2505o(102574);
                    return;
                case 17:
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(18, iE.field_localId);
                    C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(18));
                    break;
            }
            AppMethodBeat.m2505o(102574);
            return;
        }
        C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
        AppMethodBeat.m2505o(102574);
    }

    public static boolean buk() {
        AppMethodBeat.m2504i(102575);
        if (C39037b.bui() == 0) {
            AppMethodBeat.m2505o(102575);
            return false;
        } else if (C39037b.buh() < 52428800) {
            AppMethodBeat.m2505o(102575);
            return true;
        } else {
            AppMethodBeat.m2505o(102575);
            return false;
        }
    }

    /* renamed from: fY */
    public static float m66394fY(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        AppMethodBeat.m2504i(102576);
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.m2505o(102576);
        return f;
    }

    /* renamed from: iu */
    public static float m66406iu(long j) {
        float f = 1.0f;
        AppMethodBeat.m2504i(102577);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.m2505o(102577);
        return f;
    }

    /* renamed from: iv */
    public static String m66407iv(long j) {
        AppMethodBeat.m2504i(102578);
        String str;
        if (j == 0) {
            str = "0KB";
            AppMethodBeat.m2505o(102578);
            return str;
        } else if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            str = String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
            AppMethodBeat.m2505o(102578);
            return str;
        } else if ((((double) j) * 1.0d) / 1024.0d >= 1.0d) {
            str = String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
            AppMethodBeat.m2505o(102578);
            return str;
        } else {
            str = "1KB";
            AppMethodBeat.m2505o(102578);
            return str;
        }
    }

    /* renamed from: aC */
    public static String m66368aC(float f) {
        AppMethodBeat.m2504i(102579);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.m2505o(102579);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.m2505o(102579);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(102579);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(102579);
            return format;
        }
    }

    /* renamed from: e */
    public static boolean m66390e(aar aar) {
        AppMethodBeat.m2504i(102580);
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJS == 6 && C5046bo.m7532bc(aar.mnd, "").equals(aih.fJU) && C37494a.aie()) {
            AppMethodBeat.m2505o(102580);
            return true;
        }
        AppMethodBeat.m2505o(102580);
        return false;
    }

    public static String bul() {
        AppMethodBeat.m2504i(102581);
        String str = C1720g.m3536RP().eJM + "favorite/music/";
        AppMethodBeat.m2505o(102581);
        return str;
    }

    /* renamed from: o */
    public static boolean m66414o(C27966g c27966g) {
        AppMethodBeat.m2504i(102583);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102583);
            return false;
        }
        aar c = C39037b.m66378c(c27966g);
        if (c == null) {
            AppMethodBeat.m2505o(102583);
            return false;
        }
        int ckU;
        int i;
        boolean a;
        long yz = C5046bo.m7588yz();
        C43528a WR = C21846d.m33388WR(C39037b.m66370b(c));
        if (WR != null) {
            ckU = WR.ckU();
            i = c.duration;
            if (i <= 0 || Math.abs(i - ckU) >= 2) {
                c.mo27393LD(ckU);
                a = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            ckU = 0;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", Integer.valueOf(i), Integer.valueOf(ckU), Boolean.valueOf(a), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(102583);
        return a;
    }

    public static String bum() {
        AppMethodBeat.m2504i(102584);
        String str = C1720g.m3536RP().eJM + "favorite/";
        AppMethodBeat.m2505o(102584);
        return str;
    }

    public static String bun() {
        AppMethodBeat.m2504i(102585);
        String str = C1720g.m3536RP().eJM + "favorite/voice/";
        AppMethodBeat.m2505o(102585);
        return str;
    }

    /* renamed from: a */
    public static List<C27966g> m66350a(long j, int i, Set<Integer> set, C39039w c39039w) {
        AppMethodBeat.m2504i(102586);
        if (j == 0) {
            List a = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23677a(i, set, c39039w);
            AppMethodBeat.m2505o(102586);
            return a;
        }
        List<C27966g> b = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23679b(j, i, set, c39039w);
        AppMethodBeat.m2505o(102586);
        return b;
    }

    /* renamed from: q */
    public static long m66416q(long j, int i) {
        AppMethodBeat.m2504i(102587);
        C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
        long w = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23699w(j, i);
        long u = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23696u(j, i);
        C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(w), Long.valueOf(u), Long.valueOf(j));
        if (w == 0) {
            AppMethodBeat.m2505o(102587);
            return u;
        }
        LinkedList v = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23697v(w, i);
        if (v.size() > 0) {
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(w), Long.valueOf(u), Long.valueOf(j));
            C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", Integer.valueOf(v.size()));
            if (!C1720g.m3540Rg().mo14541a(new C34125ah(v), 0)) {
                C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
                C34125ah.bve();
            }
        }
        if (u == 0) {
            AppMethodBeat.m2505o(102587);
            return w;
        } else if (w < u) {
            AppMethodBeat.m2505o(102587);
            return w;
        } else {
            AppMethodBeat.m2505o(102587);
            return u;
        }
    }

    public static void startSync() {
        AppMethodBeat.m2504i(102588);
        C1720g.m3540Rg().mo14541a(new C39036aj(), 0);
        AppMethodBeat.m2505o(102588);
    }

    /* renamed from: LD */
    public static String m66339LD(String str) {
        AppMethodBeat.m2504i(102589);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102589);
            return null;
        }
        C5728b c5728b = new C5728b(C39037b.bue() + C1178g.m2591x(str.getBytes()));
        if (c5728b.exists()) {
            String w = C5736j.m8649w(c5728b.dMD());
            AppMethodBeat.m2505o(102589);
            return w;
        }
        AppMethodBeat.m2505o(102589);
        return null;
    }

    /* renamed from: f */
    public static boolean m66393f(aar aar) {
        AppMethodBeat.m2504i(102590);
        boolean exists = new C5728b(C39037b.m66370b(aar)).exists();
        AppMethodBeat.m2505o(102590);
        return exists;
    }

    /* renamed from: g */
    public static boolean m66396g(aar aar) {
        AppMethodBeat.m2504i(102591);
        boolean amo = C5063r.amo(C39037b.m66370b(aar));
        AppMethodBeat.m2505o(102591);
        return amo;
    }

    public static boolean buo() {
        AppMethodBeat.m2504i(102592);
        if (C34125ah.bvf() > 0) {
            AppMethodBeat.m2505o(102592);
            return true;
        }
        AppMethodBeat.m2505o(102592);
        return false;
    }

    /* renamed from: a */
    public static boolean m66365a(long j, Runnable runnable) {
        AppMethodBeat.m2504i(102595);
        boolean a = C39037b.m66366a(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j), true, runnable);
        AppMethodBeat.m2505o(102595);
        return a;
    }

    /* renamed from: p */
    public static void m66415p(C27966g c27966g) {
        int i;
        C31355j c31355j;
        AppMethodBeat.m2504i(102596);
        C31355j iH = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54691iH(c27966g.field_localId);
        if (iH == null) {
            iH = new C31355j();
            iH.field_localId = c27966g.field_localId;
            i = 1;
            c31355j = iH;
        } else {
            i = 0;
            c31355j = iH;
        }
        c31355j.field_tagContent = "";
        for (String str : c27966g.field_tagProto.wiI) {
            c31355j.field_tagContent += " " + str;
        }
        for (String str2 : c27966g.field_tagProto.wiJ) {
            c31355j.field_tagContent += " " + str2;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73769LM(str2);
        }
        c31355j.field_content = "";
        c31355j.field_time = c27966g.field_updateTime;
        c31355j.field_type = c27966g.field_type;
        if (i != 0) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54687a(c31355j);
            AppMethodBeat.m2505o(102596);
            return;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54688a(c31355j, "localId");
        AppMethodBeat.m2505o(102596);
    }

    /* renamed from: a */
    public static ArrayList<C27966g> m66349a(List<String> list, List<String> list2, List<Integer> list3, List<C27966g> list4, Set<Integer> set, C39039w c39039w) {
        AppMethodBeat.m2504i(102597);
        ArrayList b = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54689b(list, list2, list3);
        ArrayList<C27966g> arrayList = new ArrayList();
        if (b.size() == 0) {
            AppMethodBeat.m2505o(102597);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < b.size() ? i + 20 : b.size();
            C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(b.size()));
            ArrayList a = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23676a(b.subList(i, size), list4, set, c39039w);
            if (a != null && a.size() > 0) {
                if (list3.contains(Integer.valueOf(8))) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        C27966g c27966g = (C27966g) it.next();
                        if (c27966g.field_type == 18) {
                            Object obj;
                            try {
                                LinkedList linkedList = c27966g.field_favProto.wiv;
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
                                arrayList.add(c27966g);
                            }
                        } else {
                            arrayList.add(c27966g);
                        }
                    }
                } else {
                    arrayList.addAll(a);
                }
            }
            if (size >= b.size()) {
                AppMethodBeat.m2505o(102597);
                return arrayList;
            }
            i = size;
        }
    }

    /* renamed from: LE */
    public static int m66340LE(String str) {
        AppMethodBeat.m2504i(102598);
        if (!C5046bo.isNullOrNil(str) && str.equals("speex")) {
            AppMethodBeat.m2505o(102598);
            return 1;
        } else if (C5046bo.isNullOrNil(str) || !str.equals("silk")) {
            AppMethodBeat.m2505o(102598);
            return 0;
        } else {
            AppMethodBeat.m2505o(102598);
            return 2;
        }
    }

    public static boolean bup() {
        AppMethodBeat.m2504i(102599);
        if (C39037b.bui() == 0) {
            AppMethodBeat.m2505o(102599);
            return false;
        } else if (C39037b.buh() < 10485760) {
            AppMethodBeat.m2505o(102599);
            return true;
        } else {
            AppMethodBeat.m2505o(102599);
            return false;
        }
    }

    /* renamed from: LF */
    public static C27966g m66341LF(String str) {
        AppMethodBeat.m2504i(102600);
        C27966g c27966g = new C27966g();
        c27966g.field_localId = -1;
        c27966g.field_id = -1;
        c27966g.field_xml = str;
        c27966g.field_type = 18;
        c27966g.mo45881LH(str);
        AppMethodBeat.m2505o(102600);
        return c27966g;
    }

    /* renamed from: LG */
    private static C27966g m66342LG(String str) {
        AppMethodBeat.m2504i(102601);
        if (str == null || str.equals("")) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
            AppMethodBeat.m2505o(102601);
            return null;
        }
        String str2;
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (replace.startsWith("<noteinfo>")) {
            str2 = replace;
        } else {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        }
        Map z = C5049br.m7595z(str2, "noteinfo");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            AppMethodBeat.m2505o(102601);
            return null;
        }
        C27966g c27966g = new C27966g();
        try {
            c27966g.field_favProto = new abf();
            c27966g.field_type = 18;
            c27966g.field_favProto.mo74748mk(C5046bo.getLong((String) z.get(".noteinfo.edittime"), 0));
            aaz aaz = new aaz();
            aaz.win = (String) z.get(".noteinfo.noteeditor");
            aaz.wim = (String) z.get(".noteinfo.noteauthor");
            c27966g.field_favProto.mo74736a(aaz);
            c27966g.field_localId = C5046bo.getLong((String) z.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            C27960b.m44511a(str2, c27966g.field_favProto);
            AppMethodBeat.m2505o(102601);
            return c27966g;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", e.toString());
            AppMethodBeat.m2505o(102601);
            return null;
        }
    }

    /* renamed from: e */
    public static void m66387e(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(102602);
        C27966g LG = C39037b.m66342LG(str);
        if (LG == null) {
            AppMethodBeat.m2505o(102602);
            return;
        }
        C18313ld c18313ld = new C18313ld();
        c18313ld.cGU.type = 2;
        c18313ld.cGU.field_localId = -1;
        c18313ld.cGU.context = context;
        c18313ld.cGU.cHa = 4;
        c18313ld.cGU.cHc = true;
        Bundle bundle = new Bundle();
        bundle.putString("noteauthor", LG.field_favProto.vzK.wim);
        bundle.putString("noteeditor", LG.field_favProto.vzK.win);
        bundle.putLong("edittime", LG.field_favProto.lgR);
        bundle.putString("notexml", C27966g.m44521s(LG));
        bundle.putString("snslocalid", str2);
        bundle.putString("snsthumbpath", str3);
        bundle.putString("snsnotelinkxml", str);
        c18313ld.cGU.cGZ = bundle;
        c18313ld.cGU.field_favProto = LG.field_favProto;
        C4879a.xxA.mo10055m(c18313ld);
        AppMethodBeat.m2505o(102602);
    }

    /* renamed from: b */
    private static void m66372b(C37721gh c37721gh) {
        AppMethodBeat.m2504i(102603);
        C27966g LG = C39037b.m66342LG(c37721gh.cAH.desc);
        if (LG == null) {
            AppMethodBeat.m2505o(102603);
            return;
        }
        if (!(LG.field_favProto == null || LG.field_favProto.wiv == null)) {
            Iterator it = LG.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (aar.dataType == 20) {
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.akV("");
                    aar.akL("");
                    aar.akM("");
                    aar.akJ("");
                    aar.akK("");
                }
            }
        }
        c37721gh.cAH.cvC = LG.field_favProto;
        AppMethodBeat.m2505o(102603);
    }

    /* renamed from: a */
    public static C27966g m66345a(abf abf) {
        AppMethodBeat.m2504i(102604);
        C27966g c27966g = new C27966g();
        c27966g.field_favProto = new abf();
        c27966g.field_type = 18;
        c27966g.field_favProto = abf;
        AppMethodBeat.m2505o(102604);
        return c27966g;
    }

    /* renamed from: b */
    private static void m66374b(C27966g c27966g, boolean z) {
        AppMethodBeat.m2504i(102605);
        aaz aaz = new aaz();
        if (!z) {
            aaz.wim = C1853r.m3846Yz();
        }
        aaz.win = C1853r.m3846Yz();
        c27966g.field_favProto.mo74748mk(C5046bo.anT());
        c27966g.field_favProto.mo74736a(aaz);
        AppMethodBeat.m2505o(102605);
    }

    /* renamed from: q */
    public static void m66417q(C27966g c27966g) {
        AppMethodBeat.m2504i(102606);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102606);
            return;
        }
        aaz aaz = c27966g.field_favProto.vzK;
        if (aaz == null || C5046bo.isNullOrNil(aaz.win)) {
            if (c27966g.field_type == 18) {
                if (c27966g.field_favProto.wit.cvp == 6) {
                    C39037b.m66374b(c27966g, false);
                } else {
                    C39037b.m66374b(c27966g, true);
                }
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
            }
            AppMethodBeat.m2505o(102606);
            return;
        }
        AppMethodBeat.m2505o(102606);
    }

    /* renamed from: c */
    public static void m66380c(C37721gh c37721gh) {
        AppMethodBeat.m2504i(102607);
        C27966g c27966g;
        if (c37721gh.cAH.cAO == 1) {
            String str;
            c37721gh.cAI.path = C39037b.m66401ip(c37721gh.cAH.cvv);
            C9356b c9356b = c37721gh.cAI;
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
            if (iE == null || iE.field_favProto == null) {
                str = "";
            } else {
                if (iE.field_type != 18 || iE.field_favProto.wiv.size() > 1) {
                    Iterator it = iE.field_favProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        switch (aar.dataType) {
                            case 2:
                                str = C39037b.m66379c(aar);
                                if (!C5730e.m8628ct(str)) {
                                    String b = C39037b.m66370b(aar);
                                    if (!C5730e.m8628ct(b)) {
                                        if (!aar.wfU) {
                                            if (!aar.wga) {
                                                str = "";
                                                break;
                                            }
                                            C39037b.m66360a(iE, aar, true);
                                            str = b;
                                            break;
                                        }
                                        C39037b.m66359a(iE, aar);
                                        break;
                                    }
                                    C5056d.m7656c(b, 150, 150, CompressFormat.JPEG, 90, str);
                                    str = C39037b.m66379c(aar);
                                    break;
                                }
                                break;
                            default:
                        }
                    }
                }
                str = "";
            }
            c9356b.thumbPath = str;
            AppMethodBeat.m2505o(102607);
        } else if (c37721gh.cAH.cAO == 2) {
            c27966g = new C27966g();
            c27966g.field_type = 2;
            aar aar2 = new aar();
            aar2.akU(C39037b.m66382cf(aar2.toString(), 2));
            String b2 = C39037b.m66370b(aar2);
            aar2.akV(b2);
            aar2.mo27394LE(2);
            c27966g.field_favProto.wiv.add(aar2);
            c37721gh.cAI.path = C27966g.m44521s(c27966g);
            c37721gh.cAI.thumbPath = b2;
            AppMethodBeat.m2505o(102607);
        } else if (c37721gh.cAH.cAO == 3) {
            c27966g = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
            if (c27966g != null) {
                c37721gh.cAI.path = C1853r.m3846Yz() + ";" + c27966g.field_fromUser + ";" + c27966g.field_updateTime;
            }
            AppMethodBeat.m2505o(102607);
        } else if (c37721gh.cAH.cAO == 4) {
            C39037b.m66372b(c37721gh);
            AppMethodBeat.m2505o(102607);
        } else if (c37721gh.cAH.cAO == 5) {
            C39037b.m66355a(c37721gh);
            AppMethodBeat.m2505o(102607);
        } else if (c37721gh.cAH.cAO == 6) {
            c27966g = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
            if (c27966g == null) {
                c37721gh.cAI.ret = 0;
                AppMethodBeat.m2505o(102607);
                return;
            }
            int i;
            C9356b c9356b2 = c37721gh.cAI;
            if (c27966g.field_id > 0) {
                i = 1;
            } else {
                i = 0;
            }
            c9356b2.ret = i;
            AppMethodBeat.m2505o(102607);
        } else {
            c27966g = new C27966g();
            c27966g.field_type = 18;
            c27966g.field_favProto = c37721gh.cAH.cvC;
            c37721gh.cAI.path = C27966g.m44521s(c27966g);
            AppMethodBeat.m2505o(102607);
        }
    }

    /* renamed from: a */
    public static void m66358a(C27966g c27966g, int i) {
        AppMethodBeat.m2504i(102608);
        if (c27966g == null) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
            AppMethodBeat.m2505o(102608);
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
        int size = c27966g.field_tagProto.wiJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(C5046bo.ani((String) c27966g.field_tagProto.wiJ.get(i2))).append("</tag>");
        }
        bcd.pXM = stringBuffer.toString();
        C4990ab.m7419v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", Integer.valueOf(c27966g.field_id), bcd.pXM);
        linkedList2.add(bcd);
        if (c27966g.field_id > 0) {
            C1720g.m3540Rg().mo14541a(new C11850al(c27966g.field_id, linkedList, linkedList2), 0);
            C27968h.m44532k((long) c27966g.field_id, size, i);
            AppMethodBeat.m2505o(102608);
            return;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getEditService().mo35979a(c27966g.field_localId, linkedList, linkedList2, i);
        AppMethodBeat.m2505o(102608);
    }

    /* renamed from: b */
    public static void m66371b(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(139140);
        C39037b.m66354a(context, str, intent, null);
        AppMethodBeat.m2505o(139140);
    }

    /* renamed from: a */
    public static void m66354a(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(102610);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.m2505o(102610);
                return;
            }
        }
        String str2 = C4996ah.doz() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(C4996ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.m2505o(102610);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.m2505o(102610);
    }

    /* renamed from: a */
    public static void m66352a(Context context, String str, Intent intent, int i) {
        AppMethodBeat.m2504i(102611);
        C39037b.m66353a(context, str, intent, i, null);
        AppMethodBeat.m2505o(102611);
    }

    /* renamed from: a */
    public static void m66353a(Context context, String str, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(102612);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.m2505o(102612);
                return;
            }
        }
        String str2 = C4996ah.doz() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(C4996ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i, bundle);
        }
        AppMethodBeat.m2505o(102612);
    }

    /* renamed from: c */
    public static void m66381c(String str, Context context) {
        AppMethodBeat.m2504i(102613);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
            AppMethodBeat.m2505o(102613);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        C25985d.m41473f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.m2505o(102613);
    }

    /* renamed from: v */
    public static void m66419v(Intent intent, Context context) {
        AppMethodBeat.m2504i(102615);
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 1);
            C25985d.m41467b(context, "sns", ".ui.SnsUploadUI", intent);
        }
        AppMethodBeat.m2505o(102615);
    }

    /* renamed from: e */
    public static void m66388e(String str, Context context) {
        AppMethodBeat.m2504i(102616);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
            AppMethodBeat.m2505o(102616);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", str);
        intent.putExtra("Retr_Msg_Type", 4);
        intent.putExtra("mutil_select_is_ret", true);
        C25985d.m41473f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.m2505o(102616);
    }

    /* renamed from: a */
    public static void m66351a(long j, aay aay, String str, String str2, ArrayList<String> arrayList, Context context) {
        AppMethodBeat.m2504i(102617);
        if (aay == null || context == null) {
            AppMethodBeat.m2505o(102617);
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
        C25985d.m41467b(context, C8741b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.m2505o(102617);
    }

    /* renamed from: a */
    public static String[] m66367a(final C27966g c27966g, C7306ak c7306ak) {
        String str = null;
        AppMethodBeat.m2504i(102618);
        if (c27966g == null) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            AppMethodBeat.m2505o(102618);
            return null;
        }
        final aar c = C39037b.m66378c(c27966g);
        String[] strArr = new String[2];
        C279643 c279643 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102522);
                C39037b.m66359a(c27966g, c);
                AppMethodBeat.m2505o(102522);
            }
        };
        abe abe;
        switch (c27966g.field_type) {
            case 5:
                abu abu = c27966g.field_favProto.whA;
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
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = c.cvq;
                }
                strArr[0] = C39037b.m66379c(c);
                strArr[1] = str2;
                c7306ak.post(c279643);
                break;
                break;
            case 10:
                abe = c27966g.field_favProto.whC;
                if (abe != null) {
                    strArr[1] = abe.thumbUrl;
                    break;
                }
                break;
            case 11:
                abe = c27966g.field_favProto.whC;
                if (abe != null) {
                    strArr[1] = abe.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (c27966g.field_favProto.wiv != null) {
                    Iterator it = c27966g.field_favProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        if (aar.dataType == 2) {
                            str = C39037b.m66370b(aar);
                            c7306ak.post(c279643);
                        } else if (aar.dataType == 15) {
                            str = C39037b.m66379c(aar);
                            c7306ak.post(c279643);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = c.cvq;
                break;
            case 15:
                abo abo = c27966g.field_favProto.whE;
                if (abo != null) {
                    strArr[1] = abo.thumbUrl;
                    break;
                }
                break;
            default:
                if (c != null) {
                    strArr[0] = C39037b.m66379c(c);
                    strArr[1] = c.cvq;
                    c7306ak.post(c279643);
                    break;
                }
                break;
        }
        C4990ab.m7411d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", strArr[0], strArr[1], Integer.valueOf(c27966g.field_type));
        AppMethodBeat.m2505o(102618);
        return strArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: r */
    public static final String m66418r(C27966g c27966g) {
        String str;
        AppMethodBeat.m2504i(102619);
        StringBuffer stringBuffer = new StringBuffer();
        aar aar;
        switch (c27966g.field_type) {
            case 1:
                if (!C5046bo.isNullOrNil(c27966g.field_favProto.desc)) {
                    stringBuffer.append(c27966g.field_favProto.desc.getBytes().length);
                    break;
                }
                break;
            case 2:
            case 8:
                long j = 0;
                Iterator it = c27966g.field_favProto.wiv.iterator();
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
                stringBuffer.append(C39037b.m66378c(c27966g).duration);
                break;
            case 5:
                str = "";
                try {
                    str = c27966g.field_favProto.whA.wiY;
                } catch (Exception e) {
                }
                stringBuffer.append(str);
                break;
            case 14:
            case 18:
                if (c27966g != null) {
                    Iterator it2 = c27966g.field_favProto.wiv.iterator();
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (it2.hasNext()) {
                        int i5;
                        aar = (aar) it2.next();
                        switch (aar.dataType) {
                            case 1:
                                if (C5046bo.isNullOrNil(aar.desc)) {
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
                    AppMethodBeat.m2505o(102619);
                    return str;
                }
                break;
        }
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(102619);
        return str;
    }

    /* renamed from: a */
    public static String m66348a(aar aar) {
        AppMethodBeat.m2504i(102523);
        aas aas = aar.wgT;
        String str = "";
        switch (aar.dataType) {
            case 1:
                str = C39037b.m66391ek(str, aar.desc);
                break;
            case 4:
                if (aas.whE != null) {
                    str = C39037b.m66391ek(str, aas.whE.title);
                    break;
                }
                break;
            case 5:
                if (aas.whA != null) {
                    str = C39037b.m66391ek(str, aas.whA.title);
                    break;
                }
                break;
            case 6:
                str = C39037b.m66391ek(str, aas.hHV);
                if (aas.why != null) {
                    str = C39037b.m66391ek(C39037b.m66391ek(str, aas.why.cIK), aas.why.label);
                    break;
                }
                break;
            case 8:
                str = C39037b.m66391ek(str, aas.title);
                break;
            case 10:
            case 11:
                if (aas.whC != null) {
                    str = C39037b.m66391ek(C39037b.m66391ek(str, aas.whC.title), aas.whC.desc);
                    break;
                }
                break;
            default:
                str = C39037b.m66391ek(C39037b.m66391ek(str, aas.title), aas.desc);
                break;
        }
        AppMethodBeat.m2505o(102523);
        return str;
    }

    /* renamed from: a */
    public static void m66359a(C27966g c27966g, aar aar) {
        AppMethodBeat.m2504i(102572);
        if (C5046bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.m2505o(102572);
            return;
        }
        String LA = C39037b.m66336LA(aar.mnd);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(LA);
        if (LR != null && LR.field_status == 3) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            C5728b c5728b = new C5728b(C39037b.m66379c(aar));
            if (!(C5046bo.isNullOrNil(aar.wfV) || C5046bo.isNullOrNil(aar.fgE) || c5728b.exists())) {
                C39037b.m66363a(aar, c27966g, 1);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(LA);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
            }
            AppMethodBeat.m2505o(102572);
            return;
        }
        LR.field_status = 1;
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(LA);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
        AppMethodBeat.m2505o(102572);
    }

    public static String getAppName(Context context, String str) {
        AppMethodBeat.m2504i(102582);
        C26409b c26409b = C26410a.fls;
        String t;
        if (c26409b != null) {
            t = c26409b.mo44181t(context, str);
            AppMethodBeat.m2505o(102582);
            return t;
        }
        t = "";
        AppMethodBeat.m2505o(102582);
        return t;
    }

    /* renamed from: a */
    public static void m66362a(aar aar, int i, long j) {
        AppMethodBeat.m2504i(102593);
        if (C5046bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.m2505o(102593);
        } else if (C5046bo.isNullOrNil(aar.wfV) || C5046bo.isNullOrNil(aar.fgE)) {
            AppMethodBeat.m2505o(102593);
        } else {
            String LA = C39037b.m66336LA(aar.mnd);
            C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(LA);
            if (LR != null && (LR.field_status == 3 || LR.field_status == 4)) {
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
                LR = null;
            }
            if (LR == null || LR.field_type != 1) {
                C5728b c5728b = new C5728b(C39037b.m66379c(aar));
                if (!(C5046bo.isNullOrNil(aar.wfV) || C5046bo.isNullOrNil(aar.fgE) || c5728b.exists())) {
                    C27966g c27966g = new C27966g();
                    c27966g.field_localId = j;
                    c27966g.field_id = -1;
                    c27966g.field_type = i;
                    C39037b.m66363a(aar, c27966g, 1);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(LA);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                }
                AppMethodBeat.m2505o(102593);
                return;
            }
            LR.field_status = 1;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(LA);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
            AppMethodBeat.m2505o(102593);
        }
    }

    /* renamed from: b */
    public static void m66375b(aar aar, int i, long j) {
        AppMethodBeat.m2504i(102594);
        if (C5046bo.isNullOrNil(aar.mnd)) {
            AppMethodBeat.m2505o(102594);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", aar.mnd);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(aar.mnd);
        if (LR != null && (LR.field_status == 3 || LR.field_status == 4)) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
            LR = null;
        }
        if (LR == null || LR.field_type != 1) {
            C5728b c5728b = new C5728b(C39037b.m66370b(aar));
            if (!(C5046bo.isNullOrNil(aar.wgb) || C5046bo.isNullOrNil(aar.wfZ) || c5728b.exists())) {
                C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                C27966g c27966g = new C27966g();
                c27966g.field_localId = j;
                c27966g.field_id = -1;
                c27966g.field_type = i;
                C39037b.m66364a(aar, c27966g, 1, true);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(aar.mnd);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                C4990ab.m7417i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.m2505o(102594);
            return;
        }
        C4990ab.m7416i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        LR.field_status = 1;
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, "dataId");
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7315LP(aar.mnd);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
        AppMethodBeat.m2505o(102594);
    }

    /* renamed from: d */
    public static void m66385d(String str, Context context) {
        AppMethodBeat.m2504i(102614);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
            AppMethodBeat.m2505o(102614);
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + C1853r.m3846Yz() + "_0";
        String nW = C37922v.m64078nW(str2);
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", str2);
        intent.putExtra("reportSessionId", nW);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        C25985d.m41467b(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.m2505o(102614);
    }
}
