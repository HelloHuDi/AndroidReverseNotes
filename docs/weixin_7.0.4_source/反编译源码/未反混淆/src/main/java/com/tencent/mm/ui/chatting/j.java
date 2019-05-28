package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.e;
import com.tencent.mm.at.i;
import com.tencent.mm.at.m;
import com.tencent.mm.at.m.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class j {

    /* renamed from: com.tencent.mm.ui.chatting.j$2 */
    static class AnonymousClass2 implements a {
        final /* synthetic */ long fFE;
        final /* synthetic */ long yIA;

        AnonymousClass2(long j, long j2) {
            this.fFE = j;
            this.yIA = j2;
        }

        public final void a(long j, int i, int i2, int i3) {
            AppMethodBeat.i(30533);
            ab.i("MicroMsg.ChattingEditModeLogic", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(this.yIA);
                jf.setStatus(2);
                jf.eI(j);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.yIA, jf);
                i.lB((int) this.fFE);
                AppMethodBeat.o(30533);
                return;
            }
            i.lC((int) this.fFE);
            i.lB((int) this.fFE);
            AppMethodBeat.o(30533);
        }
    }

    public static boolean av(bi biVar) {
        AppMethodBeat.i(30539);
        if (biVar == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            AppMethodBeat.o(30539);
            return true;
        }
        EmojiInfo Jd;
        if (biVar.dty()) {
            b bVar;
            ap apVar = new ap(biVar.field_content);
            b X = b.X(biVar.field_content, biVar.field_reserved);
            if (X == null) {
                X = new b();
                X.fgq = apVar.cvZ;
                bVar = X;
            } else {
                bVar = X;
            }
            Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(bVar.fgq);
        } else {
            Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
        }
        if (Jd != null && (Jd.field_catalog == EmojiInfo.yaB || (!bo.isNullOrNil(Jd.field_groupId) && ((d) g.M(d.class)).getEmojiMgr().Ji(Jd.field_groupId)))) {
            AppMethodBeat.o(30539);
            return false;
        } else if (Jd == null || !Jd.duU()) {
            AppMethodBeat.o(30539);
            return false;
        } else {
            AppMethodBeat.o(30539);
            return true;
        }
    }

    public static boolean aw(bi biVar) {
        AppMethodBeat.i(30540);
        if (biVar.dty()) {
            b bVar;
            ap apVar = new ap(biVar.field_content);
            b X = b.X(biVar.field_content, biVar.field_reserved);
            if (X == null) {
                X = new b();
                X.fgq = apVar.cvZ;
                bVar = X;
            } else {
                bVar = X;
            }
            if (((d) g.M(d.class)).getEmojiMgr().Jd(bVar.fgq) == null) {
                AppMethodBeat.o(30540);
                return false;
            }
        }
        AppMethodBeat.o(30540);
        return true;
    }

    public static boolean ax(bi biVar) {
        AppMethodBeat.i(30541);
        if (biVar == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            AppMethodBeat.o(30541);
            return true;
        }
        String oz;
        if (biVar.field_isSend == 0) {
            oz = bf.oz(biVar.field_content);
        } else {
            oz = biVar.field_content;
        }
        b me = b.me(oz);
        if (me == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            AppMethodBeat.o(30541);
            return false;
        }
        f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, false);
        if (bT == null || !bT.xy()) {
            AppMethodBeat.o(30541);
            return false;
        }
        AppMethodBeat.o(30541);
        return true;
    }

    public static boolean ay(bi biVar) {
        AppMethodBeat.i(30542);
        if (biVar.getType() == 419430449) {
            AppMethodBeat.o(30542);
            return true;
        }
        AppMethodBeat.o(30542);
        return false;
    }

    public static boolean az(bi biVar) {
        AppMethodBeat.i(30543);
        if (biVar.getType() == 436207665 || biVar.getType() == 469762097) {
            AppMethodBeat.o(30543);
            return true;
        }
        AppMethodBeat.o(30543);
        return false;
    }

    public static boolean aA(bi biVar) {
        AppMethodBeat.i(30544);
        if (biVar == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            AppMethodBeat.o(30544);
            return true;
        }
        String oz;
        if (biVar.field_isSend == 0) {
            oz = bf.oz(biVar.field_content);
        } else {
            oz = biVar.field_content;
        }
        b me = b.me(oz);
        if (me == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            AppMethodBeat.o(30544);
            return false;
        } else if (!(me.type == 33 && me.fiR == 3) && (!(me.type == 46 && me.fiR == 3) && (me.type != 44 || (me.fiR != 3 && me.fiY == 0 && me.cw(false))))) {
            AppMethodBeat.o(30544);
            return false;
        } else {
            AppMethodBeat.o(30544);
            return true;
        }
    }

    public static boolean eP(List<bi> list) {
        AppMethodBeat.i(30545);
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            AppMethodBeat.o(30545);
            return true;
        }
        for (bi biVar : list) {
            if (biVar.drD() || av(biVar) || biVar.dtw() || ax(biVar) || ay(biVar) || biVar.getType() == -1879048186 || aF(biVar) || az(biVar) || aE(biVar) || aA(biVar)) {
                AppMethodBeat.o(30545);
                return true;
            } else if (aI(biVar)) {
                AppMethodBeat.o(30545);
                return true;
            }
        }
        AppMethodBeat.o(30545);
        return false;
    }

    public static boolean a(boolean z, List<bi> list, ah ahVar) {
        boolean z2 = true;
        AppMethodBeat.i(30546);
        bi biVar;
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            AppMethodBeat.o(30546);
            return false;
        } else if (list.size() != 1 || ((ahVar == null || !ahVar.dCJ()) && !z)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                boolean z3;
                biVar = (bi) it.next();
                if ((ahVar == null || !ahVar.dCJ()) && !z) {
                    if (aB(biVar) || aC(biVar)) {
                        it.remove();
                        z3 = false;
                    }
                    z3 = z2;
                } else {
                    if (biVar.drD() || av(biVar) || ax(biVar) || ay(biVar) || biVar.getType() == -1879048186 || aF(biVar) || az(biVar) || ((aB(biVar) && (ahVar == null || !ahVar.dCJ())) || ((aC(biVar) && (ahVar == null || !ahVar.dCJ())) || biVar.getType() == 318767153 || aG(biVar) || aH(biVar) || aE(biVar) || aA(biVar)))) {
                        it.remove();
                        z2 = false;
                    }
                    z3 = z2;
                }
                z2 = z3;
            }
            AppMethodBeat.o(30546);
            return z2;
        } else {
            biVar = (bi) list.get(0);
            if (aG(biVar) || biVar.drD() || av(biVar) || ax(biVar) || ay(biVar) || biVar.getType() == -1879048186 || biVar.getType() == 318767153 || aF(biVar) || az(biVar) || aH(biVar) || aE(biVar) || aA(biVar)) {
                AppMethodBeat.o(30546);
                return false;
            }
            AppMethodBeat.o(30546);
            return true;
        }
    }

    private static boolean aB(bi biVar) {
        AppMethodBeat.i(30547);
        if (biVar != null) {
            b me = b.me(biVar.field_content);
            if (me != null && me.type == 19) {
                nt ntVar = new nt();
                ntVar.cJY.type = 0;
                ntVar.cJY.cKa = me.fgU;
                com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                c cVar = ntVar.cJZ.cKi;
                if (cVar != null) {
                    Iterator it = cVar.fjr.iterator();
                    while (it.hasNext()) {
                        if (!bo.isNullOrNil(((aar) it.next()).whr)) {
                            ab.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", Integer.valueOf(((aar) it.next()).dataType));
                            AppMethodBeat.o(30547);
                            return true;
                        }
                    }
                }
                if (me.fgU == null || !me.fgU.contains("<recordxml>")) {
                    AppMethodBeat.o(30547);
                    return false;
                }
                AppMethodBeat.o(30547);
                return true;
            }
        }
        AppMethodBeat.o(30547);
        return false;
    }

    private static boolean aC(bi biVar) {
        AppMethodBeat.i(30548);
        if (biVar != null) {
            b me = b.me(biVar.field_content);
            if (me != null && me.type == 24) {
                AppMethodBeat.o(30548);
                return true;
            }
        }
        AppMethodBeat.o(30548);
        return false;
    }

    public static boolean aD(bi biVar) {
        AppMethodBeat.i(30549);
        if (biVar != null) {
            b me = b.me(biVar.field_content);
            if (me == null) {
                AppMethodBeat.o(30549);
                return false;
            } else if (me.type == 6 || me.type == 5 || me.type == 19) {
                AppMethodBeat.o(30549);
                return true;
            }
        }
        AppMethodBeat.o(30549);
        return false;
    }

    public static boolean aE(bi biVar) {
        AppMethodBeat.i(30550);
        if (biVar == null || !biVar.drC()) {
            AppMethodBeat.o(30550);
            return false;
        }
        boolean c = l.c(biVar.field_msgId, biVar.field_content);
        AppMethodBeat.o(30550);
        return c;
    }

    static boolean aF(bi biVar) {
        AppMethodBeat.i(30551);
        if (biVar != null) {
            b me = b.me(biVar.field_content);
            if (me != null && me.type == 16) {
                AppMethodBeat.o(30551);
                return true;
            } else if (me != null && me.type == 34) {
                AppMethodBeat.o(30551);
                return true;
            }
        }
        AppMethodBeat.o(30551);
        return false;
    }

    static boolean aG(bi biVar) {
        AppMethodBeat.i(30552);
        if (biVar.dtw()) {
            aw.ZK();
            bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
            if (Rn == null || bo.isNullOrNil(Rn.svN)) {
                AppMethodBeat.o(30552);
                return true;
            } else if (t.mZ(Rn.svN)) {
                AppMethodBeat.o(30552);
                return false;
            } else {
                AppMethodBeat.o(30552);
                return true;
            }
        }
        AppMethodBeat.o(30552);
        return false;
    }

    private static boolean aH(bi biVar) {
        AppMethodBeat.i(30553);
        if (biVar != null && biVar.bAA()) {
            b me = b.me(biVar.field_content);
            if (me != null && me.type == 6 && (me.fgs != 0 || me.fgo > 26214400)) {
                AppMethodBeat.o(30553);
                return true;
            }
        }
        AppMethodBeat.o(30553);
        return false;
    }

    public static boolean aI(bi biVar) {
        AppMethodBeat.i(30554);
        if (biVar != null && biVar.bAA()) {
            b me = b.me(biVar.field_content);
            if (me != null && me.type == 6) {
                AppMethodBeat.o(30554);
                return true;
            }
        }
        AppMethodBeat.o(30554);
        return false;
    }

    public static int eQ(List<bi> list) {
        int i = 0;
        AppMethodBeat.i(30555);
        if (list == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            AppMethodBeat.o(30555);
            return 0;
        }
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                bi biVar = (bi) it.next();
                if (biVar.drD() || av(biVar) || biVar.bAC() || ax(biVar) || ay(biVar) || az(biVar)) {
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            } else {
                AppMethodBeat.o(30555);
                return i2;
            }
        }
    }

    public static boolean eR(List<bi> list) {
        AppMethodBeat.i(30556);
        if (list == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            AppMethodBeat.o(30556);
            return false;
        }
        for (bi biVar : list) {
            s uf;
            if (biVar.drE() || biVar.dtA()) {
                e fI;
                e eVar = null;
                if (biVar.field_msgId > 0) {
                    eVar = o.ahl().fJ(biVar.field_msgId);
                }
                if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                    fI = o.ahl().fI(biVar.field_msgSvrId);
                } else {
                    fI = eVar;
                }
                if (fI != null && (fI.offset < fI.frO || fI.frO == 0)) {
                    AppMethodBeat.o(30556);
                    return true;
                }
            } else if (biVar.bws()) {
                uf = com.tencent.mm.modelvideo.o.all().uf(biVar.field_imgPath);
                if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                    AppMethodBeat.o(30556);
                    return true;
                }
            } else if (biVar.dty()) {
                if (!aw(biVar)) {
                    AppMethodBeat.o(30556);
                    return true;
                }
            } else if (biVar.bAA()) {
                b X = b.X(biVar.field_content, biVar.field_content);
                if (X != null) {
                    switch (X.type) {
                        case 6:
                            com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(X.csD);
                            if (aiE != null) {
                                if (new com.tencent.mm.vfs.b(aiE.field_fileFullPath).exists()) {
                                    break;
                                }
                                AppMethodBeat.o(30556);
                                return true;
                            }
                            AppMethodBeat.o(30556);
                            return true;
                        default:
                            break;
                    }
                }
                AppMethodBeat.o(30556);
                return true;
            } else if (biVar.bwt()) {
                uf = u.ut(biVar.field_imgPath);
                if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                    AppMethodBeat.o(30556);
                    return true;
                }
            } else {
                continue;
            }
        }
        AppMethodBeat.o(30556);
        return false;
    }

    public static boolean eS(List<bi> list) {
        AppMethodBeat.i(30557);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(30557);
            return false;
        }
        for (bi biVar : list) {
            if (biVar.bws() && com.tencent.mm.pluginsdk.model.j.aiB(biVar.field_imgPath)) {
                AppMethodBeat.o(30557);
                return true;
            }
        }
        AppMethodBeat.o(30557);
        return false;
    }

    public static boolean eT(List<bi> list) {
        AppMethodBeat.i(30558);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(30558);
            return false;
        }
        for (bi bwt : list) {
            if (bwt.bwt()) {
                AppMethodBeat.o(30558);
                return true;
            }
        }
        AppMethodBeat.o(30558);
        return false;
    }

    public static String v(String str, int i, boolean z) {
        AppMethodBeat.i(30559);
        if (z && str != null && i == 0) {
            str = bf.oz(str);
        }
        AppMethodBeat.o(30559);
        return str;
    }

    public static List<String> dBY() {
        String str;
        AppMethodBeat.i(30560);
        List<String> le = z.aeR().le(25);
        com.tencent.mm.aj.e aeR = z.aeR();
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.aj.e.a(stringBuilder);
        com.tencent.mm.aj.e.c(stringBuilder);
        com.tencent.mm.aj.e.d(stringBuilder);
        com.tencent.mm.aj.e.a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(com.tencent.mm.aj.e.aet());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", stringBuilder.toString());
        Cursor rawQuery = aeR.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : arrayList) {
            String adX = com.tencent.mm.aj.f.qX(str2).adX();
            if (!bo.isNullOrNil(adX)) {
                hashMap.put(adX, str2);
            }
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str22 : le) {
            if (!com.tencent.mm.aj.f.ra(str22)) {
                linkedList.add(str22);
            } else if (com.tencent.mm.aj.f.re(str22)) {
                str22 = com.tencent.mm.aj.f.qX(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && com.tencent.mm.aj.f.rc(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!bo.isNullOrNil(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(bo.isNullOrNil(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        ab.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(30560);
        return linkedList;
    }

    public static List<String> dBZ() {
        AppMethodBeat.i(30561);
        List<String> le = z.aeR().le(25);
        LinkedList linkedList = new LinkedList();
        for (String str : le) {
            if (!com.tencent.mm.aj.f.ra(str)) {
                linkedList.add(str);
            }
        }
        ab.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(30561);
        return linkedList;
    }

    public static void c(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.i(30562);
        ab.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        String ug = com.tencent.mm.modelvideo.t.ug(r.Yz());
        com.tencent.mm.modelvideo.o.all();
        ab.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", com.tencent.mm.modelvideo.t.uh(str), com.tencent.mm.modelvideo.t.uh(ug), com.tencent.mm.modelvideo.t.ui(str), com.tencent.mm.modelvideo.t.ui(ug));
        com.tencent.mm.vfs.e.y(r1, r2);
        com.tencent.mm.vfs.e.y(r3, r4);
        u.a(ug, i2, str2, null, i, str3, i3);
        u.uo(ug);
        AppMethodBeat.o(30562);
    }

    static boolean a(Context context, String str, bi biVar, String str2) {
        AppMethodBeat.i(30563);
        if (context == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", str2);
            AppMethodBeat.o(30563);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", str2);
            AppMethodBeat.o(30563);
            return false;
        } else if (biVar == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", str2);
            AppMethodBeat.o(30563);
            return false;
        } else {
            AppMethodBeat.o(30563);
            return true;
        }
    }

    public static void a(Context context, String str, bi biVar) {
        AppMethodBeat.i(30564);
        if (a(context, str, biVar, "emoji")) {
            String str2;
            String str3 = ap.aps(biVar.field_content).cvZ;
            if (str3 == null || str3.endsWith("-1")) {
                str2 = biVar.field_imgPath;
            } else {
                str2 = str3;
            }
            if (str2 == null) {
                ab.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
                AppMethodBeat.o(30564);
                return;
            }
            ((d) g.M(d.class)).getEmojiMgr().r(context, str, str2);
            AppMethodBeat.o(30564);
            return;
        }
        AppMethodBeat.o(30564);
    }

    public static void b(Context context, String str, bi biVar) {
        AppMethodBeat.i(30565);
        if (a(context, str, biVar, "image")) {
            e eVar = null;
            if (biVar.field_msgId > 0) {
                eVar = o.ahl().fJ(biVar.field_msgId);
            }
            if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                eVar = o.ahl().fI(biVar.field_msgSvrId);
            }
            if (eVar == null) {
                AppMethodBeat.o(30565);
                return;
            }
            int i = 0;
            if (eVar.agQ() && !com.tencent.mm.at.f.a(eVar).fDz.startsWith("SERVERID://")) {
                i = 1;
            }
            String q = o.ahl().q(com.tencent.mm.at.f.c(eVar), "", "");
            String q2 = o.ahl().q(eVar.fDB, "th_", "");
            if (eVar.offset < eVar.frO || eVar.frO == 0) {
                Object obj;
                final String Yz = r.Yz();
                final String str2 = eVar.fDK;
                Map z = br.z(eVar.fDK, "msg");
                if (z == null) {
                    ab.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", eVar.fDK);
                    obj = null;
                } else {
                    int i2;
                    String str3;
                    final int i3 = eVar.fDC;
                    if (i3 != 1) {
                        i2 = 2;
                        str3 = (String) z.get(".msg.img.$cdnmidimgurl");
                    } else {
                        i2 = 1;
                        str3 = (String) z.get(".msg.img.$cdnbigimgurl");
                    }
                    ab.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i3), str3);
                    if (bo.isNullOrNil(str3)) {
                        ab.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        String str4 = (String) z.get(".msg.img.$aeskey");
                        if (bo.isNullOrNil(str4)) {
                            ab.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            if (bo.isNullOrNil(com.tencent.mm.al.c.a("downimg", (long) eVar.fDG, biVar.field_talker, biVar.field_msgId))) {
                                ab.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(biVar.field_msgSvrId));
                                obj = null;
                            } else {
                                final String str5 = (String) z.get(".msg.img.$md5");
                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                final bi biVar2 = biVar;
                                final String str6 = str;
                                final Context context2 = context;
                                gVar.egl = new com.tencent.mm.i.g.a() {
                                    final /* synthetic */ int jOj = 4;

                                    /* JADX WARNING: Removed duplicated region for block: B:23:0x02bf  */
                                    /* JADX WARNING: Removed duplicated region for block: B:17:0x01aa  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                        AppMethodBeat.i(30532);
                                        if (dVar != null) {
                                            if (dVar.field_exist_whencheck) {
                                                long a;
                                                int i2;
                                                String a2;
                                                clk clk;
                                                ab.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", dVar);
                                                cy cyVar = biVar2;
                                                int i3 = this.jOj;
                                                String str2 = str6;
                                                String str3 = Yz;
                                                String str4 = str2;
                                                String str5 = str5;
                                                int i4 = i3;
                                                String I = o.ahl().I(cyVar.field_imgPath, true);
                                                PString pString = new PString();
                                                PInt pInt = new PInt();
                                                PInt pInt2 = new PInt();
                                                pString.value = "";
                                                cy biVar = new bi();
                                                biVar.setType(t.nL(str2));
                                                biVar.ju(str2);
                                                biVar.hO(1);
                                                biVar.setStatus(1);
                                                biVar.eJ(bf.oC(biVar.field_talker));
                                                biVar.setContent(str4);
                                                com.tencent.mm.l.a.a.KG().g(biVar);
                                                long Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
                                                Assert.assertTrue(Z >= 0);
                                                ab.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
                                                if (i4 == 1) {
                                                    a = o.ahl().a(null, Z, true, biVar.field_content, pString, pInt, pInt2);
                                                } else {
                                                    a = 0;
                                                }
                                                long a3 = o.ahl().a(null, Z, false, biVar.field_content, pString, pInt, pInt2);
                                                Map z2 = br.z(str4, "msg");
                                                int i5 = bo.getInt((String) z2.get(".msg.img.$length"), dVar.field_thumbimgLength);
                                                e b = o.ahl().b(Long.valueOf(a3));
                                                b.fG((long) ((int) Z));
                                                if (a3 > 0) {
                                                    ab.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", o.ahl().b(pString.value, "th_", "", false));
                                                    com.tencent.mm.vfs.e.y(I, r9);
                                                    biVar.jv(pString.value);
                                                    biVar.hZ(cyVar.dJw);
                                                    biVar.ia(cyVar.dJx);
                                                    if (a > 0) {
                                                        b.lx(1);
                                                        b.lu((int) a);
                                                        i2 = bo.getInt((String) z2.get(".msg.img.$hdlength"), dVar.field_thumbimgLength);
                                                        o.ahl().a(Long.valueOf(a3), b);
                                                        if (i4 != 1) {
                                                            b = o.ahl().b(Long.valueOf(a));
                                                        } else {
                                                            a = a3;
                                                        }
                                                        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(Z, (bi) biVar);
                                                        o.ahl().a(Long.valueOf(a), b);
                                                        a2 = com.tencent.mm.al.c.a("upimg", biVar.field_createTime, biVar.field_talker, biVar.field_msgId + "_" + a + "_" + i4);
                                                        clk = new clk();
                                                        clk.vEB = new bts().alV(str3);
                                                        clk.vEC = new bts().alV(str2);
                                                        clk.nao = biVar.getType();
                                                        clk.vEG = biVar.dqJ;
                                                        clk.vRz = b.fDD;
                                                        clk.xja = new bts().alV(a2);
                                                        clk.wqw = i4;
                                                        dVar.field_filemd5 = str5;
                                                        dVar.field_thumbimgLength = (int) com.tencent.mm.vfs.e.asZ(I);
                                                        dVar.field_fileLength = i2;
                                                        g.Rg().a(new m(i3, clk, b, dVar, new AnonymousClass2(a3, Z)), 0);
                                                    }
                                                }
                                                i2 = i5;
                                                o.ahl().a(Long.valueOf(a3), b);
                                                if (i4 != 1) {
                                                }
                                                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(Z, (bi) biVar);
                                                o.ahl().a(Long.valueOf(a), b);
                                                a2 = com.tencent.mm.al.c.a("upimg", biVar.field_createTime, biVar.field_talker, biVar.field_msgId + "_" + a + "_" + i4);
                                                clk = new clk();
                                                clk.vEB = new bts().alV(str3);
                                                clk.vEC = new bts().alV(str2);
                                                clk.nao = biVar.getType();
                                                clk.vEG = biVar.dqJ;
                                                clk.vRz = b.fDD;
                                                clk.xja = new bts().alV(a2);
                                                clk.wqw = i4;
                                                dVar.field_filemd5 = str5;
                                                dVar.field_thumbimgLength = (int) com.tencent.mm.vfs.e.asZ(I);
                                                dVar.field_fileLength = i2;
                                                g.Rg().a(new m(i3, clk, b, dVar, new AnonymousClass2(a3, Z)), 0);
                                            } else {
                                                ab.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                                                j.a(context2, eVar, biVar2, this.jOj, str6, o.ahl().q(eVar.fDB, "th_", ""));
                                            }
                                        }
                                        AppMethodBeat.o(30532);
                                        return 0;
                                    }

                                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                    }

                                    public final byte[] l(String str, byte[] bArr) {
                                        return new byte[0];
                                    }
                                };
                                gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), str, biVar.field_msgId);
                                gVar.field_fileId = str3;
                                gVar.field_aesKey = str4;
                                gVar.field_filemd5 = str5;
                                gVar.field_fileType = i2;
                                gVar.field_talker = str;
                                gVar.field_priority = com.tencent.mm.i.a.efC;
                                gVar.field_svr_signature = "";
                                gVar.field_onlycheckexist = true;
                                gVar.field_trysafecdn = true;
                                if (com.tencent.mm.al.f.afx().e(gVar)) {
                                    obj = 1;
                                } else {
                                    ab.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
                                    obj = null;
                                }
                            }
                        }
                    }
                }
                if (obj == null) {
                    a(context, eVar, biVar, 4, str, q2);
                }
                AppMethodBeat.o(30565);
                return;
            }
            if (!bo.isNullOrNil(q)) {
                com.tencent.mm.plugin.messenger.a.g.bOk().a(context, str, q, i, eVar.fDK, q2);
            }
            AppMethodBeat.o(30565);
            return;
        }
        AppMethodBeat.o(30565);
    }

    static void a(final Context context, final e eVar, bi biVar, int i, String str, String str2) {
        AppMethodBeat.i(30566);
        String q = o.ahl().q(com.tencent.mm.at.f.c(eVar), "", "");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = q;
        int i2 = eVar.fDC;
        long a = o.ahl().a(q, i2, i, pString, pInt, pInt2);
        e b = o.ahl().b(Long.valueOf(a));
        b.lw(1);
        bi biVar2 = new bi();
        biVar2.setType(t.nL(str));
        biVar2.ju(str);
        biVar2.hO(1);
        biVar2.setStatus(1);
        biVar2.jv(pString.value);
        biVar2.hZ(pInt.value);
        biVar2.ia(pInt2.value);
        biVar2.eJ(bf.oC(biVar2.field_talker));
        if (com.tencent.mm.aj.f.kq(biVar2.field_talker)) {
            biVar.ix(com.tencent.mm.aj.a.e.aae());
        }
        aw.ZK();
        long Z = com.tencent.mm.model.c.XO().Z(biVar2);
        Assert.assertTrue(Z >= 0);
        ab.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        b.fG((long) ((int) Z));
        o.ahl().a(Long.valueOf(a), b);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(Z), eVar);
        final String str3 = str;
        final String str4 = str2;
        o.ahm().a(eVar.fDy, biVar.field_msgId, i2, hashMap, R.drawable.b0p, new com.tencent.mm.at.d.a() {
            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ai.m mVar) {
            }

            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ai.m mVar) {
                Object obj2;
                AppMethodBeat.i(30534);
                if (i3 == 0 && i4 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj instanceof HashMap) {
                    HashMap hashMap = (HashMap) obj;
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            Long l = (Long) entry.getKey();
                            String q = o.ahl().q(com.tencent.mm.at.f.c((e) entry.getValue()), "", "");
                            if (obj2 != null) {
                                aw.ZK();
                                com.tencent.mm.model.c.XO().jg(l.longValue());
                                com.tencent.mm.plugin.messenger.a.g.bOk().a(context, str3, q, i, eVar.fDK, str4);
                            }
                        }
                    }
                }
                AppMethodBeat.o(30534);
            }

            public final void a(long j, long j2, int i, int i2, Object obj) {
            }
        });
        AppMethodBeat.o(30566);
    }

    static void e(final String str, final bi biVar) {
        AppMethodBeat.i(30567);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30538);
                com.tencent.mm.modelvideo.o.alq().a(biVar.field_imgPath, new com.tencent.mm.modelvideo.t.a() {
                    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
                        AppMethodBeat.i(30537);
                        s ut = u.ut(aVar.fileName);
                        if (ut != null && ut.status == 199) {
                            j.c(biVar.field_imgPath, str, ut.fXh, ut.fXd, ut.alw(), biVar.getType());
                        }
                        AppMethodBeat.o(30537);
                    }
                });
                AppMethodBeat.o(30538);
            }
        });
        AppMethodBeat.o(30567);
    }

    public static void c(Context context, String str, bi biVar) {
        AppMethodBeat.i(30568);
        if (!a(context, str, biVar, "video") || biVar == null) {
            AppMethodBeat.o(30568);
        } else if (biVar != null && biVar.bwt() && u.uv(biVar.field_imgPath)) {
            AppMethodBeat.o(30568);
        } else {
            s ut = u.ut(biVar.field_imgPath);
            if (ut == null || ut.status != 199) {
                Object obj;
                Map z = br.z(ut.alw(), "msg");
                if (z == null) {
                    ab.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
                    obj = null;
                } else {
                    final String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                    if (bo.isNullOrNil(str2)) {
                        obj = null;
                    } else {
                        final String str3 = (String) z.get(".msg.videomsg.$aeskey");
                        final String str4 = (String) z.get(".msg.videomsg.$md5");
                        final String str5 = (String) z.get(".msg.videomsg.$newmd5");
                        final int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                        final int i = bo.getInt((String) z.get(".msg.videomsg.$playlength"), 0);
                        final int i2 = bo.getInt((String) z.get(".msg.videomsg.$cdnthumblength"), 0);
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        final String str6 = str;
                        final bi biVar2 = biVar;
                        gVar.egl = new com.tencent.mm.i.g.a() {
                            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                AppMethodBeat.i(30536);
                                if (dVar != null) {
                                    if (dVar.field_exist_whencheck) {
                                        dVar.field_fileId = str2;
                                        dVar.field_aesKey = str3;
                                        dVar.field_thumbimgLength = i2;
                                        dVar.field_fileLength = intValue;
                                        dVar.field_toUser = str6;
                                        dVar.field_filemd5 = str4;
                                        dVar.field_mp4identifymd5 = str5;
                                        ab.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", dVar);
                                        final String ug = com.tencent.mm.modelvideo.t.ug(r.Yz());
                                        com.tencent.mm.modelvideo.o.all();
                                        String ui = com.tencent.mm.modelvideo.t.ui(ug);
                                        com.tencent.mm.modelvideo.o.all();
                                        com.tencent.mm.vfs.e.y(com.tencent.mm.modelvideo.t.ui(biVar2.field_imgPath), ui);
                                        ab.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + str3 + "\" cdnthumbaeskey=\"" + str3 + "\" cdnvideourl=\"" + str2 + "\" ") + "cdnthumburl=\"" + str2 + "\" ") + "length=\"" + intValue + "\" ") + "cdnthumblength=\"" + i2 + "\"/></msg>");
                                        u.d(ug, i, str6, ui);
                                        g.Rg().a(new h(ug, 0, dVar, new h.a() {
                                            public final void cC(int i, int i2) {
                                                AppMethodBeat.i(30535);
                                                s ut = u.ut(ug);
                                                ut.status = 111;
                                                ut.bJt = 256;
                                                com.tencent.mm.modelvideo.o.all().c(ut);
                                                ab.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                                                AppMethodBeat.o(30535);
                                            }
                                        }), 0);
                                    } else {
                                        j.e(str6, biVar2);
                                    }
                                }
                                AppMethodBeat.o(30536);
                                return 0;
                            }

                            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                            }

                            public final byte[] l(String str, byte[] bArr) {
                                return new byte[0];
                            }
                        };
                        gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), str, biVar.field_msgId);
                        gVar.field_fileId = str2;
                        gVar.field_aesKey = str3;
                        gVar.field_filemd5 = str4;
                        gVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
                        gVar.field_talker = str;
                        gVar.field_priority = com.tencent.mm.i.a.efC;
                        gVar.field_svr_signature = "";
                        gVar.field_onlycheckexist = true;
                        gVar.field_trysafecdn = true;
                        if (com.tencent.mm.al.f.afx().e(gVar)) {
                            obj = 1;
                        } else {
                            ab.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
                            obj = null;
                        }
                    }
                }
                if (obj == null) {
                    e(str, biVar);
                }
                AppMethodBeat.o(30568);
                return;
            }
            c(biVar.field_imgPath, str, ut.fXh, ut.fXd, ut.alw(), biVar.getType());
            AppMethodBeat.o(30568);
        }
    }

    public static void a(Context context, String str, bi biVar, boolean z) {
        AppMethodBeat.i(30569);
        if (a(context, str, biVar, "text")) {
            String v = v(biVar.field_content, biVar.field_isSend, z);
            if (biVar.dtM()) {
                v = v + "\n\n" + v(biVar.field_transContent, biVar.field_isSend, z);
            }
            if (v == null || v.equals("")) {
                ab.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
                AppMethodBeat.o(30569);
                return;
            }
            com.tencent.mm.plugin.messenger.a.g.bOk().F(str, v, t.nK(str));
            AppMethodBeat.o(30569);
            return;
        }
        AppMethodBeat.o(30569);
    }

    public static void b(Context context, String str, bi biVar, boolean z) {
        AppMethodBeat.i(30570);
        if (!a(context, str, biVar, "appmsg")) {
            AppMethodBeat.o(30570);
        } else if (context == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
            AppMethodBeat.o(30570);
        } else if (biVar == null) {
            ab.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.o(30570);
        } else {
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                String str2;
                String c = o.ahl().c(biVar.field_imgPath, false, false);
                if (ah.isNullOrNil(c) || c.endsWith("hd") || !com.tencent.mm.vfs.e.ct(c + "hd")) {
                    str2 = c;
                } else {
                    str2 = c + "hd";
                }
                try {
                    com.tencent.mm.af.o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
                    LinkedList<p> linkedList = b.fjr;
                    if (linkedList == null || linkedList.size() <= 0) {
                        if (biVar == null || !(biVar.bAA() || biVar.drC())) {
                            c = null;
                        } else {
                            String nW = v.nW(biVar.field_msgSvrId);
                            v.b y = v.Zp().y(nW, true);
                            y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                            y.j("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(biVar, z, false));
                            y.j("preChatName", biVar.field_talker);
                            y.j("preMsgIndex", Integer.valueOf(0));
                            y.j("sendAppMsgScene", Integer.valueOf(1));
                            ((com.tencent.mm.plugin.sns.b.i) g.K(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", y, biVar);
                            c = nW;
                        }
                        com.tencent.mm.plugin.messenger.a.g.bOk().a(str, bo.readFromFile(str2), bo.anj(biVar.field_content), c);
                        AppMethodBeat.o(30570);
                        return;
                    }
                    for (p pVar : linkedList) {
                        b bVar = new b();
                        if (l.mg(pVar.fjC)) {
                            l.b(str, l.a(str, pVar), pVar.fjH);
                        } else {
                            bVar.title = pVar.title;
                            bVar.description = pVar.fjz;
                            bVar.action = "view";
                            bVar.type = 5;
                            bVar.url = pVar.url;
                            bVar.cMg = b.cMg;
                            bVar.cMh = b.cMh;
                            bVar.dJv = b.dJv;
                            bVar.thumburl = l.a(pVar);
                            com.tencent.mm.af.f eVar = new com.tencent.mm.af.e();
                            eVar.ffZ = pVar.type;
                            if (pVar.type == 5) {
                                eVar.fgd = pVar.fgd;
                                eVar.fga = (int) pVar.time;
                                eVar.duration = pVar.fjB;
                                eVar.videoWidth = pVar.videoWidth;
                                eVar.videoHeight = pVar.videoHeight;
                            }
                            bVar.a(eVar);
                            if (bo.isNullOrNil(bVar.thumburl) && !bo.isNullOrNil(bVar.cMg)) {
                                com.tencent.mm.ah.h qo = com.tencent.mm.ah.o.act().qo(bVar.cMg);
                                if (qo != null) {
                                    bVar.thumburl = qo.ack();
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.g.bOk().a(str, bo.readFromFile(str2), bo.anj(b.a(bVar, null, null)), null);
                        }
                    }
                    AppMethodBeat.o(30570);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    ab.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", e.getLocalizedMessage());
                    AppMethodBeat.o(30570);
                    return;
                }
            }
            AppMethodBeat.o(30570);
        }
    }

    public static void c(Context context, String str, bi biVar, boolean z) {
        AppMethodBeat.i(30571);
        if (a(context, str, biVar, FirebaseAnalytics.b.LOCATION)) {
            com.tencent.mm.plugin.messenger.a.g.bOk().F(str, v(biVar.field_content, biVar.field_isSend, z), 48);
            AppMethodBeat.o(30571);
            return;
        }
        AppMethodBeat.o(30571);
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        AppMethodBeat.i(30572);
        try {
            bi biVar = new bi();
            biVar.setContent(str2);
            biVar.hO(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map z2 = br.z(str2, "msg");
            if (z2 != null && z2.size() > 0) {
                biVar.jw(be.aS(z2));
            }
            b(context, str, biVar, z);
            AppMethodBeat.o(30572);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
            ab.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
            AppMethodBeat.o(30572);
        }
    }

    public static void b(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(30573);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Yb()).append(emojiInfo.Aq()).toString();
        if (com.tencent.mm.vfs.e.asZ(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = com.tencent.mm.vfs.e.e(stringBuilder2 + "_thumb", 0, (int) com.tencent.mm.vfs.e.asZ(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream openRead = com.tencent.mm.vfs.e.openRead(stringBuilder2);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.b.b(openRead, 1.0f));
                openRead.close();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                ab.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, emojiInfo.field_app_id, null, str, 1, emojiInfo.Aq());
        AppMethodBeat.o(30573);
    }
}
