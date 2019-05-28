package com.tencent.tinker.lib.util;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class c {
    private static c ACm;
    public boolean ACn = true;
    public File ACo = null;
    public File ACp = null;
    public int ACq = 5;
    private Context context = null;

    public static class a {
        public String ACr;
        public String cvZ;

        public a(String str, String str2) {
            this.cvZ = str;
            this.ACr = str2;
        }

        public static a am(File file) {
            String property;
            Object e;
            Throwable th;
            String str = null;
            Properties properties = new Properties();
            Object fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    property = properties.getProperty("md5");
                    try {
                        str = properties.getProperty("times");
                        com.tencent.tinker.c.b.a.ah(fileInputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e)), new Object[0]);
                            com.tencent.tinker.c.b.a.ah(fileInputStream);
                            return new a(property, str);
                        } catch (Throwable th2) {
                            th = th2;
                            com.tencent.tinker.c.b.a.ah(fileInputStream);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    property = str;
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream = str;
                property = str;
                a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e)), new Object[0]);
                com.tencent.tinker.c.b.a.ah(fileInputStream);
                return new a(property, str);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = str;
                com.tencent.tinker.c.b.a.ah(fileInputStream);
                throw th;
            }
            return new a(property, str);
        }

        public static void a(File file, a aVar) {
            Throwable e;
            if (aVar != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put("md5", aVar.cvZ);
                properties.put("times", aVar.ACr);
                Object fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, null);
                        com.tencent.tinker.c.b.a.ah(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                            com.tencent.tinker.c.b.a.ah(fileOutputStream);
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.tinker.c.b.a.ah(fileOutputStream);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                    com.tencent.tinker.c.b.a.ah(fileOutputStream);
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    com.tencent.tinker.c.b.a.ah(fileOutputStream);
                    throw e;
                }
            }
        }
    }

    private c(Context context) {
        this.context = context;
        this.ACo = new File(SharePatchFileUtil.ji(context), "patch.retry");
        this.ACp = new File(SharePatchFileUtil.ji(context), "temp.apk");
    }

    public static c jc(Context context) {
        if (ACm == null) {
            ACm = new c(context);
        }
        return ACm;
    }

    public final boolean dSj() {
        if (!this.ACn) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!com.tencent.tinker.lib.e.a.iX(this.context).rNw) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.ACo.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (b.iZ(this.context)) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.ACp.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
                return false;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", absolutePath);
            com.tencent.tinker.lib.e.c.cf(this.context, absolutePath);
            return true;
        }
    }

    public final boolean auk(String str) {
        if (!this.ACn) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.ACo.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            a am = a.am(this.ACo);
            if (!str.equals(am.cvZ) || Integer.parseInt(am.ACr) < this.ACq) {
                return true;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(Integer.parseInt(am.ACr)));
            SharePatchFileUtil.as(this.ACp);
            return false;
        }
    }

    public final void al(File file) {
        if (!file.getAbsolutePath().equals(this.ACp.getAbsolutePath())) {
            a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", file.getAbsolutePath(), this.ACp.getAbsolutePath());
            try {
                SharePatchFileUtil.j(file, this.ACp);
            } catch (IOException e) {
                a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", file.getAbsolutePath(), this.ACp.getAbsolutePath());
            }
        }
    }
}
