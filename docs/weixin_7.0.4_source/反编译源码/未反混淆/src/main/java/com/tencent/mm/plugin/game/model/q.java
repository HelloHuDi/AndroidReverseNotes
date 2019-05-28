package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class q {
    public static n bEm() {
        n iP;
        AppMethodBeat.i(111317);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            iP = ((c) g.K(c.class)).bCY().iP(longValue);
        } else {
            iP = null;
        }
        if (iP == null || iP.field_isHidden || b(iP)) {
            com.tencent.mm.plugin.game.e.a.Oh("");
            AppMethodBeat.o(111317);
            return null;
        }
        AppMethodBeat.o(111317);
        return iP;
    }

    public static void bEn() {
        AppMethodBeat.i(111318);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = ((c) g.K(c.class)).bCY().iP(longValue);
        }
        if (nVar == null || nVar.field_isHidden) {
            AppMethodBeat.o(111318);
            return;
        }
        g.RP().Ry().set(a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.o(111318);
    }

    public static n bEo() {
        AppMethodBeat.i(111319);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(111319);
            return null;
        }
        n iP = ((c) g.K(c.class)).bCY().iP(longValue);
        if (iP == null || iP.field_isHidden || b(iP)) {
            AppMethodBeat.o(111319);
            return null;
        }
        AppMethodBeat.o(111319);
        return iP;
    }

    public static void bEp() {
        AppMethodBeat.i(111320);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = ((c) g.K(c.class)).bCY().iP(longValue);
        }
        if (nVar == null || nVar.field_isHidden) {
            AppMethodBeat.o(111320);
            return;
        }
        g.RP().Ry().set(a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.o(111320);
    }

    public static n bEq() {
        AppMethodBeat.i(111321);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(111321);
            return null;
        }
        n iP = ((c) g.K(c.class)).bCY().iP(longValue);
        if (iP == null || iP.field_isHidden || b(iP)) {
            AppMethodBeat.o(111321);
            return null;
        }
        AppMethodBeat.o(111321);
        return iP;
    }

    public static void bEr() {
        AppMethodBeat.i(111322);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = ((c) g.K(c.class)).bCY().iP(longValue);
        }
        if (nVar == null || nVar.field_isHidden) {
            AppMethodBeat.o(111322);
            return;
        }
        g.RP().Ry().set(a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.o(111322);
    }

    public static n bEs() {
        AppMethodBeat.i(111323);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(111323);
            return null;
        }
        n iP = ((c) g.K(c.class)).bCY().iP(longValue);
        if (iP == null || iP.field_isHidden || b(iP)) {
            AppMethodBeat.o(111323);
            return null;
        }
        AppMethodBeat.o(111323);
        return iP;
    }

    public static void bEt() {
        AppMethodBeat.i(111324);
        long longValue = ((Long) g.RP().Ry().get(a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = ((c) g.K(c.class)).bCY().iP(longValue);
        }
        if (nVar == null || nVar.field_isHidden) {
            AppMethodBeat.o(111324);
            return;
        }
        g.RP().Ry().set(a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(0));
        AppMethodBeat.o(111324);
    }

    private static boolean b(n nVar) {
        AppMethodBeat.i(111325);
        if (nVar.field_expireTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(111325);
            return true;
        }
        AppMethodBeat.o(111325);
        return false;
    }

    public static void c(n nVar) {
        AppMethodBeat.i(111326);
        if (bo.isNullOrNil(nVar.field_mergerId)) {
            AppMethodBeat.o(111326);
            return;
        }
        n nVar2;
        r bCY = ((c) g.K(c.class)).bCY();
        String str = "select * from GameRawMessage where msgType=" + nVar.field_msgType + " and mergerId= \"" + nVar.field_mergerId + "\" order by createTime desc limit 1";
        n nVar3 = new n();
        Cursor rawQuery = bCY.rawQuery(str, new String[0]);
        if (rawQuery == null) {
            nVar2 = null;
        } else {
            if (rawQuery.moveToFirst()) {
                nVar3.d(rawQuery);
            }
            rawQuery.close();
            nVar2 = nVar3;
        }
        if (nVar2 != null) {
            nVar2.bEl();
            if (!bo.ek(nVar2.mWp)) {
                nVar.bEl();
                LinkedList linkedList = new LinkedList(nVar2.mWp);
                if (!bo.ek(nVar.mWp)) {
                    String str2 = ((i) nVar.mWp.get(0)).userName;
                    if (!bo.isNullOrNil(str2)) {
                        Iterator it = nVar2.mWp.iterator();
                        while (it.hasNext()) {
                            i iVar = (i) it.next();
                            if (iVar.userName.equals(str2)) {
                                linkedList.remove(iVar);
                                break;
                            }
                        }
                    }
                }
                if (!bo.ek(linkedList)) {
                    nVar.field_rawXML = ah.a(nVar.field_rawXML, linkedList, nVar2.mWu);
                }
                ((c) g.K(c.class)).bCY().a((com.tencent.mm.sdk.e.c) nVar2, new String[0]);
            }
        }
        AppMethodBeat.o(111326);
    }
}
