package com.tencent.p177mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.q */
public final class C39215q {
    public static C28229n bEm() {
        C28229n iP;
        AppMethodBeat.m2504i(111317);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        } else {
            iP = null;
        }
        if (iP == null || iP.field_isHidden || C39215q.m66821b(iP)) {
            C34276a.m56202Oh("");
            AppMethodBeat.m2505o(111317);
            return null;
        }
        AppMethodBeat.m2505o(111317);
        return iP;
    }

    public static void bEn() {
        AppMethodBeat.m2504i(111318);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        C28229n c28229n = null;
        if (longValue != 0) {
            c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        }
        if (c28229n == null || c28229n.field_isHidden) {
            AppMethodBeat.m2505o(111318);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.m2505o(111318);
    }

    public static C28229n bEo() {
        AppMethodBeat.m2504i(111319);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.m2505o(111319);
            return null;
        }
        C28229n iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        if (iP == null || iP.field_isHidden || C39215q.m66821b(iP)) {
            AppMethodBeat.m2505o(111319);
            return null;
        }
        AppMethodBeat.m2505o(111319);
        return iP;
    }

    public static void bEp() {
        AppMethodBeat.m2504i(111320);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        C28229n c28229n = null;
        if (longValue != 0) {
            c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        }
        if (c28229n == null || c28229n.field_isHidden) {
            AppMethodBeat.m2505o(111320);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.m2505o(111320);
    }

    public static C28229n bEq() {
        AppMethodBeat.m2504i(111321);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.m2505o(111321);
            return null;
        }
        C28229n iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        if (iP == null || iP.field_isHidden || C39215q.m66821b(iP)) {
            AppMethodBeat.m2505o(111321);
            return null;
        }
        AppMethodBeat.m2505o(111321);
        return iP;
    }

    public static void bEr() {
        AppMethodBeat.m2504i(111322);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        C28229n c28229n = null;
        if (longValue != 0) {
            c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        }
        if (c28229n == null || c28229n.field_isHidden) {
            AppMethodBeat.m2505o(111322);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.m2505o(111322);
    }

    public static C28229n bEs() {
        AppMethodBeat.m2504i(111323);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.m2505o(111323);
            return null;
        }
        C28229n iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        if (iP == null || iP.field_isHidden || C39215q.m66821b(iP)) {
            AppMethodBeat.m2505o(111323);
            return null;
        }
        AppMethodBeat.m2505o(111323);
        return iP;
    }

    public static void bEt() {
        AppMethodBeat.m2504i(111324);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        C28229n c28229n = null;
        if (longValue != 0) {
            c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
        }
        if (c28229n == null || c28229n.field_isHidden) {
            AppMethodBeat.m2505o(111324);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.m2505o(111324);
    }

    /* renamed from: b */
    private static boolean m66821b(C28229n c28229n) {
        AppMethodBeat.m2504i(111325);
        if (c28229n.field_expireTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.m2505o(111325);
            return true;
        }
        AppMethodBeat.m2505o(111325);
        return false;
    }

    /* renamed from: c */
    public static void m66822c(C28229n c28229n) {
        AppMethodBeat.m2504i(111326);
        if (C5046bo.isNullOrNil(c28229n.field_mergerId)) {
            AppMethodBeat.m2505o(111326);
            return;
        }
        C28229n c28229n2;
        C46012r bCY = ((C45983c) C1720g.m3528K(C45983c.class)).bCY();
        String str = "select * from GameRawMessage where msgType=" + c28229n.field_msgType + " and mergerId= \"" + c28229n.field_mergerId + "\" order by createTime desc limit 1";
        C28229n c28229n3 = new C28229n();
        Cursor rawQuery = bCY.rawQuery(str, new String[0]);
        if (rawQuery == null) {
            c28229n2 = null;
        } else {
            if (rawQuery.moveToFirst()) {
                c28229n3.mo8995d(rawQuery);
            }
            rawQuery.close();
            c28229n2 = c28229n3;
        }
        if (c28229n2 != null) {
            c28229n2.bEl();
            if (!C5046bo.m7548ek(c28229n2.mWp)) {
                c28229n.bEl();
                LinkedList linkedList = new LinkedList(c28229n2.mWp);
                if (!C5046bo.m7548ek(c28229n.mWp)) {
                    String str2 = ((C28233i) c28229n.mWp.get(0)).userName;
                    if (!C5046bo.isNullOrNil(str2)) {
                        Iterator it = c28229n2.mWp.iterator();
                        while (it.hasNext()) {
                            C28233i c28233i = (C28233i) it.next();
                            if (c28233i.userName.equals(str2)) {
                                linkedList.remove(c28233i);
                                break;
                            }
                        }
                    }
                }
                if (!C5046bo.m7548ek(linkedList)) {
                    c28229n.field_rawXML = C12158ah.m20093a(c28229n.field_rawXML, linkedList, c28229n2.mWu);
                }
                ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo16760a((C4925c) c28229n2, new String[0]);
            }
        }
        AppMethodBeat.m2505o(111326);
    }
}
