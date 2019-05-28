package com.tencent.mm.plugin.sns.storage;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class v {
    public static String ao(String str, long j) {
        AppMethodBeat.i(38017);
        String str2 = str + j;
        AppMethodBeat.o(38017);
        return str2;
    }

    public static String ap(String str, long j) {
        AppMethodBeat.i(38018);
        String str2 = str + j;
        AppMethodBeat.o(38018);
        return str2;
    }

    public static boolean Zl(String str) {
        AppMethodBeat.i(38019);
        if (str == null || !str.startsWith("ad_table_")) {
            AppMethodBeat.o(38019);
            return false;
        }
        AppMethodBeat.o(38019);
        return true;
    }

    public static boolean WT(String str) {
        AppMethodBeat.i(38020);
        if (str == null || !str.startsWith("sns_table_")) {
            AppMethodBeat.o(38020);
            return false;
        }
        AppMethodBeat.o(38020);
        return true;
    }

    public static long Zm(String str) {
        AppMethodBeat.i(38021);
        long anl;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(38021);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            anl = bo.anl(str.substring(9));
            AppMethodBeat.o(38021);
            return anl;
        } else if (str.startsWith("sns_table_")) {
            anl = bo.anl(str.substring(10));
            AppMethodBeat.o(38021);
            return anl;
        } else {
            anl = bo.anl(str);
            AppMethodBeat.o(38021);
            return anl;
        }
    }

    public static int Zn(String str) {
        AppMethodBeat.i(38022);
        int ank;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(38022);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            ank = bo.ank(str.substring(9));
            AppMethodBeat.o(38022);
            return ank;
        } else {
            ank = bo.ank(str.substring(10));
            AppMethodBeat.o(38022);
            return ank;
        }
    }

    public static boolean Zo(String str) {
        AppMethodBeat.i(38023);
        if (str.startsWith("ad_table_")) {
            if (bo.anl(str.substring(9)) != 0) {
                AppMethodBeat.o(38023);
                return true;
            }
            AppMethodBeat.o(38023);
            return false;
        } else if (bo.anl(str.substring(10)) != 0) {
            AppMethodBeat.o(38023);
            return true;
        } else {
            AppMethodBeat.o(38023);
            return false;
        }
    }

    public static boolean Zp(String str) {
        AppMethodBeat.i(38024);
        if (Zo(str)) {
            AppMethodBeat.o(38024);
            return false;
        }
        AppMethodBeat.o(38024);
        return true;
    }

    public static int gr(String str, String str2) {
        AppMethodBeat.i(38025);
        g.RN();
        int ak = ak(str, str2, a.QG());
        AppMethodBeat.o(38025);
        return ak;
    }

    public static int ak(String str, String str2, String str3) {
        int i = 0;
        AppMethodBeat.i(38026);
        String al = al(str, str2, str3);
        if (!bo.isNullOrNil(al)) {
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
        AppMethodBeat.o(38026);
        return i;
    }

    public static String al(String str, String str2, String str3) {
        AppMethodBeat.i(38027);
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
            string = ah.getContext().getSharedPreferences("SnsAdVote", 0).getString(stringBuilder.toString(), "");
            AppMethodBeat.o(38027);
            return string;
        }
        string = "";
        AppMethodBeat.o(38027);
        return string;
    }

    public static void h(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(38028);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(38028);
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
            AppMethodBeat.o(38028);
            return;
        }
        Editor edit = ah.getContext().getSharedPreferences("SnsAdVote", 0).edit();
        edit.putString(stringBuilder.toString(), "voteResultIndex=" + i + "&isUpdate=" + i2);
        edit.commit();
        AppMethodBeat.o(38028);
    }
}
