package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class o {
    static boolean a = false;
    private static o d = null;
    private static int g = 0;
    private static int h = 0;
    private static int i = 3;
    private static String k = null;
    private bi b = null;
    private bi c = null;
    private boolean e = false;
    private boolean f = false;
    private File j = null;

    private o() {
    }

    public static o a(boolean z) {
        AppMethodBeat.i(64072);
        if (d == null && z) {
            synchronized (o.class) {
                try {
                    if (d == null) {
                        d = new o();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(64072);
                    }
                }
            }
        }
        o oVar = d;
        AppMethodBeat.o(64072);
        return oVar;
    }

    static void a(int i) {
        g = i;
    }

    private void b(int i) {
        AppMethodBeat.i(64077);
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.j, "count.prop")), null);
            AppMethodBeat.o(64077);
        } catch (FileNotFoundException e) {
            AppMethodBeat.o(64077);
        } catch (IOException e2) {
            AppMethodBeat.o(64077);
        }
    }

    public static int d() {
        return g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A:{SYNTHETIC, Splitter:B:21:0x0054} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int i() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(64076);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.j, "count.prop");
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    i = Integer.valueOf(properties.getProperty(k, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.o(64076);
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.o(64076);
                    throw th;
                }
            }
            AppMethodBeat.o(64076);
        } catch (Exception e3) {
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(64076);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
            }
        }
        AppMethodBeat.o(64076);
        return i;
        AppMethodBeat.o(64076);
        return i;
    }

    public bi a() {
        return this.e ? this.b : null;
    }

    public synchronized void a(Context context, boolean z, boolean z2, am amVar) {
        AppMethodBeat.i(64073);
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(context);
        TbsLog.i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2);
        h++;
        if (amVar != null) {
            amVar.b = h == 1;
        }
        TbsCoreLoadStat.getInstance().a();
        if (amVar != null) {
            amVar.a("tbs_rename_task", (byte) 1);
        }
        an.a().b(context, h == 1);
        an.a().l(context);
        if (amVar != null) {
            amVar.a("tbs_rename_task", (byte) 2);
        }
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        if (amVar != null) {
            amVar.a("can_load_x5", (byte) 1);
        }
        boolean a = QbSdk.a(context, z, z2);
        if (amVar != null) {
            amVar.a("can_load_x5", (byte) 2);
        }
        boolean z3 = VERSION.SDK_INT >= 7;
        boolean z4 = a && z3;
        if (z4) {
            long currentTimeMillis = System.currentTimeMillis();
            z4 = an.a().e(context, d());
            TbsLog.i("SDKEngine", "isTbsCoreLegal: " + z4 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z4) {
            String str = "can_load_x5=" + a + "; is_compatible=" + z3;
            TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: ".concat(String.valueOf(str)));
            if (!(QbSdk.a && this.e)) {
                this.e = false;
                TbsCoreLoadStat.getInstance().a(context, 405, new Throwable(str));
            }
            this.j = an.t(context);
            this.f = true;
            AppMethodBeat.o(64073);
        } else if (this.e) {
            AppMethodBeat.o(64073);
        } else {
            try {
                File r;
                Context e;
                File file;
                File file2;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                    if (amVar != null) {
                        amVar.a("read_core_info", (byte) 1);
                    }
                    z4 = TbsShareManager.j(context);
                    if (amVar != null) {
                        amVar.a("read_core_info", (byte) 2);
                    }
                    if (z4) {
                        file2 = new File(TbsShareManager.c(context));
                        r = an.a().r(context);
                        e = TbsShareManager.e(context);
                        if (r == null) {
                            this.e = false;
                            QbSdk.a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                            AppMethodBeat.o(64073);
                        } else {
                            file = file2;
                        }
                    } else {
                        this.e = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                        AppMethodBeat.o(64073);
                    }
                } else {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                    file2 = an.a().r(context);
                    Object obj = (g == 25436 || g == 25437) ? 1 : null;
                    e = obj != null ? context.getApplicationContext() : context;
                    if (file2 == null) {
                        this.e = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        AppMethodBeat.o(64073);
                    } else {
                        r = file2;
                        file = file2;
                    }
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, e, file.getAbsolutePath());
                Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                TbsLog.i("SDKEngine", "SDKEngine init optDir is ".concat(String.valueOf(hostCorePathAppDefined)));
                if (this.c != null) {
                    this.b = this.c;
                    this.b.a(context, e, file.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.d, amVar);
                } else {
                    this.b = new bi(context, e, file.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.d, amVar);
                }
                this.e = true;
            } catch (Throwable th) {
                TbsLog.e("SDKEngine", "useSystemWebView by exception: ".concat(String.valueOf(th)));
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                this.e = false;
                QbSdk.a(context, "SDKEngine::useSystemWebView by exception: ".concat(String.valueOf(th)));
            }
            this.j = an.t(context);
            this.f = true;
            AppMethodBeat.o(64073);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str) {
        k = str;
    }

    public boolean b() {
        return this.e;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean b(boolean z) {
        a = z;
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public bi c() {
        return this.b;
    }

    public String e() {
        AppMethodBeat.i(64074);
        String str;
        if (this.b == null || QbSdk.a) {
            str = "system webview get nothing...";
            AppMethodBeat.o(64074);
            return str;
        }
        str = this.b.a();
        AppMethodBeat.o(64074);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean f() {
        AppMethodBeat.i(64075);
        if (a) {
            if (k == null) {
                AppMethodBeat.o(64075);
                return false;
            }
            int i = i();
            if (i == 0) {
                b(1);
            } else if (i + 1 <= i) {
                b(i + 1);
            } else {
                AppMethodBeat.o(64075);
                return false;
            }
        }
        boolean z = a;
        AppMethodBeat.o(64075);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean g() {
        return this.f;
    }

    public boolean h() {
        AppMethodBeat.i(64078);
        boolean useSoftWare = QbSdk.useSoftWare();
        AppMethodBeat.o(64078);
        return useSoftWare;
    }
}
