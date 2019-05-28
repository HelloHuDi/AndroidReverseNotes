package com.tencent.tinker.loader.shareutil;

import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;

public class ShareBsDiffPatchInfo {
    public String ADL;
    public String cdy;
    public String cvZ;
    public String name;
    public String path;

    private ShareBsDiffPatchInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.cvZ = str2;
        this.ADL = str4;
        this.cdy = str5;
        this.path = str3;
    }

    /* renamed from: n */
    public static void m9344n(String str, ArrayList<ShareBsDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 5);
                    if (split != null && split.length >= 5) {
                        arrayList.add(new ShareBsDiffPatchInfo(split[0].trim(), split[2].trim(), split[1].trim(), split[3].trim(), split[4].trim()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m9343a(ShareBsDiffPatchInfo shareBsDiffPatchInfo) {
        if (shareBsDiffPatchInfo == null) {
            return false;
        }
        String str = shareBsDiffPatchInfo.name;
        String str2 = shareBsDiffPatchInfo.cvZ;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.cvZ);
        stringBuffer.append(",");
        stringBuffer.append(this.ADL);
        stringBuffer.append(",");
        stringBuffer.append(this.cdy);
        return stringBuffer.toString();
    }
}
