package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16208bg;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16209bh;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36485bk;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36486bl;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36487bm;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36533lu;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46790hs;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dv */
public class C41021dv implements C24348dr {
    /* renamed from: a */
    private static final String[] f16411a = new String[]{C46790hs.m88918a(), "https://vectorsdk.map.qq.com", "https://tafrtt.map.qq.com/rttserverex/", "diditaf.map.qq.com"};
    /* renamed from: b */
    private static C16209bh f16412b;
    /* renamed from: c */
    private static C36485bk f16413c;

    static {
        AppMethodBeat.m2504i(101127);
        AppMethodBeat.m2505o(101127);
    }

    /* renamed from: a */
    public void mo40490a(Context context) {
        AppMethodBeat.m2504i(101115);
        try {
            C16209bh c16209bh = new C16209bh(context, 3203, C36520ic.f15396a, "android_vector_sdk_4.2.2.1");
            f16412b = c16209bh;
            f16413c = C16208bg.m24695b(c16209bh);
            AppMethodBeat.m2505o(101115);
        } catch (Exception e) {
            new StringBuilder("initNet error:").append(e.toString());
            AppMethodBeat.m2505o(101115);
        }
    }

    /* renamed from: a */
    public C16193dt mo40487a(String str) {
        AppMethodBeat.m2504i(101116);
        C16193dt a = mo40488a(str, "QQ Map Mobile");
        AppMethodBeat.m2505o(101116);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo40488a(String str, String str2) {
        AppMethodBeat.m2504i(101117);
        C16193dt a = mo65071a(str, str2, 1);
        AppMethodBeat.m2505o(101117);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65071a(String str, String str2, int i) {
        AppMethodBeat.m2504i(101118);
        C16193dt a = mo65072a(str, str2, i, null);
        AppMethodBeat.m2505o(101118);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65072a(String str, String str2, int i, C36533lu c36533lu) {
        AppMethodBeat.m2504i(101119);
        C16193dt a = mo65073a(str, str2, i, null, c36533lu);
        AppMethodBeat.m2505o(101119);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65073a(String str, String str2, int i, HashMap<String, String> hashMap, C36533lu c36533lu) {
        AppMethodBeat.m2504i(101120);
        IOException iOException;
        if (f16413c == null) {
            iOException = new IOException("HttpClient Init Failed and is Null");
            AppMethodBeat.m2505o(101120);
            throw iOException;
        }
        C36486bl a = f16413c.mo57707a(str, null);
        a.mo29259b(i > 0);
        a.mo29252a((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        a.mo29258b((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        a.mo29255a(true);
        if (!StringUtil.isEmpty(str2)) {
            a.mo29254a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Entry entry : hashMap.entrySet()) {
                if (entry != null) {
                    a.mo29254a((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (c36533lu != null) {
            c36533lu.mo57771a(a);
        }
        C36487bm a2 = f16413c.mo57708a(a);
        if (a2 != null) {
            int c = a2.mo12393c();
            int a3 = a2.mo12390a();
            if (a3 == 0 && c == 200) {
                C16193dt c16193dt = new C16193dt();
                c16193dt.f3096a = a2.mo12394d();
                c16193dt.f3097b = C41021dv.m71264b(a2.mo12391a("Content-Type"));
                AppMethodBeat.m2505o(101120);
                return c16193dt;
            }
            String stringBuilder = new StringBuilder(OpenSDKTool4Assistant.EXTRA_ERROR_CODE).append(a3).append(", statusCode:").append(c).append(", detailErrorInfo:").append(a2.mo12392b()).toString();
            if (a3 == -4) {
                C36474dw c36474dw = new C36474dw(stringBuilder);
                AppMethodBeat.m2505o(101120);
                throw c36474dw;
            }
            IOException iOException2 = new IOException(stringBuilder);
            AppMethodBeat.m2505o(101120);
            throw iOException2;
        }
        iOException = new IOException("response is null");
        AppMethodBeat.m2505o(101120);
        throw iOException;
    }

    /* renamed from: a */
    public C16193dt mo40489a(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(101121);
        C16193dt a = mo65074a(str, str2, bArr, 1);
        AppMethodBeat.m2505o(101121);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65074a(String str, String str2, byte[] bArr, int i) {
        AppMethodBeat.m2504i(101122);
        C16193dt a = mo65075a(str, str2, bArr, i, null);
        AppMethodBeat.m2505o(101122);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65075a(String str, String str2, byte[] bArr, int i, C36533lu c36533lu) {
        AppMethodBeat.m2504i(101123);
        C16193dt a = mo65076a(str, str2, bArr, i, null, c36533lu);
        AppMethodBeat.m2505o(101123);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65076a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, C36533lu c36533lu) {
        AppMethodBeat.m2504i(101124);
        C16193dt a = mo65077a(str, str2, bArr, i, hashMap, c36533lu, 0);
        AppMethodBeat.m2505o(101124);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo65077a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, C36533lu c36533lu, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(101125);
        IOException iOException;
        if (f16413c == null) {
            iOException = new IOException("HttpClient Init Failed and is Null");
            AppMethodBeat.m2505o(101125);
            throw iOException;
        }
        C36486bl a = f16413c.mo57707a(str, bArr);
        a.mo29255a(false);
        if (i > 0) {
            z = true;
        }
        a.mo29259b(z);
        if (!StringUtil.isEmpty(str2)) {
            a.mo29254a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Entry entry : hashMap.entrySet()) {
                if (entry != null) {
                    a.mo29254a((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (c36533lu != null) {
            c36533lu.mo57771a(a);
        }
        if (i2 > 0) {
            a.mo29252a(i2);
            a.mo29258b(i2);
        } else {
            a.mo29252a((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            a.mo29258b((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        C36487bm a2 = f16413c.mo57708a(a);
        if (a2 != null) {
            int c = a2.mo12393c();
            int a3 = a2.mo12390a();
            if (a3 == 0 && c == 200) {
                C16193dt c16193dt = new C16193dt();
                c16193dt.f3096a = a2.mo12394d();
                c16193dt.f3097b = C41021dv.m71264b(a2.mo12391a("Content-Type"));
                AppMethodBeat.m2505o(101125);
                return c16193dt;
            }
            String stringBuilder = new StringBuilder(OpenSDKTool4Assistant.EXTRA_ERROR_CODE).append(a3).append(", statusCode:").append(c).append(", detailErrorInfo:").append(a2.mo12392b()).toString();
            if (a3 == -4) {
                C36474dw c36474dw = new C36474dw(stringBuilder);
                AppMethodBeat.m2505o(101125);
                throw c36474dw;
            }
            IOException iOException2 = new IOException(stringBuilder);
            AppMethodBeat.m2505o(101125);
            throw iOException2;
        }
        iOException = new IOException("response is null");
        AppMethodBeat.m2505o(101125);
        throw iOException;
    }

    /* renamed from: b */
    private static String m71264b(String str) {
        AppMethodBeat.m2504i(101126);
        String str2 = "GBK";
        if (str != null) {
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (str3.contains("charset")) {
                    String[] split2 = str3.split("=");
                    if (split2.length > 1) {
                        str2 = split2[1].trim();
                    }
                } else {
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(101126);
        return str2;
    }
}
