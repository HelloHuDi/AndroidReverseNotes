package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.protocal.protobuf.C23401ix;
import com.tencent.p177mm.protocal.protobuf.C30192iy;
import com.tencent.p177mm.protocal.protobuf.cwz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.config.j */
public final class C33138j extends C37440a<C30192iy> {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.j$a */
    public enum C33137a {
        DEFAULT(100),
        RECENTS_LIST(101),
        TASK_BAR(102),
        STAR_LIST(103),
        MP_PRELOAD(104),
        BIZ_BIND_WXA(105),
        WXA_CUSTOMER_SERVICE(106),
        WXA_PLUGIN_JSAPI(107),
        WXA_RECOMMEND_LIST(108),
        WXA_RECOMMEND_CARD_LIST(109);
        
        final int intValue;

        static {
            AppMethodBeat.m2505o(129849);
        }

        private C33137a(int i) {
            this.intValue = i;
        }
    }

    C33138j(List<String> list, C33137a c33137a) {
        AppMethodBeat.m2504i(129850);
        C4990ab.m7417i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), c33137a.name(), Integer.valueOf(c33137a.intValue));
        C23401ix c23401ix = new C23401ix();
        c23401ix.Scene = c33137a.intValue;
        for (String str : list) {
            if (!C5046bo.isNullOrNil(str)) {
                cwz cwz = new cwz();
                cwz.xfb = str;
                cwz.vMS = C42340f.auO().mo21576zf(str);
                c23401ix.vKs.add(cwz);
            }
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c23401ix;
        c1196a.fsK = new C30192iy();
        c1196a.fsI = 1192;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(129850);
    }
}
