package com.tencent.mm.plugin.appbrand.appcache.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.f;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends com.tencent.mm.ai.a<iu> {
    private final b ehh;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a$2 */
    public static class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Boolean> {
        final /* synthetic */ Runnable gVL;

        public AnonymousClass2(Runnable runnable) {
            this.gVL = runnable;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(129442);
            this.gVL.run();
            f.dMj().cR(Boolean.TRUE);
            Void voidR = zXH;
            AppMethodBeat.o(129442);
            return voidR;
        }
    }

    /* synthetic */ a(List list, byte b) {
        this(list);
    }

    private a(List<cga> list) {
        AppMethodBeat.i(129443);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        it itVar = new it();
        itVar.vKs.addAll(list);
        aVar.fsJ = itVar;
        aVar.fsK = new iu();
        aVar.fsI = 2763;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.o(129443);
    }

    static List<cga> awt() {
        AppMethodBeat.i(129444);
        if ((!((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue() ? 1 : 0) != 0) {
            k kVar = (k) com.tencent.mm.plugin.appbrand.app.f.E(k.class);
            Cursor rawQuery = kVar.gTC.rawQuery("select distinct username,updateTime from AppBrandLocalUsageRecord where updateTime >= " + (bo.anT() - AppBrandGlobalSystemConfig.ayC().hge.hgz) + " order by updateTime desc limit " + AppBrandGlobalSystemConfig.ayC().hge.hgA + " offset 0 ", null);
            if (!(rawQuery == null || rawQuery.isClosed())) {
                if (rawQuery.moveToLast()) {
                    do {
                        kVar.x(rawQuery.getString(0), rawQuery.getLong(1));
                    } while (rawQuery.moveToPrevious());
                }
                rawQuery.close();
            }
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.TRUE);
        }
        com.tencent.mm.platformtools.t.a auK = com.tencent.mm.plugin.appbrand.app.f.auK();
        int i = AppBrandGlobalSystemConfig.ayC().hge.hgA;
        ab.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList with minUpdateTime( %s )", bo.mx(bo.anT() - AppBrandGlobalSystemConfig.ayC().hge.hgz));
        Cursor a = auK.a("select distinct WxaAttributesTable.username,WxaAttributesTable.appId,WxaAttributesTable.versionInfo from AppBrandAppLaunchUsernameDuplicateRecord left outer join WxaAttributesTable on AppBrandAppLaunchUsernameDuplicateRecord.username=WxaAttributesTable.username where AppBrandAppLaunchUsernameDuplicateRecord.updateTime >= " + r6 + " order by AppBrandAppLaunchUsernameDuplicateRecord.updateTime desc limit " + i + " offset 0", null, 2);
        if (a == null || a.isClosed()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(129444);
            return emptyList;
        }
        LinkedList linkedList = new LinkedList();
        if (a.moveToFirst()) {
            WxaAttributes wxaAttributes = new WxaAttributes();
            do {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    wxaAttributes.d(a);
                    cga cga = new cga();
                    cga.xfb = string;
                    if (wxaAttributes.ayL() != null) {
                        cga.xfc = wxaAttributes.ayL().axy;
                    }
                    if (!bo.isNullOrNil(wxaAttributes.field_appId)) {
                        WxaPkgWrappingInfo bm = h.bm(wxaAttributes.field_appId, 0);
                        cga.xfd = bm != null ? bm.gVu : 0;
                    }
                    linkedList.add(cga);
                }
            } while (a.moveToNext());
        }
        a.close();
        i = auK.delete("AppBrandAppLaunchUsernameDuplicateRecord", "updateTime < ?", new String[]{String.valueOf(r6)});
        ab.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList, delete records updateTime < %s, count %d", bo.mx(r6), Integer.valueOf(i));
        AppMethodBeat.o(129444);
        return linkedList;
    }
}
