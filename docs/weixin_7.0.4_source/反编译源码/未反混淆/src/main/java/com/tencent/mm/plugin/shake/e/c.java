package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

public final class c {

    public static class a {
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
        public LinkedList<a> qiL;
    }

    public static a WN(String str) {
        AppMethodBeat.i(24953);
        if (str == null) {
            AppMethodBeat.o(24953);
            return null;
        }
        String str2 = "";
        Map z = br.z(str, "tv");
        if (z == null) {
            AppMethodBeat.o(24953);
            return null;
        }
        a aVar = new a();
        aVar.field_id = bo.nullAsNil((String) z.get(str2 + ".tv.id"));
        aVar.field_topic = bo.nullAsNil((String) z.get(str2 + ".tv.topic"));
        aVar.field_title = bo.nullAsNil((String) z.get(str2 + ".tv.title"));
        aVar.field_subtitle = bo.nullAsNil((String) z.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = bo.nullAsNil((String) z.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = bo.nullAsNil((String) z.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = bo.nullAsNil((String) z.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = bo.nullAsNil((String) z.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = bo.nullAsNil((String) z.get(str2 + ".tv.source"));
        aVar.qiL = a.l(z, str2 + ".tv");
        aVar.field_xml = str;
        AppMethodBeat.o(24953);
        return aVar;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(24954);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!bo.isNullOrNil(aVar.field_id)) {
            stringBuilder.append("<id>" + bo.ani(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + bo.ani(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + bo.ani(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + bo.ani(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + bo.ani(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + bo.ani(aVar.field_shareurl) + "</shareurl>");
        if (bo.isNullOrNil(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + bo.ani(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + bo.ani(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + bo.ani(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(24954);
        return stringBuilder2;
    }

    public static String a(Context context, a aVar) {
        AppMethodBeat.i(24955);
        b bVar = new b();
        bVar.title = aVar.field_title;
        if (bo.isNullOrNil(aVar.field_topic)) {
            bVar.description = aVar.field_subtitle;
        } else {
            bVar.description = aVar.field_topic;
        }
        bVar.type = 20;
        bVar.url = aVar.field_shareurl;
        bVar.action = "";
        if (k.cjQ()) {
            bVar.appName = context.getString(R.string.dz2);
            bVar.appId = "wxaf060266bfa9a35c";
        }
        bVar.thumburl = aVar.field_thumburl;
        bVar.fgT = b(aVar);
        String a = b.a(bVar, null, null);
        AppMethodBeat.o(24955);
        return a;
    }
}
