package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ShareSecurityCheck {
    private static String AFf = null;
    public final HashMap<String, String> AFg = new HashMap();
    private final HashMap<String, String> AFh = new HashMap();
    private final Context mContext;

    public ShareSecurityCheck(Context context) {
        this.mContext = context;
        if (AFf == null) {
            Context context2 = this.mContext;
            try {
                String cq = SharePatchFileUtil.cq(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 64).signatures[0].toByteArray());
                AFf = cq;
                if (cq == null) {
                    throw new TinkerRuntimeException("get public key md5 is null");
                }
                SharePatchFileUtil.ah(null);
            } catch (Exception e) {
                throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e);
            } catch (Throwable th) {
                SharePatchFileUtil.ah(null);
            }
        }
    }

    public final HashMap<String, String> dSo() {
        if (!this.AFh.isEmpty()) {
            return this.AFh;
        }
        String str = (String) this.AFg.get("assets/package_meta.txt");
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(IOUtils.LINE_SEPARATOR_UNIX)) {
            if (!(str2 == null || str2.length() <= 0 || str2.startsWith("#"))) {
                String[] split = str2.split("=", 2);
                if (split != null && split.length >= 2) {
                    this.AFh.put(split[0].trim(), split[1].trim());
                }
            }
        }
        return this.AFh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089 A:{SYNTHETIC, Splitter:B:38:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089 A:{SYNTHETIC, Splitter:B:38:0x0089} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aw(File file) {
        Throwable e;
        JarFile jarFile;
        if (!SharePatchFileUtil.ap(file)) {
            return false;
        }
        JarFile jarFile2;
        try {
            jarFile2 = new JarFile(file);
            try {
                Enumeration entries = jarFile2.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (jarEntry != null) {
                        String name = jarEntry.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith("meta.txt")) {
                            this.AFg.put(name, SharePatchFileUtil.a(jarFile2, jarEntry));
                            Certificate[] certificates = jarEntry.getCertificates();
                            if (certificates == null || !a(file, certificates)) {
                                try {
                                    jarFile2.close();
                                } catch (IOException e2) {
                                    file.getAbsolutePath();
                                }
                                return false;
                            }
                        }
                    }
                }
                try {
                    jarFile2.close();
                } catch (IOException e3) {
                    file.getAbsolutePath();
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                jarFile = jarFile2;
                try {
                    throw new TinkerRuntimeException(String.format("ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e);
                } catch (Throwable th) {
                    e = th;
                    jarFile2 = jarFile;
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (IOException e5) {
                            file.getAbsolutePath();
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (jarFile2 != null) {
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            jarFile = null;
            throw new TinkerRuntimeException(String.format("ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e);
        } catch (Throwable th3) {
            e = th3;
            jarFile2 = null;
            if (jarFile2 != null) {
            }
            throw e;
        }
    }

    private static boolean a(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            int length = certificateArr.length - 1;
            while (length >= 0) {
                try {
                    if (AFf.equals(SharePatchFileUtil.cq(certificateArr[length].getEncoded()))) {
                        return true;
                    }
                    length--;
                } catch (Exception e) {
                    file.getAbsolutePath();
                }
            }
        }
        return false;
    }
}
