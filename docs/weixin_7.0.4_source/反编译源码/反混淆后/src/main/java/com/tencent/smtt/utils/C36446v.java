package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* renamed from: com.tencent.smtt.utils.v */
public class C36446v {
    /* renamed from: c */
    private static C36446v f15185c = null;
    /* renamed from: a */
    private Context f15186a = null;
    /* renamed from: b */
    private File f15187b = null;
    /* renamed from: d */
    private String f15188d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    /* renamed from: e */
    private String f15189e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    /* renamed from: f */
    private String f15190f = "http://wup.imtt.qq.com:8080";
    /* renamed from: g */
    private String f15191g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    /* renamed from: h */
    private String f15192h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    /* renamed from: i */
    private String f15193i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    /* renamed from: j */
    private String f15194j = "http://mqqad.html5.qq.com/adjs";
    /* renamed from: k */
    private String f15195k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    @TargetApi(11)
    private C36446v(Context context) {
        AppMethodBeat.m2504i(65305);
        TbsLog.m80438w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f15186a = context.getApplicationContext();
        m60196g();
        AppMethodBeat.m2505o(65305);
    }

    /* renamed from: a */
    public static synchronized C36446v m60194a() {
        C36446v c36446v;
        synchronized (C36446v.class) {
            c36446v = f15185c;
        }
        return c36446v;
    }

    /* renamed from: a */
    public static synchronized C36446v m60195a(Context context) {
        C36446v c36446v;
        synchronized (C36446v.class) {
            AppMethodBeat.m2504i(65304);
            if (f15185c == null) {
                f15185c = new C36446v(context);
            }
            c36446v = f15185c;
            AppMethodBeat.m2505o(65304);
        }
        return c36446v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0118 A:{SYNTHETIC, Splitter:B:57:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0127 A:{SYNTHETIC, Splitter:B:65:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0127 A:{SYNTHETIC, Splitter:B:65:0x0127} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    private synchronized void m60196g() {
        Throwable th;
        StringWriter stringWriter;
        AppMethodBeat.m2504i(65306);
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File h = m60197h();
            if (h == null) {
                TbsLog.m80432e("TbsCommonConfig", "Config file is null, default values will be applied");
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(65306);
            } else {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(h));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.f15188d = property;
                    }
                    property = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property)) {
                        this.f15190f = property;
                    }
                    property = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property)) {
                        this.f15191g = property;
                    }
                    property = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property)) {
                        this.f15192h = property;
                    }
                    property = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property)) {
                        this.f15193i = property;
                    }
                    property = properties.getProperty("tips_url", "");
                    if (!"".equals(property)) {
                        this.f15194j = property;
                    }
                    property = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property)) {
                        this.f15195k = property;
                    }
                    String property2 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property2)) {
                        this.f15189e = property2;
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(65306);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.m2505o(65306);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
            }
            AppMethodBeat.m2505o(65306);
            throw th;
        }
    }

    /* renamed from: h */
    private File m60197h() {
        Throwable th;
        StringWriter stringWriter;
        AppMethodBeat.m2504i(65307);
        File file;
        try {
            if (this.f15187b == null) {
                this.f15187b = new File(C30950k.m49545a(this.f15186a, 5));
                if (this.f15187b == null || !this.f15187b.isDirectory()) {
                    AppMethodBeat.m2505o(65307);
                    return null;
                }
            }
            file = new File(this.f15187b, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.m80438w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.m80432e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    AppMethodBeat.m2505o(65307);
                    return file;
                }
                AppMethodBeat.m2505o(65307);
                return file;
            }
            TbsLog.m80432e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            AppMethodBeat.m2505o(65307);
            return null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.m80432e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            AppMethodBeat.m2505o(65307);
            return file;
        }
    }

    /* renamed from: b */
    public String mo57632b() {
        return this.f15188d;
    }

    /* renamed from: c */
    public String mo57633c() {
        return this.f15191g;
    }

    /* renamed from: d */
    public String mo57634d() {
        return this.f15192h;
    }

    /* renamed from: e */
    public String mo57635e() {
        return this.f15193i;
    }

    /* renamed from: f */
    public String mo57636f() {
        return this.f15189e;
    }
}
