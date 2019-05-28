package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class ai {
    private static ai a = null;
    private static Context b = null;

    private ai() {
    }

    static ai a(Context context) {
        AppMethodBeat.i(64302);
        if (a == null) {
            synchronized (ai.class) {
                try {
                    if (a == null) {
                        a = new ai();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(64302);
                    }
                }
            }
        }
        b = context.getApplicationContext();
        ai aiVar = a;
        AppMethodBeat.o(64302);
        return aiVar;
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
    private Properties e() {
        AppMethodBeat.i(64305);
        Properties properties;
        BufferedInputStream bufferedInputStream;
        try {
            File a = a();
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
                    AppMethodBeat.o(64305);
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
                    AppMethodBeat.o(64305);
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
            AppMethodBeat.o(64305);
            return properties;
        } catch (Exception e5) {
            properties = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.o(64305);
            return properties;
        } catch (Throwable th3) {
        }
    }

    /* Access modifiers changed, original: 0000 */
    public File a() {
        AppMethodBeat.i(64304);
        an.a();
        File file = new File(an.t(b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                AppMethodBeat.o(64304);
                return null;
            }
        }
        AppMethodBeat.o(64304);
        return file;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        AppMethodBeat.i(64308);
        a("dexopt_retry_num", i);
        AppMethodBeat.o(64308);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, int i2) {
        AppMethodBeat.i(64303);
        a("copy_core_ver", i);
        a("copy_status", i2);
        AppMethodBeat.o(64303);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str) {
        AppMethodBeat.i(64310);
        a("install_apk_path", str);
        AppMethodBeat.o(64310);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, int i) {
        AppMethodBeat.i(64317);
        a(str, String.valueOf(i));
        AppMethodBeat.o(64317);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A:{SYNTHETIC, Splitter:B:19:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A:{SYNTHETIC, Splitter:B:27:0x0059} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        AppMethodBeat.i(64316);
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3;
        try {
            Properties e = e();
            if (e != null) {
                e.setProperty(str, str2);
                File a = a();
                if (a != null) {
                    fileOutputStream3 = new FileOutputStream(a);
                    try {
                        e.store(fileOutputStream3, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream3;
                    } catch (Exception e2) {
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                                AppMethodBeat.o(64316);
                                return;
                            } catch (IOException e3) {
                                AppMethodBeat.o(64316);
                                return;
                            }
                        }
                        AppMethodBeat.o(64316);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.o(64316);
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    AppMethodBeat.o(64316);
                    return;
                } catch (IOException e5) {
                    AppMethodBeat.o(64316);
                    return;
                }
            }
        } catch (Exception e6) {
            fileOutputStream3 = null;
            if (fileOutputStream3 != null) {
            }
            AppMethodBeat.o(64316);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(64316);
            throw th;
        }
        AppMethodBeat.o(64316);
    }

    /* Access modifiers changed, original: 0000 */
    public int b() {
        AppMethodBeat.i(64306);
        int c = c("install_core_ver");
        AppMethodBeat.o(64306);
        return c;
    }

    /* Access modifiers changed, original: 0000 */
    public int b(String str) {
        AppMethodBeat.i(64315);
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.o(64315);
            return -1;
        }
        int parseInt = Integer.parseInt(e.getProperty(str));
        AppMethodBeat.o(64315);
        return parseInt;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        AppMethodBeat.i(64309);
        a("unzip_retry_num", i);
        AppMethodBeat.o(64309);
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i, int i2) {
        AppMethodBeat.i(64311);
        a("install_core_ver", i);
        a("install_status", i2);
        AppMethodBeat.o(64311);
    }

    /* Access modifiers changed, original: 0000 */
    public int c() {
        AppMethodBeat.i(64307);
        int b = b("install_status");
        AppMethodBeat.o(64307);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    public int c(String str) {
        AppMethodBeat.i(64318);
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.o(64318);
            return 0;
        }
        int parseInt = Integer.parseInt(e.getProperty(str));
        AppMethodBeat.o(64318);
        return parseInt;
    }

    /* Access modifiers changed, original: 0000 */
    public void c(int i) {
        AppMethodBeat.i(64312);
        a("incrupdate_status", i);
        AppMethodBeat.o(64312);
    }

    /* Access modifiers changed, original: 0000 */
    public int d() {
        AppMethodBeat.i(64313);
        int b = b("incrupdate_status");
        AppMethodBeat.o(64313);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    public String d(String str) {
        AppMethodBeat.i(64319);
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            AppMethodBeat.o(64319);
            return null;
        }
        String property = e.getProperty(str);
        AppMethodBeat.o(64319);
        return property;
    }

    /* Access modifiers changed, original: 0000 */
    public void d(int i) {
        AppMethodBeat.i(64314);
        a("unlzma_status", i);
        AppMethodBeat.o(64314);
    }
}
