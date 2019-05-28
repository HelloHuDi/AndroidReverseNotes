package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct> implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>> {
    public abstract String awu();

    public abstract _Ret b(String str, String str2, _CmdStruct _cmdstruct);

    public abstract cxp bm(_CmdStruct _cmdstruct);

    public final /* synthetic */ Object call(Object obj) {
        Object obj2;
        d dVar = (d) obj;
        String str = (String) dVar.get(1);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) invalid appId", awu());
            obj2 = null;
        } else {
            cxp bm = bm(dVar.get(2));
            if (bm == null) {
                ab.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) null CmdBase", awu());
                obj2 = null;
            } else {
                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) bm.xsX, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWm.get(getClass()));
                long j = ((long) bm.xsV) & 4294967295L;
                ab.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) DealEndTime %d , now %d", awu(), Long.valueOf(j), Long.valueOf(bo.anT()));
                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2;
                if (j < bo.anT()) {
                    aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) bm.xsX, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWn.get(getClass()));
                    obj2 = null;
                } else {
                    long j2 = bo.getLong(f.xH().get("PredownloadCmdSequence$" + awu() + '$' + str, AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
                    j = ((long) bm.xsW) & 4294967295L;
                    ab.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s), lastSeq %d, cmdSeq %d", awu(), Long.valueOf(j2), Long.valueOf(j));
                    if (j2 > j) {
                        aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) bm.xsX, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWo.get(getClass()));
                        obj2 = null;
                    } else if (j2 == j) {
                        aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) bm.xsX, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWp.get(getClass()));
                        obj2 = null;
                    } else {
                        f.xH().bG("PredownloadCmdSequence$" + awu() + '$' + str, Long.toString(j));
                        obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            return b((String) dVar.get(0), (String) dVar.get(1), dVar.get(2));
        }
        com.tencent.mm.vending.g.f.dMj().cR(null);
        return null;
    }
}
