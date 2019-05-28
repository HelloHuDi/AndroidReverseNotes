package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.bg;
import com.tencent.tencentmap.mapsdk.maps.a.bh;
import com.tencent.tencentmap.mapsdk.maps.a.bk;
import com.tencent.tencentmap.mapsdk.maps.a.bl;
import com.tencent.tencentmap.mapsdk.maps.a.bm;
import com.tencent.tencentmap.mapsdk.maps.a.hs;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.lu;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class dv implements dr {
    private static final String[] a = new String[]{hs.a(), "https://vectorsdk.map.qq.com", "https://tafrtt.map.qq.com/rttserverex/", "diditaf.map.qq.com"};
    private static bh b;
    private static bk c;

    static {
        AppMethodBeat.i(101127);
        AppMethodBeat.o(101127);
    }

    public void a(Context context) {
        AppMethodBeat.i(101115);
        try {
            bh bhVar = new bh(context, 3203, ic.a, "android_vector_sdk_4.2.2.1");
            b = bhVar;
            c = bg.b(bhVar);
            AppMethodBeat.o(101115);
        } catch (Exception e) {
            new StringBuilder("initNet error:").append(e.toString());
            AppMethodBeat.o(101115);
        }
    }

    public dt a(String str) {
        AppMethodBeat.i(101116);
        dt a = a(str, "QQ Map Mobile");
        AppMethodBeat.o(101116);
        return a;
    }

    public dt a(String str, String str2) {
        AppMethodBeat.i(101117);
        dt a = a(str, str2, 1);
        AppMethodBeat.o(101117);
        return a;
    }

    public dt a(String str, String str2, int i) {
        AppMethodBeat.i(101118);
        dt a = a(str, str2, i, null);
        AppMethodBeat.o(101118);
        return a;
    }

    public dt a(String str, String str2, int i, lu luVar) {
        AppMethodBeat.i(101119);
        dt a = a(str, str2, i, null, luVar);
        AppMethodBeat.o(101119);
        return a;
    }

    public dt a(String str, String str2, int i, HashMap<String, String> hashMap, lu luVar) {
        AppMethodBeat.i(101120);
        IOException iOException;
        if (c == null) {
            iOException = new IOException("HttpClient Init Failed and is Null");
            AppMethodBeat.o(101120);
            throw iOException;
        }
        bl a = c.a(str, null);
        a.b(i > 0);
        a.a((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        a.b((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        a.a(true);
        if (!StringUtil.isEmpty(str2)) {
            a.a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Entry entry : hashMap.entrySet()) {
                if (entry != null) {
                    a.a((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (luVar != null) {
            luVar.a(a);
        }
        bm a2 = c.a(a);
        if (a2 != null) {
            int c = a2.c();
            int a3 = a2.a();
            if (a3 == 0 && c == 200) {
                dt dtVar = new dt();
                dtVar.a = a2.d();
                dtVar.b = b(a2.a("Content-Type"));
                AppMethodBeat.o(101120);
                return dtVar;
            }
            String stringBuilder = new StringBuilder(OpenSDKTool4Assistant.EXTRA_ERROR_CODE).append(a3).append(", statusCode:").append(c).append(", detailErrorInfo:").append(a2.b()).toString();
            if (a3 == -4) {
                dw dwVar = new dw(stringBuilder);
                AppMethodBeat.o(101120);
                throw dwVar;
            }
            IOException iOException2 = new IOException(stringBuilder);
            AppMethodBeat.o(101120);
            throw iOException2;
        }
        iOException = new IOException("response is null");
        AppMethodBeat.o(101120);
        throw iOException;
    }

    public dt a(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(101121);
        dt a = a(str, str2, bArr, 1);
        AppMethodBeat.o(101121);
        return a;
    }

    public dt a(String str, String str2, byte[] bArr, int i) {
        AppMethodBeat.i(101122);
        dt a = a(str, str2, bArr, i, null);
        AppMethodBeat.o(101122);
        return a;
    }

    public dt a(String str, String str2, byte[] bArr, int i, lu luVar) {
        AppMethodBeat.i(101123);
        dt a = a(str, str2, bArr, i, null, luVar);
        AppMethodBeat.o(101123);
        return a;
    }

    public dt a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, lu luVar) {
        AppMethodBeat.i(101124);
        dt a = a(str, str2, bArr, i, hashMap, luVar, 0);
        AppMethodBeat.o(101124);
        return a;
    }

    public dt a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, lu luVar, int i2) {
        boolean z = false;
        AppMethodBeat.i(101125);
        IOException iOException;
        if (c == null) {
            iOException = new IOException("HttpClient Init Failed and is Null");
            AppMethodBeat.o(101125);
            throw iOException;
        }
        bl a = c.a(str, bArr);
        a.a(false);
        if (i > 0) {
            z = true;
        }
        a.b(z);
        if (!StringUtil.isEmpty(str2)) {
            a.a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Entry entry : hashMap.entrySet()) {
                if (entry != null) {
                    a.a((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (luVar != null) {
            luVar.a(a);
        }
        if (i2 > 0) {
            a.a(i2);
            a.b(i2);
        } else {
            a.a((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            a.b((int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        bm a2 = c.a(a);
        if (a2 != null) {
            int c = a2.c();
            int a3 = a2.a();
            if (a3 == 0 && c == 200) {
                dt dtVar = new dt();
                dtVar.a = a2.d();
                dtVar.b = b(a2.a("Content-Type"));
                AppMethodBeat.o(101125);
                return dtVar;
            }
            String stringBuilder = new StringBuilder(OpenSDKTool4Assistant.EXTRA_ERROR_CODE).append(a3).append(", statusCode:").append(c).append(", detailErrorInfo:").append(a2.b()).toString();
            if (a3 == -4) {
                dw dwVar = new dw(stringBuilder);
                AppMethodBeat.o(101125);
                throw dwVar;
            }
            IOException iOException2 = new IOException(stringBuilder);
            AppMethodBeat.o(101125);
            throw iOException2;
        }
        iOException = new IOException("response is null");
        AppMethodBeat.o(101125);
        throw iOException;
    }

    private static String b(String str) {
        AppMethodBeat.i(101126);
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
        AppMethodBeat.o(101126);
        return str2;
    }
}
