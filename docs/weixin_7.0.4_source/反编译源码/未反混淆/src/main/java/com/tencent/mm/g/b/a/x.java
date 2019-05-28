package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class x extends a {
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

    public x(String str) {
        AppMethodBeat.i(50537);
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
                this.cVD = bo.getLong(strArr[0], 0);
                this.cVE = bo.getLong(strArr[1], 0);
                this.cYf = bo.getLong(strArr[2], 0);
                this.cVC = t("NewMd5", strArr[3], true);
                this.cYg = bo.getLong(strArr[4], 0);
                this.cYh = bo.getInt(strArr[5], 0);
                this.cYi = bo.getLong(strArr[6], 0);
                this.cVM = t("CDNIp", strArr[7], true);
                this.cVw = t("FromUser", strArr[8], true);
                this.cVx = t("Session", strArr[9], true);
                this.cYj = bo.getLong(strArr[10], 0);
                this.cVz = t("FileId", strArr[11], true);
                this.cVA = t("SnsUrl", strArr[12], true);
                this.cVQ = t("Publishid", strArr[13], true);
            }
        }
        AppMethodBeat.o(50537);
    }

    public final int getId() {
        return 14499;
    }

    public final String Fj() {
        AppMethodBeat.i(50538);
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
        VX(str);
        AppMethodBeat.o(50538);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(50539);
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
        AppMethodBeat.o(50539);
        return stringBuffer2;
    }
}
