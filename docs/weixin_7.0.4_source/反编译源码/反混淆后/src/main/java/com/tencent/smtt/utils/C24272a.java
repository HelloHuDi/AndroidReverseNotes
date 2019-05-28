package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/* renamed from: com.tencent.smtt.utils.a */
public class C24272a {
    /* renamed from: a */
    public static int m37432a(Context context, File file) {
        boolean z = false;
        AppMethodBeat.m2504i(65165);
        if (VERSION.SDK_INT >= 23 && !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME)) {
            z = true;
        }
        int a = C24272a.m37433a(context, file, z);
        AppMethodBeat.m2505o(65165);
        return a;
    }

    /* renamed from: a */
    public static int m37433a(Context context, File file, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(65167);
        if (file != null) {
            try {
                if (file.exists()) {
                    int c;
                    if (file.getName().contains("tbs.org")) {
                        c = C24272a.m37437c(file);
                        if (c > 0) {
                            AppMethodBeat.m2505o(65167);
                            return c;
                        } else if (TbsConfig.APP_QQ.equals(context.getApplicationInfo().packageName) && (file.getAbsolutePath().contains("com.tencent.mm") || file.getAbsolutePath().contains(TbsConfig.APP_QZONE))) {
                            AppMethodBeat.m2505o(65167);
                            return 0;
                        }
                    }
                    c = ((VERSION.SDK_INT == 23 || VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi")) ? 1 : 0;
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        c = 0;
                        z = false;
                    } else if (readApk == 2) {
                        AppMethodBeat.m2505o(65167);
                        return 0;
                    }
                    if (z || r1 != 0) {
                        c = C24272a.m37436b(file);
                        if (c > 0) {
                            AppMethodBeat.m2505o(65167);
                            return c;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        if (file != null && file.exists()) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
                if (packageArchiveInfo != null) {
                    i = packageArchiveInfo.versionCode;
                }
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(65167);
                return -1;
            }
        }
        AppMethodBeat.m2505o(65167);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A:{SYNTHETIC, Splitter:B:13:0x0033} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A:{SYNTHETIC, Splitter:B:28:0x006d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m37434a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(65164);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream2;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                int i = 0;
                int i2 = 0;
                while (i < 16) {
                    byte b = digest[i];
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b >>> 4) & 15];
                    int i4 = i3 + 1;
                    cArr2[i3] = cArr[b & 15];
                    i++;
                    i2 = i4;
                }
                String str = new String(cArr2);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(65164);
                return str;
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(65164);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(65164);
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(65164);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
            }
            AppMethodBeat.m2505o(65164);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m37435a(Context context, File file, long j, int i) {
        AppMethodBeat.m2504i(65163);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(65163);
            return false;
        } else if (j <= 0 || j == file.length()) {
            try {
                if (i != C24272a.m37432a(context, file)) {
                    AppMethodBeat.m2505o(65163);
                    return false;
                }
                if ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(C36443b.m60180a(context, true, file))) {
                    AppMethodBeat.m2505o(65163);
                    return true;
                }
                AppMethodBeat.m2505o(65163);
                return false;
            } catch (Exception e) {
                AppMethodBeat.m2505o(65163);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(65163);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079 A:{SYNTHETIC, Splitter:B:40:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A:{Catch:{ Exception -> 0x0092 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A:{SYNTHETIC, Splitter:B:27:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A:{Catch:{ Exception -> 0x0096 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079 A:{SYNTHETIC, Splitter:B:40:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A:{Catch:{ Exception -> 0x0092 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A:{SYNTHETIC, Splitter:B:27:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A:{Catch:{ Exception -> 0x0096 }} */
    /* JADX WARNING: Missing block: B:15:0x0040, code skipped:
            r0 = java.lang.Integer.parseInt(r0[1].trim());
     */
    /* JADX WARNING: Missing block: B:16:0x004b, code skipped:
            if (r1 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:19:0x0050, code skipped:
            if (r3 == null) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:20:0x0052, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:36:0x0070, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(65168);
     */
    /* JADX WARNING: Missing block: B:48:0x0087, code skipped:
            if (r1 == null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:51:0x008c, code skipped:
            if (r3 == null) goto L_0x0081;
     */
    /* JADX WARNING: Missing block: B:52:0x008e, code skipped:
            r3.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static int m37436b(File file) {
        BufferedReader bufferedReader;
        int i;
        Throwable th;
        AppMethodBeat.m2504i(65168);
        synchronized (C24272a.class) {
            JarFile jarFile;
            BufferedReader bufferedReader2;
            try {
                jarFile = new JarFile(file);
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("tbs_core_version")) {
                                String[] split = readLine.split("=");
                                if (split != null && split.length == 2) {
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                            }
                            if (jarFile != null) {
                            }
                            i = -1;
                            AppMethodBeat.m2505o(65168);
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader2 != null) {
                            }
                            if (jarFile != null) {
                            }
                            AppMethodBeat.m2505o(65168);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (jarFile != null) {
                    }
                    i = -1;
                    AppMethodBeat.m2505o(65168);
                    return i;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = null;
                    if (bufferedReader2 != null) {
                    }
                    if (jarFile != null) {
                    }
                    AppMethodBeat.m2505o(65168);
                    throw th;
                }
            } catch (Exception e3) {
                bufferedReader = null;
                jarFile = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        i = -1;
                        AppMethodBeat.m2505o(65168);
                        return i;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                i = -1;
                AppMethodBeat.m2505o(65168);
                return i;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                jarFile = null;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e5) {
                        AppMethodBeat.m2505o(65168);
                        throw th;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                AppMethodBeat.m2505o(65168);
                throw th;
            }
        }
        return i;
    }

    /* renamed from: c */
    private static int m37437c(File file) {
        AppMethodBeat.m2504i(65166);
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                File[] listFiles = parentFile.listFiles();
                Pattern compile = Pattern.compile("x5.backup(.*)");
                int parseInt;
                for (File file2 : listFiles) {
                    if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        parseInt = Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                        AppMethodBeat.m2505o(65166);
                        return parseInt;
                    }
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(65166);
        return -1;
    }
}
