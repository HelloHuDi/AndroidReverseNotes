package com.tencent.p177mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.websearch.api.z */
public final class C29744z {
    private static final Map<String, Integer> tZW = new HashMap();

    static {
        AppMethodBeat.m2504i(124088);
        AppMethodBeat.m2505o(124088);
    }

    /* renamed from: a */
    public static void m47156a(int i, String str, String str2, String str3, int i2, boolean z, String str4, String str5, int i3) {
        AppMethodBeat.m2504i(124075);
        C29744z.m47157a(i, str, str2, str3, i2, z, str4, str5, i3, "");
        AppMethodBeat.m2505o(124075);
    }

    /* renamed from: a */
    public static void m47157a(int i, String str, String str2, String str3, int i2, boolean z, String str4, String str5, int i3, String str6) {
        AppMethodBeat.m2504i(124076);
        C29744z.m47154a(4, i, str, str2, str3, i2, z, str4, true, str5, str6, i3);
        AppMethodBeat.m2505o(124076);
    }

    /* renamed from: a */
    public static void m47158a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3) {
        AppMethodBeat.m2504i(124077);
        C29744z.m47159a(i, str, str2, str3, i2, z, str4, z2, str5, i3, "");
        AppMethodBeat.m2505o(124077);
    }

    /* renamed from: a */
    public static void m47159a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3, String str6) {
        AppMethodBeat.m2504i(124078);
        C29744z.m47154a(7, i, str, str2, str3, i2, z, str4, z2, str5, str6, i3);
        AppMethodBeat.m2505o(124078);
    }

    /* renamed from: a */
    public static void m47161a(int i, String str, String str2, boolean z, String str3, int i2, String str4, boolean z2) {
        AppMethodBeat.m2504i(124080);
        C29744z.m47155a(12, i, str, str2, "", 0, z, "", true, str3, str4, i2, z2);
        AppMethodBeat.m2505o(124080);
    }

    /* renamed from: a */
    public static void m47160a(int i, String str, String str2, boolean z, String str3, int i2) {
        AppMethodBeat.m2504i(124081);
        C29744z.m47154a(10, i, str, str2, "", 0, z, "", true, str3, "", i2);
        AppMethodBeat.m2505o(124081);
    }

    public static void cUX() {
    }

    /* renamed from: a */
    public static void m47163a(int i, String str, String str2, boolean z, String str3, int i2, boolean z2) {
        AppMethodBeat.m2504i(124082);
        C29744z.m47155a(14, i, str, str2, "", 0, z, "", true, str3, "", i2, z2);
        AppMethodBeat.m2505o(124082);
    }

    /* renamed from: a */
    private static void m47154a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4) {
        AppMethodBeat.m2504i(124083);
        C29744z.m47155a(i, i2, str, str2, str3, i3, z, str4, z2, str5, str6, i4, false);
        AppMethodBeat.m2505o(124083);
    }

    /* renamed from: a */
    private static void m47155a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4, boolean z3) {
        String str7;
        AppMethodBeat.m2504i(124084);
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
        objArr2[2] = C5046bo.m7532bc(str, "");
        objArr2[3] = C5046bo.m7532bc(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str7 = "";
        } else {
            str7 = str3;
        }
        objArr2[4] = str7;
        objArr2[5] = Integer.valueOf(i3);
        objArr2[6] = Integer.valueOf(z ? 1 : 0);
        objArr2[7] = C5046bo.m7532bc(str4, "");
        objArr2[8] = Long.valueOf(System.currentTimeMillis());
        objArr2[9] = C29744z.cUY();
        objArr2[10] = Integer.valueOf(i5);
        objArr2[11] = C5046bo.m7532bc(str5, "");
        objArr2[12] = TextUtils.isEmpty(str6) ? "" : str6;
        objArr2[13] = Integer.valueOf(i4);
        objArr2[14] = Integer.valueOf(C29744z.m47153HO(i2));
        objArr2[15] = Integer.valueOf(z3 ? 1 : 0);
        objArr[0] = C29744z.m47164s(objArr2);
        C4990ab.m7417i(str8, str9, objArr);
        C7053e c7053e = C7053e.pXa;
        objArr = new Object[16];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = C5046bo.m7532bc(str, "");
        objArr[3] = C5046bo.m7532bc(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = C5046bo.m7532bc(str4, "");
        objArr[8] = Long.valueOf(System.currentTimeMillis());
        objArr[9] = C29744z.cUY();
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = C5046bo.m7532bc(str5, "");
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        objArr[12] = str6;
        objArr[13] = Integer.valueOf(i4);
        objArr[14] = Integer.valueOf(C29744z.m47153HO(i2));
        objArr[15] = Integer.valueOf(z3 ? 1 : 0);
        c7053e.mo8381e(14904, objArr);
        AppMethodBeat.m2505o(124084);
    }

    /* renamed from: HO */
    private static int m47153HO(int i) {
        AppMethodBeat.m2504i(124085);
        int HV;
        switch (i) {
            case 21:
                HV = C46400aa.m87305HV(1);
                AppMethodBeat.m2505o(124085);
                return HV;
            case 201:
                HV = C46400aa.cVc();
                AppMethodBeat.m2505o(124085);
                return HV;
            default:
                HV = C46400aa.m87305HV(0);
                AppMethodBeat.m2505o(124085);
                return HV;
        }
    }

    private static String cUY() {
        AppMethodBeat.m2504i(124086);
        Context context = C4996ah.getContext();
        String str;
        if (C5023at.isConnected(context)) {
            C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = ".concat(String.valueOf(C5023at.getNetType(context))));
            if (C5023at.is2G(context)) {
                C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
                str = "2g";
                AppMethodBeat.m2505o(124086);
                return str;
            } else if (C5023at.is3G(context)) {
                C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
                str = "3g";
                AppMethodBeat.m2505o(124086);
                return str;
            } else if (C5023at.is4G(context)) {
                C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
                str = "4g";
                AppMethodBeat.m2505o(124086);
                return str;
            } else if (C5023at.isWifi(context)) {
                C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
                str = "wifi";
                AppMethodBeat.m2505o(124086);
                return str;
            } else {
                str = "fail";
                AppMethodBeat.m2505o(124086);
                return str;
            }
        }
        C4990ab.m7418v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
        str = "fail";
        AppMethodBeat.m2505o(124086);
        return str;
    }

    /* renamed from: s */
    private static String m47164s(Object... objArr) {
        AppMethodBeat.m2504i(124087);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append(String.valueOf(objArr[i]).replace(',', ' ')).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[15]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(124087);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static void m47162a(int i, String str, String str2, boolean z, String str3, int i2, String str4, boolean z2, String str5) {
        AppMethodBeat.m2504i(124079);
        C29744z.m47155a(1, i, str, str2, str5, 0, z, "", true, str3, str4, i2, z2);
        AppMethodBeat.m2505o(124079);
    }
}
