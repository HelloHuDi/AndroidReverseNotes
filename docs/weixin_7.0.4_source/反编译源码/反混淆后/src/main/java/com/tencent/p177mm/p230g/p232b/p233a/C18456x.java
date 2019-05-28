package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.x */
public final class C18456x extends C46180a {
    private String cVA = "";
    private String cVC = "";
    private long cVD = 0;
    private long cVE = 0;
    private String cVM = "";
    private String cVQ = "";
    private String cVw = "";
    private String cVx = "";
    private String cVz = "";
    private long cYf = 0;
    private long cYg = 0;
    private int cYh = 0;
    private long cYi = 0;
    private long cYj = 0;

    public C18456x(String str) {
        AppMethodBeat.m2504i(50537);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 14) {
                    strArr = new String[14];
                    Arrays.fill(strArr, 0, 14, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this.cVD = C5046bo.getLong(strArr[0], 0);
                this.cVE = C5046bo.getLong(strArr[1], 0);
                this.cYf = C5046bo.getLong(strArr[2], 0);
                this.cVC = mo74169t("NewMd5", strArr[3], true);
                this.cYg = C5046bo.getLong(strArr[4], 0);
                this.cYh = C5046bo.getInt(strArr[5], 0);
                this.cYi = C5046bo.getLong(strArr[6], 0);
                this.cVM = mo74169t("CDNIp", strArr[7], true);
                this.cVw = mo74169t("FromUser", strArr[8], true);
                this.cVx = mo74169t("Session", strArr[9], true);
                this.cYj = C5046bo.getLong(strArr[10], 0);
                this.cVz = mo74169t("FileId", strArr[11], true);
                this.cVA = mo74169t("SnsUrl", strArr[12], true);
                this.cVQ = mo74169t("Publishid", strArr[13], true);
            }
        }
        AppMethodBeat.m2505o(50537);
    }

    public final int getId() {
        return 14499;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(50538);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVD);
        stringBuffer.append(str);
        stringBuffer.append(this.cVE);
        stringBuffer.append(str);
        stringBuffer.append(this.cYf);
        stringBuffer.append(str);
        stringBuffer.append(this.cVC);
        stringBuffer.append(str);
        stringBuffer.append(this.cYg);
        stringBuffer.append(str);
        stringBuffer.append(this.cYh);
        stringBuffer.append(str);
        stringBuffer.append(this.cYi);
        stringBuffer.append(str);
        stringBuffer.append(this.cVM);
        stringBuffer.append(str);
        stringBuffer.append(this.cVw);
        stringBuffer.append(str);
        stringBuffer.append(this.cVx);
        stringBuffer.append(str);
        stringBuffer.append(this.cYj);
        stringBuffer.append(str);
        stringBuffer.append(this.cVz);
        stringBuffer.append(str);
        stringBuffer.append(this.cVA);
        stringBuffer.append(str);
        stringBuffer.append(this.cVQ);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(50538);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(50539);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DownloadStartTime:").append(this.cVD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadEndTime:").append(this.cVE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadSize:").append(this.cYf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewMd5:").append(this.cVC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgType:").append(this.cYg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadSpeed:").append(this.cYh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadFinishSize:").append(this.cYi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CDNIp:").append(this.cVM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FromUser:").append(this.cVw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Session:").append(this.cVx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ChatroomNum:").append(this.cYj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FileId:").append(this.cVz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SnsUrl:").append(this.cVA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Publishid:").append(this.cVQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(50539);
        return stringBuffer2;
    }
}
