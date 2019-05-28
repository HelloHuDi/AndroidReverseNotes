package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* renamed from: com.tencent.smtt.utils.w */
public class C36447w {
    /* renamed from: e */
    private static C36447w f15196e = null;
    /* renamed from: a */
    public boolean f15197a = false;
    /* renamed from: b */
    private Context f15198b = null;
    /* renamed from: c */
    private File f15199c = null;
    /* renamed from: d */
    private boolean f15200d = false;
    /* renamed from: f */
    private File f15201f = null;

    private C36447w(Context context) {
        AppMethodBeat.m2504i(65309);
        this.f15198b = context.getApplicationContext();
        mo57638b();
        AppMethodBeat.m2505o(65309);
    }

    /* renamed from: a */
    public static synchronized C36447w m60203a() {
        C36447w c36447w;
        synchronized (C36447w.class) {
            c36447w = f15196e;
        }
        return c36447w;
    }

    /* renamed from: a */
    public static synchronized C36447w m60204a(Context context) {
        C36447w c36447w;
        synchronized (C36447w.class) {
            AppMethodBeat.m2504i(65308);
            if (f15196e == null) {
                f15196e = new C36447w(context);
            }
            c36447w = f15196e;
            AppMethodBeat.m2505o(65308);
        }
        return c36447w;
    }

    /* renamed from: d */
    private File m60205d() {
        File file;
        AppMethodBeat.m2504i(65311);
        try {
            if (this.f15199c == null) {
                this.f15199c = new File(this.f15198b.getDir("tbs", 0), "core_private");
                if (this.f15199c == null || !this.f15199c.isDirectory()) {
                    AppMethodBeat.m2505o(65311);
                    return null;
                }
            }
            file = new File(this.f15199c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        AppMethodBeat.m2505o(65311);
        return file;
    }

    /* renamed from: a */
    public void mo57637a(boolean z) {
        AppMethodBeat.m2504i(65312);
        this.f15200d = z;
        mo57639c();
        AppMethodBeat.m2505o(65312);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A:{SYNTHETIC, Splitter:B:36:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007a A:{SYNTHETIC, Splitter:B:46:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized void mo57638b() {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.m2504i(65310);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (this.f15201f == null) {
                this.f15201f = m60205d();
            }
            if (this.f15201f == null) {
                AppMethodBeat.m2505o(65310);
            } else {
                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(this.f15201f));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream3);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.f15197a = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream3.close();
                        AppMethodBeat.m2505o(65310);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(65310);
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
                    AppMethodBeat.m2505o(65310);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.m2505o(65310);
            throw th;
        }
        return;
    }

    /* renamed from: c */
    public void mo57639c() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.m2504i(65313);
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream;
        try {
            File d = m60205d();
            if (d == null) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream2.close();
                } catch (Exception e) {
                }
                bufferedOutputStream2 = null;
                try {
                    bufferedOutputStream2.close();
                    AppMethodBeat.m2505o(65313);
                    return;
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(65313);
                    return;
                }
            }
            Properties properties;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f15197a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f15200d));
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
                AppMethodBeat.m2505o(65313);
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
                    AppMethodBeat.m2505o(65313);
                } catch (Exception e6) {
                    AppMethodBeat.m2505o(65313);
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream.close();
                bufferedOutputStream.close();
                AppMethodBeat.m2505o(65313);
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedInputStream.close();
            bufferedOutputStream.close();
            AppMethodBeat.m2505o(65313);
            throw th;
        }
    }
}
