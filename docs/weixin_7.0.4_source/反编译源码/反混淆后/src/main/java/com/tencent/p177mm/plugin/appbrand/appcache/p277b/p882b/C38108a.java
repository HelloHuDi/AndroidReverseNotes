package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7625d;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.a */
public abstract class C38108a<_Ret, _CmdStruct> implements C5681a<_Ret, C7625d<String, String, _CmdStruct>> {
    public abstract String awu();

    /* renamed from: b */
    public abstract _Ret mo21442b(String str, String str2, _CmdStruct _cmdstruct);

    /* renamed from: bm */
    public abstract cxp mo21443bm(_CmdStruct _cmdstruct);

    public final /* synthetic */ Object call(Object obj) {
        Object obj2;
        C7625d c7625d = (C7625d) obj;
        String str = (String) c7625d.get(1);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) invalid appId", awu());
            obj2 = null;
        } else {
            cxp bm = mo21443bm(c7625d.get(2));
            if (bm == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) null CmdBase", awu());
                obj2 = null;
            } else {
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) bm.xsX, (long) C19050a.gWm.get(getClass()));
                long j = ((long) bm.xsV) & 4294967295L;
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) DealEndTime %d , now %d", awu(), Long.valueOf(j), Long.valueOf(C5046bo.anT()));
                C19050a c19050a2;
                if (j < C5046bo.anT()) {
                    c19050a2 = C19050a.gWl;
                    C19050a.m29623z((long) bm.xsX, (long) C19050a.gWn.get(getClass()));
                    obj2 = null;
                } else {
                    long j2 = C5046bo.getLong(C42340f.m74880xH().get("PredownloadCmdSequence$" + awu() + '$' + str, AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
                    j = ((long) bm.xsW) & 4294967295L;
                    C4990ab.m7417i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s), lastSeq %d, cmdSeq %d", awu(), Long.valueOf(j2), Long.valueOf(j));
                    if (j2 > j) {
                        c19050a2 = C19050a.gWl;
                        C19050a.m29623z((long) bm.xsX, (long) C19050a.gWo.get(getClass()));
                        obj2 = null;
                    } else if (j2 == j) {
                        c19050a2 = C19050a.gWl;
                        C19050a.m29623z((long) bm.xsX, (long) C19050a.gWp.get(getClass()));
                        obj2 = null;
                    } else {
                        C42340f.m74880xH().mo53682bG("PredownloadCmdSequence$" + awu() + '$' + str, Long.toString(j));
                        obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            return mo21442b((String) c7625d.get(0), (String) c7625d.get(1), c7625d.get(2));
        }
        C5698f.dMj().mo11582cR(null);
        return null;
    }
}
