package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum t {
    ;
    
    private static Integer hai;
    private static final long haj = 0;

    static {
        hai = null;
        haj = TimeUnit.DAYS.toSeconds(1);
        AppMethodBeat.o(129662);
    }

    public static boolean axG() {
        return true;
    }

    public static boolean axH() {
        return true;
    }

    public static void nC(int i) {
        AppMethodBeat.i(129659);
        hai = Integer.valueOf(i);
        s sVar = (s) f.E(s.class);
        Cursor query = sVar.hae.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", new Object[]{"orderSequence", Long.valueOf(Long.MAX_VALUE), Integer.valueOf(axI())}));
        if (query == null) {
            AppMethodBeat.o(129659);
            return;
        }
        List linkedList;
        if (query.moveToFirst()) {
            linkedList = new LinkedList();
            do {
                linkedList.add(String.valueOf(query.getLong(0)));
            } while (query.moveToNext());
        } else {
            linkedList = null;
        }
        query.close();
        if (!bo.ek(linkedList)) {
            String[] strArr = new String[1];
            long iV = sVar.hae.iV(Thread.currentThread().getId());
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                strArr[0] = (String) it.next();
                sVar.hae.delete("AppBrandStarApp", "rowid=?", strArr);
            }
            sVar.hae.mB(iV);
            sVar.b("batch", 5, null);
        }
        AppMethodBeat.o(129659);
    }

    public static int axI() {
        AppMethodBeat.i(129660);
        int intValue;
        if (hai != null) {
            intValue = hai.intValue();
            AppMethodBeat.o(129660);
            return intValue;
        }
        intValue = AppBrandGlobalSystemConfig.ayC().hfR;
        AppMethodBeat.o(129660);
        return intValue;
    }

    static void a(int i, int i2, int i3, String str, b bVar, Long l) {
        AppMethodBeat.i(129661);
        if (bVar == null) {
            ab.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
            AppMethodBeat.o(129661);
        } else if ((((arj) bVar.fsG.fsP).condition & 2) == 0) {
            AppMethodBeat.o(129661);
        } else {
            ark ark = (ark) bVar.fsH.fsP;
            ab.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", Integer.valueOf(i2), Integer.valueOf(i3), str, l);
            if (i2 == 0 && i3 == 0 && ark != null) {
                if (f.E(s.class) != null) {
                    ((s) f.E(s.class)).a(cwq.class, ark.wvv, l);
                    u.a(i, ark.wvv);
                }
                g.RP().Ry().set(a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.valueOf((ark.status & 1) > 0));
            }
            AppMethodBeat.o(129661);
        }
    }
}
