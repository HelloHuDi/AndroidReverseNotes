package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class w {
    private static w e = null;
    public boolean a = false;
    private Context b = null;
    private File c = null;
    private boolean d = false;
    private File f = null;

    private w(Context context) {
        AppMethodBeat.i(65309);
        this.b = context.getApplicationContext();
        b();
        AppMethodBeat.o(65309);
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = e;
        }
        return wVar;
    }

    public static synchronized w a(Context context) {
        w wVar;
        synchronized (w.class) {
            AppMethodBeat.i(65308);
            if (e == null) {
                e = new w(context);
            }
            wVar = e;
            AppMethodBeat.o(65308);
        }
        return wVar;
    }

    private File d() {
        File file;
        AppMethodBeat.i(65311);
        try {
            if (this.c == null) {
                this.c = new File(this.b.getDir("tbs", 0), "core_private");
                if (this.c == null || !this.c.isDirectory()) {
                    AppMethodBeat.o(65311);
                    return null;
                }
            }
            file = new File(this.c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        AppMethodBeat.o(65311);
        return file;
    }

    public void a(boolean z) {
        AppMethodBeat.i(65312);
        this.d = z;
        c();
        AppMethodBeat.o(65312);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A:{SYNTHETIC, Splitter:B:36:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007a A:{SYNTHETIC, Splitter:B:46:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(65310);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (this.f == null) {
                this.f = d();
            }
            if (this.f == null) {
                AppMethodBeat.o(65310);
            } else {
                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(this.f));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream3);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.a = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream3.close();
                        AppMethodBeat.o(65310);
                    } catch (Exception e) {
                        AppMethodBeat.o(65310);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream3;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(65310);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.o(65310);
            throw th;
        }
        return;
    }

    public void c() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.i(65313);
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream;
        try {
            File d = d();
            if (d == null) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream2.close();
                } catch (Exception e) {
                }
                bufferedOutputStream2 = null;
                try {
                    bufferedOutputStream2.close();
                    AppMethodBeat.o(65313);
                    return;
                } catch (Exception e2) {
                    AppMethodBeat.o(65313);
                    return;
                }
            }
            Properties properties;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(d));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(65313);
                throw th;
            }
            try {
                properties.store(bufferedOutputStream2, null);
                try {
                    bufferedInputStream.close();
                } catch (Exception e5) {
                }
                try {
                    bufferedOutputStream2.close();
                    AppMethodBeat.o(65313);
                } catch (Exception e6) {
                    AppMethodBeat.o(65313);
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream.close();
                bufferedOutputStream.close();
                AppMethodBeat.o(65313);
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedInputStream.close();
            bufferedOutputStream.close();
            AppMethodBeat.o(65313);
            throw th;
        }
    }
}
