package com.tencent.p177mm.plugin.sns.storage;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.v */
public final class C35002v {
    /* renamed from: ao */
    public static String m57489ao(String str, long j) {
        AppMethodBeat.m2504i(38017);
        String str2 = str + j;
        AppMethodBeat.m2505o(38017);
        return str2;
    }

    /* renamed from: ap */
    public static String m57490ap(String str, long j) {
        AppMethodBeat.m2504i(38018);
        String str2 = str + j;
        AppMethodBeat.m2505o(38018);
        return str2;
    }

    /* renamed from: Zl */
    public static boolean m57482Zl(String str) {
        AppMethodBeat.m2504i(38019);
        if (str == null || !str.startsWith("ad_table_")) {
            AppMethodBeat.m2505o(38019);
            return false;
        }
        AppMethodBeat.m2505o(38019);
        return true;
    }

    /* renamed from: WT */
    public static boolean m57481WT(String str) {
        AppMethodBeat.m2504i(38020);
        if (str == null || !str.startsWith("sns_table_")) {
            AppMethodBeat.m2505o(38020);
            return false;
        }
        AppMethodBeat.m2505o(38020);
        return true;
    }

    /* renamed from: Zm */
    public static long m57483Zm(String str) {
        AppMethodBeat.m2504i(38021);
        long anl;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(38021);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            anl = C5046bo.anl(str.substring(9));
            AppMethodBeat.m2505o(38021);
            return anl;
        } else if (str.startsWith("sns_table_")) {
            anl = C5046bo.anl(str.substring(10));
            AppMethodBeat.m2505o(38021);
            return anl;
        } else {
            anl = C5046bo.anl(str);
            AppMethodBeat.m2505o(38021);
            return anl;
        }
    }

    /* renamed from: Zn */
    public static int m57484Zn(String str) {
        AppMethodBeat.m2504i(38022);
        int ank;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(38022);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            ank = C5046bo.ank(str.substring(9));
            AppMethodBeat.m2505o(38022);
            return ank;
        } else {
            ank = C5046bo.ank(str.substring(10));
            AppMethodBeat.m2505o(38022);
            return ank;
        }
    }

    /* renamed from: Zo */
    public static boolean m57485Zo(String str) {
        AppMethodBeat.m2504i(38023);
        if (str.startsWith("ad_table_")) {
            if (C5046bo.anl(str.substring(9)) != 0) {
                AppMethodBeat.m2505o(38023);
                return true;
            }
            AppMethodBeat.m2505o(38023);
            return false;
        } else if (C5046bo.anl(str.substring(10)) != 0) {
            AppMethodBeat.m2505o(38023);
            return true;
        } else {
            AppMethodBeat.m2505o(38023);
            return false;
        }
    }

    /* renamed from: Zp */
    public static boolean m57486Zp(String str) {
        AppMethodBeat.m2504i(38024);
        if (C35002v.m57485Zo(str)) {
            AppMethodBeat.m2505o(38024);
            return false;
        }
        AppMethodBeat.m2505o(38024);
        return true;
    }

    /* renamed from: gr */
    public static int m57491gr(String str, String str2) {
        AppMethodBeat.m2504i(38025);
        C1720g.m3534RN();
        int ak = C35002v.m57487ak(str, str2, C1668a.m3384QG());
        AppMethodBeat.m2505o(38025);
        return ak;
    }

    /* renamed from: ak */
    public static int m57487ak(String str, String str2, String str3) {
        int i = 0;
        AppMethodBeat.m2504i(38026);
        String al = C35002v.m57488al(str, str2, str3);
        if (!C5046bo.isNullOrNil(al)) {
            String[] split = al.split("&");
            int i2 = 0;
            while (i2 < split.length) {
                if (split[i2] != null && split[i2].contains("voteResultIndex=")) {
                    i = Integer.valueOf(split[i2].substring(16)).intValue();
                    break;
                }
                i2++;
            }
        }
        AppMethodBeat.m2505o(38026);
        return i;
    }

    /* renamed from: al */
    public static String m57488al(String str, String str2, String str3) {
        AppMethodBeat.m2504i(38027);
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        String string;
        if (stringBuilder.length() > 0) {
            string = C4996ah.getContext().getSharedPreferences("SnsAdVote", 0).getString(stringBuilder.toString(), "");
            AppMethodBeat.m2505o(38027);
            return string;
        }
        string = "";
        AppMethodBeat.m2505o(38027);
        return string;
    }

    /* renamed from: h */
    public static void m57492h(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(38028);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(38028);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        if (stringBuilder.length() <= 0) {
            AppMethodBeat.m2505o(38028);
            return;
        }
        Editor edit = C4996ah.getContext().getSharedPreferences("SnsAdVote", 0).edit();
        edit.putString(stringBuilder.toString(), "voteResultIndex=" + i + "&isUpdate=" + i2);
        edit.commit();
        AppMethodBeat.m2505o(38028);
    }
}
