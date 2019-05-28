package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends j<g> {
    public static final String[] fnj = new String[]{j.a(g.ccO, "BizKF")};
    private e bSd;

    static {
        AppMethodBeat.i(11400);
        AppMethodBeat.o(11400);
    }

    public i(e eVar) {
        super(eVar, g.ccO, "BizKF", null);
        AppMethodBeat.i(11392);
        this.bSd = eVar;
        eVar.hY("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        eVar.hY("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
        AppMethodBeat.o(11392);
    }

    public final g rg(String str) {
        AppMethodBeat.i(11393);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(11393);
            return null;
        }
        Cursor a = this.bSd.a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            AppMethodBeat.o(11393);
            return gVar;
        }
        ab.w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.o(11393);
        return null;
    }

    public static boolean a(g gVar) {
        AppMethodBeat.i(11394);
        if (gVar == null) {
            AppMethodBeat.o(11394);
            return false;
        } else if (System.currentTimeMillis() - gVar.field_updateTime >= 86400000) {
            AppMethodBeat.o(11394);
            return true;
        } else {
            AppMethodBeat.o(11394);
            return false;
        }
    }

    private boolean b(g gVar) {
        AppMethodBeat.i(11395);
        if (gVar == null || bo.isNullOrNil(gVar.field_openId) || bo.isNullOrNil(gVar.field_brandUsername)) {
            ab.w("MicroMsg.BizKFStorage", "wrong argument");
            AppMethodBeat.o(11395);
            return false;
        }
        boolean z;
        if (this.bSd.replace("BizKF", g.ccO.xDc, gVar.Hl()) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", gVar.field_openId, gVar.field_brandUsername, Boolean.valueOf(z));
        AppMethodBeat.o(11395);
        return z;
    }

    public final g rh(String str) {
        AppMethodBeat.i(11396);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11396);
            return null;
        }
        Cursor a = this.bSd.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            AppMethodBeat.o(11396);
            return gVar;
        }
        ab.w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.o(11396);
        return null;
    }

    public final int ri(String str) {
        AppMethodBeat.i(11397);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11397);
            return -1;
        }
        ab.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str, Integer.valueOf(this.bSd.delete("BizKF", "brandUsername = ?", new String[]{str})));
        AppMethodBeat.o(11397);
        return this.bSd.delete("BizKF", "brandUsername = ?", new String[]{str});
    }

    public final int f(LinkedList<g> linkedList) {
        AppMethodBeat.i(11398);
        if (linkedList.size() <= 0) {
            ab.e("MicroMsg.BizKFStorage", "null kfs");
            AppMethodBeat.o(11398);
            return 0;
        }
        long iV;
        if (this.bSd instanceof h) {
            iV = ((h) this.bSd).iV(Thread.currentThread().getId());
        } else {
            iV = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar != null && b(gVar)) {
                i++;
            }
            i = i;
        }
        if (this.bSd instanceof h) {
            g.RP().eJN.mB(iV);
        }
        ab.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i));
        AppMethodBeat.o(11398);
        return i;
    }
}
