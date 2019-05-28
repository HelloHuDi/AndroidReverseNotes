package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ShareResPatchInfo {
    public String AEV = null;
    public String AEW = null;
    public ArrayList<String> AEX = new ArrayList();
    public ArrayList<String> AEY = new ArrayList();
    public ArrayList<String> AEZ = new ArrayList();
    public HashMap<String, File> AFa = new HashMap();
    public ArrayList<String> AFb = new ArrayList();
    public HashMap<String, LargeModeInfo> AFc = new HashMap();
    public HashSet<Pattern> AFd = new HashSet();

    public static class LargeModeInfo {
        public long AFe;
        public String cvZ = null;
        public File file = null;
    }

    public static void a(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
            int i = 0;
            while (i < split.length) {
                String str2 = split[i];
                if (str2 != null && str2.length() > 0) {
                    int i2;
                    if (str2.startsWith("resources_out.zip")) {
                        String[] split2 = str2.split(",", 3);
                        shareResPatchInfo.AEV = split2[1];
                        shareResPatchInfo.AEW = split2[2];
                    } else if (str2.startsWith("pattern:")) {
                        i2 = i;
                        for (int parseInt = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); parseInt > 0; parseInt--) {
                            HashSet hashSet = shareResPatchInfo.AFd;
                            String str3 = split[i2 + 1];
                            if (str3.contains(".")) {
                                str3 = str3.replaceAll("\\.", "\\\\.");
                            }
                            if (str3.contains("?")) {
                                str3 = str3.replaceAll("\\?", "\\.");
                            }
                            if (str3.contains("*")) {
                                str3 = str3.replace("*", ".*");
                            }
                            hashSet.add(Pattern.compile(str3));
                            i2++;
                        }
                        i = i2;
                    } else if (str2.startsWith("add:")) {
                        for (i2 = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.AEX.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("modify:")) {
                        for (i2 = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.AEZ.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("large modify:")) {
                        for (i2 = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); i2 > 0; i2--) {
                            String[] split3 = split[i + 1].split(",", 3);
                            Object obj = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.cvZ = split3[1];
                            largeModeInfo.AFe = Long.parseLong(split3[2]);
                            shareResPatchInfo.AFb.add(obj);
                            shareResPatchInfo.AFc.put(obj, largeModeInfo);
                            i++;
                        }
                    } else if (str2.startsWith("delete:")) {
                        for (i2 = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.AEY.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("store:")) {
                        for (i2 = Integer.parseInt(str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.AFa.put(split[i + 1], null);
                            i++;
                        }
                    }
                }
                i++;
            }
        }
    }

    public static boolean a(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((Pattern) it.next()).matcher(str).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(ShareResPatchInfo shareResPatchInfo) {
        if (shareResPatchInfo == null) {
            return false;
        }
        String str = shareResPatchInfo.AEW;
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static void b(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String str2 = str.split(IOUtils.LINE_SEPARATOR_UNIX)[0];
            if (str2 == null || str2.length() <= 0) {
                throw new TinkerRuntimeException("res meta Corrupted:".concat(String.valueOf(str)));
            }
            String[] split = str2.split(",", 3);
            shareResPatchInfo.AEV = split[1];
            shareResPatchInfo.AEW = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.AEW + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("arscBaseCrc:" + this.AEV + IOUtils.LINE_SEPARATOR_UNIX);
        Iterator it = this.AFd.iterator();
        while (it.hasNext()) {
            stringBuffer.append("pattern:" + ((Pattern) it.next()) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        it = this.AEX.iterator();
        while (it.hasNext()) {
            stringBuffer.append("addedSet:" + ((String) it.next()) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        it = this.AEZ.iterator();
        while (it.hasNext()) {
            stringBuffer.append("modifiedSet:" + ((String) it.next()) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        it = this.AFb.iterator();
        while (it.hasNext()) {
            stringBuffer.append("largeModifiedSet:" + ((String) it.next()) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        it = this.AEY.iterator();
        while (it.hasNext()) {
            stringBuffer.append("deletedSet:" + ((String) it.next()) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        for (String str : this.AFa.keySet()) {
            stringBuffer.append("storeSet:" + str + IOUtils.LINE_SEPARATOR_UNIX);
        }
        return stringBuffer.toString();
    }
}
