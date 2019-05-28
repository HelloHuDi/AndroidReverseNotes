package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class z {
    private static final Map<String, Integer> tZW = new HashMap();

    static {
        AppMethodBeat.i(124088);
        AppMethodBeat.o(124088);
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, String str5, int i3) {
        AppMethodBeat.i(124075);
        a(i, str, str2, str3, i2, z, str4, str5, i3, "");
        AppMethodBeat.o(124075);
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, String str5, int i3, String str6) {
        AppMethodBeat.i(124076);
        a(4, i, str, str2, str3, i2, z, str4, true, str5, str6, i3);
        AppMethodBeat.o(124076);
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3) {
        AppMethodBeat.i(124077);
        a(i, str, str2, str3, i2, z, str4, z2, str5, i3, "");
        AppMethodBeat.o(124077);
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3, String str6) {
        AppMethodBeat.i(124078);
        a(7, i, str, str2, str3, i2, z, str4, z2, str5, str6, i3);
        AppMethodBeat.o(124078);
    }

    public static void a(int i, String str, String str2, boolean z, String str3, int i2, String str4, boolean z2) {
        AppMethodBeat.i(124080);
        a(12, i, str, str2, "", 0, z, "", true, str3, str4, i2, z2);
        AppMethodBeat.o(124080);
    }

    public static void a(int i, String str, String str2, boolean z, String str3, int i2) {
        AppMethodBeat.i(124081);
        a(10, i, str, str2, "", 0, z, "", true, str3, "", i2);
        AppMethodBeat.o(124081);
    }

    public static void cUX() {
    }

    public static void a(int i, String str, String str2, boolean z, String str3, int i2, boolean z2) {
        AppMethodBeat.i(124082);
        a(14, i, str, str2, "", 0, z, "", true, str3, "", i2, z2);
        AppMethodBeat.o(124082);
    }

    private static void a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4) {
        AppMethodBeat.i(124083);
        a(i, i2, str, str2, str3, i3, z, str4, z2, str5, str6, i4, false);
        AppMethodBeat.o(124083);
    }

    private static void a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4, boolean z3) {
        String str7;
        AppMethodBeat.i(124084);
        int i5 = z2 ? 1 : 2;
        if (i == 1 || i == 10 || i == 12) {
            i5 = 0;
        }
        String str8 = "MicroMsg.WebSearch.WebSearchActionTracer";
        String str9 = "reporting 14904 %s ";
        Object[] objArr = new Object[1];
        Object[] objArr2 = new Object[16];
        objArr2[0] = Integer.valueOf(i);
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = bo.bc(str, "");
        objArr2[3] = bo.bc(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str7 = "";
        } else {
            str7 = str3;
        }
        objArr2[4] = str7;
        objArr2[5] = Integer.valueOf(i3);
        objArr2[6] = Integer.valueOf(z ? 1 : 0);
        objArr2[7] = bo.bc(str4, "");
        objArr2[8] = Long.valueOf(System.currentTimeMillis());
        objArr2[9] = cUY();
        objArr2[10] = Integer.valueOf(i5);
        objArr2[11] = bo.bc(str5, "");
        objArr2[12] = TextUtils.isEmpty(str6) ? "" : str6;
        objArr2[13] = Integer.valueOf(i4);
        objArr2[14] = Integer.valueOf(HO(i2));
        objArr2[15] = Integer.valueOf(z3 ? 1 : 0);
        objArr[0] = s(objArr2);
        ab.i(str8, str9, objArr);
        e eVar = e.pXa;
        objArr = new Object[16];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = bo.bc(str, "");
        objArr[3] = bo.bc(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = bo.bc(str4, "");
        objArr[8] = Long.valueOf(System.currentTimeMillis());
        objArr[9] = cUY();
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = bo.bc(str5, "");
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        objArr[12] = str6;
        objArr[13] = Integer.valueOf(i4);
        objArr[14] = Integer.valueOf(HO(i2));
        objArr[15] = Integer.valueOf(z3 ? 1 : 0);
        eVar.e(14904, objArr);
        AppMethodBeat.o(124084);
    }

    private static int HO(int i) {
        AppMethodBeat.i(124085);
        int HV;
        switch (i) {
            case 21:
                HV = aa.HV(1);
                AppMethodBeat.o(124085);
                return HV;
            case 201:
                HV = aa.cVc();
                AppMethodBeat.o(124085);
                return HV;
            default:
                HV = aa.HV(0);
                AppMethodBeat.o(124085);
                return HV;
        }
    }

    private static String cUY() {
        AppMethodBeat.i(124086);
        Context context = ah.getContext();
        String str;
        if (at.isConnected(context)) {
            ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = ".concat(String.valueOf(at.getNetType(context))));
            if (at.is2G(context)) {
                ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
                str = "2g";
                AppMethodBeat.o(124086);
                return str;
            } else if (at.is3G(context)) {
                ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
                str = "3g";
                AppMethodBeat.o(124086);
                return str;
            } else if (at.is4G(context)) {
                ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
                str = "4g";
                AppMethodBeat.o(124086);
                return str;
            } else if (at.isWifi(context)) {
                ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
                str = "wifi";
                AppMethodBeat.o(124086);
                return str;
            } else {
                str = "fail";
                AppMethodBeat.o(124086);
                return str;
            }
        }
        ab.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
        str = "fail";
        AppMethodBeat.o(124086);
        return str;
    }

    private static String s(Object... objArr) {
        AppMethodBeat.i(124087);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append(String.valueOf(objArr[i]).replace(',', ' ')).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[15]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(124087);
        return stringBuilder2;
    }

    public static void a(int i, String str, String str2, boolean z, String str3, int i2, String str4, boolean z2, String str5) {
        AppMethodBeat.i(124079);
        a(1, i, str, str2, str5, 0, z, "", true, str3, str4, i2, z2);
        AppMethodBeat.o(124079);
    }
}
