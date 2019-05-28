package com.tencent.mm.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a {
    public String appId;
    public String bQi;
    public String content;
    private String fjU;
    public int fjV;
    public int fjW;
    public String path;
    public String title;
    public int type;
    public String username;

    public static a mk(String str) {
        AppMethodBeat.i(51122);
        Map z = br.z(str, "sysmsg");
        a aVar = new a();
        if (z == null) {
            AppMethodBeat.o(51122);
            return aVar;
        }
        aVar.fjU = (String) z.get(".sysmsg.subscribesysmsg.content_template.template");
        aVar.title = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title");
        aVar.content = aVar.fjU.replace("$wxaapp_view$", aVar.title);
        aVar.appId = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid");
        aVar.username = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username");
        aVar.path = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path");
        aVar.type = bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
        aVar.bQi = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        aVar.fjV = bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
        aVar.fjW = bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
        AppMethodBeat.o(51122);
        return aVar;
    }
}
