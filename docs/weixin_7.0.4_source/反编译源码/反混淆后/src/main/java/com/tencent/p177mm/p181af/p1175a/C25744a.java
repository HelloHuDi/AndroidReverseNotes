package com.tencent.p177mm.p181af.p1175a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.af.a.a */
public final class C25744a {
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

    /* renamed from: mk */
    public static C25744a m40872mk(String str) {
        AppMethodBeat.m2504i(51122);
        Map z = C5049br.m7595z(str, "sysmsg");
        C25744a c25744a = new C25744a();
        if (z == null) {
            AppMethodBeat.m2505o(51122);
            return c25744a;
        }
        c25744a.fjU = (String) z.get(".sysmsg.subscribesysmsg.content_template.template");
        c25744a.title = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title");
        c25744a.content = c25744a.fjU.replace("$wxaapp_view$", c25744a.title);
        c25744a.appId = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid");
        c25744a.username = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username");
        c25744a.path = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path");
        c25744a.type = C5046bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
        c25744a.bQi = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        c25744a.fjV = C5046bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
        c25744a.fjW = C5046bo.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
        AppMethodBeat.m2505o(51122);
        return c25744a;
    }
}
