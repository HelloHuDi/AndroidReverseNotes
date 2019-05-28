package com.tencent.mm.plugin.report;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

public abstract class a {
    private static boolean pWV = false;
    private StringBuffer pWW = new StringBuffer();

    public abstract String Fj();

    public abstract String Fk();

    public abstract int getId();

    public static void kh(boolean z) {
        pWV = z;
    }

    public static String r(Object... objArr) {
        if (objArr.length <= 0) {
            ab.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final boolean ajK() {
        int id = getId();
        String Fj = Fj();
        ab.v("MicroMsg.AbsReportStruct", "report %d %s", Integer.valueOf(getId()), Fj());
        if (id <= 0 || bo.isNullOrNil(Fj)) {
            return false;
        }
        h.pYm.X(getId(), Fj());
        if (!pWV) {
            return true;
        }
        j.cgu().aa(Fj(), Fk(), "\r\n\r\n error:\r\n" + this.pWW.toString());
        return true;
    }

    private void fO(String str, String str2) {
        ab.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", Integer.valueOf(getId()), str, str2);
        this.pWW.append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).append(IOUtils.LINE_SEPARATOR_WINDOWS);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ai(String str, long j) {
        if (j <= 0) {
            fO(str, String.valueOf(j));
            return false;
        } else if (j < 3600000) {
            return true;
        } else {
            fO(str, String.valueOf(j));
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aj(String str, long j) {
        if (j > 151473600000L) {
            return true;
        }
        fO(str, String.valueOf(j));
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ak(String str, long j) {
        if (j > 151473600) {
            return true;
        }
        fO(str, String.valueOf(j));
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean VX(String str) {
        if (bo.isNullOrNil(str)) {
            fO("", "check rpt value is null.");
            return false;
        } else if (str.length() < 7168) {
            return true;
        } else {
            fO("", "check rpt value more than 7k.");
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String t(String str, String str2, boolean z) {
        if (bo.isNullOrNil(str2) || !str2.contains(",")) {
            return str2;
        }
        if (z && (f.DEBUG || f.IS_FLAVOR_RED)) {
            Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + str + " value:" + str2, false);
        } else {
            fO(str, "value contain comma, please confirm your logic. value :".concat(String.valueOf(str2)));
        }
        return str2.replace(',', ' ');
    }

    protected static boolean getBoolean(String str) {
        if (bo.getInt(str, 0) != 0) {
            return true;
        }
        return false;
    }
}
