package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dg */
public final class C24363dg extends C36492cx {
    /* renamed from: b */
    private static C24363dg f4658b = new C24363dg();

    static {
        AppMethodBeat.m2504i(98705);
        AppMethodBeat.m2505o(98705);
    }

    private C24363dg() {
    }

    /* renamed from: a */
    private static String m37676a(String str, boolean z, Map<String, String> map) {
        AppMethodBeat.m2504i(98703);
        String d = C31029ce.m49849d();
        map.put("A23", C46772bt.f18095d);
        C24364di c24364di = new C24364di();
        c24364di.mo40560c(String.valueOf(str));
        c24364di.mo40554a(System.currentTimeMillis());
        c24364di.mo40558b(C31034df.f14098a);
        c24364di.mo40555a(d);
        map.put("A1", C46772bt.f18094c);
        map.put("A2", C24373eu.m37732a());
        map.put("A4", C24373eu.m37740b());
        map.put("A6", C24373eu.m37743c());
        map.put("A7", C24373eu.m37747e());
        map.put("A23", C46772bt.f18095d);
        map.put("A33", C31029ce.m49851f());
        map.put("A10", C31034df.f14101d);
        map.put("A9", C31034df.f14100c);
        map.put("A19", d);
        c24364di.mo40556a((Map) map);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C24373eu.m37734a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        stringBuilder.append("INFO|");
        stringBuilder.append(C24362a.m37668a() + "|");
        stringBuilder.append(C31034df.f14099b + "|");
        stringBuilder.append("beacon|");
        stringBuilder.append("1.8.1|");
        d = c24364di.mo40557b();
        try {
            d = URLEncoder.encode(c24364di.mo40557b(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
        stringBuilder.append(d + "|");
        stringBuilder.append("|");
        stringBuilder.append("upload_ip|");
        stringBuilder.append("|");
        stringBuilder.append(c24364di.mo40553a() + "|");
        stringBuilder.append(c24364di.mo40561d() + "|");
        stringBuilder.append(z + "|");
        stringBuilder.append("0|");
        stringBuilder.append("0|");
        stringBuilder.append(C24363dg.m37677a(c24364di.mo40562e()) + "|");
        stringBuilder.append(C24373eu.m37734a(c24364di.mo40559c(), "yyyy-MM-dd HH:mm:ss") + "|");
        stringBuilder.append("upload_time");
        d = stringBuilder.toString();
        AppMethodBeat.m2505o(98703);
        return d;
    }

    /* renamed from: a */
    private static String m37677a(Map<String, String> map) {
        AppMethodBeat.m2504i(98704);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.m2505o(98704);
            return str;
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            str = "";
            AppMethodBeat.m2505o(98704);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : keySet) {
            stringBuilder.append("&");
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append((String) map.get(str2));
        }
        str2 = stringBuilder.substring(1);
        stringBuilder.setLength(0);
        AppMethodBeat.m2505o(98704);
        return str2;
    }

    /* renamed from: d */
    public static C24363dg m37678d() {
        return f4658b;
    }

    /* renamed from: a */
    public final int mo40550a() {
        AppMethodBeat.m2504i(98701);
        int a = C24362a.m37665a("report_insert_new_record_num_limit", 5, 100, 100);
        AppMethodBeat.m2505o(98701);
        return a;
    }

    /* renamed from: a */
    public final void mo40551a(String str, boolean z, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(98702);
        super.mo57714a(C24363dg.m37676a(str, z, map), z2, z3);
        AppMethodBeat.m2505o(98702);
    }

    /* renamed from: b */
    public final String mo40552b() {
        return "beacon";
    }
}
