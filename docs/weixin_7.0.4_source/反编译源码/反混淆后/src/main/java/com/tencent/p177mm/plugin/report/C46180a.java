package com.tencent.p177mm.plugin.report;

import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.C7063j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.report.a */
public abstract class C46180a {
    private static boolean pWV = false;
    private StringBuffer pWW = new StringBuffer();

    /* renamed from: Fj */
    public abstract String mo4982Fj();

    /* renamed from: Fk */
    public abstract String mo4983Fk();

    public abstract int getId();

    /* renamed from: kh */
    public static void m86310kh(boolean z) {
        pWV = z;
    }

    /* renamed from: r */
    public static String m86311r(Object... objArr) {
        if (objArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
        String Fj = mo4982Fj();
        C4990ab.m7419v("MicroMsg.AbsReportStruct", "report %d %s", Integer.valueOf(getId()), mo4982Fj());
        if (id <= 0 || C5046bo.isNullOrNil(Fj)) {
            return false;
        }
        C7060h.pYm.mo8374X(getId(), mo4982Fj());
        if (!pWV) {
            return true;
        }
        C7063j.cgu().mo15422aa(mo4982Fj(), mo4983Fk(), "\r\n\r\n error:\r\n" + this.pWW.toString());
        return true;
    }

    /* renamed from: fO */
    private void m86309fO(String str, String str2) {
        C4990ab.m7421w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", Integer.valueOf(getId()), str, str2);
        this.pWW.append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).append(IOUtils.LINE_SEPARATOR_WINDOWS);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ai */
    public final boolean mo74165ai(String str, long j) {
        if (j <= 0) {
            m86309fO(str, String.valueOf(j));
            return false;
        } else if (j < 3600000) {
            return true;
        } else {
            m86309fO(str, String.valueOf(j));
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aj */
    public final boolean mo74166aj(String str, long j) {
        if (j > 151473600000L) {
            return true;
        }
        m86309fO(str, String.valueOf(j));
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ak */
    public final boolean mo74168ak(String str, long j) {
        if (j > 151473600) {
            return true;
        }
        m86309fO(str, String.valueOf(j));
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: VX */
    public final boolean mo74164VX(String str) {
        if (C5046bo.isNullOrNil(str)) {
            m86309fO("", "check rpt value is null.");
            return false;
        } else if (str.length() < 7168) {
            return true;
        } else {
            m86309fO("", "check rpt value more than 7k.");
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: t */
    public final String mo74169t(String str, String str2, boolean z) {
        if (C5046bo.isNullOrNil(str2) || !str2.contains(",")) {
            return str2;
        }
        if (z && (C5058f.DEBUG || C5058f.IS_FLAVOR_RED)) {
            Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + str + " value:" + str2, false);
        } else {
            m86309fO(str, "value contain comma, please confirm your logic. value :".concat(String.valueOf(str2)));
        }
        return str2.replace(',', ' ');
    }

    protected static boolean getBoolean(String str) {
        if (C5046bo.getInt(str, 0) != 0) {
            return true;
        }
        return false;
    }
}
