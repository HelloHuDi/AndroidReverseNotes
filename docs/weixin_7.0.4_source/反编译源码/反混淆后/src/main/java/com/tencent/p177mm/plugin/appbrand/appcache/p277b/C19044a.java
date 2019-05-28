package com.tencent.p177mm.plugin.appbrand.appcache.p277b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26772k;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C19573h;
import com.tencent.p177mm.protocal.protobuf.C40530iu;
import com.tencent.p177mm.protocal.protobuf.C46553it;
import com.tencent.p177mm.protocal.protobuf.cga;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a */
public final class C19044a extends C37440a<C40530iu> {
    private final C7472b ehh;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a$2 */
    public static class C190452 implements C5681a<Void, Boolean> {
        final /* synthetic */ Runnable gVL;

        public C190452(Runnable runnable) {
            this.gVL = runnable;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129442);
            this.gVL.run();
            C5698f.dMj().mo11582cR(Boolean.TRUE);
            Void voidR = zXH;
            AppMethodBeat.m2505o(129442);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a$1 */
    public static class C190461 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a$1$1 */
        class C190431 implements C5681a<Void, C37441a<C40530iu>> {
            C190431() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129439);
                C37441a c37441a = (C37441a) obj;
                int i = c37441a.errType;
                int i2 = c37441a.errCode;
                String str = c37441a.aIm;
                C40530iu c40530iu = (C40530iu) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "onCgiBack, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C19050a c19050a;
                if (i != 0 || i2 != 0 || c40530iu == null || c40530iu.vKQ == null) {
                    c19050a = C19050a.gWl;
                    C19050a.m29623z(0, 2);
                } else {
                    C42354d.m74909aB(c40530iu.vKQ);
                    c19050a = C19050a.gWl;
                    C19050a.m29623z(0, 1);
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(129439);
                return voidR;
            }
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(129440);
            if (!C1720g.m3534RN().eJb || C42340f.auK() == null || C42340f.auV() == null) {
                AppMethodBeat.m2505o(129440);
                return;
            }
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(0))).longValue();
            long j = AppBrandGlobalSystemConfig.ayC().hge.hgy;
            long anT = C5046bo.anT();
            if ((anT >= longValue + j ? 1 : 0) != 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(anT));
                List awt = C19044a.awt();
                if (C5046bo.m7548ek(awt)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
                    AppMethodBeat.m2505o(129440);
                    return;
                }
                int i2;
                int i3 = AppBrandGlobalSystemConfig.ayC().hge.hgB;
                int i4 = 0;
                while (true) {
                    i2 = i;
                    if (i4 >= awt.size() / i3) {
                        break;
                    }
                    i2 = i4 * i3;
                    i = i2 + i3;
                    m29618aA(awt.subList(i2, i));
                    i4++;
                }
                if (i2 < awt.size()) {
                    m29618aA(awt.subList(i2, awt.size()));
                }
                AppMethodBeat.m2505o(129440);
                return;
            }
            AppMethodBeat.m2505o(129440);
        }

        /* renamed from: aA */
        private void m29618aA(List<cga> list) {
            AppMethodBeat.m2504i(129441);
            C19050a c19050a = C19050a.gWl;
            C19050a.m29623z(0, 0);
            new C19044a(list, (byte) 0).acy().mo60492h(new C190431());
            AppMethodBeat.m2505o(129441);
        }
    }

    /* synthetic */ C19044a(List list, byte b) {
        this(list);
    }

    private C19044a(List<cga> list) {
        AppMethodBeat.m2504i(129443);
        C1196a c1196a = new C1196a();
        C46553it c46553it = new C46553it();
        c46553it.vKs.addAll(list);
        c1196a.fsJ = c46553it;
        c1196a.fsK = new C40530iu();
        c1196a.fsI = 2763;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.m2505o(129443);
    }

    static List<cga> awt() {
        AppMethodBeat.m2504i(129444);
        if ((!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue() ? 1 : 0) != 0) {
            C26772k c26772k = (C26772k) C42340f.m74878E(C26772k.class);
            Cursor rawQuery = c26772k.gTC.rawQuery("select distinct username,updateTime from AppBrandLocalUsageRecord where updateTime >= " + (C5046bo.anT() - AppBrandGlobalSystemConfig.ayC().hge.hgz) + " order by updateTime desc limit " + AppBrandGlobalSystemConfig.ayC().hge.hgA + " offset 0 ", null);
            if (!(rawQuery == null || rawQuery.isClosed())) {
                if (rawQuery.moveToLast()) {
                    do {
                        c26772k.mo44544x(rawQuery.getString(0), rawQuery.getLong(1));
                    } while (rawQuery.moveToPrevious());
                }
                rawQuery.close();
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.TRUE);
        }
        C1953a auK = C42340f.auK();
        int i = AppBrandGlobalSystemConfig.ayC().hge.hgA;
        C4990ab.m7417i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList with minUpdateTime( %s )", C5046bo.m7579mx(C5046bo.anT() - AppBrandGlobalSystemConfig.ayC().hge.hgz));
        Cursor a = auK.mo10104a("select distinct WxaAttributesTable.username,WxaAttributesTable.appId,WxaAttributesTable.versionInfo from AppBrandAppLaunchUsernameDuplicateRecord left outer join WxaAttributesTable on AppBrandAppLaunchUsernameDuplicateRecord.username=WxaAttributesTable.username where AppBrandAppLaunchUsernameDuplicateRecord.updateTime >= " + r6 + " order by AppBrandAppLaunchUsernameDuplicateRecord.updateTime desc limit " + i + " offset 0", null, 2);
        if (a == null || a.isClosed()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(129444);
            return emptyList;
        }
        LinkedList linkedList = new LinkedList();
        if (a.moveToFirst()) {
            WxaAttributes wxaAttributes = new WxaAttributes();
            do {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    wxaAttributes.mo8995d(a);
                    cga cga = new cga();
                    cga.xfb = string;
                    if (wxaAttributes.ayL() != null) {
                        cga.xfc = wxaAttributes.ayL().axy;
                    }
                    if (!C5046bo.isNullOrNil(wxaAttributes.field_appId)) {
                        WxaPkgWrappingInfo bm = C19573h.m30345bm(wxaAttributes.field_appId, 0);
                        cga.xfd = bm != null ? bm.gVu : 0;
                    }
                    linkedList.add(cga);
                }
            } while (a.moveToNext());
        }
        a.close();
        i = auK.delete("AppBrandAppLaunchUsernameDuplicateRecord", "updateTime < ?", new String[]{String.valueOf(r6)});
        C4990ab.m7417i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList, delete records updateTime < %s, count %d", C5046bo.m7579mx(r6), Integer.valueOf(i));
        AppMethodBeat.m2505o(129444);
        return linkedList;
    }
}
