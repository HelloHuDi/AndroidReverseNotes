package com.tencent.tinker.lib.util;

import android.content.Context;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C46818c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.p673c.p1516b.C36549a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.tinker.lib.util.c */
public final class C41089c {
    private static C41089c ACm;
    public boolean ACn = true;
    public File ACo = null;
    public File ACp = null;
    public int ACq = 5;
    private Context context = null;

    /* renamed from: com.tencent.tinker.lib.util.c$a */
    public static class C5954a {
        public String ACr;
        public String cvZ;

        public C5954a(String str, String str2) {
            this.cvZ = str;
            this.ACr = str2;
        }

        /* renamed from: am */
        public static C5954a m9290am(File file) {
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
                        C36549a.m60575ah(fileInputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            C5952a.m9283e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e)), new Object[0]);
                            C36549a.m60575ah(fileInputStream);
                            return new C5954a(property, str);
                        } catch (Throwable th2) {
                            th = th2;
                            C36549a.m60575ah(fileInputStream);
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
                C5952a.m9283e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e)), new Object[0]);
                C36549a.m60575ah(fileInputStream);
                return new C5954a(property, str);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = str;
                C36549a.m60575ah(fileInputStream);
                throw th;
            }
            return new C5954a(property, str);
        }

        /* renamed from: a */
        public static void m9289a(File file, C5954a c5954a) {
            Throwable e;
            if (c5954a != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put("md5", c5954a.cvZ);
                properties.put("times", c5954a.ACr);
                Object fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, null);
                        C36549a.m60575ah(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C5952a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                            C36549a.m60575ah(fileOutputStream);
                        } catch (Throwable th) {
                            e = th;
                            C36549a.m60575ah(fileOutputStream);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    C5952a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                    C36549a.m60575ah(fileOutputStream);
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    C36549a.m60575ah(fileOutputStream);
                    throw e;
                }
            }
        }
    }

    private C41089c(Context context) {
        this.context = context;
        this.ACo = new File(SharePatchFileUtil.m9384ji(context), "patch.retry");
        this.ACp = new File(SharePatchFileUtil.m9384ji(context), "temp.apk");
    }

    /* renamed from: jc */
    public static C41089c m71517jc(Context context) {
        if (ACm == null) {
            ACm = new C41089c(context);
        }
        return ACm;
    }

    public final boolean dSj() {
        if (!this.ACn) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!C31097a.m50180iX(this.context).rNw) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.ACo.exists()) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (C31098b.m50187iZ(this.context)) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.ACp.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
                return false;
            }
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", absolutePath);
            C46818c.m89042cf(this.context, absolutePath);
            return true;
        }
    }

    public final boolean auk(String str) {
        if (!this.ACn) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.ACo.exists()) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            C5954a am = C5954a.m9290am(this.ACo);
            if (!str.equals(am.cvZ) || Integer.parseInt(am.ACr) < this.ACq) {
                return true;
            }
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(Integer.parseInt(am.ACr)));
            SharePatchFileUtil.m9373as(this.ACp);
            return false;
        }
    }

    /* renamed from: al */
    public final void mo65179al(File file) {
        if (!file.getAbsolutePath().equals(this.ACp.getAbsolutePath())) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", file.getAbsolutePath(), this.ACp.getAbsolutePath());
            try {
                SharePatchFileUtil.m9382j(file, this.ACp);
            } catch (IOException e) {
                C5952a.m9283e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", file.getAbsolutePath(), this.ACp.getAbsolutePath());
            }
        }
    }
}
