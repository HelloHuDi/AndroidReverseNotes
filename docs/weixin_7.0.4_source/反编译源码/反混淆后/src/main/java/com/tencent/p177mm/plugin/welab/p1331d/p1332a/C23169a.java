package com.tencent.p177mm.plugin.welab.p1331d.p1332a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32685cq;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.d.a.a */
public class C23169a extends C32685cq {
    public static C4924a ccO;
    private static final List<String> uMf = Arrays.asList(new String[]{"_cn", "_hk", "_tw", "_en"});
    private Map<String, Field> uMe = new HashMap();

    public C23169a() {
        AppMethodBeat.m2504i(80584);
        AppMethodBeat.m2505o(80584);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(80585);
        int hashCode = this.field_LabsAppId.hashCode();
        AppMethodBeat.m2505o(80585);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(80586);
        if (obj == this) {
            AppMethodBeat.m2505o(80586);
            return true;
        } else if (obj instanceof C23169a) {
            boolean equals = ((C23169a) obj).field_LabsAppId.equals(this.field_LabsAppId);
            AppMethodBeat.m2505o(80586);
            return equals;
        } else {
            AppMethodBeat.m2505o(80586);
            return false;
        }
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(80587);
        if (TextUtils.isEmpty(this.field_LabsAppId) || this.field_LabsAppId.equals("labs1de6f3")) {
            AppMethodBeat.m2505o(80587);
            return false;
        }
        AppMethodBeat.m2505o(80587);
        return true;
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(80588);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_starttime || System.currentTimeMillis() / 1000 >= this.field_endtime) {
            AppMethodBeat.m2505o(80588);
            return false;
        }
        AppMethodBeat.m2505o(80588);
        return true;
    }

    public final boolean isExpired() {
        AppMethodBeat.m2504i(80589);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_endtime) {
            AppMethodBeat.m2505o(80589);
            return false;
        }
        AppMethodBeat.m2505o(80589);
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(80590);
        String str = "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + ", exptId " + this.field_expId + "]";
        AppMethodBeat.m2505o(80590);
        return str;
    }

    public final String agR(String str) {
        AppMethodBeat.m2504i(80591);
        String Eq = m35551Eq(str + "Key_android");
        if (!TextUtils.isEmpty(Eq)) {
            Eq = C4996ah.getResources().getString(C4996ah.getResources().getIdentifier(Eq, "string", C4996ah.getPackageName()));
            if (!TextUtils.isEmpty(Eq)) {
                AppMethodBeat.m2505o(80591);
                return Eq;
            }
        }
        Eq = C4988aa.m7403gw(C4996ah.getContext());
        if (C4988aa.doo()) {
            Eq = m35552hq(str, "_cn");
            AppMethodBeat.m2505o(80591);
            return Eq;
        } else if ("zh_HK".equals(Eq)) {
            Eq = m35552hq(str, "_hk");
            AppMethodBeat.m2505o(80591);
            return Eq;
        } else if ("zh_TW".equals(Eq)) {
            Eq = m35552hq(str, "_tw");
            AppMethodBeat.m2505o(80591);
            return Eq;
        } else {
            Eq = m35552hq(str, "_en");
            AppMethodBeat.m2505o(80591);
            return Eq;
        }
    }

    /* renamed from: hq */
    private String m35552hq(String str, String str2) {
        AppMethodBeat.m2504i(80592);
        String Eq = m35551Eq(str + str2);
        if (TextUtils.isEmpty(Eq)) {
            Eq = agS(str);
            AppMethodBeat.m2505o(80592);
            return Eq;
        }
        AppMethodBeat.m2505o(80592);
        return Eq;
    }

    private String agS(String str) {
        String Eq;
        AppMethodBeat.m2504i(80593);
        for (String Eq2 : uMf) {
            Eq2 = m35551Eq(str + Eq2);
            if (!TextUtils.isEmpty(Eq2)) {
                AppMethodBeat.m2505o(80593);
                return Eq2;
            }
        }
        Eq2 = "";
        AppMethodBeat.m2505o(80593);
        return Eq2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001d A:{SYNTHETIC, Splitter:B:7:0x001d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Eq */
    private String m35551Eq(String str) {
        Field field;
        Throwable e;
        String str2;
        AppMethodBeat.m2504i(80594);
        Field field2 = (Field) this.uMe.get(str);
        if (field2 == null) {
            try {
                field = C23169a.class.getField(str);
                try {
                    this.uMe.put(str, field);
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    C4990ab.m7420w("LabAppInfo", C5046bo.m7574l(e));
                    if (field != null) {
                    }
                    str2 = "";
                    AppMethodBeat.m2505o(80594);
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
                AppMethodBeat.m2505o(80594);
                return str2;
            } catch (IllegalAccessException e4) {
                C4990ab.m7420w("LabAppInfo", C5046bo.m7574l(e4));
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(80594);
        return str2;
    }

    public final boolean ddt() {
        AppMethodBeat.m2504i(80595);
        if (isExpired() || this.field_Switch == 3) {
            AppMethodBeat.m2505o(80595);
            return true;
        }
        AppMethodBeat.m2505o(80595);
        return false;
    }

    public final boolean ddu() {
        AppMethodBeat.m2504i(80596);
        if (isRunning() && (this.field_Switch == 2 || this.field_Switch == 1)) {
            AppMethodBeat.m2505o(80596);
            return true;
        }
        AppMethodBeat.m2505o(80596);
        return false;
    }

    public final void ddv() {
        AppMethodBeat.m2504i(80597);
        if (this.field_idkey > 0 && this.field_idkeyValue >= 0) {
            C7060h.pYm.mo8378a((long) this.field_idkey, (long) this.field_idkeyValue, 1, false);
        }
        AppMethodBeat.m2505o(80597);
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
        AppMethodBeat.m2504i(80598);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[46];
        c4924a.columns = new String[47];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "LabsAppId";
        c4924a.xDd.put("LabsAppId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "LabsAppId";
        c4924a.columns[1] = "expId";
        c4924a.xDd.put("expId", "TEXT default '' ");
        stringBuilder.append(" expId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "Type";
        c4924a.xDd.put("Type", "INTEGER default '0' ");
        stringBuilder.append(" Type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "BizType";
        c4924a.xDd.put("BizType", "INTEGER default '0' ");
        stringBuilder.append(" BizType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "Switch";
        c4924a.xDd.put("Switch", "INTEGER default '0' ");
        stringBuilder.append(" Switch INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "AllVer";
        c4924a.xDd.put("AllVer", "INTEGER default '0' ");
        stringBuilder.append(" AllVer INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "DetailURL";
        c4924a.xDd.put("DetailURL", "TEXT");
        stringBuilder.append(" DetailURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "WeAppUser";
        c4924a.xDd.put("WeAppUser", "TEXT");
        stringBuilder.append(" WeAppUser TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "WeAppPath";
        c4924a.xDd.put("WeAppPath", "TEXT");
        stringBuilder.append(" WeAppPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "Pos";
        c4924a.xDd.put("Pos", "INTEGER default '0' ");
        stringBuilder.append(" Pos INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "TitleKey_android";
        c4924a.xDd.put("TitleKey_android", "TEXT");
        stringBuilder.append(" TitleKey_android TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "Title_cn";
        c4924a.xDd.put("Title_cn", "TEXT");
        stringBuilder.append(" Title_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "Title_hk";
        c4924a.xDd.put("Title_hk", "TEXT");
        stringBuilder.append(" Title_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "Title_tw";
        c4924a.xDd.put("Title_tw", "TEXT");
        stringBuilder.append(" Title_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "Title_en";
        c4924a.xDd.put("Title_en", "TEXT");
        stringBuilder.append(" Title_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "Desc_cn";
        c4924a.xDd.put("Desc_cn", "TEXT");
        stringBuilder.append(" Desc_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "Desc_hk";
        c4924a.xDd.put("Desc_hk", "TEXT");
        stringBuilder.append(" Desc_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[17] = "Desc_tw";
        c4924a.xDd.put("Desc_tw", "TEXT");
        stringBuilder.append(" Desc_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "Desc_en";
        c4924a.xDd.put("Desc_en", "TEXT");
        stringBuilder.append(" Desc_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[19] = "Introduce_cn";
        c4924a.xDd.put("Introduce_cn", "TEXT");
        stringBuilder.append(" Introduce_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[20] = "Introduce_hk";
        c4924a.xDd.put("Introduce_hk", "TEXT");
        stringBuilder.append(" Introduce_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[21] = "Introduce_tw";
        c4924a.xDd.put("Introduce_tw", "TEXT");
        stringBuilder.append(" Introduce_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[22] = "Introduce_en";
        c4924a.xDd.put("Introduce_en", "TEXT");
        stringBuilder.append(" Introduce_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[23] = "starttime";
        c4924a.xDd.put("starttime", "LONG");
        stringBuilder.append(" starttime LONG");
        stringBuilder.append(", ");
        c4924a.columns[24] = "endtime";
        c4924a.xDd.put("endtime", "LONG");
        stringBuilder.append(" endtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[25] = "sequence";
        c4924a.xDd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        c4924a.columns[26] = "prioritylevel";
        c4924a.xDd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[27] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[28] = "ThumbUrl_cn";
        c4924a.xDd.put("ThumbUrl_cn", "TEXT");
        stringBuilder.append(" ThumbUrl_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[29] = "ThumbUrl_hk";
        c4924a.xDd.put("ThumbUrl_hk", "TEXT");
        stringBuilder.append(" ThumbUrl_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[30] = "ThumbUrl_tw";
        c4924a.xDd.put("ThumbUrl_tw", "TEXT");
        stringBuilder.append(" ThumbUrl_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[31] = "ThumbUrl_en";
        c4924a.xDd.put("ThumbUrl_en", "TEXT");
        stringBuilder.append(" ThumbUrl_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[32] = "ImgUrl_android_cn";
        c4924a.xDd.put("ImgUrl_android_cn", "TEXT");
        stringBuilder.append(" ImgUrl_android_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[33] = "ImgUrl_android_hk";
        c4924a.xDd.put("ImgUrl_android_hk", "TEXT");
        stringBuilder.append(" ImgUrl_android_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[34] = "ImgUrl_android_tw";
        c4924a.xDd.put("ImgUrl_android_tw", "TEXT");
        stringBuilder.append(" ImgUrl_android_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[35] = "ImgUrl_android_en";
        c4924a.xDd.put("ImgUrl_android_en", "TEXT");
        stringBuilder.append(" ImgUrl_android_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[36] = "RedPoint";
        c4924a.xDd.put("RedPoint", "INTEGER");
        stringBuilder.append(" RedPoint INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[37] = "WeAppDebugMode";
        c4924a.xDd.put("WeAppDebugMode", "INTEGER");
        stringBuilder.append(" WeAppDebugMode INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[38] = "idkey";
        c4924a.xDd.put("idkey", "INTEGER");
        stringBuilder.append(" idkey INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[39] = "idkeyValue";
        c4924a.xDd.put("idkeyValue", "INTEGER");
        stringBuilder.append(" idkeyValue INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[40] = "Icon";
        c4924a.xDd.put("Icon", "TEXT");
        stringBuilder.append(" Icon TEXT");
        stringBuilder.append(", ");
        c4924a.columns[41] = "ImgUrl_cn";
        c4924a.xDd.put("ImgUrl_cn", "TEXT");
        stringBuilder.append(" ImgUrl_cn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[42] = "ImgUrl_hk";
        c4924a.xDd.put("ImgUrl_hk", "TEXT");
        stringBuilder.append(" ImgUrl_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[43] = "ImgUrl_tw";
        c4924a.xDd.put("ImgUrl_tw", "TEXT");
        stringBuilder.append(" ImgUrl_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[44] = "ImgUrl_en";
        c4924a.xDd.put("ImgUrl_en", "TEXT");
        stringBuilder.append(" ImgUrl_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[45] = "bItemFromXExpt";
        c4924a.xDd.put("bItemFromXExpt", "INTEGER");
        stringBuilder.append(" bItemFromXExpt INTEGER");
        c4924a.columns[46] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(80598);
    }
}
