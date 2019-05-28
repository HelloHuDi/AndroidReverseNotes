package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.ai */
class C36432ai {
    /* renamed from: a */
    private static C36432ai f15164a = null;
    /* renamed from: b */
    private static Context f15165b = null;

    private C36432ai() {
    }

    /* renamed from: a */
    static C36432ai m60088a(Context context) {
        AppMethodBeat.m2504i(64302);
        if (f15164a == null) {
            synchronized (C36432ai.class) {
                try {
                    if (f15164a == null) {
                        f15164a = new C36432ai();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(64302);
                    }
                }
            }
        }
        f15165b = context.getApplicationContext();
        C36432ai c36432ai = f15164a;
        AppMethodBeat.m2505o(64302);
        return c36432ai;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A:{SYNTHETIC, Splitter:B:15:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC, Splitter:B:21:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A:{SYNTHETIC, Splitter:B:15:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A:{Splitter:B:1:0x0007, ExcHandler: all (r0_13 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:18:0x0036, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:0x0037, code skipped:
            r2 = r0;
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:31:0x004d, code skipped:
            r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private Properties m60089e() {
        AppMethodBeat.m2504i(64305);
        Properties properties;
        BufferedInputStream bufferedInputStream;
        try {
            File a = mo57537a();
            properties = new Properties();
            if (a != null) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a));
                try {
                    properties.load(bufferedInputStream);
                } catch (Exception e) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(64305);
                    return properties;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.m2505o(64305);
                    throw th2;
                }
            }
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(64305);
            return properties;
        } catch (Exception e5) {
            properties = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.m2505o(64305);
            return properties;
        } catch (Throwable th3) {
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public File mo57537a() {
        AppMethodBeat.m2504i(64304);
        C5813an.m8800a();
        File file = new File(C5813an.m8819t(f15165b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                AppMethodBeat.m2505o(64304);
                return null;
            }
        }
        AppMethodBeat.m2505o(64304);
        return file;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo57538a(int i) {
        AppMethodBeat.m2504i(64308);
        mo57541a("dexopt_retry_num", i);
        AppMethodBeat.m2505o(64308);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo57539a(int i, int i2) {
        AppMethodBeat.m2504i(64303);
        mo57541a("copy_core_ver", i);
        mo57541a("copy_status", i2);
        AppMethodBeat.m2505o(64303);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo57540a(String str) {
        AppMethodBeat.m2504i(64310);
        mo57542a("install_apk_path", str);
        AppMethodBeat.m2505o(64310);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo57541a(String str, int i) {
        AppMethodBeat.m2504i(64317);
        mo57542a(str, String.valueOf(i));
        AppMethodBeat.m2505o(64317);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A:{SYNTHETIC, Splitter:B:19:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A:{SYNTHETIC, Splitter:B:27:0x0059} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo57542a(String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        AppMethodBeat.m2504i(64316);
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3;
        try {
            Properties e = m60089e();
            if (e != null) {
                e.setProperty(str, str2);
                File a = mo57537a();
                if (a != null) {
                    fileOutputStream3 = new FileOutputStream(a);
                    try {
                        e.store(fileOutputStream3, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream3;
                    } catch (Exception e2) {
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                                AppMethodBeat.m2505o(64316);
                                return;
                            } catch (IOException e3) {
                                AppMethodBeat.m2505o(64316);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(64316);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.m2505o(64316);
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    AppMethodBeat.m2505o(64316);
                    return;
                } catch (IOException e5) {
                    AppMethodBeat.m2505o(64316);
                    return;
                }
            }
        } catch (Exception e6) {
            fileOutputStream3 = null;
            if (fileOutputStream3 != null) {
            }
            AppMethodBeat.m2505o(64316);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(64316);
            throw th;
        }
        AppMethodBeat.m2505o(64316);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public int mo57543b() {
        AppMethodBeat.m2504i(64306);
        int c = mo57548c("install_core_ver");
        AppMethodBeat.m2505o(64306);
        return c;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public int mo57544b(String str) {
        AppMethodBeat.m2504i(64315);
        Properties e = m60089e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.m2505o(64315);
            return -1;
        }
        int parseInt = Integer.parseInt(e.getProperty(str));
        AppMethodBeat.m2505o(64315);
        return parseInt;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo57545b(int i) {
        AppMethodBeat.m2504i(64309);
        mo57541a("unzip_retry_num", i);
        AppMethodBeat.m2505o(64309);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo57546b(int i, int i2) {
        AppMethodBeat.m2504i(64311);
        mo57541a("install_core_ver", i);
        mo57541a("install_status", i2);
        AppMethodBeat.m2505o(64311);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public int mo57547c() {
        AppMethodBeat.m2504i(64307);
        int b = mo57544b("install_status");
        AppMethodBeat.m2505o(64307);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public int mo57548c(String str) {
        AppMethodBeat.m2504i(64318);
        Properties e = m60089e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.m2505o(64318);
            return 0;
        }
        int parseInt = Integer.parseInt(e.getProperty(str));
        AppMethodBeat.m2505o(64318);
        return parseInt;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo57549c(int i) {
        AppMethodBeat.m2504i(64312);
        mo57541a("incrupdate_status", i);
        AppMethodBeat.m2505o(64312);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public int mo57550d() {
        AppMethodBeat.m2504i(64313);
        int b = mo57544b("incrupdate_status");
        AppMethodBeat.m2505o(64313);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public String mo57551d(String str) {
        AppMethodBeat.m2504i(64319);
        Properties e = m60089e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.m2505o(64319);
            return null;
        }
        String property = e.getProperty(str);
        AppMethodBeat.m2505o(64319);
        return property;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo57552d(int i) {
        AppMethodBeat.m2504i(64314);
        mo57541a("unlzma_status", i);
        AppMethodBeat.m2505o(64314);
    }
}
