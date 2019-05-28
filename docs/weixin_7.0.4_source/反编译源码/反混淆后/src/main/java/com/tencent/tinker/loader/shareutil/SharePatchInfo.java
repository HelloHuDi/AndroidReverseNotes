package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SharePatchInfo {
    public String ABP;
    public String AES;
    public boolean AET;
    public String AEU;
    public String uWO;

    public SharePatchInfo(String str, String str2, boolean z, String str3, String str4) {
        this.uWO = str;
        this.AES = str2;
        this.AET = z;
        this.AEU = str3;
        this.ABP = str4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A:{SYNTHETIC, Splitter:B:22:0x0030} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    public static SharePatchInfo m9392l(File file, File file2) {
        ShareFileLockHelper ao;
        Throwable e;
        SharePatchInfo sharePatchInfo = null;
        if (!(file == null || file2 == null)) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                ao = ShareFileLockHelper.m9351ao(file2);
                try {
                    sharePatchInfo = m9391av(file);
                    try {
                        ao.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                ao = null;
            } catch (Throwable th) {
                e = th;
                ao = null;
                if (ao != null) {
                    try {
                        ao.close();
                    } catch (IOException e5) {
                    }
                }
                throw e;
            }
        }
        return sharePatchInfo;
        try {
            throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
        } catch (Throwable e32) {
            e = e32;
            if (ao != null) {
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static boolean m9390a(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.m9351ao(file2);
            boolean a = m9389a(file, sharePatchInfo);
            try {
                shareFileLockHelper.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (Exception e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: av */
    private static SharePatchInfo m9391av(File file) {
        Object e;
        Throwable th;
        String str = null;
        boolean z = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        Object obj = null;
        while (i < 2 && obj == null) {
            int i2 = i + 1;
            Properties properties = new Properties();
            Object fileInputStream;
            String property;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    property = properties.getProperty("old");
                    try {
                        str3 = properties.getProperty("new");
                        z = !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(properties.getProperty("is_remove_new_version"));
                        str2 = properties.getProperty("print");
                        str = properties.getProperty("dir");
                        SharePatchFileUtil.m9369ah(fileInputStream);
                        str4 = property;
                    } catch (IOException e2) {
                        IOException e3 = e2;
                        try {
                            new StringBuilder("read property failed, e:").append(e3);
                            SharePatchFileUtil.m9369ah(fileInputStream);
                            str4 = property;
                            if (str4 != null) {
                            }
                            i = i2;
                        } catch (Throwable th2) {
                            th = th2;
                            SharePatchFileUtil.m9369ah(fileInputStream);
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    e3 = e4;
                    property = str4;
                }
            } catch (IOException e5) {
                e3 = e5;
                fileInputStream = null;
                property = str4;
                new StringBuilder("read property failed, e:").append(e3);
                SharePatchFileUtil.m9369ah(fileInputStream);
                str4 = property;
                if (str4 != null) {
                }
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                SharePatchFileUtil.m9369ah(fileInputStream);
                throw th;
            }
            if (str4 != null || str3 == null) {
                i = i2;
            } else if ((str4.equals("") || SharePatchFileUtil.aus(str4)) && SharePatchFileUtil.aus(str3)) {
                i = i2;
                obj = 1;
            } else {
                new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                i = i2;
            }
        }
        if (obj != null) {
            return new SharePatchInfo(str4, str3, z, str2, str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0107 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0107 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m9389a(File file, SharePatchInfo sharePatchInfo) {
        Object e;
        SharePatchInfo av;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        int i;
        if (ShareTinkerInternals.isNullOrNil(sharePatchInfo.AEU)) {
            sharePatchInfo.AEU = Build.FINGERPRINT;
        }
        if (ShareTinkerInternals.isNullOrNil(sharePatchInfo.ABP)) {
            sharePatchInfo.ABP = "odex";
        }
        StringBuilder append = new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.uWO).append(", newVer:").append(sharePatchInfo.AES).append(", isRemoveNewVersion:");
        if (sharePatchInfo.AET) {
            i = 1;
        } else {
            i = 0;
        }
        append.append(i).append(", fingerprint:").append(sharePatchInfo.AEU).append(", oatDir:").append(sharePatchInfo.ABP);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        i = 0;
        boolean z = false;
        while (i < 2 && !z) {
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put("old", sharePatchInfo.uWO);
            properties.put("new", sharePatchInfo.AES);
            properties.put("is_remove_new_version", sharePatchInfo.AET ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            properties.put("print", sharePatchInfo.AEU);
            properties.put("dir", sharePatchInfo.ABP);
            Object fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from old version:" + sharePatchInfo.uWO + " to new version:" + sharePatchInfo.AES);
                    SharePatchFileUtil.m9369ah(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("write property failed, e:").append(e);
                        SharePatchFileUtil.m9369ah(fileOutputStream);
                        av = m9391av(file);
                        if (av == null) {
                        }
                        z = false;
                        if (z) {
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        SharePatchFileUtil.m9369ah(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                new StringBuilder("write property failed, e:").append(e);
                SharePatchFileUtil.m9369ah(fileOutputStream);
                av = m9391av(file);
                if (av == null) {
                }
                z = false;
                if (z) {
                }
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                SharePatchFileUtil.m9369ah(fileOutputStream);
                throw th;
            }
            av = m9391av(file);
            if (av == null && av.uWO.equals(sharePatchInfo.uWO) && av.AES.equals(sharePatchInfo.AES)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                file.delete();
            }
            i = i2;
        }
        if (z) {
            return true;
        }
        return false;
    }
}
