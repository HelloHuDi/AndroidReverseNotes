package com.tencent.p177mm.plugin.shake.p1296e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.e.c */
public final class C43525c {

    /* renamed from: com.tencent.mm.plugin.shake.e.c$a */
    public static class C29005a {
        public String field_id;
        public String field_playstatid;
        public String field_playurl;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public String field_topic;
        public String field_xml;
        public LinkedList<C21832a> qiL;
    }

    /* renamed from: WN */
    public static C29005a m77779WN(String str) {
        AppMethodBeat.m2504i(24953);
        if (str == null) {
            AppMethodBeat.m2505o(24953);
            return null;
        }
        String str2 = "";
        Map z = C5049br.m7595z(str, "tv");
        if (z == null) {
            AppMethodBeat.m2505o(24953);
            return null;
        }
        C29005a c29005a = new C29005a();
        c29005a.field_id = C5046bo.nullAsNil((String) z.get(str2 + ".tv.id"));
        c29005a.field_topic = C5046bo.nullAsNil((String) z.get(str2 + ".tv.topic"));
        c29005a.field_title = C5046bo.nullAsNil((String) z.get(str2 + ".tv.title"));
        c29005a.field_subtitle = C5046bo.nullAsNil((String) z.get(str2 + ".tv.subtitle"));
        c29005a.field_thumburl = C5046bo.nullAsNil((String) z.get(str2 + ".tv.thumburl"));
        c29005a.field_shareurl = C5046bo.nullAsNil((String) z.get(str2 + ".tv.shareurl"));
        c29005a.field_playurl = C5046bo.nullAsNil((String) z.get(str2 + ".tv.playurl"));
        c29005a.field_playstatid = C5046bo.nullAsNil((String) z.get(str2 + ".tv.playurl$statid"));
        c29005a.field_source = C5046bo.nullAsNil((String) z.get(str2 + ".tv.source"));
        c29005a.qiL = C21832a.m33381l(z, str2 + ".tv");
        c29005a.field_xml = str;
        AppMethodBeat.m2505o(24953);
        return c29005a;
    }

    /* renamed from: b */
    public static String m77781b(C29005a c29005a) {
        AppMethodBeat.m2504i(24954);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!C5046bo.isNullOrNil(c29005a.field_id)) {
            stringBuilder.append("<id>" + C5046bo.ani(c29005a.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + C5046bo.ani(c29005a.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + C5046bo.ani(c29005a.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + C5046bo.ani(c29005a.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + C5046bo.ani(c29005a.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + C5046bo.ani(c29005a.field_shareurl) + "</shareurl>");
        if (C5046bo.isNullOrNil(c29005a.field_playstatid)) {
            stringBuilder.append("<playurl>" + C5046bo.ani(c29005a.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + c29005a.field_playstatid + "\">" + C5046bo.ani(c29005a.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + C5046bo.ani(c29005a.field_source) + "</source>");
        stringBuilder.append("</tv>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(24954);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static String m77780a(Context context, C29005a c29005a) {
        AppMethodBeat.m2504i(24955);
        C8910b c8910b = new C8910b();
        c8910b.title = c29005a.field_title;
        if (C5046bo.isNullOrNil(c29005a.field_topic)) {
            c8910b.description = c29005a.field_subtitle;
        } else {
            c8910b.description = c29005a.field_topic;
        }
        c8910b.type = 20;
        c8910b.url = c29005a.field_shareurl;
        c8910b.action = "";
        if (C3826k.cjQ()) {
            c8910b.appName = context.getString(C25738R.string.dz2);
            c8910b.appId = "wxaf060266bfa9a35c";
        }
        c8910b.thumburl = c29005a.field_thumburl;
        c8910b.fgT = C43525c.m77781b(c29005a);
        String a = C8910b.m16061a(c8910b, null, null);
        AppMethodBeat.m2505o(24955);
        return a;
    }
}
