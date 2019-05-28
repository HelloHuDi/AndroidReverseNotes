package com.tencent.p177mm.p187al;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.HttpURLConnection;
import java.util.List;

/* renamed from: com.tencent.mm.al.c */
public final class C37458c {
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
        AppMethodBeat.m2504i(78059);
        if (C5046bo.m7540cb(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(78059);
        } else if (i == 3) {
            C4990ab.m7420w(str, str2);
            AppMethodBeat.m2505o(78059);
        } else if (i == 2) {
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(78059);
        } else if (i == 1) {
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(78059);
        } else {
            if (i == 0) {
                C4990ab.m7418v(str, str2);
            }
            AppMethodBeat.m2505o(78059);
        }
    }

    /* renamed from: rP */
    private static String m63166rP(String str) {
        AppMethodBeat.m2504i(78060);
        if (!C5046bo.isNullOrNil(str)) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (C5046bo.m7590z(charAt) || C5046bo.m7498A(charAt)) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(78060);
                    return null;
                }
            }
        }
        AppMethodBeat.m2505o(78060);
        return str;
    }

    /* renamed from: a */
    public static String m63162a(String str, long j, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.m2504i(78061);
        C4990ab.m7411d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", str, Long.valueOf(j), str2, str3, C5046bo.dpG());
        if (C5046bo.isNullOrNil(C37458c.m63166rP(str))) {
            AppMethodBeat.m2505o(78061);
        } else if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(78061);
        } else if (j <= 0) {
            AppMethodBeat.m2505o(78061);
        } else {
            String nullAsNil = C5046bo.nullAsNil(C37458c.m63166rP(str3));
            str4 = "a" + str + "_" + C1178g.m2591x((C1853r.m3846Yz() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
            if (!C5046bo.isNullOrNil(nullAsNil)) {
                str4 = str4 + "_" + nullAsNil;
            }
            AppMethodBeat.m2505o(78061);
        }
        return str4;
    }

    /* renamed from: bV */
    public static int m63164bV(Context context) {
        AppMethodBeat.m2504i(78062);
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                i = fyW;
                AppMethodBeat.m2505o(78062);
                return i;
            } else if (activeNetworkInfo.getType() == 1) {
                i = fyY;
                AppMethodBeat.m2505o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                i = fyW;
                AppMethodBeat.m2505o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                i = fyW;
                AppMethodBeat.m2505o(78062);
                return i;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                i = fyX;
                AppMethodBeat.m2505o(78062);
                return i;
            } else {
                i = fyW;
                AppMethodBeat.m2505o(78062);
                return i;
            }
        } catch (NullPointerException e) {
            C4990ab.m7413e("MicroMsg.CdnUtil", "exception:%s", C5046bo.m7574l(e));
            i = fyW;
            AppMethodBeat.m2505o(78062);
            return i;
        }
    }

    /* renamed from: bW */
    public static int m63165bW(Context context) {
        AppMethodBeat.m2504i(78063);
        int netType = C5023at.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        int i;
        if (activeNetworkInfo == null) {
            i = fyZ;
            AppMethodBeat.m2505o(78063);
            return i;
        } else if (activeNetworkInfo.getType() == 1) {
            i = fzd;
            AppMethodBeat.m2505o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            i = fza;
            AppMethodBeat.m2505o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() >= 13) {
            i = fzc;
            AppMethodBeat.m2505o(78063);
            return i;
        } else if (activeNetworkInfo.getSubtype() >= 3) {
            i = fzb;
            AppMethodBeat.m2505o(78063);
            return i;
        } else if (C5023at.isWap(netType)) {
            i = fze;
            AppMethodBeat.m2505o(78063);
            return i;
        } else {
            i = fza;
            AppMethodBeat.m2505o(78063);
            return i;
        }
    }

    /* renamed from: b */
    public static int m63163b(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(78064);
        try {
            List list = (List) httpURLConnection.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                AppMethodBeat.m2505o(78064);
                return 0;
            } else if (C5046bo.isNullOrNil(list.toString()) || !list.toString().contains("no-cache")) {
                AppMethodBeat.m2505o(78064);
                return 0;
            } else {
                AppMethodBeat.m2505o(78064);
                return -1;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CdnUtil", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78064);
            return -2;
        }
    }
}
