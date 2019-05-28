package com.tencent.mm.plugin.welab.d.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends cq {
    public static com.tencent.mm.sdk.e.c.a ccO;
    private static final List<String> uMf = Arrays.asList(new String[]{"_cn", "_hk", "_tw", "_en"});
    private Map<String, Field> uMe = new HashMap();

    public a() {
        AppMethodBeat.i(80584);
        AppMethodBeat.o(80584);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public int hashCode() {
        AppMethodBeat.i(80585);
        int hashCode = this.field_LabsAppId.hashCode();
        AppMethodBeat.o(80585);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(80586);
        if (obj == this) {
            AppMethodBeat.o(80586);
            return true;
        } else if (obj instanceof a) {
            boolean equals = ((a) obj).field_LabsAppId.equals(this.field_LabsAppId);
            AppMethodBeat.o(80586);
            return equals;
        } else {
            AppMethodBeat.o(80586);
            return false;
        }
    }

    public final boolean isValid() {
        AppMethodBeat.i(80587);
        if (TextUtils.isEmpty(this.field_LabsAppId) || this.field_LabsAppId.equals("labs1de6f3")) {
            AppMethodBeat.o(80587);
            return false;
        }
        AppMethodBeat.o(80587);
        return true;
    }

    public final boolean isRunning() {
        AppMethodBeat.i(80588);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_starttime || System.currentTimeMillis() / 1000 >= this.field_endtime) {
            AppMethodBeat.o(80588);
            return false;
        }
        AppMethodBeat.o(80588);
        return true;
    }

    public final boolean isExpired() {
        AppMethodBeat.i(80589);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_endtime) {
            AppMethodBeat.o(80589);
            return false;
        }
        AppMethodBeat.o(80589);
        return true;
    }

    public String toString() {
        AppMethodBeat.i(80590);
        String str = "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + ", exptId " + this.field_expId + "]";
        AppMethodBeat.o(80590);
        return str;
    }

    public final String agR(String str) {
        AppMethodBeat.i(80591);
        String Eq = Eq(str + "Key_android");
        if (!TextUtils.isEmpty(Eq)) {
            Eq = ah.getResources().getString(ah.getResources().getIdentifier(Eq, "string", ah.getPackageName()));
            if (!TextUtils.isEmpty(Eq)) {
                AppMethodBeat.o(80591);
                return Eq;
            }
        }
        Eq = aa.gw(ah.getContext());
        if (aa.doo()) {
            Eq = hq(str, "_cn");
            AppMethodBeat.o(80591);
            return Eq;
        } else if ("zh_HK".equals(Eq)) {
            Eq = hq(str, "_hk");
            AppMethodBeat.o(80591);
            return Eq;
        } else if ("zh_TW".equals(Eq)) {
            Eq = hq(str, "_tw");
            AppMethodBeat.o(80591);
            return Eq;
        } else {
            Eq = hq(str, "_en");
            AppMethodBeat.o(80591);
            return Eq;
        }
    }

    private String hq(String str, String str2) {
        AppMethodBeat.i(80592);
        String Eq = Eq(str + str2);
        if (TextUtils.isEmpty(Eq)) {
            Eq = agS(str);
            AppMethodBeat.o(80592);
            return Eq;
        }
        AppMethodBeat.o(80592);
        return Eq;
    }

    private String agS(String str) {
        String Eq;
        AppMethodBeat.i(80593);
        for (String Eq2 : uMf) {
            Eq2 = Eq(str + Eq2);
            if (!TextUtils.isEmpty(Eq2)) {
                AppMethodBeat.o(80593);
                return Eq2;
            }
        }
        Eq2 = "";
        AppMethodBeat.o(80593);
        return Eq2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001d A:{SYNTHETIC, Splitter:B:7:0x001d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String Eq(String str) {
        Field field;
        Throwable e;
        String str2;
        AppMethodBeat.i(80594);
        Field field2 = (Field) this.uMe.get(str);
        if (field2 == null) {
            try {
                field = a.class.getField(str);
                try {
                    this.uMe.put(str, field);
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    ab.w("LabAppInfo", bo.l(e));
                    if (field != null) {
                    }
                    str2 = "";
                    AppMethodBeat.o(80594);
                    return str2;
                }
            } catch (NoSuchFieldException e3) {
                e = e3;
                field = field2;
            }
        } else {
            field = field2;
        }
        if (field != null) {
            try {
                str2 = (String) field.get(this);
                AppMethodBeat.o(80594);
                return str2;
            } catch (IllegalAccessException e4) {
                ab.w("LabAppInfo", bo.l(e4));
            }
        }
        str2 = "";
        AppMethodBeat.o(80594);
        return str2;
    }

    public final boolean ddt() {
        AppMethodBeat.i(80595);
        if (isExpired() || this.field_Switch == 3) {
            AppMethodBeat.o(80595);
            return true;
        }
        AppMethodBeat.o(80595);
        return false;
    }

    public final boolean ddu() {
        AppMethodBeat.i(80596);
        if (isRunning() && (this.field_Switch == 2 || this.field_Switch == 1)) {
            AppMethodBeat.o(80596);
            return true;
        }
        AppMethodBeat.o(80596);
        return false;
    }

    public final void ddv() {
        AppMethodBeat.i(80597);
        if (this.field_idkey > 0 && this.field_idkeyValue >= 0) {
            h.pYm.a((long) this.field_idkey, (long) this.field_idkeyValue, 1, false);
        }
        AppMethodBeat.o(80597);
    }

    public final boolean ddw() {
        return this.field_bItemFromXExpt == 1;
    }

    public final boolean ddx() {
        if (this.field_status == 1) {
            return true;
        }
        return false;
    }

    static {
        AppMethodBeat.i(80598);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[46];
        aVar.columns = new String[47];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "LabsAppId";
        aVar.xDd.put("LabsAppId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "LabsAppId";
        aVar.columns[1] = "expId";
        aVar.xDd.put("expId", "TEXT default '' ");
        stringBuilder.append(" expId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "Type";
        aVar.xDd.put("Type", "INTEGER default '0' ");
        stringBuilder.append(" Type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "BizType";
        aVar.xDd.put("BizType", "INTEGER default '0' ");
        stringBuilder.append(" BizType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "Switch";
        aVar.xDd.put("Switch", "INTEGER default '0' ");
        stringBuilder.append(" Switch INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "AllVer";
        aVar.xDd.put("AllVer", "INTEGER default '0' ");
        stringBuilder.append(" AllVer INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "DetailURL";
        aVar.xDd.put("DetailURL", "TEXT");
        stringBuilder.append(" DetailURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "WeAppUser";
        aVar.xDd.put("WeAppUser", "TEXT");
        stringBuilder.append(" WeAppUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "WeAppPath";
        aVar.xDd.put("WeAppPath", "TEXT");
        stringBuilder.append(" WeAppPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "Pos";
        aVar.xDd.put("Pos", "INTEGER default '0' ");
        stringBuilder.append(" Pos INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "TitleKey_android";
        aVar.xDd.put("TitleKey_android", "TEXT");
        stringBuilder.append(" TitleKey_android TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "Title_cn";
        aVar.xDd.put("Title_cn", "TEXT");
        stringBuilder.append(" Title_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "Title_hk";
        aVar.xDd.put("Title_hk", "TEXT");
        stringBuilder.append(" Title_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "Title_tw";
        aVar.xDd.put("Title_tw", "TEXT");
        stringBuilder.append(" Title_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "Title_en";
        aVar.xDd.put("Title_en", "TEXT");
        stringBuilder.append(" Title_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "Desc_cn";
        aVar.xDd.put("Desc_cn", "TEXT");
        stringBuilder.append(" Desc_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "Desc_hk";
        aVar.xDd.put("Desc_hk", "TEXT");
        stringBuilder.append(" Desc_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "Desc_tw";
        aVar.xDd.put("Desc_tw", "TEXT");
        stringBuilder.append(" Desc_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "Desc_en";
        aVar.xDd.put("Desc_en", "TEXT");
        stringBuilder.append(" Desc_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "Introduce_cn";
        aVar.xDd.put("Introduce_cn", "TEXT");
        stringBuilder.append(" Introduce_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "Introduce_hk";
        aVar.xDd.put("Introduce_hk", "TEXT");
        stringBuilder.append(" Introduce_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "Introduce_tw";
        aVar.xDd.put("Introduce_tw", "TEXT");
        stringBuilder.append(" Introduce_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "Introduce_en";
        aVar.xDd.put("Introduce_en", "TEXT");
        stringBuilder.append(" Introduce_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "starttime";
        aVar.xDd.put("starttime", "LONG");
        stringBuilder.append(" starttime LONG");
        stringBuilder.append(", ");
        aVar.columns[24] = "endtime";
        aVar.xDd.put("endtime", "LONG");
        stringBuilder.append(" endtime LONG");
        stringBuilder.append(", ");
        aVar.columns[25] = "sequence";
        aVar.xDd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[26] = "prioritylevel";
        aVar.xDd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[27] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "ThumbUrl_cn";
        aVar.xDd.put("ThumbUrl_cn", "TEXT");
        stringBuilder.append(" ThumbUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "ThumbUrl_hk";
        aVar.xDd.put("ThumbUrl_hk", "TEXT");
        stringBuilder.append(" ThumbUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "ThumbUrl_tw";
        aVar.xDd.put("ThumbUrl_tw", "TEXT");
        stringBuilder.append(" ThumbUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "ThumbUrl_en";
        aVar.xDd.put("ThumbUrl_en", "TEXT");
        stringBuilder.append(" ThumbUrl_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "ImgUrl_android_cn";
        aVar.xDd.put("ImgUrl_android_cn", "TEXT");
        stringBuilder.append(" ImgUrl_android_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "ImgUrl_android_hk";
        aVar.xDd.put("ImgUrl_android_hk", "TEXT");
        stringBuilder.append(" ImgUrl_android_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "ImgUrl_android_tw";
        aVar.xDd.put("ImgUrl_android_tw", "TEXT");
        stringBuilder.append(" ImgUrl_android_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "ImgUrl_android_en";
        aVar.xDd.put("ImgUrl_android_en", "TEXT");
        stringBuilder.append(" ImgUrl_android_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "RedPoint";
        aVar.xDd.put("RedPoint", "INTEGER");
        stringBuilder.append(" RedPoint INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "WeAppDebugMode";
        aVar.xDd.put("WeAppDebugMode", "INTEGER");
        stringBuilder.append(" WeAppDebugMode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "idkey";
        aVar.xDd.put("idkey", "INTEGER");
        stringBuilder.append(" idkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[39] = "idkeyValue";
        aVar.xDd.put("idkeyValue", "INTEGER");
        stringBuilder.append(" idkeyValue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[40] = "Icon";
        aVar.xDd.put("Icon", "TEXT");
        stringBuilder.append(" Icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[41] = "ImgUrl_cn";
        aVar.xDd.put("ImgUrl_cn", "TEXT");
        stringBuilder.append(" ImgUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[42] = "ImgUrl_hk";
        aVar.xDd.put("ImgUrl_hk", "TEXT");
        stringBuilder.append(" ImgUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[43] = "ImgUrl_tw";
        aVar.xDd.put("ImgUrl_tw", "TEXT");
        stringBuilder.append(" ImgUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[44] = "ImgUrl_en";
        aVar.xDd.put("ImgUrl_en", "TEXT");
        stringBuilder.append(" ImgUrl_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[45] = "bItemFromXExpt";
        aVar.xDd.put("bItemFromXExpt", "INTEGER");
        stringBuilder.append(" bItemFromXExpt INTEGER");
        aVar.columns[46] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(80598);
    }
}
