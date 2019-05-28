package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class j extends com.tencent.mm.ai.a<iy> {

    public enum a {
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
            AppMethodBeat.o(129849);
        }

        private a(int i) {
            this.intValue = i;
        }
    }

    j(List<String> list, a aVar) {
        AppMethodBeat.i(129850);
        ab.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.intValue));
        ix ixVar = new ix();
        ixVar.Scene = aVar.intValue;
        for (String str : list) {
            if (!bo.isNullOrNil(str)) {
                cwz cwz = new cwz();
                cwz.xfb = str;
                cwz.vMS = f.auO().zf(str);
                ixVar.vKs.add(cwz);
            }
        }
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = ixVar;
        aVar2.fsK = new iy();
        aVar2.fsI = 1192;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.ehh = aVar2.acD();
        AppMethodBeat.o(129850);
    }
}
