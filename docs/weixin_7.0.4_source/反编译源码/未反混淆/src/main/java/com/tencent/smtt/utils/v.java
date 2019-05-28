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

public class v {
    private static v c = null;
    private Context a = null;
    private File b = null;
    private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String f = "http://wup.imtt.qq.com:8080";
    private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String j = "http://mqqad.html5.qq.com/adjs";
    private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    @TargetApi(11)
    private v(Context context) {
        AppMethodBeat.i(65305);
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.a = context.getApplicationContext();
        g();
        AppMethodBeat.o(65305);
    }

    public static synchronized v a() {
        v vVar;
        synchronized (v.class) {
            vVar = c;
        }
        return vVar;
    }

    public static synchronized v a(Context context) {
        v vVar;
        synchronized (v.class) {
            AppMethodBeat.i(65304);
            if (c == null) {
                c = new v(context);
            }
            vVar = c;
            AppMethodBeat.o(65304);
        }
        return vVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0118 A:{SYNTHETIC, Splitter:B:57:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0127 A:{SYNTHETIC, Splitter:B:65:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0127 A:{SYNTHETIC, Splitter:B:65:0x0127} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void g() {
        Throwable th;
        StringWriter stringWriter;
        AppMethodBeat.i(65306);
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File h = h();
            if (h == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(65306);
            } else {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(h));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.d = property;
                    }
                    property = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property)) {
                        this.f = property;
                    }
                    property = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property)) {
                        this.g = property;
                    }
                    property = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property)) {
                        this.h = property;
                    }
                    property = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property)) {
                        this.i = property;
                    }
                    property = properties.getProperty("tips_url", "");
                    if (!"".equals(property)) {
                        this.j = property;
                    }
                    property = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property)) {
                        this.k = property;
                    }
                    String property2 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property2)) {
                        this.e = property2;
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.o(65306);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.o(65306);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
            }
            AppMethodBeat.o(65306);
            throw th;
        }
    }

    private File h() {
        Throwable th;
        StringWriter stringWriter;
        AppMethodBeat.i(65307);
        File file;
        try {
            if (this.b == null) {
                this.b = new File(k.a(this.a, 5));
                if (this.b == null || !this.b.isDirectory()) {
                    AppMethodBeat.o(65307);
                    return null;
                }
            }
            file = new File(this.b, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    AppMethodBeat.o(65307);
                    return file;
                }
                AppMethodBeat.o(65307);
                return file;
            }
            TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            AppMethodBeat.o(65307);
            return null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            AppMethodBeat.o(65307);
            return file;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.e;
    }
}
