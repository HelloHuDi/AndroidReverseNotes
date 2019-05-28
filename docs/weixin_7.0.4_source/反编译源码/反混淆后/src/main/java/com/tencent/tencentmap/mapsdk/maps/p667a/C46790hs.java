package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hs */
public class C46790hs {
    /* renamed from: a */
    public static String m88918a() {
        AppMethodBeat.m2504i(99572);
        String e = C46790hs.m88923e();
        if (e.equals("didi")) {
            if (C30982aj.m49609a() == 1) {
                e = "https://ddsdk.vectors.map.qq.com";
                AppMethodBeat.m2505o(99572);
                return e;
            }
            e = "https://ddsdk.vectors2.map.qq.com";
            AppMethodBeat.m2505o(99572);
            return e;
        } else if (e.equals("tencentmap")) {
            e = "https://mapvectors.map.qq.com";
            AppMethodBeat.m2505o(99572);
            return e;
        } else {
            e = "https://vectorsdk.map.qq.com";
            AppMethodBeat.m2505o(99572);
            return e;
        }
    }

    /* renamed from: b */
    public static String m88920b() {
        AppMethodBeat.m2504i(99573);
        String str;
        if (C46790hs.m88923e().equals("didi")) {
            str = "/mobile_newmap";
            AppMethodBeat.m2505o(99573);
            return str;
        }
        str = "/mvd_map";
        AppMethodBeat.m2505o(99573);
        return str;
    }

    /* renamed from: a */
    public static String m88919a(String str) {
        AppMethodBeat.m2504i(99574);
        String e = C46790hs.m88923e();
        if (e.equals("didi") || e.equals("tencentmap") || !str.contains("indoor_map")) {
            AppMethodBeat.m2505o(99574);
            return str;
        }
        str = str.replace("https://vectorsdk.map.qq.com/indoor_map?", "https://mapvectors.map.qq.com/indoormap2?") + "&apiKey=" + C36520ic.f15396a;
        AppMethodBeat.m2505o(99574);
        return str;
    }

    /* renamed from: c */
    public static String m88921c() {
        AppMethodBeat.m2504i(99575);
        String str;
        if (C46790hs.m88923e().equals("didi")) {
            str = "1HV13IK65T1XH392";
            AppMethodBeat.m2505o(99575);
            return str;
        }
        str = "0M3009PNO62FLOQC";
        AppMethodBeat.m2505o(99575);
        return str;
    }

    /* renamed from: e */
    private static String m88923e() {
        return Token.WX_TOKEN_PLATFORMID_VALUE;
    }

    /* renamed from: d */
    public static String m88922d() {
        AppMethodBeat.m2504i(99576);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://closedroadvector.map.qq.com/closed_road_v2?");
        stringBuilder.append("iszip=true");
        stringBuilder.append("&imei=" + C36520ic.m60473a());
        stringBuilder.append("&pf=android");
        stringBuilder.append("&sdkversion=4.2.2");
        stringBuilder.append("&p=sdk");
        stringBuilder.append("&nettype=" + C36520ic.m60485b());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(99576);
        return stringBuilder2;
    }
}
