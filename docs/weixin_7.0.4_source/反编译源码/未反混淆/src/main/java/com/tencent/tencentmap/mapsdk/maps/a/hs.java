package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.tencentmap.mapsdk.a.aj;

public class hs {
    public static String a() {
        AppMethodBeat.i(99572);
        String e = e();
        if (e.equals("didi")) {
            if (aj.a() == 1) {
                e = "https://ddsdk.vectors.map.qq.com";
                AppMethodBeat.o(99572);
                return e;
            }
            e = "https://ddsdk.vectors2.map.qq.com";
            AppMethodBeat.o(99572);
            return e;
        } else if (e.equals("tencentmap")) {
            e = "https://mapvectors.map.qq.com";
            AppMethodBeat.o(99572);
            return e;
        } else {
            e = "https://vectorsdk.map.qq.com";
            AppMethodBeat.o(99572);
            return e;
        }
    }

    public static String b() {
        AppMethodBeat.i(99573);
        String str;
        if (e().equals("didi")) {
            str = "/mobile_newmap";
            AppMethodBeat.o(99573);
            return str;
        }
        str = "/mvd_map";
        AppMethodBeat.o(99573);
        return str;
    }

    public static String a(String str) {
        AppMethodBeat.i(99574);
        String e = e();
        if (e.equals("didi") || e.equals("tencentmap") || !str.contains("indoor_map")) {
            AppMethodBeat.o(99574);
            return str;
        }
        str = str.replace("https://vectorsdk.map.qq.com/indoor_map?", "https://mapvectors.map.qq.com/indoormap2?") + "&apiKey=" + ic.a;
        AppMethodBeat.o(99574);
        return str;
    }

    public static String c() {
        AppMethodBeat.i(99575);
        String str;
        if (e().equals("didi")) {
            str = "1HV13IK65T1XH392";
            AppMethodBeat.o(99575);
            return str;
        }
        str = "0M3009PNO62FLOQC";
        AppMethodBeat.o(99575);
        return str;
    }

    private static String e() {
        return Token.WX_TOKEN_PLATFORMID_VALUE;
    }

    public static String d() {
        AppMethodBeat.i(99576);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://closedroadvector.map.qq.com/closed_road_v2?");
        stringBuilder.append("iszip=true");
        stringBuilder.append("&imei=" + ic.a());
        stringBuilder.append("&pf=android");
        stringBuilder.append("&sdkversion=4.2.2");
        stringBuilder.append("&p=sdk");
        stringBuilder.append("&nettype=" + ic.b());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(99576);
        return stringBuilder2;
    }
}
