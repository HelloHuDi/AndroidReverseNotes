package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String ADN;
    public final String ADO;
    public final String ADP;
    public final String ADQ;
    public final String ADR;
    public final String ADS;
    public final String ADT;
    public final boolean ADU;
    public final String eBb;
    public final String path;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.ADN = str;
        this.path = str2;
        this.ADO = str3;
        this.ADP = str4;
        this.ADS = str5;
        this.ADQ = str6;
        this.ADR = str7;
        this.ADT = str8;
        if (str8.equals("jar")) {
            this.ADU = true;
            if (SharePatchFileUtil.aut(str)) {
                this.eBb = str + ".jar";
            } else {
                this.eBb = str;
            }
        } else if (str8.equals("raw")) {
            this.ADU = false;
            this.eBb = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:".concat(String.valueOf(str8)));
        }
    }

    /* renamed from: o */
    public static void m9346o(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 8);
                    if (split != null && split.length >= 8) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static boolean m9345c(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.ADN;
        String str2 = ShareTinkerInternals.dSp() ? shareDexDiffPatchInfo.ADP : shareDexDiffPatchInfo.ADO;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ADN);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.ADO);
        stringBuffer.append(",");
        stringBuffer.append(this.ADP);
        stringBuffer.append(",");
        stringBuffer.append(this.ADQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ADR);
        stringBuffer.append(",");
        stringBuffer.append(this.ADS);
        stringBuffer.append(",");
        stringBuffer.append(this.ADT);
        return stringBuffer.toString();
    }
}
