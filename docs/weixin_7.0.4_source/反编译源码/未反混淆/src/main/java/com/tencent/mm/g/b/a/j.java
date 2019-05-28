package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class j extends a {
    private String cVA = "";
    private int cVB = 0;
    private String cVC = "";
    private long cVD = 0;
    private long cVE = 0;
    private long cVF = 0;
    private long cVG = 0;
    private long cVH = 0;
    private long cVI = 0;
    private long cVJ = 0;
    private long cVK = 0;
    private long cVL = 0;
    private String cVM = "";
    private long cVN = 0;
    private long cVO = 0;
    private long cVP = 0;
    private String cVQ = "";
    private String cVw = "";
    private String cVx = "";
    private long cVy = 0;
    private String cVz = "";

    public j(String str) {
        AppMethodBeat.i(50531);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 21) {
                    strArr = new String[21];
                    Arrays.fill(strArr, 0, 21, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this.cVw = t("FromUser", strArr[0], true);
                this.cVx = t("Session", strArr[1], true);
                this.cVy = bo.getLong(strArr[2], 0);
                this.cVz = t("FileId", strArr[3], true);
                this.cVA = t("SnsUrl", strArr[4], true);
                this.cVB = bo.getInt(strArr[5], 0);
                this.cVC = t("NewMd5", strArr[6], true);
                this.cVD = bo.getLong(strArr[7], 0);
                this.cVE = bo.getLong(strArr[8], 0);
                this.cVF = bo.getLong(strArr[9], 0);
                this.cVG = bo.getLong(strArr[10], 0);
                this.cVH = bo.getLong(strArr[11], 0);
                this.cVI = bo.getLong(strArr[12], 0);
                this.cVJ = bo.getLong(strArr[13], 0);
                this.cVK = bo.getLong(strArr[14], 0);
                this.cVL = bo.getLong(strArr[15], 0);
                this.cVM = t("CDNIp", strArr[16], true);
                this.cVN = bo.getLong(strArr[17], 0);
                this.cVO = bo.getLong(strArr[18], 0);
                this.cVP = bo.getLong(strArr[19], 0);
                this.cVQ = t("Publishid", strArr[20], true);
            }
        }
        AppMethodBeat.o(50531);
    }

    public final int getId() {
        return 13795;
    }

    public final String Fj() {
        AppMethodBeat.i(50532);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVw);
        stringBuffer.append(str);
        stringBuffer.append(this.cVx);
        stringBuffer.append(str);
        stringBuffer.append(this.cVy);
        stringBuffer.append(str);
        stringBuffer.append(this.cVz);
        stringBuffer.append(str);
        stringBuffer.append(this.cVA);
        stringBuffer.append(str);
        stringBuffer.append(this.cVB);
        stringBuffer.append(str);
        stringBuffer.append(this.cVC);
        stringBuffer.append(str);
        stringBuffer.append(this.cVD);
        stringBuffer.append(str);
        stringBuffer.append(this.cVE);
        stringBuffer.append(str);
        stringBuffer.append(this.cVF);
        stringBuffer.append(str);
        stringBuffer.append(this.cVG);
        stringBuffer.append(str);
        stringBuffer.append(this.cVH);
        stringBuffer.append(str);
        stringBuffer.append(this.cVI);
        stringBuffer.append(str);
        stringBuffer.append(this.cVJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cVK);
        stringBuffer.append(str);
        stringBuffer.append(this.cVL);
        stringBuffer.append(str);
        stringBuffer.append(this.cVM);
        stringBuffer.append(str);
        stringBuffer.append(this.cVN);
        stringBuffer.append(str);
        stringBuffer.append(this.cVO);
        stringBuffer.append(str);
        stringBuffer.append(this.cVP);
        stringBuffer.append(str);
        stringBuffer.append(this.cVQ);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(50532);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(50533);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FromUser:").append(this.cVw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Session:").append(this.cVx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ChatNum:").append(this.cVy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FileId:").append(this.cVz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SnsUrl:").append(this.cVA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetType:").append(this.cVB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewMd5:").append(this.cVC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadStartTime:").append(this.cVD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadEndTime:").append(this.cVE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoSize:").append(this.cVF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoDuration:").append(this.cVG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoBitrate:").append(this.cVH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AudioBitrate:").append(this.cVI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoFps:").append(this.cVJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoWidth:").append(this.cVK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoHeight:").append(this.cVL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CDNIp:").append(this.cVM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginalAudioChannel:").append(this.cVN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadPreloadSize:").append(this.cVO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadPreloadCompletion:").append(this.cVP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Publishid:").append(this.cVQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(50533);
        return stringBuffer2;
    }
}
