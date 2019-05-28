package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public final class dg extends cx {
    private static dg b = new dg();

    static {
        AppMethodBeat.i(98705);
        AppMethodBeat.o(98705);
    }

    private dg() {
    }

    private static String a(String str, boolean z, Map<String, String> map) {
        AppMethodBeat.i(98703);
        String d = ce.d();
        map.put("A23", bt.d);
        di diVar = new di();
        diVar.c(String.valueOf(str));
        diVar.a(System.currentTimeMillis());
        diVar.b(df.a);
        diVar.a(d);
        map.put("A1", bt.c);
        map.put("A2", eu.a());
        map.put("A4", eu.b());
        map.put("A6", eu.c());
        map.put("A7", eu.e());
        map.put("A23", bt.d);
        map.put("A33", ce.f());
        map.put("A10", df.d);
        map.put("A9", df.c);
        map.put("A19", d);
        diVar.a((Map) map);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(eu.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        stringBuilder.append("INFO|");
        stringBuilder.append(a.a() + "|");
        stringBuilder.append(df.b + "|");
        stringBuilder.append("beacon|");
        stringBuilder.append("1.8.1|");
        d = diVar.b();
        try {
            d = URLEncoder.encode(diVar.b(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
        stringBuilder.append(d + "|");
        stringBuilder.append("|");
        stringBuilder.append("upload_ip|");
        stringBuilder.append("|");
        stringBuilder.append(diVar.a() + "|");
        stringBuilder.append(diVar.d() + "|");
        stringBuilder.append(z + "|");
        stringBuilder.append("0|");
        stringBuilder.append("0|");
        stringBuilder.append(a(diVar.e()) + "|");
        stringBuilder.append(eu.a(diVar.c(), "yyyy-MM-dd HH:mm:ss") + "|");
        stringBuilder.append("upload_time");
        d = stringBuilder.toString();
        AppMethodBeat.o(98703);
        return d;
    }

    private static String a(Map<String, String> map) {
        AppMethodBeat.i(98704);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.o(98704);
            return str;
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            str = "";
            AppMethodBeat.o(98704);
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
        AppMethodBeat.o(98704);
        return str2;
    }

    public static dg d() {
        return b;
    }

    public final int a() {
        AppMethodBeat.i(98701);
        int a = a.a("report_insert_new_record_num_limit", 5, 100, 100);
        AppMethodBeat.o(98701);
        return a;
    }

    public final void a(String str, boolean z, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.i(98702);
        super.a(a(str, z, map), z2, z3);
        AppMethodBeat.o(98702);
    }

    public final String b() {
        return "beacon";
    }
}
