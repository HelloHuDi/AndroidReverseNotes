package com.tencent.p177mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.protocal.protobuf.arj;
import com.tencent.p177mm.protocal.protobuf.ark;
import com.tencent.p177mm.protocal.protobuf.cwq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.t */
public enum C26783t {
    ;
    
    private static Integer hai;
    private static final long haj = 0;

    static {
        hai = null;
        haj = TimeUnit.DAYS.toSeconds(1);
        AppMethodBeat.m2505o(129662);
    }

    public static boolean axG() {
        return true;
    }

    public static boolean axH() {
        return true;
    }

    /* renamed from: nC */
    public static void m42628nC(int i) {
        AppMethodBeat.m2504i(129659);
        hai = Integer.valueOf(i);
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        Cursor query = c26779s.hae.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", new Object[]{"orderSequence", Long.valueOf(Long.MAX_VALUE), Integer.valueOf(C26783t.axI())}));
        if (query == null) {
            AppMethodBeat.m2505o(129659);
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
        if (!C5046bo.m7548ek(linkedList)) {
            String[] strArr = new String[1];
            long iV = c26779s.hae.mo15639iV(Thread.currentThread().getId());
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                strArr[0] = (String) it.next();
                c26779s.hae.delete("AppBrandStarApp", "rowid=?", strArr);
            }
            c26779s.hae.mo15640mB(iV);
            c26779s.mo15641b("batch", 5, null);
        }
        AppMethodBeat.m2505o(129659);
    }

    public static int axI() {
        AppMethodBeat.m2504i(129660);
        int intValue;
        if (hai != null) {
            intValue = hai.intValue();
            AppMethodBeat.m2505o(129660);
            return intValue;
        }
        intValue = AppBrandGlobalSystemConfig.ayC().hfR;
        AppMethodBeat.m2505o(129660);
        return intValue;
    }

    /* renamed from: a */
    static void m42627a(int i, int i2, int i3, String str, C7472b c7472b, Long l) {
        AppMethodBeat.m2504i(129661);
        if (c7472b == null) {
            C4990ab.m7412e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
            AppMethodBeat.m2505o(129661);
        } else if ((((arj) c7472b.fsG.fsP).condition & 2) == 0) {
            AppMethodBeat.m2505o(129661);
        } else {
            ark ark = (ark) c7472b.fsH.fsP;
            C4990ab.m7417i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", Integer.valueOf(i2), Integer.valueOf(i3), str, l);
            if (i2 == 0 && i3 == 0 && ark != null) {
                if (C42340f.m74878E(C26779s.class) != null) {
                    ((C26779s) C42340f.m74878E(C26779s.class)).mo44550a(cwq.class, ark.wvv, l);
                    C26784u.m42629a(i, ark.wvv);
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.valueOf((ark.status & 1) > 0));
            }
            AppMethodBeat.m2505o(129661);
        }
    }
}
