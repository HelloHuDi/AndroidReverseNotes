package com.tencent.mm.al;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;
import java.util.List;

public final class c {
    public static int fyW = 1;
    public static int fyX = 2;
    public static int fyY = 3;
    public static int fyZ = -1;
    public static int fza = 3;
    public static int fzb = 4;
    public static int fzc = 5;
    public static int fzd = 1;
    public static int fze = 2;
    public static int fzf = -10001;
    public static int fzg = -10002;
    public static int fzh = -10003;
    public static int fzi = -10004;

    public static void outputJniLog(byte[] bArr, String str, int i) {
        AppMethodBeat.i(78059);
        if (bo.cb(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            ab.e(str, str2);
            AppMethodBeat.o(78059);
        } else if (i == 3) {
            ab.w(str, str2);
            AppMethodBeat.o(78059);
        } else if (i == 2) {
            ab.i(str, str2);
            AppMethodBeat.o(78059);
        } else if (i == 1) {
            ab.d(str, str2);
            AppMethodBeat.o(78059);
        } else {
            if (i == 0) {
                ab.v(str, str2);
            }
            AppMethodBeat.o(78059);
        }
    }

    private static String rP(String str) {
        AppMethodBeat.i(78060);
        if (!bo.isNullOrNil(str)) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (bo.z(charAt) || bo.A(charAt)) {
                    i++;
                } else {
                    AppMethodBeat.o(78060);
                    return null;
                }
            }
        }
        AppMethodBeat.o(78060);
        return str;
    }

    public static String a(String str, long j, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(78061);
        ab.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", str, Long.valueOf(j), str2, str3, bo.dpG());
        if (bo.isNullOrNil(rP(str))) {
            AppMethodBeat.o(78061);
        } else if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(78061);
        } else if (j <= 0) {
            AppMethodBeat.o(78061);
        } else {
            String nullAsNil = bo.nullAsNil(rP(str3));
            str4 = "a" + str + "_" + g.x((r.Yz() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
            if (!bo.isNullOrNil(nullAsNil)) {
                str4 = str4 + "_" + nullAsNil;
            }
            AppMethodBeat.o(78061);
        }
        return str4;
    }

    public static int bV(Context context) {
        AppMethodBeat.i(78062);
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                i = fyW;
                AppMethodBeat.o(78062);
                return i;
            } else if (activeNetworkInfo.getType() == 1) {
                i = fyY;
                AppMethodBeat.o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                i = fyW;
                AppMethodBeat.o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                i = fyW;
                AppMethodBeat.o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                i = fyX;
                AppMethodBeat.o(78062);
                return i;
            } else {
                i = fyW;
                AppMethodBeat.o(78062);
                return i;
            }
        } catch (NullPointerException e) {
            ab.e("MicroMsg.CdnUtil", "exception:%s", bo.l(e));
            i = fyW;
            AppMethodBeat.o(78062);
            return i;
        }
    }

    public static int bW(Context context) {
        AppMethodBeat.i(78063);
        int netType = at.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        int i;
        if (activeNetworkInfo == null) {
            i = fyZ;
            AppMethodBeat.o(78063);
            return i;
        } else if (activeNetworkInfo.getType() == 1) {
            i = fzd;
            AppMethodBeat.o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            i = fza;
            AppMethodBeat.o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() >= 13) {
            i = fzc;
            AppMethodBeat.o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() >= 3) {
            i = fzb;
            AppMethodBeat.o(78063);
            return i;
        } else if (at.isWap(netType)) {
            i = fze;
            AppMethodBeat.o(78063);
            return i;
        } else {
            i = fza;
            AppMethodBeat.o(78063);
            return i;
        }
    }

    public static int b(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(78064);
        try {
            List list = (List) httpURLConnection.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(78064);
                return 0;
            } else if (bo.isNullOrNil(list.toString()) || !list.toString().contains("no-cache")) {
                AppMethodBeat.o(78064);
                return 0;
            } else {
                AppMethodBeat.o(78064);
                return -1;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.CdnUtil", "exception:%s", bo.l(e));
            AppMethodBeat.o(78064);
            return -2;
        }
    }
}
