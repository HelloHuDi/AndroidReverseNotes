package com.tencent.p177mm.p230g.p232b.p233a;

import android.support.p056d.C0252a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.p */
public final class C32675p extends C46180a {
    private String _ID = "";
    private long cVR = 0;
    private long cWA = 0;
    private String cWB = "";
    private String cWC = "";
    private long cWD = 0;
    private long cWE = 0;
    private String cWF = "";
    private String cWG = "";
    public long cWH = 0;
    private long cWI = 0;
    private long cWJ = 0;
    private String cWK = "";
    private String cWL = "";
    private String cWM = "";
    private long cWN = 0;
    private String cWO = "";
    private String cWP = "";
    private String cWQ = "";
    private long cWu = 0;
    private long cWv = 0;
    private long cWw = 0;
    private long cWx = 0;
    private long cWy = 0;
    private long cWz = 0;

    public C32675p(String str) {
        AppMethodBeat.m2504i(35556);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 25) {
                    strArr = new String[25];
                    Arrays.fill(strArr, 0, 25, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this._ID = mo74169t("ID", strArr[0], true);
                this.cWu = C5046bo.getLong(strArr[1], 0);
                this.cWv = C5046bo.getLong(strArr[2], 0);
                this.cWw = C5046bo.getLong(strArr[3], 0);
                this.cWx = C5046bo.getLong(strArr[4], 0);
                this.cWy = C5046bo.getLong(strArr[5], 0);
                this.cWz = C5046bo.getLong(strArr[6], 0);
                this.cWA = C5046bo.getLong(strArr[7], 0);
                this.cWB = mo74169t(C0252a.TAG_F_NUMBER, strArr[8], true);
                this.cWC = mo74169t(C0252a.TAG_EXPOSURE_TIME, strArr[9], true);
                this.cWD = C5046bo.getLong(strArr[10], 0);
                this.cWE = C5046bo.getLong(strArr[11], 0);
                this.cWF = mo74169t(C0252a.TAG_LENS_MODEL, strArr[12], true);
                this.cWG = mo74169t("CreatTime", strArr[13], true);
                this.cWH = C5046bo.getLong(strArr[14], 0);
                this.cVR = C5046bo.getLong(strArr[15], 0);
                this.cWI = C5046bo.getLong(strArr[16], 0);
                this.cWJ = C5046bo.getLong(strArr[17], 0);
                this.cWK = mo74169t("make", strArr[18], true);
                this.cWL = mo74169t("software", strArr[19], true);
                this.cWM = mo74169t("fileExt", strArr[20], true);
                this.cWN = C5046bo.getLong(strArr[21], 0);
                this.cWO = mo74169t(C0252a.TAG_Y_CB_CR_SUB_SAMPLING, strArr[22], true);
                this.cWP = mo74169t("md5", strArr[23], true);
                mo53207eM(strArr[24]);
            }
        }
        AppMethodBeat.m2505o(35556);
    }

    public final int getId() {
        return 16585;
    }

    /* renamed from: eM */
    public final C32675p mo53207eM(String str) {
        AppMethodBeat.m2504i(35557);
        this.cWQ = mo74169t("publishId", str, true);
        AppMethodBeat.m2505o(35557);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(35558);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this._ID);
        stringBuffer.append(str);
        stringBuffer.append(this.cWu);
        stringBuffer.append(str);
        stringBuffer.append(this.cWv);
        stringBuffer.append(str);
        stringBuffer.append(this.cWw);
        stringBuffer.append(str);
        stringBuffer.append(this.cWx);
        stringBuffer.append(str);
        stringBuffer.append(this.cWy);
        stringBuffer.append(str);
        stringBuffer.append(this.cWz);
        stringBuffer.append(str);
        stringBuffer.append(this.cWA);
        stringBuffer.append(str);
        stringBuffer.append(this.cWB);
        stringBuffer.append(str);
        stringBuffer.append(this.cWC);
        stringBuffer.append(str);
        stringBuffer.append(this.cWD);
        stringBuffer.append(str);
        stringBuffer.append(this.cWE);
        stringBuffer.append(str);
        stringBuffer.append(this.cWF);
        stringBuffer.append(str);
        stringBuffer.append(this.cWG);
        stringBuffer.append(str);
        stringBuffer.append(this.cWH);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWI);
        stringBuffer.append(str);
        stringBuffer.append(this.cWJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cWK);
        stringBuffer.append(str);
        stringBuffer.append(this.cWL);
        stringBuffer.append(str);
        stringBuffer.append(this.cWM);
        stringBuffer.append(str);
        stringBuffer.append(this.cWN);
        stringBuffer.append(str);
        stringBuffer.append(this.cWO);
        stringBuffer.append(str);
        stringBuffer.append(this.cWP);
        stringBuffer.append(str);
        stringBuffer.append(this.cWQ);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(35558);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(35559);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ID:").append(this._ID);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MediaType:").append(this.cWu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginWidth:").append(this.cWv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginHeight:").append(this.cWw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CompressedWidth:").append(this.cWx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CompressedHeight:").append(this.cWy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginSize:").append(this.cWz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CompressedSize:").append(this.cWA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FNumber:").append(this.cWB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposureTime:").append(this.cWC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ISO:").append(this.cWD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Flash:").append(this.cWE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("LensModel:").append(this.cWF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CreatTime:").append(this.cWG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsFromWeChat:").append(this.cWH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sceneType:").append(this.cWI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("fileSource:").append(this.cWJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("make:").append(this.cWK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("software:").append(this.cWL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("fileExt:").append(this.cWM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("faceCount:").append(this.cWN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("YCbCrSubSampling:").append(this.cWO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("md5:").append(this.cWP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("publishId:").append(this.cWQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(35559);
        return stringBuffer2;
    }
}
